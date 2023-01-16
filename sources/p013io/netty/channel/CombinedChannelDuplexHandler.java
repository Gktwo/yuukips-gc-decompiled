package p013io.netty.channel;

import java.net.SocketAddress;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelInboundHandler;
import p013io.netty.channel.ChannelOutboundHandler;
import p013io.netty.util.Attribute;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.ThrowableUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.CombinedChannelDuplexHandler */
/* loaded from: grasscutter.jar:io/netty/channel/CombinedChannelDuplexHandler.class */
public class CombinedChannelDuplexHandler<I extends ChannelInboundHandler, O extends ChannelOutboundHandler> extends ChannelDuplexHandler {
    private static final InternalLogger logger;
    private DelegatingChannelHandlerContext inboundCtx;
    private DelegatingChannelHandlerContext outboundCtx;
    private volatile boolean handlerAdded;
    private I inboundHandler;
    private O outboundHandler;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !CombinedChannelDuplexHandler.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(CombinedChannelDuplexHandler.class);
    }

    protected CombinedChannelDuplexHandler() {
        ensureNotSharable();
    }

    public CombinedChannelDuplexHandler(I inboundHandler, O outboundHandler) {
        ensureNotSharable();
        init(inboundHandler, outboundHandler);
    }

    protected final void init(I inboundHandler, O outboundHandler) {
        validate(inboundHandler, outboundHandler);
        this.inboundHandler = inboundHandler;
        this.outboundHandler = outboundHandler;
    }

    private void validate(I inboundHandler, O outboundHandler) {
        if (this.inboundHandler != null) {
            throw new IllegalStateException("init() can not be invoked if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with non-default constructor.");
        }
        ObjectUtil.checkNotNull(inboundHandler, "inboundHandler");
        ObjectUtil.checkNotNull(outboundHandler, "outboundHandler");
        if (inboundHandler instanceof ChannelOutboundHandler) {
            throw new IllegalArgumentException("inboundHandler must not implement " + ChannelOutboundHandler.class.getSimpleName() + " to get combined.");
        } else if (outboundHandler instanceof ChannelInboundHandler) {
            throw new IllegalArgumentException("outboundHandler must not implement " + ChannelInboundHandler.class.getSimpleName() + " to get combined.");
        }
    }

    protected final I inboundHandler() {
        return this.inboundHandler;
    }

    protected final O outboundHandler() {
        return this.outboundHandler;
    }

    private void checkAdded() {
        if (!this.handlerAdded) {
            throw new IllegalStateException("handler not added to pipeline yet");
        }
    }

    public final void removeInboundHandler() {
        checkAdded();
        this.inboundCtx.remove();
    }

    public final void removeOutboundHandler() {
        checkAdded();
        this.outboundCtx.remove();
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        if (this.inboundHandler == null) {
            throw new IllegalStateException("init() must be invoked before being added to a " + ChannelPipeline.class.getSimpleName() + " if " + CombinedChannelDuplexHandler.class.getSimpleName() + " was constructed with the default constructor.");
        }
        this.outboundCtx = new DelegatingChannelHandlerContext(ctx, this.outboundHandler);
        this.inboundCtx = new DelegatingChannelHandlerContext(ctx, this.inboundHandler) { // from class: io.netty.channel.CombinedChannelDuplexHandler.1
            @Override // p013io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext, p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
            public ChannelHandlerContext fireExceptionCaught(Throwable cause) {
                if (!CombinedChannelDuplexHandler.this.outboundCtx.removed) {
                    try {
                        CombinedChannelDuplexHandler.this.outboundHandler.exceptionCaught(CombinedChannelDuplexHandler.this.outboundCtx, cause);
                    } catch (Throwable error) {
                        if (CombinedChannelDuplexHandler.logger.isDebugEnabled()) {
                            CombinedChannelDuplexHandler.logger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(error), cause);
                        } else if (CombinedChannelDuplexHandler.logger.isWarnEnabled()) {
                            CombinedChannelDuplexHandler.logger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", error, cause);
                        }
                    }
                } else {
                    fireExceptionCaught(cause);
                }
                return this;
            }
        };
        this.handlerAdded = true;
        try {
            this.inboundHandler.handlerAdded(this.inboundCtx);
        } finally {
            this.outboundHandler.handlerAdded(this.outboundCtx);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        try {
            this.inboundCtx.remove();
        } finally {
            this.outboundCtx.remove();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.channelRegistered(this.inboundCtx);
        } else {
            this.inboundCtx.fireChannelRegistered();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.channelUnregistered(this.inboundCtx);
        } else {
            this.inboundCtx.fireChannelUnregistered();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.channelActive(this.inboundCtx);
        } else {
            this.inboundCtx.fireChannelActive();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.channelInactive(this.inboundCtx);
        } else {
            this.inboundCtx.fireChannelInactive();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler, p013io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.exceptionCaught(this.inboundCtx, cause);
        } else {
            this.inboundCtx.fireExceptionCaught(cause);
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.userEventTriggered(this.inboundCtx, evt);
        } else {
            this.inboundCtx.fireUserEventTriggered(evt);
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.channelRead(this.inboundCtx, msg);
        } else {
            this.inboundCtx.fireChannelRead(msg);
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.channelReadComplete(this.inboundCtx);
        } else {
            this.inboundCtx.fireChannelReadComplete();
        }
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.inboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.inboundCtx.removed) {
            this.inboundHandler.channelWritabilityChanged(this.inboundCtx);
        } else {
            this.inboundCtx.fireChannelWritabilityChanged();
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.bind(this.outboundCtx, localAddress, promise);
        } else {
            this.outboundCtx.bind(localAddress, promise);
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.connect(this.outboundCtx, remoteAddress, localAddress, promise);
        } else {
            this.outboundCtx.connect(remoteAddress, localAddress, promise);
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.disconnect(this.outboundCtx, promise);
        } else {
            this.outboundCtx.disconnect(promise);
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.close(this.outboundCtx, promise);
        } else {
            this.outboundCtx.close(promise);
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.deregister(this.outboundCtx, promise);
        } else {
            this.outboundCtx.deregister(promise);
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.read(this.outboundCtx);
        } else {
            this.outboundCtx.read();
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.write(this.outboundCtx, msg, promise);
        } else {
            this.outboundCtx.write(msg, promise);
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext ctx) throws Exception {
        if (!$assertionsDisabled && ctx != this.outboundCtx.ctx) {
            throw new AssertionError();
        } else if (!this.outboundCtx.removed) {
            this.outboundHandler.flush(this.outboundCtx);
        } else {
            this.outboundCtx.flush();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext */
    /* loaded from: grasscutter.jar:io/netty/channel/CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.class */
    public static class DelegatingChannelHandlerContext implements ChannelHandlerContext {
        private final ChannelHandlerContext ctx;
        private final ChannelHandler handler;
        boolean removed;

        DelegatingChannelHandlerContext(ChannelHandlerContext ctx, ChannelHandler handler) {
            this.ctx = ctx;
            this.handler = handler;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public Channel channel() {
            return this.ctx.channel();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public EventExecutor executor() {
            return this.ctx.executor();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public String name() {
            return this.ctx.name();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public ChannelHandler handler() {
            return this.ctx.handler();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public boolean isRemoved() {
            return this.removed || this.ctx.isRemoved();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelRegistered() {
            this.ctx.fireChannelRegistered();
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelUnregistered() {
            this.ctx.fireChannelUnregistered();
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelActive() {
            this.ctx.fireChannelActive();
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelInactive() {
            this.ctx.fireChannelInactive();
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireExceptionCaught(Throwable cause) {
            this.ctx.fireExceptionCaught(cause);
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireUserEventTriggered(Object event) {
            this.ctx.fireUserEventTriggered(event);
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelRead(Object msg) {
            this.ctx.fireChannelRead(msg);
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelReadComplete() {
            this.ctx.fireChannelReadComplete();
            return this;
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
        public ChannelHandlerContext fireChannelWritabilityChanged() {
            this.ctx.fireChannelWritabilityChanged();
            return this;
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress localAddress) {
            return this.ctx.bind(localAddress);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress remoteAddress) {
            return this.ctx.connect(remoteAddress);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
            return this.ctx.connect(remoteAddress, localAddress);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect() {
            return this.ctx.disconnect();
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close() {
            return this.ctx.close();
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister() {
            return this.ctx.deregister();
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
            return this.ctx.bind(localAddress, promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
            return this.ctx.connect(remoteAddress, promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
            return this.ctx.connect(remoteAddress, localAddress, promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture disconnect(ChannelPromise promise) {
            return this.ctx.disconnect(promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture close(ChannelPromise promise) {
            return this.ctx.close(promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture deregister(ChannelPromise promise) {
            return this.ctx.deregister(promise);
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelOutboundInvoker
        public ChannelHandlerContext read() {
            this.ctx.read();
            return this;
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object msg) {
            return this.ctx.write(msg);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture write(Object msg, ChannelPromise promise) {
            return this.ctx.write(msg, promise);
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelOutboundInvoker
        public ChannelHandlerContext flush() {
            this.ctx.flush();
            return this;
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
            return this.ctx.writeAndFlush(msg, promise);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture writeAndFlush(Object msg) {
            return this.ctx.writeAndFlush(msg);
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public ChannelPipeline pipeline() {
            return this.ctx.pipeline();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext
        public ByteBufAllocator alloc() {
            return this.ctx.alloc();
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise newPromise() {
            return this.ctx.newPromise();
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelProgressivePromise newProgressivePromise() {
            return this.ctx.newProgressivePromise();
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newSucceededFuture() {
            return this.ctx.newSucceededFuture();
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelFuture newFailedFuture(Throwable cause) {
            return this.ctx.newFailedFuture(cause);
        }

        @Override // p013io.netty.channel.ChannelOutboundInvoker
        public ChannelPromise voidPromise() {
            return this.ctx.voidPromise();
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.util.AttributeMap
        public <T> Attribute<T> attr(AttributeKey<T> key) {
            return this.ctx.channel().attr(key);
        }

        @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.util.AttributeMap
        public <T> boolean hasAttr(AttributeKey<T> key) {
            return this.ctx.channel().hasAttr(key);
        }

        final void remove() {
            EventExecutor executor = executor();
            if (executor.inEventLoop()) {
                remove0();
            } else {
                executor.execute(new Runnable() { // from class: io.netty.channel.CombinedChannelDuplexHandler.DelegatingChannelHandlerContext.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelegatingChannelHandlerContext.this.remove0();
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void remove0() {
            if (!this.removed) {
                this.removed = true;
                try {
                    this.handler.handlerRemoved(this);
                } catch (Throwable cause) {
                    fireExceptionCaught((Throwable) new ChannelPipelineException(this.handler.getClass().getName() + ".handlerRemoved() has thrown an exception.", cause));
                }
            }
        }
    }
}
