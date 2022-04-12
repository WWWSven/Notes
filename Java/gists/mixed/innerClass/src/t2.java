class t2{
    public static void main(String[] args) {
        t t = new t();
        System.out.println(t);

        t.contain();

        // 静态成员内部类
        t.innerStatic innerStatic = new t.innerStatic();
        System.out.println(innerStatic);

        // 外部类.new
        // t.inner inner1 = new t.inner();// 不可以，需要inner是static
        t.inner inner = t.new inner();
        System.out.println(inner);
    }
}

class t{
    // 成员内部类
    class inner {
        /**
         * 非static的内部类，编译后的class文件持有外部类的引用（构造函数）
         * 所以能够无缝访问外部内的东西
         */
        @Override
        public String toString() {
            return "成员内部类";
        }
    }

    @Override
    public String toString() {
        inner inner = new inner();
        System.out.println(inner);
        return "非静态的成员内部类只能类内用";
    }

    public void contain() {
        // 局部内部类
        class innerFunc{
            @Override
            public String toString() {
                return "局部内部类";
            }
        }
        // 局部内部类只能在作用域内用
        innerFunc innerFunc = new innerFunc();
        System.out.println(innerFunc);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类：thread");
            }
        }).start();
        // 匿名内部类
        new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类： runnable");
            }
        }.run();
    }
    // 静态成员内部类
    static class innerStatic{
        /**
         * class文件不持有对外部类的引用
         * 所以哪里都能用
         */
        @Override
        public String toString() {
            return "静态成员内部类";
        }
    }
}
