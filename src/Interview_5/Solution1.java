package Interview_5;

public class Solution1 {

    public static String replaceSpace(StringBuffer str) {

        String str1=str.toString();
        String str2=str1.replace(" ","%20");
        return str2;

    }

    public static void main(String[] args) {

        System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));
    }
}