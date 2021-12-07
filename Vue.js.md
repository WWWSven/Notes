#### [【2021年5月更新】Vue3+TypeScript从入门到实战全系列教程](https://www.bilibili.com/video/BV1gf4y1W783?from=search&seid=7092774578790706426&spm_id_from=333.337.0.0)

##### P1:

- Vue + TS 历史变革
  <img src=".image/image-20211207114356429.png" alt="image-20211207114356429" style="zoom: 67%;" />

- vite 还是 webpack
  - vite 用 es6 = 快；
  - 不考虑浏览器兼容 直接上vite，webpack 对浏览器版本兼容好；
  - 其实 vite 跟 webpack 提供的功能也不非常一致；
  - 故，，，能跑就行；



#### [【阿里P7大神强推】2021前端 TypeScript 快速上手,从入门到精通全集](https://www.bilibili.com/video/BV1784y1c7V9?p=2&spm_id_from=pageDriver)

- 强类型 pk 弱类型（各种隐式类型转换），静态类型 pk 动态类型（没有语言层面的类型检查），js的类型问题（弱类型+动态类型）；
- flow方案（code阶段做静态类型检查的工具）或者用 bable套装；
- flow 的 mixed & any
  **相同**：mixed 跟 any 都接收任意类型
  **不同**：mixed 还是强类型，要使用传统 typeof 进行类型判断后flow才不会报错；any相当于没用 flow 的原始 js 的弱类型，并且不会被flow报错，any 的存在可以用来兼容以前的老代码；
  <img src=".image/image-20211207203108923.png" alt="image-20211207203108923" style="zoom:50%;" />
- up主推荐的第三方类型手册：https://www.saltycrane.com/cheat-sheets/flow-type/latest/
- 