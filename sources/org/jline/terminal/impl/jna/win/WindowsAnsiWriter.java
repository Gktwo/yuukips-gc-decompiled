package org.jline.terminal.impl.jna.win;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.io.IOException;
import java.io.Writer;
import org.jline.terminal.impl.jna.win.Kernel32;
import org.jline.utils.AnsiWriter;
import org.jline.utils.Colors;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/WindowsAnsiWriter.class */
public final class WindowsAnsiWriter extends AnsiWriter {
    private static final short FOREGROUND_BLACK = 0;
    private static final short FOREGROUND_YELLOW = 6;
    private static final short FOREGROUND_MAGENTA = 5;
    private static final short FOREGROUND_CYAN = 3;
    private static final short FOREGROUND_WHITE = 7;
    private static final short BACKGROUND_BLACK = 0;
    private static final short BACKGROUND_YELLOW = 96;
    private static final short BACKGROUND_MAGENTA = 80;
    private static final short BACKGROUND_CYAN = 48;
    private static final short BACKGROUND_WHITE = 112;
    private static final short[] ANSI_FOREGROUND_COLOR_MAP = {0, 4, 2, 6, 1, 5, 3, 7};
    private static final short[] ANSI_BACKGROUND_COLOR_MAP = {0, 64, 32, 96, 16, 80, 48, 112};
    private static final int MAX_ESCAPE_SEQUENCE_LENGTH = 100;
    private final Pointer console;
    private boolean negative;
    private boolean bold;
    private boolean underline;
    private final Kernel32.CONSOLE_SCREEN_BUFFER_INFO info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
    private short savedX = -1;
    private short savedY = -1;
    private final short originalColors = this.info.wAttributes;

    public WindowsAnsiWriter(Writer out, Pointer console) throws IOException {
        super(out);
        this.console = console;
        getConsoleInfo();
    }

    private void getConsoleInfo() throws IOException {
        this.out.flush();
        Kernel32.INSTANCE.GetConsoleScreenBufferInfo(this.console, this.info);
        if (this.negative) {
            this.info.wAttributes = invertAttributeColors(this.info.wAttributes);
        }
    }

    private void applyAttribute() throws IOException {
        this.out.flush();
        short attributes = this.info.wAttributes;
        if (this.bold) {
            attributes = (short) (attributes | 8);
        }
        if (this.underline) {
            attributes = (short) (attributes | 128);
        }
        if (this.negative) {
            attributes = invertAttributeColors(attributes);
        }
        Kernel32.INSTANCE.SetConsoleTextAttribute(this.console, attributes);
    }

    private short invertAttributeColors(short attributes) {
        return (short) ((attributes & 65280) | ((15 & attributes) << 4) | ((240 & attributes) >> 4));
    }

