//: typeinfo/GenericClassReferences.java
package typeinfo; /* Added by Eclipse.py */

public class GenericClassReferences {
  public static void main(String[] args) {
    Class intClass = int.class; // 普通的类引用可以被重新赋值为指向任何其他的Class对象，
    Class<Integer> genericIntClass = int.class; // 泛型类引用只能赋值为指向其泛型声明的类型，
    genericIntClass = Integer.class; // Same thing
    intClass = double.class;
    // genericIntClass = double.class; // Illegal=不合法的，通过泛型语法，可以让编译器强制执行额外的类型检查
  }
} ///:~
