package day15;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class foo02 {
    /**
     * 2.请使用UDP方式和同桌实现聊天的功能,单线程
     */
    public static void main(String[] args) throws Exception {
        // server
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        new Thread() {
            @Override
            public void run() {
                // receive
                while (true) {
                    byte[] bytes = new byte[1024 * 8];
                    DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                    try {
                        datagramSocket.receive(datagramPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                    System.out.println(datagramPacket.getAddress() + ":// " + s);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("input: ");
                    String s1 = scanner.nextLine();
                    if ("exit".equals(s1)) break;
                    byte[] bytes1 = s1.getBytes();
                    DatagramPacket datagramPacket = null;
                    try {
                        datagramPacket = new DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("192.168.36.77"), 7777);
                        datagramSocket.send(datagramPacket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}


class serverClass{
    public void doServer(){
        Scanner scanner = new Scanner(System.in);
        try {
            DatagramSocket ds = new DatagramSocket(8888);
            while (true){
                byte[] bytes = new byte[1024 * 8];
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                ds.receive(dp);
                if (dp.getLength()!=0){
                    String s = new String(dp.getData(), dp.getOffset(), dp.getLength());
                    System.out.println("form client: "+s);
                }
                ///~~~
                System.out.print("server: ");
                byte[] message = scanner.nextLine().getBytes();
                dp.setData(message);
                ds.send(dp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class singleThreadServer{
    public static void main(String[] args) {
        serverClass serverClass = new serverClass();
        serverClass.doServer();
    }
}
class singleThreadClient{
    public static void main(String[] args) {
        clientClass clientClass = new clientClass();
        clientClass.doClient();
    }
}
class clientClass{
    public void doClient(){
        Scanner scanner = new Scanner(System.in);
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            while (true){
                datagramSocket.connect(InetAddress.getLocalHost(),8888);
                System.out.print("client: ");
                byte[] bytes = scanner.nextLine().getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                datagramSocket.send(dp);
                ///~~~
                byte[] receiveMessage = new byte[1024 * 8];
                dp = new DatagramPacket(receiveMessage, receiveMessage.length);
                datagramSocket.receive(dp);
                if (dp.getLength()!=0){
                    String string = new String(dp.getData(), dp.getOffset(), dp.getLength());
                    System.out.println("form server: "+string);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}