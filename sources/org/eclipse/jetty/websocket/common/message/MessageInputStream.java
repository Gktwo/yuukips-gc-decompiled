package org.eclipse.jetty.websocket.common.message;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.NullByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.SuspendToken;
import org.eclipse.jetty.websocket.common.WebSocketSession;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/MessageInputStream.class */
public class MessageInputStream extends InputStream implements MessageAppender {
    private static final Logger LOG = Log.getLogger(MessageInputStream.class);
    private static final ByteBuffer EOF = ByteBuffer.allocate(0).asReadOnlyBuffer();
    private final Session session;
    private final ByteBufferPool bufferPool;
    private final BlockingDeque<ByteBuffer> buffers;
    private final long timeoutMs;
    private ByteBuffer activeBuffer;
    private SuspendToken suspendToken;
    private State state;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/MessageInputStream$State.class */
    public enum State {
        RESUMED,
        SUSPENDED,
        COMPLETE,
        CLOSED
    }

    public MessageInputStream(Session session) {
        this(session, -1);
    }

    public MessageInputStream(Session session, int timeoutMs) {
        this.buffers = new LinkedBlockingDeque();
        this.activeBuffer = null;
        this.state = State.RESUMED;
        this.timeoutMs = (long) timeoutMs;
        this.session = session;
        this.bufferPool = session instanceof WebSocketSession ? ((WebSocketSession) session).getBufferPool() : new NullByteBufferPool();
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void appendFrame(ByteBuffer framePayload, boolean fin) throws IOException {
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[2];
            objArr[0] = fin ? "final" : "non-final";
            objArr[1] = BufferUtil.toDetailString(framePayload);
            logger.debug("Appending {} chunk: {}", objArr);
        }
        boolean bufferIsEmpty = BufferUtil.isEmpty(framePayload);
        if (!bufferIsEmpty || fin) {
            try {
                synchronized (this) {
                    if (!bufferIsEmpty) {
                        switch (this.state) {
                            case CLOSED:
                                return;
                            case RESUMED:
                                this.suspendToken = this.session.suspend();
                                this.state = State.SUSPENDED;
                                ByteBuffer copy = acquire(framePayload.remaining(), framePayload.isDirect());
                                BufferUtil.clearToFill(copy);
                                copy.put(framePayload);
                                BufferUtil.flipToFlush(copy, 0);
                                this.buffers.put(copy);
                                break;
                            default:
                                throw new IllegalStateException("Incorrect State: " + this.state.name());
                        }
                    }
                    if (fin) {
                        this.buffers.add(EOF);
                        this.state = State.COMPLETE;
                    }
                }
            } catch (InterruptedException e) {
                throw new IOException(e);
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.state != State.CLOSED) {
                if (this.state != State.COMPLETE || (!this.buffers.isEmpty() && this.buffers.peek() != EOF) || (this.activeBuffer != null && this.activeBuffer.hasRemaining())) {
                    LOG.warn("MessageInputStream closed without fully consuming content {}", this.session);
                }
                if (!(this.activeBuffer == null || this.activeBuffer == EOF)) {
                    this.bufferPool.release(this.activeBuffer);
                }
                for (ByteBuffer buffer : this.buffers) {
                    if (!(buffer == null || buffer == EOF)) {
                        this.bufferPool.release(buffer);
                    }
                }
                this.activeBuffer = null;
                this.buffers.clear();
                this.state = State.CLOSED;
                this.buffers.add(EOF);
            }
        }
    }

    public void handlerComplete() {
        SuspendToken resume;
        close();
        synchronized (this) {
            resume = this.suspendToken;
            this.suspendToken = null;
        }
        if (resume != null) {
            resume.resume();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read;
        byte[] bytes = new byte[1];
        do {
            read = read(bytes, 0, 1);
            if (read < 0) {
                return -1;
            }
        } while (read == 0);
        return bytes[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        try {
            if (this.state != State.CLOSED) {
                while (this.activeBuffer == null) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Waiting {} ms to read", this.timeoutMs);
                    }
                    if (this.timeoutMs < 0) {
                        this.activeBuffer = this.buffers.take();
                    } else {
                        this.activeBuffer = this.buffers.poll(this.timeoutMs, TimeUnit.MILLISECONDS);
                        if (this.activeBuffer == null) {
                            throw new IOException(String.format("Read timeout: %,dms expired", Long.valueOf(this.timeoutMs)));
                        }
                    }
                    if (this.activeBuffer == EOF) {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Reached EOF", new Object[0]);
                        }
                        close();
                        return -1;
                    }
                }
                ByteBuffer buffer = BufferUtil.toBuffer(b, off, len);
                BufferUtil.clearToFill(buffer);
                int written = BufferUtil.put(this.activeBuffer, buffer);
                BufferUtil.flipToFlush(buffer, 0);
                if (!this.activeBuffer.hasRemaining()) {
                    SuspendToken resume = null;
                    synchronized (this) {
                        if (!(this.activeBuffer == null || this.activeBuffer == EOF)) {
                            this.bufferPool.release(this.activeBuffer);
                        }
                        this.activeBuffer = null;
                        switch (this.state) {
                            case CLOSED:
                                return -1;
                            case RESUMED:
                                throw new IllegalStateException("Incorrect State: " + this.state.name());
                            case SUSPENDED:
                                resume = this.suspendToken;
                                this.suspendToken = null;
                                this.state = State.RESUMED;
                                break;
                        }
                        if (resume != null) {
                            resume.resume();
                        }
                    }
                }
                return written;
            } else if (!LOG.isDebugEnabled()) {
                return -1;
            } else {
                LOG.debug("Stream closed", new Object[0]);
                return -1;
            }
        } catch (InterruptedException x) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Interrupted while waiting to read", x);
            }
            close();
            return -1;
        }
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void messageComplete() {
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("reset() not supported");
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    private ByteBuffer acquire(int capacity, boolean direct) {
        return this.bufferPool.acquire(capacity, direct);
    }
}
