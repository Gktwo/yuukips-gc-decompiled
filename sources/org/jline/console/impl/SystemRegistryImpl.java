package org.jline.console.impl;

import dev.morphia.mapping.Mapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jline.builtins.Completers;
import org.jline.builtins.ConfigurationPath;
import org.jline.builtins.Options;
import org.jline.builtins.Styles;
import org.jline.console.ArgDesc;
import org.jline.console.CmdDesc;
import org.jline.console.CmdLine;
import org.jline.console.CommandInput;
import org.jline.console.CommandMethods;
import org.jline.console.CommandRegistry;
import org.jline.console.ConsoleEngine;
import org.jline.console.SystemRegistry;
import org.jline.keymap.KeyMap;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.Parser;
import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.reader.impl.completer.SystemCompleter;
import org.jline.terminal.Attributes;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.Log;
import org.jline.utils.OSUtils;
import org.jline.utils.StyleResolver;
import p001ch.qos.logback.classic.net.SyslogAppender;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl.class */
public class SystemRegistryImpl implements SystemRegistry {
    private static final Class<?>[] BUILTIN_REGISTRIES;
    private CommandRegistry[] commandRegistries;
    private Integer consoleId;
    protected final Parser parser;
    protected final ConfigurationPath configPath;
    protected final Supplier<Path> workDir;
    private Exception exception;
    private final CommandOutputStream outputStream;
    private Function<CmdLine, CmdDesc> scriptDescription;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Map<String, CommandRegistry> subcommands = new HashMap();
    private final Map<Pipe, String> pipeName = new HashMap();
    private final Map<String, CommandMethods> commandExecute = new HashMap();
    private final Map<String, List<String>> commandInfos = new HashMap();
    private ScriptStore scriptStore = new ScriptStore();
    private NamesAndValues names = new NamesAndValues(this);
    private final SystemCompleter customSystemCompleter = new SystemCompleter();
    private final AggregateCompleter customAggregateCompleter = new AggregateCompleter(new ArrayList());
    private boolean commandGroups = true;

    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$Pipe.class */
    public enum Pipe {
        FLIP,
        NAMED,
        AND,
        OR
    }

    static {
        $assertionsDisabled = !SystemRegistryImpl.class.desiredAssertionStatus();
        BUILTIN_REGISTRIES = new Class[]{Builtins.class, ConsoleEngineImpl.class};
    }

    public SystemRegistryImpl(Parser parser, Terminal terminal, Supplier<Path> workDir, ConfigurationPath configPath) {
        this.parser = parser;
        this.workDir = workDir;
        this.configPath = configPath;
        this.outputStream = new CommandOutputStream(terminal);
        this.pipeName.put(Pipe.FLIP, "|;");
        this.pipeName.put(Pipe.NAMED, "|");
        this.pipeName.put(Pipe.AND, "&&");
        this.pipeName.put(Pipe.OR, "||");
        this.commandExecute.put("exit", new CommandMethods(this::exit, this::exitCompleter));
        this.commandExecute.put("help", new CommandMethods(this::help, this::helpCompleter));
    }

    public void rename(Pipe pipe, String name) {
        if (name.matches("/w+") || this.pipeName.containsValue(name)) {
            throw new IllegalArgumentException();
        }
        this.pipeName.put(pipe, name);
    }

    @Override // org.jline.console.SystemRegistry
    public Collection<String> getPipeNames() {
        return this.pipeName.values();
    }

    @Override // org.jline.console.SystemRegistry
    public void setCommandRegistries(CommandRegistry... commandRegistries) {
        this.commandRegistries = commandRegistries;
        for (int i = 0; i < commandRegistries.length; i++) {
            if (commandRegistries[i] instanceof ConsoleEngine) {
                if (this.consoleId != null) {
                    throw new IllegalArgumentException();
                }
                this.consoleId = Integer.valueOf(i);
                ((ConsoleEngine) commandRegistries[i]).setSystemRegistry(this);
                this.scriptStore = new ScriptStore((ConsoleEngine) commandRegistries[i]);
                this.names = new NamesAndValues(this.configPath);
            } else if (commandRegistries[i] instanceof SystemRegistry) {
                throw new IllegalArgumentException();
            }
        }
        SystemRegistry.add(this);
    }

    @Override // org.jline.console.SystemRegistry
    public void initialize(File script) {
        if (this.consoleId != null) {
            try {
                consoleEngine().execute(script);
            } catch (Exception e) {
                trace(e);
            }
        }
    }

    @Override // org.jline.console.CommandRegistry
    public Set<String> commandNames() {
        Set<String> out = new HashSet<>();
        for (CommandRegistry r : this.commandRegistries) {
            out.addAll(r.commandNames());
        }
        out.addAll(localCommandNames());
        return out;
    }

    private Set<String> localCommandNames() {
        return this.commandExecute.keySet();
    }

    @Override // org.jline.console.CommandRegistry
    public Map<String, String> commandAliases() {
        Map<String, String> out = new HashMap<>();
        for (CommandRegistry r : this.commandRegistries) {
            out.putAll(r.commandAliases());
        }
        return out;
    }

    @Override // org.jline.console.SystemRegistry, org.jline.builtins.ConsoleOptionGetter
    public Object consoleOption(String name) {
        Object out = null;
        if (this.consoleId != null) {
            out = consoleEngine().consoleOption(name, null);
        }
        return out;
    }

    @Override // org.jline.console.SystemRegistry
    public void register(String command, CommandRegistry subcommandRegistry) {
        this.subcommands.put(command, subcommandRegistry);
        this.commandExecute.put(command, new CommandMethods(this::subcommand, this::emptyCompleter));
    }

    private List<String> localCommandInfo(String command) {
        try {
            if (this.subcommands.containsKey(command)) {
                registryHelp(this.subcommands.get(command));
            } else {
                localExecute(command, new String[]{"--help"});
            }
        } catch (Options.HelpException e) {
            this.exception = null;
            return JlineCommandRegistry.compileCommandInfo(e.getMessage());
        } catch (Exception e2) {
            trace(e2);
        }
        return new ArrayList();
    }

    @Override // org.jline.console.CommandRegistry
    public List<String> commandInfo(String command) {
        int id = registryId(command);
        List<String> out = new ArrayList();
        if (id > -1) {
            if (!this.commandInfos.containsKey(command)) {
                this.commandInfos.put(command, this.commandRegistries[id].commandInfo(command));
            }
            out = this.commandInfos.get(command);
        } else if (this.scriptStore.hasScript(command) && consoleEngine() != null) {
            out = consoleEngine().commandInfo(command);
        } else if (isLocalCommand(command)) {
            out = localCommandInfo(command);
        }
        return out;
    }

    @Override // org.jline.console.CommandRegistry
    public boolean hasCommand(String command) {
        return registryId(command) > -1 || isLocalCommand(command);
    }

    public void setGroupCommandsInHelp(boolean commandGroups) {
        this.commandGroups = commandGroups;
    }

