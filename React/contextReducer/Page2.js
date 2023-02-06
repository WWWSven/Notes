import useGlobalContext from "./useGlobalContext";

export default ()=>{
	const globalContext = useGlobalContext();
	return <>
		<div>
			color:
			{globalContext.theme.store.color}
		</div>
		<div>
			user:
			{globalContext.userInfo.store.age}
		</div>
	</>
}