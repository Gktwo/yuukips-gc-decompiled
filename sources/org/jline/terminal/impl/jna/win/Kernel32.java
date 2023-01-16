package org.jline.terminal.impl.jna.win;

import com.sun.jna.LastErrorException;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import java.util.Arrays;
import java.util.List;

/* WARNING: Classes with same name are omitted:
  
 */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32.class */
public interface Kernel32 extends StdCallLibrary {
    public static final Kernel32 INSTANCE = (Kernel32) Native.load("kernel32", Kernel32.class, W32APIOptions.UNICODE_OPTIONS);
    public static final Pointer INVALID_HANDLE_VALUE = Pointer.createConstant(-1L);
    public static final int STD_INPUT_HANDLE = -10;
    public static final int STD_OUTPUT_HANDLE = -11;
    public static final int STD_ERROR_HANDLE = -12;
    public static final int ENABLE_PROCESSED_INPUT = 1;
    public static final int ENABLE_LINE_INPUT = 2;
    public static final int ENABLE_ECHO_INPUT = 4;
    public static final int ENABLE_WINDOW_INPUT = 8;
    public static final int ENABLE_MOUSE_INPUT = 16;
    public static final int ENABLE_INSERT_MODE = 32;
    public static final int ENABLE_QUICK_EDIT_MODE = 64;
    public static final int ENABLE_EXTENDED_FLAGS = 128;
    public static final int RIGHT_ALT_PRESSED = 1;
    public static final int LEFT_ALT_PRESSED = 2;
    public static final int RIGHT_CTRL_PRESSED = 4;
    public static final int LEFT_CTRL_PRESSED = 8;
    public static final int SHIFT_PRESSED = 16;
    public static final int FOREGROUND_BLUE = 1;
    public static final int FOREGROUND_GREEN = 2;
    public static final int FOREGROUND_RED = 4;
    public static final int FOREGROUND_INTENSITY = 8;
    public static final int BACKGROUND_BLUE = 16;
    public static final int BACKGROUND_GREEN = 32;
    public static final int BACKGROUND_RED = 64;
    public static final int BACKGROUND_INTENSITY = 128;
    public static final int FROM_LEFT_1ST_BUTTON_PRESSED = 1;
    public static final int RIGHTMOST_BUTTON_PRESSED = 2;
    public static final int FROM_LEFT_2ND_BUTTON_PRESSED = 4;
    public static final int FROM_LEFT_3RD_BUTTON_PRESSED = 8;
    public static final int FROM_LEFT_4TH_BUTTON_PRESSED = 16;
    public static final int MOUSE_MOVED = 1;
    public static final int DOUBLE_CLICK = 2;
    public static final int MOUSE_WHEELED = 4;
    public static final int MOUSE_HWHEELED = 8;

    int WaitForSingleObject(Pointer pointer, int i);

    Pointer GetStdHandle(int i);

    void AllocConsole() throws LastErrorException;

    void FreeConsole() throws LastErrorException;

    Pointer GetConsoleWindow();

    int GetConsoleCP();

    void FillConsoleOutputCharacter(Pointer pointer, char c, int i, COORD coord, IntByReference intByReference) throws LastErrorException;

    void FillConsoleOutputAttribute(Pointer pointer, short s, int i, COORD coord, IntByReference intByReference) throws LastErrorException;

    void GetConsoleCursorInfo(Pointer pointer, CONSOLE_CURSOR_INFO.ByReference byReference) throws LastErrorException;

    void GetConsoleMode(Pointer pointer, IntByReference intByReference) throws LastErrorException;

    void GetConsoleScreenBufferInfo(Pointer pointer, CONSOLE_SCREEN_BUFFER_INFO console_screen_buffer_info) throws LastErrorException;

    void GetNumberOfConsoleInputEvents(Pointer pointer, IntByReference intByReference) throws LastErrorException;

    void ReadConsoleInput(Pointer pointer, INPUT_RECORD[] input_recordArr, int i, IntByReference intByReference) throws LastErrorException;

    void SetConsoleCtrlHandler(Pointer pointer, boolean z) throws LastErrorException;

    void ReadConsoleOutput(Pointer pointer, CHAR_INFO[] char_infoArr, COORD coord, COORD coord2, SMALL_RECT small_rect) throws LastErrorException;

    void ReadConsoleOutputA(Pointer pointer, CHAR_INFO[] char_infoArr, COORD coord, COORD coord2, SMALL_RECT small_rect) throws LastErrorException;

