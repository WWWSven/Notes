import {GitBlob} from "@/app/api/repos/trees/route";
import {requestTreesBySha} from "@/lib/api-utils";

export async function GET(
  request: Request,
  { params }: { params: Promise<{ sha: string }> }
){
  const sha = (await params).sha

  const tree = await requestTreesBySha(sha)

  const treeBySha: GitBlob[] = tree.data.tree.filter(
    e=>
      (e.type=='blob' && e.path.endsWith('.md') && !e.path.startsWith('.'))  ||
      (e.type=='tree' && !e.path.startsWith('.'))
  )

  return Response.json(treeBySha)
}

