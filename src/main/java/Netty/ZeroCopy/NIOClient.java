package Netty.ZeroCopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Yu
 * transferTO 底层使用到零拷贝
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress("127.0.0.1", 7001));

        String filename = "nio.txt";

        long start = System.currentTimeMillis();

        FileInputStream fileInputStream = new FileInputStream(filename);
        FileChannel fileChannel = fileInputStream.getChannel();

        //LInux ：一次transferTO，就可以完成传输
        //Windows ：一次transferTO只能发送 8m，如果文件过大需要分段

        long transferTo = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        long end = System.currentTimeMillis();

        System.out.println("发送字节数：" + transferTo + " 耗时：" + (end - start));

    }
}
