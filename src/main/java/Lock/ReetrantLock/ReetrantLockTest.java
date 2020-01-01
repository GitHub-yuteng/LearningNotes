package Lock.ReetrantLock;

import sun.misc.Unsafe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Reetrant implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        inOne();
    }

    public void inOne() {

        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Come in One!");
            inTwo();// 线程在进入内层方法会自动获取锁。
        } finally {
            lock.unlock();
        }
    }

    public void inTwo() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Come in Two!");
        } finally {
            lock.unlock();
        }
    }
}

public class ReetrantLockTest {

    public static void main(String[] args) {

        Reetrant reetrant = new Reetrant();

        new Thread(reetrant, "Thread-3").start();
        new Thread(reetrant, "Thread-4").start();
    }
}
