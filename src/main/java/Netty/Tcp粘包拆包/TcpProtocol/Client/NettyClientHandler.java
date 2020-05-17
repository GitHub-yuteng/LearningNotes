package Netty.Tcp粘包拆包.TcpProtocol.Client;

import Netty.Tcp粘包拆包.TcpProtocol.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;


/**
 * @author Yu
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol message) throws Exception {
        int length = message.getLength();
        byte[] content = message.getContent();

        System.out.println("长度：" + length + " —> " + "内容：" + new String(content, CharsetUtil.UTF_8) + " " +
                "====> 服务器收到的消息次数：" + (++count));
    }

    /**
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        for (int i = 0; i < 5; i++) {
            String message = UUID.randomUUID().toString().substring(0, 8);
            byte[] content = message.getBytes(CharsetUtil.UTF_8);
            int length = content.length;
            //创建协议包
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setLength(length);
            messageProtocol.setContent(content);
            ctx.channel().writeAndFlush(messageProtocol);
            System.out.println("channelActive..." + (i + 1) + "==> " + message + "\n");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
