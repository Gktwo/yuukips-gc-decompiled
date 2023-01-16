package p013io.netty.handler.stream;

import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.buffer.Unpooled;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelDuplexHandler;
import p013io.netty.channel.ChannelFuture;
import p013io.netty.channel.ChannelFutureListener;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelProgressivePromise;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Future;
import p013io.netty.util.concurrent.GenericFutureListener;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.stream.ChunkedWriteHandler */
/* loaded from: grasscutter.jar:io/netty/handler/stream/ChunkedWriteHandler.class */
public class ChunkedWriteHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChunkedWriteHandler.class);
    private final Queue<PendingWrite> queue = new ArrayDeque();
    private volatile ChannelHandlerContext ctx;

    public ChunkedWriteHandler() {
    }

    @Deprecated
    public ChunkedWriteHandler(int maxPendingWrites) {
        ObjectUtil.checkPositive(maxPendingWrites, "maxPendingWrites");
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    public void resumeTransfer() {
        final ChannelHandlerContext ctx = this.ctx;
        if (ctx != null) {
            if (ctx.executor().inEventLoop()) {
                resumeTransfer0(ctx);
            } else {
                ctx.executor().execute(new Runnable() { // from class: io.netty.handler.stream.ChunkedWriteHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChunkedWriteHandler.this.resumeTransfer0(ctx);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void resumeTransfer0(ChannelHandlerContext ctx) {
        try {
            doFlush(ctx);
        } catch (Exception e) {
            logger.warn("Unexpected exception while sending chunks.", (Throwable) e);
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        this.queue.add(new PendingWrite(msg, promise));
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext ctx) throws Exception {
        doFlush(ctx);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        doFlush(ctx);
        ctx.fireChannelInactive();
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().isWritable()) {
            doFlush(ctx);
        }
        ctx.fireChannelWritabilityChanged();
    }

    private void discard(Throwable cause) {
        while (true) {
            PendingWrite currentWrite = this.queue.poll();
            if (currentWrite != null) {
                Object message = currentWrite.msg;
                if (message instanceof ChunkedInput) {
                    ChunkedInput<?> in = (ChunkedInput) message;
                    try {
                        boolean endOfInput = in.isEndOfInput();
                        long inputLength = in.length();
                        closeInput(in);
                        if (!endOfInput) {
                            if (cause == null) {
                                cause = new ClosedChannelException();
                            }
                            currentWrite.fail(cause);
                        } else {
                            currentWrite.success(inputLength);
                        }
                    } catch (Exception e) {
                        closeInput(in);
                        currentWrite.fail(e);
                        if (logger.isWarnEnabled()) {
                            logger.warn(ChunkedInput.class.getSimpleName() + " failed", (Throwable) e);
                        }
                    }
                } else {
                    if (cause == null) {
                        cause = new ClosedChannelException();
                    }
                    currentWrite.fail(cause);
                }
            } else {
                return;
            }
        }
    }

    private void doFlush(ChannelHandlerContext ctx) {
        final PendingWrite currentWrite;
        boolean suspend;
        Channel channel = ctx.channel();
        if (!channel.isActive()) {
            discard(null);
            return;
        }
        boolean requiresFlush = true;
        ByteBufAllocator allocator = ctx.alloc();
        while (true) {
            if (!channel.isWritable() || (currentWrite = this.queue.peek()) == null) {
                break;
            } else if (currentWrite.promise.isDone()) {
                this.queue.remove();
            } else {
                Object pendingMessage = currentWrite.msg;
                if (pendingMessage instanceof ChunkedInput) {
                    ChunkedInput<?> chunks = (ChunkedInput) pendingMessage;
                    Object message = null;
                    try {
                        message = chunks.readChunk(allocator);
                        boolean endOfInput = chunks.isEndOfInput();
                        if (message == null) {
                            suspend = !endOfInput;
                        } else {
                            suspend = false;
                        }
                        if (suspend) {
                            break;
                        }
                        if (message == null) {
                            message = Unpooled.EMPTY_BUFFER;
                        }
                        if (endOfInput) {
                            this.queue.remove();
                        }
                        ChannelFuture f = ctx.writeAndFlush(message);
                        if (!endOfInput) {
                            final boolean resume = !channel.isWritable();
                            if (f.isDone()) {
                                handleFuture(f, currentWrite, resume);
                            } else {
                                f.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.3
                                    public void operationComplete(ChannelFuture future) {
                                        ChunkedWriteHandler.this.handleFuture(future, currentWrite, resume);
                                    }
                                });
                            }
                        } else if (f.isDone()) {
                            handleEndOfInputFuture(f, currentWrite);
                        } else {
                            f.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.2
                                public void operationComplete(ChannelFuture future) {
                                    ChunkedWriteHandler.handleEndOfInputFuture(future, currentWrite);
                                }
                            });
                        }
                        requiresFlush = false;
                    } catch (Throwable t) {
                        this.queue.remove();
                        if (message != null) {
                            ReferenceCountUtil.release(message);
                        }
                        closeInput(chunks);
                        currentWrite.fail(t);
                    }
                } else {
                    this.queue.remove();
                    ctx.write(pendingMessage, currentWrite.promise);
                    requiresFlush = true;
                }
                if (!channel.isActive()) {
                    discard(new ClosedChannelException());
                    break;
                }
            }
        }
        if (requiresFlush) {
            ctx.flush();
        }
    }

    /* access modifiers changed from: private */
    public static void handleEndOfInputFuture(ChannelFuture future, PendingWrite currentWrite) {
        ChunkedInput<?> input = (ChunkedInput) currentWrite.msg;
        if (!future.isSuccess()) {
            closeInput(input);
            currentWrite.fail(future.cause());
            return;
        }
        long inputProgress = input.progress();
        long inputLength = input.length();
        closeInput(input);
        currentWrite.progress(inputProgress, inputLength);
        currentWrite.success(inputLength);
    }

    /* access modifiers changed from: private */
    public void handleFuture(ChannelFuture future, PendingWrite currentWrite, boolean resume) {
        ChunkedInput<?> input = (ChunkedInput) currentWrite.msg;
        if (!future.isSuccess()) {
            closeInput(input);
            currentWrite.fail(future.cause());
            return;
        }
        currentWrite.progress(input.progress(), input.length());
        if (resume && future.channel().isWritable()) {
            resumeTransfer();
        }
    }

    private static void closeInput(ChunkedInput<?> chunks) {
        try {
            chunks.close();
        } catch (Throwable t) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a chunked input.", t);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.stream.ChunkedWriteHandler$PendingWrite */
    /* loaded from: grasscutter.jar:io/netty/handler/stream/ChunkedWriteHandler$PendingWrite.class */
    public static final class PendingWrite {
        final Object msg;
        final ChannelPromise promise;

        PendingWrite(Object msg, ChannelPromise promise) {
            this.msg = msg;
            this.promise = promise;
        }

        void fail(Throwable cause) {
            ReferenceCountUtil.release(this.msg);
            this.promise.tryFailure(cause);
        }

        void success(long total) {
            if (!this.promise.isDone()) {
                progress(total, total);
                this.promise.trySuccess();
            }
        }

        void progress(long progress, long total) {
            if (this.promise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) this.promise).tryProgress(progress, total);
            }
        }
    }
}
