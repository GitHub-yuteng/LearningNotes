package Juc;

/**
 * @author Yu
 */
public class VolatileReOrder {

    private static long x = 0;
    private static long y = 0;
    private static long a = 0;
    private static long b = 0;
    private volatile static long c = 0;
    private volatile static long d = 0;

    private static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            count++;

            Thread t1 = new Thread(() -> {
                x = b;
                c = 101;
                a = 1;

                System.out.println(Thread.currentThread().getName() + " /x ->" + x);
            });

            Thread t2 = new Thread(() -> {
                y = a;
                d = 201;
                b = 1;
                System.out.println(Thread.currentThread().getName() + " /y ->" + y);
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            String show = "count " + count + " " + x + "," + y;
            if (x != 0 && y != 0) {
                System.out.println(Thread.currentThread().getName() + " ->" + show);
                break;
            } else {
                System.out.println(Thread.currentThread().getName() + "===>" + show);
            }
        }
    }
}
