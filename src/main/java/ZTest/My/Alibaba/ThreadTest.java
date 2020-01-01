package ZTest.My.Alibaba;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        System.out.println("In run");
        yield();
        System.out.println("Leaving run");
    }

    public static void main(String[] argv) {
        (new ThreadTest()).start();
    }
}