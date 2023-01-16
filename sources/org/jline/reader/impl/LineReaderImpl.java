package org.jline.reader.impl;

import dev.morphia.mapping.Mapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.IOError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import net.bytebuddy.utility.JavaConstant;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.reader.Binding;
import org.jline.reader.Buffer;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.CompletingParsedLine;
import org.jline.reader.CompletionMatcher;
import org.jline.reader.EOFError;
import org.jline.reader.Editor;
import org.jline.reader.EndOfFileException;
import org.jline.reader.Expander;
import org.jline.reader.Highlighter;
import org.jline.reader.History;
import org.jline.reader.LineReader;
import org.jline.reader.Macro;
import org.jline.reader.MaskingCallback;
import org.jline.reader.ParsedLine;
import org.jline.reader.Parser;
import org.jline.reader.Reference;
import org.jline.reader.SyntaxError;
import org.jline.reader.UserInterruptException;
import org.jline.reader.Widget;
import org.jline.reader.impl.history.DefaultHistory;
import org.jline.terminal.Attributes;
import org.jline.terminal.Cursor;
import org.jline.terminal.MouseEvent;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedCharSequence;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.Curses;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;
import org.jline.utils.Log;
import org.jline.utils.Status;
import org.jline.utils.StyleResolver;
import org.jline.utils.WCWidth;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.net.SyslogAppender;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl.class */
public class LineReaderImpl implements LineReader, Flushable {
    public static final char NULL_MASK = 0;
    public static final int TAB_WIDTH = 4;
    public static final String DEFAULT_WORDCHARS = "*?_-.[]~=/&;!#$%^(){}<>";
    public static final String DEFAULT_REMOVE_SUFFIX_CHARS = " \t\n;&|";
    public static final String DEFAULT_COMMENT_BEGIN = "#";
    public static final String DEFAULT_SEARCH_TERMINATORS = "\u001b\n";
    public static final String DEFAULT_BELL_STYLE = "";
    public static final int DEFAULT_LIST_MAX = 100;
    public static final int DEFAULT_MENU_LIST_MAX = Integer.MAX_VALUE;
    public static final int DEFAULT_ERRORS = 2;
    public static final long DEFAULT_BLINK_MATCHING_PAREN = 500;
    public static final long DEFAULT_AMBIGUOUS_BINDING = 1000;
    public static final String DEFAULT_SECONDARY_PROMPT_PATTERN = "%M> ";
    public static final String DEFAULT_OTHERS_GROUP_NAME = "others";
    public static final String DEFAULT_ORIGINAL_GROUP_NAME = "original";
    public static final String DEFAULT_COMPLETION_STYLE_STARTING = "fg:cyan";
    public static final String DEFAULT_COMPLETION_STYLE_DESCRIPTION = "fg:bright-black";
    public static final String DEFAULT_COMPLETION_STYLE_GROUP = "fg:bright-magenta,bold";
    public static final String DEFAULT_COMPLETION_STYLE_SELECTION = "inverse";
    public static final String DEFAULT_COMPLETION_STYLE_BACKGROUND = "bg:default";
    public static final String DEFAULT_COMPLETION_STYLE_LIST_STARTING = "fg:cyan";
    public static final String DEFAULT_COMPLETION_STYLE_LIST_DESCRIPTION = "fg:bright-black";
    public static final String DEFAULT_COMPLETION_STYLE_LIST_GROUP = "fg:black,bold";
    public static final String DEFAULT_COMPLETION_STYLE_LIST_SELECTION = "inverse";
    public static final String DEFAULT_COMPLETION_STYLE_LIST_BACKGROUND = "bg:bright-magenta";
    public static final int DEFAULT_INDENTATION = 0;
    public static final int DEFAULT_FEATURES_MAX_BUFFER_SIZE = 1000;
    public static final int DEFAULT_SUGGESTIONS_MIN_BUFFER_SIZE = 1;
    private static final int MIN_ROWS = 3;
    public static final String BRACKETED_PASTE_ON = "\u001b[?2004h";
    public static final String BRACKETED_PASTE_OFF = "\u001b[?2004l";
    public static final String BRACKETED_PASTE_BEGIN = "\u001b[200~";
    public static final String BRACKETED_PASTE_END = "\u001b[201~";
    public static final String FOCUS_IN_SEQ = "\u001b[I";
    public static final String FOCUS_OUT_SEQ = "\u001b[O";
    protected final Terminal terminal;
    protected final String appName;
    protected final Map<String, KeyMap<Binding>> keyMaps;
    protected final Map<String, Object> variables;
    protected History history;
    protected Completer completer;
    protected Highlighter highlighter;
    protected Parser parser;
    protected Expander expander;
    protected CompletionMatcher completionMatcher;
    protected final Map<LineReader.Option, Boolean> options;
    protected final Buffer buf;
    protected String tailTip;
    protected LineReader.SuggestionType autosuggestion;
    protected final Size size;
    protected AttributedString prompt;
    protected AttributedString rightPrompt;
    protected MaskingCallback maskingCallback;
    protected Map<Integer, String> modifiedHistory;
    protected Buffer historyBuffer;
    protected CharSequence searchBuffer;
    protected StringBuffer searchTerm;
    protected boolean searchFailing;
    protected boolean searchBackward;
    protected int searchIndex;
    protected boolean doAutosuggestion;
    protected final BindingReader bindingReader;
    protected int findChar;
    protected int findDir;
    protected int findTailAdd;
    private int searchDir;
    private String searchString;
    protected int regionMark;
    protected LineReader.RegionType regionActive;
    private boolean forceChar;
    private boolean forceLine;
    protected String yankBuffer;
    protected ViMoveMode viMoveMode;
    protected KillRing killRing;
    protected UndoTree<Buffer> undo;
    protected boolean isUndo;
    protected final ReentrantLock lock;
    protected State state;
    protected final AtomicBoolean startedReading;
    protected boolean reading;
    protected Supplier<AttributedString> post;
    protected Map<String, Widget> builtinWidgets;
    protected Map<String, Widget> widgets;
    protected int count;
    protected int mult;
    protected int universal;
    protected int repeatCount;
    protected boolean isArgDigit;
    protected ParsedLine parsedLine;
    protected boolean skipRedisplay;
    protected Display display;
    protected boolean overTyping;
    protected String keyMap;
    protected int smallTerminalOffset;
    protected boolean nextCommandFromHistory;
    protected int nextHistoryId;
    protected List<String> commandsBuffer;
    int candidateStartPosition;
    private static final String DESC_PREFIX = "(";
    private static final String DESC_SUFFIX = ")";
    private static final int MARGIN_BETWEEN_DISPLAY_AND_DESC = 1;
    private static final int MARGIN_BETWEEN_COLUMNS = 3;
    private static final int MENU_LIST_WIDTH = 25;

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$BellType.class */
    public enum BellType {
        NONE,
        AUDIBLE,
        VISIBLE
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$CompletionType.class */
    public enum CompletionType {
        Expand,
        ExpandComplete,
        Complete,
        List
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$State.class */
    public enum State {
        NORMAL,
        DONE,
        IGNORE,
        EOF,
        INTERRUPT
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$ViMoveMode.class */
    public enum ViMoveMode {
        NORMAL,
        YANK,
        DELETE,
        CHANGE
    }

    public LineReaderImpl(Terminal terminal) throws IOException {
        this(terminal, terminal.getName(), null);
    }

    public LineReaderImpl(Terminal terminal, String appName) throws IOException {
        this(terminal, appName, null);
    }

    public LineReaderImpl(Terminal terminal, String appName, Map<String, Object> variables) {
        this.history = new DefaultHistory();
        this.completer = null;
        this.highlighter = new DefaultHighlighter();
        this.parser = new DefaultParser();
        this.expander = new DefaultExpander();
        this.completionMatcher = new CompletionMatcherImpl();
        this.options = new HashMap();
        this.buf = new BufferImpl();
        this.tailTip = "";
        this.autosuggestion = LineReader.SuggestionType.NONE;
        this.size = new Size();
        this.prompt = AttributedString.EMPTY;
        this.rightPrompt = AttributedString.EMPTY;
        this.modifiedHistory = new HashMap();
        this.historyBuffer = null;
        this.searchTerm = null;
        this.searchIndex = -1;
        this.yankBuffer = "";
        this.viMoveMode = ViMoveMode.NORMAL;
        this.killRing = new KillRing();
        this.undo = new UndoTree<>(this::setBuffer);
        this.lock = new ReentrantLock();
        this.state = State.DONE;
        this.startedReading = new AtomicBoolean();
        this.universal = 4;
        this.overTyping = false;
        this.smallTerminalOffset = 0;
        this.nextCommandFromHistory = false;
        this.nextHistoryId = -1;
        this.commandsBuffer = new ArrayList();
        this.candidateStartPosition = 0;
        Objects.requireNonNull(terminal, "terminal can not be null");
        this.terminal = terminal;
        this.appName = appName == null ? "JLine" : appName;
        if (variables != null) {
            this.variables = variables;
        } else {
            this.variables = new HashMap();
        }
        this.keyMaps = defaultKeyMaps();
        this.builtinWidgets = builtinWidgets();
        this.widgets = new HashMap(this.builtinWidgets);
        this.bindingReader = new BindingReader(terminal.reader());
        doDisplay();
    }

    @Override // org.jline.reader.LineReader
    public Terminal getTerminal() {
        return this.terminal;
    }

    @Override // org.jline.reader.LineReader
    public String getAppName() {
        return this.appName;
    }

    @Override // org.jline.reader.LineReader
    public Map<String, KeyMap<Binding>> getKeyMaps() {
        return this.keyMaps;
    }

    @Override // org.jline.reader.LineReader
    public KeyMap<Binding> getKeys() {
        return this.keyMaps.get(this.keyMap);
    }

    @Override // org.jline.reader.LineReader
    public Map<String, Widget> getWidgets() {
        return this.widgets;
    }

    @Override // org.jline.reader.LineReader
    public Map<String, Widget> getBuiltinWidgets() {
        return Collections.unmodifiableMap(this.builtinWidgets);
    }

    @Override // org.jline.reader.LineReader
    public Buffer getBuffer() {
        return this.buf;
    }

    @Override // org.jline.reader.LineReader
    public void setAutosuggestion(LineReader.SuggestionType type) {
        this.autosuggestion = type;
    }

    @Override // org.jline.reader.LineReader
    public LineReader.SuggestionType getAutosuggestion() {
        return this.autosuggestion;
    }

    @Override // org.jline.reader.LineReader
    public String getTailTip() {
        return this.tailTip;
    }

    @Override // org.jline.reader.LineReader
    public void setTailTip(String tailTip) {
        this.tailTip = tailTip;
    }

    @Override // org.jline.reader.LineReader
    public void runMacro(String macro) {
        this.bindingReader.runMacro(macro);
    }

    @Override // org.jline.reader.LineReader
    public MouseEvent readMouseEvent() {
        Terminal terminal = this.terminal;
        BindingReader bindingReader = this.bindingReader;
        Objects.requireNonNull(bindingReader);
        return terminal.readMouseEvent(this::readCharacter);
    }

    public void setCompleter(Completer completer) {
        this.completer = completer;
    }

    public Completer getCompleter() {
        return this.completer;
    }

    public void setHistory(History history) {
        Objects.requireNonNull(history);
        this.history = history;
    }

    @Override // org.jline.reader.LineReader
    public History getHistory() {
        return this.history;
    }

    public void setHighlighter(Highlighter highlighter) {
        this.highlighter = highlighter;
    }

    @Override // org.jline.reader.LineReader
    public Highlighter getHighlighter() {
        return this.highlighter;
    }

