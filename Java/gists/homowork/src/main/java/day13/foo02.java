package day13;

import java.util.ArrayList;

public class foo02 extends Thread{
    private static int id = 0;
    private int currentID = 0;
    {
        currentID = id++;
    }
    /**
     * 模拟多个人通过一个山洞：
     * 	(1).这个山洞每次只能通过一个人，每个人通过山洞的时间为1秒；
     * 	(2).创建10个线程，同时准备过此山洞，并且定义一个变量用于记录通过隧道的人数。显示每次通过山洞人的姓名，和通过顺序；
     * 	保证安全问题,不能出现多个人同时通过山洞的现象;(必须逐一通过)
     */
    public static void main(String[] args) {
        ArrayList<foo02> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new foo02());
        }
        for (foo02 foo02 : list) {
            foo02.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("线程"+this.currentID+"通过山洞，他是第"+(++getIndex.index)+"个");
    }
}
class getIndex{
    public static int index = 0;
}