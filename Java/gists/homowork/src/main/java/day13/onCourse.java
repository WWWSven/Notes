package day13;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class onCourse {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name","value");
        properties.setProperty("foo","bar"  );
        String foo = properties.getProperty("foo");
        System.out.println(foo);
        properties.setProperty("foo","barChange");
        properties.list(System.out);
        properties.store(new FileWriter("D:/spring.properties"),"this is comments");

        properties.load(new FileReader("D:/spring.properties"));
        properties.list(System.out);
    }
}
class DeadLockDemo {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程 2").start();
    }
}
class extendtsThread extends Thread{
    private static int id = 0;
    private int currentID = id;
    {
        currentID=++id;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("this is thread:"+currentID+"(ID:"+this.getId()+"),and run as "+i+"times!");
        }
    }

    public static void main(String[] args) {
        extendtsThread t1 = new extendtsThread();
        extendtsThread t2 = new extendtsThread();
        extendtsThread t3 = new extendtsThread();
        extendtsThread t4 = new extendtsThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class implementsRunnable implements Runnable{
    private static int id = 0;

    @Override
    public void run() {
        int currentID = ++id;
        for (int i = 0; i < 10; i++) {
            System.out.println("this is thread:"+ currentID +",and run as "+i+"times!");
        }
    }

    public static void main(String[] args) {
        implementsRunnable implementsRunnable = new implementsRunnable();
        Thread thread = new Thread(implementsRunnable);
        Thread thread1 = new Thread(implementsRunnable);
        thread.start();
        thread1.start();
    }
}
class noname{
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        }.start();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        };
        new Thread(runnable).start();

    }
}