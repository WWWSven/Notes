import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _977 {
    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i: nums){
            list.add(i*i);
        }
        List<Integer> collect = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        int[] res = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            res[i] = collect.get(i);
        }
        return res;
    }
}
