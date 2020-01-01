package Thread.Join;

public class JoinDemo extends Thread {
    int i;
    Thread previousThread; //上一个线程

    public JoinDemo(Thread previousThread, int i) {
        this.previousThread = previousThread;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            previousThread.join();
//            thread.join的含义是当前线程需要等待previousThread线程终止之后才从thread.join返回。
//            简单来说，就是上一个线程没有执行完之前，下一个会一直阻塞在join方法处。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "num:" + i);
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinDemo joinDemo = new JoinDemo(previousThread, i);
            joinDemo.start();
            previousThread = joinDemo;
        }
        System.out.println("main: " + Thread.currentThread().getName());//TODO main

    }
}