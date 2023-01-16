package org.jline.terminal.spi;

import java.io.IOException;
import java.nio.charset.Charset;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/spi/JnaSupport.class */
public interface JnaSupport {
    Pty current() throws IOException;

    Pty open(Attributes attributes, Size size) throws IOException;

    Terminal winSysTerminal(String str, String str2, boolean z, Charset charset, int i, boolean z2, Terminal.SignalHandler signalHandler) throws IOException;

    Terminal winSysTerminal(String str, String str2, boolean z, Charset charset, int i, boolean z2, Terminal.SignalHandler signalHandler, boolean z3) throws IOException;

    boolean isWindowsConsole();

    boolean isConsoleOutput();

    boolean isConsoleInput();
}
