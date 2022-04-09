package day10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class foo05 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList("王佳乐", "张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖", "王敏"));
        System.out.println(hashSet);
        // 使用Stream流的filter()方法筛选集合中所有的“张”姓学员；
        //筛选后，获取前两个，并打印。
        System.out.print("两个姓张的元素是：");
        hashSet.stream().filter(v->v.startsWith("张")).limit(2).forEach(v-> System.out.print(v+" "));
        System.out.println();
        //重新获取Stream流，用filter()方法筛选出所有的“王”姓学员；
        //筛选后，跳过第1个，打印剩余的人员。
        System.out.print("跳过第一个姓王的元素是：");
        hashSet.stream().filter(v->v.startsWith("王")).skip(1).forEach(v-> System.out.print(v+" "));

    }
}
