![image-20210407132111643](.image/image-20210407132111643.png)

- 图形化卡塔兰数的递归树
  
  - https://visualgo.net/zh/recursion
  
    ```javascript
    // n=4 -> 14
    if (n == 0) /* base case */
      return 1;
    else /* recursive case */
      return f(n-1)*2*n*(2*n-1)/(n+1)/n;
    ```
- leetcode 卡塔兰数分析
  
  -  https://leetcode-cn.com/circle/article/lWYCzv/