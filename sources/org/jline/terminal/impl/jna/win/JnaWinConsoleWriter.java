package org.jline.terminal.impl.jna.win;

import com.sun.jna.LastErrorException;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.io.IOException;
import org.jline.terminal.impl.AbstractWindowsConsoleWriter;

/* WARNING: Classes with same name are omitted:
  
 */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/JnaWinConsoleWriter.class */
public class JnaWinConsoleWriter extends AbstractWindowsConsoleWriter {
    private final Pointer consoleHandle;
    private final IntByReference writtenChars = new IntByReference();

    /* access modifiers changed from: package-private */
    public JnaWinConsoleWriter(Pointer consoleHandle) {
        this.consoleHandle = consoleHandle;
    }

    @Override // org.jline.terminal.impl.AbstractWindowsConsoleWriter
    protected void writeConsole(char[] text, int len) throws IOException {
        try {
            Kernel32.INSTANCE.WriteConsoleW(this.consoleHandle, text, len, this.writtenChars, null);
        } catch (LastErrorException e) {
            throw new IOException("Failed to write to console", e);
        }
    }
}
