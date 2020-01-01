package Thread.Notify.NotifyAll;

/**
 * @author Yu
 */
public class MyThreadA extends Thread {

    private MyService service;

    public MyThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.waitMethod();
    }
}
