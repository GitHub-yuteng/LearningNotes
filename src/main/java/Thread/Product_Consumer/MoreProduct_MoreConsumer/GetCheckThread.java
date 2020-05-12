package Thread.Product_Consumer.MoreProduct_MoreConsumer;

/**
 * @author Yu
 */
public class GetCheckThread extends Thread {

    private GetService service;

    public GetCheckThread(GetService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.checkBoxStatus();
    }
}
