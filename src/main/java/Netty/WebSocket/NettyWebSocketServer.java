package Netty.WebSocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author Yu
 */
public class NettyWebSocketServer {

    private int port;

    public NettyWebSocketServer(int port) {
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
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道的初始对象
                        //给 pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //基于Http协议，使用Http编码解码器
                            pipeline.addLast(new HttpServerCodec());//向 pipeline 加入解码器
                            //以块的方式写，添加 ChunkedWriteHandler 处理器
                            pipeline.addLast(new ChunkedWriteHandler());
                            //添加 HttpObjectAggregator 处理器
                            // Http在传输过程中是分段的，HttpObjectAggregator 将多个段聚合起来
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            //对于WebSocket是以帧的形式传输 frame 形式传递
                            /**
                             * WebSocketFrame 六个子类
                             * 浏览器请求时候  ws://localhost:7000/xxx  表示请求的uri
                             * WebSocketServerProtocolHandler 核心功能 将HTTP协议升级为 WS：WebSocket
                             *
                             * 通过 101 状态码 切换
                             * Request URL: ws://127.0.0.1:7000/web
                             * Request Method: GET
                             * Status Code: 101 Switching Protocols
                             * upgrade: websocket
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/web"));

                            //自定义Handler，出来业务逻辑
                            pipeline.addLast(new WebSocketFrameHandler());

                        }
                    });//给 WorkerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println("NettyWebSocketServer is ready...");

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
        NettyWebSocketServer server = new NettyWebSocketServer(7000);
        server.run();
    }
}
