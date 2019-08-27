package 剑指Offer.ReplaceSpace;

/**
 * 将一个字符串中的空格替换成 "%20"。
 */
public class Solution {

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(str.toString());
        String replaceSpace = replaceSpace(str);
        System.out.println("char[]优化-> " + replaceSpace);

        System.out.println("===========");
        String replaceSpace2 = replaceSpace2(str);
        System.out.println("StringBuffer 追加-> " + replaceSpace2);
    }

    public static String replaceSpace(StringBuffer str) {
        int length = str.length();//TODO 字符串长度
        int count = 0;//TODO 空格个数

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        int len = 2 * count + length;//TODO 空格原本占一个位置，则空格数 乘 2 得总长
        char[] chars = new char[len];//TODO 提前设置好数组大小，提高扩容效率
        int index = len - 1;//TODO 因为数组下标从0开始

        while (length > 0) {//TODO > 0 防止 下标越界
            if (str.charAt(length - 1) != ' ') {
                chars[index--] = str.charAt(length - 1);
            } else {
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            }
            length--;
        }
        return String.valueOf(chars);
    }

    public static String replaceSpace2(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return String.valueOf(sb);
    }
}