import { ReactElement } from "react";
import { IDispatchType } from "../interface/IDispatchType";

/**
 * 实现常规路由, 兼容cli模式
 */
export interface IRouter{
    name: string, // 路由页面的名称
    path: string, // 路由页面的路径
    element: ReactElement // 路由到的组件
    loader?: Function, // 组件的loader
    action?: Function, // 组件提交的回调
    errorComponent?: React.Component // 组件的异常页面
    children?: IRouterArr
}

export type IRouterArr = IRouter[]; // 路由数组

export const init: IRouterArr = [] // 初始化的空路由数组

let loaderData: any;
export function reducer(state: IRouter, action: any ): any {
    if(action.type===actions.redirect.type){
        // todo: redirect
        window.history.pushState(null, 'title测试', 'http://172.25.171.233:3001/test/中文')
        // window.history.go()
    }else if(action.type === actions.loader.type){
        // 加载初始化的数据
        loaderData = actions.loader.loader();
    }else if(action.type === actions.loader.type){
        // 提交数据
        action.action();
    }
}

// todo: 要拿到数据还必须先在组件加载前dispatch这个loader, 能不能自动dispatch
export const useLoaderData = (loader?: Function)=>{
    if(loader){
        return loader();
    }else{
        // 走配置文件
    }
    return 'need a loader! cofnig or function argument!';
}



export const actions: IDispatchType = {
    redirect: {type: 'redirect'},
    loader: {type: 'loader', loader: ()=>{}}, // 这玩意啥时候调用 
    action: {type: 'action', action: ()=>{}}, // 这玩意啥时候调用三?
}

// todo: 路由, 切换url, 监听url变化进而渲染不同的组件, 使用history和hash模式
// https://juejin.cn/post/6886290490640039943
