package org.eclipse.jetty.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import org.eclipse.jetty.http.BadMessageException;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.http.HttpScheme;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.http.MetaData;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.ChannelEndPoint;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.QuietException;
import org.eclipse.jetty.server.HttpChannelState;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpInput;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.HostPort;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Scheduler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannel.class */
public class HttpChannel implements Runnable, HttpOutput.Interceptor {
    public static Listener NOOP_LISTENER = new Listener() { // from class: org.eclipse.jetty.server.HttpChannel.1
    };
    private static final Logger LOG = Log.getLogger(HttpChannel.class);
    private final Connector _connector;
    private final Executor _executor;
    private final HttpConfiguration _configuration;
    private final EndPoint _endPoint;
    private final HttpTransport _transport;
    private final Listener _combinedListener;
    private HttpFields _trailers;
    private MetaData.Response _committedMetaData;
    private RequestLog _requestLog;
    private long _oldIdleTimeout;
    private long _written;
    private final AtomicLong _requests = new AtomicLong();
    @Deprecated
    private final List<Listener> _transientListeners = new ArrayList();
    private final Supplier<HttpFields> _trailerSupplier = () -> {
        return this._trailers;
    };
    private final HttpChannelState _state = new HttpChannelState(this);
    private final Request _request = new Request(this, newHttpInput(this._state));
    private final Response _response = new Response(this, newHttpOutput());

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannel$Dispatchable.class */
    public interface Dispatchable {
        void dispatch() throws IOException, ServletException;
    }

    static /* synthetic */ long access$214(HttpChannel x0, long x1) {
        long j = x0._written + x1;
        x0._written = j;
        return j;
    }

