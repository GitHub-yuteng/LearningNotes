package Review_Java;

/**
 * @author Yu
 */
public class Generic<T> {
    int[] a = new int[1];
    int[][][] a1 = new int[3][3][];
    Object[] objects = new Object[4];
    A[] s = new A[2];
    private T p;
    int i = 0;
    private final long id = ++i;

    public Generic(T p) {
        this.p = p;
    }

    public T getP() {
        return p;
    }

    public void setP(T p) {
        this.p = p;
    }

    public static void main(String[] args) {
        Generic<A> t1 = new Generic<>(new A());
        Generic<B> t2 = new Generic<>(new B());

        System.out.println(t1.id);
    }
}

class A {

}

class B {

}
