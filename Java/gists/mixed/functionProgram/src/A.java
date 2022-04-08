interface A{
    void method();
}
class Test{
    public static void main(String[] args){
        fun().method();
    }

    /**
     * @return 返回一个接口
     */
    public static A fun(){
        return ()-> System.out.println("hello Word");
    }
}