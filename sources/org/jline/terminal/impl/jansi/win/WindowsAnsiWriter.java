package org.jline.terminal.impl.jansi.win;

import java.io.IOException;
import java.io.Writer;
import org.fusesource.jansi.WindowsSupport;
import org.fusesource.jansi.internal.Kernel32;
import org.jline.utils.AnsiWriter;
import org.jline.utils.Colors;

/* loaded from: grasscutter.jar:org/jline/terminal/impl/jansi/win/WindowsAnsiWriter.class */
public final class WindowsAnsiWriter extends AnsiWriter {
    private static final short FOREGROUND_BLACK = 0;
    private static final short BACKGROUND_BLACK = 0;
    private boolean negative;
    private boolean bold;
    private boolean underline;
    private static final long console = Kernel32.GetStdHandle(Kernel32.STD_OUTPUT_HANDLE);
    private static final short FOREGROUND_YELLOW = (short) (Kernel32.FOREGROUND_RED | Kernel32.FOREGROUND_GREEN);
    private static final short FOREGROUND_MAGENTA = (short) (Kernel32.FOREGROUND_BLUE | Kernel32.FOREGROUND_RED);
    private static final short FOREGROUND_CYAN = (short) (Kernel32.FOREGROUND_BLUE | Kernel32.FOREGROUND_GREEN);
    private static final short FOREGROUND_WHITE = (short) ((Kernel32.FOREGROUND_RED | Kernel32.FOREGROUND_GREEN) | Kernel32.FOREGROUND_BLUE);
    private static final short BACKGROUND_YELLOW = (short) (Kernel32.BACKGROUND_RED | Kernel32.BACKGROUND_GREEN);
    private static final short BACKGROUND_MAGENTA = (short) (Kernel32.BACKGROUND_BLUE | Kernel32.BACKGROUND_RED);
    private static final short BACKGROUND_CYAN = (short) (Kernel32.BACKGROUND_BLUE | Kernel32.BACKGROUND_GREEN);
    private static final short BACKGROUND_WHITE = (short) ((Kernel32.BACKGROUND_RED | Kernel32.BACKGROUND_GREEN) | Kernel32.BACKGROUND_BLUE);
    private static final short[] ANSI_FOREGROUND_COLOR_MAP = {0, Kernel32.FOREGROUND_RED, Kernel32.FOREGROUND_GREEN, FOREGROUND_YELLOW, Kernel32.FOREGROUND_BLUE, FOREGROUND_MAGENTA, FOREGROUND_CYAN, FOREGROUND_WHITE};
    private static final short[] ANSI_BACKGROUND_COLOR_MAP = {0, Kernel32.BACKGROUND_RED, Kernel32.BACKGROUND_GREEN, BACKGROUND_YELLOW, Kernel32.BACKGROUND_BLUE, BACKGROUND_MAGENTA, BACKGROUND_CYAN, BACKGROUND_WHITE};
    private final Kernel32.CONSOLE_SCREEN_BUFFER_INFO info = new Kernel32.CONSOLE_SCREEN_BUFFER_INFO();
    private short savedX = -1;
    private short savedY = -1;
    private final short originalColors = this.info.attributes;

    public WindowsAnsiWriter(Writer out) throws IOException {
        super(out);
        getConsoleInfo();
    }

    private void getConsoleInfo() throws IOException {
        this.out.flush();
        if (Kernel32.GetConsoleScreenBufferInfo(console, this.info) == 0) {
            throw new IOException("Could not get the screen info: " + WindowsSupport.getLastErrorMessage());
        } else if (this.negative) {
            this.info.attributes = invertAttributeColors(this.info.attributes);
        }
    }

    private void applyAttribute() throws IOException {
        this.out.flush();
        short attributes = this.info.attributes;
        if (this.bold) {
            attributes = (short) (attributes | Kernel32.FOREGROUND_INTENSITY);
        }
        if (this.underline) {
            attributes = (short) (attributes | Kernel32.BACKGROUND_INTENSITY);
        }
        if (this.negative) {
            attributes = invertAttributeColors(attributes);
        }
        if (Kernel32.SetConsoleTextAttribute(console, attributes) == 0) {
            throw new IOException(WindowsSupport.getLastErrorMessage());
        }
    }

    private short invertAttributeColors(short attributes) {
        return (short) ((attributes & 65280) | ((15 & attributes) << 4) | ((240 & attributes) >> 4));
    }

