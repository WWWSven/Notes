package day12;

import java.io.*;
import java.util.Arrays;

public class foo01 {
    public static void main(String[] args) throws IOException {
        // 请使用“便捷字符流”配合数组将文件"窗里窗外"的内容打印到控制台,并统计出读文本共使用的时间;
        String s = "D:\\itheima2\\day12_io\\作业\\窗里窗外.txt";
        try(
            FileReader fileReader = new FileReader(s);
        ) {
            char[] buffer = new char[1024 * 8];
            int len;
            while ((len=fileReader.read(buffer))!=-1){
//                System.out.println(String.valueOf(buffer));
                System.out.println(new String(buffer, 0, len));
            }
        }

    }
}
