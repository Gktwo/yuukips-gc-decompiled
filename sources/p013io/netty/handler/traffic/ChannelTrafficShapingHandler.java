package p013io.netty.handler.traffic;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;

/* renamed from: io.netty.handler.traffic.ChannelTrafficShapingHandler */
/* loaded from: grasscutter.jar:io/netty/handler/traffic/ChannelTrafficShapingHandler.class */
public class ChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ArrayDeque<ToSend> messagesQueue = new ArrayDeque<>();
    private long queueSize;

    public ChannelTrafficShapingHandler(long writeLimit, long readLimit, long checkInterval, long maxTime) {
        super(writeLimit, readLimit, checkInterval, maxTime);
    }

    public ChannelTrafficShapingHandler(long writeLimit, long readLimit, long checkInterval) {
        super(writeLimit, readLimit, checkInterval);
    }

    public ChannelTrafficShapingHandler(long writeLimit, long readLimit) {
        super(writeLimit, readLimit);
    }

    public ChannelTrafficShapingHandler(long checkInterval) {
        super(checkInterval);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        TrafficCounter trafficCounter = new TrafficCounter(this, ctx.executor(), "ChannelTC" + ctx.channel().hashCode(), this.checkInterval);
        setTrafficCounter(trafficCounter);
        trafficCounter.start();
        handlerAdded(ctx);
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.trafficCounter.stop();
        synchronized (this) {
            if (ctx.channel().isActive()) {
                Iterator<ToSend> it = this.messagesQueue.iterator();
                while (it.hasNext()) {
                    ToSend toSend = it.next();
                    long size = calculateSize(toSend.toSend);
                    this.trafficCounter.bytesRealWriteFlowControl(size);
                    this.queueSize -= size;
                    ctx.write(toSend.toSend, toSend.promise);
                }
            } else {
                Iterator<ToSend> it2 = this.messagesQueue.iterator();
                while (it2.hasNext()) {
                    ToSend toSend2 = it2.next();
                    if (toSend2.toSend instanceof ByteBuf) {
                        ((ByteBuf) toSend2.toSend).release();
                    }
                }
            }
            this.messagesQueue.clear();
        }
        releaseWriteSuspended(ctx);
        releaseReadSuspended(ctx);
        handlerRemoved(ctx);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.traffic.ChannelTrafficShapingHandler$ToSend */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/ChannelTrafficShapingHandler$ToSend.class */
    public static final class ToSend {
        final long relativeTimeAction;
        final Object toSend;
        final ChannelPromise promise;

        private ToSend(long delay, Object toSend, ChannelPromise promise) {
            this.relativeTimeAction = delay;
            this.toSend = toSend;
            this.promise = promise;
        }
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    void submitWrite(final ChannelHandlerContext ctx, Object msg, long size, long delay, long now, ChannelPromise promise) {
        synchronized (this) {
            if (delay == 0) {
                if (this.messagesQueue.isEmpty()) {
                    this.trafficCounter.bytesRealWriteFlowControl(size);
                    ctx.write(msg, promise);
                    return;
                }
            }
            ToSend newToSend = new ToSend(delay + now, msg, promise);
            this.messagesQueue.addLast(newToSend);
            this.queueSize += size;
            checkWriteSuspend(ctx, delay, this.queueSize);
            final long futureNow = newToSend.relativeTimeAction;
            ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.traffic.ChannelTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelTrafficShapingHandler.this.sendAllValid(ctx, futureNow);
                }
            }, delay, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext ctx, long now) {
        synchronized (this) {
            ToSend newToSend = this.messagesQueue.pollFirst();
            while (true) {
                if (newToSend != null) {
                    if (newToSend.relativeTimeAction > now) {
                        this.messagesQueue.addFirst(newToSend);
                        break;
                    }
                    long size = calculateSize(newToSend.toSend);
                    this.trafficCounter.bytesRealWriteFlowControl(size);
                    this.queueSize -= size;
                    ctx.write(newToSend.toSend, newToSend.promise);
                    newToSend = this.messagesQueue.pollFirst();
                } else {
                    break;
                }
            }
            if (this.messagesQueue.isEmpty()) {
                releaseWriteSuspended(ctx);
            }
        }
        ctx.flush();
    }

    public long queueSize() {
        return this.queueSize;
    }
}
