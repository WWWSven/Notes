package day08;

import java.util.ArrayList;

public class bar01 {
    /**                 0 1 2 3 4 5 6
     * 观察如下数列找规律: 1 1 2 3 5 8 13 .... 求第20个数是多少?
     */
    public static void main(String[] args) {
//        extracted();
        int i = get(1, 1, 0);
        System.out.println(i);
    }
    public static int get(int i, int j,int step){
        step++; if (step==18) return i+j;
        return get(j,i+j,step);
    }

    private static void extracted() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        // 1,1 size = 2
        //
        for (int i = 0; i < 18; i++) {
            int foo = list.get(list.size()-1); // index=1 ---1
            int bar = list.get(list.size()-2);// index=2 ---- 1
            list.add(foo+bar); // index=3-------2
        }
        System.out.println(list.get(list.size()-1));
    }
}
