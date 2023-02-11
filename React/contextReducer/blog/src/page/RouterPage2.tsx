import { useNavigator } from "../component/Router"

export default ()=>{
    const [backToHome] = useNavigator('/')
    const [toEdit] = useNavigator('/articles/123/edit')
    return <>
        <div style={{color: 'red'}}>
            this is page 2
        </div>
        <br />
        <button onClick={()=>backToHome()}>
            backToHome
        </button>
        <hr />
        <button onClick={()=>toEdit()}>
            edit article
        </button>
    </>
}