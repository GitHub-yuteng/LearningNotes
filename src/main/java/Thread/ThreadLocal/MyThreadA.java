package Thread.ThreadLocal;

/**
 * @author Yu
 */
public class MyThreadA extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                if (ThreadLocalTools.threadLocal.get() == null) {
                    ThreadLocalTools.threadLocal.set("A" + (i + 1));
                    ThreadLocal local = new ThreadLocal();
                    local.set("AAAAAA");
                    String str = (String) local.get();
                    System.out.println(str);
                }
                System.out.println("A get-》》" + ThreadLocalTools.threadLocal.get());
                int sleepValue = (int) (Math.random() * 1000);
                Thread.sleep(sleepValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
