import { IDispatchType } from "../interface/IDispatchType";

export interface ITheme {
    color: string
}

export const init: ITheme = {
	color: 'white'
};


export function reducer(state: ITheme, action: any): ITheme {
	if (action.type === actions.white.type){
		return {
			color: 'white'
		}
	}else if (action.type === actions.black.type){
		return {
			color: 'black'
		}
	}
	throw Error('Unknown action.');
}

export const actions: IDispatchType = {
	white: {type: "white"},
	black: {type: "black"}
}