package ZTest.My;

public class Threads4 {

    public static void main(String[] args) {
        new Threads4().go();
    }

    public void go() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}