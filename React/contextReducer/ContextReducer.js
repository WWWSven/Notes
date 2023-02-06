import {GlobalContextProvider} from "./useGlobalContext";
import {useReducer} from "react";
import Page1 from "./Page1";
import {init as themeInit, reducer as themeReducer} from "./store/themeStore";
import {init as userInfoInit, reducer as userInfoReducer} from "./store/userInfoStore";
import Page2 from "./Page2";
import ButtonPage from "./ButtonPage";

export default ()=>{
	const [themeStore, themeDispatch] = useReducer(themeReducer, themeInit); // useReducer 是有三个参数的
	const [userInfoStore, userInfoDispatch] = useReducer(userInfoReducer, userInfoInit);

	const providerValue = {
		theme: {
			store: themeStore,
			dispatch: themeDispatch
		},
		userInfo: {
			store: userInfoStore,
			dispatch: userInfoDispatch
		}
	};

	return <GlobalContextProvider value={providerValue}>
		<Page1/>
		<hr/>
		<Page2/>
		<hr/>
		<ButtonPage/>
	</GlobalContextProvider>
}