package day09;

import java.util.Arrays;
import java.util.List;

public class bar03 {
    public static void main(String[] args) {
        MyCollections<String> myCollections = new MyCollections<>();

        List<String> strings = Arrays.asList("a", "bbb", "ccc", "aaa");
        myCollections.sort(strings);
        System.out.println(strings);

        MyCollections<Integer> myCollections2 = new MyCollections<>();
        List<Integer> integers = Arrays.asList(1, 2, 3, 3, 2, 1);
        myCollections2.sort(integers);
        System.out.println(integers);

        myPerson myPerson1 = new myPerson(10);
        myPerson myPerson2 = new myPerson(18);
        myPerson myPerson3 = new myPerson(11);
        myPerson myPerson4 = new myPerson(133);
        List<myPerson> myPeople = Arrays.asList(myPerson1, myPerson2, myPerson3, myPerson4);
        MyCollections<myPerson> myCollections3 = new MyCollections<>();
        myCollections3.sort(myPeople);
        System.out.println(myPeople);

    }
}

class  MyCollections <T extends Comparable<T>>{
    public void sort(List<T> list){
        for (int i = 0; i < list.size()-1; i++) {
            for (int i1 = 0; i1 < list.size()-1-i; i1++) {
                if (list.get(i1).compareTo(list.get(i1+1))>0){
                    T temp = list.get(i1);
                    list.set(i1,list.get(i1+1));
                    list.set(i1+1,temp);
                }
            }
        }
    }
}
class myPerson implements Comparable<myPerson>{
    public int id;
    public myPerson(int id) {
        this.id = id;
    }
    @Override
    public int compareTo(myPerson o) {
        return this.id-o.id;
    }

    @Override
    public String toString() {
        return "myPerson{" +
                "id=" + id +
                '}';
    }
}