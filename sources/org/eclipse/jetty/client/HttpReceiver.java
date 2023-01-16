package org.eclipse.jetty.client;

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongConsumer;
import java.util.function.LongUnaryOperator;
import java.util.stream.Stream;
import org.eclipse.jetty.client.ContentDecoder;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.MathUtils;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpReceiver.class */
public abstract class HttpReceiver {
    protected static final Logger LOG;
    private final AtomicReference<ResponseState> responseState = new AtomicReference<>(ResponseState.IDLE);
    private final HttpChannel channel;
    private ContentListeners contentListeners;
    private Decoder decoder;
    private Throwable failure;
    private long demand;
    private boolean stalled;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpReceiver$DecodeResult.class */
    public enum DecodeResult {
        DECODE,
        NEED_INPUT,
        ABORT
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpReceiver$ResponseState.class */
    public enum ResponseState {
        TRANSIENT,
        IDLE,
        BEGIN,
        HEADER,
        HEADERS,
        CONTENT,
        FAILURE
    }

    static {
        $assertionsDisabled = !HttpReceiver.class.desiredAssertionStatus();
        LOG = Log.getLogger(HttpReceiver.class);
    }

    /* access modifiers changed from: protected */
    public HttpReceiver(HttpChannel channel) {
        this.channel = channel;
    }

    /* access modifiers changed from: protected */
    public HttpChannel getHttpChannel() {
        return this.channel;
    }

    void demand(long n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid demand " + n);
        }
        boolean resume = false;
        synchronized (this) {
            this.demand = MathUtils.cappedAdd(this.demand, n);
            if (this.stalled) {
                this.stalled = false;
                resume = true;
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Response demand={}/{}, resume={}", Long.valueOf(n), Long.valueOf(this.demand), Boolean.valueOf(resume));
            }
        }
        if (!resume) {
            return;
        }
        if (this.decoder != null) {
            this.decoder.resume();
        } else {
            receive();
        }
    }

    protected long demand() {
        return demand(LongUnaryOperator.identity());
    }

    /* access modifiers changed from: private */
    public long demand(LongUnaryOperator operator) {
        long applyAsLong;
        synchronized (this) {
            applyAsLong = operator.applyAsLong(this.demand);
            this.demand = applyAsLong;
        }
        return applyAsLong;
    }

    protected boolean hasDemandOrStall() {
        boolean z;
        synchronized (this) {
            this.stalled = this.demand <= 0;
            z = !this.stalled;
        }
        return z;
    }

    protected HttpExchange getHttpExchange() {
        return this.channel.getHttpExchange();
    }

    protected HttpDestination getHttpDestination() {
        return this.channel.getHttpDestination();
    }

    public boolean isFailed() {
        return this.responseState.get() == ResponseState.FAILURE;
    }

    protected void receive() {
    }

