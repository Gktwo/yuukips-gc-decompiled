package nonapi.p019io.github.classgraph.fileslice.reader;

import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: nonapi.io.github.classgraph.fileslice.reader.RandomAccessReader */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/reader/RandomAccessReader.class */
public interface RandomAccessReader {
    int read(long j, ByteBuffer byteBuffer, int i, int i2) throws IOException;

    int read(long j, byte[] bArr, int i, int i2) throws IOException;

    byte readByte(long j) throws IOException;

    int readUnsignedByte(long j) throws IOException;

    short readShort(long j) throws IOException;

    int readUnsignedShort(long j) throws IOException;

    int readInt(long j) throws IOException;

    long readUnsignedInt(long j) throws IOException;

    long readLong(long j) throws IOException;

    String readString(long j, int i, boolean z, boolean z2) throws IOException;

    String readString(long j, int i) throws IOException;
}
