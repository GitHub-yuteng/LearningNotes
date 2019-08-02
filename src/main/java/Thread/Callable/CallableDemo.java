package Thread.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo{

    public static void main(String[] args) {

        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> futureTask = new FutureTask<>(new ThreadDemo());

        new Thread(futureTask, "A").start();

        //2.接收线程运算后的结果
        try {
            Integer sum = futureTask.get();  //FutureTask 可用于 闭锁
            System.out.println(Thread.currentThread().getName() + "->" + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }
}
