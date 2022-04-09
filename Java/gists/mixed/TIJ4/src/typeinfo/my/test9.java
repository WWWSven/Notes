package typeinfo.my;

import java.lang.reflect.Field;
import java.util.Arrays;

public class test9 {
    // 9 改下8 使用Class.getDeclaredFields()打印一个类中的域相关信息
    public static void Hierarchy(Object o) {
        if(o.getClass().getSuperclass() != null) {
            System.out.println(o.getClass() + " is a subclass of " +
                    o.getClass().getSuperclass());
            // ~ start
            Field[] fields = o.getClass().getDeclaredFields();
            System.out.println(Arrays.toString(fields));
            // ~ end
            try {
                Hierarchy(o.getClass().getSuperclass().newInstance());
            } catch(InstantiationException e) {
                System.out.println("Unable to instantiate obj");
            } catch(IllegalAccessException e) {
                System.out.println("Unable to access");
            }
        }
    }
    public static void main(String[] args) {
        Hierarchy(new C());
    }

}
