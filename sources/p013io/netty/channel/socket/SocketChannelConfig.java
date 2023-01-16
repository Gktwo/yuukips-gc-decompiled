package p013io.netty.channel.socket;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;

/* renamed from: io.netty.channel.socket.SocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/SocketChannelConfig.class */
public interface SocketChannelConfig extends DuplexChannelConfig {
    boolean isTcpNoDelay();

    SocketChannelConfig setTcpNoDelay(boolean z);

    int getSoLinger();

    SocketChannelConfig setSoLinger(int i);

    int getSendBufferSize();

    SocketChannelConfig setSendBufferSize(int i);

    int getReceiveBufferSize();

    SocketChannelConfig setReceiveBufferSize(int i);

    boolean isKeepAlive();

    SocketChannelConfig setKeepAlive(boolean z);

    int getTrafficClass();

    SocketChannelConfig setTrafficClass(int i);

    boolean isReuseAddress();

    SocketChannelConfig setReuseAddress(boolean z);

    SocketChannelConfig setPerformancePreferences(int i, int i2, int i3);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig
    SocketChannelConfig setAllowHalfClosure(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    SocketChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    @Deprecated
    SocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // p013io.netty.channel.socket.DuplexChannelConfig, p013io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);
}
