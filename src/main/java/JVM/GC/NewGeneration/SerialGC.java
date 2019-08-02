package JVM.GC.NewGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 * java -XX:+PrintCommandLineFlags -version
 * <p>
 * -XX:InitialHeapSize=132510208
 * -XX:MaxHeapSize=2120163328
 * -XX:+PrintCommandLineFlags
 * -XX:+UseCompressedClassPointers
 * -XX:+UseCompressedOops
 * -XX:-UseLargePagesIndividualAllocation
 * -XX:+UseParallelGC
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * GC (Allocation Failure) [DefNew          Default New Generation
 * Full GC (Allocation Failure) [Tenured   Old
 *
 * //TODO DefNew + Tenured
 */
public class SerialGC {
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
