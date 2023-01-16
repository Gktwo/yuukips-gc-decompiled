package org.jline.terminal.impl;

import java.io.IOException;
import java.io.Writer;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/AbstractWindowsConsoleWriter.class */
public abstract class AbstractWindowsConsoleWriter extends Writer {
    protected abstract void writeConsole(char[] cArr, int i) throws IOException;

    @Override // java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        char[] text = cbuf;
        if (off != 0) {
            text = new char[len];
            System.arraycopy(cbuf, off, text, 0, len);
        }
        synchronized (this.lock) {
            writeConsole(text, len);
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
