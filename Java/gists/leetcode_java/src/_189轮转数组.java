import java.util.Arrays;

public class _189轮转数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i+k)%nums.length] = nums[i];
        }
        System.arraycopy(result,0,nums,0,result.length);
    }
}
