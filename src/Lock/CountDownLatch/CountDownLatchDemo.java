package Lock.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Yu
 */
public class CountDownLatchDemo {


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(7);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println("i");
                countDownLatch.countDown();
            }).start();
        }

    }
}
