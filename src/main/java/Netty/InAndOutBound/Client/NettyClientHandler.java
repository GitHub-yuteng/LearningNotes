package Netty.InAndOutBound.Client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Yu
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<Long> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {
        System.out.println("接收服务端：" + channelHandlerContext.channel().remoteAddress() + " -> " + aLong);
    }

    //当通道就绪就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClientHandler channelActive...");
        ctx.writeAndFlush(123456L);// 出站
    }
}
