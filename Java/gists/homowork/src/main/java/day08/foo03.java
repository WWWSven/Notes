package day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class foo03 {
    /**
     * 键盘输入3本书按照价格从低到高排序后输出,如果价格相同则按照书名的自然顺序排序;
     * 1:书以对象形式存在,包含书名和价格(int类型)两个属性;
     * 2:要求即使直接打印书对象的时候,也能看到书的名称和价格,而不是书对象的地址值;
     * 3:分别使用自然排序和比较器排序实现效果;
     */
    public static void main(String[] args) {
        Book b1 = new Book("红楼梦", 99);
        Book b2 = new Book("水浒传", 108);
        Book b3 = new Book("西游记", 280);
        ArrayList<Book> list = new ArrayList<>(Arrays.asList(b1,b2,b3,b1));
//        list.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                int result = o2.price-o1.price;
//                result = result==0 ? o1.name.compareTo(o2.name) : result;
//                return result;
//            }
//
//        });
        Collections.sort(list);
        System.out.println(list);
    }
}
class Book implements Comparable<Book>{
    public String name;
    public int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        int result = o.price - this.price;
        result = result==0?this.name.compareTo(o.name):result;
        return result;
    }
}