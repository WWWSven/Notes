package day11;

import java.io.File;
import java.io.IOException;

public class foo01 {
    /**
     *  请在D盘根目录下创建一个文件：test1.txt(随意录入一些内容)，再创建一个目录：测试目录
     * **要求:**
     * 1. 获取、打印file1和file2的绝对路径；
     * 2. 获取、打印file1和file2的文件名和目录名；
     * 3. 获取、打印file1和file2的文件大小；
     * 4. 分别判断file1和file2是否存在；
     * 5. 分别判断file1和file2是否是文件？是否是目录？
     */
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:/test1.text");
        fun(file1);
        System.out.println("------------------------------------------------");
        File file2 = new File("D:/directory");
        fun(file2);
    }
    public static void fun(File f) throws IOException {
        boolean touchBool = false;
        if (f.isFile()) {
            f.createNewFile();
            touchBool=true;
        }
        else if (f.isDirectory()){
            f.mkdir();
            touchBool=true;
        }
        if (touchBool) System.out.println(f+"创建成功！");
        System.out.println(f+"的绝对路径:"+f.getAbsolutePath());
        System.out.println(f+"的文件名:"+f.getName());
        System.out.println(f+"的目录名:"+f.getParent());
        System.out.println(f+"的文件大小:"+f.length()+"Byte");
        System.out.println(f+(f.exists()?"存在":"不存在"));
        System.out.println(f+(f.isDirectory()?"是文件夹":"是文件"));
    }
}
