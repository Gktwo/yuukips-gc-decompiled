package p014it.unimi.dsi.fastutil.shorts;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortMappedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortMappedBigList.class */
public class ShortMappedBigList extends AbstractShortBigList {
    public static int LOG2_BYTES = 63 - Long.numberOfLeadingZeros(2);
    @Deprecated
    public static int LOG2_BITS = 63 - Long.numberOfLeadingZeros(2);
    private static int CHUNK_SHIFT = 30 - LOG2_BYTES;
    public static final long CHUNK_SIZE = 1 << CHUNK_SHIFT;
    private static final long CHUNK_MASK = CHUNK_SIZE - 1;
    private final ShortBuffer[] buffer;
    private final boolean[] readyToUse;

    /* renamed from: n */
    private final int f3059n;
    private final long size;

    protected ShortMappedBigList(ShortBuffer[] buffer, long size, boolean[] readyToUse) {
        this.buffer = buffer;
        this.f3059n = buffer.length;
        this.size = size;
        this.readyToUse = readyToUse;
        for (int i = 0; i < this.f3059n; i++) {
            if (i < this.f3059n - 1 && ((long) buffer[i].capacity()) != CHUNK_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ShortMappedBigList map(FileChannel fileChannel) throws IOException {
        return map(fileChannel, ByteOrder.BIG_ENDIAN);
    }

    public static ShortMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder) throws IOException {
        return map(fileChannel, byteOrder, FileChannel.MapMode.READ_ONLY);
    }

    public static ShortMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder, FileChannel.MapMode mapMode) throws IOException {
        long size = fileChannel.size() / 2;
        int chunks = (int) ((size + (CHUNK_SIZE - 1)) / CHUNK_SIZE);
        ShortBuffer[] buffer = new ShortBuffer[chunks];
        for (int i = 0; i < chunks; i++) {
            buffer[i] = fileChannel.map(mapMode, ((long) i) * CHUNK_SIZE * 2, Math.min(CHUNK_SIZE, size - (((long) i) * CHUNK_SIZE)) * 2).order(byteOrder).asShortBuffer();
        }
        boolean[] readyToUse = new boolean[chunks];
        Arrays.fill(readyToUse, true);
        return new ShortMappedBigList(buffer, size, readyToUse);
    }

    private ShortBuffer ShortBuffer(int n) {
        if (this.readyToUse[n]) {
            return this.buffer[n];
        }
        this.readyToUse[n] = true;
        ShortBuffer[] shortBufferArr = this.buffer;
        ShortBuffer duplicate = this.buffer[n].duplicate();
        shortBufferArr[n] = duplicate;
        return duplicate;
    }

    public ShortMappedBigList copy() {
        return new ShortMappedBigList((ShortBuffer[]) this.buffer.clone(), this.size, new boolean[this.f3059n]);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public short getShort(long index) {
        return ShortBuffer((int) (index >>> CHUNK_SHIFT)).get((int) (index & CHUNK_MASK));
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public void getElements(long from, short[] a, int offset, int length) {
        int chunk = (int) (from >>> CHUNK_SHIFT);
        int displ = (int) (from & CHUNK_MASK);
        while (length > 0) {
            ShortBuffer b = ShortBuffer(chunk);
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

    @Override // p014it.unimi.dsi.fastutil.shorts.AbstractShortBigList, p014it.unimi.dsi.fastutil.shorts.ShortBigList
    public short set(long index, short value) {
        ShortBuffer b = ShortBuffer((int) (index >>> CHUNK_SHIFT));
        int i = (int) (index & CHUNK_MASK);
        short previousValue = b.get(i);
        b.put(i, value);
        return previousValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }
}
