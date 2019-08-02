package JVM.OOM;

/**
 * @author Yu
 */
public class StackOverflowError {
    public static void main(String[] args) {
        StackOverflow();
    }

    private static void StackOverflow() {
        StackOverflow();
    }
}
