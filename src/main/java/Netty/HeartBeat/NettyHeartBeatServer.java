package Netty.HeartBeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author Yu
 */
public class NettyHeartBeatServer {

    private int port;

    public NettyHeartBeatServer(int port) {
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
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道的初始对象
                        //给 pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("StringDecoder", new StringDecoder());//向 pipeline 加入解码器
                            pipeline.addLast("StringEncoder", new StringEncoder());//向 pipeline 加入编码器
                            //加入一个 netty 提供的 IdelStateHandler
                            /**
                             * IdleStateHandler 空闲状态处理器，客户端异常终止，服务端不能感知
                             * readerIdleTime：多长时间没有读，发送一个心跳检测包检测是否连接
                             * writerIdleTime：多长时间没有写，发送一个心跳检测包检测是否连接
                             * allIdleTime：多长时间没有读写，发送一个心跳检测包检测是否连接
                             *
                             * 当 IdleStateHandler 触发后，就会传递给管道的下一个Handler处理
                             * 通过调用下一个 Handler 的 userEventTriggered
                             */
                            pipeline.addLast(new IdleStateHandler(5, 10, 30, TimeUnit.SECONDS));
                            //加入一个对空闲检测进一步处理的Handler
                            pipeline.addLast(new HeartBeatHandler());
                        }
                    });//给 WorkerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println("NettyHeartBeatServer is ready...");

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
        NettyHeartBeatServer server = new NettyHeartBeatServer(9999);
        server.run();
    }
}
