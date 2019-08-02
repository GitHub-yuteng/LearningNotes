package JVM.GC.OldGeneration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 * //TODO 此参数Java8已经被优化,不存在了
 * Error: Could not create the Java Virtual Machine.
 * Error: A fatal exception has occurred. Program will exit.
 * Unrecognized VM option 'UseSerialOldGC'
 * Did you mean '(+/-)UseSerialGC'?
 *
 * 错误：无法创建Java虚拟机。
 * 错误：发生了致命异常。 程序将会退出。
 * 无法识别的VM选项'UseSerialOldGC'
 * 你的意思是'（+/-）UseSerialGC'？
 */
public class SerialOldGC {
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
