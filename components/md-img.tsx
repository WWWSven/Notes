export async function MdImg({
  src, alt
}: {
  src: string; alt?: string
}) {
  const resp = await (await fetch(`http://localhost:3000/api/repos/contents/${src}`, {cache: "no-store"})).json()
  const imageBase64 = `data:image/webp;base64,${resp.content}`

  return (
    <div style={{textAlign: 'center', margin: '20px 0'}}>
      <img
        src={imageBase64}
        alt={alt}
        style={{
          maxWidth: '100%',
          height: 'auto',
          borderRadius: '8px',
          boxShadow: '0 4px 6px rgba(0, 0, 0, 0.1)',
        }}
      />
      {alt && <div style={{color: '#555', fontSize: '0.9rem'}}>{alt}</div>}
    </div>
  )
}
