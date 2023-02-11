import { useReducer } from "react";
import { GlobalContextProvider } from "./hook/useGlobalContext";
import ButtonPage from "./page/ButtonPage";
import Page1 from "./page/Page1";
import Page2 from "./page/Page2";
import { init as themeInit, reducer as themeReducer} from "./store/theme";
import { init as userInfoInit, reducer as userInfoReducer } from "./store/userInfo";
import Router from "./component/Router";
import { IRouterArr } from "./component/routerStore"
import RouterPage1 from "./page/RouterPage1";
import RouterPage2 from "./page/RouterPage2";

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


	const routerConfig: IRouterArr = [
		{
			name: "主页",
			path: "/",
			element: <RouterPage1 key={"page1"}/>,
			loader: undefined,
			action: undefined,
			errorComponent: undefined
		},
		{
			name: "文章列表",
			path: "/articles",
			element: <RouterPage2 key={"page2"}/>,
			loader: undefined,
			action: undefined,
			errorComponent: undefined,
			children: [
				{
					name: "文章详情",
					path: `/:artId`,
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
