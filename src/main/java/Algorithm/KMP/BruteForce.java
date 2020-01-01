package Algorithm.KMP;

/**
 * @author Yu
 */
public class BruteForce {


    public static int bruteForce(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int p1 = 0;//TODO 指向s1
        int p2 = 0;//TODO 指向s2

        while (p1 < s1Len && p2 < s2Len) {//TODO 保证匹配时候不越界
            if (s1[p1] == s2[p2]) {
                p1++;
                p2++;
                //TODO 如果完全匹配则 p2 == s2Len  退出循环
            } else {
                //TODO 回溯 性能低
                p1 = p1 - (p2 - 1);
                p2 = 0;
            }
        }

        //TODO 判断是否匹配成功
        if (p2 == s2Len) {
            return p1 - p2;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        int i = bruteForce("abasdcb", "sd");
        System.out.println(i);
    }
}
