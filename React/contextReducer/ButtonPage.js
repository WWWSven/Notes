import useGlobalContext from "./useGlobalContext";
import {dispatchType as userInfoDispatchType} from "./store/userInfoStore";
import {dispatchType as themeDispatchType} from "./store/themeStore";

export default ()=>{
	const globalContext = useGlobalContext();
	const theme = globalContext.theme;
	const userInfo = globalContext.userInfo;

	return <>
		<button onClick={()=>theme.dispatch(themeDispatchType.white)}>
			theme-white
		</button>
		<button onClick={()=>theme.dispatch(themeDispatchType.black)}>
			theme-black
		</button>
		<button onClick={()=>userInfo.dispatch(userInfoDispatchType.increment)}>
			+
		</button>
		<button onClick={()=>userInfo.dispatch(userInfoDispatchType.decrement)}>
			-
		</button>
	</>
}