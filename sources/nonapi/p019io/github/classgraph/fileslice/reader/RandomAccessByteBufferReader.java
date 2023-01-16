package nonapi.p019io.github.classgraph.fileslice.reader;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import nonapi.p019io.github.classgraph.utils.StringUtils;

/* renamed from: nonapi.io.github.classgraph.fileslice.reader.RandomAccessByteBufferReader */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/reader/RandomAccessByteBufferReader.class */
public class RandomAccessByteBufferReader implements RandomAccessReader {
    private final ByteBuffer byteBuffer;
    private final int sliceStartPos;
    private final int sliceLength;

    public RandomAccessByteBufferReader(ByteBuffer byteBuffer, long sliceStartPos, long sliceLength) {
        this.byteBuffer = byteBuffer.duplicate();
        this.byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.sliceStartPos = (int) sliceStartPos;
        this.sliceLength = (int) sliceLength;
        this.byteBuffer.position(this.sliceStartPos);
        this.byteBuffer.limit(this.sliceStartPos + this.sliceLength);
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
            this.byteBuffer.position(this.sliceStartPos + ((int) srcOffset));
            this.byteBuffer.get(dstArr, dstArrStart, numBytesToRead);
            this.byteBuffer.position(this.sliceStartPos);
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
            this.byteBuffer.position((int) (((long) this.sliceStartPos) + srcOffset));
            dstBuf.position(dstBufStart);
            dstBuf.limit(dstBufStart + numBytesToRead);
            dstBuf.put(this.byteBuffer);
            this.byteBuffer.limit(this.sliceStartPos + this.sliceLength);
            this.byteBuffer.position(this.sliceStartPos);
            return numBytesToRead;
        } catch (IndexOutOfBoundsException | BufferUnderflowException | ReadOnlyBufferException e) {
            throw new IOException("Read index out of bounds");
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public byte readByte(long offset) throws IOException {
        return this.byteBuffer.get((int) (((long) this.sliceStartPos) + offset));
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedByte(long offset) throws IOException {
        return this.byteBuffer.get((int) (((long) this.sliceStartPos) + offset)) & 255;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedShort(long offset) throws IOException {
        return this.byteBuffer.getShort((int) (((long) this.sliceStartPos) + offset)) & 255;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public short readShort(long offset) throws IOException {
        return (short) readUnsignedShort(offset);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readInt(long offset) throws IOException {
        return this.byteBuffer.getInt((int) (((long) this.sliceStartPos) + offset));
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readUnsignedInt(long offset) throws IOException {
        return ((long) readInt(offset)) & 4294967295L;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readLong(long offset) throws IOException {
        return this.byteBuffer.getLong((int) (((long) this.sliceStartPos) + offset));
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes, boolean replaceSlashWithDot, boolean stripLSemicolon) throws IOException {
        int idx = (int) (((long) this.sliceStartPos) + offset);
        byte[] arr = new byte[numBytes];
        if (read(offset, arr, 0, numBytes) >= numBytes) {
            return StringUtils.readString(arr, idx, numBytes, replaceSlashWithDot, stripLSemicolon);
        }
        throw new IOException("Premature EOF while reading string");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes) throws IOException {
        return readString(offset, numBytes, false, false);
    }
}
