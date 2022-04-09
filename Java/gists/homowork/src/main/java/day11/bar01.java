package day11;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class bar01 {
    /**
     * 1.编写代码实现删除文件夹
     * 2.编写代码实现拷贝单个文件
     * 3.编写代码实现对文件的加密和解密
     */
    public static void main(String[] args) throws IOException {
        System.out.println(
                copyOneFile("D:/infoCopy.txt", "D:/infoCopyTO.txt")?"拷贝单个文件成功":"拷贝单个文件失败");

        System.out.println(
                deleteDirectory("D:/多级目录 - 副本")?"删除文件夹成功！":"删除文件夹失败！");


        String salt = "sven's salt";
        System.out.println(
                encrypt("D:/czh.jpg", "D:/encrypt.txt", salt) ?"加密成功":"加密失败");
        System.out.println(
                encrypt("D:/encrypt.txt", "D:/encryptDecode.jpg", salt)?"解密成功":"解密失败");

    }
    public static boolean copyOneFile(String sourceStr, String toStr) throws IOException {
        File source = new File(sourceStr);
        File to = new File(toStr);
        if (!source.exists()) return false;
        int availableCopy;
        int writeCount = 0;
        try (FileInputStream inputStream = new FileInputStream(source);
             FileOutputStream outputStream = new FileOutputStream(to)){ // outputSteam用的File的createNewFile去新建文件
            availableCopy = inputStream.available();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer))!=-1){
                writeCount+=len;
                outputStream.write(buffer,0,len);
            }
        }
        return writeCount == availableCopy;
    }
    public static boolean deleteDirectory(String directoryStr){
        File directory = new File(directoryStr);
        boolean re = true;
        File[] files = directory.listFiles();
        if (files!=null){
            for (File file : files) {
                if (file.isDirectory()){
                    deleteDirectory(file.getAbsolutePath());
                }else{
                    if (!file.delete()) re=false;
                }
            }
        }
        if (!directory.delete()) re=false;
        return re;
    }
    public static boolean encrypt(String formStr, String toStr, String salt) throws IOException {
        File form = new File(formStr);
        File to = new File(toStr);
        if (!form.exists()) return false;
        byte[] bytes = salt.getBytes();
        if (bytes.length< 3) return false;
        int key = bytes[0]*bytes[1]-bytes[2];// 加密的key
        try (
            FileInputStream inputStream = new FileInputStream(form);
            FileOutputStream outputStream = new FileOutputStream(to)
        ){
            byte[] buffer = new byte[1024];
            int len;
            while ((len=inputStream.read(buffer))!=-1){
                for (int i = 0; i < buffer.length; i++) { // 加密
                    buffer[i] = (byte) (buffer[i]^key);
                }
                outputStream.write(buffer,0,len);
            }
        }
        return true;
    }
}
