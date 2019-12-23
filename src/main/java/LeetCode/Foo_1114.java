package LeetCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Yu
 */
public class Foo_1114 {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public Foo_1114() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            if (number != 1) {
                condition1.await();
            }
            printFirst.run();
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            if (number != 2) {
                condition2.await();
            }
            printSecond.run();
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            if (number != 3) {
                condition3.await();
            }
            printThird.run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Foo_1114 foo_1114 = new Foo_1114();

        new Thread(() -> {
            try {
                foo_1114.first(new printA());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                foo_1114.second(new printB());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {
                foo_1114.third(new printC());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}

class printA implements Runnable {

    @Override
    public void run() {
        System.out.println("A");
    }
}

class printB implements Runnable {

    @Override
    public void run() {
        System.out.println("B");
    }
}

class printC implements Runnable {

    @Override
    public void run() {
        System.out.println("C");
    }
}