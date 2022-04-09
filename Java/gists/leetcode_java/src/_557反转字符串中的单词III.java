import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _557反转字符串中的单词III {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        // 输出："s'teL ekat edoCteeL tsetnoc"
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        // 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
        String[] arr = s.split(" ");
        List<String> collect = Arrays.stream(arr).map(s1 -> {
            char[] chars = s1.toCharArray();
            swap(chars);
            return String.valueOf(chars);
        }).collect(Collectors.toList());
        String res = String.join(" ", collect);
        return res;
    }
    public static void swap(char[] s){
        int low = 0;
        int hei = s.length-1;
        while (low<hei){
            s[low] = (char) (s[low]^s[hei]);
            s[hei] = (char) (s[low]^s[hei]);
            s[low] = (char) (s[hei]^s[low]);
            low++;hei--;
        }
    }
}
