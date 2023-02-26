package org.jline.builtins;

import com.google.common.net.HttpHeaders;
import dev.morphia.mapping.Mapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.jline.builtins.Source;
import org.jline.builtins.Styles;
import org.jline.console.Printer;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.reader.Editor;
import org.jline.reader.LineReader;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Attributes;
import org.jline.terminal.MouseEvent;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;
import org.jline.utils.Status;
import org.jline.utils.StyleResolver;
import org.mozilla.universalchardet.CharsetListener;
import org.mozilla.universalchardet.UniversalDetector;
import p001ch.qos.logback.classic.net.SyslogAppender;
import p001ch.qos.logback.core.util.LocationUtil;

/* loaded from: grasscutter.jar:org/jline/builtins/Nano.class */
public class Nano implements Editor {
    protected final Terminal terminal;
    protected final Display display;
    protected final BindingReader bindingReader;
    protected final Size size;
    protected final Path root;
    protected final int vsusp;
    private final List<Path> syntaxFiles;
    protected KeyMap<Operation> keys;
    public String title;
    public boolean printLineNumbers;
    public boolean wrapping;
    public boolean smoothScrolling;
    public boolean mouseSupport;
    public boolean oneMoreLine;
    public boolean constantCursor;
    public boolean quickBlank;
    public int tabs;
    public String brackets;
    public String matchBrackets;
    public String punct;
    public String quoteStr;
    private boolean restricted;
    private String syntaxName;
    private boolean writeBackup;
    private boolean atBlanks;
    private boolean view;
    private boolean cut2end;
    private boolean tempFile;
    private String historyLog;
    private boolean tabsToSpaces;
    private boolean autoIndent;
    protected final List<Buffer> buffers;
    protected int bufferIndex;
    protected Buffer buffer;
    protected String message;
    protected String errorMessage;
    protected int nbBindings;
    protected LinkedHashMap<String, String> shortcuts;
    protected String editMessage;
    protected final StringBuilder editBuffer;
    protected boolean searchCaseSensitive;
    protected boolean searchRegexp;
    protected boolean searchBackwards;
    protected String searchTerm;
    protected int matchedLength;
    protected PatternHistory patternHistory;
    protected WriteMode writeMode;
    protected List<String> cutbuffer;
    protected boolean mark;
    protected boolean highlight;
    private boolean searchToReplace;
    protected boolean readNewBuffer;
    private boolean nanorcIgnoreErrors;
    private final boolean windowsTerminal;

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$CursorMovement.class */
    public enum CursorMovement {
        RIGHT,
        LEFT,
        STILL
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$Operation.class */
    public enum Operation {
        DO_LOWER_CASE,
        QUIT,
        WRITE,
        READ,
        GOTO,
        FIND,
        WRAP,
        NUMBERS,
        SMOOTH_SCROLLING,
        MOUSE_SUPPORT,
        ONE_MORE_LINE,
        CLEAR_SCREEN,
        UP,
        DOWN,
        LEFT,
        RIGHT,
        INSERT,
        BACKSPACE,
        NEXT_BUFFER,
        PREV_BUFFER,
        HELP,
        NEXT_PAGE,
        PREV_PAGE,
        SCROLL_UP,
        SCROLL_DOWN,
        NEXT_WORD,
        PREV_WORD,
        BEGINNING_OF_LINE,
        END_OF_LINE,
        FIRST_LINE,
        LAST_LINE,
        CUR_POS,
        CASE_SENSITIVE,
        BACKWARDS,
        REGEXP,
        ACCEPT,
        CANCEL,
        SEARCH,
        TOGGLE_REPLACE,
        MAC_FORMAT,
        DOS_FORMAT,
        APPEND_MODE,
        PREPEND_MODE,
        BACKUP,
        TO_FILES,
        YES,
        NO,
        ALL,
        NEW_BUFFER,
        EXECUTE,
        NEXT_SEARCH,
        MATCHING,
        VERBATIM,
        DELETE,
        JUSTIFY_PARAGRAPH,
        TO_SPELL,
        CUT,
        REPLACE,
        MARK,
        COPY,
        INDENT,
        UNINDENT,
        BEGINNING_OF_PARAGRAPH,
        END_OF_PARAGRAPH,
        CUT_TO_END,
        JUSTIFY_FILE,
        COUNT,
        CONSTANT_CURSOR,
        WHITESPACE,
        HIGHLIGHT,
        SMART_HOME_KEY,
        AUTO_INDENT,
        CUT_TO_END_TOGGLE,
        TABS_TO_SPACE,
        UNCUT,
        MOUSE_EVENT,
        TOGGLE_SUSPENSION
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$WriteFormat.class */
    public enum WriteFormat {
        UNIX,
        DOS,
        MAC
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$WriteMode.class */
    public enum WriteMode {
        WRITE,
        APPEND,
        PREPEND
    }

