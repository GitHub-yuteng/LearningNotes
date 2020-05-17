package Netty.Tcp粘包拆包.TcpProtocol.Server;

import Netty.Tcp粘包拆包.TcpProtocol.MessageProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;


/**
 * @author Yu
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count = 0;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol message) throws Exception {

        int length = message.getLength();
        byte[] content = (LocalDateTime.now().toString() + ": " + new String(message.getContent(), CharsetUtil.UTF_8)).getBytes(CharsetUtil.UTF_8);

        System.out.println("长度：" + length + " —> " + "内容：" + new String(content, CharsetUtil.UTF_8) + " " +
                "====> 服务器收到的消息次数：" + (++count));

        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLength(content.length);
        messageProtocol.setContent(content);

        channelHandlerContext.channel().writeAndFlush(messageProtocol);
        System.out.println();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
