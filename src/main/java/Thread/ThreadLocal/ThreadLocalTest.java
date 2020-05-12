package Thread.ThreadLocal;

/**
 * @author Yu
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

        MyThreadA myThreadA = new MyThreadA();
        MyThreadB myThreadB = new MyThreadB();

        myThreadA.start();
        myThreadB.start();
        myThreadA.join();
        myThreadB.join();

        for (int i = 0; i < 10; i++) {
            ThreadLocalTools.threadLocal.set("main " + (i + 1));
            System.out.println("->> main get：" + ThreadLocalTools.threadLocal.get() + " ->" + Thread.currentThread().getName());
            int sleepValue = (int) (Math.random() * 1000);
            Thread.sleep(sleepValue);
        }
    }
}
