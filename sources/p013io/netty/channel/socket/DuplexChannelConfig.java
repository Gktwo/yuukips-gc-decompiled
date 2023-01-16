package p013io.netty.channel.socket;

import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.ChannelConfig;
import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.WriteBufferWaterMark;

/* renamed from: io.netty.channel.socket.DuplexChannelConfig */
/* loaded from: grasscutter.jar:io/netty/channel/socket/DuplexChannelConfig.class */
public interface DuplexChannelConfig extends ChannelConfig {
    boolean isAllowHalfClosure();

    DuplexChannelConfig setAllowHalfClosure(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    @Deprecated
    DuplexChannelConfig setMaxMessagesPerRead(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DuplexChannelConfig setWriteSpinCount(int i);

    @Override // p013io.netty.channel.ChannelConfig
    DuplexChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    DuplexChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    @Override // p013io.netty.channel.ChannelConfig
    DuplexChannelConfig setAutoRead(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    DuplexChannelConfig setAutoClose(boolean z);

    @Override // p013io.netty.channel.ChannelConfig
    DuplexChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    @Override // p013io.netty.channel.ChannelConfig
    DuplexChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);
}
