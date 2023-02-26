package org.eclipse.jetty.client;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.jline.builtins.Tmux;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/HttpContent.class */
public class HttpContent implements Callback, Closeable {
    private static final Logger LOG = Log.getLogger(HttpContent.class);
    private static final ByteBuffer AFTER = ByteBuffer.allocate(0);
    private static final ByteBuffer CLOSE = ByteBuffer.allocate(0);
    private final ContentProvider provider;
    private final Iterator<ByteBuffer> iterator;
    private ByteBuffer buffer;
    private ByteBuffer content;
    private boolean last;

    public HttpContent(ContentProvider provider) {
        this.provider = provider;
        this.iterator = provider == null ? Collections.emptyIterator() : provider.iterator();
    }

    private static boolean isTheCloseBuffer(ByteBuffer buffer) {
        return buffer == CLOSE;
    }

    public boolean hasContent() {
        return this.provider != null;
    }

    public boolean isLast() {
        return this.last;
    }

    public ByteBuffer getByteBuffer() {
        return this.buffer;
    }

    public ByteBuffer getContent() {
        return this.content;
    }

    public boolean advance() {
        boolean advance;
        if (!(this.iterator instanceof Synchronizable)) {
            return advance(this.iterator);
        }
        synchronized (((Synchronizable) this.iterator).getLock()) {
            advance = advance(this.iterator);
        }
        return advance;
    }

    private boolean advance(Iterator<ByteBuffer> iterator) {
        boolean hasNext = iterator.hasNext();
        ByteBuffer bytes = hasNext ? iterator.next() : null;
        boolean hasMore = hasNext && iterator.hasNext();
        boolean wasLast = this.last;
        this.last = !hasMore;
        if (hasNext) {
            this.buffer = bytes;
            this.content = bytes == null ? null : bytes.slice();
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                Object[] objArr = new Object[2];
                objArr[0] = hasMore ? Tmux.CMD_NEXT : "last";
                objArr[1] = String.valueOf(bytes);
                logger.debug("Advanced content to {} chunk {}", objArr);
            }
            return bytes != null;
        } else if (wasLast) {
            ByteBuffer byteBuffer = AFTER;
            this.content = byteBuffer;
            this.buffer = byteBuffer;
            if (!LOG.isDebugEnabled()) {
                return false;
            }
            LOG.debug("Advanced content past last chunk", new Object[0]);
            return false;
        } else {
            ByteBuffer byteBuffer2 = CLOSE;
            this.content = byteBuffer2;
            this.buffer = byteBuffer2;
            if (!LOG.isDebugEnabled()) {
                return false;
            }
            LOG.debug("Advanced content to last chunk", new Object[0]);
            return false;
        }
    }

    public boolean isConsumed() {
        return this.buffer == AFTER;
    }

    @Override // org.eclipse.jetty.util.Callback
    public void succeeded() {
        if (!isConsumed() && !isTheCloseBuffer(this.buffer) && (this.iterator instanceof Callback)) {
            ((Callback) this.iterator).succeeded();
        }
    }

    @Override // org.eclipse.jetty.util.Callback
    public void failed(Throwable x) {
        if (!isConsumed() && !isTheCloseBuffer(this.buffer) && (this.iterator instanceof Callback)) {
            ((Callback) this.iterator).failed(x);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.iterator instanceof Closeable) {
            C5739IO.close((Closeable) this.iterator);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("%s@%x - has=%b,last=%b,consumed=%b,buffer=%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Boolean.valueOf(hasContent()), Boolean.valueOf(isLast()), Boolean.valueOf(isConsumed()), BufferUtil.toDetailString(getContent()));
    }
}
