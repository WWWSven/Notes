package initBlock;


public class t01 {
    public static void main(String[] args) {
        bar b = new bar(1);
        System.out.println(b.num);
    }
    private static void fooTest() {
        foo[] fs = new foo[3];
        fs[0] = new foo();
        new foo();
        fs[1] = new foo();
        fs[2] = new foo();
        for (foo f :
                fs) {
            System.out.println(f.id);
        }
    }
}
class bar{
    public int num;
    bar(int noUse){
        System.out.println("bar construct"+noUse);
    }
}
class foo{
    public static int nextId;
    public int id;
    {
        id = nextId;
        nextId++;
    }
}
