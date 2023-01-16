package p013io.netty.buffer;

import java.nio.ByteOrder;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.buffer.AbstractUnsafeSwappedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/AbstractUnsafeSwappedByteBuf.class */
abstract class AbstractUnsafeSwappedByteBuf extends SwappedByteBuf {
    private final boolean nativeByteOrder;
    private final AbstractByteBuf wrapped;
    static final /* synthetic */ boolean $assertionsDisabled;

    protected abstract short _getShort(AbstractByteBuf abstractByteBuf, int i);

    protected abstract int _getInt(AbstractByteBuf abstractByteBuf, int i);

    protected abstract long _getLong(AbstractByteBuf abstractByteBuf, int i);

    protected abstract void _setShort(AbstractByteBuf abstractByteBuf, int i, short s);

    protected abstract void _setInt(AbstractByteBuf abstractByteBuf, int i, int i2);

    protected abstract void _setLong(AbstractByteBuf abstractByteBuf, int i, long j);

    static {
        $assertionsDisabled = !AbstractUnsafeSwappedByteBuf.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public AbstractUnsafeSwappedByteBuf(AbstractByteBuf buf) {
        super(buf);
        if ($assertionsDisabled || PlatformDependent.isUnaligned()) {
            this.wrapped = buf;
            this.nativeByteOrder = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER == (order() == ByteOrder.BIG_ENDIAN);
            return;
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final long getLong(int index) {
        this.wrapped.checkIndex(index, 8);
        long v = _getLong(this.wrapped, index);
        return this.nativeByteOrder ? v : Long.reverseBytes(v);
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final float getFloat(int index) {
        return Float.intBitsToFloat(getInt(index));
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final double getDouble(int index) {
        return Double.longBitsToDouble(getLong(index));
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final char getChar(int index) {
        return (char) getShort(index);
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final long getUnsignedInt(int index) {
        return ((long) getInt(index)) & 4294967295L;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final int getInt(int index) {
        this.wrapped.checkIndex(index, 4);
        int v = _getInt(this.wrapped, index);
        return this.nativeByteOrder ? v : Integer.reverseBytes(v);
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final int getUnsignedShort(int index) {
        return getShort(index) & 65535;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final short getShort(int index) {
        this.wrapped.checkIndex(index, 2);
        short v = _getShort(this.wrapped, index);
        return this.nativeByteOrder ? v : Short.reverseBytes(v);
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf setShort(int index, int value) {
        this.wrapped.checkIndex(index, 2);
        _setShort(this.wrapped, index, this.nativeByteOrder ? (short) value : Short.reverseBytes((short) value));
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf setInt(int index, int value) {
        this.wrapped.checkIndex(index, 4);
        _setInt(this.wrapped, index, this.nativeByteOrder ? value : Integer.reverseBytes(value));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf setLong(int index, long j) {
        this.wrapped.checkIndex(index, 8);
        _setLong(this.wrapped, index, (this.nativeByteOrder ? j : Long.reverseBytes(j)) == true ? 1 : 0);
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf setChar(int index, int value) {
        setShort(index, value);
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf setFloat(int index, float value) {
        setInt(index, Float.floatToRawIntBits(value));
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf setDouble(int index, double value) {
        setLong(index, Double.doubleToRawLongBits(value));
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf writeShort(int value) {
        this.wrapped.ensureWritable0(2);
        _setShort(this.wrapped, this.wrapped.writerIndex, this.nativeByteOrder ? (short) value : Short.reverseBytes((short) value));
        this.wrapped.writerIndex += 2;
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf writeInt(int value) {
        this.wrapped.ensureWritable0(4);
        _setInt(this.wrapped, this.wrapped.writerIndex, this.nativeByteOrder ? value : Integer.reverseBytes(value));
        this.wrapped.writerIndex += 4;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf writeLong(long j) {
        this.wrapped.ensureWritable0(8);
        _setLong(this.wrapped, this.wrapped.writerIndex, (this.nativeByteOrder ? j : Long.reverseBytes(j)) == true ? 1 : 0);
        this.wrapped.writerIndex += 8;
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf writeChar(int value) {
        writeShort(value);
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf writeFloat(float value) {
        writeInt(Float.floatToRawIntBits(value));
        return this;
    }

    @Override // p013io.netty.buffer.SwappedByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf writeDouble(double value) {
        writeLong(Double.doubleToRawLongBits(value));
        return this;
    }
}
