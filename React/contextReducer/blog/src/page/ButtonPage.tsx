import useGlobalContext from "../hook/useGlobalContext"
import { actions } from "../store/theme";
import { actions as userInfoActions } from "../store/userInfo";

export default ()=>{
    const [, dispatch] = useGlobalContext('theme');
    const [, userInfoDispatch] = useGlobalContext('userInfo');
    return <>
        <button onClick={()=>{dispatch(actions.black)}}>
            black
        </button>
        <button onClick={()=>{dispatch(actions.white)}}>
            white
        </button>
        <input type="text" onChange={(e)=>{
            userInfoActions.changeName.newState = "fuck";
            userInfoDispatch(userInfoActions.changeName);
        }}/>
        <button onClick={()=>{userInfoDispatch(userInfoActions.increment)}}>
            age+1
        </button>
    </>
}