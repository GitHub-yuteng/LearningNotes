package Thread.LearnThread;

/**
 * @author Yu
 */
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("-> " + Thread.currentThread().getName());//-> main
        System.out.println("--> " + this.getName());//--> Thread-0
    }

    @Override
    public void run() {
        System.out.println("run -> " + Thread.currentThread().getName());//run -> A
        System.out.println("run --> " + this.getName());//run --> Thread-0
    }
}

class Run {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }
}