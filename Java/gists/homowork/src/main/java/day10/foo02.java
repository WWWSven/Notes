package day10;

import java.util.*;

public class foo02 {
    /**
     * TreeMap 实现
     * 以劳模对象为键,家庭住址为值,并按照劳模的年龄从大到小排序后输出;
     */
    public static void main(String[] args) {
        TreeMap<work, String> treeMap = new TreeMap<>();
        work 张三 = new work(18, "张三");
        treeMap.put(张三,"北京");
        work 李四 = new work(20, "李四");
        treeMap.put(李四,"上海");
        treeMap.put(new work(35,"王五"),"天津");
        treeMap.put(new work(21,"赵六"),"北京");
        treeMap.put(new work(19,"田七"),"上海");
        System.out.println("-------------原集合-------------");
        treeMap.keySet().forEach(System.out::println);
        System.out.println("-------------删除张三后的集合-------------");
        treeMap.remove(张三);
        treeMap.keySet().forEach(System.out::println);
        System.out.println("-------------修改李四的家庭住址为郑州-------------");
        treeMap.put(李四,"郑州");
        treeMap.entrySet().forEach(System.out::println);
        System.out.println("-------------遍历集合方式1-------------");
        treeMap.entrySet().forEach(System.out::println);
        System.out.println("-------------遍历集合方式2-------------");
        Set<Map.Entry<work, String>> entries = treeMap.entrySet();
        Iterator<Map.Entry<work, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<work, String> next = iterator.next();
            System.out.println(next.getKey()+"="+next.getValue());
        }
    }
}
class work implements Comparable<work>{
    public int age;
    public String name;

    public work(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age+"的"+name;
    }

    @Override
    public int compareTo(work o) {
        return this.age-o.age;
    }
}
