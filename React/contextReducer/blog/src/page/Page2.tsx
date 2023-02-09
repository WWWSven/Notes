import useGlobalContext from "../hook/useGlobalContext"
import { IUserInfo } from "../store/userInfo";

export default ()=>{
    const contextAll = useGlobalContext();
    const [store, dispatch] = useGlobalContext('userInfo');

    return <>
    {
        // console.log(contextAll)
    }
        <div>
            color:
            {contextAll.theme.store.color}
        </div>
        <div>
            name: 
            {store.name}
        </div>
        <div>
            age:
            {store.age}
        </div>
    </>
}