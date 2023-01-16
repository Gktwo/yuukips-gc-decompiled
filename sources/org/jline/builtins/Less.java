package org.jline.builtins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Stream;
import org.jline.builtins.Nano;
import org.jline.builtins.Source;
import org.jline.console.Printer;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;
import org.jline.utils.Status;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/builtins/Less.class */
public class Less {
    private static final int ESCAPE = 27;
    private static final String MESSAGE_FILE_INFO = "FILE_INFO";
    public boolean quitAtSecondEof;
    public boolean quitAtFirstEof;
    public boolean quitIfOneScreen;
    public boolean printLineNumbers;
    public boolean quiet;
    public boolean veryQuiet;
    public boolean chopLongLines;
    public boolean ignoreCaseCond;
    public boolean ignoreCaseAlways;
    public boolean noKeypad;
    public boolean noInit;
    protected List<Integer> tabs;
    protected String syntaxName;
    private String historyLog;
    protected final Terminal terminal;
    protected final Display display;
    protected final BindingReader bindingReader;
    protected final Path currentDir;
    protected List<Source> sources;
    protected int sourceIdx;
    protected BufferedReader reader;
    protected KeyMap<Operation> keys;
    protected int firstLineInMemory;
    protected List<AttributedString> lines;
    protected int firstLineToDisplay;
    protected int firstColumnToDisplay;
    protected int offsetInLine;
    protected String message;
    protected String errorMessage;
    protected final StringBuilder buffer;
    protected final Map<String, Operation> options;
    protected int window;
    protected int halfWindow;
    protected int nbEof;
    protected Nano.PatternHistory patternHistory;
    protected String pattern;
    protected String displayPattern;
    protected final Size size;
    Nano.SyntaxHighlighter syntaxHighlighter;
    private final List<Path> syntaxFiles;
    private boolean highlight;
    private boolean nanorcIgnoreErrors;

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/builtins/Less$Operation.class */
    public enum Operation {
        HELP,
        EXIT,
        FORWARD_ONE_LINE,
        BACKWARD_ONE_LINE,
        FORWARD_ONE_WINDOW_OR_LINES,
        BACKWARD_ONE_WINDOW_OR_LINES,
        FORWARD_ONE_WINDOW_AND_SET,
        BACKWARD_ONE_WINDOW_AND_SET,
        FORWARD_ONE_WINDOW_NO_STOP,
        FORWARD_HALF_WINDOW_AND_SET,
        BACKWARD_HALF_WINDOW_AND_SET,
        LEFT_ONE_HALF_SCREEN,
        RIGHT_ONE_HALF_SCREEN,
        FORWARD_FOREVER,
        REPAINT,
        REPAINT_AND_DISCARD,
        REPEAT_SEARCH_FORWARD,
        REPEAT_SEARCH_BACKWARD,
        REPEAT_SEARCH_FORWARD_SPAN_FILES,
        REPEAT_SEARCH_BACKWARD_SPAN_FILES,
        UNDO_SEARCH,
        GO_TO_FIRST_LINE_OR_N,
        GO_TO_LAST_LINE_OR_N,
        GO_TO_PERCENT_OR_N,
        GO_TO_NEXT_TAG,
        GO_TO_PREVIOUS_TAG,
        FIND_CLOSE_BRACKET,
        FIND_OPEN_BRACKET,
        OPT_PRINT_LINES,
        OPT_CHOP_LONG_LINES,
        OPT_QUIT_AT_FIRST_EOF,
        OPT_QUIT_AT_SECOND_EOF,
        OPT_QUIET,
        OPT_VERY_QUIET,
        OPT_IGNORE_CASE_COND,
        OPT_IGNORE_CASE_ALWAYS,
        OPT_SYNTAX_HIGHLIGHT,
        ADD_FILE,
        NEXT_FILE,
        PREV_FILE,
        GOTO_FILE,
        INFO_FILE,
        DELETE_FILE,
        CHAR,
        INSERT,
        RIGHT,
        LEFT,
        NEXT_WORD,
        PREV_WORD,
        HOME,
        END,
        BACKSPACE,
        DELETE,
        DELETE_WORD,
        DELETE_LINE,
        ACCEPT,
        UP,
        DOWN
    }

    public static String[] usage() {
        return new String[]{"less -  file pager", "Usage: less [OPTIONS] [FILES]", "  -? --help                    Show help", "  -e --quit-at-eof             Exit on second EOF", "  -E --QUIT-AT-EOF             Exit on EOF", "  -F --quit-if-one-screen      Exit if entire file fits on first screen", "  -q --quiet --silent          Silent mode", "  -Q --QUIET --SILENT          Completely silent", "  -S --chop-long-lines         Do not fold long lines", "  -i --ignore-case             Search ignores lowercase case", "  -I --IGNORE-CASE             Search ignores all case", "  -x --tabs=N[,...]            Set tab stops", "  -N --LINE-NUMBERS            Display line number for each line", "  -Y --syntax=name             The name of the syntax highlighting to use.", "     --no-init                 Disable terminal initialization", "     --no-keypad               Disable keypad handling", "     --ignorercfiles           Don't look at the system's lessrc nor at the user's lessrc.", "  -H --historylog=name         Log search strings to file, so they can be retrieved in later sessions"};
    }

    public Less(Terminal terminal, Path currentDir) {
        this(terminal, currentDir, null);
    }

    public Less(Terminal terminal, Path currentDir, Options opts) {
        this(terminal, currentDir, opts, null);
    }