    public HttpChannel(Connector connector, HttpConfiguration configuration, EndPoint endPoint, HttpTransport transport) {
        Listener listener;
        this._connector = connector;
        this._configuration = (HttpConfiguration) Objects.requireNonNull(configuration);
        this._endPoint = endPoint;
        this._transport = transport;
        this._executor = connector.getServer().getThreadPool();
        this._requestLog = connector.getServer().getRequestLog();
        if (connector instanceof AbstractConnector) {
            listener = ((AbstractConnector) connector).getHttpChannelListeners();
        } else {
            listener = NOOP_LISTENER;
        }
        this._combinedListener = listener;
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[4];
            objArr[0] = this;
            objArr[1] = this._endPoint;
            objArr[2] = this._endPoint == null ? null : this._endPoint.getConnection();
            objArr[3] = this._state;
            logger.debug("new {} -> {},{},{}", objArr);
        }
    }

    public boolean isSendError() {
        return this._state.isSendError();
    }

    /* access modifiers changed from: protected */
    public String formatAddrOrHost(String addr) {
        return HostPort.normalizeHost(addr);
    }

    protected HttpInput newHttpInput(HttpChannelState state) {
        return new HttpInput(state);
    }

    protected HttpOutput newHttpOutput() {
        return new HttpOutput(this);
    }

    public HttpChannelState getState() {
        return this._state;
    }

    @Deprecated
    public boolean addListener(Listener listener) {
        return this._transientListeners.add(listener);
    }

    @Deprecated
    public boolean removeListener(Listener listener) {
        return this._transientListeners.remove(listener);
    }

    @Deprecated
    public List<Listener> getTransientListeners() {
        return this._transientListeners;
    }

    public long getBytesWritten() {
        return this._written;
    }

    public long getRequests() {
        return this._requests.get();
    }

    public Connector getConnector() {
        return this._connector;
    }

    public HttpTransport getHttpTransport() {
        return this._transport;
    }

    public RequestLog getRequestLog() {
        return this._requestLog;
    }

    public void setRequestLog(RequestLog requestLog) {
        this._requestLog = requestLog;
    }

    public void addRequestLog(RequestLog requestLog) {
        if (this._requestLog == null) {
            this._requestLog = requestLog;
        } else if (this._requestLog instanceof RequestLogCollection) {
            ((RequestLogCollection) this._requestLog).add(requestLog);
        } else {
            this._requestLog = new RequestLogCollection(this._requestLog, requestLog);
        }
    }

    public MetaData.Response getCommittedMetaData() {
        return this._committedMetaData;
    }

    public long getIdleTimeout() {
        return this._endPoint.getIdleTimeout();
    }

    public void setIdleTimeout(long timeoutMs) {
        this._endPoint.setIdleTimeout(timeoutMs);
    }

    public ByteBufferPool getByteBufferPool() {
        return this._connector.getByteBufferPool();
    }

    public HttpConfiguration getHttpConfiguration() {
        return this._configuration;
    }

    @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
    public boolean isOptimizedForDirectBuffers() {
        return getHttpTransport().isOptimizedForDirectBuffers();
    }

    public Server getServer() {
        return this._connector.getServer();
    }

    public Request getRequest() {
        return this._request;
    }

    public Response getResponse() {
        return this._response;
    }

    public Connection getConnection() {
        return this._endPoint.getConnection();
    }

    public EndPoint getEndPoint() {
        return this._endPoint;
    }

    public String getLocalName() {
        HttpConfiguration httpConfiguration = getHttpConfiguration();
        if (httpConfiguration != null) {
            SocketAddress localAddress = httpConfiguration.getLocalAddress();
            if (localAddress instanceof InetSocketAddress) {
                return ((InetSocketAddress) localAddress).getHostName();
            }
        }
        InetSocketAddress local = getLocalAddress();
        if (local != null) {
            return local.getHostString();
        }
        return null;
    }

    public int getLocalPort() {
        HttpConfiguration httpConfiguration = getHttpConfiguration();
        if (httpConfiguration != null) {
            SocketAddress localAddress = httpConfiguration.getLocalAddress();
            if (localAddress instanceof InetSocketAddress) {
                return ((InetSocketAddress) localAddress).getPort();
            }
        }
        InetSocketAddress local = getLocalAddress();
        if (local == null) {
            return 0;
        }
        return local.getPort();
    }

    public InetSocketAddress getLocalAddress() {
        HttpConfiguration httpConfiguration = getHttpConfiguration();
        if (httpConfiguration != null) {
            SocketAddress localAddress = httpConfiguration.getLocalAddress();
            if (localAddress instanceof InetSocketAddress) {
                return (InetSocketAddress) localAddress;
            }
        }
        return this._endPoint.getLocalAddress();
    }

    public InetSocketAddress getRemoteAddress() {
        return this._endPoint.getRemoteAddress();
    }

    public HostPort getServerAuthority() {
        HttpConfiguration httpConfiguration = getHttpConfiguration();
        if (httpConfiguration != null) {
            return httpConfiguration.getServerAuthority();
        }
        return null;
    }

    public void continue100(int available) throws IOException {
        throw new UnsupportedOperationException();
    }

    public void recycle() {
        this._request.recycle();
        this._response.recycle();
        this._committedMetaData = null;
        this._requestLog = this._connector == null ? null : this._connector.getServer().getRequestLog();
        this._written = 0;
        this._trailers = null;
        this._oldIdleTimeout = 0;
        this._transientListeners.clear();
    }

    public void onAsyncWaitForContent() {
    }

    public void onBlockWaitForContent() {
    }

    public void onBlockWaitForContentFailure(Throwable failure) {
        getRequest().getHttpInput().failed(failure);
    }

    @Override // java.lang.Runnable
    public void run() {
        handle();
    }

    public boolean handle() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("handle {} {} ", this._request.getHttpURI(), this);
        }
        HttpChannelState.Action action = this._state.handling();
        while (true) {
            if (!getServer().isStopped()) {
                try {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("action {} {}", action, this);
                    }
                    switch (action) {
                        case TERMINATED:
                            onCompleted();
                            break;
                        case WAIT:
                            break;
                        case DISPATCH:
                            if (this._request.hasMetaData()) {
                                dispatch(DispatcherType.REQUEST, () -> {
                                    for (HttpConfiguration.Customizer customizer : this._configuration.getCustomizers()) {
                                        customizer.customize(getConnector(), this._configuration, this._request);
                                        if (this._request.isHandled()) {
                                            return;
                                        }
                                    }
                                    getServer().handle(this);
                                });
                                break;
                            } else {
                                throw new IllegalStateException("state=" + this._state);
                            }
                        case ASYNC_DISPATCH:
                            dispatch(DispatcherType.ASYNC, () -> {
                                getServer().handleAsync(this);
                            });
                            break;
                        case ASYNC_TIMEOUT:
                            this._state.onTimeout();
                            break;
                        case SEND_ERROR:
                            this._response.resetContent();
                            Integer code = (Integer) this._request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
                            if (code == null) {
                                code = 500;
                            }
                            this._response.setStatus(code.intValue());
                            ensureConsumeAllOrNotPersistent();
                            ContextHandler.Context context = (ContextHandler.Context) this._request.getAttribute(ErrorHandler.ERROR_CONTEXT);
                            ErrorHandler errorHandler = ErrorHandler.getErrorHandler(getServer(), context == null ? null : context.getContextHandler());
                            if (!HttpStatus.hasNoBody(this._response.getStatus()) && errorHandler != null && errorHandler.errorPageForMethod(this._request.getMethod())) {
                                dispatch(DispatcherType.ERROR, ()
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0189: INVOKE  
                                      (r7v0 'this' org.eclipse.jetty.server.HttpChannel A[D('this' org.eclipse.jetty.server.HttpChannel), IMMUTABLE_TYPE, THIS])
                                      (wrap: javax.servlet.DispatcherType : 0x017e: SGET  (r1v33 javax.servlet.DispatcherType A[REMOVE]) =  javax.servlet.DispatcherType.ERROR javax.servlet.DispatcherType)
                                      (wrap: org.eclipse.jetty.server.HttpChannel$Dispatchable : 0x0184: INVOKE_CUSTOM (r2v13 org.eclipse.jetty.server.HttpChannel$Dispatchable A[REMOVE]) = 
                                      (r7v0 'this' org.eclipse.jetty.server.HttpChannel A[D('this' org.eclipse.jetty.server.HttpChannel), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                                      (r0v94 'errorHandler' org.eclipse.jetty.server.handler.ErrorHandler A[D('errorHandler' org.eclipse.jetty.server.handler.ErrorHandler), DONT_INLINE])
                                    
                                     handle type: INVOKE_DIRECT
                                     lambda: org.eclipse.jetty.server.HttpChannel.Dispatchable.dispatch():void
                                     call insn: ?: INVOKE  (r2 I:org.eclipse.jetty.server.HttpChannel), (r3 I:org.eclipse.jetty.server.handler.ErrorHandler) type: DIRECT call: org.eclipse.jetty.server.HttpChannel.lambda$handle$3(org.eclipse.jetty.server.handler.ErrorHandler):void)
                                     type: DIRECT call: org.eclipse.jetty.server.HttpChannel.dispatch(javax.servlet.DispatcherType, org.eclipse.jetty.server.HttpChannel$Dispatchable):void in method: org.eclipse.jetty.server.HttpChannel.handle():boolean, file: grasscutter.jar:org/eclipse/jetty/server/HttpChannel.class
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
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:281)
                                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:79)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:189)
                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
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
                                    	... 45 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 920
                                */
                                throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.HttpChannel.handle():boolean");
                            }

                            public void ensureConsumeAllOrNotPersistent() {
                                switch (this._request.getHttpVersion()) {
                                    case HTTP_1_0:
                                        if (!this._request.getHttpInput().consumeAll()) {
                                            this._response.getHttpFields().computeField(HttpHeader.CONNECTION, h, fields -> {
                                                if (fields == null || fields.isEmpty()) {
                                                    return null;
                                                }
                                                String v = (String) fields.stream().flatMap(field -> {
                                                    return Stream.of((Object[]) field.getValues()).filter(s -> {
                                                        return !HttpHeaderValue.KEEP_ALIVE.m41is(s);
                                                    });
                                                }).collect(Collectors.joining(", "));
                                                if (StringUtil.isEmpty(v)) {
                                                    return null;
                                                }
                                                return new HttpField(HttpHeader.CONNECTION, v);
                                            });
                                            return;
                                        }
                                        return;
                                    case HTTP_1_1:
                                        if (!this._request.getHttpInput().consumeAll()) {
                                            this._response.getHttpFields().computeField(HttpHeader.CONNECTION, h, fields -> {
                                                if (fields == null || fields.isEmpty()) {
                                                    return HttpConnection.CONNECTION_CLOSE;
                                                }
                                                if (!fields.stream().anyMatch(f -> {
                                                    return f.contains(HttpHeaderValue.CLOSE.asString());
                                                })) {
                                                    return new HttpField(HttpHeader.CONNECTION, (String) Stream.concat(fields.stream().flatMap(field -> {
                                                        return Stream.of((Object[]) field.getValues()).filter(s -> {
                                                            return !HttpHeaderValue.KEEP_ALIVE.m41is(s);
                                                        });
                                                    }), Stream.of(HttpHeaderValue.CLOSE.asString())).collect(Collectors.joining(", ")));
                                                }
                                                if (fields.size() == 1) {
                                                    HttpField f = (HttpField) fields.get(0);
                                                    if (HttpConnection.CONNECTION_CLOSE.equals(f)) {
                                                        return f;
                                                    }
                                                }
                                                return new HttpField(HttpHeader.CONNECTION, (String) fields.stream().flatMap(field -> {
                                                    return Stream.of((Object[]) field.getValues()).filter(s -> {
                                                        return !HttpHeaderValue.KEEP_ALIVE.m41is(s);
                                                    });
                                                }).collect(Collectors.joining(", ")));
                                            });
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }

                            private void dispatch(DispatcherType type, Dispatchable dispatchable) throws IOException, ServletException {
                                try {
                                    this._request.setHandled(false);
                                    this._response.reopen();
                                    this._request.setDispatcherType(type);
                                    this._combinedListener.onBeforeDispatch(this._request);
                                    dispatchable.dispatch();
                                    this._combinedListener.onAfterDispatch(this._request);
                                    this._request.setDispatcherType(null);
                                } catch (Throwable th) {
                                    this._combinedListener.onAfterDispatch(this._request);
                                    this._request.setDispatcherType(null);
                                    throw th;
                                }
                            }

                            /* access modifiers changed from: protected */
                            public void handleException(Throwable failure) {
                                Throwable quiet = unwrap(failure, QuietException.class);
                                Throwable noStack = unwrap(failure, BadMessageException.class, IOException.class, TimeoutException.class);
                                if (quiet != null || !getServer().isRunning()) {
                                    if (LOG.isDebugEnabled()) {
                                        LOG.debug(this._request.getRequestURI(), failure);
                                    }
                                } else if (noStack == null) {
                                    LOG.warn(this._request.getRequestURI(), failure);
                                } else if (LOG.isDebugEnabled()) {
                                    LOG.warn("handleException " + this._request.getRequestURI(), failure);
                                } else {
                                    LOG.warn("handleException {} {}", this._request.getRequestURI(), noStack.toString());
                                }
                                if (isCommitted()) {
                                    abort(failure);
                                } else {
                                    this._state.onError(failure);
                                }
                            }

                            /* access modifiers changed from: protected */
                            public Throwable unwrap(Throwable failure, Class<?>... targets) {
                                while (failure != null) {
                                    for (Class<?> x : targets) {
                                        if (x.isInstance(failure)) {
                                            return failure;
                                        }
                                    }
                                    failure = failure.getCause();
                                }
                                return null;
                            }

                            public void sendResponseAndComplete() {
                                try {
                                    this._request.setHandled(true);
                                    this._state.completing();
                                    ByteBuffer buffer = this._response.getHttpOutput().getBuffer();
                                    Runnable r4 = () -> {
                                        this._state.completed(null);
                                    };
                                    HttpChannelState httpChannelState = this._state;
                                    Objects.requireNonNull(httpChannelState);
                                    sendResponse(null, buffer, true, Callback.from(r4, this::completed));
                                } catch (Throwable x) {
                                    abort(x);
                                }
                            }

                            public boolean isExpecting100Continue() {
                                return false;
                            }

                            public boolean isExpecting102Processing() {
                                return false;
                            }

                            @Override // java.lang.Object
                            public String toString() {
                                long timeStamp = this._request.getTimeStamp();
                                Object[] objArr = new Object[9];
                                objArr[0] = getClass().getSimpleName();
                                objArr[1] = Integer.valueOf(hashCode());
                                objArr[2] = this._state;
                                objArr[3] = this._requests;
                                objArr[4] = Boolean.valueOf(isRequestCompleted());
                                objArr[5] = Boolean.valueOf(isResponseCompleted());
                                objArr[6] = this._state.getState();
                                objArr[7] = this._request.getHttpURI();
                                objArr[8] = Long.valueOf(timeStamp == 0 ? 0 : System.currentTimeMillis() - timeStamp);
                                return String.format("%s@%x{s=%s,r=%s,c=%b/%b,a=%s,uri=%s,age=%d}", objArr);
                            }

                            public void onRequest(MetaData.Request request) {
                                this._requests.incrementAndGet();
                                this._request.setTimeStamp(System.currentTimeMillis());
                                HttpFields fields = this._response.getHttpFields();
                                if (this._configuration.getSendDateHeader() && !fields.contains(HttpHeader.DATE)) {
                                    fields.put(this._connector.getServer().getDateField());
                                }
                                long idleTO = this._configuration.getIdleTimeout();
                                this._oldIdleTimeout = getIdleTimeout();
                                if (idleTO >= 0 && this._oldIdleTimeout != idleTO) {
                                    setIdleTimeout(idleTO);
                                }
                                request.setTrailerSupplier(this._trailerSupplier);
                                this._request.setMetaData(request);
                                this._request.setSecure(HttpScheme.HTTPS.m39is(request.getURI().getScheme()));
                                this._combinedListener.onRequestBegin(this._request);
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("REQUEST for {} on {}{}{} {} {}{}{}", request.getURIString(), this, System.lineSeparator(), request.getMethod(), request.getURIString(), request.getHttpVersion(), System.lineSeparator(), request.getFields());
                                }
                            }

                            public boolean onContent(HttpInput.Content content) {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("onContent {} {}", this, content);
                                }
                                this._combinedListener.onRequestContent(this._request, content.getByteBuffer());
                                return this._request.getHttpInput().addContent(content);
                            }

                            public boolean onContentComplete() {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("onContentComplete {}", this);
                                }
                                this._combinedListener.onRequestContentEnd(this._request);
                                return false;
                            }

                            public void onTrailers(HttpFields trailers) {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("onTrailers {} {}", this, trailers);
                                }
                                this._trailers = trailers;
                                this._combinedListener.onRequestTrailers(this._request);
                            }

                            public boolean onRequestComplete() {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("onRequestComplete {}", this);
                                }
                                boolean result = this._request.getHttpInput().eof();
                                this._combinedListener.onRequestEnd(this._request);
                                return result;
                            }

                            public void onCompleted() {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("onCompleted for {} written={}", getRequest().getRequestURI(), Long.valueOf(getBytesWritten()));
                                }
                                if (this._requestLog != null) {
                                    this._requestLog.log(this._request, this._response);
                                }
                                if (this._configuration.getIdleTimeout() >= 0 && getIdleTimeout() != this._oldIdleTimeout) {
                                    setIdleTimeout(this._oldIdleTimeout);
                                }
                                this._request.onCompleted();
                                this._combinedListener.onComplete(this._request);
                                this._transport.onCompleted();
                            }

                            public boolean onEarlyEOF() {
                                return this._request.getHttpInput().earlyEOF();
                            }

                            public void onBadMessage(BadMessageException failure) {
                                int status = failure.getCode();
                                String reason = failure.getReason();
                                if (status < 400 || status > 599) {
                                    failure = new BadMessageException(400, reason, failure);
                                }
                                this._combinedListener.onRequestFailure(this._request, failure);
                                try {
                                    try {
                                        try {
                                            if (this._state.handling() == HttpChannelState.Action.DISPATCH) {
                                                ByteBuffer content = null;
                                                HttpFields fields = new HttpFields();
                                                ErrorHandler handler = (ErrorHandler) getServer().getBean((Class<Object>) ErrorHandler.class);
                                                if (handler != null) {
                                                    content = handler.badMessageError(status, reason, fields);
                                                }
                                                sendResponse(new MetaData.Response(HttpVersion.HTTP_1_1, status, reason, fields, (long) BufferUtil.length(content)), content, true);
                                            }
                                            try {
                                                onCompleted();
                                            } catch (Throwable e) {
                                                LOG.debug(e);
                                            }
                                        } catch (IOException e2) {
                                            LOG.debug(e2);
                                            try {
                                                onCompleted();
                                            } catch (Throwable e) {
                                                LOG.debug(e);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            onCompleted();
                                        } catch (Throwable e) {
                                            LOG.debug(e);
                                        }
                                        throw th;
                                    }
                                } finally {
                                    abort(e);
                                }
                            }

                            public boolean sendResponse(MetaData.Response info, ByteBuffer content, boolean complete, Callback callback) {
                                Callback committed;
                                boolean committing = this._state.commitResponse();
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("sendResponse info={} content={} complete={} committing={} callback={}", info, BufferUtil.toDetailString(content), Boolean.valueOf(complete), Boolean.valueOf(committing), callback);
                                }
                                if (committing) {
                                    if (info == null) {
                                        info = this._response.newResponseMetaData();
                                    }
                                    commit(info);
                                    this._combinedListener.onResponseBegin(this._request);
                                    this._request.onResponseCommit();
                                    int status = info.getStatus();
                                    if (status >= 200 || status < 100) {
                                        committed = new SendCallback(callback, content, true, complete);
                                    } else {
                                        committed = new Send100Callback(callback);
                                    }
                                    this._transport.send(info, this._request.isHead(), content, complete, committed);
                                } else if (info == null) {
                                    this._transport.send(null, this._request.isHead(), content, complete, new SendCallback(callback, content, false, complete));
                                } else {
                                    callback.failed(new IllegalStateException("committed"));
                                }
                                return committing;
                            }

                            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x002d
                                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                                */
                            public boolean sendResponse(org.eclipse.jetty.http.MetaData.Response r7, java.nio.ByteBuffer r8, boolean r9) throws java.io.IOException {
                                /*
                                    r6 = this;
                                    r0 = r6
                                    org.eclipse.jetty.server.Response r0 = r0._response     // Catch: Throwable -> 0x0048
                                    org.eclipse.jetty.server.HttpOutput r0 = r0.getHttpOutput()     // Catch: Throwable -> 0x0048
                                    org.eclipse.jetty.util.SharedBlockingCallback$Blocker r0 = r0.acquireWriteBlockingCallback()     // Catch: Throwable -> 0x0048
                                    r10 = r0
                                    r0 = r6
                                    r1 = r7
                                    r2 = r8
                                    r3 = r9
                                    r4 = r10
                                    boolean r0 = r0.sendResponse(r1, r2, r3, r4)     // Catch: Throwable -> 0x002d, Throwable -> 0x0048
                                    r11 = r0
                                    r0 = r10
                                    r0.block()     // Catch: Throwable -> 0x002d, Throwable -> 0x0048
                                    r0 = r11
                                    r12 = r0
                                    r0 = r10
                                    if (r0 == 0) goto L_0x002a
                                    r0 = r10
                                    r0.close()     // Catch: Throwable -> 0x0048
                                L_0x002a:
                                    r0 = r12
                                    return r0
                                L_0x002d:
                                    r11 = move-exception
                                    r0 = r10
                                    if (r0 == 0) goto L_0x0045
                                    r0 = r10
                                    r0.close()     // Catch: Throwable -> 0x0048, Throwable -> 0x003c
                                    goto L_0x0045
                                L_0x003c:
                                    r12 = move-exception
                                    r0 = r11
                                    r1 = r12
                                    r0.addSuppressed(r1)     // Catch: Throwable -> 0x0048
                                L_0x0045:
                                    r0 = r11
                                    throw r0     // Catch: Throwable -> 0x0048
                                L_0x0048:
                                    r10 = move-exception
                                    org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.HttpChannel.LOG
                                    boolean r0 = r0.isDebugEnabled()
                                    if (r0 == 0) goto L_0x005f
                                    org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.HttpChannel.LOG
                                    r1 = r10
                                    r0.debug(r1)
                                L_0x005f:
                                    r0 = r6
                                    r1 = r10
                                    r0.abort(r1)
                                    r0 = r10
                                    throw r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.HttpChannel.sendResponse(org.eclipse.jetty.http.MetaData$Response, java.nio.ByteBuffer, boolean):boolean");
                            }

                            protected void commit(MetaData.Response info) {
                                this._committedMetaData = info;
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("COMMIT for {} on {}{}{} {} {}{}{}", getRequest().getRequestURI(), this, System.lineSeparator(), Integer.valueOf(info.getStatus()), info.getReason(), info.getHttpVersion(), System.lineSeparator(), info.getFields());
                                }
                            }

                            public boolean isCommitted() {
                                return this._state.isResponseCommitted();
                            }

                            public boolean isRequestCompleted() {
                                return this._state.isCompleted();
                            }

                            public boolean isResponseCompleted() {
                                return this._state.isResponseCompleted();
                            }

                            public boolean isPersistent() {
                                return this._endPoint.isOpen();
                            }

                            @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
                            public void write(ByteBuffer content, boolean complete, Callback callback) {
                                sendResponse(null, content, complete, callback);
                            }

                            @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
                            public void resetBuffer() {
                                if (isCommitted()) {
                                    throw new IllegalStateException("Committed");
                                }
                            }

                            @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
                            public HttpOutput.Interceptor getNextInterceptor() {
                                return null;
                            }

                            /* access modifiers changed from: protected */
                            public void execute(Runnable task) {
                                this._executor.execute(task);
                            }

                            public Scheduler getScheduler() {
                                return this._connector.getScheduler();
                            }

                            public boolean useDirectBuffers() {
                                return getEndPoint() instanceof ChannelEndPoint;
                            }

                            public void abort(Throwable failure) {
                                if (this._state.abortResponse()) {
                                    this._combinedListener.onResponseFailure(this._request, failure);
                                    this._transport.abort(failure);
                                }
                            }

                            /* access modifiers changed from: private */
                            public void notifyEvent1(Function<Listener, Consumer<Request>> function, Request request) {
                                for (Listener listener : this._transientListeners) {
                                    try {
                                        function.apply(listener).accept(request);
                                    } catch (Throwable x) {
                                        LOG.debug("Failure invoking listener " + listener, x);
                                    }
                                }
                            }

                            /* access modifiers changed from: private */
                            public void notifyEvent2(Function<Listener, BiConsumer<Request, ByteBuffer>> function, Request request, ByteBuffer content) {
                                for (Listener listener : this._transientListeners) {
                                    try {
                                        function.apply(listener).accept(request, content.slice());
                                    } catch (Throwable x) {
                                        LOG.debug("Failure invoking listener " + listener, x);
                                    }
                                }
                            }

                            /* access modifiers changed from: private */
                            public void notifyEvent2(Function<Listener, BiConsumer<Request, Throwable>> function, Request request, Throwable failure) {
                                for (Listener listener : this._transientListeners) {
                                    try {
                                        function.apply(listener).accept(request, failure);
                                    } catch (Throwable x) {
                                        LOG.debug("Failure invoking listener " + listener, x);
                                    }
                                }
                            }

                            /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannel$Listener.class */
                            public interface Listener extends EventListener {
                                default void onRequestBegin(Request request) {
                                }

                                default void onBeforeDispatch(Request request) {
                                }

                                default void onDispatchFailure(Request request, Throwable failure) {
                                }

                                default void onAfterDispatch(Request request) {
                                }

                                default void onRequestContent(Request request, ByteBuffer content) {
                                }

                                default void onRequestContentEnd(Request request) {
                                }

                                default void onRequestTrailers(Request request) {
                                }

                                default void onRequestEnd(Request request) {
                                }

                                default void onRequestFailure(Request request, Throwable failure) {
                                }

                                default void onResponseBegin(Request request) {
                                }

                                default void onResponseCommit(Request request) {
                                }

                                default void onResponseContent(Request request, ByteBuffer content) {
                                }

                                default void onResponseEnd(Request request) {
                                }

                                default void onResponseFailure(Request request, Throwable failure) {
                                }

                                default void onComplete(Request request) {
                                }
                            }

                            /* access modifiers changed from: private */
                            /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannel$SendCallback.class */
                            public class SendCallback extends Callback.Nested {
                                private final ByteBuffer _content;
                                private final int _length;
                                private final boolean _commit;
                                private final boolean _complete;

                                private SendCallback(Callback callback, ByteBuffer content, boolean commit, boolean complete) {
                                    super(callback);
                                    this._content = content == null ? BufferUtil.EMPTY_BUFFER : content.slice();
                                    this._length = this._content.remaining();
                                    this._commit = commit;
                                    this._complete = complete;
                                }

                                @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
                                public void succeeded() {
                                    HttpChannel.access$214(HttpChannel.this, (long) this._length);
                                    if (this._commit) {
                                        HttpChannel.this._combinedListener.onResponseCommit(HttpChannel.this._request);
                                    }
                                    if (this._length > 0) {
                                        HttpChannel.this._combinedListener.onResponseContent(HttpChannel.this._request, this._content);
                                    }
                                    if (this._complete && HttpChannel.this._state.completeResponse()) {
                                        HttpChannel.this._combinedListener.onResponseEnd(HttpChannel.this._request);
                                    }
                                    succeeded();
                                }

                                @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
                                public void failed(final Throwable x) {
                                    if (HttpChannel.LOG.isDebugEnabled()) {
                                        HttpChannel.LOG.debug("Commit failed", x);
                                    }
                                    if (x instanceof BadMessageException) {
                                        HttpChannel.this._transport.send(HttpGenerator.RESPONSE_500_INFO, false, null, true, new Callback.Nested(this) { // from class: org.eclipse.jetty.server.HttpChannel.SendCallback.1
                                            @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
                                            public void succeeded() {
                                                HttpChannel.this._response.getHttpOutput().completed(null);
                                                failed(x);
                                            }

                                            @Override // org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
                                            public void failed(Throwable th) {
                                                HttpChannel.this.abort(x);
                                                failed(x);
                                            }
                                        });
                                        return;
                                    }
                                    HttpChannel.this.abort(x);
                                    failed(x);
                                }
                            }

                            /* access modifiers changed from: private */
                            /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannel$Send100Callback.class */
                            public class Send100Callback extends SendCallback {
                                private Send100Callback(Callback callback) {
                                    super(callback, null, false, false);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.SendCallback, org.eclipse.jetty.util.Callback.Nested, org.eclipse.jetty.util.Callback.Completing, org.eclipse.jetty.util.Callback
                                public void succeeded() {
                                    if (HttpChannel.this._state.partialResponse()) {
                                        succeeded();
                                    } else {
                                        failed(new IllegalStateException());
                                    }
                                }
                            }

                            @Deprecated
                            /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannel$TransientListeners.class */
                            public static class TransientListeners implements Listener {
                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onRequestBegin(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onRequestBegin;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onBeforeDispatch(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onBeforeDispatch;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onDispatchFailure(Request request, Throwable failure) {
                                    request.getHttpChannel().notifyEvent2(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onDispatchFailure;
                                    }, request, failure);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onAfterDispatch(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onAfterDispatch;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onRequestContent(Request request, ByteBuffer content) {
                                    request.getHttpChannel().notifyEvent2(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onRequestContent;
                                    }, request, content);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onRequestContentEnd(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onRequestContentEnd;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onRequestTrailers(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onRequestTrailers;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onRequestEnd(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onRequestEnd;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onRequestFailure(Request request, Throwable failure) {
                                    request.getHttpChannel().notifyEvent2(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onRequestFailure;
                                    }, request, failure);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onResponseBegin(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onResponseBegin;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onResponseCommit(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onResponseCommit;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onResponseContent(Request request, ByteBuffer content) {
                                    request.getHttpChannel().notifyEvent2(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onResponseContent;
                                    }, request, content);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onResponseEnd(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onResponseEnd;
                                    }, request);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onResponseFailure(Request request, Throwable failure) {
                                    request.getHttpChannel().notifyEvent2(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onResponseFailure;
                                    }, request, failure);
                                }

                                @Override // org.eclipse.jetty.server.HttpChannel.Listener
                                public void onComplete(Request request) {
                                    request.getHttpChannel().notifyEvent1(listener -> {
                                        Objects.requireNonNull(listener);
                                        return this::onComplete;
                                    }, request);
                                }
                            }
                        }
