package typeinfo.my;

public class test10 {
    /* https://github.com/kinggggg/thinking_in_java_answer/blob/master/TypeInfo/Ex10(3).java
    判断char数组究竟是一个基本类型，还是一个对象
     */
    // ?? 好吧，，
}

// typeinfo/Ex10.java
// TIJ4 Chapter Typeinfo, Exercise 10, page 562
// Write a program to determine whether an array of char is a primitive type
// or a true Object.

class Ex10 {
    public static void main(String[] args) {
        char[] c = new char[10];
        // c is an Object:
        System.out.println("Superclass of char[] c: " +
                c.getClass().getSuperclass());
        System.out.println("char[] c instanceof Object: " +
                (c instanceof Object));
    }
}
