package day06;


import java.util.ArrayList;
import java.util.Arrays;

class run{
    /**
     * 有如下一个字符串:”91 27 46 38 50”，请写代码实现最终输出结果。
     * 	1.定义一个字符串对象,接受如上字符串
     * 	2.把字符串中的数字数据存储到一个int类型的数组中
     * 	3.对int数组进行排序
     * 	4.把排序后的数组中的元素进行拼接得到一个字符串
     * 	5.输出字符串
     */
    public static void main(String[] args) {
        String s = "91 27 46 38 50";
        String[] sArr = s.split(" ");
        int[] intArr = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            intArr[i] = Integer.parseInt(sArr[i]);
        }
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
    }
}