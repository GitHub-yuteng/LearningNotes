package 剑指Offer.Fibonacci;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 思路：如果只有1级台阶，显然只有 1 种跳法，如果两个台阶，就有 2 种跳法。
 * 一般情况下，我们把 n 级台阶时的跳法看成是 n 的函数，记为f(n)。
 * 当n>2时，第一次跳的时候就有两种不同的选择：
 * 一是第一次只跳1级：
 * 此时跳法数目等于后面剩下的 n-1 级台阶的跳法数目，即为f(n-1);
 * 另一种选择是第一次跳2级：
 * 此时跳法数目等于后面剩下的n-2级台阶的跳法数目，即为f(n-2)；
 * 因此n级台阶的不同跳法总数是f(n)=f(n-1)+f(n-2)
 *
 * 比如：有6层台阶 通过计算一共有13种跳法
 * 此时，把问题简化
 * 当青蛙第一次跳 1 阶，则问题变为 5阶；->8种
 * 当青蛙第一次跳 2 阶，则问题变为 4阶；->5种
 * 则此时6阶梯，为上述之和 13种！
 *
 * 扩展：
 * 若一只青蛙一次可以跳上1及台阶，也可跳上2级台阶，也可跳上3级台阶，…….也可跳上n级台阶。问一直青蛙要跳上n级台阶有几种跳法?
 * 通过数学归纳法可知，f(n) = 2^(n-1)。
 */
public class FrogJump {

    public static int Fibonacci(int n) {

        if (n <= 2) {
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
        int fibonacci = FrogJump.Fibonacci(3);
        System.out.println(fibonacci);
    }
}