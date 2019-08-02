package Lock.ReetrantLock;

/**
 * @author Yu
 */
class Sync {
    public synchronized void inOne() {
        System.out.println(Thread.currentThread().getName() + " Come in One!");
        inTwo();// 线程在进入内层方法会自动获取锁。
    }

    public synchronized void inTwo() {
        System.out.println(Thread.currentThread().getName() + " Come in Two!");
    }
}

public class SyncTest {
    public static void main(String[] args) {
        Sync sync = new Sync();

        new Thread(() -> {
            sync.inOne();
        }, "Thread-1").start();

        new Thread(() -> {
            sync.inOne();
        }, "Thread-2").start();
    }
}

