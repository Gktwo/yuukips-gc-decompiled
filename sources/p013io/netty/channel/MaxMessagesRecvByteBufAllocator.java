package p013io.netty.channel;

/* renamed from: io.netty.channel.MaxMessagesRecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/MaxMessagesRecvByteBufAllocator.class */
public interface MaxMessagesRecvByteBufAllocator extends RecvByteBufAllocator {
    int maxMessagesPerRead();

    MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int i);
}
