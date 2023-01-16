package p014it.unimi.dsi.fastutil.chars;

import java.io.IOException;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* renamed from: it.unimi.dsi.fastutil.chars.CharMappedBigList */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharMappedBigList.class */
public class CharMappedBigList extends AbstractCharBigList {
    public static int LOG2_BYTES = 63 - Long.numberOfLeadingZeros(2);
    @Deprecated
    public static int LOG2_BITS = 63 - Long.numberOfLeadingZeros(2);
    private static int CHUNK_SHIFT = 30 - LOG2_BYTES;
    public static final long CHUNK_SIZE = 1 << CHUNK_SHIFT;
    private static final long CHUNK_MASK = CHUNK_SIZE - 1;
    private final CharBuffer[] buffer;
    private final boolean[] readyToUse;

    /* renamed from: n */
    private final int f1518n;
    private final long size;

    protected CharMappedBigList(CharBuffer[] buffer, long size, boolean[] readyToUse) {
        this.buffer = buffer;
        this.f1518n = buffer.length;
        this.size = size;
        this.readyToUse = readyToUse;
        for (int i = 0; i < this.f1518n; i++) {
            if (i < this.f1518n - 1 && ((long) buffer[i].capacity()) != CHUNK_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static CharMappedBigList map(FileChannel fileChannel) throws IOException {
        return map(fileChannel, ByteOrder.BIG_ENDIAN);
    }

    public static CharMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder) throws IOException {
        return map(fileChannel, byteOrder, FileChannel.MapMode.READ_ONLY);
    }

    public static CharMappedBigList map(FileChannel fileChannel, ByteOrder byteOrder, FileChannel.MapMode mapMode) throws IOException {
        long size = fileChannel.size() / 2;
        int chunks = (int) ((size + (CHUNK_SIZE - 1)) / CHUNK_SIZE);
        CharBuffer[] buffer = new CharBuffer[chunks];
        for (int i = 0; i < chunks; i++) {
            buffer[i] = fileChannel.map(mapMode, ((long) i) * CHUNK_SIZE * 2, Math.min(CHUNK_SIZE, size - (((long) i) * CHUNK_SIZE)) * 2).order(byteOrder).asCharBuffer();
        }
        boolean[] readyToUse = new boolean[chunks];
        Arrays.fill(readyToUse, true);
        return new CharMappedBigList(buffer, size, readyToUse);
    }

    private CharBuffer CharBuffer(int n) {
        if (this.readyToUse[n]) {
            return this.buffer[n];
        }
        this.readyToUse[n] = true;
        CharBuffer[] charBufferArr = this.buffer;
        CharBuffer duplicate = this.buffer[n].duplicate();
        charBufferArr[n] = duplicate;
        return duplicate;
    }

    public CharMappedBigList copy() {
        return new CharMappedBigList((CharBuffer[]) this.buffer.clone(), this.size, new boolean[this.f1518n]);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
    public char getChar(long index) {
        return CharBuffer((int) (index >>> CHUNK_SHIFT)).get((int) (index & CHUNK_MASK));
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBigList
    public void getElements(long from, char[] a, int offset, int length) {
        int chunk = (int) (from >>> CHUNK_SHIFT);
        int displ = (int) (from & CHUNK_MASK);
        while (length > 0) {
            CharBuffer b = CharBuffer(chunk);
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

    @Override // p014it.unimi.dsi.fastutil.chars.AbstractCharBigList, p014it.unimi.dsi.fastutil.chars.CharBigList
    public char set(long index, char value) {
        CharBuffer b = CharBuffer((int) (index >>> CHUNK_SHIFT));
        int i = (int) (index & CHUNK_MASK);
        char previousValue = b.get(i);
        b.put(i, value);
        return previousValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Size64
    public long size64() {
        return this.size;
    }
}
