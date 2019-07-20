package DataStructure.ZTest.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest3 {

    private Lock lock = new ReentrantLock();

    public void tryLockParamTest(Thread thread) throws InterruptedException {
        //尝试获取锁 获取不到锁，就等3秒，如果3秒后还是获取不到就返回false
        if (lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
            try {
                System.out.println(thread.getName() + "获取当前锁"); //打印当前锁的名称
                Thread.sleep(4000);//为看出执行效果，是线程此处休眠2秒
            } catch (Exception e) {
                System.out.println(thread.getName() + "发生了异常释放锁");
            } finally {
                System.out.println(thread.getName() + "执行完毕释放锁");
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "当前锁被其他线程占用,等待3s后仍无法获取,放弃");
        }
    }

    public static void main(String[] args) {
        LockTest3 lockTest = new LockTest3();
        Thread thread1 = new Thread(() -> {
            try {
                lockTest.tryLockParamTest(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            try {
                lockTest.tryLockParamTest(Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2");

        thread1.start();
        thread2.start();

    }
}