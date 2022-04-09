package day18_2;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class foo {
    public static void main(String[] args) throws Exception {
        File file = new File("newstu.txt");
        Properties prop = new Properties();
        prop.load(new FileReader("Student.txt"));
        String liuF = prop.getProperty("刘方");
        if (liuF!=null){
            prop.setProperty("刘方", String.valueOf(18));
        }
        // prop.store(new FileWriter(file),"你好");
        String s = "你好asdf";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        prop.store(new FileWriter(file), new String(bytes, StandardCharsets.UTF_8));
    }
}
