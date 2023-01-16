package org.jline.terminal.impl.jna.win;

import com.sun.jna.LastErrorException;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.function.IntConsumer;
import org.jline.terminal.Cursor;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.impl.AbstractWindowsTerminal;
import org.jline.terminal.impl.jna.win.Kernel32;
import org.jline.utils.InfoCmp;
import org.jline.utils.OSUtils;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/JnaWinSysTerminal.class */
public class JnaWinSysTerminal extends AbstractWindowsTerminal {
    private static final Pointer consoleIn = Kernel32.INSTANCE.GetStdHandle(-10);
    private static final Pointer consoleOut = Kernel32.INSTANCE.GetStdHandle(-11);
    private char[] focus = {27, '[', ' '};
    private char[] mouse = {27, '[', 'M', ' ', ' ', ' '};
    private final Kernel32.INPUT_RECORD[] inputEvents = new Kernel32.INPUT_RECORD[1];
    private final IntByReference eventsRead = new IntByReference();

    public static JnaWinSysTerminal createTerminal(String name, String type, boolean ansiPassThrough, Charset encoding, int codepage, boolean nativeSignals, Terminal.SignalHandler signalHandler, boolean paused) throws IOException {
        Writer writer;
        if (ansiPassThrough) {
            if (type == null) {
                type = OSUtils.IS_CONEMU ? "windows-conemu" : "windows";
            }
            writer = new JnaWinConsoleWriter(consoleOut);
        } else {
            IntByReference mode = new IntByReference();
            Kernel32.INSTANCE.GetConsoleMode(consoleOut, mode);
            try {
                Kernel32.INSTANCE.SetConsoleMode(consoleOut, mode.getValue() | 4);
                if (type == null) {
                    type = "windows-vtp";
                }
                writer = new JnaWinConsoleWriter(consoleOut);
            } catch (LastErrorException e) {
                if (OSUtils.IS_CONEMU) {
                    if (type == null) {
                        type = "windows-conemu";
                    }
                    writer = new JnaWinConsoleWriter(consoleOut);
                } else {
                    if (type == null) {
                        type = "windows";
                    }
                    writer = new WindowsAnsiWriter(new BufferedWriter(new JnaWinConsoleWriter(consoleOut)), consoleOut);
                }
            }
        }
        JnaWinSysTerminal terminal = new JnaWinSysTerminal(writer, name, type, encoding, codepage, nativeSignals, signalHandler);
        if (!paused) {
            terminal.resume();
        }
        return terminal;
    }

    public static boolean isWindowsConsole() {
        try {
            IntByReference mode = new IntByReference();
            Kernel32.INSTANCE.GetConsoleMode(consoleOut, mode);
            Kernel32.INSTANCE.GetConsoleMode(consoleIn, mode);
            return true;
        } catch (LastErrorException e) {
            return false;
        }
    }

    public static boolean isConsoleOutput() {
        try {
            Kernel32.INSTANCE.GetConsoleMode(consoleOut, new IntByReference());
            return true;
        } catch (LastErrorException e) {
            return false;
        }
    }

    public static boolean isConsoleInput() {
        try {
            Kernel32.INSTANCE.GetConsoleMode(consoleIn, new IntByReference());
            return true;
        } catch (LastErrorException e) {
            return false;
        }
    }

    JnaWinSysTerminal(Writer writer, String name, String type, Charset encoding, int codepage, boolean nativeSignals, Terminal.SignalHandler signalHandler) throws IOException {
        super(writer, name, type, encoding, codepage, nativeSignals, signalHandler);
        this.strings.put(InfoCmp.Capability.key_mouse, "\\E[M");
    }

    @Override // org.jline.terminal.impl.AbstractWindowsTerminal
    protected int getConsoleMode() {
        IntByReference mode = new IntByReference();
        Kernel32.INSTANCE.GetConsoleMode(consoleIn, mode);
        return mode.getValue();
    }

    @Override // org.jline.terminal.impl.AbstractWindowsTerminal
    protected void setConsoleMode(int mode) {
        Kernel32.INSTANCE.SetConsoleMode(consoleIn, mode);
    }

