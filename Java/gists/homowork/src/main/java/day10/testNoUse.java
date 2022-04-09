package day10;


import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class shallowCopy{
    int a = 0;
}
class shallowCopyTest{
    public static void main(String[] args) {
        shallowCopy s1 = new shallowCopy();
        s1.a = 10;
        System.out.println(s1.a);
        shallowCopy s2 = s1;
        System.out.println(s2.a);
        s1.a=100;
        System.out.println(s2.a);
    }
}

class deepCopy implements Cloneable{
    int a = 0;
    public deepCopy clone() throws CloneNotSupportedException {
        return (deepCopy) super.clone();
    }
}
class deepCopyTest{
    public static void main(String[] args) throws CloneNotSupportedException {
        deepCopy deepCopy = new deepCopy();
        deepCopy.a=1;
        System.out.println(deepCopy.a);
        deepCopy clone = deepCopy.clone();
        System.out.println(clone.a);
        deepCopy.a=100;
        System.out.println(deepCopy.a);
        System.out.println(clone.a);
    }
}


class constructCopy{
    int a = 0;

    public constructCopy(int a) {
        this.a = a;
    }

    public constructCopy clone() {
        return new constructCopy(this.a);
    }
}
class constructCopyTest{
    public static void main(String[] args) {
        constructCopy constructCopy = new constructCopy(1);
        System.out.println(constructCopy.a);
        constructCopy clone = constructCopy.clone();
        constructCopy.a = 1000;
        System.out.println(constructCopy.a);
        System.out.println(clone.a);
    }
}
