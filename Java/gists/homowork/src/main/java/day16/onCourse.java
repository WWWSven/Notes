package day16;

import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class onCourse {
}

class client{
    public static void main(String[] args) {
        try {
            for (;;){
                MulticastSocket multicastSocket = new MulticastSocket(8888);
                multicastSocket.joinGroup(InetAddress.getByName("224.0.1.100"));
                byte[] bytes = new byte[1024 * 8];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                multicastSocket.receive(datagramPacket);
                String message = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class server{
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(100);
//        for (int i = 0; i < 100; i++) {
//            service.submit(()->extracted());
//        }
        extracted();
    }

    private static void extracted() {
        try {
            while (true){
                Thread.sleep(2000);
                DatagramSocket datagramSocket = new DatagramSocket();
                String s = "java.lang.ArithmeticException: / by zero\n" +
                        "\tat day16.server.main(onCourse.java:30)";
                byte[] bytes = s.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
                        InetAddress.getByName("255.255.255.255"),8888);
                datagramSocket.send(datagramPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class foo{
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            byte[] bytes = new byte[1024 * 8];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            socket.receive(dp);
            System.out.println(new String(dp.getData(),dp.getOffset(),dp.getLength()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class tcpClient{
    public static void main(String[] args) {
        try (
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        ){
//            Socket socket = new Socket(InetAddress.getByName("192.168.36.70"), 9000);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            ///~~~
            outputStream.write("我是黎姿！".getBytes());
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
class tcpServer{
    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(8888)
        ){
            Socket accept = serverSocket.accept();
            OutputStream outputStream = accept.getOutputStream();
            InputStream inputStream = accept.getInputStream();
            ///~~~
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
                outputStream.write("黎姿尼玛".getBytes());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class scan{
    public static void main(String[] args) {
        try {
            String myHost = Inet4Address.getLocalHost().getHostAddress();// 192.168.43.56
            String subHost = myHost.substring(0, myHost.lastIndexOf('.') + 1);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


class copySocketService{
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept(); // block 1
            InputStream iStream = socket.getInputStream();
            OutputStream oStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(oStream);
            FileOutputStream fos = new FileOutputStream("d:/copyTo.txt");
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=iStream.read(bytes))!=-1){ // block 2
                fos.write(bytes,0,len);
            }
            printStream.println("ok!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class copySocketClient{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            InputStream iStream = socket.getInputStream();
            OutputStream oStream = socket.getOutputStream();
            FileInputStream fis = new FileInputStream("d:/copyFrom.txt");
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=fis.read(bytes))!=-1){
                 oStream.write(bytes,0,len);
            }
            socket.shutdownOutput(); // 释放结束信号，打破server的read block
            while ((len=iStream.read(bytes))!=-1){ // block
                System.out.println(new String(bytes,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class upload{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.36.70", 9999);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream("D:/a.txt");
        PrintStream printStream = new PrintStream(outputStream);
        printStream.print("a.txt");
        byte[] bytes = new byte[1024 * 8];
        int len;
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream,"utf-8")
        );
        System.out.println(bufferedReader.readLine());

    }
}


