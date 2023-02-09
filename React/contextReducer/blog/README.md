### todo

##### 需要初始化数据的页面有loader

```js
const loaderData = useLoaderData()
```

##### 需要用action push数据

```js
<Form>
  <input .....
</Form>
```

##### 需要一个useNavigate, 但是可以dispatch一个action, 不实现也可以把

```js
const navigate = useNavigate()
navigate(-1)
```

##### 需要Outlet组件提供出口

##### 需要一个localstorage提供本地化能力

---

- 参考
  - https://github.com/ruanyl/reapex
