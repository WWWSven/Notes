package day13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class foo01{
    /**
     * 请使用继承Thread类的方式定义一个线程类，
     * 在run()方法中循环10次，每1秒循环1次，每次循环按“yyyy-MM-dd HH:mm:ss”的格式打印当前系统时间。
     * 使用匿名内部类配合SimpleDateFormat和Date实现
     */
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    String format = simpleDateFormat.format(new Date());
                    System.out.println(format);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

