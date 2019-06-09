/**
 * @author Yu
 */

// 就近原则
// 成员变量：类变量、实例变量
// 局部变量：局部变量
public class Exam5 {

    static int s;  //静态 默认初始化一次 为 0
                //但是 new 两个对象 代码块初始化两次  和方法调用 三次。静态变量 此类只有一个 s  3+2
    int i;
    int j;
    {
        int i = 1;//无关
        i++;//无关
        j++;// j 仅仅在这里 自增了1次
        s++;
    }
    public void test(int j) {
        j++;//这里的 j 是 传值。 不是全局的 j ，仅仅是局部变量 j
        i++; // i 是 对象的成员变量， 根据方法调用的次数而增加的。
        s++;
    }
    public static void main(String[] args) {
        Exam5 obj1 = new Exam5();
        Exam5 obj2 = new Exam5();

        obj1.test(10);
        obj1.test(20);
        obj2.test(30);

        System.out.println(obj1.i+","+obj1.j+","+obj1.s);
        System.out.println(obj2.i+","+obj2.j+","+obj2.s);
    }

}
