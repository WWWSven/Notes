public class bs {
    public static void main(String[] args) {
        int[] ar = new int[]{-1,0,3,5,9,12};
        System.out.println(search(ar, 9));
    }
    public static int search(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int middle = (left + right) / 2;
            int flag = nums[middle];
            if(target>flag) left=flag+1;
            if(target<flag) right=flag-1;
            if(target==flag) return flag;
        }
        return index;
    }
}
