export const init = {
	age: 18
};

export function reducer(state, action) {
	if (action.type === dispatchType.increment.type){
		return {
			age: state.age + 1
		}
	}else if (action.type === dispatchType.decrement.type){
		return {
			age: state.age - 1
		}
	}
	throw Error('Unknown action.');
}

export const dispatchType = {
	increment: {type: "inc"},
	decrement: {type: "dec"}
}