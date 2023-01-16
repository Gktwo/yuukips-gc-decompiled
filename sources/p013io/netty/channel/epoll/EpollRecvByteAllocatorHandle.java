package p013io.netty.channel.epoll;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.unix.PreferredDirectByteBufAllocator;
import p013io.netty.util.UncheckedBooleanSupplier;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.epoll.EpollRecvByteAllocatorHandle */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollRecvByteAllocatorHandle.class */
public class EpollRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle implements RecvByteBufAllocator.ExtendedHandle {
    private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() { // from class: io.netty.channel.epoll.EpollRecvByteAllocatorHandle.1
        @Override // p013io.netty.util.UncheckedBooleanSupplier, p013io.netty.util.BooleanSupplier
        public boolean get() {
            return EpollRecvByteAllocatorHandle.this.maybeMoreDataToRead();
        }
    };
    private boolean isEdgeTriggered;
    private boolean receivedRdHup;

    /* access modifiers changed from: package-private */
    public EpollRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle handle) {
        super(handle);
    }

    /* access modifiers changed from: package-private */
    public final void receivedRdHup() {
        this.receivedRdHup = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isReceivedRdHup() {
        return this.receivedRdHup;
    }

    /* access modifiers changed from: package-private */
    public boolean maybeMoreDataToRead() {
        return (this.isEdgeTriggered && lastBytesRead() > 0) || (!this.isEdgeTriggered && lastBytesRead() == attemptedBytesRead());
    }

    /* access modifiers changed from: package-private */
    public final void edgeTriggered(boolean edgeTriggered) {
        this.isEdgeTriggered = edgeTriggered;
    }

    final boolean isEdgeTriggered() {
        return this.isEdgeTriggered;
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.DelegatingHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
    public final ByteBuf allocate(ByteBufAllocator alloc) {
        this.preferredDirectByteBufAllocator.updateAllocator(alloc);
        return delegate().allocate(this.preferredDirectByteBufAllocator);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.ExtendedHandle
    public final boolean continueReading(UncheckedBooleanSupplier maybeMoreDataSupplier) {
        return ((RecvByteBufAllocator.ExtendedHandle) delegate()).continueReading(maybeMoreDataSupplier);
    }

    @Override // p013io.netty.channel.RecvByteBufAllocator.DelegatingHandle, p013io.netty.channel.RecvByteBufAllocator.Handle
    public final boolean continueReading() {
        return continueReading(this.defaultMaybeMoreDataSupplier);
    }
}
