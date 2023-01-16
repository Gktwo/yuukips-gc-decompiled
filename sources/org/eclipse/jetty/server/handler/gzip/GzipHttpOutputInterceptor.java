package org.eclipse.jetty.server.handler.gzip;

import java.nio.ByteBuffer;
import java.nio.channels.WritePendingException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.eclipse.jetty.http.CompressedContentFormat;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpOutput;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.IteratingCallback;
import org.eclipse.jetty.util.IteratingNestedCallback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/gzip/GzipHttpOutputInterceptor.class */
public class GzipHttpOutputInterceptor implements HttpOutput.Interceptor {
    public static Logger LOG = Log.getLogger(GzipHttpOutputInterceptor.class);
    private static final byte[] GZIP_HEADER = {31, -117, 8, 0, 0, 0, 0, 0, 0, 0};
    public static final HttpField VARY_ACCEPT_ENCODING_USER_AGENT = new PreEncodedHttpField(HttpHeader.VARY, HttpHeader.ACCEPT_ENCODING + ", " + HttpHeader.USER_AGENT);
    public static final HttpField VARY_ACCEPT_ENCODING = new PreEncodedHttpField(HttpHeader.VARY, HttpHeader.ACCEPT_ENCODING.asString());
    private final AtomicReference<GZState> _state;
    private final CRC32 _crc;
    private final GzipFactory _factory;
    private final HttpOutput.Interceptor _interceptor;
    private final HttpChannel _channel;
    private final HttpField _vary;
    private final int _bufferSize;
    private final boolean _syncFlush;
    private Deflater _deflater;
    private ByteBuffer _buffer;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/gzip/GzipHttpOutputInterceptor$GZState.class */
    public enum GZState {
        MIGHT_COMPRESS,
        NOT_COMPRESSING,
        COMMITTING,
        COMPRESSING,
        FINISHED
    }

    public GzipHttpOutputInterceptor(GzipFactory factory, HttpChannel channel, HttpOutput.Interceptor next, boolean syncFlush) {
        this(factory, VARY_ACCEPT_ENCODING_USER_AGENT, channel.getHttpConfiguration().getOutputBufferSize(), channel, next, syncFlush);
    }

    public GzipHttpOutputInterceptor(GzipFactory factory, HttpField vary, HttpChannel channel, HttpOutput.Interceptor next, boolean syncFlush) {
        this(factory, vary, channel.getHttpConfiguration().getOutputBufferSize(), channel, next, syncFlush);
    }

    public GzipHttpOutputInterceptor(GzipFactory factory, HttpField vary, int bufferSize, HttpChannel channel, HttpOutput.Interceptor next, boolean syncFlush) {
        this._state = new AtomicReference<>(GZState.MIGHT_COMPRESS);
        this._crc = new CRC32();
        this._factory = factory;
        this._channel = channel;
        this._interceptor = next;
        this._vary = vary;
        this._bufferSize = bufferSize;
        this._syncFlush = syncFlush;
    }

    @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
    public HttpOutput.Interceptor getNextInterceptor() {
        return this._interceptor;
    }

    @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
    public boolean isOptimizedForDirectBuffers() {
        return false;
    }

    @Override // org.eclipse.jetty.server.HttpOutput.Interceptor
    public void write(ByteBuffer content, boolean complete, Callback callback) {
        switch (this._state.get()) {
            case MIGHT_COMPRESS:
                commit(content, complete, callback);
                return;
            case NOT_COMPRESSING:
                this._interceptor.write(content, complete, callback);
                return;
            case COMMITTING:
                callback.failed(new WritePendingException());
                return;
            case COMPRESSING:
                gzip(content, complete, callback);
                return;
            default:
                callback.failed(new IllegalStateException("state=" + this._state.get()));
                return;
        }
    }

    /* access modifiers changed from: private */
    public void addTrailer() {
        BufferUtil.putIntLittleEndian(this._buffer, (int) this._crc.getValue());
        BufferUtil.putIntLittleEndian(this._buffer, this._deflater.getTotalIn());
    }

