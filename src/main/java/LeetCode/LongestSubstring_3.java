package LeetCode;

import antlr.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Yu
 */
public class LongestSubstring_3 {

    /**
     * TLE
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring_1(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            //TODO 如果只有一个字符 j必须等于字符串长度
            for (int j = i + 1; j <= s.length(); j++) {
                if (allUnique(s, i, j)) {
                    length = Math.max(length, j - i);
                    System.out.println(s.substring(i, j));
                }
            }
        }
        return length;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 暴力法 逐个检查所有的子字符串，看它是否不含有重复的字符。
     * 时间复杂度 O(n^2)
     *
     * @param str
     */
    private static void solution1(String str) {
        int length = lengthOfLongestSubstring_1(str);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring_2(String s) {
        int length = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();//模拟窗口
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
                System.out.println("==>" + s.substring(i, j));
            } else {
                set.remove(s.charAt(i++));
                System.out.println(s.substring(i, j));
            }
        }
        return ans;
    }

    /**
     * 滑动窗口算法
     *
     * @param str
     */
    private static void solution2(String str) {
        int length = lengthOfLongestSubstring_2(str);
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring_3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 优化滑动窗口算法
     *
     * @param str
     */
    private static void solution3(String str) {
        int length = lengthOfLongestSubstring_3(str);
        System.out.println(length);
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
//        solution1(str);
        solution2(str);
    }
}
