package org.eclipse.jetty.p023io.ssl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.ToIntFunction;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.AbstractEndPoint;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.WriteFlusher;
import org.eclipse.jetty.p023io.ssl.SslHandshakeListener;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* renamed from: org.eclipse.jetty.io.ssl.SslConnection */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection.class */
public class SslConnection extends AbstractConnection implements Connection.UpgradeTo {
    private static final Logger LOG = Log.getLogger(SslConnection.class);
    private static final String TLS_1_3 = "TLSv1.3";
    private final AtomicReference<HandshakeState> _handshake;
    private final List<SslHandshakeListener> handshakeListeners;
    private final AtomicLong _bytesIn;
    private final AtomicLong _bytesOut;
    private final ByteBufferPool _bufferPool;
    private final SSLEngine _sslEngine;
    private final DecryptedEndPoint _decryptedEndPoint;
    private ByteBuffer _decryptedInput;
    private ByteBuffer _encryptedInput;
    private ByteBuffer _encryptedOutput;
    private final boolean _encryptedDirectBuffers;
    private final boolean _decryptedDirectBuffers;
    private boolean _renegotiationAllowed;
    private int _renegotiationLimit;
    private boolean _closedOutbound;
    private boolean _requireCloseMessage;
    private FlushState _flushState;
    private FillState _fillState;
    private boolean _underflown;
    private final Runnable _runFillable;
    private final Callback _sslReadCallback;

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.ssl.SslConnection$FillState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$FillState.class */
    public enum FillState {
        IDLE,
        INTERESTED,
        WAIT_FOR_FLUSH
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.ssl.SslConnection$FlushState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$FlushState.class */
    public enum FlushState {
        IDLE,
        WRITING,
        WAIT_FOR_FILL
    }

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.io.ssl.SslConnection$HandshakeState */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$HandshakeState.class */
    public enum HandshakeState {
        INITIAL,
        HANDSHAKE,
        SUCCEEDED,
        FAILED
    }

    static /* synthetic */ int access$2410(SslConnection x0) {
        int i = x0._renegotiationLimit;
        x0._renegotiationLimit = i - 1;
        return i;
    }

    /* renamed from: org.eclipse.jetty.io.ssl.SslConnection$RunnableTask */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$RunnableTask.class */
    private abstract class RunnableTask implements Runnable, Invocable {
        private final String _operation;

        protected RunnableTask(String op) {
            this._operation = op;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("SSL:%s:%s:%s", SslConnection.this, this._operation, getInvocationType());
        }
    }

    public SslConnection(ByteBufferPool byteBufferPool, Executor executor, EndPoint endPoint, SSLEngine sslEngine) {
        this(byteBufferPool, executor, endPoint, sslEngine, false, false);
    }

