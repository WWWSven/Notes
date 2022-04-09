package day11;

import java.io.File;

public class foo04 {
    /**
     * 请使用代码计算出你电脑上的任意一个文件夹中的大小。
     * **要求：**
     * 必须是一个多层文件夹;
     * **提示**: (File中有length()方法可以获取文件的字节大小, 文件夹没有大小的概念, 所谓求文件夹大小, 是求这个文件夹下所有的文件大小总和)
     * (每个人的具体数据都不一样,以实际情况为准)
     */
    public static void main(String[] args) {
        File file = new File("D:\\多级目录");
        System.out.println(getCountSize(file));
    }
    public static Long getCountSize(File file){
        Long count = 0L;
        File[] files = file.listFiles();
        if (files!=null){
            for (File f : files) {
                if (f.isDirectory()){
                    count += getCountSize(f);
                }else {
                    count += f.length();
                }
            }
        }
        return count;
    }
}
