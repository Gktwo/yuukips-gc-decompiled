package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: InflaterSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0018"}, m373d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readOrInflate", "refill", "releaseBytesAfterInflate", "timeout", "Lokio/Timeout;", "okio"})
/* loaded from: grasscutter.jar:okio/InflaterSource.class */
public final class InflaterSource implements Source {
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final Inflater inflater;
    private int bufferBytesHeldByInflater;
    private boolean closed;

    public InflaterSource(@NotNull BufferedSource source, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(@NotNull Source source, @NotNull Inflater inflater) {
        this(Okio.buffer(source), inflater);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            long bytesInflated = readOrInflate(sink, byteCount);
            if (bytesInflated > 0) {
                return bytesInflated;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(@NotNull Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (byteCount == 0) {
            return 0;
        } else {
            try {
                Segment tail = sink.writableSegment$okio(1);
                int toRead = (int) Math.min(byteCount, (long) (8192 - tail.limit));
                refill();
                int bytesInflated = this.inflater.inflate(tail.data, tail.limit, toRead);
                releaseBytesAfterInflate();
                if (bytesInflated > 0) {
                    tail.limit += bytesInflated;
                    sink.setSize$okio(sink.size() + ((long) bytesInflated));
                    return (long) bytesInflated;
                } else if (tail.pos != tail.limit) {
                    return 0;
                } else {
                    sink.head = tail.pop();
                    SegmentPool.recycle(tail);
                    return 0;
                }
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment head = this.source.getBuffer().head;
        Intrinsics.checkNotNull(head);
        this.bufferBytesHeldByInflater = head.limit - head.pos;
        this.inflater.setInput(head.data, head.pos, this.bufferBytesHeldByInflater);
        return false;
    }

    private final void releaseBytesAfterInflate() {
        if (this.bufferBytesHeldByInflater != 0) {
            int toRelease = this.bufferBytesHeldByInflater - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= toRelease;
            this.source.skip((long) toRelease);
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }
}
