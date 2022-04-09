package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class bar03 {
    /**
     * 随机生成10个不重复的数组放入集合, 实现奇数放左边,偶数放右边
     */
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(getRandomArr());
        }
        System.out.println("原始数组：");
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(exec(list.get(i)));
        }
        System.out.println("实现奇数放左边,偶数放右边后的集合：");
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[] exec(int[] arr) {
        int low = 0;
        int height = arr.length-1;
        int[] arrTemp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0){
                arrTemp[height]= arr[i];
                height--;
            }else {
                arrTemp[low]= arr[i];
                low++;
            }
        }
        return arrTemp;
    }

    public static int[] getRandomArr(){
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(100); i++) {
            list.add(random.nextInt(100));
        }
        int[] intArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intArr[i] = list.get(i);
        }
        return intArr;
    }
}
