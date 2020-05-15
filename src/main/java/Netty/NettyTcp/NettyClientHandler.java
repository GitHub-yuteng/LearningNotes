package Netty.NettyTcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author Yu
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    //当通道就绪就会触发该方法
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClient：" + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("NettyServer Hello...", CharsetUtil.UTF_8));
    }

    //当通道有读取事件时触发
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //将 msg 转为 ByteBuf -> netty 提供的
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务端回复信息：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("服务端地址：" + ctx.channel().remoteAddress());
    }

    //处理异常，一般发生异常需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
