package JVM.GC.OldGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC
 *
 * [GC (Allocation Failure) [PSYoungGen:  Parallel Scavenge
 * [Full GC (Ergonomics) [PSYoungGen: 2047K->0K(2560K)] [ParOldGen:     Parallel Old Generation
 *
 * //TODO PSYoungGen + ParOldGen
 */
public class ParallelOldGC {
    public static void main(String[] args) throws InterruptedException {
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
