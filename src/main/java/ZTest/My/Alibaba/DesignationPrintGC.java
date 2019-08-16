package ZTest.My.Alibaba;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 * <p>
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 *
 * 触发 5次 youngGC 3次fullGC 2次youngGC
 */
public class DesignationPrintGC {
    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            Byte[] bytes = new Byte[1024 * 1024];
            SoftReference<Object> softReference = new SoftReference<>(bytes);
        }
        System.gc();
        System.gc();

        List<Object> l = new ArrayList<Object>();
        for (int i = 0; i < 6; i++) {
            l.add(new byte[1024 * 1024]);
            if (i % 10 == 0) {
                System.gc();
            }
        }
    }
}
