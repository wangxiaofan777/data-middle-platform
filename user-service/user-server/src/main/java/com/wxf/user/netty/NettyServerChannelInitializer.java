package com.wxf.user.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Wxf
 * @since 2023-10-27 21:36:17
 **/
@Slf4j
public class NettyServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        log.info("=========== 收到新连接 ==========");

        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast("active", new channela)
        pipeline.addLast("", new IdleStateHandler(60, 0, 0));



    }
}
