package Review_Java;

/**
 * @author Yu
 */
public class TestMethodReload {

    public void methodReload() {

    }

    //TODO 发生在同一个类中，方法名必须相同，参数类型不同、个数不同、顺序不同
    //TODO 'methodReload()' is already defined in 'Review_Java.TestMethodReload'
    //TODO 返回值不同不是重载
    /*public int methodReload(){
        return 1;
    }*/

    //TODO 参数类型不同
    public void methodReload(int i) {

    }

    //TODO 参数类型不同
    public void methodReload(String i) {

    }

    //TODO 个数不同
    public void methodReload(int i, String str) {

    }

    //TODO 顺序不同
    public void methodReload(String str, int i) {

    }
}
