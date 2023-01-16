package org.eclipse.jetty.websocket.common.extensions.compress;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.eclipse.jetty.p023io.ByteBufferAccumulator;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.compression.DeflaterPool;
import org.eclipse.jetty.util.compression.InflaterPool;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.OpCode;
import org.eclipse.jetty.websocket.common.extensions.AbstractExtension;
import org.eclipse.jetty.websocket.common.frames.DataFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/compress/CompressExtension.class */
public abstract class CompressExtension extends AbstractExtension {
    protected static final byte[] TAIL_BYTES = {0, 0, -1, -1};
    protected static final ByteBuffer TAIL_BYTES_BUF = ByteBuffer.wrap(TAIL_BYTES);
    private static final Logger LOG = Log.getLogger(CompressExtension.class);
    protected static final int TAIL_DROP_NEVER = 0;
    protected static final int TAIL_DROP_ALWAYS = 1;
    protected static final int TAIL_DROP_FIN_ONLY = 2;
    protected static final int RSV_USE_ALWAYS = 0;
    protected static final int RSV_USE_ONLY_FIRST = 1;
    protected static final int INFLATE_BUFFER_SIZE = 8192;
    protected static final int INPUT_MAX_BUFFER_SIZE = 8192;
    private static final int DECOMPRESS_BUF_SIZE = 8192;
    private DeflaterPool deflaterPool;
    private InflaterPool inflaterPool;
    private Deflater deflaterImpl;
    private Inflater inflaterImpl;
    private int tailDrop;
    private int rsvUse;
    private final Queue<FrameEntry> entries = new ArrayDeque();
    private final IteratingCallback flusher = new Flusher();
    protected AtomicInteger decompressCount = new AtomicInteger(0);

    abstract int getTailDropMode();

    abstract int getRsvUseMode();

    /* access modifiers changed from: protected */
    public CompressExtension() {
        this.tailDrop = 0;
        this.rsvUse = 0;
        this.tailDrop = getTailDropMode();
        this.rsvUse = getRsvUseMode();
    }

    public void setInflaterPool(InflaterPool inflaterPool) {
        this.inflaterPool = inflaterPool;
    }

    public void setDeflaterPool(DeflaterPool deflaterPool) {
        this.deflaterPool = deflaterPool;
    }

    public Deflater getDeflater() {
        if (this.deflaterImpl == null) {
            this.deflaterImpl = this.deflaterPool.acquire();
        }
        return this.deflaterImpl;
    }

    public Inflater getInflater() {
        if (this.inflaterImpl == null) {
            this.inflaterImpl = this.inflaterPool.acquire();
        }
        return this.inflaterImpl;
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.websocket.api.extensions.Extension
    public boolean isRsv1User() {
        return true;
    }

    protected void forwardIncoming(Frame frame, ByteAccumulator accumulator) {
        DataFrame newFrame = new DataFrame(frame);
        newFrame.setRsv1(false);
        ByteBuffer buffer = getBufferPool().acquire(accumulator.getLength(), false);
        try {
            BufferUtil.clearToFill(buffer);
            accumulator.transferTo(buffer);
            newFrame.setPayload(buffer);
            nextIncomingFrame(newFrame);
            getBufferPool().release(buffer);
        } catch (Throwable th) {
            getBufferPool().release(buffer);
            throw th;
        }
    }

    protected ByteAccumulator newByteAccumulator() {
        return new ByteAccumulator(Math.max(getPolicy().getMaxTextMessageSize(), getPolicy().getMaxBinaryMessageSize()), getBufferPool());
    }

    protected void decompress(ByteAccumulator accumulator, ByteBuffer buf) throws DataFormatException {
        int decompressed;
        if (!BufferUtil.isEmpty(buf)) {
            Inflater inflater = getInflater();
            while (buf.hasRemaining() && inflater.needsInput()) {
                if (supplyInput(inflater, buf)) {
                    do {
                        ByteBuffer buffer = accumulator.ensureBuffer(8192);
                        decompressed = inflater.inflate(buffer.array(), buffer.arrayOffset() + buffer.limit(), buffer.capacity() - buffer.limit());
                        buffer.limit(buffer.limit() + decompressed);
                        accumulator.addLength(decompressed);
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Decompressed {} bytes into buffer {} from {}", Integer.valueOf(decompressed), BufferUtil.toDetailString(buffer), toDetail(inflater));
                        }
                    } while (decompressed > 0);
                } else if (LOG.isDebugEnabled()) {
                    LOG.debug("Needed input, but no buffer could supply input", new Object[0]);
                    return;
                } else {
                    return;
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Decompress: exiting {}", toDetail(inflater));
            }
        }
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
    public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        if (this.flusher.isFailed()) {
            notifyCallbackFailure(callback, new ZipException());
            return;
        }
        FrameEntry entry = new FrameEntry(frame, callback, batchMode);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Queuing {}", entry);
        }
        offerEntry(entry);
        this.flusher.iterate();
    }

