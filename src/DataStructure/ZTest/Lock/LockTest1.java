package DataStructure.ZTest.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest1 {

    private Lock lock = new ReentrantLock();

    /*
     * 使用完毕释放后其他线程才能获取锁
     */
    public void lockTest(Thread thread) {
        lock.lock();//获取锁
        try {
            System.out.println("线程" + thread.getName() + "获取当前锁"); //打印当前锁的名称
            Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
        } catch (Exception e) {
            System.out.println("线程" + thread.getName() + "发生了异常释放锁");
        } finally {
            System.out.println("线程" + thread.getName() + "执行完毕释放锁");
            lock.unlock(); //释放锁
        }
    }

    public static void main(String[] args) {

        LockTest1 lt = new LockTest1();
        //声明一个线程 “线程一”
        Thread thread1 = new Thread(() -> lt.lockTest(Thread.currentThread()), "thread1");
        //声明一个线程 “线程二”
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                lt.lockTest(Thread.currentThread());
            }
        }, "thread2");
        // 启动2个线程
        thread2.start();
        thread1.start();

    }
}