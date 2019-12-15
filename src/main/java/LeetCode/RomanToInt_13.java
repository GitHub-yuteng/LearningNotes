package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yu
 */
public class RomanToInt_13 {

    public static int romanToInt(String s) {

        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            //TODO 先判断两个字符
            if (i + 1 < s.length() && romanMap.containsKey(s.substring(i, i + 2))) {
                ans = ans + romanMap.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans = ans + romanMap.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = romanToInt("LIX");
        System.out.println(i);
    }
}
