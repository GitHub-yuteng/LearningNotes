package JVM.OOM.OutOfMemoryError;

import java.nio.ByteBuffer;

/**
 * @author Yu
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferMemory {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("配置的maxDirectMemory：" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        Thread.sleep(3000);

        //设置为 5m 要分配 6m
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