    @Override // org.jline.reader.LineReader
    public Parser getParser() {
        return this.parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    @Override // org.jline.reader.LineReader
    public Expander getExpander() {
        return this.expander;
    }

    public void setExpander(Expander expander) {
        this.expander = expander;
    }

    public void setCompletionMatcher(CompletionMatcher completionMatcher) {
        this.completionMatcher = completionMatcher;
    }

    @Override // org.jline.reader.LineReader
    public String readLine() throws UserInterruptException, EndOfFileException {
        return readLine((String) null, (String) null, (MaskingCallback) null, (String) null);
    }

    @Override // org.jline.reader.LineReader
    public String readLine(Character mask) throws UserInterruptException, EndOfFileException {
        return readLine((String) null, (String) null, mask, (String) null);
    }

    @Override // org.jline.reader.LineReader
    public String readLine(String prompt) throws UserInterruptException, EndOfFileException {
        return readLine(prompt, (String) null, (MaskingCallback) null, (String) null);
    }

    @Override // org.jline.reader.LineReader
    public String readLine(String prompt, Character mask) throws UserInterruptException, EndOfFileException {
        return readLine(prompt, (String) null, mask, (String) null);
    }

    @Override // org.jline.reader.LineReader
    public String readLine(String prompt, Character mask, String buffer) throws UserInterruptException, EndOfFileException {
        return readLine(prompt, (String) null, mask, buffer);
    }

    @Override // org.jline.reader.LineReader
    public String readLine(String prompt, String rightPrompt, Character mask, String buffer) throws UserInterruptException, EndOfFileException {
        return readLine(prompt, rightPrompt, mask != null ? new SimpleMaskingCallback(mask) : null, buffer);
    }

    @Override // org.jline.reader.LineReader
    public String readLine(String prompt, String rightPrompt, MaskingCallback maskingCallback, String buffer) throws UserInterruptException, EndOfFileException {
        if (!this.commandsBuffer.isEmpty()) {
            String cmd = this.commandsBuffer.remove(0);
            boolean done = false;
            do {
                try {
                    this.parser.parse(cmd, cmd.length() + 1, Parser.ParseContext.ACCEPT_LINE);
                    done = true;
                } catch (EOFError e) {
                    if (this.commandsBuffer.isEmpty()) {
                        throw new IllegalArgumentException("Incompleted command: \n" + cmd);
                    }
                    cmd = (cmd + "\n") + this.commandsBuffer.remove(0);
                } catch (SyntaxError e2) {
                    done = true;
                } catch (Exception e3) {
                    this.commandsBuffer.clear();
                    throw new IllegalArgumentException(e3.getMessage());
                }
            } while (!done);
            AttributedStringBuilder sb = new AttributedStringBuilder();
            sb.styled((v0) -> {
                return v0.bold();
            }, cmd);
            sb.toAttributedString().println(this.terminal);
            this.terminal.flush();
            return finish(cmd);
        } else if (!this.startedReading.compareAndSet(false, true)) {
            throw new IllegalStateException();
        } else {
            try {
                Thread readLineThread = Thread.currentThread();
                boolean dumb = isTerminalDumb();
                try {
                    this.maskingCallback = maskingCallback;
                    this.repeatCount = 0;
                    this.mult = 1;
                    this.regionActive = LineReader.RegionType.NONE;
                    this.regionMark = -1;
                    this.smallTerminalOffset = 0;
                    this.state = State.NORMAL;
                    this.modifiedHistory.clear();
                    setPrompt(prompt);
                    setRightPrompt(rightPrompt);
                    this.buf.clear();
                    if (buffer != null) {
                        this.buf.write(buffer);
                    }
                    if (!this.nextCommandFromHistory || this.nextHistoryId <= 0) {
                        this.nextHistoryId = -1;
                    } else {
                        if (this.history.size() > this.nextHistoryId) {
                            this.history.moveTo(this.nextHistoryId);
                        } else {
                            this.history.moveTo(this.history.last());
                        }
                        this.buf.write(this.history.current());
                    }
                    this.nextCommandFromHistory = false;
                    this.undo.clear();
                    this.parsedLine = null;
                    this.keyMap = LineReader.MAIN;
                    if (this.history != null) {
                        this.history.attach(this);
                    }
                    this.lock.lock();
                    this.reading = true;
                    Terminal.SignalHandler previousIntrHandler = this.terminal.handle(Terminal.Signal.INT, signal -> {
                        readLineThread.interrupt();
                    });
                    Terminal.SignalHandler previousWinchHandler = this.terminal.handle(Terminal.Signal.WINCH, this::handleSignal);
                    Terminal.SignalHandler previousContHandler = this.terminal.handle(Terminal.Signal.CONT, this::handleSignal);
                    Attributes originalAttributes = this.terminal.enterRawMode();
                    doDisplay();
                    if (!dumb) {
                        this.terminal.puts(InfoCmp.Capability.keypad_xmit, new Object[0]);
                        if (isSet(LineReader.Option.AUTO_FRESH_LINE)) {
                            try {
                                callWidget(LineReader.FRESH_LINE);
                            } catch (Throwable th) {
                                this.lock.unlock();
                                throw th;
                            }
                        }
                        if (isSet(LineReader.Option.MOUSE)) {
                            this.terminal.trackMouse(Terminal.MouseTracking.Normal);
                        }
                        if (isSet(LineReader.Option.BRACKETED_PASTE)) {
                            this.terminal.writer().write(BRACKETED_PASTE_ON);
                        }
                    } else {
                        Attributes attr = new Attributes(originalAttributes);
                        attr.setInputFlag(Attributes.InputFlag.IGNCR, true);
                        this.terminal.setAttributes(attr);
                    }
                    callWidget(LineReader.CALLBACK_INIT);
                    this.undo.newState(this.buf.copy());
                    redrawLine();
                    redisplay();
                    this.lock.unlock();
                    while (true) {
                        KeyMap<Binding> local = null;
                        if (isInViCmdMode() && this.regionActive != LineReader.RegionType.NONE) {
                            local = this.keyMaps.get(LineReader.VISUAL);
                        }
                        Binding o = readBinding(getKeys(), local);
                        if (o == null) {
                            throw new EndOfFileException().partialLine(this.buf.length() > 0 ? this.buf.toString() : null);
                        }
                        Log.trace("Binding: ", o);
                        if (this.buf.length() == 0 && getLastBinding().charAt(0) == originalAttributes.getControlChar(Attributes.ControlChar.VEOF)) {
                            throw new EndOfFileException();
                        }
                        this.isArgDigit = false;
                        this.count = (this.repeatCount == 0 ? 1 : this.repeatCount) * this.mult;
                        this.isUndo = false;
                        if (this.regionActive == LineReader.RegionType.PASTE) {
                            this.regionActive = LineReader.RegionType.NONE;
                        }
                        this.lock.lock();
                        Buffer copy = this.buf.length() <= getInt(LineReader.FEATURES_MAX_BUFFER_SIZE, 1000) ? this.buf.copy() : null;
                        if (!getWidget(o).apply()) {
                            try {
                                beep();
                            } catch (Throwable th2) {
                                this.lock.unlock();
                                throw th2;
                            }
                        }
                        if (!this.isUndo && copy != null && this.buf.length() <= getInt(LineReader.FEATURES_MAX_BUFFER_SIZE, 1000) && !copy.toString().equals(this.buf.toString())) {
                            this.undo.newState(this.buf.copy());
                        }
                        switch (this.state) {
                            case DONE:
                                String finishBuffer = finishBuffer();
                                this.lock.unlock();
                                try {
                                    this.lock.lock();
                                    this.reading = false;
                                    cleanup();
                                    if (originalAttributes != null) {
                                        this.terminal.setAttributes(originalAttributes);
                                    }
                                    if (previousIntrHandler != null) {
                                        this.terminal.handle(Terminal.Signal.INT, previousIntrHandler);
                                    }
                                    if (previousWinchHandler != null) {
                                        this.terminal.handle(Terminal.Signal.WINCH, previousWinchHandler);
                                    }
                                    if (previousContHandler != null) {
                                        this.terminal.handle(Terminal.Signal.CONT, previousContHandler);
                                    }
                                    this.lock.unlock();
                                    this.startedReading.set(false);
                                    return finishBuffer;
                                } catch (Throwable th3) {
                                    this.lock.unlock();
                                    throw th3;
                                }
                            case IGNORE:
                                this.lock.unlock();
                                try {
                                    this.lock.lock();
                                    this.reading = false;
                                    cleanup();
                                    if (originalAttributes != null) {
                                        this.terminal.setAttributes(originalAttributes);
                                    }
                                    if (previousIntrHandler != null) {
                                        this.terminal.handle(Terminal.Signal.INT, previousIntrHandler);
                                    }
                                    if (previousWinchHandler != null) {
                                        this.terminal.handle(Terminal.Signal.WINCH, previousWinchHandler);
                                    }
                                    if (previousContHandler != null) {
                                        this.terminal.handle(Terminal.Signal.CONT, previousContHandler);
                                    }
                                    this.lock.unlock();
                                    this.startedReading.set(false);
                                    return "";
                                } catch (Throwable th4) {
                                    this.lock.unlock();
                                    throw th4;
                                }
                            case EOF:
                                throw new EndOfFileException();
                            case INTERRUPT:
                                throw new UserInterruptException(this.buf.toString());
                            default:
                                if (!this.isArgDigit) {
                                    this.repeatCount = 0;
                                    this.mult = 1;
                                }
                                if (!dumb) {
                                    redisplay();
                                }
                                this.lock.unlock();
                        }
                    }
                } catch (IOError e4) {
                    if (e4.getCause() instanceof InterruptedIOException) {
                        throw new UserInterruptException(this.buf.toString());
                    }
                    throw e4;
                }
            } catch (Throwable th5) {
                try {
                    this.lock.lock();
                    this.reading = false;
                    cleanup();
                    if (0 != 0) {
                        this.terminal.setAttributes(null);
                    }
                    if (0 != 0) {
                        this.terminal.handle(Terminal.Signal.INT, null);
                    }
                    if (0 != 0) {
                        this.terminal.handle(Terminal.Signal.WINCH, null);
                    }
                    if (0 != 0) {
                        this.terminal.handle(Terminal.Signal.CONT, null);
                    }
                    this.lock.unlock();
                    this.startedReading.set(false);
                    throw th5;
                } catch (Throwable th6) {
                    this.lock.unlock();
                    throw th6;
                }
            }
        }
    }

    private boolean isTerminalDumb() {
        return "dumb".equals(this.terminal.getType()) || "dumb-color".equals(this.terminal.getType());
    }

    private void doDisplay() {
        this.size.copy(this.terminal.getBufferSize());
        this.display = new Display(this.terminal, false);
        this.display.resize(this.size.getRows(), this.size.getColumns());
        if (isSet(LineReader.Option.DELAY_LINE_WRAP)) {
            this.display.setDelayLineWrap(true);
        }
    }

    @Override // org.jline.reader.LineReader
    public void printAbove(String str) {
        try {
            this.lock.lock();
            boolean reading = this.reading;
            if (reading) {
                this.display.update(Collections.emptyList(), 0);
            }
            if (str.endsWith("\n") || str.endsWith("\n\u001b[m") || str.endsWith("\n\u001b[0m")) {
                this.terminal.writer().print(str);
            } else {
                this.terminal.writer().println(str);
            }
            if (reading) {
                redisplay(false);
            }
            this.terminal.flush();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.jline.reader.LineReader
    public void printAbove(AttributedString str) {
        printAbove(str.toAnsi(this.terminal));
    }

    @Override // org.jline.reader.LineReader
    public boolean isReading() {
        try {
            this.lock.lock();
            return this.reading;
        } finally {
            this.lock.unlock();
        }
    }

    protected boolean freshLine() {
        boolean wrapAtEol = this.terminal.getBooleanCapability(InfoCmp.Capability.auto_right_margin);
        boolean delayedWrapAtEol = wrapAtEol && this.terminal.getBooleanCapability(InfoCmp.Capability.eat_newline_glitch);
        AttributedStringBuilder sb = new AttributedStringBuilder();
        sb.style(AttributedStyle.DEFAULT.foreground(8));
        sb.append((CharSequence) "~");
        sb.style(AttributedStyle.DEFAULT);
        if (!wrapAtEol || delayedWrapAtEol) {
            for (int i = 0; i < this.size.getColumns() - 1; i++) {
                sb.append((CharSequence) " ");
            }
            sb.append((CharSequence) KeyMap.key(this.terminal, InfoCmp.Capability.carriage_return));
            sb.append((CharSequence) " ");
            sb.append((CharSequence) KeyMap.key(this.terminal, InfoCmp.Capability.carriage_return));
        } else {
            String el = this.terminal.getStringCapability(InfoCmp.Capability.clr_eol);
            if (el != null) {
                Curses.tputs(sb, el, new Object[0]);
            }
            for (int i2 = 0; i2 < this.size.getColumns() - 2; i2++) {
                sb.append((CharSequence) " ");
            }
            sb.append((CharSequence) KeyMap.key(this.terminal, InfoCmp.Capability.carriage_return));
            sb.append((CharSequence) " ");
            sb.append((CharSequence) KeyMap.key(this.terminal, InfoCmp.Capability.carriage_return));
        }
        sb.print(this.terminal);
        return true;
    }

    @Override // org.jline.reader.LineReader
    public void callWidget(String name) {
        Widget w;
        try {
            this.lock.lock();
            if (!this.reading) {
                throw new IllegalStateException("Widgets can only be called during a `readLine` call");
            }
            if (name.startsWith(Mapper.IGNORED_FIELDNAME)) {
                w = this.builtinWidgets.get(name.substring(1));
            } else {
                w = this.widgets.get(name);
            }
            if (w != null) {
                w.apply();
            }
        } finally {
            this.lock.unlock();
        }
    }

    public boolean redrawLine() {
        this.display.reset();
        return true;
    }

    public void putString(CharSequence str) {
        this.buf.write(str, this.overTyping);
    }

    @Override // java.io.Flushable
    public void flush() {
        this.terminal.flush();
    }

    public boolean isKeyMap(String name) {
        return this.keyMap.equals(name);
    }

    public int readCharacter() {
        if (!this.lock.isHeldByCurrentThread()) {
            return this.bindingReader.readCharacter();
        }
        try {
            this.lock.unlock();
            return this.bindingReader.readCharacter();
        } finally {
            this.lock.lock();
        }
    }

    public int peekCharacter(long timeout) {
        return this.bindingReader.peekCharacter(timeout);
    }

    protected <T> T doReadBinding(KeyMap<T> keys, KeyMap<T> local) {
        if (!this.lock.isHeldByCurrentThread()) {
            return (T) this.bindingReader.readBinding(keys, local);
        }
        try {
            this.lock.unlock();
            T t = (T) this.bindingReader.readBinding(keys, local);
            this.lock.lock();
            return t;
        } catch (Throwable th) {
            this.lock.lock();
            throw th;
        }
    }

    protected String doReadStringUntil(String sequence) {
        if (!this.lock.isHeldByCurrentThread()) {
            return this.bindingReader.readStringUntil(sequence);
        }
        try {
            this.lock.unlock();
            return this.bindingReader.readStringUntil(sequence);
        } finally {
            this.lock.lock();
        }
    }

    public Binding readBinding(KeyMap<Binding> keys) {
        return readBinding(keys, null);
    }

    public Binding readBinding(KeyMap<Binding> keys, KeyMap<Binding> local) {
        Binding o = (Binding) doReadBinding(keys, local);
        if (o instanceof Reference) {
            String ref = ((Reference) o).name();
            if (!LineReader.YANK_POP.equals(ref) && !LineReader.YANK.equals(ref)) {
                this.killRing.resetLastYank();
            }
            if (!LineReader.KILL_LINE.equals(ref) && !LineReader.KILL_WHOLE_LINE.equals(ref) && !LineReader.BACKWARD_KILL_WORD.equals(ref) && !LineReader.KILL_WORD.equals(ref)) {
                this.killRing.resetLastKill();
            }
        }
        return o;
    }

    @Override // org.jline.reader.LineReader
    public ParsedLine getParsedLine() {
        return this.parsedLine;
    }

    @Override // org.jline.reader.LineReader
    public String getLastBinding() {
        return this.bindingReader.getLastBinding();
    }

    @Override // org.jline.reader.LineReader
    public String getSearchTerm() {
        if (this.searchTerm != null) {
            return this.searchTerm.toString();
        }
        return null;
    }

    @Override // org.jline.reader.LineReader
    public LineReader.RegionType getRegionActive() {
        return this.regionActive;
    }

    @Override // org.jline.reader.LineReader
    public int getRegionMark() {
        return this.regionMark;
    }

    @Override // org.jline.reader.LineReader
    public boolean setKeyMap(String name) {
        if (this.keyMaps.get(name) == null) {
            return false;
        }
        this.keyMap = name;
        if (!this.reading) {
            return true;
        }
        callWidget(LineReader.CALLBACK_KEYMAP);
        return true;
    }

    @Override // org.jline.reader.LineReader
    public String getKeyMap() {
        return this.keyMap;
    }

    @Override // org.jline.reader.LineReader
    public LineReader variable(String name, Object value) {
        this.variables.put(name, value);
        return this;
    }

    @Override // org.jline.reader.LineReader
    public Map<String, Object> getVariables() {
        return this.variables;
    }

    @Override // org.jline.reader.LineReader
    public Object getVariable(String name) {
        return this.variables.get(name);
    }

    @Override // org.jline.reader.LineReader
    public void setVariable(String name, Object value) {
        this.variables.put(name, value);
    }

    @Override // org.jline.reader.LineReader
    public LineReader option(LineReader.Option option, boolean value) {
        this.options.put(option, Boolean.valueOf(value));
        return this;
    }

    @Override // org.jline.reader.LineReader
    public boolean isSet(LineReader.Option option) {
        return option.isSet(this.options);
    }

    @Override // org.jline.reader.LineReader
    public void setOpt(LineReader.Option option) {
        this.options.put(option, Boolean.TRUE);
    }

    @Override // org.jline.reader.LineReader
    public void unsetOpt(LineReader.Option option) {
        this.options.put(option, Boolean.FALSE);
    }

    @Override // org.jline.reader.LineReader
    public void addCommandsInBuffer(Collection<String> commands) {
        this.commandsBuffer.addAll(commands);
    }

    @Override // org.jline.reader.LineReader
    public void editAndAddInBuffer(File file) throws Exception {
        if (isSet(LineReader.Option.BRACKETED_PASTE)) {
            this.terminal.writer().write(BRACKETED_PASTE_OFF);
        }
        Editor editor = (Editor) Class.forName("org.jline.builtins.Nano").getConstructor(Terminal.class, File.class).newInstance(this.terminal, new File(file.getParent()));
        editor.setRestricted(true);
        editor.open(Collections.singletonList(file.getName()));
        editor.run();
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            this.commandsBuffer.clear();
            while (true) {
                String line = br.readLine();
                if (line != null) {
                    this.commandsBuffer.add(line);
                } else {
                    br.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                br.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    protected String finishBuffer() {
        return finish(this.buf.toString());
    }

    protected String finish(String str) {
        String historyLine = str;
        if (!isSet(LineReader.Option.DISABLE_EVENT_EXPANSION)) {
            StringBuilder sb = new StringBuilder();
            boolean escaped = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (escaped) {
                    escaped = false;
                    if (ch != '\n') {
                        sb.append(ch);
                    }
                } else if (this.parser.isEscapeChar(ch)) {
                    escaped = true;
                } else {
                    sb.append(ch);
                }
            }
            str = sb.toString();
        }
        if (this.maskingCallback != null) {
            historyLine = this.maskingCallback.history(historyLine);
        }
        if (historyLine != null && historyLine.length() > 0) {
            this.history.add(Instant.now(), historyLine);
        }
        return str;
    }

    protected void handleSignal(Terminal.Signal signal) {
        this.doAutosuggestion = false;
        if (signal == Terminal.Signal.WINCH) {
            Status status = Status.getStatus(this.terminal, false);
            if (status != null) {
                status.hardReset();
            }
            this.size.copy(this.terminal.getBufferSize());
            this.display.resize(this.size.getRows(), this.size.getColumns());
            redisplay();
        } else if (signal == Terminal.Signal.CONT) {
            this.terminal.enterRawMode();
            this.size.copy(this.terminal.getBufferSize());
            this.display.resize(this.size.getRows(), this.size.getColumns());
            this.terminal.puts(InfoCmp.Capability.keypad_xmit, new Object[0]);
            redrawLine();
            redisplay();
        }
    }

    protected Widget getWidget(Object binding) {
        Widget w;
        if (binding instanceof Widget) {
            w = (Widget) binding;
        } else if (binding instanceof Macro) {
            String macro = ((Macro) binding).getSequence();
            w = ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE_CUSTOM (r5v4 'w' org.jline.reader.Widget) = 
                  (r3v0 'this' org.jline.reader.impl.LineReaderImpl A[D('this' org.jline.reader.impl.LineReaderImpl), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r0v21 'macro' java.lang.String A[D('macro' java.lang.String), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: org.jline.reader.Widget.apply():boolean
                 call insn: ?: INVOKE  (r0 I:org.jline.reader.impl.LineReaderImpl), (r1 I:java.lang.String) type: DIRECT call: org.jline.reader.impl.LineReaderImpl.lambda$getWidget$1(java.lang.String):boolean in method: org.jline.reader.impl.LineReaderImpl.getWidget(java.lang.Object):org.jline.reader.Widget, file: grasscutter.jar:org/jline/reader/impl/LineReaderImpl.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:170)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:147)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                	... 23 more
                */
            /*
                this = this;
                r0 = r4
                boolean r0 = r0 instanceof org.jline.reader.Widget
                if (r0 == 0) goto L_0x000f
                r0 = r4
                org.jline.reader.Widget r0 = (org.jline.reader.Widget) r0
                r5 = r0
                goto L_0x005c
            L_0x000f:
                r0 = r4
                boolean r0 = r0 instanceof org.jline.reader.Macro
                if (r0 == 0) goto L_0x0029
                r0 = r4
                org.jline.reader.Macro r0 = (org.jline.reader.Macro) r0
                java.lang.String r0 = r0.getSequence()
                r6 = r0
                r0 = r3
                r1 = r6
                org.jline.reader.Widget r0 = () -> { // org.jline.reader.Widget.apply():boolean
                    return r0.lambda$getWidget$1(r1);
                }
                r5 = r0
                goto L_0x005c
            L_0x0029:
                r0 = r4
                boolean r0 = r0 instanceof org.jline.reader.Reference
                if (r0 == 0) goto L_0x0055
                r0 = r4
                org.jline.reader.Reference r0 = (org.jline.reader.Reference) r0
                java.lang.String r0 = r0.name()
                r6 = r0
                r0 = r3
                java.util.Map<java.lang.String, org.jline.reader.Widget> r0 = r0.widgets
                r1 = r6
                java.lang.Object r0 = r0.get(r1)
                org.jline.reader.Widget r0 = (org.jline.reader.Widget) r0
                r5 = r0
                r0 = r5
                if (r0 != 0) goto L_0x0052
                r0 = r3
                r1 = r6
                org.jline.reader.Widget r0 = () -> { // org.jline.reader.Widget.apply():boolean
                    return r0.lambda$getWidget$3(r1);
                }
                r5 = r0
            L_0x0052:
                goto L_0x005c
            L_0x0055:
                r0 = r3
                org.jline.reader.Widget r0 = () -> { // org.jline.reader.Widget.apply():boolean
                    return r0.lambda$getWidget$5();
                }
                r5 = r0
            L_0x005c:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.reader.impl.LineReaderImpl.getWidget(java.lang.Object):org.jline.reader.Widget");
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt == null ? AttributedString.EMPTY : expandPromptPattern(prompt, 0, "", 0);
        }

        public void setRightPrompt(String rightPrompt) {
            this.rightPrompt = rightPrompt == null ? AttributedString.EMPTY : expandPromptPattern(rightPrompt, 0, "", 0);
        }

        protected void setBuffer(Buffer buffer) {
            this.buf.copyFrom(buffer);
        }

        protected void setBuffer(String buffer) {
            this.buf.clear();
            this.buf.write(buffer);
        }

        protected String viDeleteChangeYankToRemap(String op) {
            char c = 65535;
            switch (op.hashCode()) {
                case -2086128840:
                    if (op.equals(LineReader.END_OF_LINE)) {
                        c = 3;
                        break;
                    }
                    break;
                case -2072886794:
                    if (op.equals(LineReader.VI_FIND_PREV_CHAR)) {
                        c = 20;
                        break;
                    }
                    break;
                case -1941338186:
                    if (op.equals(LineReader.VI_FIND_NEXT_CHAR_SKIP)) {
                        c = 19;
                        break;
                    }
                    break;
                case -1700380294:
                    if (op.equals(LineReader.VI_FORWARD_WORD_END)) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1690997923:
                    if (op.equals(LineReader.DIGIT_ARGUMENT)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1499210095:
                    if (op.equals(LineReader.VI_REPEAT_FIND)) {
                        c = 22;
                        break;
                    }
                    break;
                case -1443126179:
                    if (op.equals(LineReader.VI_FIRST_NON_BLANK)) {
                        c = '\r';
                        break;
                    }
                    break;
                case -447401186:
                    if (op.equals(LineReader.VI_CHANGE)) {
                        c = 17;
                        break;
                    }
                    break;
                case -390207944:
                    if (op.equals(LineReader.VI_FORWARD_CHAR)) {
                        c = '\n';
                        break;
                    }
                    break;
                case -389604884:
                    if (op.equals(LineReader.VI_FORWARD_WORD)) {
                        c = 11;
                        break;
                    }
                    break;
                case -325380770:
                    if (op.equals(LineReader.FORWARD_CHAR)) {
                        c = 2;
                        break;
                    }
                    break;
                case -272268795:
                    if (op.equals(LineReader.VI_DELETE)) {
                        c = 15;
                        break;
                    }
                    break;
                case -204986010:
                    if (op.equals(LineReader.VI_BACKWARD_CHAR)) {
                        c = '\b';
                        break;
                    }
                    break;
                case -204382950:
                    if (op.equals(LineReader.VI_BACKWARD_WORD)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -14233290:
                    if (op.equals(LineReader.VI_FIND_NEXT_CHAR)) {
                        c = 18;
                        break;
                    }
                    break;
                case 71732982:
                    if (op.equals(LineReader.VI_FIND_PREV_CHAR_SKIP)) {
                        c = 21;
                        break;
                    }
                    break;
                case 92611376:
                    if (op.equals(LineReader.SEND_BREAK)) {
                        c = 0;
                        break;
                    }
                    break;
                case 123927130:
                    if (op.equals(LineReader.NEG_ARGUMENT)) {
                        c = 6;
                        break;
                    }
                    break;
                case 402572703:
                    if (op.equals(LineReader.VI_YANK)) {
                        c = 16;
                        break;
                    }
                    break;
                case 517237095:
                    if (op.equals(LineReader.VI_REV_REPEAT_FIND)) {
                        c = 23;
                        break;
                    }
                    break;
                case 1399497446:
                    if (op.equals(LineReader.VI_GOTO_COLUMN)) {
                        c = 14;
                        break;
                    }
                    break;
                case 1804656384:
                    if (op.equals(LineReader.BACKWARD_CHAR)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1864679370:
                    if (op.equals(LineReader.VI_DIGIT_OR_BEGINNING_OF_LINE)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1995120390:
                    if (op.equals(LineReader.VI_MATCH_BRACKET)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    return op;
                default:
                    return LineReader.VI_CMD_MODE;
            }
        }

        protected int switchCase(int ch) {
            if (Character.isUpperCase(ch)) {
                return Character.toLowerCase(ch);
            }
            if (Character.isLowerCase(ch)) {
                return Character.toUpperCase(ch);
            }
            return ch;
        }

        protected boolean isInViMoveOperation() {
            return this.viMoveMode != ViMoveMode.NORMAL;
        }

        protected boolean isInViChangeOperation() {
            return this.viMoveMode == ViMoveMode.CHANGE;
        }

        protected boolean isInViCmdMode() {
            return LineReader.VICMD.equals(this.keyMap);
        }

        protected boolean viForwardChar() {
            if (this.count < 0) {
                return callNeg(this::viBackwardChar);
            }
            int lim = findeol();
            if (isInViCmdMode() && !isInViMoveOperation()) {
                lim--;
            }
            if (this.buf.cursor() >= lim) {
                return false;
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0 || this.buf.cursor() >= lim) {
                    return true;
                }
                this.buf.move(1);
            }
        }

        protected boolean viBackwardChar() {
            if (this.count < 0) {
                return callNeg(this::viForwardChar);
            }
            if (this.buf.cursor() == findbol()) {
                return false;
            }
            do {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0 || this.buf.cursor() <= 0) {
                    return true;
                }
                this.buf.move(-1);
            } while (this.buf.currChar() != 10);
            this.buf.move(1);
            return true;
        }

        protected boolean forwardWord() {
            if (this.count < 0) {
                return callNeg(this::backwardWord);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                while (this.buf.cursor() < this.buf.length() && isWord(this.buf.currChar())) {
                    this.buf.move(1);
                }
                if (isInViChangeOperation() && this.count == 0) {
                    return true;
                }
                while (this.buf.cursor() < this.buf.length() && !isWord(this.buf.currChar())) {
                    this.buf.move(1);
                }
            }
        }

        protected boolean viForwardWord() {
            if (this.count < 0) {
                return callNeg(this::viBackwardWord);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                if (isViAlphaNum(this.buf.currChar())) {
                    while (this.buf.cursor() < this.buf.length() && isViAlphaNum(this.buf.currChar())) {
                        this.buf.move(1);
                    }
                } else {
                    while (this.buf.cursor() < this.buf.length() && !isViAlphaNum(this.buf.currChar()) && !isWhitespace(this.buf.currChar())) {
                        this.buf.move(1);
                    }
                }
                if (isInViChangeOperation() && this.count == 0) {
                    return true;
                }
                int nl = this.buf.currChar() == 10 ? 1 : 0;
                while (this.buf.cursor() < this.buf.length() && nl < 2 && isWhitespace(this.buf.currChar())) {
                    this.buf.move(1);
                    nl += this.buf.currChar() == 10 ? 1 : 0;
                }
            }
        }

        protected boolean viForwardBlankWord() {
            if (this.count < 0) {
                return callNeg(this::viBackwardBlankWord);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                while (this.buf.cursor() < this.buf.length() && !isWhitespace(this.buf.currChar())) {
                    this.buf.move(1);
                }
                if (isInViChangeOperation() && this.count == 0) {
                    return true;
                }
                int nl = this.buf.currChar() == 10 ? 1 : 0;
                while (this.buf.cursor() < this.buf.length() && nl < 2 && isWhitespace(this.buf.currChar())) {
                    this.buf.move(1);
                    nl += this.buf.currChar() == 10 ? 1 : 0;
                }
            }
        }

        protected boolean emacsForwardWord() {
            return forwardWord();
        }

        protected boolean viForwardBlankWordEnd() {
            if (this.count < 0) {
                return false;
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    while (this.buf.cursor() < this.buf.length()) {
                        this.buf.move(1);
                        if (!isWhitespace(this.buf.currChar())) {
                            break;
                        }
                    }
                    while (this.buf.cursor() < this.buf.length()) {
                        this.buf.move(1);
                        if (isWhitespace(this.buf.currChar())) {
                            break;
                        }
                    }
                } else {
                    return true;
                }
            }
        }

        protected boolean viForwardWordEnd() {
            if (this.count < 0) {
                return callNeg(this::backwardWord);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    break;
                }
                while (this.buf.cursor() < this.buf.length() && isWhitespace(this.buf.nextChar())) {
                    this.buf.move(1);
                }
                if (this.buf.cursor() < this.buf.length()) {
                    if (isViAlphaNum(this.buf.nextChar())) {
                        this.buf.move(1);
                        while (this.buf.cursor() < this.buf.length() && isViAlphaNum(this.buf.nextChar())) {
                            this.buf.move(1);
                        }
                    } else {
                        this.buf.move(1);
                        while (this.buf.cursor() < this.buf.length() && !isViAlphaNum(this.buf.nextChar()) && !isWhitespace(this.buf.nextChar())) {
                            this.buf.move(1);
                        }
                    }
                }
            }
            if (this.buf.cursor() >= this.buf.length() || !isInViMoveOperation()) {
                return true;
            }
            this.buf.move(1);
            return true;
        }

        protected boolean backwardWord() {
            if (this.count < 0) {
                return callNeg(this::forwardWord);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                while (this.buf.cursor() > 0 && !isWord(this.buf.atChar(this.buf.cursor() - 1))) {
                    this.buf.move(-1);
                }
                while (this.buf.cursor() > 0 && isWord(this.buf.atChar(this.buf.cursor() - 1))) {
                    this.buf.move(-1);
                }
            }
        }

        protected boolean viBackwardWord() {
            if (this.count < 0) {
                return callNeg(this::viForwardWord);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                int nl = 0;
                while (true) {
                    if (this.buf.cursor() <= 0) {
                        break;
                    }
                    this.buf.move(-1);
                    if (!isWhitespace(this.buf.currChar())) {
                        break;
                    }
                    nl += this.buf.currChar() == 10 ? 1 : 0;
                    if (nl == 2) {
                        this.buf.move(1);
                        break;
                    }
                }
                if (this.buf.cursor() > 0) {
                    if (isViAlphaNum(this.buf.currChar())) {
                        while (this.buf.cursor() > 0 && isViAlphaNum(this.buf.prevChar())) {
                            this.buf.move(-1);
                        }
                    } else {
                        while (this.buf.cursor() > 0 && !isViAlphaNum(this.buf.prevChar()) && !isWhitespace(this.buf.prevChar())) {
                            this.buf.move(-1);
                        }
                    }
                }
            }
        }

        protected boolean viBackwardBlankWord() {
            if (this.count < 0) {
                return callNeg(this::viForwardBlankWord);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    while (this.buf.cursor() > 0) {
                        this.buf.move(-1);
                        if (!isWhitespace(this.buf.currChar())) {
                            break;
                        }
                    }
                    while (this.buf.cursor() > 0) {
                        this.buf.move(-1);
                        if (isWhitespace(this.buf.currChar())) {
                            break;
                        }
                    }
                } else {
                    return true;
                }
            }
        }

        protected boolean viBackwardWordEnd() {
            int start;
            if (this.count < 0) {
                return callNeg(this::viForwardWordEnd);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0 || this.buf.cursor() <= 1) {
                    return true;
                }
                if (isViAlphaNum(this.buf.currChar())) {
                    start = 1;
                } else if (!isWhitespace(this.buf.currChar())) {
                    start = 2;
                } else {
                    start = 0;
                }
                while (this.buf.cursor() > 0) {
                    boolean same = start != 1 && isWhitespace(this.buf.currChar());
                    if (start != 0) {
                        same |= isViAlphaNum(this.buf.currChar());
                    }
                    if (same == (start == 2)) {
                        break;
                    }
                    this.buf.move(-1);
                }
                while (this.buf.cursor() > 0 && isWhitespace(this.buf.currChar())) {
                    this.buf.move(-1);
                }
            }
        }

        protected boolean viBackwardBlankWordEnd() {
            if (this.count < 0) {
                return callNeg(this::viForwardBlankWordEnd);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                while (this.buf.cursor() > 0 && !isWhitespace(this.buf.currChar())) {
                    this.buf.move(-1);
                }
                while (this.buf.cursor() > 0 && isWhitespace(this.buf.currChar())) {
                    this.buf.move(-1);
                }
            }
        }

        protected boolean emacsBackwardWord() {
            return backwardWord();
        }

        protected boolean backwardDeleteWord() {
            if (this.count < 0) {
                return callNeg(this::deleteWord);
            }
            int cursor = this.buf.cursor();
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    while (cursor > 0 && !isWord(this.buf.atChar(cursor - 1))) {
                        cursor--;
                    }
                    while (cursor > 0 && isWord(this.buf.atChar(cursor - 1))) {
                        cursor--;
                    }
                } else {
                    this.buf.backspace(this.buf.cursor() - cursor);
                    return true;
                }
            }
        }

        protected boolean viBackwardKillWord() {
            if (this.count < 0) {
                return false;
            }
            int lim = findbol();
            int x = this.buf.cursor();
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    while (x > lim && isWhitespace(this.buf.atChar(x - 1))) {
                        x--;
                    }
                    if (x > lim) {
                        if (isViAlphaNum(this.buf.atChar(x - 1))) {
                            while (x > lim && isViAlphaNum(this.buf.atChar(x - 1))) {
                                x--;
                            }
                        } else {
                            while (x > lim && !isViAlphaNum(this.buf.atChar(x - 1)) && !isWhitespace(this.buf.atChar(x - 1))) {
                                x--;
                            }
                        }
                    }
                } else {
                    this.killRing.addBackwards(this.buf.substring(x, this.buf.cursor()));
                    this.buf.backspace(this.buf.cursor() - x);
                    return true;
                }
            }
        }

        protected boolean backwardKillWord() {
            if (this.count < 0) {
                return callNeg(this::killWord);
            }
            int x = this.buf.cursor();
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    while (x > 0 && !isWord(this.buf.atChar(x - 1))) {
                        x--;
                    }
                    while (x > 0 && isWord(this.buf.atChar(x - 1))) {
                        x--;
                    }
                } else {
                    this.killRing.addBackwards(this.buf.substring(x, this.buf.cursor()));
                    this.buf.backspace(this.buf.cursor() - x);
                    return true;
                }
            }
        }

        protected boolean copyPrevWord() {
            if (this.count <= 0) {
                return false;
            }
            int t0 = this.buf.cursor();
            do {
                while (t0 > 0 && !isWord(this.buf.atChar(t0 - 1))) {
                    t0--;
                }
                while (t0 > 0 && isWord(this.buf.atChar(t0 - 1))) {
                    t0--;
                }
                int i = this.count - 1;
                this.count = i;
                if (i == 0) {
                    this.buf.write(this.buf.substring(t0, t0));
                    return true;
                }
            } while (t0 != 0);
            return false;
        }

        protected boolean upCaseWord() {
            int count = Math.abs(this.count);
            int cursor = this.buf.cursor();
            while (true) {
                count--;
                if (count <= 0) {
                    break;
                }
                while (this.buf.cursor() < this.buf.length() && !isWord(this.buf.currChar())) {
                    this.buf.move(1);
                }
                while (this.buf.cursor() < this.buf.length() && isWord(this.buf.currChar())) {
                    this.buf.currChar(Character.toUpperCase(this.buf.currChar()));
                    this.buf.move(1);
                }
            }
            if (this.count >= 0) {
                return true;
            }
            this.buf.cursor(cursor);
            return true;
        }

        protected boolean downCaseWord() {
            int count = Math.abs(this.count);
            int cursor = this.buf.cursor();
            while (true) {
                count--;
                if (count <= 0) {
                    break;
                }
                while (this.buf.cursor() < this.buf.length() && !isWord(this.buf.currChar())) {
                    this.buf.move(1);
                }
                while (this.buf.cursor() < this.buf.length() && isWord(this.buf.currChar())) {
                    this.buf.currChar(Character.toLowerCase(this.buf.currChar()));
                    this.buf.move(1);
                }
            }
            if (this.count >= 0) {
                return true;
            }
            this.buf.cursor(cursor);
            return true;
        }

        protected boolean capitalizeWord() {
            int i;
            int count = Math.abs(this.count);
            int cursor = this.buf.cursor();
            while (true) {
                count--;
                if (count <= 0) {
                    break;
                }
                boolean first = true;
                while (this.buf.cursor() < this.buf.length() && !isWord(this.buf.currChar())) {
                    this.buf.move(1);
                }
                while (this.buf.cursor() < this.buf.length() && isWord(this.buf.currChar()) && !isAlpha(this.buf.currChar())) {
                    this.buf.move(1);
                }
                while (this.buf.cursor() < this.buf.length() && isWord(this.buf.currChar())) {
                    Buffer buffer = this.buf;
                    if (first) {
                        i = Character.toUpperCase(this.buf.currChar());
                    } else {
                        i = Character.toLowerCase(this.buf.currChar());
                    }
                    buffer.currChar(i);
                    this.buf.move(1);
                    first = false;
                }
            }
            if (this.count >= 0) {
                return true;
            }
            this.buf.cursor(cursor);
            return true;
        }

        protected boolean deleteWord() {
            if (this.count < 0) {
                return callNeg(this::backwardDeleteWord);
            }
            int x = this.buf.cursor();
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    while (x < this.buf.length() && !isWord(this.buf.atChar(x))) {
                        x++;
                    }
                    while (x < this.buf.length() && isWord(this.buf.atChar(x))) {
                        x++;
                    }
                } else {
                    this.buf.delete(x - this.buf.cursor());
                    return true;
                }
            }
        }

        protected boolean killWord() {
            if (this.count < 0) {
                return callNeg(this::backwardKillWord);
            }
            int x = this.buf.cursor();
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    while (x < this.buf.length() && !isWord(this.buf.atChar(x))) {
                        x++;
                    }
                    while (x < this.buf.length() && isWord(this.buf.atChar(x))) {
                        x++;
                    }
                } else {
                    this.killRing.add(this.buf.substring(this.buf.cursor(), x));
                    this.buf.delete(x - this.buf.cursor());
                    return true;
                }
            }
        }

        protected boolean transposeWords() {
            int end2;
            int sta2;
            int lstart = this.buf.cursor() - 1;
            int lend = this.buf.cursor();
            while (this.buf.atChar(lstart) != 0 && this.buf.atChar(lstart) != 10) {
                lstart--;
            }
            int lstart2 = lstart + 1;
            while (this.buf.atChar(lend) != 0 && this.buf.atChar(lend) != 10) {
                lend++;
            }
            if (lend - lstart2 < 2) {
                return false;
            }
            int words = 0;
            boolean inWord = false;
            if (!isDelimiter(this.buf.atChar(lstart2))) {
                words = 0 + 1;
                inWord = true;
            }
            for (int i = lstart2; i < lend; i++) {
                if (isDelimiter(this.buf.atChar(i))) {
                    inWord = false;
                } else {
                    if (!inWord) {
                        words++;
                    }
                    inWord = true;
                }
            }
            if (words < 2) {
                return false;
            }
            boolean neg = this.count < 0;
            for (int count = Math.max(this.count, -this.count); count > 0; count--) {
                int sta1 = this.buf.cursor();
                while (sta1 > lstart2 && !isDelimiter(this.buf.atChar(sta1 - 1))) {
                    sta1--;
                }
                int end1 = sta1;
                while (end1 < lend) {
                    end1++;
                    if (isDelimiter(this.buf.atChar(end1))) {
                        break;
                    }
                }
                if (!neg) {
                    sta2 = end1;
                    while (sta2 < lend) {
                        sta2++;
                        if (!isDelimiter(this.buf.atChar(sta2))) {
                            break;
                        }
                    }
                    if (sta2 != lend) {
                        end2 = sta2;
                        while (end2 < lend) {
                            end2++;
                            if (isDelimiter(this.buf.atChar(end2))) {
                                break;
                            }
                        }
                    } else {
                        end2 = sta1;
                        while (isDelimiter(this.buf.atChar(end2 - 1))) {
                            end2--;
                        }
                        sta2 = end2;
                        while (sta2 > lstart2 && !isDelimiter(this.buf.atChar(sta2 - 1))) {
                            sta2--;
                        }
                    }
                } else {
                    end2 = sta1 - 1;
                    while (end2 > lstart2 && isDelimiter(this.buf.atChar(end2 - 1))) {
                        end2--;
                    }
                    if (end2 < lstart2) {
                        sta2 = end1;
                        do {
                            sta2++;
                        } while (isDelimiter(this.buf.atChar(sta2)));
                        end2 = sta2;
                        while (end2 < lend) {
                            end2++;
                            if (isDelimiter(this.buf.atChar(end2))) {
                                break;
                            }
                        }
                    } else {
                        sta2 = end2;
                        while (sta2 > lstart2 && !isDelimiter(this.buf.atChar(sta2 - 1))) {
                            sta2--;
                        }
                    }
                }
                if (sta1 < sta2) {
                    this.buf.clear();
                    this.buf.write(this.buf.substring(0, sta1) + this.buf.substring(sta2, end2) + this.buf.substring(end1, sta2) + this.buf.substring(sta1, end1) + this.buf.substring(end2));
                    this.buf.cursor(neg ? end1 : end2);
                } else {
                    this.buf.clear();
                    this.buf.write(this.buf.substring(0, sta2) + this.buf.substring(sta1, end1) + this.buf.substring(end2, sta1) + this.buf.substring(sta2, end2) + this.buf.substring(end1));
                    this.buf.cursor(neg ? end2 : end1);
                }
            }
            return true;
        }

        private int findbol() {
            int x = this.buf.cursor();
            while (x > 0 && this.buf.atChar(x - 1) != 10) {
                x--;
            }
            return x;
        }

        private int findeol() {
            int x = this.buf.cursor();
            while (x < this.buf.length() && this.buf.atChar(x) != 10) {
                x++;
            }
            return x;
        }

        protected boolean insertComment() {
            return doInsertComment(false);
        }

        protected boolean viInsertComment() {
            return doInsertComment(true);
        }

        protected boolean doInsertComment(boolean isViMode) {
            String comment = getString(LineReader.COMMENT_BEGIN, DEFAULT_COMMENT_BEGIN);
            beginningOfLine();
            putString(comment);
            if (isViMode) {
                setKeyMap(LineReader.VIINS);
            }
            return acceptLine();
        }

        protected boolean viFindNextChar() {
            int vigetkey = vigetkey();
            this.findChar = vigetkey;
            if (vigetkey <= 0) {
                return false;
            }
            this.findDir = 1;
            this.findTailAdd = 0;
            return vifindchar(false);
        }

        protected boolean viFindPrevChar() {
            int vigetkey = vigetkey();
            this.findChar = vigetkey;
            if (vigetkey <= 0) {
                return false;
            }
            this.findDir = -1;
            this.findTailAdd = 0;
            return vifindchar(false);
        }

        protected boolean viFindNextCharSkip() {
            int vigetkey = vigetkey();
            this.findChar = vigetkey;
            if (vigetkey <= 0) {
                return false;
            }
            this.findDir = 1;
            this.findTailAdd = -1;
            return vifindchar(false);
        }

        protected boolean viFindPrevCharSkip() {
            int vigetkey = vigetkey();
            this.findChar = vigetkey;
            if (vigetkey <= 0) {
                return false;
            }
            this.findDir = -1;
            this.findTailAdd = 1;
            return vifindchar(false);
        }

        protected boolean viRepeatFind() {
            return vifindchar(true);
        }

        protected boolean viRevRepeatFind() {
            if (this.count < 0) {
                return callNeg(() -> {
                    return vifindchar(true);
                });
            }
            this.findTailAdd = -this.findTailAdd;
            this.findDir = -this.findDir;
            boolean ret = vifindchar(true);
            this.findTailAdd = -this.findTailAdd;
            this.findDir = -this.findDir;
            return ret;
        }

        private int vigetkey() {
            int ch = readCharacter();
            KeyMap<Binding> km = this.keyMaps.get(LineReader.MAIN);
            if (km != null) {
                Binding b = km.getBound(new String(Character.toChars(ch)));
                if ((b instanceof Reference) && LineReader.SEND_BREAK.equals(((Reference) b).name())) {
                    return -1;
                }
            }
            return ch;
        }

        private boolean vifindchar(boolean repeat) {
            if (this.findDir == 0) {
                return false;
            }
            if (this.count < 0) {
                return callNeg(this::viRevRepeatFind);
            }
            if (repeat && this.findTailAdd != 0) {
                if (this.findDir > 0) {
                    if (this.buf.cursor() < this.buf.length() && this.buf.nextChar() == this.findChar) {
                        this.buf.move(1);
                    }
                } else if (this.buf.cursor() > 0 && this.buf.prevChar() == this.findChar) {
                    this.buf.move(-1);
                }
            }
            int cursor = this.buf.cursor();
            do {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    do {
                        this.buf.move(this.findDir);
                        if (this.buf.cursor() <= 0 || this.buf.cursor() >= this.buf.length() || this.buf.currChar() == this.findChar) {
                            break;
                        }
                    } while (this.buf.currChar() != 10);
                    if (this.buf.cursor() <= 0 || this.buf.cursor() >= this.buf.length()) {
                        break;
                    }
                } else {
                    if (this.findTailAdd != 0) {
                        this.buf.move(this.findTailAdd);
                    }
                    if (this.findDir != 1 || !isInViMoveOperation()) {
                        return true;
                    }
                    this.buf.move(1);
                    return true;
                }
            } while (this.buf.currChar() != 10);
            this.buf.cursor(cursor);
            return false;
        }

        private boolean callNeg(Widget widget) {
            this.count = -this.count;
            boolean ret = widget.apply();
            this.count = -this.count;
            return ret;
        }

        protected boolean viHistorySearchForward() {
            this.searchDir = 1;
            this.searchIndex = 0;
            return getViSearchString() && viRepeatSearch();
        }

        protected boolean viHistorySearchBackward() {
            this.searchDir = -1;
            this.searchIndex = this.history.size() - 1;
            return getViSearchString() && viRepeatSearch();
        }

        protected boolean viRepeatSearch() {
            int si;
            if (this.searchDir == 0) {
                return false;
            }
            if (this.searchDir < 0) {
                si = searchBackwards(this.searchString, this.searchIndex, false);
            } else {
                si = searchForwards(this.searchString, this.searchIndex, false);
            }
            if (si == -1 || si == this.history.index()) {
                return false;
            }
            this.searchIndex = si;
            this.buf.clear();
            this.history.moveTo(this.searchIndex);
            this.buf.write(this.history.get(this.searchIndex));
            if (!LineReader.VICMD.equals(this.keyMap)) {
                return true;
            }
            this.buf.move(-1);
            return true;
        }

        protected boolean viRevRepeatSearch() {
            this.searchDir = -this.searchDir;
            boolean ret = viRepeatSearch();
            this.searchDir = -this.searchDir;
            return ret;
        }

        private boolean getViSearchString() {
            if (this.searchDir == 0) {
                return false;
            }
            String searchPrompt = this.searchDir < 0 ? "?" : "/";
            Buffer searchBuffer = new BufferImpl();
            KeyMap<Binding> keyMap = this.keyMaps.get(LineReader.MAIN);
            if (keyMap == null) {
                keyMap = this.keyMaps.get(LineReader.SAFE);
            }
            while (true) {
                this.post = () -> {
                    return new AttributedString(searchPrompt + searchBuffer.toString() + JavaConstant.Dynamic.DEFAULT_NAME);
                };
                redisplay();
                Binding b = (Binding) doReadBinding(keyMap, null);
                if (b instanceof Reference) {
                    String func = ((Reference) b).name();
                    char c = 65535;
                    switch (func.hashCode()) {
                        case -1493272024:
                            if (func.equals(LineReader.VI_BACKWARD_DELETE_CHAR)) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1383268060:
                            if (func.equals(LineReader.VI_QUOTED_INSERT)) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -1313197076:
                            if (func.equals(LineReader.CLEAR_SCREEN)) {
                                c = 5;
                                break;
                            }
                            break;
                        case 7600358:
                            if (func.equals(LineReader.MAGIC_SPACE)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 92611376:
                            if (func.equals(LineReader.SEND_BREAK)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 275063630:
                            if (func.equals(LineReader.BACKWARD_DELETE_CHAR)) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 374721545:
                            if (func.equals(LineReader.VI_BACKWARD_KILL_WORD)) {
                                c = 11;
                                break;
                            }
                            break;
                        case 528516783:
                            if (func.equals(LineReader.BACKWARD_KILL_WORD)) {
                                c = '\n';
                                break;
                            }
                            break;
                        case 582287769:
                            if (func.equals(LineReader.ACCEPT_LINE)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 626374334:
                            if (func.equals(LineReader.QUOTED_INSERT)) {
                                c = '\f';
                                break;
                            }
                            break;
                        case 976605274:
                            if (func.equals(LineReader.SELF_INSERT)) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1123998768:
                            if (func.equals(LineReader.VI_CMD_MODE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1680511217:
                            if (func.equals(LineReader.SELF_INSERT_UNMETA)) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1710570287:
                            if (func.equals(LineReader.REDISPLAY)) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            this.post = null;
                            return false;
                        case 1:
                        case 2:
                            this.searchString = searchBuffer.toString();
                            this.post = null;
                            return true;
                        case 3:
                            searchBuffer.write(32);
                            continue;
                        case 4:
                            redisplay();
                            continue;
                        case 5:
                            clearScreen();
                            continue;
                        case 6:
                            searchBuffer.write(getLastBinding());
                            continue;
                        case 7:
                            if (getLastBinding().charAt(0) == 27) {
                                String s = getLastBinding().substring(1);
                                if ("\r".equals(s)) {
                                    s = "\n";
                                }
                                searchBuffer.write(s);
                                break;
                            } else {
                                continue;
                            }
                        case '\b':
                        case '\t':
                            if (searchBuffer.length() > 0) {
                                searchBuffer.backspace();
                                break;
                            } else {
                                continue;
                            }
                        case '\n':
                        case 11:
                            if (searchBuffer.length() > 0 && !isWhitespace(searchBuffer.prevChar())) {
                                searchBuffer.backspace();
                            }
                            if (searchBuffer.length() > 0) {
                                if (!isWhitespace(searchBuffer.prevChar())) {
                                    break;
                                } else {
                                    searchBuffer.backspace();
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case '\f':
                        case '\r':
                            int c2 = readCharacter();
                            if (c2 < 0) {
                                beep();
                                break;
                            } else {
                                searchBuffer.write(c2);
                                continue;
                            }
                        default:
                            beep();
                            continue;
                    }
                }
            }
        }

        protected boolean insertCloseCurly() {
            return insertClose("}");
        }

        protected boolean insertCloseParen() {
            return insertClose(DESC_SUFFIX);
        }

        protected boolean insertCloseSquare() {
            return insertClose("]");
        }

        protected boolean insertClose(String s) {
            putString(s);
            long blink = getLong(LineReader.BLINK_MATCHING_PAREN, 500);
            if (blink <= 0) {
                removeIndentation();
                return true;
            }
            int closePosition = this.buf.cursor();
            this.buf.move(-1);
            doViMatchBracket();
            redisplay();
            peekCharacter(blink);
            int blinkPosition = this.buf.cursor();
            this.buf.cursor(closePosition);
            if (blinkPosition == closePosition - 1) {
                return true;
            }
            removeIndentation();
            return true;
        }

        private void removeIndentation() {
            int indent = getInt(LineReader.INDENTATION, 0);
            if (indent > 0) {
                this.buf.move(-1);
                int i = 0;
                while (true) {
                    if (i >= indent) {
                        break;
                    }
                    this.buf.move(-1);
                    if (this.buf.currChar() != 32) {
                        this.buf.move(1);
                        break;
                    } else {
                        this.buf.delete();
                        i++;
                    }
                }
                this.buf.move(1);
            }
        }

        protected boolean viMatchBracket() {
            return doViMatchBracket();
        }

        protected boolean undefinedKey() {
            return false;
        }

        protected boolean doViMatchBracket() {
            int pos = this.buf.cursor();
            if (pos == this.buf.length()) {
                return false;
            }
            int type = getBracketType(this.buf.atChar(pos));
            int move = type < 0 ? -1 : 1;
            int count = 1;
            if (type == 0) {
                return false;
            }
            while (count > 0) {
                pos += move;
                if (pos < 0 || pos >= this.buf.length()) {
                    return false;
                }
                int curType = getBracketType(this.buf.atChar(pos));
                if (curType == type) {
                    count++;
                } else if (curType == (-type)) {
                    count--;
                }
            }
            if (move > 0 && isInViMoveOperation()) {
                pos++;
            }
            this.buf.cursor(pos);
            return true;
        }

        protected int getBracketType(int ch) {
            switch (ch) {
                case 40:
                    return 3;
                case 41:
                    return -3;
                case 91:
                    return 1;
                case 93:
                    return -1;
                case 123:
                    return 2;
                case 125:
                    return -2;
                default:
                    return 0;
            }
        }

        protected boolean transposeChars() {
            int lstart = this.buf.cursor() - 1;
            int lend = this.buf.cursor();
            while (this.buf.atChar(lstart) != 0 && this.buf.atChar(lstart) != 10) {
                lstart--;
            }
            int lstart2 = lstart + 1;
            while (this.buf.atChar(lend) != 0 && this.buf.atChar(lend) != 10) {
                lend++;
            }
            if (lend - lstart2 < 2) {
                return false;
            }
            boolean neg = this.count < 0;
            for (int count = Math.max(this.count, -this.count); count > 0; count--) {
                while (this.buf.cursor() <= lstart2) {
                    this.buf.move(1);
                }
                while (this.buf.cursor() >= lend) {
                    this.buf.move(-1);
                }
                int c = this.buf.currChar();
                this.buf.currChar(this.buf.prevChar());
                this.buf.move(-1);
                this.buf.currChar(c);
                this.buf.move(neg ? 0 : 2);
            }
            return true;
        }

        protected boolean undo() {
            this.isUndo = true;
            if (!this.undo.canUndo()) {
                return false;
            }
            this.undo.undo();
            return true;
        }

        protected boolean redo() {
            this.isUndo = true;
            if (!this.undo.canRedo()) {
                return false;
            }
            this.undo.redo();
            return true;
        }

        protected boolean sendBreak() {
            if (this.searchTerm != null) {
                return true;
            }
            this.buf.clear();
            println();
            redrawLine();
            return false;
        }

        protected boolean backwardChar() {
            return this.buf.move(-this.count) != 0;
        }

        protected boolean forwardChar() {
            return this.buf.move(this.count) != 0;
        }

        protected boolean viDigitOrBeginningOfLine() {
            if (this.repeatCount > 0) {
                return digitArgument();
            }
            return beginningOfLine();
        }

        protected boolean universalArgument() {
            this.mult *= this.universal;
            this.isArgDigit = true;
            return true;
        }

        protected boolean argumentBase() {
            if (this.repeatCount <= 0 || this.repeatCount >= 32) {
                return false;
            }
            this.universal = this.repeatCount;
            this.isArgDigit = true;
            return true;
        }

        protected boolean negArgument() {
            this.mult *= -1;
            this.isArgDigit = true;
            return true;
        }

        protected boolean digitArgument() {
            String s = getLastBinding();
            this.repeatCount = ((this.repeatCount * 10) + s.charAt(s.length() - 1)) - 48;
            this.isArgDigit = true;
            return true;
        }

        protected boolean viDelete() {
            int cursorStart = this.buf.cursor();
            Binding o = readBinding(getKeys());
            if (o instanceof Reference) {
                String op = viDeleteChangeYankToRemap(((Reference) o).name());
                if (LineReader.VI_DELETE.equals(op)) {
                    killWholeLine();
                } else {
                    this.viMoveMode = ViMoveMode.DELETE;
                    Widget widget = this.widgets.get(op);
                    if (widget == null || widget.apply()) {
                        this.viMoveMode = ViMoveMode.NORMAL;
                    } else {
                        this.viMoveMode = ViMoveMode.NORMAL;
                        return false;
                    }
                }
                return viDeleteTo(cursorStart, this.buf.cursor());
            }
            pushBackBinding();
            return false;
        }

        protected boolean viYankTo() {
            int cursorStart = this.buf.cursor();
            Binding o = readBinding(getKeys());
            if (o instanceof Reference) {
                String op = viDeleteChangeYankToRemap(((Reference) o).name());
                if (LineReader.VI_YANK.equals(op)) {
                    this.yankBuffer = this.buf.toString();
                    return true;
                }
                this.viMoveMode = ViMoveMode.YANK;
                Widget widget = this.widgets.get(op);
                if (widget != null && !widget.apply()) {
                    return false;
                }
                this.viMoveMode = ViMoveMode.NORMAL;
                return viYankTo(cursorStart, this.buf.cursor());
            }
            pushBackBinding();
            return false;
        }

        protected boolean viYankWholeLine() {
            int p = this.buf.cursor();
            while (this.buf.move(-1) == -1 && this.buf.prevChar() != 10) {
            }
            int s = this.buf.cursor();
            for (int i = 0; i < this.repeatCount; i++) {
                while (this.buf.move(1) == 1 && this.buf.prevChar() != 10) {
                }
            }
            this.yankBuffer = this.buf.substring(s, this.buf.cursor());
            if (!this.yankBuffer.endsWith("\n")) {
                this.yankBuffer += "\n";
            }
            this.buf.cursor(p);
            return true;
        }

        protected boolean viChange() {
            int cursorStart = this.buf.cursor();
            Binding o = readBinding(getKeys());
            if (o instanceof Reference) {
                String op = viDeleteChangeYankToRemap(((Reference) o).name());
                if (LineReader.VI_CHANGE.equals(op)) {
                    killWholeLine();
                } else {
                    this.viMoveMode = ViMoveMode.CHANGE;
                    Widget widget = this.widgets.get(op);
                    if (widget == null || widget.apply()) {
                        this.viMoveMode = ViMoveMode.NORMAL;
                    } else {
                        this.viMoveMode = ViMoveMode.NORMAL;
                        return false;
                    }
                }
                boolean res = viChange(cursorStart, this.buf.cursor());
                setKeyMap(LineReader.VIINS);
                return res;
            }
            pushBackBinding();
            return false;
        }

        protected void cleanup() {
            if (isSet(LineReader.Option.ERASE_LINE_ON_FINISH)) {
                Buffer oldBuffer = this.buf.copy();
                AttributedString oldPrompt = this.prompt;
                this.buf.clear();
                this.prompt = new AttributedString("");
                doCleanup(false);
                this.prompt = oldPrompt;
                this.buf.copyFrom(oldBuffer);
                return;
            }
            doCleanup(true);
        }

        protected void doCleanup(boolean nl) {
            this.buf.cursor(this.buf.length());
            this.post = null;
            if (this.size.getColumns() > 0 || this.size.getRows() > 0) {
                this.doAutosuggestion = false;
                redisplay(false);
                if (nl) {
                    println();
                }
                this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                this.terminal.trackMouse(Terminal.MouseTracking.Off);
                if (isSet(LineReader.Option.BRACKETED_PASTE) && !isTerminalDumb()) {
                    this.terminal.writer().write(BRACKETED_PASTE_OFF);
                }
                flush();
            }
            this.history.moveToEnd();
        }

        protected boolean historyIncrementalSearchForward() {
            return doSearchHistory(false);
        }

        protected boolean historyIncrementalSearchBackward() {
            return doSearchHistory(true);
        }

        /* access modifiers changed from: package-private */
        /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$Pair.class */
        public static class Pair<U, V> {

            /* renamed from: u */
            final U f3232u;

            /* renamed from: v */
            final V f3233v;

            public Pair(U u, V v) {
                this.f3232u = u;
                this.f3233v = v;
            }

            public U getU() {
                return this.f3232u;
            }

            public V getV() {
                return this.f3233v;
            }
        }

        protected boolean doSearchHistory(boolean backward) {
            Pair<Integer, Integer> pair;
            if (this.history.isEmpty()) {
                return false;
            }
            KeyMap<Binding> terminators = new KeyMap<>();
            getString(LineReader.SEARCH_TERMINATORS, DEFAULT_SEARCH_TERMINATORS).codePoints().forEach(c -> {
                bind(terminators, LineReader.ACCEPT_LINE, new String(Character.toChars(terminators)));
            });
            Buffer originalBuffer = this.buf.copy();
            this.searchIndex = -1;
            this.searchTerm = new StringBuffer();
            this.searchBackward = backward;
            this.searchFailing = false;
            this.post = () -> {
                return new AttributedString((this.searchFailing ? "failing " : "") + (this.searchBackward ? "bck-i-search" : "fwd-i-search") + ": " + ((Object) this.searchTerm) + JavaConstant.Dynamic.DEFAULT_NAME);
            };
            redisplay();
            while (true) {
                try {
                    try {
                        int i = this.searchIndex;
                        Binding operation = readBinding(getKeys(), terminators);
                        String ref = operation instanceof Reference ? ((Reference) operation).name() : "";
                        boolean next = false;
                        char c = 65535;
                        switch (ref.hashCode()) {
                            case 83530940:
                                if (ref.equals(LineReader.HISTORY_INCREMENTAL_SEARCH_BACKWARD)) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 92611376:
                                if (ref.equals(LineReader.SEND_BREAK)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 275063630:
                                if (ref.equals(LineReader.BACKWARD_DELETE_CHAR)) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 504023756:
                                if (ref.equals(LineReader.HISTORY_INCREMENTAL_SEARCH_FORWARD)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 976605274:
                                if (ref.equals(LineReader.SELF_INSERT)) {
                                    c = 4;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                beep();
                                this.buf.copyFrom(originalBuffer);
                                this.searchTerm = null;
                                this.searchIndex = -1;
                                this.post = null;
                                return true;
                            case 1:
                                this.searchBackward = true;
                                next = true;
                                break;
                            case 2:
                                this.searchBackward = false;
                                next = true;
                                break;
                            case 3:
                                if (this.searchTerm.length() > 0) {
                                    this.searchTerm.deleteCharAt(this.searchTerm.length() - 1);
                                    break;
                                }
                                break;
                            case 4:
                                this.searchTerm.append(getLastBinding());
                                break;
                            default:
                                if (this.searchIndex != -1) {
                                    this.history.moveTo(this.searchIndex);
                                }
                                pushBackBinding();
                                this.searchTerm = null;
                                this.searchIndex = -1;
                                this.post = null;
                                return true;
                        }
                        String pattern = doGetSearchPattern();
                        if (pattern.length() == 0) {
                            this.buf.copyFrom(originalBuffer);
                            this.searchFailing = false;
                        } else {
                            Pattern pat = Pattern.compile(pattern, isSet(LineReader.Option.CASE_INSENSITIVE_SEARCH) ? 66 : 64);
                            if (this.searchBackward) {
                                pair = matches(pat, this.buf.toString(), this.searchIndex).stream().filter(p -> {
                                    return nextOnly ? ((Integer) next.f3233v).intValue() < this.buf.cursor() : ((Integer) next.f3233v).intValue() <= this.buf.cursor();
                                }).max(Comparator.comparing((v0) -> {
                                    return v0.getV();
                                })).orElse(null);
                                if (pair == null) {
                                    pair = (Pair) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.history.reverseIterator(this.searchIndex < 0 ? this.history.last() : this.searchIndex - 1), 16), false).flatMap(e -> {
                                        return matches(pat, pat.line(), pat.index()).stream();
                                    }).findFirst().orElse(null);
                                }
                            } else {
                                pair = matches(pat, this.buf.toString(), this.searchIndex).stream().filter(p -> {
                                    return nextOnly ? ((Integer) next.f3233v).intValue() > this.buf.cursor() : ((Integer) next.f3233v).intValue() >= this.buf.cursor();
                                }).min(Comparator.comparing((v0) -> {
                                    return v0.getV();
                                })).orElse(null);
                                if (pair == null) {
                                    pair = (Pair) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.history.iterator((this.searchIndex < 0 ? this.history.last() : this.searchIndex) + 1), 16), false).flatMap(e -> {
                                        return matches(pat, pat.line(), pat.index()).stream();
                                    }).findFirst().orElse(null);
                                    if (pair == null && this.searchIndex >= 0) {
                                        pair = matches(pat, originalBuffer.toString(), -1).stream().min(Comparator.comparing((v0) -> {
                                            return v0.getV();
                                        })).orElse(null);
                                    }
                                }
                            }
                            if (pair != null) {
                                this.searchIndex = pair.f3232u.intValue();
                                this.buf.clear();
                                if (this.searchIndex >= 0) {
                                    this.buf.write(this.history.get(this.searchIndex));
                                } else {
                                    this.buf.write(originalBuffer.toString());
                                }
                                this.buf.cursor(pair.f3233v.intValue());
                                this.searchFailing = false;
                            } else {
                                this.searchFailing = true;
                                beep();
                            }
                        }
                        redisplay();
                    } catch (IOError e) {
                        if (!(e.getCause() instanceof InterruptedException)) {
                            throw e;
                        }
                        this.searchTerm = null;
                        this.searchIndex = -1;
                        this.post = null;
                        return true;
                    }
                } catch (Throwable th) {
                    this.searchTerm = null;
                    this.searchIndex = -1;
                    this.post = null;
                    throw th;
                }
            }
        }

        private List<Pair<Integer, Integer>> matches(Pattern p, String line, int index) {
            List<Pair<Integer, Integer>> starts = new ArrayList<>();
            Matcher m = p.matcher(line);
            while (m.find()) {
                starts.add(new Pair<>(Integer.valueOf(index), Integer.valueOf(m.start())));
            }
            return starts;
        }

        private String doGetSearchPattern() {
            StringBuilder sb = new StringBuilder();
            boolean inQuote = false;
            for (int i = 0; i < this.searchTerm.length(); i++) {
                char c = this.searchTerm.charAt(i);
                if (Character.isLowerCase(c)) {
                    if (inQuote) {
                        sb.append("\\E");
                        inQuote = false;
                    }
                    sb.append("[").append(Character.toLowerCase(c)).append(Character.toUpperCase(c)).append("]");
                } else {
                    if (!inQuote) {
                        sb.append("\\Q");
                        inQuote = true;
                    }
                    sb.append(c);
                }
            }
            if (inQuote) {
                sb.append("\\E");
            }
            return sb.toString();
        }

        private void pushBackBinding() {
            pushBackBinding(false);
        }

        private void pushBackBinding(boolean skip) {
            String s = getLastBinding();
            if (s != null) {
                this.bindingReader.runMacro(s);
                this.skipRedisplay = skip;
            }
        }

        protected boolean historySearchForward() {
            if (this.historyBuffer == null || this.buf.length() == 0 || !this.buf.toString().equals(this.history.current())) {
                this.historyBuffer = this.buf.copy();
                this.searchBuffer = getFirstWord();
            }
            int index = this.history.index() + 1;
            if (index < this.history.last() + 1) {
                int searchIndex = searchForwards(this.searchBuffer.toString(), index, true);
                if (searchIndex == -1) {
                    this.history.moveToEnd();
                    if (this.buf.toString().equals(this.historyBuffer.toString())) {
                        return false;
                    }
                    setBuffer(this.historyBuffer.toString());
                    this.historyBuffer = null;
                    return true;
                } else if (this.history.moveTo(searchIndex)) {
                    setBuffer(this.history.current());
                    return true;
                } else {
                    this.history.moveToEnd();
                    setBuffer(this.historyBuffer.toString());
                    return false;
                }
            } else {
                this.history.moveToEnd();
                if (this.buf.toString().equals(this.historyBuffer.toString())) {
                    return false;
                }
                setBuffer(this.historyBuffer.toString());
                this.historyBuffer = null;
                return true;
            }
        }

        private CharSequence getFirstWord() {
            String s = this.buf.toString();
            int i = 0;
            while (i < s.length() && !Character.isWhitespace(s.charAt(i))) {
                i++;
            }
            return s.substring(0, i);
        }

        protected boolean historySearchBackward() {
            if (this.historyBuffer == null || this.buf.length() == 0 || !this.buf.toString().equals(this.history.current())) {
                this.historyBuffer = this.buf.copy();
                this.searchBuffer = getFirstWord();
            }
            int searchIndex = searchBackwards(this.searchBuffer.toString(), this.history.index(), true);
            if (searchIndex == -1 || !this.history.moveTo(searchIndex)) {
                return false;
            }
            setBuffer(this.history.current());
            return true;
        }

        public int searchBackwards(String searchTerm, int startIndex) {
            return searchBackwards(searchTerm, startIndex, false);
        }

        public int searchBackwards(String searchTerm) {
            return searchBackwards(searchTerm, this.history.index(), false);
        }

        public int searchBackwards(String searchTerm, int startIndex, boolean startsWith) {
            boolean caseInsensitive = isSet(LineReader.Option.CASE_INSENSITIVE_SEARCH);
            if (caseInsensitive) {
                searchTerm = searchTerm.toLowerCase();
            }
            ListIterator<History.Entry> it = this.history.iterator(startIndex);
            while (it.hasPrevious()) {
                History.Entry e = it.previous();
                String line = e.line();
                if (caseInsensitive) {
                    line = line.toLowerCase();
                }
                int idx = line.indexOf(searchTerm);
                if ((startsWith && idx == 0) || (!startsWith && idx >= 0)) {
                    return e.index();
                }
            }
            return -1;
        }

        public int searchForwards(String searchTerm, int startIndex, boolean startsWith) {
            boolean caseInsensitive = isSet(LineReader.Option.CASE_INSENSITIVE_SEARCH);
            if (caseInsensitive) {
                searchTerm = searchTerm.toLowerCase();
            }
            if (startIndex > this.history.last()) {
                startIndex = this.history.last();
            }
            ListIterator<History.Entry> it = this.history.iterator(startIndex);
            if (this.searchIndex != -1 && it.hasNext()) {
                it.next();
            }
            while (it.hasNext()) {
                History.Entry e = it.next();
                String line = e.line();
                if (caseInsensitive) {
                    line = line.toLowerCase();
                }
                int idx = line.indexOf(searchTerm);
                if ((startsWith && idx == 0) || (!startsWith && idx >= 0)) {
                    return e.index();
                }
            }
            return -1;
        }

        public int searchForwards(String searchTerm, int startIndex) {
            return searchForwards(searchTerm, startIndex, false);
        }

        public int searchForwards(String searchTerm) {
            return searchForwards(searchTerm, this.history.index());
        }

        protected boolean quit() {
            getBuffer().clear();
            return acceptLine();
        }

        protected boolean acceptAndHold() {
            this.nextCommandFromHistory = false;
            acceptLine();
            if (!this.buf.toString().isEmpty()) {
                this.nextHistoryId = Integer.MAX_VALUE;
                this.nextCommandFromHistory = true;
            }
            return this.nextCommandFromHistory;
        }

        protected boolean acceptLineAndDownHistory() {
            this.nextCommandFromHistory = false;
            acceptLine();
            if (this.nextHistoryId < 0) {
                this.nextHistoryId = this.history.index();
            }
            if (this.history.size() > this.nextHistoryId + 1) {
                this.nextHistoryId++;
                this.nextCommandFromHistory = true;
            }
            return this.nextCommandFromHistory;
        }

        protected boolean acceptAndInferNextHistory() {
            this.nextCommandFromHistory = false;
            acceptLine();
            if (!this.buf.toString().isEmpty()) {
                this.nextHistoryId = searchBackwards(this.buf.toString(), this.history.last());
                if (this.nextHistoryId >= 0 && this.history.size() > this.nextHistoryId + 1) {
                    this.nextHistoryId++;
                    this.nextCommandFromHistory = true;
                }
            }
            return this.nextCommandFromHistory;
        }

        protected boolean acceptLine() {
            this.parsedLine = null;
            int curPos = 0;
            if (!isSet(LineReader.Option.DISABLE_EVENT_EXPANSION)) {
                try {
                    String str = this.buf.toString();
                    String exp = this.expander.expandHistory(this.history, str);
                    if (!exp.equals(str)) {
                        this.buf.clear();
                        this.buf.write(exp);
                        if (isSet(LineReader.Option.HISTORY_VERIFY)) {
                            return true;
                        }
                    }
                } catch (IllegalArgumentException e) {
                }
            }
            try {
                curPos = this.buf.cursor();
                this.parsedLine = this.parser.parse(this.buf.toString(), this.buf.cursor(), Parser.ParseContext.ACCEPT_LINE);
            } catch (EOFError e2) {
                StringBuilder sb = new StringBuilder("\n");
                indention(e2.getOpenBrackets(), sb);
                int curMove = sb.length();
                if (isSet(LineReader.Option.INSERT_BRACKET) && e2.getOpenBrackets() > 1 && e2.getNextClosingBracket() != null) {
                    sb.append('\n');
                    indention(e2.getOpenBrackets() - 1, sb);
                    sb.append(e2.getNextClosingBracket());
                }
                this.buf.write(sb.toString());
                this.buf.cursor(curPos + curMove);
                return true;
            } catch (SyntaxError e3) {
            }
            callWidget(LineReader.CALLBACK_FINISH);
            this.state = State.DONE;
            return true;
        }

        void indention(int nb, StringBuilder sb) {
            int indent = getInt(LineReader.INDENTATION, 0) * nb;
            for (int i = 0; i < indent; i++) {
                sb.append(' ');
            }
        }

        protected boolean selfInsert() {
            for (int count = this.count; count > 0; count--) {
                putString(getLastBinding());
            }
            return true;
        }

        protected boolean selfInsertUnmeta() {
            if (getLastBinding().charAt(0) != 27) {
                return false;
            }
            String s = getLastBinding().substring(1);
            if ("\r".equals(s)) {
                s = "\n";
            }
            for (int count = this.count; count > 0; count--) {
                putString(s);
            }
            return true;
        }

        protected boolean overwriteMode() {
            this.overTyping = !this.overTyping;
            return true;
        }

        protected boolean beginningOfBufferOrHistory() {
            if (findbol() == 0) {
                return beginningOfHistory();
            }
            this.buf.cursor(0);
            return true;
        }

        protected boolean beginningOfHistory() {
            if (!this.history.moveToFirst()) {
                return false;
            }
            setBuffer(this.history.current());
            return true;
        }

        protected boolean endOfBufferOrHistory() {
            if (findeol() == this.buf.length()) {
                return endOfHistory();
            }
            this.buf.cursor(this.buf.length());
            return true;
        }

        protected boolean endOfHistory() {
            if (!this.history.moveToLast()) {
                return false;
            }
            setBuffer(this.history.current());
            return true;
        }

        protected boolean beginningOfLineHist() {
            if (this.count < 0) {
                return callNeg(this::endOfLineHist);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                int bol = findbol();
                if (bol != this.buf.cursor()) {
                    this.buf.cursor(bol);
                } else {
                    moveHistory(false);
                    this.buf.cursor(0);
                }
            }
        }

        protected boolean endOfLineHist() {
            if (this.count < 0) {
                return callNeg(this::beginningOfLineHist);
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                int eol = findeol();
                if (eol != this.buf.cursor()) {
                    this.buf.cursor(eol);
                } else {
                    moveHistory(true);
                }
            }
        }

        protected boolean upHistory() {
            do {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
            } while (moveHistory(false));
            return !isSet(LineReader.Option.HISTORY_BEEP);
        }

        protected boolean downHistory() {
            do {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
            } while (moveHistory(true));
            return !isSet(LineReader.Option.HISTORY_BEEP);
        }

        protected boolean viUpLineOrHistory() {
            return upLine() || (upHistory() && viFirstNonBlank());
        }

        protected boolean viDownLineOrHistory() {
            return downLine() || (downHistory() && viFirstNonBlank());
        }

        protected boolean upLine() {
            return this.buf.mo27up();
        }

        protected boolean downLine() {
            return this.buf.down();
        }

        protected boolean upLineOrHistory() {
            return upLine() || upHistory();
        }

        protected boolean upLineOrSearch() {
            return upLine() || historySearchBackward();
        }

        protected boolean downLineOrHistory() {
            return downLine() || downHistory();
        }

        protected boolean downLineOrSearch() {
            return downLine() || historySearchForward();
        }

        protected boolean viCmdMode() {
            if (this.state == State.NORMAL) {
                this.buf.move(-1);
            }
            return setKeyMap(LineReader.VICMD);
        }

        protected boolean viInsert() {
            return setKeyMap(LineReader.VIINS);
        }

        protected boolean viAddNext() {
            this.buf.move(1);
            return setKeyMap(LineReader.VIINS);
        }

        protected boolean viAddEol() {
            return endOfLine() && setKeyMap(LineReader.VIINS);
        }

        protected boolean emacsEditingMode() {
            return setKeyMap(LineReader.EMACS);
        }

        protected boolean viChangeWholeLine() {
            return viFirstNonBlank() && viChangeEol();
        }

        protected boolean viChangeEol() {
            return viChange(this.buf.cursor(), this.buf.length()) && setKeyMap(LineReader.VIINS);
        }

        protected boolean viKillEol() {
            int eol = findeol();
            if (this.buf.cursor() == eol) {
                return false;
            }
            this.killRing.add(this.buf.substring(this.buf.cursor(), eol));
            this.buf.delete(eol - this.buf.cursor());
            return true;
        }

        protected boolean quotedInsert() {
            int c = readCharacter();
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                putString(new String(Character.toChars(c)));
            }
        }

        protected boolean viJoin() {
            if (!this.buf.down()) {
                return false;
            }
            while (this.buf.move(-1) == -1 && this.buf.prevChar() != 10) {
            }
            this.buf.backspace();
            this.buf.write(32);
            this.buf.move(-1);
            return true;
        }

        protected boolean viKillWholeLine() {
            return killWholeLine() && setKeyMap(LineReader.VIINS);
        }

        protected boolean viInsertBol() {
            return beginningOfLine() && setKeyMap(LineReader.VIINS);
        }

        protected boolean backwardDeleteChar() {
            if (this.count < 0) {
                return callNeg(this::deleteChar);
            }
            if (this.buf.cursor() == 0) {
                return false;
            }
            this.buf.backspace(this.count);
            return true;
        }

        protected boolean viFirstNonBlank() {
            beginningOfLine();
            while (this.buf.cursor() < this.buf.length() && isWhitespace(this.buf.currChar())) {
                this.buf.move(1);
            }
            return true;
        }

        protected boolean viBeginningOfLine() {
            this.buf.cursor(findbol());
            return true;
        }

        protected boolean viEndOfLine() {
            if (this.count < 0) {
                return false;
            }
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i > 0) {
                    this.buf.cursor(findeol() + 1);
                } else {
                    this.buf.move(-1);
                    return true;
                }
            }
        }

        protected boolean beginningOfLine() {
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                while (this.buf.move(-1) == -1 && this.buf.prevChar() != 10) {
                }
            }
        }

        protected boolean endOfLine() {
            while (true) {
                int i = this.count;
                this.count = i - 1;
                if (i <= 0) {
                    return true;
                }
                while (this.buf.move(1) == 1 && this.buf.currChar() != 10) {
                }
            }
        }

        protected boolean deleteChar() {
            if (this.count < 0) {
                return callNeg(this::backwardDeleteChar);
            }
            if (this.buf.cursor() == this.buf.length()) {
                return false;
            }
            this.buf.delete(this.count);
            return true;
        }

        protected boolean viBackwardDeleteChar() {
            for (int i = 0; i < this.count; i++) {
                if (!this.buf.backspace()) {
                    return false;
                }
            }
            return true;
        }

        protected boolean viDeleteChar() {
            for (int i = 0; i < this.count; i++) {
                if (!this.buf.delete()) {
                    return false;
                }
            }
            return true;
        }

        protected boolean viSwapCase() {
            for (int i = 0; i < this.count; i++) {
                if (this.buf.cursor() >= this.buf.length()) {
                    return false;
                }
                this.buf.currChar(switchCase(this.buf.atChar(this.buf.cursor())));
                this.buf.move(1);
            }
            return true;
        }

        protected boolean viReplaceChars() {
            int c = readCharacter();
            if (c < 0 || c == 27 || c == 3) {
                return true;
            }
            for (int i = 0; i < this.count; i++) {
                if (!this.buf.currChar((char) c)) {
                    return false;
                }
                if (i < this.count - 1) {
                    this.buf.move(1);
                }
            }
            return true;
        }

        protected boolean viChange(int startPos, int endPos) {
            return doViDeleteOrChange(startPos, endPos, true);
        }

        protected boolean viDeleteTo(int startPos, int endPos) {
            return doViDeleteOrChange(startPos, endPos, false);
        }

        protected boolean doViDeleteOrChange(int startPos, int endPos, boolean isChange) {
            if (startPos == endPos) {
                return true;
            }
            if (endPos < startPos) {
                endPos = startPos;
                startPos = endPos;
            }
            this.buf.cursor(startPos);
            this.buf.delete(endPos - startPos);
            if (isChange || startPos <= 0 || startPos != this.buf.length()) {
                return true;
            }
            this.buf.move(-1);
            return true;
        }

        protected boolean viYankTo(int startPos, int endPos) {
            if (endPos < startPos) {
                endPos = startPos;
                startPos = endPos;
            }
            if (startPos == endPos) {
                this.yankBuffer = "";
                return true;
            }
            this.yankBuffer = this.buf.substring(startPos, endPos);
            this.buf.cursor(startPos);
            return true;
        }

        protected boolean viOpenLineAbove() {
            while (this.buf.move(-1) == -1 && this.buf.prevChar() != 10) {
            }
            this.buf.write(10);
            this.buf.move(-1);
            return setKeyMap(LineReader.VIINS);
        }

        protected boolean viOpenLineBelow() {
            while (this.buf.move(1) == 1 && this.buf.currChar() != 10) {
            }
            this.buf.write(10);
            return setKeyMap(LineReader.VIINS);
        }

        protected boolean viPutAfter() {
            if (this.yankBuffer.indexOf(10) >= 0) {
                while (this.buf.move(1) == 1 && this.buf.currChar() != 10) {
                }
                this.buf.move(1);
                putString(this.yankBuffer);
                this.buf.move(-this.yankBuffer.length());
                return true;
            } else if (this.yankBuffer.length() == 0) {
                return true;
            } else {
                if (this.buf.cursor() < this.buf.length()) {
                    this.buf.move(1);
                }
                for (int i = 0; i < this.count; i++) {
                    putString(this.yankBuffer);
                }
                this.buf.move(-1);
                return true;
            }
        }

        protected boolean viPutBefore() {
            if (this.yankBuffer.indexOf(10) >= 0) {
                while (this.buf.move(-1) == -1 && this.buf.prevChar() != 10) {
                }
                putString(this.yankBuffer);
                this.buf.move(-this.yankBuffer.length());
                return true;
            } else if (this.yankBuffer.length() == 0) {
                return true;
            } else {
                if (this.buf.cursor() > 0) {
                    this.buf.move(-1);
                }
                for (int i = 0; i < this.count; i++) {
                    putString(this.yankBuffer);
                }
                this.buf.move(-1);
                return true;
            }
        }

        protected boolean doLowercaseVersion() {
            this.bindingReader.runMacro(getLastBinding().toLowerCase());
            return true;
        }

        protected boolean setMarkCommand() {
            if (this.count < 0) {
                this.regionActive = LineReader.RegionType.NONE;
                return true;
            }
            this.regionMark = this.buf.cursor();
            this.regionActive = LineReader.RegionType.CHAR;
            return true;
        }

        protected boolean exchangePointAndMark() {
            if (this.count == 0) {
                this.regionActive = LineReader.RegionType.CHAR;
                return true;
            }
            int x = this.regionMark;
            this.regionMark = this.buf.cursor();
            this.buf.cursor(x);
            if (this.buf.cursor() > this.buf.length()) {
                this.buf.cursor(this.buf.length());
            }
            if (this.count <= 0) {
                return true;
            }
            this.regionActive = LineReader.RegionType.CHAR;
            return true;
        }

        protected boolean visualMode() {
            if (isInViMoveOperation()) {
                this.isArgDigit = true;
                this.forceLine = false;
                this.forceChar = true;
                return true;
            } else if (this.regionActive == LineReader.RegionType.NONE) {
                this.regionMark = this.buf.cursor();
                this.regionActive = LineReader.RegionType.CHAR;
                return true;
            } else if (this.regionActive == LineReader.RegionType.CHAR) {
                this.regionActive = LineReader.RegionType.NONE;
                return true;
            } else if (this.regionActive != LineReader.RegionType.LINE) {
                return true;
            } else {
                this.regionActive = LineReader.RegionType.CHAR;
                return true;
            }
        }

        protected boolean visualLineMode() {
            if (isInViMoveOperation()) {
                this.isArgDigit = true;
                this.forceLine = true;
                this.forceChar = false;
                return true;
            } else if (this.regionActive == LineReader.RegionType.NONE) {
                this.regionMark = this.buf.cursor();
                this.regionActive = LineReader.RegionType.LINE;
                return true;
            } else if (this.regionActive == LineReader.RegionType.CHAR) {
                this.regionActive = LineReader.RegionType.LINE;
                return true;
            } else if (this.regionActive != LineReader.RegionType.LINE) {
                return true;
            } else {
                this.regionActive = LineReader.RegionType.NONE;
                return true;
            }
        }

        protected boolean deactivateRegion() {
            this.regionActive = LineReader.RegionType.NONE;
            return true;
        }

        protected boolean whatCursorPosition() {
            this.post = () -> {
                AttributedStringBuilder sb = new AttributedStringBuilder();
                if (this.buf.cursor() < this.buf.length()) {
                    int c = this.buf.currChar();
                    sb.append((CharSequence) "Char: ");
                    if (c == 32) {
                        sb.append((CharSequence) "SPC");
                    } else if (c == 10) {
                        sb.append((CharSequence) "LFD");
                    } else if (c < 32) {
                        sb.append('^');
                        sb.append((char) ((c + 65) - 1));
                    } else if (c == 127) {
                        sb.append((CharSequence) "^?");
                    } else {
                        sb.append((char) c);
                    }
                    sb.append((CharSequence) " (");
                    sb.append((CharSequence) "0").append((CharSequence) Integer.toOctalString(c)).append((CharSequence) " ");
                    sb.append((CharSequence) Integer.toString(c)).append((CharSequence) " ");
                    sb.append((CharSequence) "0x").append((CharSequence) Integer.toHexString(c)).append((CharSequence) " ");
                    sb.append((CharSequence) DESC_SUFFIX);
                } else {
                    sb.append((CharSequence) "EOF");
                }
                sb.append((CharSequence) "   ");
                sb.append((CharSequence) "point ");
                sb.append((CharSequence) Integer.toString(this.buf.cursor() + 1));
                sb.append((CharSequence) " of ");
                sb.append((CharSequence) Integer.toString(this.buf.length() + 1));
                sb.append((CharSequence) " (");
                sb.append((CharSequence) Integer.toString(this.buf.length() == 0 ? 100 : (100 * this.buf.cursor()) / this.buf.length()));
                sb.append((CharSequence) "%)");
                sb.append((CharSequence) "   ");
                sb.append((CharSequence) "column ");
                sb.append((CharSequence) Integer.toString(this.buf.cursor() - findbol()));
                return sb.toAttributedString();
            };
            return true;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0029
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        protected boolean editAndExecute() {
            /*
                r4 = this;
                r0 = 1
                r5 = r0
                r0 = 0
                r6 = r0
                java.lang.String r0 = "jline-execute-"
                r1 = 0
                java.io.File r0 = java.io.File.createTempFile(r0, r1)     // Catch: Exception -> 0x005d, all -> 0x0087
                r6 = r0
                java.io.FileWriter r0 = new java.io.FileWriter     // Catch: Exception -> 0x005d, all -> 0x0087
                r1 = r0
                r2 = r6
                r1.<init>(r2)     // Catch: Exception -> 0x005d, all -> 0x0087
                r7 = r0
                r0 = r7
                r1 = r4
                org.jline.reader.Buffer r1 = r1.buf     // Catch: Exception -> 0x005d, all -> 0x0087, Throwable -> 0x0029
                java.lang.String r1 = r1.toString()     // Catch: Exception -> 0x005d, all -> 0x0087, Throwable -> 0x0029
                r0.write(r1)     // Catch: Exception -> 0x005d, all -> 0x0087, Throwable -> 0x0029
                r0 = r7
                r0.close()     // Catch: Exception -> 0x005d, all -> 0x0087
                goto L_0x003e
            L_0x0029:
                r8 = move-exception
                r0 = r7
                r0.close()     // Catch: Exception -> 0x005d, all -> 0x0087, Throwable -> 0x0032
                goto L_0x003b
            L_0x0032:
                r9 = move-exception
                r0 = r8
                r1 = r9
                r0.addSuppressed(r1)     // Catch: Exception -> 0x005d, all -> 0x0087
            L_0x003b:
                r0 = r8
                throw r0     // Catch: Exception -> 0x005d, all -> 0x0087
            L_0x003e:
                r0 = r4
                r1 = r6
                r0.editAndAddInBuffer(r1)     // Catch: Exception -> 0x005d, all -> 0x0087
                r0 = r4
                org.jline.reader.impl.LineReaderImpl$State r1 = org.jline.reader.impl.LineReaderImpl.State.IGNORE
                r0.state = r1
                r0 = r6
                if (r0 == 0) goto L_0x00a3
                r0 = r6
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x00a3
                r0 = r6
                boolean r0 = r0.delete()
                goto L_0x00a3
            L_0x005d:
                r7 = move-exception
                r0 = r7
                r1 = r4
                org.jline.terminal.Terminal r1 = r1.terminal     // Catch: all -> 0x0087
                java.io.PrintWriter r1 = r1.writer()     // Catch: all -> 0x0087
                r0.printStackTrace(r1)     // Catch: all -> 0x0087
                r0 = 0
                r5 = r0
                r0 = r4
                org.jline.reader.impl.LineReaderImpl$State r1 = org.jline.reader.impl.LineReaderImpl.State.IGNORE
                r0.state = r1
                r0 = r6
                if (r0 == 0) goto L_0x00a3
                r0 = r6
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x00a3
                r0 = r6
                boolean r0 = r0.delete()
                goto L_0x00a3
            L_0x0087:
                r10 = move-exception
                r0 = r4
                org.jline.reader.impl.LineReaderImpl$State r1 = org.jline.reader.impl.LineReaderImpl.State.IGNORE
                r0.state = r1
                r0 = r6
                if (r0 == 0) goto L_0x00a0
                r0 = r6
                boolean r0 = r0.exists()
                if (r0 == 0) goto L_0x00a0
                r0 = r6
                boolean r0 = r0.delete()
            L_0x00a0:
                r0 = r10
                throw r0
            L_0x00a3:
                r0 = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.reader.impl.LineReaderImpl.editAndExecute():boolean");
        }

        protected Map<String, Widget> builtinWidgets() {
            Map<String, Widget> widgets = new HashMap<>();
            addBuiltinWidget(widgets, LineReader.ACCEPT_AND_INFER_NEXT_HISTORY, this::acceptAndInferNextHistory);
            addBuiltinWidget(widgets, LineReader.ACCEPT_AND_HOLD, this::acceptAndHold);
            addBuiltinWidget(widgets, LineReader.ACCEPT_LINE, this::acceptLine);
            addBuiltinWidget(widgets, LineReader.ACCEPT_LINE_AND_DOWN_HISTORY, this::acceptLineAndDownHistory);
            addBuiltinWidget(widgets, LineReader.ARGUMENT_BASE, this::argumentBase);
            addBuiltinWidget(widgets, LineReader.BACKWARD_CHAR, this::backwardChar);
            addBuiltinWidget(widgets, LineReader.BACKWARD_DELETE_CHAR, this::backwardDeleteChar);
            addBuiltinWidget(widgets, LineReader.BACKWARD_DELETE_WORD, this::backwardDeleteWord);
            addBuiltinWidget(widgets, LineReader.BACKWARD_KILL_LINE, this::backwardKillLine);
            addBuiltinWidget(widgets, LineReader.BACKWARD_KILL_WORD, this::backwardKillWord);
            addBuiltinWidget(widgets, LineReader.BACKWARD_WORD, this::backwardWord);
            addBuiltinWidget(widgets, LineReader.BEEP, this::beep);
            addBuiltinWidget(widgets, LineReader.BEGINNING_OF_BUFFER_OR_HISTORY, this::beginningOfBufferOrHistory);
            addBuiltinWidget(widgets, LineReader.BEGINNING_OF_HISTORY, this::beginningOfHistory);
            addBuiltinWidget(widgets, LineReader.BEGINNING_OF_LINE, this::beginningOfLine);
            addBuiltinWidget(widgets, LineReader.BEGINNING_OF_LINE_HIST, this::beginningOfLineHist);
            addBuiltinWidget(widgets, LineReader.CAPITALIZE_WORD, this::capitalizeWord);
            addBuiltinWidget(widgets, LineReader.CLEAR, this::clear);
            addBuiltinWidget(widgets, LineReader.CLEAR_SCREEN, this::clearScreen);
            addBuiltinWidget(widgets, LineReader.COMPLETE_PREFIX, this::completePrefix);
            addBuiltinWidget(widgets, LineReader.COMPLETE_WORD, this::completeWord);
            addBuiltinWidget(widgets, LineReader.COPY_PREV_WORD, this::copyPrevWord);
            addBuiltinWidget(widgets, LineReader.COPY_REGION_AS_KILL, this::copyRegionAsKill);
            addBuiltinWidget(widgets, LineReader.DELETE_CHAR, this::deleteChar);
            addBuiltinWidget(widgets, LineReader.DELETE_CHAR_OR_LIST, this::deleteCharOrList);
            addBuiltinWidget(widgets, LineReader.DELETE_WORD, this::deleteWord);
            addBuiltinWidget(widgets, LineReader.DIGIT_ARGUMENT, this::digitArgument);
            addBuiltinWidget(widgets, LineReader.DO_LOWERCASE_VERSION, this::doLowercaseVersion);
            addBuiltinWidget(widgets, LineReader.DOWN_CASE_WORD, this::downCaseWord);
            addBuiltinWidget(widgets, LineReader.DOWN_LINE, this::downLine);
            addBuiltinWidget(widgets, LineReader.DOWN_LINE_OR_HISTORY, this::downLineOrHistory);
            addBuiltinWidget(widgets, LineReader.DOWN_LINE_OR_SEARCH, this::downLineOrSearch);
            addBuiltinWidget(widgets, LineReader.DOWN_HISTORY, this::downHistory);
            addBuiltinWidget(widgets, LineReader.EDIT_AND_EXECUTE_COMMAND, this::editAndExecute);
            addBuiltinWidget(widgets, LineReader.EMACS_EDITING_MODE, this::emacsEditingMode);
            addBuiltinWidget(widgets, LineReader.EMACS_BACKWARD_WORD, this::emacsBackwardWord);
            addBuiltinWidget(widgets, LineReader.EMACS_FORWARD_WORD, this::emacsForwardWord);
            addBuiltinWidget(widgets, LineReader.END_OF_BUFFER_OR_HISTORY, this::endOfBufferOrHistory);
            addBuiltinWidget(widgets, LineReader.END_OF_HISTORY, this::endOfHistory);
            addBuiltinWidget(widgets, LineReader.END_OF_LINE, this::endOfLine);
            addBuiltinWidget(widgets, LineReader.END_OF_LINE_HIST, this::endOfLineHist);
            addBuiltinWidget(widgets, LineReader.EXCHANGE_POINT_AND_MARK, this::exchangePointAndMark);
            addBuiltinWidget(widgets, LineReader.EXPAND_HISTORY, this::expandHistory);
            addBuiltinWidget(widgets, LineReader.EXPAND_OR_COMPLETE, this::expandOrComplete);
            addBuiltinWidget(widgets, LineReader.EXPAND_OR_COMPLETE_PREFIX, this::expandOrCompletePrefix);
            addBuiltinWidget(widgets, LineReader.EXPAND_WORD, this::expandWord);
            addBuiltinWidget(widgets, LineReader.FRESH_LINE, this::freshLine);
            addBuiltinWidget(widgets, LineReader.FORWARD_CHAR, this::forwardChar);
            addBuiltinWidget(widgets, LineReader.FORWARD_WORD, this::forwardWord);
            addBuiltinWidget(widgets, LineReader.HISTORY_INCREMENTAL_SEARCH_BACKWARD, this::historyIncrementalSearchBackward);
            addBuiltinWidget(widgets, LineReader.HISTORY_INCREMENTAL_SEARCH_FORWARD, this::historyIncrementalSearchForward);
            addBuiltinWidget(widgets, LineReader.HISTORY_SEARCH_BACKWARD, this::historySearchBackward);
            addBuiltinWidget(widgets, LineReader.HISTORY_SEARCH_FORWARD, this::historySearchForward);
            addBuiltinWidget(widgets, LineReader.INSERT_CLOSE_CURLY, this::insertCloseCurly);
            addBuiltinWidget(widgets, LineReader.INSERT_CLOSE_PAREN, this::insertCloseParen);
            addBuiltinWidget(widgets, LineReader.INSERT_CLOSE_SQUARE, this::insertCloseSquare);
            addBuiltinWidget(widgets, LineReader.INSERT_COMMENT, this::insertComment);
            addBuiltinWidget(widgets, LineReader.KILL_BUFFER, this::killBuffer);
            addBuiltinWidget(widgets, LineReader.KILL_LINE, this::killLine);
            addBuiltinWidget(widgets, LineReader.KILL_REGION, this::killRegion);
            addBuiltinWidget(widgets, LineReader.KILL_WHOLE_LINE, this::killWholeLine);
            addBuiltinWidget(widgets, LineReader.KILL_WORD, this::killWord);
            addBuiltinWidget(widgets, LineReader.LIST_CHOICES, this::listChoices);
            addBuiltinWidget(widgets, LineReader.MENU_COMPLETE, this::menuComplete);
            addBuiltinWidget(widgets, LineReader.MENU_EXPAND_OR_COMPLETE, this::menuExpandOrComplete);
            addBuiltinWidget(widgets, LineReader.NEG_ARGUMENT, this::negArgument);
            addBuiltinWidget(widgets, LineReader.OVERWRITE_MODE, this::overwriteMode);
            addBuiltinWidget(widgets, LineReader.QUOTED_INSERT, this::quotedInsert);
            addBuiltinWidget(widgets, LineReader.REDISPLAY, this::redisplay);
            addBuiltinWidget(widgets, LineReader.REDRAW_LINE, this::redrawLine);
            addBuiltinWidget(widgets, LineReader.REDO, this::redo);
            addBuiltinWidget(widgets, LineReader.SELF_INSERT, this::selfInsert);
            addBuiltinWidget(widgets, LineReader.SELF_INSERT_UNMETA, this::selfInsertUnmeta);
            addBuiltinWidget(widgets, LineReader.SEND_BREAK, this::sendBreak);
            addBuiltinWidget(widgets, LineReader.SET_MARK_COMMAND, this::setMarkCommand);
            addBuiltinWidget(widgets, LineReader.TRANSPOSE_CHARS, this::transposeChars);
            addBuiltinWidget(widgets, LineReader.TRANSPOSE_WORDS, this::transposeWords);
            addBuiltinWidget(widgets, LineReader.UNDEFINED_KEY, this::undefinedKey);
            addBuiltinWidget(widgets, LineReader.UNIVERSAL_ARGUMENT, this::universalArgument);
            addBuiltinWidget(widgets, LineReader.UNDO, this::undo);
            addBuiltinWidget(widgets, LineReader.UP_CASE_WORD, this::upCaseWord);
            addBuiltinWidget(widgets, LineReader.UP_HISTORY, this::upHistory);
            addBuiltinWidget(widgets, LineReader.UP_LINE, this::upLine);
            addBuiltinWidget(widgets, LineReader.UP_LINE_OR_HISTORY, this::upLineOrHistory);
            addBuiltinWidget(widgets, LineReader.UP_LINE_OR_SEARCH, this::upLineOrSearch);
            addBuiltinWidget(widgets, LineReader.VI_ADD_EOL, this::viAddEol);
            addBuiltinWidget(widgets, LineReader.VI_ADD_NEXT, this::viAddNext);
            addBuiltinWidget(widgets, LineReader.VI_BACKWARD_CHAR, this::viBackwardChar);
            addBuiltinWidget(widgets, LineReader.VI_BACKWARD_DELETE_CHAR, this::viBackwardDeleteChar);
            addBuiltinWidget(widgets, LineReader.VI_BACKWARD_BLANK_WORD, this::viBackwardBlankWord);
            addBuiltinWidget(widgets, LineReader.VI_BACKWARD_BLANK_WORD_END, this::viBackwardBlankWordEnd);
            addBuiltinWidget(widgets, LineReader.VI_BACKWARD_KILL_WORD, this::viBackwardKillWord);
            addBuiltinWidget(widgets, LineReader.VI_BACKWARD_WORD, this::viBackwardWord);
            addBuiltinWidget(widgets, LineReader.VI_BACKWARD_WORD_END, this::viBackwardWordEnd);
            addBuiltinWidget(widgets, LineReader.VI_BEGINNING_OF_LINE, this::viBeginningOfLine);
            addBuiltinWidget(widgets, LineReader.VI_CMD_MODE, this::viCmdMode);
            addBuiltinWidget(widgets, LineReader.VI_DIGIT_OR_BEGINNING_OF_LINE, this::viDigitOrBeginningOfLine);
            addBuiltinWidget(widgets, LineReader.VI_DOWN_LINE_OR_HISTORY, this::viDownLineOrHistory);
            addBuiltinWidget(widgets, LineReader.VI_CHANGE, this::viChange);
            addBuiltinWidget(widgets, LineReader.VI_CHANGE_EOL, this::viChangeEol);
            addBuiltinWidget(widgets, LineReader.VI_CHANGE_WHOLE_LINE, this::viChangeWholeLine);
            addBuiltinWidget(widgets, LineReader.VI_DELETE_CHAR, this::viDeleteChar);
            addBuiltinWidget(widgets, LineReader.VI_DELETE, this::viDelete);
            addBuiltinWidget(widgets, LineReader.VI_END_OF_LINE, this::viEndOfLine);
            addBuiltinWidget(widgets, LineReader.VI_KILL_EOL, this::viKillEol);
            addBuiltinWidget(widgets, LineReader.VI_FIRST_NON_BLANK, this::viFirstNonBlank);
            addBuiltinWidget(widgets, LineReader.VI_FIND_NEXT_CHAR, this::viFindNextChar);
            addBuiltinWidget(widgets, LineReader.VI_FIND_NEXT_CHAR_SKIP, this::viFindNextCharSkip);
            addBuiltinWidget(widgets, LineReader.VI_FIND_PREV_CHAR, this::viFindPrevChar);
            addBuiltinWidget(widgets, LineReader.VI_FIND_PREV_CHAR_SKIP, this::viFindPrevCharSkip);
            addBuiltinWidget(widgets, LineReader.VI_FORWARD_BLANK_WORD, this::viForwardBlankWord);
            addBuiltinWidget(widgets, LineReader.VI_FORWARD_BLANK_WORD_END, this::viForwardBlankWordEnd);
            addBuiltinWidget(widgets, LineReader.VI_FORWARD_CHAR, this::viForwardChar);
            addBuiltinWidget(widgets, LineReader.VI_FORWARD_WORD, this::viForwardWord);
            addBuiltinWidget(widgets, LineReader.VI_FORWARD_WORD, this::viForwardWord);
            addBuiltinWidget(widgets, LineReader.VI_FORWARD_WORD_END, this::viForwardWordEnd);
            addBuiltinWidget(widgets, LineReader.VI_HISTORY_SEARCH_BACKWARD, this::viHistorySearchBackward);
            addBuiltinWidget(widgets, LineReader.VI_HISTORY_SEARCH_FORWARD, this::viHistorySearchForward);
            addBuiltinWidget(widgets, LineReader.VI_INSERT, this::viInsert);
            addBuiltinWidget(widgets, LineReader.VI_INSERT_BOL, this::viInsertBol);
            addBuiltinWidget(widgets, LineReader.VI_INSERT_COMMENT, this::viInsertComment);
            addBuiltinWidget(widgets, LineReader.VI_JOIN, this::viJoin);
            addBuiltinWidget(widgets, LineReader.VI_KILL_LINE, this::viKillWholeLine);
            addBuiltinWidget(widgets, LineReader.VI_MATCH_BRACKET, this::viMatchBracket);
            addBuiltinWidget(widgets, LineReader.VI_OPEN_LINE_ABOVE, this::viOpenLineAbove);
            addBuiltinWidget(widgets, LineReader.VI_OPEN_LINE_BELOW, this::viOpenLineBelow);
            addBuiltinWidget(widgets, LineReader.VI_PUT_AFTER, this::viPutAfter);
            addBuiltinWidget(widgets, LineReader.VI_PUT_BEFORE, this::viPutBefore);
            addBuiltinWidget(widgets, LineReader.VI_REPEAT_FIND, this::viRepeatFind);
            addBuiltinWidget(widgets, LineReader.VI_REPEAT_SEARCH, this::viRepeatSearch);
            addBuiltinWidget(widgets, LineReader.VI_REPLACE_CHARS, this::viReplaceChars);
            addBuiltinWidget(widgets, LineReader.VI_REV_REPEAT_FIND, this::viRevRepeatFind);
            addBuiltinWidget(widgets, LineReader.VI_REV_REPEAT_SEARCH, this::viRevRepeatSearch);
            addBuiltinWidget(widgets, LineReader.VI_SWAP_CASE, this::viSwapCase);
            addBuiltinWidget(widgets, LineReader.VI_UP_LINE_OR_HISTORY, this::viUpLineOrHistory);
            addBuiltinWidget(widgets, LineReader.VI_YANK, this::viYankTo);
            addBuiltinWidget(widgets, LineReader.VI_YANK_WHOLE_LINE, this::viYankWholeLine);
            addBuiltinWidget(widgets, LineReader.VISUAL_LINE_MODE, this::visualLineMode);
            addBuiltinWidget(widgets, LineReader.VISUAL_MODE, this::visualMode);
            addBuiltinWidget(widgets, LineReader.WHAT_CURSOR_POSITION, this::whatCursorPosition);
            addBuiltinWidget(widgets, LineReader.YANK, this::yank);
            addBuiltinWidget(widgets, LineReader.YANK_POP, this::yankPop);
            addBuiltinWidget(widgets, LineReader.MOUSE, this::mouse);
            addBuiltinWidget(widgets, LineReader.BEGIN_PASTE, this::beginPaste);
            addBuiltinWidget(widgets, LineReader.FOCUS_IN, this::focusIn);
            addBuiltinWidget(widgets, LineReader.FOCUS_OUT, this::focusOut);
            return widgets;
        }

        private void addBuiltinWidget(Map<String, Widget> widgets, String name, Widget widget) {
            widgets.put(name, namedWidget(Mapper.IGNORED_FIELDNAME + name, widget));
        }

        private Widget namedWidget(final String name, final Widget widget) {
            return new Widget() { // from class: org.jline.reader.impl.LineReaderImpl.1
                public String toString() {
                    return name;
                }

                @Override // org.jline.reader.Widget
                public boolean apply() {
                    return widget.apply();
                }
            };
        }

        public boolean redisplay() {
            redisplay(true);
            return true;
        }

        protected void redisplay(boolean flush) {
            List<AttributedString> newLines;
            List<AttributedString> rightPromptLines;
            try {
                this.lock.lock();
                if (this.skipRedisplay) {
                    this.skipRedisplay = false;
                    this.lock.unlock();
                    return;
                }
                Status status = Status.getStatus(this.terminal, false);
                if (status != null) {
                    status.redraw();
                }
                if (this.size.getRows() <= 0 || this.size.getRows() >= 3) {
                    List<AttributedString> secondaryPrompts = new ArrayList<>();
                    AttributedString full = getDisplayedBufferWithPrompts(secondaryPrompts);
                    if (this.size.getColumns() <= 0) {
                        newLines = new ArrayList<>();
                        newLines.add(full);
                    } else {
                        newLines = full.columnSplitLength(this.size.getColumns(), true, this.display.delayLineWrap());
                    }
                    if (this.rightPrompt.length() == 0 || this.size.getColumns() <= 0) {
                        rightPromptLines = new ArrayList();
                    } else {
                        rightPromptLines = this.rightPrompt.columnSplitLength(this.size.getColumns());
                    }
                    while (newLines.size() < rightPromptLines.size()) {
                        newLines.add(new AttributedString(""));
                    }
                    for (int i = 0; i < rightPromptLines.size(); i++) {
                        newLines.set(i, addRightPrompt(rightPromptLines.get(i), newLines.get(i)));
                    }
                    int cursorPos = -1;
                    int cursorNewLinesId = -1;
                    int cursorColPos = -1;
                    if (this.size.getColumns() > 0) {
                        AttributedStringBuilder sb = new AttributedStringBuilder().tabs(4);
                        sb.append(this.prompt);
                        String buffer = this.buf.upToCursor();
                        if (this.maskingCallback != null) {
                            buffer = this.maskingCallback.display(buffer);
                        }
                        sb.append(insertSecondaryPrompts(new AttributedString(buffer), secondaryPrompts, false));
                        List<AttributedString> promptLines = sb.columnSplitLength(this.size.getColumns(), false, this.display.delayLineWrap());
                        if (!promptLines.isEmpty()) {
                            cursorNewLinesId = promptLines.size() - 1;
                            cursorColPos = promptLines.get(promptLines.size() - 1).columnLength();
                            cursorPos = this.size.cursorPos(cursorNewLinesId, cursorColPos);
                        }
                    }
                    List<AttributedString> newLinesToDisplay = new ArrayList<>();
                    int displaySize = displayRows(status);
                    if (newLines.size() <= displaySize || isTerminalDumb()) {
                        newLinesToDisplay = newLines;
                    } else {
                        StringBuilder sb2 = new StringBuilder(">....");
                        for (int i2 = sb2.toString().length(); i2 < this.size.getColumns(); i2++) {
                            sb2.append(" ");
                        }
                        AttributedString partialCommandInfo = new AttributedString(sb2.toString());
                        int lineId = (newLines.size() - displaySize) + 1;
                        int endId = displaySize;
                        int startId = 1;
                        if (lineId > cursorNewLinesId) {
                            lineId = cursorNewLinesId;
                            endId = displaySize - 1;
                            startId = 0;
                        } else {
                            newLinesToDisplay.add(partialCommandInfo);
                        }
                        int cursorRowPos = 0;
                        for (int i3 = startId; i3 < endId; i3++) {
                            if (cursorNewLinesId == lineId) {
                                cursorRowPos = i3;
                            }
                            lineId++;
                            newLinesToDisplay.add(newLines.get(lineId));
                        }
                        if (startId == 0) {
                            newLinesToDisplay.add(partialCommandInfo);
                        }
                        cursorPos = this.size.cursorPos(cursorRowPos, cursorColPos);
                    }
                    this.display.update(newLinesToDisplay, cursorPos, flush);
                    this.lock.unlock();
                    return;
                }
                AttributedStringBuilder sb3 = new AttributedStringBuilder().tabs(4);
                sb3.append(this.prompt);
                concat(getHighlightedBuffer(this.buf.toString()).columnSplitLength(Integer.MAX_VALUE), sb3);
                AttributedString full2 = sb3.toAttributedString();
                sb3.setLength(0);
                sb3.append(this.prompt);
                String line = this.buf.upToCursor();
                if (this.maskingCallback != null) {
                    line = this.maskingCallback.display(line);
                }
                concat(new AttributedString(line).columnSplitLength(Integer.MAX_VALUE), sb3);
                AttributedString toCursor = sb3.toAttributedString();
                int w = WCWidth.wcwidth(8230);
                int width = this.size.getColumns();
                int cursor = toCursor.columnLength();
                int inc = (width / 2) + 1;
                while (cursor <= this.smallTerminalOffset + w) {
                    this.smallTerminalOffset -= inc;
                }
                while (cursor >= (this.smallTerminalOffset + width) - w) {
                    this.smallTerminalOffset += inc;
                }
                if (this.smallTerminalOffset > 0) {
                    sb3.setLength(0);
                    sb3.append("…");
                    sb3.append(full2.columnSubSequence(this.smallTerminalOffset + w, Integer.MAX_VALUE));
                    full2 = sb3.toAttributedString();
                }
                if (full2.columnLength() >= this.smallTerminalOffset + width) {
                    sb3.setLength(0);
                    sb3.append(full2.columnSubSequence(0, width - w));
                    sb3.append("…");
                    full2 = sb3.toAttributedString();
                }
                this.display.update(Collections.singletonList(full2), cursor - this.smallTerminalOffset, flush);
                this.lock.unlock();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }

        private void concat(List<AttributedString> lines, AttributedStringBuilder sb) {
            if (lines.size() > 1) {
                for (int i = 0; i < lines.size() - 1; i++) {
                    sb.append(lines.get(i));
                    sb.style(sb.style().inverse());
                    sb.append("\\n");
                    sb.style(sb.style().inverseOff());
                }
            }
            sb.append(lines.get(lines.size() - 1));
        }

        private String matchPreviousCommand(String buffer) {
            if (buffer.length() == 0) {
                return "";
            }
            History history = getHistory();
            StringBuilder sb = new StringBuilder();
            char[] charArray = buffer.replace("\\", "\\\\").toCharArray();
            for (char c : charArray) {
                if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == '^' || c == '*' || c == '$' || c == '.' || c == '?' || c == '+' || c == '|' || c == '<' || c == '>' || c == '!' || c == '-') {
                    sb.append('\\');
                }
                sb.append(c);
            }
            Pattern pattern = Pattern.compile(sb.toString() + ".*", 32);
            Iterator<History.Entry> iter = history.reverseIterator(history.last());
            String suggestion = "";
            int tot = 0;
            while (true) {
                if (!iter.hasNext()) {
                    break;
                }
                History.Entry entry = iter.next();
                if (pattern.matcher(entry.line()).matches()) {
                    suggestion = entry.line().substring(buffer.length());
                    break;
                } else if (tot > 200) {
                    break;
                } else {
                    tot++;
                }
            }
            return suggestion;
        }

        public AttributedString getDisplayedBufferWithPrompts(List<AttributedString> secondaryPrompts) {
            AttributedString tNewBuf = insertSecondaryPrompts(getHighlightedBuffer(this.buf.toString()), secondaryPrompts);
            AttributedStringBuilder full = new AttributedStringBuilder().tabs(4);
            full.append(this.prompt);
            full.append(tNewBuf);
            if (this.doAutosuggestion && !isTerminalDumb()) {
                String lastBinding = getLastBinding() != null ? getLastBinding() : "";
                if (this.autosuggestion == LineReader.SuggestionType.HISTORY) {
                    AttributedStringBuilder sb = new AttributedStringBuilder();
                    this.tailTip = matchPreviousCommand(this.buf.toString());
                    sb.styled((v0) -> {
                        return v0.faint();
                    }, this.tailTip);
                    full.append(sb.toAttributedString());
                } else if (this.autosuggestion == LineReader.SuggestionType.COMPLETER) {
                    if (this.buf.length() >= getInt(LineReader.SUGGESTIONS_MIN_BUFFER_SIZE, 1) && this.buf.length() == this.buf.cursor() && (!lastBinding.equals(SyslogAppender.DEFAULT_STACKTRACE_PATTERN) || this.buf.prevChar() == 32 || this.buf.prevChar() == 61)) {
                        clearChoices();
                        listChoices(true);
                    } else if (!lastBinding.equals(SyslogAppender.DEFAULT_STACKTRACE_PATTERN)) {
                        clearChoices();
                    }
                } else if (this.autosuggestion == LineReader.SuggestionType.TAIL_TIP && this.buf.length() == this.buf.cursor()) {
                    if (!lastBinding.equals(SyslogAppender.DEFAULT_STACKTRACE_PATTERN) || this.buf.prevChar() == 32) {
                        clearChoices();
                    }
                    AttributedStringBuilder sb2 = new AttributedStringBuilder();
                    if (this.buf.prevChar() != 32) {
                        if (!this.tailTip.startsWith("[")) {
                            int idx = this.tailTip.indexOf(32);
                            int idb = this.buf.toString().lastIndexOf(32);
                            int idd = this.buf.toString().lastIndexOf(45);
                            if (idx > 0 && ((idb == -1 && idb == idd) || (idb >= 0 && idb > idd))) {
                                this.tailTip = this.tailTip.substring(idx);
                            } else if (idb >= 0 && idb < idd) {
                                sb2.append((CharSequence) " ");
                            }
                        } else {
                            sb2.append((CharSequence) " ");
                        }
                    }
                    sb2.styled((v0) -> {
                        return v0.faint();
                    }, this.tailTip);
                    full.append(sb2.toAttributedString());
                }
            }
            if (this.post != null) {
                full.append((CharSequence) "\n");
                full.append(this.post.get());
            }
            this.doAutosuggestion = true;
            return full.toAttributedString();
        }

        private AttributedString getHighlightedBuffer(String buffer) {
            if (this.maskingCallback != null) {
                buffer = this.maskingCallback.display(buffer);
            }
            if (this.highlighter == null || isSet(LineReader.Option.DISABLE_HIGHLIGHTER) || buffer.length() >= getInt(LineReader.FEATURES_MAX_BUFFER_SIZE, 1000)) {
                return new AttributedString(buffer);
            }
            return this.highlighter.highlight(this, buffer);
        }

        private AttributedString expandPromptPattern(String pattern, int padToWidth, String message, int line) {
            AttributedString astr;
            ArrayList<AttributedString> parts = new ArrayList<>();
            boolean isHidden = false;
            int padPartIndex = -1;
            StringBuilder padPartString = null;
            StringBuilder sb = new StringBuilder();
            String pattern2 = pattern + "%{";
            int plen = pattern2.length();
            int padChar = -1;
            int padPos = -1;
            int cols = 0;
            int i = 0;
            while (i < plen) {
                i++;
                char ch = pattern2.charAt(i);
                if (ch != '%' || i >= plen) {
                    sb.append(ch);
                } else {
                    int count = 0;
                    boolean countSeen = false;
                    while (true) {
                        i++;
                        char ch2 = pattern2.charAt(i);
                        switch (ch2) {
                            case '%':
                                sb.append(ch2);
                                continue;
                            case '-':
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                boolean neg = false;
                                if (ch2 == '-') {
                                    neg = true;
                                    i++;
                                    ch2 = pattern2.charAt(i);
                                }
                                countSeen = true;
                                count = 0;
                                while (ch2 >= '0' && ch2 <= '9') {
                                    count = (count < 0 ? 0 : 10 * count) + (ch2 - '0');
                                    i++;
                                    ch2 = pattern2.charAt(i);
                                }
                                if (neg) {
                                    count = -count;
                                }
                                i--;
                                break;
                            case 'M':
                                if (message != null) {
                                    sb.append(message);
                                    break;
                                } else {
                                    continue;
                                }
                            case 'N':
                                sb.append(getInt(LineReader.LINE_OFFSET, 0) + line);
                                continue;
                            case 'P':
                                if (countSeen && count >= 0) {
                                    padToWidth = count;
                                }
                                if (i < plen) {
                                    i++;
                                    padChar = pattern2.charAt(i);
                                }
                                padPos = sb.length();
                                padPartIndex = parts.size();
                                continue;
                            case '{':
                            case '}':
                                String str = sb.toString();
                                if (!isHidden) {
                                    astr = AttributedString.fromAnsi(str);
                                    cols += astr.columnLength();
                                } else {
                                    astr = new AttributedString(str, AttributedStyle.HIDDEN);
                                }
                                if (padPartIndex == parts.size()) {
                                    padPartString = sb;
                                    if (i < plen) {
                                        sb = new StringBuilder();
                                    }
                                } else {
                                    sb.setLength(0);
                                }
                                parts.add(astr);
                                isHidden = ch2 == '{';
                                continue;
                        }
                    }
                }
            }
            if (padToWidth > cols) {
                int padCount = (padToWidth - cols) / WCWidth.wcwidth(padChar);
                while (true) {
                    padCount--;
                    if (padCount >= 0) {
                        padPartString.insert(padPos, (char) padChar);
                    } else {
                        parts.set(padPartIndex, AttributedString.fromAnsi(padPartString.toString()));
                    }
                }
            }
            return AttributedString.join((AttributedString) null, parts);
        }

        private AttributedString insertSecondaryPrompts(AttributedString str, List<AttributedString> prompts) {
            return insertSecondaryPrompts(str, prompts, true);
        }

        private AttributedString insertSecondaryPrompts(AttributedString strAtt, List<AttributedString> prompts, boolean computePrompts) {
            AttributedString prompt;
            Objects.requireNonNull(prompts);
            List<AttributedString> lines = strAtt.columnSplitLength(Integer.MAX_VALUE);
            AttributedStringBuilder sb = new AttributedStringBuilder();
            String secondaryPromptPattern = getString(LineReader.SECONDARY_PROMPT_PATTERN, DEFAULT_SECONDARY_PROMPT_PATTERN);
            boolean needsMessage = secondaryPromptPattern.contains("%M") && strAtt.length() < getInt(LineReader.FEATURES_MAX_BUFFER_SIZE, 1000);
            AttributedStringBuilder buf = new AttributedStringBuilder();
            int width = 0;
            List<String> missings = new ArrayList<>();
            if (computePrompts && secondaryPromptPattern.contains("%P")) {
                width = this.prompt.columnLength();
                if (width > this.size.getColumns() || this.prompt.contains('\n')) {
                    width = new TerminalLine(this.prompt.toString(), 0, this.size.getColumns()).getEndLine().length();
                }
                for (int line = 0; line < lines.size() - 1; line++) {
                    buf.append(lines.get(line)).append((CharSequence) "\n");
                    String missing = "";
                    if (needsMessage) {
                        try {
                            this.parser.parse(buf.toString(), buf.length(), Parser.ParseContext.SECONDARY_PROMPT);
                        } catch (EOFError e) {
                            missing = e.getMissing();
                        } catch (SyntaxError e2) {
                        }
                    }
                    missings.add(missing);
                    width = Math.max(width, expandPromptPattern(secondaryPromptPattern, 0, missing, line + 1).columnLength());
                }
                buf.setLength(0);
            }
            int line2 = 0;
            while (line2 < lines.size() - 1) {
                sb.append(lines.get(line2)).append((CharSequence) "\n");
                buf.append(lines.get(line2)).append((CharSequence) "\n");
                if (computePrompts) {
                    String missing2 = "";
                    if (needsMessage) {
                        if (missings.isEmpty()) {
                            try {
                                this.parser.parse(buf.toString(), buf.length(), Parser.ParseContext.SECONDARY_PROMPT);
                            } catch (EOFError e3) {
                                missing2 = e3.getMissing();
                            } catch (SyntaxError e4) {
                            }
                        } else {
                            missing2 = missings.get(line2);
                        }
                    }
                    prompt = expandPromptPattern(secondaryPromptPattern, width, missing2, line2 + 1);
                } else {
                    prompt = prompts.get(line2);
                }
                prompts.add(prompt);
                sb.append(prompt);
                line2++;
            }
            sb.append(lines.get(line2));
            buf.append(lines.get(line2));
            return sb.toAttributedString();
        }

        private AttributedString addRightPrompt(AttributedString prompt, AttributedString line) {
            int width = prompt.columnLength();
            boolean endsWithNl = line.length() > 0 && line.charAt(line.length() - 1) == '\n';
            int nb = (this.size.getColumns() - width) - (line.columnLength() + (endsWithNl ? 1 : 0));
            if (nb >= 3) {
                AttributedStringBuilder sb = new AttributedStringBuilder(this.size.getColumns());
                sb.append(line, 0, endsWithNl ? line.length() - 1 : line.length());
                for (int j = 0; j < nb; j++) {
                    sb.append(' ');
                }
                sb.append(prompt);
                if (endsWithNl) {
                    sb.append('\n');
                }
                line = sb.toAttributedString();
            }
            return line;
        }

        protected boolean insertTab() {
            return isSet(LineReader.Option.INSERT_TAB) && getLastBinding().equals(SyslogAppender.DEFAULT_STACKTRACE_PATTERN) && this.buf.toString().matches("(^|[\\s\\S]*\n)[\r\n\t ]*");
        }

        protected boolean expandHistory() {
            String str = this.buf.toString();
            String exp = this.expander.expandHistory(this.history, str);
            if (exp.equals(str)) {
                return false;
            }
            this.buf.clear();
            this.buf.write(exp);
            return true;
        }

        protected boolean expandWord() {
            if (insertTab()) {
                return selfInsert();
            }
            return doComplete(CompletionType.Expand, isSet(LineReader.Option.MENU_COMPLETE), false);
        }

        protected boolean expandOrComplete() {
            if (insertTab()) {
                return selfInsert();
            }
            return doComplete(CompletionType.ExpandComplete, isSet(LineReader.Option.MENU_COMPLETE), false);
        }

        protected boolean expandOrCompletePrefix() {
            if (insertTab()) {
                return selfInsert();
            }
            return doComplete(CompletionType.ExpandComplete, isSet(LineReader.Option.MENU_COMPLETE), true);
        }

        protected boolean completeWord() {
            if (insertTab()) {
                return selfInsert();
            }
            return doComplete(CompletionType.Complete, isSet(LineReader.Option.MENU_COMPLETE), false);
        }

        protected boolean menuComplete() {
            if (insertTab()) {
                return selfInsert();
            }
            return doComplete(CompletionType.Complete, true, false);
        }

        protected boolean menuExpandOrComplete() {
            if (insertTab()) {
                return selfInsert();
            }
            return doComplete(CompletionType.ExpandComplete, true, false);
        }

        protected boolean completePrefix() {
            if (insertTab()) {
                return selfInsert();
            }
            return doComplete(CompletionType.Complete, isSet(LineReader.Option.MENU_COMPLETE), true);
        }

        protected boolean listChoices() {
            return listChoices(false);
        }

        private boolean listChoices(boolean forSuggestion) {
            return doComplete(CompletionType.List, isSet(LineReader.Option.MENU_COMPLETE), false, forSuggestion);
        }

        protected boolean deleteCharOrList() {
            if (this.buf.cursor() != this.buf.length() || this.buf.length() == 0) {
                return deleteChar();
            }
            return doComplete(CompletionType.List, isSet(LineReader.Option.MENU_COMPLETE), false);
        }

        protected boolean doComplete(CompletionType lst, boolean useMenu, boolean prefix) {
            return doComplete(lst, useMenu, prefix, false);
        }

        protected boolean doComplete(CompletionType lst, boolean useMenu, boolean prefix, boolean forSuggestion) {
            String current;
            if (getBoolean(LineReader.DISABLE_COMPLETION, false)) {
                return true;
            }
            if (!isSet(LineReader.Option.DISABLE_EVENT_EXPANSION)) {
                try {
                    if (expandHistory()) {
                        return true;
                    }
                } catch (Exception e) {
                    Log.info("Error while expanding history", e);
                    return false;
                }
            }
            try {
                CompletingParsedLine line = wrap(this.parser.parse(this.buf.toString(), this.buf.cursor(), Parser.ParseContext.COMPLETE));
                List<Candidate> candidates = new ArrayList<>();
                try {
                    if (this.completer != null) {
                        this.completer.complete(this, line, candidates);
                    }
                    if (lst == CompletionType.ExpandComplete || lst == CompletionType.Expand) {
                        String w = this.expander.expandVar(line.word());
                        if (!line.word().equals(w)) {
                            if (prefix) {
                                this.buf.backspace(line.wordCursor());
                            } else {
                                this.buf.move(line.word().length() - line.wordCursor());
                                this.buf.backspace(line.word().length());
                            }
                            this.buf.write(w);
                            return true;
                        } else if (lst == CompletionType.Expand) {
                            return false;
                        } else {
                            lst = CompletionType.Complete;
                        }
                    }
                    this.completionMatcher.compile(this.options, prefix, line, isSet(LineReader.Option.CASE_INSENSITIVE), getInt(LineReader.ERRORS, 2), getOriginalGroupName());
                    List<Candidate> possible = this.completionMatcher.matches(candidates);
                    if (possible.isEmpty()) {
                        return false;
                    }
                    this.size.copy(this.terminal.getSize());
                    try {
                        if (lst == CompletionType.List) {
                            String word = line.word();
                            Objects.requireNonNull(line);
                            doList(possible, word, false, (v1, v2) -> {
                                return r4.escape(v1, v2);
                            }, forSuggestion);
                            return !possible.isEmpty();
                        }
                        Candidate completion = null;
                        if (possible.size() == 1) {
                            completion = possible.get(0);
                        } else if (isSet(LineReader.Option.RECOGNIZE_EXACT)) {
                            completion = this.completionMatcher.exactMatch();
                        }
                        if (completion != null && !completion.value().isEmpty()) {
                            if (prefix) {
                                this.buf.backspace(line.rawWordCursor());
                            } else {
                                this.buf.move(line.rawWordLength() - line.rawWordCursor());
                                this.buf.backspace(line.rawWordLength());
                            }
                            this.buf.write(line.escape(completion.value(), completion.complete()));
                            if (completion.complete()) {
                                if (this.buf.currChar() != 32) {
                                    this.buf.write(" ");
                                } else {
                                    this.buf.move(1);
                                }
                            }
                            if (completion.suffix() != null) {
                                if (this.autosuggestion == LineReader.SuggestionType.COMPLETER) {
                                    listChoices(true);
                                }
                                redisplay();
                                Binding op = readBinding(getKeys());
                                if (op != null) {
                                    String chars = getString(LineReader.REMOVE_SUFFIX_CHARS, DEFAULT_REMOVE_SUFFIX_CHARS);
                                    String ref = op instanceof Reference ? ((Reference) op).name() : null;
                                    if ((LineReader.SELF_INSERT.equals(ref) && chars.indexOf(getLastBinding().charAt(0)) >= 0) || LineReader.ACCEPT_LINE.equals(ref)) {
                                        this.buf.backspace(completion.suffix().length());
                                        if (getLastBinding().charAt(0) != ' ') {
                                            this.buf.write(32);
                                        }
                                    }
                                    pushBackBinding(true);
                                }
                            }
                            this.size.copy(this.terminal.getBufferSize());
                            return true;
                        } else if (useMenu) {
                            this.buf.move(line.word().length() - line.wordCursor());
                            this.buf.backspace(line.word().length());
                            String word2 = line.word();
                            Objects.requireNonNull(line);
                            doMenu(possible, word2, (v1, v2) -> {
                                return r3.escape(v1, v2);
                            });
                            this.size.copy(this.terminal.getBufferSize());
                            return true;
                        } else {
                            if (prefix) {
                                current = line.word().substring(0, line.wordCursor());
                            } else {
                                current = line.word();
                                this.buf.move(line.rawWordLength() - line.rawWordCursor());
                            }
                            String commonPrefix = this.completionMatcher.getCommonPrefix();
                            if (commonPrefix.startsWith(current) && !commonPrefix.equals(current)) {
                                this.buf.backspace(line.rawWordLength());
                                this.buf.write(line.escape(commonPrefix, false));
                                callWidget(LineReader.REDISPLAY);
                                current = commonPrefix;
                                if (((!isSet(LineReader.Option.AUTO_LIST) && isSet(LineReader.Option.AUTO_MENU)) || (isSet(LineReader.Option.AUTO_LIST) && isSet(LineReader.Option.LIST_AMBIGUOUS))) && !nextBindingIsComplete()) {
                                    this.size.copy(this.terminal.getBufferSize());
                                    return true;
                                }
                            }
                            if (isSet(LineReader.Option.AUTO_LIST)) {
                                Objects.requireNonNull(line);
                                if (!doList(possible, current, true, (v1, v2) -> {
                                    return r4.escape(v1, v2);
                                })) {
                                    this.size.copy(this.terminal.getBufferSize());
                                    return true;
                                }
                            }
                            if (isSet(LineReader.Option.AUTO_MENU)) {
                                this.buf.backspace(current.length());
                                String word3 = line.word();
                                Objects.requireNonNull(line);
                                doMenu(possible, word3, (v1, v2) -> {
                                    return r3.escape(v1, v2);
                                });
                            }
                            this.size.copy(this.terminal.getBufferSize());
                            return true;
                        }
                    } finally {
                        this.size.copy(this.terminal.getBufferSize());
                    }
                } catch (Exception e2) {
                    Log.info("Error while finding completion candidates", e2);
                    if (!Log.isDebugEnabled()) {
                        return false;
                    }
                    e2.printStackTrace();
                    return false;
                }
            } catch (Exception e3) {
                Log.info("Error while parsing line", e3);
                return false;
            }
        }

        protected static CompletingParsedLine wrap(final ParsedLine line) {
            if (line instanceof CompletingParsedLine) {
                return (CompletingParsedLine) line;
            }
            return new CompletingParsedLine() { // from class: org.jline.reader.impl.LineReaderImpl.2
                @Override // org.jline.reader.ParsedLine
                public String word() {
                    return ParsedLine.this.word();
                }

                @Override // org.jline.reader.ParsedLine
                public int wordCursor() {
                    return ParsedLine.this.wordCursor();
                }

                @Override // org.jline.reader.ParsedLine
                public int wordIndex() {
                    return ParsedLine.this.wordIndex();
                }

                @Override // org.jline.reader.ParsedLine
                public List<String> words() {
                    return ParsedLine.this.words();
                }

                @Override // org.jline.reader.ParsedLine
                public String line() {
                    return ParsedLine.this.line();
                }

                @Override // org.jline.reader.ParsedLine
                public int cursor() {
                    return ParsedLine.this.cursor();
                }

                @Override // org.jline.reader.CompletingParsedLine
                public CharSequence escape(CharSequence candidate, boolean complete) {
                    return candidate;
                }

                @Override // org.jline.reader.CompletingParsedLine
                public int rawWordCursor() {
                    return wordCursor();
                }

                @Override // org.jline.reader.CompletingParsedLine
                public int rawWordLength() {
                    return word().length();
                }
            };
        }

        protected Comparator<Candidate> getCandidateComparator(boolean caseInsensitive, String word) {
            String wdi = caseInsensitive ? word.toLowerCase() : word;
            return Comparator.comparing((v0) -> {
                return v0.value();
            }, Comparator.comparingInt(w -> {
                return ReaderUtils.distance(wdi, caseInsensitive ? w.toLowerCase() : w);
            })).thenComparing(Comparator.naturalOrder());
        }

        protected String getOthersGroupName() {
            return getString(LineReader.OTHERS_GROUP_NAME, DEFAULT_OTHERS_GROUP_NAME);
        }

        protected String getOriginalGroupName() {
            return getString(LineReader.ORIGINAL_GROUP_NAME, DEFAULT_ORIGINAL_GROUP_NAME);
        }

        protected Comparator<String> getGroupComparator() {
            return Comparator.comparingInt(s -> {
                if (getOthersGroupName().equals(s)) {
                    return 1;
                }
                return getOriginalGroupName().equals(s) ? -1 : 0;
            }).thenComparing((v0) -> {
                return v0.toLowerCase();
            }, Comparator.naturalOrder());
        }

        private void mergeCandidates(List<Candidate> possible) {
            Map<String, List<Candidate>> keyedCandidates = new HashMap<>();
            for (Candidate candidate : possible) {
                if (candidate.key() != null) {
                    keyedCandidates.computeIfAbsent(candidate.key(), s -> {
                        return new ArrayList();
                    }).add(candidate);
                }
            }
            if (!keyedCandidates.isEmpty()) {
                for (List<Candidate> candidates : keyedCandidates.values()) {
                    if (candidates.size() >= 1) {
                        possible.removeAll(candidates);
                        candidates.sort(Comparator.comparing((v0) -> {
                            return v0.value();
                        }));
                        Candidate first = candidates.get(0);
                        possible.add(new Candidate(first.value(), (String) candidates.stream().map((v0) -> {
                            return v0.displ();
                        }).collect(Collectors.joining(" ")), first.group(), first.descr(), first.suffix(), null, first.complete()));
                    }
                }
            }
        }

        protected boolean nextBindingIsComplete() {
            redisplay();
            Binding operation = readBinding(getKeys(), this.keyMaps.get(LineReader.MENU));
            if ((operation instanceof Reference) && LineReader.MENU_COMPLETE.equals(((Reference) operation).name())) {
                return true;
            }
            pushBackBinding();
            return false;
        }

        /* access modifiers changed from: private */
        public int displayRows() {
            return displayRows(Status.getStatus(this.terminal, false));
        }

        private int displayRows(Status status) {
            return this.size.getRows() - (status != null ? status.size() : 0);
        }

        /* access modifiers changed from: private */
        public int promptLines() {
            return insertSecondaryPrompts(AttributedStringBuilder.append(this.prompt, this.buf.toString()), new ArrayList()).columnSplitLength(this.size.getColumns(), false, this.display.delayLineWrap()).size();
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$MenuSupport.class */
        public class MenuSupport implements Supplier<AttributedString> {
            final BiFunction<CharSequence, Boolean, CharSequence> escaper;
            AttributedString computed;
            int lines;
            int columns;
            String completed;
            final List<Candidate> possible = new ArrayList();
            int selection = -1;
            int topLine = 0;
            String word = "";

            public MenuSupport(List<Candidate> original, String completed, BiFunction<CharSequence, Boolean, CharSequence> escaper) {
                this.escaper = escaper;
                this.completed = completed;
                LineReaderImpl.this.computePost(original, null, this.possible, completed);
                next();
            }

            public Candidate completion() {
                return this.possible.get(this.selection);
            }

            public void next() {
                this.selection = (this.selection + 1) % this.possible.size();
                update();
            }

            public void previous() {
                this.selection = ((this.selection + this.possible.size()) - 1) % this.possible.size();
                update();
            }

            private void major(int step) {
                int axis = LineReaderImpl.this.isSet(LineReader.Option.LIST_ROWS_FIRST) ? this.columns : this.lines;
                int sel = this.selection + (step * axis);
                if (sel < 0) {
                    sel = (this.possible.size() - (this.possible.size() % axis)) + ((sel + axis) % axis);
                    if (sel >= this.possible.size()) {
                        sel -= axis;
                    }
                } else if (sel >= this.possible.size()) {
                    sel %= axis;
                }
                this.selection = sel;
                update();
            }

            private void minor(int step) {
                int axis = LineReaderImpl.this.isSet(LineReader.Option.LIST_ROWS_FIRST) ? this.columns : this.lines;
                int row = this.selection % axis;
                int options = this.possible.size();
                if ((this.selection - row) + axis > options) {
                    axis = options % axis;
                }
                this.selection = (this.selection - row) + (((axis + row) + step) % axis);
                update();
            }

            /* renamed from: up */
            public void m26up() {
                if (LineReaderImpl.this.isSet(LineReader.Option.LIST_ROWS_FIRST)) {
                    major(-1);
                } else {
                    minor(-1);
                }
            }

            public void down() {
                if (LineReaderImpl.this.isSet(LineReader.Option.LIST_ROWS_FIRST)) {
                    major(1);
                } else {
                    minor(1);
                }
            }

            public void left() {
                if (LineReaderImpl.this.isSet(LineReader.Option.LIST_ROWS_FIRST)) {
                    minor(-1);
                } else {
                    major(-1);
                }
            }

            public void right() {
                if (LineReaderImpl.this.isSet(LineReader.Option.LIST_ROWS_FIRST)) {
                    minor(1);
                } else {
                    major(1);
                }
            }

            private void update() {
                LineReaderImpl.this.buf.backspace(this.word.length());
                this.word = this.escaper.apply(completion().value(), true).toString();
                LineReaderImpl.this.buf.write(this.word);
                PostResult pr = LineReaderImpl.this.computePost(this.possible, completion(), null, this.completed);
                int displaySize = LineReaderImpl.this.displayRows() - LineReaderImpl.this.promptLines();
                if (pr.lines > displaySize) {
                    int displayed = displaySize - 1;
                    if (pr.selectedLine >= 0) {
                        if (pr.selectedLine < this.topLine) {
                            this.topLine = pr.selectedLine;
                        } else if (pr.selectedLine >= this.topLine + displayed) {
                            this.topLine = (pr.selectedLine - displayed) + 1;
                        }
                    }
                    AttributedString post = pr.post;
                    if (post.length() > 0 && post.charAt(post.length() - 1) != '\n') {
                        post = new AttributedStringBuilder(post.length() + 1).append(post).append((CharSequence) "\n").toAttributedString();
                    }
                    List<AttributedString> lines = post.columnSplitLength(LineReaderImpl.this.size.getColumns(), true, LineReaderImpl.this.display.delayLineWrap());
                    List<AttributedString> sub = new ArrayList<>(lines.subList(this.topLine, this.topLine + displayed));
                    sub.add(new AttributedStringBuilder().style(AttributedStyle.DEFAULT.foreground(6)).append((CharSequence) "rows ").append((CharSequence) Integer.toString(this.topLine + 1)).append((CharSequence) " to ").append((CharSequence) Integer.toString(this.topLine + displayed)).append((CharSequence) " of ").append((CharSequence) Integer.toString(lines.size())).append((CharSequence) "\n").style(AttributedStyle.DEFAULT).toAttributedString());
                    this.computed = AttributedString.join(AttributedString.EMPTY, sub);
                } else {
                    this.computed = pr.post;
                }
                this.lines = pr.lines;
                this.columns = ((this.possible.size() + this.lines) - 1) / this.lines;
            }

            @Override // java.util.function.Supplier
            public AttributedString get() {
                return this.computed;
            }
        }

        protected boolean doMenu(List<Candidate> original, String completed, BiFunction<CharSequence, Boolean, CharSequence> escaper) {
            List<Candidate> possible = new ArrayList<>();
            original.sort(getCandidateComparator(isSet(LineReader.Option.CASE_INSENSITIVE), completed));
            mergeCandidates(original);
            computePost(original, null, possible, completed);
            boolean defaultAutoGroup = isSet(LineReader.Option.AUTO_GROUP);
            boolean defaultGroup = isSet(LineReader.Option.GROUP);
            if (!isSet(LineReader.Option.GROUP_PERSIST)) {
                option(LineReader.Option.AUTO_GROUP, false);
                option(LineReader.Option.GROUP, false);
            }
            MenuSupport menuSupport = new MenuSupport(original, completed, escaper);
            this.post = menuSupport;
            callWidget(LineReader.REDISPLAY);
            KeyMap<Binding> keyMap = this.keyMaps.get(LineReader.MENU);
            while (true) {
                Binding operation = readBinding(getKeys(), keyMap);
                if (operation != null) {
                    String ref = operation instanceof Reference ? ((Reference) operation).name() : "";
                    char c = 65535;
                    switch (ref.hashCode()) {
                        case -2043638076:
                            if (ref.equals(LineReader.DOWN_LINE_OR_SEARCH)) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1313197076:
                            if (ref.equals(LineReader.CLEAR_SCREEN)) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -473347524:
                            if (ref.equals(LineReader.REVERSE_MENU_COMPLETE)) {
                                c = 1;
                                break;
                            }
                            break;
                        case -325380770:
                            if (ref.equals(LineReader.FORWARD_CHAR)) {
                                c = 6;
                                break;
                            }
                            break;
                        case 30334712:
                            if (ref.equals(LineReader.DOWN_LINE_OR_HISTORY)) {
                                c = 4;
                                break;
                            }
                            break;
                        case 372331435:
                            if (ref.equals(LineReader.UP_LINE_OR_SEARCH)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 587348455:
                            if (ref.equals(LineReader.MENU_COMPLETE)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1804656384:
                            if (ref.equals(LineReader.BACKWARD_CHAR)) {
                                c = 7;
                                break;
                            }
                            break;
                        case 1910945521:
                            if (ref.equals(LineReader.UP_LINE_OR_HISTORY)) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            menuSupport.next();
                            break;
                        case 1:
                            menuSupport.previous();
                            break;
                        case 2:
                        case 3:
                            menuSupport.m26up();
                            break;
                        case 4:
                        case 5:
                            menuSupport.down();
                            break;
                        case 6:
                            menuSupport.right();
                            break;
                        case 7:
                            menuSupport.left();
                            break;
                        case '\b':
                            clearScreen();
                            break;
                        default:
                            Candidate completion = menuSupport.completion();
                            if (completion.suffix() != null) {
                                String chars = getString(LineReader.REMOVE_SUFFIX_CHARS, DEFAULT_REMOVE_SUFFIX_CHARS);
                                if ((LineReader.SELF_INSERT.equals(ref) && chars.indexOf(getLastBinding().charAt(0)) >= 0) || LineReader.BACKWARD_DELETE_CHAR.equals(ref)) {
                                    this.buf.backspace(completion.suffix().length());
                                }
                            }
                            if (completion.complete() && getLastBinding().charAt(0) != ' ' && (LineReader.SELF_INSERT.equals(ref) || getLastBinding().charAt(0) != ' ')) {
                                this.buf.write(32);
                            }
                            if (!LineReader.ACCEPT_LINE.equals(ref) && (!LineReader.SELF_INSERT.equals(ref) || completion.suffix() == null || !completion.suffix().startsWith(getLastBinding()))) {
                                pushBackBinding(true);
                            }
                            this.post = null;
                            option(LineReader.Option.AUTO_GROUP, defaultAutoGroup);
                            option(LineReader.Option.GROUP, defaultGroup);
                            return true;
                    }
                    this.doAutosuggestion = false;
                    callWidget(LineReader.REDISPLAY);
                } else {
                    option(LineReader.Option.AUTO_GROUP, defaultAutoGroup);
                    option(LineReader.Option.GROUP, defaultGroup);
                    return false;
                }
            }
        }

        protected boolean clearChoices() {
            return doList(new ArrayList(), "", false, null, false);
        }

        protected boolean doList(List<Candidate> possible, String completed, boolean runLoop, BiFunction<CharSequence, Boolean, CharSequence> escaper) {
            return doList(possible, completed, runLoop, escaper, false);
        }

        protected boolean doList(List<Candidate> possible, String completed, boolean runLoop, BiFunction<CharSequence, Boolean, CharSequence> escaper, boolean forSuggestion) {
            List<Candidate> cands;
            mergeCandidates(possible);
            int promptLines = insertSecondaryPrompts(AttributedStringBuilder.append(this.prompt, this.buf.toString()), new ArrayList()).columnSplitLength(this.size.getColumns(), false, this.display.delayLineWrap()).size();
            int lines = computePost(possible, null, null, completed).lines;
            int listMax = getInt(LineReader.LIST_MAX, 100);
            if ((listMax > 0 && possible.size() >= listMax) || lines >= this.size.getRows() - promptLines) {
                if (forSuggestion) {
                    return false;
                }
                this.post = ()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0091: IPUT  
                      (wrap: java.util.function.Supplier<org.jline.utils.AttributedString> : 0x008c: INVOKE_CUSTOM (r1v56 java.util.function.Supplier<org.jline.utils.AttributedString> A[REMOVE]) = 
                      (r8v0 'this' org.jline.reader.impl.LineReaderImpl A[D('this' org.jline.reader.impl.LineReaderImpl), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r9v0 'possible' java.util.List<org.jline.reader.Candidate> A[D('possible' java.util.List<org.jline.reader.Candidate>), DONT_INLINE])
                      (r0v9 'lines' int A[D('lines' int), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.util.function.Supplier.get():java.lang.Object
                     call insn: ?: INVOKE  (r1 I:org.jline.reader.impl.LineReaderImpl), (r2 I:java.util.List), (r3 I:int) type: DIRECT call: org.jline.reader.impl.LineReaderImpl.lambda$doList$18(java.util.List, int):org.jline.utils.AttributedString)
                      (r8v0 'this' org.jline.reader.impl.LineReaderImpl A[D('this' org.jline.reader.impl.LineReaderImpl), IMMUTABLE_TYPE, THIS])
                     org.jline.reader.impl.LineReaderImpl.post java.util.function.Supplier in method: org.jline.reader.impl.LineReaderImpl.doList(java.util.List<org.jline.reader.Candidate>, java.lang.String, boolean, java.util.function.BiFunction<java.lang.CharSequence, java.lang.Boolean, java.lang.CharSequence>, boolean):boolean, file: grasscutter.jar:org/jline/reader/impl/LineReaderImpl.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                    	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:462)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 25 more
                    */
                /*
                // Method dump skipped, instructions count: 671
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jline.reader.impl.LineReaderImpl.doList(java.util.List, java.lang.String, boolean, java.util.function.BiFunction, boolean):boolean");
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$CompletingWord.class */
            public static class CompletingWord implements CompletingParsedLine {
                private final String word;

                public CompletingWord(String word) {
                    this.word = word;
                }

                @Override // org.jline.reader.CompletingParsedLine
                public CharSequence escape(CharSequence candidate, boolean complete) {
                    return null;
                }

                @Override // org.jline.reader.CompletingParsedLine
                public int rawWordCursor() {
                    return this.word.length();
                }

                @Override // org.jline.reader.CompletingParsedLine
                public int rawWordLength() {
                    return this.word.length();
                }

                @Override // org.jline.reader.ParsedLine
                public String word() {
                    return this.word;
                }

                @Override // org.jline.reader.ParsedLine
                public int wordCursor() {
                    return this.word.length();
                }

                @Override // org.jline.reader.ParsedLine
                public int wordIndex() {
                    return 0;
                }

                @Override // org.jline.reader.ParsedLine
                public List<String> words() {
                    return null;
                }

                @Override // org.jline.reader.ParsedLine
                public String line() {
                    return this.word;
                }

                @Override // org.jline.reader.ParsedLine
                public int cursor() {
                    return this.word.length();
                }
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$PostResult.class */
            public static class PostResult {
                final AttributedString post;
                final int lines;
                final int selectedLine;

                public PostResult(AttributedString post, int lines, int selectedLine) {
                    this.post = post;
                    this.lines = lines;
                    this.selectedLine = selectedLine;
                }
            }

            protected PostResult computePost(List<Candidate> possible, Candidate selection, List<Candidate> ordered, String completed) {
                Display display = this.display;
                Objects.requireNonNull(display);
                return computePost(possible, selection, ordered, completed, this::wcwidth, this.size.getColumns(), isSet(LineReader.Option.AUTO_GROUP), isSet(LineReader.Option.GROUP), isSet(LineReader.Option.LIST_ROWS_FIRST));
            }

            protected PostResult computePost(List<Candidate> possible, Candidate selection, List<Candidate> ordered, String completed, Function<String, Integer> wcwidth, int width, boolean autoGroup, boolean groupName, boolean rowsFirst) {
                Map<String, Map<String, Candidate>> sorted;
                List<Object> strings = new ArrayList<>();
                if (groupName) {
                    Comparator<String> groupComparator = getGroupComparator();
                    if (groupComparator != null) {
                        sorted = new TreeMap<>(groupComparator);
                    } else {
                        sorted = new LinkedHashMap<>();
                    }
                    for (Candidate cand : possible) {
                        String group = cand.group();
                        sorted.computeIfAbsent(group != null ? group : "", s -> {
                            return new LinkedHashMap();
                        }).put(cand.value(), cand);
                    }
                    for (Map.Entry<String, Map<String, Candidate>> entry : sorted.entrySet()) {
                        String group2 = entry.getKey();
                        if (group2.isEmpty() && sorted.size() > 1) {
                            group2 = getOthersGroupName();
                        }
                        if (!group2.isEmpty() && autoGroup) {
                            strings.add(group2);
                        }
                        strings.add(new ArrayList(entry.getValue().values()));
                        if (ordered != null) {
                            ordered.addAll(entry.getValue().values());
                        }
                    }
                } else {
                    Set<String> groups = new LinkedHashSet<>();
                    TreeMap<String, Candidate> sorted2 = new TreeMap<>();
                    for (Candidate cand2 : possible) {
                        String group3 = cand2.group();
                        if (group3 != null) {
                            groups.add(group3);
                        }
                        sorted2.put(cand2.value(), cand2);
                    }
                    if (autoGroup) {
                        strings.addAll(groups);
                    }
                    strings.add(new ArrayList(sorted2.values()));
                    if (ordered != null) {
                        ordered.addAll(sorted2.values());
                    }
                }
                return toColumns(strings, selection, completed, wcwidth, width, rowsFirst);
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:org/jline/reader/impl/LineReaderImpl$TerminalLine.class */
            public static class TerminalLine {
                private String endLine;
                private int startPos;

                public TerminalLine(String line, int startPos, int width) {
                    this.startPos = startPos;
                    this.endLine = line.substring(line.lastIndexOf(10) + 1);
                    boolean first = true;
                    while (true) {
                        if (this.endLine.length() + (first ? startPos : 0) <= width) {
                            break;
                        }
                        if (first) {
                            this.endLine = this.endLine.substring(width - startPos);
                        } else {
                            this.endLine = this.endLine.substring(width);
                        }
                        first = false;
                    }
                    if (!first) {
                        this.startPos = 0;
                    }
                }

                public int getStartPos() {
                    return this.startPos;
                }

                public String getEndLine() {
                    return this.endLine;
                }
            }

            private int candidateStartPosition(List<Candidate> cands) {
                List<String> values = (List) cands.stream().map(c -> {
                    return AttributedString.stripAnsi(c.displ());
                }).filter(c -> {
                    return !c.matches("\\w+") && c.length() > 1;
                }).collect(Collectors.toList());
                Set<String> notDelimiters = new HashSet<>();
                values.forEach(v -> {
                    v.substring(0, v.length() - 1).chars().filter(c -> {
                        return !Character.isDigit(c) && !Character.isAlphabetic(c);
                    }).forEach(c -> {
                        notDelimiters.add(Character.toString((char) c));
                    });
                });
                int width = this.size.getColumns();
                int promptLength = this.prompt != null ? this.prompt.length() : 0;
                if (promptLength > 0) {
                    promptLength = new TerminalLine(this.prompt.toString(), 0, width).getEndLine().length();
                }
                TerminalLine tl = new TerminalLine(this.buf.substring(0, this.buf.cursor()), promptLength, width);
                int out = tl.getStartPos();
                String buffer = tl.getEndLine();
                int i = buffer.length();
                while (true) {
                    if (i > 0) {
                        if (buffer.substring(0, i).matches(".*\\W") && !notDelimiters.contains(buffer.substring(i - 1, i))) {
                            out += i;
                            break;
                        }
                        i--;
                    } else {
                        break;
                    }
                }
                return out;
            }

            protected PostResult toColumns(List<Object> items, Candidate selection, String completed, Function<String, Integer> wcwidth, int width, boolean rowsFirst) {
                int[] out = new int[2];
                int maxWidth = 0;
                int listSize = 0;
                for (Object item : items) {
                    if (item instanceof String) {
                        maxWidth = Math.max(maxWidth, wcwidth.apply((String) item).intValue());
                    } else if (item instanceof List) {
                        for (Candidate cand : (List) item) {
                            listSize++;
                            int len = wcwidth.apply(cand.displ()).intValue();
                            if (cand.descr() != null) {
                                len = len + 1 + DESC_PREFIX.length() + wcwidth.apply(cand.descr()).intValue() + DESC_SUFFIX.length();
                            }
                            maxWidth = Math.max(maxWidth, len);
                        }
                    }
                }
                AttributedStringBuilder sb = new AttributedStringBuilder();
                if (listSize > 0) {
                    if (!isSet(LineReader.Option.AUTO_MENU_LIST) || listSize >= Math.min(getInt(LineReader.MENU_LIST_MAX, Integer.MAX_VALUE), displayRows() - promptLines())) {
                        for (Object list : items) {
                            toColumns(list, width, maxWidth, sb, selection, completed, rowsFirst, false, out);
                        }
                    } else {
                        int maxWidth2 = Math.max(maxWidth, 25);
                        sb.tabs(Math.max(Math.min(this.candidateStartPosition, (width - maxWidth2) - 1), 1));
                        int width2 = maxWidth2 + 2;
                        if (!isSet(LineReader.Option.GROUP_PERSIST)) {
                            List<Candidate> list2 = new ArrayList<>();
                            for (Object o : items) {
                                if (o instanceof Collection) {
                                    list2.addAll((Collection) o);
                                }
                            }
                            toColumns((List) list2.stream().sorted(getCandidateComparator(isSet(LineReader.Option.CASE_INSENSITIVE), "")).collect(Collectors.toList()), width2, maxWidth2, sb, selection, completed, rowsFirst, true, out);
                        } else {
                            for (Object list3 : items) {
                                toColumns(list3, width2, maxWidth2, sb, selection, completed, rowsFirst, true, out);
                            }
                        }
                    }
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
                    sb.setLength(sb.length() - 1);
                }
                return new PostResult(sb.toAttributedString(), out[0], out[1]);
            }

            protected void toColumns(Object items, int width, int maxWidth, AttributedStringBuilder sb, Candidate selection, String completed, boolean rowsFirst, boolean doMenuList, int[] out) {
                IntBinaryOperator index;
                if (maxWidth > 0 && width > 0) {
                    if (items instanceof String) {
                        if (doMenuList) {
                            sb.style(AttributedStyle.DEFAULT);
                            sb.append('\t');
                        }
                        AttributedStringBuilder asb = new AttributedStringBuilder();
                        asb.style(getCompletionStyleGroup(doMenuList)).append((CharSequence) ((String) items)).style(AttributedStyle.DEFAULT);
                        if (doMenuList) {
                            for (int k = ((String) items).length(); k < maxWidth + 1; k++) {
                                asb.append(' ');
                            }
                        }
                        sb.style(getCompletionStyleBackground(doMenuList));
                        sb.append((AttributedCharSequence) asb);
                        sb.append("\n");
                        out[0] = out[0] + 1;
                    } else if (items instanceof List) {
                        List<Candidate> candidates = (List) items;
                        int maxWidth2 = Math.min(width, maxWidth);
                        int c = width / maxWidth2;
                        while (c > 1 && (c * maxWidth2) + ((c - 1) * 3) >= width) {
                            c--;
                        }
                        int lines = ((candidates.size() + c) - 1) / c;
                        int columns = ((candidates.size() + lines) - 1) / lines;
                        if (rowsFirst) {
                            index = i, j -> {
                                return (i * columns) + j;
                            };
                        } else {
                            index = i, j -> {
                                return (j * lines) + i;
                            };
                        }
                        for (int i = 0; i < lines; i++) {
                            if (doMenuList) {
                                sb.style(AttributedStyle.DEFAULT);
                                sb.append('\t');
                            }
                            AttributedStringBuilder asb2 = new AttributedStringBuilder();
                            int j = 0;
                            while (j < columns) {
                                int idx = index.applyAsInt(i, j);
                                if (idx < candidates.size()) {
                                    Candidate cand = candidates.get(idx);
                                    boolean hasRightItem = j < columns - 1 && index.applyAsInt(i, j + 1) < candidates.size();
                                    AttributedString left = AttributedString.fromAnsi(cand.displ());
                                    AttributedString right = AttributedString.fromAnsi(cand.descr());
                                    int lw = left.columnLength();
                                    int rw = 0;
                                    if (right != null) {
                                        int rem = maxWidth2 - (((lw + 1) + DESC_PREFIX.length()) + DESC_SUFFIX.length());
                                        int rw2 = right.columnLength();
                                        if (rw2 > rem) {
                                            right = AttributedStringBuilder.append(right.columnSubSequence(0, rem - WCWidth.wcwidth(8230)), "…");
                                            rw2 = right.columnLength();
                                        }
                                        right = AttributedStringBuilder.append(DESC_PREFIX, right, DESC_SUFFIX);
                                        rw = rw2 + DESC_PREFIX.length() + DESC_SUFFIX.length();
                                    }
                                    if (cand == selection) {
                                        out[1] = i;
                                        asb2.style(getCompletionStyleSelection(doMenuList));
                                        if (left.toString().regionMatches(isSet(LineReader.Option.CASE_INSENSITIVE), 0, completed, 0, completed.length())) {
                                            asb2.append((CharSequence) left.toString(), 0, completed.length());
                                            asb2.append((CharSequence) left.toString(), completed.length(), left.length());
                                        } else {
                                            asb2.append((CharSequence) left.toString());
                                        }
                                        for (int k2 = 0; k2 < (maxWidth2 - lw) - rw; k2++) {
                                            asb2.append(' ');
                                        }
                                        if (right != null) {
                                            asb2.append(right);
                                        }
                                        asb2.style(AttributedStyle.DEFAULT);
                                    } else {
                                        if (left.toString().regionMatches(isSet(LineReader.Option.CASE_INSENSITIVE), 0, completed, 0, completed.length())) {
                                            asb2.style(getCompletionStyleStarting(doMenuList));
                                            asb2.append(left, 0, completed.length());
                                            asb2.style(AttributedStyle.DEFAULT);
                                            asb2.append(left, completed.length(), left.length());
                                        } else {
                                            asb2.append(left);
                                        }
                                        if (right != null || hasRightItem) {
                                            for (int k3 = 0; k3 < (maxWidth2 - lw) - rw; k3++) {
                                                asb2.append(' ');
                                            }
                                        }
                                        if (right != null) {
                                            asb2.style(getCompletionStyleDescription(doMenuList));
                                            asb2.append(right);
                                            asb2.style(AttributedStyle.DEFAULT);
                                        } else if (doMenuList) {
                                            for (int k4 = lw; k4 < maxWidth2; k4++) {
                                                asb2.append(' ');
                                            }
                                        }
                                    }
                                    if (hasRightItem) {
                                        for (int k5 = 0; k5 < 3; k5++) {
                                            asb2.append(' ');
                                        }
                                    }
                                    if (doMenuList) {
                                        asb2.append(' ');
                                    }
                                }
                                j++;
                            }
                            sb.style(getCompletionStyleBackground(doMenuList));
                            sb.append((AttributedCharSequence) asb2);
                            sb.append('\n');
                        }
                        out[0] = out[0] + lines;
                    }
                }
            }

            protected AttributedStyle getCompletionStyleStarting(boolean menuList) {
                return menuList ? getCompletionStyleListStarting() : getCompletionStyleStarting();
            }

            protected AttributedStyle getCompletionStyleDescription(boolean menuList) {
                return menuList ? getCompletionStyleListDescription() : getCompletionStyleDescription();
            }

            protected AttributedStyle getCompletionStyleGroup(boolean menuList) {
                return menuList ? getCompletionStyleListGroup() : getCompletionStyleGroup();
            }

            protected AttributedStyle getCompletionStyleSelection(boolean menuList) {
                return menuList ? getCompletionStyleListSelection() : getCompletionStyleSelection();
            }

            protected AttributedStyle getCompletionStyleBackground(boolean menuList) {
                return menuList ? getCompletionStyleListBackground() : getCompletionStyleBackground();
            }

            protected AttributedStyle getCompletionStyleStarting() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_STARTING, "fg:cyan");
            }

            protected AttributedStyle getCompletionStyleDescription() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_DESCRIPTION, "fg:bright-black");
            }

            protected AttributedStyle getCompletionStyleGroup() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_GROUP, DEFAULT_COMPLETION_STYLE_GROUP);
            }

            protected AttributedStyle getCompletionStyleSelection() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_SELECTION, "inverse");
            }

            protected AttributedStyle getCompletionStyleBackground() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_BACKGROUND, DEFAULT_COMPLETION_STYLE_BACKGROUND);
            }

            protected AttributedStyle getCompletionStyleListStarting() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_LIST_STARTING, "fg:cyan");
            }

            protected AttributedStyle getCompletionStyleListDescription() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_LIST_DESCRIPTION, "fg:bright-black");
            }

