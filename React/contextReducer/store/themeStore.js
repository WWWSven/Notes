


export const init = {
	color: 'white'
};

export function reducer(state, action) {
	if (action.type === dispatchType.white.type){
		return {
			color: 'white'
		}
	}else if (action.type === dispatchType.black.type){
		return {
			color: 'black'
		}
	}
	throw Error('Unknown action.');
}

export const dispatchType = {
	white: {type: "white"},
	black: {type: "black"}
}