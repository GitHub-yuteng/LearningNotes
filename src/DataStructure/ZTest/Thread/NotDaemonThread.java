package DataStructure.ZTest.Thread;

/**
 * @author Yu
 */
public class NotDaemonThread {
    public static void main(String[] args) {
       /* Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("我是子线程(用户线程)");
                }
            }
        });*/

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
        // TODO 启动线程 没有开启守护线程
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
