package p014it.unimi.dsi.fastutil.p015io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: it.unimi.dsi.fastutil.io.FastMultiByteArrayInputStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/FastMultiByteArrayInputStream.class */
public class FastMultiByteArrayInputStream extends MeasurableInputStream implements RepositionableStream {
    public static final int SLICE_BITS = 30;
    public static final int SLICE_SIZE = 1073741824;
    public static final int SLICE_MASK = 1073741823;
    public byte[][] array;
    public byte[] current;
    public long length;
    private long position;

    public FastMultiByteArrayInputStream(MeasurableInputStream is) throws IOException {
        this(is, is.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FastMultiByteArrayInputStream(java.io.InputStream r8, long r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = r7
            r0.<init>()
            r0 = r7
            r1 = r9
            r0.length = r1
            r0 = r7
            r1 = r9
            r2 = 1073741824(0x40000000, double:5.304989477E-315)
            long r1 = r1 + r2
            r2 = 1
            long r1 = r1 - r2
            r2 = 1073741824(0x40000000, double:5.304989477E-315)
            long r1 = r1 / r2
            int r1 = (int) r1
            r2 = 1
            int r1 = r1 + r2
            byte[][] r1 = new byte[r1]
            r0.array = r1
            r0 = 0
            r11 = r0
        L_0x0021:
            r0 = r11
            r1 = r7
            byte[][] r1 = r1.array
            int r1 = r1.length
            r2 = 1
            int r1 = r1 - r2
            if (r0 >= r1) goto L_0x0077
            r0 = r7
            byte[][] r0 = r0.array
            r1 = r11
            r2 = r9
            r3 = 1073741824(0x40000000, double:5.304989477E-315)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0040
            r2 = 1073741824(0x40000000, float:2.0)
            goto L_0x0042
        L_0x0040:
            r2 = r9
            int r2 = (int) r2
        L_0x0042:
            byte[] r2 = new byte[r2]
            r0[r1] = r2
            r0 = r8
            r1 = r7
            byte[][] r1 = r1.array
            r2 = r11
            r1 = r1[r2]
            long r0 = read(r0, r1)
            r1 = r7
            byte[][] r1 = r1.array
            r2 = r11
            r1 = r1[r2]
            int r1 = r1.length
            long r1 = (long) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0065
            java.io.EOFException r0 = new java.io.EOFException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0065:
            r0 = r9
            r1 = r7
            byte[][] r1 = r1.array
            r2 = r11
            r1 = r1[r2]
            int r1 = r1.length
            long r1 = (long) r1
            long r0 = r0 - r1
            r9 = r0
            int r11 = r11 + 1
            goto L_0x0021
        L_0x0077:
            r0 = r7
            r1 = r7
            byte[][] r1 = r1.array
            r2 = 0
            r1 = r1[r2]
            r0.current = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.p015io.FastMultiByteArrayInputStream.<init>(java.io.InputStream, long):void");
    }

    private static long read(InputStream is, byte[] a) throws IOException {
        if (a.length == 0) {
            return 0;
        }
        int read = 0;
        do {
            int result = is.read(a, read, Math.min(a.length - read, 1048576));
            if (result < 0) {
                return (long) read;
            }
            read += result;
        } while (read < a.length);
        return (long) read;
    }

    public FastMultiByteArrayInputStream(FastMultiByteArrayInputStream is) {
        this.array = is.array;
        this.length = is.length;
        this.current = this.array[0];
    }

    public FastMultiByteArrayInputStream(byte[] array) {
        if (array.length == 0) {
            this.array = new byte[1];
            return;
        }
        this.array = new byte[2];
        this.array[0] = array;
        this.length = (long) array.length;
        this.current = array;
    }

    @Override // java.io.InputStream
    public int available() {
        return (int) Math.min(2147483647L, this.length - this.position);
    }

    @Override // java.io.InputStream
    public long skip(long n) {
        if (n > this.length - this.position) {
            n = this.length - this.position;
        }
        this.position += n;
        updateCurrent();
        return n;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.length == this.position) {
            return -1;
        }
        long j = this.position;
        this.position = j + 1;
        int disp = (int) (j & 1073741823);
        if (disp == 0) {
            updateCurrent();
        }
        return this.current[disp] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int offset, int length) {
        long remaining = this.length - this.position;
        if (remaining == 0) {
            return length == 0 ? 0 : -1;
        }
        int n = (int) Math.min((long) length, remaining);
        while (true) {
            int disp = (int) (this.position & 1073741823);
            if (disp == 0) {
                updateCurrent();
            }
            int res = Math.min(n, this.current.length - disp);
            System.arraycopy(this.current, disp, b, offset, res);
            n -= res;
            this.position += (long) res;
            if (n == 0) {
                return n;
            }
            offset += res;
        }
    }

    private void updateCurrent() {
        this.current = this.array[(int) (this.position >>> 30)];
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream, p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public long position() {
        return this.position;
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public void position(long newPosition) {
        this.position = Math.min(newPosition, this.length);
        updateCurrent();
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream
    public long length() throws IOException {
        return this.length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int dummy) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }
}
