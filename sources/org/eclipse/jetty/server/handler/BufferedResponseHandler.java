package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.pathmap.PathSpecSet;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.IncludeExclude;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/BufferedResponseHandler.class */
public class BufferedResponseHandler extends HandlerWrapper {
    private static final Logger LOG = Log.getLogger(BufferedResponseHandler.class);
    private final IncludeExclude<String> _methods = new IncludeExclude<>();
    private final IncludeExclude<String> _paths = new IncludeExclude<>(PathSpecSet.class);
    private final IncludeExclude<String> _mimeTypes = new IncludeExclude<>();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/BufferedResponseHandler$BufferedInterceptor.class */
    protected interface BufferedInterceptor extends HttpOutput.Interceptor {
    }

    public BufferedResponseHandler() {
        this._methods.include((IncludeExclude<String>) HttpMethod.GET.asString());
        for (String type : MimeTypes.getKnownMimeTypes()) {
            if (type.startsWith("image/") || type.startsWith("audio/") || type.startsWith("video/")) {
                this._mimeTypes.exclude((IncludeExclude<String>) type);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} mime types {}", this, this._mimeTypes);
        }
    }

    public IncludeExclude<String> getMethodIncludeExclude() {
        return this._methods;
    }

    public IncludeExclude<String> getPathIncludeExclude() {
        return this._paths;
    }

    public IncludeExclude<String> getMimeIncludeExclude() {
        return this._mimeTypes;
    }

    protected boolean isMimeTypeBufferable(String mimetype) {
        return this._mimeTypes.test(mimetype);
    }

    protected boolean isPathBufferable(String requestURI) {
        if (requestURI == null) {
            return true;
        }
        return this._paths.test(requestURI);
    }

