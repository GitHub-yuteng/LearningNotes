package Thread.ThreadLocal;

public class MyThreadB extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                if (ThreadLocalTools.threadLocal.get() == null) {
                    ThreadLocalTools.threadLocal.set("B" + (i + 1));
                }
                System.out.println("B get--->>" + ThreadLocalTools.threadLocal.get());
                int sleepValue = (int) (Math.random() * 1000);
                Thread.sleep(sleepValue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}