package day07;

import java.util.ArrayList;
import java.util.Arrays;

public class foo02 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>(Arrays.asList(88.5,39.2,77.1,56.8,89.0,99.0,59.5));
        System.out.println("使用增强for遍历所有元素，并打印");
        for (Double aDouble : list) {
            System.out.println(aDouble);
        }
        System.out.println("使用增强for遍历所有元素，打印不及格的分数");
        for (Double aDouble : list) {
            if (aDouble<60) System.out.println(aDouble);
        }
        System.out.println("使用增强for遍历所有元素，计算不及格的分数的数量，和平均分，并打印计算结果");
        Double countPeople = 0.0;
        Double countScore = 0.0;
        for (Double aDouble : list) {
            if (aDouble<60) {
                countPeople++;
                countScore+=aDouble;
            }
        }
        countScore=countScore/countPeople;
        System.out.println("不及格学生人数:"+countPeople+",不及格学生平均分："+countScore);
        System.out.println("使用增强for遍历所有元素，求出最高分，并打印");
        Double result = 0.0;
        for (Double aDouble : list) {
            if (aDouble>result) result=aDouble;
        }
        System.out.println("集合中最高分："+result);
    }
}