    protected boolean shouldBuffer(HttpChannel channel, boolean last) {
        if (last) {
            return false;
        }
        Response response = channel.getResponse();
        int status = response.getStatus();
        if (HttpStatus.hasNoBody(status) || HttpStatus.isRedirection(status)) {
            return false;
        }
        String ct = response.getContentType();
        if (ct == null) {
            return true;
        }
        return isMimeTypeBufferable(StringUtil.asciiToLowerCase(MimeTypes.getContentTypeWithoutCharset(ct)));
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = baseRequest.getServletContext();
        String path = context == null ? baseRequest.getRequestURI() : URIUtil.addPaths(baseRequest.getServletPath(), baseRequest.getPathInfo());
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} handle {} in {}", this, baseRequest, context);
        }
        HttpOutput out = baseRequest.getResponse().getHttpOutput();
        for (HttpOutput.Interceptor interceptor = out.getInterceptor(); interceptor != null; interceptor = interceptor.getNextInterceptor()) {
            if (interceptor instanceof BufferedInterceptor) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("{} already intercepting {}", this, request);
                }
                this._handler.handle(target, baseRequest, request, response);
                return;
            }
        }
        if (!this._methods.test(baseRequest.getMethod())) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} excluded by method {}", this, request);
            }
            this._handler.handle(target, baseRequest, request, response);
        } else if (!isPathBufferable(path)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} excluded by path {}", this, request);
            }
            this._handler.handle(target, baseRequest, request, response);
        } else {
            String mimeType = context == null ? MimeTypes.getDefaultMimeByExtension(path) : context.getMimeType(path);
            if (mimeType == null || isMimeTypeBufferable(MimeTypes.getContentTypeWithoutCharset(mimeType))) {
                out.setInterceptor(newBufferedInterceptor(baseRequest.getHttpChannel(), out.getInterceptor()));
                if (this._handler != null) {
                    this._handler.handle(target, baseRequest, request, response);
                    return;
                }
                return;
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("{} excluded by path suffix mime type {}", this, request);
            }
            this._handler.handle(target, baseRequest, request, response);
        }
    }

    protected BufferedInterceptor newBufferedInterceptor(HttpChannel httpChannel, HttpOutput.Interceptor interceptor) {
        return new ArrayBufferedInterceptor(httpChannel, interceptor);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/BufferedResponseHandler$ArrayBufferedInterceptor.class */
    public class ArrayBufferedInterceptor implements BufferedInterceptor {
        private final HttpOutput.Interceptor _next;
        private final HttpChannel _channel;
        private final Queue<ByteBuffer> _buffers = new ArrayDeque();
        private Boolean _aggregating;
        private ByteBuffer _aggregate;

        public ArrayBufferedInterceptor(HttpChannel httpChannel, HttpOutput.Interceptor interceptor) {
            this._next = interceptor;
            this._channel = httpChannel;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public HttpOutput.Interceptor getNextInterceptor() {
            return this._next;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public boolean isOptimizedForDirectBuffers() {
            return false;
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public void resetBuffer() {
            this._buffers.clear();
            this._aggregating = null;
            this._aggregate = null;
            resetBuffer();
        }

        @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
        public void write(ByteBuffer content, boolean last, Callback callback) {
            if (BufferedResponseHandler.LOG.isDebugEnabled()) {
                BufferedResponseHandler.LOG.debug("{} write last={} {}", this, Boolean.valueOf(last), BufferUtil.toDetailString(content));
            }
            if (this._aggregating == null) {
                this._aggregating = Boolean.valueOf(BufferedResponseHandler.this.shouldBuffer(this._channel, last));
            }
            if (!this._aggregating.booleanValue()) {
                getNextInterceptor().write(content, last, callback);
            } else if (last) {
                if (BufferUtil.length(content) > 0) {
                    this._buffers.offer(content);
                }
                if (BufferedResponseHandler.LOG.isDebugEnabled()) {
                    BufferedResponseHandler.LOG.debug("{} committing {}", this, Integer.valueOf(this._buffers.size()));
                }
                commit(callback);
            } else {
                if (BufferedResponseHandler.LOG.isDebugEnabled()) {
                    BufferedResponseHandler.LOG.debug("{} aggregating", this);
                }
                while (BufferUtil.hasContent(content)) {
                    if (BufferUtil.space(this._aggregate) == 0) {
                        this._aggregate = BufferUtil.allocate(Math.max(this._channel.getHttpConfiguration().getOutputBufferSize(), BufferUtil.length(content)));
                        this._buffers.offer(this._aggregate);
                    }
                    BufferUtil.append(this._aggregate, content);
                }
                callback.succeeded();
            }
        }

        private void commit(final Callback callback) {
            if (this._buffers.size() == 0) {
                getNextInterceptor().write(BufferUtil.EMPTY_BUFFER, true, callback);
            } else if (this._buffers.size() == 1) {
                getNextInterceptor().write(this._buffers.poll(), true, callback);
            } else {
                new IteratingCallback() { // from class: org.eclipse.jetty.server.handler.BufferedResponseHandler.ArrayBufferedInterceptor.1
                    @Override // org.eclipse.jetty.util.IteratingCallback
                    protected IteratingCallback.Action process() {
                        ByteBuffer buffer = (ByteBuffer) ArrayBufferedInterceptor.this._buffers.poll();
                        if (buffer == null) {
                            return IteratingCallback.Action.SUCCEEDED;
                        }
                        ArrayBufferedInterceptor.this.getNextInterceptor().write(buffer, ArrayBufferedInterceptor.this._buffers.isEmpty(), this);
                        return IteratingCallback.Action.SCHEDULED;
                    }

                    /* access modifiers changed from: protected */
                    @Override // org.eclipse.jetty.util.IteratingCallback
                    public void onCompleteSuccess() {
                        callback.succeeded();
                    }

                    /* access modifiers changed from: protected */
                    @Override // org.eclipse.jetty.util.IteratingCallback
                    public void onCompleteFailure(Throwable cause) {
                        callback.failed(cause);
                    }
                }.iterate();
            }
        }
    }
}
