package day05;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class test01 {
    public static void main(String[] args) {
        System.out.println(Math.pow(3, 5));
        System.out.println(Math.ceil(3.2));
        System.out.println(Math.floor(3.8));
        System.out.println(BigDecimal.valueOf(5.6).setScale(0, BigDecimal.ROUND_HALF_UP));
        System.out.println(Math.round(5.6));
    }
}

class test02{
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Set set = new HashSet();
        for (int i = 1; i < 10000001; i++) {
            set.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
    }
}

class test03{
    public static void main(String[] args) {
        double[] arr = {0.1,0.2,2.1,3.2,5.56,7.21};
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < arr.length; i++) {
            sum = sum.add(BigDecimal.valueOf(arr[i]));
        }
        System.out.println(sum.divide(BigDecimal.valueOf(arr.length),2,BigDecimal.ROUND_HALF_UP));
//        double sum = 0.0;
//        for (double v : arr) {
//            sum+=v;
//        }
//        System.out.println(BigDecimal.valueOf(sum/arr.length).setScale(2,BigDecimal.ROUND_HALF_UP));
    }
}

class test04{
    public static void main(String[] args) {
        System.out.print("请输入年龄和身高，中间用逗号分割：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        String age = split[0];
        String height = split[1];
        int i = Integer.parseInt(age);
        double floor = Math.floor(Float.parseFloat(height));
        System.out.println("年龄的整数" + i + ",身高小数" + floor);
//        System.out.printf("年龄的整数%d,身高小数%.2f",Integer.parseInt(age),Math.floor(Float.parseFloat(height)));
    }
}