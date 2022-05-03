- 输出
  - concurrentHashMap
    - 1.7
    - 1.8
  - 从socket到servlet
  - 动态代理骚操作，优化mapper里的重复操作
    ![image-20220318100713255](../.image/image-20220318100713255.png)

- 用反射优化servlet
  - 通过uri获取方法名，用反射做servet方法的路由，一个类有一个带通配符的根路由，通过反射做方法的分发。



- Filter & Interceptor
  - filter: WEB的组件，拦截用户的所有请求.过滤器是基于函数回调(DefaultServlet)。
  - interceptor: springmvc的组件，主要用于拦截handler(处理器).拦截器是基于java的反射机制的
  - 技术栈不同：Filter 属于 Servlet技术，Interceptor属于SpringMvc技术
  - 作用不用：Filter 对所有访问进行增强，Interceptor仅对springMvc的Controller进行增强。
- WebMvcConfigurationSupport 和WebMvcConfigurer 只能出现一个，会产生冲突的。可以通过继承配置类的方式去在多个文件中去使用一个（WebMvcConfigurationSupport 或WebMvcConfigurer ）。
