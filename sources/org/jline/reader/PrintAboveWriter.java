package org.jline.reader;

import java.io.StringWriter;

/* loaded from: grasscutter.jar:org/jline/reader/PrintAboveWriter.class */
public class PrintAboveWriter extends StringWriter {
    private final LineReader reader;

    public PrintAboveWriter(LineReader reader) {
        this.reader = reader;
    }

    @Override // java.io.StringWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        StringBuffer buffer = getBuffer();
        int lastNewline = buffer.lastIndexOf("\n");
        if (lastNewline >= 0) {
            this.reader.printAbove(buffer.substring(0, lastNewline + 1));
            buffer.delete(0, lastNewline + 1);
        }
    }
}
