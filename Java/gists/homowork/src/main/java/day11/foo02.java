package day11;

import java.io.File;
import java.io.IOException;

public class foo02 {
    /**
     * **要求：**
     * (相对路径,可以相对于项目也可以相对于模块)
     * 1. 判断file1是否存在？如果不存在，创建这个文件。
     * 2. 判断file2是否存在？如果不存在，创建这个目录。
     *    3. 判断file3是否存在？如果不存在，创建这个多级目录。
     */
    public static void main(String[] args) throws IOException {
        File file1 = new File("test.txt");//相对路径
        File file2 = new File("一级目录");
        File file3 = new File("目录A/目录B/目录C");
        if (!file1.exists()) file1.createNewFile();
        if (!file2.exists()) file2.mkdir();
        if (!file3.exists()) file3.mkdirs();
    }
}
