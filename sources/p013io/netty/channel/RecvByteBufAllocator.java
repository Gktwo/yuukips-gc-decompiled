package p013io.netty.channel;

import net.bytebuddy.implementation.MethodDelegation;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufAllocator;
import p013io.netty.util.UncheckedBooleanSupplier;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.RecvByteBufAllocator */
/* loaded from: grasscutter.jar:io/netty/channel/RecvByteBufAllocator.class */
public interface RecvByteBufAllocator {

    /* renamed from: io.netty.channel.RecvByteBufAllocator$ExtendedHandle */
    /* loaded from: grasscutter.jar:io/netty/channel/RecvByteBufAllocator$ExtendedHandle.class */
    public interface ExtendedHandle extends Handle {
        boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier);
    }

    @Deprecated
    /* renamed from: io.netty.channel.RecvByteBufAllocator$Handle */
    /* loaded from: grasscutter.jar:io/netty/channel/RecvByteBufAllocator$Handle.class */
    public interface Handle {
        ByteBuf allocate(ByteBufAllocator byteBufAllocator);

        int guess();

        void reset(ChannelConfig channelConfig);

        void incMessagesRead(int i);

        void lastBytesRead(int i);

        int lastBytesRead();

        void attemptedBytesRead(int i);

        int attemptedBytesRead();

        boolean continueReading();

        void readComplete();
    }

    Handle newHandle();

    /* renamed from: io.netty.channel.RecvByteBufAllocator$DelegatingHandle */
    /* loaded from: grasscutter.jar:io/netty/channel/RecvByteBufAllocator$DelegatingHandle.class */
    public static class DelegatingHandle implements Handle {
        private final Handle delegate;

        public DelegatingHandle(Handle delegate) {
            this.delegate = (Handle) ObjectUtil.checkNotNull(delegate, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        }

        protected final Handle delegate() {
            return this.delegate;
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public ByteBuf allocate(ByteBufAllocator alloc) {
            return this.delegate.allocate(alloc);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int guess() {
            return this.delegate.guess();
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void reset(ChannelConfig config) {
            this.delegate.reset(config);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void incMessagesRead(int numMessages) {
            this.delegate.incMessagesRead(numMessages);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void lastBytesRead(int bytes) {
            this.delegate.lastBytesRead(bytes);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int lastBytesRead() {
            return this.delegate.lastBytesRead();
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public boolean continueReading() {
            return this.delegate.continueReading();
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public int attemptedBytesRead() {
            return this.delegate.attemptedBytesRead();
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void attemptedBytesRead(int bytes) {
            this.delegate.attemptedBytesRead(bytes);
        }

        @Override // p013io.netty.channel.RecvByteBufAllocator.Handle
        public void readComplete() {
            this.delegate.readComplete();
        }
    }
}
