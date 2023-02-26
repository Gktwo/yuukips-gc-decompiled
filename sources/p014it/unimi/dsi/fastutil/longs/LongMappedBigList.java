package p014it.unimi.dsi.fastutil.longs;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.longs.LongMappedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongMappedBigList.class */
public class LongMappedBigList extends AbstractLongBigList {
    public static int LOG2_BYTES = 63 - Long.numberOfLeadingZeros(8);
    @Deprecated
    public static int LOG2_BITS = 63 - Long.numberOfLeadingZeros(8);
    private static int CHUNK_SHIFT = 30 - LOG2_BYTES;
    public static final long CHUNK_SIZE = 1 << CHUNK_SHIFT;
    private static final long CHUNK_MASK = CHUNK_SIZE - 1;
    private final LongBuffer[] buffer;
    private final boolean[] readyToUse;

    /* renamed from: n */
    private final int f2393n;
    private final long size;

    protected LongMappedBigList(LongBuffer[] buffer, long size, boolean[] readyToUse) {
        this.buffer = buffer;
        this.f2393n = buffer.length;
        this.size = size;
        this.readyToUse = readyToUse;
        for (int i = 0; i < this.f2393n; i++) {
            if (i < this.f2393n - 1 && ((long) buffer[i].capacity()) != CHUNK_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static LongMappedBigList map(FileChannel fileChannel) throws IOException {
        return map(fileChannel, ByteOrder.BIG_ENDIAN);
    }

    public static LongMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder) throws IOException {
        return map(fileChannel, byteOrder, FileChannel.MapMode.READ_ONLY);
    }

    public static LongMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder, FileChannel.MapMode mapMode) throws IOException {
        long size = fileChannel.size() / 8;
        int chunks = (int) ((size + (CHUNK_SIZE - 1)) / CHUNK_SIZE);
        LongBuffer[] buffer = new LongBuffer[chunks];
        for (int i = 0; i < chunks; i++) {
            buffer[i] = fileChannel.map(mapMode, ((long) i) * CHUNK_SIZE * 8, Math.min(CHUNK_SIZE, size - (((long) i) * CHUNK_SIZE)) * 8).order(byteOrder).asLongBuffer();
        }
        boolean[] readyToUse = new boolean[chunks];
        Arrays.fill(readyToUse, true);
        return new LongMappedBigList(buffer, size, readyToUse);
    }

    private LongBuffer LongBuffer(int n) {
        if (this.readyToUse[n]) {
            return this.buffer[n];
        }
        this.readyToUse[n] = true;
        LongBuffer[] longBufferArr = this.buffer;
        LongBuffer duplicate = this.buffer[n].duplicate();
        longBufferArr[n] = duplicate;
        return duplicate;
    }

    public LongMappedBigList copy() {
        return new LongMappedBigList((LongBuffer[]) this.buffer.clone(), this.size, new boolean[this.f2393n]);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public long getLong(long index) {
        return LongBuffer((int) (index >>> CHUNK_SHIFT)).get((int) (index & CHUNK_MASK));
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBigList
    public void getElements(long from, long[] a, int offset, int length) {
        int chunk = (int) (from >>> CHUNK_SHIFT);
        int displ = (int) (from & CHUNK_MASK);
        while (length > 0) {
            LongBuffer b = LongBuffer(chunk);
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

    @Override // p014it.unimi.dsi.fastutil.longs.AbstractLongBigList, p014it.unimi.dsi.fastutil.longs.LongBigList
    public long set(long index, long value) {
        LongBuffer b = LongBuffer((int) (index >>> CHUNK_SHIFT));
        int i = (int) (index & CHUNK_MASK);
        long previousValue = b.get(i);
        b.put(i, value);
        return previousValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }
}
