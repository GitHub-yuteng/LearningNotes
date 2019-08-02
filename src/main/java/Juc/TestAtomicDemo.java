package Juc;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {

    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable {

    //	private volatile int serialNumber = 0;// 加上volatile 问题依然存在，不能保证变量的“原子性”
    private AtomicInteger serialNumber = new AtomicInteger(0);//包装类

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        System.out.println(getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();//原子性 获取并自增
    }
}