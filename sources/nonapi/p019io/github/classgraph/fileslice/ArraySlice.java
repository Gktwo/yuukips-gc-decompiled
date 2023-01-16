package nonapi.p019io.github.classgraph.fileslice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessArrayReader;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader;

/* renamed from: nonapi.io.github.classgraph.fileslice.ArraySlice */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fileslice/ArraySlice.class */
public class ArraySlice extends Slice {
    public byte[] arr;

    private ArraySlice(ArraySlice parentSlice, long offset, long length, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler) {
        super(parentSlice, offset, length, isDeflatedZipEntry, inflatedLengthHint, nestedJarHandler);
        this.arr = parentSlice.arr;
    }

    public ArraySlice(byte[] arr, boolean isDeflatedZipEntry, long inflatedLengthHint, NestedJarHandler nestedJarHandler) {
        super((long) arr.length, isDeflatedZipEntry, inflatedLengthHint, nestedJarHandler);
        this.arr = arr;
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public Slice slice(long offset, long length, boolean isDeflatedZipEntry, long inflatedLengthHint) {
        if (!this.isDeflatedZipEntry) {
            return new ArraySlice(this, offset, length, isDeflatedZipEntry, inflatedLengthHint, this.nestedJarHandler);
        }
        throw new IllegalArgumentException("Cannot slice a deflated zip entry");
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public byte[] load() throws IOException {
        if (this.isDeflatedZipEntry) {
            InputStream inputStream = open();
            Throwable th = null;
            try {
                byte[] readAllBytesAsArray = NestedJarHandler.readAllBytesAsArray(inputStream, this.inflatedLengthHint);
                if (inputStream != null) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        inputStream.close();
                    }
                }
                return readAllBytesAsArray;
            } catch (Throwable th3) {
                if (inputStream != null) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        inputStream.close();
                    }
                }
                throw th3;
            }
        } else if (this.sliceStartPos == 0 && this.sliceLength == ((long) this.arr.length)) {
            return this.arr;
        } else {
            return Arrays.copyOfRange(this.arr, (int) this.sliceStartPos, (int) (this.sliceStartPos + this.sliceLength));
        }
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice
    public RandomAccessReader randomAccessReader() {
        return new RandomAccessArrayReader(this.arr, (int) this.sliceStartPos, (int) this.sliceLength);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice, java.lang.Object
    public boolean equals(Object o) {
        return equals(o);
    }

    @Override // nonapi.p019io.github.classgraph.fileslice.Slice, java.lang.Object
    public int hashCode() {
        return hashCode();
    }
}
