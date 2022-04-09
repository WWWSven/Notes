package day10;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class foo04 {
    /**
     * 随机生成10个10至20之间的随机数(数字允许重复),使用Stream流的技术,找出大于15的元素并打印出来;
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new Random().ints(10, 21)
                .limit(10)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("第%d次生成的随机数是：%d\n",i+1,list.get(i));
        }
        System.out.print("大于15的元素有：");
        list.stream().filter(integer -> integer>15).forEach(v-> System.out.print(v+" "));
    }
}
