package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.IntStream;

public class foo03 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        try (
            FileReader fileReader = new FileReader("D:\\itheima2\\day12_io\\作业\\student.txt");
        ){
            StringBuilder stringBuilder = new StringBuilder("");
            char[] chars = new char[1024 * 8];
            int read;
            while ((read=fileReader.read(chars))!=-1){
                stringBuilder.append(chars,0,read);
            }
            String[] split = stringBuilder.toString().split(",");
            ArrayList<Integer> randoms = new ArrayList<>(); // size=4
            while (randoms.size()!=split.length){
                int i = new Random().nextInt(split.length);
                if (!randoms.contains(i)) randoms.add(i);
            }
            int j = 0;
            for (int i = 0; i < split.length; i++) {
                Integer randomsIndex = randoms.get(j++);
                System.out.println("今天第"+ (i+1)+ "位同学是：" +split[randomsIndex]);
                System.out.println("回车查看下一位同学，输入over结束！");
                String next = scanner.nextLine();
                if ("over".equals(next)){
                    break;
                }
            }
        }
    }
}
