package day06;

import java.util.ArrayList;
import java.util.Arrays;

public class quickSort {
    /**
     * 自动手动完成选择排序
     * 	自动手动完成快速排序
     */
    public static void main(String[] args) {
        int[] arr = {34,12,2,100};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr, int low, int high){
        // 左边第一个元素是枢轴元素
        // 左指针向右找到一个大于枢轴的元素，右指针向左找到一个小于竖轴的元素，两个指针找到后交换元素。
        // 左指针 大于，等于 右指针 停止
        if (low>high) return;
        int base = arr[low];
        int l = low;
        int r = high;
        while (l<r){
            while (base<=arr[r] && l<r) r--;
            while (base>=arr[l] && l<r) l++;
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
        }
        arr[low] = arr[l];
        arr[l] = base;
        sort(arr, low, l-1);
        sort(arr, l+1, high);
    }
}
