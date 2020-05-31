package Netty.RPC.netty;

import Netty.RPC.consumer.RpcClientBootStrap;
import Netty.RPC.provider.RpcProvider;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Yu
 */
public class RpcNettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RpcNettyServerHandler channelActive...");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发送的消息，并调用服务
        System.out.println("客户端信息：" + msg.toString());
        //客户端在调用服务器的api 时，需要定义一个协议
        if (msg.toString().startsWith(RpcClientBootStrap.protocolName)) {
            String result = new RpcProvider().rpc(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        } else {
            ctx.writeAndFlush("error");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
