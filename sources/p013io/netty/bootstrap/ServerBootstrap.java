package p013io.netty.bootstrap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelInboundHandlerAdapter;
import p013io.netty.channel.ChannelInitializer;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.ChannelPipeline;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.channel.ServerChannel;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.bootstrap.ServerBootstrap */
/* loaded from: grasscutter.jar:io/netty/bootstrap/ServerBootstrap.class */
public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, ServerChannel> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ServerBootstrap.class);
    private final Map<ChannelOption<?>, Object> childOptions = new LinkedHashMap();
    private final Map<AttributeKey<?>, Object> childAttrs = new ConcurrentHashMap();
    private final ServerBootstrapConfig config = new ServerBootstrapConfig(this);
    private volatile EventLoopGroup childGroup;
    private volatile ChannelHandler childHandler;

    public ServerBootstrap() {
    }

    private ServerBootstrap(ServerBootstrap bootstrap) {
        super(bootstrap);
        this.childGroup = bootstrap.childGroup;
        this.childHandler = bootstrap.childHandler;
        synchronized (bootstrap.childOptions) {
            this.childOptions.putAll(bootstrap.childOptions);
        }
        this.childAttrs.putAll(bootstrap.childAttrs);
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap group(EventLoopGroup group) {
        return group(group, group);
    }

    public ServerBootstrap group(EventLoopGroup parentGroup, EventLoopGroup childGroup) {
        group(parentGroup);
        if (this.childGroup != null) {
            throw new IllegalStateException("childGroup set already");
        }
        this.childGroup = (EventLoopGroup) ObjectUtil.checkNotNull(childGroup, "childGroup");
        return this;
    }

    public <T> ServerBootstrap childOption(ChannelOption<T> childOption, T value) {
        ObjectUtil.checkNotNull(childOption, "childOption");
        synchronized (this.childOptions) {
            if (value == null) {
                this.childOptions.remove(childOption);
            } else {
                this.childOptions.put(childOption, value);
            }
        }
        return this;
    }

    public <T> ServerBootstrap childAttr(AttributeKey<T> childKey, T value) {
        ObjectUtil.checkNotNull(childKey, "childKey");
        if (value == null) {
            this.childAttrs.remove(childKey);
        } else {
            this.childAttrs.put(childKey, value);
        }
        return this;
    }

    public ServerBootstrap childHandler(ChannelHandler childHandler) {
        this.childHandler = (ChannelHandler) ObjectUtil.checkNotNull(childHandler, "childHandler");
        return this;
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) {
        setChannelOptions(channel, newOptionsArray(), logger);
        setAttributes(channel, newAttributesArray());
        ChannelPipeline p = channel.pipeline();
        final EventLoopGroup currentChildGroup = this.childGroup;
        final ChannelHandler currentChildHandler = this.childHandler;
        final Map.Entry<ChannelOption<?>, Object>[] currentChildOptions = newOptionsArray(this.childOptions);
        final Map.Entry<AttributeKey<?>, Object>[] currentChildAttrs = newAttributesArray(this.childAttrs);
        p.addLast(new ChannelInitializer<Channel>() { // from class: io.netty.bootstrap.ServerBootstrap.1
            @Override // p013io.netty.channel.ChannelInitializer
            public void initChannel(final Channel ch) {
                final ChannelPipeline pipeline = ch.pipeline();
                ChannelHandler handler = ServerBootstrap.this.config.handler();
                if (handler != null) {
                    pipeline.addLast(handler);
                }
                ch.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pipeline.addLast(new ServerBootstrapAcceptor(ch, currentChildGroup, currentChildHandler, currentChildOptions, currentChildAttrs));
                    }
                });
            }
        });
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap validate() {
        validate();
        if (this.childHandler == null) {
            throw new IllegalStateException("childHandler not set");
        }
        if (this.childGroup == null) {
            logger.warn("childGroup is not set. Using parentGroup instead.");
            this.childGroup = this.config.group();
        }
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.bootstrap.ServerBootstrap$ServerBootstrapAcceptor */
    /* loaded from: grasscutter.jar:io/netty/bootstrap/ServerBootstrap$ServerBootstrapAcceptor.class */
    public static class ServerBootstrapAcceptor extends ChannelInboundHandlerAdapter {
        private final EventLoopGroup childGroup;
        private final ChannelHandler childHandler;
        private final Map.Entry<ChannelOption<?>, Object>[] childOptions;
        private final Map.Entry<AttributeKey<?>, Object>[] childAttrs;
        private final Runnable enableAutoReadTask;

        ServerBootstrapAcceptor(final Channel channel, EventLoopGroup childGroup, ChannelHandler childHandler, Map.Entry<ChannelOption<?>, Object>[] childOptions, Map.Entry<AttributeKey<?>, Object>[] childAttrs) {
            this.childGroup = childGroup;
            this.childHandler = childHandler;
            this.childOptions = childOptions;
            this.childAttrs = childAttrs;
            this.enableAutoReadTask = new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    channel.config().setAutoRead(true);
                }
            };
        }

        @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            final Channel child = (Channel) msg;
            child.pipeline().addLast(this.childHandler);
            AbstractBootstrap.setChannelOptions(child, this.childOptions, ServerBootstrap.logger);
            AbstractBootstrap.setAttributes(child, this.childAttrs);
            try {
                this.childGroup.register(child).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.2
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (!future.isSuccess()) {
                            ServerBootstrapAcceptor.forceClose(child, future.cause());
                        }
                    }
                });
            } catch (Throwable t) {
                forceClose(child, t);
            }
        }

        /* access modifiers changed from: private */
        public static void forceClose(Channel child, Throwable t) {
            child.unsafe().closeForcibly();
            ServerBootstrap.logger.warn("Failed to register an accepted channel: {}", child, t);
        }

        @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ChannelConfig config = ctx.channel().config();
            if (config.isAutoRead()) {
                config.setAutoRead(false);
                ctx.channel().eventLoop().schedule(this.enableAutoReadTask, 1L, TimeUnit.SECONDS);
            }
            ctx.fireExceptionCaught(cause);
        }
    }

    @Override // p013io.netty.bootstrap.AbstractBootstrap, java.lang.Object
    public ServerBootstrap clone() {
        return new ServerBootstrap(this);
    }

    @Deprecated
    public EventLoopGroup childGroup() {
        return this.childGroup;
    }

    /* access modifiers changed from: package-private */
    public final ChannelHandler childHandler() {
        return this.childHandler;
    }

    /* access modifiers changed from: package-private */
    public final Map<ChannelOption<?>, Object> childOptions() {
        Map<ChannelOption<?>, Object> copiedMap;
        synchronized (this.childOptions) {
            copiedMap = copiedMap(this.childOptions);
        }
        return copiedMap;
    }

    /* access modifiers changed from: package-private */
    public final Map<AttributeKey<?>, Object> childAttrs() {
        return copiedMap(this.childAttrs);
    }

    /* Return type fixed from 'io.netty.bootstrap.ServerBootstrapConfig' to match base method */
    @Override // p013io.netty.bootstrap.AbstractBootstrap
    public final AbstractBootstrapConfig<ServerBootstrap, ServerChannel> config() {
        return this.config;
    }
}
