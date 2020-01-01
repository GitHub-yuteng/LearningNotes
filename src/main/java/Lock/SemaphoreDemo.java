package Lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 抽象数据类型：一个整形（semaphore）， 两个原子操作
 *
 * - P()：sem减1，如果 sem< 0, 等待，否则继续；
 * - V()：sem加1，如果 sem<=0 ，唤醒一个等待的P；
 */

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);//模拟 3个位置  如果设置为1，则变为加锁

        for (int i = 1; i <= 6; i++) {//模拟 6部车

            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位！");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 停车3秒后离开车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