    private void applyCursorPosition() throws IOException {
        this.info.dwCursorPosition.f3247X = (short) Math.max(0, Math.min(this.info.dwSize.f3247X - 1, (int) this.info.dwCursorPosition.f3247X));
        this.info.dwCursorPosition.f3248Y = (short) Math.max(0, Math.min(this.info.dwSize.f3248Y - 1, (int) this.info.dwCursorPosition.f3248Y));
        Kernel32.INSTANCE.SetConsoleCursorPosition(this.console, this.info.dwCursorPosition);
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processEraseScreen(int eraseOption) throws IOException {
        getConsoleInfo();
        IntByReference written = new IntByReference();
        switch (eraseOption) {
            case 0:
                int lengthToEnd = ((this.info.srWindow.Bottom - this.info.dwCursorPosition.f3248Y) * this.info.dwSize.f3247X) + (this.info.dwSize.f3247X - this.info.dwCursorPosition.f3247X);
                Kernel32.INSTANCE.FillConsoleOutputCharacter(this.console, ' ', lengthToEnd, this.info.dwCursorPosition, written);
                Kernel32.INSTANCE.FillConsoleOutputAttribute(this.console, this.info.wAttributes, lengthToEnd, this.info.dwCursorPosition, written);
                return;
            case 1:
                Kernel32.COORD topLeft2 = new Kernel32.COORD();
                topLeft2.f3247X = 0;
                topLeft2.f3248Y = this.info.srWindow.Top;
                int lengthToCursor = ((this.info.dwCursorPosition.f3248Y - this.info.srWindow.Top) * this.info.dwSize.f3247X) + this.info.dwCursorPosition.f3247X;
                Kernel32.INSTANCE.FillConsoleOutputCharacter(this.console, ' ', lengthToCursor, topLeft2, written);
                Kernel32.INSTANCE.FillConsoleOutputAttribute(this.console, this.info.wAttributes, lengthToCursor, topLeft2, written);
                return;
            case 2:
                Kernel32.COORD topLeft = new Kernel32.COORD();
                topLeft.f3247X = 0;
                topLeft.f3248Y = this.info.srWindow.Top;
                int screenLength = this.info.srWindow.height() * this.info.dwSize.f3247X;
                Kernel32.INSTANCE.FillConsoleOutputCharacter(this.console, ' ', screenLength, topLeft, written);
                Kernel32.INSTANCE.FillConsoleOutputAttribute(this.console, this.info.wAttributes, screenLength, topLeft, written);
                return;
            default:
                return;
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processEraseLine(int eraseOption) throws IOException {
        getConsoleInfo();
        IntByReference written = new IntByReference();
        switch (eraseOption) {
            case 0:
                int lengthToLastCol = this.info.dwSize.f3247X - this.info.dwCursorPosition.f3247X;
                Kernel32.INSTANCE.FillConsoleOutputCharacter(this.console, ' ', lengthToLastCol, this.info.dwCursorPosition, written);
                Kernel32.INSTANCE.FillConsoleOutputAttribute(this.console, this.info.wAttributes, lengthToLastCol, this.info.dwCursorPosition, written);
                return;
            case 1:
                Kernel32.COORD leftColCurrRow2 = new Kernel32.COORD(0, this.info.dwCursorPosition.f3248Y);
                Kernel32.INSTANCE.FillConsoleOutputCharacter(this.console, ' ', this.info.dwCursorPosition.f3247X, leftColCurrRow2, written);
                Kernel32.INSTANCE.FillConsoleOutputAttribute(this.console, this.info.wAttributes, this.info.dwCursorPosition.f3247X, leftColCurrRow2, written);
                return;
            case 2:
                Kernel32.COORD leftColCurrRow = new Kernel32.COORD(0, this.info.dwCursorPosition.f3248Y);
                Kernel32.INSTANCE.FillConsoleOutputCharacter(this.console, ' ', this.info.dwSize.f3247X, leftColCurrRow, written);
                Kernel32.INSTANCE.FillConsoleOutputAttribute(this.console, this.info.wAttributes, this.info.dwSize.f3247X, leftColCurrRow, written);
                return;
            default:
                return;
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorUpLine(int count) throws IOException {
        getConsoleInfo();
        this.info.dwCursorPosition.f3247X = 0;
        Kernel32.COORD coord = this.info.dwCursorPosition;
        coord.f3248Y = (short) (coord.f3248Y - count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorDownLine(int count) throws IOException {
        getConsoleInfo();
        this.info.dwCursorPosition.f3247X = 0;
        Kernel32.COORD coord = this.info.dwCursorPosition;
        coord.f3248Y = (short) (coord.f3248Y + count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorLeft(int count) throws IOException {
        getConsoleInfo();
        Kernel32.COORD coord = this.info.dwCursorPosition;
        coord.f3247X = (short) (coord.f3247X - count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorRight(int count) throws IOException {
        getConsoleInfo();
        Kernel32.COORD coord = this.info.dwCursorPosition;
        coord.f3247X = (short) (coord.f3247X + count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorDown(int count) throws IOException {
        getConsoleInfo();
        int nb = Math.max(0, ((this.info.dwCursorPosition.f3248Y + count) - this.info.dwSize.f3248Y) + 1);
        if (nb != count) {
            Kernel32.COORD coord = this.info.dwCursorPosition;
            coord.f3248Y = (short) (coord.f3248Y + count);
            applyCursorPosition();
        }
        if (nb > 0) {
            Kernel32.SMALL_RECT scroll = new Kernel32.SMALL_RECT(this.info.srWindow);
            scroll.Top = 0;
            Kernel32.COORD org2 = new Kernel32.COORD();
            org2.f3247X = 0;
            org2.f3248Y = (short) (-nb);
            Kernel32.INSTANCE.ScrollConsoleScreenBuffer(this.console, scroll, scroll, org2, new Kernel32.CHAR_INFO(' ', this.originalColors));
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorUp(int count) throws IOException {
        getConsoleInfo();
        Kernel32.COORD coord = this.info.dwCursorPosition;
        coord.f3248Y = (short) (coord.f3248Y - count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorTo(int row, int col) throws IOException {
        getConsoleInfo();
        this.info.dwCursorPosition.f3248Y = (short) ((this.info.srWindow.Top + row) - 1);
        this.info.dwCursorPosition.f3247X = (short) (col - 1);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorToColumn(int x) throws IOException {
        getConsoleInfo();
        this.info.dwCursorPosition.f3247X = (short) (x - 1);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processSetForegroundColorExt(int paletteIndex) throws IOException {
        int color = Colors.roundColor(paletteIndex, 16);
        this.info.wAttributes = (short) ((this.info.wAttributes & -8) | ANSI_FOREGROUND_COLOR_MAP[color & 7]);
        this.info.wAttributes = (short) ((this.info.wAttributes & -9) | (color >= 8 ? 8 : 0));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processSetBackgroundColorExt(int paletteIndex) throws IOException {
        int color = Colors.roundColor(paletteIndex, 16);
        this.info.wAttributes = (short) ((this.info.wAttributes & -113) | ANSI_BACKGROUND_COLOR_MAP[color & 7]);
        this.info.wAttributes = (short) ((this.info.wAttributes & -129) | (color >= 8 ? 128 : 0));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processDefaultTextColor() throws IOException {
        this.info.wAttributes = (short) ((this.info.wAttributes & -16) | (this.originalColors & 15));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processDefaultBackgroundColor() throws IOException {
        this.info.wAttributes = (short) ((this.info.wAttributes & -241) | (this.originalColors & 240));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processAttributeRest() throws IOException {
        this.info.wAttributes = (short) ((this.info.wAttributes & -256) | this.originalColors);
        this.negative = false;
        this.bold = false;
        this.underline = false;
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processSetAttribute(int attribute) throws IOException {
        switch (attribute) {
            case 1:
                this.bold = true;
                applyAttribute();
                return;
            case 4:
                this.underline = true;
                applyAttribute();
                return;
            case 7:
                this.negative = true;
                applyAttribute();
                return;
            case 22:
                this.bold = false;
                applyAttribute();
                return;
            case 24:
                this.underline = false;
                applyAttribute();
                return;
            case 27:
                this.negative = false;
                applyAttribute();
                return;
            default:
                return;
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processSaveCursorPosition() throws IOException {
        getConsoleInfo();
        this.savedX = this.info.dwCursorPosition.f3247X;
        this.savedY = this.info.dwCursorPosition.f3248Y;
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processRestoreCursorPosition() throws IOException {
        if (this.savedX != -1 && this.savedY != -1) {
            this.out.flush();
            this.info.dwCursorPosition.f3247X = this.savedX;
            this.info.dwCursorPosition.f3248Y = this.savedY;
            applyCursorPosition();
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processInsertLine(int optionInt) throws IOException {
        getConsoleInfo();
        Kernel32.SMALL_RECT scroll = new Kernel32.SMALL_RECT(this.info.srWindow);
        scroll.Top = this.info.dwCursorPosition.f3248Y;
        Kernel32.COORD org2 = new Kernel32.COORD();
        org2.f3247X = 0;
        org2.f3248Y = (short) (this.info.dwCursorPosition.f3248Y + optionInt);
        Kernel32.INSTANCE.ScrollConsoleScreenBuffer(this.console, scroll, scroll, org2, new Kernel32.CHAR_INFO(' ', this.originalColors));
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processDeleteLine(int optionInt) throws IOException {
        getConsoleInfo();
        Kernel32.SMALL_RECT scroll = new Kernel32.SMALL_RECT(this.info.srWindow);
        scroll.Top = this.info.dwCursorPosition.f3248Y;
        Kernel32.COORD org2 = new Kernel32.COORD();
        org2.f3247X = 0;
        org2.f3248Y = (short) (this.info.dwCursorPosition.f3248Y - optionInt);
        Kernel32.INSTANCE.ScrollConsoleScreenBuffer(this.console, scroll, scroll, org2, new Kernel32.CHAR_INFO(' ', this.originalColors));
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processChangeWindowTitle(String label) {
        Kernel32.INSTANCE.SetConsoleTitle(label);
    }
}
