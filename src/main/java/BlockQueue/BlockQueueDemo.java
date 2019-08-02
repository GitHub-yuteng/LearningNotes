package BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Yu
 */
public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        //TODO 抛出异常  add —— remove
        System.out.println("抛出异常  add —— remove");
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        System.out.println("element()->获取头部元素:" + blockingQueue.element());//TODO 获取头部元素
        System.out.println(blockingQueue.toString());
//        blockingQueue.add(4);//TODO java.lang.IllegalStateException: Queue full

        System.out.println(blockingQueue.remove());//TODO 1
        System.out.println(blockingQueue.remove());//TODO 2
        System.out.println(blockingQueue.remove());//TODO 3
//        System.out.println(blockingQueue.remove());//TODO java.util.NoSuchElementException

        System.out.println("-----------------------------");
        System.out.println(blockingQueue.toString());

        //TODO 返回特殊值 offer —— poll
        System.out.println("返回特殊值 offer —— poll");
        System.out.println(blockingQueue.offer(1));//TODO true
        System.out.println(blockingQueue.offer(2));//TODO true
        System.out.println(blockingQueue.offer(3));//TODO true
        System.out.println(blockingQueue.offer(4));//TODO false

        System.out.println("peek()->获取头部元素:" + blockingQueue.peek());
        System.out.println(blockingQueue.toString());

        System.out.println(blockingQueue.poll());//TODO 1
        System.out.println(blockingQueue.poll());//TODO 2
        System.out.println(blockingQueue.poll());//TODO 3
        System.out.println(blockingQueue.poll());//TODO null

        System.out.println("-----------------------------");
        System.out.println(blockingQueue.toString());

        //TODO 阻塞 put —— take
        System.out.println("根据容器大小阻塞 put —— take");
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);

        System.out.println("take-> " + blockingQueue.take());
        blockingQueue.put(4);//TODO 根据队列大小 阻塞
        System.out.println(blockingQueue.toString());

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());//TODO 阻塞

        System.out.println("-----------------------------");
        System.out.println(blockingQueue.toString());

        //TODO 超时退出
        //TODO offer(E e, long timeout, TimeUnit unit)
        //TODO poll(long timeout, TimeUnit unit)
        System.out.println("boolean offer(E e, long timeout, TimeUnit unit)");
        System.out.println("E poll(long timeout, TimeUnit unit)");
        System.out.println(blockingQueue.offer(1, 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(2, 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(3, 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer(4, 2L, TimeUnit.SECONDS)+" 阻塞2s");

        System.out.println(blockingQueue.toString());
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS)+" 阻塞2s");
    }
}
