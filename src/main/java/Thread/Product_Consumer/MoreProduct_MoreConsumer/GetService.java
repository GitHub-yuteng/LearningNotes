package Thread.Product_Consumer.MoreProduct_MoreConsumer;

/**
 * @author Yu
 */
public class GetService {
    private Box box;

    public GetService(Box box) {
        this.box = box;
    }

    public void getMethod() {
        try {
            synchronized (this) {
                while (box.size() == 0) {
                    System.out.println("======");
                    this.wait();
                }
                box.popFirst();
            }
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkBoxStatus() {
        try {
            while (true) {
                synchronized (this) {
                    if (box.size() > 0) {
                        this.notifyAll();
                    }
                }
                System.out.println("get CheckBox = " + box.size());
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
