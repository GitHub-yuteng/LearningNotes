package Thread;

/**
 * @author Yu
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("我是子线程(用户线程)");
            }
        });

        // TODO 标识当前方法为守护线程，一定要在启动线程前设置为守护线程
        t1.setDaemon(true);
        t1.start();

        //相当与主线程
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("main:i:" + i);
        }
        System.out.println("主线程执行完毕...");
    }
}
