package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
loader: 需要实例化对象，所以需要classloader
interface：这个接口是要保证代理增强得对象和被代理得对象得功能一致
h：
static Object newProxyInstance(ClassLoader loader,  //指定当前目标对象使用类加载器
    Class<?>[] interfaces,    //目标对象实现的接口的类型
    InvocationHandler h      //事件处理器
)//返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。
Object invoke(Object proxy, Method method, Object[] args) //在代理实例上处理方法调用并返回结果。
 */
interface IUserDao {
    public void save();
}

class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
class ProxyFactory {
    private Object target;// 维护一个目标对象
    public ProxyFactory(Object target) {
        this.target = target;
    }
    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    /**
                        每个方法都会调用invoke
                        可以判断method.getName()返回的方法名，找到要增强的方法。
                     */
                    System.out.println("开启事务");
                    // 执行目标对象方法
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务");
                    return null;
                }
            });
    }
}
class TestProxy {
    public void testDynamicProxy (){
        IUserDao target = new UserDao();
        System.out.println(target.getClass());  //输出目标对象信息
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());  //输出代理对象信息
        proxy.save();  //执行代理方法
    }
}
class run2{
    public static void main(String[] args) {
        TestProxy testProxy = new TestProxy();
        testProxy.testDynamicProxy();
    }
}