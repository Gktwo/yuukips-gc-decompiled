package nonapi.p019io.github.classgraph.fileslice.reader;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.Arrays;
import nonapi.p019io.github.classgraph.fileslice.ArraySlice;
import nonapi.p019io.github.classgraph.fileslice.Slice;
import nonapi.p019io.github.classgraph.utils.StringUtils;

/* renamed from: nonapi.io.github.classgraph.fileslice.reader.ClassfileReader */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/reader/ClassfileReader.class */
public class ClassfileReader implements RandomAccessReader, SequentialReader, Closeable {
    private InputStream inflaterInputStream;
    private RandomAccessReader randomAccessReader;
    private byte[] arr;
    private int arrUsed;
    private int currIdx;
    private int classfileLengthHint;
    private static final int INITIAL_BUF_SIZE = 16384;
    private static final int BUF_CHUNK_SIZE = 8184;

    public ClassfileReader(Slice slice) throws IOException {
        this.classfileLengthHint = -1;
        this.classfileLengthHint = (int) slice.sliceLength;
        if (slice.isDeflatedZipEntry) {
            this.inflaterInputStream = slice.open();
            this.arr = new byte[16384];
            this.classfileLengthHint = (int) Math.min(slice.inflatedLengthHint, 2147483639L);
        } else if (slice instanceof ArraySlice) {
            ArraySlice arraySlice = (ArraySlice) slice;
            if (arraySlice.sliceStartPos == 0 && arraySlice.sliceLength == ((long) arraySlice.arr.length)) {
                this.arr = arraySlice.arr;
            } else {
                this.arr = Arrays.copyOfRange(arraySlice.arr, (int) arraySlice.sliceStartPos, (int) (arraySlice.sliceStartPos + arraySlice.sliceLength));
            }
            this.arrUsed = this.arr.length;
            this.classfileLengthHint = this.arr.length;
        } else {
            this.randomAccessReader = slice.randomAccessReader();
            this.arr = new byte[16384];
            this.classfileLengthHint = (int) Math.min(slice.sliceLength, 2147483639L);
        }
    }

    public ClassfileReader(InputStream inputStream) throws IOException {
        this.classfileLengthHint = -1;
        this.inflaterInputStream = inputStream;
        this.arr = new byte[16384];
    }

    public int currPos() {
        return this.currIdx;
    }

    public byte[] buf() {
        return this.arr;
    }

    private void readTo(int targetArrUsed) throws IOException {
        int maxArrLen = this.classfileLengthHint == -1 ? 2147483639 : this.classfileLengthHint;
        if (this.inflaterInputStream == null && this.randomAccessReader == null) {
            throw new IOException("Tried to read past end of fixed array buffer");
        } else if (targetArrUsed > 2147483639 || targetArrUsed < 0 || this.arrUsed == maxArrLen) {
            throw new IOException("Hit 2GB limit while trying to grow buffer array");
        } else {
            int maxNewArrUsed = (int) Math.min(Math.max((long) targetArrUsed, (long) (this.arrUsed + BUF_CHUNK_SIZE)), (long) maxArrLen);
            long newArrLength = (long) this.arr.length;
            while (newArrLength < ((long) maxNewArrUsed)) {
                newArrLength = Math.min((long) maxNewArrUsed, newArrLength * 2);
            }
            if (newArrLength > 2147483639) {
                throw new IOException("Hit 2GB limit while trying to grow buffer array");
            }
            this.arr = Arrays.copyOf(this.arr, (int) Math.min(newArrLength, (long) maxArrLen));
            int maxBytesToRead = this.arr.length - this.arrUsed;
            if (this.inflaterInputStream != null) {
                int numRead = this.inflaterInputStream.read(this.arr, this.arrUsed, maxBytesToRead);
                if (numRead > 0) {
                    this.arrUsed += numRead;
                }
            } else {
                int numBytesRead = this.randomAccessReader.read((long) this.arrUsed, this.arr, this.arrUsed, Math.min(maxBytesToRead, maxArrLen - this.arrUsed));
                if (numBytesRead > 0) {
                    this.arrUsed += numBytesRead;
                }
            }
            if (this.arrUsed < targetArrUsed) {
                throw new IOException("Buffer underflow");
            }
        }
    }

