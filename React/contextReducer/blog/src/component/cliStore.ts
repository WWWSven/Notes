import { IDispatchType } from "../interface/IDispatchType";

export interface ICLI{
    name: string
    path: string,
    element: React.Component
    loader: any,
    action: any,
    errorComponent: React.Component
}

type ICLIRouter = ICLI[];

export const init: ICLIRouter = []

export function reducer(state: ICLI, action: any ): any {
    if(action.type===actions.redirect.type){
        // todo: redirect
        window.history.pushState(null, 'title测试', 'http://172.25.171.233:3001/test/中文')
        // window.history.go()
    }
}

export const actions: IDispatchType = {
    redirect: {type: 'redirect'},
    loader: {type: 'loader', loader: ()=>{}}, // 这玩意啥时候调用 
    action: {type: 'action', action: ()=>{}}, // 这玩意啥时候调用三?
}

// todo: 路由, 切换url, 监听url变化进而渲染不同的组件, 使用history和hash模式
// https://juejin.cn/post/6886290490640039943

// todo: router的loader和action可以参考一下