package 剑指Offer.Interview_5;


/*
将一个字符串中的空格替换成 "%20"。
*/
public class Solution {

    public static void main(String[] args) {

        String str = "A BCD EFGHIJKLMN O  P";
        System.out.println(str.toString());
        String replaceSpace = replaceSpace(str);
        System.out.println(replaceSpace);
    }

    public static String replaceSpace(String str) {
        int length = str.length();//字符串的长度
        int count = 0;//空格的个数ii

        for (int i = 0; i < length; i++) {
            //检测空格
            if (str.charAt(i) == ' ') {
                count++;
            }
        }

        int nn = 2 * count + length; //根据空格的个数，得到新数组的长度

        int index = nn - 1;
        char[] ct = new char[nn];//新建数组

        while (length > 0) {
            if (str.charAt(length - 1) != ' ') {
                //如果不是空格
                ct[index--] = str.charAt(length - 1);
            } else {
                //如果是空格
                ct[index--] = '0';
                ct[index--] = '2';
                ct[index--] = '%';
            }
            //取下一个字符
            length--;
        }
        return String.valueOf(ct);//将字符数组转为String类型后返回
    }
}