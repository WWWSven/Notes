package day06;

import java.util.Arrays;

public class test06 {
    /**
     * 自己手动完成二分查找功能
     * 	自己手动完成冒泡排序
     */
    public static void main(String[] args) {
        int[] arr = {34,12,2,100};
        System.out.println("原始："+Arrays.toString(arr));
        popSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------------------------");
        System.out.println(binarySearch(arr, 34));
    }
    public static int binarySearch(int[] arr,int target){
        int low = 0;
        int height = arr.length-1;
        while (low<=height){
            int mid = (low+height)/2;
            if (arr[mid]>target){
                height=mid-1;
            }else if (arr[mid]<target){
                low=mid+1;
            }else return mid;
        }
        return -1;
    }

    public static void popSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
