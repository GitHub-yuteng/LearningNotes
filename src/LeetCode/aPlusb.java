package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Yu
 */
public class aPlusb {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public static int aplusb(int a, int b) {
        if ((a & b) == 0)
            return a|b;
        return aplusb(a^b,(a&b)<<1);
    }

    public static void main(String[] args) {
        int aplusb = aplusb(3, 5);
        System.out.println(aplusb);

        Object o = new Object();
        o.hashCode();
    }
}

// 如果没有进位，那么a+b = a|b。如果有进位就不成立