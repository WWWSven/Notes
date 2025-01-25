// https://nextjs.org/docs/app/building-your-application/routing/route-handlers
import {requestBlobsBySha} from "@/lib/api-utils";

export async function GET(
  request: Request,
  { params }: { params: Promise<{ sha: string }> }
){
  const sha = (await params).sha
  let blob = await requestBlobsBySha(sha)
  blob.data.content = base64Decode(blob.data.content)
  return Response.json(blob.data)
}

function base64Decode(base64) {
  const binString = atob(base64);
  const byteArr = Uint8Array.from(binString, (m) => m.codePointAt(0));
  return new TextDecoder().decode(byteArr);
}

