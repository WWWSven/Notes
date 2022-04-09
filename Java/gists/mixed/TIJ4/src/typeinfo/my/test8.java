package typeinfo.my;

import typeinfo.toys.ToyTest;

public class test8 extends ToyTest {
    /*
     8 写一个接收任意对象作为参数的方法，递归打印出该对象所在继承体系中所有的类
     */
    public static void main(String[] args) {
        getObjectExtendsInfo(new test8());
    }
    public static void getObjectExtendsInfo(Object obj){
        Class<?> cc = obj.getClass();
        while (cc.getSuperclass()!=null){
            System.out.println(cc.getName()+" extends for: "+cc.getSuperclass().getName());
            cc=cc.getSuperclass();
        }
    }
}


// typeinfo/Ex8.java
// TIJ4 Chapter Typeinfo, Exercise 8, page 562
// Write a method that takes an object and recursively prints all
// the classes in that object's hierarchy.

class A {
    private String a;
}

class B extends A {
    private Integer bExtendA;
}

class C extends B {
    public String cExtendB;
}

class Ex8 {
    public static void Hierarchy(Object o) {
        if(o.getClass().getSuperclass() != null) {
            System.out.println(o.getClass() + " is a subclass of " +
                    o.getClass().getSuperclass());
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