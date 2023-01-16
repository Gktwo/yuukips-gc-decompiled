package p013io.netty.handler.traffic;

import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javassist.compiler.TokenId;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

@ChannelHandler.Sharable
/* renamed from: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler */
/* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalChannelTrafficShapingHandler.class */
public class GlobalChannelTrafficShapingHandler extends AbstractTrafficShapingHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(GlobalChannelTrafficShapingHandler.class);
    final ConcurrentMap<Integer, PerChannel> channelQueues = PlatformDependent.newConcurrentHashMap();
    private final AtomicLong queuesSize = new AtomicLong();
    private final AtomicLong cumulativeWrittenBytes = new AtomicLong();
    private final AtomicLong cumulativeReadBytes = new AtomicLong();
    volatile long maxGlobalWriteSize = 419430400;
    private volatile long writeChannelLimit;
    private volatile long readChannelLimit;
    private static final float DEFAULT_DEVIATION = 0.1f;
    private static final float MAX_DEVIATION = 0.4f;
    private static final float DEFAULT_SLOWDOWN = 0.4f;
    private static final float DEFAULT_ACCELERATION = -0.1f;
    private volatile float maxDeviation;
    private volatile float accelerationFactor;
    private volatile float slowDownFactor;
    private volatile boolean readDeviationActive;
    private volatile boolean writeDeviationActive;

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler$PerChannel */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalChannelTrafficShapingHandler$PerChannel.class */
    public static final class PerChannel {
        ArrayDeque<ToSend> messagesQueue;
        TrafficCounter channelTrafficCounter;
        long queueSize;
        long lastWriteTimestamp;
        long lastReadTimestamp;

        PerChannel() {
        }
    }

    void createGlobalTrafficCounter(ScheduledExecutorService executor) {
        setMaxDeviation(DEFAULT_DEVIATION, 0.4f, DEFAULT_ACCELERATION);
        ObjectUtil.checkNotNullWithIAE(executor, "executor");
        TrafficCounter tc = new GlobalChannelTrafficCounter(this, executor, "GlobalChannelTC", this.checkInterval);
        setTrafficCounter(tc);
        tc.start();
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected int userDefinedWritabilityIndex() {
        return 3;
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor, long writeGlobalLimit, long readGlobalLimit, long writeChannelLimit, long readChannelLimit, long checkInterval, long maxTime) {
        super(writeGlobalLimit, readGlobalLimit, checkInterval, maxTime);
        createGlobalTrafficCounter(executor);
        this.writeChannelLimit = writeChannelLimit;
        this.readChannelLimit = readChannelLimit;
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor, long writeGlobalLimit, long readGlobalLimit, long writeChannelLimit, long readChannelLimit, long checkInterval) {
        super(writeGlobalLimit, readGlobalLimit, checkInterval);
        this.writeChannelLimit = writeChannelLimit;
        this.readChannelLimit = readChannelLimit;
        createGlobalTrafficCounter(executor);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor, long writeGlobalLimit, long readGlobalLimit, long writeChannelLimit, long readChannelLimit) {
        super(writeGlobalLimit, readGlobalLimit);
        this.writeChannelLimit = writeChannelLimit;
        this.readChannelLimit = readChannelLimit;
        createGlobalTrafficCounter(executor);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor, long checkInterval) {
        super(checkInterval);
        createGlobalTrafficCounter(executor);
    }

    public GlobalChannelTrafficShapingHandler(ScheduledExecutorService executor) {
        createGlobalTrafficCounter(executor);
    }

    public float maxDeviation() {
        return this.maxDeviation;
    }

    public float accelerationFactor() {
        return this.accelerationFactor;
    }

    public float slowDownFactor() {
        return this.slowDownFactor;
    }

    public void setMaxDeviation(float maxDeviation, float slowDownFactor, float accelerationFactor) {
        if (maxDeviation > 0.4f) {
            throw new IllegalArgumentException("maxDeviation must be <= 0.4");
        }
        ObjectUtil.checkPositiveOrZero(slowDownFactor, "slowDownFactor");
        if (accelerationFactor > 0.0f) {
            throw new IllegalArgumentException("accelerationFactor must be <= 0");
        }
        this.maxDeviation = maxDeviation;
        this.accelerationFactor = 1.0f + accelerationFactor;
        this.slowDownFactor = 1.0f + slowDownFactor;
    }

    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v34, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void computeDeviationCumulativeBytes() {
        /*
            r8 = this;
            r0 = 0
            r9 = r0
            r0 = 0
            r11 = r0
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r13 = r0
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r15 = r0
            r0 = r8
            java.util.concurrent.ConcurrentMap<java.lang.Integer, io.netty.handler.traffic.GlobalChannelTrafficShapingHandler$PerChannel> r0 = r0.channelQueues
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
            r17 = r0
        L_0x001e:
            r0 = r17
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0077
            r0 = r17
            java.lang.Object r0 = r0.next()
            io.netty.handler.traffic.GlobalChannelTrafficShapingHandler$PerChannel r0 = (p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.PerChannel) r0
            r18 = r0
            r0 = r18
            io.netty.handler.traffic.TrafficCounter r0 = r0.channelTrafficCounter
            long r0 = r0.cumulativeWrittenBytes()
            r19 = r0
            r0 = r9
            r1 = r19
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0048
            r0 = r19
            r9 = r0
        L_0x0048:
            r0 = r13
            r1 = r19
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0054
            r0 = r19
            r13 = r0
        L_0x0054:
            r0 = r18
            io.netty.handler.traffic.TrafficCounter r0 = r0.channelTrafficCounter
            long r0 = r0.cumulativeReadBytes()
            r19 = r0
            r0 = r11
            r1 = r19
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0068
            r0 = r19
            r11 = r0
        L_0x0068:
            r0 = r15
            r1 = r19
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0074
            r0 = r19
            r15 = r0
        L_0x0074:
            goto L_0x001e
        L_0x0077:
            r0 = r8
            java.util.concurrent.ConcurrentMap<java.lang.Integer, io.netty.handler.traffic.GlobalChannelTrafficShapingHandler$PerChannel> r0 = r0.channelQueues
            int r0 = r0.size()
            r1 = 1
            if (r0 <= r1) goto L_0x0088
            r0 = 1
            goto L_0x0089
        L_0x0088:
            r0 = 0
        L_0x0089:
            r17 = r0
            r0 = r8
            r1 = r17
            if (r1 == 0) goto L_0x00a0
            r1 = r15
            r2 = r11
            r3 = 2
            long r2 = r2 / r3
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a0
            r1 = 1
            goto L_0x00a1
        L_0x00a0:
            r1 = 0
        L_0x00a1:
            r0.readDeviationActive = r1
            r0 = r8
            r1 = r17
            if (r1 == 0) goto L_0x00b9
            r1 = r13
            r2 = r9
            r3 = 2
            long r2 = r2 / r3
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b9
            r1 = 1
            goto L_0x00ba
        L_0x00b9:
            r1 = 0
        L_0x00ba:
            r0.writeDeviationActive = r1
            r0 = r8
            java.util.concurrent.atomic.AtomicLong r0 = r0.cumulativeWrittenBytes
            r1 = r9
            r0.set(r1)
            r0 = r8
            java.util.concurrent.atomic.AtomicLong r0 = r0.cumulativeReadBytes
            r1 = r11
            r0.set(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.computeDeviationCumulativeBytes():void");
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    public void doAccounting(TrafficCounter counter) {
        computeDeviationCumulativeBytes();
        doAccounting(counter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long computeBalancedWait(float r6, float r7, long r8) {
        /*
            r5 = this;
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0008
            r0 = r8
            return r0
        L_0x0008:
            r0 = r6
            r1 = r7
            float r0 = r0 / r1
            r10 = r0
            r0 = r10
            r1 = r5
            float r1 = r1.maxDeviation
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x003a
            r0 = r10
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = r5
            float r2 = r2.maxDeviation
            float r1 = r1 - r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0025
            r0 = r8
            return r0
        L_0x0025:
            r0 = r5
            float r0 = r0.slowDownFactor
            r10 = r0
            r0 = r8
            r1 = 10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0040
            r0 = 10
            r8 = r0
            goto L_0x0040
        L_0x003a:
            r0 = r5
            float r0 = r0.accelerationFactor
            r10 = r0
        L_0x0040:
            r0 = r8
            float r0 = (float) r0
            r1 = r10
            float r0 = r0 * r1
            long r0 = (long) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.computeBalancedWait(float, float, long):long");
    }

    public long getMaxGlobalWriteSize() {
        return this.maxGlobalWriteSize;
    }

    public void setMaxGlobalWriteSize(long maxGlobalWriteSize) {
        this.maxGlobalWriteSize = ObjectUtil.checkPositive(maxGlobalWriteSize, "maxGlobalWriteSize");
    }

    public long queuesSize() {
        return this.queuesSize.get();
    }

    public void configureChannel(long newWriteLimit, long newReadLimit) {
        this.writeChannelLimit = newWriteLimit;
        this.readChannelLimit = newReadLimit;
        long now = TrafficCounter.milliSecondFromNano();
        for (PerChannel perChannel : this.channelQueues.values()) {
            perChannel.channelTrafficCounter.resetAccounting(now);
        }
    }

    public long getWriteChannelLimit() {
        return this.writeChannelLimit;
    }

    public void setWriteChannelLimit(long writeLimit) {
        this.writeChannelLimit = writeLimit;
        long now = TrafficCounter.milliSecondFromNano();
        for (PerChannel perChannel : this.channelQueues.values()) {
            perChannel.channelTrafficCounter.resetAccounting(now);
        }
    }

    public long getReadChannelLimit() {
        return this.readChannelLimit;
    }

    public void setReadChannelLimit(long readLimit) {
        this.readChannelLimit = readLimit;
        long now = TrafficCounter.milliSecondFromNano();
        for (PerChannel perChannel : this.channelQueues.values()) {
            perChannel.channelTrafficCounter.resetAccounting(now);
        }
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
            perChannel.channelTrafficCounter = new TrafficCounter(this, null, "ChannelTC" + ctx.channel().hashCode(), this.checkInterval);
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
        this.trafficCounter.resetCumulativeTime();
        handlerAdded(ctx);
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler, p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.trafficCounter.resetCumulativeTime();
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
                        perChannel.channelTrafficCounter.bytesRealWriteFlowControl(size);
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
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r23v2, types: [long] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r0v73, types: [long] */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r21v10 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler, p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void channelRead(p013io.netty.channel.ChannelHandlerContext r11, java.lang.Object r12) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 467
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.channelRead(io.netty.channel.ChannelHandlerContext, java.lang.Object):void");
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
    protected long checkWaitReadTime(p013io.netty.channel.ChannelHandlerContext r6, long r7, long r9) {
        /*
            r5 = this;
            r0 = r6
            io.netty.channel.Channel r0 = r0.channel()
            int r0 = r0.hashCode()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11 = r0
            r0 = r5
            java.util.concurrent.ConcurrentMap<java.lang.Integer, io.netty.handler.traffic.GlobalChannelTrafficShapingHandler$PerChannel> r0 = r0.channelQueues
            r1 = r11
            java.lang.Object r0 = r0.get(r1)
            io.netty.handler.traffic.GlobalChannelTrafficShapingHandler$PerChannel r0 = (p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.PerChannel) r0
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
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.checkWaitReadTime(io.netty.channel.ChannelHandlerContext, long, long):long");
    }

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected void informReadOperation(ChannelHandlerContext ctx, long now) {
        PerChannel perChannel = this.channelQueues.get(Integer.valueOf(ctx.channel().hashCode()));
        if (perChannel != null) {
            perChannel.lastReadTimestamp = now;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler$ToSend */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/GlobalChannelTrafficShapingHandler$ToSend.class */
    public static final class ToSend {
        final long relativeTimeAction;
        final Object toSend;
        final ChannelPromise promise;
        final long size;

        private ToSend(long delay, Object toSend, long size, ChannelPromise promise) {
            this.relativeTimeAction = delay;
            this.toSend = toSend;
            this.size = size;
            this.promise = promise;
        }
    }

    protected long maximumCumulativeWrittenBytes() {
        return this.cumulativeWrittenBytes.get();
    }

    protected long maximumCumulativeReadBytes() {
        return this.cumulativeReadBytes.get();
    }

    public Collection<TrafficCounter> channelTrafficCounters() {
        return new AbstractCollection<TrafficCounter>() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<TrafficCounter> iterator() {
                return new Iterator<TrafficCounter>() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.1.1
                    final Iterator<PerChannel> iter;

                    {
                        this.iter = GlobalChannelTrafficShapingHandler.this.channelQueues.values().iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iter.hasNext();
                    }

                    @Override // java.util.Iterator
                    public TrafficCounter next() {
                        return this.iter.next().channelTrafficCounter;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return GlobalChannelTrafficShapingHandler.this.channelQueues.size();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r25v1, types: [long] */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r0v44, types: [long] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r25v5 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler, p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(p013io.netty.channel.ChannelHandlerContext r12, java.lang.Object r13, p013io.netty.channel.ChannelPromise r14) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.write(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.channel.ChannelPromise):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v57, types: [long] */
    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    protected void submitWrite(final ChannelHandlerContext ctx, Object msg, long size, long writedelay, long now, ChannelPromise promise) {
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
                    perChannel.channelTrafficCounter.bytesRealWriteFlowControl(size);
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
            ctx.executor().schedule((Runnable) new Runnable() { // from class: io.netty.handler.traffic.GlobalChannelTrafficShapingHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    GlobalChannelTrafficShapingHandler.this.sendAllValid(ctx, perChannel, futureNow);
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
                    perChannel.channelTrafficCounter.bytesRealWriteFlowControl(size);
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

    @Override // p013io.netty.handler.traffic.AbstractTrafficShapingHandler
    public String toString() {
        return new StringBuilder((int) TokenId.THROW).append(toString()).append(" Write Channel Limit: ").append(this.writeChannelLimit).append(" Read Channel Limit: ").append(this.readChannelLimit).toString();
    }
}
