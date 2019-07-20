package DataStructure.ZTest.Lock.FairLock;

import org.junit.Test;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    private ReentrantLock fairLock = new ReentrantLock(true);

    private ReentrantLock notFairLock = new ReentrantLock(false);

    @Test
    public void testFair() {
        Thread[] threads = new Thread[10];
        Runnable r = () -> tryGet(fairLock);
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(r);
        }
        for (Thread t : threads) {
            t.start();
        }
    }

    @Test
    public void testNotFair() {
        Thread[] threads = new Thread[10];
        Runnable r = () -> tryGet(notFairLock);
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(r);
        }
        for (Thread t : threads) {
            t.start();
        }
    }

    private void tryGet(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获取了锁！");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}