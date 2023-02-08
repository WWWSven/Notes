import useGlobalContext from "../hook/useGlobalContext"
import { actions } from "./cliStore"

function loader(){

}

export default ()=>{
    const [store, dispatch] = useGlobalContext('cli')
    actions.loader.loader = loader;
    const loaderData = useLoaderData();

    return <>
        <input onChange={()=>{console.log('ddd')}} />
        <button onClick={()=>{dispatch(actions.redirect)}}>go</button>
    </>
}