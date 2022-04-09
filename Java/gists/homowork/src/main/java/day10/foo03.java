package day10;

public class foo03 {
    public static int sum(int... arr){
        int result = 0;
        for (int i : arr) {
            result+=i;
        }
        return result;
    }

    public static void main(String[] args) {
        int sum = sum(1, 2, 3, 4);
        System.out.println(sum);
    }
}
