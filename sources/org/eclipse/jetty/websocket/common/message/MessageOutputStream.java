package org.eclipse.jetty.websocket.common.message;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;
import org.eclipse.jetty.websocket.common.BlockingWriteCallback;
import org.eclipse.jetty.websocket.common.WebSocketSession;
import org.eclipse.jetty.websocket.common.frames.BinaryFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/MessageOutputStream.class */
public class MessageOutputStream extends OutputStream {
    private static final Logger LOG = Log.getLogger(MessageOutputStream.class);
    private final OutgoingFrames outgoing;
    private final ByteBufferPool bufferPool;
    private final BlockingWriteCallback blocker;
    private long frameCount;
    private BinaryFrame frame;
    private ByteBuffer buffer;
    private WriteCallback callback;
    private boolean closed;

    public MessageOutputStream(WebSocketSession session) {
        this(session.getOutgoingHandler(), session.getPolicy().getMaxBinaryMessageBufferSize(), session.getBufferPool());
    }

    public MessageOutputStream(OutgoingFrames outgoing, int bufferSize, ByteBufferPool bufferPool) {
        this.outgoing = outgoing;
        this.bufferPool = bufferPool;
        this.blocker = new BlockingWriteCallback();
        this.buffer = bufferPool.acquire(bufferSize, true);
        BufferUtil.flipToFill(this.buffer);
        this.frame = new BinaryFrame();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int off, int len) throws IOException {
        try {
            send(bytes, off, len);
        } catch (Throwable x) {
            notifyFailure(x);
            throw x;
        }
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        try {
            send(new byte[]{(byte) b}, 0, 1);
        } catch (Throwable x) {
            notifyFailure(x);
            throw x;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            flush(false);
        } catch (Throwable x) {
            notifyFailure(x);
            throw x;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush(true);
            this.bufferPool.release(this.buffer);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Stream closed, {} frames sent", this.frameCount);
            }
            notifySuccess();
        } catch (Throwable x) {
            notifyFailure(x);
            throw x;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x005f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void flush(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r6
            r1 = r0
            r8 = r1
            monitor-enter(r0)
            r0 = r6
            boolean r0 = r0.closed     // Catch: all -> 0x0096
            if (r0 == 0) goto L_0x0015
            java.io.IOException r0 = new java.io.IOException     // Catch: all -> 0x0096
            r1 = r0
            java.lang.String r2 = "Stream is closed"
            r1.<init>(r2)     // Catch: all -> 0x0096
            throw r0     // Catch: all -> 0x0096
        L_0x0015:
            r0 = r6
            r1 = r7
            r0.closed = r1     // Catch: all -> 0x0096
            r0 = r6
            java.nio.ByteBuffer r0 = r0.buffer     // Catch: all -> 0x0096
            r1 = 0
            org.eclipse.jetty.util.BufferUtil.flipToFlush(r0, r1)     // Catch: all -> 0x0096
            r0 = r6
            org.eclipse.jetty.websocket.common.frames.BinaryFrame r0 = r0.frame     // Catch: all -> 0x0096
            r1 = r6
            java.nio.ByteBuffer r1 = r1.buffer     // Catch: all -> 0x0096
            org.eclipse.jetty.websocket.common.frames.BinaryFrame r0 = r0.setPayload(r1)     // Catch: all -> 0x0096
            r0 = r6
            org.eclipse.jetty.websocket.common.frames.BinaryFrame r0 = r0.frame     // Catch: all -> 0x0096
            r1 = r7
            org.eclipse.jetty.websocket.common.WebSocketFrame r0 = r0.setFin(r1)     // Catch: all -> 0x0096
            r0 = r6
            org.eclipse.jetty.websocket.common.BlockingWriteCallback r0 = r0.blocker     // Catch: all -> 0x0096
            org.eclipse.jetty.websocket.common.BlockingWriteCallback$WriteBlocker r0 = r0.acquireWriteBlocker()     // Catch: all -> 0x0096
            r9 = r0
            r0 = r6
            org.eclipse.jetty.websocket.api.extensions.OutgoingFrames r0 = r0.outgoing     // Catch: all -> 0x0096, Throwable -> 0x005f
            r1 = r6
            org.eclipse.jetty.websocket.common.frames.BinaryFrame r1 = r1.frame     // Catch: all -> 0x0096, Throwable -> 0x005f
            r2 = r9
            org.eclipse.jetty.websocket.api.BatchMode r3 = org.eclipse.jetty.websocket.api.BatchMode.OFF     // Catch: all -> 0x0096, Throwable -> 0x005f
            r0.outgoingFrame(r1, r2, r3)     // Catch: all -> 0x0096, Throwable -> 0x005f
            r0 = r9
            r0.block()     // Catch: all -> 0x0096, Throwable -> 0x005f
            r0 = r9
            if (r0 == 0) goto L_0x0078
            r0 = r9
            r0.close()     // Catch: all -> 0x0096
            goto L_0x0078
        L_0x005f:
            r10 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x0075
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x006c, all -> 0x0096
            goto L_0x0075
        L_0x006c:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: all -> 0x0096
        L_0x0075:
            r0 = r10
            throw r0     // Catch: all -> 0x0096
        L_0x0078:
            r0 = r6
            r1 = r0
            long r1 = r1.frameCount     // Catch: all -> 0x0096
            r2 = 1
            long r1 = r1 + r2
            r0.frameCount = r1     // Catch: all -> 0x0096
            r0 = r6
            org.eclipse.jetty.websocket.common.frames.BinaryFrame r0 = r0.frame     // Catch: all -> 0x0096
            r0.setIsContinuation()     // Catch: all -> 0x0096
            r0 = r6
            java.nio.ByteBuffer r0 = r0.buffer     // Catch: all -> 0x0096
            int r0 = org.eclipse.jetty.util.BufferUtil.flipToFill(r0)     // Catch: all -> 0x0096
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x0096
            goto L_0x009d
        L_0x0096:
            r12 = move-exception
            r0 = r8
            monitor-exit(r0)     // Catch: all -> 0x0096
            r0 = r12
            throw r0
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.message.MessageOutputStream.flush(boolean):void");
    }

    private void send(byte[] bytes, int offset, int length) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("Stream is closed");
            }
            while (length > 0) {
                int size = Math.min(this.buffer.remaining(), length);
                this.buffer.put(bytes, offset, size);
                offset += size;
                length -= size;
                if (length > 0) {
                    flush(false);
                }
            }
        }
    }

    public void setCallback(WriteCallback callback) {
        synchronized (this) {
            this.callback = callback;
        }
    }

    private void notifySuccess() {
        WriteCallback callback;
        synchronized (this) {
            callback = this.callback;
        }
        if (callback != null) {
            callback.writeSuccess();
        }
    }

    private void notifyFailure(Throwable failure) {
        WriteCallback callback;
        synchronized (this) {
            callback = this.callback;
        }
        if (callback != null) {
            callback.writeFailed(failure);
        }
    }
}
