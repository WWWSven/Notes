//: typeinfo/ClassInitialization.java
package typeinfo; /* Added by Eclipse.py */
import java.util.*;

class Initable {
  static final int staticFinal = 47; // final静态常量
  static final int staticFinal2 =
    ClassInitialization.rand.nextInt(1000);
  static {
    System.out.println("Initializing Initable");
  }
}

class Initable2 {
  static int staticNonFinal = 147; // 非final静态常量
  static {
    System.out.println("Initializing Initable2");
  }
}

class Initable3 {
  static int staticNonFinal = 74;
  static {
    System.out.println("Initializing Initable3");
  }
}

public class ClassInitialization {
  public static Random rand = new Random(47);
  public static void main(String[] args) throws Exception {
    Class initable = Initable.class; // 懒加载，不初始化 Initable
    System.out.println("After creating Initable ref");
    // Does not trigger initialization:
    System.out.println(Initable.staticFinal); // 调用静态域的时候初始化了 Initable
    // Does trigger initialization:
    System.out.println(Initable.staticFinal2); // 先
    // Does trigger initialization:
    System.out.println(Initable2.staticNonFinal); // 先执行了静态代码块，然后打印了147
    Class initable3 = Class.forName("typeinfo.Initable3"); // forName 立即初始化了 Initable3,所以其中的静态代码块执行了
    System.out.println("After creating Initable3 ref");
    System.out.println(Initable3.staticNonFinal);
  }
} /* Output: TODO 没看懂
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*///:~
