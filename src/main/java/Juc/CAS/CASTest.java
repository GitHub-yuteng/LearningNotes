package Juc.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASTest {

    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        System.out.println("------ABA问题的解决--------");

        new Thread(() -> {
            // 初始版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第 1 次版本号" + stamp);
            try {
                // 暂停1秒钟t3线程
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第 2 次版本号" + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101, 100,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + "\t第 3 次版本号" + atomicStampedReference.getStamp());
        }, "t3").start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第 1 次版本号" + stamp);
            try {
                // 暂停3秒钟t4线程，保证上面的t3线程完成了一次ABA操作
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //这里必须重新获取版本号 才可以完成修改
//            int newStamp = atomicStampedReference.getStamp();
            boolean result = atomicStampedReference.compareAndSet(100, 200, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "\t修改成功否：" + result + "\t当前最新实际版本号:" + atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t当前实际最新值：" + atomicStampedReference.getReference());
        }, "t4").start();
    }
}
//输出
//------ABA问题的解决--------
//t3	第一次版本号1
//t4	第一次版本号1
//t3	第二次版本号2
//t3	第三次版本号3
//t4	修改成功否：false	当前最新实际版本号:3
//t4	当前实际最新值：100