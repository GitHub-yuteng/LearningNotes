package Netty.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Yu
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        // 1. 获取通道
        SocketChannel socketChannel = SocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

        if(!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("连接服务端需要时间...");
            }
        }

        // 2. 切换非阻塞模式
        socketChannel.configureBlocking(false);

        // 3. 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        // 4. 发送数据给服务端
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String str = scan.next();
            String data = new Date().toString() +": "+ str;
            buf.put(data.getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
        // 5. 关闭通道
        socketChannel.close();
    }
}
