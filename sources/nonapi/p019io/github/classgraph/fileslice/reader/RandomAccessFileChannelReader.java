package nonapi.p019io.github.classgraph.fileslice.reader;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import nonapi.p019io.github.classgraph.utils.StringUtils;

/* renamed from: nonapi.io.github.classgraph.fileslice.reader.RandomAccessFileChannelReader */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/reader/RandomAccessFileChannelReader.class */
public class RandomAccessFileChannelReader implements RandomAccessReader {
    private final FileChannel fileChannel;
    private final long sliceStartPos;
    private final long sliceLength;
    private ByteBuffer reusableByteBuffer;
    private final byte[] scratchArr = new byte[8];
    private final ByteBuffer scratchByteBuf = ByteBuffer.wrap(this.scratchArr);
    private byte[] utf8Bytes;

    public RandomAccessFileChannelReader(FileChannel fileChannel, long sliceStartPos, long sliceLength) {
        this.fileChannel = fileChannel;
        this.sliceStartPos = sliceStartPos;
        this.sliceLength = sliceLength;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int read(long srcOffset, ByteBuffer dstBuf, int dstBufStart, int numBytes) throws IOException {
        if (numBytes == 0) {
            return 0;
        }
        if (srcOffset >= 0 && numBytes >= 0) {
            try {
                if (((long) numBytes) <= this.sliceLength - srcOffset) {
                    long srcStart = this.sliceStartPos + srcOffset;
                    dstBuf.position(dstBufStart);
                    dstBuf.limit(dstBufStart + numBytes);
                    int numBytesRead = this.fileChannel.read(dstBuf, srcStart);
                    if (numBytesRead == 0) {
                        return -1;
                    }
                    return numBytesRead;
                }
            } catch (IndexOutOfBoundsException | BufferUnderflowException e) {
                throw new IOException("Read index out of bounds");
            }
        }
        throw new IOException("Read index out of bounds");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int read(long srcOffset, byte[] dstArr, int dstArrStart, int numBytes) throws IOException {
        if (numBytes == 0) {
            return 0;
        }
        if (srcOffset >= 0 && numBytes >= 0) {
            try {
                if (((long) numBytes) <= this.sliceLength - srcOffset) {
                    if (this.reusableByteBuffer == null || this.reusableByteBuffer.array() != dstArr) {
                        this.reusableByteBuffer = ByteBuffer.wrap(dstArr);
                    }
                    return read(srcOffset, this.reusableByteBuffer, dstArrStart, numBytes);
                }
            } catch (IndexOutOfBoundsException | BufferUnderflowException e) {
                throw new IOException("Read index out of bounds");
            }
        }
        throw new IOException("Read index out of bounds");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public byte readByte(long offset) throws IOException {
        if (read(offset, this.scratchByteBuf, 0, 1) >= 1) {
            return this.scratchArr[0];
        }
        throw new IOException("Premature EOF");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedByte(long offset) throws IOException {
        if (read(offset, this.scratchByteBuf, 0, 1) >= 1) {
            return this.scratchArr[0] & 255;
        }
        throw new IOException("Premature EOF");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public short readShort(long offset) throws IOException {
        return (short) readUnsignedShort(offset);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readUnsignedShort(long offset) throws IOException {
        if (read(offset, this.scratchByteBuf, 0, 2) >= 2) {
            return ((this.scratchArr[1] & 255) << 8) | (this.scratchArr[0] & 255);
        }
        throw new IOException("Premature EOF");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public int readInt(long offset) throws IOException {
        if (read(offset, this.scratchByteBuf, 0, 4) >= 4) {
            return ((this.scratchArr[3] & 255) << 24) | ((this.scratchArr[2] & 255) << 16) | ((this.scratchArr[1] & 255) << 8) | (this.scratchArr[0] & 255);
        }
        throw new IOException("Premature EOF");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readUnsignedInt(long offset) throws IOException {
        return ((long) readInt(offset)) & 4294967295L;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public long readLong(long offset) throws IOException {
        if (read(offset, this.scratchByteBuf, 0, 8) >= 8) {
            return ((((long) this.scratchArr[7]) & 255) << 56) | ((((long) this.scratchArr[6]) & 255) << 48) | ((((long) this.scratchArr[5]) & 255) << 40) | ((((long) this.scratchArr[4]) & 255) << 32) | ((((long) this.scratchArr[3]) & 255) << 24) | ((((long) this.scratchArr[2]) & 255) << 16) | ((((long) this.scratchArr[1]) & 255) << 8) | (((long) this.scratchArr[0]) & 255);
        }
        throw new IOException("Premature EOF");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes, boolean replaceSlashWithDot, boolean stripLSemicolon) throws IOException {
        if (this.utf8Bytes == null || this.utf8Bytes.length < numBytes) {
            this.utf8Bytes = new byte[numBytes];
        }
        if (read(offset, this.utf8Bytes, 0, numBytes) >= numBytes) {
            return StringUtils.readString(this.utf8Bytes, 0, numBytes, replaceSlashWithDot, stripLSemicolon);
        }
        throw new IOException("Premature EOF");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader
    public String readString(long offset, int numBytes) throws IOException {
        return readString(offset, numBytes, false, false);
    }
}
