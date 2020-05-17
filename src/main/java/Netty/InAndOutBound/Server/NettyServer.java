package Netty.InAndOutBound.Server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author Yu
 */
public class NettyServer{

    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    //编写一个run方法，处理客户端的请求
    public void run() throws Exception {

        //创建两个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器端的启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)//使用 NioSocketChannel 作为服务器通道的实现类
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列得到连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new LoggingHandler(LogLevel.INFO))//为 bossGroup 增加一个日志处理器
                    .childHandler(new ServerHandlerChannelInitializer());//给 WorkerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println("NettyServer is ready...");

            //启动服务器 绑定端口同步处理
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //监听关闭
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        NettyServer server = new NettyServer(9999);
        server.run();
    }
}
