package day08;

import java.util.*;

public class onCourse {
    public static void main(String[] args) {
//        student<String, Integer> stu1 = new student<>("Sven",18);
//        System.out.println(stu1);
    }
}

class Student<E,L>{
    public E name;
    public L age;

    public Student(E name, L age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}

class pokRun{
    public static void main(String[] args) {
        String[] colors = {"黑桃","红心","方片","红桃"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        ArrayList<String> pok = new ArrayList<>();
        pok.add("大王");
        pok.add("小王");
        for (String color : colors) {
            for (String number : numbers) {
                pok.add(color+number);
            }
        }
        Collections.shuffle(pok);
        ArrayList<String> foo = new ArrayList<>();
        ArrayList<String> bar = new ArrayList<>();
        ArrayList<String> foobar = new ArrayList<>();
        ArrayList<String> threePok = new ArrayList<>();
        for (int i = 0; i < pok.size(); i++) {
            String s = pok.get(i);
            if (i>50){
                threePok.add(s);
            }else {
                if (i%3==0){
                    foo.add(s);
                }
                if (i%3==1){
                    bar.add(s);
                }
                if (i%3==2){
                    foobar.add(s);
                }
            }
        }
        System.out.println(threePok);
        System.out.println(foo);
        System.out.println(bar);
        System.out.println(foobar);
    }
}


class student implements Comparable<student>{
    public String name;
    public int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(student o) {
        return this.age-o.age;
    }
}
class studentRun{
    public static void main(String[] args) {
        student a = new student("a",12);
        student a2 = new student("a",12);
        student b = new student("b", 14);
        TreeSet<student> set = new TreeSet<>();
        set.add(a);
        set.add(a2);
        set.add(b);
        System.out.println(set);
    }
}
