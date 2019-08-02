package JVM.OOM.OutOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
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
