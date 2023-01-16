package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.slf4j.Marker;

/* loaded from: grasscutter.jar:com/google/protobuf/ByteString.class */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    private static final ByteArrayCopier byteArrayCopier;
    private int hash = 0;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$ByteArrayCopier.class */
    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i, int i2);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$ByteIterator.class */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public abstract byte byteAt(int i);

    /* access modifiers changed from: package-private */
    public abstract byte internalByteAt(int i);

    public abstract int size();

    public abstract ByteString substring(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    public abstract void copyTo(ByteBuffer byteBuffer);

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeTo(ByteOutput byteOutput) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeToReverse(ByteOutput byteOutput) throws IOException;

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    protected abstract String toStringInternal(Charset charset);

    public abstract boolean isValidUtf8();

    /* access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    @Override // java.lang.Object
    public abstract boolean equals(Object obj);

    public abstract InputStream newInput();

    public abstract CodedInputStream newCodedInput();

    /* access modifiers changed from: protected */
    public abstract int getTreeDepth();

    /* access modifiers changed from: protected */
    public abstract boolean isBalanced();

    /* access modifiers changed from: protected */
    public abstract int partialHash(int i, int i2, int i3);

    static {
        byteArrayCopier = Android.isOnAndroidDevice() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() { // from class: com.google.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.protobuf.ByteString$ByteIterator] */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.google.protobuf.ByteString$ByteIterator] */
            /* JADX WARNING: Unknown variable types count: 2 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int compare(com.google.protobuf.ByteString r4, com.google.protobuf.ByteString r5) {
                /*
                    r3 = this;
                    r0 = r4
                    com.google.protobuf.ByteString$ByteIterator r0 = r0.iterator()
                    r6 = r0
                    r0 = r5
                    com.google.protobuf.ByteString$ByteIterator r0 = r0.iterator()
                    r7 = r0
                L_0x000b:
                    r0 = r6
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x0041
                    r0 = r7
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x0041
                    r0 = r6
                    byte r0 = r0.nextByte()
                    int r0 = com.google.protobuf.ByteString.access$200(r0)
                    r1 = r7
                    byte r1 = r1.nextByte()
                    int r1 = com.google.protobuf.ByteString.access$200(r1)
                    int r0 = java.lang.Integer.compare(r0, r1)
                    r8 = r0
                    r0 = r8
                    if (r0 == 0) goto L_0x003e
                    r0 = r8
                    return r0
                L_0x003e:
                    goto L_0x000b
                L_0x0041:
                    r0 = r4
                    int r0 = r0.size()
                    r1 = r5
                    int r1 = r1.size()
                    int r0 = java.lang.Integer.compare(r0, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ByteString.C07292.compare(com.google.protobuf.ByteString, com.google.protobuf.ByteString):int");
            }
        };
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$SystemByteArrayCopier.class */
    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bytes, int offset, int size) {
            byte[] copy = new byte[size];
            System.arraycopy(bytes, offset, copy, 0, size);
            return copy;
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$ArraysByteArrayCopier.class */
    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bytes, int offset, int size) {
            return Arrays.copyOfRange(bytes, offset, offset + size);
        }
    }

    /* Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AbstractByteIterator() { // from class: com.google.protobuf.ByteString.1
            private int position = 0;
            private final int limit;

            {
                this.limit = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.position < this.limit;
            }

            @Override // com.google.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int currentPos = this.position;
                if (currentPos >= this.limit) {
                    throw new NoSuchElementException();
                }
                this.position = currentPos + 1;
                return ByteString.this.internalByteAt(currentPos);
            }
        };
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$AbstractByteIterator.class */
    static abstract class AbstractByteIterator implements ByteIterator {
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: private */
    public static int toInt(byte value) {
        return value & 255;
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public final ByteString substring(int beginIndex) {
        return substring(beginIndex, size());
    }

    public final boolean startsWith(ByteString prefix) {
        return size() >= prefix.size() && substring(0, prefix.size()).equals(prefix);
    }

    public final boolean endsWith(ByteString suffix) {
        return size() >= suffix.size() && substring(size() - suffix.size()).equals(suffix);
    }

    public static ByteString copyFrom(byte[] bytes, int offset, int size) {
        checkRange(offset, offset + size, bytes.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bytes, offset, size));
    }

    public static ByteString copyFrom(byte[] bytes) {
        return copyFrom(bytes, 0, bytes.length);
    }

    /* access modifiers changed from: package-private */
    public static ByteString wrap(ByteBuffer buffer) {
        if (!buffer.hasArray()) {
            return new NioByteString(buffer);
        }
        return wrap(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
    }

    /* access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bytes) {
        return new LiteralByteString(bytes);
    }

    /* access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bytes, int offset, int length) {
        return new BoundedByteString(bytes, offset, length);
    }

    public static ByteString copyFrom(ByteBuffer bytes, int size) {
        checkRange(0, size, bytes.remaining());
        byte[] copy = new byte[size];
        bytes.get(copy);
        return new LiteralByteString(copy);
    }

    public static ByteString copyFrom(ByteBuffer bytes) {
        return copyFrom(bytes, bytes.remaining());
    }

    public static ByteString copyFrom(String text, String charsetName) throws UnsupportedEncodingException {
        return new LiteralByteString(text.getBytes(charsetName));
    }

    public static ByteString copyFrom(String text, Charset charset) {
        return new LiteralByteString(text.getBytes(charset));
    }

    public static ByteString copyFromUtf8(String text) {
        return new LiteralByteString(text.getBytes(Internal.UTF_8));
    }

    public static ByteString readFrom(InputStream streamToDrain) throws IOException {
        return readFrom(streamToDrain, 256, 8192);
    }

    public static ByteString readFrom(InputStream streamToDrain, int chunkSize) throws IOException {
        return readFrom(streamToDrain, chunkSize, chunkSize);
    }

    public static ByteString readFrom(InputStream streamToDrain, int minChunkSize, int maxChunkSize) throws IOException {
        Collection<ByteString> results = new ArrayList<>();
        int chunkSize = minChunkSize;
        while (true) {
            ByteString chunk = readChunk(streamToDrain, chunkSize);
            if (chunk == null) {
                return copyFrom(results);
            }
            results.add(chunk);
            chunkSize = Math.min(chunkSize * 2, maxChunkSize);
        }
    }

    private static ByteString readChunk(InputStream in, int chunkSize) throws IOException {
        int count;
        byte[] buf = new byte[chunkSize];
        int bytesRead = 0;
        while (bytesRead < chunkSize && (count = in.read(buf, bytesRead, chunkSize - bytesRead)) != -1) {
            bytesRead += count;
        }
        if (bytesRead == 0) {
            return null;
        }
        return copyFrom(buf, 0, bytesRead);
    }

    public final ByteString concat(ByteString other) {
        if (Integer.MAX_VALUE - size() >= other.size()) {
            return RopeByteString.concatenate(this, other);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + Marker.ANY_NON_NULL_MARKER + other.size());
    }

    public static ByteString copyFrom(Iterable<ByteString> byteStrings) {
        int size;
        if (!(byteStrings instanceof Collection)) {
            int tempSize = 0;
            Iterator<ByteString> iter = byteStrings.iterator();
            while (iter.hasNext()) {
                iter.next();
                tempSize++;
            }
            size = tempSize;
        } else {
            size = ((Collection) byteStrings).size();
        }
        if (size == 0) {
            return EMPTY;
        }
        return balancedConcat(byteStrings.iterator(), size);
    }

    private static ByteString balancedConcat(Iterator<ByteString> iterator, int length) {
        ByteString result;
        if (length < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(length)));
        }
        if (length == 1) {
            result = iterator.next();
        } else {
            int halfLength = length >>> 1;
            result = balancedConcat(iterator, halfLength).concat(balancedConcat(iterator, length - halfLength));
        }
        return result;
    }

    public void copyTo(byte[] target, int offset) {
        copyTo(target, 0, offset, size());
    }

    @Deprecated
    public final void copyTo(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        checkRange(sourceOffset, sourceOffset + numberToCopy, size());
        checkRange(targetOffset, targetOffset + numberToCopy, target.length);
        if (numberToCopy > 0) {
            copyToInternal(target, sourceOffset, targetOffset, numberToCopy);
        }
    }

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] result = new byte[size];
        copyToInternal(result, 0, 0, size);
        return result;
    }

    final void writeTo(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
        checkRange(sourceOffset, sourceOffset + numberToWrite, size());
        if (numberToWrite > 0) {
            writeToInternal(out, sourceOffset, numberToWrite);
        }
    }

    public final String toString(String charsetName) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(charsetName));
        } catch (UnsupportedCharsetException e) {
            UnsupportedEncodingException exception = new UnsupportedEncodingException(charsetName);
            exception.initCause(e);
            throw exception;
        }
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$LeafByteString.class */
    static abstract class LeafByteString extends ByteString {
        /* access modifiers changed from: package-private */
        public abstract boolean equalsRange(ByteString byteString, int i, int i2);

        /* Return type fixed from 'java.util.Iterator' to match base method */
        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return iterator();
        }

        @Override // com.google.protobuf.ByteString
        protected final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        protected final boolean isBalanced() {
            return true;
        }

        @Override // com.google.protobuf.ByteString
        void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int h = this.hash;
        if (h == 0) {
            int size = size();
            h = partialHash(size, 0, size);
            if (h == 0) {
                h = 1;
            }
            this.hash = h;
        }
        return h;
    }

    public static Output newOutput(int initialCapacity) {
        return new Output(initialCapacity);
    }

    public static Output newOutput() {
        return new Output(128);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$Output.class */
    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private final int initialCapacity;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private byte[] buffer;
        private int bufferPos;

        Output(int initialCapacity) {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.initialCapacity = initialCapacity;
            this.flushedBuffers = new ArrayList<>();
            this.buffer = new byte[initialCapacity];
        }

        @Override // java.io.OutputStream
        public synchronized void write(int b) {
            if (this.bufferPos == this.buffer.length) {
                flushFullBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i = this.bufferPos;
            this.bufferPos = i + 1;
            bArr[i] = (byte) b;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] b, int offset, int length) {
            if (length <= this.buffer.length - this.bufferPos) {
                System.arraycopy(b, offset, this.buffer, this.bufferPos, length);
                this.bufferPos += length;
                return;
            }
            int copySize = this.buffer.length - this.bufferPos;
            System.arraycopy(b, offset, this.buffer, this.bufferPos, copySize);
            int offset2 = offset + copySize;
            int length2 = length - copySize;
            flushFullBuffer(length2);
            System.arraycopy(b, offset2, this.buffer, 0, length2);
            this.bufferPos = length2;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom(this.flushedBuffers);
        }

        private byte[] copyArray(byte[] buffer, int length) {
            byte[] result = new byte[length];
            System.arraycopy(buffer, 0, result, 0, Math.min(buffer.length, length));
            return result;
        }

        public void writeTo(OutputStream out) throws IOException {
            ByteString[] cachedFlushBuffers;
            byte[] cachedBuffer;
            int cachedBufferPos;
            synchronized (this) {
                cachedFlushBuffers = (ByteString[]) this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
                cachedBuffer = this.buffer;
                cachedBufferPos = this.bufferPos;
            }
            for (ByteString byteString : cachedFlushBuffers) {
                byteString.writeTo(out);
            }
            out.write(copyArray(cachedBuffer, cachedBufferPos));
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized void reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        private void flushFullBuffer(int minSize) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            this.flushedBuffersTotalBytes += this.buffer.length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(minSize, this.flushedBuffersTotalBytes >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            if (this.bufferPos >= this.buffer.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (this.bufferPos > 0) {
                this.flushedBuffers.add(new LiteralByteString(copyArray(this.buffer, this.bufferPos)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static CodedBuilder newCodedBuilder(int size) {
        return new CodedBuilder(size);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$CodedBuilder.class */
    public static final class CodedBuilder {
        private final CodedOutputStream output;
        private final byte[] buffer;

        private CodedBuilder(int size) {
            this.buffer = new byte[size];
            this.output = CodedOutputStream.newInstance(this.buffer);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }
    }

    /* access modifiers changed from: protected */
    public final int peekCachedHashCode() {
        return this.hash;
    }

    static void checkIndex(int index, int size) {
        if ((index | (size - (index + 1))) >= 0) {
            return;
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + index);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + index + ", " + size);
    }

    static int checkRange(int startIndex, int endIndex, int size) {
        int length = endIndex - startIndex;
        if ((startIndex | endIndex | length | (size - endIndex)) >= 0) {
            return length;
        }
        if (startIndex < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + startIndex + " < 0");
        } else if (endIndex < startIndex) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + startIndex + ", " + endIndex);
        } else {
            throw new IndexOutOfBoundsException("End index: " + endIndex + " >= " + size);
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay());
    }

    private String truncateAndEscapeForDisplay() {
        return size() <= 50 ? TextFormatEscaper.escapeBytes(this) : TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$LiteralByteString.class */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bytes) {
            if (bytes == null) {
                throw new NullPointerException();
            }
            this.bytes = bytes;
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int index) {
            return this.bytes[index];
        }

        @Override // com.google.protobuf.ByteString
        byte internalByteAt(int index) {
            return this.bytes[index];
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int beginIndex, int endIndex) {
            int length = checkRange(beginIndex, endIndex, size());
            if (length == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + beginIndex, length);
        }

        @Override // com.google.protobuf.ByteString
        protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.bytes, sourceOffset, target, targetOffset, numberToCopy);
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer target) {
            target.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        final void writeToInternal(OutputStream outputStream, int sourceOffset, int numberToWrite) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + sourceOffset, numberToWrite);
        }

        @Override // com.google.protobuf.ByteString
        final void writeTo(ByteOutput output) throws IOException {
            output.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        protected final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offset = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offset, offset + size());
        }

        @Override // com.google.protobuf.ByteString
        protected final int partialIsValidUtf8(int state, int offset, int length) {
            int index = getOffsetIntoBytes() + offset;
            return Utf8.partialIsValidUtf8(state, this.bytes, index, index + length);
        }

        @Override // com.google.protobuf.ByteString, java.lang.Object
        public final boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof ByteString) || size() != ((ByteString) other).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(other instanceof LiteralByteString)) {
                return other.equals(this);
            }
            int thisHash = peekCachedHashCode();
            int thatHash = ((LiteralByteString) other).peekCachedHashCode();
            if (thisHash == 0 || thatHash == 0 || thisHash == thatHash) {
                return equalsRange((LiteralByteString) other, 0, size());
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString other, int offset, int length) {
            if (length > other.size()) {
                throw new IllegalArgumentException("Length too large: " + length + size());
            } else if (offset + length > other.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + offset + ", " + length + ", " + other.size());
            } else if (!(other instanceof LiteralByteString)) {
                return other.substring(offset, offset + length).equals(substring(0, length));
            } else {
                LiteralByteString lbsOther = (LiteralByteString) other;
                byte[] thisBytes = this.bytes;
                byte[] otherBytes = lbsOther.bytes;
                int thisLimit = getOffsetIntoBytes() + length;
                int thisIndex = getOffsetIntoBytes();
                int otherIndex = lbsOther.getOffsetIntoBytes() + offset;
                while (thisIndex < thisLimit) {
                    if (thisBytes[thisIndex] != otherBytes[otherIndex]) {
                        return false;
                    }
                    thisIndex++;
                    otherIndex++;
                }
                return true;
            }
        }

        @Override // com.google.protobuf.ByteString
        protected final int partialHash(int h, int offset, int length) {
            return Internal.partialHash(h, this.bytes, getOffsetIntoBytes() + offset, length);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        protected int getOffsetIntoBytes() {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/ByteString$BoundedByteString.class */
    public static final class BoundedByteString extends LiteralByteString {
        private final int bytesOffset;
        private final int bytesLength;
        private static final long serialVersionUID = 1;

        BoundedByteString(byte[] bytes, int offset, int length) {
            super(bytes);
            checkRange(offset, offset + length, bytes.length);
            this.bytesOffset = offset;
            this.bytesLength = length;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public byte byteAt(int index) {
            checkIndex(index, size());
            return this.bytes[this.bytesOffset + index];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        byte internalByteAt(int index) {
            return this.bytes[this.bytesOffset + index];
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.LiteralByteString, com.google.protobuf.ByteString
        protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + sourceOffset, target, targetOffset, numberToCopy);
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }

        private void readObject(ObjectInputStream in) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }
    }
}
