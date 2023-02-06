import {createContext, useContext} from "react";


const GlobalContext = createContext(null);
const GlobalContextProvider = GlobalContext.Provider;

const useGlobalContext = ()=>{
	return useContext(GlobalContext);
}
const useGlobalContextWithProp = ({storeName})=>{
	const globalContext = useContext(GlobalContext);
	return globalContext[storeName];
}
// 全局包装器
export {GlobalContextProvider};
// 子组件获取context的hook
export default useGlobalContext;
// 测试
export {useGlobalContextWithProp};
