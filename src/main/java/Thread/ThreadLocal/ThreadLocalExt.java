package Thread.ThreadLocal;

/**
 * @author Yu
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "default";
    }
}