    public SystemRegistryImpl groupCommandsInHelp(boolean commandGroups) {
        this.commandGroups = commandGroups;
        return this;
    }

    private boolean isLocalCommand(String command) {
        return this.commandExecute.containsKey(command);
    }

    @Override // org.jline.console.SystemRegistry
    public boolean isCommandOrScript(ParsedLine line) {
        return isCommandOrScript(this.parser.getCommand(line.words().get(0)));
    }

    @Override // org.jline.console.SystemRegistry
    public boolean isCommandOrScript(String command) {
        if (hasCommand(command)) {
            return true;
        }
        return this.scriptStore.hasScript(command);
    }

    public void addCompleter(Completer completer) {
        if (completer instanceof SystemCompleter) {
            SystemCompleter sc = (SystemCompleter) completer;
            if (sc.isCompiled()) {
                this.customAggregateCompleter.getCompleters().add(sc);
            } else {
                this.customSystemCompleter.add(sc);
            }
        } else {
            this.customAggregateCompleter.getCompleters().add(completer);
        }
    }

    @Override // org.jline.console.CommandRegistry
    public SystemCompleter compileCompleters() {
        throw new IllegalStateException("Use method completer() to retrieve Completer!");
    }

    private SystemCompleter _compileCompleters() {
        SystemCompleter out = CommandRegistry.aggregateCompleters(this.commandRegistries);
        SystemCompleter local = new SystemCompleter();
        for (String command : this.commandExecute.keySet()) {
            if (this.subcommands.containsKey(command)) {
                for (Map.Entry<String, List<Completer>> entry : this.subcommands.get(command).compileCompleters().getCompleters().entrySet()) {
                    for (Completer cc : entry.getValue()) {
                        if (!(cc instanceof ArgumentCompleter)) {
                            throw new IllegalArgumentException();
                        }
                        List<Completer> cmps = ((ArgumentCompleter) cc).getCompleters();
                        cmps.add(0, NullCompleter.INSTANCE);
                        cmps.set(1, new StringsCompleter(entry.getKey()));
                        Completer last = cmps.get(cmps.size() - 1);
                        if (last instanceof Completers.OptionCompleter) {
                            ((Completers.OptionCompleter) last).setStartPos(cmps.size() - 1);
                            cmps.set(cmps.size() - 1, last);
                        }
                        local.add(command, new ArgumentCompleter(cmps));
                    }
                }
                continue;
            } else {
                local.add(command, this.commandExecute.get(command).compileCompleter().apply(command));
            }
        }
        local.add(this.customSystemCompleter);
        out.add(local);
        out.compile();
        return out;
    }

    @Override // org.jline.console.SystemRegistry
    public Completer completer() {
        List<Completer> completers = new ArrayList<>();
        completers.add(_compileCompleters());
        completers.add(this.customAggregateCompleter);
        if (this.consoleId != null) {
            completers.addAll(consoleEngine().scriptCompleters());
            completers.add(new PipelineCompleter(this.workDir, this.pipeName, this.names).doCompleter());
        }
        return new AggregateCompleter(completers);
    }

    private CmdDesc localCommandDescription(String command) {
        if (!isLocalCommand(command)) {
            throw new IllegalArgumentException();
        }
        try {
            localExecute(command, new String[]{"--help"});
            return null;
        } catch (Options.HelpException e) {
            this.exception = null;
            return JlineCommandRegistry.compileCommandDescription(e.getMessage());
        } catch (Exception e2) {
            trace(e2);
            return null;
        }
    }

    @Override // org.jline.console.CommandRegistry
    public CmdDesc commandDescription(List<String> args) {
        CmdDesc out = new CmdDesc(false);
        String command = args.get(0);
        int id = registryId(command);
        if (id > -1) {
            out = this.commandRegistries[id].commandDescription(args);
        } else if (this.scriptStore.hasScript(command) && consoleEngine() != null) {
            out = consoleEngine().commandDescription(args);
        } else if (isLocalCommand(command)) {
            out = localCommandDescription(command);
        }
        return out;
    }

    private CmdDesc commandDescription(CommandRegistry subreg) {
        List<AttributedString> main = new ArrayList<>();
        Map<String, List<AttributedString>> options = new HashMap<>();
        StyleResolver helpStyle = Styles.helpStyle();
        Iterator it = new TreeSet(subreg.commandNames()).iterator();
        while (it.hasNext()) {
            String sc = (String) it.next();
            Iterator<String> it2 = subreg.commandInfo(sc).iterator();
            if (it2.hasNext()) {
                main.add(Options.HelpException.highlightSyntax(sc + " -  " + it2.next(), helpStyle, true));
            }
        }
        return new CmdDesc(main, ArgDesc.doArgNames(Collections.singletonList("")), options);
    }

    public void setScriptDescription(Function<CmdLine, CmdDesc> scriptDescription) {
        this.scriptDescription = scriptDescription;
    }

    @Override // org.jline.console.SystemRegistry
    public CmdDesc commandDescription(CmdLine line) {
        CmdDesc out = null;
        String cmd = this.parser.getCommand(line.getArgs().get(0));
        switch (line.getDescriptionType()) {
            case COMMAND:
                if (isCommandOrScript(cmd) && !this.names.hasPipes(line.getArgs())) {
                    List<String> args = line.getArgs();
                    if (!this.subcommands.containsKey(cmd)) {
                        args.set(0, cmd);
                        out = commandDescription(args);
                        break;
                    } else {
                        String c = args.size() > 1 ? args.get(1) : null;
                        if (c != null && !this.subcommands.get(cmd).hasCommand(c)) {
                            out = commandDescription(this.subcommands.get(cmd));
                        } else if (c != null && c.equals("help")) {
                            out = null;
                        } else if (c != null) {
                            out = this.subcommands.get(cmd).commandDescription(Collections.singletonList(c));
                        } else {
                            out = commandDescription(this.subcommands.get(cmd));
                        }
                        if (out != null) {
                            out.setSubcommand(true);
                            break;
                        }
                    }
                }
                break;
            case METHOD:
            case SYNTAX:
                if (!isCommandOrScript(cmd)) {
                    out = this.scriptDescription.apply(line);
                    break;
                }
                break;
        }
        return out;
    }

    @Override // org.jline.console.SystemRegistry
    public Object invoke(String command, Object... args) throws Exception {
        Object out = null;
        String command2 = ConsoleEngine.plainCommand(command);
        Object[] args2 = args == null ? new Object[]{null} : args;
        int id = registryId(command2);
        if (id > -1) {
            out = this.commandRegistries[id].invoke(commandSession(), command2, args2);
        } else if (isLocalCommand(command2)) {
            out = localExecute(command2, args2);
        } else if (this.consoleId != null) {
            out = consoleEngine().invoke(commandSession(), command2, args2);
        }
        return out;
    }

    private Object localExecute(String command, Object[] args) throws Exception {
        if (!isLocalCommand(command)) {
            throw new IllegalArgumentException();
        }
        Object out = this.commandExecute.get(command).execute().apply(new CommandInput(command, args, commandSession()));
        if (this.exception == null) {
            return out;
        }
        throw this.exception;
    }

