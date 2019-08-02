package Lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        // public CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙！");
        });

        for (int i = 1; i <= 7; i++) {

            final int num = i;

            new Thread(() -> {
                System.out.println("--> 收集到" + num + "龙珠！");
                try {
                    cyclicBarrier.await();//TODO
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
