import { Dispatch, Reducer, ReducerAction, ReducerState } from "react";

export interface IContext<R extends Reducer<any, any>> {
	store: ReducerState<R>;
	dispatch: Dispatch<ReducerAction<R>>;
}
