package org.eclipse.jetty.server;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.p023io.EofException;
import org.eclipse.jetty.p023io.RuntimeIOException;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput.class */
public class HttpInput extends ServletInputStream implements Runnable {
    private Content _content;
    private Content _intercepted;
    private final HttpChannelState _channelState;
    private ReadListener _listener;
    private long _contentArrived;
    private long _contentConsumed;
    private long _blockUntil;
    private boolean _waitingForContent;
    private Interceptor _interceptor;
    private static final Logger LOG = Log.getLogger(HttpInput.class);
    static final Content EOF_CONTENT = new EofContent("EOF");
    static final Content EARLY_EOF_CONTENT = new EofContent("EARLY_EOF");
    protected static final State STREAM = new State() { // from class: org.eclipse.jetty.server.HttpInput.1
        @Override // org.eclipse.jetty.server.HttpInput.State
        public boolean blockForContent(HttpInput input) throws IOException {
            input.blockForContent();
            return true;
        }

        public String toString() {
            return "STREAM";
        }
    };
    protected static final State ASYNC = new State() { // from class: org.eclipse.jetty.server.HttpInput.2
        @Override // org.eclipse.jetty.server.HttpInput.State
        public int noContent() {
            return 0;
        }

        public String toString() {
            return "ASYNC";
        }
    };
    protected static final State EARLY_EOF = new EOFState() { // from class: org.eclipse.jetty.server.HttpInput.3
        @Override // org.eclipse.jetty.server.HttpInput.State
        public int noContent() throws IOException {
            throw getError();
        }

        public String toString() {
            return "EARLY_EOF";
        }

        @Override // org.eclipse.jetty.server.HttpInput.State
        public IOException getError() {
            return new EofException("Early EOF");
        }
    };
    protected static final State EOF = new EOFState() { // from class: org.eclipse.jetty.server.HttpInput.4
        public String toString() {
            return "EOF";
        }
    };
    protected static final State AEOF = new EOFState() { // from class: org.eclipse.jetty.server.HttpInput.5
        public String toString() {
            return "AEOF";
        }
    };
    private final byte[] _oneByteBuffer = new byte[1];
    private final Deque<Content> _inputQ = new ArrayDeque();
    private State _state = STREAM;
    private long _firstByteTimeStamp = -1;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$Interceptor.class */
    public interface Interceptor {
        Content readFrom(Content content);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$ChainedInterceptor.class */
    public static class ChainedInterceptor implements Interceptor, Destroyable {
        private final Interceptor _prev;
        private final Interceptor _next;

        public ChainedInterceptor(Interceptor prev, Interceptor next) {
            this._prev = prev;
            this._next = next;
        }

        public Interceptor getPrev() {
            return this._prev;
        }

        public Interceptor getNext() {
            return this._next;
        }

        @Override // org.eclipse.jetty.server.HttpInput.Interceptor
        public Content readFrom(Content content) {
            return getNext().readFrom(getPrev().readFrom(content));
        }

        @Override // org.eclipse.jetty.util.component.Destroyable
        public void destroy() {
            if (this._prev instanceof Destroyable) {
                ((Destroyable) this._prev).destroy();
            }
            if (this._next instanceof Destroyable) {
                ((Destroyable) this._next).destroy();
            }
        }
    }

    public HttpInput(HttpChannelState state) {
        this._channelState = state;
    }

    protected HttpChannelState getHttpChannelState() {
        return this._channelState;
    }

    public void recycle() {
        synchronized (this._inputQ) {
            Throwable failure = fail(this._intercepted, null);
            this._intercepted = null;
            Throwable failure2 = fail(this._content, failure);
            this._content = null;
            Content item = this._inputQ.poll();
            while (item != null) {
                failure2 = fail(item, failure2);
                item = this._inputQ.poll();
            }
            this._listener = null;
            this._state = STREAM;
            this._contentArrived = 0;
            this._contentConsumed = 0;
            this._firstByteTimeStamp = -1;
            this._blockUntil = 0;
            this._waitingForContent = false;
            if (this._interceptor instanceof Destroyable) {
                ((Destroyable) this._interceptor).destroy();
            }
            this._interceptor = null;
        }
    }

    private Throwable fail(Content content, Throwable failure) {
        if (content != null) {
            if (failure == null) {
                failure = new IOException("unconsumed input");
            }
            content.failed(failure);
        }
        return failure;
    }

    public Interceptor getInterceptor() {
        return this._interceptor;
    }

    public void setInterceptor(Interceptor interceptor) {
        this._interceptor = interceptor;
    }

