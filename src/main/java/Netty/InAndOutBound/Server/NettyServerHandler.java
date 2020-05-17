package Netty.InAndOutBound.Server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Yu
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {
        System.out.println("接收客户端：" + channelHandlerContext.channel().remoteAddress() + " -> " + aLong);
        //给客户端发送数据
        channelHandlerContext.writeAndFlush(98765L);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