    @Override // org.jline.terminal.Terminal
    public Size getSize() {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
        Kernel32.INSTANCE.GetConsoleScreenBufferInfo(consoleOut, info);
        return new Size(info.windowWidth(), info.windowHeight());
    }

    @Override // org.jline.terminal.Terminal
    public Size getBufferSize() {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
        Kernel32.INSTANCE.GetConsoleScreenBufferInfo(consoleOut, info);
        return new Size(info.dwSize.f3247X, info.dwSize.f3248Y);
    }

    @Override // org.jline.terminal.impl.AbstractWindowsTerminal
    protected boolean processConsoleInput() throws IOException {
        Kernel32.INPUT_RECORD event = readConsoleInput(100);
        if (event == null) {
            return false;
        }
        switch (event.EventType) {
            case 1:
                processKeyEvent(event.Event.KeyEvent);
                return true;
            case 2:
                processMouseEvent(event.Event.MouseEvent);
                return true;
            case 4:
                raise(Terminal.Signal.WINCH);
                return false;
            case 16:
                processFocusEvent(event.Event.FocusEvent.bSetFocus);
                return true;
            default:
                return false;
        }
    }

    private void processKeyEvent(Kernel32.KEY_EVENT_RECORD keyEvent) throws IOException {
        processKeyEvent(keyEvent.bKeyDown, keyEvent.wVirtualKeyCode, keyEvent.uChar.UnicodeChar, keyEvent.dwControlKeyState);
    }

    private void processFocusEvent(boolean hasFocus) throws IOException {
        if (this.focusTracking) {
            this.focus[2] = hasFocus ? 'I' : 'O';
            this.slaveInputPipe.write(this.focus);
        }
    }

    private void processMouseEvent(Kernel32.MOUSE_EVENT_RECORD mouseEvent) throws IOException {
        int cb;
        int dwEventFlags = mouseEvent.dwEventFlags;
        int dwButtonState = mouseEvent.dwButtonState;
        if (this.tracking == Terminal.MouseTracking.Off) {
            return;
        }
        if (this.tracking != Terminal.MouseTracking.Normal || dwEventFlags != 1) {
            if (this.tracking != Terminal.MouseTracking.Button || dwEventFlags != 1 || dwButtonState != 0) {
                int dwEventFlags2 = dwEventFlags & -3;
                if (dwEventFlags2 == 4) {
                    cb = 0 | 64;
                    if ((dwButtonState >> 16) < 0) {
                        cb |= 1;
                    }
                } else if (dwEventFlags2 != 8) {
                    if ((dwButtonState & 1) != 0) {
                        cb = 0 | 0;
                    } else if ((dwButtonState & 2) != 0) {
                        cb = 0 | 1;
                    } else if ((dwButtonState & 4) != 0) {
                        cb = 0 | 2;
                    } else {
                        cb = 0 | 3;
                    }
                } else {
                    return;
                }
                int cx = mouseEvent.dwMousePosition.f3247X;
                int cy = mouseEvent.dwMousePosition.f3248Y;
                this.mouse[3] = (char) (32 + cb);
                this.mouse[4] = (char) (32 + cx + 1);
                this.mouse[5] = (char) (32 + cy + 1);
                this.slaveInputPipe.write(this.mouse);
            }
        }
    }

    private Kernel32.INPUT_RECORD readConsoleInput(int dwMilliseconds) throws IOException {
        if (Kernel32.INSTANCE.WaitForSingleObject(consoleIn, dwMilliseconds) != 0) {
            return null;
        }
        Kernel32.INSTANCE.ReadConsoleInput(consoleIn, this.inputEvents, 1, this.eventsRead);
        if (this.eventsRead.getValue() == 1) {
            return this.inputEvents[0];
        }
        return null;
    }

    @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
    public Cursor getCursorPosition(IntConsumer discarded) {
        Kernel32.CONSOLE_SCREEN_BUFFER_INFO info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
        Kernel32.INSTANCE.GetConsoleScreenBufferInfo(consoleOut, info);
        return new Cursor(info.dwCursorPosition.f3247X, info.dwCursorPosition.f3248Y);
    }
}
