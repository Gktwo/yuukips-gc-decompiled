package p014it.unimi.dsi.fastutil.p015io;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileChannel;

/* renamed from: it.unimi.dsi.fastutil.io.FastBufferedOutputStream */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/FastBufferedOutputStream.class */
public class FastBufferedOutputStream extends MeasurableOutputStream implements RepositionableStream {
    private static final boolean ASSERTS = false;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    protected byte[] buffer;
    protected int pos;
    protected int avail;

    /* renamed from: os */
    protected OutputStream f2209os;
    private FileChannel fileChannel;
    private RepositionableStream repositionableStream;
    private MeasurableStream measurableStream;

    private static int ensureBufferSize(int bufferSize) {
        if (bufferSize > 0) {
            return bufferSize;
        }
        throw new IllegalArgumentException("Illegal buffer size: " + bufferSize);
    }

    public FastBufferedOutputStream(OutputStream os, byte[] buffer) {
        this.f2209os = os;
        ensureBufferSize(buffer.length);
        this.buffer = buffer;
        this.avail = buffer.length;
        if (os instanceof RepositionableStream) {
            this.repositionableStream = (RepositionableStream) os;
        }
        if (os instanceof MeasurableStream) {
            this.measurableStream = (MeasurableStream) os;
        }
        if (this.repositionableStream == null) {
            try {
                this.fileChannel = (FileChannel) os.getClass().getMethod("getChannel", new Class[0]).invoke(os, new Object[0]);
            } catch (ClassCastException e) {
            } catch (IllegalAccessException e2) {
            } catch (IllegalArgumentException e3) {
            } catch (NoSuchMethodException e4) {
            } catch (InvocationTargetException e5) {
            }
        }
    }

    public FastBufferedOutputStream(OutputStream os, int bufferSize) {
        this(os, new byte[ensureBufferSize(bufferSize)]);
    }

    public FastBufferedOutputStream(OutputStream os) {
        this(os, 8192);
    }

    private void dumpBuffer(boolean ifFull) throws IOException {
        if (this.pos != 0) {
            if (!ifFull || this.avail == 0) {
                this.f2209os.write(this.buffer, 0, this.pos);
                this.pos = 0;
                this.avail = this.buffer.length;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.avail--;
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        bArr[i] = (byte) b;
        dumpBuffer(true);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int offset, int length) throws IOException {
        if (length >= this.buffer.length) {
            dumpBuffer(false);
            this.f2209os.write(b, offset, length);
        } else if (length <= this.avail) {
            System.arraycopy(b, offset, this.buffer, this.pos, length);
            this.pos += length;
            this.avail -= length;
            dumpBuffer(true);
        } else {
            dumpBuffer(false);
            System.arraycopy(b, offset, this.buffer, 0, length);
            this.pos = length;
            this.avail -= length;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        dumpBuffer(false);
        this.f2209os.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f2209os != null) {
            flush();
            if (this.f2209os != System.out) {
                this.f2209os.close();
            }
            this.f2209os = null;
            this.buffer = null;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream, p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public long position() throws IOException {
        if (this.repositionableStream != null) {
            return this.repositionableStream.position() + ((long) this.pos);
        }
        if (this.measurableStream != null) {
            return this.measurableStream.position() + ((long) this.pos);
        }
        if (this.fileChannel != null) {
            return this.fileChannel.position() + ((long) this.pos);
        }
        throw new UnsupportedOperationException("position() can only be called if the underlying byte stream implements the MeasurableStream or RepositionableStream interface or if the getChannel() method of the underlying byte stream exists and returns a FileChannel");
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.RepositionableStream
    public void position(long newPosition) throws IOException {
        flush();
        if (this.repositionableStream != null) {
            this.repositionableStream.position(newPosition);
        } else if (this.fileChannel != null) {
            this.fileChannel.position(newPosition);
        } else {
            throw new UnsupportedOperationException("position() can only be called if the underlying byte stream implements the RepositionableStream interface or if the getChannel() method of the underlying byte stream exists and returns a FileChannel");
        }
    }

    @Override // p014it.unimi.dsi.fastutil.p015io.MeasurableStream
    public long length() throws IOException {
        flush();
        if (this.measurableStream != null) {
            return this.measurableStream.length();
        }
        if (this.fileChannel != null) {
            return this.fileChannel.size();
        }
        throw new UnsupportedOperationException();
    }
}
