package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

@Beta
@GwtIncompatible
/* renamed from: com.google.common.io.LineReader */
/* loaded from: grasscutter.jar:com/google/common/io/LineReader.class */
public final class LineReader {
    private final Readable readable;
    private final Reader reader;
    private final CharBuffer cbuf = CharStreams.createBuffer();
    private final char[] buf = this.cbuf.array();
    private final Queue<String> lines = new LinkedList();
    private final LineBuffer lineBuf = new LineBuffer() { // from class: com.google.common.io.LineReader.1
        @Override // com.google.common.p004io.LineBuffer
        protected void handleLine(String line, String end) {
            LineReader.this.lines.add(line);
        }
    };

    public LineReader(Readable readable) {
        this.readable = (Readable) Preconditions.checkNotNull(readable);
        this.reader = readable instanceof Reader ? (Reader) readable : null;
    }

    @CanIgnoreReturnValue
    public String readLine() throws IOException {
        while (true) {
            if (this.lines.peek() != null) {
                break;
            }
            this.cbuf.clear();
            int read = this.reader != null ? this.reader.read(this.buf, 0, this.buf.length) : this.readable.read(this.cbuf);
            if (read == -1) {
                this.lineBuf.finish();
                break;
            }
            this.lineBuf.add(this.buf, 0, read);
        }
        return this.lines.poll();
    }
}
