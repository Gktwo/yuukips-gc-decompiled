package p013io.netty.channel;

import java.util.ArrayDeque;
import java.util.Queue;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.ChannelFlushPromiseNotifier */
/* loaded from: grasscutter.jar:io/netty/channel/ChannelFlushPromiseNotifier.class */
public final class ChannelFlushPromiseNotifier {
    private long writeCounter;
    private final Queue<FlushCheckpoint> flushCheckpoints;
    private final boolean tryNotify;

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.channel.ChannelFlushPromiseNotifier$FlushCheckpoint */
    /* loaded from: grasscutter.jar:io/netty/channel/ChannelFlushPromiseNotifier$FlushCheckpoint.class */
    public interface FlushCheckpoint {
        long flushCheckpoint();

        void flushCheckpoint(long j);

        ChannelPromise promise();
    }

    public ChannelFlushPromiseNotifier(boolean tryNotify) {
        this.flushCheckpoints = new ArrayDeque();
        this.tryNotify = tryNotify;
    }

    public ChannelFlushPromiseNotifier() {
        this(false);
    }

    @Deprecated
    public ChannelFlushPromiseNotifier add(ChannelPromise promise, int pendingDataSize) {
        return add(promise, (long) pendingDataSize);
    }

    public ChannelFlushPromiseNotifier add(ChannelPromise promise, long pendingDataSize) {
        ObjectUtil.checkNotNull(promise, "promise");
        ObjectUtil.checkPositiveOrZero(pendingDataSize, "pendingDataSize");
        long checkpoint = this.writeCounter + pendingDataSize;
        if (promise instanceof FlushCheckpoint) {
            FlushCheckpoint cp = (FlushCheckpoint) promise;
            cp.flushCheckpoint(checkpoint);
            this.flushCheckpoints.add(cp);
        } else {
            this.flushCheckpoints.add(new DefaultFlushCheckpoint(checkpoint, promise));
        }
        return this;
    }

    public ChannelFlushPromiseNotifier increaseWriteCounter(long delta) {
        ObjectUtil.checkPositiveOrZero(delta, "delta");
        this.writeCounter += delta;
        return this;
    }

    public long writeCounter() {
        return this.writeCounter;
    }

    public ChannelFlushPromiseNotifier notifyPromises() {
        notifyPromises0(null);
        return this;
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures() {
        return notifyPromises();
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable cause) {
        notifyPromises();
        while (true) {
            FlushCheckpoint cp = this.flushCheckpoints.poll();
            if (cp == null) {
                return this;
            }
            if (this.tryNotify) {
                cp.promise().tryFailure(cause);
            } else {
                cp.promise().setFailure(cause);
            }
        }
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable cause) {
        return notifyPromises(cause);
    }

    public ChannelFlushPromiseNotifier notifyPromises(Throwable cause1, Throwable cause2) {
        notifyPromises0(cause1);
        while (true) {
            FlushCheckpoint cp = this.flushCheckpoints.poll();
            if (cp == null) {
                return this;
            }
            if (this.tryNotify) {
                cp.promise().tryFailure(cause2);
            } else {
                cp.promise().setFailure(cause2);
            }
        }
    }

    @Deprecated
    public ChannelFlushPromiseNotifier notifyFlushFutures(Throwable cause1, Throwable cause2) {
        return notifyPromises(cause1, cause2);
    }

    private void notifyPromises0(Throwable cause) {
        if (this.flushCheckpoints.isEmpty()) {
            this.writeCounter = 0;
            return;
        }
        long writeCounter = this.writeCounter;
        while (true) {
            FlushCheckpoint cp = this.flushCheckpoints.peek();
            if (cp == null) {
                this.writeCounter = 0;
                break;
            } else if (cp.flushCheckpoint() <= writeCounter) {
                this.flushCheckpoints.remove();
                ChannelPromise promise = cp.promise();
                if (cause == null) {
                    if (this.tryNotify) {
                        promise.trySuccess();
                    } else {
                        promise.setSuccess();
                    }
                } else if (this.tryNotify) {
                    promise.tryFailure(cause);
                } else {
                    promise.setFailure(cause);
                }
            } else if (writeCounter > 0 && this.flushCheckpoints.size() == 1) {
                this.writeCounter = 0;
                cp.flushCheckpoint(cp.flushCheckpoint() - writeCounter);
            }
        }
        long newWriteCounter = this.writeCounter;
        if (newWriteCounter >= 549755813888L) {
            this.writeCounter = 0;
            for (FlushCheckpoint cp2 : this.flushCheckpoints) {
                cp2.flushCheckpoint(cp2.flushCheckpoint() - newWriteCounter);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.ChannelFlushPromiseNotifier$DefaultFlushCheckpoint */
    /* loaded from: grasscutter.jar:io/netty/channel/ChannelFlushPromiseNotifier$DefaultFlushCheckpoint.class */
    public static class DefaultFlushCheckpoint implements FlushCheckpoint {
        private long checkpoint;
        private final ChannelPromise future;

        DefaultFlushCheckpoint(long checkpoint, ChannelPromise future) {
            this.checkpoint = checkpoint;
            this.future = future;
        }

        @Override // p013io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public long flushCheckpoint() {
            return this.checkpoint;
        }

        @Override // p013io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public void flushCheckpoint(long checkpoint) {
            this.checkpoint = checkpoint;
        }

        @Override // p013io.netty.channel.ChannelFlushPromiseNotifier.FlushCheckpoint
        public ChannelPromise promise() {
            return this.future;
        }
    }
}