    void ReadConsoleOutputCharacter(Pointer pointer, char[] cArr, int i, COORD coord, IntByReference intByReference) throws LastErrorException;

    void ReadConsoleOutputCharacterA(Pointer pointer, byte[] bArr, int i, COORD coord, IntByReference intByReference) throws LastErrorException;

    void SetConsoleCursorInfo(Pointer pointer, CONSOLE_CURSOR_INFO console_cursor_info) throws LastErrorException;

    void SetConsoleCP(int i) throws LastErrorException;

    void SetConsoleOutputCP(int i) throws LastErrorException;

    void SetConsoleCursorPosition(Pointer pointer, COORD coord) throws LastErrorException;

    void SetConsoleMode(Pointer pointer, int i) throws LastErrorException;

    void SetConsoleScreenBufferSize(Pointer pointer, COORD coord) throws LastErrorException;

    void SetConsoleTextAttribute(Pointer pointer, short s) throws LastErrorException;

    void SetConsoleTitle(String str) throws LastErrorException;

    void SetConsoleWindowInfo(Pointer pointer, boolean z, SMALL_RECT small_rect) throws LastErrorException;

    void WriteConsoleW(Pointer pointer, char[] cArr, int i, IntByReference intByReference, Pointer pointer2) throws LastErrorException;

    void WriteConsoleOutput(Pointer pointer, CHAR_INFO[] char_infoArr, COORD coord, COORD coord2, SMALL_RECT small_rect) throws LastErrorException;

    void WriteConsoleOutputA(Pointer pointer, CHAR_INFO[] char_infoArr, COORD coord, COORD coord2, SMALL_RECT small_rect) throws LastErrorException;

    void WriteConsoleOutputCharacter(Pointer pointer, char[] cArr, int i, COORD coord, IntByReference intByReference) throws LastErrorException;

    void WriteConsoleOutputCharacterA(Pointer pointer, byte[] bArr, int i, COORD coord, IntByReference intByReference) throws LastErrorException;

    void ScrollConsoleScreenBuffer(Pointer pointer, SMALL_RECT small_rect, SMALL_RECT small_rect2, COORD coord, CHAR_INFO char_info) throws LastErrorException;

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$CHAR_INFO.class */
    public static class CHAR_INFO extends Structure {
        public UnionChar uChar;
        public short Attributes;
        private static String[] fieldOrder = {"uChar", "Attributes"};

        public CHAR_INFO() {
        }

        public CHAR_INFO(char c, short attr) {
            this.uChar = new UnionChar(c);
            this.Attributes = attr;
        }

        public CHAR_INFO(byte c, short attr) {
            this.uChar = new UnionChar(c);
            this.Attributes = attr;
        }

