import { useReducer } from "react";
import CLI from "./component/CLI";
import { GlobalContextProvider } from "./hook/useGlobalContext";
import ButtonPage from "./page/ButtonPage";
import Page1 from "./page/Page1";
import Page2 from "./page/Page2";
import { init as themeInit, reducer as themeReducer} from "./store/theme";
import { init as userInfoInit, reducer as userInfoReducer } from "./store/userInfo";
import { init as cliInit, reducer as cliReducer} from "./component/cliStore";

function App() {
  	const [themeStore, themeDispatch] = useReducer(themeReducer, themeInit); // useReducer 是有三个参数的
	const [userInfoStore, userInfoDispatch] = useReducer(userInfoReducer, userInfoInit);
	const [cliStore, cliDispatch] = useReducer(cliReducer, cliInit);

	const providerValue = {
		theme: {
			store: themeStore,
			dispatch: themeDispatch
		},
		userInfo: {
			store: userInfoStore,
			dispatch: userInfoDispatch
		},
		cli: {
			store: cliStore,
			dispatch: cliDispatch
		}
	};

  return <GlobalContextProvider value={providerValue}>
    <Page1/>
	<hr />
    <Page2/>
	<hr />
	<ButtonPage/>
	<hr />
	{/* 命令输入组件, 接收命令, 命令匹配上了输出对应路由, 对不上则输出默认 */}
	<CLI />
  </GlobalContextProvider>
}

export default App;
