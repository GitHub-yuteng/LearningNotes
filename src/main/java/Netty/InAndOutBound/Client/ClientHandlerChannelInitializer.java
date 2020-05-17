package Netty.InAndOutBound.Client;

import Netty.InAndOutBound.Coder.ByteToLongDecoder;
import Netty.InAndOutBound.Coder.LongToByteEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Yu
 */
public class ClientHandlerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();
        //加入一个出站的Handler编码器，对数据进行一个编码
        pipeline.addLast(new LongToByteEncoder());
        //加入一个入站的Handler解码器，对数据进行一个解码
        pipeline.addLast(new ByteToLongDecoder());
        //加入一个自定义Handler，处理业务
        pipeline.addLast(new NettyClientHandler());//出站时，逆序调用Handler
    }
}
