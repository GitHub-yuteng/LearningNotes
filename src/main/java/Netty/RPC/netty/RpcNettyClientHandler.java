package Netty.RPC.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author Yu
 */
public class RpcNettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    private String param;//客户端调用方法时传入的参数
    private String result;//返回的结果

    /**
     * 与服务器连接创建后，就会被调用
     *
     * @param ctx
     * @throws Exception (1)
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClientHandler channelActive");
        context = ctx;//因为会在call方法使用ctx
    }

    //收到服务器数据调用方法(4)
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("NettyClientHandler channelRead...");
        result = msg.toString();
        notify();//唤醒等待线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 被代理对象调用，发送数据给服务器，发送过后 -> wait -> 等待被唤醒
     *
     * @return
     * @throws Exception (3)_(5)
     */
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("NettyClientHandler call...1");
        context.writeAndFlush(param);
        wait();//等待channelRead获取到返回结果唤醒
        System.out.println("NettyClientHandler call...2");
        return result;//服务方返回的数据
    }

    //(2)
    public void setParam(String param) {
        System.out.println("NettyClientHandler setParam");
        this.param = param;
    }
}
