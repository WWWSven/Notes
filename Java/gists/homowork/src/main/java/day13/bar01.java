package day13;

import java.util.Properties;

public class bar01 {
    /**
     * 1.现在已知下面的信息,请将信息读取出来展示(要求使用Properties完成)
     * 	name=张三
     * 	age=18
     * 	height=178
     * 	weight=90
     */
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name","张三");
        properties.setProperty("age","18");
        properties.setProperty("height","178");
        properties.setProperty("weight","90");
        properties.list(System.out);
    }
}
