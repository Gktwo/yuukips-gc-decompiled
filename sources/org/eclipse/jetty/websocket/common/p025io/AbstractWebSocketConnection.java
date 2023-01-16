package org.eclipse.jetty.websocket.common.p025io;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import org.eclipse.jetty.p023io.AbstractConnection;
import org.eclipse.jetty.p023io.AbstractEndPoint;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.CloseException;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.SuspendToken;
import org.eclipse.jetty.websocket.api.WebSocketBehavior;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.common.CloseInfo;
import org.eclipse.jetty.websocket.common.Generator;
import org.eclipse.jetty.websocket.common.LogicalConnection;
import org.eclipse.jetty.websocket.common.Parser;
import org.eclipse.jetty.websocket.common.WebSocketSession;
import org.eclipse.jetty.websocket.common.p025io.ReadState;

/* renamed from: org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/AbstractWebSocketConnection.class */
public abstract class AbstractWebSocketConnection extends AbstractConnection implements LogicalConnection, Connection.UpgradeTo, Dumpable {
    private static final Logger LOG = Log.getLogger(AbstractWebSocketConnection.class);
    private static final AtomicLong ID_GEN = new AtomicLong(0);
    private static final int MIN_BUFFER_SIZE = 28;
    private final ByteBufferPool bufferPool;
    private final Scheduler scheduler;
    private final Generator generator;
    private final Parser parser;
    private final WebSocketPolicy policy;
    private final FrameFlusher flusher;
    private WebSocketSession session;
    private ByteBuffer initialBuffer;
    private CloseInfo fatalCloseInfo;
    private final ReadState readState = new ReadState();
    private final ConnectionState connectionState = new ConnectionState();
    private final LongAdder bytesIn = new LongAdder();
    private List<ExtensionConfig> extensions = new ArrayList();
    private Stats stats = new Stats();

    /* renamed from: id */
    private final String f3182id = Long.toString(ID_GEN.incrementAndGet());

    /* access modifiers changed from: private */
    /* renamed from: org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection$CallbackBridge */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/AbstractWebSocketConnection$CallbackBridge.class */
    public static class CallbackBridge implements WriteCallback {
        private final Callback callback;

        public CallbackBridge(Callback callback) {
            this.callback = callback != null ? callback : Callback.NOOP;
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeFailed(Throwable x) {
            this.callback.failed(x);
        }

        @Override // org.eclipse.jetty.websocket.api.WriteCallback
        public void writeSuccess() {
            this.callback.succeeded();
        }
    }

    /* renamed from: org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection$Flusher */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/AbstractWebSocketConnection$Flusher.class */
    private class Flusher extends FrameFlusher {
        private Flusher(ByteBufferPool bufferPool, Generator generator, EndPoint endpoint) {
            super(bufferPool, generator, endpoint, AbstractWebSocketConnection.this.getPolicy().getMaxBinaryMessageBufferSize(), 8);
        }

        @Override // org.eclipse.jetty.websocket.common.p025io.FrameFlusher, org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable failure) {
            AbstractWebSocketConnection.this.close(failure);
            onCompleteFailure(failure);
        }
    }

    @Deprecated
    /* renamed from: org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection$Stats */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/AbstractWebSocketConnection$Stats.class */
    public static class Stats {
        private AtomicLong countFillInterestedEvents = new AtomicLong(0);
        private AtomicLong countOnFillableEvents = new AtomicLong(0);
        private AtomicLong countFillableErrors = new AtomicLong(0);

        public long getFillableErrorCount() {
            return this.countFillableErrors.get();
        }

        public long getFillInterestedCount() {
            return this.countFillInterestedEvents.get();
        }

        public long getOnFillableCount() {
            return this.countOnFillableEvents.get();
        }
    }

