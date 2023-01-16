package p013io.netty.channel.epoll;

import p013io.netty.channel.RecvByteBufAllocator;

/* renamed from: io.netty.channel.epoll.EpollRecvByteAllocatorStreamingHandle */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollRecvByteAllocatorStreamingHandle.class */
final class EpollRecvByteAllocatorStreamingHandle extends EpollRecvByteAllocatorHandle {
    /* access modifiers changed from: package-private */
    public EpollRecvByteAllocatorStreamingHandle(RecvByteBufAllocator.ExtendedHandle handle) {
        super(handle);
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.channel.epoll.EpollRecvByteAllocatorHandle
    public boolean maybeMoreDataToRead() {
        return lastBytesRead() == attemptedBytesRead() || isReceivedRdHup();
    }
}
