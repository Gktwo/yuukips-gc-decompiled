package p014it.unimi.dsi.fastutil.p015io;

import java.io.IOException;
import p014it.unimi.dsi.fastutil.bytes.ByteArrays;

/* renamed from: it.unimi.dsi.fastutil.io.FastByteArrayOutputStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/FastByteArrayOutputStream.class */
public class FastByteArrayOutputStream extends MeasurableOutputStream implements RepositionableStream {
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public byte[] array;
    public int length;
    private int position;

    public FastByteArrayOutputStream() {
        this(16);
    }

    public FastByteArrayOutputStream(int initialCapacity) {
        this.array = new byte[initialCapacity];
    }

    public FastByteArrayOutputStream(byte[] a) {
        this.array = a;
    }

    public void reset() {
        this.length = 0;
        this.position = 0;
    }

    public void trim() {
        this.array = ByteArrays.trim(this.array, this.length);
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        if (this.position >= this.array.length) {
            this.array = ByteArrays.grow(this.array, this.position + 1, this.length);
        }
        byte[] bArr = this.array;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = (byte) b;
        if (this.length < this.position) {
            this.length = this.position;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        ByteArrays.ensureOffsetLength(b, off, len);
        if (this.position + len > this.array.length) {
            this.array = ByteArrays.grow(this.array, this.position + len, this.position);
        }
        System.arraycopy(b, off, this.array, this.position, len);
        if (this.position + len > this.length) {
            int i = this.position + len;
            this.position = i;
            this.length = i;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public void position(long newPosition) {
        if (this.position > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Position too large: " + newPosition);
        }
        this.position = (int) newPosition;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream, p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public long position() {
        return (long) this.position;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream
    public long length() throws IOException {
        return (long) this.length;
    }
}
