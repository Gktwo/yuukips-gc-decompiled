package org.jline.utils;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/AnsiWriter.class */
public class AnsiWriter extends FilterWriter {
    private static final char[] RESET_CODE = "\u001b[0m".toCharArray();
    private static final int MAX_ESCAPE_SEQUENCE_LENGTH = 100;
    private int startOfValue;
    private static final int LOOKING_FOR_FIRST_ESC_CHAR = 0;
    private static final int LOOKING_FOR_SECOND_ESC_CHAR = 1;
    private static final int LOOKING_FOR_NEXT_ARG = 2;
    private static final int LOOKING_FOR_STR_ARG_END = 3;
    private static final int LOOKING_FOR_INT_ARG_END = 4;
    private static final int LOOKING_FOR_OSC_COMMAND = 5;
    private static final int LOOKING_FOR_OSC_COMMAND_END = 6;
    private static final int LOOKING_FOR_OSC_PARAM = 7;
    private static final int LOOKING_FOR_ST = 8;
    private static final int LOOKING_FOR_CHARSET = 9;
    private static final int FIRST_ESC_CHAR = 27;
    private static final int SECOND_ESC_CHAR = 91;
    private static final int SECOND_OSC_CHAR = 93;
    private static final int BEL = 7;
    private static final int SECOND_ST_CHAR = 92;
    private static final int SECOND_CHARSET0_CHAR = 40;
    private static final int SECOND_CHARSET1_CHAR = 41;
    protected static final int ERASE_SCREEN_TO_END = 0;
    protected static final int ERASE_SCREEN_TO_BEGINING = 1;
    protected static final int ERASE_SCREEN = 2;
    protected static final int ERASE_LINE_TO_END = 0;
    protected static final int ERASE_LINE_TO_BEGINING = 1;
    protected static final int ERASE_LINE = 2;
    protected static final int ATTRIBUTE_INTENSITY_BOLD = 1;
    protected static final int ATTRIBUTE_INTENSITY_FAINT = 2;
    protected static final int ATTRIBUTE_ITALIC = 3;
    protected static final int ATTRIBUTE_UNDERLINE = 4;
    protected static final int ATTRIBUTE_BLINK_SLOW = 5;
    protected static final int ATTRIBUTE_BLINK_FAST = 6;
    protected static final int ATTRIBUTE_NEGATIVE_ON = 7;
    protected static final int ATTRIBUTE_CONCEAL_ON = 8;
    protected static final int ATTRIBUTE_UNDERLINE_DOUBLE = 21;
    protected static final int ATTRIBUTE_INTENSITY_NORMAL = 22;
    protected static final int ATTRIBUTE_UNDERLINE_OFF = 24;
    protected static final int ATTRIBUTE_BLINK_OFF = 25;
    @Deprecated
    protected static final int ATTRIBUTE_NEGATIVE_Off = 27;
    protected static final int ATTRIBUTE_NEGATIVE_OFF = 27;
    protected static final int ATTRIBUTE_CONCEAL_OFF = 28;
    protected static final int BLACK = 0;
    protected static final int RED = 1;
    protected static final int GREEN = 2;
    protected static final int YELLOW = 3;
    protected static final int BLUE = 4;
    protected static final int MAGENTA = 5;
    protected static final int CYAN = 6;
    protected static final int WHITE = 7;
    private final char[] buffer = new char[100];
    private int pos = 0;
    private final ArrayList<Object> options = new ArrayList<>();
    int state = 0;

