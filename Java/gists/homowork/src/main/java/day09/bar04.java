package day09;

import java.util.Comparator;
import java.util.TreeSet;

public class bar04 {
    /**
     * 现在有一堆顺序混乱的牌,  String[] arr ={"方片5","黑桃6","红桃3","大王","梅花4"};
     *   请按照斗地主的顺序将牌重写整理排序(这个有点难度, 量力而行)
     */
    public static void main(String[] args) {
        TreeSet<pok> set = new TreeSet<>(new Comparator<pok>() {
            @Override
            public int compare(pok o1, pok o2) {
                int result = 0;
                String[] arr = {"大王","小王","黑桃","红桃","梅花","方片"};
                int o1Index = 0;
                int o2Index = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals(o1.type)) o1Index=i;
                }
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals(o2.type)) o2Index=i;
                }
                result = o1Index - o2Index;
                int[] numberArr = {0,2,1,13,12,11,10,9,8,7,6,5,4,3};
                int o1number = 0;
                int o2number = 0;
                for (int i = 0; i < numberArr.length; i++) {
                    if (numberArr[i]==o1.number) o1number=i;
                }
                for (int i = 0; i < numberArr.length; i++) {
                    if (numberArr[i]==o2.number) o2number=i;
                }
                result = result == 0 ? o1number - o2number : result;
                return result;
            }
        });
        String[] arr ={"方片5","黑桃6","黑桃2","红桃3","大王","梅花4","方片5","红桃2","小王"};
        for (String s : arr) {
            String name = "";
            int number = 0;
            if (s.length()==3){
                name = s.substring(0,2);
                number = Integer.parseInt(s.substring(2));
            }else {
                name = s.substring(0,2);
            }
//            System.out.println(name+":"+number);
            set.add(new pok(name,number));
        }
        System.out.println(set);
    }
}
class pok{
    public String type;
    public int number;
    public pok(String type, int number) {
        this.type = type;
        this.number = number;
    }
    @Override
    public String toString() {
        return "pok{" +
                "type='" + type + '\'' +
                ", number=" + number +
                '}';
    }
}
