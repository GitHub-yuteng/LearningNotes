package Netty.NettyTcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Date;

/**
 * @author Yu
 */
public class NettyTcpServer {
    public static void main(String[] args) throws InterruptedException {

        int port = 6668;

        //创建 BossGroup 和 WorkerGroup
        //说明
        // BossGroup 只是处理链接请求，真正的和客户端业务处理会交给 WorkerGroup 完成
        // 两个都是无限循环
        // BossGroup 和 WorkerGroup 含有子线程 NioEventLoop 的个数，默认实际为 cpu核数 * 2
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器端的启动对象，配置参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)//使用 NioSocketChannel 作为服务器通道的实现类
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列得到连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道的初始对象
                        //给 pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });//给 WorkerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println("NettyServer is ready...");

            //启动服务器 绑定端口同步处理
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();

            //给 channelFuture 注册监听器 异步执行结果
            channelFuture.addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println(new Date() + " -> channelFuture 端口：" + port + " 绑定成功...");
                } else {
                    System.out.println("-> channelFuture 端口：" + port + " 绑定失败...");
                }
            });

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
