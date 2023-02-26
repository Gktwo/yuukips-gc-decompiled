package p014it.unimi.dsi.fastutil.floats;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatMappedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatMappedBigList.class */
public class FloatMappedBigList extends AbstractFloatBigList {
    public static int LOG2_BYTES = 63 - Long.numberOfLeadingZeros(4);
    @Deprecated
    public static int LOG2_BITS = 63 - Long.numberOfLeadingZeros(4);
    private static int CHUNK_SHIFT = 30 - LOG2_BYTES;
    public static final long CHUNK_SIZE = 1 << CHUNK_SHIFT;
    private static final long CHUNK_MASK = CHUNK_SIZE - 1;
    private final FloatBuffer[] buffer;
    private final boolean[] readyToUse;

    /* renamed from: n */
    private final int f1921n;
    private final long size;

    protected FloatMappedBigList(FloatBuffer[] buffer, long size, boolean[] readyToUse) {
        this.buffer = buffer;
        this.f1921n = buffer.length;
        this.size = size;
        this.readyToUse = readyToUse;
        for (int i = 0; i < this.f1921n; i++) {
            if (i < this.f1921n - 1 && ((long) buffer[i].capacity()) != CHUNK_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static FloatMappedBigList map(FileChannel fileChannel) throws IOException {
        return map(fileChannel, ByteOrder.BIG_ENDIAN);
    }

    public static FloatMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder) throws IOException {
        return map(fileChannel, byteOrder, FileChannel.MapMode.READ_ONLY);
    }

    public static FloatMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder, FileChannel.MapMode mapMode) throws IOException {
        long size = fileChannel.size() / 4;
        int chunks = (int) ((size + (CHUNK_SIZE - 1)) / CHUNK_SIZE);
        FloatBuffer[] buffer = new FloatBuffer[chunks];
        for (int i = 0; i < chunks; i++) {
            buffer[i] = fileChannel.map(mapMode, ((long) i) * CHUNK_SIZE * 4, Math.min(CHUNK_SIZE, size - (((long) i) * CHUNK_SIZE)) * 4).order(byteOrder).asFloatBuffer();
        }
        boolean[] readyToUse = new boolean[chunks];
        Arrays.fill(readyToUse, true);
        return new FloatMappedBigList(buffer, size, readyToUse);
    }

    private FloatBuffer FloatBuffer(int n) {
        if (this.readyToUse[n]) {
            return this.buffer[n];
        }
        this.readyToUse[n] = true;
        FloatBuffer[] floatBufferArr = this.buffer;
        FloatBuffer duplicate = this.buffer[n].duplicate();
        floatBufferArr[n] = duplicate;
        return duplicate;
    }

    public FloatMappedBigList copy() {
        return new FloatMappedBigList((FloatBuffer[]) this.buffer.clone(), this.size, new boolean[this.f1921n]);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
    public float getFloat(long index) {
        return FloatBuffer((int) (index >>> CHUNK_SHIFT)).get((int) (index & CHUNK_MASK));
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBigList
    public void getElements(long from, float[] a, int offset, int length) {
        int chunk = (int) (from >>> CHUNK_SHIFT);
        int displ = (int) (from & CHUNK_MASK);
        while (length > 0) {
            FloatBuffer b = FloatBuffer(chunk);
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

    @Override // p014it.unimi.dsi.fastutil.floats.AbstractFloatBigList, p014it.unimi.dsi.fastutil.floats.FloatBigList
    public float set(long index, float value) {
        FloatBuffer b = FloatBuffer((int) (index >>> CHUNK_SHIFT));
        int i = (int) (index & CHUNK_MASK);
        float previousValue = b.get(i);
        b.put(i, value);
        return previousValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }
}
