package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CipherSink.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0003\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u001b"}, m373d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "blockSize", "", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "close", "", "doFinal", "", "flush", "timeout", "Lokio/Timeout;", "update", "source", "Lokio/Buffer;", "remaining", "", "write", "byteCount", "okio"})
/* loaded from: grasscutter.jar:okio/CipherSink.class */
public final class CipherSink implements Sink {
    @NotNull
    private final BufferedSink sink;
    @NotNull
    private final Cipher cipher;
    private final int blockSize;
    private boolean closed;

    public CipherSink(@NotNull BufferedSink sink, @NotNull Cipher cipher) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.sink = sink;
        this.cipher = cipher;
        this.blockSize = this.cipher.getBlockSize();
        if (!(this.blockSize > 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Block cipher required ", getCipher()).toString());
        }
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [okio.CipherSink] */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r0v24 */
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
            r0 = r7
            boolean r0 = r0.closed
            if (r0 != 0) goto L_0x001a
            r0 = 1
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            r11 = r0
            r0 = 0
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r11
            if (r0 != 0) goto L_0x003f
            r0 = 0
            r14 = r0
            java.lang.String r0 = "closed"
            r13 = r0
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = r13
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x003f:
            r0 = r9
            r11 = r0
        L_0x0042:
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x005d
            r0 = r7
            r1 = r8
            r2 = r11
            int r0 = r0.update(r1, r2)
            r13 = r0
            r0 = r11
            r1 = r13
            long r1 = (long) r1
            long r0 = r0 - r1
            r11 = r0
            goto L_0x0042
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.CipherSink.write(okio.Buffer, long):void");
    }

    private final int update(Buffer source, long remaining) {
        Segment head = source.head;
        Intrinsics.checkNotNull(head);
        int size = (int) Math.min(remaining, (long) (head.limit - head.pos));
        Buffer buffer = this.sink.getBuffer();
        int outputSize = this.cipher.getOutputSize(size);
        while (outputSize > 8192) {
            if (!(size > this.blockSize)) {
                throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + size).toString());
            }
            size -= this.blockSize;
            outputSize = this.cipher.getOutputSize(size);
        }
        Segment s = buffer.writableSegment$okio(outputSize);
        int ciphered = this.cipher.update(head.data, head.pos, size, s.data, s.limit);
        s.limit += ciphered;
        buffer.setSize$okio(buffer.size() + ((long) ciphered));
        if (s.pos == s.limit) {
            buffer.head = s.pop();
            SegmentPool.recycle(s);
        }
        this.sink.emitCompleteSegments();
        source.setSize$okio(source.size() - ((long) size));
        head.pos += size;
        if (head.pos == head.limit) {
            source.head = head.pop();
            SegmentPool.recycle(head);
        }
        return size;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.sink.flush();
    }

    @Override // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            Throwable thrown = doFinal();
            try {
                this.sink.close();
            } catch (Throwable e) {
                if (thrown == null) {
                    thrown = e;
                }
            }
            if (thrown != null) {
                throw thrown;
            }
        }
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return null;
        }
        Throwable thrown = null;
        Buffer buffer = this.sink.getBuffer();
        Segment s = buffer.writableSegment$okio(outputSize);
        try {
            int ciphered = this.cipher.doFinal(s.data, s.limit);
            s.limit += ciphered;
            buffer.setSize$okio(buffer.size() + ((long) ciphered));
        } catch (Throwable e) {
            thrown = e;
        }
        if (s.pos == s.limit) {
            buffer.head = s.pop();
            SegmentPool.recycle(s);
        }
        return thrown;
    }
}
