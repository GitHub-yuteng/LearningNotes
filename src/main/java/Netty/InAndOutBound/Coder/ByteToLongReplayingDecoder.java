package Netty.InAndOutBound.Coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Yu
 */
public class ByteToLongReplayingDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("ByteToLongReplayingDecoder decode...");
        list.add(byteBuf.readLong());
    }
}
