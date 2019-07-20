package DataStructure.DivideAndConquer;

/**
 * @author Yu
 */
public class Hannota {

    public static void main(String[] args) {
        Hannota(10, 'A', 'B', 'C');
    }

    public static void Hannota(int num, char a, char b, char c) {
        //如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //如果n>=2,总看成两个盘子，上面 和 下面
            //1、先把上面的所有的盘 A->B,移动过程用到 C
            //上面
            Hannota(num - 1, a, c, b);//从a 借助 c 到 b
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //下面
            Hannota(num - 1, b, a, c);//从 b 借助 a 到 c
        }
    }
}
