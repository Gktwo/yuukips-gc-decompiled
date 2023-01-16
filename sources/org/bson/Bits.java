package org.bson;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/Bits.class */
public class Bits {
    Bits() {
    }

    /* access modifiers changed from: package-private */
    public static void readFully(InputStream inputStream, byte[] buffer) throws IOException {
        readFully(inputStream, buffer, 0, buffer.length);
    }

    /* access modifiers changed from: package-private */
    public static void readFully(InputStream inputStream, byte[] buffer, int offset, int length) throws IOException {
        if (buffer.length < length + offset) {
            throw new IllegalArgumentException("Buffer is too small");
        }
        int arrayOffset = offset;
        int bytesToRead = length;
        while (bytesToRead > 0) {
            int bytesRead = inputStream.read(buffer, arrayOffset, bytesToRead);
            if (bytesRead < 0) {
                throw new EOFException();
            }
            bytesToRead -= bytesRead;
            arrayOffset += bytesRead;
        }
    }

    /* access modifiers changed from: package-private */
    public static int readInt(InputStream inputStream, byte[] buffer) throws IOException {
        readFully(inputStream, buffer, 0, 4);
        return readInt(buffer);
    }

    /* access modifiers changed from: package-private */
    public static int readInt(byte[] buffer) {
        return readInt(buffer, 0);
    }

    static int readInt(byte[] buffer, int offset) {
        return 0 | ((255 & buffer[offset + 0]) << 0) | ((255 & buffer[offset + 1]) << 8) | ((255 & buffer[offset + 2]) << 16) | ((255 & buffer[offset + 3]) << 24);
    }

    static long readLong(InputStream inputStream) throws IOException {
        return readLong(inputStream, new byte[8]);
    }

    static long readLong(InputStream inputStream, byte[] buffer) throws IOException {
        readFully(inputStream, buffer, 0, 8);
        return readLong(buffer);
    }

    static long readLong(byte[] buffer) {
        return readLong(buffer, 0);
    }

    /* access modifiers changed from: package-private */
    public static long readLong(byte[] buffer, int offset) {
        return 0 | ((255 & ((long) buffer[offset + 0])) << 0) | ((255 & ((long) buffer[offset + 1])) << 8) | ((255 & ((long) buffer[offset + 2])) << 16) | ((255 & ((long) buffer[offset + 3])) << 24) | ((255 & ((long) buffer[offset + 4])) << 32) | ((255 & ((long) buffer[offset + 5])) << 40) | ((255 & ((long) buffer[offset + 6])) << 48) | ((255 & ((long) buffer[offset + 7])) << 56);
    }
}
