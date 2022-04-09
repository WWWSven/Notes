package day08;

import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class foo02 {
    /**
     * 随机生成8个不重复的10至20之间的随机数并保存Set集合中,然后打印出集合中所有的数据;
     * 使用treeSet实现
     */
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        int number = 0;
        while (set.size()!=8){
            number++;
            int nu = ThreadLocalRandom.current().nextInt(10, 21);
            System.out.printf("第%d次生成的元素是：%d\n",number,nu);
            set.add(nu);
        }
        System.out.println(set);
    }
}
