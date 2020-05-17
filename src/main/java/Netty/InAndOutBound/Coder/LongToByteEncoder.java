package Netty.InAndOutBound.Coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Yu
 */
public class LongToByteEncoder extends MessageToByteEncoder<Long> {

    /**
     * @param channelHandlerContext
     * @param aLong
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Long aLong, ByteBuf byteBuf) throws Exception {
        System.out.println("LongToByteEncoder... " + aLong);
        byteBuf.writeLong(aLong);
    }
}
