package day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class test05 {
    /**
     * 古代有个国王生日, 决定从100个死囚犯中赦免一个人,
     * 于是让100个死囚犯手拉手围城一个圈, 开始从1一直往上报数, 逢14的倍数需要枪毙, 直到剩下一个人则无罪释放
     * 	请求活着的是刚开始100人中的第(1-100)个人???
     */
    public static void main(String[] args) {
        int[] ints = IntStream.range(1, 101).toArray();
        /*
        123-123
        13-45
        3
         */
        solution05 solution05 = new solution05();
        int i = solution05.method01(ints, 0);
        System.out.println(i);
    }
}
class solution05{
    public int method01(int[] person,int start){
        if (person.length == 1) { // 剩余最后一个元素则返回它
            return person[0];
        }
        ArrayList<Integer> list = new ArrayList<>(); // 存放活下来的人
        for (int i = 0; i < person.length; i++) {
            ++start; // 叫号数++
            if (start%14!=0) {
                list.add(person[i]); // 存放活下来的人
            }else{
                System.out.println(start+":"+person[i]+"被删除了");
            }
        }
        // ArrayList 转 int[]
        int[] listArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            listArr[i] = list.get(i);
        }///~
        return method01(listArr, start); // recursion
    }
}


// -----------------------------------------------------------------
// 123456
//~1x3x5x
//~7 x 9
//~x  9
class te{
    public static void main(String[] args) {
        int[] ints = IntStream.range(1, 101).toArray();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(ints).forEach(list::add); //
        int count = 0;
        while (list.size()!=1){
            for (int i = 0; i < list.size(); i++) {
                count++;
                if (count%14==0) {
                    list.set(i,0);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)==0) list.remove(i);
            }
        }
        System.out.println(list);
    }
}