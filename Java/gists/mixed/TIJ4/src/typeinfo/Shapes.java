//: typeinfo/Shapes.java
package typeinfo; /* Added by Eclipse.py */
import java.util.*;

abstract class Shape {
  void draw() { System.out.println(this + ".draw()"); }
  abstract public String toString();
  // 五：实现rotate，circle不旋转
  void rotate(){
   if (this instanceof Circle) return;
    System.out.println(this + "旋转！！");
  }
}

class Circle extends Shape {
  public String toString() { return "Circle"; }
}

class Square extends Shape {
  public String toString() { return "Square"; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
}

/**
 * 练习三：添加菱形 Rhomboid，向上转型为Shape，然后向下转型为 Rhomboid，试着向下转型为Circle，看看发生啥
 */
class Rhomboid extends Shape{
  public String toString(){ return "Rhomboid"; }
}


public class Shapes {
  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(
      new Circle(), new Square(), new Triangle(), new Rhomboid()
    );
    for(Shape shape : shapeList)
      shape.draw();
    // 向上转型为Shape,然后向下转型为 Rhomboid，
    System.out.println();
    Shape rhomboid = new Rhomboid();
    if (rhomboid instanceof Rhomboid){
      Rhomboid rhomboid1 = (Rhomboid) rhomboid;
      rhomboid1.draw();
    }
    rhomboid.draw();
    // 试着向下转型为Circle > 转不了
    // Circle rhomboid2 = (Circle) new Rhomboid();

    System.out.println();
    for(Shape shape : shapeList)
      shape.rotate();
  }
} /* Output:
Circle.draw()
Square.draw()
Triangle.draw()
*///:~
