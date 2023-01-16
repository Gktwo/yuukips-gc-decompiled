package org.eclipse.jetty.client.util;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/ByteBufferContentProvider.class */
public class ByteBufferContentProvider extends AbstractTypedContentProvider {
    private final ByteBuffer[] buffers;
    private final int length;

    public ByteBufferContentProvider(ByteBuffer... buffers) {
        this(ContentType.OCTET_STREAM, buffers);
    }

    public ByteBufferContentProvider(String contentType, ByteBuffer... buffers) {
        super(contentType);
        this.buffers = buffers;
        int length = 0;
        for (ByteBuffer buffer : buffers) {
            length += buffer.remaining();
        }
        this.length = length;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public long getLength() {
        return (long) this.length;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public boolean isReproducible() {
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return new Iterator<ByteBuffer>() { // from class: org.eclipse.jetty.client.util.ByteBufferContentProvider.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < ByteBufferContentProvider.this.buffers.length;
            }

            @Override // java.util.Iterator
            public ByteBuffer next() {
                try {
                    ByteBuffer buffer = ByteBufferContentProvider.this.buffers[this.index];
                    ByteBufferContentProvider.this.buffers[this.index] = buffer.slice();
                    this.index++;
                    return buffer;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
