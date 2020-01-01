package Thread.Notify.NotifyAll;

/**
 * @author Yu
 */
public class MyService {

    private Object lock = new Object();

    public void waitMethod() {
        try {
            synchronized (lock) {
                System.out.println("Begin wait" + System.currentTimeMillis() + "->" + Thread.currentThread().getName());
                lock.wait();
                System.out.println("End wait" + System.currentTimeMillis() + "->" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifyMethod() {
        synchronized (lock) {
            System.out.println("Begin Notify" + System.currentTimeMillis() + "->" + Thread.currentThread().getName());
            lock.notifyAll();
            System.out.println("End Notify" + System.currentTimeMillis() + "->" + Thread.currentThread().getName());
        }
    }
}
