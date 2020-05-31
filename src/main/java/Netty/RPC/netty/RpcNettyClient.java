package Netty.RPC.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yu
 */
public class RpcNettyClient {

    //创建线程池
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static RpcNettyClientHandler clientHandler;

    public Object getBean(final Class<?> serivceClass, final String protocolName) {

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serivceClass}, (proxy, method, args) -> {
                    if (clientHandler == null) {
                        initClient();
                    }
                    //设置要发给服务器端的信息
                    clientHandler.setParam(protocolName + args[0]);
                    return executor.submit(clientHandler).get();
                });
    }

    //初始化客户端
    private static void initClient() {

        clientHandler = new RpcNettyClientHandler();
        //创建EventLoopGroup
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        //客户端启动对象
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)//设置线程组
                .channel(NioSocketChannel.class)//设置客户端通道的实现类
                .option(ChannelOption.TCP_NODELAY, true)//无延时
                .handler(new ChannelInitializer<SocketChannel>() {//创建一个通道的测试对象
                    //给 pipeline 设置处理器
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast("StringDecoder", new StringDecoder());//向 pipeline 加入解码器
                        pipeline.addLast("StringEncoder", new StringEncoder());//向 pipeline 加入编码器s
                        pipeline.addLast(clientHandler);
                    }
                });//给 eventExecutors 的 EventLoop 对应的管道设置处理器

        System.out.println("NettyClient Rpc is ok...");

        try {
            //启动客户端去连接服务端
            bootstrap.connect("127.0.0.1", 7000).sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