    public AnsiWriter(Writer out) {
        super(out);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public synchronized void write(int data) throws IOException {
        boolean skip;
        switch (this.state) {
            case 0:
                if (data != 27) {
                    this.out.write(data);
                    break;
                } else {
                    char[] cArr = this.buffer;
                    int i = this.pos;
                    this.pos = i + 1;
                    cArr[i] = (char) data;
                    this.state = 1;
                    break;
                }
            case 1:
                char[] cArr2 = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                cArr2[i2] = (char) data;
                if (data != 91) {
                    if (data != 93) {
                        if (data != 40) {
                            if (data != 41) {
                                reset(false);
                                break;
                            } else {
                                this.options.add(49);
                                this.state = 9;
                                break;
                            }
                        } else {
                            this.options.add(48);
                            this.state = 9;
                            break;
                        }
                    } else {
                        this.state = 5;
                        break;
                    }
                } else {
                    this.state = 2;
                    break;
                }
            case 2:
                char[] cArr3 = this.buffer;
                int i3 = this.pos;
                this.pos = i3 + 1;
                cArr3[i3] = (char) data;
                if (34 != data) {
                    if (48 <= data && data <= 57) {
                        this.startOfValue = this.pos - 1;
                        this.state = 4;
                        break;
                    } else if (59 == data) {
                        this.options.add(null);
                        break;
                    } else if (63 == data) {
                        this.options.add('?');
                        break;
                    } else if (61 == data) {
                        this.options.add('=');
                        break;
                    } else {
                        boolean skip2 = true;
                        try {
                            skip2 = processEscapeCommand(this.options, data);
                            reset(skip2);
                            break;
                        } finally {
                        }
                    }
                } else {
                    this.startOfValue = this.pos - 1;
                    this.state = 3;
                    break;
                }
                break;
            case 3:
                char[] cArr4 = this.buffer;
                int i4 = this.pos;
                this.pos = i4 + 1;
                cArr4[i4] = (char) data;
                if (34 != data) {
                    this.options.add(new String(this.buffer, this.startOfValue, (this.pos - 1) - this.startOfValue));
                    if (data != 59) {
                        reset(processEscapeCommand(this.options, data));
                        break;
                    } else {
                        this.state = 2;
                        break;
                    }
                }
                break;
            case 4:
                char[] cArr5 = this.buffer;
                int i5 = this.pos;
                this.pos = i5 + 1;
                cArr5[i5] = (char) data;
                if (48 > data || data > 57) {
                    this.options.add(Integer.valueOf(new String(this.buffer, this.startOfValue, (this.pos - 1) - this.startOfValue)));
                    if (data == 59) {
                        this.state = 2;
                        break;
                    } else {
                        boolean skip3 = true;
                        try {
                            skip3 = processEscapeCommand(this.options, data);
                            reset(skip3);
                            break;
                        } finally {
                        }
                    }
                }
                break;
            case 5:
                char[] cArr6 = this.buffer;
                int i6 = this.pos;
                this.pos = i6 + 1;
                cArr6[i6] = (char) data;
                if (48 <= data && data <= 57) {
                    this.startOfValue = this.pos - 1;
                    this.state = 6;
                    break;
                } else {
                    reset(false);
                    break;
                }
                break;
            case 6:
                char[] cArr7 = this.buffer;
                int i7 = this.pos;
                this.pos = i7 + 1;
                cArr7[i7] = (char) data;
                if (59 != data) {
                    if (48 > data || data > 57) {
                        reset(false);
                        break;
                    }
                } else {
                    this.options.add(Integer.valueOf(new String(this.buffer, this.startOfValue, (this.pos - 1) - this.startOfValue)));
                    this.startOfValue = this.pos;
                    this.state = 7;
                    break;
                }
                break;
            case 7:
                char[] cArr8 = this.buffer;
                int i8 = this.pos;
                this.pos = i8 + 1;
                cArr8[i8] = (char) data;
                if (7 != data) {
                    if (27 == data) {
                        this.state = 8;
                        break;
                    }
                } else {
                    this.options.add(new String(this.buffer, this.startOfValue, (this.pos - 1) - this.startOfValue));
                    boolean skip4 = true;
                    try {
                        skip4 = processOperatingSystemCommand(this.options);
                        reset(skip4);
                        break;
                    } finally {
                    }
                }
                break;
            case 8:
                char[] cArr9 = this.buffer;
                int i9 = this.pos;
                this.pos = i9 + 1;
                cArr9[i9] = (char) data;
                if (92 != data) {
                    this.state = 7;
                    break;
                } else {
                    this.options.add(new String(this.buffer, this.startOfValue, (this.pos - 2) - this.startOfValue));
                    skip = true;
                    try {
                        skip = processOperatingSystemCommand(this.options);
                        reset(skip);
                        break;
                    } finally {
                    }
                }
            case 9:
                this.options.add(Character.valueOf((char) data));
                skip = processCharsetSelect(this.options);
                break;
        }
        if (this.pos >= this.buffer.length) {
            skip = false;
        }
    }

    private void reset(boolean skipBuffer) throws IOException {
        if (!skipBuffer) {
            this.out.write(this.buffer, 0, this.pos);
        }
        this.pos = 0;
        this.startOfValue = 0;
        this.options.clear();
        this.state = 0;
    }

    private int getNextOptionInt(Iterator<Object> optionsIterator) throws IOException {
        while (optionsIterator.hasNext()) {
            Object arg = optionsIterator.next();
            if (arg != null) {
                return ((Integer) arg).intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean processEscapeCommand(ArrayList<Object> options, int command) throws IOException {
        try {
            switch (command) {
                case 65:
                    processCursorUp(optionInt(options, 0, 1));
                    return true;
                case 66:
                    processCursorDown(optionInt(options, 0, 1));
                    return true;
                case 67:
                    processCursorRight(optionInt(options, 0, 1));
                    return true;
                case 68:
                    processCursorLeft(optionInt(options, 0, 1));
                    return true;
                case 69:
                    processCursorDownLine(optionInt(options, 0, 1));
                    return true;
                case 70:
                    processCursorUpLine(optionInt(options, 0, 1));
                    return true;
                case 71:
                    processCursorToColumn(optionInt(options, 0));
                    return true;
                case 72:
                case 102:
                    processCursorTo(optionInt(options, 0, 1), optionInt(options, 1, 1));
                    return true;
                case 73:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 116:
                default:
                    if (97 <= command && 122 <= command) {
                        processUnknownExtension(options, command);
                        return true;
                    } else if (65 > command || 90 > command) {
                        return false;
                    } else {
                        processUnknownExtension(options, command);
                        return true;
                    }
                case 74:
                    processEraseScreen(optionInt(options, 0, 0));
                    return true;
                case 75:
                    processEraseLine(optionInt(options, 0, 0));
                    return true;
                case 76:
                    processInsertLine(optionInt(options, 0, 1));
                    return true;
                case 77:
                    processDeleteLine(optionInt(options, 0, 1));
                    return true;
                case 83:
                    processScrollUp(optionInt(options, 0, 1));
                    return true;
                case 84:
                    processScrollDown(optionInt(options, 0, 1));
                    return true;
                case 109:
                    Iterator<Object> it = options.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next != null && next.getClass() != Integer.class) {
                            throw new IllegalArgumentException();
                        }
                    }
                    int count = 0;
                    Iterator<Object> optionsIterator = options.iterator();
                    while (optionsIterator.hasNext()) {
                        Object next2 = optionsIterator.next();
                        if (next2 != null) {
                            count++;
                            int value = ((Integer) next2).intValue();
                            if (30 <= value && value <= 37) {
                                processSetForegroundColor(value - 30);
                            } else if (40 <= value && value <= 47) {
                                processSetBackgroundColor(value - 40);
                            } else if (90 <= value && value <= 97) {
                                processSetForegroundColor(value - 90, true);
                            } else if (100 <= value && value <= 107) {
                                processSetBackgroundColor(value - 100, true);
                            } else if (value == 38 || value == 48) {
                                int arg2or5 = getNextOptionInt(optionsIterator);
                                if (arg2or5 == 2) {
                                    int r = getNextOptionInt(optionsIterator);
                                    int g = getNextOptionInt(optionsIterator);
                                    int b = getNextOptionInt(optionsIterator);
                                    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
                                        throw new IllegalArgumentException();
                                    } else if (value == 38) {
                                        processSetForegroundColorExt(r, g, b);
                                    } else {
                                        processSetBackgroundColorExt(r, g, b);
                                    }
                                } else if (arg2or5 == 5) {
                                    int paletteIndex = getNextOptionInt(optionsIterator);
                                    if (paletteIndex < 0 || paletteIndex > 255) {
                                        throw new IllegalArgumentException();
                                    } else if (value == 38) {
                                        processSetForegroundColorExt(paletteIndex);
                                    } else {
                                        processSetBackgroundColorExt(paletteIndex);
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else {
                                switch (value) {
                                    case 0:
                                        processAttributeRest();
                                        continue;
                                    case 39:
                                        processDefaultTextColor();
                                        continue;
                                    case 49:
                                        processDefaultBackgroundColor();
                                        continue;
                                    default:
                                        processSetAttribute(value);
                                        continue;
                                }
                            }
                        }
                    }
                    if (count != 0) {
                        return true;
                    }
                    processAttributeRest();
                    return true;
                case 115:
                    processSaveCursorPosition();
                    return true;
                case 117:
                    processRestoreCursorPosition();
                    return true;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean processOperatingSystemCommand(ArrayList<Object> options) throws IOException {
        int command = optionInt(options, 0);
        String label = (String) options.get(1);
        try {
            switch (command) {
                case 0:
                    processChangeIconNameAndWindowTitle(label);
                    return true;
                case 1:
                    processChangeIconName(label);
                    return true;
                case 2:
                    processChangeWindowTitle(label);
                    return true;
                default:
                    processUnknownOperatingSystemCommand(command, label);
                    return true;
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    protected void processRestoreCursorPosition() throws IOException {
    }

    protected void processSaveCursorPosition() throws IOException {
    }

    protected void processInsertLine(int optionInt) throws IOException {
    }

    protected void processDeleteLine(int optionInt) throws IOException {
    }

    protected void processScrollDown(int optionInt) throws IOException {
    }

    protected void processScrollUp(int optionInt) throws IOException {
    }

    protected void processEraseScreen(int eraseOption) throws IOException {
    }

    protected void processEraseLine(int eraseOption) throws IOException {
    }

    protected void processSetAttribute(int attribute) throws IOException {
    }

    protected void processSetForegroundColor(int color) throws IOException {
        processSetForegroundColor(color, false);
    }

    protected void processSetForegroundColor(int color, boolean bright) throws IOException {
        processSetForegroundColorExt(bright ? color + 8 : color);
    }

    protected void processSetForegroundColorExt(int paletteIndex) throws IOException {
    }

    protected void processSetForegroundColorExt(int r, int g, int b) throws IOException {
        processSetForegroundColorExt(Colors.roundRgbColor(r, g, b, 16));
    }

    protected void processSetBackgroundColor(int color) throws IOException {
        processSetBackgroundColor(color, false);
    }

    protected void processSetBackgroundColor(int color, boolean bright) throws IOException {
        processSetBackgroundColorExt(bright ? color + 8 : color);
    }

    protected void processSetBackgroundColorExt(int paletteIndex) throws IOException {
    }

    protected void processSetBackgroundColorExt(int r, int g, int b) throws IOException {
        processSetBackgroundColorExt(Colors.roundRgbColor(r, g, b, 16));
    }

    protected void processDefaultTextColor() throws IOException {
    }

    protected void processDefaultBackgroundColor() throws IOException {
    }

    protected void processAttributeRest() throws IOException {
    }

    protected void processCursorTo(int row, int col) throws IOException {
    }

    protected void processCursorToColumn(int x) throws IOException {
    }

    protected void processCursorUpLine(int count) throws IOException {
    }

    protected void processCursorDownLine(int count) throws IOException {
        for (int i = 0; i < count; i++) {
            this.out.write(10);
        }
    }

    protected void processCursorLeft(int count) throws IOException {
    }

    protected void processCursorRight(int count) throws IOException {
        for (int i = 0; i < count; i++) {
            this.out.write(32);
        }
    }

    protected void processCursorDown(int count) throws IOException {
    }

    protected void processCursorUp(int count) throws IOException {
    }

    protected void processUnknownExtension(ArrayList<Object> options, int command) {
    }

    protected void processChangeIconNameAndWindowTitle(String label) {
        processChangeIconName(label);
        processChangeWindowTitle(label);
    }

    protected void processChangeIconName(String name) {
    }

    protected void processChangeWindowTitle(String title) {
    }

    protected void processUnknownOperatingSystemCommand(int command, String param) {
    }

    private boolean processCharsetSelect(ArrayList<Object> options) throws IOException {
        processCharsetSelect(optionInt(options, 0), ((Character) options.get(1)).charValue());
        return true;
    }

    protected void processCharsetSelect(int set, char seq) {
    }

    private int optionInt(ArrayList<Object> options, int index) {
        if (options.size() <= index) {
            throw new IllegalArgumentException();
        }
        Object value = options.get(index);
        if (value == null) {
            throw new IllegalArgumentException();
        } else if (value.getClass().equals(Integer.class)) {
            return ((Integer) value).intValue();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private int optionInt(ArrayList<Object> options, int index, int defaultValue) {
        if (options.size() <= index) {
            return defaultValue;
        }
        Object value = options.get(index);
        if (value == null) {
            return defaultValue;
        }
        return ((Integer) value).intValue();
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            write(cbuf[off + i]);
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            write(str.charAt(off + i));
        }
    }

    @Override // java.io.FilterWriter, java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() throws IOException {
        write(RESET_CODE);
        flush();
        close();
    }
}
