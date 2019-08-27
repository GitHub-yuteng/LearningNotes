package 剑指Offer.Fibonacci;

/*
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * */
public class Solution3 {

    public static int Fibonacci(int n) {

        if (n <= 2){
            return n;
        }

        int pre2 = 1, pre1 = 2;
        int fib = 0;

        for (int i = 3; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        int fibonacci = Solution3.Fibonacci(5);
        System.out.println(fibonacci);
    }
}