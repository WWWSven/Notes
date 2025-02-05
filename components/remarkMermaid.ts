import { visit } from 'unist-util-visit';
import { LaunchOptions } from "puppeteer-core"

/**
 * https://github.com/alfonsusac/mermaid-ssr/blob/main/src/app/render/route.ts
 * https://github.com/sjwall/mdx-mermaid/blob/main/lib/src/mdxast-mermaid.ts
 */
const chrome = require("@sparticuz/chromium")
const puppeteer = require("puppeteer-core")

const renderToSvg = async (id, src, config, url) => {
  const options= {
    args: [...chrome.args, "--no-sandbox", "--disable-setuid-sandbox"],
    defaultViewport: chrome.defaultViewport,
    executablePath: await chrome.executablePath(),
    headless: chrome.headless,
    dumpio: true
  } as LaunchOptions
  console.log('option', options)
  let browser = await puppeteer.launch(options);
  try {
    let page = await browser.newPage();
    await page.goto(`data:text/html,<!DOCTYPE html><script src="${url}"></script>`);
    return await page.evaluate((diagramId, mermaidDiagram, config) => {
      window.mermaid.initialize({ startOnLoad: false, ...config });
      try {
        return window.mermaid.mermaidAPI.render(diagramId, mermaidDiagram);
      }
      catch (error) {
        return JSON.stringify(error);
      }
    }, id, src, config);
  }
  finally {
    await browser.close();
  }
};

/* istanbul ignore next */
const outputSVG = async (node, index, parent, config) => {
  const value = await renderToSvg(`mermaid-svg-${index}`, node.value, config && config.mermaid ? config.mermaid : {}, config?.svgMermaidSrc ?? 'https://cdn.jsdelivr.net/npm/mermaid@9.3.0/dist/mermaid.min.js');
  const { fromHtml } = await import('hast-util-from-html');
  const { toEstree } = await import('hast-util-to-estree');
  const { toJs, jsx } = await import('estree-util-to-js');
  const { fromMarkdown } = await import('mdast-util-from-markdown');
  const { mdxjs } = await import('micromark-extension-mdxjs');
  const { mdxFromMarkdown } = await import('mdast-util-mdx');
  const { visit } = await import('estree-util-visit');
  const hast = fromHtml(value, {
    fragment: true,
    space: 'svg'
  });
  const estree = toEstree(hast);
  visit(estree, (node, key, index, ancestors) => {
    const jsxElement = node;
    if (node.type === 'JSXElement' && jsxElement.openingElement.name.name === 'style') {
      const styleExpression = jsxElement.children[0];
      const css = styleExpression.expression.value;
      const buffer = Buffer.from(css);
      const encoded = buffer.toString('base64');
      jsxElement.children = [];
      jsxElement.openingElement.attributes.push({
        type: 'JSXAttribute',
        name: { type: 'JSXIdentifier', name: 'href' },
        value: { type: 'Literal', value: `data:text/css;base64,${encoded}` }
      }, {
        type: 'JSXAttribute',
        name: { type: 'JSXIdentifier', name: 'rel' },
        value: { type: 'Literal', value: `stylesheet` }
      }, {
        type: 'JSXAttribute',
        name: { type: 'JSXIdentifier', name: 'type' },
        value: { type: 'Literal', value: `text/css` }
      });
      jsxElement.openingElement.name.name = 'link';
      jsxElement.openingElement.selfClosing = true;
      jsxElement.closingElement = null;
      const parent = ancestors[ancestors.length - 1];
      parent.children.splice(parent.children.indexOf(node), 1);
      estree.body[0].expression.children.push(node);
    }
  });
  const js = toJs(estree, { handlers: jsx });
  const tree = fromMarkdown(js.value.substring(2, js.value.length - 5), {
    extensions: [mdxjs()],
    mdastExtensions: [mdxFromMarkdown()]
  });
  return tree.children[0].children;
};


const findInstances = (ast) => {
  const instances = [];
  visit(ast, { type: 'code', lang: 'mermaid' }, (node, index, parent) => {
    instances.push([node, index, parent]);
  });
  return instances;
};

function plugin(config) {
  return async function transformer(ast) {
    let instances = findInstances(ast);
    while (instances.length > 0) {
      const [node, index, parent] = instances[0];
      const result = await outputSVG(node, index, parent, config);
      Array.prototype.splice.apply(parent.children, [index, 1, ...result]);
      instances = findInstances(ast);
    }
    return ast;
  };
}

export { plugin as default };
