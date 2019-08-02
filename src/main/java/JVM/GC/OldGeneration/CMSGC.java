package JVM.GC.OldGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
 * 老年代使用CMS -XX:+UseConcMarkSweepGC，新生代自动激活使用 ParNewGC 收集器。
 *
 * [GC (Allocation Failure) [ParNew:
 * [Full GC (Allocation Failure) [CMS:
 *
 * //TODO ParNew + CMS
 * [GC (CMS Initial Mark)
 * [CMS-concurrent-mark-start]
 * [GC (CMS Final Remark)
 * [CMS-concurrent-sweep-start]
 */
public class CMSGC {
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