    public Less(Terminal terminal, Path currentDir, Options opts, ConfigurationPath configPath) {
        this.tabs = Collections.singletonList(4);
        this.historyLog = null;
        this.firstLineInMemory = 0;
        this.lines = new ArrayList();
        this.firstLineToDisplay = 0;
        this.firstColumnToDisplay = 0;
        this.offsetInLine = 0;
        this.buffer = new StringBuilder();
        this.options = new TreeMap();
        this.patternHistory = new Nano.PatternHistory(null);
        this.size = new Size();
        this.syntaxFiles = new ArrayList();
        this.highlight = true;
        this.terminal = terminal;
        this.display = new Display(terminal, true);
        this.bindingReader = new BindingReader(terminal.reader());
        this.currentDir = currentDir;
        Path lessrc = configPath != null ? configPath.getConfig("jlessrc") : null;
        boolean ignorercfiles = opts != null && opts.isSet("ignorercfiles");
        if (lessrc != null && !ignorercfiles) {
            try {
                parseConfig(lessrc);
            } catch (IOException e) {
                this.errorMessage = "Encountered error while reading config file: " + lessrc;
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
            if (opts.isSet("QUIT-AT-EOF")) {
                this.quitAtFirstEof = true;
            }
            if (opts.isSet("quit-at-eof")) {
                this.quitAtSecondEof = true;
            }
            if (opts.isSet("quit-if-one-screen")) {
                this.quitIfOneScreen = true;
            }
            if (opts.isSet("quiet")) {
                this.quiet = true;
            }
            if (opts.isSet("QUIET")) {
                this.veryQuiet = true;
            }
            if (opts.isSet("chop-long-lines")) {
                this.chopLongLines = true;
            }
            if (opts.isSet("IGNORE-CASE")) {
                this.ignoreCaseAlways = true;
            }
            if (opts.isSet("ignore-case")) {
                this.ignoreCaseCond = true;
            }
            if (opts.isSet("LINE-NUMBERS")) {
                this.printLineNumbers = true;
            }
            if (opts.isSet("tabs")) {
                doTabs(opts.get("tabs"));
            }
            if (opts.isSet("syntax")) {
                this.syntaxName = opts.get("syntax");
                this.nanorcIgnoreErrors = false;
            }
            if (opts.isSet("no-init")) {
                this.noInit = true;
            }
            if (opts.isSet("no-keypad")) {
                this.noKeypad = true;
            }
            if (opts.isSet("historylog")) {
                this.historyLog = opts.get("historylog");
            }
        }
        if (configPath != null && this.historyLog != null) {
            try {
                this.patternHistory = new Nano.PatternHistory(configPath.getUserConfig(this.historyLog, true));
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
                    List<String> parts = Nano.Parser.split(line2);
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
                        if (option.equals("QUIT-AT-EOF")) {
                            this.quitAtFirstEof = val;
                        } else if (option.equals("quit-at-eof")) {
                            this.quitAtSecondEof = val;
                        } else if (option.equals("quit-if-one-screen")) {
                            this.quitIfOneScreen = val;
                        } else if (option.equals("quiet") || option.equals("silent")) {
                            this.quiet = val;
                        } else if (option.equals("QUIET") || option.equals("SILENT")) {
                            this.veryQuiet = val;
                        } else if (option.equals("chop-long-lines")) {
                            this.chopLongLines = val;
                        } else if (option.equals("IGNORE-CASE")) {
                            this.ignoreCaseAlways = val;
                        } else if (option.equals("ignore-case")) {
                            this.ignoreCaseCond = val;
                        } else if (option.equals("LINE-NUMBERS")) {
                            this.printLineNumbers = val;
                        } else {
                            this.errorMessage = "Less config: Unknown or unsupported configuration option " + option;
                        }
                    } else if (parts.size() == 3 && parts.get(0).equals("set")) {
                        String option2 = parts.get(1);
                        String val2 = parts.get(2);
                        if (option2.equals("tabs")) {
                            doTabs(val2);
                        } else if (option2.equals("historylog")) {
                            this.historyLog = val2;
                        } else {
                            this.errorMessage = "Less config: Unknown or unsupported configuration option " + option2;
                        }
                    } else if (parts.get(0).equals(Tmux.CMD_BIND) || parts.get(0).equals(Tmux.CMD_UNBIND)) {
                        this.errorMessage = "Less config: Key bindings can not be changed!";
                    } else {
                        this.errorMessage = "Less config: Bad configuration '" + line2 + "'";
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

    private void doTabs(String val) {
        this.tabs = new ArrayList();
        String[] split = val.split(",");
        for (String s : split) {
            try {
                this.tabs.add(Integer.valueOf(Integer.parseInt(s)));
            } catch (Exception e) {
                this.errorMessage = "Less config: tabs option error parsing number: " + s;
            }
        }
    }

    public Less tabs(List<Integer> tabs) {
        this.tabs = tabs;
        return this;
    }

    public void handle(Terminal.Signal signal) {
        this.size.copy(this.terminal.getSize());
        try {
            this.display.clear();
            display(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(Source... sources) throws IOException, InterruptedException {
        run(Arrays.asList(sources));
    }

    public void run(List<Source> sources) throws IOException, InterruptedException {
        Operation op;
        if (sources == null || sources.isEmpty()) {
            throw new IllegalArgumentException("No sources");
        }
        sources.add(0, new Source.ResourceSource("less-help.txt", "HELP -- Press SPACE for more, or q when done"));
        this.sources = sources;
        this.sourceIdx = 1;
        openSource();
        if (this.errorMessage != null) {
            this.message = this.errorMessage;
            this.errorMessage = null;
        }
        Status status = Status.getStatus(this.terminal, false);
        if (status != null) {
            try {
                status.suspend();
            } finally {
                if (this.reader != null) {
                    this.reader.close();
                }
                if (status != null) {
                    status.restore();
                }
                this.patternHistory.persist();
            }
        }
        this.size.copy(this.terminal.getSize());
        if (!this.quitIfOneScreen || sources.size() != 2 || !display(true)) {
            Terminal.SignalHandler prevHandler = this.terminal.handle(Terminal.Signal.WINCH, this::handle);
            Attributes attr = this.terminal.enterRawMode();
            this.window = this.size.getRows() - 1;
            this.halfWindow = this.window / 2;
            this.keys = new KeyMap<>();
            bindKeys(this.keys);
            if (!this.noInit) {
                this.terminal.puts(InfoCmp.Capability.enter_ca_mode, new Object[0]);
            }
            try {
                if (!this.noKeypad) {
                    this.terminal.puts(InfoCmp.Capability.keypad_xmit, new Object[0]);
                }
                this.terminal.writer().flush();
                this.display.clear();
                display(false);
                checkInterrupted();
                this.options.put("-e", Operation.OPT_QUIT_AT_SECOND_EOF);
                this.options.put("--quit-at-eof", Operation.OPT_QUIT_AT_SECOND_EOF);
                this.options.put("-E", Operation.OPT_QUIT_AT_FIRST_EOF);
                this.options.put("-QUIT-AT-EOF", Operation.OPT_QUIT_AT_FIRST_EOF);
                this.options.put("-N", Operation.OPT_PRINT_LINES);
                this.options.put("--LINE-NUMBERS", Operation.OPT_PRINT_LINES);
                this.options.put("-q", Operation.OPT_QUIET);
                this.options.put("--quiet", Operation.OPT_QUIET);
                this.options.put("--silent", Operation.OPT_QUIET);
                this.options.put("-Q", Operation.OPT_VERY_QUIET);
                this.options.put("--QUIET", Operation.OPT_VERY_QUIET);
                this.options.put("--SILENT", Operation.OPT_VERY_QUIET);
                this.options.put("-S", Operation.OPT_CHOP_LONG_LINES);
                this.options.put("--chop-long-lines", Operation.OPT_CHOP_LONG_LINES);
                this.options.put("-i", Operation.OPT_IGNORE_CASE_COND);
                this.options.put("--ignore-case", Operation.OPT_IGNORE_CASE_COND);
                this.options.put("-I", Operation.OPT_IGNORE_CASE_ALWAYS);
                this.options.put("--IGNORE-CASE", Operation.OPT_IGNORE_CASE_ALWAYS);
                this.options.put("-Y", Operation.OPT_SYNTAX_HIGHLIGHT);
                this.options.put("--syntax", Operation.OPT_SYNTAX_HIGHLIGHT);
                boolean forward = true;
                do {
                    checkInterrupted();
                    op = null;
                    if (this.buffer.length() > 0 && this.buffer.charAt(0) == '-') {
                        int c = this.terminal.reader().read();
                        this.message = null;
                        if (this.buffer.length() == 1) {
                            this.buffer.append((char) c);
                            if (c != 45) {
                                op = this.options.get(this.buffer.toString());
                                if (op == null) {
                                    this.message = "There is no " + printable(this.buffer.toString()) + " option";
                                    this.buffer.setLength(0);
                                }
                            }
                        } else if (c != 13) {
                            this.buffer.append((char) c);
                            Map<String, Operation> matching = new HashMap<>();
                            for (Map.Entry<String, Operation> entry : this.options.entrySet()) {
                                if (entry.getKey().startsWith(this.buffer.toString())) {
                                    matching.put(entry.getKey(), entry.getValue());
                                }
                            }
                            switch (matching.size()) {
                                case 0:
                                    this.buffer.setLength(0);
                                    break;
                                case 1:
                                    this.buffer.setLength(0);
                                    this.buffer.append(matching.keySet().iterator().next());
                                    break;
                            }
                        } else {
                            op = this.options.get(this.buffer.toString());
                            if (op == null) {
                                this.message = "There is no " + printable(this.buffer.toString()) + " option";
                                this.buffer.setLength(0);
                            }
                        }
                    } else if (this.buffer.length() <= 0 || !(this.buffer.charAt(0) == '/' || this.buffer.charAt(0) == '?' || this.buffer.charAt(0) == '&')) {
                        Operation obj = (Operation) this.bindingReader.readBinding(this.keys, null, false);
                        if (obj == Operation.CHAR) {
                            char c2 = this.bindingReader.getLastBinding().charAt(0);
                            if (c2 == '-' || c2 == '/' || c2 == '?' || c2 == '&') {
                                this.buffer.setLength(0);
                            }
                            this.buffer.append(c2);
                        } else if (obj != Operation.BACKSPACE) {
                            op = obj;
                        } else if (this.buffer.length() > 0) {
                            this.buffer.deleteCharAt(this.buffer.length() - 1);
                        }
                    } else {
                        forward = search();
                    }
                    if (op != null) {
                        this.message = null;
                        switch (op) {
                            case FORWARD_ONE_LINE:
                                moveForward(getStrictPositiveNumberInBuffer(1));
                                break;
                            case BACKWARD_ONE_LINE:
                                moveBackward(getStrictPositiveNumberInBuffer(1));
                                break;
                            case FORWARD_ONE_WINDOW_OR_LINES:
                                moveForward(getStrictPositiveNumberInBuffer(this.window));
                                break;
                            case FORWARD_ONE_WINDOW_AND_SET:
                                this.window = getStrictPositiveNumberInBuffer(this.window);
                                moveForward(this.window);
                                break;
                            case FORWARD_ONE_WINDOW_NO_STOP:
                                moveForward(this.window);
                                break;
                            case FORWARD_HALF_WINDOW_AND_SET:
                                this.halfWindow = getStrictPositiveNumberInBuffer(this.halfWindow);
                                moveForward(this.halfWindow);
                                break;
                            case BACKWARD_ONE_WINDOW_AND_SET:
                                this.window = getStrictPositiveNumberInBuffer(this.window);
                                moveBackward(this.window);
                                break;
                            case BACKWARD_ONE_WINDOW_OR_LINES:
                                moveBackward(getStrictPositiveNumberInBuffer(this.window));
                                break;
                            case BACKWARD_HALF_WINDOW_AND_SET:
                                this.halfWindow = getStrictPositiveNumberInBuffer(this.halfWindow);
                                moveBackward(this.halfWindow);
                                break;
                            case GO_TO_FIRST_LINE_OR_N:
                                moveTo(getStrictPositiveNumberInBuffer(1) - 1);
                                break;
                            case GO_TO_LAST_LINE_OR_N:
                                int lineNum = getStrictPositiveNumberInBuffer(0) - 1;
                                if (lineNum < 0) {
                                    moveForward(Integer.MAX_VALUE);
                                    break;
                                } else {
                                    moveTo(lineNum);
                                    break;
                                }
                            case HOME:
                                moveTo(0);
                                break;
                            case END:
                                moveForward(Integer.MAX_VALUE);
                                break;
                            case LEFT_ONE_HALF_SCREEN:
                                this.firstColumnToDisplay = Math.max(0, this.firstColumnToDisplay - (this.size.getColumns() / 2));
                                break;
                            case RIGHT_ONE_HALF_SCREEN:
                                this.firstColumnToDisplay += this.size.getColumns() / 2;
                                break;
                            case REPEAT_SEARCH_BACKWARD_SPAN_FILES:
                                moveToMatch(!forward, true);
                                break;
                            case REPEAT_SEARCH_BACKWARD:
                                moveToMatch(!forward, false);
                                break;
                            case REPEAT_SEARCH_FORWARD_SPAN_FILES:
                                moveToMatch(forward, true);
                                break;
                            case REPEAT_SEARCH_FORWARD:
                                moveToMatch(forward, false);
                                break;
                            case UNDO_SEARCH:
                                this.pattern = null;
                                break;
                            case OPT_PRINT_LINES:
                                this.buffer.setLength(0);
                                this.printLineNumbers = !this.printLineNumbers;
                                this.message = this.printLineNumbers ? "Constantly display line numbers" : "Don't use line numbers";
                                break;
                            case OPT_QUIET:
                                this.buffer.setLength(0);
                                this.quiet = !this.quiet;
                                this.veryQuiet = false;
                                this.message = this.quiet ? "Ring the bell for errors but not at eof/bof" : "Ring the bell for errors AND at eof/bof";
                                break;
                            case OPT_VERY_QUIET:
                                this.buffer.setLength(0);
                                this.veryQuiet = !this.veryQuiet;
                                this.quiet = false;
                                this.message = this.veryQuiet ? "Never ring the bell" : "Ring the bell for errors AND at eof/bof";
                                break;
                            case OPT_CHOP_LONG_LINES:
                                this.buffer.setLength(0);
                                this.offsetInLine = 0;
                                this.chopLongLines = !this.chopLongLines;
                                this.message = this.chopLongLines ? "Chop long lines" : "Fold long lines";
                                this.display.clear();
                                break;
                            case OPT_IGNORE_CASE_COND:
                                this.ignoreCaseCond = !this.ignoreCaseCond;
                                this.ignoreCaseAlways = false;
                                this.message = this.ignoreCaseCond ? "Ignore case in searches" : "Case is significant in searches";
                                break;
                            case OPT_IGNORE_CASE_ALWAYS:
                                this.ignoreCaseAlways = !this.ignoreCaseAlways;
                                this.ignoreCaseCond = false;
                                this.message = this.ignoreCaseAlways ? "Ignore case in searches and in patterns" : "Case is significant in searches";
                                break;
                            case OPT_SYNTAX_HIGHLIGHT:
                                this.highlight = !this.highlight;
                                this.message = "Highlight " + (this.highlight ? "enabled" : "disabled");
                                break;
                            case ADD_FILE:
                                addFile();
                                break;
                            case NEXT_FILE:
                                int next = getStrictPositiveNumberInBuffer(1);
                                if (this.sourceIdx < sources.size() - next) {
                                    SavedSourcePositions ssp = new SavedSourcePositions(this);
                                    this.sourceIdx += next;
                                    String newSource = sources.get(this.sourceIdx).getName();
                                    try {
                                        openSource();
                                    } catch (FileNotFoundException e) {
                                        ssp.restore(newSource);
                                    }
                                    break;
                                } else {
                                    this.message = "No next file";
                                    break;
                                }
                            case PREV_FILE:
                                int prev = getStrictPositiveNumberInBuffer(1);
                                if (this.sourceIdx > prev) {
                                    SavedSourcePositions ssp2 = new SavedSourcePositions(-1);
                                    this.sourceIdx -= prev;
                                    String newSource2 = sources.get(this.sourceIdx).getName();
                                    try {
                                        openSource();
                                    } catch (FileNotFoundException e2) {
                                        ssp2.restore(newSource2);
                                    }
                                    break;
                                } else {
                                    this.message = "No previous file";
                                    break;
                                }
                            case GOTO_FILE:
                                int tofile = getStrictPositiveNumberInBuffer(1);
                                if (tofile < sources.size()) {
                                    SavedSourcePositions ssp3 = new SavedSourcePositions(tofile < this.sourceIdx ? -1 : 0);
                                    this.sourceIdx = tofile;
                                    String newSource3 = sources.get(this.sourceIdx).getName();
                                    try {
                                        openSource();
                                    } catch (FileNotFoundException e3) {
                                        ssp3.restore(newSource3);
                                    }
                                    break;
                                } else {
                                    this.message = "No such file";
                                    break;
                                }
                            case INFO_FILE:
                                this.message = MESSAGE_FILE_INFO;
                                break;
                            case DELETE_FILE:
                                if (sources.size() > 2) {
                                    sources.remove(this.sourceIdx);
                                    if (this.sourceIdx >= sources.size()) {
                                        this.sourceIdx = sources.size() - 1;
                                    }
                                    openSource();
                                    break;
                                }
                                break;
                            case REPAINT:
                                this.size.copy(this.terminal.getSize());
                                this.display.clear();
                                break;
                            case REPAINT_AND_DISCARD:
                                this.message = null;
                                this.size.copy(this.terminal.getSize());
                                this.display.clear();
                                break;
                            case HELP:
                                help();
                                break;
                        }
                        this.buffer.setLength(0);
                    }
                    if ((this.quitAtFirstEof && this.nbEof > 0) || (this.quitAtSecondEof && this.nbEof > 1)) {
                        if (this.sourceIdx < sources.size() - 1) {
                            this.sourceIdx++;
                            openSource();
                        } else {
                            op = Operation.EXIT;
                        }
                    }
                    display(false);
                } while (op != Operation.EXIT);
                this.terminal.setAttributes(attr);
                if (prevHandler != null) {
                    this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
                }
                if (!this.noInit) {
                    this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0]);
                }
                if (!this.noKeypad) {
                    this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                }
                this.terminal.writer().flush();
            } catch (InterruptedException e4) {
                this.terminal.setAttributes(attr);
                if (prevHandler != null) {
                    this.terminal.handle(Terminal.Signal.WINCH, prevHandler);
                }
                if (!this.noInit) {
                    this.terminal.puts(InfoCmp.Capability.exit_ca_mode, new Object[0]);
                }
                if (!this.noKeypad) {
                    this.terminal.puts(InfoCmp.Capability.keypad_local, new Object[0]);
                }
                this.terminal.writer().flush();
            }
            if (this.reader != null) {
                this.reader.close();
            }
            if (status != null) {
                status.restore();
            }
            this.patternHistory.persist();
        }
    }

    private void moveToMatch(boolean forward, boolean spanFiles) throws IOException {
        if (forward) {
            moveToNextMatch(spanFiles);
        } else {
            moveToPreviousMatch(spanFiles);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Less$LineEditor.class */
    public class LineEditor {
        private final int begPos;

        public LineEditor(int begPos) {
            this.begPos = begPos;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public int editBuffer(Operation op, int curPos) {
            switch (op) {
                case HOME:
                    curPos = this.begPos;
                    break;
                case END:
                    curPos = Less.this.buffer.length();
                    break;
                case INSERT:
                    curPos++;
                    Less.this.buffer.insert(curPos, Less.this.bindingReader.getLastBinding());
                    break;
                case BACKSPACE:
                    if (curPos > this.begPos - 1) {
                        curPos--;
                        Less.this.buffer.deleteCharAt(curPos);
                        break;
                    }
                    break;
                case NEXT_WORD:
                    int newPos = Less.this.buffer.length();
                    int i = curPos;
                    while (true) {
                        if (i < Less.this.buffer.length()) {
                            if (Less.this.buffer.charAt(i) == ' ') {
                                newPos = i + 1;
                            } else {
                                i++;
                            }
                        }
                    }
                    curPos = newPos;
                    break;
                case PREV_WORD:
                    int newPos2 = this.begPos;
                    int i2 = curPos - 2;
                    while (true) {
                        if (i2 > this.begPos) {
                            if (Less.this.buffer.charAt(i2) == ' ') {
                                newPos2 = i2 + 1;
                            } else {
                                i2--;
                            }
                        }
                    }
                    curPos = newPos2;
                    break;
                case DELETE:
                    if (curPos >= this.begPos && curPos < Less.this.buffer.length()) {
                        Less.this.buffer.deleteCharAt(curPos);
                        break;
                    }
                    break;
                case DELETE_WORD:
                    while (curPos < Less.this.buffer.length() && Less.this.buffer.charAt(curPos) != ' ') {
                        Less.this.buffer.deleteCharAt(curPos);
                    }
                    while (true) {
                        if (curPos - 1 >= this.begPos) {
                            if (Less.this.buffer.charAt(curPos - 1) == ' ') {
                                curPos--;
                                Less.this.buffer.deleteCharAt(curPos);
                                break;
                            } else {
                                curPos--;
                                Less.this.buffer.deleteCharAt(curPos);
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                case DELETE_LINE:
                    Less.this.buffer.setLength(this.begPos);
                    curPos = 1;
                    break;
                case LEFT:
                    if (curPos > this.begPos) {
                        curPos--;
                        break;
                    }
                    break;
                case RIGHT:
                    if (curPos < Less.this.buffer.length()) {
                        curPos++;
                        break;
                    }
                    break;
            }
            return curPos;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Less$SavedSourcePositions.class */
    public class SavedSourcePositions {
        int saveSourceIdx;
        int saveFirstLineToDisplay;
        int saveFirstColumnToDisplay;
        int saveOffsetInLine;
        boolean savePrintLineNumbers;

        public SavedSourcePositions(Less less) {
            this(0);
        }

        public SavedSourcePositions(int dec) {
            this.saveSourceIdx = Less.this.sourceIdx + dec;
            this.saveFirstLineToDisplay = Less.this.firstLineToDisplay;
            this.saveFirstColumnToDisplay = Less.this.firstColumnToDisplay;
            this.saveOffsetInLine = Less.this.offsetInLine;
            this.savePrintLineNumbers = Less.this.printLineNumbers;
        }

        public void restore(String failingSource) throws IOException {
            Less.this.sourceIdx = this.saveSourceIdx;
            Less.this.openSource();
            Less.this.firstLineToDisplay = this.saveFirstLineToDisplay;
            Less.this.firstColumnToDisplay = this.saveFirstColumnToDisplay;
            Less.this.offsetInLine = this.saveOffsetInLine;
            Less.this.printLineNumbers = this.savePrintLineNumbers;
            if (failingSource != null) {
                Less.this.message = failingSource + " not found!";
            }
        }
    }

    private void addSource(String file) throws IOException {
        if (file.contains("*") || file.contains("?")) {
            for (Path p : Commands.findFiles(this.currentDir, file)) {
                this.sources.add(new Source.URLSource(p.toUri().toURL(), p.toString()));
            }
        } else {
            this.sources.add(new Source.URLSource(this.currentDir.resolve(file).toUri().toURL(), file));
        }
        this.sourceIdx = this.sources.size() - 1;
    }

    private void addFile() throws IOException, InterruptedException {
        KeyMap<Operation> fileKeyMap = new KeyMap<>();
        fileKeyMap.setUnicode(Operation.INSERT);
        for (char i = ' '; i < 256; i = (char) (i + 1)) {
            fileKeyMap.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
        }
        fileKeyMap.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right), KeyMap.alt('l'));
        fileKeyMap.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left), KeyMap.alt('h'));
        fileKeyMap.bind((KeyMap<Operation>) Operation.HOME, KeyMap.key(this.terminal, InfoCmp.Capability.key_home), KeyMap.alt('0'));
        fileKeyMap.bind((KeyMap<Operation>) Operation.END, KeyMap.key(this.terminal, InfoCmp.Capability.key_end), KeyMap.alt('$'));
        fileKeyMap.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
        fileKeyMap.bind((KeyMap<Operation>) Operation.DELETE, KeyMap.alt('x'));
        fileKeyMap.bind((KeyMap<Operation>) Operation.DELETE_WORD, KeyMap.alt('X'));
        fileKeyMap.bind((KeyMap<Operation>) Operation.DELETE_LINE, KeyMap.ctrl('U'));
        fileKeyMap.bind((KeyMap<Operation>) Operation.ACCEPT, "\r");
        SavedSourcePositions ssp = new SavedSourcePositions(this);
        this.message = null;
        this.buffer.append("Examine: ");
        int curPos = this.buffer.length();
        display(false, Integer.valueOf(curPos));
        LineEditor lineEditor = new LineEditor(curPos);
        while (true) {
            checkInterrupted();
            int[] iArr = C58301.$SwitchMap$org$jline$builtins$Less$Operation;
            Operation op = (Operation) this.bindingReader.readBinding(fileKeyMap);
            switch (iArr[op.ordinal()]) {
                case 46:
                    String name = this.buffer.substring(curPos);
                    addSource(name);
                    try {
                        openSource();
                        return;
                    } catch (Exception e) {
                        ssp.restore(name);
                        return;
                    }
                default:
                    curPos = lineEditor.editBuffer(op, curPos);
                    if (curPos > curPos) {
                        display(false, Integer.valueOf(curPos));
                    } else {
                        this.buffer.setLength(0);
                        return;
                    }
            }
        }
    }

    private boolean search() throws IOException, InterruptedException {
        KeyMap<Operation> searchKeyMap = new KeyMap<>();
        searchKeyMap.setUnicode(Operation.INSERT);
        for (char i = ' '; i < 256; i = (char) (i + 1)) {
            searchKeyMap.bind((KeyMap<Operation>) Operation.INSERT, Character.toString(i));
        }
        searchKeyMap.bind((KeyMap<Operation>) Operation.RIGHT, KeyMap.key(this.terminal, InfoCmp.Capability.key_right), KeyMap.alt('l'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.LEFT, KeyMap.key(this.terminal, InfoCmp.Capability.key_left), KeyMap.alt('h'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.NEXT_WORD, KeyMap.alt('w'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.PREV_WORD, KeyMap.alt('b'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.HOME, KeyMap.key(this.terminal, InfoCmp.Capability.key_home), KeyMap.alt('0'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.END, KeyMap.key(this.terminal, InfoCmp.Capability.key_end), KeyMap.alt('$'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
        searchKeyMap.bind((KeyMap<Operation>) Operation.DELETE, KeyMap.alt('x'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.DELETE_WORD, KeyMap.alt('X'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.DELETE_LINE, KeyMap.ctrl('U'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.UP, KeyMap.key(this.terminal, InfoCmp.Capability.key_up), KeyMap.alt('k'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.DOWN, KeyMap.key(this.terminal, InfoCmp.Capability.key_down), KeyMap.alt('j'));
        searchKeyMap.bind((KeyMap<Operation>) Operation.ACCEPT, "\r");
        boolean forward = true;
        this.message = null;
        int curPos = this.buffer.length();
        char type = this.buffer.charAt(0);
        String currentBuffer = this.buffer.toString();
        LineEditor lineEditor = new LineEditor(curPos);
        while (true) {
            checkInterrupted();
            int[] iArr = C58301.$SwitchMap$org$jline$builtins$Less$Operation;
            Operation op = (Operation) this.bindingReader.readBinding(searchKeyMap);
            switch (iArr[op.ordinal()]) {
                case 46:
                    try {
                        String _pattern = this.buffer.substring(1);
                        if (type == '&') {
                            this.displayPattern = _pattern.length() > 0 ? _pattern : null;
                            getPattern(true);
                        } else {
                            this.pattern = _pattern;
                            getPattern();
                            if (type == '/') {
                                moveToNextMatch();
                            } else {
                                if (this.lines.size() - this.firstLineToDisplay <= this.size.getRows()) {
                                    this.firstLineToDisplay = this.lines.size();
                                } else {
                                    moveForward(this.size.getRows() - 1);
                                }
                                moveToPreviousMatch();
                                forward = false;
                            }
                        }
                        this.patternHistory.add(_pattern);
                        this.buffer.setLength(0);
                    } catch (PatternSyntaxException e) {
                        String str = e.getMessage();
                        if (str.indexOf(10) > 0) {
                            str = str.substring(0, str.indexOf(10));
                        }
                        if (type == '&') {
                            this.displayPattern = null;
                        } else {
                            this.pattern = null;
                        }
                        this.buffer.setLength(0);
                        this.message = "Invalid pattern: " + str + " (Press a key)";
                        display(false);
                        this.terminal.reader().read();
                        this.message = null;
                    }
                    return forward;
                case 47:
                    this.buffer.setLength(0);
                    this.buffer.append(type);
                    this.buffer.append(this.patternHistory.m30up(currentBuffer.substring(1)));
                    curPos = this.buffer.length();
                    break;
                case 48:
                    this.buffer.setLength(0);
                    this.buffer.append(type);
                    this.buffer.append(this.patternHistory.down(currentBuffer.substring(1)));
                    curPos = this.buffer.length();
                    break;
                default:
                    curPos = lineEditor.editBuffer(op, curPos);
                    currentBuffer = this.buffer.toString();
                    break;
            }
            if (curPos < curPos) {
                this.buffer.setLength(0);
                return true;
            }
            display(false, Integer.valueOf(curPos));
        }
    }

    private void help() throws IOException {
        Operation op;
        SavedSourcePositions ssp = new SavedSourcePositions(this);
        this.printLineNumbers = false;
        this.sourceIdx = 0;
        try {
            openSource();
            display(false);
            do {
                checkInterrupted();
                op = (Operation) this.bindingReader.readBinding(this.keys, null, false);
                if (op != null) {
                    switch (op) {
                        case FORWARD_ONE_WINDOW_OR_LINES:
                            moveForward(getStrictPositiveNumberInBuffer(this.window));
                            break;
                        case BACKWARD_ONE_WINDOW_OR_LINES:
                            moveBackward(getStrictPositiveNumberInBuffer(this.window));
                            break;
                    }
                }
                display(false);
            } while (op != Operation.EXIT);
        } catch (IOException | InterruptedException e) {
        } finally {
            ssp.restore(null);
        }
    }

    protected void openSource() throws IOException {
        boolean open;
        boolean wasOpen = false;
        if (this.reader != null) {
            this.reader.close();
            wasOpen = true;
        }
        boolean displayMessage = false;
        do {
            Source source = this.sources.get(this.sourceIdx);
            try {
                InputStream in = source.read();
                if (this.sources.size() == 2 || this.sourceIdx == 0) {
                    this.message = source.getName();
                } else {
                    this.message = source.getName() + " (file " + this.sourceIdx + " of " + (this.sources.size() - 1) + ")";
                }
                this.reader = new BufferedReader(new InputStreamReader(new InterruptibleInputStream(in)));
                this.firstLineInMemory = 0;
                this.lines = new ArrayList();
                this.firstLineToDisplay = 0;
                this.firstColumnToDisplay = 0;
                this.offsetInLine = 0;
                this.display.clear();
                if (this.sourceIdx == 0) {
                    this.syntaxHighlighter = Nano.SyntaxHighlighter.build(this.syntaxFiles, null, "none");
                } else {
                    this.syntaxHighlighter = Nano.SyntaxHighlighter.build(this.syntaxFiles, source.getName(), this.syntaxName, this.nanorcIgnoreErrors);
                }
                open = true;
                if (displayMessage) {
                    AttributedStringBuilder asb = new AttributedStringBuilder();
                    asb.style(AttributedStyle.INVERSE);
                    asb.append((CharSequence) (source.getName() + " (press RETURN)"));
                    asb.toAttributedString().println(this.terminal);
                    this.terminal.writer().flush();
                    this.terminal.reader().read();
                }
            } catch (FileNotFoundException exp) {
                this.sources.remove(this.sourceIdx);
                if (this.sourceIdx > this.sources.size() - 1) {
                    this.sourceIdx = this.sources.size() - 1;
                }
                if (wasOpen) {
                    throw exp;
                }
                AttributedStringBuilder asb2 = new AttributedStringBuilder();
                asb2.append((CharSequence) (source.getName() + " not found!"));
                asb2.toAttributedString().println(this.terminal);
                this.terminal.writer().flush();
                open = false;
                displayMessage = true;
            }
            if (open) {
                break;
            }
        } while (this.sourceIdx > 0);
        if (!open) {
            throw new FileNotFoundException();
        }
    }

    void moveTo(int lineNum) throws IOException {
        if (getLine(lineNum) != null) {
            this.display.clear();
            if (this.firstLineInMemory > lineNum) {
                openSource();
            }
            this.firstLineToDisplay = lineNum;
            this.offsetInLine = 0;
            return;
        }
        this.message = "Cannot seek to line number " + (lineNum + 1);
    }

    private void moveToNextMatch() throws IOException {
        moveToNextMatch(false);
    }

    private void moveToNextMatch(boolean spanFiles) throws IOException {
        Pattern compiled = getPattern();
        Pattern dpCompiled = getPattern(true);
        if (compiled != null) {
            int lineNumber = this.firstLineToDisplay + 1;
            while (true) {
                AttributedString line = getLine(lineNumber);
                if (line == null) {
                    break;
                } else if (toBeDisplayed(line, dpCompiled) && compiled.matcher(line).find()) {
                    this.display.clear();
                    this.firstLineToDisplay = lineNumber;
                    this.offsetInLine = 0;
                    return;
                } else {
                    lineNumber++;
                }
            }
        }
        if (!spanFiles) {
            this.message = "Pattern not found";
        } else if (this.sourceIdx < this.sources.size() - 1) {
            SavedSourcePositions ssp = new SavedSourcePositions(this);
            List<Source> list = this.sources;
            int i = this.sourceIdx + 1;
            this.sourceIdx = i;
            String newSource = list.get(i).getName();
            try {
                openSource();
                moveToNextMatch(true);
            } catch (FileNotFoundException e) {
                ssp.restore(newSource);
            }
        } else {
            this.message = "Pattern not found";
        }
    }

    private void moveToPreviousMatch() throws IOException {
        moveToPreviousMatch(false);
    }

    private void moveToPreviousMatch(boolean spanFiles) throws IOException {
        AttributedString line;
        Pattern compiled = getPattern();
        Pattern dpCompiled = getPattern(true);
        if (compiled != null) {
            int lineNumber = this.firstLineToDisplay - 1;
            while (lineNumber >= this.firstLineInMemory && (line = getLine(lineNumber)) != null) {
                if (toBeDisplayed(line, dpCompiled) && compiled.matcher(line).find()) {
                    this.display.clear();
                    this.firstLineToDisplay = lineNumber;
                    this.offsetInLine = 0;
                    return;
                }
                lineNumber--;
            }
        }
        if (!spanFiles) {
            this.message = "Pattern not found";
        } else if (this.sourceIdx > 1) {
            SavedSourcePositions ssp = new SavedSourcePositions(-1);
            List<Source> list = this.sources;
            int i = this.sourceIdx - 1;
            this.sourceIdx = i;
            String newSource = list.get(i).getName();
            try {
                openSource();
                this.firstLineToDisplay = (int) this.sources.get(this.sourceIdx).lines().longValue();
                moveToPreviousMatch(true);
            } catch (FileNotFoundException e) {
                ssp.restore(newSource);
            }
        } else {
            this.message = "Pattern not found";
        }
    }

    private String printable(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 27) {
                sb.append("ESC");
            } else if (c < ' ') {
                sb.append('^').append((char) (c + '@'));
            } else if (c < 128) {
                sb.append(c);
            } else {
                sb.append('\\').append(String.format("%03o", Integer.valueOf(c)));
            }
        }
        return sb.toString();
    }

    void moveForward(int lines) throws IOException {
        Long allLines;
        Pattern dpCompiled = getPattern(true);
        int width = this.size.getColumns() - (this.printLineNumbers ? 8 : 0);
        int height = this.size.getRows();
        boolean doOffsets = this.firstColumnToDisplay == 0 && !this.chopLongLines;
        if (lines >= this.size.getRows() - 1) {
            this.display.clear();
        }
        if (lines == Integer.MAX_VALUE && (allLines = this.sources.get(this.sourceIdx).lines()) != null) {
            this.firstLineToDisplay = (int) allLines.longValue();
            for (int l = 0; l < height - 1; l++) {
                this.firstLineToDisplay = prevLine2display(this.firstLineToDisplay, dpCompiled).getU().intValue();
            }
        }
        while (true) {
            lines--;
            if (lines >= 0) {
                int lastLineToDisplay = this.firstLineToDisplay;
                if (!doOffsets) {
                    for (int l2 = 0; l2 < height - 1; l2++) {
                        lastLineToDisplay = nextLine2display(lastLineToDisplay, dpCompiled).getU().intValue();
                    }
                } else {
                    int off = this.offsetInLine;
                    int l3 = 0;
                    while (true) {
                        if (l3 >= height - 1) {
                            break;
                        }
                        Pair<Integer, AttributedString> nextLine = nextLine2display(lastLineToDisplay, dpCompiled);
                        AttributedString line = nextLine.getV();
                        if (line == null) {
                            lastLineToDisplay = nextLine.getU().intValue();
                            break;
                        }
                        if (line.columnLength() > off + width) {
                            off += width;
                        } else {
                            off = 0;
                            lastLineToDisplay = nextLine.getU().intValue();
                        }
                        l3++;
                    }
                }
                if (getLine(lastLineToDisplay) == null) {
                    eof();
                    return;
                }
                Pair<Integer, AttributedString> nextLine2 = nextLine2display(this.firstLineToDisplay, dpCompiled);
                AttributedString line2 = nextLine2.getV();
                if (!doOffsets || line2.columnLength() <= width + this.offsetInLine) {
                    this.offsetInLine = 0;
                    this.firstLineToDisplay = nextLine2.getU().intValue();
                } else {
                    this.offsetInLine += width;
                }
            } else {
                return;
            }
        }
    }

    void moveBackward(int lines) throws IOException {
        Pattern dpCompiled = getPattern(true);
        int width = this.size.getColumns() - (this.printLineNumbers ? 8 : 0);
        if (lines >= this.size.getRows() - 1) {
            this.display.clear();
        }
        while (true) {
            lines--;
            if (lines < 0) {
                return;
            }
            if (this.offsetInLine > 0) {
                this.offsetInLine = Math.max(0, this.offsetInLine - width);
            } else if (this.firstLineInMemory < this.firstLineToDisplay) {
                Pair<Integer, AttributedString> prevLine = prevLine2display(this.firstLineToDisplay, dpCompiled);
                this.firstLineToDisplay = prevLine.getU().intValue();
                AttributedString line = prevLine.getV();
                if (line != null && this.firstColumnToDisplay == 0 && !this.chopLongLines) {
                    int length = line.columnLength();
                    this.offsetInLine = length - (length % width);
                }
            } else {
                bof();
                return;
            }
        }
    }

    private void eof() {
        this.nbEof++;
        if (this.sourceIdx <= 0 || this.sourceIdx >= this.sources.size() - 1) {
            this.message = "(END)";
        } else {
            this.message = "(END) - Next: " + this.sources.get(this.sourceIdx + 1).getName();
        }
        if (!this.quiet && !this.veryQuiet && !this.quitAtFirstEof && !this.quitAtSecondEof) {
            this.terminal.puts(InfoCmp.Capability.bell, new Object[0]);
            this.terminal.writer().flush();
        }
    }

    private void bof() {
        if (!this.quiet && !this.veryQuiet) {
            this.terminal.puts(InfoCmp.Capability.bell, new Object[0]);
            this.terminal.writer().flush();
        }
    }

    int getStrictPositiveNumberInBuffer(int def) {
        try {
            int n = Integer.parseInt(this.buffer.toString());
            int i = n > 0 ? n : def;
            this.buffer.setLength(0);
            return i;
        } catch (NumberFormatException e) {
            this.buffer.setLength(0);
            return def;
        } catch (Throwable th) {
            this.buffer.setLength(0);
            throw th;
        }
    }

    private Pair<Integer, AttributedString> nextLine2display(int line, Pattern dpCompiled) throws IOException {
        AttributedString curLine;
        do {
            line++;
            curLine = getLine(line);
        } while (!toBeDisplayed(curLine, dpCompiled));
        return new Pair<>(Integer.valueOf(line), curLine);
    }

    private Pair<Integer, AttributedString> prevLine2display(int line, Pattern dpCompiled) throws IOException {
        AttributedString curLine;
        do {
            line--;
            curLine = getLine(line);
            if (line <= 0) {
                break;
            }
        } while (!toBeDisplayed(curLine, dpCompiled));
        if (line == 0 && !toBeDisplayed(curLine, dpCompiled)) {
            curLine = null;
        }
        return new Pair<>(Integer.valueOf(line), curLine);
    }

    private boolean toBeDisplayed(AttributedString curLine, Pattern dpCompiled) {
        return curLine == null || dpCompiled == null || this.sourceIdx == 0 || dpCompiled.matcher(curLine).find();
    }

    synchronized boolean display(boolean oneScreen) throws IOException {
        return display(oneScreen, null);
    }

    synchronized boolean display(boolean oneScreen, Integer curPos) throws IOException {
        AttributedString toDisplay;
        List<AttributedString> newLines = new ArrayList<>();
        int width = this.size.getColumns() - (this.printLineNumbers ? 8 : 0);
        int height = this.size.getRows();
        int inputLine = this.firstLineToDisplay;
        AttributedString curLine = null;
        Pattern compiled = getPattern();
        Pattern dpCompiled = getPattern(true);
        boolean fitOnOneScreen = false;
        boolean eof = false;
        this.syntaxHighlighter.reset();
        int terminalLine = 0;
        while (true) {
            if (terminalLine >= height - 1) {
                break;
            }
            if (curLine == null) {
                Pair<Integer, AttributedString> nextLine = nextLine2display(inputLine, dpCompiled);
                inputLine = nextLine.getU().intValue();
                curLine = nextLine.getV();
                if (curLine == null) {
                    if (oneScreen) {
                        fitOnOneScreen = true;
                        break;
                    }
                    eof = true;
                    curLine = new AttributedString("~");
                } else if (this.highlight) {
                    curLine = this.syntaxHighlighter.highlight(curLine);
                }
                if (compiled != null) {
                    curLine = curLine.styleMatches(compiled, AttributedStyle.DEFAULT.inverse());
                }
            }
            if (this.firstColumnToDisplay > 0 || this.chopLongLines) {
                int off = this.firstColumnToDisplay;
                if (terminalLine == 0 && this.offsetInLine > 0) {
                    off = Math.max(this.offsetInLine, off);
                }
                toDisplay = curLine.columnSubSequence(off, off + width);
                curLine = null;
            } else {
                if (terminalLine == 0 && this.offsetInLine > 0) {
                    curLine = curLine.columnSubSequence(this.offsetInLine, Integer.MAX_VALUE);
                }
                toDisplay = curLine.columnSubSequence(0, width);
                curLine = curLine.columnSubSequence(width, Integer.MAX_VALUE);
                if (curLine.length() == 0) {
                    curLine = null;
                }
            }
            if (!this.printLineNumbers || eof) {
                newLines.add(toDisplay);
            } else {
                AttributedStringBuilder sb = new AttributedStringBuilder();
                sb.append((CharSequence) String.format("%7d ", Integer.valueOf(inputLine)));
                sb.append(toDisplay);
                newLines.add(sb.toAttributedString());
            }
            terminalLine++;
        }
        if (oneScreen) {
            if (fitOnOneScreen) {
                newLines.forEach(l -> {
                    l.println(this.terminal);
                });
            }
            return fitOnOneScreen;
        }
        AttributedStringBuilder msg = new AttributedStringBuilder();
        if (MESSAGE_FILE_INFO.equals(this.message)) {
            Source source = this.sources.get(this.sourceIdx);
            Long allLines = source.lines();
            this.message = source.getName() + (this.sources.size() > 2 ? " (file " + this.sourceIdx + " of " + (this.sources.size() - 1) + ")" : "") + " lines " + (this.firstLineToDisplay + 1) + "-" + inputLine + "/" + (allLines != null ? allLines.longValue() : (long) this.lines.size()) + (eof ? " (END)" : "");
        }
        if (this.buffer.length() > 0) {
            msg.append((CharSequence) " ").append((CharSequence) this.buffer);
        } else if (this.bindingReader.getCurrentBuffer().length() > 0 && this.terminal.reader().peek(1) == -2) {
            msg.append((CharSequence) " ").append((CharSequence) printable(this.bindingReader.getCurrentBuffer()));
        } else if (this.message != null) {
            msg.style(AttributedStyle.INVERSE);
            msg.append((CharSequence) this.message);
            msg.style(AttributedStyle.INVERSE.inverseOff());
        } else if (this.displayPattern != null) {
            msg.append((CharSequence) "&");
        } else {
            msg.append((CharSequence) EmitterKt.COMMENT_PREFIX);
        }
        newLines.add(msg.toAttributedString());
        this.display.resize(this.size.getRows(), this.size.getColumns());
        if (curPos == null) {
            this.display.update(newLines, -1);
            return false;
        }
        this.display.update(newLines, this.size.cursorPos(this.size.getRows() - 1, curPos.intValue() + 1));
        return false;
    }

    private Pattern getPattern() {
        return getPattern(false);
    }

    private Pattern getPattern(boolean doDisplayPattern) {
        Pattern compiled = null;
        String _pattern = doDisplayPattern ? this.displayPattern : this.pattern;
        if (_pattern != null) {
            compiled = Pattern.compile("(" + _pattern + ")", this.ignoreCaseAlways || (this.ignoreCaseCond && _pattern.toLowerCase().equals(_pattern)) ? 66 : 0);
        }
        return compiled;
    }

    AttributedString getLine(int line) throws IOException {
        String str;
        while (line >= this.lines.size() && (str = this.reader.readLine()) != null) {
            this.lines.add(AttributedString.fromAnsi(str, this.tabs));
        }
        if (line < this.lines.size()) {
            return this.lines.get(line);
        }
        return null;
    }

    public static void checkInterrupted() throws InterruptedException {
        Thread.yield();
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
    }

    private void bindKeys(KeyMap<Operation> map) {
        map.bind((KeyMap<Operation>) Operation.HELP, "h", "H");
        map.bind((KeyMap<Operation>) Operation.EXIT, "q", ":q", "Q", ":Q", "ZZ");
        map.bind((KeyMap<Operation>) Operation.FORWARD_ONE_LINE, "e", KeyMap.ctrl('E'), "j", KeyMap.ctrl('N'), "\r", KeyMap.key(this.terminal, InfoCmp.Capability.key_down));
        map.bind((KeyMap<Operation>) Operation.BACKWARD_ONE_LINE, "y", KeyMap.ctrl('Y'), "k", KeyMap.ctrl('K'), KeyMap.ctrl('P'), KeyMap.key(this.terminal, InfoCmp.Capability.key_up));
        map.bind((KeyMap<Operation>) Operation.FORWARD_ONE_WINDOW_OR_LINES, "f", KeyMap.ctrl('F'), KeyMap.ctrl('V'), " ", KeyMap.key(this.terminal, InfoCmp.Capability.key_npage));
        map.bind((KeyMap<Operation>) Operation.BACKWARD_ONE_WINDOW_OR_LINES, "b", KeyMap.ctrl('B'), KeyMap.alt('v'), KeyMap.key(this.terminal, InfoCmp.Capability.key_ppage));
        map.bind((KeyMap<Operation>) Operation.FORWARD_ONE_WINDOW_AND_SET, "z");
        map.bind((KeyMap<Operation>) Operation.BACKWARD_ONE_WINDOW_AND_SET, "w");
        map.bind((KeyMap<Operation>) Operation.FORWARD_ONE_WINDOW_NO_STOP, KeyMap.alt(' '));
        map.bind((KeyMap<Operation>) Operation.FORWARD_HALF_WINDOW_AND_SET, DateTokenConverter.CONVERTER_KEY, KeyMap.ctrl('D'));
        map.bind((KeyMap<Operation>) Operation.BACKWARD_HALF_WINDOW_AND_SET, "u", KeyMap.ctrl('U'));
        map.bind((KeyMap<Operation>) Operation.RIGHT_ONE_HALF_SCREEN, KeyMap.alt(')'), KeyMap.key(this.terminal, InfoCmp.Capability.key_right));
        map.bind((KeyMap<Operation>) Operation.LEFT_ONE_HALF_SCREEN, KeyMap.alt('('), KeyMap.key(this.terminal, InfoCmp.Capability.key_left));
        map.bind((KeyMap<Operation>) Operation.FORWARD_FOREVER, "F");
        map.bind((KeyMap<Operation>) Operation.REPAINT, "r", KeyMap.ctrl('R'), KeyMap.ctrl('L'));
        map.bind((KeyMap<Operation>) Operation.REPAINT_AND_DISCARD, "R");
        map.bind((KeyMap<Operation>) Operation.REPEAT_SEARCH_FORWARD, "n");
        map.bind((KeyMap<Operation>) Operation.REPEAT_SEARCH_BACKWARD, "N");
        map.bind((KeyMap<Operation>) Operation.REPEAT_SEARCH_FORWARD_SPAN_FILES, KeyMap.alt('n'));
        map.bind((KeyMap<Operation>) Operation.REPEAT_SEARCH_BACKWARD_SPAN_FILES, KeyMap.alt('N'));
        map.bind((KeyMap<Operation>) Operation.UNDO_SEARCH, KeyMap.alt('u'));
        map.bind((KeyMap<Operation>) Operation.GO_TO_FIRST_LINE_OR_N, "g", "<", KeyMap.alt('<'));
        map.bind((KeyMap<Operation>) Operation.GO_TO_LAST_LINE_OR_N, "G", ">", KeyMap.alt('>'));
        map.bind((KeyMap<Operation>) Operation.HOME, KeyMap.key(this.terminal, InfoCmp.Capability.key_home));
        map.bind((KeyMap<Operation>) Operation.END, KeyMap.key(this.terminal, InfoCmp.Capability.key_end));
        map.bind((KeyMap<Operation>) Operation.ADD_FILE, ":e", KeyMap.ctrl('X') + KeyMap.ctrl('V'));
        map.bind((KeyMap<Operation>) Operation.NEXT_FILE, ":n");
        map.bind((KeyMap<Operation>) Operation.PREV_FILE, ":p");
        map.bind((KeyMap<Operation>) Operation.GOTO_FILE, ":x");
        map.bind((KeyMap<Operation>) Operation.INFO_FILE, "=", ":f", KeyMap.ctrl('G'));
        map.bind((KeyMap<Operation>) Operation.DELETE_FILE, ":d");
        map.bind((KeyMap<Operation>) Operation.BACKSPACE, KeyMap.del());
        "-/0123456789?&".chars().forEach(c -> {
            map.bind((KeyMap) Operation.CHAR, (CharSequence) Character.toString((char) c));
        });
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Less$InterruptibleInputStream.class */
    public static class InterruptibleInputStream extends FilterInputStream {
        InterruptibleInputStream(InputStream in) {
            super(in);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
            if (!Thread.currentThread().isInterrupted()) {
                return read(b, off, len);
            }
            throw new InterruptedIOException();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/builtins/Less$Pair.class */
    public static class Pair<U, V> {

        /* renamed from: u */
        final U f3197u;

        /* renamed from: v */
        final V f3198v;

        public Pair(U u, V v) {
            this.f3197u = u;
            this.f3198v = v;
        }

        public U getU() {
            return this.f3197u;
        }

        public V getV() {
            return this.f3198v;
        }
    }
}
