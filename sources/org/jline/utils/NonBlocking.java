package org.jline.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/NonBlocking.class */
public class NonBlocking {
    public static NonBlockingPumpReader nonBlockingPumpReader() {
        return new NonBlockingPumpReader();
    }

    public static NonBlockingPumpReader nonBlockingPumpReader(int size) {
        return new NonBlockingPumpReader(size);
    }

    public static NonBlockingPumpInputStream nonBlockingPumpInputStream() {
        return new NonBlockingPumpInputStream();
    }

    public static NonBlockingPumpInputStream nonBlockingPumpInputStream(int size) {
        return new NonBlockingPumpInputStream(size);
    }

    public static NonBlockingInputStream nonBlockingStream(NonBlockingReader reader, Charset encoding) {
        return new NonBlockingReaderInputStream(reader, encoding);
    }

    public static NonBlockingInputStream nonBlocking(String name, InputStream inputStream) {
        if (inputStream instanceof NonBlockingInputStream) {
            return (NonBlockingInputStream) inputStream;
        }
        return new NonBlockingInputStreamImpl(name, inputStream);
    }

    public static NonBlockingReader nonBlocking(String name, Reader reader) {
        if (reader instanceof NonBlockingReader) {
            return (NonBlockingReader) reader;
        }
        return new NonBlockingReaderImpl(name, reader);
    }

    public static NonBlockingReader nonBlocking(String name, InputStream inputStream, Charset encoding) {
        return new NonBlockingInputStreamReader(nonBlocking(name, inputStream), encoding);
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/utils/NonBlocking$NonBlockingReaderInputStream.class */
    private static class NonBlockingReaderInputStream extends NonBlockingInputStream {
        private final NonBlockingReader reader;
        private final CharsetEncoder encoder;
        private final ByteBuffer bytes;
        private final CharBuffer chars;

        private NonBlockingReaderInputStream(NonBlockingReader reader, Charset charset) {
            this.reader = reader;
            this.encoder = charset.newEncoder().onUnmappableCharacter(CodingErrorAction.REPLACE).onMalformedInput(CodingErrorAction.REPLACE);
            this.bytes = ByteBuffer.allocate(4);
            this.chars = CharBuffer.allocate(2);
            this.bytes.limit(0);
            this.chars.limit(0);
        }

        @Override // java.io.InputStream
        public int available() {
            return ((int) (((float) this.reader.available()) * this.encoder.averageBytesPerChar())) + this.bytes.remaining();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.reader.close();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x000d */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x000d */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0, types: [long] */
        /* JADX WARN: Type inference failed for: r8v1, types: [long] */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [org.jline.utils.NonBlockingReader] */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r0v56, types: [long] */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jline.utils.NonBlockingInputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read(long r8, boolean r10) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 230
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlocking.NonBlockingReaderInputStream.read(long, boolean):int");
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/utils/NonBlocking$NonBlockingInputStreamReader.class */
    public static class NonBlockingInputStreamReader extends NonBlockingReader {
        private final NonBlockingInputStream input;
        private final CharsetDecoder decoder;
        private final ByteBuffer bytes;
        private final CharBuffer chars;

        public NonBlockingInputStreamReader(NonBlockingInputStream inputStream, Charset encoding) {
            this(inputStream, (encoding != null ? encoding : Charset.defaultCharset()).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE));
        }

        public NonBlockingInputStreamReader(NonBlockingInputStream input, CharsetDecoder decoder) {
            this.input = input;
            this.decoder = decoder;
            this.bytes = ByteBuffer.allocate(4);
            this.chars = CharBuffer.allocate(2);
            this.bytes.limit(0);
            this.chars.limit(0);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x000d */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x000d */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v0, types: [long] */
        /* JADX WARN: Type inference failed for: r8v1, types: [long] */
        /* JADX WARN: Type inference failed for: r12v0 */
        /* JADX WARN: Type inference failed for: r12v1, types: [long] */
        /* JADX WARN: Type inference failed for: r0v21, types: [org.jline.utils.NonBlockingInputStream] */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r0v28, types: [long] */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r0v56, types: [long] */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // org.jline.utils.NonBlockingReader
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected int read(long r8, boolean r10) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 230
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlocking.NonBlockingInputStreamReader.read(long, boolean):int");
        }

        @Override // org.jline.utils.NonBlockingReader
        public int readBuffered(char[] b) throws IOException {
            if (b == null) {
                throw new NullPointerException();
            } else if (b.length == 0) {
                return 0;
            } else {
                if (this.chars.hasRemaining()) {
                    int r = Math.min(b.length, this.chars.remaining());
                    this.chars.get(b);
                    return r;
                }
                byte[] buf = new byte[b.length];
                int l = this.input.readBuffered(buf);
                if (l < 0) {
                    return l;
                }
                ByteBuffer bytes = ByteBuffer.wrap(buf, 0, l);
                CharBuffer chars = CharBuffer.wrap(b);
                this.decoder.decode(bytes, chars, false);
                chars.flip();
                return chars.remaining();
            }
        }

        @Override // org.jline.utils.NonBlockingReader
        public void shutdown() {
            this.input.shutdown();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.input.close();
        }
    }
}