    @Override // org.jline.console.SystemRegistry
    public Terminal terminal() {
        return commandSession().terminal();
    }

    private CommandRegistry.CommandSession commandSession() {
        return this.outputStream.getCommandSession();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$CommandOutputStream.class */
    public static class CommandOutputStream {
        private final Terminal origTerminal;
        private OutputStream outputStream;
        private Terminal terminal;
        private String output;
        private CommandRegistry.CommandSession commandSession;
        private boolean redirecting = false;
        private final PrintStream origOut = System.out;
        private final PrintStream origErr = System.err;

        public CommandOutputStream(Terminal terminal) {
            this.origTerminal = terminal;
            this.terminal = terminal;
            PrintStream ps = new PrintStream(terminal.output());
            this.commandSession = new CommandRegistry.CommandSession(terminal, terminal.input(), ps, ps);
        }

        public void redirect() {
            this.outputStream = new ByteArrayOutputStream();
        }

        public void redirect(File file, boolean append) throws IOException {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    new File(file.getParent()).mkdirs();
                    file.createNewFile();
                }
            }
            this.outputStream = new FileOutputStream(file, append);
        }

        public void open() throws IOException {
            if (!this.redirecting && this.outputStream != null) {
                this.output = null;
                PrintStream out = new PrintStream(this.outputStream);
                System.setOut(out);
                System.setErr(out);
                InputStream in = new ByteArrayInputStream((KeyMap.ctrl('X') + "q").getBytes());
                Attributes attrs = new Attributes();
                if (OSUtils.IS_WINDOWS) {
                    attrs.setInputFlag(Attributes.InputFlag.IGNCR, true);
                }
                try {
                    this.terminal = TerminalBuilder.builder().streams(in, this.outputStream).attributes(attrs).jna(false).jansi(false).type("dumb").build();
                    this.commandSession = new CommandRegistry.CommandSession(this.terminal, this.terminal.input(), out, out);
                    this.redirecting = true;
                } catch (IOException e) {
                    reset();
                    throw e;
                }
            }
        }

        public void close() {
            if (this.redirecting) {
                try {
                    this.terminal.flush();
                    if (this.outputStream instanceof ByteArrayOutputStream) {
                        this.output = this.outputStream.toString();
                    }
                    this.terminal.close();
                } catch (Exception e) {
                }
                reset();
            }
        }

        public void resetOutput() {
            this.output = null;
        }

        private void reset() {
            this.outputStream = null;
            System.setOut(this.origOut);
            System.setErr(this.origErr);
            this.terminal = null;
            this.terminal = this.origTerminal;
            PrintStream ps = new PrintStream(this.terminal.output());
            this.commandSession = new CommandRegistry.CommandSession(this.terminal, this.terminal.input(), ps, ps);
            this.redirecting = false;
        }

        public CommandRegistry.CommandSession getCommandSession() {
            return this.commandSession;
        }

        public String getOutput() {
            return this.output;
        }

        public boolean isRedirecting() {
            return this.redirecting;
        }

