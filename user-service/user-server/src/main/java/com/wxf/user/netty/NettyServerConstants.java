package com.wxf.user.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wxf
 * @since 2023-10-27 21:50:34
 **/
public interface NettyServerConstants {
    Map<ChannelId, ChannelHandlerContext> CONTEXT_MAP = new ConcurrentHashMap<>();

}
