package LeetCode;

/**
 * @author Yu
 */
public class ClimbStairs_70 {
    public static int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    public static void main(String[] args) {
        int i = climbStairs(3);
        System.out.println(i);
    }
}
