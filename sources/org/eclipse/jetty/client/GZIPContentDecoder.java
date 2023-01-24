package org.eclipse.jetty.client;

import java.nio.ByteBuffer;
import org.eclipse.jetty.client.ContentDecoder;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/GZIPContentDecoder.class */
public class GZIPContentDecoder extends org.eclipse.jetty.http.GZIPContentDecoder implements ContentDecoder {
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public GZIPContentDecoder() {
        this(8192);
    }

    public GZIPContentDecoder(int bufferSize) {
        this(null, bufferSize);
    }

    public GZIPContentDecoder(ByteBufferPool byteBufferPool, int bufferSize) {
        super(byteBufferPool, bufferSize);
    }

    @Override // org.eclipse.jetty.http.GZIPContentDecoder
    protected boolean decodedChunk(ByteBuffer chunk) {
        decodedChunk(chunk);
        return true;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/GZIPContentDecoder$Factory.class */
    public static class Factory extends ContentDecoder.Factory {
        private final int bufferSize;
        private final ByteBufferPool byteBufferPool;

        public Factory() {
            this(8192);
        }

        public Factory(int bufferSize) {
            this(null, bufferSize);
        }

        public Factory(ByteBufferPool byteBufferPool) {
            this(byteBufferPool, 8192);
        }

        public Factory(ByteBufferPool byteBufferPool, int bufferSize) {
            super(GzipHandler.GZIP);
            this.byteBufferPool = byteBufferPool;
            this.bufferSize = bufferSize;
        }

        @Override // org.eclipse.jetty.client.ContentDecoder.Factory
        public ContentDecoder newContentDecoder() {
            return new GZIPContentDecoder(this.byteBufferPool, this.bufferSize);
        }
    }
}
