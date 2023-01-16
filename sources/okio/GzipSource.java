package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: GzipSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\fX\u0004¢\u0006\u0002\n��¨\u0006!"}, m373d2 = {"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", "name", "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"})
/* loaded from: grasscutter.jar:okio/GzipSource.class */
public final class GzipSource implements Source {
    private byte section;
    @NotNull
    private final RealBufferedSource source;
    @NotNull
    private final InflaterSource inflaterSource;
    @NotNull
    private final Inflater inflater = new Inflater(true);
    @NotNull
    private final CRC32 crc = new CRC32();

    public GzipSource(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = new RealBufferedSource(source);
        this.inflaterSource = new InflaterSource((BufferedSource) this.source, this.inflater);
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        } else if (byteCount == 0) {
            return 0;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = 1;
            }
            if (this.section == 1) {
                long offset = sink.size();
                long result = this.inflaterSource.read(sink, byteCount);
                if (result != -1) {
                    updateCrc(sink, offset, result);
                    return result;
                }
                this.section = 2;
            }
            if (this.section != 2) {
                return -1;
            }
            consumeTrailer();
            this.section = 3;
            if (this.source.exhausted()) {
                return -1;
            }
            throw new IOException("gzip finished without exhausting source");
        }
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10);
        int flags = this.source.bufferField.getByte(3);
        boolean fhcrc = ((flags >> 1) & 1) == 1;
        if (fhcrc) {
            updateCrc(this.source.bufferField, 0, 10);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((flags >> 2) & 1) == 1) {
            this.source.require(2);
            if (fhcrc) {
                updateCrc(this.source.bufferField, 0, 2);
            }
            long xlen = (long) this.source.bufferField.readShortLe();
            this.source.require(xlen);
            if (fhcrc) {
                updateCrc(this.source.bufferField, 0, xlen);
            }
            this.source.skip(xlen);
        }
        if (((flags >> 3) & 1) == 1) {
            long index = this.source.indexOf((byte) 0);
            if (index == -1) {
                throw new EOFException();
            }
            if (fhcrc) {
                updateCrc(this.source.bufferField, 0, index + 1);
            }
            this.source.skip(index + 1);
        }
        if (((flags >> 4) & 1) == 1) {
            long index2 = this.source.indexOf((byte) 0);
            if (index2 == -1) {
                throw new EOFException();
            }
            if (fhcrc) {
                updateCrc(this.source.bufferField, 0, index2 + 1);
            }
            this.source.skip(index2 + 1);
        }
        if (fhcrc) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) ((int) this.crc.getValue()));
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    private final void updateCrc(Buffer buffer, long offset, long byteCount) {
        char c = offset;
        char c2 = byteCount;
        Segment s = buffer.head;
        Intrinsics.checkNotNull(s);
        while (c >= ((long) (s.limit - s.pos))) {
            c -= (long) (s.limit - s.pos);
            s = s.next;
            Intrinsics.checkNotNull(s);
        }
        while (c2 > 0) {
            int pos = (int) (((long) s.pos) + c);
            int toUpdate = (int) Math.min((long) (s.limit - pos), (long) c2);
            this.crc.update(s.data, pos, toUpdate);
            c2 -= (long) toUpdate;
            c = 0;
            Segment segment = s.next;
            Intrinsics.checkNotNull(segment);
            s = segment;
        }
    }

    private final void checkEqual(String name, int expected, int actual) {
        if (actual != expected) {
            Object[] objArr = {name, Integer.valueOf(actual), Integer.valueOf(expected)};
            String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
            throw new IOException(format);
        }
    }
}
