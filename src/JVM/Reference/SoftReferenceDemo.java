package JVM.Reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    /*
     *内存够用的时候就保留，不够用就回收!
     */
    public static void softRef_Memory_Enough() {
        Object object1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object1);
        System.out.println(object1);//TODO java.lang.Object@74a14482
        System.out.println(softReference.get());//TODO java.lang.Object@74a14482
        object1 = null;
        System.gc();
        System.out.println(object1);//TODO null
        System.out.println(softReference.get());//TODO java.lang.Object@74a14482
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让它内存不够用了 导致00M，看软引用的回收情况
     * -Xms5m -Xmx5m -XX: +PrintGCDetails
     */
    public static void softRef_Memory_NotEnough() {
        Object object1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object1);
        System.out.println(object1);//TODO java.lang.Object@1540e19d
        System.out.println(softReference.get());//TODO java.lang.Object@1540e19d

        object1 = null;

        try {
            byte[] bytes = new byte[30 * 1024 * 1014];
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(object1);//TODO null
            System.out.println(softReference.get());//TODO null
        }
    }

    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
