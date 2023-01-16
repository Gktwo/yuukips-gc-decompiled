package nonapi.p019io.github.classgraph.fileslice.reader;

import java.io.IOException;

/* renamed from: nonapi.io.github.classgraph.fileslice.reader.SequentialReader */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/reader/SequentialReader.class */
public interface SequentialReader {
    byte readByte() throws IOException;

    int readUnsignedByte() throws IOException;

    short readShort() throws IOException;

    int readUnsignedShort() throws IOException;

    int readInt() throws IOException;

    long readUnsignedInt() throws IOException;

    long readLong() throws IOException;

    void skip(int i) throws IOException;

    String readString(int i, boolean z, boolean z2) throws IOException;

    String readString(int i) throws IOException;
}
