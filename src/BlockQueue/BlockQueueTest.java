package BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Yu
 */
public class BlockQueueTest {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

//        blockingQueue.add(1);
//        blockingQueue.add(2);
//        blockingQueue.add(3);
//        blockingQueue.add(4);

       blockingQueue.put(1);
       blockingQueue.put(2);
       blockingQueue.put(3);
       blockingQueue.put(4);

//        blockingQueue.poll();

        blockingQueue.take();
        System.out.println(blockingQueue.toString());


    }
}
