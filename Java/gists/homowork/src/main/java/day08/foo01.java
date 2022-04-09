package day08;


import java.util.HashSet;
import java.util.Set;

public class foo01 {
    /**
     * {2.2,5.5,6.6,2.2,8.8,1.1,2.2,8.8,5.5,2.2,6.6}
     * 去重，hashSet实现
     */
    public static void main(String[] args) {
//        System.out.println(new HashSet<>(Arrays.asList(2.2,5.5,6.6,2.2,8.8,1.1,2.2,8.8,5.5,2.2,6.6)));
        double[] arr = {2.2,5.5,6.6,2.2,8.8,1.1,2.2,8.8,5.5,2.2,6.6};
        Set<Double> set = new HashSet<>();
        for (double v : arr) {
            set.add(v);
        }
        System.out.println(set);
    }
}
