package JVM.Reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Object object1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(object1, referenceQueue);

        System.out.println(object1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("=========GC后 对象引用被放入引用队列========");

        object1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(object1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}
