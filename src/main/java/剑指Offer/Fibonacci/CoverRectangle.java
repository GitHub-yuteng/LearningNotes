package 剑指Offer.Fibonacci;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 问题简化：
 * 当第一次 竖着铺一块，问题简化为 2*(n-1)
 * 当第一次 横着铺两块，问题简化为 2*(n-2)
 */
public class CoverRectangle {

    public static int Fibonacci(int target) {

        if (target <= 2) {
            return target;
        }

        int pre2 = 1, pre1 = 2;
        int result = 0;

        for (int i = 3; i <= target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public static int Fibonacci2(int n) {
        int number = 1;
        int sum = 1;
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        while (n-- >= 2) {
            sum += number;
            number = sum - number;
        }
        return sum;
    }

    public static void main(String[] args) {
        int fibonacci = CoverRectangle.Fibonacci(5);
        System.out.println(fibonacci);
        System.out.println("=============");
        int fibonacci2 = CoverRectangle.Fibonacci2(5);
        System.out.println(fibonacci2);
    }
}