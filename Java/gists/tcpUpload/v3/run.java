package day16.tcpUpload.v3;

public class run {
    /**
     * 测试server和client
     */
    public static void main(String[] args) {
        new Thread(Server::run).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(Client::run,"client").start();
    }
}
/*
v2: PrintStream 替代 outputStream
    BufferedReader 替代 inputStream
 */