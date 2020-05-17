package Netty.NIO.NIOServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

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
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        // 4. 获取选择器
        Selector selector = Selector.open();//WindowsSelectorImpl

        // 5. 将通道注册到选择器上, 并且指定“监听接收事件”
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 6. 轮询式的获取选择器上已经“准备就绪”的事件
        while (true) {

            if (selector.select(10000) == 0) {
                System.out.println("服务器等待10s，无连接...");
                continue;
            }

            // 7. 获取当前选择器中所有注册的“选择键(已就绪的监听事件)”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                // 8. 获取准备“就绪”的事件
                SelectionKey selectionKey = iterator.next();

                // 9. 判断具体是什么事件准备就绪
                if (selectionKey.isAcceptable()) {
                    // 10. 若“接收就绪”，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    // 11. 切换非阻塞模式
                    socketChannel.configureBlocking(false);

                    // 12. 将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (selectionKey.isReadable()) {
                    // 13. 获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    // 14. 获取关联的Buffer
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();

                    int len = 0;
                    while ((len = socketChannel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        System.out.println("客户端：" + socketChannel.getRemoteAddress() + " " +
                                new String(byteBuffer.array(), 0, len));
                        byteBuffer.clear();
                    }
                }
                // 15. 取消选择键 SelectionKey
                iterator.remove();
            }
        }
    }
}
