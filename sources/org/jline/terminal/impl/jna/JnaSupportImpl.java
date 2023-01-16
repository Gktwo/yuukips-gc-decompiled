package org.jline.terminal.impl.jna;

import java.io.IOException;
import java.nio.charset.Charset;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.impl.jna.win.JnaWinSysTerminal;
import org.jline.terminal.spi.JnaSupport;
import org.jline.terminal.spi.Pty;
import org.jline.utils.OSUtils;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/JnaSupportImpl.class */
public class JnaSupportImpl implements JnaSupport {
    @Override // org.jline.terminal.spi.JnaSupport
    public Pty current() throws IOException {
        return JnaNativePty.current();
    }

    @Override // org.jline.terminal.spi.JnaSupport
    public Pty open(Attributes attributes, Size size) throws IOException {
        return JnaNativePty.open(attributes, size);
    }

    @Override // org.jline.terminal.spi.JnaSupport
    public Terminal winSysTerminal(String name, String type, boolean ansiPassThrough, Charset encoding, int codepage, boolean nativeSignals, Terminal.SignalHandler signalHandler) throws IOException {
        return winSysTerminal(name, type, ansiPassThrough, encoding, codepage, nativeSignals, signalHandler, false);
    }

    @Override // org.jline.terminal.spi.JnaSupport
    public Terminal winSysTerminal(String name, String type, boolean ansiPassThrough, Charset encoding, int codepage, boolean nativeSignals, Terminal.SignalHandler signalHandler, boolean paused) throws IOException {
        return JnaWinSysTerminal.createTerminal(name, type, ansiPassThrough, encoding, codepage, nativeSignals, signalHandler, paused);
    }

    @Override // org.jline.terminal.spi.JnaSupport
    public boolean isWindowsConsole() {
        return JnaWinSysTerminal.isWindowsConsole();
    }

    @Override // org.jline.terminal.spi.JnaSupport
    public boolean isConsoleOutput() {
        if (OSUtils.IS_CYGWIN || OSUtils.IS_MSYSTEM) {
            throw new UnsupportedOperationException();
        } else if (OSUtils.IS_WINDOWS) {
            return JnaWinSysTerminal.isConsoleOutput();
        } else {
            return JnaNativePty.isConsoleOutput();
        }
    }

    @Override // org.jline.terminal.spi.JnaSupport
    public boolean isConsoleInput() {
        if (OSUtils.IS_CYGWIN || OSUtils.IS_MSYSTEM) {
            throw new UnsupportedOperationException();
        } else if (OSUtils.IS_WINDOWS) {
            return JnaWinSysTerminal.isConsoleInput();
        } else {
            return JnaNativePty.isConsoleInput();
        }
    }
}