    public void addInterceptor(Interceptor interceptor) {
        if (this._interceptor == null) {
            this._interceptor = interceptor;
        } else {
            this._interceptor = new ChainedInterceptor(this._interceptor, interceptor);
        }
    }

    @Override // java.io.InputStream
    public int available() {
        int available = 0;
        synchronized (this._inputQ) {
            if (this._content == null) {
                this._content = this._inputQ.poll();
            }
            if (this._content == null) {
                produceContent();
                if (this._content == null) {
                    this._content = this._inputQ.poll();
                }
            }
            if (this._content != null) {
                available = this._content.remaining();
            }
        }
        if (0 != 0) {
            wake();
        }
        return available;
    }

    protected void wake() {
        HttpChannel channel = this._channelState.getHttpChannel();
        channel.getConnector().getServer().getThreadPool().execute(channel);
    }

    private long getBlockingTimeout() {
        return getHttpChannelState().getHttpChannel().getHttpConfiguration().getBlockingTimeout();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = read(this._oneByteBuffer, 0, 1);
        if (read == 0) {
            throw new IllegalStateException("unready read=0");
        } else if (read < 0) {
            return -1;
        } else {
            return this._oneByteBuffer[0] & 255;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        int l;
        boolean wake = false;
        synchronized (this._inputQ) {
            if (!isAsync() && this._blockUntil == 0) {
                long blockingTimeout = getBlockingTimeout();
                if (blockingTimeout > 0) {
                    this._blockUntil = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(blockingTimeout);
                }
            }
            long minRequestDataRate = this._channelState.getHttpChannel().getHttpConfiguration().getMinRequestDataRate();
            if (minRequestDataRate > 0 && this._firstByteTimeStamp != -1) {
                long period = System.nanoTime() - this._firstByteTimeStamp;
                if (period > 0 && this._contentArrived < (minRequestDataRate * TimeUnit.NANOSECONDS.toMillis(period)) / TimeUnit.SECONDS.toMillis(1)) {
                    BadMessageException bad = new BadMessageException(408, String.format("Request content data rate < %d B/s", Long.valueOf(minRequestDataRate)));
                    if (this._channelState.isResponseCommitted()) {
                        this._channelState.getHttpChannel().abort(bad);
                    }
                    throw bad;
                }
            }
            while (true) {
                Content item = nextContent();
                if (item != null) {
                    l = get(item, b, off, len);
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("{} read {} from {}", this, Integer.valueOf(l), item);
                    }
                    if (item.isEmpty()) {
                        nextInterceptedContent();
                    }
                } else if (!this._state.blockForContent(this)) {
                    l = this._state.noContent();
                    if (l < 0) {
                        wake = this._channelState.onReadEof();
                    }
                }
            }
        }
        if (wake) {
            wake();
        }
        return l;
    }

    protected void produceContent() throws IOException {
    }

    public void asyncReadProduce() throws IOException {
        synchronized (this._inputQ) {
            produceContent();
        }
    }

    protected Content nextContent() throws IOException {
        Content content = nextNonSentinelContent();
        if (content == null && !isFinished()) {
            produceContent();
            content = nextNonSentinelContent();
        }
        return content;
    }

    protected Content nextNonSentinelContent() throws IOException {
        while (true) {
            Content content = nextInterceptedContent();
            if (!(content instanceof SentinelContent)) {
                return content;
            }
            consume(content);
        }
    }

    protected Content produceNextContent() throws IOException {
        Content content = nextInterceptedContent();
        if (content == null && !isFinished()) {
            produceContent();
            content = nextInterceptedContent();
        }
        return content;
    }

    protected Content nextInterceptedContent() throws IOException {
        if (this._intercepted != null) {
            if (this._intercepted.hasContent()) {
                return this._intercepted;
            }
            this._intercepted.succeeded();
            this._intercepted = null;
        }
        if (this._content == null) {
            this._content = this._inputQ.poll();
        }
        while (this._content != null) {
            if (this._interceptor != null) {
                this._intercepted = intercept(this._content);
                if (!(this._intercepted == null || this._intercepted == this._content)) {
                    if (this._intercepted.hasContent()) {
                        return this._intercepted;
                    }
                    this._intercepted.succeeded();
                }
                this._intercepted = null;
            }
            if (this._content.hasContent() || (this._content instanceof SentinelContent)) {
                return this._content;
            }
            this._content.succeeded();
            this._content = this._inputQ.poll();
        }
        return null;
    }

    private Content intercept(Content content) throws IOException {
        try {
            return this._interceptor.readFrom(content);
        } catch (Throwable x) {
            IOException failure = new IOException("Bad content", x);
            content.failed(failure);
            HttpChannel channel = this._channelState.getHttpChannel();
            if (channel.getResponse().isCommitted()) {
                channel.abort(failure);
            }
            throw failure;
        }
    }

