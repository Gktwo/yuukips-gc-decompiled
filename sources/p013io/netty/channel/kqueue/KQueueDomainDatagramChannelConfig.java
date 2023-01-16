package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.util.Map;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.ChannelOption;
import p013io.netty.channel.FixedRecvByteBufAllocator;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;
import p013io.netty.channel.unix.DomainDatagramChannelConfig;

/* renamed from: io.netty.channel.kqueue.KQueueDomainDatagramChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueDomainDatagramChannelConfig.class */
public final class KQueueDomainDatagramChannelConfig extends KQueueChannelConfig implements DomainDatagramChannelConfig {
    private static final RecvByteBufAllocator DEFAULT_RCVBUF_ALLOCATOR = new FixedRecvByteBufAllocator(2048);
    private boolean activeOnOpen;

    /* access modifiers changed from: package-private */
    public KQueueDomainDatagramChannelConfig(KQueueDomainDatagramChannel channel) {
        super(channel);
        setRecvByteBufAllocator(DEFAULT_RCVBUF_ALLOCATOR);
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public Map<ChannelOption<?>, Object> getOptions() {
        return getOptions(getOptions(), ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, ChannelOption.SO_SNDBUF);
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> T getOption(ChannelOption<T> option) {
        if (option == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            return (T) Boolean.valueOf(this.activeOnOpen);
        }
        if (option == ChannelOption.SO_SNDBUF) {
            return (T) Integer.valueOf(getSendBufferSize());
        }
        return (T) getOption(option);
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public <T> boolean setOption(ChannelOption<T> option, T value) {
        validate(option, value);
        if (option == ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION) {
            setActiveOnOpen(((Boolean) value).booleanValue());
            return true;
        } else if (option != ChannelOption.SO_SNDBUF) {
            return setOption(option, value);
        } else {
            setSendBufferSize(((Integer) value).intValue());
            return true;
        }
    }

    private void setActiveOnOpen(boolean activeOnOpen) {
        if (this.channel.isRegistered()) {
            throw new IllegalStateException("Can only changed before channel was registered");
        }
        this.activeOnOpen = activeOnOpen;
    }

    /* access modifiers changed from: package-private */
    public boolean getActiveOnOpen() {
        return this.activeOnOpen;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setAllocator(ByteBufAllocator allocator) {
        setAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setAutoClose(boolean autoClose) {
        setAutoClose(autoClose);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setAutoRead(boolean autoRead) {
        setAutoRead(autoRead);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setConnectTimeoutMillis(int connectTimeoutMillis) {
        setConnectTimeoutMillis(connectTimeoutMillis);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    public KQueueDomainDatagramChannelConfig setMaxMessagesPerRead(int maxMessagesPerRead) {
        setMaxMessagesPerRead(maxMessagesPerRead);
        return this;
    }

    @Override // p013io.netty.channel.DefaultChannelConfig
    public KQueueDomainDatagramChannelConfig setMaxMessagesPerWrite(int maxMessagesPerWrite) {
        setMaxMessagesPerWrite(maxMessagesPerWrite);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator estimator) {
        setMessageSizeEstimator(estimator);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig
    public KQueueDomainDatagramChannelConfig setRcvAllocTransportProvidesGuess(boolean transportProvidesGuess) {
        setRcvAllocTransportProvidesGuess(transportProvidesGuess);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator allocator) {
        setRecvByteBufAllocator(allocator);
        return this;
    }

    @Override // p013io.netty.channel.unix.DomainDatagramChannelConfig
    public KQueueDomainDatagramChannelConfig setSendBufferSize(int sendBufferSize) {
        try {
            ((KQueueDomainDatagramChannel) this.channel).socket.setSendBufferSize(sendBufferSize);
            return this;
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.unix.DomainDatagramChannelConfig
    public int getSendBufferSize() {
        try {
            return ((KQueueDomainDatagramChannel) this.channel).socket.getSendBufferSize();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark) {
        setWriteBufferWaterMark(writeBufferWaterMark);
        return this;
    }

    @Override // p013io.netty.channel.kqueue.KQueueChannelConfig, p013io.netty.channel.DefaultChannelConfig, p013io.netty.channel.ChannelConfig
    public KQueueDomainDatagramChannelConfig setWriteSpinCount(int writeSpinCount) {
        setWriteSpinCount(writeSpinCount);
        return this;
    }
}
