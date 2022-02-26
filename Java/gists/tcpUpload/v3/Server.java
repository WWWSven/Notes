package day16.tcpUpload.v3;

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
            // v3: 接收文件名
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String fileName = bufferedReader.readLine();
            ///~
            File upload = new File("D:/upload/");
            if (!upload.exists()) upload.mkdir();
            FileOutputStream fos = new FileOutputStream(new File(upload,fileName));
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
