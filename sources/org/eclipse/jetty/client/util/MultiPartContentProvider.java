package org.eclipse.jetty.client.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jetty.client.AsyncContentProvider;
import org.eclipse.jetty.client.Synchronizable;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.p023io.RuntimeIOException;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/MultiPartContentProvider.class */
public class MultiPartContentProvider extends AbstractTypedContentProvider implements AsyncContentProvider, Closeable {
    private static final Logger LOG = Log.getLogger(MultiPartContentProvider.class);
    private static final byte[] COLON_SPACE_BYTES = {58, 32};
    private static final byte[] CR_LF_BYTES = {13, 10};
    private final List<Part> parts;
    private final ByteBuffer firstBoundary;
    private final ByteBuffer middleBoundary;
    private final ByteBuffer onlyBoundary;
    private final ByteBuffer lastBoundary;
    private final AtomicBoolean closed;
    private AsyncContentProvider.Listener listener;
    private long length;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/MultiPartContentProvider$State.class */
    public enum State {
        FIRST_BOUNDARY,
        HEADERS,
        CONTENT,
        MIDDLE_BOUNDARY,
        LAST_BOUNDARY,
        COMPLETE
    }

    public MultiPartContentProvider() {
        this(makeBoundary());
    }

    public MultiPartContentProvider(String boundary) {
        super("multipart/form-data; boundary=" + boundary);
        this.parts = new ArrayList();
        this.closed = new AtomicBoolean();
        this.length = -1;
        String firstBoundaryLine = "--" + boundary + "\r\n";
        this.firstBoundary = ByteBuffer.wrap(firstBoundaryLine.getBytes(StandardCharsets.US_ASCII));
        this.middleBoundary = ByteBuffer.wrap(("\r\n" + firstBoundaryLine).getBytes(StandardCharsets.US_ASCII));
        String onlyBoundaryLine = "--" + boundary + "--\r\n";
        this.onlyBoundary = ByteBuffer.wrap(onlyBoundaryLine.getBytes(StandardCharsets.US_ASCII));
        this.lastBoundary = ByteBuffer.wrap(("\r\n" + onlyBoundaryLine).getBytes(StandardCharsets.US_ASCII));
    }

    private static String makeBoundary() {
        StringBuilder builder = new StringBuilder("JettyHttpClientBoundary");
        builder.append(Long.toString((long) System.identityHashCode(builder), 36));
        builder.append(Long.toString((long) System.identityHashCode(Thread.currentThread()), 36));
        builder.append(Long.toString(System.nanoTime(), 36));
        return builder.toString();
    }

    public void addFieldPart(String name, ContentProvider content, HttpFields fields) {
        addPart(new Part(name, null, ContentType.PLAIN, content, fields));
    }

    public void addFilePart(String name, String fileName, ContentProvider content, HttpFields fields) {
        addPart(new Part(name, fileName, ContentType.OCTET_STREAM, content, fields));
    }

