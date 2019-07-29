package Lock.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(10);

        LatchDemo ld = new LatchDemo(latch);

        long start = System.currentTimeMillis();

        //10个分线程
        for (int i = 0; i < 10; i++) {
            new Thread(ld, "T" + i).start();
        }

        //不加 latch.await();   10个分线程和 1个主线程同时执行，没办法计算时间
        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();//主线程

        System.out.println("耗费时间为：" + (end - start));
    }
}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        //TODO 每个线程都各自打印50以内的偶数
        synchronized (this) {
            try {
                for (int i = 0; i < 50; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "---->" + i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}