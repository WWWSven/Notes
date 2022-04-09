import java.util.Arrays;

public class _283移动零 {
    public static void main(String[] args) {
        // int[] nums = {0,1,0,3,12};
        int[] nums = {2,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                // 如果不是0，前移，直到前一个也不是0,
                int j = i;
                while ( j>0 && nums[j - 1] == 0){
                    j--;
                }
                nums[j] = nums[i];
                if (j!=i) nums[i]=0;
            }
        }
    }
}
