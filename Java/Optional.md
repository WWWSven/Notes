### WHAT

npe问题普遍存在，通常手工if foo==null 做判断，Optional是更优雅的解决npe问题的方案，

null 是啥？ 在静态类型语言中以一种错误的方式对缺失变量值的建模。

Java一直试图避免让程序员意识到指针的存在，唯一的例外是：`null`指针。

其他语言中的做法， 如js的foo?.bar，java7有过这种提议，被废弃了

java的optional跟Haskell的Maybe和Scala的Option[t]相似

通常我们的做法

```java

```

现在我们使用Optional

```java

```

### HOW

使用场景



### WHY

为啥这么设计

Optional把代码中的npe做了包装，需要写代码的时候考虑那个变量是可能npe的，进而设计的时候也就知道那些变量是不会npe的， 那发生npe的时候就直面问题， 找到是数据的问题， 还是代码的问题，，，so，Optional不是为了消除npe， 只是为了让代码更加“普适”， 能够看到Optional就能知道这个是可能npe的， ，，，



最后

官方推荐的是在函数返回值的位置上使用 Optional，而不是属性，集合等位置，记住， op只是为了让可能ope的地方更明显，所以给可能有值也可能null的返回加了包装类， 也就是op

或许函数的参数也可以写op