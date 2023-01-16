package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStream.class */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    int sizeLimit;
    CodedInputStreamReader wrapper;
    private boolean shouldDiscardUnknownFields;

    public abstract int readTag() throws IOException;

    public abstract void checkLastTagWas(int i) throws InvalidProtocolBufferException;

    public abstract int getLastTag();

    public abstract boolean skipField(int i) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream codedOutputStream) throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract long readUInt64() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract boolean readBool() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException;

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract void enableAliasing(boolean z);

    public abstract void resetSizeCounter();

    public abstract int pushLimit(int i) throws InvalidProtocolBufferException;

    public abstract void popLimit(int i);

    public abstract int getBytesUntilLimit();

    public abstract boolean isAtEnd() throws IOException;

    public abstract int getTotalBytesRead();

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i) throws IOException;

    public abstract void skipRawBytes(int i) throws IOException;

    public static CodedInputStream newInstance(InputStream input) {
        return newInstance(input, 4096);
    }

    public static CodedInputStream newInstance(InputStream input, int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        } else if (input == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        } else {
            return new StreamDecoder(input, bufferSize);
        }
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> input) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new IterableByteBufferInputStream(input));
        }
        return newInstance(input, false);
    }

    /* access modifiers changed from: package-private */
    public static CodedInputStream newInstance(Iterable<ByteBuffer> bufs, boolean bufferIsImmutable) {
        int flag = 0;
        int totalSize = 0;
        for (ByteBuffer buf : bufs) {
            totalSize += buf.remaining();
            if (buf.hasArray()) {
                flag |= 1;
            } else if (buf.isDirect()) {
                flag |= 2;
            } else {
                flag |= 4;
            }
        }
        if (flag == 2) {
            return new IterableDirectByteBufferDecoder(bufs, totalSize, bufferIsImmutable);
        }
        return newInstance(new IterableByteBufferInputStream(bufs));
    }

    public static CodedInputStream newInstance(byte[] buf) {
        return newInstance(buf, 0, buf.length);
    }

    public static CodedInputStream newInstance(byte[] buf, int off, int len) {
        return newInstance(buf, off, len, false);
    }

    /* access modifiers changed from: package-private */
    public static CodedInputStream newInstance(byte[] buf, int off, int len, boolean bufferIsImmutable) {
        ArrayDecoder result = new ArrayDecoder(buf, off, len, bufferIsImmutable);
        try {
            result.pushLimit(len);
            return result;
        } catch (InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer buf) {
        return newInstance(buf, false);
    }

    /* access modifiers changed from: package-private */
    public static CodedInputStream newInstance(ByteBuffer buf, boolean bufferIsImmutable) {
        if (buf.hasArray()) {
            return newInstance(buf.array(), buf.arrayOffset() + buf.position(), buf.remaining(), bufferIsImmutable);
        }
        if (buf.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(buf, bufferIsImmutable);
        }
        byte[] buffer = new byte[buf.remaining()];
        buf.duplicate().get(buffer);
        return newInstance(buffer, 0, buffer.length, true);
    }

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public final int setRecursionLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + limit);
        }
        int oldLimit = this.recursionLimit;
        this.recursionLimit = limit;
        return oldLimit;
    }

    public final int setSizeLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
        }
        int oldLimit = this.sizeLimit;
        this.sizeLimit = limit;
        return oldLimit;
    }

    /* access modifiers changed from: package-private */
    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    /* access modifiers changed from: package-private */
    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    /* access modifiers changed from: package-private */
    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public static int decodeZigZag32(int n) {
        return (n >>> 1) ^ (-(n & 1));
    }

    public static long decodeZigZag64(long n) {
        return (n >>> 1) ^ (-(n & 1));
    }

    public static int readRawVarint32(int firstByte, InputStream input) throws IOException {
        if ((firstByte & 128) == 0) {
            return firstByte;
        }
        int result = firstByte & 127;
        int offset = 7;
        while (offset < 32) {
            int b = input.read();
            if (b == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            result |= (b & 127) << offset;
            if ((b & 128) == 0) {
                return result;
            }
            offset += 7;
        }
        while (offset < 64) {
            int b2 = input.read();
            if (b2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if ((b2 & 128) == 0) {
                return result;
            } else {
                offset += 7;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream input) throws IOException {
        int firstByte = input.read();
        if (firstByte != -1) {
            return readRawVarint32(firstByte, input);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStream$ArrayDecoder.class */
    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private final boolean immutable;
        private int limit;
        private int bufferSizeAfterLimit;
        private int pos;
        private int startPos;
        private int lastTag;
        private boolean enableAliasing;
        private int currentLimit;

        private ArrayDecoder(byte[] buffer, int offset, int len, boolean immutable) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            this.limit = offset + len;
            this.pos = offset;
            this.startPos = this.pos;
            this.immutable = immutable;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeRawVarint32(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeRawVarint32(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeRawVarint32(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeRawVarint32(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeRawVarint32(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeRawVarint32(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= this.limit - this.pos) {
                String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
                this.pos += size;
                return result;
            } else if (size == 0) {
                return "";
            } else {
                if (size < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= this.limit - this.pos) {
                String result = Utf8.decodeUtf8(this.buffer, this.pos, size);
                this.pos += size;
                return result;
            } else if (size == 0) {
                return "";
            } else {
                if (size <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            ByteString result;
            int size = readRawVarint32();
            if (size > 0 && size <= this.limit - this.pos) {
                if (!this.immutable || !this.enableAliasing) {
                    result = ByteString.copyFrom(this.buffer, this.pos, size);
                } else {
                    result = ByteString.wrap(this.buffer, this.pos, size);
                }
                this.pos += size;
                return result;
            } else if (size == 0) {
                return ByteString.EMPTY;
            } else {
                return ByteString.wrap(readRawBytes(size));
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer result;
            int size = readRawVarint32();
            if (size > 0 && size <= this.limit - this.pos) {
                if (this.immutable || !this.enableAliasing) {
                    result = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.pos, this.pos + size));
                } else {
                    result = ByteBuffer.wrap(this.buffer, this.pos, size).slice();
                }
                this.pos += size;
                return result;
            } else if (size == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (size < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c2, code lost:
            if (r0[r5] < 0) goto L_0x00cf;
         */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 213
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v37, types: [long] */
        /* JADX WARN: Type inference failed for: r0v45, types: [long] */
        /* JADX WARN: Type inference failed for: r0v47, types: [long] */
        /* JADX WARN: Type inference failed for: r0v49, types: [long] */
        /* JADX WARN: Type inference failed for: r0v51, types: [long] */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0121, code lost:
            if (((long) r0[r7]) < 0) goto L_0x012e;
         */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 307
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.ArrayDecoder.readRawVarint64():long");
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            char c = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b = readRawByte();
                c |= ((long) (b & Byte.MAX_VALUE)) << shift;
                if ((b & 128) == 0) {
                    return c;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int tempPos = this.pos;
            if (this.limit - tempPos < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 4;
            return (buffer[tempPos] & 255) | ((buffer[tempPos + 1] & 255) << 8) | ((buffer[tempPos + 2] & 255) << 16) | ((buffer[tempPos + 3] & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int tempPos = this.pos;
            if (this.limit - tempPos < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 8;
            return (((long) buffer[tempPos]) & 255) | ((((long) buffer[tempPos + 1]) & 255) << 8) | ((((long) buffer[tempPos + 2]) & 255) << 16) | ((((long) buffer[tempPos + 3]) & 255) << 24) | ((((long) buffer[tempPos + 4]) & 255) << 32) | ((((long) buffer[tempPos + 5]) & 255) << 40) | ((((long) buffer[tempPos + 6]) & 255) << 48) | ((((long) buffer[tempPos + 7]) & 255) << 56);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + getTotalBytesRead();
            if (byteLimit2 < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += this.bufferSizeAfterLimit;
            int bufferEnd = this.limit - this.startPos;
            if (bufferEnd > this.currentLimit) {
                this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
                this.limit -= this.bufferSizeAfterLimit;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit == Integer.MAX_VALUE) {
                return -1;
            }
            return this.currentLimit - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length > 0 && length <= this.limit - this.pos) {
                int tempPos = this.pos;
                this.pos += length;
                return Arrays.copyOfRange(this.buffer, tempPos, this.pos);
            } else if (length > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (length == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0 && length <= this.limit - this.pos) {
                this.pos += length;
            } else if (length < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStream$UnsafeDirectNioDecoder.class */
    public static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final ByteBuffer buffer;
        private final boolean immutable;
        private final long address;
        private long limit;
        private long pos;
        private long startPos;
        private int bufferSizeAfterLimit;
        private int lastTag;
        private boolean enableAliasing;
        private int currentLimit;

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private UnsafeDirectNioDecoder(ByteBuffer buffer, boolean immutable) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = buffer;
            this.address = UnsafeUtil.addressOffset(buffer);
            this.limit = this.address + ((long) buffer.limit());
            this.pos = this.address + ((long) buffer.position());
            this.startPos = this.pos;
            this.immutable = immutable;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeRawVarint32(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeRawVarint32(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeRawVarint32(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeRawVarint32(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeRawVarint32(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeRawVarint32(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= remaining()) {
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.pos, bytes, 0, (long) size);
                String result = new String(bytes, Internal.UTF_8);
                this.pos += (long) size;
                return result;
            } else if (size == 0) {
                return "";
            } else {
                if (size < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= remaining()) {
                String result = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), size);
                this.pos += (long) size;
                return result;
            } else if (size == 0) {
                return "";
            } else {
                if (size <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size <= 0 || size > remaining()) {
                if (size == 0) {
                    return ByteString.EMPTY;
                }
                if (size < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.immutable || !this.enableAliasing) {
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.pos, bytes, 0, (long) size);
                this.pos += (long) size;
                return ByteString.wrap(bytes);
            } else {
                ByteBuffer result = slice(this.pos, this.pos + ((long) size));
                this.pos += (long) size;
                return ByteString.wrap(result);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size <= 0 || size > remaining()) {
                if (size == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (size < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (this.immutable || !this.enableAliasing) {
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.pos, bytes, 0, (long) size);
                this.pos += (long) size;
                return ByteBuffer.wrap(bytes);
            } else {
                ByteBuffer result = slice(this.pos, this.pos + ((long) size));
                this.pos += (long) size;
                return result;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Type inference failed for: r1v25, types: [long] */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d4, code lost:
            if (r0 < 0) goto L_0x00e1;
         */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 231
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                long j = this.pos;
                this.pos = j + 1;
                if (UnsafeUtil.getByte(j) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r0v37, types: [long] */
        /* JADX WARN: Type inference failed for: r1v64, types: [long] */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r0v45, types: [long] */
        /* JADX WARN: Type inference failed for: r0v47, types: [long] */
        /* JADX WARN: Type inference failed for: r0v49, types: [long] */
        /* JADX WARN: Type inference failed for: r0v51, types: [long] */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v16 */
        /* JADX WARN: Type inference failed for: r10v17 */
        /* JADX WARN: Type inference failed for: r10v18 */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r12v17 */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0133, code lost:
            if (((long) com.google.protobuf.UnsafeUtil.getByte(r10)) < 0) goto L_0x0140;
         */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 325
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint64():long");
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            char c = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b = readRawByte();
                c |= ((long) (b & Byte.MAX_VALUE)) << shift;
                if ((b & 128) == 0) {
                    return c;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            long tempPos = this.pos;
            if (this.limit - tempPos < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = tempPos + 4;
            return (UnsafeUtil.getByte(tempPos) & 255) | ((UnsafeUtil.getByte(tempPos + 1) & 255) << 8) | ((UnsafeUtil.getByte(tempPos + 2) & 255) << 16) | ((UnsafeUtil.getByte(tempPos + 3) & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            long tempPos = this.pos;
            if (this.limit - tempPos < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.pos = tempPos + 8;
            return (((long) UnsafeUtil.getByte(tempPos)) & 255) | ((((long) UnsafeUtil.getByte(tempPos + 1)) & 255) << 8) | ((((long) UnsafeUtil.getByte(tempPos + 2)) & 255) << 16) | ((((long) UnsafeUtil.getByte(tempPos + 3)) & 255) << 24) | ((((long) UnsafeUtil.getByte(tempPos + 4)) & 255) << 32) | ((((long) UnsafeUtil.getByte(tempPos + 5)) & 255) << 40) | ((((long) UnsafeUtil.getByte(tempPos + 6)) & 255) << 48) | ((((long) UnsafeUtil.getByte(tempPos + 7)) & 255) << 56);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + getTotalBytesRead();
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit == Integer.MAX_VALUE) {
                return -1;
            }
            return this.currentLimit - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            long j = this.pos;
            this.pos = j + 1;
            return UnsafeUtil.getByte(j);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length >= 0 && length <= remaining()) {
                byte[] bytes = new byte[length];
                slice(this.pos, this.pos + ((long) length)).get(bytes);
                this.pos += (long) length;
                return bytes;
            } else if (length > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (length == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0 && length <= remaining()) {
                this.pos += (long) length;
            } else if (length < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += (long) this.bufferSizeAfterLimit;
            int bufferEnd = (int) (this.limit - this.startPos);
            if (bufferEnd > this.currentLimit) {
                this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
                this.limit -= (long) this.bufferSizeAfterLimit;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private int bufferPos(long pos) {
            return (int) (pos - this.address);
        }

        private ByteBuffer slice(long begin, long end) throws IOException {
            int prevPos;
            int prevLimit;
            try {
                prevPos = this.buffer.position();
                prevLimit = this.buffer.limit();
                try {
                    this.buffer.position(bufferPos(begin));
                    this.buffer.limit(bufferPos(end));
                    ByteBuffer slice = this.buffer.slice();
                    this.buffer.position(prevPos);
                    this.buffer.limit(prevLimit);
                    return slice;
                } catch (IllegalArgumentException e) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } catch (Throwable th) {
                this.buffer.position(prevPos);
                this.buffer.limit(prevLimit);
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStream$StreamDecoder.class */
    public static final class StreamDecoder extends CodedInputStream {
        private final InputStream input;
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int pos;
        private int lastTag;
        private int totalBytesRetired;
        private int currentLimit;
        private RefillCallback refillCallback;

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStream$StreamDecoder$RefillCallback.class */
        public interface RefillCallback {
            void onRefill();
        }

        private StreamDecoder(InputStream input, int bufferSize) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(input, "input");
            this.input = input;
            this.buffer = new byte[bufferSize];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        private static int read(InputStream input, byte[] data, int offset, int length) throws IOException {
            try {
                return input.read(data, offset, length);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private static long skip(InputStream input, long length) throws IOException {
            try {
                return input.skip(length);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private static int available(InputStream input) throws IOException {
            try {
                return input.available();
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeRawVarint32(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeRawVarint32(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeRawVarint32(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeRawVarint32(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeRawVarint32(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeRawVarint32(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        /* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStream$StreamDecoder$SkippedDataSink.class */
        private class SkippedDataSink implements RefillCallback {
            private int lastPos;
            private ByteArrayOutputStream byteArrayStream;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            @Override // com.google.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }

            ByteBuffer getSkippedData() {
                if (this.byteArrayStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && size <= this.bufferSize - this.pos) {
                String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
                this.pos += size;
                return result;
            } else if (size == 0) {
                return "";
            } else {
                if (size > this.bufferSize) {
                    return new String(readRawBytesSlowPath(size, false), Internal.UTF_8);
                }
                refillBuffer(size);
                String result2 = new String(this.buffer, this.pos, size, Internal.UTF_8);
                this.pos += size;
                return result2;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int tempPos;
            byte[] bytes;
            int size = readRawVarint32();
            int oldPos = this.pos;
            if (size <= this.bufferSize - oldPos && size > 0) {
                bytes = this.buffer;
                this.pos = oldPos + size;
                tempPos = oldPos;
            } else if (size == 0) {
                return "";
            } else {
                if (size <= this.bufferSize) {
                    refillBuffer(size);
                    bytes = this.buffer;
                    tempPos = 0;
                    this.pos = 0 + size;
                } else {
                    bytes = readRawBytesSlowPath(size, false);
                    tempPos = 0;
                }
            }
            return Utf8.decodeUtf8(bytes, tempPos, size);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size <= this.bufferSize - this.pos && size > 0) {
                ByteString result = ByteString.copyFrom(this.buffer, this.pos, size);
                this.pos += size;
                return result;
            } else if (size == 0) {
                return ByteString.EMPTY;
            } else {
                return readBytesSlowPath(size);
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            int size = readRawVarint32();
            if (size > this.bufferSize - this.pos || size <= 0) {
                return readRawBytesSlowPath(size, false);
            }
            byte[] result = Arrays.copyOfRange(this.buffer, this.pos, this.pos + size);
            this.pos += size;
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size <= this.bufferSize - this.pos && size > 0) {
                ByteBuffer result = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, this.pos, this.pos + size));
                this.pos += size;
                return result;
            } else if (size == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                return ByteBuffer.wrap(readRawBytesSlowPath(size, true));
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c2, code lost:
            if (r0[r5] < 0) goto L_0x00cf;
         */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 213
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint32():int");
        }

        private void skipRawVarint() throws IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v37, types: [long] */
        /* JADX WARN: Type inference failed for: r0v45, types: [long] */
        /* JADX WARN: Type inference failed for: r0v47, types: [long] */
        /* JADX WARN: Type inference failed for: r0v49, types: [long] */
        /* JADX WARN: Type inference failed for: r0v51, types: [long] */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v18 */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0121, code lost:
            if (((long) r0[r7]) < 0) goto L_0x012e;
         */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 307
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.StreamDecoder.readRawVarint64():long");
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            char c = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b = readRawByte();
                c |= ((long) (b & Byte.MAX_VALUE)) << shift;
                if ((b & 128) == 0) {
                    return c;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            int tempPos = this.pos;
            if (this.bufferSize - tempPos < 4) {
                refillBuffer(4);
                tempPos = this.pos;
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 4;
            return (buffer[tempPos] & 255) | ((buffer[tempPos + 1] & 255) << 8) | ((buffer[tempPos + 2] & 255) << 16) | ((buffer[tempPos + 3] & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            int tempPos = this.pos;
            if (this.bufferSize - tempPos < 8) {
                refillBuffer(8);
                tempPos = this.pos;
            }
            byte[] buffer = this.buffer;
            this.pos = tempPos + 8;
            return (((long) buffer[tempPos]) & 255) | ((((long) buffer[tempPos + 1]) & 255) << 8) | ((((long) buffer[tempPos + 2]) & 255) << 16) | ((((long) buffer[tempPos + 3]) & 255) << 24) | ((((long) buffer[tempPos + 4]) & 255) << 32) | ((((long) buffer[tempPos + 5]) & 255) << 40) | ((((long) buffer[tempPos + 6]) & 255) << 48) | ((((long) buffer[tempPos + 7]) & 255) << 56);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + this.totalBytesRetired + this.pos;
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        private void recomputeBufferSizeAfterLimit() {
            this.bufferSize += this.bufferSizeAfterLimit;
            int bufferEnd = this.totalBytesRetired + this.bufferSize;
            if (bufferEnd > this.currentLimit) {
                this.bufferSizeAfterLimit = bufferEnd - this.currentLimit;
                this.bufferSize -= this.bufferSizeAfterLimit;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit == Integer.MAX_VALUE) {
                return -1;
            }
            return this.currentLimit - (this.totalBytesRetired + this.pos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        private void refillBuffer(int n) throws IOException {
            if (tryRefillBuffer(n)) {
                return;
            }
            if (n > (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private boolean tryRefillBuffer(int n) throws IOException {
            if (this.pos + n <= this.bufferSize) {
                throw new IllegalStateException("refillBuffer() called when " + n + " bytes were already available in buffer");
            } else if (n > (this.sizeLimit - this.totalBytesRetired) - this.pos || this.totalBytesRetired + this.pos + n > this.currentLimit) {
                return false;
            } else {
                if (this.refillCallback != null) {
                    this.refillCallback.onRefill();
                }
                int tempPos = this.pos;
                if (tempPos > 0) {
                    if (this.bufferSize > tempPos) {
                        System.arraycopy(this.buffer, tempPos, this.buffer, 0, this.bufferSize - tempPos);
                    }
                    this.totalBytesRetired += tempPos;
                    this.bufferSize -= tempPos;
                    this.pos = 0;
                }
                int bytesRead = read(this.input, this.buffer, this.bufferSize, Math.min(this.buffer.length - this.bufferSize, (this.sizeLimit - this.totalBytesRetired) - this.bufferSize));
                if (bytesRead == 0 || bytesRead < -1 || bytesRead > this.buffer.length) {
                    throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + bytesRead + "\nThe InputStream implementation is buggy.");
                } else if (bytesRead <= 0) {
                    return false;
                } else {
                    this.bufferSize += bytesRead;
                    recomputeBufferSizeAfterLimit();
                    if (this.bufferSize >= n) {
                        return true;
                    }
                    return tryRefillBuffer(n);
                }
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int size) throws IOException {
            int tempPos = this.pos;
            if (size > this.bufferSize - tempPos || size <= 0) {
                return readRawBytesSlowPath(size, false);
            }
            this.pos = tempPos + size;
            return Arrays.copyOfRange(this.buffer, tempPos, tempPos + size);
        }

        private byte[] readRawBytesSlowPath(int size, boolean ensureNoLeakedReferences) throws IOException {
            byte[] result = readRawBytesSlowPathOneChunk(size);
            if (result != null) {
                return ensureNoLeakedReferences ? (byte[]) result.clone() : result;
            }
            int originalBufferPos = this.pos;
            int bufferedBytes = this.bufferSize - this.pos;
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> chunks = readRawBytesSlowPathRemainingChunks(size - bufferedBytes);
            byte[] bytes = new byte[size];
            System.arraycopy(this.buffer, originalBufferPos, bytes, 0, bufferedBytes);
            int tempPos = bufferedBytes;
            for (byte[] chunk : chunks) {
                System.arraycopy(chunk, 0, bytes, tempPos, chunk.length);
                tempPos += chunk.length;
            }
            return bytes;
        }

        private byte[] readRawBytesSlowPathOneChunk(int size) throws IOException {
            if (size == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int currentMessageSize = this.totalBytesRetired + this.pos + size;
            if (currentMessageSize - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            } else if (currentMessageSize > this.currentLimit) {
                skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.pos);
                throw InvalidProtocolBufferException.truncatedMessage();
            } else {
                int bufferedBytes = this.bufferSize - this.pos;
                int sizeLeft = size - bufferedBytes;
                if (sizeLeft >= 4096 && sizeLeft > available(this.input)) {
                    return null;
                }
                byte[] bytes = new byte[size];
                System.arraycopy(this.buffer, this.pos, bytes, 0, bufferedBytes);
                this.totalBytesRetired += this.bufferSize;
                this.pos = 0;
                this.bufferSize = 0;
                int tempPos = bufferedBytes;
                while (tempPos < bytes.length) {
                    int n = read(this.input, bytes, tempPos, size - tempPos);
                    if (n == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += n;
                    tempPos += n;
                }
                return bytes;
            }
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int sizeLeft) throws IOException {
            List<byte[]> chunks = new ArrayList<>();
            while (sizeLeft > 0) {
                byte[] chunk = new byte[Math.min(sizeLeft, 4096)];
                int tempPos = 0;
                while (tempPos < chunk.length) {
                    int n = this.input.read(chunk, tempPos, chunk.length - tempPos);
                    if (n == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += n;
                    tempPos += n;
                }
                sizeLeft -= chunk.length;
                chunks.add(chunk);
            }
            return chunks;
        }

        private ByteString readBytesSlowPath(int size) throws IOException {
            byte[] result = readRawBytesSlowPathOneChunk(size);
            if (result != null) {
                return ByteString.copyFrom(result);
            }
            int originalBufferPos = this.pos;
            int bufferedBytes = this.bufferSize - this.pos;
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> chunks = readRawBytesSlowPathRemainingChunks(size - bufferedBytes);
            byte[] bytes = new byte[size];
            System.arraycopy(this.buffer, originalBufferPos, bytes, 0, bufferedBytes);
            int tempPos = bufferedBytes;
            for (byte[] chunk : chunks) {
                System.arraycopy(chunk, 0, bytes, tempPos, chunk.length);
                tempPos += chunk.length;
            }
            return ByteString.wrap(bytes);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int size) throws IOException {
            if (size > this.bufferSize - this.pos || size < 0) {
                skipRawBytesSlowPath(size);
            } else {
                this.pos += size;
            }
        }

        private void skipRawBytesSlowPath(int size) throws IOException {
            if (size < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else if (this.totalBytesRetired + this.pos + size > this.currentLimit) {
                skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.pos);
                throw InvalidProtocolBufferException.truncatedMessage();
            } else {
                int totalSkipped = 0;
                if (this.refillCallback == null) {
                    this.totalBytesRetired += this.pos;
                    totalSkipped = this.bufferSize - this.pos;
                    this.bufferSize = 0;
                    this.pos = 0;
                    while (totalSkipped < size) {
                        try {
                            int toSkip = size - totalSkipped;
                            long skipped = skip(this.input, (long) toSkip);
                            if (skipped < 0 || skipped > ((long) toSkip)) {
                                throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + skipped + "\nThe InputStream implementation is buggy.");
                            } else if (skipped == 0) {
                                break;
                            } else {
                                totalSkipped += (int) skipped;
                            }
                        } finally {
                            this.totalBytesRetired += totalSkipped;
                            recomputeBufferSizeAfterLimit();
                        }
                    }
                }
                if (totalSkipped < size) {
                    int tempPos = this.bufferSize - this.pos;
                    this.pos = this.bufferSize;
                    refillBuffer(1);
                    while (size - tempPos > this.bufferSize) {
                        tempPos += this.bufferSize;
                        this.pos = this.bufferSize;
                        refillBuffer(1);
                    }
                    this.pos = size - tempPos;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/CodedInputStream$IterableDirectByteBufferDecoder.class */
    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private Iterable<ByteBuffer> input;
        private Iterator<ByteBuffer> iterator;
        private ByteBuffer currentByteBuffer;
        private boolean immutable;
        private boolean enableAliasing;
        private int totalBufferSize;
        private int bufferSizeAfterCurrentLimit;
        private int currentLimit;
        private int lastTag;
        private int totalBytesRead;
        private int startOffset;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private long currentAddress;
        private long currentByteBufferLimit;

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> inputBufs, int size, boolean immutableFlag) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = size;
            this.input = inputBufs;
            this.iterator = this.input.iterator();
            this.immutable = immutableFlag;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (size == 0) {
                this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
                this.currentByteBufferPos = 0;
                this.currentByteBufferStartPos = 0;
                this.currentByteBufferLimit = 0;
                this.currentAddress = 0;
                return;
            }
            tryGetNextByteBuffer();
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void tryGetNextByteBuffer() {
            this.currentByteBuffer = this.iterator.next();
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            this.currentByteBufferPos = (long) this.currentByteBuffer.position();
            this.currentByteBufferStartPos = this.currentByteBufferPos;
            this.currentByteBufferLimit = (long) this.currentByteBuffer.limit();
            this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentByteBufferPos += this.currentAddress;
            this.currentByteBufferStartPos += this.currentAddress;
            this.currentByteBufferLimit += this.currentAddress;
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.google.protobuf.CodedInputStream
        public void checkLastTagWas(int value) throws InvalidProtocolBufferException {
            if (this.lastTag != value) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getLastTag() {
            return this.lastTag;
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    skipRawVarint();
                    return true;
                case 1:
                    skipRawBytes(8);
                    return true;
                case 2:
                    skipRawBytes(readRawVarint32());
                    return true;
                case 3:
                    skipMessage();
                    checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
                    return true;
                case 4:
                    return false;
                case 5:
                    skipRawBytes(4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean skipField(int tag, CodedOutputStream output) throws IOException {
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    long value = readInt64();
                    output.writeRawVarint32(tag);
                    output.writeUInt64NoTag(value);
                    return true;
                case 1:
                    long value2 = readRawLittleEndian64();
                    output.writeRawVarint32(tag);
                    output.writeFixed64NoTag(value2);
                    return true;
                case 2:
                    ByteString value3 = readBytes();
                    output.writeRawVarint32(tag);
                    output.writeBytesNoTag(value3);
                    return true;
                case 3:
                    output.writeRawVarint32(tag);
                    skipMessage(output);
                    int endtag = WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4);
                    checkLastTagWas(endtag);
                    output.writeRawVarint32(endtag);
                    return true;
                case 4:
                    return false;
                case 5:
                    int value4 = readRawLittleEndian32();
                    output.writeRawVarint32(tag);
                    output.writeFixed32NoTag(value4);
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage() throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag));
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream output) throws IOException {
            int tag;
            do {
                tag = readTag();
                if (tag == 0) {
                    return;
                }
            } while (skipField(tag, output));
        }

        @Override // com.google.protobuf.CodedInputStream
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.google.protobuf.CodedInputStream
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readString() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && ((long) size) <= this.currentByteBufferLimit - this.currentByteBufferPos) {
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0, (long) size);
                String result = new String(bytes, Internal.UTF_8);
                this.currentByteBufferPos += (long) size;
                return result;
            } else if (size > 0 && size <= remaining()) {
                byte[] bytes2 = new byte[size];
                readRawBytesTo(bytes2, 0, size);
                return new String(bytes2, Internal.UTF_8);
            } else if (size == 0) {
                return "";
            } else {
                if (size < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            int size = readRawVarint32();
            if (size > 0 && ((long) size) <= this.currentByteBufferLimit - this.currentByteBufferPos) {
                String result = Utf8.decodeUtf8(this.currentByteBuffer, (int) (this.currentByteBufferPos - this.currentByteBufferStartPos), size);
                this.currentByteBufferPos += (long) size;
                return result;
            } else if (size >= 0 && size <= remaining()) {
                byte[] bytes = new byte[size];
                readRawBytesTo(bytes, 0, size);
                return Utf8.decodeUtf8(bytes, 0, size);
            } else if (size == 0) {
                return "";
            } else {
                if (size <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
            this.recursionDepth--;
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder) throws IOException {
            readGroup(fieldNumber, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.CodedInputStream
        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
        }

        @Override // com.google.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry) throws IOException {
            int length = readRawVarint32();
            checkRecursionLimit();
            int oldLimit = pushLimit(length);
            this.recursionDepth++;
            T result = parser.parsePartialFrom(this, extensionRegistry);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(oldLimit);
            return result;
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteString readBytes() throws IOException {
            int size = readRawVarint32();
            if (size <= 0 || ((long) size) > this.currentByteBufferLimit - this.currentByteBufferPos) {
                if (size <= 0 || size > remaining()) {
                    if (size == 0) {
                        return ByteString.EMPTY;
                    }
                    if (size < 0) {
                        throw InvalidProtocolBufferException.negativeSize();
                    }
                    throw InvalidProtocolBufferException.truncatedMessage();
                } else if (!this.immutable || !this.enableAliasing) {
                    byte[] temp = new byte[size];
                    readRawBytesTo(temp, 0, size);
                    return ByteString.wrap(temp);
                } else {
                    ArrayList<ByteString> byteStrings = new ArrayList<>();
                    int l = size;
                    while (l > 0) {
                        if (currentRemaining() == 0) {
                            getNextByteBuffer();
                        }
                        int bytesToCopy = Math.min(l, (int) currentRemaining());
                        int idx = (int) (this.currentByteBufferPos - this.currentAddress);
                        byteStrings.add(ByteString.wrap(slice(idx, idx + bytesToCopy)));
                        l -= bytesToCopy;
                        this.currentByteBufferPos += (long) bytesToCopy;
                    }
                    return ByteString.copyFrom(byteStrings);
                }
            } else if (!this.immutable || !this.enableAliasing) {
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0, (long) size);
                this.currentByteBufferPos += (long) size;
                return ByteString.wrap(bytes);
            } else {
                int idx2 = (int) (this.currentByteBufferPos - this.currentAddress);
                ByteString result = ByteString.wrap(slice(idx2, idx2 + size));
                this.currentByteBufferPos += (long) size;
                return result;
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws IOException {
            int size = readRawVarint32();
            if (size <= 0 || ((long) size) > currentRemaining()) {
                if (size > 0 && size <= remaining()) {
                    byte[] temp = new byte[size];
                    readRawBytesTo(temp, 0, size);
                    return ByteBuffer.wrap(temp);
                } else if (size == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                } else {
                    if (size < 0) {
                        throw InvalidProtocolBufferException.negativeSize();
                    }
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else if (this.immutable || !this.enableAliasing) {
                byte[] bytes = new byte[size];
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0, (long) size);
                this.currentByteBufferPos += (long) size;
                return ByteBuffer.wrap(bytes);
            } else {
                this.currentByteBufferPos += (long) size;
                return slice((int) ((this.currentByteBufferPos - this.currentAddress) - ((long) size)), (int) (this.currentByteBufferPos - this.currentAddress));
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARN: Type inference failed for: r1v27, types: [long] */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00df, code lost:
            if (r0 < 0) goto L_0x00ec;
         */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 242
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.readRawVarint32():int");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r0v37, types: [long] */
        /* JADX WARN: Type inference failed for: r1v66, types: [long] */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r0v45, types: [long] */
        /* JADX WARN: Type inference failed for: r0v47, types: [long] */
        /* JADX WARN: Type inference failed for: r0v49, types: [long] */
        /* JADX WARN: Type inference failed for: r0v51, types: [long] */
        /* JADX WARN: Type inference failed for: r10v13 */
        /* JADX WARN: Type inference failed for: r10v14 */
        /* JADX WARN: Type inference failed for: r10v15 */
        /* JADX WARN: Type inference failed for: r10v16 */
        /* JADX WARN: Type inference failed for: r10v17 */
        /* JADX WARN: Type inference failed for: r10v18 */
        /* JADX WARN: Type inference failed for: r10v19 */
        /* JADX WARN: Type inference failed for: r10v20 */
        /* JADX WARN: Type inference failed for: r12v17 */
        /* JADX WARN: Type inference failed for: r12v18 */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x013e, code lost:
            if (((long) com.google.protobuf.UnsafeUtil.getByte(r10)) < 0) goto L_0x014b;
         */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.google.protobuf.CodedInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long readRawVarint64() throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 336
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.readRawVarint64():long");
        }

        /* JADX WARN: Type inference failed for: r0v7, types: [long] */
        @Override // com.google.protobuf.CodedInputStream
        long readRawVarint64SlowPath() throws IOException {
            char c = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b = readRawByte();
                c |= ((long) (b & Byte.MAX_VALUE)) << shift;
                if ((b & 128) == 0) {
                    return c;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
            }
            long tempPos = this.currentByteBufferPos;
            this.currentByteBufferPos += 4;
            return (UnsafeUtil.getByte(tempPos) & 255) | ((UnsafeUtil.getByte(tempPos + 1) & 255) << 8) | ((UnsafeUtil.getByte(tempPos + 2) & 255) << 16) | ((UnsafeUtil.getByte(tempPos + 3) & 255) << 24);
        }

        @Override // com.google.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws IOException {
            if (currentRemaining() < 8) {
                return (((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48) | ((((long) readRawByte()) & 255) << 56);
            }
            long tempPos = this.currentByteBufferPos;
            this.currentByteBufferPos += 8;
            return (((long) UnsafeUtil.getByte(tempPos)) & 255) | ((((long) UnsafeUtil.getByte(tempPos + 1)) & 255) << 8) | ((((long) UnsafeUtil.getByte(tempPos + 2)) & 255) << 16) | ((((long) UnsafeUtil.getByte(tempPos + 3)) & 255) << 24) | ((((long) UnsafeUtil.getByte(tempPos + 4)) & 255) << 32) | ((((long) UnsafeUtil.getByte(tempPos + 5)) & 255) << 40) | ((((long) UnsafeUtil.getByte(tempPos + 6)) & 255) << 48) | ((((long) UnsafeUtil.getByte(tempPos + 7)) & 255) << 56);
        }

        @Override // com.google.protobuf.CodedInputStream
        public void enableAliasing(boolean enabled) {
            this.enableAliasing = enabled;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int pushLimit(int byteLimit) throws InvalidProtocolBufferException {
            if (byteLimit < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int byteLimit2 = byteLimit + getTotalBytesRead();
            int oldLimit = this.currentLimit;
            if (byteLimit2 > oldLimit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = byteLimit2;
            recomputeBufferSizeAfterLimit();
            return oldLimit;
        }

        private void recomputeBufferSizeAfterLimit() {
            this.totalBufferSize += this.bufferSizeAfterCurrentLimit;
            int bufferEnd = this.totalBufferSize - this.startOffset;
            if (bufferEnd > this.currentLimit) {
                this.bufferSizeAfterCurrentLimit = bufferEnd - this.currentLimit;
                this.totalBufferSize -= this.bufferSizeAfterCurrentLimit;
                return;
            }
            this.bufferSizeAfterCurrentLimit = 0;
        }

        @Override // com.google.protobuf.CodedInputStream
        public void popLimit(int oldLimit) {
            this.currentLimit = oldLimit;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            if (this.currentLimit == Integer.MAX_VALUE) {
                return -1;
            }
            return this.currentLimit - getTotalBytesRead();
        }

        @Override // com.google.protobuf.CodedInputStream
        public boolean isAtEnd() throws IOException {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // com.google.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte readRawByte() throws IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j = this.currentByteBufferPos;
            this.currentByteBufferPos = j + 1;
            return UnsafeUtil.getByte(j);
        }

        @Override // com.google.protobuf.CodedInputStream
        public byte[] readRawBytes(int length) throws IOException {
            if (length >= 0 && ((long) length) <= currentRemaining()) {
                byte[] bytes = new byte[length];
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, 0, (long) length);
                this.currentByteBufferPos += (long) length;
                return bytes;
            } else if (length >= 0 && length <= remaining()) {
                byte[] bytes2 = new byte[length];
                readRawBytesTo(bytes2, 0, length);
                return bytes2;
            } else if (length > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (length == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private void readRawBytesTo(byte[] bytes, int offset, int length) throws IOException {
            if (length >= 0 && length <= remaining()) {
                int l = length;
                while (l > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int bytesToCopy = Math.min(l, (int) currentRemaining());
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bytes, (long) ((length - l) + offset), (long) bytesToCopy);
                    l -= bytesToCopy;
                    this.currentByteBufferPos += (long) bytesToCopy;
                }
            } else if (length > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (length != 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        @Override // com.google.protobuf.CodedInputStream
        public void skipRawBytes(int length) throws IOException {
            if (length >= 0 && ((long) length) <= (((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                int l = length;
                while (l > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int rl = Math.min(l, (int) currentRemaining());
                    l -= rl;
                    this.currentByteBufferPos += (long) rl;
                }
            } else if (length < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void skipRawVarint() throws IOException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private ByteBuffer slice(int begin, int end) throws IOException {
            int prevPos = this.currentByteBuffer.position();
            int prevLimit = this.currentByteBuffer.limit();
            try {
                try {
                    this.currentByteBuffer.position(begin);
                    this.currentByteBuffer.limit(end);
                    ByteBuffer slice = this.currentByteBuffer.slice();
                    this.currentByteBuffer.position(prevPos);
                    this.currentByteBuffer.limit(prevLimit);
                    return slice;
                } catch (IllegalArgumentException e) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } catch (Throwable th) {
                this.currentByteBuffer.position(prevPos);
                this.currentByteBuffer.limit(prevLimit);
                throw th;
            }
        }
    }
}
