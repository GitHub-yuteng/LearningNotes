package Lock;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + " 自己持有：" + lockA + " 尝试获取：" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " 自己持有：" + lockB + " 尝试获取：" + lockA);
            }
        }
    }
}

public class DeadLock {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"A").start();
        new Thread(new HoldLockThread(lockB,lockA),"B").start();

        //linux ps -ef|grep java  ls -l
        // windows 运行此文件后 jps -l
        //jps -l 定位进程号
        //jstack xxx 找到原因查看

       /*
        E:\IntellWorkSpace\LearningNotes\src\Lock>jps -l
        11476
        14164 Lock.DeadLock
        1352 org.jetbrains.jps.cmdline.Launcher
        5832 sun.tools.jps.Jps

        E:\IntellWorkSpace\LearningNotes\src\Lock>jstack 14164

        "B":
        at Lock.HoldLockThread.run(DeadLock.java:25)
        - waiting to lock <0x00000000d5f45d48> (a java.lang.String)
        - locked <0x00000000d5f45d80> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)

        "A":
        at Lock.HoldLockThread.run(DeadLock.java:25)
        - waiting to lock <0x00000000d5f45d80> (a java.lang.String)
        - locked <0x00000000d5f45d48> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)

        Found 1 deadlock.
        */
    }
}