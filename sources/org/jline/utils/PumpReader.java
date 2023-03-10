package org.jline.utils;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/PumpReader.class */
public class PumpReader extends Reader {
    private static final int EOF = -1;
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private final CharBuffer readBuffer;
    private final CharBuffer writeBuffer;
    private final Writer writer;
    private boolean closed;

    public PumpReader() {
        this(4096);
    }

    public PumpReader(int bufferSize) {
        char[] buf = new char[Math.max(bufferSize, 2)];
        this.readBuffer = CharBuffer.wrap(buf);
        this.writeBuffer = CharBuffer.wrap(buf);
        this.writer = new Writer();
        this.readBuffer.limit(0);
    }

    public java.io.Writer getWriter() {
        return this.writer;
    }

    public java.io.InputStream createInputStream(Charset charset) {
        return new InputStream(charset);
    }

    private boolean waitForMoreInput() throws InterruptedIOException {
        if (!this.writeBuffer.hasRemaining()) {
            throw new AssertionError("No space in write buffer");
        }
        int oldRemaining = this.readBuffer.remaining();
        while (!this.closed) {
            notifyAll();
            try {
                wait();
                if (this.readBuffer.remaining() > oldRemaining) {
                    return true;
                }
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        }
        return false;
    }

    private boolean wait(CharBuffer buffer) throws InterruptedIOException {
        while (!buffer.hasRemaining()) {
            if (this.closed) {
                return false;
            }
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
        }
        return true;
    }

    private boolean waitForInput() throws InterruptedIOException {
        return wait(this.readBuffer);
    }

    private void waitForBufferSpace() throws InterruptedIOException, ClosedException {
        if (!wait(this.writeBuffer) || this.closed) {
            throw new ClosedException();
        }
    }

    private static boolean rewind(CharBuffer buffer, CharBuffer other) {
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

    private boolean rewindReadBuffer() {
        boolean rw = rewind(this.readBuffer, this.writeBuffer) && this.readBuffer.hasRemaining();
        notifyAll();
        return rw;
    }

    private void rewindWriteBuffer() {
        rewind(this.writeBuffer, this.readBuffer);
        notifyAll();
    }

    @Override // java.io.Reader
    public synchronized boolean ready() {
        return this.readBuffer.hasRemaining();
    }

    public synchronized int available() {
        int count = this.readBuffer.remaining();
        if (this.writeBuffer.position() < this.readBuffer.position()) {
            count += this.writeBuffer.position();
        }
        return count;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        if (!waitForInput()) {
            return -1;
        }
        int b = this.readBuffer.get();
        rewindReadBuffer();
        return b;
    }

    private int copyFromBuffer(char[] cbuf, int off, int len) {
        int len2 = Math.min(len, this.readBuffer.remaining());
        this.readBuffer.get(cbuf, off, len2);
        return len2;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cbuf, int off, int len) throws IOException {
        if (len == 0) {
            return 0;
        }
        if (!waitForInput()) {
            return -1;
        }
        int count = copyFromBuffer(cbuf, off, len);
        if (rewindReadBuffer() && count < len) {
            count += copyFromBuffer(cbuf, off + count, len - count);
            rewindReadBuffer();
        }
        return count;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer target) throws IOException {
        if (!target.hasRemaining()) {
            return 0;
        }
        if (!waitForInput()) {
            return -1;
        }
        int count = this.readBuffer.read(target);
        if (rewindReadBuffer() && target.hasRemaining()) {
            count += this.readBuffer.read(target);
            rewindReadBuffer();
        }
        return count;
    }

    private void encodeBytes(CharsetEncoder encoder, ByteBuffer output) throws IOException {
        int oldPos = output.position();
        CoderResult result = encoder.encode(this.readBuffer, output, false);
        int encodedCount = output.position() - oldPos;
        if (result.isUnderflow()) {
            boolean hasMoreInput = rewindReadBuffer();
            boolean reachedEndOfInput = false;
            if (encodedCount == 0 && !hasMoreInput) {
                reachedEndOfInput = !waitForMoreInput();
            }
            CoderResult result2 = encoder.encode(this.readBuffer, output, reachedEndOfInput);
            if (result2.isError()) {
                result2.throwException();
            }
            if (reachedEndOfInput || output.position() - oldPos != 0) {
                rewindReadBuffer();
                return;
            }
            throw new AssertionError("Failed to encode any chars");
        } else if (!result.isOverflow()) {
            result.throwException();
        } else if (encodedCount == 0) {
            throw new AssertionError("Output buffer has not enough space");
        }
    }

    synchronized int readBytes(CharsetEncoder encoder, byte[] b, int off, int len) throws IOException {
        if (!waitForInput()) {
            return 0;
        }
        ByteBuffer output = ByteBuffer.wrap(b, off, len);
        encodeBytes(encoder, output);
        return output.position() - off;
    }

    synchronized void readBytes(CharsetEncoder encoder, ByteBuffer output) throws IOException {
        if (waitForInput()) {
            encodeBytes(encoder, output);
        }
    }

    synchronized void write(char c) throws IOException {
        waitForBufferSpace();
        this.writeBuffer.put(c);
        rewindWriteBuffer();
    }

    synchronized void write(char[] cbuf, int off, int len) throws IOException {
        while (len > 0) {
            waitForBufferSpace();
            int count = Math.min(len, this.writeBuffer.remaining());
            this.writeBuffer.put(cbuf, off, count);
            off += count;
            len -= count;
            rewindWriteBuffer();
        }
    }

    synchronized void write(String str, int off, int len) throws IOException {
        char[] buf = this.writeBuffer.array();
        while (len > 0) {
            waitForBufferSpace();
            int count = Math.min(len, this.writeBuffer.remaining());
            str.getChars(off, off + count, buf, this.writeBuffer.position());
            this.writeBuffer.position(this.writeBuffer.position() + count);
            off += count;
            len -= count;
            rewindWriteBuffer();
        }
    }

    synchronized void flush() {
        if (this.readBuffer.hasRemaining()) {
            notifyAll();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        notifyAll();
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/utils/PumpReader$Writer.class */
    private static class Writer extends java.io.Writer {
        private final PumpReader reader;

        private Writer(PumpReader reader) {
            this.reader = reader;
        }

        @Override // java.io.Writer
        public void write(int c) throws IOException {
            this.reader.write((char) c);
        }

        @Override // java.io.Writer
        public void write(char[] cbuf, int off, int len) throws IOException {
            this.reader.write(cbuf, off, len);
        }

        @Override // java.io.Writer
        public void write(String str, int off, int len) throws IOException {
            this.reader.write(str, off, len);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            this.reader.flush();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.reader.close();
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/utils/PumpReader$InputStream.class */
    private static class InputStream extends java.io.InputStream {
        private final PumpReader reader;
        private final CharsetEncoder encoder;
        private final ByteBuffer buffer;

        private InputStream(PumpReader reader, Charset charset) {
            this.reader = reader;
            this.encoder = charset.newEncoder().onUnmappableCharacter(CodingErrorAction.REPLACE).onMalformedInput(CodingErrorAction.REPLACE);
            this.buffer = ByteBuffer.allocate((int) Math.ceil((double) (this.encoder.maxBytesPerChar() * 2.0f)));
            this.buffer.limit(0);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return ((int) (((double) this.reader.available()) * ((double) this.encoder.averageBytesPerChar()))) + this.buffer.remaining();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.buffer.hasRemaining() || readUsingBuffer()) {
                return this.buffer.get();
            }
            return -1;
        }

        private boolean readUsingBuffer() throws IOException {
            this.buffer.clear();
            this.reader.readBytes(this.encoder, this.buffer);
            this.buffer.flip();
            return this.buffer.hasRemaining();
        }

        private int copyFromBuffer(byte[] b, int off, int len) {
            int len2 = Math.min(len, this.buffer.remaining());
            this.buffer.get(b, off, len2);
            return len2;
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
            int read;
            if (len == 0) {
                return 0;
            }
            if (this.buffer.hasRemaining()) {
                read = copyFromBuffer(b, off, len);
                if (read == len) {
                    return len;
                }
                off += read;
                len -= read;
            } else {
                read = 0;
            }
            if (len >= this.buffer.capacity()) {
                read += this.reader.readBytes(this.encoder, b, off, len);
            } else if (readUsingBuffer()) {
                read += copyFromBuffer(b, off, len);
            }
            if (read == 0) {
                return -1;
            }
            return read;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.reader.close();
        }
    }
}
