package p013io.netty.channel;

import p013io.netty.channel.MessageSizeEstimator;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.PendingBytesTracker */
/* loaded from: grasscutter.jar:io/netty/channel/PendingBytesTracker.class */
abstract class PendingBytesTracker implements MessageSizeEstimator.Handle {
    private final MessageSizeEstimator.Handle estimatorHandle;

    public abstract void incrementPendingOutboundBytes(long j);

    public abstract void decrementPendingOutboundBytes(long j);

    private PendingBytesTracker(MessageSizeEstimator.Handle estimatorHandle) {
        this.estimatorHandle = (MessageSizeEstimator.Handle) ObjectUtil.checkNotNull(estimatorHandle, "estimatorHandle");
    }

    @Override // p013io.netty.channel.MessageSizeEstimator.Handle
    public final int size(Object msg) {
        return this.estimatorHandle.size(msg);
    }

    /* access modifiers changed from: package-private */
    public static PendingBytesTracker newTracker(Channel channel) {
        if (channel.pipeline() instanceof DefaultChannelPipeline) {
            return new DefaultChannelPipelinePendingBytesTracker((DefaultChannelPipeline) channel.pipeline());
        }
        ChannelOutboundBuffer buffer = channel.unsafe().outboundBuffer();
        MessageSizeEstimator.Handle handle = channel.config().getMessageSizeEstimator().newHandle();
        return buffer == null ? new NoopPendingBytesTracker(handle) : new ChannelOutboundBufferPendingBytesTracker(buffer, handle);
    }

    /* renamed from: io.netty.channel.PendingBytesTracker$DefaultChannelPipelinePendingBytesTracker */
    /* loaded from: grasscutter.jar:io/netty/channel/PendingBytesTracker$DefaultChannelPipelinePendingBytesTracker.class */
    private static final class DefaultChannelPipelinePendingBytesTracker extends PendingBytesTracker {
        private final DefaultChannelPipeline pipeline;

        DefaultChannelPipelinePendingBytesTracker(DefaultChannelPipeline pipeline) {
            super(pipeline.estimatorHandle());
            this.pipeline = pipeline;
        }

        @Override // p013io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long bytes) {
            this.pipeline.incrementPendingOutboundBytes(bytes);
        }

        @Override // p013io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long bytes) {
            this.pipeline.decrementPendingOutboundBytes(bytes);
        }
    }

    /* renamed from: io.netty.channel.PendingBytesTracker$ChannelOutboundBufferPendingBytesTracker */
    /* loaded from: grasscutter.jar:io/netty/channel/PendingBytesTracker$ChannelOutboundBufferPendingBytesTracker.class */
    private static final class ChannelOutboundBufferPendingBytesTracker extends PendingBytesTracker {
        private final ChannelOutboundBuffer buffer;

        ChannelOutboundBufferPendingBytesTracker(ChannelOutboundBuffer buffer, MessageSizeEstimator.Handle estimatorHandle) {
            super(estimatorHandle);
            this.buffer = buffer;
        }

        @Override // p013io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long bytes) {
            this.buffer.incrementPendingOutboundBytes(bytes);
        }

        @Override // p013io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long bytes) {
            this.buffer.decrementPendingOutboundBytes(bytes);
        }
    }

    /* renamed from: io.netty.channel.PendingBytesTracker$NoopPendingBytesTracker */
    /* loaded from: grasscutter.jar:io/netty/channel/PendingBytesTracker$NoopPendingBytesTracker.class */
    private static final class NoopPendingBytesTracker extends PendingBytesTracker {
        NoopPendingBytesTracker(MessageSizeEstimator.Handle estimatorHandle) {
            super(estimatorHandle);
        }

        @Override // p013io.netty.channel.PendingBytesTracker
        public void incrementPendingOutboundBytes(long bytes) {
        }

        @Override // p013io.netty.channel.PendingBytesTracker
        public void decrementPendingOutboundBytes(long bytes) {
        }
    }
}
