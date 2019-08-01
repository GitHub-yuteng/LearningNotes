package JVM.Reference;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {

        Object object1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object1);
        System.out.println(object1);//TODO java.lang.Object@74a14482
        System.out.println(weakReference.get());//TODO java.lang.Object@74a14482

        object1 = null;
        System.gc();

        System.out.println(object1);//TODO null
        System.out.println(weakReference.get());//TODO null
    }
}
