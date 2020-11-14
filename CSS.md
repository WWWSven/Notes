1. height：100%

   > https://www.webhek.com/post/css-100-percent-height.html

   ```html
   <div id="container">
     this is container
   </div>
   ```

   ```css
   #container{background-color: yellow;}
   /* edit you code */
   /* container 的 height 取决于父元素（html&body）的height */
   html{
     height: 100%;
   }
   body{
     /* body 的 margin 会导致滚动条出现 */
     margin: 0%;
     height: 100%;
   }
   #container{
     height: 100%;
   }
   ```

2. 居中

    > https://developer.mozilla.org/zh-CN/docs/Web/CSS/Layout_cookbook/Center_an_element

    ```html
    <div id="container">
      this is container div.
    </div>
    ```

    ```css
    html { height: 100%; }
    body { height: 100%; margin: 0%;}
    #container{
      height: 100%; /* 容器得有个高度 */
      display: flex;
      justify-content: center; /* 弹性项目沿主轴如何排布 */
      align-items: center; /* 弹性项目沿侧轴默认如何排布 */
    }
    ```

------------------

1. flex box

   

2. grid