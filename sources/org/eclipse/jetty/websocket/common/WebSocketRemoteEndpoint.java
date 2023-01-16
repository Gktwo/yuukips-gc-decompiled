package org.eclipse.jetty.websocket.common;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.WritePendingException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;
import org.eclipse.jetty.websocket.common.BlockingWriteCallback;
import org.eclipse.jetty.websocket.common.frames.BinaryFrame;
import org.eclipse.jetty.websocket.common.frames.ContinuationFrame;
import org.eclipse.jetty.websocket.common.frames.DataFrame;
import org.eclipse.jetty.websocket.common.frames.PingFrame;
import org.eclipse.jetty.websocket.common.frames.PongFrame;
import org.eclipse.jetty.websocket.common.frames.TextFrame;
import org.eclipse.jetty.websocket.common.p025io.FutureWriteCallback;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/WebSocketRemoteEndpoint.class */
public class WebSocketRemoteEndpoint implements RemoteEndpoint {
    private static final WriteCallback NOOP_CALLBACK = new WriteCallback() { // from class: org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint.1
        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeSuccess() {
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeFailed(Throwable x) {
        }
    };
    private static final Logger LOG = Log.getLogger(WebSocketRemoteEndpoint.class);
    private static final int ASYNC_MASK = 65535;
    private static final int BLOCK_MASK = 65536;
    private static final int STREAM_MASK = 131072;
    private static final int PARTIAL_TEXT_MASK = 262144;
    private static final int PARTIAL_BINARY_MASK = 524288;
    private final LogicalConnection connection;
    private final OutgoingFrames outgoing;
    private final AtomicInteger msgState;
    private final BlockingWriteCallback blocker;
    private final AtomicInteger numOutgoingFrames;
    private volatile BatchMode batchMode;
    private int maxNumOutgoingFrames;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/WebSocketRemoteEndpoint$MsgType.class */
    private enum MsgType {
        BLOCKING,
        ASYNC,
        STREAMING,
        PARTIAL_TEXT,
        PARTIAL_BINARY
    }

    public WebSocketRemoteEndpoint(LogicalConnection connection, OutgoingFrames outgoing) {
        this(connection, outgoing, BatchMode.AUTO);
    }

    public WebSocketRemoteEndpoint(LogicalConnection connection, OutgoingFrames outgoing, BatchMode batchMode) {
        this.msgState = new AtomicInteger();
        this.blocker = new BlockingWriteCallback();
        this.numOutgoingFrames = new AtomicInteger();
        this.maxNumOutgoingFrames = -1;
        if (connection == null) {
            throw new IllegalArgumentException("LogicalConnection cannot be null");
        }
        this.connection = connection;
        this.outgoing = outgoing;
        this.batchMode = batchMode;
    }

    private void blockingWrite(WebSocketFrame frame) throws IOException {
        BlockingWriteCallback.WriteBlocker b = this.blocker.acquireWriteBlocker();
        try {
            uncheckedSendFrame(frame, b);
            b.block();
            if (b != null) {
                b.close();
            }
        } catch (Throwable th) {
            if (b != null) {
                try {
                    b.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private boolean lockMsg(MsgType type) {
        while (true) {
            int state = this.msgState.get();
            switch (type) {
                case BLOCKING:
                    if ((state & 786432) == 0) {
                        if ((state & 65536) == 0) {
                            if (!this.msgState.compareAndSet(state, state | 65536)) {
                                break;
                            } else {
                                return state == 0;
                            }
                        } else {
                            throw new IllegalStateException(String.format("Blocking message pending %x for %s", Integer.valueOf(state), type));
                        }
                    } else {
                        throw new IllegalStateException(String.format("Partial message pending %x for %s", Integer.valueOf(state), type));
                    }
                case ASYNC:
                    if ((state & 786432) == 0) {
                        if ((state & 65535) != 65535) {
                            if (!this.msgState.compareAndSet(state, state + 1)) {
                                break;
                            } else {
                                return state == 0;
                            }
                        } else {
                            throw new IllegalStateException(String.format("Too many async sends: %x", Integer.valueOf(state)));
                        }
                    } else {
                        throw new IllegalStateException(String.format("Partial message pending %x for %s", Integer.valueOf(state), type));
                    }
                case STREAMING:
                    if ((state & 786432) == 0) {
                        if ((state & 131072) == 0) {
                            if (!this.msgState.compareAndSet(state, state | 131072)) {
                                break;
                            } else {
                                return state == 0;
                            }
                        } else {
                            throw new IllegalStateException(String.format("Already streaming %x for %s", Integer.valueOf(state), type));
                        }
                    } else {
                        throw new IllegalStateException(String.format("Partial message pending %x for %s", Integer.valueOf(state), type));
                    }
                case PARTIAL_BINARY:
                    if (state == 524288) {
                        return false;
                    }
                    if (state == 0 && this.msgState.compareAndSet(0, state | 524288)) {
                        return true;
                    }
                    throw new IllegalStateException(String.format("Cannot send %s in state %x", type, Integer.valueOf(state)));
                case PARTIAL_TEXT:
                    if (state == 262144) {
                        return false;
                    }
                    if (state == 0 && this.msgState.compareAndSet(0, state | 262144)) {
                        return true;
                    }
                    throw new IllegalStateException(String.format("Cannot send %s in state %x", type, Integer.valueOf(state)));
            }
        }
    }

    private void unlockMsg(MsgType type) {
        while (true) {
            int state = this.msgState.get();
            switch (type) {
                case BLOCKING:
                    if ((state & 65536) != 0) {
                        if (!this.msgState.compareAndSet(state, state & -65537)) {
                            break;
                        } else {
                            return;
                        }
                    } else {
                        throw new IllegalStateException(String.format("Not Blocking in state %x", Integer.valueOf(state)));
                    }
                case ASYNC:
                    if ((state & 65535) != 0) {
                        if (!this.msgState.compareAndSet(state, state - 1)) {
                            break;
                        } else {
                            return;
                        }
                    } else {
                        throw new IllegalStateException(String.format("Not Async in %x", Integer.valueOf(state)));
                    }
                case STREAMING:
                    if ((state & 131072) != 0) {
                        if (!this.msgState.compareAndSet(state, state & -131073)) {
                            break;
                        } else {
                            return;
                        }
                    } else {
                        throw new IllegalStateException(String.format("Not Streaming in state %x", Integer.valueOf(state)));
                    }
                case PARTIAL_BINARY:
                    if (!this.msgState.compareAndSet(524288, 0)) {
                        throw new IllegalStateException(String.format("Not Partial Binary in state %x", Integer.valueOf(state)));
                    }
                    return;
                case PARTIAL_TEXT:
                    if (!this.msgState.compareAndSet(262144, 0)) {
                        throw new IllegalStateException(String.format("Not Partial Text in state %x", Integer.valueOf(state)));
                    }
                    return;
            }
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public InetSocketAddress getInetSocketAddress() {
        if (this.connection == null) {
            return null;
        }
        return this.connection.getRemoteAddress();
    }

    private Future<Void> sendAsyncFrame(WebSocketFrame frame) {
        FutureWriteCallback future = new FutureWriteCallback();
        uncheckedSendFrame(frame, future);
        return future;
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendBytes(ByteBuffer data) throws IOException {
        lockMsg(MsgType.BLOCKING);
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendBytes with {}", BufferUtil.toDetailString(data));
            }
            blockingWrite(new BinaryFrame().setPayload(data));
        } finally {
            unlockMsg(MsgType.BLOCKING);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public Future<Void> sendBytesByFuture(ByteBuffer data) {
        lockMsg(MsgType.ASYNC);
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendBytesByFuture with {}", BufferUtil.toDetailString(data));
            }
            return sendAsyncFrame(new BinaryFrame().setPayload(data));
        } finally {
            unlockMsg(MsgType.ASYNC);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendBytes(ByteBuffer data, WriteCallback callback) {
        lockMsg(MsgType.ASYNC);
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendBytes({}, {})", BufferUtil.toDetailString(data), callback);
            }
            uncheckedSendFrame(new BinaryFrame().setPayload(data), callback == null ? NOOP_CALLBACK : callback);
        } finally {
            unlockMsg(MsgType.ASYNC);
        }
    }

    public void uncheckedSendFrame(WebSocketFrame frame, WriteCallback callback) {
        BatchMode batchMode = BatchMode.OFF;
        if (frame.isDataFrame()) {
            batchMode = getBatchMode();
        }
        if (this.maxNumOutgoingFrames > 0 && frame.isDataFrame()) {
            int outgoingFrames = this.numOutgoingFrames.incrementAndGet();
            AtomicInteger atomicInteger = this.numOutgoingFrames;
            Objects.requireNonNull(atomicInteger);
            callback = from(callback, this::decrementAndGet);
            if (outgoingFrames > this.maxNumOutgoingFrames) {
                callback.writeFailed(new WritePendingException());
                return;
            }
        }
        this.outgoing.outgoingFrame(frame, callback, batchMode);
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendPartialBytes(ByteBuffer fragment, boolean isLast) throws IOException {
        boolean first = lockMsg(MsgType.PARTIAL_BINARY);
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendPartialBytes({}, {})", BufferUtil.toDetailString(fragment), Boolean.valueOf(isLast));
            }
            DataFrame frame = first ? new BinaryFrame() : new ContinuationFrame();
            frame.setPayload(fragment);
            frame.setFin(isLast);
            blockingWrite(frame);
            if (isLast) {
                unlockMsg(MsgType.PARTIAL_BINARY);
            }
        } catch (Throwable th) {
            if (isLast) {
                unlockMsg(MsgType.PARTIAL_BINARY);
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendPartialString(String fragment, boolean isLast) throws IOException {
        boolean first = lockMsg(MsgType.PARTIAL_TEXT);
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendPartialString({}, {})", fragment, Boolean.valueOf(isLast));
            }
            DataFrame frame = first ? new TextFrame() : new ContinuationFrame();
            frame.setPayload(BufferUtil.toBuffer(fragment, StandardCharsets.UTF_8));
            frame.setFin(isLast);
            blockingWrite(frame);
            if (isLast) {
                unlockMsg(MsgType.PARTIAL_TEXT);
            }
        } catch (Throwable th) {
            if (isLast) {
                unlockMsg(MsgType.PARTIAL_TEXT);
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendPing(ByteBuffer applicationData) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sendPing with {}", BufferUtil.toDetailString(applicationData));
        }
        sendAsyncFrame(new PingFrame().setPayload(applicationData));
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendPong(ByteBuffer applicationData) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sendPong with {}", BufferUtil.toDetailString(applicationData));
        }
        sendAsyncFrame(new PongFrame().setPayload(applicationData));
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendString(String text) throws IOException {
        lockMsg(MsgType.BLOCKING);
        try {
            WebSocketFrame frame = new TextFrame().setPayload(text);
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendString with {}", BufferUtil.toDetailString(frame.getPayload()));
            }
            blockingWrite(frame);
        } finally {
            unlockMsg(MsgType.BLOCKING);
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public Future<Void> sendStringByFuture(String text) {
        lockMsg(MsgType.ASYNC);
        try {
            TextFrame frame = new TextFrame().setPayload(text);
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendStringByFuture with {}", BufferUtil.toDetailString(frame.getPayload()));
            }
            Future<Void> sendAsyncFrame = sendAsyncFrame(frame);
            unlockMsg(MsgType.ASYNC);
            return sendAsyncFrame;
        } catch (Throwable th) {
            unlockMsg(MsgType.ASYNC);
            throw th;
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void sendString(String text, WriteCallback callback) {
        lockMsg(MsgType.ASYNC);
        try {
            TextFrame frame = new TextFrame().setPayload(text);
            if (LOG.isDebugEnabled()) {
                LOG.debug("sendString({},{})", BufferUtil.toDetailString(frame.getPayload()), callback);
            }
            uncheckedSendFrame(frame, callback == null ? NOOP_CALLBACK : callback);
            unlockMsg(MsgType.ASYNC);
        } catch (Throwable th) {
            unlockMsg(MsgType.ASYNC);
            throw th;
        }
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public BatchMode getBatchMode() {
        return this.batchMode;
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void setBatchMode(BatchMode batchMode) {
        this.batchMode = batchMode;
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public int getMaxOutgoingFrames() {
        return this.maxNumOutgoingFrames;
    }

    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void setMaxOutgoingFrames(int maxOutgoingFrames) {
        this.maxNumOutgoingFrames = maxOutgoingFrames;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0027
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.eclipse.jetty.websocket.api.RemoteEndpoint
    public void flush() throws java.io.IOException {
        /*
            r4 = this;
            r0 = r4
            org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint$MsgType r1 = org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint.MsgType.ASYNC
            boolean r0 = r0.lockMsg(r1)
            r0 = r4
            org.eclipse.jetty.websocket.common.BlockingWriteCallback r0 = r0.blocker     // Catch: all -> 0x0045
            org.eclipse.jetty.websocket.common.BlockingWriteCallback$WriteBlocker r0 = r0.acquireWriteBlocker()     // Catch: all -> 0x0045
            r5 = r0
            r0 = r4
            org.eclipse.jetty.websocket.common.frames.BinaryFrame r1 = org.eclipse.jetty.websocket.common.p025io.FrameFlusher.FLUSH_FRAME     // Catch: Throwable -> 0x0027, all -> 0x0045
            r2 = r5
            r0.uncheckedSendFrame(r1, r2)     // Catch: Throwable -> 0x0027, all -> 0x0045
            r0 = r5
            r0.block()     // Catch: Throwable -> 0x0027, all -> 0x0045
            r0 = r5
            if (r0 == 0) goto L_0x003b
            r0 = r5
            r0.close()     // Catch: all -> 0x0045
            goto L_0x003b
        L_0x0027:
            r6 = move-exception
            r0 = r5
            if (r0 == 0) goto L_0x0039
            r0 = r5
            r0.close()     // Catch: Throwable -> 0x0033, all -> 0x0045
            goto L_0x0039
        L_0x0033:
            r7 = move-exception
            r0 = r6
            r1 = r7
            r0.addSuppressed(r1)     // Catch: all -> 0x0045
        L_0x0039:
            r0 = r6
            throw r0     // Catch: all -> 0x0045
        L_0x003b:
            r0 = r4
            org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint$MsgType r1 = org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint.MsgType.ASYNC
            r0.unlockMsg(r1)
            goto L_0x0051
        L_0x0045:
            r8 = move-exception
            r0 = r4
            org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint$MsgType r1 = org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint.MsgType.ASYNC
            r0.unlockMsg(r1)
            r0 = r8
            throw r0
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint.flush():void");
    }

    public String toString() {
        return String.format("%s@%x[batching=%b]", getClass().getSimpleName(), Integer.valueOf(hashCode()), getBatchMode());
    }

    private static WriteCallback from(final WriteCallback callback, final Runnable completed) {
        return new WriteCallback() { // from class: org.eclipse.jetty.websocket.common.WebSocketRemoteEndpoint.2
            @Override // org.eclipse.jetty.websocket.api.WriteCallback
            public void writeFailed(Throwable x) {
                try {
                    WriteCallback.this.writeFailed(x);
                } finally {
                    completed.run();
                }
            }

            @Override // org.eclipse.jetty.websocket.api.WriteCallback
            public void writeSuccess() {
                try {
                    WriteCallback.this.writeSuccess();
                } finally {
                    completed.run();
                }
            }
        };
    }
}
