package p014it.unimi.dsi.fastutil.p015io;

/* renamed from: it.unimi.dsi.fastutil.io.FastByteArrayInputStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/FastByteArrayInputStream.class */
public class FastByteArrayInputStream extends MeasurableInputStream implements RepositionableStream {
    public byte[] array;
    public int offset;
    public int length;
    private int position;
    private int mark;

    public FastByteArrayInputStream(byte[] array, int offset, int length) {
        this.array = array;
        this.offset = offset;
        this.length = length;
    }

    public FastByteArrayInputStream(byte[] array) {
        this(array, 0, array.length);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.position = this.mark;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public void mark(int dummy) {
        this.mark = this.position;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.length - this.position;
    }

    @Override // java.io.InputStream
    public long skip(long n) {
        if (n <= ((long) (this.length - this.position))) {
            this.position += (int) n;
            return n;
        }
        long n2 = (long) (this.length - this.position);
        this.position = this.length;
        return n2;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.length == this.position) {
            return -1;
        }
        byte[] bArr = this.array;
        int i = this.offset;
        int i2 = this.position;
        this.position = i2 + 1;
        return bArr[i + i2] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int offset, int length) {
        if (this.length == this.position) {
            return length == 0 ? 0 : -1;
        }
        int n = Math.min(length, this.length - this.position);
        System.arraycopy(this.array, this.offset + this.position, b, offset, n);
        this.position += n;
        return n;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream, p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public long position() {
        return (long) this.position;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public void position(long newPosition) {
        this.position = (int) Math.min(newPosition, (long) this.length);
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream
    public long length() {
        return (long) this.length;
    }
}
