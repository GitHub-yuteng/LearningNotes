package Netty.InAndOutBound.Coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Yu
 */
public class ByteToLongDecoder extends ByteToMessageDecoder {

    /**
     * @param channelHandlerContext
     * @param byteBuf               入站 ByteBuf
     * @param list                  list集合，将解码后的数据传给下一个handler
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println("ByteToLongDecoder decode...");
        //long 8个字节,要有8个字节才能读取到一个long
        if (byteBuf.readableBytes() >= 8) {
            list.add(byteBuf.readLong());
        }
    }
}
