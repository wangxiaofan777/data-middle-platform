package com.wxf.user.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 消息解码器
 *
 * @author Wxf
 * @since 2023-10-27 21:59:55
 **/
public class SocketChooseHandler extends ByteToMessageDecoder {

    // 默认暗号长度23
    private static final int MAX_LENGTH = 23;
    // Websocket握手协议前缀
    private static final String WEBSOCKET_PREFIX = "GET /";


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    }

    private String getBufStart(ByteBuf in) {
        int length = in.readableBytes();
        if (length > MAX_LENGTH) {
            length = MAX_LENGTH;
        }
        // 标记读位置
        in.markReaderIndex();
        byte[] content = new byte[length];
        in.readBytes(content);
        return new String(content);
    }
}
