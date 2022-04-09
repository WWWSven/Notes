package day13;

public class bar02 {
    /**
     * 2.使用多线程技术实现, 一条线程不断打印播放音乐, 一条线程不断的打印显示画面. 观看现象
     *   总结多线程的使用步骤, 然后述说为何两条线程的代码会交替执行???
     */
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (true) System.out.println("播放音乐！");
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) System.out.println("显示画面！");
            }
        }.start();
        /**
         * 使用：
         *  继承Thread类，或者实现Runnable接口，重写run方法，前者使用start方法开启线程，后者将其放入Thread的构造方法，再使用start开启线程
         * 多线程如何实现的：
         *  类似cpu时间片轮转，调用start的时候会调用native的start0，开启一个栈空间给run方法，cpu再这些栈空间上轮转执行。
         */
    }
}
