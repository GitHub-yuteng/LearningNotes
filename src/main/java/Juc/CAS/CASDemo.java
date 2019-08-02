package Juc.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CASDemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            try {
                // 暂停1秒钟t2线程，保证上面的t1线程完成了一次ABA操作
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "->" + atomicReference.compareAndSet(100, 200) + "\t" + atomicReference.get());
        }, "t2").start();
        // 输出 true	200
    }
}