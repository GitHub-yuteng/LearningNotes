package LeetCode;

import javassist.bytecode.analysis.FramePrinter;

/**
 * @author Yu
 */
public class LengthOfLastWord_58 {

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        if (end < 0) {
            return 0;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }

    public static void main(String[] args) {
        int length = lengthOfLastWord(" asd");

        System.out.println(length);
    }
}
