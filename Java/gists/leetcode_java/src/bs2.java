public class bs2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]>=target) return i;
        }
        return 0;
    }
}
