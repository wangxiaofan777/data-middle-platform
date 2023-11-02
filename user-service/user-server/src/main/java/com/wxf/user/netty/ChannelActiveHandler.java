package com.wxf.user.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

import static com.wxf.user.netty.NettyServerConstants.CONTEXT_MAP;

/**
 * 客户端新建处理器
 *
 * @author Wxf
 * @since 2023-10-27 21:39:52
 **/
@Slf4j
@ChannelHandler.Sharable
public class ChannelActiveHandler extends ChannelInboundHandlerAdapter {

    // 有客户端连接都会出发此函数
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 获取客户端远程地址
        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        // 客户端IP
        String clientIp = inetSocketAddress.getAddress().getHostAddress();
        // 客户端端口
        int clientPort = inetSocketAddress.getPort();

        ChannelId channelId = ctx.channel().id();

        if (CONTEXT_MAP.containsKey(channelId)) {
            log.info("Socket Client [{}] is connected, now connected size is: [{}] ...", channelId, CONTEXT_MAP.size());
        } else {
            log.info("Socket Client [{}] is connecting [{}], port: [{}]", channelId, clientIp, clientIp);
            CONTEXT_MAP.put(channelId, ctx);
        }


    }
}
