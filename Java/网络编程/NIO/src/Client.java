import java.io.*;
import java.net.*;

public class Client {
    public void getConnect(Integer port) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),port));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true){
            System.out.println(br.readLine());
        }
    }




    public static void main(String[] args) {

    }
}
