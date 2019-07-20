package DataStructure.ZTest.Lock.FairLock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock {
    /**
     * true 表示 ReentrantLock 的公平锁
     */
    private ReentrantLock lock = new ReentrantLock(true);

    public void testFair() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        FairLock fairLock = new FairLock();

        Thread thread;

        Thread[] threadArray = new Thread[10];

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            fairLock.testFair();
        };

        for (int i = 0; i < 10; i++) {
            thread = new Thread(runnable);
            threadArray[i] = thread;
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}

