package day07;

import java.util.ArrayList;
import java.util.Arrays;

public class bar02 {
    /**
     * 键盘录入若干的字符串存入集合中,直到录入"over"结束, 请完成以下需求
     * 	(1)将集合中所有元素变成大写
     * 	(2)将集合以"张"开头的元素打印出来
     * 	(3)将元素所有"A"变成"B",最后展示数据元素
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("张无极","张二狗","aaa","AB"));
        System.out.println("原始数据："+list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i,list.get(i).toUpperCase());
        }
        System.out.println("变大写："+list);
        System.out.println("打印所有张姓人：");
        for (String s : list) {
            if (s.contains("张")) System.out.println(s);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("A")) list.set(i, list.get(i).replace("A","B"));
        }
        System.out.println("A变B："+list);
    }
}
