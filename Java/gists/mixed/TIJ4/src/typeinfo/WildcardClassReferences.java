//: typeinfo/WildcardClassReferences.java
package typeinfo; /* Added by Eclipse.py */

public class WildcardClassReferences { // wild card = 百搭
  public static void main(String[] args) {
    Class<?> intClass = int.class; // ？表示任何事物
    intClass = double.class;
  }
} ///:~
