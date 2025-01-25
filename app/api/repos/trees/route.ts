import {requestTrees} from "@/lib/api-utils";

export type GitBlob = {
  path: string;        // 文件路径，例如 "心理学.md"
  mode: string;        // 文件模式，例如 "100644"
  type: 'tree'|'blob';        // 类型，例如 "blob"
  sha: string;         // 文件的 SHA 哈希值
  size: number;        // 文件大小，以字节为单位
  url: string;         // 指向 GitHub API 的文件 URL
};

export async function GET() {
  const res = await requestTrees()

  const tree: GitBlob[] = res.data.tree.filter(
    e=>
      (e.type=='blob' && e.path.endsWith('.md') && !e.path.startsWith('.'))  ||
      (e.type=='tree' && !e.path.startsWith('.'))
  )
  return Response.json(tree)
}

