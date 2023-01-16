package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.stream.Stream;

@GwtIncompatible
/* renamed from: com.google.common.io.CharSink */
/* loaded from: grasscutter.jar:com/google/common/io/CharSink.class */
public abstract class CharSink {
    public abstract Writer openStream() throws IOException;

    public Writer openBufferedStream() throws IOException {
        Writer writer = openStream();
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer);
    }

    public void write(CharSequence charSequence) throws IOException {
        Preconditions.checkNotNull(charSequence);
        Closer closer = Closer.create();
        try {
            Writer out = (Writer) closer.register(openStream());
            out.append(charSequence);
            out.flush();
            closer.close();
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }

    public void writeLines(Iterable<? extends CharSequence> lines) throws IOException {
        writeLines(lines, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> lines, String lineSeparator) throws IOException {
        writeLines(lines.iterator(), lineSeparator);
    }

    @Beta
    public void writeLines(Stream<? extends CharSequence> lines) throws IOException {
        writeLines(lines, System.getProperty("line.separator"));
    }

    @Beta
    public void writeLines(Stream<? extends CharSequence> lines, String lineSeparator) throws IOException {
        writeLines(lines.iterator(), lineSeparator);
    }

    private void writeLines(Iterator<? extends CharSequence> lines, String lineSeparator) throws IOException {
        Preconditions.checkNotNull(lineSeparator);
        Writer out = openBufferedStream();
        Throwable th = null;
        while (lines.hasNext()) {
            try {
                out.append((CharSequence) lines.next()).append((CharSequence) lineSeparator);
            } catch (Throwable th2) {
                if (out != null) {
                    if (0 != 0) {
                        try {
                            out.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        out.close();
                    }
                }
                throw th2;
            }
        }
        if (out == null) {
            return;
        }
        if (0 != 0) {
            try {
                out.close();
            } catch (Throwable th4) {
                th.addSuppressed(th4);
            }
        } else {
            out.close();
        }
    }

    @CanIgnoreReturnValue
    public long writeFrom(Readable readable) throws IOException {
        Preconditions.checkNotNull(readable);
        Closer closer = Closer.create();
        try {
            Writer out = (Writer) closer.register(openStream());
            long written = CharStreams.copy(readable, out);
            out.flush();
            closer.close();
            return written;
        } catch (Throwable th) {
            closer.close();
            throw th;
        }
    }
}