    private void offerEntry(FrameEntry entry) {
        synchronized (this) {
            this.entries.offer(entry);
        }
    }

    /* access modifiers changed from: private */
    public FrameEntry pollEntry() {
        FrameEntry poll;
        synchronized (this) {
            poll = this.entries.poll();
        }
        return poll;
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

    private static boolean supplyInput(Inflater inflater, ByteBuffer buf) {
        int len;
        int inputOffset;
        byte[] input;
        if (buf != null && buf.remaining() > 0) {
            if (buf.hasArray()) {
                len = buf.remaining();
                input = buf.array();
                inputOffset = buf.position() + buf.arrayOffset();
                buf.position(buf.position() + len);
            } else {
                len = Math.min(8192, buf.remaining());
                input = new byte[len];
                inputOffset = 0;
                buf.get(input, 0, len);
            }
            inflater.setInput(input, inputOffset, len);
            if (!LOG.isDebugEnabled()) {
                return true;
            }
            LOG.debug("Supplied {} input bytes: {}", Integer.valueOf(input.length), toDetail(inflater));
            return true;
        } else if (!LOG.isDebugEnabled()) {
            return false;
        } else {
            LOG.debug("No data left left to supply to Inflater", new Object[0]);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static boolean supplyInput(Deflater deflater, ByteBuffer buf) {
        int len;
        int inputOffset;
        byte[] input;
        if (buf != null && buf.remaining() > 0) {
            if (buf.hasArray()) {
                len = buf.remaining();
                input = buf.array();
                inputOffset = buf.position() + buf.arrayOffset();
                buf.position(buf.position() + len);
            } else {
                len = Math.min(8192, buf.remaining());
                input = new byte[len];
                inputOffset = 0;
                buf.get(input, 0, len);
            }
            deflater.setInput(input, inputOffset, len);
            if (!LOG.isDebugEnabled()) {
                return true;
            }
            LOG.debug("Supplied {} input bytes: {}", Integer.valueOf(input.length), toDetail(deflater));
            return true;
        } else if (!LOG.isDebugEnabled()) {
            return false;
        } else {
            LOG.debug("No data left left to supply to Deflater", new Object[0]);
            return false;
        }
    }

    private static String toDetail(Inflater inflater) {
        return String.format("Inflater[finished=%b,read=%d,written=%d,remaining=%d,in=%d,out=%d]", Boolean.valueOf(inflater.finished()), Long.valueOf(inflater.getBytesRead()), Long.valueOf(inflater.getBytesWritten()), Integer.valueOf(inflater.getRemaining()), Integer.valueOf(inflater.getTotalIn()), Integer.valueOf(inflater.getTotalOut()));
    }

    private static String toDetail(Deflater deflater) {
        return String.format("Deflater[finished=%b,read=%d,written=%d,in=%d,out=%d]", Boolean.valueOf(deflater.finished()), Long.valueOf(deflater.getBytesRead()), Long.valueOf(deflater.getBytesWritten()), Integer.valueOf(deflater.getTotalIn()), Integer.valueOf(deflater.getTotalOut()));
    }

    public static boolean endsWithTail(ByteBuffer buf) {
        if (buf == null || buf.remaining() < TAIL_BYTES.length) {
            return false;
        }
        int limit = buf.limit();
        for (int i = TAIL_BYTES.length; i > 0; i--) {
            if (buf.get(limit - i) != TAIL_BYTES[TAIL_BYTES.length - i]) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (this.deflaterImpl != null) {
            this.deflaterPool.release(this.deflaterImpl);
            this.deflaterImpl = null;
        }
        if (this.inflaterImpl != null) {
            this.inflaterPool.release(this.inflaterImpl);
            this.inflaterImpl = null;
        }
        doStop();
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/compress/CompressExtension$FrameEntry.class */
    public static class FrameEntry {
        private final Frame frame;
        private final WriteCallback callback;
        private final BatchMode batchMode;

        private FrameEntry(Frame frame, WriteCallback callback, BatchMode batchMode) {
            this.frame = frame;
            this.callback = callback;
            this.batchMode = batchMode;
        }

        public String toString() {
            return this.frame.toString();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/compress/CompressExtension$Flusher.class */
    private class Flusher extends IteratingCallback implements WriteCallback {
        private FrameEntry current;
        private boolean finished;

        private Flusher() {
            this.finished = true;
        }

        @Override // org.eclipse.jetty.util.IteratingCallback, org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            CompressExtension.this.notifyCallbackFailure(this.current.callback, x);
            failed(x);
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            if (this.finished) {
                this.current = CompressExtension.this.pollEntry();
                if (CompressExtension.LOG.isDebugEnabled()) {
                    CompressExtension.LOG.debug("Processing {}", this.current);
                }
                if (this.current == null) {
                    return IteratingCallback.Action.IDLE;
                }
                deflate(this.current);
            } else {
                compress(this.current, false);
            }
            return IteratingCallback.Action.SCHEDULED;
        }

        private void deflate(FrameEntry entry) {
            Frame frame = entry.frame;
            BatchMode batchMode = entry.batchMode;
            if (OpCode.isControlFrame(frame.getOpCode())) {
                CompressExtension.this.nextOutgoingFrame(frame, this, batchMode);
            } else {
                compress(entry, true);
            }
        }

        private void compress(FrameEntry entry, boolean first) {
            Frame frame = entry.frame;
            boolean fin = frame.isFin();
            ByteBuffer data = frame.getPayload();
            Deflater deflater = CompressExtension.this.getDeflater();
            if (data == null) {
                data = BufferUtil.EMPTY_BUFFER;
            }
            int remaining = data.remaining();
            int outputLength = Math.max(256, data.remaining());
            if (CompressExtension.LOG.isDebugEnabled()) {
                CompressExtension.LOG.debug("Compressing {}: {} bytes in {} bytes chunk", entry, Integer.valueOf(remaining), Integer.valueOf(outputLength));
            }
            ByteBuffer payload = BufferUtil.EMPTY_BUFFER;
            WriteCallback callback = this;
            if (!deflater.needsInput() || CompressExtension.supplyInput(deflater, data)) {
                final ByteBufferPool bufferPool = CompressExtension.this.getBufferPool();
                ByteBufferAccumulator accumulator = new ByteBufferAccumulator(bufferPool, false);
                while (true) {
                    try {
                        ByteBuffer buffer = accumulator.ensureBuffer(8, outputLength);
                        int compressed = deflater.deflate(buffer.array(), buffer.arrayOffset() + buffer.limit(), buffer.capacity() - buffer.limit(), 2);
                        buffer.limit(buffer.limit() + compressed);
                        if (CompressExtension.LOG.isDebugEnabled()) {
                            CompressExtension.LOG.debug("Wrote {} bytes to output buffer", accumulator);
                        }
                        if (compressed <= 0) {
                            break;
                        }
                    } catch (Throwable th) {
                        try {
                            accumulator.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                final ByteBuffer buffer2 = accumulator.takeByteBuffer();
                payload = buffer2;
                callback = new WriteCallback() { // from class: org.eclipse.jetty.websocket.common.extensions.compress.CompressExtension.Flusher.1
                    @Override // org.eclipse.jetty.websocket.api.WriteCallback
                    public void writeFailed(Throwable x) {
                        bufferPool.release(buffer2);
                        Flusher.this.writeFailed(x);
                    }

                    @Override // org.eclipse.jetty.websocket.api.WriteCallback
                    public void writeSuccess() {
                        bufferPool.release(buffer2);
                        Flusher.this.writeSuccess();
                    }
                };
                accumulator.close();
            }
            if (payload.remaining() > 0) {
                if (CompressExtension.LOG.isDebugEnabled()) {
                    CompressExtension.LOG.debug("compressed[] bytes = {}", BufferUtil.toDetailString(payload));
                }
                if (CompressExtension.this.tailDrop == 1) {
                    if (CompressExtension.endsWithTail(payload)) {
                        payload.limit(payload.limit() - CompressExtension.TAIL_BYTES.length);
                    }
                    if (CompressExtension.LOG.isDebugEnabled()) {
                        CompressExtension.LOG.debug("payload (TAIL_DROP_ALWAYS) = {}", BufferUtil.toDetailString(payload));
                    }
                } else if (CompressExtension.this.tailDrop == 2) {
                    if (frame.isFin() && CompressExtension.endsWithTail(payload)) {
                        payload.limit(payload.limit() - CompressExtension.TAIL_BYTES.length);
                    }
                    if (CompressExtension.LOG.isDebugEnabled()) {
                        CompressExtension.LOG.debug("payload (TAIL_DROP_FIN_ONLY) = {}", BufferUtil.toDetailString(payload));
                    }
                }
            } else if (fin) {
                payload = ByteBuffer.wrap(new byte[]{0});
            }
            if (CompressExtension.LOG.isDebugEnabled()) {
                CompressExtension.LOG.debug("Compressed {}: input:{} -> payload:{}", entry, Integer.valueOf(outputLength), Integer.valueOf(payload.remaining()));
            }
            boolean continuation = frame.getType().isContinuation() || !first;
            DataFrame chunk = new DataFrame(frame, continuation);
            if (CompressExtension.this.rsvUse == 1) {
                chunk.setRsv1(!continuation);
            } else {
                chunk.setRsv1(true);
            }
            chunk.setPayload(payload);
            chunk.setFin(fin);
            CompressExtension.this.nextOutgoingFrame(chunk, callback, entry.batchMode);
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteSuccess() {
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable x) {
            while (true) {
                FrameEntry entry = CompressExtension.this.pollEntry();
                if (entry != null) {
                    CompressExtension.this.notifyCallbackFailure(entry.callback, x);
                } else {
                    return;
                }
            }
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeSuccess() {
            if (this.finished) {
                CompressExtension.this.notifyCallbackSuccess(this.current.callback);
            }
            succeeded();
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeFailed(Throwable x) {
            failed(x);
        }
    }
}
