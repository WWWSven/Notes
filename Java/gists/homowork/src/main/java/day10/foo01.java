package day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class foo01 {
    /**
     * hashMap 实现，三种方式遍历
     */
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(101,"阿三面馆");
        hashMap.put(102,"阿四粥馆");
        hashMap.put(103,"阿五米馆");
        hashMap.put(104,"阿六快递");
        // 1
        System.out.println("==================1 entrySet(iterator&forEach)=====================");
        System.out.println("----------------------- iterator ----------------------------");
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey()+"_"+next.getValue());
        }
        System.out.println("------------------------ forEach ---------------------------");
        Set<Map.Entry<Integer, String>> entries1 = hashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries1) {
            System.out.println(entry.getKey()+"_"+entry.getValue());
        }
        // 2
        System.out.println("==================2 keySet=====================");
        Set<Integer> integers = hashMap.keySet();
        Iterator<Integer> iterator1 = integers.iterator();
        while (iterator1.hasNext()){
            Integer next = iterator1.next();
            System.out.println(next+"_"+hashMap.get(next));
        }
        // 3
        System.out.println("==================3 forEach=====================");
        hashMap.forEach((integer, s) -> System.out.println(integer+"_"+s));
    }
}
