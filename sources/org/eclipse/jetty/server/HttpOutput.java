package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritePendingException;
import java.nio.charset.CharsetEncoder;
import java.util.ResourceBundle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.EofException;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.SharedBlockingCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput.class */
public class HttpOutput extends ServletOutputStream implements Runnable {
    private static final String LSTRING_FILE = "javax.servlet.LocalStrings";
    private static ResourceBundle lStrings = ResourceBundle.getBundle(LSTRING_FILE);
    private static Logger LOG = Log.getLogger(HttpOutput.class);
    private static final ThreadLocal<CharsetEncoder> _encoder = new ThreadLocal<>();
    private final HttpChannel _channel;
    private final HttpChannelState _channelState;
    private final SharedBlockingCallback _writeBlocker;
    private Interceptor _interceptor;
    private long _written;
    private long _flushed;
    private ByteBuffer _aggregate;
    private int _bufferSize;
    private int _commitSize;
    private WriteListener _writeListener;
    private volatile Throwable _onError;
    private Callback _closedCallback;
    private ApiState _apiState = ApiState.BLOCKING;
    private State _state = State.OPEN;
    private boolean _softClose = false;
    private long _firstByteTimeStamp = -1;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$ApiState.class */
    public enum ApiState {
        BLOCKING,
        BLOCKED,
        ASYNC,
        READY,
        PENDING,
        UNREADY
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$State.class */
    public enum State {
        OPEN,
        CLOSE,
        CLOSING,
        CLOSED
    }

