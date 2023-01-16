package org.eclipse.jetty.server;

import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Objects;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelListeners.class */
public class HttpChannelListeners implements HttpChannel.Listener {
    static final Logger LOG = Log.getLogger(HttpChannel.class);
    public static HttpChannel.Listener NOOP = new HttpChannel.Listener() { // from class: org.eclipse.jetty.server.HttpChannelListeners.1
    };
    private final NotifyRequest onRequestBegin;
    private final NotifyRequest onBeforeDispatch;
    private final NotifyFailure onDispatchFailure;
    private final NotifyRequest onAfterDispatch;
    private final NotifyContent onRequestContent;
    private final NotifyRequest onRequestContentEnd;
    private final NotifyRequest onRequestTrailers;
    private final NotifyRequest onRequestEnd;
    private final NotifyFailure onRequestFailure;
    private final NotifyRequest onResponseBegin;
    private final NotifyRequest onResponseCommit;
    private final NotifyContent onResponseContent;
    private final NotifyRequest onResponseEnd;
    private final NotifyFailure onResponseFailure;
    private final NotifyRequest onComplete;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelListeners$NotifyContent.class */
    public interface NotifyContent {
        public static final NotifyContent NOOP = request, content -> {
        };

        void onContent(Request request, ByteBuffer byteBuffer);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelListeners$NotifyFailure.class */
    public interface NotifyFailure {
        public static final NotifyFailure NOOP = request, failure -> {
        };

        void onFailure(Request request, Throwable th);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/HttpChannelListeners$NotifyRequest.class */
    public interface NotifyRequest {
        public static final NotifyRequest NOOP = request -> {
        };

        void onRequest(Request request);
    }

