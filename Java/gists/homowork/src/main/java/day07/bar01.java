package day07;

import java.util.*;

public class bar01 {
    public static void main(String[] args) {
        /**
         * 2. 键盘录入若干的数字存入集合中, 直到录入 -1 结束,完成以下需求
         *  (1)求集合中最大值
         * 	(2)求集合中元素和
         * 	(3)将集合中偶数元素变成的二倍
         * 	(4)删除集合所有奇数的元素
         * 	(注意,单独解决每一个需求)
         */
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("录入数字，-1结束：");
        int nu = scanner.nextInt();
        if (nu!=-1) list.add(nu);
        while (nu!=-1){
            System.out.println("录入数字，-1结束：");
            nu = scanner.nextInt();
            list.add(nu);
        }
        System.out.println("原始集合："+list);
        System.out.println("最大值："+getMax(list));
        System.out.println("元素和: "+getSum(list));
        fuck2(list);
        System.out.println("偶数变2倍后的集合："+list);
        fuck3(list);
        System.out.println("删除所有奇数元素后的集合:"+list);
        System.exit(0);
    }

    private static void fuck3(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i)%2) != 0){
                list.remove(i);
                i--; //!!!!!!!!!!!!!
            }
        }
    }

    private static void fuck2(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)%2==0){
                list.set(i, list.get(i)*2);
            }
        }
    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum+=integer;
        }
        return sum;
    }

    private static int getMax(ArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int max = 0;
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next>max) max=next;
        }
        return max;
    }
}
