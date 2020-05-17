package Netty.Tcp粘包拆包.TcpProtocol.Server;

import Netty.Tcp粘包拆包.TcpProtocol.Coder.MessageDecoder;
import Netty.Tcp粘包拆包.TcpProtocol.Coder.MessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Yu
 */
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //得到管道向管道加入处理器
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new MessageEncoder());//编码器
        pipeline.addLast(new MessageDecoder());//解码器
        pipeline.addLast(new NettyServerHandler());
    }
}
