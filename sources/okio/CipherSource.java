package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CipherSource.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n��R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u001b"}, m373d2 = {"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "blockSize", "", "buffer", "Lokio/Buffer;", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "final", "close", "", "doFinal", "read", "", "sink", "byteCount", "refill", "timeout", "Lokio/Timeout;", "update", "okio"})
/* loaded from: grasscutter.jar:okio/CipherSource.class */
public final class CipherSource implements Source {
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final Cipher cipher;
    private final int blockSize;
    @NotNull
    private final Buffer buffer = new Buffer();

    /* renamed from: final  reason: not valid java name */
    private boolean f3350final;
    private boolean closed;

    public CipherSource(@NotNull BufferedSource source, @NotNull Cipher cipher) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.source = source;
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

    @Override // okio.Source
    public long read(@NotNull Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (byteCount == 0) {
            return 0;
        } else {
            if (this.f3350final) {
                return this.buffer.read(sink, byteCount);
            }
            refill();
            return this.buffer.read(sink, byteCount);
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0) {
            if (this.source.exhausted()) {
                this.f3350final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        Segment head = this.source.getBuffer().head;
        Intrinsics.checkNotNull(head);
        int size = head.limit - head.pos;
        int outputSize = this.cipher.getOutputSize(size);
        while (outputSize > 8192) {
            if (!(size > this.blockSize)) {
                throw new IllegalStateException(("Unexpected output size " + outputSize + " for input size " + size).toString());
            }
            size -= this.blockSize;
            outputSize = this.cipher.getOutputSize(size);
        }
        Segment s = this.buffer.writableSegment$okio(outputSize);
        int ciphered = this.cipher.update(head.data, head.pos, size, s.data, s.pos);
        this.source.skip((long) size);
        s.limit += ciphered;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + ((long) ciphered));
        if (s.pos == s.limit) {
            this.buffer.head = s.pop();
            SegmentPool.recycle(s);
        }
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize != 0) {
            Segment s = this.buffer.writableSegment$okio(outputSize);
            int ciphered = this.cipher.doFinal(s.data, s.pos);
            s.limit += ciphered;
            Buffer buffer = this.buffer;
            buffer.setSize$okio(buffer.size() + ((long) ciphered));
            if (s.pos == s.limit) {
                this.buffer.head = s.pop();
                SegmentPool.recycle(s);
            }
        }
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }
}
