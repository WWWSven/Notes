package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class foo03 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>(Arrays.asList(
                new Person("张三",22),
                new Person("李四",26),
                new Person("张翠山",38),
                new Person("赵六",19),
                new Person("张三丰",103),
                new Person("张无忌",17),
                new Person("赵敏",16)
        ));
        //找出集合中所有姓张的人并且年龄大于18岁的并全部返回,然后在main方法中输出返回的人
        findZhang(list);
        System.out.println(list);
    }
    public static void findZhang(ArrayList<Person> list){
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()){
            Person next = iterator.next();
            String name = next.name;
            int age = next.age;
            if (!name.contains("张")&&age>18){
                System.out.println(name);
                iterator.remove();
            }
        }
    }
}
class Person{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
