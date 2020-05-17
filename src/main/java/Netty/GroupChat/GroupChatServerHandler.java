package Netty.GroupChat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Yu
 */
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //定义一个Channel组，管理所有的Channel
    //GlobalEventExecutor.INSTANCE 全局事件执行器，单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 表示连接建立，一旦连接，第一个被执行
     * 将当前 Channel 加入到 ChannelGroup
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该用户聊天的信息，推送给其它在线的客户端
        //该方法会将 channelGroup 中所有的 channel 遍历，并发送消息，不需要自己遍历
        channelGroup.writeAndFlush(simpleDateFormat.format(new Date()) + " [客户端]:" + channel.remoteAddress() + " 加入聊天...\n");
        channelGroup.add(channel);
        System.out.println("handlerAdded 当前 ChannelGroup size: " + channelGroup.size());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //该方法会将 channelGroup 中所有的 channel 遍历，并发送消息，不需要自己遍历
        channelGroup.writeAndFlush(simpleDateFormat.format(new Date()) + " [客户端]:" + channel.remoteAddress() + " 离开.." +
                ".\n");
        System.out.println("handlerRemoved 当前 ChannelGroup size: " + channelGroup.size());
    }

    /**
     * 表示Channel处于活动状态
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(simpleDateFormat.format(new Date()) + " [用户]: " + channel.remoteAddress() + " 上线...\n");
    }

    /**
     * 表示Channel处于非活动状态
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(simpleDateFormat.format(new Date()) + " [用户]: " + channel.remoteAddress() + " 下线...\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        //获取到当前的Channel
        Channel channel = channelHandlerContext.channel();
        //遍历 channelGroup，根据不同的情况推送不同的消息
        System.out.println(channel.remoteAddress() + " Message: " + s);
        channelGroup.forEach(c -> {
            if (channel != c) {//不是当前的Channel
                c.writeAndFlush(simpleDateFormat.format(new Date()) + " [用户] " + channel.remoteAddress() + " 发送消息: " + s + "\n");
            } else {
                c.writeAndFlush(simpleDateFormat.format(new Date()) + " [本人] " + "消息: " + s + "\n");//回显自己的消息
            }
        });
    }

    /**
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
