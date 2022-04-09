package day11;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class onCourse {
    public static void main(String[] args) {
        // nio
        Path a = Paths.get("directory");
        for (int i = 0; i < a.getNameCount(); i++) {
            System.out.println(a.getName(i));
        }
        System.out.println("----------------nio/oio----------------------");
        // old
        File file = new File("a");
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());

        File directory = new File("directory");
        File[] files = directory.listFiles();
        System.out.println(Arrays.toString(files));

        File file1 = new File(".");
        File[] files1 = file1.listFiles();
        System.out.println(Arrays.toString(files1));
        System.out.println("----------------nio/oio----------------------");
    }
}

class recursionCreate{
    public static void main(String[] args) throws Exception {
        String path = "D:/temp";
        File file = new File(path);
        if (file.exists()){
            // 删除前统计
            getStatus(file);
            // 递归删除
            delete(file);
        }else {
            System.out.println(file.mkdir()?"创建了temp!":"创建temp失败！");
        }
        // 创建新文件夹
        create(file, null,new ArrayList<>(Arrays.asList(".txt",".avi",".jpg",".exe")));
        // 创建后统计
        getStatus(file);

        /**
         * 创建字符输出流
         * 写数据
         * 手动释放资源 or 带资源的try
         */

        try(OutputStream outputStream = new FileOutputStream("log")) {
            outputStream.write("this is a log file!".getBytes(StandardCharsets.UTF_8));
            outputStream.write("这是一个日志文件!".getBytes(StandardCharsets.UTF_8));
            outputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
        }
    }
    public static void getStatus(File f){
        HashMap<String, Integer> map = new HashMap<>();
        status(f,map);
        System.out.println(map);
    }
    public static void status(File f, HashMap<String, Integer> map){
        File[] files = f.listFiles();
        if (files!=null){
            for (File file : files) {
                if (file.isFile()){
                    String suffixEquals0 = "没有后缀！";
                    String name = file.getName();
                    String suffix = name.substring(name.lastIndexOf('.'));
                    if (suffix.length()==0){
                        if (map.containsKey(suffixEquals0)){
                            map.put(suffixEquals0,map.get(suffixEquals0)+1);
                        }else {
                            map.put(suffixEquals0,1);
                        }
                    }else{
                        if (map.containsKey(suffix)){
                            map.put(suffix,map.get(suffix)+1);
                        }else {
                            map.put(suffix,1);
                        }
                    }
                }else {
                    status(file,map);
                }
            }
        }
    }
    public static void delete(File f){
        File[] files = f.listFiles();
        if (files!=null){
            for (File file : files) {
                if (file.isFile()){
                    if (file.delete()) System.out.println(file+"文件删除了！");
                }else {
                    delete(file);
                }
            }
        }
        boolean delete = f.delete();
        System.out.println(delete?f+"文件夹被删除了！":f+"文件夹删除失败！");
    }
    public static void create(File f, ArrayList<String> list,ArrayList<String> type) throws IOException {
        if (list==null){
            list = new Random().ints(1, 101)
                    .limit(10)
                    .mapToObj(i->String.valueOf(i))
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
            System.out.println("文件夹随机命名："+list);
        }
        // ------------------------------
        if (f!=null){
            for (int i = 0; i < list.size(); i++) {
                File file = new File(f, list.get(i));
                if (file.mkdir()) System.out.println(file+"被创建了！");
                else System.out.println(file+"创建失败了！");
                list.remove(i);
                for (int i1 = 0; i1 < list.size(); i1++) {
                    File aFile = new File(f, list.get(i1) + type.get(new Random().nextInt(type.size())));
                    boolean newFile = aFile.createNewFile();
                    if (newFile) System.out.println(aFile+"创建成功了！");
                    else System.out.println(aFile+"创建失败了！");
                }
                create(file,list,type);
            }
        }
    }
}
class foo{
    public static void main(String[] args) {

    }
}