    public HttpChannelListeners(Collection<HttpChannel.Listener> listeners) {
        try {
            NotifyRequest onRequestBegin = NotifyRequest.NOOP;
            NotifyRequest onBeforeDispatch = NotifyRequest.NOOP;
            NotifyFailure onDispatchFailure = NotifyFailure.NOOP;
            NotifyRequest onAfterDispatch = NotifyRequest.NOOP;
            NotifyContent onRequestContent = NotifyContent.NOOP;
            NotifyRequest onRequestContentEnd = NotifyRequest.NOOP;
            NotifyRequest onRequestTrailers = NotifyRequest.NOOP;
            NotifyRequest onRequestEnd = NotifyRequest.NOOP;
            NotifyFailure onRequestFailure = NotifyFailure.NOOP;
            NotifyRequest onResponseBegin = NotifyRequest.NOOP;
            NotifyRequest onResponseCommit = NotifyRequest.NOOP;
            NotifyContent onResponseContent = NotifyContent.NOOP;
            NotifyRequest onResponseEnd = NotifyRequest.NOOP;
            NotifyFailure onResponseFailure = NotifyFailure.NOOP;
            NotifyRequest onComplete = NotifyRequest.NOOP;
            for (HttpChannel.Listener listener : listeners) {
                if (!listener.getClass().getMethod("onRequestBegin", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onRequestBegin = combine(onRequestBegin, this::onRequestBegin);
                }
                if (!listener.getClass().getMethod("onBeforeDispatch", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onBeforeDispatch = combine(onBeforeDispatch, this::onBeforeDispatch);
                }
                if (!listener.getClass().getMethod("onDispatchFailure", Request.class, Throwable.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onDispatchFailure = combine(onDispatchFailure, this::onDispatchFailure);
                }
                if (!listener.getClass().getMethod("onAfterDispatch", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onAfterDispatch = combine(onAfterDispatch, this::onAfterDispatch);
                }
                if (!listener.getClass().getMethod("onRequestContent", Request.class, ByteBuffer.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onRequestContent = combine(onRequestContent, this::onRequestContent);
                }
                if (!listener.getClass().getMethod("onRequestContentEnd", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onRequestContentEnd = combine(onRequestContentEnd, this::onRequestContentEnd);
                }
                if (!listener.getClass().getMethod("onRequestTrailers", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onRequestTrailers = combine(onRequestTrailers, this::onRequestTrailers);
                }
                if (!listener.getClass().getMethod("onRequestEnd", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onRequestEnd = combine(onRequestEnd, this::onRequestEnd);
                }
                if (!listener.getClass().getMethod("onRequestFailure", Request.class, Throwable.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onRequestFailure = combine(onRequestFailure, this::onRequestFailure);
                }
                if (!listener.getClass().getMethod("onResponseBegin", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onResponseBegin = combine(onResponseBegin, this::onResponseBegin);
                }
                if (!listener.getClass().getMethod("onResponseCommit", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onResponseCommit = combine(onResponseCommit, this::onResponseCommit);
                }
                if (!listener.getClass().getMethod("onResponseContent", Request.class, ByteBuffer.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onResponseContent = combine(onResponseContent, this::onResponseContent);
                }
                if (!listener.getClass().getMethod("onResponseEnd", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onResponseEnd = combine(onResponseEnd, this::onResponseEnd);
                }
                if (!listener.getClass().getMethod("onResponseFailure", Request.class, Throwable.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onResponseFailure = combine(onResponseFailure, this::onResponseFailure);
                }
                if (!listener.getClass().getMethod("onComplete", Request.class).isDefault()) {
                    Objects.requireNonNull(listener);
                    onComplete = combine(onComplete, this::onComplete);
                }
            }
            this.onRequestBegin = onRequestBegin;
            this.onBeforeDispatch = onBeforeDispatch;
            this.onDispatchFailure = onDispatchFailure;
            this.onAfterDispatch = onAfterDispatch;
            this.onRequestContent = onRequestContent;
            this.onRequestContentEnd = onRequestContentEnd;
            this.onRequestTrailers = onRequestTrailers;
            this.onRequestEnd = onRequestEnd;
            this.onRequestFailure = onRequestFailure;
            this.onResponseBegin = onResponseBegin;
            this.onResponseCommit = onResponseCommit;
            this.onResponseContent = onResponseContent;
            this.onResponseEnd = onResponseEnd;
            this.onResponseFailure = onResponseFailure;
            this.onComplete = onComplete;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onRequestBegin(Request request) {
        this.onRequestBegin.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onBeforeDispatch(Request request) {
        this.onBeforeDispatch.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onDispatchFailure(Request request, Throwable failure) {
        this.onDispatchFailure.onFailure(request, failure);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onAfterDispatch(Request request) {
        this.onAfterDispatch.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onRequestContent(Request request, ByteBuffer content) {
        this.onRequestContent.onContent(request, content);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onRequestContentEnd(Request request) {
        this.onRequestContentEnd.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onRequestTrailers(Request request) {
        this.onRequestTrailers.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onRequestEnd(Request request) {
        this.onRequestEnd.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onRequestFailure(Request request, Throwable failure) {
        this.onRequestFailure.onFailure(request, failure);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onResponseBegin(Request request) {
        this.onResponseBegin.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onResponseCommit(Request request) {
        this.onResponseCommit.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onResponseContent(Request request, ByteBuffer content) {
        this.onResponseContent.onContent(request, content);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onResponseEnd(Request request) {
        this.onResponseEnd.onRequest(request);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onResponseFailure(Request request, Throwable failure) {
        this.onResponseFailure.onFailure(request, failure);
    }

    @Override // org.eclipse.jetty.server.HttpChannel.Listener
    public void onComplete(Request request) {
        this.onComplete.onRequest(request);
    }

    private static NotifyRequest combine(NotifyRequest first, NotifyRequest second) {
        if (first == NotifyRequest.NOOP) {
            return second;
        }
        if (second == NotifyRequest.NOOP) {
            return first;
        }
        return request -> {
            first.onRequest(request);
            second.onRequest(request);
        };
    }

    private static NotifyFailure combine(NotifyFailure first, NotifyFailure second) {
        if (first == NotifyFailure.NOOP) {
            return second;
        }
        if (second == NotifyFailure.NOOP) {
            return first;
        }
        return request, throwable -> {
            first.onFailure(request, throwable);
            second.onFailure(request, throwable);
        };
    }

    private static NotifyContent combine(NotifyContent first, NotifyContent second) {
        if (first == NotifyContent.NOOP) {
            return request, content -> {
                second.onContent(request, content.slice());
            };
        }
        if (second == NotifyContent.NOOP) {
            return request, content -> {
                first.onContent(request, content.slice());
            };
        }
        return request, content -> {
            ByteBuffer content2 = content.slice();
            first.onContent(request, content2);
            second.onContent(request, content2);
        };
    }
}
