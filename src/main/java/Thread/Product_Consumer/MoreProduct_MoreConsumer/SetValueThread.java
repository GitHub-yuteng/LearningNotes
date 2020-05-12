package Thread.Product_Consumer.MoreProduct_MoreConsumer;

/**
 * @author Yu
 */
public class SetValueThread extends Thread {

    private SetService service;

    public SetValueThread(SetService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            service.setMethod();
        }
    }
}
