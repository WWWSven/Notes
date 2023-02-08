import useGlobalContext from "../hook/useGlobalContext"

export default ()=>{
    const [store, dispatch] = useGlobalContext('theme');

    return <>
        <div>
            color:
            {store.color}
        </div>
    </>
}