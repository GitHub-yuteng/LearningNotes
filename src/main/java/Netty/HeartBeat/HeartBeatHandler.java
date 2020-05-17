package Netty.HeartBeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;


/**
 * @author Yu
 */
public class HeartBeatHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {


        if (evt instanceof IdleStateEvent) {
            //将 evt 向下 转型
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;

            String eventType = null;

            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    eventType = "READER_IDLE...";
//                    ctx.channel().writeAndFlush(eventType);
                    break;
                case WRITER_IDLE:
                    eventType = "WRITER_IDLE...";
                    ctx.channel().writeAndFlush(eventType);
                    break;
                case ALL_IDLE:
                    eventType = "ALL_IDLE...";
                    ctx.channel().writeAndFlush(eventType);
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + " --- TimeOut... " + eventType);
            //根据 IDLE 状态 做业务处理
            //如果发生空闲，关闭通道、就不会在触发空闲状态
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(s);
    }
}
