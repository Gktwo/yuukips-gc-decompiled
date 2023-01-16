package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* compiled from: -RealBufferedSink.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��D\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n��\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010��\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\b¨\u0006*"}, m373d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", IntegerTokenConverter.CONVERTER_KEY, "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_RealBufferedSinkKt.class */
public final class _RealBufferedSinkKt {
    public static final void commonWrite(@NotNull RealBufferedSink $this$commonWrite, @NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!$this$commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(source, byteCount);
        $this$commonWrite.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink $this$commonWrite, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!(!$this$commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(byteString);
        return $this$commonWrite.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink $this$commonWrite, @NotNull ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!(!$this$commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(byteString, offset, byteCount);
        return $this$commonWrite.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink $this$commonWriteUtf8, @NotNull String string) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(!$this$commonWriteUtf8.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteUtf8.bufferField.writeUtf8(string);
        return $this$commonWriteUtf8.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink $this$commonWriteUtf8, @NotNull String string, int beginIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(!$this$commonWriteUtf8.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteUtf8.bufferField.writeUtf8(string, beginIndex, endIndex);
        return $this$commonWriteUtf8.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink $this$commonWriteUtf8CodePoint, int codePoint) {
        Intrinsics.checkNotNullParameter($this$commonWriteUtf8CodePoint, "<this>");
        if (!(!$this$commonWriteUtf8CodePoint.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteUtf8CodePoint.bufferField.writeUtf8CodePoint(codePoint);
        return $this$commonWriteUtf8CodePoint.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink $this$commonWrite, @NotNull byte[] source) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!$this$commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(source);
        return $this$commonWrite.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink $this$commonWrite, @NotNull byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!$this$commonWrite.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWrite.bufferField.write(source, offset, byteCount);
        return $this$commonWrite.emitCompleteSegments();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    public static final long commonWriteAll(@NotNull RealBufferedSink $this$commonWriteAll, @NotNull Source source) {
        Intrinsics.checkNotNullParameter($this$commonWriteAll, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        char c = 0;
        while (true) {
            long readCount = source.read($this$commonWriteAll.bufferField, FileAppender.DEFAULT_BUFFER_SIZE);
            if (readCount == -1) {
                return c;
            }
            c += readCount;
            $this$commonWriteAll.emitCompleteSegments();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink $this$commonWrite, @NotNull Source source, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonWrite, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        char c = byteCount;
        while (c > 0) {
            long read = source.read($this$commonWrite.bufferField, c);
            if (read == -1) {
                throw new EOFException();
            }
            c -= read;
            $this$commonWrite.emitCompleteSegments();
        }
        return $this$commonWrite;
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink $this$commonWriteByte, int b) {
        Intrinsics.checkNotNullParameter($this$commonWriteByte, "<this>");
        if (!(!$this$commonWriteByte.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteByte.bufferField.writeByte(b);
        return $this$commonWriteByte.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink $this$commonWriteShort, int s) {
        Intrinsics.checkNotNullParameter($this$commonWriteShort, "<this>");
        if (!(!$this$commonWriteShort.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteShort.bufferField.writeShort(s);
        return $this$commonWriteShort.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink $this$commonWriteShortLe, int s) {
        Intrinsics.checkNotNullParameter($this$commonWriteShortLe, "<this>");
        if (!(!$this$commonWriteShortLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteShortLe.bufferField.writeShortLe(s);
        return $this$commonWriteShortLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink $this$commonWriteInt, int i) {
        Intrinsics.checkNotNullParameter($this$commonWriteInt, "<this>");
        if (!(!$this$commonWriteInt.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteInt.bufferField.writeInt(i);
        return $this$commonWriteInt.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink $this$commonWriteIntLe, int i) {
        Intrinsics.checkNotNullParameter($this$commonWriteIntLe, "<this>");
        if (!(!$this$commonWriteIntLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteIntLe.bufferField.writeIntLe(i);
        return $this$commonWriteIntLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink $this$commonWriteLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteLong, "<this>");
        if (!(!$this$commonWriteLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteLong.bufferField.writeLong(v);
        return $this$commonWriteLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink $this$commonWriteLongLe, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteLongLe, "<this>");
        if (!(!$this$commonWriteLongLe.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteLongLe.bufferField.writeLongLe(v);
        return $this$commonWriteLongLe.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink $this$commonWriteDecimalLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteDecimalLong, "<this>");
        if (!(!$this$commonWriteDecimalLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteDecimalLong.bufferField.writeDecimalLong(v);
        return $this$commonWriteDecimalLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink $this$commonWriteHexadecimalUnsignedLong, long v) {
        Intrinsics.checkNotNullParameter($this$commonWriteHexadecimalUnsignedLong, "<this>");
        if (!(!$this$commonWriteHexadecimalUnsignedLong.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        $this$commonWriteHexadecimalUnsignedLong.bufferField.writeHexadecimalUnsignedLong(v);
        return $this$commonWriteHexadecimalUnsignedLong.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink $this$commonEmitCompleteSegments) {
        Intrinsics.checkNotNullParameter($this$commonEmitCompleteSegments, "<this>");
        if (!(!$this$commonEmitCompleteSegments.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long byteCount = $this$commonEmitCompleteSegments.bufferField.completeSegmentByteCount();
        if (byteCount > 0) {
            $this$commonEmitCompleteSegments.sink.write($this$commonEmitCompleteSegments.bufferField, byteCount);
        }
        return $this$commonEmitCompleteSegments;
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull RealBufferedSink $this$commonEmit) {
        Intrinsics.checkNotNullParameter($this$commonEmit, "<this>");
        if (!(!$this$commonEmit.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long byteCount = $this$commonEmit.bufferField.size();
        if (byteCount > 0) {
            $this$commonEmit.sink.write($this$commonEmit.bufferField, byteCount);
        }
        return $this$commonEmit;
    }

    public static final void commonFlush(@NotNull RealBufferedSink $this$commonFlush) {
        Intrinsics.checkNotNullParameter($this$commonFlush, "<this>");
        if (!(!$this$commonFlush.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if ($this$commonFlush.bufferField.size() > 0) {
            $this$commonFlush.sink.write($this$commonFlush.bufferField, $this$commonFlush.bufferField.size());
        }
        $this$commonFlush.sink.flush();
    }

    public static final void commonClose(@NotNull RealBufferedSink $this$commonClose) {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        if (!$this$commonClose.closed) {
            Throwable thrown = null;
            try {
                if ($this$commonClose.bufferField.size() > 0) {
                    $this$commonClose.sink.write($this$commonClose.bufferField, $this$commonClose.bufferField.size());
                }
            } catch (Throwable e) {
                thrown = e;
            }
            try {
                $this$commonClose.sink.close();
            } catch (Throwable e2) {
                if (thrown == null) {
                    thrown = e2;
                }
            }
            $this$commonClose.closed = true;
            if (thrown != null) {
                throw thrown;
            }
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSink $this$commonTimeout) {
        Intrinsics.checkNotNullParameter($this$commonTimeout, "<this>");
        return $this$commonTimeout.sink.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSink $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return "buffer(" + $this$commonToString.sink + ')';
    }
}