            protected AttributedStyle getCompletionStyleListGroup() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_LIST_GROUP, DEFAULT_COMPLETION_STYLE_LIST_GROUP);
            }

            protected AttributedStyle getCompletionStyleListSelection() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_LIST_SELECTION, "inverse");
            }

            protected AttributedStyle getCompletionStyleListBackground() {
                return getCompletionStyle(LineReader.COMPLETION_STYLE_LIST_BACKGROUND, DEFAULT_COMPLETION_STYLE_LIST_BACKGROUND);
            }

            protected AttributedStyle getCompletionStyle(String name, String value) {
                return new StyleResolver(s -> {
                    return getString(s, null);
                }).resolve(Mapper.IGNORED_FIELDNAME + name, value);
            }

            protected AttributedStyle buildStyle(String str) {
                return AttributedString.fromAnsi(ANSIConstants.ESC_START + str + "m ").styleAt(0);
            }

            protected boolean moveHistory(boolean next, int count) {
                boolean ok = true;
                for (int i = 0; i < count; i++) {
                    boolean moveHistory = moveHistory(next);
                    ok = moveHistory;
                    if (!moveHistory) {
                        break;
                    }
                }
                return ok;
            }

            protected boolean moveHistory(boolean next) {
                String str;
                if (!this.buf.toString().equals(this.history.current())) {
                    this.modifiedHistory.put(Integer.valueOf(this.history.index()), this.buf.toString());
                }
                if (next && !this.history.next()) {
                    return false;
                }
                if (!next && !this.history.previous()) {
                    return false;
                }
                if (this.modifiedHistory.containsKey(Integer.valueOf(this.history.index()))) {
                    str = this.modifiedHistory.get(Integer.valueOf(this.history.index()));
                } else {
                    str = this.history.current();
                }
                setBuffer(str);
                return true;
            }

            void print(String str) {
                this.terminal.writer().write(str);
            }

            void println(String s) {
                print(s);
                println();
            }

            void println() {
                this.terminal.puts(InfoCmp.Capability.carriage_return, new Object[0]);
                print("\n");
                redrawLine();
            }

            protected boolean killBuffer() {
                this.killRing.add(this.buf.toString());
                this.buf.clear();
                return true;
            }

            protected boolean killWholeLine() {
                int end;
                int start;
                if (this.buf.length() == 0) {
                    return false;
                }
                if (this.count >= 0) {
                    start = this.buf.cursor();
                    while (start > 0 && this.buf.atChar(start - 1) != 10) {
                        start--;
                    }
                    end = start;
                    while (true) {
                        int i = this.count;
                        this.count = i - 1;
                        if (i <= 0) {
                            break;
                        }
                        while (end < this.buf.length() && this.buf.atChar(end) != 10) {
                            end++;
                        }
                        if (end < this.buf.length()) {
                            end++;
                        }
                    }
                } else {
                    end = this.buf.cursor();
                    while (this.buf.atChar(end) != 0 && this.buf.atChar(end) != 10) {
                        end++;
                    }
                    start = end;
                    for (int count = -this.count; count > 0; count--) {
                        while (start > 0 && this.buf.atChar(start - 1) != 10) {
                            start--;
                        }
                        start--;
                    }
                }
                String killed = this.buf.substring(start, end);
                this.buf.cursor(start);
                this.buf.delete(end - start);
                this.killRing.add(killed);
                return true;
            }

            public boolean killLine() {
                if (this.count < 0) {
                    return callNeg(this::backwardKillLine);
                }
                if (this.buf.cursor() == this.buf.length()) {
                    return false;
                }
                int cp = this.buf.cursor();
                int len = cp;
                while (true) {
                    int i = this.count;
                    this.count = i - 1;
                    if (i <= 0) {
                        int num = len - cp;
                        String killed = this.buf.substring(cp, cp + num);
                        this.buf.delete(num);
                        this.killRing.add(killed);
                        return true;
                    } else if (this.buf.atChar(len) == 10) {
                        len++;
                    } else {
                        while (this.buf.atChar(len) != 0 && this.buf.atChar(len) != 10) {
                            len++;
                        }
                    }
                }
            }

            public boolean backwardKillLine() {
                if (this.count < 0) {
                    return callNeg(this::killLine);
                }
                if (this.buf.cursor() == 0) {
                    return false;
                }
                int cp = this.buf.cursor();
                int beg = cp;
                while (true) {
                    int i = this.count;
                    this.count = i - 1;
                    if (i <= 0 || beg == 0) {
                        break;
                    } else if (this.buf.atChar(beg - 1) == 10) {
                        beg--;
                    } else {
                        while (beg > 0 && this.buf.atChar(beg - 1) != 0 && this.buf.atChar(beg - 1) != 10) {
                            beg--;
                        }
                    }
                }
                int num = cp - beg;
                String killed = this.buf.substring(cp - beg, cp);
                this.buf.cursor(beg);
                this.buf.delete(num);
                this.killRing.add(killed);
                return true;
            }

            public boolean killRegion() {
                return doCopyKillRegion(true);
            }

            public boolean copyRegionAsKill() {
                return doCopyKillRegion(false);
            }

            private boolean doCopyKillRegion(boolean kill) {
                if (this.regionMark > this.buf.length()) {
                    this.regionMark = this.buf.length();
                }
                if (this.regionActive == LineReader.RegionType.LINE) {
                    int start = this.regionMark;
                    int end = this.buf.cursor();
                    if (start < end) {
                        while (start > 0 && this.buf.atChar(start - 1) != 10) {
                            start--;
                        }
                        while (end < this.buf.length() - 1 && this.buf.atChar(end + 1) != 10) {
                            end++;
                        }
                        if (isInViCmdMode()) {
                            end++;
                        }
                        this.killRing.add(this.buf.substring(start, end));
                        if (kill) {
                            this.buf.backspace(end - start);
                        }
                    } else {
                        while (end > 0 && this.buf.atChar(end - 1) != 10) {
                            end--;
                        }
                        while (start < this.buf.length() && this.buf.atChar(start) != 10) {
                            start++;
                        }
                        if (isInViCmdMode()) {
                            start++;
                        }
                        this.killRing.addBackwards(this.buf.substring(end, start));
                        if (kill) {
                            this.buf.cursor(end);
                            this.buf.delete(start - end);
                        }
                    }
                } else if (this.regionMark > this.buf.cursor()) {
                    if (isInViCmdMode()) {
                        this.regionMark++;
                    }
                    this.killRing.add(this.buf.substring(this.buf.cursor(), this.regionMark));
                    if (kill) {
                        this.buf.delete(this.regionMark - this.buf.cursor());
                    }
                } else {
                    if (isInViCmdMode()) {
                        this.buf.move(1);
                    }
                    this.killRing.add(this.buf.substring(this.regionMark, this.buf.cursor()));
                    if (kill) {
                        this.buf.backspace(this.buf.cursor() - this.regionMark);
                    }
                }
                if (!kill) {
                    return true;
                }
                this.regionActive = LineReader.RegionType.NONE;
                return true;
            }

            public boolean yank() {
                String yanked = this.killRing.yank();
                if (yanked == null) {
                    return false;
                }
                putString(yanked);
                return true;
            }

            public boolean yankPop() {
                String current;
                if (!this.killRing.lastYank() || (current = this.killRing.yank()) == null) {
                    return false;
                }
                this.buf.backspace(current.length());
                String yanked = this.killRing.yankPop();
                if (yanked == null) {
                    return false;
                }
                putString(yanked);
                return true;
            }

            public boolean mouse() {
                MouseEvent event = readMouseEvent();
                if (event.getType() != MouseEvent.Type.Released || event.getButton() != MouseEvent.Button.Button1) {
                    return true;
                }
                StringBuilder tsb = new StringBuilder();
                Cursor cursor = this.terminal.getCursorPosition(c -> {
                    tsb.append((char) c);
                });
                this.bindingReader.runMacro(tsb.toString());
                List<AttributedString> secondaryPrompts = new ArrayList<>();
                getDisplayedBufferWithPrompts(secondaryPrompts);
                AttributedStringBuilder sb = new AttributedStringBuilder().tabs(4);
                sb.append(this.prompt);
                sb.append(insertSecondaryPrompts(new AttributedString(this.buf.upToCursor()), secondaryPrompts, false));
                int currentLine = sb.columnSplitLength(this.size.getColumns(), false, this.display.delayLineWrap()).size() - 1;
                int wantedLine = Math.max(0, Math.min((currentLine + event.getY()) - cursor.getY(), secondaryPrompts.size()));
                this.buf.moveXY((event.getX() - cursor.getX()) - ((wantedLine == 0 ? this.prompt.columnLength() : secondaryPrompts.get(wantedLine - 1).columnLength()) - (currentLine == 0 ? this.prompt.columnLength() : secondaryPrompts.get(currentLine - 1).columnLength())), event.getY() - cursor.getY());
                return true;
            }

            public boolean beginPaste() {
                String str = doReadStringUntil(BRACKETED_PASTE_END);
                this.regionActive = LineReader.RegionType.PASTE;
                this.regionMark = getBuffer().cursor();
                getBuffer().write(str.replace('\r', '\n'));
                return true;
            }

            public boolean focusIn() {
                return false;
            }

            public boolean focusOut() {
                return false;
            }

            public boolean clear() {
                this.display.update(Collections.emptyList(), 0);
                return true;
            }

            public boolean clearScreen() {
                if (this.terminal.puts(InfoCmp.Capability.clear_screen, new Object[0])) {
                    if ("windows-conemu".equals(this.terminal.getType()) && !Boolean.getBoolean("org.jline.terminal.conemu.disable-activate")) {
                        this.terminal.writer().write("\u001b[9999E");
                    }
                    Status status = Status.getStatus(this.terminal, false);
                    if (status != null) {
                        status.reset();
                    }
                    redrawLine();
                    return true;
                }
                println();
                return true;
            }

            public boolean beep() {
                BellType bell_preference = BellType.AUDIBLE;
                String lowerCase = getString(LineReader.BELL_STYLE, "").toLowerCase();
                char c = 65535;
                switch (lowerCase.hashCode()) {
                    case -661267710:
                        if (lowerCase.equals("audible")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3551:
                        if (lowerCase.equals("on")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 109935:
                        if (lowerCase.equals("off")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3387192:
                        if (lowerCase.equals("none")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 466743410:
                        if (lowerCase.equals("visible")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 1:
                        bell_preference = BellType.NONE;
                        break;
                    case 2:
                        bell_preference = BellType.AUDIBLE;
                        break;
                    case 3:
                        bell_preference = BellType.VISIBLE;
                        break;
                    case 4:
                        bell_preference = getBoolean(LineReader.PREFER_VISIBLE_BELL, false) ? BellType.VISIBLE : BellType.AUDIBLE;
                        break;
                }
                if (bell_preference == BellType.VISIBLE) {
                    if (!this.terminal.puts(InfoCmp.Capability.flash_screen, new Object[0]) && !this.terminal.puts(InfoCmp.Capability.bell, new Object[0])) {
                        return true;
                    }
                    flush();
                    return true;
                } else if (bell_preference != BellType.AUDIBLE || !this.terminal.puts(InfoCmp.Capability.bell, new Object[0])) {
                    return true;
                } else {
                    flush();
                    return true;
                }
            }

            protected boolean isDelimiter(int c) {
                return !Character.isLetterOrDigit(c);
            }

            protected boolean isWhitespace(int c) {
                return Character.isWhitespace(c);
            }

            protected boolean isViAlphaNum(int c) {
                return c == 95 || Character.isLetterOrDigit(c);
            }

            protected boolean isAlpha(int c) {
                return Character.isLetter(c);
            }

            protected boolean isWord(int c) {
                return Character.isLetterOrDigit(c) || (c < 128 && getString(LineReader.WORDCHARS, DEFAULT_WORDCHARS).indexOf((char) c) >= 0);
            }

            String getString(String name, String def) {
                return ReaderUtils.getString(this, name, def);
            }

            boolean getBoolean(String name, boolean def) {
                return ReaderUtils.getBoolean(this, name, def);
            }

            int getInt(String name, int def) {
                return ReaderUtils.getInt(this, name, def);
            }

            long getLong(String name, long def) {
                return ReaderUtils.getLong(this, name, def);
            }

            @Override // org.jline.reader.LineReader
            public Map<String, KeyMap<Binding>> defaultKeyMaps() {
                Map<String, KeyMap<Binding>> keyMaps = new HashMap<>();
                keyMaps.put(LineReader.EMACS, emacs());
                keyMaps.put(LineReader.VICMD, viCmd());
                keyMaps.put(LineReader.VIINS, viInsertion());
                keyMaps.put(LineReader.MENU, menu());
                keyMaps.put(LineReader.VIOPP, viOpp());
                keyMaps.put(LineReader.VISUAL, visual());
                keyMaps.put(LineReader.SAFE, safe());
                if (getBoolean(LineReader.BIND_TTY_SPECIAL_CHARS, true)) {
                    Attributes attr = this.terminal.getAttributes();
                    bindConsoleChars(keyMaps.get(LineReader.EMACS), attr);
                    bindConsoleChars(keyMaps.get(LineReader.VIINS), attr);
                }
                for (KeyMap<Binding> keyMap : keyMaps.values()) {
                    keyMap.setUnicode(new Reference(LineReader.SELF_INSERT));
                    keyMap.setAmbiguousTimeout(getLong(LineReader.AMBIGUOUS_BINDING, 1000));
                }
                keyMaps.put(LineReader.MAIN, keyMaps.get(LineReader.EMACS));
                return keyMaps;
            }

            public KeyMap<Binding> emacs() {
                KeyMap<Binding> emacs = new KeyMap<>();
                bindKeys(emacs);
                bind(emacs, LineReader.SET_MARK_COMMAND, KeyMap.ctrl('@'));
                bind(emacs, LineReader.BEGINNING_OF_LINE, KeyMap.ctrl('A'));
                bind(emacs, LineReader.BACKWARD_CHAR, KeyMap.ctrl('B'));
                bind(emacs, LineReader.DELETE_CHAR_OR_LIST, KeyMap.ctrl('D'));
                bind(emacs, LineReader.END_OF_LINE, KeyMap.ctrl('E'));
                bind(emacs, LineReader.FORWARD_CHAR, KeyMap.ctrl('F'));
                bind(emacs, LineReader.SEND_BREAK, KeyMap.ctrl('G'));
                bind(emacs, LineReader.BACKWARD_DELETE_CHAR, KeyMap.ctrl('H'));
                bind(emacs, LineReader.EXPAND_OR_COMPLETE, KeyMap.ctrl('I'));
                bind(emacs, LineReader.ACCEPT_LINE, KeyMap.ctrl('J'));
                bind(emacs, LineReader.KILL_LINE, KeyMap.ctrl('K'));
                bind(emacs, LineReader.CLEAR_SCREEN, KeyMap.ctrl('L'));
                bind(emacs, LineReader.ACCEPT_LINE, KeyMap.ctrl('M'));
                bind(emacs, LineReader.DOWN_LINE_OR_HISTORY, KeyMap.ctrl('N'));
                bind(emacs, LineReader.ACCEPT_LINE_AND_DOWN_HISTORY, KeyMap.ctrl('O'));
                bind(emacs, LineReader.UP_LINE_OR_HISTORY, KeyMap.ctrl('P'));
                bind(emacs, LineReader.HISTORY_INCREMENTAL_SEARCH_BACKWARD, KeyMap.ctrl('R'));
                bind(emacs, LineReader.HISTORY_INCREMENTAL_SEARCH_FORWARD, KeyMap.ctrl('S'));
                bind(emacs, LineReader.TRANSPOSE_CHARS, KeyMap.ctrl('T'));
                bind(emacs, LineReader.KILL_WHOLE_LINE, KeyMap.ctrl('U'));
                bind(emacs, LineReader.QUOTED_INSERT, KeyMap.ctrl('V'));
                bind(emacs, LineReader.BACKWARD_KILL_WORD, KeyMap.ctrl('W'));
                bind(emacs, LineReader.YANK, KeyMap.ctrl('Y'));
                bind(emacs, LineReader.CHARACTER_SEARCH, KeyMap.ctrl(']'));
                bind(emacs, LineReader.UNDO, KeyMap.ctrl('_'));
                bind(emacs, LineReader.SELF_INSERT, KeyMap.range(" -~"));
                bind(emacs, LineReader.INSERT_CLOSE_PAREN, DESC_SUFFIX);
                bind(emacs, LineReader.INSERT_CLOSE_SQUARE, "]");
                bind(emacs, LineReader.INSERT_CLOSE_CURLY, "}");
                bind(emacs, LineReader.BACKWARD_DELETE_CHAR, KeyMap.del());
                bind(emacs, LineReader.VI_MATCH_BRACKET, KeyMap.translate("^X^B"));
                bind(emacs, LineReader.SEND_BREAK, KeyMap.translate("^X^G"));
                bind(emacs, LineReader.EDIT_AND_EXECUTE_COMMAND, KeyMap.translate("^X^E"));
                bind(emacs, LineReader.VI_FIND_NEXT_CHAR, KeyMap.translate("^X^F"));
                bind(emacs, LineReader.VI_JOIN, KeyMap.translate("^X^J"));
                bind(emacs, LineReader.KILL_BUFFER, KeyMap.translate("^X^K"));
                bind(emacs, LineReader.INFER_NEXT_HISTORY, KeyMap.translate("^X^N"));
                bind(emacs, LineReader.OVERWRITE_MODE, KeyMap.translate("^X^O"));
                bind(emacs, LineReader.REDO, KeyMap.translate("^X^R"));
                bind(emacs, LineReader.UNDO, KeyMap.translate("^X^U"));
                bind(emacs, LineReader.VI_CMD_MODE, KeyMap.translate("^X^V"));
                bind(emacs, LineReader.EXCHANGE_POINT_AND_MARK, KeyMap.translate("^X^X"));
                bind(emacs, LineReader.DO_LOWERCASE_VERSION, KeyMap.translate("^XA-^XZ"));
                bind(emacs, LineReader.WHAT_CURSOR_POSITION, KeyMap.translate("^X="));
                bind(emacs, LineReader.KILL_LINE, KeyMap.translate("^X^?"));
                bind(emacs, LineReader.SEND_BREAK, KeyMap.alt(KeyMap.ctrl('G')));
                bind(emacs, LineReader.BACKWARD_KILL_WORD, KeyMap.alt(KeyMap.ctrl('H')));
                bind(emacs, LineReader.SELF_INSERT_UNMETA, KeyMap.alt(KeyMap.ctrl('M')));
                bind(emacs, LineReader.COMPLETE_WORD, KeyMap.alt(KeyMap.esc()));
                bind(emacs, LineReader.CHARACTER_SEARCH_BACKWARD, KeyMap.alt(KeyMap.ctrl(']')));
                bind(emacs, LineReader.COPY_PREV_WORD, KeyMap.alt(KeyMap.ctrl('_')));
                bind(emacs, LineReader.SET_MARK_COMMAND, KeyMap.alt(' '));
                bind(emacs, LineReader.NEG_ARGUMENT, KeyMap.alt('-'));
                bind(emacs, LineReader.DIGIT_ARGUMENT, KeyMap.range("\\E0-\\E9"));
                bind(emacs, LineReader.BEGINNING_OF_HISTORY, KeyMap.alt('<'));
                bind(emacs, LineReader.LIST_CHOICES, KeyMap.alt('='));
                bind(emacs, LineReader.END_OF_HISTORY, KeyMap.alt('>'));
                bind(emacs, LineReader.LIST_CHOICES, KeyMap.alt('?'));
                bind(emacs, LineReader.DO_LOWERCASE_VERSION, KeyMap.range("^[A-^[Z"));
                bind(emacs, LineReader.ACCEPT_AND_HOLD, KeyMap.alt('a'));
                bind(emacs, LineReader.BACKWARD_WORD, KeyMap.alt('b'));
                bind(emacs, LineReader.CAPITALIZE_WORD, KeyMap.alt('c'));
                bind(emacs, LineReader.KILL_WORD, KeyMap.alt('d'));
                bind(emacs, LineReader.KILL_WORD, KeyMap.translate("^[[3;5~"));
                bind(emacs, LineReader.FORWARD_WORD, KeyMap.alt('f'));
                bind(emacs, LineReader.DOWN_CASE_WORD, KeyMap.alt('l'));
                bind(emacs, LineReader.HISTORY_SEARCH_FORWARD, KeyMap.alt('n'));
                bind(emacs, LineReader.HISTORY_SEARCH_BACKWARD, KeyMap.alt('p'));
                bind(emacs, LineReader.TRANSPOSE_WORDS, KeyMap.alt('t'));
                bind(emacs, LineReader.UP_CASE_WORD, KeyMap.alt('u'));
                bind(emacs, LineReader.YANK_POP, KeyMap.alt('y'));
                bind(emacs, LineReader.BACKWARD_KILL_WORD, KeyMap.alt(KeyMap.del()));
                bindArrowKeys(emacs);
                bind(emacs, LineReader.FORWARD_WORD, KeyMap.translate("^[[1;5C"));
                bind(emacs, LineReader.BACKWARD_WORD, KeyMap.translate("^[[1;5D"));
                bind(emacs, LineReader.FORWARD_WORD, KeyMap.alt(key(InfoCmp.Capability.key_right)));
                bind(emacs, LineReader.BACKWARD_WORD, KeyMap.alt(key(InfoCmp.Capability.key_left)));
                bind(emacs, LineReader.FORWARD_WORD, KeyMap.alt(KeyMap.translate("^[[C")));
                bind(emacs, LineReader.BACKWARD_WORD, KeyMap.alt(KeyMap.translate("^[[D")));
                return emacs;
            }

            public KeyMap<Binding> viInsertion() {
                KeyMap<Binding> viins = new KeyMap<>();
                bindKeys(viins);
                bind(viins, LineReader.SELF_INSERT, KeyMap.range("^@-^_"));
                bind(viins, LineReader.LIST_CHOICES, KeyMap.ctrl('D'));
                bind(viins, LineReader.SEND_BREAK, KeyMap.ctrl('G'));
                bind(viins, LineReader.BACKWARD_DELETE_CHAR, KeyMap.ctrl('H'));
                bind(viins, LineReader.EXPAND_OR_COMPLETE, KeyMap.ctrl('I'));
                bind(viins, LineReader.ACCEPT_LINE, KeyMap.ctrl('J'));
                bind(viins, LineReader.CLEAR_SCREEN, KeyMap.ctrl('L'));
                bind(viins, LineReader.ACCEPT_LINE, KeyMap.ctrl('M'));
                bind(viins, LineReader.MENU_COMPLETE, KeyMap.ctrl('N'));
                bind(viins, LineReader.REVERSE_MENU_COMPLETE, KeyMap.ctrl('P'));
                bind(viins, LineReader.HISTORY_INCREMENTAL_SEARCH_BACKWARD, KeyMap.ctrl('R'));
                bind(viins, LineReader.HISTORY_INCREMENTAL_SEARCH_FORWARD, KeyMap.ctrl('S'));
                bind(viins, LineReader.TRANSPOSE_CHARS, KeyMap.ctrl('T'));
                bind(viins, LineReader.KILL_WHOLE_LINE, KeyMap.ctrl('U'));
                bind(viins, LineReader.QUOTED_INSERT, KeyMap.ctrl('V'));
                bind(viins, LineReader.BACKWARD_KILL_WORD, KeyMap.ctrl('W'));
                bind(viins, LineReader.YANK, KeyMap.ctrl('Y'));
                bind(viins, LineReader.VI_CMD_MODE, KeyMap.ctrl('['));
                bind(viins, LineReader.UNDO, KeyMap.ctrl('_'));
                bind(viins, LineReader.HISTORY_INCREMENTAL_SEARCH_BACKWARD, KeyMap.ctrl('X') + "r");
                bind(viins, LineReader.HISTORY_INCREMENTAL_SEARCH_FORWARD, KeyMap.ctrl('X') + "s");
                bind(viins, LineReader.SELF_INSERT, KeyMap.range(" -~"));
                bind(viins, LineReader.INSERT_CLOSE_PAREN, DESC_SUFFIX);
                bind(viins, LineReader.INSERT_CLOSE_SQUARE, "]");
                bind(viins, LineReader.INSERT_CLOSE_CURLY, "}");
                bind(viins, LineReader.BACKWARD_DELETE_CHAR, KeyMap.del());
                bindArrowKeys(viins);
                return viins;
            }

            public KeyMap<Binding> viCmd() {
                KeyMap<Binding> vicmd = new KeyMap<>();
                bind(vicmd, LineReader.LIST_CHOICES, KeyMap.ctrl('D'));
                bind(vicmd, LineReader.EMACS_EDITING_MODE, KeyMap.ctrl('E'));
                bind(vicmd, LineReader.SEND_BREAK, KeyMap.ctrl('G'));
                bind(vicmd, LineReader.VI_BACKWARD_CHAR, KeyMap.ctrl('H'));
                bind(vicmd, LineReader.ACCEPT_LINE, KeyMap.ctrl('J'));
                bind(vicmd, LineReader.KILL_LINE, KeyMap.ctrl('K'));
                bind(vicmd, LineReader.CLEAR_SCREEN, KeyMap.ctrl('L'));
                bind(vicmd, LineReader.ACCEPT_LINE, KeyMap.ctrl('M'));
                bind(vicmd, LineReader.VI_DOWN_LINE_OR_HISTORY, KeyMap.ctrl('N'));
                bind(vicmd, LineReader.VI_UP_LINE_OR_HISTORY, KeyMap.ctrl('P'));
                bind(vicmd, LineReader.QUOTED_INSERT, KeyMap.ctrl('Q'));
                bind(vicmd, LineReader.HISTORY_INCREMENTAL_SEARCH_BACKWARD, KeyMap.ctrl('R'));
                bind(vicmd, LineReader.HISTORY_INCREMENTAL_SEARCH_FORWARD, KeyMap.ctrl('S'));
                bind(vicmd, LineReader.TRANSPOSE_CHARS, KeyMap.ctrl('T'));
                bind(vicmd, LineReader.KILL_WHOLE_LINE, KeyMap.ctrl('U'));
                bind(vicmd, LineReader.QUOTED_INSERT, KeyMap.ctrl('V'));
                bind(vicmd, LineReader.BACKWARD_KILL_WORD, KeyMap.ctrl('W'));
                bind(vicmd, LineReader.YANK, KeyMap.ctrl('Y'));
                bind(vicmd, LineReader.HISTORY_INCREMENTAL_SEARCH_BACKWARD, KeyMap.ctrl('X') + "r");
                bind(vicmd, LineReader.HISTORY_INCREMENTAL_SEARCH_FORWARD, KeyMap.ctrl('X') + "s");
                bind(vicmd, LineReader.SEND_BREAK, KeyMap.alt(KeyMap.ctrl('G')));
                bind(vicmd, LineReader.BACKWARD_KILL_WORD, KeyMap.alt(KeyMap.ctrl('H')));
                bind(vicmd, LineReader.SELF_INSERT_UNMETA, KeyMap.alt(KeyMap.ctrl('M')));
                bind(vicmd, LineReader.COMPLETE_WORD, KeyMap.alt(KeyMap.esc()));
                bind(vicmd, LineReader.CHARACTER_SEARCH_BACKWARD, KeyMap.alt(KeyMap.ctrl(']')));
                bind(vicmd, LineReader.SET_MARK_COMMAND, KeyMap.alt(' '));
                bind(vicmd, LineReader.DIGIT_ARGUMENT, KeyMap.alt('-'));
                bind(vicmd, LineReader.BEGINNING_OF_HISTORY, KeyMap.alt('<'));
                bind(vicmd, LineReader.LIST_CHOICES, KeyMap.alt('='));
                bind(vicmd, LineReader.END_OF_HISTORY, KeyMap.alt('>'));
                bind(vicmd, LineReader.LIST_CHOICES, KeyMap.alt('?'));
                bind(vicmd, LineReader.DO_LOWERCASE_VERSION, KeyMap.range("^[A-^[Z"));
                bind(vicmd, LineReader.BACKWARD_WORD, KeyMap.alt('b'));
                bind(vicmd, LineReader.CAPITALIZE_WORD, KeyMap.alt('c'));
                bind(vicmd, LineReader.KILL_WORD, KeyMap.alt('d'));
                bind(vicmd, LineReader.FORWARD_WORD, KeyMap.alt('f'));
                bind(vicmd, LineReader.DOWN_CASE_WORD, KeyMap.alt('l'));
                bind(vicmd, LineReader.HISTORY_SEARCH_FORWARD, KeyMap.alt('n'));
                bind(vicmd, LineReader.HISTORY_SEARCH_BACKWARD, KeyMap.alt('p'));
                bind(vicmd, LineReader.TRANSPOSE_WORDS, KeyMap.alt('t'));
                bind(vicmd, LineReader.UP_CASE_WORD, KeyMap.alt('u'));
                bind(vicmd, LineReader.YANK_POP, KeyMap.alt('y'));
                bind(vicmd, LineReader.BACKWARD_KILL_WORD, KeyMap.alt(KeyMap.del()));
                bind(vicmd, LineReader.FORWARD_CHAR, " ");
                bind(vicmd, LineReader.VI_INSERT_COMMENT, DEFAULT_COMMENT_BEGIN);
                bind(vicmd, LineReader.END_OF_LINE, "$");
                bind(vicmd, LineReader.VI_MATCH_BRACKET, "%");
                bind(vicmd, LineReader.VI_DOWN_LINE_OR_HISTORY, Marker.ANY_NON_NULL_MARKER);
                bind(vicmd, LineReader.VI_REV_REPEAT_FIND, ",");
                bind(vicmd, LineReader.VI_UP_LINE_OR_HISTORY, "-");
                bind(vicmd, LineReader.VI_REPEAT_CHANGE, Mapper.IGNORED_FIELDNAME);
                bind(vicmd, LineReader.VI_HISTORY_SEARCH_BACKWARD, "/");
                bind(vicmd, LineReader.VI_DIGIT_OR_BEGINNING_OF_LINE, "0");
                bind(vicmd, LineReader.DIGIT_ARGUMENT, KeyMap.range("1-9"));
                bind(vicmd, LineReader.VI_REPEAT_FIND, ";");
                bind(vicmd, LineReader.LIST_CHOICES, "=");
                bind(vicmd, LineReader.VI_HISTORY_SEARCH_FORWARD, "?");
                bind(vicmd, LineReader.VI_ADD_EOL, "A");
                bind(vicmd, LineReader.VI_BACKWARD_BLANK_WORD, "B");
                bind(vicmd, LineReader.VI_CHANGE_EOL, "C");
                bind(vicmd, LineReader.VI_KILL_EOL, "D");
                bind(vicmd, LineReader.VI_FORWARD_BLANK_WORD_END, "E");
                bind(vicmd, LineReader.VI_FIND_PREV_CHAR, "F");
                bind(vicmd, LineReader.VI_FETCH_HISTORY, "G");
                bind(vicmd, LineReader.VI_INSERT_BOL, "I");
                bind(vicmd, LineReader.VI_JOIN, "J");
                bind(vicmd, LineReader.VI_REV_REPEAT_SEARCH, "N");
                bind(vicmd, LineReader.VI_OPEN_LINE_ABOVE, "O");
                bind(vicmd, LineReader.VI_PUT_BEFORE, "P");
                bind(vicmd, LineReader.VI_REPLACE, "R");
                bind(vicmd, LineReader.VI_KILL_LINE, "S");
                bind(vicmd, LineReader.VI_FIND_PREV_CHAR_SKIP, "T");
                bind(vicmd, LineReader.REDO, "U");
                bind(vicmd, LineReader.VISUAL_LINE_MODE, "V");
                bind(vicmd, LineReader.VI_FORWARD_BLANK_WORD, "W");
                bind(vicmd, LineReader.VI_BACKWARD_DELETE_CHAR, "X");
                bind(vicmd, LineReader.VI_YANK_WHOLE_LINE, "Y");
                bind(vicmd, LineReader.VI_FIRST_NON_BLANK, "^");
                bind(vicmd, LineReader.VI_ADD_NEXT, "a");
                bind(vicmd, LineReader.VI_BACKWARD_WORD, "b");
                bind(vicmd, LineReader.VI_CHANGE, "c");
                bind(vicmd, LineReader.VI_DELETE, DateTokenConverter.CONVERTER_KEY);
                bind(vicmd, LineReader.VI_FORWARD_WORD_END, "e");
                bind(vicmd, LineReader.VI_FIND_NEXT_CHAR, "f");
                bind(vicmd, LineReader.WHAT_CURSOR_POSITION, "ga");
                bind(vicmd, LineReader.VI_BACKWARD_BLANK_WORD_END, "gE");
                bind(vicmd, LineReader.VI_BACKWARD_WORD_END, "ge");
                bind(vicmd, LineReader.VI_BACKWARD_CHAR, "h");
                bind(vicmd, LineReader.VI_INSERT, IntegerTokenConverter.CONVERTER_KEY);
                bind(vicmd, LineReader.DOWN_LINE_OR_HISTORY, "j");
                bind(vicmd, LineReader.UP_LINE_OR_HISTORY, "k");
                bind(vicmd, LineReader.VI_FORWARD_CHAR, "l");
                bind(vicmd, LineReader.VI_REPEAT_SEARCH, "n");
                bind(vicmd, LineReader.VI_OPEN_LINE_BELOW, "o");
                bind(vicmd, LineReader.VI_PUT_AFTER, "p");
                bind(vicmd, LineReader.VI_REPLACE_CHARS, "r");
                bind(vicmd, LineReader.VI_SUBSTITUTE, "s");
                bind(vicmd, LineReader.VI_FIND_NEXT_CHAR_SKIP, "t");
                bind(vicmd, LineReader.UNDO, "u");
                bind(vicmd, LineReader.VISUAL_MODE, "v");
                bind(vicmd, LineReader.VI_FORWARD_WORD, "w");
                bind(vicmd, LineReader.VI_DELETE_CHAR, "x");
                bind(vicmd, LineReader.VI_YANK, "y");
                bind(vicmd, LineReader.VI_GOTO_COLUMN, "|");
                bind(vicmd, LineReader.VI_SWAP_CASE, "~");
                bind(vicmd, LineReader.VI_BACKWARD_CHAR, KeyMap.del());
                bindArrowKeys(vicmd);
                return vicmd;
            }

            public KeyMap<Binding> menu() {
                KeyMap<Binding> menu = new KeyMap<>();
                bind(menu, LineReader.MENU_COMPLETE, SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                bind(menu, LineReader.REVERSE_MENU_COMPLETE, key(InfoCmp.Capability.back_tab));
                bind(menu, LineReader.ACCEPT_LINE, "\r", "\n");
                bindArrowKeys(menu);
                return menu;
            }

            public KeyMap<Binding> safe() {
                KeyMap<Binding> safe = new KeyMap<>();
                bind(safe, LineReader.SELF_INSERT, KeyMap.range("^@-^?"));
                bind(safe, LineReader.ACCEPT_LINE, "\r", "\n");
                bind(safe, LineReader.SEND_BREAK, KeyMap.ctrl('G'));
                return safe;
            }

            public KeyMap<Binding> visual() {
                KeyMap<Binding> visual = new KeyMap<>();
                bind(visual, LineReader.UP_LINE, key(InfoCmp.Capability.key_up), "k");
                bind(visual, LineReader.DOWN_LINE, key(InfoCmp.Capability.key_down), "j");
                bind(visual, this::deactivateRegion, KeyMap.esc());
                bind(visual, LineReader.EXCHANGE_POINT_AND_MARK, "o");
                bind(visual, LineReader.PUT_REPLACE_SELECTION, "p");
                bind(visual, LineReader.VI_DELETE, "x");
                bind(visual, LineReader.VI_OPER_SWAP_CASE, "~");
                return visual;
            }

            public KeyMap<Binding> viOpp() {
                KeyMap<Binding> viOpp = new KeyMap<>();
                bind(viOpp, LineReader.UP_LINE, key(InfoCmp.Capability.key_up), "k");
                bind(viOpp, LineReader.DOWN_LINE, key(InfoCmp.Capability.key_down), "j");
                bind(viOpp, LineReader.VI_CMD_MODE, KeyMap.esc());
                return viOpp;
            }

            private void bind(KeyMap<Binding> map, String widget, Iterable<? extends CharSequence> keySeqs) {
                map.bind((KeyMap<Binding>) new Reference(widget), keySeqs);
            }

            private void bind(KeyMap<Binding> map, String widget, CharSequence... keySeqs) {
                map.bind((KeyMap<Binding>) new Reference(widget), keySeqs);
            }

            private void bind(KeyMap<Binding> map, Widget widget, CharSequence... keySeqs) {
                map.bind((KeyMap<Binding>) widget, keySeqs);
            }

            private String key(InfoCmp.Capability capability) {
                return KeyMap.key(this.terminal, capability);
            }

            private void bindKeys(KeyMap<Binding> emacs) {
                Widget beep = namedWidget(LineReader.BEEP, this::beep);
                Stream.of((Object[]) InfoCmp.Capability.values()).filter(c -> {
                    return c.name().startsWith("key_");
                }).map(this::key).forEach(k -> {
                    bind(emacs, emacs, beep);
                });
            }

            private void bindArrowKeys(KeyMap<Binding> map) {
                bind(map, LineReader.UP_LINE_OR_SEARCH, key(InfoCmp.Capability.key_up));
                bind(map, LineReader.DOWN_LINE_OR_SEARCH, key(InfoCmp.Capability.key_down));
                bind(map, LineReader.BACKWARD_CHAR, key(InfoCmp.Capability.key_left));
                bind(map, LineReader.FORWARD_CHAR, key(InfoCmp.Capability.key_right));
                bind(map, LineReader.BEGINNING_OF_LINE, key(InfoCmp.Capability.key_home));
                bind(map, LineReader.END_OF_LINE, key(InfoCmp.Capability.key_end));
                bind(map, LineReader.DELETE_CHAR, key(InfoCmp.Capability.key_dc));
                bind(map, LineReader.KILL_WHOLE_LINE, key(InfoCmp.Capability.key_dl));
                bind(map, LineReader.OVERWRITE_MODE, key(InfoCmp.Capability.key_ic));
                bind(map, LineReader.MOUSE, key(InfoCmp.Capability.key_mouse));
                bind(map, LineReader.BEGIN_PASTE, BRACKETED_PASTE_BEGIN);
                bind(map, LineReader.FOCUS_IN, FOCUS_IN_SEQ);
                bind(map, LineReader.FOCUS_OUT, FOCUS_OUT_SEQ);
            }

            private void bindConsoleChars(KeyMap<Binding> keyMap, Attributes attr) {
                if (attr != null) {
                    rebind(keyMap, LineReader.BACKWARD_DELETE_CHAR, KeyMap.del(), (char) attr.getControlChar(Attributes.ControlChar.VERASE));
                    rebind(keyMap, LineReader.BACKWARD_KILL_WORD, KeyMap.ctrl('W'), (char) attr.getControlChar(Attributes.ControlChar.VWERASE));
                    rebind(keyMap, LineReader.KILL_WHOLE_LINE, KeyMap.ctrl('U'), (char) attr.getControlChar(Attributes.ControlChar.VKILL));
                    rebind(keyMap, LineReader.QUOTED_INSERT, KeyMap.ctrl('V'), (char) attr.getControlChar(Attributes.ControlChar.VLNEXT));
                }
            }

            private void rebind(KeyMap<Binding> keyMap, String operation, String prevBinding, char newBinding) {
                if (newBinding > 0 && newBinding < 128) {
                    Reference ref = new Reference(operation);
                    bind(keyMap, LineReader.SELF_INSERT, prevBinding);
                    keyMap.bind((KeyMap<Binding>) ref, Character.toString(newBinding));
                }
            }
        }
