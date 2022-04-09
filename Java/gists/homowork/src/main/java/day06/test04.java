package day06;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test04 {
    /**
     * 随机生成10个1-100之间的随机数存入ArrayList集合中.
     * 	1.将集合中重复的元素去除
     * 	2.将集合的元素按照从小到大的顺序排序(提示: 可以使用冒泡排序)
     */
    public static void main(String[] args) {
        solution solution = new solution();
//        solution.method01();
//        solution.method02();
        solution.method03();
    }
}
class solution{
    public void method01(){
        ThreadLocalRandom current = ThreadLocalRandom.current();
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            li.add(current.nextInt(1, 101));
        }
        li.addAll(li); // 模拟重复元素
        System.out.println("原始："+li);
        List<Integer> li2 = li.stream().distinct().collect(Collectors.toList());
        System.out.println("去重后："+li2);
        li2.sort(Comparator.naturalOrder());
        System.out.println("排序后："+li2);
    }
    public void method02(){
        Random random = new Random();
        IntStream limit = random.ints(1, 101).limit(10); // 生成10个随机数
        ArrayList<Integer> li = new ArrayList<>();
        limit.forEach((value -> li.add(value))); // 填进list
        li.addAll(li); // 模拟重复
        System.out.println("原始："+li);
        List<Integer> li2 = li.stream().distinct().collect(Collectors.toList()); // 去重
        System.out.println("去重后："+li2);
        li2.sort(Comparator.naturalOrder());
        System.out.println("排序后："+li2);
    }
    public void method03(){
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(99) + 1);
        }
        list.addAll(list); // 模拟重复
        System.out.println("原始："+list);
        ArrayList<Integer> list2 = new ArrayList<>();
        for (Integer integer : list) { // 去重
            if (!list2.contains(integer)) list2.add(integer);
        }
        System.out.println("去重后："+list2);
        for (int i = 0; i < list2.size()-1; i++) {
            for (int j = 0; j < list2.size()-1-i; j++) {
                if (list2.get(j)>list2.get(j+1)){
                    int temp = list2.get(j+1);
                    list2.set(j+1,list2.get(j));
                    list2.set(j,temp);
                }
            }
        }
        System.out.println("排序后："+list2);
    }
}


