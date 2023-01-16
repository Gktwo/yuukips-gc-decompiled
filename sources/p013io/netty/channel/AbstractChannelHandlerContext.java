package p013io.netty.channel;

import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.AbstractChannel;
import p013io.netty.util.Attribute;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.ResourceLeakHint;
import p013io.netty.util.concurrent.AbstractEventExecutor;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.OrderedEventExecutor;
import p013io.netty.util.internal.ObjectPool;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PromiseNotificationUtil;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.ThrowableUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.AbstractChannelHandlerContext */
/* loaded from: grasscutter.jar:io/netty/channel/AbstractChannelHandlerContext.class */
public abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    private static final InternalLogger logger;
    volatile AbstractChannelHandlerContext next;
    volatile AbstractChannelHandlerContext prev;
    private static final AtomicIntegerFieldUpdater<AbstractChannelHandlerContext> HANDLER_STATE_UPDATER;
    private static final int ADD_PENDING = 1;
    private static final int ADD_COMPLETE = 2;
    private static final int REMOVE_COMPLETE = 3;
    private static final int INIT = 0;
    private final DefaultChannelPipeline pipeline;
    private final String name;
    private final boolean ordered;
    private final int executionMask;
    final EventExecutor executor;
    private ChannelFuture succeededFuture;
    private Tasks invokeTasks;
    private volatile int handlerState = 0;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !AbstractChannelHandlerContext.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(AbstractChannelHandlerContext.class);
        HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractChannelHandlerContext.class, "handlerState");
    }

    /* access modifiers changed from: package-private */
    public AbstractChannelHandlerContext(DefaultChannelPipeline pipeline, EventExecutor executor, String name, Class<? extends ChannelHandler> handlerClass) {
        this.name = (String) ObjectUtil.checkNotNull(name, "name");
        this.pipeline = pipeline;
        this.executor = executor;
        this.executionMask = ChannelHandlerMask.mask(handlerClass);
        this.ordered = executor == null || (executor instanceof OrderedEventExecutor);
    }

    @Override // p013io.netty.channel.ChannelHandlerContext
    public Channel channel() {
        return this.pipeline.channel();
    }

    @Override // p013io.netty.channel.ChannelHandlerContext
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // p013io.netty.channel.ChannelHandlerContext
    public ByteBufAllocator alloc() {
        return channel().config().getAllocator();
    }

    @Override // p013io.netty.channel.ChannelHandlerContext
    public EventExecutor executor() {
        if (this.executor == null) {
            return channel().eventLoop();
        }
        return this.executor;
    }

    @Override // p013io.netty.channel.ChannelHandlerContext
    public String name() {
        return this.name;
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRegistered() {
        invokeChannelRegistered(findContextInbound(2));
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeChannelRegistered(AbstractChannelHandlerContext next) {
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeChannelRegistered();
        } else {
            executor.execute(new Runnable(next) { // from class: io.netty.channel.AbstractChannelHandlerContext.1
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$next.invokeChannelRegistered();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelRegistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRegistered(this);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireChannelRegistered();
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelUnregistered() {
        invokeChannelUnregistered(findContextInbound(4));
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeChannelUnregistered(AbstractChannelHandlerContext next) {
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeChannelUnregistered();
        } else {
            executor.execute(new Runnable(next) { // from class: io.netty.channel.AbstractChannelHandlerContext.2
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$next.invokeChannelUnregistered();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelUnregistered() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelUnregistered(this);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireChannelUnregistered();
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelActive() {
        invokeChannelActive(findContextInbound(8));
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeChannelActive(AbstractChannelHandlerContext next) {
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeChannelActive();
        } else {
            executor.execute(new Runnable(next) { // from class: io.netty.channel.AbstractChannelHandlerContext.3
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$next.invokeChannelActive();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelActive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelActive(this);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireChannelActive();
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelInactive() {
        invokeChannelInactive(findContextInbound(16));
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeChannelInactive(AbstractChannelHandlerContext next) {
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeChannelInactive();
        } else {
            executor.execute(new Runnable(next) { // from class: io.netty.channel.AbstractChannelHandlerContext.4
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$next.invokeChannelInactive();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelInactive() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelInactive(this);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireChannelInactive();
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireExceptionCaught(Throwable cause) {
        invokeExceptionCaught(findContextInbound(1), cause);
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeExceptionCaught(AbstractChannelHandlerContext next, final Throwable cause) {
        ObjectUtil.checkNotNull(cause, "cause");
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeExceptionCaught(cause);
            return;
        }
        try {
            executor.execute(new Runnable(next) { // from class: io.netty.channel.AbstractChannelHandlerContext.5
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$next.invokeExceptionCaught(cause);
                }
            });
        } catch (Throwable t) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to submit an exceptionCaught() event.", t);
                logger.warn("The exceptionCaught() event that was failed to submit was:", cause);
            }
        }
    }

    /* access modifiers changed from: private */
    public void invokeExceptionCaught(Throwable cause) {
        if (invokeHandler()) {
            try {
                handler().exceptionCaught(this, cause);
            } catch (Throwable error) {
                if (logger.isDebugEnabled()) {
                    logger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(error), cause);
                } else if (logger.isWarnEnabled()) {
                    logger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", error, cause);
                }
            }
        } else {
            fireExceptionCaught(cause);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireUserEventTriggered(Object event) {
        invokeUserEventTriggered(findContextInbound(128), event);
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeUserEventTriggered(AbstractChannelHandlerContext next, final Object event) {
        ObjectUtil.checkNotNull(event, "event");
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeUserEventTriggered(event);
        } else {
            executor.execute(new Runnable(next) { // from class: io.netty.channel.AbstractChannelHandlerContext.6
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$next.invokeUserEventTriggered(event);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void invokeUserEventTriggered(Object event) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).userEventTriggered(this, event);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireUserEventTriggered(event);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRead(Object msg) {
        invokeChannelRead(findContextInbound(32), msg);
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeChannelRead(AbstractChannelHandlerContext next, Object msg) {
        final Object m = next.pipeline.touch(ObjectUtil.checkNotNull(msg, "msg"), next);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeChannelRead(m);
        } else {
            executor.execute(new Runnable(next) { // from class: io.netty.channel.AbstractChannelHandlerContext.7
                final /* synthetic */ AbstractChannelHandlerContext val$next;

                {
                    this.val$next = r4;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.val$next.invokeChannelRead(m);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void invokeChannelRead(Object msg) {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelRead(this, msg);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireChannelRead(msg);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelReadComplete() {
        invokeChannelReadComplete(findContextInbound(64));
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeChannelReadComplete(AbstractChannelHandlerContext next) {
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeChannelReadComplete();
            return;
        }
        Tasks tasks = next.invokeTasks;
        if (tasks == null) {
            Tasks tasks2 = new Tasks(next);
            tasks = tasks2;
            next.invokeTasks = tasks2;
        }
        executor.execute(tasks.invokeChannelReadCompleteTask);
    }

    /* access modifiers changed from: private */
    public void invokeChannelReadComplete() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelReadComplete(this);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireChannelReadComplete();
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        invokeChannelWritabilityChanged(findContextInbound(256));
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext next) {
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeChannelWritabilityChanged();
            return;
        }
        Tasks tasks = next.invokeTasks;
        if (tasks == null) {
            Tasks tasks2 = new Tasks(next);
            tasks = tasks2;
            next.invokeTasks = tasks2;
        }
        executor.execute(tasks.invokeChannelWritableStateChangedTask);
    }

    /* access modifiers changed from: private */
    public void invokeChannelWritabilityChanged() {
        if (invokeHandler()) {
            try {
                ((ChannelInboundHandler) handler()).channelWritabilityChanged(this);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            fireChannelWritabilityChanged();
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress localAddress) {
        return bind(localAddress, newPromise());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress remoteAddress) {
        return connect(remoteAddress, newPromise());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
        return connect(remoteAddress, localAddress, newPromise());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return close(newPromise());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return deregister(newPromise());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(final SocketAddress localAddress, final ChannelPromise promise) {
        ObjectUtil.checkNotNull(localAddress, "localAddress");
        if (isNotValidPromise(promise, false)) {
            return promise;
        }
        final AbstractChannelHandlerContext next = findContextOutbound(512);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeBind(localAddress, promise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.8
                @Override // java.lang.Runnable
                public void run() {
                    next.invokeBind(localAddress, promise);
                }
            }, promise, null, false);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void invokeBind(SocketAddress localAddress, ChannelPromise promise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).bind(this, localAddress, promise);
            } catch (Throwable t) {
                notifyOutboundHandlerException(t, promise);
            }
        } else {
            bind(localAddress, promise);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
        return connect(remoteAddress, null, promise);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(final SocketAddress remoteAddress, final SocketAddress localAddress, final ChannelPromise promise) {
        ObjectUtil.checkNotNull(remoteAddress, "remoteAddress");
        if (isNotValidPromise(promise, false)) {
            return promise;
        }
        final AbstractChannelHandlerContext next = findContextOutbound(1024);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeConnect(remoteAddress, localAddress, promise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.9
                @Override // java.lang.Runnable
                public void run() {
                    next.invokeConnect(remoteAddress, localAddress, promise);
                }
            }, promise, null, false);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void invokeConnect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).connect(this, remoteAddress, localAddress, promise);
            } catch (Throwable t) {
                notifyOutboundHandlerException(t, promise);
            }
        } else {
            connect(remoteAddress, localAddress, promise);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(final ChannelPromise promise) {
        if (!channel().metadata().hasDisconnect()) {
            return close(promise);
        }
        if (isNotValidPromise(promise, false)) {
            return promise;
        }
        final AbstractChannelHandlerContext next = findContextOutbound(2048);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeDisconnect(promise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.10
                @Override // java.lang.Runnable
                public void run() {
                    next.invokeDisconnect(promise);
                }
            }, promise, null, false);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void invokeDisconnect(ChannelPromise promise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).disconnect(this, promise);
            } catch (Throwable t) {
                notifyOutboundHandlerException(t, promise);
            }
        } else {
            disconnect(promise);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(final ChannelPromise promise) {
        if (isNotValidPromise(promise, false)) {
            return promise;
        }
        final AbstractChannelHandlerContext next = findContextOutbound(4096);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeClose(promise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.11
                @Override // java.lang.Runnable
                public void run() {
                    next.invokeClose(promise);
                }
            }, promise, null, false);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void invokeClose(ChannelPromise promise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).close(this, promise);
            } catch (Throwable t) {
                notifyOutboundHandlerException(t, promise);
            }
        } else {
            close(promise);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(final ChannelPromise promise) {
        if (isNotValidPromise(promise, false)) {
            return promise;
        }
        final AbstractChannelHandlerContext next = findContextOutbound(8192);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeDeregister(promise);
        } else {
            safeExecute(executor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.12
                @Override // java.lang.Runnable
                public void run() {
                    next.invokeDeregister(promise);
                }
            }, promise, null, false);
        }
        return promise;
    }

    /* access modifiers changed from: private */
    public void invokeDeregister(ChannelPromise promise) {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).deregister(this, promise);
            } catch (Throwable t) {
                notifyOutboundHandlerException(t, promise);
            }
        } else {
            deregister(promise);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext next = findContextOutbound(16384);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeRead();
        } else {
            Tasks tasks = next.invokeTasks;
            if (tasks == null) {
                Tasks tasks2 = new Tasks(next);
                tasks = tasks2;
                next.invokeTasks = tasks2;
            }
            executor.execute(tasks.invokeReadTask);
        }
        return this;
    }

    /* access modifiers changed from: private */
    public void invokeRead() {
        if (invokeHandler()) {
            try {
                ((ChannelOutboundHandler) handler()).read(this);
            } catch (Throwable t) {
                invokeExceptionCaught(t);
            }
        } else {
            read();
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object msg) {
        return write(msg, newPromise());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object msg, ChannelPromise promise) {
        write(msg, false, promise);
        return promise;
    }

    void invokeWrite(Object msg, ChannelPromise promise) {
        if (invokeHandler()) {
            invokeWrite0(msg, promise);
        } else {
            write(msg, promise);
        }
    }

    private void invokeWrite0(Object msg, ChannelPromise promise) {
        try {
            ((ChannelOutboundHandler) handler()).write(this, msg, promise);
        } catch (Throwable t) {
            notifyOutboundHandlerException(t, promise);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext next = findContextOutbound(65536);
        EventExecutor executor = next.executor();
        if (executor.inEventLoop()) {
            next.invokeFlush();
        } else {
            Tasks tasks = next.invokeTasks;
            if (tasks == null) {
                Tasks tasks2 = new Tasks(next);
                tasks = tasks2;
                next.invokeTasks = tasks2;
            }
            safeExecute(executor, tasks.invokeFlushTask, channel().voidPromise(), null, false);
        }
        return this;
    }

    /* access modifiers changed from: private */
    public void invokeFlush() {
        if (invokeHandler()) {
            invokeFlush0();
        } else {
            flush();
        }
    }

    private void invokeFlush0() {
        try {
            ((ChannelOutboundHandler) handler()).flush(this);
        } catch (Throwable t) {
            invokeExceptionCaught(t);
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
        write(msg, true, promise);
        return promise;
    }

    void invokeWriteAndFlush(Object msg, ChannelPromise promise) {
        if (invokeHandler()) {
            invokeWrite0(msg, promise);
            invokeFlush0();
            return;
        }
        writeAndFlush(msg, promise);
    }

    private void write(Object msg, boolean flush, ChannelPromise promise) {
        ObjectUtil.checkNotNull(msg, "msg");
        try {
            if (isNotValidPromise(promise, true)) {
                ReferenceCountUtil.release(msg);
                return;
            }
            AbstractChannelHandlerContext next = findContextOutbound(flush ? 98304 : 32768);
            Object m = this.pipeline.touch(msg, next);
            EventExecutor executor = next.executor();
            if (!executor.inEventLoop()) {
                WriteTask task = WriteTask.newInstance(next, m, promise, flush);
                if (!safeExecute(executor, task, promise, m, !flush)) {
                    task.cancel();
                }
            } else if (flush) {
                next.invokeWriteAndFlush(m, promise);
            } else {
                next.invokeWrite(m, promise);
            }
        } catch (RuntimeException e) {
            ReferenceCountUtil.release(msg);
            throw e;
        }
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object msg) {
        return writeAndFlush(msg, newPromise());
    }

    private static void notifyOutboundHandlerException(Throwable cause, ChannelPromise promise) {
        PromiseNotificationUtil.tryFailure(promise, cause, promise instanceof VoidChannelPromise ? null : logger);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(channel(), executor());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(channel(), executor());
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        ChannelFuture succeededFuture = this.succeededFuture;
        if (succeededFuture == null) {
            ChannelFuture succeededChannelFuture = new SucceededChannelFuture(channel(), executor());
            succeededFuture = succeededChannelFuture;
            this.succeededFuture = succeededChannelFuture;
        }
        return succeededFuture;
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable cause) {
        return new FailedChannelFuture(channel(), executor(), cause);
    }

    private boolean isNotValidPromise(ChannelPromise promise, boolean allowVoidPromise) {
        ObjectUtil.checkNotNull(promise, "promise");
        if (promise.isDone()) {
            if (promise.isCancelled()) {
                return true;
            }
            throw new IllegalArgumentException("promise already done: " + promise);
        } else if (promise.channel() != channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", promise.channel(), channel()));
        } else if (promise.getClass() == DefaultChannelPromise.class) {
            return false;
        } else {
            if (!allowVoidPromise && (promise instanceof VoidChannelPromise)) {
                throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) VoidChannelPromise.class) + " not allowed for this operation");
            } else if (!(promise instanceof AbstractChannel.CloseFuture)) {
                return false;
            } else {
                throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) AbstractChannel.CloseFuture.class) + " not allowed in a pipeline");
            }
        }
    }

    private AbstractChannelHandlerContext findContextInbound(int mask) {
        AbstractChannelHandlerContext ctx = this;
        EventExecutor currentExecutor = executor();
        do {
            ctx = ctx.next;
        } while (skipContext(ctx, currentExecutor, mask, 510));
        return ctx;
    }

    private AbstractChannelHandlerContext findContextOutbound(int mask) {
        AbstractChannelHandlerContext ctx = this;
        EventExecutor currentExecutor = executor();
        do {
            ctx = ctx.prev;
        } while (skipContext(ctx, currentExecutor, mask, 130560));
        return ctx;
    }

    private static boolean skipContext(AbstractChannelHandlerContext ctx, EventExecutor currentExecutor, int mask, int onlyMask) {
        return (ctx.executionMask & (onlyMask | mask)) == 0 || (ctx.executor() == currentExecutor && (ctx.executionMask & mask) == 0);
    }

    @Override // p013io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return channel().voidPromise();
    }

    /* access modifiers changed from: package-private */
    public final void setRemoved() {
        this.handlerState = 3;
    }

    final boolean setAddComplete() {
        int oldState;
        do {
            oldState = this.handlerState;
            if (oldState == 3) {
                return false;
            }
        } while (!HANDLER_STATE_UPDATER.compareAndSet(this, oldState, 2));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void setAddPending() {
        boolean updated = HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
        if (!$assertionsDisabled && !updated) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public final void callHandlerAdded() throws Exception {
        if (setAddComplete()) {
            handler().handlerAdded(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void callHandlerRemoved() throws Exception {
        try {
            if (this.handlerState == 2) {
                handler().handlerRemoved(this);
            }
        } finally {
            setRemoved();
        }
    }

    private boolean invokeHandler() {
        int handlerState = this.handlerState;
        return handlerState == 2 || (!this.ordered && handlerState == 1);
    }

    @Override // p013io.netty.channel.ChannelHandlerContext
    public boolean isRemoved() {
        return this.handlerState == 3;
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> key) {
        return channel().attr(key);
    }

    @Override // p013io.netty.channel.ChannelHandlerContext, p013io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> key) {
        return channel().hasAttr(key);
    }

    private static boolean safeExecute(EventExecutor executor, Runnable runnable, ChannelPromise promise, Object msg, boolean lazy) {
        if (lazy) {
            try {
                if (executor instanceof AbstractEventExecutor) {
                    ((AbstractEventExecutor) executor).lazyExecute(runnable);
                    return true;
                }
            } catch (Throwable cause) {
                if (msg != null) {
                    try {
                        ReferenceCountUtil.release(msg);
                    } catch (Throwable th) {
                        promise.setFailure(cause);
                        throw th;
                    }
                }
                promise.setFailure(cause);
                return false;
            }
        }
        executor.execute(runnable);
        return true;
    }

    @Override // p013io.netty.util.ResourceLeakHint
    public String toHintString() {
        return '\'' + this.name + "' will handle the message from this point.";
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ChannelHandlerContext.class) + '(' + this.name + ", " + channel() + ')';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.AbstractChannelHandlerContext$WriteTask */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractChannelHandlerContext$WriteTask.class */
    public static final class WriteTask implements Runnable {
        private static final ObjectPool<WriteTask> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<WriteTask>() { // from class: io.netty.channel.AbstractChannelHandlerContext.WriteTask.1
            @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
            public WriteTask newObject(ObjectPool.Handle<WriteTask> handle) {
                return new WriteTask(handle);
            }
        });
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
        private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 32);
        private final ObjectPool.Handle<WriteTask> handle;
        private AbstractChannelHandlerContext ctx;
        private Object msg;
        private ChannelPromise promise;
        private int size;

        static WriteTask newInstance(AbstractChannelHandlerContext ctx, Object msg, ChannelPromise promise, boolean flush) {
            WriteTask task = RECYCLER.get();
            init(task, ctx, msg, promise, flush);
            return task;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.util.internal.ObjectPool$Handle<? extends io.netty.channel.AbstractChannelHandlerContext$WriteTask> */
        /* JADX WARN: Multi-variable type inference failed */
        private WriteTask(ObjectPool.Handle<? extends WriteTask> handle) {
            this.handle = handle;
        }

        protected static void init(WriteTask task, AbstractChannelHandlerContext ctx, Object msg, ChannelPromise promise, boolean flush) {
            task.ctx = ctx;
            task.msg = msg;
            task.promise = promise;
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                task.size = ctx.pipeline.estimatorHandle().size(msg) + WRITE_TASK_OVERHEAD;
                ctx.pipeline.incrementPendingOutboundBytes((long) task.size);
            } else {
                task.size = 0;
            }
            if (flush) {
                task.size |= Integer.MIN_VALUE;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                decrementPendingOutboundBytes();
                if (this.size >= 0) {
                    this.ctx.invokeWrite(this.msg, this.promise);
                } else {
                    this.ctx.invokeWriteAndFlush(this.msg, this.promise);
                }
            } finally {
                recycle();
            }
        }

        void cancel() {
            try {
                decrementPendingOutboundBytes();
            } finally {
                recycle();
            }
        }

        private void decrementPendingOutboundBytes() {
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                this.ctx.pipeline.decrementPendingOutboundBytes((long) (this.size & Integer.MAX_VALUE));
            }
        }

        private void recycle() {
            this.ctx = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.AbstractChannelHandlerContext$Tasks */
    /* loaded from: grasscutter.jar:io/netty/channel/AbstractChannelHandlerContext$Tasks.class */
    public static final class Tasks {
        private final AbstractChannelHandlerContext next;
        private final Runnable invokeChannelReadCompleteTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.1
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelReadComplete();
            }
        };
        private final Runnable invokeReadTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.2
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeRead();
            }
        };
        private final Runnable invokeChannelWritableStateChangedTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.3
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelWritabilityChanged();
            }
        };
        private final Runnable invokeFlushTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.4
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeFlush();
            }
        };

        Tasks(AbstractChannelHandlerContext next) {
            this.next = next;
        }
    }
}
