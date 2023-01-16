package org.eclipse.jetty.websocket.common.message;

import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;
import org.eclipse.jetty.websocket.common.BlockingWriteCallback;
import org.eclipse.jetty.websocket.common.WebSocketSession;
import org.eclipse.jetty.websocket.common.frames.TextFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/MessageWriter.class */
public class MessageWriter extends Writer {
    private static final Logger LOG = Log.getLogger(MessageWriter.class);
    private final OutgoingFrames outgoing;
    private final ByteBufferPool bufferPool;
    private final BlockingWriteCallback blocker;
    private long frameCount;
    private TextFrame frame;
    private ByteBuffer buffer;
    private Utf8CharBuffer utf;
    private WriteCallback callback;
    private boolean closed;

    public MessageWriter(WebSocketSession session) {
        this(session.getOutgoingHandler(), session.getPolicy().getMaxTextMessageBufferSize(), session.getBufferPool());
    }

    public MessageWriter(OutgoingFrames outgoing, int bufferSize, ByteBufferPool bufferPool) {
        this.outgoing = outgoing;
        this.bufferPool = bufferPool;
        this.blocker = new BlockingWriteCallback();
        this.buffer = bufferPool.acquire(bufferSize, true);
        BufferUtil.flipToFill(this.buffer);
        this.frame = new TextFrame();
        this.utf = Utf8CharBuffer.wrap(this.buffer);
    }

    @Override // java.io.Writer
    public void write(char[] chars, int off, int len) throws IOException {
        try {
            send(chars, off, len);
        } catch (Throwable x) {
            notifyFailure(x);
            throw x;
        }
    }

    @Override // java.io.Writer
    public void write(int c) throws IOException {
        try {
            send(new char[]{(char) c}, 0, 1);
        } catch (Throwable x) {
            notifyFailure(x);
            throw x;
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        try {
            flush(false);
        } catch (Throwable x) {
            notifyFailure(x);
            throw x;
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:15:0x008b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void flush(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = r7
            r1 = r0
            r9 = r1
            monitor-enter(r0)
            r0 = r7
            boolean r0 = r0.closed     // Catch: all -> 0x00c3
            if (r0 == 0) goto L_0x0015
            java.io.IOException r0 = new java.io.IOException     // Catch: all -> 0x00c3
            r1 = r0
            java.lang.String r2 = "Stream is closed"
            r1.<init>(r2)     // Catch: all -> 0x00c3
            throw r0     // Catch: all -> 0x00c3
        L_0x0015:
            r0 = r7
            r1 = r8
            r0.closed = r1     // Catch: all -> 0x00c3
            r0 = r7
            org.eclipse.jetty.websocket.common.message.Utf8CharBuffer r0 = r0.utf     // Catch: all -> 0x00c3
            java.nio.ByteBuffer r0 = r0.getByteBuffer()     // Catch: all -> 0x00c3
            r10 = r0
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.websocket.common.message.MessageWriter.LOG     // Catch: all -> 0x00c3
            boolean r0 = r0.isDebugEnabled()     // Catch: all -> 0x00c3
            if (r0 == 0) goto L_0x004c
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.websocket.common.message.MessageWriter.LOG     // Catch: all -> 0x00c3
            java.lang.String r1 = "flush({}): {}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: all -> 0x00c3
            r3 = r2
            r4 = 0
            r5 = r8
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: all -> 0x00c3
            r3[r4] = r5     // Catch: all -> 0x00c3
            r3 = r2
            r4 = 1
            r5 = r7
            java.nio.ByteBuffer r5 = r5.buffer     // Catch: all -> 0x00c3
            java.lang.String r5 = org.eclipse.jetty.util.BufferUtil.toDetailString(r5)     // Catch: all -> 0x00c3
            r3[r4] = r5     // Catch: all -> 0x00c3
            r0.debug(r1, r2)     // Catch: all -> 0x00c3
        L_0x004c:
            r0 = r7
            org.eclipse.jetty.websocket.common.frames.TextFrame r0 = r0.frame     // Catch: all -> 0x00c3
            r1 = r10
            org.eclipse.jetty.websocket.common.WebSocketFrame r0 = r0.setPayload(r1)     // Catch: all -> 0x00c3
            r0 = r7
            org.eclipse.jetty.websocket.common.frames.TextFrame r0 = r0.frame     // Catch: all -> 0x00c3
            r1 = r8
            org.eclipse.jetty.websocket.common.WebSocketFrame r0 = r0.setFin(r1)     // Catch: all -> 0x00c3
            r0 = r7
            org.eclipse.jetty.websocket.common.BlockingWriteCallback r0 = r0.blocker     // Catch: all -> 0x00c3
            org.eclipse.jetty.websocket.common.BlockingWriteCallback$WriteBlocker r0 = r0.acquireWriteBlocker()     // Catch: all -> 0x00c3
            r11 = r0
            r0 = r7
            org.eclipse.jetty.websocket.api.extensions.OutgoingFrames r0 = r0.outgoing     // Catch: all -> 0x00c3, Throwable -> 0x008b
            r1 = r7
            org.eclipse.jetty.websocket.common.frames.TextFrame r1 = r1.frame     // Catch: all -> 0x00c3, Throwable -> 0x008b
            r2 = r11
            org.eclipse.jetty.websocket.api.BatchMode r3 = org.eclipse.jetty.websocket.api.BatchMode.OFF     // Catch: all -> 0x00c3, Throwable -> 0x008b
            r0.outgoingFrame(r1, r2, r3)     // Catch: all -> 0x00c3, Throwable -> 0x008b
            r0 = r11
            r0.block()     // Catch: all -> 0x00c3, Throwable -> 0x008b
            r0 = r11
            if (r0 == 0) goto L_0x00a6
            r0 = r11
            r0.close()     // Catch: all -> 0x00c3
            goto L_0x00a6
        L_0x008b:
            r12 = move-exception
            r0 = r11
            if (r0 == 0) goto L_0x00a3
            r0 = r11
            r0.close()     // Catch: all -> 0x00c3, Throwable -> 0x009a
            goto L_0x00a3
        L_0x009a:
            r13 = move-exception
            r0 = r12
            r1 = r13
            r0.addSuppressed(r1)     // Catch: all -> 0x00c3
        L_0x00a3:
            r0 = r12
            throw r0     // Catch: all -> 0x00c3
        L_0x00a6:
            r0 = r7
            r1 = r0
            long r1 = r1.frameCount     // Catch: all -> 0x00c3
            r2 = 1
            long r1 = r1 + r2
            r0.frameCount = r1     // Catch: all -> 0x00c3
            r0 = r7
            org.eclipse.jetty.websocket.common.frames.TextFrame r0 = r0.frame     // Catch: all -> 0x00c3
            r0.setIsContinuation()     // Catch: all -> 0x00c3
            r0 = r7
            org.eclipse.jetty.websocket.common.message.Utf8CharBuffer r0 = r0.utf     // Catch: all -> 0x00c3
            r0.clear()     // Catch: all -> 0x00c3
            r0 = r9
            monitor-exit(r0)     // Catch: all -> 0x00c3
            goto L_0x00ca
        L_0x00c3:
            r14 = move-exception
            r0 = r9
            monitor-exit(r0)     // Catch: all -> 0x00c3
            r0 = r14
            throw r0
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.message.MessageWriter.flush(boolean):void");
    }

    private void send(char[] chars, int offset, int length) throws IOException {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("Stream is closed");
            }
            while (length > 0) {
                int size = Math.min(this.utf.remaining(), length);
                this.utf.append(chars, offset, size);
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
