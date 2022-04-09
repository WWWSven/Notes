package day11;

import java.io.File;

public class foo03 {
    /**
     * 请在D盘下创建一个目录“多级目录”，下面随意创建一些文件和目录。
     * ​	请编写main()方法，创建以下File对象：
     * ​		File file = new File(“D:\\多级目录”);
     * ​	**要求：**
     * ​		 遍历这个多级文件夹下的所有内容(包含子文件夹的内容)，判断每个File对象是否文件
     * ​			如果是文件，打印：【文件】+ 绝对路径
     * ​			如果是目录，打印：【目录】+ 绝对路径
     * ​	**提示**: File里面有 getAbsolutePath()可以获取文件或者文件夹的绝对路径
     */
    public static void main(String[] args) {
        File file = new File("D:\\多级目录");
        recursion(file);
    }
    public static void recursion(File file){
        File[] files = file.listFiles();
        if (files!=null){ // 确保有权限，没有权限files=null，空文件夹files的length=0
            for (File f : files) {
                if (f.isDirectory()){
                    System.out.println("【目录】"+f.getAbsolutePath());
                    recursion(f);
                }else {
                    System.out.println("【文件】"+f.getAbsolutePath());
                }
            }
        }
    }
}
