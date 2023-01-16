package p014it.unimi.dsi.fastutil.bytes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteMappedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteMappedBigList.class */
public class ByteMappedBigList extends AbstractByteBigList {
    public static int LOG2_BYTES = 63 - Long.numberOfLeadingZeros(1);
    @Deprecated
    public static int LOG2_BITS = 63 - Long.numberOfLeadingZeros(1);
    private static int CHUNK_SHIFT = 30 - LOG2_BYTES;
    public static final long CHUNK_SIZE = 1 << CHUNK_SHIFT;
    private static final long CHUNK_MASK = CHUNK_SIZE - 1;
    private final ByteBuffer[] buffer;
    private final boolean[] readyToUse;

    /* renamed from: n */
    private final int f1291n;
    private final long size;

    protected ByteMappedBigList(ByteBuffer[] buffer, long size, boolean[] readyToUse) {
        this.buffer = buffer;
        this.f1291n = buffer.length;
        this.size = size;
        this.readyToUse = readyToUse;
        for (int i = 0; i < this.f1291n; i++) {
            if (i < this.f1291n - 1 && ((long) buffer[i].capacity()) != CHUNK_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ByteMappedBigList map(FileChannel fileChannel) throws IOException {
        return map(fileChannel, ByteOrder.BIG_ENDIAN);
    }

    public static ByteMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder) throws IOException {
        return map(fileChannel, byteOrder, FileChannel.MapMode.READ_ONLY);
    }

    public static ByteMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder, FileChannel.MapMode mapMode) throws IOException {
        long size = fileChannel.size() / 1;
        int chunks = (int) ((size + (CHUNK_SIZE - 1)) / CHUNK_SIZE);
        ByteBuffer[] buffer = new ByteBuffer[chunks];
        for (int i = 0; i < chunks; i++) {
            buffer[i] = fileChannel.map(mapMode, ((long) i) * CHUNK_SIZE * 1, Math.min(CHUNK_SIZE, size - (((long) i) * CHUNK_SIZE)) * 1);
        }
        boolean[] readyToUse = new boolean[chunks];
        Arrays.fill(readyToUse, true);
        return new ByteMappedBigList(buffer, size, readyToUse);
    }

    private ByteBuffer ByteBuffer(int n) {
        if (this.readyToUse[n]) {
            return this.buffer[n];
        }
        this.readyToUse[n] = true;
        ByteBuffer[] byteBufferArr = this.buffer;
        ByteBuffer duplicate = this.buffer[n].duplicate();
        byteBufferArr[n] = duplicate;
        return duplicate;
    }

    public ByteMappedBigList copy() {
        return new ByteMappedBigList((ByteBuffer[]) this.buffer.clone(), this.size, new boolean[this.f1291n]);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
    public byte getByte(long index) {
        return ByteBuffer((int) (index >>> CHUNK_SHIFT)).get((int) (index & CHUNK_MASK));
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBigList
    public void getElements(long from, byte[] a, int offset, int length) {
        int chunk = (int) (from >>> CHUNK_SHIFT);
        int displ = (int) (from & CHUNK_MASK);
        while (length > 0) {
            ByteBuffer b = ByteBuffer(chunk);
            int l = Math.min(b.capacity() - displ, length);
            if (l == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            b.position(displ);
            b.get(a, offset, l);
            int i = displ + l;
            displ = i;
            if (((long) i) == CHUNK_SIZE) {
                displ = 0;
                chunk++;
            }
            offset += l;
            length -= l;
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.AbstractByteBigList, p014it.unimi.dsi.fastutil.bytes.ByteBigList
    public byte set(long index, byte value) {
        ByteBuffer b = ByteBuffer((int) (index >>> CHUNK_SHIFT));
        int i = (int) (index & CHUNK_MASK);
        byte previousValue = b.get(i);
        b.put(i, value);
        return previousValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }
}
