package ZTest.My;

/**
 * @author Yu
 */

// 考虑好 变量值 和 栈内值 的变化

// 自增 是 变量值自增
//  操作 是 栈内操作 后赋值
public class Demo1 {
    public static void main(String[] args) {
        int i = 1;
        i = i++;//i = 1
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}
