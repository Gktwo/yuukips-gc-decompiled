package okio;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.CharsKt;
import okio.internal._BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.FileAppender;

/* compiled from: RealBufferedSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n��\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��¨\u0006I"}, m373d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", Printer.TO_STRING, "okio"})
/* loaded from: grasscutter.jar:okio/RealBufferedSource.class */
public final class RealBufferedSource implements BufferedSource {
    @JvmField
    @NotNull
    public final Source source;
    @JvmField
    @NotNull
    public final Buffer bufferField = new Buffer();
    @JvmField
    public boolean closed;

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public RealBufferedSource(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.bufferField.size() == 0 && this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
            return -1;
        } else {
            return this.bufferField.read(sink, Math.min(byteCount, this.bufferField.size()));
        }
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (!this.closed) {
            return this.bufferField.exhausted() && this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public void require(long byteCount) {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long byteCount) {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.size() < byteCount) {
            if (this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int index$iv = _BufferKt.selectPrefix(this.bufferField, options, true);
            switch (index$iv) {
                case -2:
                    break;
                case -1:
                    return -1;
                default:
                    this.bufferField.skip((long) options.getByteStrings$okio()[index$iv].size());
                    return index$iv;
            }
        } while (this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require((long) sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e$iv) {
            int offset$iv = 0;
            while (this.bufferField.size() > 0) {
                int read$iv = this.bufferField.read(sink, offset$iv, (int) this.bufferField.size());
                if (read$iv == -1) {
                    throw new AssertionError();
                }
                offset$iv += read$iv;
            }
            throw e$iv;
        }
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        _UtilKt.checkOffsetAndCount((long) sink.length, (long) offset, (long) byteCount);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
            return -1;
        }
        return this.bufferField.read(sink, offset, (int) Math.min((long) byteCount, this.bufferField.size()));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e$iv) {
            sink.writeAll(this.bufferField);
            throw e$iv;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r0v26, types: [long] */
    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        char c = 0;
        while (this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) != -1) {
            long emitByteCount$iv = this.bufferField.completeSegmentByteCount();
            if (emitByteCount$iv > 0) {
                c += emitByteCount$iv;
                sink.write(this.bufferField, emitByteCount$iv);
            }
        }
        if (this.bufferField.size() > 0) {
            c += this.bufferField.size();
            sink.write(this.bufferField, this.bufferField.size());
        }
        return c;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long byteCount) {
        require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long byteCount, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        require(byteCount);
        return this.bufferField.readString(byteCount, charset);
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long newline$iv = indexOf((byte) 10);
        if (newline$iv != -1) {
            return _BufferKt.readUtf8Line(this.bufferField, newline$iv);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long limit) {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(limit)).toString());
        }
        long scanLength$iv = limit == LongCompanionObject.MAX_VALUE ? LongCompanionObject.MAX_VALUE : limit + 1;
        long newline$iv = indexOf((byte) 10, 0, scanLength$iv);
        if (newline$iv != -1) {
            return _BufferKt.readUtf8Line(this.bufferField, newline$iv);
        }
        if (scanLength$iv < LongCompanionObject.MAX_VALUE && request(scanLength$iv) && this.bufferField.getByte(scanLength$iv - 1) == ((byte) 13) && request(scanLength$iv + 1) && this.bufferField.getByte(scanLength$iv) == ((byte) 10)) {
            return _BufferKt.readUtf8Line(this.bufferField, scanLength$iv);
        }
        Buffer data$iv = new Buffer();
        this.bufferField.copyTo(data$iv, 0, Math.min((long) 32, this.bufferField.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), limit) + " content=" + data$iv.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        require(1);
        int b0$iv = this.bufferField.getByte(0);
        if ((b0$iv & PacketOpcodes.WorldPlayerLocationNotify) == 192) {
            require(2);
        } else if ((b0$iv & PacketOpcodes.ExecuteGadgetLuaRsp) == 224) {
            require(3);
        } else if ((b0$iv & PacketOpcodes.ScenePlayerLocationNotify) == 240) {
            require(4);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    @Override // okio.BufferedSource
    public long readDecimalLong() {
        require(1);
        for (char c = 0; request(c + 1); c++) {
            byte b$iv = this.bufferField.getByte(c);
            if ((b$iv < ((byte) 48) || b$iv > ((byte) 57)) && !(c == 0 && b$iv == ((byte) 45))) {
                if (c == 0) {
                    String num = Integer.toString(b$iv, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    throw new NumberFormatException(Intrinsics.stringPlus("Expected a digit or '-' but was 0x", num));
                }
                return this.bufferField.readDecimalLong();
            }
        }
        return this.bufferField.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        require(1);
        for (int pos$iv = 0; request((long) (pos$iv + 1)); pos$iv++) {
            byte b$iv = this.bufferField.getByte((long) pos$iv);
            if ((b$iv < ((byte) 48) || b$iv > ((byte) 57)) && ((b$iv < ((byte) 97) || b$iv > ((byte) 102)) && (b$iv < ((byte) 65) || b$iv > ((byte) 70)))) {
                if (pos$iv == 0) {
                    String num = Integer.toString(b$iv, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    throw new NumberFormatException(Intrinsics.stringPlus("Expected leading [0-9a-fA-F] character but was 0x", num));
                }
                return this.bufferField.readHexadecimalUnsignedLong();
            }
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    @Override // okio.BufferedSource
    public void skip(long byteCount) {
        char c = byteCount;
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (c > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                throw new EOFException();
            }
            long toSkip$iv = Math.min((long) c, this.bufferField.size());
            this.bufferField.skip(toSkip$iv);
            c -= toSkip$iv;
        }
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0, LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long fromIndex) {
        return indexOf(b, fromIndex, LongCompanionObject.MAX_VALUE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // okio.BufferedSource
    public long indexOf(byte b, long fromIndex, long toIndex) {
        char c = fromIndex;
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        boolean z = 0 <= c ? c <= toIndex : false;
        long fromIndex$iv = c;
        if (!z) {
            throw new IllegalArgumentException(("fromIndex=" + ((long) c) + " toIndex=" + toIndex).toString());
        }
        while ((fromIndex$iv == 1 ? 1 : 0) < toIndex) {
            long result$iv = this.bufferField.indexOf(b, fromIndex$iv, toIndex);
            if (result$iv != -1) {
                return result$iv;
            }
            long lastBufferSize$iv = this.bufferField.size();
            if (lastBufferSize$iv >= toIndex || this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return -1;
            }
            fromIndex$iv = Math.max(fromIndex$iv, lastBufferSize$iv);
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [long] */
    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char c = fromIndex;
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result$iv = this.bufferField.indexOf(bytes, c);
            if (result$iv != -1) {
                return result$iv;
            }
            long lastBufferSize$iv = this.bufferField.size();
            if (this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return -1;
            }
            c = Math.max((long) c, (lastBufferSize$iv - ((long) bytes.size())) + 1);
        }
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        char c = fromIndex;
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result$iv = this.bufferField.indexOfElement(targetBytes, c);
            if (result$iv != -1) {
                return result$iv;
            }
            long lastBufferSize$iv = this.bufferField.size();
            if (this.source.read(this.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                return -1;
            }
            c = Math.max((long) c, lastBufferSize$iv);
        }
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (offset < 0 || bytesOffset < 0 || byteCount < 0 || bytes.size() - bytesOffset < byteCount) {
            return false;
        } else {
            int i$iv = 0;
            if (0 >= byteCount) {
                return true;
            }
            do {
                i$iv++;
                long bufferOffset$iv = offset + ((long) i$iv);
                if (!request(bufferOffset$iv + 1) || this.bufferField.getByte(bufferOffset$iv) != bytes.getByte(bytesOffset + i$iv)) {
                    return false;
                }
            } while (i$iv < byteCount);
            return true;
        }
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream(this) { // from class: okio.RealBufferedSource$inputStream$1
            final /* synthetic */ RealBufferedSource this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.this$0.closed) {
                    throw new IOException("closed");
                } else if (this.this$0.bufferField.size() == 0 && this.this$0.source.read(this.this$0.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                    return -1;
                } else {
                    return this.this$0.bufferField.readByte() & 255;
                }
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (this.this$0.closed) {
                    throw new IOException("closed");
                }
                _UtilKt.checkOffsetAndCount((long) data.length, (long) offset, (long) byteCount);
                if (this.this$0.bufferField.size() == 0 && this.this$0.source.read(this.this$0.bufferField, FileAppender.DEFAULT_BUFFER_SIZE) == -1) {
                    return -1;
                }
                return this.this$0.bufferField.read(data, offset, byteCount);
            }

            @Override // java.io.InputStream
            public int available() {
                if (!this.this$0.closed) {
                    return (int) Math.min(this.this$0.bufferField.size(), (long) Integer.MAX_VALUE);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                this.this$0.close();
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return this.this$0 + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return "buffer(" + this.source + ')';
    }
}
