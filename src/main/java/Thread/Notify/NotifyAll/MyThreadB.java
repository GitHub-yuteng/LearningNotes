package Thread.Notify.NotifyAll;

public class MyThreadB extends Thread {

    private MyService service;

    public MyThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.notifyMethod();
    }
}