    private void gzip(ByteBuffer content, boolean complete, Callback callback) {
        if (content.hasRemaining() || complete) {
            new GzipBufferCB(content, complete, callback).iterate();
        } else {
            callback.succeeded();
        }
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    protected void commit(ByteBuffer content, boolean complete, Callback callback) {
        Response response = this._channel.getResponse();
        int sc = response.getStatus();
        if (sc <= 0 || (sc >= 200 && sc != 204 && sc != 205 && sc < 300)) {
            String ct = response.getContentType();
            if (ct == null || this._factory.isMimeTypeGzipable(HttpFields.valueParameters(ct, null))) {
                HttpFields fields = response.getHttpFields();
                String ce = fields.get(HttpHeader.CONTENT_ENCODING);
                if (ce != null) {
                    LOG.debug("{} exclude by content-encoding {}", this, ce);
                    noCompression();
                    this._interceptor.write(content, complete, callback);
                } else if (this._state.compareAndSet(GZState.MIGHT_COMPRESS, GZState.COMMITTING)) {
                    if (this._vary != null) {
                        if (fields.contains(HttpHeader.VARY)) {
                            fields.addCSV(HttpHeader.VARY, this._vary.getValues());
                        } else {
                            fields.add(this._vary);
                        }
                    }
                    char contentLength = response.getContentLength();
                    int i = (contentLength > 0 ? 1 : (contentLength == 0 ? 0 : -1));
                    long contentLength2 = contentLength;
                    if (i < 0) {
                        contentLength2 = contentLength;
                        if (complete) {
                            contentLength2 = (long) content.remaining();
                        }
                    }
                    this._deflater = this._factory.getDeflater(this._channel.getRequest(), contentLength2 == 1 ? 1 : 0);
                    if (this._deflater == null) {
                        LOG.debug("{} exclude no deflater", this);
                        this._state.set(GZState.NOT_COMPRESSING);
                        this._interceptor.write(content, complete, callback);
                        return;
                    }
                    fields.put(CompressedContentFormat.GZIP.getContentEncoding());
                    this._crc.reset();
                    response.setContentLength(-1);
                    String etag = fields.get(HttpHeader.ETAG);
                    if (etag != null) {
                        fields.put(HttpHeader.ETAG, etagGzip(etag));
                    }
                    LOG.debug("{} compressing {}", this, this._deflater);
                    this._state.set(GZState.COMPRESSING);
                    if (BufferUtil.isEmpty(content)) {
                        this._interceptor.write(BufferUtil.EMPTY_BUFFER, complete, callback);
                    } else {
                        gzip(content, complete, callback);
                    }
                } else {
                    callback.failed(new WritePendingException());
                }
            } else {
                LOG.debug("{} exclude by mimeType {}", this, ct);
                noCompression();
                this._interceptor.write(content, complete, callback);
            }
        } else {
            LOG.debug("{} exclude by status {}", this, Integer.valueOf(sc));
            noCompression();
            if (sc == 304) {
                String requestEtags = (String) this._channel.getRequest().getAttribute(GzipHandler.GZIP_HANDLER_ETAGS);
                String responseEtag = response.getHttpFields().get(HttpHeader.ETAG);
                if (!(requestEtags == null || responseEtag == null)) {
                    String responseEtagGzip = etagGzip(responseEtag);
                    if (requestEtags.contains(responseEtagGzip)) {
                        response.getHttpFields().put(HttpHeader.ETAG, responseEtagGzip);
                    }
                }
            }
            this._interceptor.write(content, complete, callback);
        }
    }

    private String etagGzip(String etag) {
        return CompressedContentFormat.GZIP.etag(etag);
    }

    public void noCompression() {
        do {
            switch (this._state.get()) {
                case MIGHT_COMPRESS:
                    break;
                case NOT_COMPRESSING:
                    return;
                default:
                    throw new IllegalStateException(this._state.get().toString());
            }
        } while (!this._state.compareAndSet(GZState.MIGHT_COMPRESS, GZState.NOT_COMPRESSING));
    }

    public void noCompressionIfPossible() {
        do {
            switch (this._state.get()) {
                case MIGHT_COMPRESS:
                    break;
                case NOT_COMPRESSING:
                case COMPRESSING:
                    return;
                case COMMITTING:
                default:
                    throw new IllegalStateException(this._state.get().toString());
            }
        } while (!this._state.compareAndSet(GZState.MIGHT_COMPRESS, GZState.NOT_COMPRESSING));
    }

    public boolean mightCompress() {
        return this._state.get() == GZState.MIGHT_COMPRESS;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/gzip/GzipHttpOutputInterceptor$GzipBufferCB.class */
    public class GzipBufferCB extends IteratingNestedCallback {
        private ByteBuffer _copy;
        private final ByteBuffer _content;
        private final boolean _last;

        public GzipBufferCB(ByteBuffer content, boolean complete, Callback callback) {
            super(callback);
            this._content = content;
            this._last = complete;
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.IteratingNestedCallback, org.eclipse.jetty.util.IteratingCallback
        public void onCompleteFailure(Throwable x) {
            GzipHttpOutputInterceptor.this._factory.recycle(GzipHttpOutputInterceptor.this._deflater);
            GzipHttpOutputInterceptor.this._deflater = null;
            onCompleteFailure(x);
        }

        @Override // org.eclipse.jetty.util.IteratingCallback
        protected IteratingCallback.Action process() throws Exception {
            ByteBuffer slice;
            if (GzipHttpOutputInterceptor.this._deflater == null) {
                if (GzipHttpOutputInterceptor.this._buffer != null) {
                    GzipHttpOutputInterceptor.this._channel.getByteBufferPool().release(GzipHttpOutputInterceptor.this._buffer);
                    GzipHttpOutputInterceptor.this._buffer = null;
                }
                if (this._copy != null) {
                    GzipHttpOutputInterceptor.this._channel.getByteBufferPool().release(this._copy);
                    this._copy = null;
                }
                return IteratingCallback.Action.SUCCEEDED;
            }
            if (GzipHttpOutputInterceptor.this._buffer == null) {
                GzipHttpOutputInterceptor.this._buffer = GzipHttpOutputInterceptor.this._channel.getByteBufferPool().acquire(GzipHttpOutputInterceptor.this._bufferSize, false);
                BufferUtil.fill(GzipHttpOutputInterceptor.this._buffer, GzipHttpOutputInterceptor.GZIP_HEADER, 0, GzipHttpOutputInterceptor.GZIP_HEADER.length);
            } else {
                BufferUtil.clear(GzipHttpOutputInterceptor.this._buffer);
            }
            if (!GzipHttpOutputInterceptor.this._deflater.finished()) {
                if (GzipHttpOutputInterceptor.this._deflater.needsInput()) {
                    if (!BufferUtil.isEmpty(this._content)) {
                        if (this._content.hasArray()) {
                            slice = this._content;
                        } else {
                            if (this._copy == null) {
                                this._copy = GzipHttpOutputInterceptor.this._channel.getByteBufferPool().acquire(GzipHttpOutputInterceptor.this._bufferSize, false);
                            } else {
                                BufferUtil.clear(this._copy);
                            }
                            slice = this._copy;
                            BufferUtil.append(this._copy, this._content);
                        }
                        byte[] array = slice.array();
                        int off = slice.arrayOffset() + slice.position();
                        int len = slice.remaining();
                        GzipHttpOutputInterceptor.this._crc.update(array, off, len);
                        GzipHttpOutputInterceptor.this._deflater.setInput(array, off, len);
                        slice.position(slice.position() + len);
                        if (this._last && BufferUtil.isEmpty(this._content)) {
                            GzipHttpOutputInterceptor.this._deflater.finish();
                        }
                    } else if (!this._last) {
                        return IteratingCallback.Action.SUCCEEDED;
                    } else {
                        GzipHttpOutputInterceptor.this._deflater.finish();
                    }
                }
                GzipHttpOutputInterceptor.this._buffer.limit(GzipHttpOutputInterceptor.this._buffer.limit() + GzipHttpOutputInterceptor.this._deflater.deflate(GzipHttpOutputInterceptor.this._buffer.array(), GzipHttpOutputInterceptor.this._buffer.arrayOffset() + GzipHttpOutputInterceptor.this._buffer.limit(), BufferUtil.space(GzipHttpOutputInterceptor.this._buffer), GzipHttpOutputInterceptor.this._syncFlush ? 2 : 0));
            }
            if (GzipHttpOutputInterceptor.this._deflater.finished() && BufferUtil.space(GzipHttpOutputInterceptor.this._buffer) >= 8) {
                GzipHttpOutputInterceptor.this.addTrailer();
                GzipHttpOutputInterceptor.this._factory.recycle(GzipHttpOutputInterceptor.this._deflater);
                GzipHttpOutputInterceptor.this._deflater = null;
            }
            GzipHttpOutputInterceptor.this._interceptor.write(GzipHttpOutputInterceptor.this._buffer, GzipHttpOutputInterceptor.this._deflater == null, this);
            return IteratingCallback.Action.SCHEDULED;
        }

        @Override // org.eclipse.jetty.util.IteratingNestedCallback, org.eclipse.jetty.util.IteratingCallback
        public String toString() {
            Object[] objArr = new Object[7];
            objArr[0] = toString();
            objArr[1] = BufferUtil.toDetailString(this._content);
            objArr[2] = Boolean.valueOf(this._last);
            objArr[3] = BufferUtil.toDetailString(this._copy);
            objArr[4] = BufferUtil.toDetailString(GzipHttpOutputInterceptor.this._buffer);
            objArr[5] = GzipHttpOutputInterceptor.this._deflater;
            objArr[6] = (GzipHttpOutputInterceptor.this._deflater == null || !GzipHttpOutputInterceptor.this._deflater.finished()) ? "" : "(finished)";
            return String.format("%s[content=%s last=%b copy=%s buffer=%s deflate=%s %s]", objArr);
        }
    }
}
