package JVM.OOM.OutOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * 98%的时间都用来GC，并且回收了2%不到的堆内存
 */
public class GCOverheadLimit {
    public static void main(String[] args) {

        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("i:" + i);//i:145884
            e.printStackTrace();
            throw e;
        }
    }
}
