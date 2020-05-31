package Netty.RPC.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author Yu
 */
public class RpcNettyServer {

    public static void startServer(String host, int port) throws Exception {
        startServer0(host, port);
    }

    private static void startServer0(String host, int port) throws Exception {
        //创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器端的启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)//使用 NioSocketChannel 作为服务器通道的实现类
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道的初始对象
                        //给 pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("StringDecoder", new StringDecoder());//向 pipeline 加入解码器
                            pipeline.addLast("StringEncoder", new StringEncoder());//向 pipeline 加入编码器
                            pipeline.addLast(new RpcNettyServerHandler());
                        }
                    });//给 WorkerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println("RpcNettyServer Rpc is ready...");

            //启动服务器 绑定端口同步处理
            ChannelFuture channelFuture = serverBootstrap.bind(host, port).sync();
            //监听关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
