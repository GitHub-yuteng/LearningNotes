package Thread.Product_Consumer.MoreProduct_MoreConsumer;

/**
 * @author Yu
 */
public class GetValueThread extends Thread {

    private GetService service;

    public GetValueThread(GetService service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            service.getMethod();
        }
    }
}
