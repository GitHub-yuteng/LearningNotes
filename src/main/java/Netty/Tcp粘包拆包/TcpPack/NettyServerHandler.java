package Netty.Tcp粘包拆包.TcpPack;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;


/**
 * @author Yu
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        byte[] buffer = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(buffer);
        String message = new String(buffer, CharsetUtil.UTF_8);
        System.out.println(message);
        System.out.println("服务器收到的消息次数：" + (++count));

        ByteBuf copiedBuffer = Unpooled.copiedBuffer(UUID.randomUUID().toString().substring(0, 8) + " \n",
                CharsetUtil.UTF_8);
        channelHandlerContext.channel().writeAndFlush(copiedBuffer);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
