import remarkGfm from "remark-gfm";
import {compile, run, RunOptions} from "@mdx-js/mdx";
import * as runtime from 'react/jsx-runtime'
import rehypePrettyCode from "rehype-pretty-code";
import remarkToc from 'remark-toc'
import rehypeAutolinkHeadings from 'rehype-autolink-headings'
import rehypeSlug from 'rehype-slug'
import './page.css'
import {MdImg} from "@/components/md-img";
import mdxMermaid from 'mdx-mermaid'
import {Mermaid} from 'mdx-mermaid/lib/Mermaid'

export default async function Page({
  params,
}: {
  params: Promise<{ sha: string }>
}) {
  const sha = (await params).sha
  const res = await fetch(`${process.env.NEXT_PUBLIC_API_BASE_URL}/api/repos/blobs/${sha}`, {cache: "no-store"})
  const resJson = await res.json()
  const content = resJson.content

  const code = String(
    await compile(content, {
      outputFormat: 'function-body' ,
      remarkPlugins: [
        [remarkGfm, {singleTilde: false}],
        [remarkToc, {tight: true,}],
        [mdxMermaid, {output: 'svg', mermaid: { theme: 'dark' }, theme: { light: 'neutral', dark: 'forest' }}],
      ],
      rehypePlugins: [
        [rehypePrettyCode, {keepBackground: false}],
        [rehypeSlug],
        [rehypeAutolinkHeadings, {
          behavior: 'prepend',
          content: {
            type: 'element',
            tagName: 'span',
            properties: { class: 'icon icon-link' },
            children: [{ type: 'text', value: '' }],
          },
        },],
      ],
      remarkRehypeOptions: {
        allowDangerousHtml: false,
      },
      format: 'md',
    })
  )

  const { default: MDXContent } = await run(code, {
    ...runtime,
    baseUrl: import.meta.url,
  }as RunOptions)

  return <div className="bg-white/10 p-8 rounded-md">
    <MDXContent components={components}/>
  </div>
}


const components = {
  h1: ({ children }: { children: React.ReactNode }) => (
    <h1 style={{ color: 'red', fontSize: '2rem' }}>{children}</h1>
  ),
  img: MdImg,
  p: (props: React.HTMLAttributes<HTMLParagraphElement>) => {
    return <div {...props}>{props.children}</div>;
  },
};