    public void bufferTo(int numBytes) throws IOException {
        if (numBytes > this.arrUsed) {
            readTo(numBytes);
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int read(long srcOffset, byte[] dstArr, int dstArrStart, int numBytes) throws IOException {
        if (numBytes == 0) {
            return 0;
        }
        int idx = (int) srcOffset;
        if (idx + numBytes > this.arrUsed) {
            readTo(idx + numBytes);
        }
        int numBytesToRead = Math.max(Math.min(numBytes, dstArr.length - dstArrStart), 0);
        if (numBytesToRead == 0) {
            return -1;
        }
        try {
            System.arraycopy(this.arr, idx, dstArr, dstArrStart, numBytesToRead);
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
        int idx = (int) srcOffset;
        if (idx + numBytes > this.arrUsed) {
            readTo(idx + numBytes);
        }
        int numBytesToRead = Math.max(Math.min(numBytes, dstBuf.capacity() - dstBufStart), 0);
        if (numBytesToRead == 0) {
            return -1;
        }
        try {
            dstBuf.position(dstBufStart);
            dstBuf.limit(dstBufStart + numBytesToRead);
            dstBuf.put(this.arr, idx, numBytesToRead);
            return numBytesToRead;
        } catch (IndexOutOfBoundsException | BufferUnderflowException | ReadOnlyBufferException e) {
            throw new IOException("Read index out of bounds");
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public byte readByte(long offset) throws IOException {
        int idx = (int) offset;
        if (idx + 1 > this.arrUsed) {
            readTo(idx + 1);
        }
        return this.arr[idx];
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedByte(long offset) throws IOException {
        int idx = (int) offset;
        if (idx + 1 > this.arrUsed) {
            readTo(idx + 1);
        }
        return this.arr[idx] & 255;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public short readShort(long offset) throws IOException {
        return (short) readUnsignedShort(offset);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedShort(long offset) throws IOException {
        int idx = (int) offset;
        if (idx + 2 > this.arrUsed) {
            readTo(idx + 2);
        }
        return ((this.arr[idx] & 255) << 8) | (this.arr[idx + 1] & 255);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readInt(long offset) throws IOException {
        int idx = (int) offset;
        if (idx + 4 > this.arrUsed) {
            readTo(idx + 4);
        }
        return ((this.arr[idx] & 255) << 24) | ((this.arr[idx + 1] & 255) << 16) | ((this.arr[idx + 2] & 255) << 8) | (this.arr[idx + 3] & 255);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readUnsignedInt(long offset) throws IOException {
        return ((long) readInt(offset)) & 4294967295L;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readLong(long offset) throws IOException {
        int idx = (int) offset;
        if (idx + 8 > this.arrUsed) {
            readTo(idx + 8);
        }
        return ((((long) this.arr[idx]) & 255) << 56) | ((((long) this.arr[idx + 1]) & 255) << 48) | ((((long) this.arr[idx + 2]) & 255) << 40) | ((((long) this.arr[idx + 3]) & 255) << 32) | ((((long) this.arr[idx + 4]) & 255) << 24) | ((((long) this.arr[idx + 5]) & 255) << 16) | ((((long) this.arr[idx + 6]) & 255) << 8) | (((long) this.arr[idx + 7]) & 255);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public byte readByte() throws IOException {
        byte val = readByte((long) this.currIdx);
        this.currIdx++;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public int readUnsignedByte() throws IOException {
        int val = readUnsignedByte((long) this.currIdx);
        this.currIdx++;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public short readShort() throws IOException {
        short val = readShort((long) this.currIdx);
        this.currIdx += 2;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public int readUnsignedShort() throws IOException {
        int val = readUnsignedShort((long) this.currIdx);
        this.currIdx += 2;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public int readInt() throws IOException {
        int val = readInt((long) this.currIdx);
        this.currIdx += 4;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public long readUnsignedInt() throws IOException {
        long val = readUnsignedInt((long) this.currIdx);
        this.currIdx += 4;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public long readLong() throws IOException {
        long val = readLong((long) this.currIdx);
        this.currIdx += 8;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public void skip(int bytesToSkip) throws IOException {
        if (bytesToSkip < 0) {
            throw new IllegalArgumentException("Tried to skip a negative number of bytes");
        }
        int idx = this.currIdx;
        if (idx + bytesToSkip > this.arrUsed) {
            readTo(idx + bytesToSkip);
        }
        this.currIdx += bytesToSkip;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes, boolean replaceSlashWithDot, boolean stripLSemicolon) throws IOException {
        int idx = (int) offset;
        if (idx + numBytes > this.arrUsed) {
            readTo(idx + numBytes);
        }
        return StringUtils.readString(this.arr, idx, numBytes, replaceSlashWithDot, stripLSemicolon);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public String readString(int numBytes, boolean replaceSlashWithDot, boolean stripLSemicolon) throws IOException {
        String val = StringUtils.readString(this.arr, this.currIdx, numBytes, replaceSlashWithDot, stripLSemicolon);
        this.currIdx += numBytes;
        return val;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes) throws IOException {
        return readString(offset, numBytes, false, false);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.SequentialReader
    public String readString(int numBytes) throws IOException {
        return readString(numBytes, false, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.inflaterInputStream != null) {
                this.inflaterInputStream.close();
            }
        } catch (Exception e) {
        }
    }
}
