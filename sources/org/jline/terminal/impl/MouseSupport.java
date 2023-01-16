package org.jline.terminal.impl;

import java.io.EOFException;
import java.io.IOError;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.EnumSet;
import java.util.function.IntSupplier;
import org.jline.terminal.MouseEvent;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;
import org.jline.utils.InputStreamReader;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/MouseSupport.class */
public class MouseSupport {
    public static boolean hasMouseSupport(Terminal terminal) {
        return terminal.getStringCapability(InfoCmp.Capability.key_mouse) != null;
    }

    public static boolean trackMouse(Terminal terminal, Terminal.MouseTracking tracking) {
        if (!hasMouseSupport(terminal)) {
            return false;
        }
        switch (tracking) {
            case Off:
                terminal.writer().write("\u001b[?1000l");
                break;
            case Normal:
                terminal.writer().write("\u001b[?1005h\u001b[?1000h");
                break;
            case Button:
                terminal.writer().write("\u001b[?1005h\u001b[?1002h");
                break;
            case Any:
                terminal.writer().write("\u001b[?1005h\u001b[?1003h");
                break;
        }
        terminal.flush();
        return true;
    }

    public static MouseEvent readMouse(Terminal terminal, MouseEvent last) {
        return readMouse(() -> {
            return readExt(terminal);
        }, last);
    }

    public static MouseEvent readMouse(IntSupplier reader, MouseEvent last) {
        MouseEvent.Button button;
        MouseEvent.Type type;
        int cb = reader.getAsInt() - 32;
        int cx = (reader.getAsInt() - 32) - 1;
        int cy = (reader.getAsInt() - 32) - 1;
        EnumSet<MouseEvent.Modifier> modifiers = EnumSet.noneOf(MouseEvent.Modifier.class);
        if ((cb & 4) == 4) {
            modifiers.add(MouseEvent.Modifier.Shift);
        }
        if ((cb & 8) == 8) {
            modifiers.add(MouseEvent.Modifier.Alt);
        }
        if ((cb & 16) == 16) {
            modifiers.add(MouseEvent.Modifier.Control);
        }
        if ((cb & 64) != 64) {
            switch (cb & 3) {
                case 0:
                    button = MouseEvent.Button.Button1;
                    if (last.getButton() != button || (last.getType() != MouseEvent.Type.Pressed && last.getType() != MouseEvent.Type.Dragged)) {
                        type = MouseEvent.Type.Pressed;
                        break;
                    } else {
                        type = MouseEvent.Type.Dragged;
                        break;
                    }
                case 1:
                    button = MouseEvent.Button.Button2;
                    if (last.getButton() != button || (last.getType() != MouseEvent.Type.Pressed && last.getType() != MouseEvent.Type.Dragged)) {
                        type = MouseEvent.Type.Pressed;
                        break;
                    } else {
                        type = MouseEvent.Type.Dragged;
                        break;
                    }
                    break;
                case 2:
                    button = MouseEvent.Button.Button3;
                    if (last.getButton() != button || (last.getType() != MouseEvent.Type.Pressed && last.getType() != MouseEvent.Type.Dragged)) {
                        type = MouseEvent.Type.Pressed;
                        break;
                    } else {
                        type = MouseEvent.Type.Dragged;
                        break;
                    }
                    break;
                default:
                    if (last.getType() != MouseEvent.Type.Pressed && last.getType() != MouseEvent.Type.Dragged) {
                        button = MouseEvent.Button.NoButton;
                        type = MouseEvent.Type.Moved;
                        break;
                    } else {
                        button = last.getButton();
                        type = MouseEvent.Type.Released;
                        break;
                    }
                    break;
            }
        } else {
            type = MouseEvent.Type.Wheel;
            button = (cb & 1) == 1 ? MouseEvent.Button.WheelDown : MouseEvent.Button.WheelUp;
        }
        return new MouseEvent(type, button, modifiers, cx, cy);
    }

    private static int readExt(Terminal terminal) {
        int c;
        try {
            if (terminal.encoding() != StandardCharsets.UTF_8) {
                c = new InputStreamReader(terminal.input(), StandardCharsets.UTF_8).read();
            } else {
                c = terminal.reader().read();
            }
            if (c >= 0) {
                return c;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new IOError(e);
        }
    }
}
