package day14;

import java.util.concurrent.ThreadPoolExecutor;

public class onCourse {
    public static void main(String[] args) {
        manyThread manyThread = new manyThread();
        Thread thread = new Thread(manyThread,"1");
        Thread thread1 = new Thread(manyThread,"2");
        Thread thread2 = new Thread(manyThread,"3");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
class manyThread implements Runnable{
    private Integer ticket = 10000;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (ticket==0) break;
                ticket--;
                System.out.println("窗口："+Thread.currentThread().getName()+"卖了一张票！还剩"+ticket+"张票！");
            }
        }
    }
}

class cooker implements Runnable{
    private food flag;
    public cooker(food flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true){
            synchronized (food.class){
                if (flag.isFlag()){
                    try {
                        food.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("做包子！");
                    flag.setFlag(true);
                    food.class.notify();
                }
            }
        }
    }
}
class fooder implements Runnable{
    private food flag;

    public fooder(food flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true){
            synchronized (food.class){
                if (flag.isFlag()){
                    System.out.println("吃包子！");
                    flag.setFlag(false);
                    food.class.notify();
                }else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        food.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
class food{
    private boolean flag = false;
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
class test{
    public static void main(String[] args) {
        food food = new food();
        cooker cooker = new cooker(food);
        fooder fooder = new fooder(food);
        new Thread(cooker).start();
        new Thread(fooder).start();
    }
}


