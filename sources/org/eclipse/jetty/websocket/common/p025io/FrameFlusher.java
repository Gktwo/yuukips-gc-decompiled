package org.eclipse.jetty.websocket.common.p025io;

import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.Generator;
import org.eclipse.jetty.websocket.common.frames.BinaryFrame;

/* renamed from: org.eclipse.jetty.websocket.common.io.FrameFlusher */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/FrameFlusher.class */
public class FrameFlusher extends IteratingCallback {
    public static final BinaryFrame FLUSH_FRAME = new BinaryFrame();
    private static final Logger LOG = Log.getLogger(FrameFlusher.class);
    private final ByteBufferPool bufferPool;
    private final EndPoint endPoint;
    private final int bufferSize;
    private final Generator generator;
    private final int maxGather;
    private final List<FrameEntry> entries;
    private final List<ByteBuffer> buffers;
    private boolean closed;
    private Throwable terminated;
    private ByteBuffer aggregate;
    private BatchMode batchMode;
    private final Deque<FrameEntry> queue = new ArrayDeque();
    private final LongAdder messagesOut = new LongAdder();
    private final LongAdder bytesOut = new LongAdder();
    private boolean canEnqueue = true;

    public FrameFlusher(ByteBufferPool bufferPool, Generator generator, EndPoint endPoint, int bufferSize, int maxGather) {
        this.bufferPool = bufferPool;
        this.endPoint = endPoint;
        this.bufferSize = bufferSize;
        this.generator = (Generator) Objects.requireNonNull(generator);
        this.maxGather = maxGather;
        this.entries = new ArrayList(maxGather);
        this.buffers = new ArrayList((maxGather * 2) + 1);
    }

    public boolean enqueue(Frame frame, WriteCallback callback, BatchMode batchMode) {
        Throwable dead;
        FrameEntry entry = new FrameEntry(frame, callback, batchMode);
        synchronized (this) {
            if (this.canEnqueue) {
                dead = this.terminated;
                if (dead == null) {
                    byte opCode = frame.getOpCode();
                    if (opCode == 9 || opCode == 10) {
                        this.queue.offerFirst(entry);
                    } else {
                        this.queue.offerLast(entry);
                    }
                    if (opCode == 8) {
                        this.canEnqueue = false;
                    }
                }
            } else {
                dead = new ClosedChannelException();
            }
        }
        if (dead != null) {
            notifyCallbackFailure(callback, dead);
            return false;
        } else if (!LOG.isDebugEnabled()) {
            return true;
        } else {
            LOG.debug("Enqueued {} to {}", entry, this);
            return true;
        }
    }

