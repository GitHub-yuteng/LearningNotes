package Thread.Pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());//TODO 4线程

//        JDKThreadPool();

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        //TODO 请求最大上限为 corePoolSize + maximumPoolSize
        //TODO 拒绝策略为 AbortPolicy() java.util.concurrent.RejectedExecutionException
        //TODO 拒绝策略为 CallerRunsPolicy() 回退调用者 main 请求
        //TODO 拒绝策略为 DiscardPolicy() 直接丢弃
        //TODO 拒绝策略为 DiscardOldestPolicy() 丢弃等待最久的任务
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 请求");
                });
//                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void JDKThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

        //模拟20个线程，请求线程
        try {
            for (int i = 1; i <= 20; i++) {
                cachedThreadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " *");
                });
//                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fixedThreadPool.shutdown();
            singleThreadExecutor.shutdown();
            cachedThreadPool.shutdown();
        }
    }
}
