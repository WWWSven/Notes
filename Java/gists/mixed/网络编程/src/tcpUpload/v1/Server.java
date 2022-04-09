package tcpUpload.v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (
            ServerSocket serverSocket = new ServerSocket(8888)
        ){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            File upload = new File("D:/upload/");
            if (!upload.exists()) upload.mkdir();
            FileOutputStream fos = new FileOutputStream(new File(upload,"a.png"));
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=inputStream.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            outputStream.write("upload file finished!".getBytes());
            socket.shutdownOutput();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class test{
    public static void main(String[] args) throws IOException {
        File file = new File("D:/upload/");
        file.mkdir();
        System.out.println(file.exists());
    }
}