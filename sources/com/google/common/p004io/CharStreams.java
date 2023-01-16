package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

@GwtIncompatible
/* renamed from: com.google.common.io.CharStreams */
/* loaded from: grasscutter.jar:com/google/common/io/CharStreams.class */
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    /* access modifiers changed from: package-private */
    public static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    private CharStreams() {
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    @CanIgnoreReturnValue
    public static long copy(Readable from, Appendable to) throws IOException {
        if (!(from instanceof Reader)) {
            Preconditions.checkNotNull(from);
            Preconditions.checkNotNull(to);
            char c = 0;
            CharBuffer buf = createBuffer();
            while (from.read(buf) != -1) {
                buf.flip();
                to.append(buf);
                c += (long) buf.remaining();
                buf.clear();
            }
            return c;
        } else if (to instanceof StringBuilder) {
            return copyReaderToBuilder((Reader) from, (StringBuilder) to);
        } else {
            return copyReaderToWriter((Reader) from, asWriter(to));
        }
    }

    @CanIgnoreReturnValue
    static long copyReaderToBuilder(Reader from, StringBuilder to) throws IOException {
        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);
        char[] buf = new char[2048];
        long total = 0;
        while (true) {
            int nRead = from.read(buf);
            if (nRead == -1) {
                return total;
            }
            to.append(buf, 0, nRead);
            total += (long) nRead;
        }
    }

    @CanIgnoreReturnValue
    static long copyReaderToWriter(Reader from, Writer to) throws IOException {
        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);
        char[] buf = new char[2048];
        long total = 0;
        while (true) {
            int nRead = from.read(buf);
            if (nRead == -1) {
                return total;
            }
            to.write(buf, 0, nRead);
            total += (long) nRead;
        }
    }

    public static String toString(Readable r) throws IOException {
        return toStringBuilder(r).toString();
    }

    private static StringBuilder toStringBuilder(Readable r) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (r instanceof Reader) {
            copyReaderToBuilder((Reader) r, sb);
        } else {
            copy(r, sb);
        }
        return sb;
    }

    @Beta
    public static List<String> readLines(Readable r) throws IOException {
        List<String> result = new ArrayList<>();
        LineReader lineReader = new LineReader(r);
        while (true) {
            String line = lineReader.readLine();
            if (line == null) {
                return result;
            }
            result.add(line);
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public static <T> T readLines(Readable readable, LineProcessor<T> processor) throws IOException {
        String line;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(processor);
        LineReader lineReader = new LineReader(readable);
        do {
            line = lineReader.readLine();
            if (line == null) {
                break;
            }
        } while (processor.processLine(line));
        return processor.getResult();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable readable) throws IOException {
        char c = 0;
        CharBuffer buf = createBuffer();
        while (true) {
            long read = (long) readable.read(buf);
            if (read == -1) {
                return c;
            }
            c += read;
            buf.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.Beta
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void skipFully(java.io.Reader r5, long r6) throws java.io.IOException {
        /*
            r0 = r5
            java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
        L_0x0005:
            r0 = r6
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0026
            r0 = r5
            r1 = r6
            long r0 = r0.skip(r1)
            r8 = r0
            r0 = r8
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x001f
            java.io.EOFException r0 = new java.io.EOFException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x001f:
            r0 = r6
            r1 = r8
            long r0 = r0 - r1
            r6 = r0
            goto L_0x0005
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.p004io.CharStreams.skipFully(java.io.Reader, long):void");
    }

    @Beta
    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    /* renamed from: com.google.common.io.CharStreams$NullWriter */
    /* loaded from: grasscutter.jar:com/google/common/io/CharStreams$NullWriter.class */
    private static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = new NullWriter();

        private NullWriter() {
        }

        @Override // java.io.Writer
        public void write(int c) {
        }

        @Override // java.io.Writer
        public void write(char[] cbuf) {
            Preconditions.checkNotNull(cbuf);
        }

        @Override // java.io.Writer
        public void write(char[] cbuf, int off, int len) {
            Preconditions.checkPositionIndexes(off, off + len, cbuf.length);
        }

        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        @Override // java.io.Writer
        public void write(String str, int off, int len) {
            Preconditions.checkPositionIndexes(off, off + len, str.length());
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence csq) {
            Preconditions.checkNotNull(csq);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence csq, int start, int end) {
            Preconditions.checkPositionIndexes(start, end, csq.length());
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c) {
            return this;
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.lang.Object
        public String toString() {
            return "CharStreams.nullWriter()";
        }
    }

    @Beta
    public static Writer asWriter(Appendable target) {
        if (target instanceof Writer) {
            return (Writer) target;
        }
        return new AppendableWriter(target);
    }
}
