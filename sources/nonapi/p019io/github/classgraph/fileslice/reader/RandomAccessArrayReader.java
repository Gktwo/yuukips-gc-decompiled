package nonapi.p019io.github.classgraph.fileslice.reader;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import nonapi.p019io.github.classgraph.utils.StringUtils;

/* renamed from: nonapi.io.github.classgraph.fileslice.reader.RandomAccessArrayReader */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/reader/RandomAccessArrayReader.class */
public class RandomAccessArrayReader implements RandomAccessReader {
    private final byte[] arr;
    private final int sliceStartPos;
    private final int sliceLength;

    public RandomAccessArrayReader(byte[] arr, int sliceStartPos, int sliceLength) {
        this.arr = arr;
        this.sliceStartPos = sliceStartPos;
        this.sliceLength = sliceLength;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int read(long srcOffset, byte[] dstArr, int dstArrStart, int numBytes) throws IOException {
        if (numBytes == 0) {
            return 0;
        }
        if (srcOffset < 0 || numBytes < 0 || ((long) numBytes) > ((long) this.sliceLength) - srcOffset) {
            throw new IOException("Read index out of bounds");
        }
        try {
            int numBytesToRead = Math.max(Math.min(numBytes, dstArr.length - dstArrStart), 0);
            if (numBytesToRead == 0) {
                return -1;
            }
            System.arraycopy(this.arr, (int) (((long) this.sliceStartPos) + srcOffset), dstArr, dstArrStart, numBytesToRead);
            return numBytesToRead;
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("Read index out of bounds");
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int read(long srcOffset, ByteBuffer dstBuf, int dstBufStart, int numBytes) throws IOException {
        if (numBytes == 0) {
            return 0;
        }
        if (srcOffset < 0 || numBytes < 0 || ((long) numBytes) > ((long) this.sliceLength) - srcOffset) {
            throw new IOException("Read index out of bounds");
        }
        try {
            int numBytesToRead = Math.max(Math.min(numBytes, dstBuf.capacity() - dstBufStart), 0);
            if (numBytesToRead == 0) {
                return -1;
            }
            dstBuf.position(dstBufStart);
            dstBuf.limit(dstBufStart + numBytesToRead);
            dstBuf.put(this.arr, (int) (((long) this.sliceStartPos) + srcOffset), numBytesToRead);
            return numBytesToRead;
        } catch (IndexOutOfBoundsException | BufferUnderflowException | ReadOnlyBufferException e) {
            throw new IOException("Read index out of bounds");
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public byte readByte(long offset) throws IOException {
        return this.arr[this.sliceStartPos + ((int) offset)];
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedByte(long offset) throws IOException {
        return this.arr[this.sliceStartPos + ((int) offset)] & 255;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public short readShort(long offset) throws IOException {
        return (short) readUnsignedShort(offset);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedShort(long offset) throws IOException {
        int idx = this.sliceStartPos + ((int) offset);
        return ((this.arr[idx + 1] & 255) << 8) | (this.arr[idx] & 255);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readInt(long offset) throws IOException {
        int idx = this.sliceStartPos + ((int) offset);
        return ((this.arr[idx + 3] & 255) << 24) | ((this.arr[idx + 2] & 255) << 16) | ((this.arr[idx + 1] & 255) << 8) | (this.arr[idx] & 255);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readUnsignedInt(long offset) throws IOException {
        return ((long) readInt(offset)) & 4294967295L;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readLong(long offset) throws IOException {
        int idx = this.sliceStartPos + ((int) offset);
        return ((((long) this.arr[idx + 7]) & 255) << 56) | ((((long) this.arr[idx + 6]) & 255) << 48) | ((((long) this.arr[idx + 5]) & 255) << 40) | ((((long) this.arr[idx + 4]) & 255) << 32) | ((((long) this.arr[idx + 3]) & 255) << 24) | ((((long) this.arr[idx + 2]) & 255) << 16) | ((((long) this.arr[idx + 1]) & 255) << 8) | (((long) this.arr[idx]) & 255);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes, boolean replaceSlashWithDot, boolean stripLSemicolon) throws IOException {
        return StringUtils.readString(this.arr, this.sliceStartPos + ((int) offset), numBytes, replaceSlashWithDot, stripLSemicolon);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes) throws IOException {
        return readString(offset, numBytes, false, false);
    }
}
