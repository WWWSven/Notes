package day11;

import java.io.*;
import java.util.Scanner;

public class foo05 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = "D:/info.txt";
        try (FileOutputStream stream = new FileOutputStream(path)){
            while (true){
                System.out.print("输入学生信息（姓名-年龄）,输入exit退出：");
                String info = scanner.nextLine();
                if ("exit".equals(info)){
                    break;
                }
                stream.write((info+",").getBytes());
            }
        }
        try (FileInputStream stream = new FileInputStream(path)){
            StringBuilder builder = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(stream);
            while (reader.ready()){
                builder.append((char) reader.read());
            }
            System.out.println(builder);
        }
    }
}
