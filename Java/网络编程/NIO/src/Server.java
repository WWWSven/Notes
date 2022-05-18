import com.sun.xml.internal.ws.wsdl.writer.document.PortType;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class Server {
    private static final Integer PORT = 8879;
    private static final Map<Integer, BufferedWriter> clients = null;

    public void addClient(Socket client) throws IOException {
        clients.put(client.getPort(),new BufferedWriter(new OutputStreamWriter(client.getOutputStream())));
    }

    public void forwardClients(Integer port,String msg) throws IOException {
        Set<Map.Entry<Integer, BufferedWriter>> entries = clients.entrySet();
        for (Map.Entry<Integer, BufferedWriter> client : entries) {
            if (client.getKey()==port) continue;
            client.getValue().write(msg);
        }
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket client = serverSocket.accept();
        addClient(client);
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String msg = br.readLine();
        forwardClients(client.getPort(),msg);
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
