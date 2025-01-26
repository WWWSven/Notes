import {requestContentByPath} from "@/lib/api-utils";

export async function GET(
  request: Request,
  { params }: { params: Promise<{ path: string[] }> }
){
  const path = (await params).path.join('/')
  const response = await requestContentByPath(path)
  return Response.json(response.data)
}
