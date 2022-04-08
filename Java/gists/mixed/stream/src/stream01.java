import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class stream01{
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().
                filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        System.out.println("-----------------------------");
        Random random = new Random();
        IntStream ints = random.ints();
        ints.limit(2).forEach(System.out::println);
        System.out.println("-----------------------------");
    }
}