        public boolean isByteOutputStream() {
            return this.outputStream instanceof ByteArrayOutputStream;
        }
    }

    @Override // org.jline.console.SystemRegistry
    public boolean isCommandAlias(String command) {
        if (consoleEngine() == null) {
            return false;
        }
        ConsoleEngine consoleEngine = consoleEngine();
        if (!this.parser.validCommandName(command) || !consoleEngine.hasAlias(command)) {
            return false;
        }
        return !this.names.isPipe(consoleEngine.getAlias(command).split("\\s+")[0]);
    }

    private String replaceCommandAlias(String variable, String command, String rawLine) {
        ConsoleEngine consoleEngine = consoleEngine();
        if ($assertionsDisabled || consoleEngine != null) {
            return variable == null ? rawLine.replaceFirst(command + "(\\b|$)", consoleEngine.getAlias(command)) : rawLine.replaceFirst("=" + command + "(\\b|$)", "=" + consoleEngine.getAlias(command));
        }
        throw new AssertionError();
    }

    private String replacePipeAlias(ArgsParser ap, String pipeAlias, List<String> args, Map<String, List<String>> customPipes) {
        ConsoleEngine consoleEngine = consoleEngine();
        if ($assertionsDisabled || consoleEngine != null) {
            String alias = pipeAlias;
            for (int j = 0; j < args.size(); j++) {
                alias = alias.replaceAll("\\s\\$" + j + "\\b", " " + args.get(j)).replaceAll("\\$\\{" + j + "(|:-.*)}", args.get(j));
            }
            String alias2 = alias.replaceAll("\\$\\{@}", consoleEngine.expandToList(args)).replaceAll("\\$@", consoleEngine.expandToList(args)).replaceAll("\\s+\\$\\d\\b", "").replaceAll("\\s+\\$\\{\\d+}", "").replaceAll("\\$\\{\\d+}", "");
            Matcher matcher = Pattern.compile("\\$\\{\\d+:-(.*?)}").matcher(alias2);
            if (matcher.find()) {
                alias2 = matcher.replaceAll("$1");
            }
            ap.parse(alias2);
            List<String> ws = ap.args();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < ws.size()) {
                if (!ws.get(i).equals(this.pipeName.get(Pipe.NAMED))) {
                    sb.append(ws.get(i)).append(' ');
                } else if (i + 1 >= ws.size() || !consoleEngine.hasAlias(ws.get(i + 1))) {
                    sb.append(ws.get(i)).append(' ');
                } else {
                    args.clear();
                    i++;
                    String innerPipe = consoleEngine.getAlias(ws.get(i));
                    while (i < ws.size() - 1 && !this.names.isPipe(ws.get(i + 1), customPipes.keySet())) {
                        i++;
                        args.add(ws.get(i));
                    }
                    sb.append(replacePipeAlias(ap, innerPipe, args, customPipes));
                }
                i++;
            }
            return sb.toString();
        }
        throw new AssertionError();
    }

    private void replacePipeAliases(ConsoleEngine consoleEngine, Map<String, List<String>> customPipes, ArgsParser ap) {
        List<String> words = ap.args();
        if (consoleEngine != null && words.contains(this.pipeName.get(Pipe.NAMED))) {
            StringBuilder sb = new StringBuilder();
            boolean trace = false;
            int i = 0;
            while (i < words.size()) {
                if (!words.get(i).equals(this.pipeName.get(Pipe.NAMED))) {
                    sb.append(words.get(i)).append(' ');
                } else if (i + 1 >= words.size() || !consoleEngine.hasAlias(words.get(i + 1))) {
                    sb.append(words.get(i)).append(' ');
                } else {
                    trace = true;
                    List<String> args = new ArrayList<>();
                    i++;
                    String pipeAlias = consoleEngine.getAlias(words.get(i));
                    while (i < words.size() - 1 && !this.names.isPipe(words.get(i + 1), customPipes.keySet())) {
                        i++;
                        args.add(words.get(i));
                    }
                    sb.append(replacePipeAlias(ap, pipeAlias, args, customPipes));
                }
                i++;
            }
            ap.parse(sb.toString());
            if (trace) {
                consoleEngine.trace(ap.line());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0197, code lost:
        r0.add(r19.get(r35));
        r31 = r19.get(r35).equals(">>");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x01c4, code lost:
        if ((r35 + 1) < r22) goto L_0x01cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x01ce, code lost:
        throw new java.lang.IllegalArgumentException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01cf, code lost:
        r30 = redirectFile(r19.get(r35 + 1));
        r22 = r35 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x02c3, code lost:
        r36 = r19.get(r35);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x02e2, code lost:
        if (r36.equals(r13.pipeName.get(org.jline.console.impl.SystemRegistryImpl.Pipe.NAMED)) == false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x02eb, code lost:
        if ((r35 + 1) < r22) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x02f7, code lost:
        throw new java.lang.IllegalArgumentException("Pipe is NULL!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x02f8, code lost:
        r36 = r19.get(r35 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x030f, code lost:
        if (r36.matches("\\w+") == false) goto L_0x031e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x031b, code lost:
        if (r0.containsKey(r36) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0339, code lost:
        throw new java.lang.IllegalArgumentException("Unknown or illegal pipe name: " + r36);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x033a, code lost:
        r0.add(r36);
        r22 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x034a, code lost:
        if (r24 != null) goto L_0x04a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x034d, code lost:
        r24 = "_pipe" + (r0.size() - 1);
        r26 = r29;
        r29 = r24;
        r32 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<org.jline.console.impl.SystemRegistryImpl.CommandData> compileCommandLine(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 2078
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.console.impl.SystemRegistryImpl.compileCommandLine(java.lang.String):java.util.List");
    }

    private File redirectFile(String name) {
        File out;
        if (name.equals("null")) {
            out = OSUtils.IS_WINDOWS ? new File("NUL") : new File("/dev/null");
        } else {
            out = new File(name);
        }
        return out;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$ArgsParser.class */
    public static class ArgsParser {
        private int round = 0;
        private int curly = 0;
        private int square = 0;
        private boolean quoted;
        private boolean doubleQuoted;
        private String line;
        private String command;
        private String variable;
        private List<String> args;
        private final Parser parser;

        public ArgsParser(Parser parser) {
            this.parser = parser;
        }

        private void reset() {
            this.round = 0;
            this.curly = 0;
            this.square = 0;
            this.quoted = false;
            this.doubleQuoted = false;
        }

        private void next(String arg) {
            char prevChar = ' ';
            for (int i = 0; i < arg.length(); i++) {
                char c = arg.charAt(i);
                if (!this.parser.isEscapeChar(prevChar)) {
                    if (this.quoted || this.doubleQuoted) {
                        if (this.quoted && c == '\'') {
                            this.quoted = false;
                        } else if (this.doubleQuoted && c == '\"') {
                            this.doubleQuoted = false;
                        }
                    } else if (c == '(') {
                        this.round++;
                    } else if (c == ')') {
                        this.round--;
                    } else if (c == '{') {
                        this.curly++;
                    } else if (c == '}') {
                        this.curly--;
                    } else if (c == '[') {
                        this.square++;
                    } else if (c == ']') {
                        this.square--;
                    } else if (c == '\"') {
                        this.doubleQuoted = true;
                    } else if (c == '\'') {
                        this.quoted = true;
                    }
                }
                prevChar = c;
            }
        }

        private boolean isEnclosed() {
            return this.round == 0 && this.curly == 0 && this.square == 0 && !this.quoted && !this.doubleQuoted;
        }

        public boolean isEnclosed(String arg) {
            reset();
            next(arg);
            return isEnclosed();
        }

        private void enclosedArgs(List<String> words) {
            this.args = new ArrayList();
            reset();
            boolean first = true;
            StringBuilder sb = new StringBuilder();
            for (String a : words) {
                next(a);
                if (!first) {
                    sb.append(" ");
                }
                if (isEnclosed()) {
                    sb.append(a);
                    this.args.add(sb.toString());
                    sb = new StringBuilder();
                    first = true;
                } else {
                    sb.append(a);
                    first = false;
                }
            }
            if (!first) {
                this.args.add(sb.toString());
            }
        }

        public void parse(String line) {
            this.line = line;
            enclosedArgs(this.parser.parse(line, 0, Parser.ParseContext.SPLIT_LINE).words());
            this.command = this.parser.getCommand(this.args.get(0));
            if (!this.parser.validCommandName(this.command)) {
                this.command = "";
            }
            this.variable = this.parser.getVariable(this.args.get(0));
        }

        public String line() {
            return this.line;
        }

        public String command() {
            return ConsoleEngine.plainCommand(this.command);
        }

        public String rawCommand() {
            return this.command;
        }

        public String variable() {
            return this.variable;
        }

        public List<String> args() {
            return this.args;
        }

        private int closingQuote(String arg) {
            int out = -1;
            char prevChar = ' ';
            int i = 1;
            while (true) {
                if (i >= arg.length()) {
                    break;
                }
                char c = arg.charAt(i);
                if (!this.parser.isEscapeChar(prevChar) && c == arg.charAt(0)) {
                    out = i;
                    break;
                }
                prevChar = c;
                i++;
            }
            return out;
        }

        /* access modifiers changed from: private */
        public String unquote(String arg) {
            if (((arg.length() <= 1 || !arg.startsWith("\"") || !arg.endsWith("\"")) && (!arg.startsWith("'") || !arg.endsWith("'"))) || closingQuote(arg) != arg.length() - 1) {
                return arg;
            }
            return arg.substring(1, arg.length() - 1);
        }
    }

    private String flipArgument(String command, String subLine, List<String> pipes, List<String> arglist) {
        String out;
        if (pipes.size() <= 1 || !pipes.get(pipes.size() - 2).equals(this.pipeName.get(Pipe.FLIP))) {
            out = subLine;
        } else {
            String s = isCommandOrScript(command) ? "$" : "";
            out = subLine + " " + s + "_pipe" + (pipes.size() - 2);
            if (!command.isEmpty()) {
                arglist.add(s + "_pipe" + (pipes.size() - 2));
            }
        }
        return out;
    }

    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$CommandData.class */
    protected static class CommandData {
        private final String rawLine;
        private String command;
        private String[] args;
        private final File file;
        private final boolean append;
        private final String variable;
        private String pipe;

        public CommandData(ArgsParser parser, boolean statement, String rawLine, String variable, File file, boolean append, String pipe) {
            this.rawLine = rawLine;
            this.variable = variable;
            this.file = file;
            this.append = append;
            this.pipe = pipe;
            this.args = new String[0];
            this.command = "";
            if (!statement) {
                parser.parse(rawLine);
                this.command = parser.command();
                if (parser.args().size() > 1) {
                    this.args = new String[parser.args().size() - 1];
                    for (int i = 1; i < parser.args().size(); i++) {
                        this.args[i - 1] = parser.unquote(parser.args().get(i));
                    }
                }
            }
        }

        public void setPipe(String pipe) {
            this.pipe = pipe;
        }

        public File file() {
            return this.file;
        }

        public boolean append() {
            return this.append;
        }

        public String variable() {
            return this.variable;
        }

        public String command() {
            return this.command;
        }

        public String[] args() {
            return this.args;
        }

        public String rawLine() {
            return this.rawLine;
        }

        public String pipe() {
            return this.pipe;
        }

        public String toString() {
            return "[rawLine:" + this.rawLine + ", command:" + this.command + ", args:" + Arrays.asList(this.args) + ", variable:" + this.variable + ", file:" + this.file + ", append:" + this.append + ", pipe:" + this.pipe + "]";
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$ScriptStore.class */
    public static class ScriptStore {
        ConsoleEngine engine;
        Map<String, Boolean> scripts = new HashMap();

        public ScriptStore() {
        }

        public ScriptStore(ConsoleEngine engine) {
            this.engine = engine;
        }

        public void refresh() {
            if (this.engine != null) {
                this.scripts = this.engine.scripts();
            }
        }

        public boolean hasScript(String name) {
            return this.scripts.containsKey(name);
        }

        public boolean isConsoleScript(String name) {
            return this.scripts.getOrDefault(name, false).booleanValue();
        }

        public Set<String> getScripts() {
            return this.scripts.keySet();
        }
    }

    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$UnknownCommandException.class */
    public static class UnknownCommandException extends Exception {
        public UnknownCommandException(String message) {
            super(message);
        }
    }

    private Object execute(String command, String rawLine, String[] args) throws Exception {
        Object out;
        if (!this.parser.validCommandName(command)) {
            throw new UnknownCommandException("Invalid command: " + rawLine);
        }
        if (isLocalCommand(command)) {
            out = localExecute(command, this.consoleId != null ? consoleEngine().expandParameters(args) : args);
        } else {
            int id = registryId(command);
            if (id > -1) {
                out = this.commandRegistries[id].invoke(this.outputStream.getCommandSession(), command, this.consoleId != null ? consoleEngine().expandParameters(args) : args);
            } else if (!this.scriptStore.hasScript(command) || consoleEngine() == null) {
                throw new UnknownCommandException("Unknown command: " + command);
            } else {
                out = consoleEngine().execute(command, rawLine, args);
            }
        }
        return out;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:35:0x0108
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.jline.console.SystemRegistry
    public java.lang.Object execute(java.lang.String r9) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 774
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.console.impl.SystemRegistryImpl.execute(java.lang.String):java.lang.Object");
    }

    private ConsoleEngine.ExecutionResult postProcess(CommandData cmd, boolean statement, ConsoleEngine consoleEngine, Object result) {
        ConsoleEngine.ExecutionResult out;
        ConsoleEngine.ExecutionResult out2;
        if (cmd.file() != null) {
            int status = 1;
            if (cmd.file().exists()) {
                status = new Date().getTime() - cmd.file().lastModified() < 100 ? 0 : 1;
            }
            out = new ConsoleEngine.ExecutionResult(status, result);
        } else if (!statement) {
            this.outputStream.close();
            out = consoleEngine.postProcess(cmd.rawLine(), result, this.outputStream.getOutput());
        } else if (cmd.variable() != null) {
            if (consoleEngine.hasVariable(cmd.variable())) {
                out2 = consoleEngine.postProcess(consoleEngine.getVariable(cmd.variable()));
            } else {
                out2 = consoleEngine.postProcess(result);
            }
            out = new ConsoleEngine.ExecutionResult(out2.status(), null);
        } else {
            out = consoleEngine.postProcess(result);
        }
        return out;
    }

    @Override // org.jline.console.SystemRegistry
    public void cleanUp() {
        this.outputStream.close();
        this.outputStream.resetOutput();
        if (consoleEngine() != null) {
            consoleEngine().purge();
        }
    }

    private void trace(CommandData commandData) {
        if (consoleEngine() != null) {
            consoleEngine().trace(commandData);
        } else {
            new AttributedStringBuilder().append(commandData.rawLine(), AttributedStyle.DEFAULT.foreground(3)).println(terminal());
        }
    }

    @Override // org.jline.console.SystemRegistry
    public void trace(Throwable exception) {
        this.outputStream.close();
        ConsoleEngine consoleEngine = consoleEngine();
        if (consoleEngine != null) {
            if (!(exception instanceof Options.HelpException)) {
                consoleEngine.putVariable("exception", exception);
            }
            consoleEngine.trace(exception);
            return;
        }
        trace(false, exception);
    }

    @Override // org.jline.console.SystemRegistry
    public void trace(boolean stack, Throwable exception) {
        if (exception instanceof Options.HelpException) {
            Options.HelpException.highlight(exception.getMessage(), Styles.helpStyle()).print(terminal());
        } else if (exception instanceof UnknownCommandException) {
            AttributedStringBuilder asb = new AttributedStringBuilder();
            asb.append(exception.getMessage(), Styles.prntStyle().resolve(".em"));
            asb.toAttributedString().println(terminal());
        } else if (stack) {
            exception.printStackTrace();
        } else {
            String message = exception.getMessage();
            AttributedStringBuilder asb2 = new AttributedStringBuilder();
            asb2.style(Styles.prntStyle().resolve(".em"));
            if (message != null) {
                asb2.append((CharSequence) exception.getClass().getSimpleName()).append((CharSequence) ": ").append((CharSequence) message);
            } else {
                asb2.append((CharSequence) "Caught exception: ");
                asb2.append((CharSequence) exception.getClass().getCanonicalName());
            }
            asb2.toAttributedString().println(terminal());
            Log.debug("Stack: ", exception);
        }
    }

    @Override // org.jline.console.SystemRegistry
    public void close() {
        this.names.save();
    }

    public ConsoleEngine consoleEngine() {
        if (this.consoleId != null) {
            return (ConsoleEngine) this.commandRegistries[this.consoleId.intValue()];
        }
        return null;
    }

    private boolean isBuiltinRegistry(CommandRegistry registry) {
        for (Class<?> c : BUILTIN_REGISTRIES) {
            if (c == registry.getClass()) {
                return true;
            }
        }
        return false;
    }

    private void printHeader(String header) {
        AttributedStringBuilder asb = new AttributedStringBuilder().tabs(2);
        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
        asb.append(header, Options.HelpException.defaultStyle().resolve(".ti"));
        asb.append((CharSequence) EmitterKt.COMMENT_PREFIX);
        asb.toAttributedString().println(terminal());
    }

    private void printCommandInfo(String command, String info, int max) {
        AttributedStringBuilder asb = new AttributedStringBuilder().tabs(Arrays.asList(4, Integer.valueOf(max + 4)));
        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
        asb.append(command, Options.HelpException.defaultStyle().resolve(".co"));
        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
        asb.append((CharSequence) info);
        asb.setLength(terminal().getWidth());
        asb.toAttributedString().println(terminal());
    }

    private void printCommands(Collection<String> commands, int max) {
        AttributedStringBuilder asb = new AttributedStringBuilder().tabs(Arrays.asList(4, Integer.valueOf(max + 4)));
        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
        int col = 0 + 4;
        boolean done = false;
        for (String c : commands) {
            asb.append(c, Options.HelpException.defaultStyle().resolve(".co"));
            asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            col += max;
            if (col + max > terminal().getWidth()) {
                asb.toAttributedString().println(terminal());
                asb = new AttributedStringBuilder().tabs(Arrays.asList(4, Integer.valueOf(max + 4)));
                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                col = 0 + 4;
                done = true;
            } else {
                done = false;
            }
        }
        if (!done) {
            asb.toAttributedString().println(terminal());
        }
        terminal().flush();
    }

    private String doCommandInfo(List<String> info) {
        return (info == null || info.size() <= 0) ? " " : info.get(0);
    }

    private boolean isInTopics(List<String> args, String name) {
        return args.isEmpty() || args.contains(name);
    }

    private Options parseOptions(String[] usage, Object[] args) throws Options.HelpException {
        Options opt = Options.compile(usage).parse(args);
        if (!opt.isSet("help")) {
            return opt;
        }
        throw new Options.HelpException(opt.usage());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x00b9
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private java.lang.Object help(org.jline.console.CommandInput r7) {
        /*
        // Method dump skipped, instructions count: 273
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.console.impl.SystemRegistryImpl.help(org.jline.console.CommandInput):java.lang.Object");
    }

    private void helpTopic(List<String> topics, boolean commandGroups, boolean info) {
        Set<String> commands = commandNames();
        commands.addAll(this.scriptStore.getScripts());
        boolean withInfo = commands.size() < terminal().getHeight() || !topics.isEmpty() || info;
        int max = ((String) Collections.max(commands, Comparator.comparing((v0) -> {
            return v0.length();
        }))).length() + 1;
        TreeMap<String, String> builtinCommands = new TreeMap<>();
        TreeMap<String, String> systemCommands = new TreeMap<>();
        if (commandGroups || !topics.isEmpty()) {
            CommandRegistry[] commandRegistryArr = this.commandRegistries;
            for (CommandRegistry r : commandRegistryArr) {
                if (isBuiltinRegistry(r)) {
                    for (String c : r.commandNames()) {
                        builtinCommands.put(c, doCommandInfo(commandInfo(c)));
                    }
                }
            }
            for (String c2 : localCommandNames()) {
                systemCommands.put(c2, doCommandInfo(commandInfo(c2)));
                this.exception = null;
            }
            if (isInTopics(topics, "System")) {
                printHeader("System");
                if (withInfo) {
                    for (Map.Entry<String, String> entry : systemCommands.entrySet()) {
                        printCommandInfo(entry.getKey(), entry.getValue(), max);
                    }
                } else {
                    printCommands(systemCommands.keySet(), max);
                }
            }
            if (isInTopics(topics, "Builtins") && !builtinCommands.isEmpty()) {
                printHeader("Builtins");
                if (withInfo) {
                    for (Map.Entry<String, String> entry2 : builtinCommands.entrySet()) {
                        printCommandInfo(entry2.getKey(), entry2.getValue(), max);
                    }
                } else {
                    printCommands(builtinCommands.keySet(), max);
                }
            }
            CommandRegistry[] commandRegistryArr2 = this.commandRegistries;
            for (CommandRegistry r2 : commandRegistryArr2) {
                if (!isBuiltinRegistry(r2) && isInTopics(topics, r2.name()) && !r2.commandNames().isEmpty()) {
                    TreeSet<String> cmds = new TreeSet<>(r2.commandNames());
                    printHeader(r2.name());
                    if (withInfo) {
                        Iterator<String> it = cmds.iterator();
                        while (it.hasNext()) {
                            String c3 = it.next();
                            printCommandInfo(c3, doCommandInfo(commandInfo(c3)), max);
                        }
                    } else {
                        printCommands(cmds, max);
                    }
                }
            }
            if (this.consoleId != null && isInTopics(topics, "Scripts") && !this.scriptStore.getScripts().isEmpty()) {
                printHeader("Scripts");
                if (withInfo) {
                    for (String c4 : this.scriptStore.getScripts()) {
                        printCommandInfo(c4, doCommandInfo(commandInfo(c4)), max);
                    }
                } else {
                    printCommands(this.scriptStore.getScripts(), max);
                }
            }
        } else {
            TreeSet<String> ordered = new TreeSet<>(commands);
            if (withInfo) {
                Iterator<String> it2 = ordered.iterator();
                while (it2.hasNext()) {
                    String c5 = it2.next();
                    List<String> infos = commandInfo(c5);
                    printCommandInfo(c5, infos.isEmpty() ? "" : infos.get(0), max);
                }
            } else {
                printCommands(ordered, max);
            }
        }
        terminal().flush();
    }

    private Object exit(CommandInput input) {
        Object argObjects;
        try {
            Options opt = parseOptions(new String[]{"exit -  exit from app/script", "Usage: exit [OBJECT]", "  -? --help                       Displays command help"}, input.xargs());
            ConsoleEngine consoleEngine = consoleEngine();
            if (!opt.argObjects().isEmpty() && consoleEngine != null) {
                if (opt.argObjects().size() == 1) {
                    argObjects = opt.argObjects().get(0);
                } else {
                    try {
                        argObjects = opt.argObjects();
                    } catch (Exception e) {
                        trace(e);
                    }
                }
                consoleEngine.putVariable("_return", argObjects);
            }
            this.exception = new EndOfFileException();
            return null;
        } catch (Exception e2) {
            this.exception = e2;
            return null;
        }
    }

    private void registryHelp(CommandRegistry registry) throws Exception {
        List<Integer> tabs = new ArrayList<>();
        tabs.add(0);
        tabs.add(9);
        tabs.add(Integer.valueOf(10 + ((Integer) registry.commandNames().stream().map((v0) -> {
            return v0.length();
        }).max((v0, v1) -> {
            return v0.compareTo(v1);
        }).get()).intValue()));
        AttributedStringBuilder sb = new AttributedStringBuilder().tabs(tabs);
        sb.append((CharSequence) " -  ");
        sb.append((CharSequence) registry.name());
        sb.append((CharSequence) " registry");
        sb.append((CharSequence) "\n");
        boolean first = true;
        Iterator it = new TreeSet(registry.commandNames()).iterator();
        while (it.hasNext()) {
            String c = (String) it.next();
            if (first) {
                sb.append((CharSequence) "Summary:");
                first = false;
            }
            sb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            sb.append((CharSequence) c);
            sb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            sb.append((CharSequence) registry.commandInfo(c).get(0));
            sb.append((CharSequence) "\n");
        }
        throw new Options.HelpException(sb.toString());
    }

    private Object subcommand(CommandInput input) {
        Object out = null;
        try {
            if (input.args().length <= 0 || !this.subcommands.get(input.command()).hasCommand(input.args()[0])) {
                registryHelp(this.subcommands.get(input.command()));
            } else {
                out = this.subcommands.get(input.command()).invoke(input.session(), input.args()[0], input.xargs().length > 1 ? Arrays.copyOfRange(input.xargs(), 1, input.xargs().length) : new Object[0]);
            }
        } catch (Exception e) {
            this.exception = e;
        }
        return out;
    }

    private List<Completers.OptDesc> commandOptions(String command) {
        try {
            localExecute(command, new String[]{"--help"});
            return null;
        } catch (Options.HelpException e) {
            this.exception = null;
            return JlineCommandRegistry.compileCommandOptions(e.getMessage());
        } catch (Exception e2) {
            trace(e2);
            return null;
        }
    }

    private List<String> registryNames() {
        List<String> out = new ArrayList<>();
        out.add("System");
        out.add("Builtins");
        if (this.consoleId != null) {
            out.add("Scripts");
        }
        CommandRegistry[] commandRegistryArr = this.commandRegistries;
        for (CommandRegistry r : commandRegistryArr) {
            if (!isBuiltinRegistry(r)) {
                out.add(r.name());
            }
        }
        out.addAll(commandNames());
        out.addAll(this.scriptStore.getScripts());
        return out;
    }

    private List<Completer> emptyCompleter(String command) {
        return new ArrayList();
    }

    private List<Completer> helpCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        List<Completer> params = new ArrayList<>();
        params.add(new StringsCompleter(this::registryNames));
        params.add(NullCompleter.INSTANCE);
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(params, this::commandOptions, 1)));
        return completers;
    }

    private List<Completer> exitCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(NullCompleter.INSTANCE, this::commandOptions, 1)));
        return completers;
    }

    private int registryId(String command) {
        for (int i = 0; i < this.commandRegistries.length; i++) {
            if (this.commandRegistries[i].hasCommand(command)) {
                return i;
            }
        }
        return -1;
    }

    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$PipelineCompleter.class */
    private static class PipelineCompleter implements Completer {
        private final NamesAndValues names;
        private final Supplier<Path> workDir;
        private final Map<Pipe, String> pipeName;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !SystemRegistryImpl.class.desiredAssertionStatus();
        }

        public PipelineCompleter(Supplier<Path> workDir, Map<Pipe, String> pipeName, NamesAndValues names) {
            this.workDir = workDir;
            this.pipeName = pipeName;
            this.names = names;
        }

        public Completer doCompleter() {
            ArgumentCompleter out = new ArgumentCompleter(this);
            out.setStrict(false);
            return out;
        }

        @Override // org.jline.reader.Completer
        public void complete(LineReader reader, ParsedLine commandLine, List<Candidate> candidates) {
            if (!$assertionsDisabled && commandLine == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || candidates != null) {
                ArgsParser ap = new ArgsParser(reader.getParser());
                ap.parse(commandLine.line().substring(0, commandLine.cursor()));
                List<String> args = ap.args();
                if (args.size() >= 2 && this.names.hasPipes(args)) {
                    boolean enclosed = ap.isEnclosed(args.get(args.size() - 1));
                    String pWord = commandLine.words().get(commandLine.wordIndex() - 1);
                    if (enclosed && pWord.equals(this.pipeName.get(Pipe.NAMED))) {
                        for (String name : this.names.namedPipes()) {
                            candidates.add(new Candidate(name, name, null, null, null, null, true));
                        }
                    } else if ((!enclosed || !pWord.equals(">")) && !pWord.equals(">>")) {
                        String buffer = commandLine.word().substring(0, commandLine.wordCursor());
                        String param = buffer;
                        String curBuf = "";
                        int lastDelim = this.names.indexOfLastDelim(buffer);
                        if (lastDelim > -1) {
                            param = buffer.substring(lastDelim + 1);
                            curBuf = buffer.substring(0, lastDelim + 1);
                        }
                        if (curBuf.startsWith("--") && !curBuf.contains("=")) {
                            doCandidates(candidates, this.names.options(), curBuf, "", param);
                        } else if (param.length() == 0) {
                            doCandidates(candidates, this.names.fieldsAndValues(), curBuf, "", "");
                        } else if (param.contains(Mapper.IGNORED_FIELDNAME)) {
                            int point = buffer.lastIndexOf(Mapper.IGNORED_FIELDNAME);
                            String param2 = buffer.substring(point + 1);
                            doCandidates(candidates, this.names.fields(), buffer.substring(0, point + 1), "", param2);
                        } else if (this.names.encloseBy(param).length() == 1) {
                            int lastDelim2 = lastDelim + 1;
                            String postFix = this.names.encloseBy(param);
                            String param3 = buffer.substring(lastDelim2 + 1);
                            doCandidates(candidates, this.names.quoted(), buffer.substring(0, lastDelim2 + 1), postFix, param3);
                        } else {
                            doCandidates(candidates, this.names.fieldsAndValues(), curBuf, "", param);
                        }
                    } else {
                        new Completers.FilesCompleter(this.workDir).complete(reader, commandLine, candidates);
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        private void doCandidates(List<Candidate> candidates, Collection<String> fields, String curBuf, String postFix, String hint) {
            if (fields != null) {
                for (String s : fields) {
                    if (s != null && s.startsWith(hint)) {
                        candidates.add(new Candidate(AttributedString.stripAnsi(curBuf + s + postFix), s, null, null, null, null, false));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemRegistryImpl$NamesAndValues.class */
    public class NamesAndValues {
        private final String[] delims;
        private Path fileNames;
        private final Map<String, List<String>> names;
        private List<String> namedPipes;

        public NamesAndValues(SystemRegistryImpl systemRegistryImpl) {
            this(null);
        }

        public NamesAndValues(ConfigurationPath configPath) {
            this.delims = new String[]{"&", "\\|", "\\{", "\\}", "\\[", "\\]", "\\(", "\\)", "\\+", "-", "\\*", "=", ">", "<", "~", "!", EmitterKt.COMMENT_PREFIX, ",", ";"};
            this.names = new HashMap();
            this.names.put("fields", new ArrayList());
            this.names.put("values", new ArrayList());
            this.names.put("quoted", new ArrayList());
            this.names.put("options", new ArrayList());
            ConsoleEngine consoleEngine = SystemRegistryImpl.this.consoleEngine();
            if (configPath != null && consoleEngine != null) {
                try {
                    this.fileNames = configPath.getUserConfig("pipeline-names.json", true);
                    for (Map.Entry<String, List<String>> entry : ((Map) consoleEngine.slurp(this.fileNames)).entrySet()) {
                        this.names.get(entry.getKey()).addAll(entry.getValue());
                    }
                } catch (Exception e) {
                }
            }
        }

        public boolean isPipe(String arg) {
            return isPipe(arg, (SystemRegistryImpl.this.consoleEngine() != null ? SystemRegistryImpl.this.consoleEngine().getPipes() : new HashMap<>()).keySet());
        }

        /* JADX WARNING: Removed duplicated region for block: B:9:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasPipes(java.util.Collection<java.lang.String> r5) {
            /*
                r4 = this;
                r0 = r4
                org.jline.console.impl.SystemRegistryImpl r0 = org.jline.console.impl.SystemRegistryImpl.this
                org.jline.console.ConsoleEngine r0 = r0.consoleEngine()
                if (r0 == 0) goto L_0x0019
                r0 = r4
                org.jline.console.impl.SystemRegistryImpl r0 = org.jline.console.impl.SystemRegistryImpl.this
                org.jline.console.ConsoleEngine r0 = r0.consoleEngine()
                java.util.Map r0 = r0.getPipes()
                goto L_0x0020
            L_0x0019:
                java.util.HashMap r0 = new java.util.HashMap
                r1 = r0
                r1.<init>()
            L_0x0020:
                r6 = r0
                r0 = r5
                java.util.Iterator r0 = r0.iterator()
                r7 = r0
            L_0x0028:
                r0 = r7
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x0064
                r0 = r7
                java.lang.Object r0 = r0.next()
                java.lang.String r0 = (java.lang.String) r0
                r8 = r0
                r0 = r4
                r1 = r8
                r2 = r6
                java.util.Set r2 = r2.keySet()
                boolean r0 = r0.isPipe(r1, r2)
                if (r0 != 0) goto L_0x005f
                r0 = r8
                java.lang.String r1 = ">"
                boolean r0 = r0.contains(r1)
                if (r0 != 0) goto L_0x005f
                r0 = r8
                java.lang.String r1 = ">>"
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L_0x0061
            L_0x005f:
                r0 = 1
                return r0
            L_0x0061:
                goto L_0x0028
            L_0x0064:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.console.impl.SystemRegistryImpl.NamesAndValues.hasPipes(java.util.Collection):boolean");
        }

        /* access modifiers changed from: private */
        public boolean isPipe(String arg, Set<String> pipes) {
            return SystemRegistryImpl.this.pipeName.containsValue(arg) || pipes.contains(arg);
        }

        public void extractNames(String line) {
            if (!SystemRegistryImpl.this.parser.getCommand(line).equals("pipe")) {
                ArgsParser ap = new ArgsParser(SystemRegistryImpl.this.parser);
                ap.parse(line);
                List<String> args = ap.args();
                int pipeId = 0;
                Iterator<String> it = args.iterator();
                while (it.hasNext() && !isPipe(it.next())) {
                    pipeId++;
                }
                if (pipeId < args.size()) {
                    StringBuilder sb = new StringBuilder();
                    int redirectPipe = -1;
                    for (int i = pipeId + 1; i < args.size(); i++) {
                        String arg = args.get(i);
                        if (isPipe(arg) || namedPipes().contains(arg) || arg.matches("\\d+") || redirectPipe == i - 1) {
                            redirectPipe = -1;
                        } else if (arg.equals(">") || arg.equals(">>")) {
                            redirectPipe = i;
                        } else if (arg.matches("\\w+(\\(\\))?")) {
                            addValues(arg);
                        } else if (!arg.matches("--\\w+(=.*|)$") || arg.length() <= 4) {
                            sb.append(arg);
                            sb.append(" ");
                        } else {
                            int idx = arg.indexOf(61);
                            if (idx > 0) {
                                if (idx > 4) {
                                    addOptions(arg.substring(2, idx));
                                }
                                sb.append(arg.substring(idx + 1));
                                sb.append(" ");
                            } else if (idx == -1) {
                                addOptions(arg.substring(2));
                            }
                        }
                    }
                    if (sb.length() > 0) {
                        String rest = sb.toString();
                        for (String d : this.delims) {
                            rest = rest.replaceAll(d, " ");
                        }
                        String[] words = rest.split("\\s+");
                        for (String w : words) {
                            if (w.length() >= 3 && !w.matches("\\d+")) {
                                if (isQuoted(w)) {
                                    addQuoted(w.substring(1, w.length() - 1));
                                } else if (w.contains(Mapper.IGNORED_FIELDNAME)) {
                                    String[] split = w.split("\\.");
                                    for (String f : split) {
                                        if (!f.matches("\\d+") && f.matches("\\w+")) {
                                            addFields(f);
                                        }
                                    }
                                } else if (w.matches("\\w+")) {
                                    addValues(w);
                                }
                            }
                        }
                    }
                }
                this.namedPipes = null;
            }
        }

        public String encloseBy(String param) {
            boolean quoted = param.length() > 0 && (param.startsWith("\"") || param.startsWith("'") || param.startsWith("/"));
            if (quoted && param.length() > 1) {
                quoted = !param.endsWith(Character.toString(param.charAt(0)));
            }
            return quoted ? Character.toString(param.charAt(0)) : "";
        }

        private boolean isQuoted(String word) {
            return word.length() > 1 && ((word.startsWith("\"") && word.endsWith("\"")) || ((word.startsWith("'") && word.endsWith("'")) || (word.startsWith("/") && word.endsWith("/"))));
        }

        public int indexOfLastDelim(String word) {
            int out = -1;
            for (String d : this.delims) {
                int x = word.lastIndexOf(d.replace("\\", ""));
                if (x > out) {
                    out = x;
                }
            }
            return out;
        }

        private void addFields(String field) {
            add("fields", field);
        }

        private void addValues(String arg) {
            add("values", arg);
        }

        private void addQuoted(String arg) {
            add("quoted", arg);
        }

        private void addOptions(String arg) {
            add("options", arg);
        }

        private void add(String where, String value) {
            if (value.length() >= 3) {
                this.names.get(where).remove(value);
                this.names.get(where).add(0, value);
            }
        }

        public List<String> namedPipes() {
            if (this.namedPipes == null) {
                this.namedPipes = SystemRegistryImpl.this.consoleId != null ? SystemRegistryImpl.this.consoleEngine().getNamedPipes() : new ArrayList<>();
            }
            return this.namedPipes;
        }

        public List<String> values() {
            return this.names.get("values");
        }

        public List<String> fields() {
            return this.names.get("fields");
        }

        public List<String> quoted() {
            return this.names.get("quoted");
        }

        public List<String> options() {
            return this.names.get("options");
        }

        /* access modifiers changed from: private */
        public Set<String> fieldsAndValues() {
            Set<String> out = new HashSet<>();
            out.addAll(fields());
            out.addAll(values());
            return out;
        }

        private void truncate(String where, int maxSize) {
            if (this.names.get(where).size() > maxSize) {
                this.names.put(where, this.names.get(where).subList(0, maxSize));
            }
        }

        public void save() {
            ConsoleEngine consoleEngine = SystemRegistryImpl.this.consoleEngine();
            if (consoleEngine != null && this.fileNames != null) {
                int maxSize = ((Integer) consoleEngine.consoleOption("maxValueNames", 100)).intValue();
                truncate("fields", maxSize);
                truncate("values", maxSize);
                truncate("quoted", maxSize);
                truncate("options", maxSize);
                consoleEngine.persist(this.fileNames, this.names);
            }
        }
    }
}
