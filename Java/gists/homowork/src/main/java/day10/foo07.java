package day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

public class foo07 {
/**
 * 本题综合单列集合,双列集合,键盘输入,Stream流操作
 * 1.键盘录入3个学生信息,存储到学生对象(姓名,年龄).然后添加到ArrayList集合中.
 * 2.键盘录入3个居住地信息,添加到另一个集合ArrayList;
 * 3.把两个list集合中的数据收集到同一个map集合中,键是学生对对象,值是居住地址.
 * 4.要求map集合中不能存在相同的学生信息.并按照学生年龄降序排列
 * 5.使用Stream流输出集合中所有姓张的人信息;
 */
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入第"+(i+1)+"个学生的姓名：");
            String name = scanner.next();
            System.out.println("请输入第"+(i+1)+"个学生的年龄：");
            int age = scanner.nextInt();
            list.add(new Student(name,age));
        }
        ArrayList<String> addr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入第"+(i+1)+"个学生的居住地：");
            addr.add(scanner.next());
        }
        TreeMap<Student, String> map = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.name.equals(o2.name) && (o1.age == o2.age)) return 0;
                return o1.age - o2.age;
            }
        });
        for (int i = 0; i < 3; i++) {
            map.put(list.get(i), addr.get(i));
        }
        System.out.println("输入完成的集合为："+map);
        map.entrySet().stream()
                .filter(e->e.getKey().name.startsWith("张"))
                .forEach(e-> System.out.println("学生信息："+e.getKey()+", 对应的居住地址是："+e.getValue()));
    }
}
class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}