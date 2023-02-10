import { useReducer } from "react";
import { GlobalContextProvider } from "./hook/useGlobalContext";
import ButtonPage from "./page/ButtonPage";
import Page1 from "./page/Page1";
import Page2 from "./page/Page2";
import { init as themeInit, reducer as themeReducer} from "./store/theme";
import { init as userInfoInit, reducer as userInfoReducer } from "./store/userInfo";
import Router, {useNavigator} from "./component/Router";
import { IRouterArr } from "./component/routerStore"

function App() {
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

	const [go] = useNavigator('/articles')

	const routerConfig: IRouterArr = [
		{
			name: "主页",
			path: "/",
			element: <div key={"主页"}>
				主页
				<button onClick={()=>{go()}}>文章列表</button>
			</div>,
			loader: undefined,
			action: undefined,
			errorComponent: undefined
		},
		{
			name: "文章列表",
			path: "/articles",
			element: <div key={"文章列表"}>这里是文章列表</div>,
			loader: undefined,
			action: undefined,
			errorComponent: undefined,
			children: [
				{
					name: "文章详情",
					path: `/${1}`,
					element: <Page1 key={'文章详情'}/>,
					loader: undefined,
					action: undefined,
					errorComponent: undefined
				},
				{
					name: "文章编辑",
					path: "/:artId/edit",
					element: <Page1 key={'文章编辑'}/>,
					loader: undefined,
					action: undefined,
					errorComponent: undefined
				},
			]
		}
	]


  return <GlobalContextProvider value={providerValue}>
	<Router router={routerConfig} />
  </GlobalContextProvider>
}

export default App;