    @Override // org.eclipse.jetty.util.IteratingCallback
    protected IteratingCallback.Action process() throws Throwable {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Flushing {}", this);
        }
        int space = this.aggregate == null ? this.bufferSize : BufferUtil.space(this.aggregate);
        BatchMode currentBatchMode = BatchMode.AUTO;
        synchronized (this) {
            if (this.closed) {
                return IteratingCallback.Action.SUCCEEDED;
            } else if (this.terminated != null) {
                throw this.terminated;
            } else {
                while (!this.queue.isEmpty() && this.entries.size() < this.maxGather) {
                    FrameEntry entry = this.queue.poll();
                    currentBatchMode = BatchMode.max(currentBatchMode, entry.batchMode);
                    this.messagesOut.increment();
                    if (entry.frame == FLUSH_FRAME) {
                        currentBatchMode = BatchMode.OFF;
                    }
                    int approxFrameLength = 28 + BufferUtil.length(entry.frame.getPayload());
                    if (approxFrameLength > (this.bufferSize >> 2)) {
                        currentBatchMode = BatchMode.OFF;
                    }
                    space -= approxFrameLength;
                    if (space <= 0) {
                        currentBatchMode = BatchMode.OFF;
                    }
                    this.entries.add(entry);
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} processing {} entries: {}", this, Integer.valueOf(this.entries.size()), this.entries);
                }
                if (!this.entries.isEmpty()) {
                    this.batchMode = currentBatchMode;
                    return currentBatchMode == BatchMode.OFF ? flush() : batch();
                } else if (this.batchMode != BatchMode.AUTO) {
                    releaseAggregate();
                    return IteratingCallback.Action.IDLE;
                } else {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("{} auto flushing", this);
                    }
                    return flush();
                }
            }
        }
    }

    private IteratingCallback.Action batch() {
        if (this.aggregate == null) {
            this.aggregate = this.bufferPool.acquire(this.bufferSize, true);
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} acquired aggregate buffer {}", this, this.aggregate);
            }
        }
        for (FrameEntry entry : this.entries) {
            entry.generateHeaderBytes(this.aggregate);
            ByteBuffer payload = entry.frame.getPayload();
            if (BufferUtil.hasContent(payload)) {
                BufferUtil.append(this.aggregate, payload);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} aggregated {} frames: {}", this, Integer.valueOf(this.entries.size()), this.entries);
        }
        succeeded();
        return IteratingCallback.Action.SCHEDULED;
    }

    private IteratingCallback.Action flush() {
        if (!BufferUtil.isEmpty(this.aggregate)) {
            this.buffers.add(this.aggregate);
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} flushing aggregate {}", this, this.aggregate);
            }
        }
        for (FrameEntry entry : this.entries) {
            if (entry.frame != FLUSH_FRAME) {
                this.buffers.add(entry.generateHeaderBytes());
                ByteBuffer payload = entry.frame.getPayload();
                if (BufferUtil.hasContent(payload)) {
                    this.buffers.add(payload);
                }
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} flushing {} frames: {}", this, Integer.valueOf(this.entries.size()), this.entries);
        }
        if (this.buffers.isEmpty()) {
            releaseAggregate();
            succeedEntries();
            return IteratingCallback.Action.IDLE;
        }
        int i = 0;
        int bytes = 0;
        ByteBuffer[] bufferArray = new ByteBuffer[this.buffers.size()];
        for (ByteBuffer bb : this.buffers) {
            bytes += bb.limit() - bb.position();
            i++;
            bufferArray[i] = bb;
        }
        this.bytesOut.add((long) bytes);
        this.endPoint.write(this, (ByteBuffer[]) this.buffers.toArray(new ByteBuffer[this.buffers.size()]));
        this.buffers.clear();
        return IteratingCallback.Action.SCHEDULED;
    }

    private int getQueueSize() {
        int size;
        synchronized (this) {
            size = this.queue.size();
        }
        return size;
    }

    @Override // org.eclipse.jetty.util.IteratingCallback, org.eclipse.jetty.util.Callback
    public void succeeded() {
        succeedEntries();
        succeeded();
    }

    private void succeedEntries() {
        for (FrameEntry entry : this.entries) {
            notifyCallbackSuccess(entry.callback);
            entry.release();
            if (entry.frame.getOpCode() == 8) {
                synchronized (this) {
                    this.closed = true;
                }
                this.endPoint.shutdownOutput();
            }
        }
        this.entries.clear();
    }

    @Override // org.eclipse.jetty.util.IteratingCallback
    public void onCompleteFailure(Throwable failure) {
        releaseAggregate();
        synchronized (this) {
            if (this.terminated == null) {
                this.terminated = failure;
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Write flush failure", failure);
                }
            }
            this.entries.addAll(this.queue);
            this.queue.clear();
        }
        for (FrameEntry entry : this.entries) {
            notifyCallbackFailure(entry.callback, failure);
            entry.release();
        }
        this.entries.clear();
    }

    private void releaseAggregate() {
        if (BufferUtil.isEmpty(this.aggregate)) {
            this.bufferPool.release(this.aggregate);
            this.aggregate = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void terminate(Throwable cause) {
        Throwable reason;
        synchronized (this) {
            reason = this.terminated;
            if (reason == null) {
                this.terminated = cause;
            }
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[2];
            objArr[0] = reason == null ? "Terminating" : "Terminated";
            objArr[1] = this;
            logger.debug("{} {}", objArr);
        }
        if (reason == null) {
            iterate();
        }
    }

    protected void notifyCallbackSuccess(WriteCallback callback) {
        if (callback != null) {
            try {
                callback.writeSuccess();
            } catch (Throwable x) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Exception while notifying success of callback " + callback, x);
                }
            }
        }
    }

    protected void notifyCallbackFailure(WriteCallback callback, Throwable failure) {
        if (callback != null) {
            try {
                callback.writeFailed(failure);
            } catch (Throwable x) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Exception while notifying failure of callback " + callback, x);
                }
            }
        }
    }

    public long getMessagesOut() {
        return this.messagesOut.longValue();
    }

    public long getBytesOut() {
        return this.bytesOut.longValue();
    }

    @Override // org.eclipse.jetty.util.IteratingCallback
    public String toString() {
        int aggSize = -1;
        ByteBuffer agg = this.aggregate;
        if (agg != null) {
            aggSize = agg.position();
        }
        return String.format("%s[queueSize=%d,aggregateSize=%d,terminated=%s]", toString(), Integer.valueOf(getQueueSize()), Integer.valueOf(aggSize), this.terminated);
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.websocket.common.io.FrameFlusher$FrameEntry */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/FrameFlusher$FrameEntry.class */
    public class FrameEntry {
        private final Frame frame;
        private final WriteCallback callback;
        private final BatchMode batchMode;
        private ByteBuffer headerBuffer;

        private FrameEntry(Frame frame, WriteCallback callback, BatchMode batchMode) {
            this.frame = (Frame) Objects.requireNonNull(frame);
            this.callback = callback;
            this.batchMode = batchMode;
        }

        /* access modifiers changed from: private */
        public ByteBuffer generateHeaderBytes() {
            ByteBuffer generateHeaderBytes = FrameFlusher.this.generator.generateHeaderBytes(this.frame);
            this.headerBuffer = generateHeaderBytes;
            return generateHeaderBytes;
        }

        /* access modifiers changed from: private */
        public void generateHeaderBytes(ByteBuffer buffer) {
            FrameFlusher.this.generator.generateHeaderBytes(this.frame, buffer);
        }

        /* access modifiers changed from: private */
        public void release() {
            if (this.headerBuffer != null) {
                FrameFlusher.this.generator.getBufferPool().release(this.headerBuffer);
                this.headerBuffer = null;
            }
        }

        public String toString() {
            return String.format("%s[%s,%s,%s,%s]", getClass().getSimpleName(), this.frame, this.callback, this.batchMode, FrameFlusher.this.terminated);
        }
    }
}
