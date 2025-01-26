import {Octokit} from "@octokit/core";


const octokit = new Octokit({
  auth: process.env.GITHUB_AUTH_TOKEN
})
const user = process.env.GITHUB_USER
const repo = process.env.GITHUB_REPO
const branch = process.env.GITHUB_BRANCH

export const requestTrees = async () => {
  return requestTreesBySha(branch!);
}

export const requestTreesBySha = async (sha: string) => {
  if (!sha) throw new Error('SHA is required'); // 抛出一个错误
  const tree = await octokit.request(`GET /repos/${user}/${repo}/git/trees/${sha}`, {
    owner: 'OWNER',
    repo: 'REPO',
    tree_sha: 'TREE_SHA',
    headers: {
      'X-GitHub-Api-Version': '2022-11-28'
    }
  })

  return tree;
}

export const requestBlobsBySha = async (sha: string) => {
  if (!sha) throw new Error('SHA is required'); // 抛出一个错误
  let blob = await octokit.request(`GET /repos/${user}/${repo}/git/blobs/${sha}`, {
    owner: 'OWNER',
    repo: 'REPO',
    file_sha: 'FILE_SHA',
    headers: {
      'X-GitHub-Api-Version': '2022-11-28'
    }
  })
  return blob;
}

export const requestContentByPath = async (path: string) => {
  if (!path) throw new Error('SHA is required'); // 抛出一个错误
  const data = await octokit.request(`GET /repos/${user}/${repo}/contents/${path}`, {
    owner: 'OWNER',
    repo: 'REPO',
    path: 'PATH',
    headers: {
      'X-GitHub-Api-Version': '2022-11-28'
    }
  })
  return data;
}
