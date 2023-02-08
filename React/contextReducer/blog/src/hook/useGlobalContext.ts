import {createContext, Dispatch, Provider, ReducerAction, ReducerState, useContext} from "react";
import { IContext } from "../interface/IContext";
import { IContexts } from "../interface/IContexts";

const anyValue: any = {};
const GlobalContext: React.Context<any> = createContext(anyValue);
const GlobalContextProvider: Provider<any> = GlobalContext.Provider;

type hookRe = [ReducerState<any>, Dispatch<ReducerAction<any>>] | IContexts;

const useGlobalContext = (storeName?: string): any =>{
	const globalContext: IContexts = useContext(GlobalContext);
	if(storeName){
		const aContext: IContext<any> = globalContext[storeName];
		return [aContext.store, aContext.dispatch];
	}
	return globalContext;
}

// 全局包装器
export {GlobalContextProvider};

// 子组件获取context的hook
export default useGlobalContext;
