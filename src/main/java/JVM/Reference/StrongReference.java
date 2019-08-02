package JVM.Reference;

/**
 * @author Yu
 */
public class StrongReference {
    public static void main(String[] args) {

        Object obj1 = new Object();//这样定义的默认就是强引用
        Object obj2 = obj1;//obj2 5引用赋值
        obj1 = null;//置空
        System.gc();
        System.out.println(obj1);//TODO null
        System.out.println(obj2);//TODO java.lang.Object@74a14482
    }
}
