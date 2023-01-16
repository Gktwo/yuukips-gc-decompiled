package org.jline.builtins;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jline.builtins.Completers;
import org.jline.builtins.Options;
import org.jline.builtins.Source;
import org.jline.console.Printer;
import org.jline.keymap.KeyMap;
import org.jline.reader.Binding;
import org.jline.reader.Highlighter;
import org.jline.reader.History;
import org.jline.reader.LineReader;
import org.jline.reader.Macro;
import org.jline.reader.Reference;
import org.jline.reader.Widget;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.StyleResolver;
import org.quartz.jobs.NativeJob;
import p001ch.qos.logback.classic.net.SyslogAppender;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/builtins/Commands.class */
public class Commands {
    public static void tmux(Terminal terminal, PrintStream out, PrintStream err, Supplier<Object> getter, Consumer<Object> setter, Consumer<Terminal> runner, String[] argv) throws Exception {
        Options opt = Options.compile(new String[]{"tmux -  terminal multiplexer", "Usage: tmux [command]", "  -? --help                    Show help"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        } else if (argv.length != 0) {
            Object instance = getter.get();
            if (instance != null) {
                ((Tmux) instance).execute(out, err, Arrays.asList(argv));
            } else {
                err.println("tmux: no instance running");
            }
        } else if (getter.get() != null) {
            err.println("tmux: can't run tmux inside itself");
        } else {
            Tmux tmux = new Tmux(terminal, err, runner);
            setter.accept(tmux);
            try {
                tmux.run();
                setter.accept(null);
            } catch (Throwable th) {
                setter.accept(null);
                throw th;
            }
        }
    }

    public static void nano(Terminal terminal, PrintStream out, PrintStream err, Path currentDir, String[] argv) throws Exception {
        nano(terminal, out, err, currentDir, argv, null);
    }

    public static void nano(Terminal terminal, PrintStream out, PrintStream err, Path currentDir, String[] argv, ConfigurationPath configPath) throws Exception {
        Options opt = Options.compile(Nano.usage()).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        Nano edit = new Nano(terminal, currentDir, opt, configPath);
        edit.open(opt.args());
        edit.run();
    }

    public static void less(Terminal terminal, InputStream in, PrintStream out, PrintStream err, Path currentDir, String[] argv) throws Exception {
        less(terminal, in, out, err, currentDir, argv, null);
    }

    public static void less(Terminal terminal, InputStream in, PrintStream out, PrintStream err, Path currentDir, String[] argv, ConfigurationPath configPath) throws Exception {
        Options opt = Options.compile(Less.usage()).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        Less less = new Less(terminal, currentDir, opt, configPath);
        List<Source> sources = new ArrayList<>();
        if (opt.args().isEmpty()) {
            opt.args().add("-");
        }
        for (String arg : opt.args()) {
            String arg2 = arg.startsWith("~") ? arg.replace("~", System.getProperty("user.home")) : arg;
            if ("-".equals(arg2)) {
                sources.add(new Source.StdInSource(in));
            } else if (arg2.contains("*") || arg2.contains("?")) {
                for (Path p : findFiles(currentDir, arg2)) {
                    sources.add(new Source.URLSource(p.toUri().toURL(), p.toString()));
                }
            } else {
                sources.add(new Source.URLSource(currentDir.resolve(arg2).toUri().toURL(), arg2));
            }
        }
        less.run(sources);
    }

    /* access modifiers changed from: protected */
    public static List<Path> findFiles(Path root, String files) throws IOException {
        String regex;
        String files2 = files.startsWith("~") ? files.replace("~", System.getProperty("user.home")) : files;
        Path searchRoot = Paths.get("/", new String[0]);
        if (new File(files2).isAbsolute()) {
            regex = files2.replaceAll("\\\\", "/").replaceAll("//", "/");
            if (regex.contains("/")) {
                String sr = regex.substring(0, regex.lastIndexOf("/") + 1);
                while (true) {
                    if (!sr.contains("*") && !sr.contains("?")) {
                        break;
                    }
                    sr = sr.substring(0, sr.lastIndexOf("/"));
                }
                searchRoot = Paths.get(sr + "/", new String[0]);
            }
        } else {
            regex = ((root.toString().length() == 0 ? "" : root.toString() + "/") + files2).replaceAll("\\\\", "/").replaceAll("//", "/");
            searchRoot = root;
        }
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + regex);
        return (List) Files.find(searchRoot, Integer.MAX_VALUE, path, f -> {
            return pathMatcher.matches(path);
        }, new FileVisitOption[0]).collect(Collectors.toList());
    }

