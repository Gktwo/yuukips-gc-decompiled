package p013io.netty.channel;

import p013io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;

/* renamed from: io.netty.channel.ServerChannelRecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/ServerChannelRecvByteBufAllocator.class */
public final class ServerChannelRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    public ServerChannelRecvByteBufAllocator() {
        super(1, true);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator
    public RecvByteBufAllocator.Handle newHandle() {
        return new DefaultMaxMessagesRecvByteBufAllocator.MaxMessageHandle() { // from class: io.netty.channel.ServerChannelRecvByteBufAllocator.1
            @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
            public int guess() {
                return 128;
            }
        };
    }
}
