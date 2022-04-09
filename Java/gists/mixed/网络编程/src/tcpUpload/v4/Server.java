package tcpUpload.v4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

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
            Thread.sleep(2000); // 在这里休眠两秒，方便BufferReader把信息存进缓存区，缓存会从client读入
            // 文件名和文件的一部分，导致文件缺一部分。
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String fileName = bufferedReader.readLine();
            // v4: 随机文件名, 整一个路径
            StringBuilder path = new StringBuilder("");
            int hashCode = fileName.hashCode();// int 4B 32bit
            for (int i = 0; i < 4; i++) {
                path.append(hashCode & 15);
                path.append("/");
                hashCode = hashCode>>4;
            }
            fileName = UUID.randomUUID() + "-" + fileName;
            ///~
            File upload = new File("D:/upload/",path.toString());
            if (!upload.exists()) upload.mkdirs();
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
