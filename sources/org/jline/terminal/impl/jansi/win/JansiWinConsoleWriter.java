package org.jline.terminal.impl.jansi.win;

import java.io.IOException;
import org.fusesource.jansi.WindowsSupport;
import org.fusesource.jansi.internal.Kernel32;
import org.jline.terminal.impl.AbstractWindowsConsoleWriter;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jansi/win/JansiWinConsoleWriter.class */
public class JansiWinConsoleWriter extends AbstractWindowsConsoleWriter {
    private static final long console = Kernel32.GetStdHandle(Kernel32.STD_OUTPUT_HANDLE);
    private final int[] writtenChars = new int[1];

    @Override // org.jline.terminal.impl.AbstractWindowsConsoleWriter
    protected void writeConsole(char[] text, int len) throws IOException {
        if (Kernel32.WriteConsoleW(console, text, len, this.writtenChars, 0) == 0) {
            throw new IOException("Failed to write to console: " + WindowsSupport.getLastErrorMessage());
        }
    }
}
