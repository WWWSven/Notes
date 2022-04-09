package day07;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class bar05 {
    /**
     * 请将第五题的牌除了最后三张, 模拟发牌, 发到其他三个集合中, 打印发牌后的三个集合
     */
    public static void main(String[] args) {
        ArrayList<String> pokEle1 = new ArrayList<>();
        ArrayList<String> pokEle2 = new ArrayList<>();
        ArrayList<String> pokEle3 = new ArrayList<>();
        ArrayList<String> threePok = new ArrayList<>();
        ArrayList<String> pok = bar04.getPok();
        for (int i = 0; i < 3; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, pok.size());
            String s = pok.get(randomIndex);
            threePok.add(s);
            pok.remove(s);
        }
        ArrayList<Integer> index = new ArrayList<>(); // 存储三个牌做间隔的索引值(size==16)
        for (int i = 0; i < pok.size()-1; i+=3) {
            index.add(i);
        }
        for (int i = 0; i < 16; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, index.size()); // 对index集合随机索引
            Integer indexEle = index.get(randomIndex);
            pokEle1.add(pok.get(indexEle));
            pokEle2.add(pok.get(indexEle+1));
            pokEle3.add(pok.get(indexEle+2));
            index.remove(randomIndex);
        }
        System.out.println(pokEle1);
        System.out.println(pokEle2);
        System.out.println(pokEle3);
        System.out.println(threePok);
    }
}
