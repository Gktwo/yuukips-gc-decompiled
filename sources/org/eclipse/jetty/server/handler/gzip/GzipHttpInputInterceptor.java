package org.eclipse.jetty.server.handler.gzip;

import java.nio.ByteBuffer;
import org.eclipse.jetty.http.GZIPContentDecoder;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.server.HttpInput;
import org.eclipse.jetty.util.component.Destroyable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/gzip/GzipHttpInputInterceptor.class */
public class GzipHttpInputInterceptor implements HttpInput.Interceptor, Destroyable {
    private final Decoder _decoder;
    private ByteBuffer _chunk;

    public GzipHttpInputInterceptor(ByteBufferPool pool, int bufferSize) {
        this._decoder = new Decoder(pool, bufferSize);
    }

    @Override // org.eclipse.jetty.server.HttpInput.Interceptor
    public HttpInput.Content readFrom(HttpInput.Content content) {
        this._decoder.decodeChunks(content.getByteBuffer());
        final ByteBuffer chunk = this._chunk;
        if (chunk == null) {
            return null;
        }
        return new HttpInput.Content(chunk) { // from class: org.eclipse.jetty.server.handler.gzip.GzipHttpInputInterceptor.1
            @Override // org.eclipse.jetty.util.Callback
            public void succeeded() {
                GzipHttpInputInterceptor.this._decoder.release(chunk);
            }

            @Override // org.eclipse.jetty.util.Callback
            public void failed(Throwable x) {
                GzipHttpInputInterceptor.this._decoder.release(chunk);
            }
        };
    }

    @Override // org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        this._decoder.destroy();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/gzip/GzipHttpInputInterceptor$Decoder.class */
    public class Decoder extends GZIPContentDecoder {
        private Decoder(ByteBufferPool pool, int bufferSize) {
            super(pool, bufferSize);
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.http.GZIPContentDecoder
        public boolean decodedChunk(ByteBuffer chunk) {
            GzipHttpInputInterceptor.this._chunk = chunk;
            return true;
        }

        @Override // org.eclipse.jetty.http.GZIPContentDecoder
        public void decodeChunks(ByteBuffer compressed) {
            GzipHttpInputInterceptor.this._chunk = null;
            decodeChunks(compressed);
        }
    }
}
