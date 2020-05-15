package Netty.NettyHttp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;


/**
 * @author Yu
 * HttpObject 客户端和服务端相互通讯的数据被封装成 HttpObject
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    //channelRead0 读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        if (httpObject instanceof HttpRequest) {
            System.out.println("=======================================");
            System.out.println("pipeline HashCode: " + channelHandlerContext.pipeline().hashCode() + " Handler HashCode: " + this.hashCode());

            //获取 HttpRequest 对象
            HttpRequest httpRequest = (HttpRequest) httpObject;
            //获取URI
            URI uri = new URI(httpRequest.uri());
            //对特定资源进行过滤
            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("请求了 /favicon.ico，不做响应...");
                return;
            }

            System.out.println("HttpObject 类型：" + httpObject.getClass());
            System.out.println("客户端地址：" + channelHandlerContext.channel().remoteAddress());

            //回复信息给浏览器  [http 协议]
            ByteBuf content = Unpooled.copiedBuffer("服务 NettyHttpServer...", CharsetUtil.UTF_8);

            //构造一个http的响应，即httpResponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK, content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            //将构建好 response 返回
            channelHandlerContext.writeAndFlush(response);

        }
    }
}
