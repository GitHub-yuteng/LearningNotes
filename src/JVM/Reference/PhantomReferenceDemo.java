package JVM.Reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {

        Object object1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object1, referenceQueue);

        System.out.println(object1);//java.lang.Object@74a14482
        System.out.println(phantomReference.get());//TODO null
        System.out.println(referenceQueue.poll());//TODO null

        System.out.println("=========GC 后放入引用队列===========");

        object1 = null;
        System.gc();
        Thread.sleep(500);

        System.out.println(object1);//TODO null
        System.out.println(phantomReference.get());//TODO null
        System.out.println(referenceQueue.poll());//TODO java.lang.ref.PhantomReference@1540e19d
    }
}
/*
java.lang.Object@74a14482
null
null
=========GC 后放入引用队列===========
null
null
java.lang.ref.PhantomReference@1540e19d
*/
