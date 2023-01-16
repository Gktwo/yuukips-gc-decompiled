package okio;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;
import okio.internal._BufferKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;
import org.jline.console.Printer;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* compiled from: Buffer.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018��2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020��H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020��H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020��J$\u0010\u0017\u001a\u00020��2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020��2\u0006\u0010\u0018\u001a\u00020��2\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020��2\u0006\u0010\u0018\u001a\u00020��2\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020��H\u0016J\b\u0010!\u001a\u00020��H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020��2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020��2\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020��2\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020��2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H��¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020��2\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020��2\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020��2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020��2\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020��2\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020��2\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020��2\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020��2\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u00020��2\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0001\u001a\u00020��2\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0001\u001a\u00020��2\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u0001\u001a\u00020��2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020��8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8��@��X\u000e¢\u0006\u0002\n��R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0001"}, m373d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", LineReader.CLEAR, "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", BeanUtil.PREFIX_GETTER_GET, "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", Action.KEY_ATTRIBUTE, "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", Printer.TO_STRING, "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", IntegerTokenConverter.CONVERTER_KEY, "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"})
/* loaded from: grasscutter.jar:okio/Buffer.class */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    @JvmField
    @Nullable
    public Segment head;
    private long size;

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long offset) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo$default(this, out, offset, 0, 4, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo$default(this, out, 0, 0, 6, (Object) null);
    }

    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        return writeTo$default(this, out, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    @JvmName(name = "size")
    public final long size() {
        return this.size;
    }

    public final void setSize$okio(long j) {
        this.size = j;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this;
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream(this) { // from class: okio.Buffer$outputStream$1
            final /* synthetic */ Buffer this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // java.io.OutputStream
            public void write(int b) {
                this.this$0.writeByte(b);
            }

            @Override // java.io.OutputStream
            public void write(@NotNull byte[] data, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.this$0.write(data, offset, byteCount);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return this.this$0 + ".outputStream()";
            }
        };
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSource
    public void require(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public boolean request(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream(this) { // from class: okio.Buffer$inputStream$1
            final /* synthetic */ Buffer this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.this$0.size() > 0) {
                    return this.this$0.readByte() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public int read(@NotNull byte[] sink, int offset, int byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                return this.this$0.read(sink, offset, byteCount);
            }

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(this.this$0.size(), (long) Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return this.this$0 + ".inputStream()";
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [okio.Buffer] */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ okio.Buffer copyTo$default(okio.Buffer r7, java.io.OutputStream r8, long r9, long r11, int r13, java.lang.Object r14) throws java.io.IOException {
        /*
            r0 = r13
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0009
            r0 = 0
            r9 = r0
        L_0x0009:
            r0 = r13
            r1 = 4
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0018
            r0 = r7
            long r0 = r0.size
            r1 = r9
            long r0 = r0 - r1
            r11 = r0
        L_0x0018:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r11
            okio.Buffer r0 = r0.copyTo(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.copyTo$default(okio.Buffer, java.io.OutputStream, long, long, int, java.lang.Object):okio.Buffer");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull OutputStream out, long offset, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        char c = offset;
        char c2 = byteCount;
        _UtilKt.checkOffsetAndCount(this.size, c, c2);
        if (c2 == 0) {
            return this;
        }
        Segment s = this.head;
        while (true) {
            Intrinsics.checkNotNull(s);
            if (c >= ((long) (s.limit - s.pos))) {
                c -= (long) (s.limit - s.pos);
                s = s.next;
            }
        }
        while (c2 > 0) {
            Intrinsics.checkNotNull(s);
            int pos = (int) (((long) s.pos) + c);
            int toCopy = (int) Math.min((long) (s.limit - pos), (long) c2);
            out.write(s.data, pos, toCopy);
            c2 -= (long) toCopy;
            c = 0;
            s = s.next;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ okio.Buffer copyTo$default(okio.Buffer r7, okio.Buffer r8, long r9, long r11, int r13, java.lang.Object r14) {
        /*
            r0 = r13
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0009
            r0 = 0
            r9 = r0
        L_0x0009:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r11
            okio.Buffer r0 = r0.copyTo(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.copyTo$default(okio.Buffer, okio.Buffer, long, long, int, java.lang.Object):okio.Buffer");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long offset, long byteCount) {
        Intrinsics.checkNotNullParameter(out, "out");
        char c = offset;
        char c2 = byteCount;
        _UtilKt.checkOffsetAndCount(size(), c, c2);
        if (c2 == 0) {
            return this;
        }
        out.setSize$okio(out.size() + c2);
        Segment s$iv = this.head;
        while (true) {
            Intrinsics.checkNotNull(s$iv);
            if (c >= ((long) (s$iv.limit - s$iv.pos))) {
                c -= (long) (s$iv.limit - s$iv.pos);
                s$iv = s$iv.next;
            }
        }
        while (c2 > 0) {
            Intrinsics.checkNotNull(s$iv);
            Segment copy$iv = s$iv.sharedCopy();
            copy$iv.pos += (int) c;
            copy$iv.limit = Math.min(copy$iv.pos + ((int) c2), copy$iv.limit);
            if (out.head == null) {
                copy$iv.prev = copy$iv;
                copy$iv.next = copy$iv.prev;
                out.head = copy$iv.next;
            } else {
                Segment segment = out.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                segment2.push(copy$iv);
            }
            c2 -= (long) (copy$iv.limit - copy$iv.pos);
            c = 0;
            s$iv = s$iv.next;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ okio.Buffer copyTo$default(okio.Buffer r5, okio.Buffer r6, long r7, int r9, java.lang.Object r10) {
        /*
            r0 = r9
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0009
            r0 = 0
            r7 = r0
        L_0x0009:
            r0 = r5
            r1 = r6
            r2 = r7
            okio.Buffer r0 = r0.copyTo(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.copyTo$default(okio.Buffer, okio.Buffer, long, int, java.lang.Object):okio.Buffer");
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer out, long offset) {
        Intrinsics.checkNotNullParameter(out, "out");
        return copyTo(out, offset, this.size - offset);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = buffer.size;
        }
        return buffer.writeTo(outputStream, j);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull OutputStream out, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        char c = byteCount;
        _UtilKt.checkOffsetAndCount(this.size, 0, c);
        Segment s = this.head;
        while (c > 0) {
            Intrinsics.checkNotNull(s);
            int toCopy = (int) Math.min((long) c, (long) (s.limit - s.pos));
            out.write(s.data, s.pos, toCopy);
            s.pos += toCopy;
            this.size -= (long) toCopy;
            c -= (long) toCopy;
            if (s.pos == s.limit) {
                s = s.pop();
                this.head = s;
                SegmentPool.recycle(s);
            }
        }
        return this;
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        readFrom(input, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream input, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        readFrom(input, byteCount, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readFrom(java.io.InputStream r7, long r8, boolean r10) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r8
            r11 = r0
        L_0x0003:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x000f
            r0 = r10
            if (r0 == 0) goto L_0x00a5
        L_0x000f:
            r0 = r6
            r1 = 1
            okio.Segment r0 = r0.writableSegment$okio(r1)
            r13 = r0
            r0 = 8192(0x2000, float:1.14794E-41)
            r1 = r13
            int r1 = r1.limit
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
            r1 = r13
            byte[] r1 = r1.data
            r2 = r13
            int r2 = r2.limit
            r3 = r14
            int r0 = r0.read(r1, r2, r3)
            r15 = r0
            r0 = r15
            r1 = -1
            if (r0 != r1) goto L_0x0078
            r0 = r13
            int r0 = r0.pos
            r1 = r13
            int r1 = r1.limit
            if (r0 != r1) goto L_0x006a
            r0 = r6
            r1 = r13
            okio.Segment r1 = r1.pop()
            r0.head = r1
            r0 = r13
            okio.SegmentPool.recycle(r0)
        L_0x006a:
            r0 = r10
            if (r0 == 0) goto L_0x0070
            return
        L_0x0070:
            java.io.EOFException r0 = new java.io.EOFException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0078:
            r0 = r13
            r16 = r0
            r0 = r16
            r1 = r16
            int r1 = r1.limit
            r2 = r15
            int r1 = r1 + r2
            r0.limit = r1
            r0 = r6
            r16 = r0
            r0 = r16
            r1 = r16
            long r1 = r1.size
            r2 = r15
            long r2 = (long) r2
            long r1 = r1 + r2
            r0.size = r1
            r0 = r11
            r1 = r15
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x0003
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readFrom(java.io.InputStream, long, boolean):void");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    public final long completeSegmentByteCount() {
        char size = size();
        if (size == 0) {
            return 0;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        Segment tail$iv = segment.prev;
        Intrinsics.checkNotNull(tail$iv);
        if (tail$iv.limit < 8192 && tail$iv.owner) {
            size -= (long) (tail$iv.limit - tail$iv.pos);
        }
        return size;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        int pos$iv2 = pos$iv + 1;
        byte b$iv = segment$iv.data[pos$iv];
        setSize$okio(size() - 1);
        if (pos$iv2 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv2;
        }
        return b$iv;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.jvm.JvmName(name = "getByte")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte getByte(long r8) {
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.getByte(long):byte");
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        if (limit$iv - pos$iv < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] data$iv = segment$iv.data;
        int pos$iv2 = pos$iv + 1;
        int pos$iv3 = pos$iv2 + 1;
        int s$iv = ((data$iv[pos$iv] & 255) << 8) | (data$iv[pos$iv2] & 255);
        setSize$okio(size() - 2);
        if (pos$iv3 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv3;
        }
        return (short) s$iv;
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        if (((long) (limit$iv - pos$iv)) < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] data$iv = segment$iv.data;
        int pos$iv2 = pos$iv + 1;
        int pos$iv3 = pos$iv2 + 1;
        int pos$iv4 = pos$iv3 + 1;
        int pos$iv5 = pos$iv4 + 1;
        int i$iv = ((data$iv[pos$iv] & 255) << 24) | ((data$iv[pos$iv2] & 255) << 16) | ((data$iv[pos$iv3] & 255) << 8) | (data$iv[pos$iv4] & 255);
        setSize$okio(size() - 4);
        if (pos$iv5 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv5;
        }
        return i$iv;
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) {
            throw new EOFException();
        }
        Segment segment$iv = this.head;
        Intrinsics.checkNotNull(segment$iv);
        int pos$iv = segment$iv.pos;
        int limit$iv = segment$iv.limit;
        if (((long) (limit$iv - pos$iv)) < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (((long) readInt()) & 4294967295L);
        }
        byte[] data$iv = segment$iv.data;
        int pos$iv2 = pos$iv + 1;
        int pos$iv3 = pos$iv2 + 1;
        int pos$iv4 = pos$iv3 + 1;
        int pos$iv5 = pos$iv4 + 1;
        int pos$iv6 = pos$iv5 + 1;
        int pos$iv7 = pos$iv6 + 1;
        int pos$iv8 = pos$iv7 + 1;
        int pos$iv9 = pos$iv8 + 1;
        long v$iv = ((((long) data$iv[pos$iv]) & 255) << 56) | ((((long) data$iv[pos$iv2]) & 255) << 48) | ((((long) data$iv[pos$iv3]) & 255) << 40) | ((((long) data$iv[pos$iv4]) & 255) << 32) | ((((long) data$iv[pos$iv5]) & 255) << 24) | ((((long) data$iv[pos$iv6]) & 255) << 16) | ((((long) data$iv[pos$iv7]) & 255) << 8) | (((long) data$iv[pos$iv8]) & 255);
        setSize$okio(size() - 8);
        if (pos$iv9 == limit$iv) {
            this.head = segment$iv.pop();
            SegmentPool.recycle(segment$iv);
        } else {
            segment$iv.pos = pos$iv9;
        }
        return v$iv;
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        return _UtilKt.reverseBytes(readShort());
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        return _UtilKt.reverseBytes(readInt());
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return _UtilKt.reverseBytes(readLong());
    }

    /* JADX WARN: Type inference failed for: r0v60, types: [long] */
    /* JADX WARN: Type inference failed for: r0v81, types: [long] */
    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        if (size() == 0) {
            throw new EOFException();
        }
        char c = 0;
        int seen$iv = 0;
        boolean negative$iv = false;
        boolean done$iv = false;
        char c2 = 65529;
        do {
            Segment segment$iv = this.head;
            Intrinsics.checkNotNull(segment$iv);
            byte[] data$iv = segment$iv.data;
            int pos$iv = segment$iv.pos;
            int limit$iv = segment$iv.limit;
            while (pos$iv < limit$iv) {
                byte b$iv = data$iv[pos$iv];
                if (b$iv >= ((byte) 48) && b$iv <= ((byte) 57)) {
                    int digit$iv = ((byte) 48) - b$iv;
                    if (c < _BufferKt.OVERFLOW_ZONE || (c == _BufferKt.OVERFLOW_ZONE && ((long) digit$iv) < c2)) {
                        Buffer buffer$iv = new Buffer().writeDecimalLong((long) c).writeByte((int) b$iv);
                        if (!negative$iv) {
                            buffer$iv.readByte();
                        }
                        throw new NumberFormatException(Intrinsics.stringPlus("Number too large: ", buffer$iv.readUtf8()));
                    }
                    c = (c * '\n') + ((long) digit$iv);
                } else if (b$iv != ((byte) 45) || seen$iv != 0) {
                    done$iv = true;
                    break;
                } else {
                    negative$iv = true;
                    c2--;
                }
                pos$iv++;
                seen$iv++;
            }
            if (pos$iv == limit$iv) {
                this.head = segment$iv.pop();
                SegmentPool.recycle(segment$iv);
            } else {
                segment$iv.pos = pos$iv;
            }
            if (done$iv) {
                break;
            }
        } while (this.head != null);
        setSize$okio(size() - ((long) seen$iv));
        if (seen$iv >= (negative$iv ? 2 : 1)) {
            return negative$iv ? c : -c;
        }
        if (size() == 0) {
            throw new EOFException();
        }
        throw new NumberFormatException((negative$iv ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + _UtilKt.toHexString(getByte(0)));
    }

    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017c A[EDGE_INSN: B:47:0x017c->B:43:0x017c ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
        // Method dump skipped, instructions count: 399
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(byteCount)).toString());
        } else if (size() < byteCount) {
            throw new EOFException();
        } else if (byteCount < 4096) {
            return new ByteString(readByteArray(byteCount));
        } else {
            ByteString snapshot = snapshot((int) byteCount);
            skip(byteCount);
            return snapshot;
        }
    }

    @Override // okio.BufferedSource
    public int select(@NotNull Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        int index$iv = _BufferKt.selectPrefix$default(this, options, false, 2, null);
        if (index$iv == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[index$iv].size());
        return index$iv;
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull Buffer sink, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (size() < byteCount) {
            sink.write(this, size());
            throw new EOFException();
        } else {
            sink.write(this, byteCount);
        }
    }

    @Override // okio.BufferedSource
    public long readAll(@NotNull Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long byteCount$iv = size();
        if (byteCount$iv > 0) {
            sink.write(this, byteCount$iv);
        }
        return byteCount$iv;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8(long byteCount) throws EOFException {
        return readString(byteCount, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return readString(this.size, charset);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readString(long byteCount, @NotNull Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(byteCount)).toString());
        } else if (this.size < byteCount) {
            throw new EOFException();
        } else if (byteCount == 0) {
            return "";
        } else {
            Segment s = this.head;
            Intrinsics.checkNotNull(s);
            if (((long) s.pos) + byteCount > ((long) s.limit)) {
                return new String(readByteArray(byteCount), charset);
            }
            String result = new String(s.data, s.pos, (int) byteCount, charset);
            s.pos += (int) byteCount;
            this.size -= byteCount;
            if (s.pos == s.limit) {
                this.head = s.pop();
                SegmentPool.recycle(s);
            }
            return result;
        }
    }

    @Override // okio.BufferedSource
    @Nullable
    public String readUtf8Line() throws EOFException {
        long newline$iv = indexOf((byte) 10);
        if (newline$iv != -1) {
            return _BufferKt.readUtf8Line(this, newline$iv);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long limit) throws EOFException {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("limit < 0: ", Long.valueOf(limit)).toString());
        }
        long scanLength$iv = limit == LongCompanionObject.MAX_VALUE ? LongCompanionObject.MAX_VALUE : limit + 1;
        long newline$iv = indexOf((byte) 10, 0, scanLength$iv);
        if (newline$iv != -1) {
            return _BufferKt.readUtf8Line(this, newline$iv);
        }
        if (scanLength$iv < size() && getByte(scanLength$iv - 1) == ((byte) 13) && getByte(scanLength$iv) == ((byte) 10)) {
            return _BufferKt.readUtf8Line(this, scanLength$iv);
        }
        Buffer data$iv = new Buffer();
        copyTo(data$iv, 0, Math.min((long) 32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), limit) + " content=" + data$iv.readByteString().hex() + (char) 8230);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x01ae A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01b4  */
    @Override // okio.BufferedSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readUtf8CodePoint() throws java.io.EOFException {
        /*
        // Method dump skipped, instructions count: 487
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readUtf8CodePoint():int");
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long byteCount) throws EOFException {
        if (!(byteCount >= 0 && byteCount <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount: ", Long.valueOf(byteCount)).toString());
        } else if (size() < byteCount) {
            throw new EOFException();
        } else {
            byte[] result$iv = new byte[(int) byteCount];
            readFully(result$iv);
            return result$iv;
        }
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return read(sink, 0, sink.length);
    }

    @Override // okio.BufferedSource
    public void readFully(@NotNull byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int offset$iv = 0;
        while (offset$iv < sink.length) {
            int read$iv = read(sink, offset$iv, sink.length - offset$iv);
            if (read$iv == -1) {
                throw new EOFException();
            }
            offset$iv += read$iv;
        }
    }

    @Override // okio.BufferedSource
    public int read(@NotNull byte[] sink, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        _UtilKt.checkOffsetAndCount((long) sink.length, (long) offset, (long) byteCount);
        Segment s$iv = this.head;
        if (s$iv == null) {
            return -1;
        }
        int toCopy$iv = Math.min(byteCount, s$iv.limit - s$iv.pos);
        ArraysKt.copyInto(s$iv.data, sink, offset, s$iv.pos, s$iv.pos + toCopy$iv);
        s$iv.pos += toCopy$iv;
        setSize$okio(size() - ((long) toCopy$iv));
        if (s$iv.pos == s$iv.limit) {
            this.head = s$iv.pop();
            SegmentPool.recycle(s$iv);
        }
        return toCopy$iv;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@NotNull ByteBuffer sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Segment s = this.head;
        if (s == null) {
            return -1;
        }
        int toCopy = Math.min(sink.remaining(), s.limit - s.pos);
        sink.put(s.data, s.pos, toCopy);
        s.pos += toCopy;
        this.size -= (long) toCopy;
        if (s.pos == s.limit) {
            this.head = s.pop();
            SegmentPool.recycle(s);
        }
        return toCopy;
    }

    public final void clear() {
        skip(size());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    @Override // okio.BufferedSource
    public void skip(long byteCount) throws EOFException {
        char c = byteCount;
        while (c > 0) {
            Segment head$iv = this.head;
            if (head$iv == null) {
                throw new EOFException();
            }
            int toSkip$iv = (int) Math.min((long) c, (long) (head$iv.limit - head$iv.pos));
            setSize$okio(size() - ((long) toSkip$iv));
            c -= (long) toSkip$iv;
            head$iv.pos += toSkip$iv;
            if (head$iv.pos == head$iv.limit) {
                this.head = head$iv.pop();
                SegmentPool.recycle(head$iv);
            }
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull ByteString byteString, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, offset, byteCount);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return writeUtf8(string, 0, string.length());
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8(@NotNull String string, int beginIndex, int endIndex) {
        int c$iv;
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(beginIndex)).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        int i$iv = beginIndex;
        while (i$iv < endIndex) {
            int c$iv2 = string.charAt(i$iv);
            if (c$iv2 < 128) {
                Segment tail$iv = writableSegment$okio(1);
                byte[] data$iv = tail$iv.data;
                int segmentOffset$iv = tail$iv.limit - i$iv;
                int runLimit$iv = Math.min(endIndex, 8192 - segmentOffset$iv);
                i$iv++;
                data$iv[segmentOffset$iv + i$iv] = (byte) c$iv2;
                while (i$iv < runLimit$iv && (c$iv = string.charAt(i$iv)) < 128) {
                    i$iv++;
                    data$iv[segmentOffset$iv + i$iv] = (byte) c$iv;
                }
                int runSize$iv = (i$iv + segmentOffset$iv) - tail$iv.limit;
                tail$iv.limit += runSize$iv;
                setSize$okio(size() + ((long) runSize$iv));
            } else if (c$iv2 < 2048) {
                Segment tail$iv2 = writableSegment$okio(2);
                tail$iv2.data[tail$iv2.limit] = (byte) ((c$iv2 >> 6) | 192);
                tail$iv2.data[tail$iv2.limit + 1] = (byte) ((c$iv2 & 63) | 128);
                tail$iv2.limit += 2;
                setSize$okio(size() + 2);
                i$iv++;
            } else if (c$iv2 < 55296 || c$iv2 > 57343) {
                Segment tail$iv3 = writableSegment$okio(3);
                tail$iv3.data[tail$iv3.limit] = (byte) ((c$iv2 >> 12) | PacketOpcodes.WorldPlayerLocationNotify);
                tail$iv3.data[tail$iv3.limit + 1] = (byte) (((c$iv2 >> 6) & 63) | 128);
                tail$iv3.data[tail$iv3.limit + 2] = (byte) ((c$iv2 & 63) | 128);
                tail$iv3.limit += 3;
                setSize$okio(size() + 3);
                i$iv++;
            } else {
                int low$iv = i$iv + 1 < endIndex ? string.charAt(i$iv + 1) : 0;
                if (c$iv2 <= 56319) {
                    if (56320 <= low$iv ? low$iv <= 57343 : false) {
                        int codePoint$iv = 65536 + (((c$iv2 & 1023) << 10) | (low$iv & 1023));
                        Segment tail$iv4 = writableSegment$okio(4);
                        tail$iv4.data[tail$iv4.limit] = (byte) ((codePoint$iv >> 18) | PacketOpcodes.ExecuteGadgetLuaRsp);
                        tail$iv4.data[tail$iv4.limit + 1] = (byte) (((codePoint$iv >> 12) & 63) | 128);
                        tail$iv4.data[tail$iv4.limit + 2] = (byte) (((codePoint$iv >> 6) & 63) | 128);
                        tail$iv4.data[tail$iv4.limit + 3] = (byte) ((codePoint$iv & 63) | 128);
                        tail$iv4.limit += 4;
                        setSize$okio(size() + 4);
                        i$iv += 2;
                    }
                }
                writeByte(63);
                i$iv++;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeUtf8CodePoint(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
        } else if (codePoint < 2048) {
            Segment tail$iv = writableSegment$okio(2);
            tail$iv.data[tail$iv.limit] = (byte) ((codePoint >> 6) | 192);
            tail$iv.data[tail$iv.limit + 1] = (byte) ((codePoint & 63) | 128);
            tail$iv.limit += 2;
            setSize$okio(size() + 2);
        } else {
            if (55296 <= codePoint ? codePoint <= 57343 : false) {
                writeByte(63);
            } else if (codePoint < 65536) {
                Segment tail$iv2 = writableSegment$okio(3);
                tail$iv2.data[tail$iv2.limit] = (byte) ((codePoint >> 12) | PacketOpcodes.WorldPlayerLocationNotify);
                tail$iv2.data[tail$iv2.limit + 1] = (byte) (((codePoint >> 6) & 63) | 128);
                tail$iv2.data[tail$iv2.limit + 2] = (byte) ((codePoint & 63) | 128);
                tail$iv2.limit += 3;
                setSize$okio(size() + 3);
            } else if (codePoint <= 1114111) {
                Segment tail$iv3 = writableSegment$okio(4);
                tail$iv3.data[tail$iv3.limit] = (byte) ((codePoint >> 18) | PacketOpcodes.ExecuteGadgetLuaRsp);
                tail$iv3.data[tail$iv3.limit + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                tail$iv3.data[tail$iv3.limit + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                tail$iv3.data[tail$iv3.limit + 3] = (byte) ((codePoint & 63) | 128);
                tail$iv3.limit += 4;
                setSize$okio(size() + 4);
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected code point: 0x", _UtilKt.toHexString(codePoint)));
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return writeString(string, 0, string.length(), charset);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeString(@NotNull String string, int beginIndex, int endIndex, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(beginIndex)).toString());
        }
        if (!(endIndex >= beginIndex)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (!(endIndex <= string.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        } else if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return writeUtf8(string, beginIndex, endIndex);
        } else {
            String substring = string.substring(beginIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] data = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(data, "(this as java.lang.String).getBytes(charset)");
            return write(data, 0, data.length);
        }
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer write(@NotNull byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        int offset$iv = offset;
        _UtilKt.checkOffsetAndCount((long) source.length, (long) offset$iv, (long) byteCount);
        int limit$iv = offset$iv + byteCount;
        while (offset$iv < limit$iv) {
            Segment tail$iv = writableSegment$okio(1);
            int toCopy$iv = Math.min(limit$iv - offset$iv, 8192 - tail$iv.limit);
            ArraysKt.copyInto(source, tail$iv.data, tail$iv.limit, offset$iv, offset$iv + toCopy$iv);
            offset$iv += toCopy$iv;
            tail$iv.limit += toCopy$iv;
        }
        setSize$okio(size() + ((long) byteCount));
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@NotNull ByteBuffer source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        int byteCount = source.remaining();
        int remaining = byteCount;
        while (remaining > 0) {
            Segment tail = writableSegment$okio(1);
            int toCopy = Math.min(remaining, 8192 - tail.limit);
            source.get(tail.data, tail.limit, toCopy);
            remaining -= toCopy;
            tail.limit += toCopy;
        }
        this.size += (long) byteCount;
        return byteCount;
    }

    @Override // okio.BufferedSink
    public long writeAll(@NotNull Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long totalBytesRead$iv = 0;
        while (true) {
            long readCount$iv = source.read(this, FileAppender.DEFAULT_BUFFER_SIZE);
            if (readCount$iv == -1) {
                return totalBytesRead$iv;
            }
            totalBytesRead$iv += readCount$iv;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [okio.Source, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // okio.BufferedSink
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.Buffer write(@org.jetbrains.annotations.NotNull okio.Source r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r5
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r7
            r11 = r0
        L_0x0010:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x003e
            r0 = r6
            r1 = r9
            r2 = r11
            long r0 = r0.read(r1, r2)
            r13 = r0
            r0 = r13
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0034
            java.io.EOFException r0 = new java.io.EOFException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0034:
            r0 = r11
            r1 = r13
            long r0 = r0 - r1
            r11 = r0
            goto L_0x0010
        L_0x003e:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.write(okio.Source, long):okio.Buffer");
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeByte(int b) {
        Segment tail$iv = writableSegment$okio(1);
        byte[] bArr = tail$iv.data;
        int i = tail$iv.limit;
        tail$iv.limit = i + 1;
        bArr[i] = (byte) b;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShort(int s) {
        Segment tail$iv = writableSegment$okio(2);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((s >>> 8) & 255);
        data$iv[limit$iv2] = (byte) (s & 255);
        tail$iv.limit = limit$iv2 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeShortLe(int s) {
        return writeShort((int) _UtilKt.reverseBytes((short) s));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeInt(int i) {
        Segment tail$iv = writableSegment$okio(4);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((i >>> 24) & 255);
        int limit$iv3 = limit$iv2 + 1;
        data$iv[limit$iv2] = (byte) ((i >>> 16) & 255);
        int limit$iv4 = limit$iv3 + 1;
        data$iv[limit$iv3] = (byte) ((i >>> 8) & 255);
        data$iv[limit$iv4] = (byte) (i & 255);
        tail$iv.limit = limit$iv4 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeIntLe(int i) {
        return writeInt(_UtilKt.reverseBytes(i));
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLong(long v) {
        Segment tail$iv = writableSegment$okio(8);
        byte[] data$iv = tail$iv.data;
        int limit$iv = tail$iv.limit;
        int limit$iv2 = limit$iv + 1;
        data$iv[limit$iv] = (byte) ((int) ((v >>> 56) & 255));
        int limit$iv3 = limit$iv2 + 1;
        data$iv[limit$iv2] = (byte) ((int) ((v >>> 48) & 255));
        int limit$iv4 = limit$iv3 + 1;
        data$iv[limit$iv3] = (byte) ((int) ((v >>> 40) & 255));
        int limit$iv5 = limit$iv4 + 1;
        data$iv[limit$iv4] = (byte) ((int) ((v >>> 32) & 255));
        int limit$iv6 = limit$iv5 + 1;
        data$iv[limit$iv5] = (byte) ((int) ((v >>> 24) & 255));
        int limit$iv7 = limit$iv6 + 1;
        data$iv[limit$iv6] = (byte) ((int) ((v >>> 16) & 255));
        int limit$iv8 = limit$iv7 + 1;
        data$iv[limit$iv7] = (byte) ((int) ((v >>> 8) & 255));
        data$iv[limit$iv8] = (byte) ((int) (v & 255));
        tail$iv.limit = limit$iv8 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeLongLe(long v) {
        return writeLong(_UtilKt.reverseBytes(v));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [long] */
    /* JADX WARN: Type inference failed for: r0v88, types: [long] */
    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeDecimalLong(long v) {
        int i;
        char c = v;
        if (c == 0) {
            return writeByte(48);
        }
        boolean negative$iv = false;
        if (c < 0) {
            c = -c;
            if (c < 0) {
                return writeUtf8("-9223372036854775808");
            }
            negative$iv = true;
        }
        if (c < 100000000) {
            if (c < AbstractComponentTracker.LINGERING_TIMEOUT) {
                if (c < 100) {
                    i = c < 10 ? 1 : 2;
                } else {
                    i = c < 1000 ? 3 : 4;
                }
            } else if (c < 1000000) {
                i = c < 100000 ? 5 : 6;
            } else {
                i = c < 10000000 ? 7 : 8;
            }
        } else if (c < 1000000000000L) {
            if (c < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                i = c < 1000000000 ? 9 : 10;
            } else {
                i = c < 100000000000L ? 11 : 12;
            }
        } else if (c < 1000000000000000L) {
            if (c < 10000000000000L) {
                i = 13;
            } else {
                i = c < 100000000000000L ? 14 : 15;
            }
        } else if (c < 100000000000000000L) {
            i = c < 10000000000000000L ? 16 : 17;
        } else {
            i = c < 1000000000000000000L ? 18 : 19;
        }
        int width$iv = i;
        if (negative$iv) {
            width$iv++;
        }
        Segment tail$iv = writableSegment$okio(width$iv);
        byte[] data$iv = tail$iv.data;
        int pos$iv = tail$iv.limit + width$iv;
        while (c != 0) {
            pos$iv--;
            data$iv[pos$iv] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (c % ((long) 10))];
            c /= (long) 10;
        }
        if (negative$iv) {
            data$iv[pos$iv - 1] = (byte) 45;
        }
        tail$iv.limit += width$iv;
        setSize$okio(size() + ((long) width$iv));
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v57, types: [long] */
    @Override // okio.BufferedSink
    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long v) {
        char c = v;
        if (c == 0) {
            return writeByte(48);
        }
        long x$iv = c | (c >>> 1);
        long x$iv2 = x$iv | (x$iv >>> 2);
        long x$iv3 = x$iv2 | (x$iv2 >>> 4);
        long x$iv4 = x$iv3 | (x$iv3 >>> 8);
        long x$iv5 = x$iv4 | (x$iv4 >>> 16);
        long x$iv6 = x$iv5 | (x$iv5 >>> 32);
        long x$iv7 = x$iv6 - ((x$iv6 >>> 1) & 6148914691236517205L);
        long x$iv8 = ((x$iv7 >>> 2) & 3689348814741910323L) + (x$iv7 & 3689348814741910323L);
        long x$iv9 = ((x$iv8 >>> 4) + x$iv8) & 1085102592571150095L;
        long x$iv10 = x$iv9 + (x$iv9 >>> 8);
        long x$iv11 = x$iv10 + (x$iv10 >>> 16);
        int width$iv = (int) ((((x$iv11 & 63) + ((x$iv11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment tail$iv = writableSegment$okio(width$iv);
        byte[] data$iv = tail$iv.data;
        int start$iv = tail$iv.limit;
        for (int pos$iv = (tail$iv.limit + width$iv) - 1; pos$iv >= start$iv; pos$iv--) {
            data$iv[pos$iv] = _BufferKt.getHEX_DIGIT_BYTES()[(int) (c & 15)];
            c >>>= 4;
        }
        tail$iv.limit += width$iv;
        setSize$okio(size() + ((long) width$iv));
        return this;
    }

    @NotNull
    public final Segment writableSegment$okio(int minimumCapacity) {
        if (!(minimumCapacity >= 1 && minimumCapacity <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        } else if (this.head == null) {
            Segment result$iv = SegmentPool.take();
            this.head = result$iv;
            result$iv.prev = result$iv;
            result$iv.next = result$iv;
            return result$iv;
        } else {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            Segment tail$iv = segment.prev;
            Intrinsics.checkNotNull(tail$iv);
            if (tail$iv.limit + minimumCapacity > 8192 || !tail$iv.owner) {
                tail$iv = tail$iv.push(SegmentPool.take());
            }
            return tail$iv;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Segment tail$iv;
        Intrinsics.checkNotNullParameter(source, "source");
        char c = byteCount;
        if (!(source != this)) {
            throw new IllegalArgumentException("source == this".toString());
        }
        _UtilKt.checkOffsetAndCount(source.size(), 0, c);
        while (c > 0) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            Segment segment2 = source.head;
            Intrinsics.checkNotNull(segment2);
            if (c < ((long) (i - segment2.pos))) {
                if (this.head != null) {
                    Segment segment3 = this.head;
                    Intrinsics.checkNotNull(segment3);
                    tail$iv = segment3.prev;
                } else {
                    tail$iv = null;
                }
                if (tail$iv != null && tail$iv.owner) {
                    if ((c + ((long) tail$iv.limit)) - ((long) (tail$iv.shared ? 0 : tail$iv.pos)) <= FileAppender.DEFAULT_BUFFER_SIZE) {
                        Segment segment4 = source.head;
                        Intrinsics.checkNotNull(segment4);
                        segment4.writeTo(tail$iv, (int) c);
                        source.setSize$okio(source.size() - c);
                        setSize$okio(size() + c);
                        return;
                    }
                }
                Segment segment5 = source.head;
                Intrinsics.checkNotNull(segment5);
                source.head = segment5.split((int) c);
            }
            Segment segmentToMove$iv = source.head;
            Intrinsics.checkNotNull(segmentToMove$iv);
            long movedByteCount$iv = (long) (segmentToMove$iv.limit - segmentToMove$iv.pos);
            source.head = segmentToMove$iv.pop();
            if (this.head == null) {
                this.head = segmentToMove$iv;
                segmentToMove$iv.prev = segmentToMove$iv;
                segmentToMove$iv.next = segmentToMove$iv.prev;
            } else {
                Segment segment6 = this.head;
                Intrinsics.checkNotNull(segment6);
                Segment tail$iv2 = segment6.prev;
                Intrinsics.checkNotNull(tail$iv2);
                tail$iv2.push(segmentToMove$iv).compact();
            }
            source.setSize$okio(source.size() - movedByteCount$iv);
            setSize$okio(size() + movedByteCount$iv);
            c -= movedByteCount$iv;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        char c = byteCount;
        if (!(c >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(c)).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (c > size()) {
                c = size();
            }
            sink.write(this, (long) c);
            return c;
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

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v30, types: [long] */
    /* JADX WARN: Type inference failed for: r0v65, types: [long] */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v119, types: [long] */
    /* JADX WARN: Type inference failed for: r0v144, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // okio.BufferedSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long indexOf(byte r6, long r7, long r9) {
        /*
        // Method dump skipped, instructions count: 682
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.indexOf(byte, long, long):long");
    }

    @Override // okio.BufferedSource
    public long indexOf(@NotNull ByteString bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return indexOf(bytes, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    /* JADX WARN: Type inference failed for: r0v77, types: [long] */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v143, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // okio.BufferedSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long indexOf(@org.jetbrains.annotations.NotNull okio.ByteString r7, long r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 768
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.indexOf(okio.ByteString, long):long");
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString targetBytes) {
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARN: Type inference failed for: r0v53, types: [long] */
    /* JADX WARN: Type inference failed for: r0v92, types: [long] */
    /* JADX WARN: Type inference failed for: r0v110 */
    /* JADX WARN: Type inference failed for: r0v141, types: [long] */
    /* JADX WARN: Type inference failed for: r0v180, types: [long] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // okio.BufferedSource
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long indexOfElement(@org.jetbrains.annotations.NotNull okio.ByteString r6, long r7) {
        /*
        // Method dump skipped, instructions count: 939
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.indexOfElement(okio.ByteString, long):long");
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long offset, @NotNull ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || size() - offset < ((long) byteCount) || bytes.size() - bytesOffset < byteCount) {
            return false;
        }
        int i$iv = 0;
        if (0 >= byteCount) {
            return true;
        }
        do {
            i$iv++;
            if (getByte(offset + ((long) i$iv)) != bytes.getByte(bytesOffset + i$iv)) {
                return false;
            }
        } while (i$iv < byteCount);
        return true;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @NotNull
    public final ByteString md5() {
        return digest("MD5");
    }

    @NotNull
    public final ByteString sha1() {
        return digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private final ByteString digest(String algorithm) {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Segment head = this.head;
        if (head != null) {
            messageDigest.update(head.data, head.pos, head.limit - head.pos);
            Segment s = head.next;
            Intrinsics.checkNotNull(s);
            while (s != head) {
                messageDigest.update(s.data, s.pos, s.limit - s.pos);
                s = s.next;
                Intrinsics.checkNotNull(s);
            }
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
        return new ByteString(digest);
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return hmac("HmacSHA1", key);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return hmac("HmacSHA256", key);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return hmac("HmacSHA512", key);
    }

    private final ByteString hmac(String algorithm, ByteString key) {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.internalArray$okio(), algorithm));
            Segment head = this.head;
            if (head != null) {
                mac.update(head.data, head.pos, head.limit - head.pos);
                Segment segment = head.next;
                Intrinsics.checkNotNull(segment);
                Segment s = segment;
                while (s != head) {
                    mac.update(s.data, s.pos, s.limit - s.pos);
                    Segment segment2 = s.next;
                    Intrinsics.checkNotNull(segment2);
                    s = segment2;
                }
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r0v41, types: [long] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010e A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.lang.Object
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 282
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    @Override // java.lang.Object
    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        Segment s$iv = segment;
        int result$iv = 1;
        do {
            int limit$iv = s$iv.limit;
            for (int pos$iv = s$iv.pos; pos$iv < limit$iv; pos$iv++) {
                result$iv = (31 * result$iv) + s$iv.data[pos$iv];
            }
            Segment segment2 = s$iv.next;
            Intrinsics.checkNotNull(segment2);
            s$iv = segment2;
        } while (s$iv != this.head);
        return result$iv;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return snapshot().toString();
    }

    @NotNull
    public final Buffer copy() {
        Buffer result$iv = new Buffer();
        if (size() == 0) {
            return result$iv;
        }
        Segment head$iv = this.head;
        Intrinsics.checkNotNull(head$iv);
        Segment headCopy$iv = head$iv.sharedCopy();
        result$iv.head = headCopy$iv;
        headCopy$iv.prev = result$iv.head;
        headCopy$iv.next = headCopy$iv.prev;
        for (Segment s$iv = head$iv.next; s$iv != head$iv; s$iv = s$iv.next) {
            Segment segment = headCopy$iv.prev;
            Intrinsics.checkNotNull(segment);
            Intrinsics.checkNotNull(s$iv);
            segment.push(s$iv.sharedCopy());
        }
        result$iv.setSize$okio(size());
        return result$iv;
    }

    @Override // java.lang.Object
    @NotNull
    public Buffer clone() {
        return copy();
    }

    @NotNull
    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(Intrinsics.stringPlus("size > Int.MAX_VALUE: ", Long.valueOf(size())).toString());
    }

    @NotNull
    public final ByteString snapshot(int byteCount) {
        if (byteCount == 0) {
            return ByteString.EMPTY;
        }
        _UtilKt.checkOffsetAndCount(size(), 0, (long) byteCount);
        int offset$iv = 0;
        int segmentCount$iv = 0;
        Segment s$iv = this.head;
        while (offset$iv < byteCount) {
            Intrinsics.checkNotNull(s$iv);
            if (s$iv.limit == s$iv.pos) {
                throw new AssertionError("s.limit == s.pos");
            }
            offset$iv += s$iv.limit - s$iv.pos;
            segmentCount$iv++;
            s$iv = s$iv.next;
        }
        byte[][] segments$iv = new byte[segmentCount$iv];
        int[] directory$iv = new int[segmentCount$iv * 2];
        int offset$iv2 = 0;
        int segmentCount$iv2 = 0;
        Segment s$iv2 = this.head;
        while (offset$iv2 < byteCount) {
            Intrinsics.checkNotNull(s$iv2);
            segments$iv[segmentCount$iv2] = s$iv2.data;
            offset$iv2 += s$iv2.limit - s$iv2.pos;
            directory$iv[segmentCount$iv2] = Math.min(offset$iv2, byteCount);
            directory$iv[segmentCount$iv2 + segments$iv.length] = s$iv2.pos;
            s$iv2.shared = true;
            segmentCount$iv2++;
            s$iv2 = s$iv2.next;
        }
        return new SegmentedByteString(segments$iv, directory$iv);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadUnsafe(this, unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i, Object obj) {
        if ((i & 1) != 0) {
            unsafeCursor = _UtilKt.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return _BufferKt.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    @Deprecated(message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m9375deprecated_getByte(long index) {
        return getByte(index);
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m9376deprecated_size() {
        return this.size;
    }

    /* compiled from: Buffer.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n��\n\u0002\u0010\b\n��\n\u0002\u0010\t\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0002\n��¨\u0006\u001c"}, m373d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "start", "close", "", "expandBuffer", "minByteCount", Tmux.CMD_NEXT, "resizeBuffer", "newSize", "seek", "okio"})
    /* loaded from: grasscutter.jar:okio/Buffer$UnsafeCursor.class */
    public static final class UnsafeCursor implements Closeable {
        @JvmField
        @Nullable
        public Buffer buffer;
        @JvmField
        public boolean readWrite;
        @Nullable
        private Segment segment;
        @JvmField
        @Nullable
        public byte[] data;
        @JvmField
        public long offset = -1;
        @JvmField
        public int start = -1;
        @JvmField
        public int end = -1;

        @Nullable
        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final void setSegment$okio(@Nullable Segment segment) {
            this.segment = segment;
        }

        public final int next() {
            long j = this.offset;
            Buffer buffer = this.buffer;
            Intrinsics.checkNotNull(buffer);
            if (j != buffer.size()) {
                return this.offset == -1 ? seek(0) : seek(this.offset + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x016e */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v25, types: [long] */
        /* JADX WARN: Type inference failed for: r26v1 */
        /* JADX WARN: Type inference failed for: r26v2, types: [long] */
        /* JADX WARN: Type inference failed for: r26v4, types: [long] */
        /* JADX WARN: Type inference failed for: r0v73, types: [long] */
        /* JADX WARN: Type inference failed for: r0v78, types: [long] */
        /* JADX WARN: Type inference failed for: r0v91 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int seek(long r8) {
            /*
            // Method dump skipped, instructions count: 489
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.UnsafeCursor.seek(long):int");
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x012d */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x012d */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [long] */
        /* JADX WARN: Type inference failed for: r0v14, types: [long] */
        /* JADX WARN: Type inference failed for: r0v23, types: [long] */
        /* JADX WARN: Type inference failed for: r0v40, types: [long] */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r0v56, types: [long] */
        /* JADX WARN: Type inference failed for: r1v47 */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long resizeBuffer(long r6) {
            /*
            // Method dump skipped, instructions count: 436
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.UnsafeCursor.resizeBuffer(long):long");
        }

        public final long expandBuffer(int minByteCount) {
            if (!(minByteCount > 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount <= 0: ", Integer.valueOf(minByteCount)).toString());
            }
            if (!(minByteCount <= 8192)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("minByteCount > Segment.SIZE: ", Integer.valueOf(minByteCount)).toString());
            }
            Buffer buffer$iv = this.buffer;
            if (buffer$iv == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            } else {
                long oldSize$iv = buffer$iv.size();
                Segment tail$iv = buffer$iv.writableSegment$okio(minByteCount);
                int result$iv = 8192 - tail$iv.limit;
                tail$iv.limit = 8192;
                buffer$iv.setSize$okio(oldSize$iv + ((long) result$iv));
                setSegment$okio(tail$iv);
                this.offset = oldSize$iv;
                this.data = tail$iv.data;
                this.start = 8192 - result$iv;
                this.end = 8192;
                return (long) result$iv;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.buffer != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            setSegment$okio(null);
            this.offset = -1;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }
}
