package JVM.OOM.OutOfMemoryError;

/**
 * @author Yu
 */
public class JavaHeapSpace {

    /**
     * -Xms10m -Xmx10m
     */
    public static void main(String[] args) {

        while (true) {
            byte[] bytes = new byte[10 * 1024 * 1024];
        }
    }
}
