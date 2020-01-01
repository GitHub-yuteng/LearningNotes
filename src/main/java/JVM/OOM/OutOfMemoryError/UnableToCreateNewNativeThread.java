package JVM.OOM.OutOfMemoryError;

/**
 * @author Yu
 * 不能够创建更多的本地线程  98497
 */
public class UnableToCreateNewNativeThread {
    public static void main(String[] args) {

        for (int i = 0; ; i++) {
            System.out.println("i: " + i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "" + i).start();
        }
    }
}