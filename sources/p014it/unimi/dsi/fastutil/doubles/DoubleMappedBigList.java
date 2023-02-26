package p014it.unimi.dsi.fastutil.doubles;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleMappedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleMappedBigList.class */
public class DoubleMappedBigList extends AbstractDoubleBigList {
    public static int LOG2_BYTES = 63 - Long.numberOfLeadingZeros(8);
    @Deprecated
    public static int LOG2_BITS = 63 - Long.numberOfLeadingZeros(8);
    private static int CHUNK_SHIFT = 30 - LOG2_BYTES;
    public static final long CHUNK_SIZE = 1 << CHUNK_SHIFT;
    private static final long CHUNK_MASK = CHUNK_SIZE - 1;
    private final DoubleBuffer[] buffer;
    private final boolean[] readyToUse;

    /* renamed from: n */
    private final int f1700n;
    private final long size;

    protected DoubleMappedBigList(DoubleBuffer[] buffer, long size, boolean[] readyToUse) {
        this.buffer = buffer;
        this.f1700n = buffer.length;
        this.size = size;
        this.readyToUse = readyToUse;
        for (int i = 0; i < this.f1700n; i++) {
            if (i < this.f1700n - 1 && ((long) buffer[i].capacity()) != CHUNK_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static DoubleMappedBigList map(FileChannel fileChannel) throws IOException {
        return map(fileChannel, ByteOrder.BIG_ENDIAN);
    }

    public static DoubleMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder) throws IOException {
        return map(fileChannel, byteOrder, FileChannel.MapMode.READ_ONLY);
    }

    public static DoubleMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder, FileChannel.MapMode mapMode) throws IOException {
        long size = fileChannel.size() / 8;
        int chunks = (int) ((size + (CHUNK_SIZE - 1)) / CHUNK_SIZE);
        DoubleBuffer[] buffer = new DoubleBuffer[chunks];
        for (int i = 0; i < chunks; i++) {
            buffer[i] = fileChannel.map(mapMode, ((long) i) * CHUNK_SIZE * 8, Math.min(CHUNK_SIZE, size - (((long) i) * CHUNK_SIZE)) * 8).order(byteOrder).asDoubleBuffer();
        }
        boolean[] readyToUse = new boolean[chunks];
        Arrays.fill(readyToUse, true);
        return new DoubleMappedBigList(buffer, size, readyToUse);
    }

    private DoubleBuffer DoubleBuffer(int n) {
        if (this.readyToUse[n]) {
            return this.buffer[n];
        }
        this.readyToUse[n] = true;
        DoubleBuffer[] doubleBufferArr = this.buffer;
        DoubleBuffer duplicate = this.buffer[n].duplicate();
        doubleBufferArr[n] = duplicate;
        return duplicate;
    }

    public DoubleMappedBigList copy() {
        return new DoubleMappedBigList((DoubleBuffer[]) this.buffer.clone(), this.size, new boolean[this.f1700n]);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public double getDouble(long index) {
        return DoubleBuffer((int) (index >>> CHUNK_SHIFT)).get((int) (index & CHUNK_MASK));
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public void getElements(long from, double[] a, int offset, int length) {
        int chunk = (int) (from >>> CHUNK_SHIFT);
        int displ = (int) (from & CHUNK_MASK);
        while (length > 0) {
            DoubleBuffer b = DoubleBuffer(chunk);
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

    @Override // p014it.unimi.dsi.fastutil.doubles.AbstractDoubleBigList, p014it.unimi.dsi.fastutil.doubles.DoubleBigList
    public double set(long index, double value) {
        DoubleBuffer b = DoubleBuffer((int) (index >>> CHUNK_SHIFT));
        int i = (int) (index & CHUNK_MASK);
        double previousValue = b.get(i);
        b.put(i, value);
        return previousValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }
}
