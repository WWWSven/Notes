package cgLib;
/*
cglib特点
    JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
    如果想代理没有实现接口的类，就可以使用CGLIB实现。
    CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。
    它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。
    CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
    不鼓励直接使用ASM，因为它需要你对JVM内部结构包括class文件的格式和指令集都很熟悉。
cglib与动态代理最大的区别就是
    使用动态代理的对象必须实现一个或多个接口
    使用cglib代理的对象则无需实现接口，达到代理类无侵入。
 */
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class UserDao{
    public void save() {
        System.out.println("保存数据");
    }
}
class ProxyFactory implements MethodInterceptor {
    private Object target;//维护一个目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }
    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("关闭事务");
        return null;
    }
}
class TestProxy {
    public void testCglibProxy(){
        //目标对象
        UserDao target = new UserDao();
        System.out.println(target.getClass());
        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
    }
}
class run{
    public static void main(String[] args) {
        TestProxy testProxy = new TestProxy();
        testProxy.testCglibProxy();
    }
}