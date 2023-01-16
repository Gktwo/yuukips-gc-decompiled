package org.eclipse.jetty.client.util;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/BytesContentProvider.class */
public class BytesContentProvider extends AbstractTypedContentProvider {
    private final byte[][] bytes;
    private final long length;

    public BytesContentProvider(byte[]... bytes) {
        this(ContentType.OCTET_STREAM, bytes);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public BytesContentProvider(String contentType, byte[]... bytes) {
        super(contentType);
        this.bytes = bytes;
        char c = 0;
        for (byte[] buffer : bytes) {
            c += (long) buffer.length;
        }
        this.length = c;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public long getLength() {
        return this.length;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public boolean isReproducible() {
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return new Iterator<ByteBuffer>() { // from class: org.eclipse.jetty.client.util.BytesContentProvider.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < BytesContentProvider.this.bytes.length;
            }

            @Override // java.util.Iterator
            public ByteBuffer next() {
                try {
                    byte[][] bArr = BytesContentProvider.this.bytes;
                    int i = this.index;
                    this.index = i + 1;
                    return ByteBuffer.wrap(bArr[i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
