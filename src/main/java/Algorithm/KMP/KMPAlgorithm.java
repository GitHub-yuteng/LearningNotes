package Algorithm.KMP;

import java.util.Arrays;

/**
 * @author Yu
 */
public class KMPAlgorithm {

    //TODO 获取子串的部分匹配值表
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;//TODO 如果字符串是长度为1，部分匹配值就是0

        for (int i = 1, j = 0; i < dest.length(); i++) {

            //当 dest.charAt(i)!= dest.charAt(j) 我们需要从 next[j-1]获取新的j
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //当 dest.charAt(i)== dest.charAt(j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int kmpSearch(String str1, String str2, int[] next) {

        for (int i = 0, j = 0; i < str1.length(); i++) {

            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }

            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String str1 = "ABAADBBCCAB";
        String str2 = "ABCDABDCA";

        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));
    }
}
