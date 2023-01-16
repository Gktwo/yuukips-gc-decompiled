package p013io.netty.handler.timeout;

import java.util.concurrent.TimeUnit;
import p013io.netty.channel.ChannelDuplexHandler;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.timeout.IdleStateHandler */
/* loaded from: grasscutter.jar:io/netty/handler/timeout/IdleStateHandler.class */
public class IdleStateHandler extends ChannelDuplexHandler {
    private static final long MIN_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
    private final ChannelFutureListener writeListener;
    private final boolean observeOutput;
    private final long readerIdleTimeNanos;
    private final long writerIdleTimeNanos;
    private final long allIdleTimeNanos;
    private Future<?> readerIdleTimeout;
    private long lastReadTime;
    private boolean firstReaderIdleEvent;
    private Future<?> writerIdleTimeout;
    private long lastWriteTime;
    private boolean firstWriterIdleEvent;
    private Future<?> allIdleTimeout;
    private boolean firstAllIdleEvent;
    private byte state;
    private boolean reading;
    private long lastChangeCheckTimeStamp;
    private int lastMessageHashCode;
    private long lastPendingWriteBytes;
    private long lastFlushProgress;

    public IdleStateHandler(int readerIdleTimeSeconds, int writerIdleTimeSeconds, int allIdleTimeSeconds) {
        this((long) readerIdleTimeSeconds, (long) writerIdleTimeSeconds, (long) allIdleTimeSeconds, TimeUnit.SECONDS);
    }

    public IdleStateHandler(long readerIdleTime, long writerIdleTime, long allIdleTime, TimeUnit unit) {
        this(false, readerIdleTime, writerIdleTime, allIdleTime, unit);
    }

    public IdleStateHandler(boolean observeOutput, long readerIdleTime, long writerIdleTime, long allIdleTime, TimeUnit unit) {
        this.writeListener = new ChannelFutureListener() { // from class: io.netty.handler.timeout.IdleStateHandler.1
            public void operationComplete(ChannelFuture future) throws Exception {
                IdleStateHandler.this.lastWriteTime = IdleStateHandler.this.ticksInNanos();
                IdleStateHandler.this.firstWriterIdleEvent = IdleStateHandler.this.firstAllIdleEvent = true;
            }
        };
        this.firstReaderIdleEvent = true;
        this.firstWriterIdleEvent = true;
        this.firstAllIdleEvent = true;
        ObjectUtil.checkNotNull(unit, "unit");
        this.observeOutput = observeOutput;
        if (readerIdleTime <= 0) {
            this.readerIdleTimeNanos = 0;
        } else {
            this.readerIdleTimeNanos = Math.max(unit.toNanos(readerIdleTime), MIN_TIMEOUT_NANOS);
        }
        if (writerIdleTime <= 0) {
            this.writerIdleTimeNanos = 0;
        } else {
            this.writerIdleTimeNanos = Math.max(unit.toNanos(writerIdleTime), MIN_TIMEOUT_NANOS);
        }
        if (allIdleTime <= 0) {
            this.allIdleTimeNanos = 0;
        } else {
            this.allIdleTimeNanos = Math.max(unit.toNanos(allIdleTime), MIN_TIMEOUT_NANOS);
        }
    }