    private void addPart(Part part) {
        this.parts.add(part);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Added {}", part);
        }
    }

    @Override // org.eclipse.jetty.client.AsyncContentProvider
    public void setListener(AsyncContentProvider.Listener listener) {
        this.listener = listener;
        if (this.closed.get()) {
            this.length = calculateLength();
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    private long calculateLength() {
        if (this.parts.isEmpty()) {
            return (long) this.onlyBoundary.remaining();
        }
        char c = 0;
        int i = 0;
        while (true) {
            if (i >= this.parts.size()) {
                break;
            }
            long remaining = i == 0 ? (long) this.firstBoundary.remaining() : (long) this.middleBoundary.remaining();
            long partLength = this.parts.get(i).length;
            c = c + remaining + partLength;
            if (partLength < 0) {
                c = 65535;
                break;
            }
            i++;
        }
        if (c > 0) {
            c += (long) this.lastBoundary.remaining();
        }
        return c;
    }

    @Override // org.eclipse.jetty.client.api.ContentProvider
    public long getLength() {
        return this.length;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return new MultiPartIterator();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed.compareAndSet(false, true);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/MultiPartContentProvider$Part.class */
    public static class Part {
        private final String name;
        private final String fileName;
        private final String contentType;
        private final ContentProvider content;
        private final HttpFields fields;
        private final ByteBuffer headers;
        private final long length;

        private Part(String name, String fileName, String contentType, ContentProvider content, HttpFields fields) {
            this.name = name;
            this.fileName = fileName;
            this.contentType = contentType;
            this.content = content;
            this.fields = fields;
            this.headers = headers();
            this.length = content.getLength() < 0 ? -1 : ((long) this.headers.remaining()) + content.getLength();
        }

        private ByteBuffer headers() {
            try {
                String contentDisposition = "Content-Disposition: form-data; name=\"" + this.name + "\"";
                if (this.fileName != null) {
                    contentDisposition = contentDisposition + "; filename=\"" + this.fileName + "\"";
                }
                String contentDisposition2 = contentDisposition + "\r\n";
                String contentType = this.fields == null ? null : this.fields.get(HttpHeader.CONTENT_TYPE);
                if (contentType == null) {
                    if (this.content instanceof ContentProvider.Typed) {
                        contentType = ((ContentProvider.Typed) this.content).getContentType();
                    } else {
                        contentType = this.contentType;
                    }
                }
                String contentType2 = "Content-Type: " + contentType + "\r\n";
                if (this.fields == null || this.fields.size() == 0) {
                    return ByteBuffer.wrap(((contentDisposition2 + contentType2) + "\r\n").getBytes(StandardCharsets.UTF_8));
                }
                ByteArrayOutputStream buffer = new ByteArrayOutputStream((this.fields.size() + 1) * contentDisposition2.length());
                buffer.write(contentDisposition2.getBytes(StandardCharsets.UTF_8));
                buffer.write(contentType2.getBytes(StandardCharsets.UTF_8));
                Iterator<HttpField> it = this.fields.iterator();
                while (it.hasNext()) {
                    HttpField field = it.next();
                    if (!HttpHeader.CONTENT_TYPE.equals(field.getHeader())) {
                        buffer.write(field.getName().getBytes(StandardCharsets.US_ASCII));
                        buffer.write(MultiPartContentProvider.COLON_SPACE_BYTES);
                        String value = field.getValue();
                        if (value != null) {
                            buffer.write(value.getBytes(StandardCharsets.UTF_8));
                        }
                        buffer.write(MultiPartContentProvider.CR_LF_BYTES);
                    }
                }
                buffer.write(MultiPartContentProvider.CR_LF_BYTES);
                return ByteBuffer.wrap(buffer.toByteArray());
            } catch (IOException x) {
                throw new RuntimeIOException(x);
            }
        }

        public String toString() {
            return String.format("%s@%x[name=%s,fileName=%s,length=%d,headers=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.name, this.fileName, Long.valueOf(this.content.getLength()), this.fields);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/MultiPartContentProvider$MultiPartIterator.class */
    private class MultiPartIterator implements Iterator<ByteBuffer>, Synchronizable, Callback, Closeable {
        private Iterator<ByteBuffer> iterator;
        private int index;
        private State state;

        private MultiPartIterator() {
            this.state = State.FIRST_BOUNDARY;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.state != State.COMPLETE;
        }

        @Override // java.util.Iterator
        public ByteBuffer next() {
            while (true) {
                switch (this.state) {
                    case FIRST_BOUNDARY:
                        if (MultiPartContentProvider.this.parts.isEmpty()) {
                            this.state = State.COMPLETE;
                            return MultiPartContentProvider.this.onlyBoundary.slice();
                        }
                        this.state = State.HEADERS;
                        return MultiPartContentProvider.this.firstBoundary.slice();
                    case HEADERS:
                        Part part = (Part) MultiPartContentProvider.this.parts.get(this.index);
                        ContentProvider content = part.content;
                        if (content instanceof AsyncContentProvider) {
                            ((AsyncContentProvider) content).setListener(MultiPartContentProvider.this.listener);
                        }
                        this.iterator = content.iterator();
                        this.state = State.CONTENT;
                        return part.headers.slice();
                    case CONTENT:
                        if (!this.iterator.hasNext()) {
                            this.index++;
                            if (this.index >= MultiPartContentProvider.this.parts.size()) {
                                this.state = State.LAST_BOUNDARY;
                                break;
                            } else {
                                this.state = State.MIDDLE_BOUNDARY;
                                if (!(this.iterator instanceof Closeable)) {
                                    break;
                                } else {
                                    C5739IO.close((Closeable) this.iterator);
                                    break;
                                }
                            }
                        } else {
                            return this.iterator.next();
                        }
                    case MIDDLE_BOUNDARY:
                        this.state = State.HEADERS;
                        return MultiPartContentProvider.this.middleBoundary.slice();
                    case LAST_BOUNDARY:
                        this.state = State.COMPLETE;
                        return MultiPartContentProvider.this.lastBoundary.slice();
                    case COMPLETE:
                        throw new NoSuchElementException();
                }
            }
        }

        @Override // org.eclipse.jetty.client.Synchronizable
        public Object getLock() {
            if (this.iterator instanceof Synchronizable) {
                return ((Synchronizable) this.iterator).getLock();
            }
            return this;
        }

        @Override // org.eclipse.jetty.util.Callback
        public void succeeded() {
            if (this.state == State.CONTENT && (this.iterator instanceof Callback)) {
                ((Callback) this.iterator).succeeded();
            }
        }

        @Override // org.eclipse.jetty.util.Callback
        public void failed(Throwable x) {
            if (this.state == State.CONTENT && (this.iterator instanceof Callback)) {
                ((Callback) this.iterator).failed(x);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.iterator instanceof Closeable) {
                ((Closeable) this.iterator).close();
            }
        }
    }
}
