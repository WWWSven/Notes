package day16.tcpUpload.v1;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket(InetAddress.getLocalHost(),8888)
        ){
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            File file = new File("D:/a.png");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
            socket.shutdownOutput();
            while ((len=inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
