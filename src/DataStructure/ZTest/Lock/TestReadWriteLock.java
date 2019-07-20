package DataStructure.ZTest.Lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLock = new ReadWriteLockDemo();

        new Thread(() -> {
            final int num = readWriteLock.set((int) (Math.random() * 101));
            System.out.println("->" + num);
        }, "Write").start();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                readWriteLock.get();
            }).start();
        }
    }
}

class ReadWriteLockDemo {

    private int number = 0;
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
            System.out.println(Thread.currentThread().getName());
            this.number = number;
            return number;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
