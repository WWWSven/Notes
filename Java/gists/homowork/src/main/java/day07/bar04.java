package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class bar04 {
    /**
     * 定义集合用来装扑克牌的每一张牌, 可以使用字符串描述牌, 例如"红桃5";
     */
    public static void main(String[] args) {
        ArrayList<String> pok = getPok();
        System.out.println(pok);
        System.out.println(pok.size());
    }

    public static ArrayList<String> getPok() {
        ArrayList<String> list = new ArrayList<>();
        int[] ints = IntStream.range(1, 14).toArray();
        String[] four = {"红桃","黑桃","红心","方块"};
        for (String s : four) {
            for (int anInt : ints) {
                list.add(s+anInt);
            }
        }
        return list;
    }
}
