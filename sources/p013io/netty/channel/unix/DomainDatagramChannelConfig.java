package p013io.netty.channel.unix;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;

/* renamed from: io.netty.channel.unix.DomainDatagramChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/unix/DomainDatagramChannelConfig.class */
public interface DomainDatagramChannelConfig extends ChannelConfig {
    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setConnectTimeoutMillis(int i);

    @Override // p013io.netty.channel.ChannelConfig
    @Deprecated
    DomainDatagramChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    DomainDatagramChannelConfig setSendBufferSize(int i);

    int getSendBufferSize();

    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // p013io.netty.channel.ChannelConfig
    DomainDatagramChannelConfig setWriteSpinCount(int i);
}