    private void applyCursorPosition() throws IOException {
        this.info.cursorPosition.x = (short) Math.max(0, Math.min(this.info.size.x - 1, (int) this.info.cursorPosition.x));
        this.info.cursorPosition.y = (short) Math.max(0, Math.min(this.info.size.y - 1, (int) this.info.cursorPosition.y));
        if (Kernel32.SetConsoleCursorPosition(console, this.info.cursorPosition.copy()) == 0) {
            throw new IOException(WindowsSupport.getLastErrorMessage());
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processEraseScreen(int eraseOption) throws IOException {
        getConsoleInfo();
        int[] written = new int[1];
        switch (eraseOption) {
            case 0:
                int lengthToEnd = ((this.info.window.bottom - this.info.cursorPosition.y) * this.info.size.x) + (this.info.size.x - this.info.cursorPosition.x);
                Kernel32.FillConsoleOutputAttribute(console, this.originalColors, lengthToEnd, this.info.cursorPosition.copy(), written);
                Kernel32.FillConsoleOutputCharacterW(console, ' ', lengthToEnd, this.info.cursorPosition.copy(), written);
                return;
            case 1:
                Kernel32.COORD topLeft2 = new Kernel32.COORD();
                topLeft2.x = 0;
                topLeft2.y = this.info.window.top;
                int lengthToCursor = ((this.info.cursorPosition.y - this.info.window.top) * this.info.size.x) + this.info.cursorPosition.x;
                Kernel32.FillConsoleOutputAttribute(console, this.originalColors, lengthToCursor, topLeft2, written);
                Kernel32.FillConsoleOutputCharacterW(console, ' ', lengthToCursor, topLeft2, written);
                return;
            case 2:
                Kernel32.COORD topLeft = new Kernel32.COORD();
                topLeft.x = 0;
                topLeft.y = this.info.window.top;
                int screenLength = this.info.window.height() * this.info.size.x;
                Kernel32.FillConsoleOutputAttribute(console, this.originalColors, screenLength, topLeft, written);
                Kernel32.FillConsoleOutputCharacterW(console, ' ', screenLength, topLeft, written);
                return;
            default:
                return;
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processEraseLine(int eraseOption) throws IOException {
        getConsoleInfo();
        int[] written = new int[1];
        switch (eraseOption) {
            case 0:
                int lengthToLastCol = this.info.size.x - this.info.cursorPosition.x;
                Kernel32.FillConsoleOutputAttribute(console, this.originalColors, lengthToLastCol, this.info.cursorPosition.copy(), written);
                Kernel32.FillConsoleOutputCharacterW(console, ' ', lengthToLastCol, this.info.cursorPosition.copy(), written);
                return;
            case 1:
                Kernel32.COORD leftColCurrRow2 = this.info.cursorPosition.copy();
                leftColCurrRow2.x = 0;
                Kernel32.FillConsoleOutputAttribute(console, this.originalColors, this.info.cursorPosition.x, leftColCurrRow2, written);
                Kernel32.FillConsoleOutputCharacterW(console, ' ', this.info.cursorPosition.x, leftColCurrRow2, written);
                return;
            case 2:
                Kernel32.COORD leftColCurrRow = this.info.cursorPosition.copy();
                leftColCurrRow.x = 0;
                Kernel32.FillConsoleOutputAttribute(console, this.originalColors, this.info.size.x, leftColCurrRow, written);
                Kernel32.FillConsoleOutputCharacterW(console, ' ', this.info.size.x, leftColCurrRow, written);
                return;
            default:
                return;
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorUpLine(int count) throws IOException {
        getConsoleInfo();
        this.info.cursorPosition.x = 0;
        Kernel32.COORD coord = this.info.cursorPosition;
        coord.y = (short) (coord.y - count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorDownLine(int count) throws IOException {
        getConsoleInfo();
        this.info.cursorPosition.x = 0;
        Kernel32.COORD coord = this.info.cursorPosition;
        coord.y = (short) (coord.y + count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorLeft(int count) throws IOException {
        getConsoleInfo();
        Kernel32.COORD coord = this.info.cursorPosition;
        coord.x = (short) (coord.x - count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorRight(int count) throws IOException {
        getConsoleInfo();
        Kernel32.COORD coord = this.info.cursorPosition;
        coord.x = (short) (coord.x + count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorDown(int count) throws IOException {
        getConsoleInfo();
        int nb = Math.max(0, ((this.info.cursorPosition.y + count) - this.info.size.y) + 1);
        if (nb != count) {
            Kernel32.COORD coord = this.info.cursorPosition;
            coord.y = (short) (coord.y + count);
            applyCursorPosition();
        }
        if (nb > 0) {
            Kernel32.SMALL_RECT scroll = this.info.window.copy();
            scroll.top = 0;
            Kernel32.COORD org2 = new Kernel32.COORD();
            org2.x = 0;
            org2.y = (short) (-nb);
            Kernel32.CHAR_INFO info = new Kernel32.CHAR_INFO();
            info.unicodeChar = ' ';
            info.attributes = this.originalColors;
            Kernel32.ScrollConsoleScreenBuffer(console, scroll, scroll, org2, info);
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorUp(int count) throws IOException {
        getConsoleInfo();
        Kernel32.COORD coord = this.info.cursorPosition;
        coord.y = (short) (coord.y - count);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorTo(int row, int col) throws IOException {
        getConsoleInfo();
        this.info.cursorPosition.y = (short) ((this.info.window.top + row) - 1);
        this.info.cursorPosition.x = (short) (col - 1);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processCursorToColumn(int x) throws IOException {
        getConsoleInfo();
        this.info.cursorPosition.x = (short) (x - 1);
        applyCursorPosition();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processSetForegroundColorExt(int paletteIndex) throws IOException {
        int color = Colors.roundColor(paletteIndex, 16);
        this.info.attributes = (short) ((this.info.attributes & -8) | ANSI_FOREGROUND_COLOR_MAP[color & 7]);
        this.info.attributes = (short) ((this.info.attributes & (Kernel32.FOREGROUND_INTENSITY ^ -1)) | (color >= 8 ? Kernel32.FOREGROUND_INTENSITY : 0));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processSetBackgroundColorExt(int paletteIndex) throws IOException {
        int color = Colors.roundColor(paletteIndex, 16);
        this.info.attributes = (short) ((this.info.attributes & -113) | ANSI_BACKGROUND_COLOR_MAP[color & 7]);
        this.info.attributes = (short) ((this.info.attributes & (Kernel32.BACKGROUND_INTENSITY ^ -1)) | (color >= 8 ? Kernel32.BACKGROUND_INTENSITY : 0));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processDefaultTextColor() throws IOException {
        this.info.attributes = (short) ((this.info.attributes & -16) | (this.originalColors & 15));
        this.info.attributes = (short) (this.info.attributes & (Kernel32.FOREGROUND_INTENSITY ^ -1));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processDefaultBackgroundColor() throws IOException {
        this.info.attributes = (short) ((this.info.attributes & -241) | (this.originalColors & 240));
        this.info.attributes = (short) (this.info.attributes & (Kernel32.BACKGROUND_INTENSITY ^ -1));
        applyAttribute();
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processAttributeRest() throws IOException {
        this.info.attributes = (short) ((this.info.attributes & -256) | this.originalColors);
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
        this.savedX = this.info.cursorPosition.x;
        this.savedY = this.info.cursorPosition.y;
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processRestoreCursorPosition() throws IOException {
        if (this.savedX != -1 && this.savedY != -1) {
            this.out.flush();
            this.info.cursorPosition.x = this.savedX;
            this.info.cursorPosition.y = this.savedY;
            applyCursorPosition();
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processInsertLine(int optionInt) throws IOException {
        getConsoleInfo();
        Kernel32.SMALL_RECT scroll = this.info.window.copy();
        scroll.top = this.info.cursorPosition.y;
        Kernel32.COORD org2 = new Kernel32.COORD();
        org2.x = 0;
        org2.y = (short) (this.info.cursorPosition.y + optionInt);
        Kernel32.CHAR_INFO info = new Kernel32.CHAR_INFO();
        info.attributes = this.originalColors;
        info.unicodeChar = ' ';
        if (Kernel32.ScrollConsoleScreenBuffer(console, scroll, scroll, org2, info) == 0) {
            throw new IOException(WindowsSupport.getLastErrorMessage());
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processDeleteLine(int optionInt) throws IOException {
        getConsoleInfo();
        Kernel32.SMALL_RECT scroll = this.info.window.copy();
        scroll.top = this.info.cursorPosition.y;
        Kernel32.COORD org2 = new Kernel32.COORD();
        org2.x = 0;
        org2.y = (short) (this.info.cursorPosition.y - optionInt);
        Kernel32.CHAR_INFO info = new Kernel32.CHAR_INFO();
        info.attributes = this.originalColors;
        info.unicodeChar = ' ';
        if (Kernel32.ScrollConsoleScreenBuffer(console, scroll, scroll, org2, info) == 0) {
            throw new IOException(WindowsSupport.getLastErrorMessage());
        }
    }

    @Override // org.jline.utils.AnsiWriter
    protected void processChangeWindowTitle(String title) {
        Kernel32.SetConsoleTitle(title);
    }
}
