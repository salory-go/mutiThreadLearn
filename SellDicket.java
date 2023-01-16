package com.Thread.use;
//模拟多个售票窗口售票
public class SellDicket {

    public static void main(String[] args) {
//        SellDicket01 sellDicket01 = new SellDicket01();
//        SellDicket01 sellDicket02 = new SellDicket01();
//        SellDicket01 sellDicket03 = new SellDicket01();
////        可能出现票数为-1的情况，因为售票有50毫秒间隔
//        sellDicket01.start();
//        sellDicket02.start();
//        sellDicket03.start();
//使用接口方式来实现，还是会出先问题
        SellDicket02 sellDicket02 = new SellDicket02();
        new Thread(sellDicket02).start();
        new Thread(sellDicket02).start();
        new Thread(sellDicket02).start();
//        SellDicket01 sellDicket1 = new SellDicket01();
//        SellDicket01 sellDicket2 = new SellDicket01();
//        SellDicket01 sellDicket3 = new SellDicket01();
//        sellDicket1.start();
//        sellDicket2.start();
//        sellDicket3.start();
    }
}
class  SellDicket01 extends Thread{
    private static  int  tickenum = 100;

    @Override
    public void run() {
        while (true) {
            if (tickenum<=0) {
                System.out.println("售票结束");
                break;
            }
//        模拟售票时间
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"
            +"售票剩余量"+(--tickenum));
        }

    }
}
class  SellDicket02 implements Runnable{
    private int tickenum = 100;
//售票同步进行
//   一个同步方法
//    这时锁在对象上
//    也可以在代码块,synchronized (this) ，这也是在对象上
//    如果该方法是静态的，则锁在类上
    public /*synchronized*/ boolean buyTicket(boolean loop){
        synchronized (this) {
            if (tickenum>0) {
                tickenum--;
            }
            else {
                System.out.println("售票结束");
                loop = false;
            }
            return loop;
        }
    }

    @Override
    public void run() {
        boolean loop=true;
        while (loop) {
            loop = buyTicket(loop);
//        模拟售票时间
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"
                    +"售票剩余量"+(tickenum));
        }

    }
}

