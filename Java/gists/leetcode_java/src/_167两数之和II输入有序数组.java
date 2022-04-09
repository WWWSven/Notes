import java.util.Arrays;

public class _167两数之和II输入有序数组 {
    public static void main(String[] args) {
        int[] numbers = {5,25,75};
        int target = 0; // 预期1，2
        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        for (int i=0,j=numbers.length-1;i<j;){
            int sum = numbers[i]+numbers[j];
            if (sum==target) return new int[]{i+1,j+1};
            else if (sum>target) j--;
            else i++;
        }
        return null;
    }
}
