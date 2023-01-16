package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;

/* compiled from: DeflaterSink.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��\u0018��2\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0003J\r\u0010\u000e\u001a\u00020\u000bH��¢\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u001a"}, m373d2 = {"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", GzipHandler.DEFLATE, "syncFlush", "finishDeflate", "finishDeflate$okio", "flush", "timeout", "Lokio/Timeout;", Printer.TO_STRING, "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"})
/* loaded from: grasscutter.jar:okio/DeflaterSink.class */
public final class DeflaterSink implements Sink {
    @NotNull
    private final BufferedSink sink;
    @NotNull
    private final Deflater deflater;
    private boolean closed;

    public DeflaterSink(@NotNull BufferedSink sink, @NotNull Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(@NotNull Sink sink, @NotNull Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // okio.Sink
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(@org.jetbrains.annotations.NotNull okio.Buffer r8, long r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = r8
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r8
            long r0 = r0.size()
            r1 = 0
            r2 = r9
            okio._UtilKt.checkOffsetAndCount(r0, r1, r2)
            r0 = r9
            r11 = r0
        L_0x0012:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a6
            r0 = r8
            okio.Segment r0 = r0.head
            r1 = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r13 = r0
            r0 = r13
            int r0 = r0.limit
            r1 = r13
            int r1 = r1.pos
            int r0 = r0 - r1
            r15 = r0
            r0 = 0
            r16 = r0
            r0 = r15
            long r0 = (long) r0
            r17 = r0
            r0 = 0
            r19 = r0
            r0 = r11
            r1 = r17
            long r0 = java.lang.Math.min(r0, r1)
            int r0 = (int) r0
            r14 = r0
            r0 = r7
            java.util.zip.Deflater r0 = r0.deflater
            r1 = r13
            byte[] r1 = r1.data
            r2 = r13
            int r2 = r2.pos
            r3 = r14
            r0.setInput(r1, r2, r3)
            r0 = r7
            r1 = 0
            r0.deflate(r1)
            r0 = r8
            r15 = r0
            r0 = r15
            r1 = r15
            long r1 = r1.size()
            r2 = r14
            long r2 = (long) r2
            long r1 = r1 - r2
            r0.setSize$okio(r1)
            r0 = r13
            r15 = r0
            r0 = r15
            r1 = r15
            int r1 = r1.pos
            r2 = r14
            int r1 = r1 + r2
            r0.pos = r1
            r0 = r13
            int r0 = r0.pos
            r1 = r13
            int r1 = r1.limit
            if (r0 != r1) goto L_0x009b
            r0 = r8
            r1 = r13
            okio.Segment r1 = r1.pop()
            r0.head = r1
            r0 = r13
            okio.SegmentPool.recycle(r0)
        L_0x009b:
            r0 = r11
            r1 = r14
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x0012
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.DeflaterSink.write(okio.Buffer, long):void");
    }

    @IgnoreJRERequirement
    private final void deflate(boolean syncFlush) {
        Segment s;
        int deflated;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            s = buffer.writableSegment$okio(1);
            if (syncFlush) {
                deflated = this.deflater.deflate(s.data, s.limit, 8192 - s.limit, 2);
            } else {
                deflated = this.deflater.deflate(s.data, s.limit, 8192 - s.limit);
            }
            if (deflated > 0) {
                s.limit += deflated;
                buffer.setSize$okio(buffer.size() + ((long) deflated));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (s.pos == s.limit) {
            buffer.head = s.pop();
            SegmentPool.recycle(s);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            Throwable thrown = null;
            try {
                finishDeflate$okio();
            } catch (Throwable e) {
                thrown = e;
            }
            try {
                this.deflater.end();
            } catch (Throwable e2) {
                if (thrown == null) {
                    thrown = e2;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable e3) {
                if (thrown == null) {
                    thrown = e3;
                }
            }
            this.closed = true;
            if (thrown != null) {
                throw thrown;
            }
        }
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }
}
