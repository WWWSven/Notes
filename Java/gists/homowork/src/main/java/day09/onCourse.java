package day09;

import java.util.*;

public class onCourse {
    public static void main(String[] args) {
/*
   # treeSet
        TreeSet<Test> treeSet = new TreeSet<>(new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                int i = o1.id - o2.id;
                return -i;
            }
        });
        treeSet.add(new Test(3));
        treeSet.add(new Test(1));
        System.out.println(treeSet);
*/
//        HashSet<Character> bigSet = new HashSet<>();
//        Collections.sort(bigSet, new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return 0;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                return false;
//            }
//        });
//        for (int i = 97; i < 123; i++) {
//            bigSet.add((char) i);
//        }
//        System.out.println(bigSet);
//        System.out.println("a".hashCode());
//        System.out.println("b".hashCode());
        final HashSet<Integer> littleSet = new HashSet<Integer>();
        littleSet.add(2007111315);
        littleSet.add(2007111314);
        littleSet.add(2007111318);
        littleSet.add(2007111313);
        System.out.println(littleSet);
        System.out.println(Integer.hashCode(2007111313));
        System.out.println(Integer.hashCode(2007111314));

        System.out.println("---------------------------------");
        HashSet<Integer> littleSetTest = new HashSet<>();
        for (int i = 2007111313;i<2007111319;i++){
            littleSetTest.add(i);
        }
        System.out.println(littleSetTest);

    }
}
class Test{
    public int id;
    public Test(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                '}';
    }
}


class HashSetTest{
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();

    }
}
class Person{
    public String name;
    public int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}