import { useNavigator } from "../component/Router"

export default ()=>{
    const [goArtiles] = useNavigator('/articles')

    return <>
        this is page 1
        <br />
        <button onClick={()=>goArtiles()}>go artiles</button>
    </>
}