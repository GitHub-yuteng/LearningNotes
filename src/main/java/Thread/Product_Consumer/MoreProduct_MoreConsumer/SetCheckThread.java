package Thread.Product_Consumer.MoreProduct_MoreConsumer;

/**
 * @author Yu
 */
public class SetCheckThread extends Thread {
    private SetService service;

    public SetCheckThread(SetService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.checkBoxStatus();
    }
}
