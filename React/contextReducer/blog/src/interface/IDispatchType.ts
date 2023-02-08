export interface IType{
    type: string,
    newState?: any, // 更新状态的时候用的
    loader?: any, // 加载页面的时候用的
    action?: any, // 页面提交的时候用的
}
export interface IDispatchType{
    [key: string]: IType
}