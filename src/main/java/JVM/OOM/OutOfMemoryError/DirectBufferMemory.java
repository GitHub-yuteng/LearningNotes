package JVM.OOM.OutOfMemoryError;

import java.nio.ByteBuffer;

/**
 * @author Yu
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * 本地内存溢出
 * ByteBuffer.allocate都是分配到jvm堆内存，ByteBuffer.allocateDirect现在分配到本地内存 本地内存满了
 */
public class DirectBufferMemory {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("配置的maxDirectMemory：" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        Thread.sleep(3000);

        //设置为 5m 要分配 6m
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
