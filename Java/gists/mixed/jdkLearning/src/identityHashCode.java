public class identityHashCode {
    public static void main(String[] args) throws InterruptedException {
        foo f = new foo(){
            int j = 1;
            public String toString() {
                return String.valueOf(j);
            }
        };
        System.out.println(f);
        int i = System.identityHashCode(f);
        System.out.println(i);
    }
}
class foo{
    int i = 0;

    @Override
    public String toString() {
        return "foo{" +
                "i=" + i +
                '}';
    }
}