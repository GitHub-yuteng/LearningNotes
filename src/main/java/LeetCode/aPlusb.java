package LeetCode;

/**
 * @author Yu
 */
public class aPlusb {

    public static int aplusb(int a, int b) {
        if ((a & b) == 0){
            return a | b;
        }
        return aplusb(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        int aplusb = aplusb(3, 5);
        System.out.println(aplusb);
    }
}

// 如果没有进位，那么a+b = a|b。如果有进位就不成立