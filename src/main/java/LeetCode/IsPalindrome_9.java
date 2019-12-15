package LeetCode;

/**
 * @author Yu
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome_9 {

    public static boolean isPalindrome_3(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int div = 1;
        while (x / div > 10) {
            div *= 10;
        }

        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    /**
     * 取后一半进行反转
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome_2(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        //TODO 只要原数比反转数小说明已经过半
        while (x > revertedNumber) {
            int pop = x % 10;
            revertedNumber = revertedNumber * 10 + pop;
            x /= 10;
        }
        //如果是偶数位 则后半部分反转后与之相等
        //如果是奇数位，则中间可以忽略。 12321
        return x == revertedNumber || x == (revertedNumber / 10);
    }

    public static boolean isPalindrome_1(int x) {
        String num = x + "";
        return num.equals(new StringBuilder(num).reverse().toString());
    }

    public static void main(String[] args) {
        int num = 12321;
        boolean b = isPalindrome_2(num);
        System.out.println(b);
    }
}
