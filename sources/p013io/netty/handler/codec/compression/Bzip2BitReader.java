package p013io.netty.handler.codec.compression;

import p013io.netty.buffer.ByteBuf;

/* renamed from: io.netty.handler.codec.compression.Bzip2BitReader */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2BitReader.class */
class Bzip2BitReader {
    private static final int MAX_COUNT_OF_READABLE_BYTES = 268435455;

    /* renamed from: in */
    private ByteBuf f961in;
    private long bitBuffer;
    private int bitCount;

    /* access modifiers changed from: package-private */
    public void setByteBuf(ByteBuf in) {
        this.f961in = in;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* access modifiers changed from: package-private */
    public int readBits(int count) {
        int offset;
        long readData;
        if (count < 0 || count > 32) {
            throw new IllegalArgumentException("count: " + count + " (expected: 0-32 )");
        }
        int bitCount = this.bitCount;
        int i = this.bitBuffer;
        long bitBuffer = i;
        if (bitCount < count) {
            switch (this.f961in.readableBytes()) {
                case 1:
                    readData = (long) this.f961in.readUnsignedByte();
                    offset = 8;
                    break;
                case 2:
                    readData = (long) this.f961in.readUnsignedShort();
                    offset = 16;
                    break;
                case 3:
                    readData = (long) this.f961in.readUnsignedMedium();
                    offset = 24;
                    break;
                default:
                    readData = this.f961in.readUnsignedInt();
                    offset = 32;
                    break;
            }
            long bitBuffer2 = (i << offset) | readData;
            bitCount += offset;
            this.bitBuffer = bitBuffer2;
            bitBuffer = bitBuffer2;
        }
        int bitCount2 = bitCount - count;
        this.bitCount = bitCount2;
        return (int) (((bitBuffer == 1 ? 1 : 0) >>> bitCount2) & (count != 32 ? (long) ((1 << count) - 1) : 4294967295L));
    }

    /* access modifiers changed from: package-private */
    public boolean readBoolean() {
        return readBits(1) != 0;
    }

    /* access modifiers changed from: package-private */
    public int readInt() {
        return readBits(32);
    }

    /* access modifiers changed from: package-private */
    public void refill() {
        this.bitBuffer = (this.bitBuffer << 8) | ((long) this.f961in.readUnsignedByte());
        this.bitCount += 8;
    }

    /* access modifiers changed from: package-private */
    public boolean isReadable() {
        return this.bitCount > 0 || this.f961in.isReadable();
    }

    /* access modifiers changed from: package-private */
    public boolean hasReadableBits(int count) {
        if (count >= 0) {
            return this.bitCount >= count || ((this.f961in.readableBytes() << 3) & Integer.MAX_VALUE) >= count - this.bitCount;
        }
        throw new IllegalArgumentException("count: " + count + " (expected value greater than 0)");
    }

    /* access modifiers changed from: package-private */
    public boolean hasReadableBytes(int count) {
        if (count >= 0 && count <= MAX_COUNT_OF_READABLE_BYTES) {
            return hasReadableBits(count << 3);
        }
        throw new IllegalArgumentException("count: " + count + " (expected: 0-" + MAX_COUNT_OF_READABLE_BYTES + ')');
    }
}
