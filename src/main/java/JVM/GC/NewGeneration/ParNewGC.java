package JVM.GC.NewGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * java -XX:+PrintCommandLineFlags -version
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC
 *
 * [GC (Allocation Failure) [ParNew          Parallel New Generation
 * [Full GC (Allocation Failure) [Tenured    Old
 *
 * //TODO ParNew + Tenured
 *
 * Java HotSpot(TM) 64-Bit Server VM warning:
 * Using the ParNew young collector with the Serial old collector is deprecated and will likely be removed in a future release
 * 不推荐将 ParNew收集器 与 Serial Old收集器 一起使用，并且可能会在将来的版本中删除
 * 推荐 ParNew收集器 与 CMS收集器一起使用
 */
public class ParNewGC {
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
