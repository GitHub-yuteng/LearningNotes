import java.util.Arrays;

/**
 * @author Yu
 */

// 基本数据类型  传值
// 引用数据类型  传地址
// String 和包装类 不可变性  如果发生改变 会创建新的 值 并改变本身地址 指向新值
public class Exam4 {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 2;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(i, str, num, arr, my);

        System.out.println(i);//1
        System.out.println(str);//hello
        System.out.println(num);// 2
        System.out.println(Arrays.toString(arr)); //2
        System.out.println(my.a);//11
    }

    private static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}
class MyData {
    int a = 10;
}
