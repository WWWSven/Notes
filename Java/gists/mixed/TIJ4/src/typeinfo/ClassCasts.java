//: typeinfo/ClassCasts.java
package typeinfo; /* Added by Eclipse.py */

class Building {}
class House extends Building {}

public class ClassCasts {
  public static void main(String[] args) {
    Building b = new House();
    Class<House> houseType = House.class; // 先获得一个House类型的Class
    House h = houseType.cast(b); // 用 cast 把 Building 类型赋值给 House 类型，
    h = (House)b; // ... or just do this.，，跟上边作用一样，但更简介
    /*
    无法使用普通转型的情况下，持有Class引用进行转型是可行的，如com.sun.mirror.util.DeclarationFilter
     */
  }
} ///:~
