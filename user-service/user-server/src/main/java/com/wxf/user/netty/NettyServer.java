package com.wxf.user.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Netty服务配置
 *
 * @author Wxf
 * @since 2023-10-27 20:43:19
 **/
@Slf4j
public class NettyServer {

    private final int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap sb = new ServerBootstrap();
            // 服务端接受连接的队列长度，如果队列已满，客户端连接将被拒绝
            sb.option(ChannelOption.SO_BACKLOG, 1024);
            // 快速复用端口
            sb.childOption(ChannelOption.SO_REUSEADDR, true);
            sb.childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000);
            // 子处理器处理客户端连接的请求和数据
            sb.childOption(ChannelOption.TCP_NODELAY, true);
            // 保持长连接，2小时无数据激活心跳机制
            sb.childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定线程池
            sb.group(bossGroup, workerGroup)
                    // 指定使用的channel  通过TCP/IP进行传输
                    .channel(NioServerSocketChannel.class)
                    // 绑定监听端口
                    .localAddress(this.port)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            log.info("=========== 收到新连接 ==========");

                            // websocket协议本身属于http协议，所以这边也要使用http解编码器
                            ch.pipeline().addLast(new HttpServerCodec());
                            // 以块的形式来写的处理器
                            ch.pipeline().addLast(new ChunkedWriteHandler());
                            ch.pipeline().addLast(new HttpObjectAggregator(8192));
                            ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws", "WebSocket", true, 65535 * 10));


                        }
                    });
            // 服务器异步创建绑定
            ChannelFuture future = sb.bind().sync();
            future.addListener(listener -> {
                if (listener.isSuccess()) {
                    log.info("NettyServer start successful");
                } else {
                    log.info("NettyServer start failed...");
                }
            });
            // 关闭服务通道
            future.channel().closeFuture();
        } catch (InterruptedException e) {
            log.error("NettyServer start failed...", e);
        } finally {
            // 释放线程池资源
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully().sync();
        }

    }
}
