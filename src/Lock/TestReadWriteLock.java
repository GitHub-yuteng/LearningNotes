package Lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                final int num = rw.set((int) (Math.random() * 101));
                System.out.println(Thread.currentThread().getName() + "->" + num);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Write").start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                rw.get();
            }).start();
        }
    }

}

class ReadWriteLockDemo {

    private volatile int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 读
    public void get() {
        lock.readLock().lock(); // 上锁
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        } finally {
            lock.readLock().unlock(); // 释放锁
        }
    }

    // 写
    public int set(int number) {
        lock.writeLock().lock();

        try {
            this.number = number;
            return number;
        } finally {
            lock.writeLock().unlock();
        }
    }
}