    public static void history(LineReader reader, PrintStream out, PrintStream err, Path currentDir, String[] argv) throws Exception {
        int firstId;
        int lastId;
        Iterator<History.Entry> iter;
        Options opt = Options.compile(new String[]{"history -  list history of commands", "Usage: history [-dnrfEie] [-m match] [first] [last]", "       history -ARWI [filename]", "       history -s [old=new] [command]", "       history --clear", "       history --save", "  -? --help                       Displays command help", "     --clear                      Clear history", "     --save                       Save history", "  -m match                        If option -m is present the first argument is taken as a pattern", "                                  and only the history events matching the pattern will be shown", "  -d                              Print timestamps for each event", "  -f                              Print full time date stamps in the US format", "  -E                              Print full time date stamps in the European format", "  -i                              Print full time date stamps in ISO8601 format", "  -n                              Suppresses command numbers", "  -r                              Reverses the order of the commands", "  -A                              Appends the history out to the given file", "  -R                              Reads the history from the given file", "  -W                              Writes the history out to the given file", "  -I                              If added to -R, only the events that are not contained within the internal list are added", "                                  If added to -W or -A, only the events that are new since the last incremental operation", "                                  to the file are added", "  [first] [last]                  These optional arguments may be specified as a number or as a string. A negative number", "                                  is used as an offset to the current history event number. A string specifies the most", "                                  recent event beginning with the given string.", "  -e                              Uses the nano editor to edit the commands before executing", "  -s                              Re-executes the command without invoking an editor"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        History history = reader.getHistory();
        boolean done = true;
        boolean increment = opt.isSet("I");
        if (opt.isSet(LineReader.CLEAR)) {
            history.purge();
        } else if (opt.isSet("save")) {
            history.save();
        } else if (opt.isSet("A")) {
            history.append(opt.args().size() > 0 ? currentDir.resolve(opt.args().get(0)) : null, increment);
        } else if (opt.isSet("R")) {
            history.read(opt.args().size() > 0 ? currentDir.resolve(opt.args().get(0)) : null, increment);
        } else if (opt.isSet("W")) {
            history.write(opt.args().size() > 0 ? currentDir.resolve(opt.args().get(0)) : null, increment);
        } else {
            done = false;
        }
        if (!done) {
            ReExecute execute = new ReExecute(history, opt);
            int argId = execute.getArgId();
            Pattern pattern = null;
            if (opt.isSet(ANSIConstants.ESC_END) && opt.args().size() > argId) {
                StringBuilder sb = new StringBuilder();
                char prev = '0';
                argId++;
                char[] charArray = opt.args().get(argId).toCharArray();
                for (char c : charArray) {
                    if (!(c != '*' || prev == '\\' || prev == '.')) {
                        sb.append('.');
                    }
                    sb.append(c);
                    prev = c;
                }
                pattern = Pattern.compile(sb.toString(), 32);
            }
            boolean reverse = opt.isSet("r") || (opt.isSet("s") && opt.args().size() <= argId);
            if (opt.args().size() > argId) {
                argId++;
                firstId = retrieveHistoryId(history, opt.args().get(argId));
            } else {
                firstId = -17;
            }
            if (opt.args().size() > argId) {
                int argId2 = argId + 1;
                lastId = retrieveHistoryId(history, opt.args().get(argId));
            } else {
                lastId = -1;
            }
            int firstId2 = historyId(firstId, history.first(), history.last());
            int lastId2 = historyId(lastId, history.first(), history.last());
            if (firstId2 > lastId2) {
                firstId2 = lastId2;
                lastId2 = firstId2;
                reverse = !reverse;
            }
            int tot = (lastId2 - firstId2) + 1;
            int listed = 0;
            Highlighter highlighter = reader.getHighlighter();
            if (reverse) {
                iter = history.reverseIterator(lastId2);
            } else {
                iter = history.iterator(firstId2);
            }
            while (true) {
                if (!iter.hasNext() || listed >= tot) {
                    break;
                }
                History.Entry entry = iter.next();
                listed++;
                if (pattern == null || pattern.matcher(entry.line()).matches()) {
                    if (execute.isExecute()) {
                        if (!execute.isEdit()) {
                            execute.addCommandInBuffer(reader, entry.line());
                            break;
                        }
                        execute.addCommandInFile(entry.line());
                    } else {
                        AttributedStringBuilder sb2 = new AttributedStringBuilder();
                        if (!opt.isSet("n")) {
                            sb2.append((CharSequence) "  ");
                            sb2.styled((v0) -> {
                                return v0.bold();
                            }, String.format("%3d", Integer.valueOf(entry.index())));
                        }
                        if (opt.isSet(DateTokenConverter.CONVERTER_KEY) || opt.isSet("f") || opt.isSet("E") || opt.isSet(IntegerTokenConverter.CONVERTER_KEY)) {
                            sb2.append((CharSequence) "  ");
                            if (opt.isSet(DateTokenConverter.CONVERTER_KEY)) {
                                DateTimeFormatter.ISO_LOCAL_TIME.formatTo(LocalTime.from(entry.time().atZone(ZoneId.systemDefault())).truncatedTo(ChronoUnit.SECONDS), sb2);
                            } else {
                                LocalDateTime lt = LocalDateTime.from((TemporalAccessor) entry.time().atZone(ZoneId.systemDefault()).truncatedTo(ChronoUnit.MINUTES));
                                String format = "yyyy-MM-dd hh:mm";
                                if (opt.isSet("f")) {
                                    format = "MM/dd/yy hh:mm";
                                } else if (opt.isSet("E")) {
                                    format = "dd.MM.yyyy hh:mm";
                                }
                                DateTimeFormatter.ofPattern(format).formatTo(lt, sb2);
                            }
                        }
                        sb2.append((CharSequence) "  ");
                        sb2.append(highlighter.highlight(reader, entry.line()));
                        out.println(sb2.toAnsi(reader.getTerminal()));
                    }
                }
            }
            execute.editCommandsAndClose(reader);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Commands$ReExecute.class */
    private static class ReExecute {
        private final boolean execute;
        private final boolean edit;
        private String oldParam;
        private String newParam;
        private FileWriter cmdWriter;
        private File cmdFile;
        private int argId = 0;

        public ReExecute(History history, Options opt) throws IOException {
            this.execute = opt.isSet("e") || opt.isSet("s");
            this.edit = opt.isSet("e");
            if (this.execute) {
                Iterator<History.Entry> iter = history.reverseIterator(history.last());
                if (iter.hasNext()) {
                    iter.next();
                    iter.remove();
                }
                if (this.edit) {
                    this.cmdFile = File.createTempFile("jline-history-", null);
                    this.cmdWriter = new FileWriter(this.cmdFile);
                } else if (opt.args().size() > 0) {
                    String[] s = opt.args().get(this.argId).split("=");
                    if (s.length == 2) {
                        this.argId++;
                        this.oldParam = s[0];
                        this.newParam = s[1];
                    }
                }
            }
        }

        public int getArgId() {
            return this.argId;
        }

        public boolean isEdit() {
            return this.edit;
        }

        public boolean isExecute() {
            return this.execute;
        }

        public void addCommandInFile(String command) throws IOException {
            this.cmdWriter.write(command + "\n");
        }

        public void addCommandInBuffer(LineReader reader, String command) {
            reader.addCommandsInBuffer(Arrays.asList(replaceParam(command)));
        }

        private String replaceParam(String command) {
            String out = command;
            if (!(this.oldParam == null || this.newParam == null)) {
                out = command.replaceAll(this.oldParam, this.newParam);
            }
            return out;
        }

        public void editCommandsAndClose(LineReader reader) throws Exception {
            if (this.edit) {
                this.cmdWriter.close();
                try {
                    reader.editAndAddInBuffer(this.cmdFile);
                } finally {
                    this.cmdFile.delete();
                }
            }
        }
    }

    private static int historyId(int id, int minId, int maxId) {
        int out = id;
        if (id < 0) {
            out = maxId + id + 1;
        }
        if (out < minId) {
            out = minId;
        } else if (out > maxId) {
            out = maxId;
        }
        return out;
    }

    private static int retrieveHistoryId(History history, String s) throws IllegalArgumentException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            Iterator<History.Entry> iter = history.iterator();
            while (iter.hasNext()) {
                History.Entry entry = iter.next();
                if (entry.line().startsWith(s)) {
                    return entry.index();
                }
            }
            throw new IllegalArgumentException("history: event not found: " + s);
        }
    }

    public static void complete(LineReader reader, PrintStream out, PrintStream err, Map<String, List<Completers.CompletionData>> completions, String[] argv) throws Options.HelpException {
        Options opt = Options.compile(new String[]{"complete -  edit command specific tab-completions", "Usage: complete", "  -? --help                       Displays command help", "  -c --command=COMMAND            Command to add completion to", "  -d --description=DESCRIPTION    Description of this completions", "  -e --erase                      Erase the completions", "  -s --short-option=SHORT_OPTION  Posix-style option to complete", "  -l --long-option=LONG_OPTION    GNU-style option to complete", "  -a --argument=ARGUMENTS         A list of possible arguments", "  -n --condition=CONDITION        The completion should only be used if the", "                                  specified command has a zero exit status"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        String command = opt.get(NativeJob.PROP_COMMAND);
        if (opt.isSet("erase")) {
            completions.remove(command);
            return;
        }
        List<Completers.CompletionData> cmdCompletions = completions.computeIfAbsent(command, s -> {
            return new ArrayList();
        });
        List<String> options = null;
        if (opt.isSet("short-option")) {
            for (String op : opt.getList("short-option")) {
                if (options == null) {
                    options = new ArrayList<>();
                }
                options.add("-" + op);
            }
        }
        if (opt.isSet("long-option")) {
            for (String op2 : opt.getList("long-option")) {
                if (options == null) {
                    options = new ArrayList<>();
                }
                options.add("--" + op2);
            }
        }
        cmdCompletions.add(new Completers.CompletionData(options, opt.isSet("description") ? opt.get("description") : null, opt.isSet("argument") ? opt.get("argument") : null, opt.isSet("condition") ? opt.get("condition") : null));
    }

    public static void widget(LineReader reader, PrintStream out, PrintStream err, Function<String, Widget> widgetCreator, String[] argv) throws Exception {
        Widget org2;
        Options opt = Options.compile(new String[]{"widget -  manipulate widgets", "Usage: widget -N new-widget [function-name]", "       widget -D widget ...", "       widget -A old-widget new-widget", "       widget -U string ...", "       widget -l [options]", "  -? --help                       Displays command help", "  -A                              Create alias to widget", "  -N                              Create new widget", "  -D                              Delete widgets", "  -U                              Push characters to the stack", "  -l                              List user-defined widgets", "  -a                              With -l, list all widgets"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        if ((opt.isSet("N") ? 1 : 0) + (opt.isSet("D") ? 1 : 0) + (opt.isSet("U") ? 1 : 0) + (opt.isSet("l") ? 1 : 0) + (opt.isSet("A") ? 1 : 0) > 1) {
            err.println("widget: incompatible operation selection options");
        } else if (opt.isSet("l")) {
            TreeSet<String> ws = new TreeSet<>(reader.getWidgets().keySet());
            if (opt.isSet("a")) {
                for (String s : new HashSet<>(ws)) {
                    ws.add(reader.getWidgets().get(s).toString());
                }
            }
            Iterator<String> it = ws.iterator();
            while (it.hasNext()) {
                String s2 = it.next();
                if (opt.isSet("a")) {
                    out.println(s2);
                } else if (!reader.getWidgets().get(s2).toString().startsWith(Mapper.IGNORED_FIELDNAME)) {
                    out.println(s2 + " (" + reader.getWidgets().get(s2) + ")");
                }
            }
        } else if (opt.isSet("N")) {
            if (opt.args().size() < 1) {
                err.println("widget: not enough arguments for -N");
            } else if (opt.args().size() > 2) {
                err.println("widget: too many arguments for -N");
            } else {
                String name = opt.args().get(0);
                reader.getWidgets().put(name, widgetCreator.apply(opt.args().size() == 2 ? opt.args().get(1) : name));
            }
        } else if (opt.isSet("D")) {
            for (String name2 : opt.args()) {
                reader.getWidgets().remove(name2);
            }
        } else if (opt.isSet("A")) {
            if (opt.args().size() < 2) {
                err.println("widget: not enough arguments for -A");
            } else if (opt.args().size() > 2) {
                err.println("widget: too many arguments for -A");
            } else {
                if (opt.args().get(0).startsWith(Mapper.IGNORED_FIELDNAME)) {
                    org2 = reader.getBuiltinWidgets().get(opt.args().get(0).substring(1));
                } else {
                    org2 = reader.getWidgets().get(opt.args().get(0));
                }
                if (org2 == null) {
                    err.println("widget: no such widget `" + opt.args().get(0) + "'");
                } else {
                    reader.getWidgets().put(opt.args().get(1), org2);
                }
            }
        } else if (opt.isSet("U")) {
            for (String arg : opt.args()) {
                reader.runMacro(KeyMap.translate(arg));
            }
        } else if (opt.args().size() == 1) {
            reader.callWidget(opt.args().get(0));
        }
    }

    public static void keymap(LineReader reader, PrintStream out, PrintStream err, String[] argv) throws Options.HelpException {
        Binding bout;
        Options opt = Options.compile(new String[]{"keymap -  manipulate keymaps", "Usage: keymap [options] -l [-L] [keymap ...]", "       keymap [options] -d", "       keymap [options] -D keymap ...", "       keymap [options] -A old-keymap new-keymap", "       keymap [options] -N new-keymap [old-keymap]", "       keymap [options] -m", "       keymap [options] -r in-string ...", "       keymap [options] -s in-string out-string ...", "       keymap [options] in-string command ...", "       keymap [options] [in-string]", "  -? --help                       Displays command help", "  -A                              Create alias to keymap", "  -D                              Delete named keymaps", "  -L                              Output in form of keymap commands", "  -M (default=main)               Specify keymap to select", "  -N                              Create new keymap", "  -R                              Interpret in-strings as ranges", "  -a                              Select vicmd keymap", "  -d                              Delete existing keymaps and reset to default state", "  -e                              Select emacs keymap and bind it to main", "  -l                              List existing keymap names", "  -p                              List bindings which have given key sequence as a a prefix", "  -r                              Unbind specified in-strings ", "  -s                              Bind each in-string to each out-string ", "  -v                              Select viins keymap and bind it to main"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        Map<String, KeyMap<Binding>> keyMaps = reader.getKeyMaps();
        if ((opt.isSet("N") ? 1 : 0) + (opt.isSet(DateTokenConverter.CONVERTER_KEY) ? 1 : 0) + (opt.isSet("D") ? 1 : 0) + (opt.isSet("l") ? 1 : 0) + (opt.isSet("r") ? 1 : 0) + (opt.isSet("s") ? 1 : 0) + (opt.isSet("A") ? 1 : 0) > 1) {
            err.println("keymap: incompatible operation selection options");
        } else if (opt.isSet("l")) {
            opt.isSet("L");
            if (opt.args().size() > 0) {
                for (String arg : opt.args()) {
                    if (keyMaps.get(arg) == null) {
                        err.println("keymap: no such keymap: `" + arg + "'");
                    } else {
                        out.println(arg);
                    }
                }
                return;
            }
            Set<String> keySet = keyMaps.keySet();
            Objects.requireNonNull(out);
            keySet.forEach(this::println);
        } else if (opt.isSet("N")) {
            if (opt.isSet("e") || opt.isSet("v") || opt.isSet("a") || opt.isSet("M")) {
                err.println("keymap: keymap can not be selected with -N");
            } else if (opt.args().size() < 1) {
                err.println("keymap: not enough arguments for -N");
            } else if (opt.args().size() > 2) {
                err.println("keymap: too many arguments for -N");
            } else {
                KeyMap<Binding> org2 = null;
                if (opt.args().size() == 2) {
                    org2 = keyMaps.get(opt.args().get(1));
                    if (org2 == null) {
                        err.println("keymap: no such keymap `" + opt.args().get(1) + "'");
                        return;
                    }
                }
                KeyMap<Binding> map = new KeyMap<>();
                if (org2 != null) {
                    for (Map.Entry<String, Binding> bound : org2.getBoundKeys().entrySet()) {
                        map.bind((KeyMap<Binding>) bound.getValue(), bound.getKey());
                    }
                }
                keyMaps.put(opt.args().get(0), map);
            }
        } else if (opt.isSet("A")) {
            if (opt.isSet("e") || opt.isSet("v") || opt.isSet("a") || opt.isSet("M")) {
                err.println("keymap: keymap can not be selected with -N");
            } else if (opt.args().size() < 2) {
                err.println("keymap: not enough arguments for -A");
            } else if (opt.args().size() > 2) {
                err.println("keymap: too many arguments for -A");
            } else {
                KeyMap<Binding> org3 = keyMaps.get(opt.args().get(0));
                if (org3 == null) {
                    err.println("keymap: no such keymap `" + opt.args().get(0) + "'");
                } else {
                    keyMaps.put(opt.args().get(1), org3);
                }
            }
        } else if (opt.isSet(DateTokenConverter.CONVERTER_KEY)) {
            if (opt.isSet("e") || opt.isSet("v") || opt.isSet("a") || opt.isSet("M")) {
                err.println("keymap: keymap can not be selected with -N");
            } else if (opt.args().size() > 0) {
                err.println("keymap: too many arguments for -d");
            } else {
                keyMaps.clear();
                keyMaps.putAll(reader.defaultKeyMaps());
            }
        } else if (opt.isSet("D")) {
            if (opt.isSet("e") || opt.isSet("v") || opt.isSet("a") || opt.isSet("M")) {
                err.println("keymap: keymap can not be selected with -N");
            } else if (opt.args().size() < 1) {
                err.println("keymap: not enough arguments for -A");
            } else {
                for (String name : opt.args()) {
                    if (keyMaps.remove(name) == null) {
                        err.println("keymap: no such keymap `" + name + "'");
                        return;
                    }
                }
            }
        } else if (opt.isSet("r")) {
            String keyMapName = LineReader.MAIN;
            if ((opt.isSet("a") ? 1 : 0) + (opt.isSet("e") ? 1 : 0) + (opt.isSet("v") ? 1 : 0) + (opt.isSet("M") ? 1 : 0) > 1) {
                err.println("keymap: incompatible keymap selection options");
                return;
            }
            if (opt.isSet("a")) {
                keyMapName = LineReader.VICMD;
            } else if (opt.isSet("e")) {
                keyMapName = LineReader.EMACS;
            } else if (opt.isSet("v")) {
                keyMapName = LineReader.VIINS;
            } else if (opt.isSet("M")) {
                if (opt.args().isEmpty()) {
                    err.println("keymap: argument expected: -M");
                    return;
                }
                keyMapName = opt.args().remove(0);
            }
            KeyMap<Binding> map2 = keyMaps.get(keyMapName);
            if (map2 == null) {
                err.println("keymap: no such keymap `" + keyMapName + "'");
                return;
            }
            boolean range = opt.isSet("R");
            boolean prefix = opt.isSet("p");
            Set<String> toRemove = new HashSet<>();
            Map<String, Binding> bound2 = map2.getBoundKeys();
            for (String arg2 : opt.args()) {
                if (range) {
                    Collection<String> r = KeyMap.range(opt.args().get(0));
                    if (r == null) {
                        err.println("keymap: malformed key range `" + opt.args().get(0) + "'");
                        return;
                    }
                    toRemove.addAll(r);
                } else {
                    String seq = KeyMap.translate(arg2);
                    for (String k : bound2.keySet()) {
                        if ((prefix && k.startsWith(seq) && k.length() > seq.length()) || (!prefix && k.equals(seq))) {
                            toRemove.add(k);
                        }
                    }
                }
            }
            for (String seq2 : toRemove) {
                map2.unbind(seq2);
            }
            if (opt.isSet("e") || opt.isSet("v")) {
                keyMaps.put(LineReader.MAIN, map2);
            }
        } else if (opt.isSet("s") || opt.args().size() > 1) {
            String keyMapName2 = LineReader.MAIN;
            if ((opt.isSet("a") ? 1 : 0) + (opt.isSet("e") ? 1 : 0) + (opt.isSet("v") ? 1 : 0) + (opt.isSet("M") ? 1 : 0) > 1) {
                err.println("keymap: incompatible keymap selection options");
                return;
            }
            if (opt.isSet("a")) {
                keyMapName2 = LineReader.VICMD;
            } else if (opt.isSet("e")) {
                keyMapName2 = LineReader.EMACS;
            } else if (opt.isSet("v")) {
                keyMapName2 = LineReader.VIINS;
            } else if (opt.isSet("M")) {
                if (opt.args().isEmpty()) {
                    err.println("keymap: argument expected: -M");
                    return;
                }
                keyMapName2 = opt.args().remove(0);
            }
            KeyMap<Binding> map3 = keyMaps.get(keyMapName2);
            if (map3 == null) {
                err.println("keymap: no such keymap `" + keyMapName2 + "'");
                return;
            }
            boolean range2 = opt.isSet("R");
            if (opt.args().size() % 2 == 1) {
                err.println("keymap: even number of arguments required");
                return;
            }
            for (int i = 0; i < opt.args().size(); i += 2) {
                if (opt.isSet("s")) {
                    bout = new Macro(KeyMap.translate(opt.args().get(i + 1)));
                } else {
                    bout = new Reference(opt.args().get(i + 1));
                }
                if (range2) {
                    Collection<String> r2 = KeyMap.range(opt.args().get(i));
                    if (r2 == null) {
                        err.println("keymap: malformed key range `" + opt.args().get(i) + "'");
                        return;
                    }
                    map3.bind((KeyMap<Binding>) bout, r2);
                } else {
                    map3.bind((KeyMap<Binding>) bout, KeyMap.translate(opt.args().get(i)));
                }
            }
            if (opt.isSet("e") || opt.isSet("v")) {
                keyMaps.put(LineReader.MAIN, map3);
            }
        } else {
            String keyMapName3 = LineReader.MAIN;
            if ((opt.isSet("a") ? 1 : 0) + (opt.isSet("e") ? 1 : 0) + (opt.isSet("v") ? 1 : 0) + (opt.isSet("M") ? 1 : 0) > 1) {
                err.println("keymap: incompatible keymap selection options");
                return;
            }
            if (opt.isSet("a")) {
                keyMapName3 = LineReader.VICMD;
            } else if (opt.isSet("e")) {
                keyMapName3 = LineReader.EMACS;
            } else if (opt.isSet("v")) {
                keyMapName3 = LineReader.VIINS;
            } else if (opt.isSet("M")) {
                if (opt.args().isEmpty()) {
                    err.println("keymap: argument expected: -M");
                    return;
                }
                keyMapName3 = opt.args().remove(0);
            }
            KeyMap<Binding> map4 = keyMaps.get(keyMapName3);
            if (map4 == null) {
                err.println("keymap: no such keymap `" + keyMapName3 + "'");
                return;
            }
            boolean prefix2 = opt.isSet("p");
            boolean commands = opt.isSet("L");
            if (!prefix2 || !opt.args().isEmpty()) {
                if (opt.args().size() > 0 || (!opt.isSet("e") && !opt.isSet("v"))) {
                    Map<String, Binding> bound3 = map4.getBoundKeys();
                    String seq3 = opt.args().size() > 0 ? KeyMap.translate(opt.args().get(0)) : null;
                    Map.Entry<String, Binding> begin = null;
                    String last = null;
                    Iterator<Map.Entry<String, Binding>> iterator = bound3.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Binding> entry = iterator.next();
                        String key = entry.getKey();
                        if (seq3 == null || ((prefix2 && key.startsWith(seq3) && !key.equals(seq3)) || (!prefix2 && key.equals(seq3)))) {
                            if (begin == null && iterator.hasNext()) {
                                begin = entry;
                                last = key;
                            } else if (!key.equals((last.length() > 1 ? last.substring(0, last.length() - 1) : "") + ((char) (last.charAt(last.length() - 1) + 1))) || !entry.getValue().equals(begin.getValue())) {
                                StringBuilder sb = new StringBuilder();
                                if (commands) {
                                    sb.append("keymap -M ");
                                    sb.append(keyMapName3);
                                    sb.append(" ");
                                }
                                if (begin.getKey().equals(last)) {
                                    sb.append(KeyMap.display(last));
                                    sb.append(" ");
                                    displayValue(sb, begin.getValue());
                                    out.println(sb.toString());
                                } else {
                                    if (commands) {
                                        sb.append("-R ");
                                    }
                                    sb.append(KeyMap.display(begin.getKey()));
                                    sb.append("-");
                                    sb.append(KeyMap.display(last));
                                    sb.append(" ");
                                    displayValue(sb, begin.getValue());
                                    out.println(sb.toString());
                                }
                                begin = entry;
                                last = key;
                            } else {
                                last = key;
                            }
                        }
                    }
                }
                if (opt.isSet("e") || opt.isSet("v")) {
                    keyMaps.put(LineReader.MAIN, map4);
                    return;
                }
                return;
            }
            err.println("keymap: option -p requires a prefix string");
        }
    }

    public static void setopt(LineReader reader, PrintStream out, PrintStream err, String[] argv) throws Options.HelpException {
        Options opt = Options.compile(new String[]{"setopt -  set options", "Usage: setopt [-m] option ...", "       setopt", "  -? --help                       Displays command help", "  -m                              Use pattern matching"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        } else if (opt.args().isEmpty()) {
            LineReader.Option[] values = LineReader.Option.values();
            for (LineReader.Option option : values) {
                if (reader.isSet(option) != option.isDef()) {
                    out.println((option.isDef() ? "no-" : "") + option.toString().toLowerCase().replace('_', '-'));
                }
            }
        } else {
            doSetOpts(reader, out, err, opt.args(), opt.isSet(ANSIConstants.ESC_END), true);
        }
    }

    public static void unsetopt(LineReader reader, PrintStream out, PrintStream err, String[] argv) throws Options.HelpException {
        Options opt = Options.compile(new String[]{"unsetopt -  unset options", "Usage: unsetopt [-m] option ...", "       unsetopt", "  -? --help                       Displays command help", "  -m                              Use pattern matching"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        } else if (opt.args().isEmpty()) {
            LineReader.Option[] values = LineReader.Option.values();
            for (LineReader.Option option : values) {
                if (reader.isSet(option) == option.isDef()) {
                    out.println((option.isDef() ? "no-" : "") + option.toString().toLowerCase().replace('_', '-'));
                }
            }
        } else {
            doSetOpts(reader, out, err, opt.args(), opt.isSet(ANSIConstants.ESC_END), false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doSetOpts(org.jline.reader.LineReader r4, java.io.PrintStream r5, java.io.PrintStream r6, java.util.List<java.lang.String> r7, boolean r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 328
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.Commands.doSetOpts(org.jline.reader.LineReader, java.io.PrintStream, java.io.PrintStream, java.util.List, boolean, boolean):void");
    }

    private static void displayValue(StringBuilder sb, Object value) {
        if (value == null) {
            sb.append(LineReader.UNDEFINED_KEY);
        } else if (value instanceof Macro) {
            sb.append(KeyMap.display(((Macro) value).getSequence()));
        } else if (value instanceof Reference) {
            sb.append(((Reference) value).name());
        } else {
            sb.append(value.toString());
        }
    }

    public static void setvar(LineReader lineReader, PrintStream out, PrintStream err, String[] argv) throws Options.HelpException {
        Options opt = Options.compile(new String[]{"setvar -  set lineReader variable value", "Usage: setvar [variable] [value]", "  -? --help                    Show help"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        } else if (opt.args().isEmpty()) {
            for (Map.Entry<String, Object> entry : lineReader.getVariables().entrySet()) {
                out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else if (opt.args().size() == 1) {
            out.println(lineReader.getVariable(opt.args().get(0)));
        } else {
            lineReader.setVariable(opt.args().get(0), opt.args().get(1));
        }
    }

    public static void colors(Terminal terminal, PrintStream out, String[] argv) throws Options.HelpException, IOException {
        Options opt = Options.compile(new String[]{"colors -  view 256-color table and ANSI-styles", "Usage: colors [OPTIONS]", "  -? --help                     Displays command help", "  -a --ansistyles               List ANSI-styles", "  -c --columns=COLUMNS          Number of columns in name/rgb table", "                                COLUMNS = 1, display columns: color, style, ansi and HSL", "  -f --find=NAME                Find color names which contains NAME ", "  -l --lock=STYLE               Lock fore- or background color", "  -n --name                     Color name table (default number table)", "  -r --rgb                      Use and display rgb value", "  -s --small                    View 16-color table (default 256-color)", "  -v --view=COLOR               View 24bit color table of COLOR ", "                                COLOR = <colorName>, <color24bit> or hue<angle>"}).parse(argv);
        if (opt.isSet("help")) {
            throw new Options.HelpException(opt.usage());
        }
        Colors colors = new Colors(terminal, out);
        if (opt.isSet("ansistyles")) {
            colors.printStyles();
            return;
        }
        String style = null;
        if (opt.isSet("lock")) {
            style = opt.get("lock");
            if (style.length() - style.replace(EmitterKt.COMMENT_PREFIX, "").length() > 1) {
                style = null;
            }
        }
        if (!opt.isSet("view")) {
            boolean rgb = opt.isSet("rgb");
            int columns = terminal.getWidth() > (rgb ? 71 : 122) ? 6 : 5;
            String findName = null;
            boolean nameTable = opt.isSet("name");
            boolean table16 = opt.isSet("small");
            if (opt.isSet("find")) {
                findName = opt.get("find").toLowerCase();
                nameTable = true;
                table16 = false;
                columns = 4;
            }
            if (table16) {
                columns += 2;
            }
            if (opt.isSet(Printer.COLUMNS)) {
                columns = opt.getNumber(Printer.COLUMNS);
            }
            colors.printColors(nameTable, rgb, table16, columns, findName, style);
            return;
        }
        colors.printColor(opt.get("view").toLowerCase(), style);
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Commands$Colors.class */
    private static class Colors {
        private static final String COLORS_24BIT = "[0-9a-fA-F]{6}";
        private static final List<String> COLORS_16 = Arrays.asList("black", "red", "green", "yellow", "blue", "magenta", "cyan", "white", "!black", "!red", "!green", "!yellow", "!blue", "!magenta", "!cyan", "!white");
        boolean name;
        boolean rgb;
        private final Terminal terminal;
        private final PrintStream out;
        private boolean fixedBg;
        private String fixedStyle;

        /* renamed from: r */
        int f3193r;

        /* renamed from: g */
        int f3194g;

        /* renamed from: b */
        int f3195b;

        public Colors(Terminal terminal, PrintStream out) {
            this.terminal = terminal;
            this.out = out;
        }

        private String getAnsiStyle(String style) {
            return style;
        }

        public void printStyles() {
            AttributedStringBuilder asb = new AttributedStringBuilder();
            asb.tabs(13);
            for (String s : Styles.ANSI_STYLES) {
                AttributedStyle as = new StyleResolver(this::getAnsiStyle).resolve(Mapper.IGNORED_FIELDNAME + s);
                asb.style(as);
                asb.append((CharSequence) s);
                asb.style(AttributedStyle.DEFAULT);
                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                asb.append((CharSequence) getAnsiStyle(s));
                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                asb.append((CharSequence) as.toAnsi());
                asb.append((CharSequence) "\n");
            }
            asb.toAttributedString().println(this.terminal);
        }

        private String getStyle(String color) {
            String out;
            String out2;
            char fg = ' ';
            if (this.name) {
                out = (this.fixedBg ? "fg:" : "bg:") + "~" + color.substring(1);
                fg = color.charAt(0);
            } else if (this.rgb) {
                out = (this.fixedBg ? "fg-rgb:" : "bg-rgb:") + LineReaderImpl.DEFAULT_COMMENT_BEGIN + color.substring(1);
                fg = color.charAt(0);
            } else if (color.substring(1).matches("\\d+")) {
                out = (this.fixedBg ? "38;5;" : "48;5;") + color.substring(1);
                fg = color.charAt(0);
            } else {
                out = (this.fixedBg ? "fg:" : "bg:") + color;
            }
            if (this.fixedStyle != null) {
                out2 = out + "," + this.fixedStyle;
            } else if (color.startsWith("!") || color.equals("white") || fg == 'b') {
                out2 = out + ",fg:black";
            } else {
                out2 = out + ",fg:!white";
            }
            return out2;
        }

        private String foreground(int idx) {
            String fg = "w";
            if ((idx > 6 && idx < 16) || ((idx > 33 && idx < 52) || ((idx > 69 && idx < 88) || ((idx > 105 && idx < 124) || ((idx > 141 && idx < 160) || ((idx > 177 && idx < 196) || ((idx > 213 && idx < 232) || idx > 243))))))) {
                fg = "b";
            }
            return fg;
        }

        private String addPadding(int width, String field) {
            int s = width - field.length();
            int left = s / 2;
            StringBuilder lp = new StringBuilder();
            StringBuilder rp = new StringBuilder();
            for (int i = 0; i < left; i++) {
                lp.append(" ");
            }
            for (int i2 = 0; i2 < s - left; i2++) {
                rp.append(" ");
            }
            return lp.toString() + field + rp.toString();
        }

        private String addLeftPadding(int width, String field) {
            int s = width - field.length();
            StringBuilder lp = new StringBuilder();
            for (int i = 0; i < s; i++) {
                lp.append(" ");
            }
            return lp.toString() + field;
        }

        private void setFixedStyle(String style) {
            this.fixedStyle = style;
            if (style == null) {
                return;
            }
            if (style.contains("b:") || style.contains("b-") || style.contains("bg:") || style.contains("bg-") || style.contains("background")) {
                this.fixedBg = true;
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0053
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        private java.util.List<java.lang.String> retrieveColorNames() throws java.io.IOException {
            /*
                r6 = this;
                org.jline.builtins.Source$ResourceSource r0 = new org.jline.builtins.Source$ResourceSource
                r1 = r0
                java.lang.String r2 = "/org/jline/utils/colors.txt"
                r3 = 0
                r1.<init>(r2, r3)
                java.io.InputStream r0 = r0.read()
                r8 = r0
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: Throwable -> 0x0073
                r1 = r0
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: Throwable -> 0x0073
                r3 = r2
                r4 = r8
                r3.<init>(r4)     // Catch: Throwable -> 0x0073
                r1.<init>(r2)     // Catch: Throwable -> 0x0073
                r9 = r0
                r0 = r9
                java.util.stream.Stream r0 = r0.lines()     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.List<java.lang.String> r1 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                    return v0.trim();
                }     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.stream.Stream r0 = r0.map(r1)     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.List<java.lang.String> r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                    return lambda$retrieveColorNames$0(v0);
                }     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.List<java.lang.String> r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                    return lambda$retrieveColorNames$1(v0);
                }     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.stream.Collector r1 = java.util.stream.Collectors.toList()     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.lang.Object r0 = r0.collect(r1)     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                java.util.List r0 = (java.util.List) r0     // Catch: Throwable -> 0x0073, Throwable -> 0x0053
                r7 = r0
                r0 = r9
                r0.close()     // Catch: Throwable -> 0x0073
                goto L_0x0068
            L_0x0053:
                r10 = move-exception
                r0 = r9
                r0.close()     // Catch: Throwable -> 0x005c, Throwable -> 0x0073
                goto L_0x0065
            L_0x005c:
                r11 = move-exception
                r0 = r10
                r1 = r11
                r0.addSuppressed(r1)     // Catch: Throwable -> 0x0073
            L_0x0065:
                r0 = r10
                throw r0     // Catch: Throwable -> 0x0073
            L_0x0068:
                r0 = r8
                if (r0 == 0) goto L_0x0089
                r0 = r8
                r0.close()
                goto L_0x0089
            L_0x0073:
                r9 = move-exception
                r0 = r8
                if (r0 == 0) goto L_0x0087
                r0 = r8
                r0.close()     // Catch: Throwable -> 0x007f
                goto L_0x0087
            L_0x007f:
                r10 = move-exception
                r0 = r9
                r1 = r10
                r0.addSuppressed(r1)
            L_0x0087:
                r0 = r9
                throw r0
            L_0x0089:
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.Commands.Colors.retrieveColorNames():java.util.List");
        }

        public void printColors(boolean name, boolean rgb, boolean small, int columns, String findName, String style) throws IOException {
            this.name = !rgb && name;
            this.rgb = rgb;
            setFixedStyle(style);
            AttributedStringBuilder asb = new AttributedStringBuilder();
            int width = this.terminal.getWidth();
            String tableName = small ? " 16-color " : "256-color ";
            if (name || rgb) {
                this.out.print(tableName);
                if (name) {
                    asb.tabs(Arrays.asList(25, 60, 75));
                    this.out.println("table, fg:~<name> OR 38;5;<n>");
                    this.out.println("                 bg:~<name> OR 48;5;<n>");
                } else {
                    asb.tabs(Arrays.asList(15, 45, 70));
                    this.out.println("table, fg-rgb:<color24bit> OR 38;5;<n>");
                    this.out.println("                 bg-rgb:<color24bit> OR 48;5;<n>");
                }
                this.out.println();
                int col = 0;
                int idx = 0;
                int colWidth = rgb ? 12 : 21;
                int lb = 1;
                if (findName != null && (findName.startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN) || findName.startsWith("x"))) {
                    findName = findName.substring(1);
                }
                for (String line : retrieveColorNames()) {
                    if (!rgb) {
                        if (findName != null) {
                            if (!line.toLowerCase().contains(findName)) {
                                idx++;
                            }
                        } else if (small) {
                            colWidth = 15;
                            lb = 1;
                        } else if (columns > 4) {
                            if (idx <= 15 || idx >= 232) {
                                colWidth = (columns != 6 || idx % 2 == 0 || col == 7) ? 15 : 16;
                                lb = -1;
                            } else {
                                colWidth = (columns != 6 || col == 1 || col == 2 || col == 3) ? 21 : 20;
                                lb = 1;
                            }
                        }
                    }
                    String fg = foreground(idx);
                    if (rgb) {
                        line = Integer.toHexString(org.jline.utils.Colors.DEFAULT_COLORS_256[idx]);
                        for (int p = line.length(); p < 6; p++) {
                            line = "0" + line;
                        }
                        if (findName != null && !line.toLowerCase().matches(findName)) {
                            idx++;
                        }
                    }
                    AttributedStyle ss = new StyleResolver(this::getStyle).resolve(Mapper.IGNORED_FIELDNAME + fg + line, null);
                    if (rgb) {
                        line = LineReaderImpl.DEFAULT_COMMENT_BEGIN + line;
                    }
                    asb.style(ss);
                    String idxstr = Integer.toString(idx);
                    if (rgb) {
                        if (idx < 10) {
                            idxstr = "  " + idxstr;
                        } else if (idx < 100) {
                            idxstr = " " + idxstr;
                        }
                    }
                    asb.append((CharSequence) idxstr).append((CharSequence) addPadding(colWidth - idxstr.length(), line));
                    if (columns == 1) {
                        asb.style(AttributedStyle.DEFAULT);
                        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN).append((CharSequence) getStyle(fg + line.substring(rgb ? 1 : 0)));
                        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN).append((CharSequence) ss.toAnsi());
                        int[] rgb1 = rgb((long) org.jline.utils.Colors.DEFAULT_COLORS_256[idx]);
                        int[] hsl = rgb2hsl(rgb1[0], rgb1[1], rgb1[2]);
                        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN).append((CharSequence) addLeftPadding(6, hsl[0] + ", ")).append((CharSequence) addLeftPadding(4, hsl[1] + "%")).append((CharSequence) ", ").append((CharSequence) addLeftPadding(4, hsl[2] + "%"));
                    }
                    col++;
                    idx++;
                    if ((col + 1) * colWidth > width || col + lb > columns) {
                        col = 0;
                        asb.style(AttributedStyle.DEFAULT);
                        asb.append('\n');
                    }
                    if (findName != null) {
                        continue;
                    } else if (idx == 16) {
                        if (small) {
                            break;
                        } else if (col != 0) {
                            col = 0;
                            asb.style(AttributedStyle.DEFAULT);
                            asb.append('\n');
                        }
                    } else if (idx == 232 && col != 0) {
                        col = 0;
                        asb.style(AttributedStyle.DEFAULT);
                        asb.append('\n');
                    }
                }
            } else {
                this.out.print(tableName);
                this.out.print("table, fg:<name> ");
                if (!small) {
                    this.out.print("/ 38;5;<n>");
                }
                this.out.println();
                this.out.print("                 bg:<name> ");
                if (!small) {
                    this.out.print("/ 48;5;<n>");
                }
                this.out.println("\n");
                boolean narrow = width < 180;
                for (String c : COLORS_16) {
                    asb.style(new StyleResolver(this::getStyle).resolve('.' + c, null));
                    asb.append((CharSequence) addPadding(11, c));
                    asb.style(AttributedStyle.DEFAULT);
                    if (c.equals("white")) {
                        if (narrow || small) {
                            asb.append('\n');
                        } else {
                            asb.append((CharSequence) "    ");
                        }
                    } else if (c.equals("!white")) {
                        asb.append('\n');
                    }
                }
                asb.append('\n');
                if (!small) {
                    for (int i = 16; i < 256; i++) {
                        String fg2 = foreground(i);
                        String code = Integer.toString(i);
                        asb.style(new StyleResolver(this::getStyle).resolve(Mapper.IGNORED_FIELDNAME + fg2 + code, null));
                        String str = " ";
                        if (i < 100) {
                            str = "  ";
                        } else if (i > 231) {
                            str = i % 2 == 0 ? "    " : "   ";
                        }
                        asb.append((CharSequence) str).append((CharSequence) code).append(' ');
                        if (i == 51 || i == 87 || i == 123 || i == 159 || i == 195 || i == 231 || (narrow && (i == 33 || i == 69 || i == 105 || i == 141 || i == 177 || i == 213 || i == 243))) {
                            asb.style(AttributedStyle.DEFAULT);
                            asb.append('\n');
                            if (i == 231) {
                                asb.append('\n');
                            }
                        }
                    }
                }
            }
            asb.toAttributedString().println(this.terminal);
        }

        private int[] rgb(long color) {
            int[] rgb = new int[3];
            rgb[0] = 0;
            rgb[1] = 0;
            rgb[2] = 0;
            rgb[0] = (int) ((color >> 16) & 255);
            rgb[1] = (int) ((color >> 8) & 255);
            rgb[2] = (int) (color & 255);
            return rgb;
        }

        private int[] hue2rgb(int degree) {
            int[] rgb = new int[3];
            rgb[0] = 0;
            rgb[1] = 0;
            rgb[2] = 0;
            double hue = ((double) degree) / 60.0d;
            double a = Math.tan(((((double) degree) / 360.0d) * 2.0d) * 3.141592653589793d) / Math.sqrt(3.0d);
            if (hue >= 0.0d && hue < 1.0d) {
                rgb[0] = 255;
                rgb[1] = (int) (((2.0d * a) * 255.0d) / (1.0d + a));
            } else if (hue >= 1.0d && hue < 2.0d) {
                rgb[0] = (int) ((255.0d * (1.0d + a)) / (2.0d * a));
                rgb[1] = 255;
            } else if (hue >= 2.0d && hue < 3.0d) {
                rgb[1] = 255;
                rgb[2] = (int) ((255.0d * (1.0d + a)) / (1.0d - a));
            } else if (hue >= 3.0d && hue < 4.0d) {
                rgb[1] = (int) ((255.0d * (1.0d - a)) / (1.0d + a));
                rgb[2] = 255;
            } else if (hue >= 4.0d && hue <= 5.0d) {
                rgb[0] = (int) ((255.0d * (a - 1.0d)) / (2.0d * a));
                rgb[2] = 255;
            } else if (hue > 5.0d && hue <= 6.0d) {
                rgb[0] = 255;
                rgb[2] = (int) ((510.0d * a) / (a - 1.0d));
            }
            return rgb;
        }

        private int[] rgb2hsl(int r, int g, int b) {
            int[] hsl = new int[3];
            hsl[0] = 0;
            hsl[1] = 0;
            hsl[2] = 0;
            if (!(r == 0 && g == 0 && b == 0)) {
                hsl[0] = (int) Math.round(57.29577951308232d * Math.atan2(Math.sqrt(3.0d) * ((double) (g - b)), (double) (((2 * r) - g) - b)));
                while (hsl[0] < 0) {
                    hsl[0] = hsl[0] + 360;
                }
            }
            double mx = ((double) Math.max(Math.max(r, g), b)) / 255.0d;
            double mn = ((double) Math.min(Math.min(r, g), b)) / 255.0d;
            double l = (mx + mn) / 2.0d;
            hsl[1] = (l == 0.0d || l == 1.0d) ? 0 : (int) Math.round((100.0d * (mx - mn)) / (1.0d - Math.abs((2.0d * l) - 1.0d)));
            hsl[2] = (int) Math.round(100.0d * l);
            return hsl;
        }

        String getStyleRGB(String s) {
            if (this.fixedStyle == null) {
                double y = (0.2126d * Math.pow(((double) this.f3193r) / 255.0d, 2.2d)) + (0.7151d * Math.pow(((double) this.f3194g) / 255.0d, 2.2d)) + (0.0721d * Math.pow(((double) this.f3195b) / 255.0d, 2.2d));
                String fg = "black";
                if (1.05d / (y + 0.05d) > (y + 0.05d) / 0.05d) {
                    fg = "white";
                }
                return "bg-rgb:" + String.format("#%02x%02x%02x", Integer.valueOf(this.f3193r), Integer.valueOf(this.f3194g), Integer.valueOf(this.f3195b)) + ",fg:" + fg;
            }
            return (this.fixedBg ? "fg-rgb:" : "bg-rgb:") + String.format("#%02x%02x%02x", Integer.valueOf(this.f3193r), Integer.valueOf(this.f3194g), Integer.valueOf(this.f3195b)) + "," + this.fixedStyle;
        }

        public void printColor(String name, String style) throws IOException {
            setFixedStyle(style);
            char c = 0;
            int[] rgb = {0, 0, 0};
            if (name.matches(COLORS_24BIT)) {
                rgb = rgb(Long.parseLong(name, 16));
                c = 0;
            } else if ((name.startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN) || name.startsWith("x")) && name.substring(1).matches(COLORS_24BIT)) {
                rgb = rgb(Long.parseLong(name.substring(1), 16));
                c = 0;
            } else if (COLORS_16.contains(name)) {
                int i = 0;
                while (true) {
                    if (i >= 16) {
                        break;
                    } else if (COLORS_16.get(i).equals(name)) {
                        rgb = rgb((long) org.jline.utils.Colors.DEFAULT_COLORS_256[i]);
                        break;
                    } else {
                        i++;
                    }
                }
            } else if (name.matches("hue[1-3]?[0-9]{1,2}")) {
                int hueAngle = Integer.parseInt(name.substring(3));
                if (hueAngle > 360) {
                    throw new IllegalArgumentException("Color not found: " + name);
                }
                rgb = hue2rgb(hueAngle);
            } else if (name.matches("[a-z0-9]+")) {
                List<String> colors = retrieveColorNames();
                if (colors.contains(name)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 256) {
                            break;
                        } else if (colors.get(i2).equals(name)) {
                            rgb = rgb((long) org.jline.utils.Colors.DEFAULT_COLORS_256[i2]);
                            break;
                        } else {
                            i2++;
                        }
                    }
                } else {
                    boolean found = false;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 256) {
                            break;
                        } else if (colors.get(i3).startsWith(name)) {
                            rgb = rgb((long) org.jline.utils.Colors.DEFAULT_COLORS_256[i3]);
                            found = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!found) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= 256) {
                                break;
                            } else if (colors.get(i4).contains(name)) {
                                rgb = rgb((long) org.jline.utils.Colors.DEFAULT_COLORS_256[i4]);
                                found = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    if (!found) {
                        throw new IllegalArgumentException("Color not found: " + name);
                    }
                }
            } else {
                throw new IllegalArgumentException("Color not found: " + name);
            }
            char c2 = 0;
            int barSize = 14;
            int width = this.terminal.getWidth();
            if (width > 287) {
                c2 = 0;
                barSize = 58;
            } else if (width > 143) {
                c2 = 0;
                barSize = 29;
            } else if (width > 98) {
                c2 = 0;
                barSize = 18;
            }
            this.f3193r = rgb[0];
            this.f3194g = rgb[1];
            this.f3195b = rgb[2];
            int[] hsl = rgb2hsl(this.f3193r, this.f3194g, this.f3195b);
            int hueAngle2 = hsl[0];
            this.out.println("HSL: " + hsl[0] + "deg, " + hsl[1] + "%, " + hsl[2] + "%");
            if (hsl[2] > 85 || hsl[2] < 15 || hsl[1] < 15) {
                c = 0;
            }
            double div = (c * 0) / c2;
            int ndiv = (int) (div / c);
            double xrs = ((double) (255 - this.f3193r)) / div;
            double xgs = ((double) (255 - this.f3194g)) / div;
            double xbs = ((double) (255 - this.f3195b)) / div;
            double[] yrs = new double[ndiv];
            double[] ygs = new double[ndiv];
            double[] ybs = new double[ndiv];
            double[] ro = new double[ndiv];
            double[] go = new double[ndiv];
            double[] bo = new double[ndiv];
            AttributedStringBuilder asb = new AttributedStringBuilder();
            for (int y = 0; y < ndiv; y++) {
                for (int x = 0; x < ndiv; x++) {
                    if (y == 0) {
                        yrs[x] = (((double) rgb[0]) + (((double) x) * xrs)) / div;
                        ygs[x] = (((double) rgb[1]) + (((double) x) * xgs)) / div;
                        ybs[x] = (((double) rgb[2]) + (((double) x) * xbs)) / div;
                        ro[x] = ((double) rgb[0]) + (((double) x) * xrs);
                        go[x] = ((double) rgb[1]) + (((double) x) * xgs);
                        bo[x] = ((double) rgb[2]) + (((double) x) * xbs);
                        this.f3193r = (int) ro[x];
                        this.f3194g = (int) go[x];
                        this.f3195b = (int) bo[x];
                    } else {
                        this.f3193r = (int) (ro[x] - (((double) y) * yrs[x]));
                        this.f3194g = (int) (go[x] - (((double) y) * ygs[x]));
                        this.f3195b = (int) (bo[x] - (((double) y) * ybs[x]));
                    }
                    String col = String.format("%02x%02x%02x", Integer.valueOf(this.f3193r), Integer.valueOf(this.f3194g), Integer.valueOf(this.f3195b));
                    asb.style(new StyleResolver(this::getStyleRGB).resolve(".rgb" + col));
                    asb.append((CharSequence) " ").append((CharSequence) LineReaderImpl.DEFAULT_COMMENT_BEGIN).append((CharSequence) col).append((CharSequence) " ");
                }
                asb.style(AttributedStyle.DEFAULT).append((CharSequence) "\n");
            }
            asb.toAttributedString().println(this.terminal);
            if (hueAngle2 != -1) {
                int zero = (int) (((double) hueAngle2) - ((((double) 5) / 2.0d) * ((double) (barSize - 1))));
                int zero2 = zero - (zero % 5);
                AttributedStringBuilder asb2 = new AttributedStringBuilder();
                for (int i5 = 0; i5 < barSize; i5++) {
                    int angle = zero2 + (5 * i5);
                    while (angle < 0) {
                        angle += 360;
                    }
                    while (angle > 360) {
                        angle -= 360;
                    }
                    int[] rgb2 = hue2rgb(angle);
                    this.f3193r = rgb2[0];
                    this.f3194g = rgb2[1];
                    this.f3195b = rgb2[2];
                    asb2.style(new StyleResolver(this::getStyleRGB).resolve(".hue" + angle));
                    asb2.append((CharSequence) " ").append((CharSequence) addPadding(3, "" + angle)).append((CharSequence) " ");
                }
                asb2.style(AttributedStyle.DEFAULT).append((CharSequence) "\n");
                asb2.toAttributedString().println(this.terminal);
            }
        }
    }
}
