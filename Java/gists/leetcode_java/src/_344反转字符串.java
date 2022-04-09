import java.util.Arrays;

public class _344反转字符串 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        // 输出：['o','l','l','e','h']
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        // 你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
        int low = 0;
        int height = s.length-1;
        while (low<height){
            swap(s,low,height);
            low++;height--;
        }
    }
    public static void swap(char[] s,int i,int j){
        char temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
}
