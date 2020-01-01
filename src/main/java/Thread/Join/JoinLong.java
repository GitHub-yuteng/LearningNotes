package Thread.Join;

/**
 * @author Yu
 */
public class JoinLong {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setName("myThread");

            myThread.start();

            System.out.println("main begin " + System.currentTimeMillis());

            myThread.join();//TODO 主线程等待 子线程运行完毕后继续运行

//            Thread.sleep(2000);
            System.out.println("main -> " + Thread.currentThread().getName());
            System.out.println("main end " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            YouThread youThread = new YouThread();
            youThread.setName("youThread");
            youThread.start();
            youThread.join();
            System.out.println("MyThread run begin  " + System.currentTimeMillis());
            System.out.println("=>" + Thread.currentThread().getName());
//            Thread.sleep(5000);
            System.out.println("MyThread run end  " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class YouThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            System.out.println("YouThread run begin  " + System.currentTimeMillis());
            System.out.println("=>" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("YouThread run end  " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
