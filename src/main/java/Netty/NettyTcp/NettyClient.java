package Netty.NettyTcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Yu
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {

        //客户端需要一个事件循环组
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            //客户端启动对象
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)//设置线程组
                    .channel(NioSocketChannel.class)//设置客户端通道的实现类
                    .handler(new ChannelInitializer<SocketChannel>() {//创建一个通道的测试对象
                        //给 pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });//给 eventExecutors 的 EventLoop 对应的管道设置处理器

            System.out.println("NettyClient is ok...");

            //启动客户端去连接服务端
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
