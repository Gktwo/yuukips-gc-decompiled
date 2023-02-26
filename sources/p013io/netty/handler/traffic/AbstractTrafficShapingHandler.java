package p013io.netty.handler.traffic;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.concurrent.TimeUnit;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.ChannelDuplexHandler;
import p013io.netty.channel.ChannelHandlerContext;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.ChannelPromise;
import p013io.netty.channel.FileRegion;
import p013io.netty.util.Attribute;
import p013io.netty.util.AttributeKey;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.handler.traffic.AbstractTrafficShapingHandler */
/* loaded from: grasscutter.jar:io/netty/handler/traffic/AbstractTrafficShapingHandler.class */
public abstract class AbstractTrafficShapingHandler extends ChannelDuplexHandler {
    public static final long DEFAULT_CHECK_INTERVAL = 1000;
    public static final long DEFAULT_MAX_TIME = 15000;
    static final long DEFAULT_MAX_SIZE = 4194304;
    static final long MINIMAL_WAIT = 10;
    protected TrafficCounter trafficCounter;
    private volatile long writeLimit;
    private volatile long readLimit;
    protected volatile long maxTime;
    protected volatile long checkInterval;
    volatile long maxWriteDelay;
    volatile long maxWriteSize;
    final int userDefinedWritabilityIndex;
    static final int CHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 1;
    static final int GLOBAL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 2;
    static final int GLOBALCHANNEL_DEFAULT_USER_DEFINED_WRITABILITY_INDEX = 3;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(AbstractTrafficShapingHandler.class);
    static final AttributeKey<Boolean> READ_SUSPENDED = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".READ_SUSPENDED");
    static final AttributeKey<Runnable> REOPEN_TASK = AttributeKey.valueOf(AbstractTrafficShapingHandler.class.getName() + ".REOPEN_TASK");

    abstract void submitWrite(ChannelHandlerContext channelHandlerContext, Object obj, long j, long j2, long j3, ChannelPromise channelPromise);

    void setTrafficCounter(TrafficCounter newTrafficCounter) {
        this.trafficCounter = newTrafficCounter;
    }

    protected int userDefinedWritabilityIndex() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long writeLimit, long readLimit, long checkInterval, long maxTime) {
        this.maxTime = DEFAULT_MAX_TIME;
        this.checkInterval = 1000;
        this.maxWriteDelay = 4000;
        this.maxWriteSize = DEFAULT_MAX_SIZE;
        this.maxTime = ObjectUtil.checkPositive(maxTime, "maxTime");
        this.userDefinedWritabilityIndex = userDefinedWritabilityIndex();
        this.writeLimit = writeLimit;
        this.readLimit = readLimit;
        this.checkInterval = checkInterval;
    }

    /* access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long writeLimit, long readLimit, long checkInterval) {
        this(writeLimit, readLimit, checkInterval, DEFAULT_MAX_TIME);
    }

    /* access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long writeLimit, long readLimit) {
        this(writeLimit, readLimit, 1000, DEFAULT_MAX_TIME);
    }

    /* access modifiers changed from: protected */
    public AbstractTrafficShapingHandler() {
        this(0, 0, 1000, DEFAULT_MAX_TIME);
    }

    /* access modifiers changed from: protected */
    public AbstractTrafficShapingHandler(long checkInterval) {
        this(0, 0, checkInterval, DEFAULT_MAX_TIME);
    }

    public void configure(long newWriteLimit, long newReadLimit, long newCheckInterval) {
        configure(newWriteLimit, newReadLimit);
        configure(newCheckInterval);
    }

    public void configure(long newWriteLimit, long newReadLimit) {
        this.writeLimit = newWriteLimit;
        this.readLimit = newReadLimit;
        if (this.trafficCounter != null) {
            this.trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public void configure(long newCheckInterval) {
        this.checkInterval = newCheckInterval;
        if (this.trafficCounter != null) {
            this.trafficCounter.configure(this.checkInterval);
        }
    }

    public long getWriteLimit() {
        return this.writeLimit;
    }

    public void setWriteLimit(long writeLimit) {
        this.writeLimit = writeLimit;
        if (this.trafficCounter != null) {
            this.trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public long getReadLimit() {
        return this.readLimit;
    }

    public void setReadLimit(long readLimit) {
        this.readLimit = readLimit;
        if (this.trafficCounter != null) {
            this.trafficCounter.resetAccounting(TrafficCounter.milliSecondFromNano());
        }
    }

    public long getCheckInterval() {
        return this.checkInterval;
    }

    public void setCheckInterval(long checkInterval) {
        this.checkInterval = checkInterval;
        if (this.trafficCounter != null) {
            this.trafficCounter.configure(checkInterval);
        }
    }

    public void setMaxTimeWait(long maxTime) {
        this.maxTime = ObjectUtil.checkPositive(maxTime, "maxTime");
    }

    public long getMaxTimeWait() {
        return this.maxTime;
    }

    public long getMaxWriteDelay() {
        return this.maxWriteDelay;
    }

    public void setMaxWriteDelay(long maxWriteDelay) {
        this.maxWriteDelay = ObjectUtil.checkPositive(maxWriteDelay, "maxWriteDelay");
    }

    public long getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public void setMaxWriteSize(long maxWriteSize) {
        this.maxWriteSize = maxWriteSize;
    }

    /* access modifiers changed from: protected */
    public void doAccounting(TrafficCounter counter) {
    }

    /* renamed from: io.netty.handler.traffic.AbstractTrafficShapingHandler$ReopenReadTimerTask */
    /* loaded from: grasscutter.jar:io/netty/handler/traffic/AbstractTrafficShapingHandler$ReopenReadTimerTask.class */
    static final class ReopenReadTimerTask implements Runnable {
        final ChannelHandlerContext ctx;

        /* access modifiers changed from: package-private */
        public ReopenReadTimerTask(ChannelHandlerContext ctx) {
            this.ctx = ctx;
        }

        @Override // java.lang.Runnable
        public void run() {
            Channel channel = this.ctx.channel();
            ChannelConfig config = channel.config();
            if (config.isAutoRead() || !AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    if (!config.isAutoRead() || AbstractTrafficShapingHandler.isHandlerActive(this.ctx)) {
                        if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                            AbstractTrafficShapingHandler.logger.debug("Normal unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                        }
                    } else if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                        AbstractTrafficShapingHandler.logger.debug("Unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                    }
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(false);
                config.setAutoRead(true);
                channel.read();
            } else {
                if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                    AbstractTrafficShapingHandler.logger.debug("Not unsuspend: " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
                }
                channel.attr(AbstractTrafficShapingHandler.READ_SUSPENDED).set(false);
            }
            if (AbstractTrafficShapingHandler.logger.isDebugEnabled()) {
                AbstractTrafficShapingHandler.logger.debug("Unsuspend final status => " + config.isAutoRead() + ':' + AbstractTrafficShapingHandler.isHandlerActive(this.ctx));
            }
        }
    }

    void releaseReadSuspended(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        channel.attr(READ_SUSPENDED).set(false);
        channel.config().setAutoRead(true);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        long size = calculateSize(msg);
        long now = TrafficCounter.milliSecondFromNano();
        if (size > 0) {
            long wait = checkWaitReadTime(ctx, this.trafficCounter.readTimeToWait(size, this.readLimit, this.maxTime, now), now);
            if (wait >= MINIMAL_WAIT) {
                Channel channel = ctx.channel();
                ChannelConfig config = channel.config();
                if (logger.isDebugEnabled()) {
                    logger.debug("Read suspend: " + wait + ':' + config.isAutoRead() + ':' + isHandlerActive(ctx));
                }
                if (config.isAutoRead() && isHandlerActive(ctx)) {
                    config.setAutoRead(false);
                    channel.attr(READ_SUSPENDED).set(true);
                    Attribute<Runnable> attr = channel.attr(REOPEN_TASK);
                    Runnable reopenTask = attr.get();
                    if (reopenTask == null) {
                        reopenTask = new ReopenReadTimerTask(ctx);
                        attr.set(reopenTask);
                    }
                    ctx.executor().schedule(reopenTask, wait, TimeUnit.MILLISECONDS);
                    if (logger.isDebugEnabled()) {
                        logger.debug("Suspend final status => " + config.isAutoRead() + ':' + isHandlerActive(ctx) + " will reopened at: " + wait);
                    }
                }
            }
        }
        informReadOperation(ctx, now);
        ctx.fireChannelRead(msg);
    }

    @Override // p013io.netty.channel.ChannelHandlerAdapter, p013io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        if (channel.hasAttr(REOPEN_TASK)) {
            channel.attr(REOPEN_TASK).set(null);
        }
        handlerRemoved(ctx);
    }

    long checkWaitReadTime(ChannelHandlerContext ctx, long wait, long now) {
        return wait;
    }

    void informReadOperation(ChannelHandlerContext ctx, long now) {
    }

    protected static boolean isHandlerActive(ChannelHandlerContext ctx) {
        Boolean suspended = (Boolean) ctx.channel().attr(READ_SUSPENDED).get();
        return suspended == null || Boolean.FALSE.equals(suspended);
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext ctx) {
        if (isHandlerActive(ctx)) {
            ctx.read();
        }
    }

    @Override // p013io.netty.channel.ChannelDuplexHandler, p013io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        long size = calculateSize(msg);
        long now = TrafficCounter.milliSecondFromNano();
        if (size > 0) {
            long wait = this.trafficCounter.writeTimeToWait(size, this.writeLimit, this.maxTime, now);
            if (wait >= MINIMAL_WAIT) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Write suspend: " + wait + ':' + ctx.channel().config().isAutoRead() + ':' + isHandlerActive(ctx));
                }
                submitWrite(ctx, msg, size, wait, now, promise);
                return;
            }
        }
        submitWrite(ctx, msg, size, 0, now, promise);
    }

    @Deprecated
    protected void submitWrite(ChannelHandlerContext ctx, Object msg, long delay, ChannelPromise promise) {
        submitWrite(ctx, msg, calculateSize(msg), delay, TrafficCounter.milliSecondFromNano(), promise);
    }

    @Override // p013io.netty.channel.ChannelInboundHandlerAdapter, p013io.netty.channel.ChannelInboundHandler
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        setUserDefinedWritability(ctx, true);
        channelRegistered(ctx);
    }

    void setUserDefinedWritability(ChannelHandlerContext ctx, boolean writable) {
        ChannelOutboundBuffer cob = ctx.channel().unsafe().outboundBuffer();
        if (cob != null) {
            cob.setUserDefinedWritability(this.userDefinedWritabilityIndex, writable);
        }
    }

    void checkWriteSuspend(ChannelHandlerContext ctx, long delay, long queueSize) {
        if (queueSize > this.maxWriteSize || delay > this.maxWriteDelay) {
            setUserDefinedWritability(ctx, false);
        }
    }

    void releaseWriteSuspended(ChannelHandlerContext ctx) {
        setUserDefinedWritability(ctx, true);
    }

    public TrafficCounter trafficCounter() {
        return this.trafficCounter;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder((int) PacketOpcodes.ExecuteGroupTriggerReq).append("TrafficShaping with Write Limit: ").append(this.writeLimit).append(" Read Limit: ").append(this.readLimit).append(" CheckInterval: ").append(this.checkInterval).append(" maxDelay: ").append(this.maxWriteDelay).append(" maxSize: ").append(this.maxWriteSize).append(" and Counter: ");
        if (this.trafficCounter != null) {
            builder.append(this.trafficCounter);
        } else {
            builder.append("none");
        }
        return builder.toString();
    }

    protected long calculateSize(Object msg) {
        if (msg instanceof ByteBuf) {
            return (long) ((ByteBuf) msg).readableBytes();
        }
        if (msg instanceof ByteBufHolder) {
            return (long) ((ByteBufHolder) msg).content().readableBytes();
        }
        if (msg instanceof FileRegion) {
            return ((FileRegion) msg).count();
        }
        return -1;
    }
}
