package okio.internal;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.FileAppender;

/* compiled from: -RealBufferedSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��j\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\t\n��\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010��\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\b¨\u00068"}, m373d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_RealBufferedSourceKt.class */
public final class _RealBufferedSourceKt {
    public static final long commonRead(@NotNull RealBufferedSource $this$commonRead, @NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        if (!(!$this$commonRead.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if ($this$commonRead.bufferField.size() == 0 && $this$commonRead.source.read($this$commonRead.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
            return -1;
        } else {
            return $this$commonRead.bufferField.read(sink, Math.min(byteCount, $this$commonRead.bufferField.size()));
        }
    }

    public static final boolean commonExhausted(@NotNull RealBufferedSource $this$commonExhausted) {
        Intrinsics.checkNotNullParameter($this$commonExhausted, "<this>");
        if (!$this$commonExhausted.closed) {
            return $this$commonExhausted.bufferField.exhausted() && $this$commonExhausted.source.read($this$commonExhausted.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonRequire(@NotNull RealBufferedSource $this$commonRequire, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRequire, "<this>");
        if (!$this$commonRequire.request(byteCount)) {
            throw new EOFException();
        }
    }

    public static final boolean commonRequest(@NotNull RealBufferedSource $this$commonRequest, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRequest, "<this>");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        if (!(!$this$commonRequest.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while ($this$commonRequest.bufferField.size() < byteCount) {
            if ($this$commonRequest.source.read($this$commonRequest.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final byte commonReadByte(@NotNull RealBufferedSource $this$commonReadByte) {
        Intrinsics.checkNotNullParameter($this$commonReadByte, "<this>");
        $this$commonReadByte.require(1);
        return $this$commonReadByte.bufferField.readByte();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource $this$commonReadByteString) {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        $this$commonReadByteString.bufferField.writeAll($this$commonReadByteString.source);
        return $this$commonReadByteString.bufferField.readByteString();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource $this$commonReadByteString, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadByteString, "<this>");
        $this$commonReadByteString.require(byteCount);
        return $this$commonReadByteString.bufferField.readByteString(byteCount);
    }

    public static final int commonSelect(@NotNull RealBufferedSource $this$commonSelect, @NotNull Options options) {
        Intrinsics.checkNotNullParameter($this$commonSelect, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!$this$commonSelect.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int index = _BufferKt.selectPrefix($this$commonSelect.bufferField, options, true);
            switch (index) {
                case -2:
                    break;
                case -1:
                    return -1;
                default:
                    $this$commonSelect.bufferField.skip((long) options.getByteStrings$okio()[index].size());
                    return index;
            }
        } while ($this$commonSelect.source.read($this$commonSelect.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) != -1);
        return -1;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource $this$commonReadByteArray) {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        $this$commonReadByteArray.bufferField.writeAll($this$commonReadByteArray.source);
        return $this$commonReadByteArray.bufferField.readByteArray();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource $this$commonReadByteArray, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadByteArray, "<this>");
        $this$commonReadByteArray.require(byteCount);
        return $this$commonReadByteArray.bufferField.readByteArray(byteCount);
    }

    public static final void commonReadFully(@NotNull RealBufferedSource $this$commonReadFully, @NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            $this$commonReadFully.require((long) sink.length);
            $this$commonReadFully.bufferField.readFully(sink);
        } catch (EOFException e) {
            int offset = 0;
            while ($this$commonReadFully.bufferField.size() > 0) {
                int read = $this$commonReadFully.bufferField.read(sink, offset, (int) $this$commonReadFully.bufferField.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                offset += read;
            }
            throw e;
        }
    }

    public static final int commonRead(@NotNull RealBufferedSource $this$commonRead, @NotNull byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRead, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        _UtilKt.checkOffsetAndCount((long) sink.length, (long) offset, (long) byteCount);
        if ($this$commonRead.bufferField.size() == 0 && $this$commonRead.source.read($this$commonRead.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
            return -1;
        }
        return $this$commonRead.bufferField.read(sink, offset, (int) Math.min((long) byteCount, $this$commonRead.bufferField.size()));
    }

    public static final void commonReadFully(@NotNull RealBufferedSource $this$commonReadFully, @NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadFully, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            $this$commonReadFully.require(byteCount);
            $this$commonReadFully.bufferField.readFully(sink, byteCount);
        } catch (EOFException e) {
            sink.writeAll($this$commonReadFully.bufferField);
            throw e;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r0v26, types: [long] */
    public static final long commonReadAll(@NotNull RealBufferedSource $this$commonReadAll, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter($this$commonReadAll, "<this>");
        Intrinsics.checkNotNullParameter(sink, "sink");
        char c = 0;
        while ($this$commonReadAll.source.read($this$commonReadAll.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) != -1) {
            long emitByteCount = $this$commonReadAll.bufferField.completeSegmentByteCount();
            if (emitByteCount > 0) {
                c += emitByteCount;
                sink.write($this$commonReadAll.bufferField, emitByteCount);
            }
        }
        if ($this$commonReadAll.bufferField.size() > 0) {
            c += $this$commonReadAll.bufferField.size();
            sink.write($this$commonReadAll.bufferField, $this$commonReadAll.bufferField.size());
        }
        return c;
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource $this$commonReadUtf8) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8, "<this>");
        $this$commonReadUtf8.bufferField.writeAll($this$commonReadUtf8.source);
        return $this$commonReadUtf8.bufferField.readUtf8();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource $this$commonReadUtf8, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8, "<this>");
        $this$commonReadUtf8.require(byteCount);
        return $this$commonReadUtf8.bufferField.readUtf8(byteCount);
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull RealBufferedSource $this$commonReadUtf8Line) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8Line, "<this>");
        long newline = $this$commonReadUtf8Line.indexOf((byte) 10);
        if (newline != -1) {
            return _BufferKt.readUtf8Line($this$commonReadUtf8Line.bufferField, newline);
        }
        if ($this$commonReadUtf8Line.bufferField.size() != 0) {
            return $this$commonReadUtf8Line.readUtf8($this$commonReadUtf8Line.bufferField.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull RealBufferedSource $this$commonReadUtf8LineStrict, long limit) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8LineStrict, "<this>");
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(limit)).toString());
        }
        long scanLength = limit == LongCompanionObject.MAX_VALUE ? LongCompanionObject.MAX_VALUE : limit + 1;
        long newline = $this$commonReadUtf8LineStrict.indexOf((byte) 10, 0, scanLength);
        if (newline != -1) {
            return _BufferKt.readUtf8Line($this$commonReadUtf8LineStrict.bufferField, newline);
        }
        if (scanLength < LongCompanionObject.MAX_VALUE && $this$commonReadUtf8LineStrict.request(scanLength) && $this$commonReadUtf8LineStrict.bufferField.getByte(scanLength - 1) == ((byte) 13) && $this$commonReadUtf8LineStrict.request(scanLength + 1) && $this$commonReadUtf8LineStrict.bufferField.getByte(scanLength) == ((byte) 10)) {
            return _BufferKt.readUtf8Line($this$commonReadUtf8LineStrict.bufferField, scanLength);
        }
        Buffer data = new Buffer();
        $this$commonReadUtf8LineStrict.bufferField.copyTo(data, 0, Math.min((long) 32, $this$commonReadUtf8LineStrict.bufferField.size()));
        throw new EOFException("\\n not found: limit=" + Math.min($this$commonReadUtf8LineStrict.bufferField.size(), limit) + " content=" + data.readByteString().hex() + (char) 8230);
    }

    public static final int commonReadUtf8CodePoint(@NotNull RealBufferedSource $this$commonReadUtf8CodePoint) {
        Intrinsics.checkNotNullParameter($this$commonReadUtf8CodePoint, "<this>");
        $this$commonReadUtf8CodePoint.require(1);
        int b0 = $this$commonReadUtf8CodePoint.bufferField.getByte(0);
        if ((b0 & PacketOpcodes.SceneAvatarStaminaStepRsp) == 192) {
            $this$commonReadUtf8CodePoint.require(2);
        } else if ((b0 & PacketOpcodes.SceneKickPlayerRsp) == 224) {
            $this$commonReadUtf8CodePoint.require(3);
        } else if ((b0 & PacketOpcodes.EnterSceneDoneReq) == 240) {
            $this$commonReadUtf8CodePoint.require(4);
        }
        return $this$commonReadUtf8CodePoint.bufferField.readUtf8CodePoint();
    }

    public static final short commonReadShort(@NotNull RealBufferedSource $this$commonReadShort) {
        Intrinsics.checkNotNullParameter($this$commonReadShort, "<this>");
        $this$commonReadShort.require(2);
        return $this$commonReadShort.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull RealBufferedSource $this$commonReadShortLe) {
        Intrinsics.checkNotNullParameter($this$commonReadShortLe, "<this>");
        $this$commonReadShortLe.require(2);
        return $this$commonReadShortLe.bufferField.readShortLe();
    }

    public static final int commonReadInt(@NotNull RealBufferedSource $this$commonReadInt) {
        Intrinsics.checkNotNullParameter($this$commonReadInt, "<this>");
        $this$commonReadInt.require(4);
        return $this$commonReadInt.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull RealBufferedSource $this$commonReadIntLe) {
        Intrinsics.checkNotNullParameter($this$commonReadIntLe, "<this>");
        $this$commonReadIntLe.require(4);
        return $this$commonReadIntLe.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull RealBufferedSource $this$commonReadLong) {
        Intrinsics.checkNotNullParameter($this$commonReadLong, "<this>");
        $this$commonReadLong.require(8);
        return $this$commonReadLong.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull RealBufferedSource $this$commonReadLongLe) {
        Intrinsics.checkNotNullParameter($this$commonReadLongLe, "<this>");
        $this$commonReadLongLe.require(8);
        return $this$commonReadLongLe.bufferField.readLongLe();
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static final long commonReadDecimalLong(@NotNull RealBufferedSource $this$commonReadDecimalLong) {
        Intrinsics.checkNotNullParameter($this$commonReadDecimalLong, "<this>");
        $this$commonReadDecimalLong.require(1);
        for (char c = 0; $this$commonReadDecimalLong.request(c + 1); c++) {
            byte b = $this$commonReadDecimalLong.bufferField.getByte(c);
            if ((b < ((byte) 48) || b > ((byte) 57)) && !(c == 0 && b == ((byte) 45))) {
                if (c == 0) {
                    String num = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    throw new NumberFormatException(Intrinsics.stringPlus("Expected a digit or '-' but was 0x", num));
                }
                return $this$commonReadDecimalLong.bufferField.readDecimalLong();
            }
        }
        return $this$commonReadDecimalLong.bufferField.readDecimalLong();
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull RealBufferedSource $this$commonReadHexadecimalUnsignedLong) {
        Intrinsics.checkNotNullParameter($this$commonReadHexadecimalUnsignedLong, "<this>");
        $this$commonReadHexadecimalUnsignedLong.require(1);
        for (int pos = 0; $this$commonReadHexadecimalUnsignedLong.request((long) (pos + 1)); pos++) {
            byte b = $this$commonReadHexadecimalUnsignedLong.bufferField.getByte((long) pos);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                if (pos == 0) {
                    String num = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    throw new NumberFormatException(Intrinsics.stringPlus("Expected leading [0-9a-fA-F] character but was 0x", num));
                }
                return $this$commonReadHexadecimalUnsignedLong.bufferField.readHexadecimalUnsignedLong();
            }
        }
        return $this$commonReadHexadecimalUnsignedLong.bufferField.readHexadecimalUnsignedLong();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    public static final void commonSkip(@NotNull RealBufferedSource $this$commonSkip, long byteCount) {
        Intrinsics.checkNotNullParameter($this$commonSkip, "<this>");
        char c = byteCount;
        if (!(!$this$commonSkip.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (c > 0) {
            if ($this$commonSkip.bufferField.size() == 0 && $this$commonSkip.source.read($this$commonSkip.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                throw new EOFException();
            }
            long toSkip = Math.min((long) c, $this$commonSkip.bufferField.size());
            $this$commonSkip.bufferField.skip(toSkip);
            c -= toSkip;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    public static final long commonIndexOf(@NotNull RealBufferedSource $this$commonIndexOf, byte b, long fromIndex, long toIndex) {
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        char c = fromIndex;
        if (!(!$this$commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        boolean z = 0 <= c ? c <= toIndex : false;
        long fromIndex2 = c;
        if (!z) {
            throw new IllegalArgumentException(("fromIndex=" + ((long) c) + " toIndex=" + toIndex).toString());
        }
        while ((fromIndex2 == 1 ? 1 : 0) < toIndex) {
            long result = $this$commonIndexOf.bufferField.indexOf(b, fromIndex2, toIndex);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = $this$commonIndexOf.bufferField.size();
            if (lastBufferSize >= toIndex || $this$commonIndexOf.source.read($this$commonIndexOf.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return -1;
            }
            fromIndex2 = Math.max(fromIndex2, lastBufferSize);
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [long] */
    public static final long commonIndexOf(@NotNull RealBufferedSource $this$commonIndexOf, @NotNull ByteString bytes, long fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonIndexOf, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char c = fromIndex;
        if (!(!$this$commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result = $this$commonIndexOf.bufferField.indexOf(bytes, c);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = $this$commonIndexOf.bufferField.size();
            if ($this$commonIndexOf.source.read($this$commonIndexOf.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return -1;
            }
            c = Math.max((long) c, (lastBufferSize - ((long) bytes.size())) + 1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    public static final long commonIndexOfElement(@NotNull RealBufferedSource $this$commonIndexOfElement, @NotNull ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter($this$commonIndexOfElement, "<this>");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        char c = fromIndex;
        if (!(!$this$commonIndexOfElement.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result = $this$commonIndexOfElement.bufferField.indexOfElement(targetBytes, c);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = $this$commonIndexOfElement.bufferField.size();
            if ($this$commonIndexOfElement.source.read($this$commonIndexOfElement.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return -1;
            }
            c = Math.max((long) c, lastBufferSize);
        }
    }

    public static final boolean commonRangeEquals(@NotNull RealBufferedSource $this$commonRangeEquals, long offset, @NotNull ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter($this$commonRangeEquals, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(!$this$commonRangeEquals.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (offset < 0 || bytesOffset < 0 || byteCount < 0 || bytes.size() - bytesOffset < byteCount) {
            return false;
        } else {
            int i = 0;
            if (0 >= byteCount) {
                return true;
            }
            do {
                i++;
                long bufferOffset = offset + ((long) i);
                if (!$this$commonRangeEquals.request(bufferOffset + 1) || $this$commonRangeEquals.bufferField.getByte(bufferOffset) != bytes.getByte(bytesOffset + i)) {
                    return false;
                }
            } while (i < byteCount);
            return true;
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull RealBufferedSource $this$commonPeek) {
        Intrinsics.checkNotNullParameter($this$commonPeek, "<this>");
        return Okio.buffer(new PeekSource($this$commonPeek));
    }

    public static final void commonClose(@NotNull RealBufferedSource $this$commonClose) {
        Intrinsics.checkNotNullParameter($this$commonClose, "<this>");
        if (!$this$commonClose.closed) {
            $this$commonClose.closed = true;
            $this$commonClose.source.close();
            $this$commonClose.bufferField.clear();
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSource $this$commonTimeout) {
        Intrinsics.checkNotNullParameter($this$commonTimeout, "<this>");
        return $this$commonTimeout.source.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSource $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return "buffer(" + $this$commonToString.source + ')';
    }
}