    public long getReaderIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.readerIdleTimeNanos);
    }

    public long getWriterIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.writerIdleTimeNanos);
    }

    public long getAllIdleTimeInMillis() {
        return TimeUnit.NANOSECONDS.toMillis(this.allIdleTimeNanos);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().isActive() && ctx.channel().isRegistered()) {
            initialize(ctx);
        }
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        destroy();
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().isActive()) {
            initialize(ctx);
        }
        channelRegistered(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        initialize(ctx);
        channelActive(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        destroy();
        channelInactive(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            this.reading = true;
            this.firstAllIdleEvent = true;
            this.firstReaderIdleEvent = true;
        }
        ctx.fireChannelRead(msg);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        if ((this.readerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) && this.reading) {
            this.lastReadTime = ticksInNanos();
            this.reading = false;
        }
        ctx.fireChannelReadComplete();
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (this.writerIdleTimeNanos > 0 || this.allIdleTimeNanos > 0) {
            ctx.write(msg, promise.unvoid()).addListener((GenericFutureListener<? extends Future<? super Void>>) this.writeListener);
        } else {
            ctx.write(msg, promise);
        }
    }

    private void initialize(ChannelHandlerContext ctx) {
        switch (this.state) {
            case 1:
            case 2:
                return;
            default:
                this.state = 1;
                initOutputChanged(ctx);
                long ticksInNanos = ticksInNanos();
                this.lastWriteTime = ticksInNanos;
                this.lastReadTime = ticksInNanos;
                if (this.readerIdleTimeNanos > 0) {
                    this.readerIdleTimeout = schedule(ctx, new ReaderIdleTimeoutTask(ctx), this.readerIdleTimeNanos, TimeUnit.NANOSECONDS);
                }
                if (this.writerIdleTimeNanos > 0) {
                    this.writerIdleTimeout = schedule(ctx, new WriterIdleTimeoutTask(ctx), this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
                }
                if (this.allIdleTimeNanos > 0) {
                    this.allIdleTimeout = schedule(ctx, new AllIdleTimeoutTask(ctx), this.allIdleTimeNanos, TimeUnit.NANOSECONDS);
                    return;
                }
                return;
        }
    }

    long ticksInNanos() {
        return System.nanoTime();
    }

    Future<?> schedule(ChannelHandlerContext ctx, Runnable task, long delay, TimeUnit unit) {
        return ctx.executor().schedule(task, delay, unit);
    }

    private void destroy() {
        this.state = 2;
        if (this.readerIdleTimeout != null) {
            this.readerIdleTimeout.cancel(false);
            this.readerIdleTimeout = null;
        }
        if (this.writerIdleTimeout != null) {
            this.writerIdleTimeout.cancel(false);
            this.writerIdleTimeout = null;
        }
        if (this.allIdleTimeout != null) {
            this.allIdleTimeout.cancel(false);
            this.allIdleTimeout = null;
        }
    }

    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        ctx.fireUserEventTriggered((Object) evt);
    }

    protected IdleStateEvent newIdleStateEvent(IdleState state, boolean first) {
        switch (state) {
            case ALL_IDLE:
                return first ? IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT : IdleStateEvent.ALL_IDLE_STATE_EVENT;
            case READER_IDLE:
                return first ? IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT : IdleStateEvent.READER_IDLE_STATE_EVENT;
            case WRITER_IDLE:
                return first ? IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT : IdleStateEvent.WRITER_IDLE_STATE_EVENT;
            default:
                throw new IllegalArgumentException("Unhandled: state=" + state + ", first=" + first);
        }
    }

    private void initOutputChanged(ChannelHandlerContext ctx) {
        ChannelOutboundBuffer buf;
        if (this.observeOutput && (buf = ctx.channel().unsafe().outboundBuffer()) != null) {
            this.lastMessageHashCode = System.identityHashCode(buf.current());
            this.lastPendingWriteBytes = buf.totalPendingWriteBytes();
            this.lastFlushProgress = buf.currentProgress();
        }
    }

    /* access modifiers changed from: private */
    public boolean hasOutputChanged(ChannelHandlerContext ctx, boolean first) {
        if (!this.observeOutput) {
            return false;
        }
        if (this.lastChangeCheckTimeStamp != this.lastWriteTime) {
            this.lastChangeCheckTimeStamp = this.lastWriteTime;
            if (!first) {
                return true;
            }
        }
        ChannelOutboundBuffer buf = ctx.channel().unsafe().outboundBuffer();
        if (buf == null) {
            return false;
        }
        int messageHashCode = System.identityHashCode(buf.current());
        long pendingWriteBytes = buf.totalPendingWriteBytes();
        if (!(messageHashCode == this.lastMessageHashCode && pendingWriteBytes == this.lastPendingWriteBytes)) {
            this.lastMessageHashCode = messageHashCode;
            this.lastPendingWriteBytes = pendingWriteBytes;
            if (!first) {
                return true;
            }
        }
        long flushProgress = buf.currentProgress();
        if (flushProgress == this.lastFlushProgress) {
            return false;
        }
        this.lastFlushProgress = flushProgress;
        return !first;
    }

    /* renamed from: io.netty.handler.timeout.IdleStateHandler$AbstractIdleTask */
    /* loaded from: grasscutter.jar:io/netty/handler/timeout/IdleStateHandler$AbstractIdleTask.class */
    private static abstract class AbstractIdleTask implements Runnable {
        private final ChannelHandlerContext ctx;

        protected abstract void run(ChannelHandlerContext channelHandlerContext);

        AbstractIdleTask(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ctx.channel().isOpen()) {
                run(this.ctx);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.timeout.IdleStateHandler$ReaderIdleTimeoutTask */
    /* loaded from: grasscutter.jar:io/netty/handler/timeout/IdleStateHandler$ReaderIdleTimeoutTask.class */
    public final class ReaderIdleTimeoutTask extends AbstractIdleTask {
        ReaderIdleTimeoutTask(ChannelHandlerContext ctx) {
            super(ctx);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [long] */
        /* JADX WARN: Type inference failed for: r1v2, types: [io.netty.handler.timeout.IdleStateHandler] */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p013io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void run(p013io.netty.channel.ChannelHandlerContext r9) {
            /*
                r8 = this;
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r0 = p013io.netty.handler.timeout.IdleStateHandler.access$300(r0)
                r10 = r0
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                boolean r0 = p013io.netty.handler.timeout.IdleStateHandler.access$400(r0)
                if (r0 != 0) goto L_0x0024
                r0 = r10
                r1 = r8
                io.netty.handler.timeout.IdleStateHandler r1 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r1 = r1.ticksInNanos()
                r2 = r8
                io.netty.handler.timeout.IdleStateHandler r2 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r2 = p013io.netty.handler.timeout.IdleStateHandler.access$500(r2)
                long r1 = r1 - r2
                long r0 = r0 - r1
                r10 = r0
            L_0x0024:
                r0 = r10
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x0080
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                r1 = r8
                io.netty.handler.timeout.IdleStateHandler r1 = p013io.netty.handler.timeout.IdleStateHandler.this
                r2 = r9
                r3 = r8
                r4 = r8
                io.netty.handler.timeout.IdleStateHandler r4 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r4 = p013io.netty.handler.timeout.IdleStateHandler.access$300(r4)
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
                io.netty.util.concurrent.Future r1 = r1.schedule(r2, r3, r4, r5)
                io.netty.util.concurrent.Future r0 = p013io.netty.handler.timeout.IdleStateHandler.access$602(r0, r1)
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                boolean r0 = p013io.netty.handler.timeout.IdleStateHandler.access$700(r0)
                r12 = r0
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                r1 = 0
                boolean r0 = p013io.netty.handler.timeout.IdleStateHandler.access$702(r0, r1)
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this     // Catch: Throwable -> 0x0072
                io.netty.handler.timeout.IdleState r1 = p013io.netty.handler.timeout.IdleState.READER_IDLE     // Catch: Throwable -> 0x0072
                r2 = r12
                io.netty.handler.timeout.IdleStateEvent r0 = r0.newIdleStateEvent(r1, r2)     // Catch: Throwable -> 0x0072
                r13 = r0
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this     // Catch: Throwable -> 0x0072
                r1 = r9
                r2 = r13
                r0.channelIdle(r1, r2)     // Catch: Throwable -> 0x0072
                goto L_0x007d
            L_0x0072:
                r13 = move-exception
                r0 = r9
                r1 = r13
                io.netty.channel.ChannelHandlerContext r0 = r0.fireExceptionCaught(r1)
            L_0x007d:
                goto L_0x0095
            L_0x0080:
                r0 = r8
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                r1 = r8
                io.netty.handler.timeout.IdleStateHandler r1 = p013io.netty.handler.timeout.IdleStateHandler.this
                r2 = r9
                r3 = r8
                r4 = r10
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
                io.netty.util.concurrent.Future r1 = r1.schedule(r2, r3, r4, r5)
                io.netty.util.concurrent.Future r0 = p013io.netty.handler.timeout.IdleStateHandler.access$602(r0, r1)
            L_0x0095:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.timeout.IdleStateHandler.ReaderIdleTimeoutTask.run(io.netty.channel.ChannelHandlerContext):void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.timeout.IdleStateHandler$WriterIdleTimeoutTask */
    /* loaded from: grasscutter.jar:io/netty/handler/timeout/IdleStateHandler$WriterIdleTimeoutTask.class */
    public final class WriterIdleTimeoutTask extends AbstractIdleTask {
        WriterIdleTimeoutTask(ChannelHandlerContext ctx) {
            super(ctx);
        }

        @Override // p013io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        protected void run(ChannelHandlerContext ctx) {
            long nextDelay = IdleStateHandler.this.writerIdleTimeNanos - (IdleStateHandler.this.ticksInNanos() - IdleStateHandler.this.lastWriteTime);
            if (nextDelay <= 0) {
                IdleStateHandler.this.writerIdleTimeout = IdleStateHandler.this.schedule(ctx, this, IdleStateHandler.this.writerIdleTimeNanos, TimeUnit.NANOSECONDS);
                boolean first = IdleStateHandler.this.firstWriterIdleEvent;
                IdleStateHandler.this.firstWriterIdleEvent = false;
                try {
                    if (!IdleStateHandler.this.hasOutputChanged(ctx, first)) {
                        IdleStateHandler.this.channelIdle(ctx, IdleStateHandler.this.newIdleStateEvent(IdleState.WRITER_IDLE, first));
                    }
                } catch (Throwable t) {
                    ctx.fireExceptionCaught(t);
                }
            } else {
                IdleStateHandler.this.writerIdleTimeout = IdleStateHandler.this.schedule(ctx, this, nextDelay, TimeUnit.NANOSECONDS);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.timeout.IdleStateHandler$AllIdleTimeoutTask */
    /* loaded from: grasscutter.jar:io/netty/handler/timeout/IdleStateHandler$AllIdleTimeoutTask.class */
    public final class AllIdleTimeoutTask extends AbstractIdleTask {
        AllIdleTimeoutTask(ChannelHandlerContext ctx) {
            super(ctx);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v1, types: [long] */
        /* JADX WARN: Type inference failed for: r1v2, types: [io.netty.handler.timeout.IdleStateHandler] */
        /* JADX WARN: Type inference failed for: r0v31, types: [long] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // p013io.netty.handler.timeout.IdleStateHandler.AbstractIdleTask
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void run(p013io.netty.channel.ChannelHandlerContext r10) {
            /*
                r9 = this;
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r0 = p013io.netty.handler.timeout.IdleStateHandler.access$1100(r0)
                r11 = r0
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                boolean r0 = p013io.netty.handler.timeout.IdleStateHandler.access$400(r0)
                if (r0 != 0) goto L_0x002e
                r0 = r11
                r1 = r9
                io.netty.handler.timeout.IdleStateHandler r1 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r1 = r1.ticksInNanos()
                r2 = r9
                io.netty.handler.timeout.IdleStateHandler r2 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r2 = p013io.netty.handler.timeout.IdleStateHandler.access$500(r2)
                r3 = r9
                io.netty.handler.timeout.IdleStateHandler r3 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r3 = p013io.netty.handler.timeout.IdleStateHandler.access$000(r3)
                long r2 = java.lang.Math.max(r2, r3)
                long r1 = r1 - r2
                long r0 = r0 - r1
                r11 = r0
            L_0x002e:
                r0 = r11
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x0098
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                r1 = r9
                io.netty.handler.timeout.IdleStateHandler r1 = p013io.netty.handler.timeout.IdleStateHandler.this
                r2 = r10
                r3 = r9
                r4 = r9
                io.netty.handler.timeout.IdleStateHandler r4 = p013io.netty.handler.timeout.IdleStateHandler.this
                long r4 = p013io.netty.handler.timeout.IdleStateHandler.access$1100(r4)
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
                io.netty.util.concurrent.Future r1 = r1.schedule(r2, r3, r4, r5)
                io.netty.util.concurrent.Future r0 = p013io.netty.handler.timeout.IdleStateHandler.access$1202(r0, r1)
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                boolean r0 = p013io.netty.handler.timeout.IdleStateHandler.access$200(r0)
                r13 = r0
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                r1 = 0
                boolean r0 = p013io.netty.handler.timeout.IdleStateHandler.access$202(r0, r1)
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this     // Catch: Throwable -> 0x008a
                r1 = r10
                r2 = r13
                boolean r0 = p013io.netty.handler.timeout.IdleStateHandler.access$1000(r0, r1, r2)     // Catch: Throwable -> 0x008a
                if (r0 == 0) goto L_0x006f
                return
            L_0x006f:
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this     // Catch: Throwable -> 0x008a
                io.netty.handler.timeout.IdleState r1 = p013io.netty.handler.timeout.IdleState.ALL_IDLE     // Catch: Throwable -> 0x008a
                r2 = r13
                io.netty.handler.timeout.IdleStateEvent r0 = r0.newIdleStateEvent(r1, r2)     // Catch: Throwable -> 0x008a
                r14 = r0
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this     // Catch: Throwable -> 0x008a
                r1 = r10
                r2 = r14
                r0.channelIdle(r1, r2)     // Catch: Throwable -> 0x008a
                goto L_0x0095
            L_0x008a:
                r14 = move-exception
                r0 = r10
                r1 = r14
                io.netty.channel.ChannelHandlerContext r0 = r0.fireExceptionCaught(r1)
            L_0x0095:
                goto L_0x00ad
            L_0x0098:
                r0 = r9
                io.netty.handler.timeout.IdleStateHandler r0 = p013io.netty.handler.timeout.IdleStateHandler.this
                r1 = r9
                io.netty.handler.timeout.IdleStateHandler r1 = p013io.netty.handler.timeout.IdleStateHandler.this
                r2 = r10
                r3 = r9
                r4 = r11
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
                io.netty.util.concurrent.Future r1 = r1.schedule(r2, r3, r4, r5)
                io.netty.util.concurrent.Future r0 = p013io.netty.handler.timeout.IdleStateHandler.access$1202(r0, r1)
            L_0x00ad:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.timeout.IdleStateHandler.AllIdleTimeoutTask.run(io.netty.channel.ChannelHandlerContext):void");
        }
    }
}
