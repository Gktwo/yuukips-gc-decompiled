package p013io.netty.handler.traffic;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.traffic.GlobalTrafficShapingHandler */
/* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalTrafficShapingHandler.class */
public class GlobalTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private final ConcurrentMap<Integer, PerChannel> channelQueues = PlatformDependent.newConcurrentHashMap();
    private final AtomicLong queuesSize = new AtomicLong();
    long maxGlobalWriteSize = 419430400;

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.traffic.GlobalTrafficShapingHandler$PerChannel */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalTrafficShapingHandler$PerChannel.class */
    public static final class PerChannel {
        ArrayDeque<ToSend> messagesQueue;
        long queueSize;
        long lastWriteTimestamp;
        long lastReadTimestamp;

        private PerChannel() {
        }
    }

    void createGlobalTrafficCounter(ScheduledExecutorService executor) {
        TrafficCounter tc = new TrafficCounter(this, (ScheduledExecutorService) ObjectUtil.checkNotNull(executor, "executor"), "GlobalTC", this.checkInterval);
        setTrafficCounter(tc);
        tc.start();
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected int userDefinedWritabilityIndex() {
        return 2;
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService executor, long writeLimit, long readLimit, long checkInterval, long maxTime) {
        super(writeLimit, readLimit, checkInterval, maxTime);
        createGlobalTrafficCounter(executor);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService executor, long writeLimit, long readLimit, long checkInterval) {
        super(writeLimit, readLimit, checkInterval);
        createGlobalTrafficCounter(executor);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService executor, long writeLimit, long readLimit) {
        super(writeLimit, readLimit);
        createGlobalTrafficCounter(executor);
    }

    public GlobalTrafficShapingHandler(ScheduledExecutorService executor, long checkInterval) {
        super(checkInterval);
        createGlobalTrafficCounter(executor);
    }

    public GlobalTrafficShapingHandler(EventExecutor executor) {
        createGlobalTrafficCounter(executor);
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    public void setMaxGlobalWriteSize(long maxGlobalWriteSize) {
        this.maxGlobalWriteSize = maxGlobalWriteSize;
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public final void release() {
        this.trafficCounter.stop();
    }

    private PerChannel getOrSetPerChannel(ChannelHandlerContext ctx) {
        Integer key = Integer.valueOf(ctx.channel().hashCode());
        PerChannel perChannel = this.channelQueues.get(key);
        if (perChannel == null) {
            perChannel = new PerChannel();
            perChannel.messagesQueue = new ArrayDeque<>();
            perChannel.queueSize = 0;
            perChannel.lastReadTimestamp = TrafficCounter.milliSecondFromNano();
            perChannel.lastWriteTimestamp = perChannel.lastReadTimestamp;
            this.channelQueues.put(key, perChannel);
        }
        return perChannel;
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        getOrSetPerChannel(ctx);
        handlerAdded(ctx);
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        PerChannel perChannel = this.channelQueues.remove(Integer.valueOf(channel.hashCode()));
        if (perChannel != null) {
            synchronized (perChannel) {
                if (channel.isActive()) {
                    Iterator<ToSend> it = perChannel.messagesQueue.iterator();
                    while (it.hasNext()) {
                        ToSend toSend = it.next();
                        long size = calculateSize(toSend.toSend);
                        this.trafficCounter.bytesRealWriteFlowControl(size);
                        perChannel.queueSize -= size;
                        this.queuesSize.addAndGet(-size);
                        ctx.write(toSend.toSend, toSend.promise);
                    }
                } else {
                    this.queuesSize.addAndGet(-perChannel.queueSize);
                    Iterator<ToSend> it2 = perChannel.messagesQueue.iterator();
                    while (it2.hasNext()) {
                        ToSend toSend2 = it2.next();
                        if (toSend2.toSend instanceof ByteBuf) {
                            ((ByteBuf) toSend2.toSend).release();
                        }
                    }
                }
                perChannel.messagesQueue.clear();
            }
        }
        releaseWriteSuspended(ctx);
        releaseReadSuspended(ctx);
        handlerRemoved(ctx);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    long checkWaitReadTime(p013io.netty.channel.ChannelHandlerContext r6, long r7, long r9) {
        /*
            r5 = this;
            r0 = r6
            io.netty.channel.Channel r0 = r0.channel()
            int r0 = r0.hashCode()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11 = r0
            r0 = r5
            java.util.concurrent.ConcurrentMap<java.lang.Integer, io.netty.handler.traffic.GlobalTrafficShapingHandler$PerChannel> r0 = r0.channelQueues
            r1 = r11
            java.lang.Object r0 = r0.get(r1)
            io.netty.handler.traffic.GlobalTrafficShapingHandler$PerChannel r0 = (p013io.netty.handler.traffic.GlobalTrafficShapingHandler.PerChannel) r0
            r12 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0043
            r0 = r7
            r1 = r5
            long r1 = r1.maxTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0043
            r0 = r9
            r1 = r7
            long r0 = r0 + r1
            r1 = r12
            long r1 = r1.lastReadTimestamp
            long r0 = r0 - r1
            r1 = r5
            long r1 = r1.maxTime
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0043
            r0 = r5
            long r0 = r0.maxTime
            r7 = r0
        L_0x0043:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.GlobalTrafficShapingHandler.checkWaitReadTime(io.netty.channel.ChannelHandlerContext, long, long):long");
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    void informReadOperation(ChannelHandlerContext ctx, long now) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(ctx.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = now;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.traffic.GlobalTrafficShapingHandler$ToSend */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalTrafficShapingHandler$ToSend.class */
    public static final class ToSend {
        final long relativeTimeAction;
        final Object toSend;
        final long size;
        final ChannelPromise promise;

        private ToSend(long delay, Object toSend, long size, ChannelPromise promise) {
            this.relativeTimeAction = delay;
            this.toSend = toSend;
            this.size = size;
            this.promise = promise;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v55, types: [long] */
    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    void submitWrite(final ChannelHandlerContext ctx, Object msg, long size, long writedelay, long now, ChannelPromise promise) {
        final PerChannel perChannel = this.channelQueues.get(Integer.valueOf(ctx.channel().hashCode()));
        if (perChannel == null) {
            perChannel = getOrSetPerChannel(ctx);
        }
        char c = writedelay;
        boolean globalSizeExceeded = false;
        synchronized (perChannel) {
            if (writedelay == 0) {
                if (perChannel.messagesQueue.isEmpty()) {
                    this.trafficCounter.bytesRealWriteFlowControl(size);
                    ctx.write(msg, promise);
                    perChannel.lastWriteTimestamp = now;
                    return;
                }
            }
            if (c > this.maxTime && (now + c) - perChannel.lastWriteTimestamp > this.maxTime) {
                c = this.maxTime;
            }
            ToSend newToSend = new ToSend(c + now, msg, size, promise);
            perChannel.messagesQueue.addLast(newToSend);
            perChannel.queueSize += size;
            this.queuesSize.addAndGet(size);
            checkWriteSuspend(ctx, c, perChannel.queueSize);
            if (this.queuesSize.get() > this.maxGlobalWriteSize) {
                globalSizeExceeded = true;
            }
            if (globalSizeExceeded) {
                setUserDefinedWritability(ctx, false);
            }
            final long futureNow = newToSend.relativeTimeAction;
            ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.traffic.GlobalTrafficShapingHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalTrafficShapingHandler.this.sendAllValid(ctx, perChannel, futureNow);
                }
            }, (long) c, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public void sendAllValid(ChannelHandlerContext ctx, PerChannel perChannel, long now) {
        synchronized (perChannel) {
            ToSend newToSend = perChannel.messagesQueue.pollFirst();
            while (true) {
                if (newToSend != null) {
                    if (newToSend.relativeTimeAction > now) {
                        perChannel.messagesQueue.addFirst(newToSend);
                        break;
                    }
                    long size = newToSend.size;
                    this.trafficCounter.bytesRealWriteFlowControl(size);
                    perChannel.queueSize -= size;
                    this.queuesSize.addAndGet(-size);
                    ctx.write(newToSend.toSend, newToSend.promise);
                    perChannel.lastWriteTimestamp = now;
                    newToSend = perChannel.messagesQueue.pollFirst();
                } else {
                    break;
                }
            }
            if (perChannel.messagesQueue.isEmpty()) {
                releaseWriteSuspended(ctx);
            }
        }
        ctx.flush();
    }
}