    static /* synthetic */ long access$1614(HttpOutput x0, long x1) {
        long j = x0._written + x1;
        x0._written = j;
        return j;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$Interceptor.class */
    public interface Interceptor {
        void write(ByteBuffer byteBuffer, boolean z, Callback callback);

        Interceptor getNextInterceptor();

        boolean isOptimizedForDirectBuffers();

        default void resetBuffer() throws IllegalStateException {
            Interceptor next = getNextInterceptor();
            if (next != null) {
                next.resetBuffer();
            }
        }
    }

    public HttpOutput(HttpChannel channel) {
        this._channel = channel;
        this._channelState = channel.getState();
        this._interceptor = channel;
        this._writeBlocker = new WriteBlocker(channel);
        HttpConfiguration config = channel.getHttpConfiguration();
        this._bufferSize = config.getOutputBufferSize();
        this._commitSize = config.getOutputAggregationSize();
        if (this._commitSize > this._bufferSize) {
            LOG.warn("OutputAggregationSize {} exceeds bufferSize {}", Integer.valueOf(this._commitSize), Integer.valueOf(this._bufferSize));
            this._commitSize = this._bufferSize;
        }
    }

    public HttpChannel getHttpChannel() {
        return this._channel;
    }

    public Interceptor getInterceptor() {
        return this._interceptor;
    }

    public void setInterceptor(Interceptor interceptor) {
        this._interceptor = interceptor;
    }

    public boolean isWritten() {
        return this._written > 0;
    }

    public long getWritten() {
        return this._written;
    }

    public void reopen() {
        synchronized (this._channelState) {
            this._softClose = false;
        }
    }

    /* access modifiers changed from: protected */
    public SharedBlockingCallback.Blocker acquireWriteBlockingCallback() throws IOException {
        return this._writeBlocker.acquire();
    }

    private void channelWrite(ByteBuffer content, boolean complete) throws IOException {
        SharedBlockingCallback.Blocker blocker = this._writeBlocker.acquire();
        try {
            channelWrite(content, complete, blocker);
            blocker.block();
            if (blocker != null) {
                blocker.close();
            }
        } catch (Throwable th) {
            if (blocker != null) {
                try {
                    blocker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void channelWrite(ByteBuffer content, boolean last, Callback callback) {
        if (this._firstByteTimeStamp == -1) {
            if (getHttpChannel().getHttpConfiguration().getMinResponseDataRate() > 0) {
                this._firstByteTimeStamp = System.nanoTime();
            } else {
                this._firstByteTimeStamp = LongCompanionObject.MAX_VALUE;
            }
        }
        this._interceptor.write(content, last, callback);
    }

    /* access modifiers changed from: private */
    public void onWriteComplete(boolean last, Throwable failure) {
        String state = null;
        boolean wake = false;
        Callback closedCallback = null;
        ByteBuffer closeContent = null;
        synchronized (this._channelState) {
            if (LOG.isDebugEnabled()) {
                state = stateString();
            }
            if (last || failure != null) {
                this._state = State.CLOSED;
                closedCallback = this._closedCallback;
                this._closedCallback = null;
                releaseBuffer(failure);
                wake = updateApiState(failure);
            } else if (this._state == State.CLOSE) {
                this._state = State.CLOSING;
                closeContent = BufferUtil.hasContent(this._aggregate) ? this._aggregate : BufferUtil.EMPTY_BUFFER;
            } else {
                wake = updateApiState(null);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("onWriteComplete({},{}) {}->{} c={} cb={} w={}", Boolean.valueOf(last), failure, state, stateString(), BufferUtil.toDetailString(closeContent), closedCallback, Boolean.valueOf(wake));
        }
        if (failure != null) {
            try {
                this._channel.abort(failure);
            } catch (Throwable th) {
                if (wake) {
                    this._channel.execute(this._channel);
                }
                throw th;
            }
        }
        if (closedCallback != null) {
            if (failure == null) {
                closedCallback.succeeded();
            } else {
                closedCallback.failed(failure);
            }
        } else if (closeContent != null) {
            channelWrite(closeContent, true, new WriteCompleteCB());
        }
        if (wake) {
            this._channel.execute(this._channel);
        }
    }

    private boolean updateApiState(Throwable failure) {
        boolean wake = false;
        switch (this._apiState) {
            case BLOCKED:
                this._apiState = ApiState.BLOCKING;
                break;
            case PENDING:
                this._apiState = ApiState.ASYNC;
                if (failure != null) {
                    this._onError = failure;
                    wake = this._channelState.onWritePossible();
                    break;
                }
                break;
            case UNREADY:
                this._apiState = ApiState.READY;
                if (failure != null) {
                    this._onError = failure;
                }
                wake = this._channelState.onWritePossible();
                break;
            default:
                if (this._state != State.CLOSED) {
                    throw new IllegalStateException(stateString());
                }
                break;
        }
        return wake;
    }

    /* access modifiers changed from: private */
    public int maximizeAggregateSpace() {
        if (this._aggregate == null) {
            return getBufferSize();
        }
        BufferUtil.compact(this._aggregate);
        return BufferUtil.space(this._aggregate);
    }

    public void softClose() {
        synchronized (this._channelState) {
            this._softClose = true;
        }
    }

    public void complete(Callback callback) {
        boolean succeeded = false;
        Throwable error = null;
        ByteBuffer content = null;
        synchronized (this._channelState) {
            switch (this._apiState) {
                case BLOCKED:
                    error = new CancellationException("Completed whilst write blocked");
                    break;
                case PENDING:
                    if (!this._channel.getResponse().isContentComplete(this._written)) {
                        error = new CancellationException("Completed whilst write pending");
                        break;
                    }
                    break;
                case UNREADY:
                    error = new CancellationException("Completed whilst write unready");
                    break;
            }
            if (error != null) {
                this._channel.abort(error);
                this._writeBlocker.fail(error);
                this._state = State.CLOSED;
            } else {
                switch (this._state) {
                    case CLOSED:
                        succeeded = true;
                        break;
                    case CLOSE:
                    case CLOSING:
                        this._closedCallback = Callback.combine(this._closedCallback, callback);
                        break;
                    case OPEN:
                        if (this._onError != null) {
                            error = this._onError;
                            break;
                        } else {
                            this._closedCallback = Callback.combine(this._closedCallback, callback);
                            switch (this._apiState) {
                                case PENDING:
                                case UNREADY:
                                    this._softClose = true;
                                    this._state = State.CLOSE;
                                    break;
                                case BLOCKING:
                                    this._apiState = ApiState.BLOCKED;
                                    this._state = State.CLOSING;
                                    content = BufferUtil.hasContent(this._aggregate) ? this._aggregate : BufferUtil.EMPTY_BUFFER;
                                    break;
                                case ASYNC:
                                case READY:
                                    this._apiState = ApiState.PENDING;
                                    this._state = State.CLOSING;
                                    content = BufferUtil.hasContent(this._aggregate) ? this._aggregate : BufferUtil.EMPTY_BUFFER;
                                    break;
                                default:
                                    throw new IllegalStateException();
                            }
                        }
                }
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("complete({}) {} s={} e={}, c={}", callback, stateString(), Boolean.valueOf(succeeded), error, BufferUtil.toDetailString(content));
        }
        if (succeeded) {
            callback.succeeded();
        } else if (error != null) {
            callback.failed(error);
        } else if (content != null) {
            channelWrite(content, true, new WriteCompleteCB());
        }
    }

    public void completed(Throwable failure) {
        synchronized (this._channelState) {
            this._state = State.CLOSED;
            releaseBuffer(failure);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:76:0x0214
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 570
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.HttpOutput.close():void");
    }

    public ByteBuffer getBuffer() {
        ByteBuffer acquireBuffer;
        synchronized (this._channelState) {
            acquireBuffer = acquireBuffer();
        }
        return acquireBuffer;
    }

    private ByteBuffer acquireBuffer() {
        if (this._aggregate == null) {
            this._aggregate = this._channel.getByteBufferPool().acquire(getBufferSize(), this._interceptor.isOptimizedForDirectBuffers());
        }
        return this._aggregate;
    }

    private void releaseBuffer(Throwable failure) {
        if (this._aggregate != null) {
            ByteBufferPool bufferPool = this._channel.getConnector().getByteBufferPool();
            if (failure == null) {
                bufferPool.release(this._aggregate);
            } else {
                bufferPool.remove(this._aggregate);
            }
            this._aggregate = null;
        }
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this._channelState) {
            z = this._softClose || this._state != State.OPEN;
        }
        return z;
    }

    public boolean isAsync() {
        synchronized (this._channelState) {
            switch (this._apiState) {
                case PENDING:
                case UNREADY:
                case ASYNC:
                case READY:
                    return true;
                case BLOCKING:
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ByteBuffer content = null;
        synchronized (this._channelState) {
            switch (this._state) {
                case CLOSED:
                case CLOSING:
                    return;
                default:
                    switch (this._apiState) {
                        case PENDING:
                        case ASYNC:
                            throw new IllegalStateException("isReady() not called: " + stateString());
                        case UNREADY:
                            throw new WritePendingException();
                        case BLOCKING:
                            this._apiState = ApiState.BLOCKED;
                            content = BufferUtil.hasContent(this._aggregate) ? this._aggregate : BufferUtil.EMPTY_BUFFER;
                            break;
                        case READY:
                            this._apiState = ApiState.PENDING;
                            break;
                        default:
                            throw new IllegalStateException(stateString());
                    }
                    if (content == null) {
                        new AsyncFlush(false).iterate();
                        return;
                    }
                    try {
                        channelWrite(content, false);
                        onWriteComplete(false, null);
                        return;
                    } catch (Throwable t) {
                        onWriteComplete(false, t);
                        throw t;
                    }
            }
        }
    }

    private void checkWritable() throws EofException {
        if (this._softClose) {
            throw new EofException("Closed");
        }
        switch (this._state) {
            case CLOSED:
            case CLOSING:
                throw new EofException("Closed");
            default:
                if (this._onError != null) {
                    throw new EofException(this._onError);
                }
                return;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        boolean async;
        if (LOG.isDebugEnabled()) {
            LOG.debug("write(array {})", BufferUtil.toDetailString(ByteBuffer.wrap(b, off, len)));
        }
        synchronized (this._channelState) {
            checkWritable();
            long written = this._written + ((long) len);
            int space = maximizeAggregateSpace();
            boolean last = this._channel.getResponse().isAllContentWritten(written);
            boolean aggregate = len <= this._commitSize && (!last || (BufferUtil.hasContent(this._aggregate) && len <= space));
            boolean flush = last || !aggregate || len >= space;
            if (last && this._state == State.OPEN) {
                this._state = State.CLOSING;
            }
            switch (this._apiState) {
                case PENDING:
                case UNREADY:
                    throw new WritePendingException();
                case BLOCKING:
                    this._apiState = flush ? ApiState.BLOCKED : ApiState.BLOCKING;
                    async = false;
                    break;
                case ASYNC:
                    throw new IllegalStateException("isReady() not called: " + stateString());
                case READY:
                    async = true;
                    this._apiState = flush ? ApiState.PENDING : ApiState.ASYNC;
                    break;
                default:
                    throw new IllegalStateException(stateString());
            }
            this._written = written;
            if (aggregate) {
                acquireBuffer();
                int filled = BufferUtil.fill(this._aggregate, b, off, len);
                if (!flush) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("write(array) {} aggregated !flush {}", stateString(), BufferUtil.toDetailString(this._aggregate));
                    }
                    return;
                }
                off += filled;
                len -= filled;
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("write(array) {} last={} agg={} flush=true async={}, len={} {}", stateString(), Boolean.valueOf(last), Boolean.valueOf(aggregate), Boolean.valueOf(async), Integer.valueOf(len), BufferUtil.toDetailString(this._aggregate));
            }
            if (async) {
                new AsyncWrite(b, off, len, last).iterate();
                return;
            }
            try {
                boolean complete = false;
                if (BufferUtil.hasContent(this._aggregate)) {
                    complete = last && len == 0;
                    channelWrite(this._aggregate, complete);
                    if (len > 0 && !last && len <= this._commitSize && len <= maximizeAggregateSpace()) {
                        BufferUtil.append(this._aggregate, b, off, len);
                        last = false;
                        t = null;
                        return;
                    }
                }
                if (len > 0) {
                    ByteBuffer view = ByteBuffer.wrap(b, off, len);
                    while (len > getBufferSize()) {
                        int p = view.position();
                        int l = p + getBufferSize();
                        view.limit(l);
                        channelWrite(view, false);
                        view.limit(p + len);
                        view.position(l);
                        len -= getBufferSize();
                    }
                    channelWrite(view, last);
                } else if (last && !complete) {
                    channelWrite(BufferUtil.EMPTY_BUFFER, true);
                }
                onWriteComplete(last, null);
            } finally {
                onWriteComplete(last, t);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void write(ByteBuffer buffer) throws IOException {
        boolean last;
        boolean flush;
        boolean async;
        int len = BufferUtil.length(buffer);
        synchronized (this._channelState) {
            checkWritable();
            long written = this._written + ((long) len);
            last = this._channel.getResponse().isAllContentWritten(written);
            flush = last || len > 0 || BufferUtil.hasContent(this._aggregate);
            if (last && this._state == State.OPEN) {
                this._state = State.CLOSING;
            }
            switch (this._apiState) {
                case PENDING:
                case UNREADY:
                    throw new WritePendingException();
                case BLOCKING:
                    async = false;
                    this._apiState = flush ? ApiState.BLOCKED : ApiState.BLOCKING;
                    break;
                case ASYNC:
                    throw new IllegalStateException("isReady() not called: " + stateString());
                case READY:
                    async = true;
                    this._apiState = flush ? ApiState.PENDING : ApiState.ASYNC;
                    break;
                default:
                    throw new IllegalStateException(stateString());
            }
            this._written = written;
        }
        if (flush) {
            if (async) {
                new AsyncWrite(buffer, last).iterate();
                return;
            }
            try {
                boolean complete = false;
                if (BufferUtil.hasContent(this._aggregate)) {
                    complete = last && len == 0;
                    channelWrite(this._aggregate, complete);
                }
                if (len > 0) {
                    channelWrite(buffer, last);
                } else if (last && !complete) {
                    channelWrite(BufferUtil.EMPTY_BUFFER, true);
                }
                onWriteComplete(last, null);
            } catch (Throwable t) {
                onWriteComplete(last, t);
                throw t;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        boolean last;
        boolean flush;
        boolean async = false;
        synchronized (this._channelState) {
            checkWritable();
            long written = this._written + 1;
            int space = maximizeAggregateSpace();
            last = this._channel.getResponse().isAllContentWritten(written);
            flush = last || space == 1;
            if (last && this._state == State.OPEN) {
                this._state = State.CLOSING;
            }
            switch (this._apiState) {
                case PENDING:
                case UNREADY:
                    throw new WritePendingException();
                case BLOCKING:
                    this._apiState = flush ? ApiState.BLOCKED : ApiState.BLOCKING;
                    break;
                case ASYNC:
                    throw new IllegalStateException("isReady() not called: " + stateString());
                case READY:
                    async = true;
                    this._apiState = flush ? ApiState.PENDING : ApiState.ASYNC;
                    break;
                default:
                    throw new IllegalStateException(stateString());
            }
            this._written = written;
            acquireBuffer();
            BufferUtil.append(this._aggregate, (byte) b);
        }
        if (flush) {
            if (async) {
                new AsyncFlush(last).iterate();
                return;
            }
            try {
                channelWrite(this._aggregate, last);
                onWriteComplete(last, null);
            } catch (Throwable t) {
                onWriteComplete(last, t);
                throw t;
            }
        }
    }

    @Override // javax.servlet.ServletOutputStream
    public void print(String s) throws IOException {
        print(s, false);
    }

    @Override // javax.servlet.ServletOutputStream
    public void println(String s) throws IOException {
        print(s, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0140 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void print(java.lang.String r6, boolean r7) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 368
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.HttpOutput.print(java.lang.String, boolean):void");
    }

    @Override // javax.servlet.ServletOutputStream
    public void println(boolean b) throws IOException {
        println(lStrings.getString(b ? "value.true" : "value.false"));
    }

    @Override // javax.servlet.ServletOutputStream
    public void println(char c) throws IOException {
        println(String.valueOf(c));
    }

    @Override // javax.servlet.ServletOutputStream
    public void println(int i) throws IOException {
        println(String.valueOf(i));
    }

    @Override // javax.servlet.ServletOutputStream
    public void println(long l) throws IOException {
        println(String.valueOf(l));
    }

    @Override // javax.servlet.ServletOutputStream
    public void println(float f) throws IOException {
        println(String.valueOf(f));
    }

    @Override // javax.servlet.ServletOutputStream
    public void println(double d) throws IOException {
        println(String.valueOf(d));
    }

    public void sendContent(ByteBuffer content) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sendContent({})", BufferUtil.toDetailString(content));
        }
        this._written += (long) content.remaining();
        channelWrite(content, true);
    }

    public void sendContent(InputStream in) throws IOException {
        SharedBlockingCallback.Blocker blocker = this._writeBlocker.acquire();
        try {
            new InputStreamWritingCB(in, blocker).iterate();
            blocker.block();
            if (blocker != null) {
                blocker.close();
            }
        } catch (Throwable th) {
            if (blocker != null) {
                try {
                    blocker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void sendContent(ReadableByteChannel in) throws IOException {
        SharedBlockingCallback.Blocker blocker = this._writeBlocker.acquire();
        try {
            new ReadableByteChannelWritingCB(in, blocker).iterate();
            blocker.block();
            if (blocker != null) {
                blocker.close();
            }
        } catch (Throwable th) {
            if (blocker != null) {
                try {
                    blocker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void sendContent(HttpContent content) throws IOException {
        SharedBlockingCallback.Blocker blocker = this._writeBlocker.acquire();
        try {
            sendContent(content, blocker);
            blocker.block();
            if (blocker != null) {
                blocker.close();
            }
        } catch (Throwable th) {
            if (blocker != null) {
                try {
                    blocker.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void sendContent(ByteBuffer content, Callback callback) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sendContent(buffer={},{})", BufferUtil.toDetailString(content), callback);
        }
        if (prepareSendContent(content.remaining(), callback)) {
            channelWrite(content, true, new Callback.Nested(callback) { // from class: org.eclipse.jetty.server.HttpOutput.1
                @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
                public void succeeded() {
                    HttpOutput.this.onWriteComplete(true, null);
                    succeeded();
                }

                @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
                public void failed(Throwable x) {
                    HttpOutput.this.onWriteComplete(true, x);
                    failed(x);
                }
            });
        }
    }

    public void sendContent(InputStream in, Callback callback) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sendContent(stream={},{})", in, callback);
        }
        if (prepareSendContent(0, callback)) {
            new InputStreamWritingCB(in, callback).iterate();
        }
    }

    public void sendContent(ReadableByteChannel in, Callback callback) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sendContent(channel={},{})", in, callback);
        }
        if (prepareSendContent(0, callback)) {
            new ReadableByteChannelWritingCB(in, callback).iterate();
        }
    }

    private boolean prepareSendContent(int len, Callback callback) {
        synchronized (this._channelState) {
            if (BufferUtil.hasContent(this._aggregate)) {
                callback.failed(new IOException("cannot sendContent() after write()"));
                return false;
            } else if (this._channel.isCommitted()) {
                callback.failed(new IOException("cannot sendContent(), output already committed"));
                return false;
            } else {
                switch (this._state) {
                    case CLOSED:
                    case CLOSING:
                        callback.failed(new EofException("Closed"));
                        return false;
                    default:
                        this._state = State.CLOSING;
                        if (this._onError != null) {
                            callback.failed(this._onError);
                            return false;
                        } else if (this._apiState != ApiState.BLOCKING) {
                            throw new IllegalStateException(stateString());
                        } else {
                            this._apiState = ApiState.PENDING;
                            if (len > 0) {
                                this._written += (long) len;
                            }
                            return true;
                        }
                }
            }
        }
    }

    public void sendContent(HttpContent httpContent, Callback callback) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("sendContent(http={},{})", httpContent, callback);
        }
        ByteBuffer buffer = this._channel.useDirectBuffers() ? httpContent.getDirectBuffer() : null;
        if (buffer == null) {
            buffer = httpContent.getIndirectBuffer();
        }
        if (buffer != null) {
            sendContent(buffer, callback);
            return;
        }
        ReadableByteChannel rbc = null;
        try {
            rbc = httpContent.getReadableByteChannel();
        } catch (Throwable x) {
            LOG.debug(x);
        }
        if (rbc != null) {
            sendContent(rbc, callback);
            return;
        }
        InputStream in = null;
        try {
            in = httpContent.getInputStream();
        } catch (Throwable x2) {
            LOG.debug(x2);
        }
        if (in != null) {
            sendContent(in, callback);
            return;
        }
        Throwable cause = new IllegalArgumentException("unknown content for " + httpContent);
        this._channel.abort(cause);
        callback.failed(cause);
    }

    public int getBufferSize() {
        return this._bufferSize;
    }

    public void setBufferSize(int size) {
        this._bufferSize = size;
        this._commitSize = size;
    }

    public void onFlushed(long bytes) throws IOException {
        if (this._firstByteTimeStamp != -1 && this._firstByteTimeStamp != LongCompanionObject.MAX_VALUE) {
            long minDataRate = getHttpChannel().getHttpConfiguration().getMinResponseDataRate();
            this._flushed += bytes;
            long minFlushed = (minDataRate * TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this._firstByteTimeStamp)) / TimeUnit.SECONDS.toMillis(1);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Flushed bytes min/actual {}/{}", Long.valueOf(minFlushed), Long.valueOf(this._flushed));
            }
            if (this._flushed < minFlushed) {
                IOException ioe = new IOException(String.format("Response content data rate < %d B/s", Long.valueOf(minDataRate)));
                this._channel.abort(ioe);
                throw ioe;
            }
        }
    }

    public void recycle() {
        synchronized (this._channelState) {
            this._state = State.OPEN;
            this._apiState = ApiState.BLOCKING;
            this._softClose = true;
            this._interceptor = this._channel;
            HttpConfiguration config = this._channel.getHttpConfiguration();
            this._bufferSize = config.getOutputBufferSize();
            this._commitSize = config.getOutputAggregationSize();
            if (this._commitSize > this._bufferSize) {
                this._commitSize = this._bufferSize;
            }
            releaseBuffer(null);
            this._written = 0;
            this._writeListener = null;
            this._onError = null;
            this._firstByteTimeStamp = -1;
            this._flushed = 0;
            this._closedCallback = null;
        }
    }

    public void resetBuffer() {
        synchronized (this._channelState) {
            this._interceptor.resetBuffer();
            if (BufferUtil.hasContent(this._aggregate)) {
                BufferUtil.clear(this._aggregate);
            }
            this._written = 0;
        }
    }

    @Override // javax.servlet.ServletOutputStream
    public void setWriteListener(WriteListener writeListener) {
        boolean wake;
        if (!this._channel.getState().isAsync()) {
            throw new IllegalStateException("!ASYNC: " + stateString());
        }
        synchronized (this._channelState) {
            if (this._apiState != ApiState.BLOCKING) {
                throw new IllegalStateException("!OPEN" + stateString());
            }
            this._apiState = ApiState.READY;
            this._writeListener = writeListener;
            wake = this._channel.getState().onWritePossible();
        }
        if (wake) {
            this._channel.execute(this._channel);
        }
    }

    @Override // javax.servlet.ServletOutputStream
    public boolean isReady() {
        synchronized (this._channelState) {
            switch (this._apiState) {
                case BLOCKED:
                case UNREADY:
                    return false;
                case PENDING:
                    this._apiState = ApiState.UNREADY;
                    return false;
                case BLOCKING:
                case READY:
                    return true;
                case ASYNC:
                    this._apiState = ApiState.READY;
                    return true;
                default:
                    throw new IllegalStateException(stateString());
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable error = null;
        synchronized (this._channelState) {
            if (this._onError != null) {
                error = this._onError;
                this._onError = null;
            }
        }
        if (error == null) {
            try {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onWritePossible", new Object[0]);
                }
                this._writeListener.onWritePossible();
                return;
            } catch (Throwable t) {
                error = t;
            }
        }
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onError", error);
            }
            this._writeListener.onError(error);
            C5739IO.close((OutputStream) this);
        } catch (Throwable th) {
            C5739IO.close((OutputStream) this);
            throw th;
        }
    }

    private String stateString() {
        return String.format("s=%s,api=%s,sc=%b,e=%s", this._state, this._apiState, Boolean.valueOf(this._softClose), this._onError);
    }

    @Override // java.lang.Object
    public String toString() {
        String format;
        synchronized (this._channelState) {
            format = String.format("%s@%x{%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), stateString());
        }
        return format;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$ChannelWriteCB.class */
    public abstract class ChannelWriteCB extends IteratingCallback {
        final boolean _last;

        private ChannelWriteCB(boolean last) {
            this._last = last;
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteSuccess() {
            HttpOutput.this.onWriteComplete(this._last, null);
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable e) {
            HttpOutput.this.onWriteComplete(this._last, e);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$NestedChannelWriteCB.class */
    private abstract class NestedChannelWriteCB extends ChannelWriteCB {
        private final Callback _callback;

        private NestedChannelWriteCB(Callback callback, boolean last) {
            super(last);
            this._callback = callback;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.ChannelWriteCB, org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return this._callback.getInvocationType();
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.server.HttpOutput.ChannelWriteCB, org.eclipse.jetty.util.IteratingCallback
        public void onCompleteSuccess() {
            try {
                onCompleteSuccess();
            } finally {
                this._callback.succeeded();
            }
        }

        @Override // org.eclipse.jetty.server.HttpOutput.ChannelWriteCB, org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable e) {
            try {
                onCompleteFailure(e);
            } finally {
                this._callback.failed(e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$AsyncFlush.class */
    public class AsyncFlush extends ChannelWriteCB {
        private volatile boolean _flushed;

        private AsyncFlush(boolean last) {
            super(last);
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            if (BufferUtil.hasContent(HttpOutput.this._aggregate)) {
                this._flushed = true;
                HttpOutput.this.channelWrite(HttpOutput.this._aggregate, false, this);
                return IteratingCallback.Action.SCHEDULED;
            } else if (this._flushed) {
                return IteratingCallback.Action.SUCCEEDED;
            } else {
                this._flushed = true;
                HttpOutput.this.channelWrite(BufferUtil.EMPTY_BUFFER, false, this);
                return IteratingCallback.Action.SCHEDULED;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$AsyncWrite.class */
    public class AsyncWrite extends ChannelWriteCB {
        private final ByteBuffer _buffer;
        private final ByteBuffer _slice;
        private final int _len;
        private boolean _completed;

        private AsyncWrite(byte[] b, int off, int len, boolean last) {
            super(last);
            this._buffer = ByteBuffer.wrap(b, off, len);
            this._len = len;
            this._slice = this._len < HttpOutput.this.getBufferSize() ? null : this._buffer.duplicate();
        }

        private AsyncWrite(ByteBuffer buffer, boolean last) {
            super(last);
            this._buffer = buffer;
            this._len = buffer.remaining();
            if (this._buffer.isDirect() || this._len < HttpOutput.this.getBufferSize()) {
                this._slice = null;
            } else {
                this._slice = this._buffer.duplicate();
            }
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            if (BufferUtil.hasContent(HttpOutput.this._aggregate)) {
                this._completed = this._len == 0;
                HttpOutput.this.channelWrite(HttpOutput.this._aggregate, this._last && this._completed, this);
                return IteratingCallback.Action.SCHEDULED;
            } else if (!this._last && HttpOutput.this._aggregate != null && this._len < HttpOutput.this.maximizeAggregateSpace() && this._len < HttpOutput.this._commitSize) {
                int position = BufferUtil.flipToFill(HttpOutput.this._aggregate);
                BufferUtil.put(this._buffer, HttpOutput.this._aggregate);
                BufferUtil.flipToFlush(HttpOutput.this._aggregate, position);
                return IteratingCallback.Action.SUCCEEDED;
            } else if (this._buffer.hasRemaining()) {
                if (this._slice == null) {
                    this._completed = true;
                    HttpOutput.this.channelWrite(this._buffer, this._last, this);
                    return IteratingCallback.Action.SCHEDULED;
                }
                int p = this._buffer.position();
                int pl = p + Math.min(HttpOutput.this.getBufferSize(), this._buffer.remaining());
                this._slice.limit(pl);
                this._buffer.position(pl);
                this._slice.position(p);
                this._completed = !this._buffer.hasRemaining();
                HttpOutput.this.channelWrite(this._slice, this._last && this._completed, this);
                return IteratingCallback.Action.SCHEDULED;
            } else if (!this._last || this._completed) {
                if (HttpOutput.LOG.isDebugEnabled() && this._completed) {
                    HttpOutput.LOG.debug("EOF of {}", this);
                }
                return IteratingCallback.Action.SUCCEEDED;
            } else {
                this._completed = true;
                HttpOutput.this.channelWrite(BufferUtil.EMPTY_BUFFER, true, this);
                return IteratingCallback.Action.SCHEDULED;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$InputStreamWritingCB.class */
    public class InputStreamWritingCB extends NestedChannelWriteCB {
        private final InputStream _in;
        private final ByteBuffer _buffer;
        private boolean _eof;
        private boolean _closed;

        private InputStreamWritingCB(InputStream in, Callback callback) {
            super(callback, true);
            this._in = in;
            this._buffer = HttpOutput.this._channel.getByteBufferPool().acquire(HttpOutput.this.getBufferSize(), false);
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            if (this._eof) {
                if (HttpOutput.LOG.isDebugEnabled()) {
                    HttpOutput.LOG.debug("EOF of {}", this);
                }
                if (!this._closed) {
                    this._closed = true;
                    HttpOutput.this._channel.getByteBufferPool().release(this._buffer);
                    C5739IO.close(this._in);
                }
                return IteratingCallback.Action.SUCCEEDED;
            }
            int len = 0;
            while (len < this._buffer.capacity() && !this._eof) {
                int r = this._in.read(this._buffer.array(), this._buffer.arrayOffset() + len, this._buffer.capacity() - len);
                if (r < 0) {
                    this._eof = true;
                } else {
                    len += r;
                }
            }
            this._buffer.position(0);
            this._buffer.limit(len);
            HttpOutput.access$1614(HttpOutput.this, (long) len);
            HttpOutput.this.channelWrite(this._buffer, this._eof, this);
            return IteratingCallback.Action.SCHEDULED;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.NestedChannelWriteCB, org.eclipse.jetty.server.HttpOutput.ChannelWriteCB, org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable x) {
            try {
                HttpOutput.this._channel.getByteBufferPool().release(this._buffer);
            } finally {
                onCompleteFailure(x);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$ReadableByteChannelWritingCB.class */
    public class ReadableByteChannelWritingCB extends NestedChannelWriteCB {
        private final ReadableByteChannel _in;
        private final ByteBuffer _buffer;
        private boolean _eof;
        private boolean _closed;

        private ReadableByteChannelWritingCB(ReadableByteChannel in, Callback callback) {
            super(callback, true);
            this._in = in;
            this._buffer = HttpOutput.this._channel.getByteBufferPool().acquire(HttpOutput.this.getBufferSize(), HttpOutput.this._channel.useDirectBuffers());
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            if (this._eof) {
                if (HttpOutput.LOG.isDebugEnabled()) {
                    HttpOutput.LOG.debug("EOF of {}", this);
                }
                if (!this._closed) {
                    this._closed = true;
                    HttpOutput.this._channel.getByteBufferPool().release(this._buffer);
                    C5739IO.close(this._in);
                }
                return IteratingCallback.Action.SUCCEEDED;
            }
            BufferUtil.clearToFill(this._buffer);
            while (this._buffer.hasRemaining() && !this._eof) {
                this._eof = this._in.read(this._buffer) < 0;
            }
            BufferUtil.flipToFlush(this._buffer, 0);
            HttpOutput.access$1614(HttpOutput.this, (long) this._buffer.remaining());
            HttpOutput.this.channelWrite(this._buffer, this._eof, this);
            return IteratingCallback.Action.SCHEDULED;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.NestedChannelWriteCB, org.eclipse.jetty.server.HttpOutput.ChannelWriteCB, org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable x) {
            HttpOutput.this._channel.getByteBufferPool().release(this._buffer);
            C5739IO.close(this._in);
            onCompleteFailure(x);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$WriteBlocker.class */
    private static class WriteBlocker extends SharedBlockingCallback {
        private final HttpChannel _channel;

        private WriteBlocker(HttpChannel channel) {
            this._channel = channel;
        }

        @Override // org.eclipse.jetty.util.SharedBlockingCallback
        protected long getIdleTimeout() {
            long blockingTimeout = this._channel.getHttpConfiguration().getBlockingTimeout();
            if (blockingTimeout == 0) {
                return this._channel.getIdleTimeout();
            }
            return blockingTimeout;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpOutput$WriteCompleteCB.class */
    public class WriteCompleteCB implements Callback {
        private WriteCompleteCB() {
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            HttpOutput.this.onWriteComplete(true, null);
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            HttpOutput.this.onWriteComplete(true, x);
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }
    }
}
