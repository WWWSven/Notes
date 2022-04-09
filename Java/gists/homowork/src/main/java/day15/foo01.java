package day15;

import java.math.BigInteger;
import java.util.concurrent.*;

public class foo01 {
    /**
     * 1.请开启两条线程, 从1开始不断的打印数字, 要求一条线程打印奇数, 一条线程打印偶数
     */
    public static void main(String[] args) {
        threadDo threadDo = new threadDo();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                10,
                1,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(6),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            poolExecutor.submit(threadDo::bar);
            poolExecutor.submit(threadDo::foo);
        }
    }
}
class threadDo{
    public static BigInteger bigInt = new BigInteger("0");
    public void foo(){
        synchronized (this){
            fooBar();
        }
    }
    public void bar(){
        synchronized (this){
            fooBar();
        }
    }
    public void fooBar(){
        bigInt = bigInt.add(new BigInteger("1"));
        int i = bigInt.intValue();
        if (i%2==0){
            System.out.println("偶数："+i);
        }else {
            System.out.println("奇数："+i);
        }
    }
}
