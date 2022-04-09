package day12;

import java.io.*;

public class onCourses {

}

class test01{
    public static void main(String[] args) throws IOException {
        try (
            FileWriter writer = new FileWriter("D:/testFileWriter.data");
            ){
            writer.write("this is a file!");
        }
    }
}
class test02{
    public static void main(String[] args) throws Exception {

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("D:/1.txt"));
                BufferedReader reader = new BufferedReader(new FileReader("D:/1.txt"));
        ){
            // BufferedWriter
            writer.write("锄禾日当午");
            writer.newLine();
            writer.write("汗滴禾下土");
            writer.newLine();
            writer.flush();
            // BufferedReader
            String line;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }
    }
}

class linkedBufferWriter{
    // 链式编程的BufferWriter
    private BufferedWriter bufferedWriter;

    public linkedBufferWriter(String path) throws IOException {
        this.bufferedWriter = new BufferedWriter(new FileWriter(path));
    }

    public linkedBufferWriter write(String s) throws IOException {
        bufferedWriter.write(s);
        bufferedWriter.flush();
        return this;
    }
    public linkedBufferWriter newLine() throws IOException {
        bufferedWriter.newLine();
        bufferedWriter.flush();
        return this;
    }
    public void finish() throws IOException {
        this.bufferedWriter.close();
    }
}
class test{
    public static void main(String[] args) throws IOException {
        linkedBufferWriter writer = new linkedBufferWriter("D:/1.txt");
        writer.write("111").write("222").newLine().write("3333").finish();
    }
}