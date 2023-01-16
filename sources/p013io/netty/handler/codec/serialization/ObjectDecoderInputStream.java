package p013io.netty.handler.codec.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.StreamCorruptedException;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.serialization.ObjectDecoderInputStream */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ObjectDecoderInputStream.class */
public class ObjectDecoderInputStream extends InputStream implements ObjectInput {

    /* renamed from: in */
    private final DataInputStream f1011in;
    private final int maxObjectSize;
    private final ClassResolver classResolver;

    public ObjectDecoderInputStream(InputStream in) {
        this(in, (ClassLoader) null);
    }

    public ObjectDecoderInputStream(InputStream in, ClassLoader classLoader) {
        this(in, classLoader, 1048576);
    }

    public ObjectDecoderInputStream(InputStream in, int maxObjectSize) {
        this(in, null, maxObjectSize);
    }

    public ObjectDecoderInputStream(InputStream in, ClassLoader classLoader, int maxObjectSize) {
        ObjectUtil.checkNotNull(in, "in");
        ObjectUtil.checkPositive(maxObjectSize, "maxObjectSize");
        if (in instanceof DataInputStream) {
            this.f1011in = (DataInputStream) in;
        } else {
            this.f1011in = new DataInputStream(in);
        }
        this.classResolver = ClassResolvers.weakCachingResolver(classLoader);
        this.maxObjectSize = maxObjectSize;
    }

    @Override // java.io.ObjectInput
    public Object readObject() throws ClassNotFoundException, IOException {
        int dataLen = readInt();
        if (dataLen <= 0) {
            throw new StreamCorruptedException("invalid data length: " + dataLen);
        } else if (dataLen <= this.maxObjectSize) {
            return new CompactObjectInputStream(this.f1011in, this.classResolver).readObject();
        } else {
            throw new StreamCorruptedException("data length too big: " + dataLen + " (max: " + this.maxObjectSize + ')');
        }
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int available() throws IOException {
        return this.f1011in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectInput
    public void close() throws IOException {
        this.f1011in.close();
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        this.f1011in.mark(readlimit);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f1011in.markSupported();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int read() throws IOException {
        return this.f1011in.read();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] b, int off, int len) throws IOException {
        return this.f1011in.read(b, off, len);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] b) throws IOException {
        return this.f1011in.read(b);
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        return this.f1011in.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        return this.f1011in.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        return this.f1011in.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return this.f1011in.readDouble();
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return this.f1011in.readFloat();
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] b, int off, int len) throws IOException {
        this.f1011in.readFully(b, off, len);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] b) throws IOException {
        this.f1011in.readFully(b);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        return this.f1011in.readInt();
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() throws IOException {
        return this.f1011in.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        return this.f1011in.readLong();
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        return this.f1011in.readShort();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        return this.f1011in.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return this.f1011in.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return this.f1011in.readUTF();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f1011in.reset();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public long skip(long n) throws IOException {
        return this.f1011in.skip(n);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int n) throws IOException {
        return this.f1011in.skipBytes(n);
    }
}
