import { IDispatchType } from "../interface/IDispatchType"

export interface IUserInfo{
    name: string,
    age: number
}

export const init: IUserInfo = {
    name: "foo",
    age: 0
} 

export function reducer(state: IUserInfo, action: any): IUserInfo {
    const type = action.type
    if(type === actions.increment.type){
        return {
            ...state,
            age: state.age+1,
        }
    }else if(type === actions.decrement.type){
        return {
            ...state,
            age: state.age-1,
        }
    }else if(type === actions.changeName.type){
        return {
            ...state,
            name: action.newState,
        }
    }
    throw Error('Unknown action.');
}

export const actions: IDispatchType = {
    increment: {type: 'increment'},
    decrement: {type: 'decrement'},
    changeName: {type: 'changeName', newState: null},
}