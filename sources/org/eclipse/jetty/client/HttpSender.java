package org.eclipse.jetty.client;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.client.AsyncContentProvider;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpHeaderValue;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpSender.class */
public abstract class HttpSender implements AsyncContentProvider.Listener {
    protected static final Logger LOG = Log.getLogger(HttpSender.class);
    private final AtomicReference<RequestState> requestState = new AtomicReference<>(RequestState.QUEUED);
    private final AtomicReference<SenderState> senderState = new AtomicReference<>(SenderState.IDLE);
    private final Callback commitCallback = new CommitCallback();
    private final IteratingCallback contentCallback = new ContentCallback();
    private final Callback lastCallback = new LastCallback();
    private final HttpChannel channel;
    private HttpContent content;
    private Throwable failure;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpSender$RequestState.class */
    public enum RequestState {
        TRANSIENT,
        QUEUED,
        BEGIN,
        HEADERS,
        COMMIT,
        CONTENT,
        FAILURE
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpSender$SenderState.class */
    public enum SenderState {
        IDLE,
        SENDING,
        SENDING_WITH_CONTENT,
        EXPECTING,
        EXPECTING_WITH_CONTENT,
        WAITING,
        PROCEEDING,
        PROCEEDING_WITH_CONTENT,
        COMPLETED,
        FAILED
    }

    protected abstract void sendHeaders(HttpExchange httpExchange, HttpContent httpContent, Callback callback);

    protected abstract void sendContent(HttpExchange httpExchange, HttpContent httpContent, Callback callback);

    /* access modifiers changed from: protected */
    public HttpSender(HttpChannel channel) {
        this.channel = channel;
    }

    /* access modifiers changed from: protected */
    public HttpChannel getHttpChannel() {
        return this.channel;
    }

    protected HttpExchange getHttpExchange() {
        return this.channel.getHttpExchange();
    }

    public boolean isFailed() {
        return this.requestState.get() == RequestState.FAILURE;
    }

