package 剑指Offer.BinaryNumOf1;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * a&(a-1)的结果会将a最右边的1变为0，直到a = 0
 * 还可以先将 a&1 != 0，然后右移1位，但不能计算负数的值，
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(NumberOf1(15));
    }

    private static int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}


