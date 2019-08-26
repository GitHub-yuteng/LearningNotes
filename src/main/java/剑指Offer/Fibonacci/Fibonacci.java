package 剑指Offer.Fibonacci;

/**
 * Fibonacci 递归效率低
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }

    private static int fibonacci(int i) {
        if (i == 1 || i == 2) {
            return 1;
        } else {
            return fibonacci(i - 1) + fibonacci(i - 2);
        }
    }
}
