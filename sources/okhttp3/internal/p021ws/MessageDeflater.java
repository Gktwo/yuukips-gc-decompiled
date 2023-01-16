package okhttp3.internal.p021ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.jetbrains.annotations.NotNull;

/* compiled from: MessageDeflater.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "noContextTakeover", "", "(Z)V", "deflatedBytes", "Lokio/Buffer;", "deflater", "Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "close", "", GzipHandler.DEFLATE, "buffer", "endsWith", "suffix", "Lokio/ByteString;", "okhttp"})
/* renamed from: okhttp3.internal.ws.MessageDeflater */
/* loaded from: grasscutter.jar:okhttp3/internal/ws/MessageDeflater.class */
public final class MessageDeflater implements Closeable {
    private final boolean noContextTakeover;
    @NotNull
    private final Buffer deflatedBytes = new Buffer();
    @NotNull
    private final Deflater deflater = new Deflater(-1, true);
    @NotNull
    private final DeflaterSink deflaterSink = new DeflaterSink((Sink) this.deflatedBytes, this.deflater);

    public MessageDeflater(boolean noContextTakeover) {
        this.noContextTakeover = noContextTakeover;
    }

    public final void deflate(@NotNull Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!(this.deflatedBytes.size() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer, buffer.size());
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            long newSize = this.deflatedBytes.size() - ((long) 4);
            Buffer.UnsafeCursor cursor = Buffer.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
            try {
                cursor.resizeBuffer(newSize);
                kotlin.p016io.Closeable.closeFinally(cursor, null);
            } catch (Throwable th) {
                kotlin.p016io.Closeable.closeFinally(cursor, null);
                throw th;
            }
        } else {
            this.deflatedBytes.writeByte(0);
        }
        buffer.write(this.deflatedBytes, this.deflatedBytes.size());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.deflaterSink.close();
    }

    private final boolean endsWith(Buffer $this$endsWith, ByteString suffix) {
        return $this$endsWith.rangeEquals($this$endsWith.size() - ((long) suffix.size()), suffix);
    }
}
