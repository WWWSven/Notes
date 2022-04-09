package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class foo01 {
    /**
     */
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>(Arrays.asList("JavaEE企业级开发指南","Oracle高级编程","MySQL从入门到精通","Java架构师之路"));
        Iterator<String> iterator = list.iterator();
        //        m1(iterator);
        //        m2(iterator);
        //        m3(iterator);
        //        m4(list);

        }

    private static void m4(Collection<String> list) {
        list.removeIf(next -> next.contains("Oracle"));
        System.out.println(list);
//        Object[] objects = list.toArray();
//        System.out.println(Arrays.toString(objects));
    }

    private static void m3(Iterator<String> iterator) {
        while (iterator.hasNext()){
            String next = iterator.next();
            char[] chars = next.toLowerCase().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='j'&&chars[i+1]=='a'&&chars[i+2]=='v'&&chars[i+3]=='a'){
                    System.out.println(next);
                }
            }
        }
    }

    private static void m2(Iterator<String> iterator) {
        System.out.println("书名小于10个字符的如下：");
        while (iterator.hasNext()){
            String s = iterator.next();
            if (s.length()<10)
                System.out.println(s);
        }
    }

    private static void m1(Iterator<String> iterator) {
        System.out.println("所有元素如下：");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
