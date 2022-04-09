package day15;

import sun.security.x509.IPAddressName;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.*;

public class onCourse {
}

class test01{
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                1,
                TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }

        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        new ThreadPoolExecutor();
    }
}
class ip{
    public static void main(String[] args) {
        tool t = new tool();
        for (int i = 0; i < 255; i++) {
            int finalI = i;
            new Thread(()->t.scan(finalI)).start();
        }
    }
}
class tool{
    public void scan(int i){
        try {
            InetAddress byName = InetAddress.getByName("192.168.36."+i);
            String hostName = byName.getHostName();
            System.out.println(hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
class test{
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            datagramSocket.connect(InetAddress.getByName("192.168.36.70"),8888);
            byte[] bytes = "我是茄哥！".getBytes();
            while (true){
                datagramSocket.send(new DatagramPacket(bytes,bytes.length));
            }
        }catch (Exception e){

        }
    }
}