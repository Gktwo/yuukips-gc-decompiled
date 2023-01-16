package p013io.netty.channel.epoll;

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
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.epoll.EpollChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollChannelConfig.class */
public class EpollChannelConfig extends DefaultChannelConfig {
    private volatile long maxBytesPerGatheringWrite = Limits.SSIZE_MAX;

    /* access modifiers changed from: package-private */
    public EpollChannelConfig(AbstractEpollChannel channel) {
        super(channel);
    }

    /* access modifiers changed from: package-private */
    public EpollChannelConfig(AbstractEpollChannel channel, RecvByteBufAllocator recvByteBufAllocator) {
        super(channel, recvByteBufAllocator);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), EpollChannelOption.EPOLL_MODE);
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == EpollChannelOption.EPOLL_MODE) {
            return (T) getEpollMode();
        }
        try {
            if (option instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption opt = (IntegerUnixChannelOption) option;
                return (T) Integer.valueOf(((AbstractEpollChannel) this.channel).socket.getIntOpt(opt.level(), opt.optname()));
            } else if (!(option instanceof RawUnixChannelOption)) {
                return (T) getOption(option);
            } else {
                RawUnixChannelOption opt2 = (RawUnixChannelOption) option;
                ByteBuffer out = ByteBuffer.allocate(opt2.length());
                ((AbstractEpollChannel) this.channel).socket.getRawOpt(opt2.level(), opt2.optname(), out);
                return (T) out.flip();
            }
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == EpollChannelOption.EPOLL_MODE) {
            setEpollMode((EpollMode) value);
            return true;
        }
        try {
            if (option instanceof IntegerUnixChannelOption) {
                IntegerUnixChannelOption opt = (IntegerUnixChannelOption) option;
                ((AbstractEpollChannel) this.channel).socket.setIntOpt(opt.level(), opt.optname(), ((Integer) value).intValue());
                return true;
            } else if (!(option instanceof RawUnixChannelOption)) {
                return setOption(option, value);
            } else {
                RawUnixChannelOption opt2 = (RawUnixChannelOption) option;
                ((AbstractEpollChannel) this.channel).socket.setRawOpt(opt2.level(), opt2.optname(), (ByteBuffer) value);
                return true;
            }
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        if (!(allocator.newHandle() instanceof RecvByteBufAllocator.ExtendedHandle)) {
            throw new IllegalArgumentException("allocator.newHandle() must return an object of type: " + RecvByteBufAllocator.ExtendedHandle.class);
        }
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollChannelConfig setWriteBufferHighWaterMark(int writeBufferHighWaterMark) {
        setWriteBufferHighWaterMark(writeBufferHighWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public EpollChannelConfig setWriteBufferLowWaterMark(int writeBufferLowWaterMark) {
        setWriteBufferLowWaterMark(writeBufferLowWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public EpollChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    public EpollMode getEpollMode() {
        return ((AbstractEpollChannel) this.channel).isFlagSet(Native.EPOLLET) ? EpollMode.EDGE_TRIGGERED : EpollMode.LEVEL_TRIGGERED;
    }

    public EpollChannelConfig setEpollMode(EpollMode mode) {
        ObjectUtil.checkNotNull(mode, "mode");
        try {
            switch (mode) {
                case EDGE_TRIGGERED:
                    checkChannelNotRegistered();
                    ((AbstractEpollChannel) this.channel).setFlag(Native.EPOLLET);
                    break;
                case LEVEL_TRIGGERED:
                    checkChannelNotRegistered();
                    ((AbstractEpollChannel) this.channel).clearFlag(Native.EPOLLET);
                    break;
                default:
                    throw new Error();
            }
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    private void checkChannelNotRegistered() {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("EpollMode can only be changed before channel is registered");
        }
    }

    @Override // p013io.netty.channel.DefaultChannelConfig
    protected final void autoReadCleared() {
        ((AbstractEpollChannel) this.channel).clearEpollIn();
    }

    /* access modifiers changed from: package-private */
    public final void setMaxBytesPerGatheringWrite(long maxBytesPerGatheringWrite) {
        this.maxBytesPerGatheringWrite = maxBytesPerGatheringWrite;
    }

    /* access modifiers changed from: package-private */
    public final long getMaxBytesPerGatheringWrite() {
        return this.maxBytesPerGatheringWrite;
    }
}
