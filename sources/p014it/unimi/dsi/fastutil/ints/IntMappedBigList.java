package p014it.unimi.dsi.fastutil.ints;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.ints.IntMappedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntMappedBigList.class */
public class IntMappedBigList extends AbstractIntBigList {
    public static int LOG2_BYTES = 63 - Long.numberOfLeadingZeros(4);
    @Deprecated
    public static int LOG2_BITS = 63 - Long.numberOfLeadingZeros(4);
    private static int CHUNK_SHIFT = 30 - LOG2_BYTES;
    public static final long CHUNK_SIZE = 1 << CHUNK_SHIFT;
    private static final long CHUNK_MASK = CHUNK_SIZE - 1;
    private final IntBuffer[] buffer;
    private final boolean[] readyToUse;

    /* renamed from: n */
    private final int f2187n;
    private final long size;

    protected IntMappedBigList(IntBuffer[] buffer, long size, boolean[] readyToUse) {
        this.buffer = buffer;
        this.f2187n = buffer.length;
        this.size = size;
        this.readyToUse = readyToUse;
        for (int i = 0; i < this.f2187n; i++) {
            if (i < this.f2187n - 1 && ((long) buffer[i].capacity()) != CHUNK_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static IntMappedBigList map(FileChannel fileChannel) throws IOException {
        return map(fileChannel, ByteOrder.BIG_ENDIAN);
    }

    public static IntMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder) throws IOException {
        return map(fileChannel, byteOrder, FileChannel.MapMode.READ_ONLY);
    }

    public static IntMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder, FileChannel.MapMode mapMode) throws IOException {
        long size = fileChannel.size() / 4;
        int chunks = (int) ((size + (CHUNK_SIZE - 1)) / CHUNK_SIZE);
        IntBuffer[] buffer = new IntBuffer[chunks];
        for (int i = 0; i < chunks; i++) {
            buffer[i] = fileChannel.map(mapMode, ((long) i) * CHUNK_SIZE * 4, Math.min(CHUNK_SIZE, size - (((long) i) * CHUNK_SIZE)) * 4).order(byteOrder).asIntBuffer();
        }
        boolean[] readyToUse = new boolean[chunks];
        Arrays.fill(readyToUse, true);
        return new IntMappedBigList(buffer, size, readyToUse);
    }

    private IntBuffer IntBuffer(int n) {
        if (this.readyToUse[n]) {
            return this.buffer[n];
        }
        this.readyToUse[n] = true;
        IntBuffer[] intBufferArr = this.buffer;
        IntBuffer duplicate = this.buffer[n].duplicate();
        intBufferArr[n] = duplicate;
        return duplicate;
    }

    public IntMappedBigList copy() {
        return new IntMappedBigList((IntBuffer[]) this.buffer.clone(), this.size, new boolean[this.f2187n]);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    public int getInt(long index) {
        return IntBuffer((int) (index >>> CHUNK_SHIFT)).get((int) (index & CHUNK_MASK));
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBigList
    public void getElements(long from, int[] a, int offset, int length) {
        int chunk = (int) (from >>> CHUNK_SHIFT);
        int displ = (int) (from & CHUNK_MASK);
        while (length > 0) {
            IntBuffer b = IntBuffer(chunk);
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

    @Override // p014it.unimi.dsi.fastutil.ints.AbstractIntBigList, p014it.unimi.dsi.fastutil.ints.IntBigList
    public int set(long index, int value) {
        IntBuffer b = IntBuffer((int) (index >>> CHUNK_SHIFT));
        int i = (int) (index & CHUNK_MASK);
        int previousValue = b.get(i);
        b.put(i, value);
        return previousValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }
}