        public static CHAR_INFO[] createArray(int size) {
            return (CHAR_INFO[]) new CHAR_INFO().toArray(size);
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$CONSOLE_CURSOR_INFO.class */
    public static class CONSOLE_CURSOR_INFO extends Structure {
        public int dwSize;
        public boolean bVisible;
        private static String[] fieldOrder = {"dwSize", "bVisible"};

        /* WARNING: Classes with same name are omitted:
  
 */
        /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$CONSOLE_CURSOR_INFO$ByReference.class */
        public static class ByReference extends CONSOLE_CURSOR_INFO implements Structure.ByReference {
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$CONSOLE_SCREEN_BUFFER_INFO.class */
    public static class CONSOLE_SCREEN_BUFFER_INFO extends Structure {
        public COORD dwSize;
        public COORD dwCursorPosition;
        public short wAttributes;
        public SMALL_RECT srWindow;
        public COORD dwMaximumWindowSize;
        private static String[] fieldOrder = {"dwSize", "dwCursorPosition", "wAttributes", "srWindow", "dwMaximumWindowSize"};

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }

        public int windowWidth() {
            return this.srWindow.width() + 1;
        }

        public int windowHeight() {
            return this.srWindow.height() + 1;
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$COORD.class */
    public static class COORD extends Structure implements Structure.ByValue {

        /* renamed from: X */
        public short f3247X;

        /* renamed from: Y */
        public short f3248Y;
        private static String[] fieldOrder = {"X", "Y"};

        public COORD() {
        }

        public COORD(short X, short Y) {
            this.f3247X = X;
            this.f3248Y = Y;
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$INPUT_RECORD.class */
    public static class INPUT_RECORD extends Structure {
        public static final short KEY_EVENT = 1;
        public static final short MOUSE_EVENT = 2;
        public static final short WINDOW_BUFFER_SIZE_EVENT = 4;
        public static final short MENU_EVENT = 8;
        public static final short FOCUS_EVENT = 16;
        public short EventType;
        public EventUnion Event;
        private static String[] fieldOrder = {"EventType", "Event"};

        /* WARNING: Classes with same name are omitted:
  
 */
        /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$INPUT_RECORD$EventUnion.class */
        public static class EventUnion extends Union {
            public KEY_EVENT_RECORD KeyEvent;
            public MOUSE_EVENT_RECORD MouseEvent;
            public WINDOW_BUFFER_SIZE_RECORD WindowBufferSizeEvent;
            public MENU_EVENT_RECORD MenuEvent;
            public FOCUS_EVENT_RECORD FocusEvent;
        }

        @Override // com.sun.jna.Structure
        public void read() {
            readField("EventType");
            switch (this.EventType) {
                case 1:
                    this.Event.setType(KEY_EVENT_RECORD.class);
                    break;
                case 2:
                    this.Event.setType(MOUSE_EVENT_RECORD.class);
                    break;
                case 4:
                    this.Event.setType(WINDOW_BUFFER_SIZE_RECORD.class);
                    break;
                case 8:
                    this.Event.setType(MENU_EVENT_RECORD.class);
                    break;
                case 16:
                    this.Event.setType(MENU_EVENT_RECORD.class);
                    break;
            }
            read();
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$KEY_EVENT_RECORD.class */
    public static class KEY_EVENT_RECORD extends Structure {
        public boolean bKeyDown;
        public short wRepeatCount;
        public short wVirtualKeyCode;
        public short wVirtualScanCode;
        public UnionChar uChar;
        public int dwControlKeyState;
        private static String[] fieldOrder = {"bKeyDown", "wRepeatCount", "wVirtualKeyCode", "wVirtualScanCode", "uChar", "dwControlKeyState"};

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$MOUSE_EVENT_RECORD.class */
    public static class MOUSE_EVENT_RECORD extends Structure {
        public COORD dwMousePosition;
        public int dwButtonState;
        public int dwControlKeyState;
        public int dwEventFlags;
        private static String[] fieldOrder = {"dwMousePosition", "dwButtonState", "dwControlKeyState", "dwEventFlags"};

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$WINDOW_BUFFER_SIZE_RECORD.class */
    public static class WINDOW_BUFFER_SIZE_RECORD extends Structure {
        public COORD dwSize;
        private static String[] fieldOrder = {"dwSize"};

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$MENU_EVENT_RECORD.class */
    public static class MENU_EVENT_RECORD extends Structure {
        public int dwCommandId;
        private static String[] fieldOrder = {"dwCommandId"};

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$FOCUS_EVENT_RECORD.class */
    public static class FOCUS_EVENT_RECORD extends Structure {
        public boolean bSetFocus;
        private static String[] fieldOrder = {"bSetFocus"};

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$SMALL_RECT.class */
    public static class SMALL_RECT extends Structure {
        public short Left;
        public short Top;
        public short Right;
        public short Bottom;
        private static String[] fieldOrder = {"Left", "Top", "Right", "Bottom"};

        public SMALL_RECT() {
        }

        public SMALL_RECT(SMALL_RECT org2) {
            this(org2.Top, org2.Left, org2.Bottom, org2.Right);
        }

        public SMALL_RECT(short Top, short Left, short Bottom, short Right) {
            this.Top = Top;
            this.Left = Left;
            this.Bottom = Bottom;
            this.Right = Right;
        }

        @Override // com.sun.jna.Structure
        protected List<String> getFieldOrder() {
            return Arrays.asList(fieldOrder);
        }

        public short width() {
            return (short) (this.Right - this.Left);
        }

        public short height() {
            return (short) (this.Bottom - this.Top);
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/impl/jna/win/Kernel32$UnionChar.class */
    public static class UnionChar extends Union {
        public char UnicodeChar;
        public byte AsciiChar;

        public UnionChar() {
        }

        public UnionChar(char c) {
            setType(Character.TYPE);
            this.UnicodeChar = c;
        }

        public UnionChar(byte c) {
            setType(Byte.TYPE);
            this.AsciiChar = c;
        }

        public void set(char c) {
            setType(Character.TYPE);
            this.UnicodeChar = c;
        }

        public void set(byte c) {
            setType(Byte.TYPE);
            this.AsciiChar = c;
        }
    }
}
