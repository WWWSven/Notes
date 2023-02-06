import useGlobalContext from "./useGlobalContext";
import {useGlobalContextWithProp} from "./useGlobalContext";

export default ()=>{
	const globalContext = useGlobalContext();
	const theme = useGlobalContextWithProp({storeName: 'theme'});
	return <>
		<div>
			color:
			{globalContext.theme.store.color}
		</div>
		<div>
			test:
			{theme.store.color}
		</div>
	</>
}