package Netty.NettyHttp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author Yu
 */
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //向管道加入处理器

        //得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        //加入一个 netty 提供的 httpServerCodec  codec -> [ coder & decoder]
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        //增加自定义Handler
        pipeline.addLast("NettyHttpServerHandler", new NettyHttpServerHandler());

    }
}