    private void consume(Content content) {
        if (!isError() && (content instanceof EofContent)) {
            if (content == EARLY_EOF_CONTENT) {
                this._state = EARLY_EOF;
            } else if (this._listener == null) {
                this._state = EOF;
            } else {
                this._state = AEOF;
            }
        }
        content.succeeded();
        if (this._content == content) {
            this._content = null;
        } else if (this._intercepted == content) {
            this._intercepted = null;
        }
    }

    protected int get(Content content, byte[] buffer, int offset, int length) {
        int l = content.get(buffer, offset, length);
        this._contentConsumed += (long) l;
        return l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004b, code lost:
        throw new java.util.concurrent.TimeoutException(java.lang.String.format("Blocking timeout %d ms", java.lang.Long.valueOf(getBlockingTimeout())));
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void blockForContent() throws java.io.IOException {
        /*
            r9 = this;
            r0 = r9
            r1 = 1
            r0._waitingForContent = r1     // Catch: Throwable -> 0x0097
            r0 = r9
            org.eclipse.jetty.server.HttpChannelState r0 = r0._channelState     // Catch: Throwable -> 0x0097
            org.eclipse.jetty.server.HttpChannel r0 = r0.getHttpChannel()     // Catch: Throwable -> 0x0097
            r0.onBlockWaitForContent()     // Catch: Throwable -> 0x0097
            r0 = 0
            r10 = r0
            r0 = 0
            r11 = r0
        L_0x0013:
            r0 = r9
            long r0 = r0._blockUntil     // Catch: Throwable -> 0x0097
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x004c
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: Throwable -> 0x0097
            r1 = r9
            long r1 = r1._blockUntil     // Catch: Throwable -> 0x0097
            long r2 = java.lang.System.nanoTime()     // Catch: Throwable -> 0x0097
            long r1 = r1 - r2
            long r0 = r0.toMillis(r1)     // Catch: Throwable -> 0x0097
            r11 = r0
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x004c
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch: Throwable -> 0x0097
            r1 = r0
            java.lang.String r2 = "Blocking timeout %d ms"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: Throwable -> 0x0097
            r4 = r3
            r5 = 0
            r6 = r9
            long r6 = r6.getBlockingTimeout()     // Catch: Throwable -> 0x0097
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch: Throwable -> 0x0097
            r4[r5] = r6     // Catch: Throwable -> 0x0097
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch: Throwable -> 0x0097
            r1.<init>(r2)     // Catch: Throwable -> 0x0097
            throw r0     // Catch: Throwable -> 0x0097
        L_0x004c:
            r0 = r10
            if (r0 == 0) goto L_0x0053
            goto L_0x0094
        L_0x0053:
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.HttpInput.LOG     // Catch: Throwable -> 0x0097
            boolean r0 = r0.isDebugEnabled()     // Catch: Throwable -> 0x0097
            if (r0 == 0) goto L_0x0077
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.HttpInput.LOG     // Catch: Throwable -> 0x0097
            java.lang.String r1 = "{} blocking for content timeout={}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Throwable -> 0x0097
            r3 = r2
            r4 = 0
            r5 = r9
            r3[r4] = r5     // Catch: Throwable -> 0x0097
            r3 = r2
            r4 = 1
            r5 = r11
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: Throwable -> 0x0097
            r3[r4] = r5     // Catch: Throwable -> 0x0097
            r0.debug(r1, r2)     // Catch: Throwable -> 0x0097
        L_0x0077:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            r0 = r9
            java.util.Deque<org.eclipse.jetty.server.HttpInput$Content> r0 = r0._inputQ     // Catch: Throwable -> 0x0097
            r1 = r11
            r0.wait(r1)     // Catch: Throwable -> 0x0097
            goto L_0x008f
        L_0x0088:
            r0 = r9
            java.util.Deque<org.eclipse.jetty.server.HttpInput$Content> r0 = r0._inputQ     // Catch: Throwable -> 0x0097
            r0.wait()     // Catch: Throwable -> 0x0097
        L_0x008f:
            r0 = 1
            r10 = r0
            goto L_0x0013
        L_0x0094:
            goto L_0x00a3
        L_0x0097:
            r10 = move-exception
            r0 = r9
            org.eclipse.jetty.server.HttpChannelState r0 = r0._channelState
            org.eclipse.jetty.server.HttpChannel r0 = r0.getHttpChannel()
            r1 = r10
            r0.onBlockWaitForContentFailure(r1)
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.HttpInput.blockForContent():void");
    }

    public boolean addContent(Content content) {
        synchronized (this._inputQ) {
            this._waitingForContent = false;
            if (this._firstByteTimeStamp == -1) {
                this._firstByteTimeStamp = System.nanoTime();
            }
            if (isFinished()) {
                content.failed(isError() ? this._state.getError() : new EOFException("Content after EOF"));
                return false;
            }
            this._contentArrived += (long) content.remaining();
            if (this._content != null || !this._inputQ.isEmpty()) {
                this._inputQ.offer(content);
            } else {
                this._content = content;
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} addContent {}", this, content);
            }
            if (nextInterceptedContent() == null) {
                return false;
            }
            return wakeup();
        }
    }

    public boolean hasContent() {
        boolean z;
        synchronized (this._inputQ) {
            z = this._content != null || this._inputQ.size() > 0;
        }
        return z;
    }

    public void unblock() {
        synchronized (this._inputQ) {
            this._inputQ.notify();
        }
    }

    public long getContentConsumed() {
        long j;
        synchronized (this._inputQ) {
            j = this._contentConsumed;
        }
        return j;
    }

    public long getContentReceived() {
        long j;
        synchronized (this._inputQ) {
            j = this._contentArrived;
        }
        return j;
    }

    public boolean earlyEOF() {
        return addContent(EARLY_EOF_CONTENT);
    }

    public boolean eof() {
        return addContent(EOF_CONTENT);
    }

    public boolean consumeAll() {
        while (true) {
            synchronized (this._inputQ) {
                if (this._intercepted != null) {
                    this._intercepted.skip(this._intercepted.remaining());
                    consume(this._intercepted);
                }
                if (this._content != null) {
                    this._content.skip(this._content.remaining());
                    consume(this._content);
                }
                Content content = this._inputQ.poll();
                while (content != null) {
                    consume(content);
                    content = this._inputQ.poll();
                }
                if (this._state instanceof EOFState) {
                    return !(this._state instanceof ErrorState);
                }
                produceContent();
                if (this._content == null && this._intercepted == null && this._inputQ.isEmpty()) {
                    this._state = EARLY_EOF;
                    this._inputQ.notify();
                    return false;
                }
            }
        }
    }

    public boolean isError() {
        boolean z;
        synchronized (this._inputQ) {
            z = this._state instanceof ErrorState;
        }
        return z;
    }

    public boolean isAsync() {
        boolean z;
        synchronized (this._inputQ) {
            z = this._state == ASYNC;
        }
        return z;
    }

    @Override // javax.servlet.ServletInputStream
    public boolean isFinished() {
        boolean z;
        synchronized (this._inputQ) {
            z = this._state instanceof EOFState;
        }
        return z;
    }

    @Override // javax.servlet.ServletInputStream
    public boolean isReady() {
        synchronized (this._inputQ) {
            if (this._listener == null) {
                return true;
            }
            if (this._state instanceof EOFState) {
                return true;
            }
            if (this._waitingForContent) {
                return false;
            }
            if (produceNextContent() != null) {
                return true;
            }
            this._channelState.onReadUnready();
            this._waitingForContent = true;
            return false;
        }
    }

    @Override // javax.servlet.ServletInputStream
    public void setReadListener(ReadListener readListener) {
        boolean woken = false;
        synchronized (this._inputQ) {
            if (this._listener != null) {
                throw new IllegalStateException("ReadListener already set");
            }
            this._listener = (ReadListener) Objects.requireNonNull(readListener);
            if (isError()) {
                woken = this._channelState.onReadReady();
            } else if (produceNextContent() != null) {
                this._state = ASYNC;
                woken = this._channelState.onReadReady();
            } else if (this._state == EOF) {
                this._state = AEOF;
                woken = this._channelState.onReadEof();
            } else {
                this._state = ASYNC;
                this._channelState.onReadUnready();
                this._waitingForContent = true;
            }
        }
        if (woken) {
            wake();
        }
    }

    public boolean onIdleTimeout(Throwable x) {
        synchronized (this._inputQ) {
            boolean neverDispatched = getHttpChannelState().isIdle();
            if ((!this._waitingForContent && !neverDispatched) || isError()) {
                return false;
            }
            x.addSuppressed(new Throwable("HttpInput idle timeout"));
            this._state = new ErrorState(x);
            return wakeup();
        }
    }

    public boolean failed(Throwable x) {
        boolean wakeup;
        synchronized (this._inputQ) {
            if (!isError()) {
                x.addSuppressed(new Throwable("HttpInput failure"));
                this._state = new ErrorState(x);
            } else if (LOG.isDebugEnabled()) {
                Throwable failure = new Throwable(this._state.getError());
                failure.addSuppressed(x);
                LOG.debug(failure);
            }
            wakeup = wakeup();
        }
        return wakeup;
    }

    private boolean wakeup() {
        if (this._listener != null) {
            return this._channelState.onContentAdded();
        }
        this._inputQ.notify();
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReadListener listener = null;
        boolean aeof = false;
        try {
            synchronized (this._inputQ) {
                ReadListener listener2 = this._listener;
                if (this._state != EOF) {
                    if (this._state == AEOF) {
                        this._state = EOF;
                        aeof = true;
                    }
                    Throwable error = this._state.getError();
                    if (!aeof && error == null) {
                        Content content = nextInterceptedContent();
                        if (content != null) {
                            if (content instanceof EofContent) {
                                consume(content);
                                if (this._state == EARLY_EOF) {
                                    error = this._state.getError();
                                } else if (this._state == AEOF) {
                                    aeof = true;
                                    this._state = EOF;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    if (error != null) {
                        this._channelState.getHttpChannel().getResponse().getHttpFields().add(HttpConnection.CONNECTION_CLOSE);
                        listener2.onError(error);
                    } else if (aeof) {
                        listener2.onAllDataRead();
                    } else {
                        listener2.onDataAvailable();
                    }
                }
            }
        } catch (Throwable e) {
            LOG.warn(e.toString(), new Object[0]);
            if (LOG.isDebugEnabled()) {
                LOG.debug("", e);
            }
            if (0 != 0 || 0 == 0) {
                try {
                    this._channelState.getHttpChannel().getResponse().getHttpFields().add(HttpConnection.CONNECTION_CLOSE);
                    listener.onError(e);
                } catch (Throwable ex2) {
                    LOG.warn(ex2.toString(), new Object[0]);
                    LOG.debug(ex2);
                    throw new RuntimeIOException(ex2);
                }
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        State state;
        long consumed;
        int q;
        Content content;
        synchronized (this._inputQ) {
            state = this._state;
            consumed = this._contentConsumed;
            q = this._inputQ.size();
            content = this._inputQ.peekFirst();
        }
        return String.format("%s@%x[c=%d,q=%d,[0]=%s,s=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), Long.valueOf(consumed), Integer.valueOf(q), content, state);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$SentinelContent.class */
    public static class SentinelContent extends Content {
        private final String _name;

        public SentinelContent(String name) {
            super(BufferUtil.EMPTY_BUFFER);
            this._name = name;
        }

        @Override // org.eclipse.jetty.server.HttpInput.Content
        public String toString() {
            return this._name;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$EofContent.class */
    public static class EofContent extends SentinelContent {
        EofContent(String name) {
            super(name);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$Content.class */
    public static class Content implements Callback {
        protected final ByteBuffer _content;

        public Content(ByteBuffer content) {
            this._content = content;
        }

        public ByteBuffer getByteBuffer() {
            return this._content;
        }

        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return Invocable.InvocationType.NON_BLOCKING;
        }

        public int get(byte[] buffer, int offset, int length) {
            int length2 = Math.min(this._content.remaining(), length);
            this._content.get(buffer, offset, length2);
            return length2;
        }

        public int skip(int length) {
            int length2 = Math.min(this._content.remaining(), length);
            this._content.position(this._content.position() + length2);
            return length2;
        }

        public boolean hasContent() {
            return this._content.hasRemaining();
        }

        public int remaining() {
            return this._content.remaining();
        }

        public boolean isEmpty() {
            return !this._content.hasRemaining();
        }

        public String toString() {
            return String.format("Content@%x{%s}", Integer.valueOf(hashCode()), BufferUtil.toDetailString(this._content));
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$State.class */
    public static abstract class State {
        protected State() {
        }

        public boolean blockForContent(HttpInput in) throws IOException {
            return false;
        }

        public int noContent() throws IOException {
            return -1;
        }

        public Throwable getError() {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$EOFState.class */
    public static class EOFState extends State {
        protected EOFState() {
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpInput$ErrorState.class */
    public static class ErrorState extends EOFState {
        final Throwable _error;

        ErrorState(Throwable error) {
            this._error = error;
        }

        @Override // org.eclipse.jetty.server.HttpInput.State
        public Throwable getError() {
            return this._error;
        }

        @Override // org.eclipse.jetty.server.HttpInput.State
        public int noContent() throws IOException {
            if (this._error instanceof IOException) {
                throw ((IOException) this._error);
            }
            throw new IOException(this._error);
        }

        public String toString() {
            return "ERROR:" + this._error;
        }
    }
}
