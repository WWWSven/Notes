package day09;

import java.util.Arrays;
import java.util.HashSet;

public class foo01 {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>(Arrays.asList(
                new Roommate("赵丽颖", 18),
                new Roommate("赵丽颖", 18),
                new Roommate("范冰冰", 20),
                new Roommate("范冰冰", 20),
                new Roommate("杨幂", 19),
                new Roommate("杨幂", 19)
        ));
        System.out.println(set);
    }
}
class Roommate{
    public String name;
    public int a;

    public Roommate(String name, int a) {
        this.name = name;
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roommate roommate = (Roommate) o;

        if (a != roommate.a) return false;
        return name != null ? name.equals(roommate.name) : roommate.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + a;
        return result;
    }

    @Override
    public String toString() {
        return "Roommate{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }
}