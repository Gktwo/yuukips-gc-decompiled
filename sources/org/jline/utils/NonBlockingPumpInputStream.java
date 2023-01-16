package org.jline.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/NonBlockingPumpInputStream.class */
public class NonBlockingPumpInputStream extends NonBlockingInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private final ByteBuffer readBuffer;
    private final ByteBuffer writeBuffer;
    private final OutputStream output;
    private boolean closed;
    private IOException ioException;

    public NonBlockingPumpInputStream() {
        this(4096);
    }

    public NonBlockingPumpInputStream(int bufferSize) {
        byte[] buf = new byte[bufferSize];
        this.readBuffer = ByteBuffer.wrap(buf);
        this.writeBuffer = ByteBuffer.wrap(buf);
        this.output = new NbpOutputStream();
        this.readBuffer.limit(0);
    }

    public OutputStream getOutputStream() {
        return this.output;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x001c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, org.jline.utils.NonBlockingPumpInputStream] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r7v1, types: [long] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int wait(java.nio.ByteBuffer r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r9
            if (r0 != 0) goto L_0x001c
            long r0 = java.lang.System.currentTimeMillis()
            r1 = r7
            long r0 = r0 + r1
            r10 = r0
        L_0x001c:
            r0 = r5
            boolean r0 = r0.closed
            if (r0 != 0) goto L_0x0062
            r0 = r6
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x0062
            r0 = r9
            if (r0 != 0) goto L_0x0035
            r0 = r7
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0062
        L_0x0035:
            r0 = r5
            r0.notifyAll()
            r0 = r5
            r1 = r7
            r0.wait(r1)     // Catch: InterruptedException -> 0x0045
            r0 = r5
            r0.checkIoException()     // Catch: InterruptedException -> 0x0045
            goto L_0x0053
        L_0x0045:
            r12 = move-exception
            r0 = r5
            r0.checkIoException()
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0053:
            r0 = r9
            if (r0 != 0) goto L_0x001c
            r0 = r10
            long r1 = java.lang.System.currentTimeMillis()
            long r0 = r0 - r1
            r7 = r0
            goto L_0x001c
        L_0x0062:
            r0 = r6
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x006d
            r0 = 0
            goto L_0x007a
        L_0x006d:
            r0 = r5
            boolean r0 = r0.closed
            if (r0 == 0) goto L_0x0078
            r0 = -1
            goto L_0x007a
        L_0x0078:
            r0 = -2
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlockingPumpInputStream.wait(java.nio.ByteBuffer, long):int");
    }

    private static boolean rewind(ByteBuffer buffer, ByteBuffer other) {
        if (buffer.position() > other.position()) {
            other.limit(buffer.position());
        }
        if (buffer.position() != buffer.capacity()) {
            return false;
        }
        buffer.rewind();
        buffer.limit(other.position());
        return true;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        int count = this.readBuffer.remaining();
        if (this.writeBuffer.position() < this.readBuffer.position()) {
            count += this.writeBuffer.position();
        }
        return count;
    }

    @Override // org.jline.utils.NonBlockingInputStream
    public synchronized int read(long timeout, boolean isPeek) throws IOException {
        checkIoException();
        int res = wait(this.readBuffer, timeout);
        if (res >= 0) {
            res = this.readBuffer.get() & 255;
        }
        rewind(this.readBuffer, this.writeBuffer);
        return res;
    }

    @Override // org.jline.utils.NonBlockingInputStream
    public synchronized int readBuffered(byte[] b) throws IOException {
        checkIoException();
        int res = wait(this.readBuffer, 0);
        if (res >= 0) {
            res = 0;
            while (res < b.length && this.readBuffer.hasRemaining()) {
                res++;
                b[res] = (byte) (this.readBuffer.get() & 255);
            }
        }
        rewind(this.readBuffer, this.writeBuffer);
        return res;
    }

    public synchronized void setIoException(IOException exception) {
        this.ioException = exception;
        notifyAll();
    }

    protected synchronized void checkIoException() throws IOException {
        if (this.ioException != null) {
            throw this.ioException;
        }
    }

    synchronized void write(byte[] cbuf, int off, int len) throws IOException {
        while (len > 0) {
            if (wait(this.writeBuffer, 0) == -1) {
                throw new ClosedException();
            }
            int count = Math.min(len, this.writeBuffer.remaining());
            this.writeBuffer.put(cbuf, off, count);
            off += count;
            len -= count;
            rewind(this.writeBuffer, this.readBuffer);
        }
    }

    synchronized void flush() {
        if (this.readBuffer.hasRemaining()) {
            notifyAll();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        notifyAll();
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/utils/NonBlockingPumpInputStream$NbpOutputStream.class */
    private class NbpOutputStream extends OutputStream {
        private NbpOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            NonBlockingPumpInputStream.this.write(new byte[]{(byte) b}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] cbuf, int off, int len) throws IOException {
            NonBlockingPumpInputStream.this.write(cbuf, off, len);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            NonBlockingPumpInputStream.this.flush();
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            NonBlockingPumpInputStream.this.close();
        }
    }
}
