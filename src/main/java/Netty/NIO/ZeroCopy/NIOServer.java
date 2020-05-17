package Netty.NIO.ZeroCopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Yu
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {

        // 1. 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 2. 切换非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 3. 绑定连接
        serverSocketChannel.socket().bind(new InetSocketAddress(7001));

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();

            int read = 0;

            while (-1 != read){
                try {
                    read = socketChannel.read(byteBuffer);
                }catch (Exception e){
                   break;
                }
                byteBuffer.rewind();//倒带 position = 0；
            }
        }
    }
}
