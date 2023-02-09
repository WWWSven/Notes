import React, { useEffect, useState } from "react";
import { IRouterArr } from "./routerStore";

/**
 * 路由组件
 * 
 */

type ReactNodeProps = {
    children: React.ReactNode
    router: any
};

export default (props: ReactNodeProps)=>{
    const router: IRouterArr = props.router
    let children: React.ReactNode = props.children

    const _ele: React.ReactNode = router[0].element

    const pathName = document.location.pathname // 端口后, #前, /test/%E4%B8%AD%E6%96%87
    console.log(pathName)
    const [state, setState] = useState()


    window.addEventListener('popstate', (event)=>{
        // 这一页面的状态, 在pushState的时候传的参数 = event.state (https://developer.mozilla.org/zh-CN/docs/Web/API/Window/popstate_event)
        const pathName = document.location.pathname // 端口后, #前, /test/%E4%B8%AD%E6%96%87
        console.log(pathName)
        if(pathName==='/'){
            children = _ele
        }
        alert(pathName)
        setState(state)
    })

    return <>
    {console.log('ddd')}
    {
        // React.Children.map(children, (child)=>{
        //     // do something
        //     console.log(child)
        //     return child
        // })
        
        React.Children.map(children, (child, index)=>{
            if(React.isValidElement(child)){
                const newEle = React.cloneElement(child, {...child.props, a:'1'}) // todo
                return newEle
            }else{
                return null
            }
        })
    }
    </>
}