    protected boolean responseBegin(HttpExchange exchange) {
        if (!updateResponseState(ResponseState.IDLE, ResponseState.TRANSIENT)) {
            return false;
        }
        HttpConversation conversation = exchange.getConversation();
        HttpResponse response = exchange.getResponse();
        HttpDestination destination = getHttpDestination();
        ProtocolHandler protocolHandler = destination.getHttpClient().findProtocolHandler(exchange.getRequest(), response);
        Response.Listener handlerListener = null;
        if (protocolHandler != null) {
            handlerListener = protocolHandler.getResponseListener();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Response {} found protocol handler {}", response, protocolHandler);
            }
        }
        exchange.getConversation().updateResponseListeners(handlerListener);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response begin {}", response);
        }
        destination.getResponseNotifier().notifyBegin(conversation.getResponseListeners(), response);
        if (updateResponseState(ResponseState.TRANSIENT, ResponseState.BEGIN)) {
            return true;
        }
        dispose();
        terminateResponse(exchange);
        return false;
    }

    protected boolean responseHeader(HttpExchange exchange, HttpField field) {
        if (!updateResponseState(ResponseState.BEGIN, ResponseState.HEADER, ResponseState.TRANSIENT)) {
            return false;
        }
        HttpResponse response = exchange.getResponse();
        if (getHttpDestination().getResponseNotifier().notifyHeader(exchange.getConversation().getResponseListeners(), response, field)) {
            response.getHeaders().add(field);
            HttpHeader fieldHeader = field.getHeader();
            if (fieldHeader != null) {
                switch (fieldHeader) {
                    case SET_COOKIE:
                    case SET_COOKIE2:
                        URI uri = exchange.getRequest().getURI();
                        if (uri != null) {
                            storeCookie(uri, field);
                            break;
                        }
                        break;
                }
            }
        }
        if (updateResponseState(ResponseState.TRANSIENT, ResponseState.HEADER)) {
            return true;
        }
        dispose();
        terminateResponse(exchange);
        return false;
    }

    protected void storeCookie(URI uri, HttpField field) {
        try {
            String value = field.getValue();
            if (value != null) {
                Map<String, List<String>> header = new HashMap<>(1);
                header.put(field.getHeader().asString(), Collections.singletonList(value));
                getHttpDestination().getHttpClient().getCookieManager().put(uri, header);
            }
        } catch (IOException x) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(x);
            }
        }
    }

    protected boolean responseHeaders(HttpExchange exchange) {
        List<String> contentEncodings;
        if (!updateResponseState(ResponseState.BEGIN, ResponseState.HEADER, ResponseState.TRANSIENT)) {
            return false;
        }
        HttpResponse response = exchange.getResponse();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response headers {}{}{}", response, System.lineSeparator(), response.getHeaders().toString().trim());
        }
        ResponseNotifier notifier = getHttpDestination().getResponseNotifier();
        List<Response.ResponseListener> responseListeners = exchange.getConversation().getResponseListeners();
        notifier.notifyHeaders(responseListeners, response);
        this.contentListeners = new ContentListeners(responseListeners);
        this.contentListeners.notifyBeforeContent(response);
        if (!this.contentListeners.isEmpty() && (contentEncodings = response.getHeaders().getCSV(HttpHeader.CONTENT_ENCODING.asString(), false)) != null && !contentEncodings.isEmpty()) {
            for (ContentDecoder.Factory factory : getHttpDestination().getHttpClient().getContentDecoderFactories()) {
                Iterator<String> it = contentEncodings.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (factory.getEncoding().equalsIgnoreCase(it.next())) {
                            this.decoder = new Decoder(exchange, factory.newContentDecoder());
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (updateResponseState(ResponseState.TRANSIENT, ResponseState.HEADERS)) {
            boolean hasDemand = hasDemandOrStall();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Response headers hasDemand={} {}", Boolean.valueOf(hasDemand), response);
            }
            return hasDemand;
        }
        dispose();
        terminateResponse(exchange);
        return false;
    }

    protected boolean responseContent(HttpExchange exchange, ByteBuffer buffer, Callback callback) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response content {}{}{}", exchange.getResponse(), System.lineSeparator(), BufferUtil.toDetailString(buffer));
        }
        if (demand() <= 0) {
            callback.failed(new IllegalStateException("No demand for response content"));
            return false;
        } else if (this.decoder == null) {
            return plainResponseContent(exchange, buffer, callback);
        } else {
            return decodeResponseContent(buffer, callback);
        }
    }

    private boolean plainResponseContent(HttpExchange exchange, ByteBuffer buffer, Callback callback) {
        if (!updateResponseState(ResponseState.HEADERS, ResponseState.CONTENT, ResponseState.TRANSIENT)) {
            callback.failed(new IllegalStateException("Invalid response state " + this.responseState));
            return false;
        }
        HttpResponse response = exchange.getResponse();
        if (this.contentListeners.isEmpty()) {
            callback.succeeded();
        } else {
            this.contentListeners.notifyContent(response, buffer, callback);
        }
        if (updateResponseState(ResponseState.TRANSIENT, ResponseState.CONTENT)) {
            boolean hasDemand = hasDemandOrStall();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Response content {}, hasDemand={}", response, Boolean.valueOf(hasDemand));
            }
            return hasDemand;
        }
        dispose();
        terminateResponse(exchange);
        return false;
    }

    private boolean decodeResponseContent(ByteBuffer buffer, Callback callback) {
        return this.decoder.decode(buffer, callback);
    }

    protected boolean responseSuccess(HttpExchange exchange) {
        if (!exchange.responseComplete(null)) {
            return false;
        }
        this.responseState.set(ResponseState.IDLE);
        reset();
        HttpResponse response = exchange.getResponse();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response success {}", response);
        }
        getHttpDestination().getResponseNotifier().notifySuccess(exchange.getConversation().getResponseListeners(), response);
        if (exchange.getResponse().getStatus() == 100) {
            return true;
        }
        terminateResponse(exchange);
        return true;
    }

    protected boolean responseFailure(Throwable failure) {
        HttpExchange exchange = getHttpExchange();
        if (exchange == null) {
            return false;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response failure " + exchange.getResponse(), failure);
        }
        if (exchange.responseComplete(failure)) {
            return abort(exchange, failure);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void terminateResponse(HttpExchange exchange) {
        terminateResponse(exchange, exchange.terminateResponse());
    }

    private void terminateResponse(HttpExchange exchange, Result result) {
        HttpResponse response = exchange.getResponse();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response complete {}", response);
        }
        if (result != null) {
            Result result2 = this.channel.exchangeTerminating(exchange, result);
            boolean ordered = getHttpDestination().getHttpClient().isStrictEventOrdering();
            if (!ordered) {
                this.channel.exchangeTerminated(exchange, result2);
            }
            List<Response.ResponseListener> listeners = exchange.getConversation().getResponseListeners();
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                Object[] objArr = new Object[3];
                objArr[0] = this.failure == null ? "succeeded" : "failed";
                objArr[1] = result2;
                objArr[2] = listeners;
                logger.debug("Request/Response {}: {}, notifying {}", objArr);
            }
            getHttpDestination().getResponseNotifier().notifyComplete(listeners, result2);
            if (ordered) {
                this.channel.exchangeTerminated(exchange, result2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reset() {
        cleanup();
    }

    protected void dispose() {
        if ($assertionsDisabled || this.responseState.get() != ResponseState.TRANSIENT) {
            cleanup();
            return;
        }
        throw new AssertionError();
    }

    private void cleanup() {
        this.contentListeners = null;
        if (this.decoder != null) {
            this.decoder.destroy();
        }
        this.decoder = null;
        this.demand = 0;
        this.stalled = false;
    }

    public boolean abort(HttpExchange exchange, Throwable failure) {
        ResponseState current;
        do {
            current = this.responseState.get();
            if (current == ResponseState.FAILURE) {
                return false;
            }
        } while (!updateResponseState(current, ResponseState.FAILURE));
        boolean terminate = current != ResponseState.TRANSIENT;
        this.failure = failure;
        if (terminate) {
            dispose();
        }
        HttpResponse response = exchange.getResponse();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Response abort {} {} on {}: {}", response, exchange, getHttpChannel(), failure);
        }
        getHttpDestination().getResponseNotifier().notifyFailure(exchange.getConversation().getResponseListeners(), response, failure);
        if (terminate) {
            terminateResponse(exchange);
            return true;
        } else if (!LOG.isDebugEnabled()) {
            return false;
        } else {
            LOG.debug("Concurrent failure: response termination skipped, performed by helpers", new Object[0]);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean updateResponseState(ResponseState from1, ResponseState from2, ResponseState to) {
        ResponseState current;
        do {
            current = this.responseState.get();
            if (current != from1 && current != from2) {
                if (!LOG.isDebugEnabled()) {
                    return false;
                }
                LOG.debug("State update failed: [{},{}] -> {}: {}", from1, from2, to, current);
                return false;
            }
        } while (!updateResponseState(current, to));
        return true;
    }

    /* access modifiers changed from: private */
    public boolean updateResponseState(ResponseState from, ResponseState to) {
        ResponseState current;
        do {
            current = this.responseState.get();
            if (current != from) {
                if (!LOG.isDebugEnabled()) {
                    return false;
                }
                LOG.debug("State update failed: {} -> {}: {}", from, to, current);
                return false;
            }
        } while (!this.responseState.compareAndSet(current, to));
        return true;
    }

    public String toString() {
        return String.format("%s@%x(rsp=%s,failure=%s)", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.responseState, this.failure);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpReceiver$ContentListeners.class */
    public class ContentListeners {
        private final Map<Object, Long> demands;
        private final LongConsumer demand;
        private final List<Response.DemandedContentListener> listeners;

        private ContentListeners(List<Response.ResponseListener> responseListeners) {
            this.demands = new ConcurrentHashMap();
            HttpReceiver httpReceiver = HttpReceiver.this;
            this.demand = this::demand;
            this.listeners = new ArrayList(responseListeners.size());
            Stream<Response.ResponseListener> stream = responseListeners.stream();
            Objects.requireNonNull(Response.DemandedContentListener.class);
            Stream<Response.ResponseListener> filter = stream.filter((v1) -> {
                return r1.isInstance(v1);
            });
            Objects.requireNonNull(Response.DemandedContentListener.class);
            Stream<R> map = filter.map((v1) -> {
                return r1.cast(v1);
            });
            List<Response.DemandedContentListener> list = this.listeners;
            Objects.requireNonNull(list);
            map.forEach((v1) -> {
                r1.add(v1);
            });
        }

        /* access modifiers changed from: private */
        public boolean isEmpty() {
            return this.listeners.isEmpty();
        }

        /* access modifiers changed from: private */
        public void notifyBeforeContent(HttpResponse response) {
            if (isEmpty()) {
                this.demand.accept(1);
            } else {
                HttpReceiver.this.getHttpDestination().getResponseNotifier().notifyBeforeContent(response, this::demand, this.listeners);
            }
        }

        /* access modifiers changed from: private */
        public void notifyContent(HttpResponse response, ByteBuffer buffer, Callback callback) {
            HttpReceiver.this.demand(d -> {
                return d - 1;
            });
            HttpReceiver.this.getHttpDestination().getResponseNotifier().notifyContent(response, this::demand, buffer, callback, this.listeners);
        }

        private void demand(Object context, long value) {
            if (this.listeners.size() > 1) {
                accept(context, value);
            } else {
                this.demand.accept(value);
            }
        }

        /* JADX WARN: Type inference failed for: r0v43, types: [long] */
        private void accept(Object context, long value) {
            this.demands.merge(context, Long.valueOf(value), (v0, v1) -> {
                return MathUtils.cappedAdd(v0, v1);
            });
            if (this.demands.size() == this.listeners.size()) {
                char c = 65535;
                for (Long demand : this.demands.values()) {
                    if (demand.longValue() < c) {
                        c = demand.longValue();
                    }
                }
                if (c > 0) {
                    Iterator<Map.Entry<Object, Long>> iterator = this.demands.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<Object, Long> entry = iterator.next();
                        long newValue = entry.getValue().longValue() - c;
                        if (newValue == 0) {
                            iterator.remove();
                        } else {
                            entry.setValue(Long.valueOf(newValue));
                        }
                    }
                    this.demand.accept(c);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpReceiver$Decoder.class */
    public class Decoder implements Destroyable {
        private final HttpExchange exchange;
        private final ContentDecoder decoder;
        private ByteBuffer encoded;
        private Callback callback;

        private Decoder(HttpExchange exchange, ContentDecoder decoder) {
            this.exchange = exchange;
            this.decoder = (ContentDecoder) Objects.requireNonNull(decoder);
        }

        /* access modifiers changed from: private */
        public boolean decode(ByteBuffer encoded, Callback callback) {
            this.encoded = encoded;
            this.callback = callback;
            HttpResponse response = this.exchange.getResponse();
            if (HttpReceiver.LOG.isDebugEnabled()) {
                HttpReceiver.LOG.debug("Response content decoding {} with {}{}{}", response, this.decoder, System.lineSeparator(), BufferUtil.toDetailString(encoded));
            }
            if (!decode()) {
                return false;
            }
            boolean hasDemand = HttpReceiver.this.hasDemandOrStall();
            if (HttpReceiver.LOG.isDebugEnabled()) {
                HttpReceiver.LOG.debug("Response content decoded, hasDemand={} {}", Boolean.valueOf(hasDemand), response);
            }
            return hasDemand;
        }

        private boolean decode() {
            while (HttpReceiver.this.updateResponseState(ResponseState.HEADERS, ResponseState.CONTENT, ResponseState.TRANSIENT)) {
                DecodeResult result = decodeChunk();
                if (!HttpReceiver.this.updateResponseState(ResponseState.TRANSIENT, ResponseState.CONTENT)) {
                    HttpReceiver.this.dispose();
                    HttpReceiver.this.terminateResponse(this.exchange);
                    return false;
                } else if (result == DecodeResult.NEED_INPUT) {
                    return true;
                } else {
                    if (result == DecodeResult.ABORT) {
                        return false;
                    }
                    boolean hasDemand = HttpReceiver.this.hasDemandOrStall();
                    if (HttpReceiver.LOG.isDebugEnabled()) {
                        HttpReceiver.LOG.debug("Response content decoded chunk, hasDemand={} {}", Boolean.valueOf(hasDemand), this.exchange.getResponse());
                    }
                    if (!hasDemand) {
                        return false;
                    }
                }
            }
            this.callback.failed(new IllegalStateException("Invalid response state " + HttpReceiver.this.responseState));
            return false;
        }

        private DecodeResult decodeChunk() {
            do {
                try {
                    ByteBuffer buffer = this.decoder.decode(this.encoded);
                    if (buffer.hasRemaining()) {
                        HttpResponse response = this.exchange.getResponse();
                        if (HttpReceiver.LOG.isDebugEnabled()) {
                            HttpReceiver.LOG.debug("Response content decoded chunk {}{}{}", response, System.lineSeparator(), BufferUtil.toDetailString(buffer));
                        }
                        ContentListeners contentListeners = HttpReceiver.this.contentListeners;
                        Runnable r3 = ()
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0078: INVOKE_CUSTOM (r3v1 'r3' java.lang.Runnable) = 
                              (r7v0 'this' org.eclipse.jetty.client.HttpReceiver$Decoder A[D('this' org.eclipse.jetty.client.HttpReceiver$Decoder), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                              (r0v5 'buffer' java.nio.ByteBuffer A[D('buffer' java.nio.ByteBuffer), DONT_INLINE])
                            
                             handle type: INVOKE_DIRECT
                             lambda: java.lang.Runnable.run():void
                             call insn: ?: INVOKE  (r3 I:org.eclipse.jetty.client.HttpReceiver$Decoder), (r4 I:java.nio.ByteBuffer) type: DIRECT call: org.eclipse.jetty.client.HttpReceiver.Decoder.lambda$decodeChunk$0(java.nio.ByteBuffer):void in method: org.eclipse.jetty.client.HttpReceiver.Decoder.decodeChunk():org.eclipse.jetty.client.HttpReceiver$DecodeResult, file: grasscutter.jar:org/eclipse/jetty/client/HttpReceiver$Decoder.class
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:230)
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
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                            	... 35 more
                            */
                        /*
                            this = this;
                        L_0x0000:
                            r0 = r7
                            org.eclipse.jetty.client.ContentDecoder r0 = r0.decoder     // Catch: Throwable -> 0x0095
                            r1 = r7
                            java.nio.ByteBuffer r1 = r1.encoded     // Catch: Throwable -> 0x0095
                            java.nio.ByteBuffer r0 = r0.decode(r1)     // Catch: Throwable -> 0x0095
                            r8 = r0
                            r0 = r8
                            boolean r0 = r0.hasRemaining()     // Catch: Throwable -> 0x0095
                            if (r0 == 0) goto L_0x0018
                            goto L_0x0039
                        L_0x0018:
                            r0 = r7
                            java.nio.ByteBuffer r0 = r0.encoded     // Catch: Throwable -> 0x0095
                            boolean r0 = r0.hasRemaining()     // Catch: Throwable -> 0x0095
                            if (r0 != 0) goto L_0x0000
                            r0 = r7
                            org.eclipse.jetty.util.Callback r0 = r0.callback     // Catch: Throwable -> 0x0095
                            r0.succeeded()     // Catch: Throwable -> 0x0095
                            r0 = r7
                            r1 = 0
                            r0.encoded = r1     // Catch: Throwable -> 0x0095
                            r0 = r7
                            r1 = 0
                            r0.callback = r1     // Catch: Throwable -> 0x0095
                            org.eclipse.jetty.client.HttpReceiver$DecodeResult r0 = org.eclipse.jetty.client.HttpReceiver.DecodeResult.NEED_INPUT     // Catch: Throwable -> 0x0095
                            return r0
                        L_0x0039:
                            r0 = r8
                            r9 = r0
                            r0 = r7
                            org.eclipse.jetty.client.HttpExchange r0 = r0.exchange     // Catch: Throwable -> 0x0095
                            org.eclipse.jetty.client.HttpResponse r0 = r0.getResponse()     // Catch: Throwable -> 0x0095
                            r10 = r0
                            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.client.HttpReceiver.LOG     // Catch: Throwable -> 0x0095
                            boolean r0 = r0.isDebugEnabled()     // Catch: Throwable -> 0x0095
                            if (r0 == 0) goto L_0x006d
                            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.client.HttpReceiver.LOG     // Catch: Throwable -> 0x0095
                            java.lang.String r1 = "Response content decoded chunk {}{}{}"
                            r2 = 3
                            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Throwable -> 0x0095
                            r3 = r2
                            r4 = 0
                            r5 = r10
                            r3[r4] = r5     // Catch: Throwable -> 0x0095
                            r3 = r2
                            r4 = 1
                            java.lang.String r5 = java.lang.System.lineSeparator()     // Catch: Throwable -> 0x0095
                            r3[r4] = r5     // Catch: Throwable -> 0x0095
                            r3 = r2
                            r4 = 2
                            r5 = r9
                            java.lang.String r5 = org.eclipse.jetty.util.BufferUtil.toDetailString(r5)     // Catch: Throwable -> 0x0095
                            r3[r4] = r5     // Catch: Throwable -> 0x0095
                            r0.debug(r1, r2)     // Catch: Throwable -> 0x0095
                        L_0x006d:
                            r0 = r7
                            org.eclipse.jetty.client.HttpReceiver r0 = org.eclipse.jetty.client.HttpReceiver.this     // Catch: Throwable -> 0x0095
                            org.eclipse.jetty.client.HttpReceiver$ContentListeners r0 = org.eclipse.jetty.client.HttpReceiver.access$1200(r0)     // Catch: Throwable -> 0x0095
                            r1 = r10
                            r2 = r9
                            r3 = r7
                            r4 = r9
                            org.eclipse.jetty.client.HttpReceiver$DecodeResult r3 = () -> { // java.lang.Runnable.run():void
                                r3.lambda$decodeChunk$0(r4);
                            }     // Catch: Throwable -> 0x0095
                            r4 = r7
                            org.eclipse.jetty.util.Callback r4 = r4.callback     // Catch: Throwable -> 0x0095
                            r5 = r4
                            java.lang.Object r5 = java.util.Objects.requireNonNull(r5)     // Catch: Throwable -> 0x0095
                            org.eclipse.jetty.client.HttpReceiver$DecodeResult r4 = this::failed     // Catch: Throwable -> 0x0095
                            org.eclipse.jetty.util.Callback r3 = org.eclipse.jetty.util.Callback.from(r3, r4)     // Catch: Throwable -> 0x0095
                            org.eclipse.jetty.client.HttpReceiver.ContentListeners.access$500(r0, r1, r2, r3)     // Catch: Throwable -> 0x0095
                            org.eclipse.jetty.client.HttpReceiver$DecodeResult r0 = org.eclipse.jetty.client.HttpReceiver.DecodeResult.DECODE     // Catch: Throwable -> 0x0095
                            return r0
                        L_0x0095:
                            r8 = move-exception
                            r0 = r7
                            org.eclipse.jetty.util.Callback r0 = r0.callback
                            r1 = r8
                            r0.failed(r1)
                            org.eclipse.jetty.client.HttpReceiver$DecodeResult r0 = org.eclipse.jetty.client.HttpReceiver.DecodeResult.ABORT
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.client.HttpReceiver.Decoder.decodeChunk():org.eclipse.jetty.client.HttpReceiver$DecodeResult");
                    }

                    /* access modifiers changed from: private */
                    public void resume() {
                        if (HttpReceiver.LOG.isDebugEnabled()) {
                            HttpReceiver.LOG.debug("Response content resume decoding {} with {}", this.exchange.getResponse(), this.decoder);
                        }
                        if (this.callback == null) {
                            HttpReceiver.this.receive();
                        } else if (decode()) {
                            HttpReceiver.this.receive();
                        }
                    }

                    @Override // org.eclipse.jetty.util.component.Destroyable
                    public void destroy() {
                        if (this.decoder instanceof Destroyable) {
                            ((Destroyable) this.decoder).destroy();
                        }
                    }
                }
            }
