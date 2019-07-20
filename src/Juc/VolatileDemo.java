package Juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yu
 */
class MyData {

    volatile int num = 0;

    public void numTo60() {
        this.num = 60;
    }

    public void addPulsPuls() {
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void MyAtomicInteger() {
        atomicInteger.incrementAndGet();
    }
}

public class VolatileDemo {

    public static void main(String[] args) {
        VolatileKeyWord();
        System.out.println("-----------");
        AtomicIntegerDemo();
    }

    private static void AtomicIntegerDemo() {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPulsPuls();
                    myData.MyAtomicInteger();
                }
            }, String.valueOf(i)).start();
        }

        //当上面 20个线程运行完毕后，用 Main线程看最后结果是多少
        // main & GC
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + " Finally num :" + myData.num);
        System.out.println(Thread.currentThread().getName() + " Finally num :" + myData.atomicInteger);
    }

    /**
     * volatile int num = 0;
     * 1、证明 Volatile 内存可见性
     */
    private static void VolatileKeyWord() {

        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Enter");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.numTo60();
            System.out.println(Thread.currentThread().getName() + " Updata num" + myData.num);
        }, "Thread-Son").start();

        while (myData.num == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "End:" + myData.num);
    }
}
