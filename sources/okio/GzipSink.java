package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: GzipSink.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0004\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u0013\u0010\b\u001a\u00020\t8G¢\u0006\b\n��\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\rX\u0004¢\u0006\u0002\n��¨\u0006\u001c"}, m373d2 = {"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "okio"})
/* loaded from: grasscutter.jar:okio/GzipSink.class */
public final class GzipSink implements Sink {
    @NotNull
    private final RealBufferedSink sink;
    @NotNull
    private final DeflaterSink deflaterSink;
    private boolean closed;
    @NotNull
    private final Deflater deflater = new Deflater(-1, true);
    @NotNull
    private final CRC32 crc = new CRC32();

    public GzipSink(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = new RealBufferedSink(sink);
        this.deflaterSink = new DeflaterSink((BufferedSink) this.sink, this.deflater);
        Buffer $this$_init__u24lambda_u2d0 = this.sink.bufferField;
        $this$_init__u24lambda_u2d0.writeShort(8075);
        $this$_init__u24lambda_u2d0.writeByte(8);
        $this$_init__u24lambda_u2d0.writeByte(0);
        $this$_init__u24lambda_u2d0.writeInt(0);
        $this$_init__u24lambda_u2d0.writeByte(0);
        $this$_init__u24lambda_u2d0.writeByte(0);
    }

    @JvmName(name = "deflater")
    @NotNull
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        } else if (byteCount != 0) {
            updateCrc(source, byteCount);
            this.deflaterSink.write(source, byteCount);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            Throwable thrown = null;
            try {
                this.deflaterSink.finishDeflate$okio();
                writeFooter();
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

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [long] */
    private final void updateCrc(Buffer buffer, long byteCount) {
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment head = segment;
        char c = byteCount;
        while (c > 0) {
            int segmentLength = (int) Math.min((long) c, (long) (head.limit - head.pos));
            this.crc.update(head.data, head.pos, segmentLength);
            c -= (long) segmentLength;
            Segment segment2 = head.next;
            Intrinsics.checkNotNull(segment2);
            head = segment2;
        }
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "deflater", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_deflater")
    @NotNull
    /* renamed from: -deprecated_deflater  reason: not valid java name */
    public final Deflater m9390deprecated_deflater() {
        return this.deflater;
    }
}
