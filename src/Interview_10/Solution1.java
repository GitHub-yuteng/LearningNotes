package Interview_10;


public class Solution1 {
    /*public static int Fibonacci(int n) {
        if (n <= 1)
            return n;
        int[] fib = new int[n + 1];

        fib[1] = 1;

        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];

        return fib[n];
    }*/

/*
考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
从前向后
*/
    public static int Fibonacci(int n) {

        if (n <= 1){
            return n;
        }

        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }



    public static void main(String[] args) {
        int fibonacci = Solution1.Fibonacci(10);
        System.out.println(fibonacci);
    }
}