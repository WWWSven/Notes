package day16.tcpUpload.v2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void run() {
        try (
            ServerSocket serverSocket = new ServerSocket(8888)
        ){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            // v2: 使用PrintStream替代outputStream
            PrintStream printStream = new PrintStream(outputStream);
            File upload = new File("D:/upload/");
            if (!upload.exists()) upload.mkdir();
            FileOutputStream fos = new FileOutputStream(new File(upload,"a.png"));
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            /* v2
            outputStream.write("upload file finished!".getBytes());
            */
            printStream.println("upload file finished!");
            socket.shutdownOutput();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
