package Netty.Tcp粘包拆包.TcpPack;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Yu
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //得到管道向管道加入处理器
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new NettyClientHandler());
    }
}