    public AbstractWebSocketConnection(EndPoint endp, Executor executor, Scheduler scheduler, WebSocketPolicy policy, ByteBufferPool bufferPool) {
        super(endp, executor);
        this.policy = policy;
        this.bufferPool = bufferPool;
        this.generator = new Generator(policy, bufferPool);
        this.parser = new Parser(policy, bufferPool);
        this.scheduler = scheduler;
        this.flusher = new Flusher(bufferPool, this.generator, endp);
        setInputBufferSize(policy.getInputBufferSize());
        setMaxIdleTimeout(policy.getIdleTimeout());
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.websocket.common.LogicalConnection
    public Executor getExecutor() {
        return getExecutor();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public void close(CloseInfo close, Callback callback) {
        if (this.connectionState.closing()) {
            if (close.getStatusCode() == 1005 || StatusCode.isTransmittable(close.getStatusCode())) {
                outgoingFrame(close.asFrame(), new CallbackBridge(callback), BatchMode.OFF);
                if (StatusCode.isFatal(close.getStatusCode())) {
                    this.fatalCloseInfo = close;
                    return;
                }
                return;
            }
            disconnect();
        } else if (callback != null) {
            callback.failed(new IllegalStateException("Local Close already called"));
        }
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public void close(Throwable cause) {
        this.session.callApplicationOnError(cause);
        int statusCode = this.policy.getBehavior() == WebSocketBehavior.SERVER ? StatusCode.SERVER_ERROR : 1006;
        if (cause instanceof CloseException) {
            statusCode = ((CloseException) cause).getStatusCode();
        }
        String reason = cause.getMessage();
        if (StringUtil.isBlank(reason)) {
            reason = cause.getClass().getSimpleName();
        }
        CloseInfo closeInfo = new CloseInfo(statusCode, reason);
        this.session.callApplicationOnClose(closeInfo);
        close(closeInfo, new DisconnectCallback(this));
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public boolean canWriteWebSocketFrames() {
        return this.connectionState.canWriteWebSocketFrames();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public boolean canReadWebSocketFrames() {
        return this.connectionState.canReadWebSocketFrames();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public String toStateString() {
        return this.connectionState.toString();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public boolean opening() {
        return this.connectionState.opening();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public boolean opened() {
        if (!this.connectionState.opened()) {
            return false;
        }
        if (BufferUtil.hasContent(this.initialBuffer)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Parsing upgrade initial buffer ({} remaining)", (long) this.initialBuffer.remaining());
            }
            this.parser.parse(this.initialBuffer);
            this.initialBuffer = null;
        }
        fillInterested();
        return true;
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public void remoteClose(CloseInfo close) {
        this.session.callApplicationOnClose(close);
        close(close, new DisconnectCallback(this));
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
    public boolean onIdleExpired() {
        return onIdleExpired();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection, java.io.Closeable, java.lang.AutoCloseable, org.eclipse.jetty.client.api.Connection
    public void close() {
        close(new CloseInfo(), Callback.NOOP);
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public void disconnect() {
        if (this.connectionState.disconnected()) {
            if (this.connectionState.wasOpened()) {
                CloseInfo closeInfo = this.fatalCloseInfo;
                if (closeInfo == null) {
                    closeInfo = new CloseInfo(1006, "Disconnected");
                }
                this.session.callApplicationOnClose(closeInfo);
            } else {
                this.session.callApplicationOnError(new WebSocketException("Shutdown"));
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} disconnect()", this.policy.getBehavior());
            }
            this.flusher.terminate(new EOFException("Disconnected"));
            EndPoint endPoint = getEndPoint();
            endPoint.shutdownOutput();
            endPoint.close();
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void fillInterested() {
        this.stats.countFillInterestedEvents.incrementAndGet();
        fillInterested();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public ByteBufferPool getBufferPool() {
        return this.bufferPool;
    }

    public List<ExtensionConfig> getExtensions() {
        return this.extensions;
    }

    public Generator getGenerator() {
        return this.generator;
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public String getId() {
        return this.f3182id;
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public long getIdleTimeout() {
        return getEndPoint().getIdleTimeout();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public long getMaxIdleTimeout() {
        return getEndPoint().getIdleTimeout();
    }

    public Parser getParser() {
        return this.parser;
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public InetSocketAddress getLocalAddress() {
        return getEndPoint().getLocalAddress();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public InetSocketAddress getRemoteAddress() {
        return getEndPoint().getRemoteAddress();
    }

    public Scheduler getScheduler() {
        return this.scheduler;
    }

    @Deprecated
    public Stats getStats() {
        return this.stats;
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public boolean isOpen() {
        return getEndPoint().isOpen();
    }

    @Override // org.eclipse.jetty.websocket.common.LogicalConnection
    public boolean isReading() {
        return this.readState.isReading();
    }

    @Override // org.eclipse.jetty.p023io.AbstractConnection
    public void onFillable() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} onFillable()", this.policy.getBehavior());
        }
        this.stats.countOnFillableEvents.incrementAndGet();
        if (this.readState.getBuffer() != null) {
            throw new IllegalStateException();
        }
        onFillable(this.bufferPool.acquire(getInputBufferSize(), true));
    }

    private void onFillable(ByteBuffer buffer) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} onFillable(ByteBuffer): {}", this.policy.getBehavior(), buffer);
        }
        while (true) {
            ReadState.Action action = this.readState.getAction(buffer);
            if (LOG.isDebugEnabled()) {
                LOG.debug("ReadState Action: {}", action);
            }
            switch (action) {
                case PARSE:
                    try {
                        this.parser.parseSingleFrame(buffer);
                        break;
                    } catch (Throwable t) {
                        close(t);
                        this.readState.discard();
                        break;
                    }
                case FILL:
                    try {
                        int filled = getEndPoint().fill(buffer);
                        if (filled >= 0) {
                            if (filled != 0) {
                                this.bytesIn.add((long) filled);
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Filled {} bytes - {}", Integer.valueOf(filled), BufferUtil.toDetailString(buffer));
                                }
                                break;
                            } else {
                                this.bufferPool.release(buffer);
                                fillInterested();
                                return;
                            }
                        } else {
                            this.readState.eof();
                            break;
                        }
                    } catch (IOException e) {
                        close(e);
                        this.readState.eof();
                        break;
                    }
                case DISCARD:
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Discarded buffer - {}", BufferUtil.toDetailString(buffer));
                    }
                    BufferUtil.clear(buffer);
                    break;
                case SUSPEND:
                    return;
                case EOF:
                    this.bufferPool.release(buffer);
                    close(new CloseInfo(1001), new DisconnectCallback(this));
                    return;
                default:
                    throw new IllegalStateException(action.name());
            }
        }
    }

    @Override // org.eclipse.jetty.websocket.api.SuspendToken
    public void resume() {
        ByteBuffer resume = this.readState.resume();
        if (resume != null) {
            getExecutor().execute(()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: INVOKE  
                  (wrap: java.util.concurrent.Executor : 0x000d: INVOKE  (r0v5 java.util.concurrent.Executor A[REMOVE]) = 
                  (r4v0 'this' org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection A[D('this' org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection), IMMUTABLE_TYPE, THIS])
                 type: VIRTUAL call: org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection.getExecutor():java.util.concurrent.Executor)
                  (wrap: java.lang.Runnable : 0x0012: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                  (r4v0 'this' org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection A[D('this' org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r0v2 'resume' java.nio.ByteBuffer A[D('resume' java.nio.ByteBuffer), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  (r1 I:org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection), (r2 I:java.nio.ByteBuffer) type: DIRECT call: org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection.lambda$resume$0(java.nio.ByteBuffer):void)
                 type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: org.eclipse.jetty.websocket.common.io.AbstractWebSocketConnection.resume():void, file: grasscutter.jar:org/eclipse/jetty/websocket/common/io/AbstractWebSocketConnection.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
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
                	... 23 more
                */
            /*
                this = this;
                r0 = r4
                org.eclipse.jetty.websocket.common.io.ReadState r0 = r0.readState
                java.nio.ByteBuffer r0 = r0.resume()
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L_0x001c
                r0 = r4
                java.util.concurrent.Executor r0 = r0.getExecutor()
                r1 = r4
                r2 = r5
                void r1 = () -> { // java.lang.Runnable.run():void
                    r1.lambda$resume$0(r2);
                }
                r0.execute(r1)
            L_0x001c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.p025io.AbstractWebSocketConnection.resume():void");
        }

        @Override // org.eclipse.jetty.websocket.common.LogicalConnection
        public SuspendToken suspend() {
            this.readState.suspending();
            return this;
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.p023io.AbstractConnection
        public void onFillInterestedFailed(Throwable cause) {
            LOG.ignore(cause);
            this.stats.countFillInterestedEvents.incrementAndGet();
            onFillInterestedFailed(cause);
        }

        protected void setInitialBuffer(ByteBuffer initialBuffer) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Set initial buffer - {}", BufferUtil.toDetailString(initialBuffer));
            }
            this.initialBuffer = initialBuffer;
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection
        protected boolean onReadTimeout(Throwable timeout) {
            close(new CloseException(1001, timeout));
            return false;
        }

        @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
        public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("outgoingFrame({}, {})", frame, callback);
            }
            if (this.flusher.enqueue(frame, callback, batchMode)) {
                this.flusher.iterate();
            }
        }

        public void setExtensions(List<ExtensionConfig> extensions) {
            this.extensions = extensions;
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection
        public void setInputBufferSize(int inputBufferSize) {
            if (inputBufferSize < 28) {
                throw new IllegalArgumentException("Cannot have buffer size less than 28");
            }
            setInputBufferSize(inputBufferSize);
        }

        @Override // org.eclipse.jetty.websocket.common.LogicalConnection
        public void setMaxIdleTimeout(long ms) {
            getEndPoint().setIdleTimeout(ms);
        }

        @Override // org.eclipse.jetty.util.component.Dumpable
        public String dumpSelf() {
            return String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode()));
        }

        @Override // org.eclipse.jetty.util.component.Dumpable
        public void dump(Appendable out, String indent) throws IOException {
            EndPoint endp = getEndPoint();
            Object endpRef = endp.toString();
            if (endp instanceof AbstractEndPoint) {
                endpRef = ((AbstractEndPoint) endp).toEndPointString();
            }
            Dumpable.dumpObjects(out, indent, this, endpRef, this.flusher, this.generator, this.parser);
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection
        public String toConnectionString() {
            return String.format("%s@%x[s=%s,f=%s,g=%s,p=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.connectionState, this.flusher, this.generator, this.parser);
        }

        @Override // org.eclipse.jetty.p023io.Connection.UpgradeTo
        public void onUpgradeTo(ByteBuffer buffer) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("onUpgradeTo({})", BufferUtil.toDetailString(buffer));
            }
            setInitialBuffer(buffer);
        }

        @Override // org.eclipse.jetty.websocket.common.LogicalConnection
        public void setNextIncomingFrames(IncomingFrames incoming) {
            getParser().setIncomingFramesHandler(incoming);
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
        public long getMessagesIn() {
            return this.parser.getMessagesIn();
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
        public long getMessagesOut() {
            return this.flusher.getMessagesOut();
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
        public long getBytesIn() {
            return this.bytesIn.longValue();
        }

        @Override // org.eclipse.jetty.p023io.AbstractConnection, org.eclipse.jetty.p023io.Connection
        public long getBytesOut() {
            return this.flusher.getBytesOut();
        }
    }