    public SslConnection(ByteBufferPool byteBufferPool, Executor executor, EndPoint endPoint, SSLEngine sslEngine, boolean useDirectBuffersForEncryption, boolean useDirectBuffersForDecryption) {
        super(endPoint, executor);
        this._handshake = new AtomicReference<>(HandshakeState.INITIAL);
        this.handshakeListeners = new ArrayList();
        this._bytesIn = new AtomicLong();
        this._bytesOut = new AtomicLong();
        this._renegotiationLimit = -1;
        this._flushState = FlushState.IDLE;
        this._fillState = FillState.IDLE;
        this._runFillable = new RunnableTask("runFillable") { // from class: org.eclipse.jetty.io.ssl.SslConnection.1
            @Override // java.lang.Runnable
            public void run() {
                SslConnection.this._decryptedEndPoint.getFillInterest().fillable();
            }

            @Override // org.eclipse.jetty.util.thread.Invocable
            public Invocable.InvocationType getInvocationType() {
                return SslConnection.this._decryptedEndPoint.getFillInterest().getCallbackInvocationType();
            }
        };
        this._sslReadCallback = new Callback() { // from class: org.eclipse.jetty.io.ssl.SslConnection.2
            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                SslConnection.this.onFillable();
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable x) {
                SslConnection.this.onFillInterestedFailed(x);
            }

            @Override // org.eclipse.jetty.util.thread.Invocable
            public Invocable.InvocationType getInvocationType() {
                return SslConnection.this.getDecryptedEndPoint().getFillInterest().getCallbackInvocationType();
            }

            public String toString() {
                return String.format("SSLC.NBReadCB@%x{%s}", Integer.valueOf(SslConnection.this.hashCode()), SslConnection.this);
            }
        };
        this._bufferPool = byteBufferPool;
        this._sslEngine = sslEngine;
        this._decryptedEndPoint = newDecryptedEndPoint();
        this._encryptedDirectBuffers = useDirectBuffersForEncryption;
        this._decryptedDirectBuffers = useDirectBuffersForDecryption;
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getBytesIn() {
        return this._bytesIn.get();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public long getBytesOut() {
        return this._bytesOut.get();
    }

    public void addHandshakeListener(SslHandshakeListener listener) {
        this.handshakeListeners.add(listener);
    }

    public boolean removeHandshakeListener(SslHandshakeListener listener) {
        return this.handshakeListeners.remove(listener);
    }

    protected DecryptedEndPoint newDecryptedEndPoint() {
        return new DecryptedEndPoint();
    }

    public SSLEngine getSSLEngine() {
        return this._sslEngine;
    }

    public DecryptedEndPoint getDecryptedEndPoint() {
        return this._decryptedEndPoint;
    }

    public boolean isRenegotiationAllowed() {
        return this._renegotiationAllowed;
    }

    public void setRenegotiationAllowed(boolean renegotiationAllowed) {
        this._renegotiationAllowed = renegotiationAllowed;
    }

    public int getRenegotiationLimit() {
        return this._renegotiationLimit;
    }

    public void setRenegotiationLimit(int renegotiationLimit) {
        this._renegotiationLimit = renegotiationLimit;
    }

    @Deprecated
    public boolean isAllowMissingCloseMessage() {
        return !isRequireCloseMessage();
    }

    @Deprecated
    public void setAllowMissingCloseMessage(boolean allowMissingCloseMessage) {
        setRequireCloseMessage(!allowMissingCloseMessage);
    }

    public boolean isRequireCloseMessage() {
        return this._requireCloseMessage;
    }

    public void setRequireCloseMessage(boolean requireCloseMessage) {
        this._requireCloseMessage = requireCloseMessage;
    }

    /* access modifiers changed from: private */
    public boolean isHandshakeInitial() {
        return this._handshake.get() == HandshakeState.INITIAL;
    }

    /* access modifiers changed from: private */
    public boolean isHandshakeSucceeded() {
        return this._handshake.get() == HandshakeState.SUCCEEDED;
    }

    /* access modifiers changed from: private */
    public boolean isHandshakeComplete() {
        HandshakeState state = this._handshake.get();
        return state == HandshakeState.SUCCEEDED || state == HandshakeState.FAILED;
    }

    /* access modifiers changed from: private */
    public int getApplicationBufferSize() {
        return getBufferSize((v0) -> {
            return v0.getApplicationBufferSize();
        });
    }

    /* access modifiers changed from: private */
    public int getPacketBufferSize() {
        return getBufferSize((v0) -> {
            return v0.getPacketBufferSize();
        });
    }

    private int getBufferSize(ToIntFunction<SSLSession> bufferSizeFn) {
        SSLSession hsSession = this._sslEngine.getHandshakeSession();
        SSLSession session = this._sslEngine.getSession();
        int size = bufferSizeFn.applyAsInt(session);
        if (hsSession == null || hsSession == session) {
            return size;
        }
        return Math.max(bufferSizeFn.applyAsInt(hsSession), size);
    }

    /* access modifiers changed from: private */
    public void acquireEncryptedInput() {
        if (this._encryptedInput == null) {
            this._encryptedInput = this._bufferPool.acquire(getPacketBufferSize(), this._encryptedDirectBuffers);
        }
    }

    /* access modifiers changed from: private */
    public void acquireEncryptedOutput() {
        if (this._encryptedOutput == null) {
            this._encryptedOutput = this._bufferPool.acquire(getPacketBufferSize(), this._encryptedDirectBuffers);
        }
    }

    @Override // org.eclipse.jetty.p023io.Connection.UpgradeTo
    public void onUpgradeTo(ByteBuffer buffer) {
        acquireEncryptedInput();
        BufferUtil.append(this._encryptedInput, buffer);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public void onOpen() {
        onOpen();
        getDecryptedEndPoint().getConnection().onOpen();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public void onClose() {
        this._decryptedEndPoint.getConnection().onClose();
        onClose();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection, java.io.Closeable, java.lang.AutoCloseable, org.eclipse.jetty.client.api.Connection
    public void close() {
        getDecryptedEndPoint().getConnection().close();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public boolean onIdleExpired() {
        return getDecryptedEndPoint().getConnection().onIdleExpired();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillable() {
        if (LOG.isDebugEnabled()) {
            LOG.debug(">c.onFillable {}", this);
        }
        if (this._decryptedEndPoint.isInputShutdown()) {
            this._decryptedEndPoint.close();
        }
        this._decryptedEndPoint.onFillable();
        if (LOG.isDebugEnabled()) {
            LOG.debug("<c.onFillable {}", this);
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillInterestedFailed(Throwable cause) {
        this._decryptedEndPoint.onFillableFail(cause == null ? new IOException() : cause);
    }

    protected SSLEngineResult wrap(SSLEngine sslEngine, ByteBuffer[] input, ByteBuffer output) throws SSLException {
        return sslEngine.wrap(input, output);
    }

    protected SSLEngineResult unwrap(SSLEngine sslEngine, ByteBuffer input, ByteBuffer output) throws SSLException {
        return sslEngine.unwrap(input, output);
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public String toConnectionString() {
        ByteBuffer b = this._encryptedInput;
        int ei = b == null ? -1 : b.remaining();
        ByteBuffer b2 = this._encryptedOutput;
        int eo = b2 == null ? -1 : b2.remaining();
        ByteBuffer b3 = this._decryptedInput;
        int di = b3 == null ? -1 : b3.remaining();
        Connection connection = this._decryptedEndPoint.getConnection();
        Object[] objArr = new Object[10];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = this._sslEngine.getHandshakeStatus();
        objArr[3] = Integer.valueOf(ei);
        objArr[4] = Integer.valueOf(eo);
        objArr[5] = Integer.valueOf(di);
        objArr[6] = this._fillState;
        objArr[7] = this._flushState;
        objArr[8] = this._decryptedEndPoint.toEndPointString();
        objArr[9] = connection instanceof AbstractConnection ? ((AbstractConnection) connection).toConnectionString() : connection;
        return String.format("%s@%x{%s,eio=%d/%d,di=%d,fill=%s,flush=%s}~>%s=>%s", objArr);
    }

    /* access modifiers changed from: private */
    public void releaseEncryptedInputBuffer() {
        if (this._encryptedInput != null && !this._encryptedInput.hasRemaining()) {
            this._bufferPool.release(this._encryptedInput);
            this._encryptedInput = null;
        }
    }

    protected void releaseDecryptedInputBuffer() {
        if (this._decryptedInput != null && !this._decryptedInput.hasRemaining()) {
            this._bufferPool.release(this._decryptedInput);
            this._decryptedInput = null;
        }
    }

    /* access modifiers changed from: private */
    public void releaseEncryptedOutputBuffer() {
        if (!Thread.holdsLock(this._decryptedEndPoint)) {
            throw new IllegalStateException();
        } else if (this._encryptedOutput != null && !this._encryptedOutput.hasRemaining()) {
            this._bufferPool.release(this._encryptedOutput);
            this._encryptedOutput = null;
        }
    }

    protected int networkFill(ByteBuffer input) throws IOException {
        return getEndPoint().fill(input);
    }

    protected boolean networkFlush(ByteBuffer output) throws IOException {
        return getEndPoint().flush(output);
    }

    /* renamed from: org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$DecryptedEndPoint.class */
    public class DecryptedEndPoint extends AbstractEndPoint {
        private final Callback _incompleteWriteCallback = new IncompleteWriteCallback();
        private Throwable _failure;

        public DecryptedEndPoint() {
            super(null);
            setIdleTimeout(-1);
        }

        @Override // org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
        public long getIdleTimeout() {
            return SslConnection.this.getEndPoint().getIdleTimeout();
        }

        @Override // org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
        public void setIdleTimeout(long idleTimeout) {
            SslConnection.this.getEndPoint().setIdleTimeout(idleTimeout);
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
        public boolean isOpen() {
            return SslConnection.this.getEndPoint().isOpen();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public InetSocketAddress getLocalAddress() {
            return SslConnection.this.getEndPoint().getLocalAddress();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public InetSocketAddress getRemoteAddress() {
            return SslConnection.this.getEndPoint().getRemoteAddress();
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint
        public WriteFlusher getWriteFlusher() {
            return getWriteFlusher();
        }

        protected void onFillable() {
            boolean waitingForFill;
            boolean waitingForFill2;
            try {
                synchronized (SslConnection.this._decryptedEndPoint) {
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug("onFillable {}", SslConnection.this);
                    }
                    SslConnection.this._fillState = FillState.IDLE;
                    waitingForFill = SslConnection.this._flushState == FlushState.WAIT_FOR_FILL;
                }
                getFillInterest().fillable();
                if (waitingForFill) {
                    synchronized (SslConnection.this._decryptedEndPoint) {
                        waitingForFill2 = SslConnection.this._flushState == FlushState.WAIT_FOR_FILL;
                    }
                    if (waitingForFill2) {
                        fill(BufferUtil.EMPTY_BUFFER);
                    }
                }
            } catch (Throwable e) {
                close(e);
            }
        }

        protected void onFillableFail(Throwable failure) {
            boolean fail = false;
            synchronized (SslConnection.this._decryptedEndPoint) {
                if (SslConnection.LOG.isDebugEnabled()) {
                    SslConnection.LOG.debug("onFillableFail {}", SslConnection.this, failure);
                }
                SslConnection.this._fillState = FillState.IDLE;
                if (SslConnection.this._flushState == FlushState.WAIT_FOR_FILL) {
                    SslConnection.this._flushState = FlushState.IDLE;
                    fail = true;
                }
            }
            getFillInterest().onFail(failure);
            if (fail && !getWriteFlusher().onFail(failure)) {
                close(failure);
            }
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.EndPoint
        public void setConnection(Connection connection) {
            if (connection instanceof AbstractConnection) {
                AbstractConnection c = (AbstractConnection) connection;
                int appBufferSize = SslConnection.this.getApplicationBufferSize();
                if (c.getInputBufferSize() < appBufferSize) {
                    c.setInputBufferSize(appBufferSize);
                }
            }
            setConnection(connection);
        }

        public SslConnection getSslConnection() {
            return SslConnection.this;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:110:0x041e
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // org.eclipse.jetty.p023io.EndPoint
        public int fill(java.nio.ByteBuffer r10) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 2428
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.fill(java.nio.ByteBuffer):int");
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint
        protected void needsFillInterest() {
            try {
                ByteBuffer write = null;
                boolean interest = false;
                synchronized (SslConnection.this._decryptedEndPoint) {
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug(">needFillInterest s={}/{} uf={} ei={} di={} {}", SslConnection.this._flushState, SslConnection.this._fillState, Boolean.valueOf(SslConnection.this._underflown), BufferUtil.toDetailString(SslConnection.this._encryptedInput), BufferUtil.toDetailString(SslConnection.this._decryptedInput), SslConnection.this);
                    }
                    if (SslConnection.this._fillState == FillState.IDLE) {
                        boolean fillable = BufferUtil.hasContent(SslConnection.this._decryptedInput) || (BufferUtil.hasContent(SslConnection.this._encryptedInput) && !SslConnection.this._underflown);
                        SSLEngineResult.HandshakeStatus status = SslConnection.this._sslEngine.getHandshakeStatus();
                        switch (C56483.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[status.ordinal()]) {
                            case 1:
                            case 2:
                                if (!fillable) {
                                    interest = true;
                                    SslConnection.this._fillState = FillState.INTERESTED;
                                    if (SslConnection.this._flushState == FlushState.IDLE && BufferUtil.hasContent(SslConnection.this._encryptedOutput)) {
                                        SslConnection.this._flushState = FlushState.WRITING;
                                        write = SslConnection.this._encryptedOutput;
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                fillable = true;
                                break;
                            case 4:
                                if (!fillable) {
                                    SslConnection.this._fillState = FillState.WAIT_FOR_FLUSH;
                                    if (SslConnection.this._flushState == FlushState.IDLE) {
                                        SslConnection.this._flushState = FlushState.WRITING;
                                        write = BufferUtil.hasContent(SslConnection.this._encryptedOutput) ? SslConnection.this._encryptedOutput : BufferUtil.EMPTY_BUFFER;
                                        break;
                                    }
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unexpected HandshakeStatus " + status);
                        }
                        if (SslConnection.LOG.isDebugEnabled()) {
                            SslConnection.LOG.debug("<needFillInterest s={}/{} f={} i={} w={}", SslConnection.this._flushState, SslConnection.this._fillState, Boolean.valueOf(fillable), Boolean.valueOf(interest), BufferUtil.toDetailString(write));
                        }
                        if (write != null) {
                            SslConnection.this.getEndPoint().write(this._incompleteWriteCallback, write);
                        } else if (fillable) {
                            SslConnection.this.getExecutor().execute(SslConnection.this._runFillable);
                        } else if (interest) {
                            ensureFillInterested();
                        }
                    }
                }
            } catch (Throwable x) {
                if (SslConnection.LOG.isDebugEnabled()) {
                    SslConnection.LOG.debug(SslConnection.this.toString(), x);
                }
                close(x);
                throw x;
            }
        }

        private void handshakeSucceeded() throws SSLException {
            if (SslConnection.this._handshake.compareAndSet(HandshakeState.HANDSHAKE, HandshakeState.SUCCEEDED)) {
                if (SslConnection.LOG.isDebugEnabled()) {
                    Logger logger = SslConnection.LOG;
                    Object[] objArr = new Object[4];
                    objArr[0] = SslConnection.this;
                    objArr[1] = SslConnection.this._sslEngine.getUseClientMode() ? "client" : "resumed server";
                    objArr[2] = SslConnection.this._sslEngine.getSession().getProtocol();
                    objArr[3] = SslConnection.this._sslEngine.getSession().getCipherSuite();
                    logger.debug("handshake succeeded {} {} {}/{}", objArr);
                }
                notifyHandshakeSucceeded(SslConnection.this._sslEngine);
            } else if (SslConnection.this.isHandshakeSucceeded() && SslConnection.this._renegotiationLimit > 0) {
                SslConnection.access$2410(SslConnection.this);
            }
        }

        private Throwable handshakeFailed(Throwable failure) {
            if (SslConnection.this._handshake.compareAndSet(HandshakeState.HANDSHAKE, HandshakeState.FAILED)) {
                if (SslConnection.LOG.isDebugEnabled()) {
                    SslConnection.LOG.debug("handshake failed {} {}", SslConnection.this, failure);
                }
                if (!(failure instanceof SSLHandshakeException)) {
                    failure = new SSLHandshakeException(failure.getMessage()).initCause(failure);
                }
                notifyHandshakeFailed(SslConnection.this._sslEngine, failure);
            }
            return failure;
        }

        private void terminateInput() {
            try {
                SslConnection.this._sslEngine.closeInbound();
            } catch (Throwable x) {
                SslConnection.LOG.ignore(x);
            }
        }

        private Throwable closeInbound() throws SSLException {
            SSLEngineResult.HandshakeStatus handshakeStatus = SslConnection.this._sslEngine.getHandshakeStatus();
            try {
                SslConnection.this._sslEngine.closeInbound();
                return null;
            } catch (SSLException x) {
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || !SslConnection.this.isRequireCloseMessage()) {
                    SslConnection.LOG.ignore(x);
                    return x;
                }
                throw x;
            } catch (Throwable x2) {
                SslConnection.LOG.ignore(x2);
                return x2;
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:72:0x029a
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // org.eclipse.jetty.p023io.EndPoint
        public boolean flush(java.nio.ByteBuffer... r10) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 1680
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.flush(java.nio.ByteBuffer[]):boolean");
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint
        protected void onIncompleteFlush() {
            try {
                boolean fillInterest = false;
                ByteBuffer write = null;
                synchronized (SslConnection.this._decryptedEndPoint) {
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug(">onIncompleteFlush {} {}", SslConnection.this, BufferUtil.toDetailString(SslConnection.this._encryptedOutput));
                    }
                    if (SslConnection.this._flushState == FlushState.IDLE) {
                        while (true) {
                            SSLEngineResult.HandshakeStatus status = SslConnection.this._sslEngine.getHandshakeStatus();
                            switch (C56483.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[status.ordinal()]) {
                                case 1:
                                    if (!BufferUtil.hasContent(SslConnection.this._encryptedOutput)) {
                                        if (SslConnection.this._fillState == FillState.IDLE) {
                                            int filled = fill(BufferUtil.EMPTY_BUFFER);
                                            if (SslConnection.this._sslEngine.getHandshakeStatus() == status) {
                                                if (filled >= 0) {
                                                    fillInterest = true;
                                                    SslConnection.this._fillState = FillState.INTERESTED;
                                                    SslConnection.this._flushState = FlushState.WAIT_FOR_FILL;
                                                    break;
                                                } else {
                                                    try {
                                                        throw new IOException("Broken pipe");
                                                    } catch (IOException e) {
                                                        SslConnection.LOG.debug(e);
                                                        close(e);
                                                        write = BufferUtil.EMPTY_BUFFER;
                                                        SslConnection.this._flushState = FlushState.WRITING;
                                                        break;
                                                    }
                                                }
                                            }
                                        } else {
                                            SslConnection.this._flushState = FlushState.WAIT_FOR_FILL;
                                            break;
                                        }
                                    } else {
                                        write = SslConnection.this._encryptedOutput;
                                        SslConnection.this._flushState = FlushState.WRITING;
                                        break;
                                    }
                                case 2:
                                case 3:
                                case 4:
                                    write = BufferUtil.hasContent(SslConnection.this._encryptedOutput) ? SslConnection.this._encryptedOutput : BufferUtil.EMPTY_BUFFER;
                                    SslConnection.this._flushState = FlushState.WRITING;
                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected HandshakeStatus " + status);
                            }
                        }
                        if (SslConnection.LOG.isDebugEnabled()) {
                            SslConnection.LOG.debug("<onIncompleteFlush s={}/{} fi={} w={}", SslConnection.this._flushState, SslConnection.this._fillState, Boolean.valueOf(fillInterest), BufferUtil.toDetailString(write));
                        }
                        if (write != null) {
                            SslConnection.this.getEndPoint().write(this._incompleteWriteCallback, write);
                        } else if (fillInterest) {
                            ensureFillInterested();
                        }
                    }
                }
            } catch (Throwable x) {
                if (SslConnection.LOG.isDebugEnabled()) {
                    SslConnection.LOG.debug(SslConnection.this.toString(), x);
                }
                close(x);
                throw x;
            }
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint
        public void doShutdownOutput() {
            boolean ishut;
            EndPoint endPoint = SslConnection.this.getEndPoint();
            try {
                boolean flush = false;
                synchronized (SslConnection.this._decryptedEndPoint) {
                    ishut = endPoint.isInputShutdown();
                    boolean oshut = endPoint.isOutputShutdown();
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug("shutdownOutput: {} oshut={}, ishut={}", SslConnection.this, Boolean.valueOf(oshut), Boolean.valueOf(ishut));
                    }
                    closeOutbound();
                    if (!SslConnection.this._closedOutbound) {
                        SslConnection.this._closedOutbound = true;
                        flush = !oshut;
                    }
                }
                if (flush && !flush(BufferUtil.EMPTY_BUFFER) && !ishut) {
                    ByteBuffer write = null;
                    synchronized (SslConnection.this._decryptedEndPoint) {
                        if (BufferUtil.hasContent(SslConnection.this._encryptedOutput)) {
                            write = SslConnection.this._encryptedOutput;
                            SslConnection.this._flushState = FlushState.WRITING;
                        }
                    }
                    if (write != null) {
                        endPoint.write(Callback.from(() -> {
                            synchronized (SslConnection.this._decryptedEndPoint) {
                                SslConnection.this._flushState = FlushState.IDLE;
                                SslConnection.this.releaseEncryptedOutputBuffer();
                            }
                        }, t -> {
                            endPoint.close();
                        }), write);
                    }
                }
                if (ishut) {
                    endPoint.close();
                } else {
                    ensureFillInterested();
                }
            } catch (Throwable x) {
                SslConnection.LOG.ignore(x);
                endPoint.close();
            }
        }

        private void closeOutbound() {
            try {
                SslConnection.this._sslEngine.closeOutbound();
            } catch (Throwable x) {
                if (SslConnection.LOG.isDebugEnabled()) {
                    SslConnection.LOG.debug(x);
                }
            }
        }

        /* access modifiers changed from: private */
        public void ensureFillInterested() {
            if (SslConnection.LOG.isDebugEnabled()) {
                SslConnection.LOG.debug("ensureFillInterested {}", SslConnection.this);
            }
            SslConnection.this.tryFillInterested(SslConnection.this._sslReadCallback);
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.EndPoint
        public boolean isOutputShutdown() {
            return isOutboundDone() || SslConnection.this.getEndPoint().isOutputShutdown();
        }

        private boolean isOutboundDone() {
            try {
                return SslConnection.this._sslEngine.isOutboundDone();
            } catch (Throwable x) {
                SslConnection.LOG.ignore(x);
                return true;
            }
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint
        public void doClose() {
            doShutdownOutput();
            SslConnection.this.getEndPoint().close();
            doClose();
        }

        @Override // org.eclipse.jetty.p023io.EndPoint
        public Object getTransport() {
            return SslConnection.this.getEndPoint();
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.EndPoint
        public boolean isInputShutdown() {
            return BufferUtil.isEmpty(SslConnection.this._decryptedInput) && (SslConnection.this.getEndPoint().isInputShutdown() || isInboundDone());
        }

        private boolean isInboundDone() {
            try {
                return SslConnection.this._sslEngine.isInboundDone();
            } catch (Throwable x) {
                SslConnection.LOG.ignore(x);
                return true;
            }
        }

        private void notifyHandshakeSucceeded(SSLEngine sslEngine) throws SSLException {
            SslHandshakeListener.Event event = null;
            for (SslHandshakeListener listener : SslConnection.this.handshakeListeners) {
                if (event == null) {
                    event = new SslHandshakeListener.Event(sslEngine);
                }
                try {
                    listener.handshakeSucceeded(event);
                } catch (SSLException x) {
                    throw x;
                } catch (Throwable x2) {
                    SslConnection.LOG.info("Exception while notifying listener " + listener, x2);
                }
            }
        }

        private void notifyHandshakeFailed(SSLEngine sslEngine, Throwable failure) {
            SslHandshakeListener.Event event = null;
            for (SslHandshakeListener listener : SslConnection.this.handshakeListeners) {
                if (event == null) {
                    event = new SslHandshakeListener.Event(sslEngine);
                }
                try {
                    listener.handshakeFailed(event, failure);
                } catch (Throwable x) {
                    SslConnection.LOG.info("Exception while notifying listener " + listener, x);
                }
            }
        }

        private boolean isRenegotiating() {
            return SslConnection.this.isHandshakeComplete() && !isTLS13() && SslConnection.this._sslEngine.getHandshakeStatus() != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }

        private boolean allowRenegotiate() {
            if (!SslConnection.this.isRenegotiationAllowed()) {
                if (SslConnection.LOG.isDebugEnabled()) {
                    SslConnection.LOG.debug("Renegotiation denied {}", SslConnection.this);
                }
                terminateInput();
                return false;
            } else if (SslConnection.this.getRenegotiationLimit() != 0) {
                return true;
            } else {
                if (SslConnection.LOG.isDebugEnabled()) {
                    SslConnection.LOG.debug("Renegotiation limit exceeded {}", SslConnection.this);
                }
                terminateInput();
                return false;
            }
        }

        private boolean isTLS13() {
            return "TLSv1.3".equals(SslConnection.this._sslEngine.getSession().getProtocol());
        }

        private Throwable handleException(Throwable x, String context) {
            Throwable th;
            synchronized (SslConnection.this._decryptedEndPoint) {
                if (this._failure == null) {
                    this._failure = x;
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug(this + " stored " + context + " exception", x);
                    }
                } else if (x != this._failure) {
                    this._failure.addSuppressed(x);
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug(this + " suppressed " + context + " exception", x);
                    }
                }
                th = this._failure;
            }
            return th;
        }

        private void rethrow(Throwable x) throws IOException {
            if (x instanceof RuntimeException) {
                throw ((RuntimeException) x);
            } else if (x instanceof Error) {
                throw ((Error) x);
            } else if (x instanceof IOException) {
                throw ((IOException) x);
            } else {
                throw new IOException(x);
            }
        }

        @Override // org.eclipse.jetty.p023io.AbstractEndPoint, java.lang.Object
        public String toString() {
            return toEndPointString();
        }

        /* renamed from: org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint$IncompleteWriteCallback */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$DecryptedEndPoint$IncompleteWriteCallback.class */
        private final class IncompleteWriteCallback implements Callback, Invocable {
            private IncompleteWriteCallback() {
            }

            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                boolean interested;
                boolean fillable;
                synchronized (SslConnection.this._decryptedEndPoint) {
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug("IncompleteWriteCB succeeded {}", SslConnection.this);
                    }
                    SslConnection.this.releaseEncryptedOutputBuffer();
                    SslConnection.this._flushState = FlushState.IDLE;
                    interested = SslConnection.this._fillState == FillState.INTERESTED;
                    fillable = SslConnection.this._fillState == FillState.WAIT_FOR_FLUSH;
                    if (fillable) {
                        SslConnection.this._fillState = FillState.IDLE;
                    }
                }
                if (interested) {
                    DecryptedEndPoint.this.ensureFillInterested();
                } else if (fillable) {
                    SslConnection.this._decryptedEndPoint.getFillInterest().fillable();
                }
                SslConnection.this._decryptedEndPoint.getWriteFlusher().completeWrite();
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable x) {
                boolean failFillInterest;
                synchronized (SslConnection.this._decryptedEndPoint) {
                    if (SslConnection.LOG.isDebugEnabled()) {
                        SslConnection.LOG.debug("IncompleteWriteCB failed {}", SslConnection.this, x);
                    }
                    BufferUtil.clear(SslConnection.this._encryptedOutput);
                    SslConnection.this.releaseEncryptedOutputBuffer();
                    SslConnection.this._flushState = FlushState.IDLE;
                    failFillInterest = SslConnection.this._fillState == FillState.WAIT_FOR_FLUSH || SslConnection.this._fillState == FillState.INTERESTED;
                    if (failFillInterest) {
                        SslConnection.this._fillState = FillState.IDLE;
                    }
                }
                SslConnection.this.getExecutor().execute(()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00af: INVOKE  
                      (wrap: java.util.concurrent.Executor : 0x00a4: INVOKE  (r0v29 java.util.concurrent.Executor A[REMOVE]) = 
                      (wrap: org.eclipse.jetty.io.ssl.SslConnection : 0x00a1: IGET  (r0v28 org.eclipse.jetty.io.ssl.SslConnection A[REMOVE]) = 
                      (wrap: org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint : 0x009e: IGET  (r0v27 org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint A[REMOVE]) = 
                      (r7v0 'this' org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint$IncompleteWriteCallback A[D('this' org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint$IncompleteWriteCallback), IMMUTABLE_TYPE, THIS])
                     org.eclipse.jetty.io.ssl.SslConnection.DecryptedEndPoint.IncompleteWriteCallback.this$1 org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint)
                     org.eclipse.jetty.io.ssl.SslConnection.DecryptedEndPoint.this$0 org.eclipse.jetty.io.ssl.SslConnection)
                     type: VIRTUAL call: org.eclipse.jetty.io.ssl.SslConnection.getExecutor():java.util.concurrent.Executor)
                      (wrap: java.lang.Runnable : 0x00aa: INVOKE_CUSTOM (r1v4 java.lang.Runnable A[REMOVE]) = 
                      (r7v0 'this' org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint$IncompleteWriteCallback A[D('this' org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint$IncompleteWriteCallback), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r0v23 'failFillInterest' boolean A[D('failFillInterest' boolean), DONT_INLINE])
                      (r8v0 'x' java.lang.Throwable A[D('x' java.lang.Throwable), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.lang.Runnable.run():void
                     call insn: ?: INVOKE  
                      (r1 I:org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint$IncompleteWriteCallback)
                      (r2 I:boolean)
                      (r3 I:java.lang.Throwable)
                     type: DIRECT call: org.eclipse.jetty.io.ssl.SslConnection.DecryptedEndPoint.IncompleteWriteCallback.lambda$failed$0(boolean, java.lang.Throwable):void)
                     type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: org.eclipse.jetty.io.ssl.SslConnection.DecryptedEndPoint.IncompleteWriteCallback.failed(java.lang.Throwable):void, file: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$DecryptedEndPoint$IncompleteWriteCallback.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                    	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 15 more
                    */
                /*
                    this = this;
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$000(r0)
                    r1 = r0
                    r10 = r1
                    monitor-enter(r0)
                    org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$200()     // Catch: all -> 0x0096
                    boolean r0 = r0.isDebugEnabled()     // Catch: all -> 0x0096
                    if (r0 == 0) goto L_0x0034
                    org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$200()     // Catch: all -> 0x0096
                    java.lang.String r1 = "IncompleteWriteCB failed {}"
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: all -> 0x0096
                    r3 = r2
                    r4 = 0
                    r5 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r5 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection r5 = org.eclipse.jetty.p023io.ssl.SslConnection.this     // Catch: all -> 0x0096
                    r3[r4] = r5     // Catch: all -> 0x0096
                    r3 = r2
                    r4 = 1
                    r5 = r8
                    r3[r4] = r5     // Catch: all -> 0x0096
                    r0.debug(r1, r2)     // Catch: all -> 0x0096
                L_0x0034:
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this     // Catch: all -> 0x0096
                    java.nio.ByteBuffer r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$2000(r0)     // Catch: all -> 0x0096
                    org.eclipse.jetty.util.BufferUtil.clear(r0)     // Catch: all -> 0x0096
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.p023io.ssl.SslConnection.access$2800(r0)     // Catch: all -> 0x0096
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FlushState r1 = org.eclipse.jetty.p023io.ssl.SslConnection.FlushState.IDLE     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FlushState r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$402(r0, r1)     // Catch: all -> 0x0096
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FillState r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$300(r0)     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FillState r1 = org.eclipse.jetty.p023io.ssl.SslConnection.FillState.WAIT_FOR_FLUSH     // Catch: all -> 0x0096
                    if (r0 == r1) goto L_0x0079
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FillState r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$300(r0)     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FillState r1 = org.eclipse.jetty.p023io.ssl.SslConnection.FillState.INTERESTED     // Catch: all -> 0x0096
                    if (r0 != r1) goto L_0x007d
                L_0x0079:
                    r0 = 1
                    goto L_0x007e
                L_0x007d:
                    r0 = 0
                L_0x007e:
                    r9 = r0
                    r0 = r9
                    if (r0 == 0) goto L_0x0091
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FillState r1 = org.eclipse.jetty.p023io.ssl.SslConnection.FillState.IDLE     // Catch: all -> 0x0096
                    org.eclipse.jetty.io.ssl.SslConnection$FillState r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$302(r0, r1)     // Catch: all -> 0x0096
                L_0x0091:
                    r0 = r10
                    monitor-exit(r0)     // Catch: all -> 0x0096
                    goto L_0x009d
                L_0x0096:
                    r11 = move-exception
                    r0 = r10
                    monitor-exit(r0)     // Catch: all -> 0x0096
                    r0 = r11
                    throw r0
                L_0x009d:
                    r0 = r7
                    org.eclipse.jetty.io.ssl.SslConnection$DecryptedEndPoint r0 = org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.this
                    org.eclipse.jetty.io.ssl.SslConnection r0 = org.eclipse.jetty.p023io.ssl.SslConnection.this
                    java.util.concurrent.Executor r0 = org.eclipse.jetty.p023io.ssl.SslConnection.access$3300(r0)
                    r1 = r7
                    r2 = r9
                    r3 = r8
                    void r1 = () -> { // java.lang.Runnable.run():void
                        r1.lambda$failed$0(r2, r3);
                    }
                    r0.execute(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.ssl.SslConnection.DecryptedEndPoint.IncompleteWriteCallback.failed(java.lang.Throwable):void");
            }

            @Override // org.eclipse.jetty.util.thread.Invocable
            public Invocable.InvocationType getInvocationType() {
                return SslConnection.this._decryptedEndPoint.getWriteFlusher().getCallbackInvocationType();
            }

            public String toString() {
                return String.format("SSL@%h.DEP.writeCallback", SslConnection.this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.eclipse.jetty.io.ssl.SslConnection$3 */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ssl/SslConnection$3.class */
    public static /* synthetic */ class C56483 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus;
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$Status = new int[SSLEngineResult.Status.values().length];

        static {
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_UNDERFLOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.BUFFER_OVERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$Status[SSLEngineResult.Status.OK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = new int[SSLEngineResult.HandshakeStatus.values().length];
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
        }
    }
}