    public static String[] usage() {
        return new String[]{"nano -  edit files", "Usage: nano [OPTIONS] [FILES]", "  -? --help                    Show help", "  -B --backup                  When saving a file, back up the previous version of it, using the current filename", "                               suffixed with a tilde (~).", "  -I --ignorercfiles           Don't look at the system's nanorc nor at the user's nanorc.", "  -Q --quotestr=regex          Set the regular expression for matching the quoting part of a line.", "  -T --tabsize=number          Set the size (width) of a tab to number columns.", "  -U --quickblank              Do quick status-bar blanking: status-bar messages will disappear after 1 keystroke.", "  -c --constantshow            Constantly show the cursor position on the status bar.", "  -e --emptyline               Do not use the line below the title bar, leaving it entirely blank.", "  -j --jumpyscrolling          Scroll the buffer contents per half-screen instead of per line.", "  -l --linenumbers             Display line numbers to the left of the text area.", "  -m --mouse                   Enable mouse support, if available for your system.", "  -$ --softwrap                Enable 'soft wrapping'. ", "  -a --atblanks                Wrap lines at whitespace instead of always at the edge of the screen.", "  -R --restricted              Restricted mode: don't allow suspending; don't allow a file to be appended to,", "                               prepended to, or saved under a different name if it already has one;", "                               and don't use backup files.", "  -Y --syntax=name             The name of the syntax highlighting to use.", "  -z --suspend                 Enable the ability to suspend nano using the system's suspend keystroke (usually ^Z).", "  -v --view                    Don't allow the contents of the file to be altered: read-only mode.", "  -k --cutfromcursor           Make the 'Cut Text' command cut from the current cursor position to the end of the line", "  -t --tempfile                Save a changed buffer without prompting (when exiting with ^X).", "  -H --historylog=name         Log search strings to file, so they can be retrieved in later sessions", "  -E --tabstospaces            Convert typed tabs to spaces.", "  -i --autoindent              Indent new lines to the previous line's indentation."};
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$Buffer.class */
    public class Buffer {
        String file;
        Charset charset;
        List<String> lines;
        int firstLineToDisplay;
        int offsetInLineToDisplay;
        int line;
        int offsetInLine;
        int column;
        int wantedColumn;
        SyntaxHighlighter syntaxHighlighter;
        boolean dirty;
        WriteFormat format = WriteFormat.UNIX;
        int firstColumnToDisplay = 0;
        List<LinkedList<Integer>> offsets = new ArrayList();
        boolean uncut = false;
        int[] markPos = {-1, -1};

        protected Buffer(String file) {
            this.file = file;
            this.syntaxHighlighter = SyntaxHighlighter.build(Nano.this.syntaxFiles, file, Nano.this.syntaxName, Nano.this.nanorcIgnoreErrors);
        }

        void open() throws IOException {
            if (this.lines == null) {
                this.lines = new ArrayList();
                this.lines.add("");
                this.charset = Charset.defaultCharset();
                computeAllOffsets();
                if (this.file != null) {
                    Path path = Nano.this.root.resolve(this.file);
                    if (Files.isDirectory(path, new LinkOption[0])) {
                        Nano.this.setMessage("\"" + this.file + "\" is a directory");
                        return;
                    }
                    try {
                        InputStream fis = Files.newInputStream(path, new OpenOption[0]);
                        read(fis);
                        if (fis != null) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        Nano.this.setMessage("Error reading " + this.file + ": " + e.getMessage());
                    }
                }
            }
        }

        void open(InputStream is) throws IOException {
            if (this.lines == null) {
                this.lines = new ArrayList();
                this.lines.add("");
                this.charset = Charset.defaultCharset();
                computeAllOffsets();
                read(is);
            }
        }

        void read(InputStream fis) throws IOException {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            while (true) {
                int remaining = fis.read(buffer);
                if (remaining <= 0) {
                    break;
                }
                bos.write(buffer, 0, remaining);
            }
            byte[] bytes = bos.toByteArray();
            try {
                UniversalDetector detector = new UniversalDetector((CharsetListener) null);
                detector.handleData(bytes, 0, bytes.length);
                detector.dataEnd();
                if (detector.getDetectedCharset() != null) {
                    this.charset = Charset.forName(detector.getDetectedCharset());
                }
            } catch (Throwable th) {
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes), this.charset));
            try {
                this.lines.clear();
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    this.lines.add(line);
                }
                reader.close();
                if (this.lines.isEmpty()) {
                    this.lines.add("");
                }
                computeAllOffsets();
                moveToChar(0);
            } catch (Throwable th2) {
                try {
                    reader.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }

        private int charPosition(int displayPosition) {
            return charPosition(this.line, displayPosition, CursorMovement.STILL);
        }

        private int charPosition(int displayPosition, CursorMovement move) {
            return charPosition(this.line, displayPosition, move);
        }

        private int charPosition(int line, int displayPosition) {
            return charPosition(line, displayPosition, CursorMovement.STILL);
        }

        private int charPosition(int line, int displayPosition, CursorMovement move) {
            int out = this.lines.get(line).length();
            if (!this.lines.get(line).contains(SyslogAppender.DEFAULT_STACKTRACE_PATTERN) || displayPosition == 0) {
                out = displayPosition;
            } else if (displayPosition < length(this.lines.get(line))) {
                int ldiff = 0;
                int i = 0;
                while (true) {
                    if (i >= this.lines.get(line).length()) {
                        break;
                    }
                    int dp = length(this.lines.get(line).substring(0, i));
                    if (move == CursorMovement.LEFT) {
                        if (dp > displayPosition) {
                            break;
                        }
                        out = i;
                        i++;
                    } else if (move != CursorMovement.RIGHT) {
                        if (move != CursorMovement.STILL) {
                            continue;
                        } else if (dp <= displayPosition) {
                            ldiff = displayPosition - dp;
                            out = i;
                        } else if (dp >= displayPosition) {
                            if (dp - displayPosition < ldiff) {
                                out = i;
                            }
                        }
                        i++;
                    } else if (dp >= displayPosition) {
                        out = i;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return out;
        }

        String blanks(int nb) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nb; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        void insert(String insert) {
            String mod;
            String text = this.lines.get(this.line);
            int pos = charPosition(this.offsetInLine + this.column);
            String insert2 = insert.replaceAll("\r\n", "\n").replaceAll("\r", "\n");
            if (Nano.this.tabsToSpaces && insert2.length() == 1 && insert2.charAt(0) == '\t') {
                insert2 = blanks(((pos == text.length() ? length(text + insert2) : length(text.substring(0, pos) + insert2)) - this.offsetInLine) - this.column);
            }
            if (Nano.this.autoIndent && insert2.length() == 1 && insert2.charAt(0) == '\n') {
                char[] charArray = this.lines.get(this.line).toCharArray();
                for (char c : charArray) {
                    if (c != ' ') {
                        if (c != '\t') {
                            break;
                        }
                        insert2 = insert2 + c;
                    } else {
                        insert2 = insert2 + c;
                    }
                }
            }
            String tail = "";
            if (pos == text.length()) {
                mod = text + insert2;
            } else {
                mod = text.substring(0, pos) + insert2;
                tail = text.substring(pos);
            }
            List<String> ins = new ArrayList<>();
            int last = 0;
            int idx = mod.indexOf(10, 0);
            while (idx >= 0) {
                ins.add(mod.substring(last, idx));
                last = idx + 1;
                idx = mod.indexOf(10, last);
            }
            ins.add(mod.substring(last) + tail);
            int curPos = length(mod.substring(last));
            this.lines.set(this.line, ins.get(0));
            this.offsets.set(this.line, computeOffsets(ins.get(0)));
            for (int i = 1; i < ins.size(); i++) {
                this.line++;
                this.lines.add(this.line, ins.get(i));
                this.offsets.add(this.line, computeOffsets(ins.get(i)));
            }
            moveToChar(curPos);
            ensureCursorVisible();
            this.dirty = true;
        }

        void computeAllOffsets() {
            this.offsets.clear();
            for (String text : this.lines) {
                this.offsets.add(computeOffsets(text));
            }
        }

        LinkedList<Integer> computeOffsets(String line) {
            String text = new AttributedStringBuilder().tabs(Nano.this.tabs).append((CharSequence) line).toString();
            int width = Nano.this.size.getColumns() - (Nano.this.printLineNumbers ? 8 : 0);
            LinkedList<Integer> offsets = new LinkedList<>();
            offsets.add(0);
            if (Nano.this.wrapping) {
                int last = 0;
                int prevword = 0;
                boolean inspace = false;
                for (int i = 0; i < text.length(); i++) {
                    if (isBreakable(text.charAt(i))) {
                        inspace = true;
                    } else if (inspace) {
                        prevword = i;
                        inspace = false;
                    }
                    if (i == (last + width) - 1) {
                        if (prevword == last) {
                            prevword = i;
                        }
                        offsets.add(Integer.valueOf(prevword));
                        last = prevword;
                    }
                }
            }
            return offsets;
        }

        boolean isBreakable(char ch) {
            return !Nano.this.atBlanks || ch == ' ';
        }

        void moveToChar(int pos) {
            moveToChar(pos, CursorMovement.STILL);
        }

        void moveToChar(int pos, CursorMovement move) {
            if (!Nano.this.wrapping) {
                if (pos > this.column && (pos - this.firstColumnToDisplay) + 1 > width()) {
                    this.firstColumnToDisplay = (this.offsetInLine + this.column) - 6;
                } else if (pos < this.column && this.firstColumnToDisplay + 5 > pos) {
                    this.firstColumnToDisplay = Math.max(0, (this.firstColumnToDisplay - width()) + 5);
                }
            }
            if (this.lines.get(this.line).contains(SyslogAppender.DEFAULT_STACKTRACE_PATTERN)) {
                int cpos = charPosition(pos, move);
                if (cpos < this.lines.get(this.line).length()) {
                    pos = length(this.lines.get(this.line).substring(0, cpos));
                } else {
                    pos = length(this.lines.get(this.line));
                }
            }
            this.offsetInLine = prevLineOffset(this.line, pos + 1).get().intValue();
            this.column = pos - this.offsetInLine;
        }

        void delete(int count) {
            do {
                count--;
                if (count < 0 || !moveRight(1)) {
                    return;
                }
            } while (backspace(1));
        }

        boolean backspace(int count) {
            while (count > 0) {
                String text = this.lines.get(this.line);
                int pos = charPosition(this.offsetInLine + this.column);
                if (pos != 0) {
                    int nb = Math.min(pos, count);
                    int curPos = length(text.substring(0, pos - nb));
                    String text2 = text.substring(0, pos - nb) + text.substring(pos);
                    this.lines.set(this.line, text2);
                    this.offsets.set(this.line, computeOffsets(text2));
                    moveToChar(curPos);
                    count -= nb;
                } else if (this.line == 0) {
                    bof();
                    return false;
                } else {
                    List<String> list = this.lines;
                    int i = this.line - 1;
                    this.line = i;
                    String prev = list.get(i);
                    this.lines.set(this.line, prev + text);
                    this.offsets.set(this.line, computeOffsets(prev + text));
                    moveToChar(length(prev));
                    this.lines.remove(this.line + 1);
                    this.offsets.remove(this.line + 1);
                    count--;
                }
                this.dirty = true;
            }
            ensureCursorVisible();
            return true;
        }

        boolean moveLeft(int chars) {
            boolean ret = true;
            while (true) {
                chars--;
                if (chars >= 0) {
                    if (this.offsetInLine + this.column <= 0) {
                        if (this.line <= 0) {
                            bof();
                            ret = false;
                            break;
                        }
                        this.line--;
                        moveToChar(length(getLine(this.line)));
                    } else {
                        moveToChar((this.offsetInLine + this.column) - 1, CursorMovement.LEFT);
                    }
                } else {
                    break;
                }
            }
            this.wantedColumn = this.column;
            ensureCursorVisible();
            return ret;
        }

        boolean moveRight(int chars) {
            return moveRight(chars, false);
        }

        int width() {
            return ((Nano.this.size.getColumns() - (Nano.this.printLineNumbers ? 8 : 0)) - (Nano.this.wrapping ? 0 : 1)) - (this.firstColumnToDisplay > 0 ? 1 : 0);
        }

        boolean moveRight(int chars, boolean fromBeginning) {
            if (fromBeginning) {
                this.firstColumnToDisplay = 0;
                this.offsetInLine = 0;
                this.column = 0;
                chars = Math.min(chars, length(getLine(this.line)));
            }
            boolean ret = true;
            while (true) {
                chars--;
                if (chars >= 0) {
                    if (this.offsetInLine + this.column + 1 > length(getLine(this.line))) {
                        if (getLine(this.line + 1) == null) {
                            eof();
                            ret = false;
                            break;
                        }
                        this.line++;
                        this.firstColumnToDisplay = 0;
                        this.offsetInLine = 0;
                        this.column = 0;
                    } else {
                        moveToChar(this.offsetInLine + this.column + 1, CursorMovement.RIGHT);
                    }
                } else {
                    break;
                }
            }
            this.wantedColumn = this.column;
            ensureCursorVisible();
            return ret;
        }

        void moveDown(int lines) {
            cursorDown(lines);
            ensureCursorVisible();
        }

        void moveUp(int lines) {
            cursorUp(lines);
            ensureCursorVisible();
        }

        private Optional<Integer> prevLineOffset(int line, int offsetInLine) {
            if (line >= this.offsets.size()) {
                return Optional.empty();
            }
            Iterator<Integer> it = this.offsets.get(line).descendingIterator();
            while (it.hasNext()) {
                int off = it.next().intValue();
                if (off < offsetInLine) {
                    return Optional.of(Integer.valueOf(off));
                }
            }
            return Optional.empty();
        }

        private Optional<Integer> nextLineOffset(int line, int offsetInLine) {
            if (line >= this.offsets.size()) {
                return Optional.empty();
            }
            return this.offsets.get(line).stream().filter(o -> {
                return o.intValue() > offsetInLine;
            }).findFirst();
        }

        void moveDisplayDown(int lines) {
            int height = (Nano.this.size.getRows() - computeHeader().size()) - Nano.this.computeFooter().size();
            while (true) {
                lines--;
                if (lines >= 0) {
                    int lastLineToDisplay = this.firstLineToDisplay;
                    if (!Nano.this.wrapping) {
                        lastLineToDisplay += height - 1;
                    } else {
                        int off = this.offsetInLineToDisplay;
                        for (int l = 0; l < height - 1; l++) {
                            Optional<Integer> next = nextLineOffset(lastLineToDisplay, off);
                            if (next.isPresent()) {
                                off = next.get().intValue();
                            } else {
                                off = 0;
                                lastLineToDisplay++;
                            }
                        }
                    }
                    if (getLine(lastLineToDisplay) == null) {
                        eof();
                        return;
                    }
                    Optional<Integer> next2 = nextLineOffset(this.firstLineToDisplay, this.offsetInLineToDisplay);
                    if (next2.isPresent()) {
                        this.offsetInLineToDisplay = next2.get().intValue();
                    } else {
                        this.offsetInLineToDisplay = 0;
                        this.firstLineToDisplay++;
                    }
                } else {
                    return;
                }
            }
        }

        void moveDisplayUp(int lines) {
            int width = Nano.this.size.getColumns() - (Nano.this.printLineNumbers ? 8 : 0);
            while (true) {
                lines--;
                if (lines < 0) {
                    return;
                }
                if (this.offsetInLineToDisplay > 0) {
                    this.offsetInLineToDisplay = Math.max(0, this.offsetInLineToDisplay - (width - 1));
                } else if (this.firstLineToDisplay > 0) {
                    this.firstLineToDisplay--;
                    this.offsetInLineToDisplay = prevLineOffset(this.firstLineToDisplay, Integer.MAX_VALUE).get().intValue();
                } else {
                    bof();
                    return;
                }
            }
        }

        private void cursorDown(int lines) {
            this.firstColumnToDisplay = 0;
            while (true) {
                lines--;
                if (lines < 0) {
                    break;
                } else if (!Nano.this.wrapping) {
                    if (getLine(this.line + 1) == null) {
                        bof();
                        break;
                    }
                    this.line++;
                    this.offsetInLine = 0;
                    this.column = Math.min(length(getLine(this.line)), this.wantedColumn);
                } else {
                    String txt = getLine(this.line);
                    Optional<Integer> off = nextLineOffset(this.line, this.offsetInLine);
                    if (off.isPresent()) {
                        this.offsetInLine = off.get().intValue();
                    } else if (getLine(this.line + 1) == null) {
                        eof();
                        break;
                    } else {
                        this.line++;
                        this.offsetInLine = 0;
                        txt = getLine(this.line);
                    }
                    this.column = Math.min(this.wantedColumn, nextLineOffset(this.line, this.offsetInLine).orElse(Integer.valueOf(length(txt))).intValue() - this.offsetInLine);
                }
            }
            moveToChar(this.offsetInLine + this.column);
        }

        private void cursorUp(int lines) {
            this.firstColumnToDisplay = 0;
            while (true) {
                lines--;
                if (lines >= 0) {
                    if (!Nano.this.wrapping) {
                        if (this.line <= 0) {
                            bof();
                            break;
                        } else {
                            this.line--;
                            this.column = Math.min(length(getLine(this.line)) - this.offsetInLine, this.wantedColumn);
                        }
                    } else {
                        Optional<Integer> prev = prevLineOffset(this.line, this.offsetInLine);
                        if (!prev.isPresent()) {
                            if (this.line <= 0) {
                                bof();
                                break;
                            }
                            this.line--;
                            this.offsetInLine = prevLineOffset(this.line, Integer.MAX_VALUE).get().intValue();
                            this.column = Math.min(this.wantedColumn, nextLineOffset(this.line, this.offsetInLine).orElse(Integer.valueOf(length(getLine(this.line)))).intValue() - this.offsetInLine);
                        } else {
                            this.offsetInLine = prev.get().intValue();
                        }
                    }
                } else {
                    break;
                }
            }
            moveToChar(this.offsetInLine + this.column);
        }

        void ensureCursorVisible() {
            List<AttributedString> header = computeHeader();
            int rwidth = Nano.this.size.getColumns();
            int height = (Nano.this.size.getRows() - header.size()) - Nano.this.computeFooter().size();
            while (true) {
                if (this.line < this.firstLineToDisplay || (this.line == this.firstLineToDisplay && this.offsetInLine < this.offsetInLineToDisplay)) {
                    moveDisplayUp(Nano.this.smoothScrolling ? 1 : height / 2);
                }
            }
            while (true) {
                if (computeCursorPosition((header.size() * Nano.this.size.getColumns()) + (Nano.this.printLineNumbers ? 8 : 0), rwidth) >= (height + header.size()) * rwidth) {
                    moveDisplayDown(Nano.this.smoothScrolling ? 1 : height / 2);
                } else {
                    return;
                }
            }
        }

        void eof() {
        }

        void bof() {
        }

        void resetDisplay() {
            this.column = this.offsetInLine + this.column;
            moveRight(this.column, true);
        }

        String getLine(int line) {
            if (line < this.lines.size()) {
                return this.lines.get(line);
            }
            return null;
        }

        String getTitle() {
            return this.file != null ? "File: " + this.file : "New Buffer";
        }

        List<AttributedString> computeHeader() {
            String left = Nano.this.getTitle();
            String middle = null;
            String right = this.dirty ? "Modified" : "        ";
            int width = Nano.this.size.getColumns();
            int mstart = 2 + left.length() + 1;
            int mend = (width - 2) - 8;
            if (this.file == null) {
                middle = "New Buffer";
            } else {
                int max = mend - mstart;
                String src = this.file;
                if ("File: ".length() + src.length() > max) {
                    int lastSep = src.lastIndexOf(47);
                    if (lastSep > 0) {
                        String p1 = src.substring(lastSep);
                        String p0 = src.substring(0, lastSep);
                        while (p0.startsWith(Mapper.IGNORED_FIELDNAME)) {
                            p0 = p0.substring(1);
                        }
                        middle = "File: ..." + p0.substring(Math.max(0, Math.min(p0.length(), p0.length() - ((max - p1.length()) - "File: ...".length())))) + p1;
                    }
                    if (middle == null || middle.length() > max) {
                        left = null;
                        int max2 = mend - 2;
                        middle = "File: ..." + src.substring(Math.max(0, Math.min(src.length(), src.length() - (max2 - "File: ...".length()))));
                        if (middle.length() > max2) {
                            middle = middle.substring(0, max2);
                        }
                    }
                } else {
                    middle = "File: " + src;
                }
            }
            AttributedStringBuilder sb = new AttributedStringBuilder();
            sb.style(AttributedStyle.INVERSE);
            sb.append((CharSequence) "  ");
            int pos = 0 + 2;
            if (left != null) {
                sb.append((CharSequence) left);
                sb.append((CharSequence) " ");
                pos = pos + left.length() + 1;
                for (int i = 1; i < ((((Nano.this.size.getColumns() - middle.length()) / 2) - left.length()) - 1) - 2; i++) {
                    sb.append((CharSequence) " ");
                    pos++;
                }
            }
            sb.append((CharSequence) middle);
            for (int pos2 = pos + middle.length(); pos2 < (width - 8) - 2; pos2++) {
                sb.append((CharSequence) " ");
            }
            sb.append((CharSequence) right);
            sb.append((CharSequence) "  \n");
            return Nano.this.oneMoreLine ? Collections.singletonList(sb.toAttributedString()) : Arrays.asList(sb.toAttributedString(), new AttributedString("\n"));
        }

        void highlightDisplayedLine(int curLine, int curOffset, int nextOffset, AttributedStringBuilder line) {
            AttributedString disp = Nano.this.highlight ? this.syntaxHighlighter.highlight(new AttributedStringBuilder().tabs(Nano.this.tabs).append((CharSequence) getLine(curLine))) : new AttributedStringBuilder().tabs(Nano.this.tabs).append((CharSequence) getLine(curLine)).toAttributedString();
            int[] hls = highlightStart();
            int[] hle = highlightEnd();
            if (hls[0] == -1 || hle[0] == -1) {
                line.append(disp.columnSubSequence(curOffset, nextOffset));
            } else if (hls[0] == hle[0]) {
                if (curLine != hls[0]) {
                    line.append(disp.columnSubSequence(curOffset, nextOffset));
                } else if (hls[1] > nextOffset) {
                    line.append(disp.columnSubSequence(curOffset, nextOffset));
                } else if (hls[1] >= curOffset) {
                    line.append(disp.columnSubSequence(curOffset, hls[1]));
                    if (hle[1] > nextOffset) {
                        line.append(disp.columnSubSequence(hls[1], nextOffset), AttributedStyle.INVERSE);
                        return;
                    }
                    line.append(disp.columnSubSequence(hls[1], hle[1]), AttributedStyle.INVERSE);
                    line.append(disp.columnSubSequence(hle[1], nextOffset));
                } else if (hle[1] > nextOffset) {
                    line.append(disp.columnSubSequence(curOffset, nextOffset), AttributedStyle.INVERSE);
                } else if (hle[1] > curOffset) {
                    line.append(disp.columnSubSequence(curOffset, hle[1]), AttributedStyle.INVERSE);
                    line.append(disp.columnSubSequence(hle[1], nextOffset));
                } else {
                    line.append(disp.columnSubSequence(curOffset, nextOffset));
                }
            } else if (curLine > hls[0] && curLine < hle[0]) {
                line.append(disp.columnSubSequence(curOffset, nextOffset), AttributedStyle.INVERSE);
            } else if (curLine == hls[0]) {
                if (hls[1] > nextOffset) {
                    line.append(disp.columnSubSequence(curOffset, nextOffset));
                } else if (hls[1] < curOffset) {
                    line.append(disp.columnSubSequence(curOffset, nextOffset), AttributedStyle.INVERSE);
                } else {
                    line.append(disp.columnSubSequence(curOffset, hls[1]));
                    line.append(disp.columnSubSequence(hls[1], nextOffset), AttributedStyle.INVERSE);
                }
            } else if (curLine != hle[0]) {
                line.append(disp.columnSubSequence(curOffset, nextOffset));
            } else if (hle[1] < curOffset) {
                line.append(disp.columnSubSequence(curOffset, nextOffset));
            } else if (hle[1] > nextOffset) {
                line.append(disp.columnSubSequence(curOffset, nextOffset), AttributedStyle.INVERSE);
            } else {
                line.append(disp.columnSubSequence(curOffset, hle[1]), AttributedStyle.INVERSE);
                line.append(disp.columnSubSequence(hle[1], nextOffset));
            }
        }

        List<AttributedString> getDisplayedLines(int nbLines) {
            AttributedStyle s = AttributedStyle.DEFAULT.foreground(8);
            AttributedString cut = new AttributedString("…", s);
            AttributedString ret = new AttributedString("↩", s);
            List<AttributedString> newLines = new ArrayList<>();
            int width = Nano.this.size.getColumns() - (Nano.this.printLineNumbers ? 8 : 0);
            int curLine = this.firstLineToDisplay;
            int curOffset = this.offsetInLineToDisplay;
            int prevLine = -1;
            this.syntaxHighlighter.reset();
            for (int terminalLine = 0; terminalLine < nbLines; terminalLine++) {
                AttributedStringBuilder line = new AttributedStringBuilder().tabs(Nano.this.tabs);
                if (Nano.this.printLineNumbers && curLine < this.lines.size()) {
                    line.style(s);
                    if (curLine != prevLine) {
                        line.append((CharSequence) String.format("%7d ", Integer.valueOf(curLine + 1)));
                    } else {
                        line.append("      ‧ ");
                    }
                    line.style(AttributedStyle.DEFAULT);
                    prevLine = curLine;
                }
                if (curLine < this.lines.size()) {
                    if (!Nano.this.wrapping) {
                        AttributedString disp = new AttributedStringBuilder().tabs(Nano.this.tabs).append((CharSequence) getLine(curLine)).toAttributedString();
                        if (this.line == curLine) {
                            int cutCount = 1;
                            if (this.firstColumnToDisplay > 0) {
                                line.append(cut);
                                cutCount = 2;
                            }
                            if (disp.columnLength() - this.firstColumnToDisplay >= width - ((cutCount - 1) * cut.columnLength())) {
                                highlightDisplayedLine(curLine, this.firstColumnToDisplay, (this.firstColumnToDisplay + width) - (cutCount * cut.columnLength()), line);
                                line.append(cut);
                            } else {
                                highlightDisplayedLine(curLine, this.firstColumnToDisplay, disp.columnLength(), line);
                            }
                        } else if (disp.columnLength() >= width) {
                            highlightDisplayedLine(curLine, 0, width - cut.columnLength(), line);
                            line.append(cut);
                        } else {
                            highlightDisplayedLine(curLine, 0, disp.columnLength(), line);
                        }
                        curLine++;
                    } else {
                        Optional<Integer> nextOffset = nextLineOffset(curLine, curOffset);
                        if (nextOffset.isPresent()) {
                            highlightDisplayedLine(curLine, curOffset, nextOffset.get().intValue(), line);
                            line.append(ret);
                            curOffset = nextOffset.get().intValue();
                        } else {
                            highlightDisplayedLine(curLine, curOffset, Integer.MAX_VALUE, line);
                            curLine++;
                            curOffset = 0;
                        }
                    }
                }
                line.append('\n');
                newLines.add(line.toAttributedString());
            }
            return newLines;
        }

        public void moveTo(int x, int y) {
            if (Nano.this.printLineNumbers) {
                x = Math.max(x - 8, 0);
            }
            this.line = this.firstLineToDisplay;
            this.offsetInLine = this.offsetInLineToDisplay;
            this.wantedColumn = x;
            cursorDown(y);
        }

        public void gotoLine(int x, int y) {
            this.line = y < this.lines.size() ? y : this.lines.size() - 1;
            int x2 = Math.min(x, length(this.lines.get(this.line)));
            this.firstLineToDisplay = this.line > 0 ? this.line - 1 : this.line;
            this.offsetInLine = 0;
            this.offsetInLineToDisplay = 0;
            this.column = 0;
            moveRight(x2);
        }

        public int getDisplayedCursor() {
            return computeCursorPosition(Nano.this.printLineNumbers ? 8 : 0, Nano.this.size.getColumns() + 1);
        }

        private int computeCursorPosition(int cursor, int rwidth) {
            int cur = this.firstLineToDisplay;
            int off = this.offsetInLineToDisplay;
            while (true) {
                if (cur >= this.line && off >= this.offsetInLine) {
                    break;
                } else if (!Nano.this.wrapping) {
                    cursor += rwidth;
                    cur++;
                } else {
                    cursor += rwidth;
                    Optional<Integer> next = nextLineOffset(cur, off);
                    if (next.isPresent()) {
                        off = next.get().intValue();
                    } else {
                        cur++;
                        off = 0;
                    }
                }
            }
            if (cur == this.line) {
                if (!Nano.this.wrapping && this.column > this.firstColumnToDisplay + width()) {
                    while (this.column > this.firstColumnToDisplay + width()) {
                        this.firstColumnToDisplay += width();
                    }
                }
                return cursor + (this.column - this.firstColumnToDisplay) + (this.firstColumnToDisplay > 0 ? 1 : 0);
            }
            throw new IllegalStateException();
        }

        char getCurrentChar() {
            String str = this.lines.get(this.line);
            if (this.column + this.offsetInLine < str.length()) {
                return str.charAt(this.column + this.offsetInLine);
            }
            if (this.line < this.lines.size() - 1) {
                return '\n';
            }
            return 0;
        }

        public void prevWord() {
            while (Character.isAlphabetic(getCurrentChar()) && moveLeft(1)) {
            }
            while (!Character.isAlphabetic(getCurrentChar()) && moveLeft(1)) {
            }
            while (Character.isAlphabetic(getCurrentChar()) && moveLeft(1)) {
            }
            moveRight(1);
        }

        public void nextWord() {
            while (Character.isAlphabetic(getCurrentChar()) && moveRight(1)) {
            }
            while (!Character.isAlphabetic(getCurrentChar()) && moveRight(1)) {
            }
        }

        public void beginningOfLine() {
            this.offsetInLine = 0;
            this.column = 0;
            this.wantedColumn = 0;
            ensureCursorVisible();
        }

        public void endOfLine() {
            moveRight(length(this.lines.get(this.line)), true);
        }

        public void prevPage() {
            scrollUp(((Nano.this.size.getRows() - computeHeader().size()) - Nano.this.computeFooter().size()) - 2);
            this.column = 0;
            this.firstLineToDisplay = this.line;
            this.offsetInLineToDisplay = this.offsetInLine;
        }

        public void nextPage() {
            scrollDown(((Nano.this.size.getRows() - computeHeader().size()) - Nano.this.computeFooter().size()) - 2);
            this.column = 0;
            this.firstLineToDisplay = this.line;
            this.offsetInLineToDisplay = this.offsetInLine;
        }

        public void scrollUp(int lines) {
            cursorUp(lines);
            moveDisplayUp(lines);
        }

        public void scrollDown(int lines) {
            cursorDown(lines);
            moveDisplayDown(lines);
        }

        public void firstLine() {
            this.line = 0;
            this.column = 0;
            this.offsetInLine = 0;
            ensureCursorVisible();
        }

        public void lastLine() {
            this.line = this.lines.size() - 1;
            this.column = 0;
            this.offsetInLine = 0;
            ensureCursorVisible();
        }

        boolean nextSearch() {
            boolean out = false;
            if (Nano.this.searchTerm == null) {
                Nano.this.setMessage("No current search pattern");
                return false;
            }
            Nano.this.setMessage(null);
            int cur = this.line;
            int dir = Nano.this.searchBackwards ? -1 : 1;
            int newPos = -1;
            int newLine = -1;
            List<Integer> curRes = doSearch(this.lines.get(this.line));
            if (Nano.this.searchBackwards) {
                Collections.reverse(curRes);
            }
            for (Integer num : curRes) {
                int r = num.intValue();
                if (Nano.this.searchBackwards) {
                    if (r < this.offsetInLine + this.column) {
                        newPos = r;
                        newLine = this.line;
                        break;
                    }
                } else if (r > this.offsetInLine + this.column) {
                    newPos = r;
                    newLine = this.line;
                    break;
                }
            }
            if (newPos < 0) {
                while (true) {
                    cur = ((cur + dir) + this.lines.size()) % this.lines.size();
                    if (cur == this.line) {
                        break;
                    }
                    List<Integer> res = doSearch(this.lines.get(cur));
                    if (!res.isEmpty()) {
                        newPos = (Nano.this.searchBackwards ? res.get(res.size() - 1) : res.get(0)).intValue();
                        newLine = cur;
                    }
                }
            }
            if (newPos < 0 && !curRes.isEmpty()) {
                newPos = curRes.get(0).intValue();
                newLine = this.line;
            }
            if (newPos < 0) {
                Nano.this.setMessage("\"" + Nano.this.searchTerm + "\" not found");
            } else if (newLine == this.line && newPos == this.offsetInLine + this.column) {
                Nano.this.setMessage("This is the only occurence");
                return false;
            } else {
                if ((Nano.this.searchBackwards && (newLine > this.line || (newLine == this.line && newPos > this.offsetInLine + this.column))) || (!Nano.this.searchBackwards && (newLine < this.line || (newLine == this.line && newPos < this.offsetInLine + this.column)))) {
                    Nano.this.setMessage("Search Wrapped");
                }
                this.line = newLine;
                moveRight(newPos, true);
                out = true;
            }
            return out;
        }

        private List<Integer> doSearch(String text) {
            Matcher m = Pattern.compile(Nano.this.searchTerm, (Nano.this.searchCaseSensitive ? 0 : 66) | (Nano.this.searchRegexp ? 0 : 16)).matcher(text);
            List<Integer> res = new ArrayList<>();
            while (m.find()) {
                res.add(Integer.valueOf(m.start()));
                Nano.this.matchedLength = m.group(0).length();
            }
            return res;
        }

        protected int[] highlightStart() {
            int[] out = {-1, -1};
            if (Nano.this.mark) {
                out = getMarkStart();
            } else if (Nano.this.searchToReplace) {
                out[0] = this.line;
                out[1] = this.offsetInLine + this.column;
            }
            return out;
        }

        protected int[] highlightEnd() {
            int[] out = {-1, -1};
            if (Nano.this.mark) {
                out = getMarkEnd();
            } else if (Nano.this.searchToReplace && Nano.this.matchedLength > 0) {
                out[0] = this.line;
                int col = charPosition(this.offsetInLine + this.column) + Nano.this.matchedLength;
                if (col < this.lines.get(this.line).length()) {
                    out[1] = length(this.lines.get(this.line).substring(0, col));
                } else {
                    out[1] = length(this.lines.get(this.line));
                }
            }
            return out;
        }

        public void matching() {
            int opening = getCurrentChar();
            int idx = Nano.this.matchBrackets.indexOf(opening);
            if (idx >= 0) {
                int dir = idx >= Nano.this.matchBrackets.length() / 2 ? -1 : 1;
                int closing = Nano.this.matchBrackets.charAt((idx + (Nano.this.matchBrackets.length() / 2)) % Nano.this.matchBrackets.length());
                int lvl = 1;
                int cur = this.line;
                int pos = this.offsetInLine + this.column;
                while (true) {
                    if (pos + dir >= 0 && pos + dir < getLine(cur).length()) {
                        pos += dir;
                    } else if (cur + dir < 0 || cur + dir >= this.lines.size()) {
                        break;
                    } else {
                        cur += dir;
                        pos = dir > 0 ? 0 : this.lines.get(cur).length() - 1;
                        if (pos >= 0 && pos < this.lines.get(cur).length()) {
                        }
                    }
                    int c = this.lines.get(cur).charAt(pos);
                    if (c == opening) {
                        lvl++;
                    } else if (c == closing) {
                        lvl--;
                        if (lvl == 0) {
                            this.line = cur;
                            moveToChar(pos);
                            ensureCursorVisible();
                            return;
                        }
                    } else {
                        continue;
                    }
                }
                Nano.this.setMessage("No matching bracket");
                return;
            }
            Nano.this.setMessage("Not a bracket");
        }

        /* access modifiers changed from: private */
        public int length(String line) {
            return new AttributedStringBuilder().tabs(Nano.this.tabs).append((CharSequence) line).columnLength();
        }

        void copy() {
            if (this.uncut || Nano.this.cut2end || Nano.this.mark) {
                Nano.this.cutbuffer = new ArrayList();
            }
            if (Nano.this.mark) {
                int[] s = getMarkStart();
                int[] e = getMarkEnd();
                if (s[0] == e[0]) {
                    Nano.this.cutbuffer.add(this.lines.get(s[0]).substring(charPosition(s[0], s[1]), charPosition(e[0], e[1])));
                } else {
                    if (s[1] != 0) {
                        Nano.this.cutbuffer.add(this.lines.get(s[0]).substring(charPosition(s[0], s[1])));
                        s[0] = s[0] + 1;
                    }
                    for (int i = s[0]; i < e[0]; i++) {
                        Nano.this.cutbuffer.add(this.lines.get(i));
                    }
                    if (e[1] != 0) {
                        Nano.this.cutbuffer.add(this.lines.get(e[0]).substring(0, charPosition(e[0], e[1])));
                    }
                }
                Nano.this.mark = false;
                mark();
            } else if (Nano.this.cut2end) {
                String l = this.lines.get(this.line);
                int col = charPosition(this.offsetInLine + this.column);
                Nano.this.cutbuffer.add(l.substring(col));
                moveRight(l.substring(col).length());
            } else {
                Nano.this.cutbuffer.add(this.lines.get(this.line));
                cursorDown(1);
            }
            this.uncut = false;
        }

        void cut() {
            cut(false);
        }

        void cut(boolean toEnd) {
            if (this.lines.size() > 1) {
                if (this.uncut || Nano.this.cut2end || toEnd || Nano.this.mark) {
                    Nano.this.cutbuffer = new ArrayList();
                }
                if (Nano.this.mark) {
                    int[] s = getMarkStart();
                    int[] e = getMarkEnd();
                    if (s[0] == e[0]) {
                        String l = this.lines.get(s[0]);
                        int cols = charPosition(s[0], s[1]);
                        int cole = charPosition(e[0], e[1]);
                        Nano.this.cutbuffer.add(l.substring(cols, cole));
                        this.lines.set(s[0], l.substring(0, cols) + l.substring(cole));
                        computeAllOffsets();
                        moveRight(cols, true);
                    } else {
                        int ls = s[0];
                        int cs = charPosition(s[0], s[1]);
                        if (s[1] != 0) {
                            String l2 = this.lines.get(s[0]);
                            Nano.this.cutbuffer.add(l2.substring(cs));
                            this.lines.set(s[0], l2.substring(0, cs));
                            s[0] = s[0] + 1;
                        }
                        for (int i = s[0]; i < e[0]; i++) {
                            Nano.this.cutbuffer.add(this.lines.get(s[0]));
                            this.lines.remove(s[0]);
                        }
                        if (e[1] != 0) {
                            String l3 = this.lines.get(s[0]);
                            int col = charPosition(e[0], e[1]);
                            Nano.this.cutbuffer.add(l3.substring(0, col));
                            this.lines.set(s[0], l3.substring(col));
                        }
                        computeAllOffsets();
                        gotoLine(cs, ls);
                    }
                    Nano.this.mark = false;
                    mark();
                } else if (Nano.this.cut2end || toEnd) {
                    String l4 = this.lines.get(this.line);
                    int col2 = charPosition(this.offsetInLine + this.column);
                    Nano.this.cutbuffer.add(l4.substring(col2));
                    this.lines.set(this.line, l4.substring(0, col2));
                    if (toEnd) {
                        this.line++;
                        do {
                            Nano.this.cutbuffer.add(this.lines.get(this.line));
                            this.lines.remove(this.line);
                        } while (this.line <= this.lines.size() - 1);
                        this.line--;
                    }
                } else {
                    Nano.this.cutbuffer.add(this.lines.get(this.line));
                    this.lines.remove(this.line);
                    this.offsetInLine = 0;
                    if (this.line > this.lines.size() - 1) {
                        this.line--;
                    }
                }
                Nano.this.display.clear();
                computeAllOffsets();
                this.dirty = true;
                this.uncut = false;
            }
        }

        void uncut() {
            if (!Nano.this.cutbuffer.isEmpty()) {
                String l = this.lines.get(this.line);
                int col = charPosition(this.offsetInLine + this.column);
                if (Nano.this.cut2end) {
                    this.lines.set(this.line, l.substring(0, col) + Nano.this.cutbuffer.get(0) + l.substring(col));
                    computeAllOffsets();
                    moveRight(col + Nano.this.cutbuffer.get(0).length(), true);
                } else if (col == 0) {
                    this.lines.addAll(this.line, Nano.this.cutbuffer);
                    computeAllOffsets();
                    if (Nano.this.cutbuffer.size() > 1) {
                        gotoLine(Nano.this.cutbuffer.get(Nano.this.cutbuffer.size() - 1).length(), this.line + Nano.this.cutbuffer.size());
                    } else {
                        moveRight(Nano.this.cutbuffer.get(0).length(), true);
                    }
                } else {
                    int gotol = this.line;
                    if (Nano.this.cutbuffer.size() == 1) {
                        this.lines.set(this.line, l.substring(0, col) + Nano.this.cutbuffer.get(0) + l.substring(col));
                    } else {
                        List<String> list = this.lines;
                        int i = this.line;
                        this.line = i + 1;
                        list.set(i, l.substring(0, col) + Nano.this.cutbuffer.get(0));
                        gotol = this.line;
                        this.lines.add(this.line, Nano.this.cutbuffer.get(Nano.this.cutbuffer.size() - 1) + l.substring(col));
                        for (int i2 = Nano.this.cutbuffer.size() - 2; i2 > 0; i2--) {
                            gotol++;
                            this.lines.add(this.line, Nano.this.cutbuffer.get(i2));
                        }
                    }
                    computeAllOffsets();
                    if (Nano.this.cutbuffer.size() > 1) {
                        gotoLine(Nano.this.cutbuffer.get(Nano.this.cutbuffer.size() - 1).length(), gotol);
                    } else {
                        moveRight(col + Nano.this.cutbuffer.get(0).length(), true);
                    }
                }
                Nano.this.display.clear();
                this.dirty = true;
                this.uncut = true;
            }
        }

        void mark() {
            if (Nano.this.mark) {
                this.markPos[0] = this.line;
                this.markPos[1] = this.offsetInLine + this.column;
                return;
            }
            this.markPos[0] = -1;
            this.markPos[1] = -1;
        }

        int[] getMarkStart() {
            int[] out = {-1, -1};
            if (!Nano.this.mark) {
                return out;
            }
            if (this.markPos[0] > this.line || (this.markPos[0] == this.line && this.markPos[1] > this.offsetInLine + this.column)) {
                out[0] = this.line;
                out[1] = this.offsetInLine + this.column;
            } else {
                out = this.markPos;
            }
            return out;
        }

        int[] getMarkEnd() {
            int[] out = {-1, -1};
            if (!Nano.this.mark) {
                return out;
            }
            if (this.markPos[0] > this.line || (this.markPos[0] == this.line && this.markPos[1] > this.offsetInLine + this.column)) {
                out = this.markPos;
            } else {
                out[0] = this.line;
                out[1] = this.offsetInLine + this.column;
            }
            return out;
        }

        void replaceFromCursor(int chars, String string) {
            int pos = charPosition(this.offsetInLine + this.column);
            String text = this.lines.get(this.line);
            String mod = text.substring(0, pos) + string;
            if (chars + pos < text.length()) {
                mod = mod + text.substring(chars + pos);
            }
            this.lines.set(this.line, mod);
            this.dirty = true;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$SyntaxHighlighter.class */
    public static class SyntaxHighlighter {
        private boolean startEndHighlight;
        private final List<HighlightRule> rules = new ArrayList();
        private int ruleStartId = 0;

        private SyntaxHighlighter() {
        }

        /* access modifiers changed from: protected */
        public static SyntaxHighlighter build(List<Path> syntaxFiles, String file, String syntaxName) {
            return build(syntaxFiles, file, syntaxName, false);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
            if (r8.equals("none") == false) goto L_0x0023;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static org.jline.builtins.Nano.SyntaxHighlighter build(java.util.List<java.nio.file.Path> r6, java.lang.String r7, java.lang.String r8, boolean r9) {
            /*
                org.jline.builtins.Nano$SyntaxHighlighter r0 = new org.jline.builtins.Nano$SyntaxHighlighter
                r1 = r0
                r1.<init>()
                r10 = r0
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = r0
                r1.<init>()
                r11 = r0
                r0 = r8
                if (r0 == 0) goto L_0x0023
                r0 = r8
                if (r0 == 0) goto L_0x008c
                r0 = r8
                java.lang.String r1 = "none"
                boolean r0 = r0.equals(r1)     // Catch: PatternSyntaxException -> 0x008f
                if (r0 != 0) goto L_0x008c
            L_0x0023:
                r0 = r6
                java.util.Iterator r0 = r0.iterator()     // Catch: PatternSyntaxException -> 0x008f
                r12 = r0
            L_0x002b:
                r0 = r12
                boolean r0 = r0.hasNext()     // Catch: PatternSyntaxException -> 0x008f
                if (r0 == 0) goto L_0x0085
                r0 = r12
                java.lang.Object r0 = r0.next()     // Catch: PatternSyntaxException -> 0x008f
                java.nio.file.Path r0 = (java.nio.file.Path) r0     // Catch: PatternSyntaxException -> 0x008f
                r13 = r0
                org.jline.builtins.Nano$NanorcParser r0 = new org.jline.builtins.Nano$NanorcParser     // Catch: IOException -> 0x0080, PatternSyntaxException -> 0x008f
                r1 = r0
                r2 = r13
                r3 = r8
                r4 = r7
                r1.<init>(r2, r3, r4)     // Catch: IOException -> 0x0080, PatternSyntaxException -> 0x008f
                r14 = r0
                r0 = r14
                r0.parse()     // Catch: IOException -> 0x0080, PatternSyntaxException -> 0x008f
                r0 = r14
                boolean r0 = r0.matches()     // Catch: IOException -> 0x0080, PatternSyntaxException -> 0x008f
                if (r0 == 0) goto L_0x0068
                r0 = r10
                r1 = r14
                java.util.List r1 = r1.getHighlightRules()     // Catch: IOException -> 0x0080, PatternSyntaxException -> 0x008f
                r0.addRules(r1)     // Catch: IOException -> 0x0080, PatternSyntaxException -> 0x008f
                r0 = r10
                return r0
            L_0x0068:
                r0 = r14
                boolean r0 = r0.isDefault()     // Catch: PatternSyntaxException -> 0x008f, IOException -> 0x0080
                if (r0 == 0) goto L_0x007d
                r0 = r11
                r1 = r14
                java.util.List r1 = r1.getHighlightRules()     // Catch: PatternSyntaxException -> 0x008f, IOException -> 0x0080
                boolean r0 = r0.addAll(r1)     // Catch: PatternSyntaxException -> 0x008f, IOException -> 0x0080
            L_0x007d:
                goto L_0x0082
            L_0x0080:
                r14 = move-exception
            L_0x0082:
                goto L_0x002b
            L_0x0085:
                r0 = r10
                r1 = r11
                r0.addRules(r1)     // Catch: PatternSyntaxException -> 0x008f
            L_0x008c:
                goto L_0x0098
            L_0x008f:
                r12 = move-exception
                r0 = r9
                if (r0 != 0) goto L_0x0098
                r0 = r12
                throw r0
            L_0x0098:
                r0 = r10
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.Nano.SyntaxHighlighter.build(java.util.List, java.lang.String, java.lang.String, boolean):org.jline.builtins.Nano$SyntaxHighlighter");
        }

        public static SyntaxHighlighter build(Path nanorc, String syntaxName) {
            SyntaxHighlighter out = new SyntaxHighlighter();
            List<Path> syntaxFiles = new ArrayList<>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(nanorc.toFile()));
                for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    String line2 = line.trim();
                    if (line2.length() > 0 && !line2.startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
                        List<String> parts = Parser.split(line2);
                        if (parts.get(0).equals(Printer.INCLUDE)) {
                            if (parts.get(1).contains("*") || parts.get(1).contains("?")) {
                                PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + parts.get(1));
                                Stream<Path> find = Files.find(Paths.get(new File(parts.get(1)).getParent(), new String[0]), Integer.MAX_VALUE, path, f -> {
                                    return pathMatcher.matches(path);
                                }, new FileVisitOption[0]);
                                Objects.requireNonNull(syntaxFiles);
                                find.forEach((v1) -> {
                                    r1.add(v1);
                                });
                            } else {
                                syntaxFiles.add(Paths.get(parts.get(1), new String[0]));
                            }
                        }
                    }
                }
                reader.close();
                out = build(syntaxFiles, null, syntaxName);
            } catch (Exception e) {
            }
            return out;
        }

        public static SyntaxHighlighter build(String nanorcUrl) {
            InputStream inputStream;
            SyntaxHighlighter out = new SyntaxHighlighter();
            try {
                if (nanorcUrl.startsWith(LocationUtil.CLASSPATH_SCHEME)) {
                    inputStream = new Source.ResourceSource(nanorcUrl.substring(10), null).read();
                } else {
                    inputStream = new Source.URLSource(new URL(nanorcUrl), null).read();
                }
                NanorcParser parser = new NanorcParser(inputStream, (String) null, (String) null);
                parser.parse();
                out.addRules(parser.getHighlightRules());
            } catch (IOException e) {
            }
            return out;
        }

        private void addRules(List<HighlightRule> rules) {
            this.rules.addAll(rules);
        }

        public void reset() {
            this.ruleStartId = 0;
            this.startEndHighlight = false;
        }

        public AttributedString highlight(String string) {
            return highlight(new AttributedString(string));
        }

        public AttributedString highlight(AttributedStringBuilder asb) {
            return highlight(asb.toAttributedString());
        }

        public AttributedString highlight(AttributedString line) {
            if (this.rules.isEmpty()) {
                return line;
            }
            AttributedStringBuilder asb = new AttributedStringBuilder();
            asb.append(line);
            int startId = this.ruleStartId;
            boolean endHighlight = this.startEndHighlight;
            int i = startId;
            while (true) {
                if (i >= (endHighlight ? startId + 1 : this.rules.size())) {
                    return asb.toAttributedString();
                }
                HighlightRule rule = this.rules.get(i);
                switch (rule.getType()) {
                    case PATTERN:
                        asb.styleMatches(rule.getPattern(), rule.getStyle());
                        break;
                    case START_END:
                        boolean done = false;
                        Matcher start = rule.getStart().matcher(asb.toAttributedString());
                        Matcher end = rule.getEnd().matcher(asb.toAttributedString());
                        while (!done) {
                            AttributedStringBuilder a = new AttributedStringBuilder();
                            if (this.startEndHighlight && this.ruleStartId == i) {
                                if (end.find()) {
                                    a.append(asb.columnSubSequence(0, end.end()), rule.getStyle());
                                    a.append(asb.columnSubSequence(end.end(), asb.length()));
                                    this.ruleStartId = 0;
                                    this.startEndHighlight = false;
                                } else {
                                    a.append(asb, rule.getStyle());
                                    done = true;
                                }
                                asb = a;
                            } else if (start.find()) {
                                a.append(asb.columnSubSequence(0, start.start()));
                                if (end.find()) {
                                    a.append(asb.columnSubSequence(start.start(), end.end()), rule.getStyle());
                                    a.append(asb.columnSubSequence(end.end(), asb.length()));
                                } else {
                                    this.ruleStartId = i;
                                    this.startEndHighlight = true;
                                    a.append(asb.columnSubSequence(start.start(), asb.length()), rule.getStyle());
                                    done = true;
                                }
                                asb = a;
                            } else {
                                done = true;
                            }
                        }
                        break;
                }
                i++;
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$HighlightRule.class */
    public static class HighlightRule {
        private final RuleType type;
        private Pattern pattern;
        private final AttributedStyle style;
        private Pattern start;
        private Pattern end;

        /* loaded from: grasscutter.jar:org/jline/builtins/Nano$HighlightRule$RuleType.class */
        public enum RuleType {
            PATTERN,
            START_END
        }

        public HighlightRule(AttributedStyle style, Pattern pattern) {
            this.type = RuleType.PATTERN;
            this.pattern = pattern;
            this.style = style;
        }

        public HighlightRule(AttributedStyle style, Pattern start, Pattern end) {
            this.type = RuleType.START_END;
            this.style = style;
            this.start = start;
            this.end = end;
        }

        public RuleType getType() {
            return this.type;
        }

        public AttributedStyle getStyle() {
            return this.style;
        }

        public Pattern getPattern() {
            if (this.type != RuleType.START_END) {
                return this.pattern;
            }
            throw new IllegalAccessError();
        }

        public Pattern getStart() {
            if (this.type != RuleType.PATTERN) {
                return this.start;
            }
            throw new IllegalAccessError();
        }

        public Pattern getEnd() {
            if (this.type != RuleType.PATTERN) {
                return this.end;
            }
            throw new IllegalAccessError();
        }

        public static RuleType evalRuleType(List<String> colorCfg) {
            RuleType out = null;
            if (colorCfg.get(0).equals("color") || colorCfg.get(0).equals("icolor")) {
                out = RuleType.PATTERN;
                if (colorCfg.size() == 4 && colorCfg.get(2).startsWith("start=") && colorCfg.get(3).startsWith("end=")) {
                    out = RuleType.START_END;
                }
            }
            return out;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$NanorcParser.class */
    public static class NanorcParser {
        private static final String DEFAULT_SYNTAX = "default";
        private final String name;
        private final String target;
        private final List<HighlightRule> highlightRules;
        private final BufferedReader reader;
        private boolean matches;
        private String syntaxName;

        public NanorcParser(Path file, String name, String target) throws IOException {
            this(new Source.PathSource(file, (String) null).read(), name, target);
        }

        public NanorcParser(InputStream in, String name, String target) {
            this.highlightRules = new ArrayList();
            this.matches = false;
            this.syntaxName = "unknown";
            this.reader = new BufferedReader(new InputStreamReader(in));
            this.name = name;
            this.target = target;
        }

        public void parse() throws IOException {
            int idx = 0;
            while (true) {
                String line = this.reader.readLine();
                if (line == null) {
                    break;
                }
                idx++;
                String line2 = line.trim();
                if (line2.length() > 0 && !line2.startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
                    List<String> parts = Parser.split(line2.replaceAll("\\\\<", "\\\\b").replaceAll("\\\\>", "\\\\b").replaceAll("\\[:alnum:]", "\\\\p{Alnum}").replaceAll("\\[:alpha:]", "\\\\p{Alpha}").replaceAll("\\[:blank:]", "\\\\p{Blank}").replaceAll("\\[:cntrl:]", "\\\\p{Cntrl}").replaceAll("\\[:digit:]", "\\\\p{Digit}").replaceAll("\\[:graph:]", "\\\\p{Graph}").replaceAll("\\[:lower:]", "\\\\p{Lower}").replaceAll("\\[:print:]", "\\\\p{Print}").replaceAll("\\[:punct:]", "\\\\p{Punct}").replaceAll("\\[:space:]", "\\\\s").replaceAll("\\[:upper:]", "\\\\p{Upper}").replaceAll("\\[:xdigit:]", "\\\\p{XDigit}"));
                    if (parts.get(0).equals("syntax")) {
                        this.syntaxName = parts.get(1);
                        List<Pattern> filePatterns = new ArrayList<>();
                        if (this.name != null) {
                            if (!this.name.equals(this.syntaxName)) {
                                break;
                            }
                            this.matches = true;
                        } else if (this.target != null) {
                            for (int i = 2; i < parts.size(); i++) {
                                filePatterns.add(Pattern.compile(parts.get(i)));
                            }
                            Iterator<Pattern> it = filePatterns.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (it.next().matcher(this.target).find()) {
                                        this.matches = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (!this.matches && !this.syntaxName.equals("default")) {
                                break;
                            }
                        } else {
                            this.matches = true;
                        }
                    } else if (parts.get(0).equals("color")) {
                        addHighlightRule(this.syntaxName + idx, parts, false);
                    } else if (parts.get(0).equals("icolor")) {
                        addHighlightRule(this.syntaxName + idx, parts, true);
                    }
                }
            }
            this.reader.close();
        }

        public boolean matches() {
            return this.matches;
        }

        public List<HighlightRule> getHighlightRules() {
            return this.highlightRules;
        }

        public boolean isDefault() {
            return this.syntaxName.equals("default");
        }

        private void addHighlightRule(String reference, List<String> parts, boolean caseInsensitive) {
            Map<String, String> spec = new HashMap<>();
            spec.put(reference, parts.get(1));
            Styles.StyleCompiler sh = new Styles.StyleCompiler(spec, true);
            Objects.requireNonNull(sh);
            AttributedStyle style = new StyleResolver(this::getStyle).resolve(Mapper.IGNORED_FIELDNAME + reference);
            if (HighlightRule.evalRuleType(parts) == HighlightRule.RuleType.PATTERN) {
                for (int i = 2; i < parts.size(); i++) {
                    this.highlightRules.add(new HighlightRule(style, doPattern(parts.get(i), caseInsensitive)));
                }
            } else if (HighlightRule.evalRuleType(parts) == HighlightRule.RuleType.START_END) {
                String s = parts.get(2);
                String e = parts.get(3);
                this.highlightRules.add(new HighlightRule(style, doPattern(s.substring(7, s.length() - 1), caseInsensitive), doPattern(e.substring(5, e.length() - 1), caseInsensitive)));
            }
        }

        private Pattern doPattern(String regex, boolean caseInsensitive) {
            return caseInsensitive ? Pattern.compile(regex, 2) : Pattern.compile(regex);
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$Parser.class */
    public static class Parser {
        protected Parser() {
        }

        /* access modifiers changed from: protected */
        public static List<String> split(String s) {
            List<String> out = new ArrayList<>();
            if (s.length() == 0) {
                return out;
            }
            int depth = 0;
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == '\"') {
                    if (depth == 0) {
                        depth = 1;
                    } else {
                        if ((i < s.length() - 1 ? s.charAt(i + 1) : ' ') == ' ') {
                            depth = 0;
                        }
                    }
                } else if (c == ' ' && depth == 0 && sb.length() > 0) {
                    out.add(stripQuotes(sb.toString()));
                    sb = new StringBuilder();
                    i++;
                }
                if (sb.length() > 0 || !(c == ' ' || c == '\t')) {
                    sb.append(c);
                }
                i++;
            }
            if (sb.length() > 0) {
                out.add(stripQuotes(sb.toString()));
            }
            return out;
        }

        private static String stripQuotes(String s) {
            String out = s.trim();
            if (s.startsWith("\"") && s.endsWith("\"")) {
                out = s.substring(1, s.length() - 1);
            }
            return out;
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Nano$PatternHistory.class */
    public static class PatternHistory {
        private final Path historyFile;
        private final int size = 100;
        private List<String> patterns = new ArrayList();
        private int patternId = -1;
        private boolean lastMoveUp = false;

        public PatternHistory(Path historyFile) {
            this.historyFile = historyFile;
            load();
        }

        /* renamed from: up */
        public String m30up(String hint) {
            String out = hint;
            if (this.patterns.size() > 0 && this.patternId < this.patterns.size()) {
                if (!this.lastMoveUp && this.patternId > 0 && this.patternId < this.patterns.size() - 1) {
                    this.patternId++;
                }
                if (this.patternId < 0) {
                    this.patternId = 0;
                }
                boolean found = false;
                for (int pid = this.patternId; pid < this.patterns.size(); pid++) {
                    if (hint.length() == 0 || this.patterns.get(pid).startsWith(hint)) {
                        this.patternId = pid + 1;
                        out = this.patterns.get(pid);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    this.patternId = this.patterns.size();
                }
            }
            this.lastMoveUp = true;
            return out;
        }

        public String down(String hint) {
            String out = hint;
            if (this.patterns.size() > 0) {
                if (this.lastMoveUp) {
                    this.patternId--;
                }
                if (this.patternId < 0) {
                    this.patternId = -1;
                } else {
                    boolean found = false;
                    for (int pid = this.patternId; pid >= 0; pid--) {
                        if (hint.length() == 0 || this.patterns.get(pid).startsWith(hint)) {
                            this.patternId = pid - 1;
                            out = this.patterns.get(pid);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        this.patternId = -1;
                    }
                }
            }
            this.lastMoveUp = false;
            return out;
        }

        public void add(String pattern) {
            if (pattern.trim().length() != 0) {
                this.patterns.remove(pattern);
                if (this.patterns.size() > 100) {
                    this.patterns.remove(this.patterns.size() - 1);
                }
                this.patterns.add(0, pattern);
                this.patternId = -1;
            }
        }

        public void persist() {
            if (this.historyFile != null) {
                try {
                    BufferedWriter writer = Files.newBufferedWriter(this.historyFile.toAbsolutePath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
                    for (String s : this.patterns) {
                        if (s.trim().length() > 0) {
                            writer.append((CharSequence) s);
                            writer.newLine();
                        }
                    }
                    if (writer != null) {
                        writer.close();
                    }
                } catch (Exception e) {
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:11:0x0043
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        private void load() {
            /*
                r4 = this;
                r0 = r4
                java.nio.file.Path r0 = r0.historyFile
                if (r0 != 0) goto L_0x0008
                return
            L_0x0008:
                r0 = r4
                java.nio.file.Path r0 = r0.historyFile     // Catch: Exception -> 0x005a
                r1 = 0
                java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r1]     // Catch: Exception -> 0x005a
                boolean r0 = java.nio.file.Files.exists(r0, r1)     // Catch: Exception -> 0x005a
                if (r0 == 0) goto L_0x0057
                r0 = r4
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch: Exception -> 0x005a
                r2 = r1
                r2.<init>()     // Catch: Exception -> 0x005a
                r0.patterns = r1     // Catch: Exception -> 0x005a
                r0 = r4
                java.nio.file.Path r0 = r0.historyFile     // Catch: Exception -> 0x005a
                java.io.BufferedReader r0 = java.nio.file.Files.newBufferedReader(r0)     // Catch: Exception -> 0x005a
                r5 = r0
                r0 = r5
                java.util.stream.Stream r0 = r0.lines()     // Catch: Exception -> 0x005a, Throwable -> 0x0043
                r1 = r4
                void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                    r1.lambda$load$0(v1);
                }     // Catch: Exception -> 0x005a, Throwable -> 0x0043
                r0.forEach(r1)     // Catch: Exception -> 0x005a, Throwable -> 0x0043
                r0 = r5
                if (r0 == 0) goto L_0x0057
                r0 = r5
                r0.close()     // Catch: Exception -> 0x005a
                goto L_0x0057
            L_0x0043:
                r6 = move-exception
                r0 = r5
                if (r0 == 0) goto L_0x0055
                r0 = r5
                r0.close()     // Catch: Throwable -> 0x004f, Exception -> 0x005a
                goto L_0x0055
            L_0x004f:
                r7 = move-exception
                r0 = r6
                r1 = r7
                r0.addSuppressed(r1)     // Catch: Exception -> 0x005a
            L_0x0055:
                r0 = r6
                throw r0     // Catch: Exception -> 0x005a
            L_0x0057:
                goto L_0x005b
            L_0x005a:
                r5 = move-exception
            L_0x005b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.Nano.PatternHistory.load():void");
        }
    }

    public Nano(Terminal terminal, File root) {
        this(terminal, root.toPath());
    }

    public Nano(Terminal terminal, Path root) {
        this(terminal, root, null);
    }

    public Nano(Terminal terminal, Path root, Options opts) {
        this(terminal, root, opts, null);
    }

    public Nano(Terminal terminal, Path root, Options opts, ConfigurationPath configPath) {
        this.syntaxFiles = new ArrayList();
        this.title = "JLine Nano 3.0.0";
        this.printLineNumbers = false;
        this.wrapping = false;
        this.smoothScrolling = true;
        this.mouseSupport = false;
        this.oneMoreLine = true;
        this.constantCursor = false;
        this.quickBlank = false;
        this.tabs = 4;
        this.brackets = "\"’)>]}";
        this.matchBrackets = "(<[{)>]}";
        this.punct = "!.?";
        this.quoteStr = "^([ \\t]*[#:>\\|}])+";
        this.restricted = false;
        this.writeBackup = false;
        this.atBlanks = false;
        this.view = false;
        this.cut2end = false;
        this.tempFile = false;
        this.historyLog = null;
        this.tabsToSpaces = false;
        this.autoIndent = false;
        this.buffers = new ArrayList();
        this.errorMessage = null;
        this.nbBindings = 0;
        this.editBuffer = new StringBuilder();
        this.matchedLength = -1;
        this.patternHistory = new PatternHistory(null);
        this.writeMode = WriteMode.WRITE;
        this.cutbuffer = new ArrayList();
        this.mark = false;
        this.highlight = true;
        this.searchToReplace = false;
        this.readNewBuffer = true;
        this.terminal = terminal;
        this.windowsTerminal = terminal.getClass().getSimpleName().endsWith("WinSysTerminal");
        this.root = root;
        this.display = new Display(terminal, true);
        this.bindingReader = new BindingReader(terminal.reader());
        this.size = new Size();
        Attributes attrs = terminal.getAttributes();
        this.vsusp = attrs.getControlChar(Attributes.ControlChar.VSUSP);
        if (this.vsusp > 0) {
            attrs.setControlChar(Attributes.ControlChar.VSUSP, 0);
            terminal.setAttributes(attrs);
        }
        Path nanorc = configPath != null ? configPath.getConfig("jnanorc") : null;
        boolean ignorercfiles = opts != null && opts.isSet("ignorercfiles");
        if (nanorc != null && !ignorercfiles) {
            try {
                parseConfig(nanorc);
            } catch (IOException e) {
                this.errorMessage = "Encountered error while reading config file: " + nanorc;
            }
        } else if (new File("/usr/share/nano").exists() && !ignorercfiles) {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:/usr/share/nano/*.nanorc");
            try {
                Stream<Path> find = Files.find(Paths.get("/usr/share/nano", new String[0]), Integer.MAX_VALUE, path, f -> {
                    return pathMatcher.matches(path);
                }, new FileVisitOption[0]);
                List<Path> list = this.syntaxFiles;
                Objects.requireNonNull(list);
                find.forEach((v1) -> {
                    r1.add(v1);
                });
                this.nanorcIgnoreErrors = true;
            } catch (IOException e2) {
                this.errorMessage = "Encountered error while reading nanorc files";
            }
        }
        if (opts != null) {
            this.restricted = opts.isSet("restricted");
            this.syntaxName = null;
            if (opts.isSet("syntax")) {
                this.syntaxName = opts.get("syntax");
                this.nanorcIgnoreErrors = false;
            }
            if (opts.isSet("backup")) {
                this.writeBackup = true;
            }
            if (opts.isSet("quotestr")) {
                this.quoteStr = opts.get("quotestr");
            }
            if (opts.isSet("tabsize")) {
                this.tabs = opts.getNumber("tabsize");
            }
            if (opts.isSet("quickblank")) {
                this.quickBlank = true;
            }
            if (opts.isSet("constantshow")) {
                this.constantCursor = true;
            }
            if (opts.isSet("emptyline")) {
                this.oneMoreLine = false;
            }
            if (opts.isSet("jumpyscrolling")) {
                this.smoothScrolling = false;
            }
            if (opts.isSet("linenumbers")) {
                this.printLineNumbers = true;
            }
            if (opts.isSet(LineReader.MOUSE)) {
                this.mouseSupport = true;
            }
            if (opts.isSet("softwrap")) {
                this.wrapping = true;
            }
            if (opts.isSet("atblanks")) {
                this.atBlanks = true;
            }
            if (opts.isSet("suspend")) {
                enableSuspension();
            }
            if (opts.isSet("view")) {
                this.view = true;
            }
            if (opts.isSet("cutfromcursor")) {
                this.cut2end = true;
            }
            if (opts.isSet("tempfile")) {
                this.tempFile = true;
            }
            if (opts.isSet("historylog")) {
                this.historyLog = opts.get("historyLog");
            }
            if (opts.isSet("tabstospaces")) {
                this.tabsToSpaces = true;
            }
            if (opts.isSet("autoindent")) {
                this.autoIndent = true;
            }
        }
        bindKeys();
        if (configPath != null && this.historyLog != null) {
            try {
                this.patternHistory = new PatternHistory(configPath.getUserConfig(this.historyLog, true));
            } catch (IOException e3) {
                this.errorMessage = "Encountered error while reading pattern-history file: " + this.historyLog;
            }
        }
    }

    private void parseConfig(Path file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file.toFile()));
        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String line2 = line.trim();
                if (line2.length() > 0 && !line2.startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
                    List<String> parts = Parser.split(line2);
                    if (parts.get(0).equals(Printer.INCLUDE)) {
                        if (parts.get(1).contains("*") || parts.get(1).contains("?")) {
                            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + parts.get(1));
                            Stream<Path> find = Files.find(Paths.get(new File(parts.get(1)).getParent(), new String[0]), Integer.MAX_VALUE, path, f -> {
                                return pathMatcher.matches(path);
                            }, new FileVisitOption[0]);
                            List<Path> list = this.syntaxFiles;
                            Objects.requireNonNull(list);
                            find.forEach((v1) -> {
                                r1.add(v1);
                            });
                        } else {
                            this.syntaxFiles.add(Paths.get(parts.get(1), new String[0]));
                        }
                    } else if (parts.size() == 2 && (parts.get(0).equals("set") || parts.get(0).equals("unset"))) {
                        String option = parts.get(1);
                        boolean val = parts.get(0).equals("set");
                        if (option.equals("linenumbers")) {
                            this.printLineNumbers = val;
                        } else if (option.equals("jumpyscrolling")) {
                            this.smoothScrolling = !val;
                        } else if (option.equals("smooth")) {
                            this.smoothScrolling = val;
                        } else if (option.equals("softwrap")) {
                            this.wrapping = val;
                        } else if (option.equals(LineReader.MOUSE)) {
                            this.mouseSupport = val;
                        } else if (option.equals("emptyline")) {
                            this.oneMoreLine = val;
                        } else if (option.equals("morespace")) {
                            this.oneMoreLine = !val;
                        } else if (option.equals("constantshow")) {
                            this.constantCursor = val;
                        } else if (option.equals("quickblank")) {
                            this.quickBlank = val;
                        } else if (option.equals("atblanks")) {
                            this.atBlanks = val;
                        } else if (option.equals("suspend")) {
                            enableSuspension();
                        } else if (option.equals("view")) {
                            this.view = val;
                        } else if (option.equals("cutfromcursor")) {
                            this.cut2end = val;
                        } else if (option.equals("tempfile")) {
                            this.tempFile = val;
                        } else if (option.equals("tabstospaces")) {
                            this.tabsToSpaces = val;
                        } else if (option.equals("autoindent")) {
                            this.autoIndent = val;
                        } else {
                            this.errorMessage = "Nano config: Unknown or unsupported configuration option " + option;
                        }
                    } else if (parts.size() == 3 && parts.get(0).equals("set")) {
                        String option2 = parts.get(1);
                        String val2 = parts.get(2);
                        if (option2.equals("quotestr")) {
                            this.quoteStr = val2;
                        } else if (option2.equals("punct")) {
                            this.punct = val2;
                        } else if (option2.equals("matchbrackets")) {
                            this.matchBrackets = val2;
                        } else if (option2.equals("brackets")) {
                            this.brackets = val2;
                        } else if (option2.equals("historylog")) {
                            this.historyLog = val2;
                        } else {
                            this.errorMessage = "Nano config: Unknown or unsupported configuration option " + option2;
                        }
                    } else if (parts.get(0).equals(Tmux.CMD_BIND) || parts.get(0).equals(Tmux.CMD_UNBIND)) {
                        this.errorMessage = "Nano config: Key bindings can not be changed!";
                    } else {
                        this.errorMessage = "Nano config: Bad configuration '" + line2 + "'";
                    }
                }
            }
            reader.close();
        } catch (Throwable th) {
            try {
                reader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // org.jline.reader.Editor
    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public void open(String... files) throws IOException {
        open(Arrays.asList(files));
    }

    @Override // org.jline.reader.Editor
    public void open(List<String> files) throws IOException {
        for (String file : files) {
            String file2 = file.startsWith("~") ? file.replace("~", System.getProperty("user.home")) : file;
            if (file2.contains("*") || file2.contains("?")) {
                for (Path p : Commands.findFiles(this.root, file2)) {
                    this.buffers.add(new Buffer(p.toString()));
                }
            } else {
                this.buffers.add(new Buffer(file2));
            }
        }
    }

    @Override // org.jline.reader.Editor
    public void run() throws IOException {
        if (this.buffers.isEmpty()) {
            this.buffers.add(new Buffer(null));
        }
        this.buffer = this.buffers.get(this.bufferIndex);
        Attributes attributes = this.terminal.getAttributes();
        Attributes newAttr = new Attributes(attributes);
        if (this.vsusp > 0) {
            attributes.setControlChar(Attributes.ControlChar.VSUSP, this.vsusp);
        }
        newAttr.setLocalFlags(EnumSet.of(Attributes.LocalFlag.ICANON, Attributes.LocalFlag.ECHO, Attributes.LocalFlag.IEXTEN), false);
        newAttr.setInputFlags(EnumSet.of(Attributes.InputFlag.IXON, Attributes.InputFlag.ICRNL, Attributes.InputFlag.INLCR), false);
        newAttr.setControlChar(Attributes.ControlChar.VMIN, 1);
        newAttr.setControlChar(Attributes.ControlChar.VTIME, 0);
        newAttr.setControlChar(Attributes.ControlChar.VINTR, 0);
        this.terminal.setAttributes(newAttr);
        this.terminal.puts(InfoCmp.Capability.enter_ca_mode, new Object[0]);
        this.terminal.puts(InfoCmp.Capability.keypad_xmit, new Object[0]);
        if (this.mouseSupport) {
            this.terminal.trackMouse(Terminal.MouseTracking.Normal);
        }
        this.shortcuts = standardShortcuts();
        Terminal.SignalHandler prevHandler = null;
        Status status = Status.getStatus(this.terminal, false);
        try {
            this.size.copy(this.terminal.getSize());
            if (status != null) {
                status.suspend();
            }
            this.buffer.open();
            if (this.errorMessage != null) {
                setMessage(this.errorMessage);
                this.errorMessage = null;
            } else if (this.buffer.file != null) {
                setMessage("Read " + this.buffer.lines.size() + " lines");
            }
            this.display.clear();
            this.display.reset();
            this.display.resize(this.size.getRows(), this.size.getColumns());
            prevHandler = this.terminal.handle(Terminal.Signal.WINCH, this::handle);
            display();
            while (true) {
                int[] iArr = C58231.$SwitchMap$org$jline$builtins$Nano$Operation;
                Operation op = readOperation(this.keys);
                switch (iArr[op.ordinal()]) {
                    case 1:
                        if (!quit()) {
                            break;
                        } else {
                            if (this.mouseSupport) {
                                this.terminal.trackMouse(Terminal.MouseTracking.Off);
                            }
                            if (!this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0])) {
                                this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0]);
                            }
                            this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                            this.terminal.flush();
                            this.terminal.setAttributes(attributes);
                            this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
                            if (status != null) {
                                status.restore();
                            }
                            this.patternHistory.persist();
                            return;
                        }
                    case 2:
                        write();
                        break;
                    case 3:
                        read();
                        break;
                    case 4:
                        this.buffer.moveUp(1);
                        break;
                    case 5:
                        this.buffer.moveDown(1);
                        break;
                    case 6:
                        this.buffer.moveLeft(1);
                        break;
                    case 7:
                        this.buffer.moveRight(1);
                        break;
                    case 8:
                        this.buffer.insert(this.bindingReader.getLastBinding());
                        break;
                    case 9:
                        this.buffer.backspace(1);
                        break;
                    case 10:
                        this.buffer.delete(1);
                        break;
                    case 11:
                        wrap();
                        break;
                    case 12:
                        numbers();
                        break;
                    case 13:
                        smoothScrolling();
                        break;
                    case 14:
                        mouseSupport();
                        break;
                    case 15:
                        oneMoreLine();
                        break;
                    case 16:
                        clearScreen();
                        break;
                    case 17:
                        prevBuffer();
                        break;
                    case 18:
                        nextBuffer();
                        break;
                    case 19:
                        curPos();
                        break;
                    case 20:
                        this.buffer.prevWord();
                        break;
                    case 21:
                        this.buffer.nextWord();
                        break;
                    case 22:
                        this.buffer.beginningOfLine();
                        break;
                    case 23:
                        this.buffer.endOfLine();
                        break;
                    case 24:
                        this.buffer.firstLine();
                        break;
                    case 25:
                        this.buffer.lastLine();
                        break;
                    case 26:
                        this.buffer.prevPage();
                        break;
                    case 27:
                        this.buffer.nextPage();
                        break;
                    case 28:
                        this.buffer.scrollUp(1);
                        break;
                    case 29:
                        this.buffer.scrollDown(1);
                        break;
                    case 30:
                        this.searchToReplace = false;
                        searchAndReplace();
                        break;
                    case 31:
                        this.searchToReplace = true;
                        searchAndReplace();
                        break;
                    case 32:
                        this.buffer.nextSearch();
                        break;
                    case 33:
                        help("nano-main-help.txt");
                        break;
                    case 34:
                        constantCursor();
                        break;
                    case 35:
                        this.buffer.insert(new String(Character.toChars(this.bindingReader.readCharacter())));
                        break;
                    case 36:
                        this.buffer.matching();
                        break;
                    case 37:
                        mouseEvent();
                        break;
                    case 38:
                        toggleSuspension();
                        break;
                    case 39:
                        this.buffer.copy();
                        break;
                    case 40:
                        this.buffer.cut();
                        break;
                    case 41:
                        this.buffer.uncut();
                        break;
                    case 42:
                        gotoLine();
                        curPos();
                        break;
                    case 43:
                        this.cut2end = !this.cut2end;
                        setMessage("Cut to end " + (this.cut2end ? "enabled" : "disabled"));
                        break;
                    case 44:
                        this.buffer.cut(true);
                        break;
                    case 45:
                        this.mark = !this.mark;
                        setMessage("Mark " + (this.mark ? "Set" : "Unset"));
                        this.buffer.mark();
                        break;
                    case 46:
                        this.highlight = !this.highlight;
                        setMessage("Highlight " + (this.highlight ? "enabled" : "disabled"));
                        break;
                    case 47:
                        this.tabsToSpaces = !this.tabsToSpaces;
                        setMessage("Conversion of typed tabs to spaces " + (this.tabsToSpaces ? "enabled" : "disabled"));
                        break;
                    case 48:
                        this.autoIndent = !this.autoIndent;
                        setMessage("Auto indent " + (this.autoIndent ? "enabled" : "disabled"));
                        break;
                    default:
                        setMessage("Unsupported " + op.name().toLowerCase().replace('_', '-'));
                        break;
                }
                display();
            }
        } catch (Throwable th) {
            if (this.mouseSupport) {
                this.terminal.trackMouse(Terminal.MouseTracking.Off);
            }
            if (!this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0])) {
                this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0]);
            }
            this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
            this.terminal.flush();
            this.terminal.setAttributes(attributes);
            this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
            if (status != null) {
                status.restore();
            }
            this.patternHistory.persist();
            throw th;
        }
    }

    private int editInputBuffer(Operation operation, int curPos) {
        switch (operation) {
            case LEFT:
                if (curPos > 0) {
                    curPos--;
                    break;
                }
                break;
            case RIGHT:
                if (curPos < this.editBuffer.length()) {
                    curPos++;
                    break;
                }
                break;
            case INSERT:
                curPos++;
                this.editBuffer.insert(curPos, this.bindingReader.getLastBinding());
                break;
            case BACKSPACE:
                if (curPos > 0) {
                    curPos--;
                    this.editBuffer.deleteCharAt(curPos);
                    break;
                }
                break;
        }
        return curPos;
    }

    boolean write() throws IOException {
        KeyMap<Operation> writeKeyMap = new KeyMap<>();
        if (!this.restricted) {
            writeKeyMap.setUnicode(Operation.INSERT);
            for (char i = ' '; i < 256; i = (char) (i + 1)) {
                writeKeyMap.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
            }
            for (char i2 = 'A'; i2 <= 'Z'; i2 = (char) (i2 + 1)) {
                writeKeyMap.bind((KeyMap<Operation>) Operation.DO_LOWER_CASE, KeyMap.alt(i2));
            }
            writeKeyMap.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
            writeKeyMap.bind((KeyMap<Operation>) Operation.APPEND_MODE, KeyMap.alt('a'));
            writeKeyMap.bind((KeyMap<Operation>) Operation.PREPEND_MODE, KeyMap.alt('p'));
            writeKeyMap.bind((KeyMap<Operation>) Operation.BACKUP, KeyMap.alt('b'));
            writeKeyMap.bind((KeyMap<Operation>) Operation.TO_FILES, KeyMap.ctrl('T'));
        }
        writeKeyMap.bind((KeyMap<Operation>) Operation.MAC_FORMAT, KeyMap.alt('m'));
        writeKeyMap.bind((KeyMap<Operation>) Operation.DOS_FORMAT, KeyMap.alt('d'));
        writeKeyMap.bind((KeyMap<Operation>) Operation.ACCEPT, "\r");
        writeKeyMap.bind((KeyMap<Operation>) Operation.CANCEL, KeyMap.ctrl('C'));
        writeKeyMap.bind((KeyMap<Operation>) Operation.HELP, KeyMap.ctrl('G'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f1));
        writeKeyMap.bind((KeyMap<Operation>) Operation.MOUSE_EVENT, KeyMap.key(this.terminal, InfoCmp.Capability.key_mouse));
        writeKeyMap.bind((KeyMap<Operation>) Operation.TOGGLE_SUSPENSION, KeyMap.alt('z'));
        writeKeyMap.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        writeKeyMap.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        this.editMessage = getWriteMessage();
        this.editBuffer.setLength(0);
        this.editBuffer.append(this.buffer.file == null ? "" : this.buffer.file);
        int curPos = this.editBuffer.length();
        this.shortcuts = writeShortcuts();
        display(Integer.valueOf(curPos));
        while (true) {
            Operation op = readOperation(writeKeyMap);
            switch (op) {
                case HELP:
                    help("nano-write-help.txt");
                    break;
                case CONSTANT_CURSOR:
                case VERBATIM:
                case MATCHING:
                case COPY:
                case CUT:
                case UNCUT:
                case GOTO:
                case CUT_TO_END_TOGGLE:
                case CUT_TO_END:
                case MARK:
                case HIGHLIGHT:
                case TABS_TO_SPACE:
                case AUTO_INDENT:
                default:
                    curPos = editInputBuffer(op, curPos);
                    break;
                case MOUSE_EVENT:
                    mouseEvent();
                    break;
                case TOGGLE_SUSPENSION:
                    toggleSuspension();
                    break;
                case CANCEL:
                    this.editMessage = null;
                    this.shortcuts = standardShortcuts();
                    return false;
                case ACCEPT:
                    this.editMessage = null;
                    if (!save(this.editBuffer.toString())) {
                        return false;
                    }
                    this.shortcuts = standardShortcuts();
                    return true;
                case MAC_FORMAT:
                    this.buffer.format = this.buffer.format == WriteFormat.MAC ? WriteFormat.UNIX : WriteFormat.MAC;
                    break;
                case DOS_FORMAT:
                    this.buffer.format = this.buffer.format == WriteFormat.DOS ? WriteFormat.UNIX : WriteFormat.DOS;
                    break;
                case APPEND_MODE:
                    this.writeMode = this.writeMode == WriteMode.APPEND ? WriteMode.WRITE : WriteMode.APPEND;
                    break;
                case PREPEND_MODE:
                    this.writeMode = this.writeMode == WriteMode.PREPEND ? WriteMode.WRITE : WriteMode.PREPEND;
                    break;
                case BACKUP:
                    this.writeBackup = !this.writeBackup;
                    break;
            }
            this.editMessage = getWriteMessage();
            display(Integer.valueOf(curPos));
        }
    }

    private Operation readOperation(KeyMap<Operation> keymap) {
        while (true) {
            Operation op = (Operation) this.bindingReader.readBinding(keymap);
            if (op != Operation.DO_LOWER_CASE) {
                return op;
            }
            this.bindingReader.runMacro(this.bindingReader.getLastBinding().toLowerCase());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x009f */
    /* JADX DEBUG: Multi-variable search result rejected for r12v1, resolved type: java.nio.file.Path */
    /* JADX DEBUG: Multi-variable search result rejected for r12v2, resolved type: java.nio.file.Path */
    /* JADX DEBUG: Multi-variable search result rejected for r12v3, resolved type: java.nio.file.Path */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean save(String name) throws IOException {
        Path t;
        Path orgPath = this.buffer.file != null ? this.root.resolve(this.buffer.file) : null;
        Path newPath = this.root.resolve(name);
        if (!(orgPath != null && Files.exists(orgPath, new LinkOption[0]) && Files.exists(newPath, new LinkOption[0]) && Files.isSameFile(orgPath, newPath)) && Files.exists(Paths.get(name, new String[0]), new LinkOption[0]) && this.writeMode == WriteMode.WRITE) {
            t = getYNC("File exists, OVERWRITE ? ");
            if (t != Operation.YES) {
                return false;
            }
        } else if (!Files.exists(newPath, new LinkOption[0])) {
            newPath.toFile().createNewFile();
        }
        try {
            t = Files.createTempFile("jline-", ".temp", new FileAttribute[0]);
            try {
                OutputStream os = Files.newOutputStream(t, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
                if (this.writeMode == WriteMode.APPEND) {
                    try {
                        if (Files.isReadable(newPath)) {
                            Files.copy(newPath, os);
                        }
                    } catch (Throwable th) {
                        if (os != null) {
                            try {
                                os.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                Writer w = new OutputStreamWriter(os, this.buffer.charset);
                for (int i = 0; i < this.buffer.lines.size(); i++) {
                    w.write(this.buffer.lines.get(i));
                    switch (this.buffer.format) {
                        case UNIX:
                            w.write("\n");
                            break;
                        case DOS:
                            w.write("\r\n");
                            break;
                        case MAC:
                            w.write("\r");
                            break;
                    }
                }
                w.flush();
                if (this.writeMode == WriteMode.PREPEND && Files.isReadable(newPath)) {
                    Files.copy(newPath, os);
                }
                if (this.writeBackup) {
                    Files.move(newPath, newPath.resolveSibling(newPath.getFileName().toString() + "~"), StandardCopyOption.REPLACE_EXISTING);
                }
                Files.move(t, newPath, StandardCopyOption.REPLACE_EXISTING);
                if (this.writeMode == WriteMode.WRITE) {
                    this.buffer.file = name;
                    this.buffer.dirty = false;
                }
                setMessage("Wrote " + this.buffer.lines.size() + " lines");
                if (os != null) {
                    os.close();
                }
                Files.deleteIfExists(t);
                this.writeMode = WriteMode.WRITE;
                return true;
            } catch (IOException e) {
                setMessage("Error writing " + name + ": " + e.toString());
                Files.deleteIfExists(t);
                this.writeMode = WriteMode.WRITE;
                return false;
            }
        } catch (Throwable th3) {
            Files.deleteIfExists(t);
            this.writeMode = WriteMode.WRITE;
            throw th3;
        }
    }

    private Operation getYNC(String message) {
        return getYNC(message, false);
    }

    private Operation getYNC(String message, boolean andAll) {
        String oldEditMessage = this.editMessage;
        String oldEditBuffer = this.editBuffer.toString();
        LinkedHashMap<String, String> oldShortcuts = this.shortcuts;
        try {
            this.editMessage = message;
            this.editBuffer.setLength(0);
            KeyMap<Operation> yncKeyMap = new KeyMap<>();
            yncKeyMap.bind((KeyMap<Operation>) Operation.YES, "y", "Y");
            if (andAll) {
                yncKeyMap.bind((KeyMap<Operation>) Operation.ALL, "a", "A");
            }
            yncKeyMap.bind((KeyMap<Operation>) Operation.NO, "n", "N");
            yncKeyMap.bind((KeyMap<Operation>) Operation.CANCEL, KeyMap.ctrl('C'));
            this.shortcuts = new LinkedHashMap<>();
            this.shortcuts.put(" Y", "Yes");
            if (andAll) {
                this.shortcuts.put(" A", "All");
            }
            this.shortcuts.put(" N", "No");
            this.shortcuts.put("^C", "Cancel");
            display();
            Operation readOperation = readOperation(yncKeyMap);
            this.editMessage = oldEditMessage;
            this.editBuffer.append(oldEditBuffer);
            this.shortcuts = oldShortcuts;
            return readOperation;
        } catch (Throwable th) {
            this.editMessage = oldEditMessage;
            this.editBuffer.append(oldEditBuffer);
            this.shortcuts = oldShortcuts;
            throw th;
        }
    }

    private String getWriteMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("File Name to ");
        switch (this.writeMode) {
            case WRITE:
                sb.append("Write");
                break;
            case APPEND:
                sb.append("Append");
                break;
            case PREPEND:
                sb.append("Prepend");
                break;
        }
        switch (this.buffer.format) {
            case DOS:
                sb.append(" [DOS Format]");
                break;
            case MAC:
                sb.append(" [Mac Format]");
                break;
        }
        if (this.writeBackup) {
            sb.append(" [Backup]");
        }
        sb.append(": ");
        return sb.toString();
    }

    void read() {
        KeyMap<Operation> readKeyMap = new KeyMap<>();
        readKeyMap.setUnicode(Operation.INSERT);
        for (char i = ' '; i < 256; i = (char) (i + 1)) {
            readKeyMap.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
        }
        for (char i2 = 'A'; i2 <= 'Z'; i2 = (char) (i2 + 1)) {
            readKeyMap.bind((KeyMap<Operation>) Operation.DO_LOWER_CASE, KeyMap.alt(i2));
        }
        readKeyMap.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
        readKeyMap.bind((KeyMap<Operation>) Operation.NEW_BUFFER, KeyMap.alt('f'));
        readKeyMap.bind((KeyMap<Operation>) Operation.TO_FILES, KeyMap.ctrl('T'));
        readKeyMap.bind((KeyMap<Operation>) Operation.EXECUTE, KeyMap.ctrl('X'));
        readKeyMap.bind((KeyMap<Operation>) Operation.ACCEPT, "\r");
        readKeyMap.bind((KeyMap<Operation>) Operation.CANCEL, KeyMap.ctrl('C'));
        readKeyMap.bind((KeyMap<Operation>) Operation.HELP, KeyMap.ctrl('G'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f1));
        readKeyMap.bind((KeyMap<Operation>) Operation.MOUSE_EVENT, KeyMap.key(this.terminal, InfoCmp.Capability.key_mouse));
        readKeyMap.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        readKeyMap.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        this.editMessage = getReadMessage();
        this.editBuffer.setLength(0);
        int curPos = this.editBuffer.length();
        this.shortcuts = readShortcuts();
        display(Integer.valueOf(curPos));
        while (true) {
            Operation op = readOperation(readKeyMap);
            switch (op) {
                case HELP:
                    help("nano-read-help.txt");
                    break;
                case MOUSE_EVENT:
                    mouseEvent();
                    break;
                case CANCEL:
                    this.editMessage = null;
                    this.shortcuts = standardShortcuts();
                    return;
                case ACCEPT:
                    this.editMessage = null;
                    String file = this.editBuffer.toString();
                    boolean empty = file.isEmpty();
                    Path p = empty ? null : this.root.resolve(file);
                    if (!this.readNewBuffer && !empty && !Files.exists(p, new LinkOption[0])) {
                        setMessage("\"" + file + "\" not found");
                    } else if (!empty && Files.isDirectory(p, new LinkOption[0])) {
                        setMessage("\"" + file + "\" is a directory");
                    } else if (empty || Files.isRegularFile(p, new LinkOption[0])) {
                        Buffer buf = new Buffer(empty ? null : file);
                        try {
                            buf.open();
                            if (this.readNewBuffer) {
                                List<Buffer> list = this.buffers;
                                int i3 = this.bufferIndex + 1;
                                this.bufferIndex = i3;
                                list.add(i3, buf);
                                this.buffer = buf;
                            } else {
                                this.buffer.insert(String.join("\n", buf.lines));
                            }
                            setMessage(null);
                        } catch (IOException e) {
                            setMessage("Error reading " + file + ": " + e.getMessage());
                        }
                    } else {
                        setMessage("\"" + file + "\" is not a regular file");
                    }
                    this.shortcuts = standardShortcuts();
                    return;
                case NEW_BUFFER:
                    this.readNewBuffer = !this.readNewBuffer;
                    break;
                default:
                    curPos = editInputBuffer(op, curPos);
                    break;
            }
            this.editMessage = getReadMessage();
            display(Integer.valueOf(curPos));
        }
    }

    private String getReadMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("File to insert");
        if (this.readNewBuffer) {
            sb.append(" into new buffer");
        }
        sb.append(" [from ./]: ");
        return sb.toString();
    }

    void gotoLine() throws IOException {
        KeyMap<Operation> readKeyMap = new KeyMap<>();
        readKeyMap.setUnicode(Operation.INSERT);
        for (char i = ' '; i < 256; i = (char) (i + 1)) {
            readKeyMap.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
        }
        readKeyMap.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
        readKeyMap.bind((KeyMap<Operation>) Operation.ACCEPT, "\r");
        readKeyMap.bind((KeyMap<Operation>) Operation.HELP, KeyMap.ctrl('G'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f1));
        readKeyMap.bind((KeyMap<Operation>) Operation.CANCEL, KeyMap.ctrl('C'));
        readKeyMap.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        readKeyMap.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        readKeyMap.bind((KeyMap<Operation>) Operation.FIRST_LINE, KeyMap.ctrl('Y'));
        readKeyMap.bind((KeyMap<Operation>) Operation.LAST_LINE, KeyMap.ctrl('V'));
        readKeyMap.bind((KeyMap<Operation>) Operation.SEARCH, KeyMap.ctrl('T'));
        this.editMessage = "Enter line number, column number: ";
        this.editBuffer.setLength(0);
        int curPos = this.editBuffer.length();
        this.shortcuts = gotoShortcuts();
        display(Integer.valueOf(curPos));
        while (true) {
            Operation op = readOperation(readKeyMap);
            switch (op) {
                case FIRST_LINE:
                    this.editMessage = null;
                    this.buffer.firstLine();
                    this.shortcuts = standardShortcuts();
                    return;
                case LAST_LINE:
                    this.editMessage = null;
                    this.buffer.lastLine();
                    this.shortcuts = standardShortcuts();
                    return;
                case SEARCH:
                    this.searchToReplace = false;
                    searchAndReplace();
                    return;
                case HELP:
                    help("nano-goto-help.txt");
                    break;
                case CANCEL:
                    this.editMessage = null;
                    this.shortcuts = standardShortcuts();
                    return;
                case ACCEPT:
                    this.editMessage = null;
                    String[] pos = this.editBuffer.toString().split(",", 2);
                    int[] args = new int[2];
                    args[0] = 0;
                    args[1] = 0;
                    for (int i2 = 0; i2 < pos.length; i2++) {
                        try {
                            if (pos[i2].trim().length() > 0) {
                                args[i2] = Integer.parseInt(pos[i2]) - 1;
                                if (args[i2] < 0) {
                                    throw new NumberFormatException();
                                }
                            }
                        } catch (NumberFormatException e) {
                            setMessage("Invalid line or column number");
                        } catch (Exception ex) {
                            setMessage("Internal error: " + ex.getMessage());
                        }
                    }
                    this.buffer.gotoLine(args[1], args[0]);
                    this.shortcuts = standardShortcuts();
                    return;
                default:
                    curPos = editInputBuffer(op, curPos);
                    break;
            }
            display(Integer.valueOf(curPos));
        }
    }

    private LinkedHashMap<String, String> gotoShortcuts() {
        LinkedHashMap<String, String> shortcuts = new LinkedHashMap<>();
        shortcuts.put("^G", "Get Help");
        shortcuts.put("^Y", "First Line");
        shortcuts.put("^T", "Go To Text");
        shortcuts.put("^C", "Cancel");
        shortcuts.put("^V", "Last Line");
        return shortcuts;
    }

    private LinkedHashMap<String, String> readShortcuts() {
        LinkedHashMap<String, String> shortcuts = new LinkedHashMap<>();
        shortcuts.put("^G", "Get Help");
        shortcuts.put("^T", "To Files");
        shortcuts.put("M-F", "New Buffer");
        shortcuts.put("^C", "Cancel");
        shortcuts.put("^X", "Execute Command");
        return shortcuts;
    }

    private LinkedHashMap<String, String> writeShortcuts() {
        LinkedHashMap<String, String> s = new LinkedHashMap<>();
        s.put("^G", "Get Help");
        s.put("M-M", "Mac Format");
        s.put("^C", "Cancel");
        s.put("M-D", "DOS Format");
        if (!this.restricted) {
            s.put("^T", "To Files");
            s.put("M-P", "Prepend");
            s.put("M-A", "Append");
            s.put("M-B", "Backup File");
        }
        return s;
    }

    private LinkedHashMap<String, String> helpShortcuts() {
        LinkedHashMap<String, String> s = new LinkedHashMap<>();
        s.put("^L", HttpHeaders.REFRESH);
        s.put("^Y", "Prev Page");
        s.put("^P", "Prev Line");
        s.put("M-\\", "First Line");
        s.put("^X", "Exit");
        s.put("^V", "Next Page");
        s.put("^N", "Next Line");
        s.put("M-/", "Last Line");
        return s;
    }

    private LinkedHashMap<String, String> searchShortcuts() {
        LinkedHashMap<String, String> s = new LinkedHashMap<>();
        s.put("^G", "Get Help");
        s.put("^Y", "First Line");
        if (this.searchToReplace) {
            s.put("^R", "No Replace");
        } else {
            s.put("^R", "Replace");
            s.put("^W", "Beg of Par");
        }
        s.put("M-C", "Case Sens");
        s.put("M-R", "Regexp");
        s.put("^C", "Cancel");
        s.put("^V", "Last Line");
        s.put("^T", "Go To Line");
        if (!this.searchToReplace) {
            s.put("^O", "End of Par");
        }
        s.put("M-B", "Backwards");
        s.put("^P", "PrevHstory");
        return s;
    }

    private LinkedHashMap<String, String> replaceShortcuts() {
        LinkedHashMap<String, String> s = new LinkedHashMap<>();
        s.put("^G", "Get Help");
        s.put("^Y", "First Line");
        s.put("^P", "PrevHstory");
        s.put("^C", "Cancel");
        s.put("^V", "Last Line");
        s.put("^N", "NextHstory");
        return s;
    }

    private LinkedHashMap<String, String> standardShortcuts() {
        LinkedHashMap<String, String> s = new LinkedHashMap<>();
        s.put("^G", "Get Help");
        if (!this.view) {
            s.put("^O", "WriteOut");
        }
        s.put("^R", "Read File");
        s.put("^Y", "Prev Page");
        if (!this.view) {
            s.put("^K", "Cut Text");
        }
        s.put("^C", "Cur Pos");
        s.put("^X", "Exit");
        if (!this.view) {
            s.put("^J", "Justify");
        }
        s.put("^W", "Where Is");
        s.put("^V", "Next Page");
        if (!this.view) {
            s.put("^U", "UnCut Text");
        }
        s.put("^T", "To Spell");
        return s;
    }

    void help(String help) {
        Buffer org2 = this.buffer;
        Buffer newBuf = new Buffer(null);
        try {
            InputStream is = getClass().getResourceAsStream(help);
            newBuf.open(is);
            if (is != null) {
                is.close();
            }
            LinkedHashMap<String, String> oldShortcuts = this.shortcuts;
            this.shortcuts = helpShortcuts();
            boolean oldWrapping = this.wrapping;
            boolean oldPrintLineNumbers = this.printLineNumbers;
            boolean oldConstantCursor = this.constantCursor;
            boolean oldAtBlanks = this.atBlanks;
            boolean oldHighlight = this.highlight;
            String oldEditMessage = this.editMessage;
            this.editMessage = "";
            this.wrapping = true;
            this.atBlanks = true;
            this.printLineNumbers = false;
            this.constantCursor = false;
            this.highlight = false;
            this.buffer = newBuf;
            if (!oldWrapping) {
                this.buffer.computeAllOffsets();
            }
            try {
                this.message = null;
                this.terminal.puts(InfoCmp.Capability.cursor_invisible, new Object[0]);
                display();
                while (true) {
                    switch (readOperation(this.keys)) {
                        case QUIT:
                            this.buffer = org2;
                            this.wrapping = oldWrapping;
                            this.printLineNumbers = oldPrintLineNumbers;
                            this.constantCursor = oldConstantCursor;
                            this.shortcuts = oldShortcuts;
                            this.atBlanks = oldAtBlanks;
                            this.highlight = oldHighlight;
                            this.editMessage = oldEditMessage;
                            this.terminal.puts(InfoCmp.Capability.cursor_visible, new Object[0]);
                            if (!oldWrapping) {
                                this.buffer.computeAllOffsets();
                                return;
                            }
                            return;
                        case UP:
                            this.buffer.scrollUp(1);
                            continue;
                        case DOWN:
                            this.buffer.scrollDown(1);
                            continue;
                        case CLEAR_SCREEN:
                            clearScreen();
                            continue;
                        case FIRST_LINE:
                            this.buffer.firstLine();
                            continue;
                        case LAST_LINE:
                            this.buffer.lastLine();
                            continue;
                        case PREV_PAGE:
                            this.buffer.prevPage();
                            continue;
                        case NEXT_PAGE:
                            this.buffer.nextPage();
                            continue;
                        case MOUSE_EVENT:
                            mouseEvent();
                            continue;
                        case TOGGLE_SUSPENSION:
                            toggleSuspension();
                            continue;
                    }
                    display();
                }
            } catch (Throwable th) {
                this.buffer = org2;
                this.wrapping = oldWrapping;
                this.printLineNumbers = oldPrintLineNumbers;
                this.constantCursor = oldConstantCursor;
                this.shortcuts = oldShortcuts;
                this.atBlanks = oldAtBlanks;
                this.highlight = oldHighlight;
                this.editMessage = oldEditMessage;
                this.terminal.puts(InfoCmp.Capability.cursor_visible, new Object[0]);
                if (!oldWrapping) {
                    this.buffer.computeAllOffsets();
                }
                throw th;
            }
        } catch (IOException e) {
            setMessage("Unable to read help");
        }
    }

    void searchAndReplace() {
        try {
            search();
            if (!this.searchToReplace) {
                this.searchToReplace = false;
                this.matchedLength = -1;
                this.shortcuts = standardShortcuts();
                this.editMessage = null;
                return;
            }
            String replaceTerm = replace();
            int replaced = 0;
            boolean all = false;
            boolean found = true;
            List<Integer> matches = new ArrayList<>();
            Operation op = Operation.NO;
            while (found) {
                found = this.buffer.nextSearch();
                if (found) {
                    int[] re = this.buffer.highlightStart();
                    int match = (re[0] * 10000) + (this.searchBackwards ? this.buffer.length(this.buffer.getLine(re[0])) - re[1] : re[1]);
                    if (matches.contains(Integer.valueOf(match))) {
                        this.message = "Replaced " + replaced + " occurrences";
                        this.searchToReplace = false;
                        this.matchedLength = -1;
                        this.shortcuts = standardShortcuts();
                        this.editMessage = null;
                    }
                    matches.add(Integer.valueOf(match));
                    if (!all) {
                        op = getYNC("Replace this instance? ", true);
                    }
                } else {
                    op = Operation.NO;
                }
                switch (op) {
                    case CANCEL:
                        found = false;
                        break;
                    case ALL:
                        all = true;
                        this.buffer.replaceFromCursor(this.matchedLength, replaceTerm);
                        replaced++;
                        break;
                    case YES:
                        this.buffer.replaceFromCursor(this.matchedLength, replaceTerm);
                        replaced++;
                        break;
                    case NO:
                        break;
                }
            }
            this.message = "Replaced " + replaced + " occurrences";
            this.searchToReplace = false;
            this.matchedLength = -1;
            this.shortcuts = standardShortcuts();
            this.editMessage = null;
        } catch (Exception e) {
            this.searchToReplace = false;
            this.matchedLength = -1;
            this.shortcuts = standardShortcuts();
            this.editMessage = null;
        } catch (Throwable th) {
            this.searchToReplace = false;
            this.matchedLength = -1;
            this.shortcuts = standardShortcuts();
            this.editMessage = null;
            throw th;
        }
    }

    void search() throws IOException {
        KeyMap<Operation> searchKeyMap = new KeyMap<>();
        searchKeyMap.setUnicode(Operation.INSERT);
        for (char i = ' '; i < 256; i = (char) (i + 1)) {
            searchKeyMap.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
        }
        for (char i2 = 'A'; i2 <= 'Z'; i2 = (char) (i2 + 1)) {
            searchKeyMap.bind((KeyMap<Operation>) Operation.DO_LOWER_CASE, KeyMap.alt(i2));
        }
        searchKeyMap.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
        searchKeyMap.bind((KeyMap<Operation>) Operation.CASE_SENSITIVE, KeyMap.alt('c'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.BACKWARDS, KeyMap.alt('b'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.REGEXP, KeyMap.alt('r'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.ACCEPT, "\r");
        searchKeyMap.bind((KeyMap<Operation>) Operation.CANCEL, KeyMap.ctrl('C'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.HELP, KeyMap.ctrl('G'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f1));
        searchKeyMap.bind((KeyMap<Operation>) Operation.FIRST_LINE, KeyMap.ctrl('Y'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.LAST_LINE, KeyMap.ctrl('V'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.MOUSE_EVENT, KeyMap.key(this.terminal, InfoCmp.Capability.key_mouse));
        searchKeyMap.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        searchKeyMap.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        searchKeyMap.bind((KeyMap<Operation>) Operation.UP, KeyMap.key(this.terminal, InfoCmp.Capability.key_up));
        searchKeyMap.bind((KeyMap<Operation>) Operation.DOWN, KeyMap.key(this.terminal, InfoCmp.Capability.key_down));
        searchKeyMap.bind((KeyMap<Operation>) Operation.TOGGLE_REPLACE, KeyMap.ctrl('R'));
        this.editMessage = getSearchMessage();
        this.editBuffer.setLength(0);
        String currentBuffer = this.editBuffer.toString();
        int curPos = this.editBuffer.length();
        this.shortcuts = searchShortcuts();
        display(Integer.valueOf(curPos));
        while (true) {
            try {
                Operation op = readOperation(searchKeyMap);
                switch (op) {
                    case UP:
                        this.editBuffer.setLength(0);
                        this.editBuffer.append(this.patternHistory.m30up(currentBuffer));
                        curPos = this.editBuffer.length();
                        break;
                    case DOWN:
                        this.editBuffer.setLength(0);
                        this.editBuffer.append(this.patternHistory.down(currentBuffer));
                        curPos = this.editBuffer.length();
                        break;
                    case FIRST_LINE:
                        this.buffer.firstLine();
                        break;
                    case LAST_LINE:
                        this.buffer.lastLine();
                        break;
                    case HELP:
                        if (this.searchToReplace) {
                            help("nano-search-replace-help.txt");
                            break;
                        } else {
                            help("nano-search-help.txt");
                            break;
                        }
                    case MOUSE_EVENT:
                        mouseEvent();
                        break;
                    case CANCEL:
                        throw new IllegalArgumentException();
                    case ACCEPT:
                        if (this.editBuffer.length() > 0) {
                            this.searchTerm = this.editBuffer.toString();
                        }
                        if (this.searchTerm == null || this.searchTerm.isEmpty()) {
                            setMessage("Cancelled");
                            throw new IllegalArgumentException();
                        }
                        this.patternHistory.add(this.searchTerm);
                        if (!this.searchToReplace) {
                            this.buffer.nextSearch();
                        }
                        return;
                    case CASE_SENSITIVE:
                        this.searchCaseSensitive = !this.searchCaseSensitive;
                        break;
                    case BACKWARDS:
                        this.searchBackwards = !this.searchBackwards;
                        break;
                    case REGEXP:
                        this.searchRegexp = !this.searchRegexp;
                        break;
                    case TOGGLE_REPLACE:
                        this.searchToReplace = !this.searchToReplace;
                        this.shortcuts = searchShortcuts();
                        break;
                    default:
                        curPos = editInputBuffer(op, curPos);
                        currentBuffer = this.editBuffer.toString();
                        break;
                }
                this.editMessage = getSearchMessage();
                display(Integer.valueOf(curPos));
            } finally {
                this.shortcuts = standardShortcuts();
                this.editMessage = null;
            }
        }
    }

    String replace() throws IOException {
        KeyMap<Operation> keyMap = new KeyMap<>();
        keyMap.setUnicode(Operation.INSERT);
        for (char i = ' '; i < 256; i = (char) (i + 1)) {
            keyMap.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
        }
        for (char i2 = 'A'; i2 <= 'Z'; i2 = (char) (i2 + 1)) {
            keyMap.bind((KeyMap<Operation>) Operation.DO_LOWER_CASE, KeyMap.alt(i2));
        }
        keyMap.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
        keyMap.bind((KeyMap<Operation>) Operation.ACCEPT, "\r");
        keyMap.bind((KeyMap<Operation>) Operation.CANCEL, KeyMap.ctrl('C'));
        keyMap.bind((KeyMap<Operation>) Operation.HELP, KeyMap.ctrl('G'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f1));
        keyMap.bind((KeyMap<Operation>) Operation.FIRST_LINE, KeyMap.ctrl('Y'));
        keyMap.bind((KeyMap<Operation>) Operation.LAST_LINE, KeyMap.ctrl('V'));
        keyMap.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        keyMap.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        keyMap.bind((KeyMap<Operation>) Operation.UP, KeyMap.key(this.terminal, InfoCmp.Capability.key_up));
        keyMap.bind((KeyMap<Operation>) Operation.DOWN, KeyMap.key(this.terminal, InfoCmp.Capability.key_down));
        this.editMessage = "Replace with: ";
        this.editBuffer.setLength(0);
        String currentBuffer = this.editBuffer.toString();
        int curPos = this.editBuffer.length();
        this.shortcuts = replaceShortcuts();
        display(Integer.valueOf(curPos));
        while (true) {
            try {
                Operation op = readOperation(keyMap);
                switch (op) {
                    case UP:
                        this.editBuffer.setLength(0);
                        this.editBuffer.append(this.patternHistory.m30up(currentBuffer));
                        curPos = this.editBuffer.length();
                        break;
                    case DOWN:
                        this.editBuffer.setLength(0);
                        this.editBuffer.append(this.patternHistory.down(currentBuffer));
                        curPos = this.editBuffer.length();
                        break;
                    case FIRST_LINE:
                        this.buffer.firstLine();
                        break;
                    case LAST_LINE:
                        this.buffer.lastLine();
                        break;
                    case HELP:
                        help("nano-replace-help.txt");
                        break;
                    case MOUSE_EVENT:
                        mouseEvent();
                        break;
                    case CANCEL:
                        throw new IllegalArgumentException();
                    case ACCEPT:
                        String replaceTerm = "";
                        if (this.editBuffer.length() > 0) {
                            replaceTerm = this.editBuffer.toString();
                        }
                        if (replaceTerm == null) {
                            setMessage("Cancelled");
                            throw new IllegalArgumentException();
                        }
                        this.patternHistory.add(replaceTerm);
                        this.shortcuts = standardShortcuts();
                        this.editMessage = null;
                        return replaceTerm;
                    default:
                        curPos = editInputBuffer(op, curPos);
                        currentBuffer = this.editBuffer.toString();
                        break;
                }
                display(Integer.valueOf(curPos));
            } catch (Throwable th) {
                this.shortcuts = standardShortcuts();
                this.editMessage = null;
                throw th;
            }
        }
    }

    private String getSearchMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Search");
        if (this.searchToReplace) {
            sb.append(" (to replace)");
        }
        if (this.searchCaseSensitive) {
            sb.append(" [Case Sensitive]");
        }
        if (this.searchRegexp) {
            sb.append(" [Regexp]");
        }
        if (this.searchBackwards) {
            sb.append(" [Backwards]");
        }
        if (this.searchTerm != null) {
            sb.append(" [");
            sb.append(this.searchTerm);
            sb.append("]");
        }
        sb.append(": ");
        return sb.toString();
    }

    String computeCurPos() {
        int chari = 0;
        int chart = 0;
        for (int i = 0; i < this.buffer.lines.size(); i++) {
            int l = this.buffer.lines.get(i).length() + 1;
            if (i < this.buffer.line) {
                chari += l;
            } else if (i == this.buffer.line) {
                chari += this.buffer.offsetInLine + this.buffer.column;
            }
            chart += l;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("line ");
        sb.append(this.buffer.line + 1);
        sb.append("/");
        sb.append(this.buffer.lines.size());
        sb.append(" (");
        sb.append(Math.round((100.0d * ((double) this.buffer.line)) / ((double) this.buffer.lines.size())));
        sb.append("%), ");
        sb.append("col ");
        sb.append(this.buffer.offsetInLine + this.buffer.column + 1);
        sb.append("/");
        sb.append(this.buffer.length(this.buffer.lines.get(this.buffer.line)) + 1);
        sb.append(" (");
        if (this.buffer.lines.get(this.buffer.line).length() > 0) {
            sb.append(Math.round((100.0d * ((double) (this.buffer.offsetInLine + this.buffer.column))) / ((double) this.buffer.length(this.buffer.lines.get(this.buffer.line)))));
        } else {
            sb.append("100");
        }
        sb.append("%), ");
        sb.append("char ");
        sb.append(chari + 1);
        sb.append("/");
        sb.append(chart);
        sb.append(" (");
        sb.append(Math.round((100.0d * ((double) chari)) / ((double) chart)));
        sb.append("%)");
        return sb.toString();
    }

    void curPos() {
        setMessage(computeCurPos());
    }

    void prevBuffer() throws IOException {
        if (this.buffers.size() > 1) {
            this.bufferIndex = ((this.bufferIndex + this.buffers.size()) - 1) % this.buffers.size();
            this.buffer = this.buffers.get(this.bufferIndex);
            setMessage("Switched to " + this.buffer.getTitle());
            this.buffer.open();
            this.display.clear();
            return;
        }
        setMessage("No more open file buffers");
    }

    void nextBuffer() throws IOException {
        if (this.buffers.size() > 1) {
            this.bufferIndex = (this.bufferIndex + 1) % this.buffers.size();
            this.buffer = this.buffers.get(this.bufferIndex);
            setMessage("Switched to " + this.buffer.getTitle());
            this.buffer.open();
            this.display.clear();
            return;
        }
        setMessage("No more open file buffers");
    }

    void setMessage(String message) {
        this.message = message;
        this.nbBindings = this.quickBlank ? 2 : 25;
    }

    boolean quit() throws IOException {
        if (this.buffer.dirty) {
            if (!this.tempFile) {
                switch (getYNC("Save modified buffer (ANSWERING \"No\" WILL DESTROY CHANGES) ? ")) {
                    case CANCEL:
                        return false;
                    case YES:
                        if (!write()) {
                            return false;
                        }
                        break;
                }
            } else if (!write()) {
                return false;
            }
        }
        this.buffers.remove(this.bufferIndex);
        if (this.bufferIndex == this.buffers.size() && this.bufferIndex > 0) {
            this.bufferIndex = this.buffers.size() - 1;
        }
        if (this.buffers.isEmpty()) {
            this.buffer = null;
            return true;
        }
        this.buffer = this.buffers.get(this.bufferIndex);
        this.buffer.open();
        this.display.clear();
        setMessage("Switched to " + this.buffer.getTitle());
        return false;
    }

    void numbers() {
        this.printLineNumbers = !this.printLineNumbers;
        resetDisplay();
        setMessage("Lines numbering " + (this.printLineNumbers ? "enabled" : "disabled"));
    }

    void smoothScrolling() {
        this.smoothScrolling = !this.smoothScrolling;
        setMessage("Smooth scrolling " + (this.smoothScrolling ? "enabled" : "disabled"));
    }

    void mouseSupport() throws IOException {
        this.mouseSupport = !this.mouseSupport;
        setMessage("Mouse support " + (this.mouseSupport ? "enabled" : "disabled"));
        this.terminal.trackMouse(this.mouseSupport ? Terminal.MouseTracking.Normal : Terminal.MouseTracking.Off);
    }

    void constantCursor() {
        this.constantCursor = !this.constantCursor;
        setMessage("Constant cursor position display " + (this.constantCursor ? "enabled" : "disabled"));
    }

    void oneMoreLine() {
        this.oneMoreLine = !this.oneMoreLine;
        setMessage("Use of one more line for editing " + (this.oneMoreLine ? "enabled" : "disabled"));
    }

    void wrap() {
        this.wrapping = !this.wrapping;
        this.buffer.computeAllOffsets();
        resetDisplay();
        setMessage("Lines wrapping " + (this.wrapping ? "enabled" : "disabled"));
    }

    void clearScreen() {
        resetDisplay();
    }

    void mouseEvent() {
        MouseEvent event = this.terminal.readMouseEvent();
        if (event.getModifiers().isEmpty() && event.getType() == MouseEvent.Type.Released && event.getButton() == MouseEvent.Button.Button1) {
            int x = event.getX();
            int y = event.getY();
            int hdr = this.buffer.computeHeader().size();
            int ftr = computeFooter().size();
            if (y >= hdr) {
                if (y < this.size.getRows() - ftr) {
                    this.buffer.moveTo(x, y - hdr);
                    return;
                }
                int cols = (this.shortcuts.size() + 1) / 2;
                int si = (((y - (this.size.getRows() - ftr)) - 1) * cols) + (x / (this.size.getColumns() / cols));
                String shortcut = null;
                Iterator<String> it = this.shortcuts.keySet().iterator();
                while (true) {
                    si--;
                    if (si < 0 || !it.hasNext()) {
                        break;
                    }
                    shortcut = it.next();
                }
                if (shortcut != null) {
                    this.bindingReader.runMacro(KeyMap.translate(shortcut.replaceAll("M-", "\\\\E")));
                }
            }
        } else if (event.getType() != MouseEvent.Type.Wheel) {
        } else {
            if (event.getButton() == MouseEvent.Button.WheelDown) {
                this.buffer.moveDown(1);
            } else if (event.getButton() == MouseEvent.Button.WheelUp) {
                this.buffer.moveUp(1);
            }
        }
    }

    void enableSuspension() {
        if (!this.restricted && this.vsusp < 0) {
            Attributes attrs = this.terminal.getAttributes();
            attrs.setControlChar(Attributes.ControlChar.VSUSP, this.vsusp);
            this.terminal.setAttributes(attrs);
        }
    }

    void toggleSuspension() {
        if (this.restricted) {
            setMessage("This function is disabled in restricted mode");
        } else if (this.vsusp < 0) {
            setMessage("This function is disabled");
        } else {
            Attributes attrs = this.terminal.getAttributes();
            int toggle = this.vsusp;
            String message = "enabled";
            if (attrs.getControlChar(Attributes.ControlChar.VSUSP) > 0) {
                toggle = 0;
                message = "disabled";
            }
            attrs.setControlChar(Attributes.ControlChar.VSUSP, toggle);
            this.terminal.setAttributes(attrs);
            setMessage("Suspension " + message);
        }
    }

    public String getTitle() {
        return this.title;
    }

    void resetDisplay() {
        this.display.clear();
        this.display.resize(this.size.getRows(), this.size.getColumns());
        for (Buffer buffer : this.buffers) {
            buffer.resetDisplay();
        }
    }

    synchronized void display() {
        display(null);
    }

    synchronized void display(Integer editCursor) {
        int cursor;
        if (this.nbBindings > 0) {
            int i = this.nbBindings - 1;
            this.nbBindings = i;
            if (i == 0) {
                this.message = null;
            }
        }
        List<AttributedString> header = this.buffer.computeHeader();
        List<AttributedString> footer = computeFooter();
        List<AttributedString> newLines = this.buffer.getDisplayedLines((this.size.getRows() - header.size()) - footer.size());
        newLines.addAll(0, header);
        newLines.addAll(footer);
        if (this.editMessage != null) {
            cursor = this.size.cursorPos(this.size.getRows() - footer.size(), this.editMessage.length() + (editCursor != null ? editCursor.intValue() : this.editBuffer.length()));
        } else {
            cursor = this.size.cursorPos(header.size(), this.buffer.getDisplayedCursor());
        }
        this.display.update(newLines, cursor);
        if (this.windowsTerminal) {
            resetDisplay();
        }
    }

    protected List<AttributedString> computeFooter() {
        List<AttributedString> footer = new ArrayList<>();
        if (this.editMessage != null) {
            AttributedStringBuilder sb = new AttributedStringBuilder();
            sb.style(AttributedStyle.INVERSE);
            sb.append((CharSequence) this.editMessage);
            sb.append((CharSequence) this.editBuffer);
            for (int i = this.editMessage.length() + this.editBuffer.length(); i < this.size.getColumns(); i++) {
                sb.append(' ');
            }
            sb.append('\n');
            footer.add(sb.toAttributedString());
        } else if (this.message != null || this.constantCursor) {
            int rwidth = this.size.getColumns();
            String text = "[ " + (this.message == null ? computeCurPos() : this.message) + " ]";
            int len = text.length();
            AttributedStringBuilder sb2 = new AttributedStringBuilder();
            for (int i2 = 0; i2 < (rwidth - len) / 2; i2++) {
                sb2.append(' ');
            }
            sb2.style(AttributedStyle.INVERSE);
            sb2.append((CharSequence) text);
            sb2.append('\n');
            footer.add(sb2.toAttributedString());
        } else {
            footer.add(new AttributedString("\n"));
        }
        Iterator<Map.Entry<String, String>> sit = this.shortcuts.entrySet().iterator();
        int cols = (this.shortcuts.size() + 1) / 2;
        int cw = (this.size.getColumns() - 1) / cols;
        int rem = (this.size.getColumns() - 1) % cols;
        for (int l = 0; l < 2; l++) {
            AttributedStringBuilder sb3 = new AttributedStringBuilder();
            int c = 0;
            while (c < cols) {
                Map.Entry<String, String> entry = sit.hasNext() ? sit.next() : null;
                String key = entry != null ? entry.getKey() : "";
                String val = entry != null ? entry.getValue() : "";
                sb3.style(AttributedStyle.INVERSE);
                sb3.append((CharSequence) key);
                sb3.style(AttributedStyle.DEFAULT);
                sb3.append((CharSequence) " ");
                int nb = ((cw - key.length()) - 1) + (c < rem ? 1 : 0);
                if (val.length() > nb) {
                    sb3.append((CharSequence) val.substring(0, nb));
                } else {
                    sb3.append((CharSequence) val);
                    if (c < cols - 1) {
                        for (int i3 = 0; i3 < nb - val.length(); i3++) {
                            sb3.append((CharSequence) " ");
                        }
                    }
                }
                c++;
            }
            sb3.append('\n');
            footer.add(sb3.toAttributedString());
        }
        return footer;
    }

    protected void handle(Terminal.Signal signal) {
        if (this.buffer != null) {
            this.size.copy(this.terminal.getSize());
            this.buffer.computeAllOffsets();
            this.buffer.moveToChar(this.buffer.offsetInLine + this.buffer.column);
            resetDisplay();
            display();
        }
    }

    protected void bindKeys() {
        this.keys = new KeyMap<>();
        if (!this.view) {
            this.keys.setUnicode(Operation.INSERT);
            for (char i = ' '; i < 128; i = (char) (i + 1)) {
                this.keys.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
            }
            this.keys.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
            for (char i2 = 'A'; i2 <= 'Z'; i2 = (char) (i2 + 1)) {
                this.keys.bind((KeyMap<Operation>) Operation.DO_LOWER_CASE, KeyMap.alt(i2));
            }
            this.keys.bind((KeyMap<Operation>) Operation.WRITE, KeyMap.ctrl('O'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f3));
            this.keys.bind((KeyMap<Operation>) Operation.JUSTIFY_PARAGRAPH, KeyMap.ctrl('J'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f4));
            this.keys.bind((KeyMap<Operation>) Operation.CUT, KeyMap.ctrl('K'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f9));
            this.keys.bind((KeyMap<Operation>) Operation.UNCUT, KeyMap.ctrl('U'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f10));
            this.keys.bind((KeyMap<Operation>) Operation.REPLACE, KeyMap.ctrl('\\'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f14), KeyMap.alt('r'));
            this.keys.bind((KeyMap<Operation>) Operation.MARK, KeyMap.ctrl('^'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f15), KeyMap.alt('a'));
            this.keys.bind((KeyMap<Operation>) Operation.COPY, KeyMap.alt('^'), KeyMap.alt('6'));
            this.keys.bind((KeyMap<Operation>) Operation.INDENT, KeyMap.alt('}'));
            this.keys.bind((KeyMap<Operation>) Operation.UNINDENT, KeyMap.alt('{'));
            this.keys.bind((KeyMap<Operation>) Operation.VERBATIM, KeyMap.alt('v'));
            this.keys.bind((KeyMap<Operation>) Operation.INSERT, KeyMap.ctrl('I'), KeyMap.ctrl('M'));
            this.keys.bind((KeyMap<Operation>) Operation.DELETE, KeyMap.ctrl('D'), KeyMap.key(this.terminal, InfoCmp.Capability.key_dc));
            this.keys.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.ctrl('H'));
            this.keys.bind((KeyMap<Operation>) Operation.CUT_TO_END, KeyMap.alt('t'));
            this.keys.bind((KeyMap<Operation>) Operation.JUSTIFY_FILE, KeyMap.alt('j'));
            this.keys.bind((KeyMap<Operation>) Operation.AUTO_INDENT, KeyMap.alt('i'));
            this.keys.bind((KeyMap<Operation>) Operation.CUT_TO_END_TOGGLE, KeyMap.alt('k'));
            this.keys.bind((KeyMap<Operation>) Operation.TABS_TO_SPACE, KeyMap.alt('q'));
        } else {
            this.keys.bind((KeyMap<Operation>) Operation.NEXT_PAGE, " ", "f");
            this.keys.bind((KeyMap<Operation>) Operation.PREV_PAGE, "b");
        }
        this.keys.bind((KeyMap<Operation>) Operation.NEXT_PAGE, KeyMap.ctrl('V'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f8));
        this.keys.bind((KeyMap<Operation>) Operation.PREV_PAGE, KeyMap.ctrl('Y'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f7));
        this.keys.bind((KeyMap<Operation>) Operation.HELP, KeyMap.ctrl('G'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f1));
        this.keys.bind((KeyMap<Operation>) Operation.QUIT, KeyMap.ctrl('X'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f2));
        this.keys.bind((KeyMap<Operation>) Operation.READ, KeyMap.ctrl('R'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f5));
        this.keys.bind((KeyMap<Operation>) Operation.SEARCH, KeyMap.ctrl('W'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f6));
        this.keys.bind((KeyMap<Operation>) Operation.CUR_POS, KeyMap.ctrl('C'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f11));
        this.keys.bind((KeyMap<Operation>) Operation.TO_SPELL, KeyMap.ctrl('T'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f11));
        this.keys.bind((KeyMap<Operation>) Operation.GOTO, KeyMap.ctrl('_'), KeyMap.key(this.terminal, InfoCmp.Capability.key_f13), KeyMap.alt('g'));
        this.keys.bind((KeyMap<Operation>) Operation.NEXT_SEARCH, KeyMap.key(this.terminal, InfoCmp.Capability.key_f16), KeyMap.alt('w'));
        this.keys.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.ctrl('F'));
        this.keys.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.ctrl('B'));
        this.keys.bind((KeyMap<Operation>) Operation.NEXT_WORD, KeyMap.ctrl(' '));
        this.keys.bind((KeyMap<Operation>) Operation.PREV_WORD, KeyMap.alt(' '));
        this.keys.bind((KeyMap<Operation>) Operation.UP, KeyMap.ctrl('P'));
        this.keys.bind((KeyMap<Operation>) Operation.DOWN, KeyMap.ctrl('N'));
        this.keys.bind((KeyMap<Operation>) Operation.BEGINNING_OF_LINE, KeyMap.ctrl('A'), KeyMap.key(this.terminal, InfoCmp.Capability.key_home));
        this.keys.bind((KeyMap<Operation>) Operation.END_OF_LINE, KeyMap.ctrl('E'), KeyMap.key(this.terminal, InfoCmp.Capability.key_end));
        this.keys.bind((KeyMap<Operation>) Operation.BEGINNING_OF_PARAGRAPH, KeyMap.alt('('), KeyMap.alt('9'));
        this.keys.bind((KeyMap<Operation>) Operation.END_OF_PARAGRAPH, KeyMap.alt(')'), KeyMap.alt('0'));
        this.keys.bind((KeyMap<Operation>) Operation.FIRST_LINE, KeyMap.alt('\\'), KeyMap.alt('|'));
        this.keys.bind((KeyMap<Operation>) Operation.LAST_LINE, KeyMap.alt('/'), KeyMap.alt('?'));
        this.keys.bind((KeyMap<Operation>) Operation.MATCHING, KeyMap.alt(']'));
        this.keys.bind((KeyMap<Operation>) Operation.SCROLL_UP, KeyMap.alt('-'), KeyMap.alt('_'));
        this.keys.bind((KeyMap<Operation>) Operation.SCROLL_DOWN, KeyMap.alt('+'), KeyMap.alt('='));
        this.keys.bind((KeyMap<Operation>) Operation.PREV_BUFFER, KeyMap.alt('<'));
        this.keys.bind((KeyMap<Operation>) Operation.NEXT_BUFFER, KeyMap.alt('>'));
        this.keys.bind((KeyMap<Operation>) Operation.PREV_BUFFER, KeyMap.alt(','));
        this.keys.bind((KeyMap<Operation>) Operation.NEXT_BUFFER, KeyMap.alt('.'));
        this.keys.bind((KeyMap<Operation>) Operation.COUNT, KeyMap.alt('d'));
        this.keys.bind((KeyMap<Operation>) Operation.CLEAR_SCREEN, KeyMap.ctrl('L'));
        this.keys.bind((KeyMap<Operation>) Operation.HELP, KeyMap.alt('x'));
        this.keys.bind((KeyMap<Operation>) Operation.CONSTANT_CURSOR, KeyMap.alt('c'));
        this.keys.bind((KeyMap<Operation>) Operation.ONE_MORE_LINE, KeyMap.alt('o'));
        this.keys.bind((KeyMap<Operation>) Operation.SMOOTH_SCROLLING, KeyMap.alt('s'));
        this.keys.bind((KeyMap<Operation>) Operation.MOUSE_SUPPORT, KeyMap.alt('m'));
        this.keys.bind((KeyMap<Operation>) Operation.WHITESPACE, KeyMap.alt('p'));
        this.keys.bind((KeyMap<Operation>) Operation.HIGHLIGHT, KeyMap.alt('y'));
        this.keys.bind((KeyMap<Operation>) Operation.SMART_HOME_KEY, KeyMap.alt('h'));
        this.keys.bind((KeyMap<Operation>) Operation.WRAP, KeyMap.alt('l'));
        this.keys.bind((KeyMap<Operation>) Operation.BACKUP, KeyMap.alt('b'));
        this.keys.bind((KeyMap<Operation>) Operation.NUMBERS, KeyMap.alt('n'));
        this.keys.bind((KeyMap<Operation>) Operation.UP, KeyMap.key(this.terminal, InfoCmp.Capability.key_up));
        this.keys.bind((KeyMap<Operation>) Operation.DOWN, KeyMap.key(this.terminal, InfoCmp.Capability.key_down));
        this.keys.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        this.keys.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        this.keys.bind((KeyMap<Operation>) Operation.MOUSE_EVENT, KeyMap.key(this.terminal, InfoCmp.Capability.key_mouse));
        this.keys.bind((KeyMap<Operation>) Operation.TOGGLE_SUSPENSION, KeyMap.alt('z'));
        this.keys.bind((KeyMap<Operation>) Operation.NEXT_PAGE, KeyMap.key(this.terminal, InfoCmp.Capability.key_npage));
        this.keys.bind((KeyMap<Operation>) Operation.PREV_PAGE, KeyMap.key(this.terminal, InfoCmp.Capability.key_ppage));
    }
}
