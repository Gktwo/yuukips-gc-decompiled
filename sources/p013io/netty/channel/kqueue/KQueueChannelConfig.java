package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.DefaultChannelConfig;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.unix.IntegerUnixChannelOption;
import p013io.netty.channel.unix.Limits;
import p013io.netty.channel.unix.RawUnixChannelOption;

/* renamed from: io.netty.channel.kqueue.KQueueChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueChannelConfig.class */
public class KQueueChannelConfig extends DefaultChannelConfig {
    private volatile boolean transportProvidesGuess;
    private volatile long maxBytesPerGatheringWrite = Limits.SSIZE_MAX;

    /* access modifiers changed from: package-private */
    public KQueueChannelConfig(AbstractKQueueChannel channel) {
        super(channel);
    }

    /* access modifiers changed from: package-private */
    public KQueueChannelConfig(AbstractKQueueChannel channel, RecvByteBufAllocator recvByteBufAllocator) {
        super(channel, recvByteBufAllocator);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS) {
            return (T) Boolean.valueOf(getRcvAllocTransportProvidesGuess());
        }
        try {
            if (option instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption opt = (IntegerUnixChannelOption) option;
                return (T) Integer.valueOf(((AbstractKQueueChannel) this.channel).socket.getIntOpt(opt.level(), opt.optname()));
            } else if (!(option instanceof RawUnixChannelOption)) {
                return (T) getOption(option);
            } else {
                RawUnixChannelOption opt2 = (RawUnixChannelOption) option;
                ByteBuffer out = ByteBuffer.allocate(opt2.length());
                ((AbstractKQueueChannel) this.channel).socket.getRawOpt(opt2.level(), opt2.optname(), out);
                return (T) out.flip();
            }
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == KQueueChannelOption.RCV_ALLOC_TRANSPORT_PROVIDES_GUESS) {
            setRcvAllocTransportProvidesGuess(((Boolean) value).booleanValue());
            return true;
        }
        try {
            if (option instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption opt = (IntegerUnixChannelOption) option;
                ((AbstractKQueueChannel) this.channel).socket.setIntOpt(opt.level(), opt.optname(), ((Integer) value).intValue());
                return true;
            } else if (!(option instanceof RawUnixChannelOption)) {
                return setOption(option, value);
            } else {
                RawUnixChannelOption opt2 = (RawUnixChannelOption) option;
                ((AbstractKQueueChannel) this.channel).socket.setRawOpt(opt2.level(), opt2.optname(), (ByteBuffer) value);
                return true;
            }
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    public KQueueChannelConfig setRcvAllocTransportProvidesGuess(boolean transportProvidesGuess) {
        this.transportProvidesGuess = transportProvidesGuess;
        return this;
    }

    public boolean getRcvAllocTransportProvidesGuess() {
        return this.transportProvidesGuess;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        if (!(allocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle)) {
            throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
        }
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig
    protected final void autoReadCleared() {
        ((AbstractKQueueChannel) this.channel).clearReadFilter();
    }

    /* access modifiers changed from: package-private */
    public final void setMaxBytesPerGatheringWrite(long maxBytesPerGatheringWrite) {
        this.maxBytesPerGatheringWrite = Math.min(Limits.SSIZE_MAX, maxBytesPerGatheringWrite);
    }

    /* access modifiers changed from: package-private */
    public final long getMaxBytesPerGatheringWrite() {
        return this.maxBytesPerGatheringWrite;
    }
}
