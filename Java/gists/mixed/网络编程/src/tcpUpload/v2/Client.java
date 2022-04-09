package tcpUpload.v2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void run() {
        try (
            Socket socket = new Socket(InetAddress.getLocalHost(),8888)
        ){
            InputStream inputStream = socket.getInputStream();
            // v2: 使用BufferedReader替代inputStream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            OutputStream outputStream = socket.getOutputStream();
            File file = new File("D:/a.png");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
            socket.shutdownOutput();
            /* v2
            while ((len=inputStream.read(bytes))!=-1){
                Util.println(new String(bytes,0,len));
            }*/
            Util.println(bufferedReader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
