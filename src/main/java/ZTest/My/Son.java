package ZTest.My;

/**
 * @author Yu
 */

// 父 静态   静态变量 静态代码块
// 子 静态   静态变量 静态代码块
// 父 成员   成员变量， 代码块
// 父 构造   默认构造器
// 子 成员   成员变量， 代码块
// 子 构造   默认构造器
    // 如果子类重写 父类方法，则 都调用子类方法。
public class Son extends Father{

    private int i = test();
    private static int j = method();

    static {
        System.out.print("6、");
    }

    Son(){
        System.out.print("7、");
    }
    
    {
        System.out.print("8、");
    }

    @Override
    public int test(){
        System.out.print("9、");
        return 1;
    }

    public static int method() {
        System.out.print("10、");
        return 1;
    }

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println();
        Son son2 = new Son();
    }
}