    @Override // org.eclipse.jetty.client.AsyncContentProvider.Listener
    public void onContent() {
        if (getHttpExchange() != null) {
            while (true) {
                SenderState current = this.senderState.get();
                switch (current) {
                    case IDLE:
                        SenderState newSenderState = SenderState.SENDING;
                        if (!updateSenderState(current, newSenderState)) {
                            break;
                        } else {
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Deferred content available, {} -> {}", current, newSenderState);
                            }
                            this.contentCallback.iterate();
                            return;
                        }
                    case SENDING:
                        SenderState newSenderState2 = SenderState.SENDING_WITH_CONTENT;
                        if (!updateSenderState(current, newSenderState2)) {
                            break;
                        } else if (LOG.isDebugEnabled()) {
                            LOG.debug("Deferred content available, {} -> {}", current, newSenderState2);
                            return;
                        } else {
                            return;
                        }
                    case EXPECTING:
                        SenderState newSenderState3 = SenderState.EXPECTING_WITH_CONTENT;
                        if (!updateSenderState(current, newSenderState3)) {
                            break;
                        } else if (LOG.isDebugEnabled()) {
                            LOG.debug("Deferred content available, {} -> {}", current, newSenderState3);
                            return;
                        } else {
                            return;
                        }
                    case PROCEEDING:
                        SenderState newSenderState4 = SenderState.PROCEEDING_WITH_CONTENT;
                        if (!updateSenderState(current, newSenderState4)) {
                            break;
                        } else if (LOG.isDebugEnabled()) {
                            LOG.debug("Deferred content available, {} -> {}", current, newSenderState4);
                            return;
                        } else {
                            return;
                        }
                    case SENDING_WITH_CONTENT:
                    case EXPECTING_WITH_CONTENT:
                    case PROCEEDING_WITH_CONTENT:
                    case WAITING:
                    case COMPLETED:
                    case FAILED:
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Deferred content available, {}", current);
                            return;
                        }
                        return;
                    default:
                        illegalSenderState(current);
                        return;
                }
            }
        }
    }

    public void send(HttpExchange exchange) {
        SenderState current;
        if (queuedToBegin(exchange)) {
            Request request = exchange.getRequest();
            ContentProvider contentProvider = request.getContent();
            HttpContent content = new HttpContent(contentProvider);
            this.content = content;
            SenderState newSenderState = SenderState.SENDING;
            if (expects100Continue(request)) {
                newSenderState = content.hasContent() ? SenderState.EXPECTING_WITH_CONTENT : SenderState.EXPECTING;
            }
            do {
                current = this.senderState.get();
                switch (current) {
                    case IDLE:
                    case COMPLETED:
                        break;
                    default:
                        illegalSenderState(current);
                        return;
                }
            } while (!updateSenderState(current, newSenderState));
            if (contentProvider instanceof AsyncContentProvider) {
                ((AsyncContentProvider) contentProvider).setListener(this);
            }
            if (beginToHeaders(exchange)) {
                sendHeaders(exchange, content, this.commitCallback);
            }
        }
    }

    protected boolean expects100Continue(Request request) {
        return request.getHeaders().contains(HttpHeader.EXPECT, HttpHeaderValue.CONTINUE.asString());
    }

    protected boolean queuedToBegin(HttpExchange exchange) {
        if (!updateRequestState(RequestState.QUEUED, RequestState.TRANSIENT)) {
            return false;
        }
        Request request = exchange.getRequest();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request begin {}", request);
        }
        getHttpChannel().getHttpDestination().getRequestNotifier().notifyBegin(request);
        if (updateRequestState(RequestState.TRANSIENT, RequestState.BEGIN)) {
            return true;
        }
        terminateRequest(exchange);
        return false;
    }

    protected boolean beginToHeaders(HttpExchange exchange) {
        if (!updateRequestState(RequestState.BEGIN, RequestState.TRANSIENT)) {
            return false;
        }
        Request request = exchange.getRequest();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request headers {}{}{}", request, System.lineSeparator(), request.getHeaders().toString().trim());
        }
        getHttpChannel().getHttpDestination().getRequestNotifier().notifyHeaders(request);
        if (updateRequestState(RequestState.TRANSIENT, RequestState.HEADERS)) {
            return true;
        }
        terminateRequest(exchange);
        return false;
    }

    protected boolean headersToCommit(HttpExchange exchange) {
        if (!updateRequestState(RequestState.HEADERS, RequestState.TRANSIENT)) {
            return false;
        }
        Request request = exchange.getRequest();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request committed {}", request);
        }
        getHttpChannel().getHttpDestination().getRequestNotifier().notifyCommit(request);
        if (updateRequestState(RequestState.TRANSIENT, RequestState.COMMIT)) {
            return true;
        }
        terminateRequest(exchange);
        return false;
    }

    protected boolean someToContent(HttpExchange exchange, ByteBuffer content) {
        RequestState current = this.requestState.get();
        switch (current) {
            case COMMIT:
            case CONTENT:
                if (!updateRequestState(current, RequestState.TRANSIENT)) {
                    return false;
                }
                Request request = exchange.getRequest();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Request content {}{}{}", request, System.lineSeparator(), BufferUtil.toDetailString(content));
                }
                getHttpChannel().getHttpDestination().getRequestNotifier().notifyContent(request, content);
                if (updateRequestState(RequestState.TRANSIENT, RequestState.CONTENT)) {
                    return true;
                }
                terminateRequest(exchange);
                return false;
            default:
                return false;
        }
    }

    protected boolean someToSuccess(HttpExchange exchange) {
        switch (this.requestState.get()) {
            case COMMIT:
            case CONTENT:
                if (!exchange.requestComplete(null)) {
                    return false;
                }
                this.requestState.set(RequestState.QUEUED);
                reset();
                Request request = exchange.getRequest();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Request success {}", request);
                }
                getHttpChannel().getHttpDestination().getRequestNotifier().notifySuccess(exchange.getRequest());
                terminateRequest(exchange, null, exchange.terminateRequest());
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public void anyToFailure(Throwable failure) {
        HttpExchange exchange = getHttpExchange();
        if (exchange != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Request failure " + exchange.getRequest(), failure);
            }
            if (exchange.requestComplete(failure)) {
                executeAbort(exchange, failure);
            }
        }
    }

    private void executeAbort(HttpExchange exchange, Throwable failure) {
        try {
            getHttpChannel().getHttpDestination().getHttpClient().getExecutor().execute(()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: INVOKE  
                  (wrap: java.util.concurrent.Executor : 0x000a: INVOKE  (r0v9 'executor' java.util.concurrent.Executor A[REMOVE]) = 
                  (wrap: org.eclipse.jetty.client.HttpClient : 0x0007: INVOKE  (r0v8 org.eclipse.jetty.client.HttpClient A[REMOVE]) = 
                  (wrap: org.eclipse.jetty.client.HttpDestination : 0x0004: INVOKE  (r0v7 org.eclipse.jetty.client.HttpDestination A[REMOVE]) = 
                  (wrap: org.eclipse.jetty.client.HttpChannel : 0x0001: INVOKE  (r0v6 org.eclipse.jetty.client.HttpChannel A[REMOVE]) = 
                  (r5v0 'this' org.eclipse.jetty.client.HttpSender A[D('this' org.eclipse.jetty.client.HttpSender), IMMUTABLE_TYPE, THIS])
                 type: VIRTUAL call: org.eclipse.jetty.client.HttpSender.getHttpChannel():org.eclipse.jetty.client.HttpChannel)
                 type: VIRTUAL call: org.eclipse.jetty.client.HttpChannel.getHttpDestination():org.eclipse.jetty.client.HttpDestination)
                 type: VIRTUAL call: org.eclipse.jetty.client.HttpDestination.getHttpClient():org.eclipse.jetty.client.HttpClient)
                 type: VIRTUAL call: org.eclipse.jetty.client.HttpClient.getExecutor():java.util.concurrent.Executor)
                  (wrap: java.lang.Runnable : 0x0012: INVOKE_CUSTOM (r1v3 java.lang.Runnable A[REMOVE]) = 
                  (r5v0 'this' org.eclipse.jetty.client.HttpSender A[D('this' org.eclipse.jetty.client.HttpSender), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r6v0 'exchange' org.eclipse.jetty.client.HttpExchange A[D('exchange' org.eclipse.jetty.client.HttpExchange), DONT_INLINE])
                  (r7v0 'failure' java.lang.Throwable A[D('failure' java.lang.Throwable), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  (r1 I:org.eclipse.jetty.client.HttpSender), (r2 I:org.eclipse.jetty.client.HttpExchange), (r3 I:java.lang.Throwable) type: DIRECT call: org.eclipse.jetty.client.HttpSender.lambda$executeAbort$0(org.eclipse.jetty.client.HttpExchange, java.lang.Throwable):void)
                 type: INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void in method: org.eclipse.jetty.client.HttpSender.executeAbort(org.eclipse.jetty.client.HttpExchange, java.lang.Throwable):void, file: grasscutter.jar:org/eclipse/jetty/client/HttpSender.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
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
                	... 21 more
                */
            /*
                this = this;
                r0 = r5
                org.eclipse.jetty.client.HttpChannel r0 = r0.getHttpChannel()     // Catch: RejectedExecutionException -> 0x001f
                org.eclipse.jetty.client.HttpDestination r0 = r0.getHttpDestination()     // Catch: RejectedExecutionException -> 0x001f
                org.eclipse.jetty.client.HttpClient r0 = r0.getHttpClient()     // Catch: RejectedExecutionException -> 0x001f
                java.util.concurrent.Executor r0 = r0.getExecutor()     // Catch: RejectedExecutionException -> 0x001f
                r8 = r0
                r0 = r8
                r1 = r5
                r2 = r6
                r3 = r7
                void r1 = () -> { // java.lang.Runnable.run():void
                    r1.lambda$executeAbort$0(r2, r3);
                }     // Catch: RejectedExecutionException -> 0x001f
                r0.execute(r1)     // Catch: RejectedExecutionException -> 0x001f
                goto L_0x003b
            L_0x001f:
                r8 = move-exception
                org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.client.HttpSender.LOG
                boolean r0 = r0.isDebugEnabled()
                if (r0 == 0) goto L_0x0034
                org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.client.HttpSender.LOG
                r1 = r8
                r0.debug(r1)
            L_0x0034:
                r0 = r5
                r1 = r6
                r2 = r7
                boolean r0 = r0.abort(r1, r2)
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.client.HttpSender.executeAbort(org.eclipse.jetty.client.HttpExchange, java.lang.Throwable):void");
        }

        private void terminateRequest(HttpExchange exchange) {
            Throwable failure = this.failure;
            if (failure == null) {
                failure = new HttpRequestException("Concurrent failure", exchange.getRequest());
            }
            terminateRequest(exchange, failure, exchange.terminateRequest());
        }

        private void terminateRequest(HttpExchange exchange, Throwable failure, Result result) {
            Request request = exchange.getRequest();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Terminating request {}", request);
            }
            if (result != null) {
                Result result2 = this.channel.exchangeTerminating(exchange, result);
                HttpDestination destination = getHttpChannel().getHttpDestination();
                boolean ordered = destination.getHttpClient().isStrictEventOrdering();
                if (!ordered) {
                    this.channel.exchangeTerminated(exchange, result2);
                }
                if (LOG.isDebugEnabled()) {
                    Logger logger = LOG;
                    Object[] objArr = new Object[2];
                    objArr[0] = failure == null ? "succeeded" : "failed";
                    objArr[1] = result2;
                    logger.debug("Request/Response {}: {}", objArr);
                }
                destination.getResponseNotifier().notifyComplete(exchange.getConversation().getResponseListeners(), result2);
                if (ordered) {
                    this.channel.exchangeTerminated(exchange, result2);
                }
            } else if (failure != null && exchange.responseComplete(failure)) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Response failure from request {} {}", request, exchange);
                }
                getHttpChannel().abortResponse(exchange, failure);
            }
        }

        /* access modifiers changed from: protected */
        public void reset() {
            HttpContent content = this.content;
            this.content = null;
            content.close();
            this.senderState.set(SenderState.COMPLETED);
        }

        /* access modifiers changed from: protected */
        public void dispose() {
            HttpContent content = this.content;
            this.content = null;
            if (content != null) {
                content.close();
            }
            this.senderState.set(SenderState.FAILED);
        }

        public void proceed(HttpExchange exchange, Throwable failure) {
            if (expects100Continue(exchange.getRequest())) {
                if (failure != null) {
                    anyToFailure(failure);
                    return;
                }
                while (true) {
                    SenderState current = this.senderState.get();
                    switch (current) {
                        case EXPECTING:
                            if (!updateSenderState(current, SenderState.PROCEEDING)) {
                                break;
                            } else if (LOG.isDebugEnabled()) {
                                LOG.debug("Proceeding while expecting", new Object[0]);
                                return;
                            } else {
                                return;
                            }
                        case PROCEEDING:
                        case SENDING_WITH_CONTENT:
                        case PROCEEDING_WITH_CONTENT:
                        case COMPLETED:
                        default:
                            illegalSenderState(current);
                            return;
                        case EXPECTING_WITH_CONTENT:
                            if (!updateSenderState(current, SenderState.PROCEEDING_WITH_CONTENT)) {
                                break;
                            } else if (LOG.isDebugEnabled()) {
                                LOG.debug("Proceeding while scheduled", new Object[0]);
                                return;
                            } else {
                                return;
                            }
                        case WAITING:
                            if (!updateSenderState(current, SenderState.SENDING)) {
                                break;
                            } else {
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Proceeding while waiting", new Object[0]);
                                }
                                this.contentCallback.iterate();
                                return;
                            }
                        case FAILED:
                            return;
                    }
                }
            }
        }

        public boolean abort(HttpExchange exchange, Throwable failure) {
            RequestState current;
            do {
                current = this.requestState.get();
                switch (current) {
                    case FAILURE:
                        return false;
                }
            } while (!updateRequestState(current, RequestState.FAILURE));
            boolean terminate = current != RequestState.TRANSIENT;
            this.failure = failure;
            dispose();
            Request request = exchange.getRequest();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Request abort {} {} on {}: {}", request, exchange, getHttpChannel(), failure);
            }
            getHttpChannel().getHttpDestination().getRequestNotifier().notifyFailure(request, failure);
            if (terminate) {
                terminateRequest(exchange, failure, exchange.terminateRequest());
                return true;
            } else if (!LOG.isDebugEnabled()) {
                return false;
            } else {
                LOG.debug("Concurrent failure: request termination skipped, performed by helpers", new Object[0]);
                return false;
            }
        }

        private boolean updateRequestState(RequestState from, RequestState to) {
            boolean updated = this.requestState.compareAndSet(from, to);
            if (!updated && LOG.isDebugEnabled()) {
                LOG.debug("RequestState update failed: {} -> {}: {}", from, to, this.requestState.get());
            }
            return updated;
        }

        /* access modifiers changed from: private */
        public boolean updateSenderState(SenderState from, SenderState to) {
            boolean updated = this.senderState.compareAndSet(from, to);
            if (!updated && LOG.isDebugEnabled()) {
                LOG.debug("SenderState update failed: {} -> {}: {}", from, to, this.senderState.get());
            }
            return updated;
        }

        /* access modifiers changed from: private */
        public void illegalSenderState(SenderState current) {
            anyToFailure(new IllegalStateException("Expected " + current + " found " + this.senderState.get() + " instead"));
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s@%x(req=%s,snd=%s,failure=%s)", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.requestState, this.senderState, this.failure);
        }

        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpSender$CommitCallback.class */
        private class CommitCallback implements Callback {
            private CommitCallback() {
            }

            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                try {
                    HttpContent content = HttpSender.this.content;
                    if (content != null) {
                        content.succeeded();
                        process();
                    }
                } catch (Throwable x) {
                    HttpSender.this.anyToFailure(x);
                }
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable failure) {
                HttpContent content = HttpSender.this.content;
                if (content != null) {
                    content.failed(failure);
                    HttpSender.this.anyToFailure(failure);
                }
            }

            private void process() throws Exception {
                HttpContent content;
                HttpExchange exchange = HttpSender.this.getHttpExchange();
                if (exchange != null && HttpSender.this.headersToCommit(exchange) && (content = HttpSender.this.content) != null) {
                    if (!content.hasContent()) {
                        HttpSender.this.someToSuccess(exchange);
                        return;
                    }
                    ByteBuffer contentBuffer = content.getContent();
                    if (contentBuffer == null || HttpSender.this.someToContent(exchange, contentBuffer)) {
                        while (true) {
                            SenderState current = (SenderState) HttpSender.this.senderState.get();
                            switch (current) {
                                case SENDING:
                                    HttpSender.this.contentCallback.iterate();
                                    return;
                                case EXPECTING:
                                    if (!HttpSender.this.updateSenderState(current, SenderState.WAITING)) {
                                        break;
                                    } else {
                                        return;
                                    }
                                case PROCEEDING:
                                    if (!HttpSender.this.updateSenderState(current, SenderState.IDLE)) {
                                        break;
                                    } else {
                                        return;
                                    }
                                case SENDING_WITH_CONTENT:
                                    HttpSender.this.updateSenderState(current, SenderState.SENDING);
                                    break;
                                case EXPECTING_WITH_CONTENT:
                                    if (!HttpSender.this.updateSenderState(current, SenderState.WAITING)) {
                                        break;
                                    } else {
                                        return;
                                    }
                                case PROCEEDING_WITH_CONTENT:
                                    HttpSender.this.updateSenderState(current, SenderState.SENDING);
                                    break;
                                case WAITING:
                                case COMPLETED:
                                default:
                                    HttpSender.this.illegalSenderState(current);
                                    return;
                                case FAILED:
                                    return;
                            }
                        }
                    }
                }
            }
        }

        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpSender$ContentCallback.class */
        private class ContentCallback extends IteratingCallback {
            private ContentCallback() {
            }

            @Override // org.eclipse.jetty.util.IteratingCallback
            protected IteratingCallback.Action process() throws Exception {
                HttpExchange exchange = HttpSender.this.getHttpExchange();
                if (exchange == null) {
                    return IteratingCallback.Action.IDLE;
                }
                HttpContent content = HttpSender.this.content;
                if (content == null) {
                    return IteratingCallback.Action.IDLE;
                }
                while (true) {
                    boolean advanced = content.advance();
                    boolean lastContent = content.isLast();
                    if (HttpSender.LOG.isDebugEnabled()) {
                        HttpSender.LOG.debug("Content present {}, last {}, consumed {} for {}", Boolean.valueOf(advanced), Boolean.valueOf(lastContent), Boolean.valueOf(content.isConsumed()), exchange.getRequest());
                    }
                    if (advanced) {
                        HttpSender.this.sendContent(exchange, content, this);
                        return IteratingCallback.Action.SCHEDULED;
                    } else if (lastContent) {
                        HttpSender.this.sendContent(exchange, content, HttpSender.this.lastCallback);
                        return IteratingCallback.Action.IDLE;
                    } else {
                        SenderState current = (SenderState) HttpSender.this.senderState.get();
                        switch (current) {
                            case SENDING:
                                if (!HttpSender.this.updateSenderState(current, SenderState.IDLE)) {
                                    break;
                                } else {
                                    if (HttpSender.LOG.isDebugEnabled()) {
                                        HttpSender.LOG.debug("Content is deferred for {}", exchange.getRequest());
                                    }
                                    return IteratingCallback.Action.IDLE;
                                }
                            case SENDING_WITH_CONTENT:
                                HttpSender.this.updateSenderState(current, SenderState.SENDING);
                                break;
                            default:
                                HttpSender.this.illegalSenderState(current);
                                return IteratingCallback.Action.IDLE;
                        }
                    }
                }
            }

            @Override // org.eclipse.jetty.util.IteratingCallback, org.eclipse.jetty.util.Callback
            public void succeeded() {
                HttpContent content;
                HttpExchange exchange = HttpSender.this.getHttpExchange();
                if (exchange != null && (content = HttpSender.this.content) != null) {
                    content.succeeded();
                    HttpSender.this.someToContent(exchange, content.getContent());
                    succeeded();
                }
            }

            @Override // org.eclipse.jetty.util.IteratingCallback
            public void onCompleteFailure(Throwable failure) {
                HttpContent content = HttpSender.this.content;
                if (content != null) {
                    content.failed(failure);
                    HttpSender.this.anyToFailure(failure);
                }
            }

            @Override // org.eclipse.jetty.util.IteratingCallback
            protected void onCompleteSuccess() {
            }
        }

        /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpSender$LastCallback.class */
        private class LastCallback implements Callback {
            private LastCallback() {
            }

            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                HttpContent content;
                HttpExchange exchange = HttpSender.this.getHttpExchange();
                if (exchange != null && (content = HttpSender.this.content) != null) {
                    content.succeeded();
                    HttpSender.this.someToSuccess(exchange);
                }
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable failure) {
                HttpContent content = HttpSender.this.content;
                if (content != null) {
                    content.failed(failure);
                    HttpSender.this.anyToFailure(failure);
                }
            }
        }
    }
