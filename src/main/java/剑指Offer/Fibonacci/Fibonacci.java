package 剑指Offer.Fibonacci;

/**
 * Fibonacci 递归效率低
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(30));
    }

    private static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
