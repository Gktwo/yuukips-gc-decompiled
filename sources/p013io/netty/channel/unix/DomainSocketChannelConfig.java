package p013io.netty.channel.unix;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;

/* renamed from: io.netty.channel.unix.DomainSocketChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/unix/DomainSocketChannelConfig.class */
public interface DomainSocketChannelConfig extends ChannelConfig {
    @Override // p013io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setWriteBufferHighWaterMark(int i);

    @Override // p013io.netty.channel.ChannelConfig
    @Deprecated
    DomainSocketChannelConfig setWriteBufferLowWaterMark(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // p013io.netty.channel.ChannelConfig
    DomainSocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    DomainSocketChannelConfig setReadMode(DomainSocketReadMode domainSocketReadMode);

    DomainSocketReadMode getReadMode();
}
