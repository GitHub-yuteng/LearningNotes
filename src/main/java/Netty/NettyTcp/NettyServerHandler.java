package Netty.NettyTcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author Yu
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //读取数据(读取客户端发送的消息)

    /**
     * @param ctx 上下文对象，含有 管道pipeline，通道Channel，地址
     * @param msg 客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程：" + Thread.currentThread().getName());
        System.out.println("ChannelHandlerContext：" + ctx);
        //将 msg 转为 ByteBuf -> netty 提供的
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发送信息：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址：" + ctx.channel().remoteAddress());

        //任务队列中的Task有3种典型使用场景  3、做个集合管理，找到对应用户把任务提交到对应的 Channel -> EventLoop TaskQueue
        //1、用户程序自定义的普通任务
        //耗时操作，异步执行处理 -> 提交该 Channel 对应的 NIOEventLoop 的 taskQueue 中
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Async eventLoop 发生异常...");
            }
            ctx.writeAndFlush(Unpooled.copiedBuffer("TaskQueue1 Hello...", CharsetUtil.UTF_8));
        });

        //TaskQueue 同一个线程，这个还需要阻塞 5s
        ctx.channel().eventLoop().execute(() -> {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Async eventLoop 发生异常...");
            }
            ctx.writeAndFlush(Unpooled.copiedBuffer("TaskQueue2 Hello...", CharsetUtil.UTF_8));
        });


        //2、用户自定义定时任务 -> 提交到 scheduleTaskQueue 中 ，继续阻塞 20s
        ctx.channel().eventLoop().schedule(() -> {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Async eventLoop 发生异常...");
            }
            ctx.writeAndFlush(Unpooled.copiedBuffer("ScheduleTaskQueue Hello...", CharsetUtil.UTF_8));
        }, 20, TimeUnit.SECONDS);


        System.out.println("go on...");
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //将数据写入到缓存，并刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("NettyClient Hello...", CharsetUtil.UTF_8));
    }

    //处理异常，一般发生异常需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
