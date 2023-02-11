import React, { useEffect, useState } from "react";
import { IRouter, IRouterArr } from "./routerStore";

/**
 * A Router
 */

type routerProps = {
    router: IRouterArr
}

let setNavigator: React.Dispatch<React.SetStateAction<string>>

export default (props: routerProps)=>{
    const router: IRouterArr = props.router

    // the default renders the index element of the router config obj is path like '/'
    const pathName: string = document.location.pathname // a pathName after of port before of #, like /test/%E4%B8%AD%E6%96%87
    console.log(pathName, 'a pathName when the first render')

    const [path, setPath] = useState(pathName)
    setNavigator = setPath

    let newElement: React.ReactNode = router.find((v: IRouter)=> v.path === path)?.element
    console.log(newElement)
    window.addEventListener('popstate', (event)=>{
        // about the event arguments https://developer.mozilla.org/zh-CN/docs/Web/API/Window/popstate_event
        const newpath: string = document.location.pathname // a pathName after of port before of #, like /test/%E4%B8%AD%E6%96%87
        console.log(newpath, 'a pathName on the popstate event happend')
        // get a component by pathName
        const element: React.ReactNode = router.find((v: IRouter)=> v.path === newpath)?.element
        // set new element
        newElement = element
        // rerender
        if(newpath!==path){
            setPath(newpath)
        }
    })


    // navigator传进来路由path, 根据路由path渲染路由配置的组件 
    // 1: 直接地址栏进入, 那根据地址栏渲染
    // 2: 使用export的setState函数传递路由path渲染, 

    const needRenderEle = newElement || <>Error Page</>
    return <>
    {console.log('rerendering......')}
    {
        // the / element is render by no newElement
        React.Children.map(needRenderEle, (child)=>{
            if(React.isValidElement(child)){
                const newEle = React.cloneElement(child, {...needRenderEle.props, a:'1'}) // todo
                return newEle
            }else{
                return null
            }
        })
    }
    </>
}

export const useNavigator = (path: string): Function[] =>{
    // change browers state
    const setBrower = ()=> window.history.pushState(null, '', path)
    // return exec function setNavigator to call setState
    const setNav = ()=> setNavigator(path)
    // !!! may be change state ammoment than realy rerender
    const go = ()=>{
        setBrower()
        setNav()
    }
    // 给一个可以撤回setBrower的函数
    return [go, setBrower, setNav]
}

/**
 * todos
 * children的渲染
 */