package ZTest.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private Lock lock = new ReentrantLock();

    /*
     * 尝试获取锁 tryLock() 它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false
     */
    public void tryLockTest(Thread thread) {
        //尝试获取锁
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "获取当前锁");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(thread.getName() + "发生了异常释放锁");
            } finally {
                System.out.println(thread.getName() + "执行完毕释放锁");
                lock.unlock(); //释放锁
            }
        } else {
            System.out.println(Thread.currentThread().getName() + "当前锁被其他线程占用，无法获取");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        Thread thread1 = new Thread(() ->
                lockTest.tryLockTest(Thread.currentThread()), "Thread1");

        Thread thread2 = new Thread(() ->
                lockTest.tryLockTest(Thread.currentThread()), "thread2");

        thread1.start();
        thread2.start();
    }
}