package day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class foo06 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("王佳乐","张三丰","王思聪","张飞","刘晓敏","张靓颖","王敏"));
        System.out.println("set集合的原始元素是："+list);
        //1:筛选出所有的“张”姓学员；
        Stream<String> 张 = list.stream().filter(v -> v.startsWith("张"));
        //2:筛选出所有的“王”姓学员；
        Stream<String> 王 = list.stream().filter(v -> v.startsWith("王"));
        //3:将两个流合并为一个流后找出名字是3个字的名字数量
        System.out.println("姓张和姓王的并且名字有三个字的人有："+Stream.concat(张, 王).filter(v -> v.length() == 3).count()+"个");
    }
}
