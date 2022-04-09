package day17;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

// 完成课堂上MathUtil的案例
public class foo02 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        String doIt = "add";
        try {
            Class aClass = Class.forName("day17.mathUtil");
            Constructor constructor = aClass.getDeclaredConstructor();
            mathUtil o = (mathUtil) constructor.newInstance();
            Method method = aClass.getMethod(doIt, int.class, int.class);
            Object reValue = method.invoke(o, a, b);
            System.out.println(reValue);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class mathUtil{
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int multiplication(int a, int b){
        return a*b;
    }
    public int division(int a, int b){
        return a/b;
    }
}

