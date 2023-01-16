package org.jline.console.impl;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import dev.morphia.mapping.Mapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.bytebuddy.utility.JavaConstant;
import org.jline.builtins.Completers;
import org.jline.builtins.ConfigurationPath;
import org.jline.builtins.Options;
import org.jline.builtins.Styles;
import org.jline.console.CommandInput;
import org.jline.console.CommandMethods;
import org.jline.console.CommandRegistry;
import org.jline.console.ConsoleEngine;
import org.jline.console.Printer;
import org.jline.console.ScriptEngine;
import org.jline.console.SystemRegistry;
import org.jline.console.impl.SystemRegistryImpl;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.EOFError;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.Parser;
import org.jline.reader.SyntaxError;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p001ch.qos.logback.core.CoreConstants;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/console/impl/ConsoleEngineImpl.class */
public class ConsoleEngineImpl extends JlineCommandRegistry implements ConsoleEngine {
    private static final String VAR_CONSOLE_OPTIONS = "CONSOLE_OPTIONS";
    private static final String VAR_PATH = "PATH";
    private static final String[] OPTION_HELP = {"-?", "--help"};
    private static final String OPTION_VERBOSE = "-v";
    private static final String SLURP_FORMAT_TEXT = "TEXT";
    private static final String END_HELP = "END_HELP";
    private static final int HELP_MAX_SIZE = 30;
    private final ScriptEngine engine;
    private Exception exception;
    private SystemRegistry systemRegistry;
    private String scriptExtension;
    private final Supplier<Path> workDir;
    private final Map<String, String> aliases;
    private final Map<String, List<String>> pipes;
    private Path aliasFile;
    private LineReader reader;
    private boolean executing;
    private final Printer printer;

    /* loaded from: grasscutter.jar:org/jline/console/impl/ConsoleEngineImpl$Command.class */
    public enum Command {
        SHOW,
        DEL,
        PRNT,
        ALIAS,
        PIPE,
        UNALIAS,
        DOC,
        SLURP
    }

    public ConsoleEngineImpl(ScriptEngine engine, Printer printer, Supplier<Path> workDir, ConfigurationPath configPath) throws IOException {
        this(null, engine, printer, workDir, configPath);
    }

    public ConsoleEngineImpl(Set<Command> commands, ScriptEngine engine, Printer printer, Supplier<Path> workDir, ConfigurationPath configPath) throws IOException {
        Set<Command> cmds;
        this.scriptExtension = "jline";
        this.aliases = new HashMap();
        this.pipes = new HashMap();
        this.executing = false;
        this.engine = engine;
        this.workDir = workDir;
        this.printer = printer;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (commands == null) {
            cmds = new HashSet<>(EnumSet.allOf(Command.class));
        } else {
            cmds = new HashSet<>(commands);
        }
        for (Command c : cmds) {
            hashMap.put(c, c.name().toLowerCase());
        }
        hashMap2.put(Command.DEL, new CommandMethods(this::del, this::variableCompleter));
        hashMap2.put(Command.SHOW, new CommandMethods(this::show, this::variableCompleter));
        hashMap2.put(Command.PRNT, new CommandMethods(this::prnt, this::prntCompleter));
        hashMap2.put(Command.SLURP, new CommandMethods(this::slurpcmd, this::slurpCompleter));
        hashMap2.put(Command.ALIAS, new CommandMethods(this::aliascmd, this::aliasCompleter));
        hashMap2.put(Command.UNALIAS, new CommandMethods(this::unalias, this::unaliasCompleter));
        hashMap2.put(Command.DOC, new CommandMethods(this::doc, this::docCompleter));
        hashMap2.put(Command.PIPE, new CommandMethods(this::pipe, this::defaultCompleter));
        this.aliasFile = configPath.getUserConfig("aliases.json");
        if (this.aliasFile == null) {
            this.aliasFile = configPath.getUserConfig("aliases.json", true);
            persist(this.aliasFile, this.aliases);
        } else {
            this.aliases.putAll((Map) slurp(this.aliasFile));
        }
        registerCommands(hashMap, hashMap2);
    }

    @Override // org.jline.console.ConsoleEngine
    public void setLineReader(LineReader reader) {
        this.reader = reader;
    }

    /* access modifiers changed from: private */
    public Parser parser() {
        return this.reader.getParser();
    }

    /* access modifiers changed from: private */
    public Terminal terminal() {
        return this.systemRegistry.terminal();
    }

    @Override // org.jline.console.ConsoleEngine
    public boolean isExecuting() {
        return this.executing;
    }

    @Override // org.jline.console.ConsoleEngine
    public void setSystemRegistry(SystemRegistry systemRegistry) {
        this.systemRegistry = systemRegistry;
    }

    @Override // org.jline.console.ConsoleEngine
    public void setScriptExtension(String extension) {
        this.scriptExtension = extension;
    }

    @Override // org.jline.console.ConsoleEngine
    public boolean hasAlias(String name) {
        return this.aliases.containsKey(name);
    }

    @Override // org.jline.console.ConsoleEngine
    public String getAlias(String name) {
        return this.aliases.getOrDefault(name, null);
    }

    @Override // org.jline.console.ConsoleEngine
    public Map<String, List<String>> getPipes() {
        return this.pipes;
    }

    @Override // org.jline.console.ConsoleEngine
    public List<String> getNamedPipes() {
        List<String> out = new ArrayList<>();
        List<String> opers = new ArrayList<>();
        for (String p : this.pipes.keySet()) {
            if (p.matches("[a-zA-Z0-9]+")) {
                out.add(p);
            } else {
                opers.add(p);
            }
        }
        opers.addAll(this.systemRegistry.getPipeNames());
        for (Map.Entry<String, String> entry : this.aliases.entrySet()) {
            if (opers.contains(entry.getValue().split(" ")[0])) {
                out.add(entry.getKey());
            }
        }
        return out;
    }

    @Override // org.jline.console.ConsoleEngine
    public List<Completer> scriptCompleters() {
        List<Completer> out = new ArrayList<>();
        out.add(new ArgumentCompleter(new StringsCompleter(this::scriptNames), new Completers.OptionCompleter(NullCompleter.INSTANCE, this::commandOptions, 1)));
        out.add(new ArgumentCompleter(new StringsCompleter(this::commandAliasNames), NullCompleter.INSTANCE));
        return out;
    }

    private Set<String> commandAliasNames() {
        Set<String> opers = (Set) this.pipes.keySet().stream().filter(p -> {
            return !p.matches("\\w+");
        }).collect(Collectors.toSet());
        opers.addAll(this.systemRegistry.getPipeNames());
        return (Set) this.aliases.entrySet().stream().filter(e -> {
            return !opers.contains(((String) e.getValue()).split(" ")[0]);
        }).map((v0) -> {
            return v0.getKey();
        }).collect(Collectors.toSet());
    }

    private Set<String> scriptNames() {
        return scripts().keySet();
    }

    @Override // org.jline.console.ConsoleEngine
    public Map<String, Boolean> scripts() {
        Map<String, Boolean> out = new HashMap<>();
        try {
            List<Path> scripts = new ArrayList<>();
            if (this.engine.hasVariable(VAR_PATH)) {
                List<String> dirs = new ArrayList<>();
                for (String file : (List) this.engine.get(VAR_PATH)) {
                    String file2 = file.startsWith("~") ? file.replace("~", System.getProperty("user.home")) : file;
                    File dir = new File(file2);
                    if (dir.exists() && dir.isDirectory()) {
                        dirs.add(file2);
                    }
                }
                for (String pp : dirs) {
                    Iterator<String> it = scriptExtensions().iterator();
                    while (it.hasNext()) {
                        String regex = pp + "/*." + it.next();
                        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + regex);
                        Stream<Path> find = Files.find(Paths.get(new File(regex).getParent(), new String[0]), Integer.MAX_VALUE, path, f -> {
                            return pathMatcher.matches(path);
                        }, new FileVisitOption[0]);
                        Objects.requireNonNull(scripts);
                        find.forEach((v1) -> {
                            r1.add(v1);
                        });
                    }
                }
            }
            for (Path p : scripts) {
                String name = p.toFile().getName();
                int idx = name.lastIndexOf(Mapper.IGNORED_FIELDNAME);
                out.put(name.substring(0, idx), Boolean.valueOf(name.substring(idx + 1).equals(this.scriptExtension)));
            }
        } catch (InvalidPathException e) {
            error("Failed reading PATH. Invalid path:");
            error(e.toString());
        } catch (NoSuchFileException e2) {
            error("Failed reading PATH. No file found: " + e2.getMessage());
        } catch (Exception e3) {
            error("Failed reading PATH:");
            trace(e3);
            this.engine.put("exception", e3);
        }
        return out;
    }

    @Override // org.jline.console.ConsoleEngine
    public Object[] expandParameters(String[] args) throws Exception {
        Object[] out = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i].matches("(.*)\\$\\{(.*?)}(/.*)")) {
                Matcher matcher = Pattern.compile("(.*)\\$\\{(.*?)}(/.*)").matcher(args[i]);
                if (matcher.find()) {
                    out[i] = matcher.group(1) + this.engine.get(matcher.group(2)) + matcher.group(3);
                } else {
                    throw new IllegalArgumentException();
                }
            } else if (args[i].startsWith("${")) {
                out[i] = this.engine.execute(expandName(args[i]));
            } else if (args[i].startsWith("$")) {
                out[i] = this.engine.get(expandName(args[i]));
            } else {
                out[i] = this.engine.deserialize(args[i]);
            }
        }
        return out;
    }

    /* access modifiers changed from: private */
    public String expandToList(String[] args) {
        return expandToList(Arrays.asList(args));
    }

    @Override // org.jline.console.ConsoleEngine
    public String expandToList(List<String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (String param : params) {
            if (!first) {
                sb.append(",");
            }
            if (param.equalsIgnoreCase(C3P0Substitutions.DEBUG) || param.equalsIgnoreCase("false") || param.equalsIgnoreCase("null")) {
                sb.append(param.toLowerCase());
            } else if (isNumber(param)) {
                sb.append(param);
            } else {
                sb.append(param.startsWith("$") ? param.substring(1) : quote(param));
            }
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public String expandName(String name) {
        String out = name;
        if (name.matches("^\\$[a-zA-Z_]+[a-zA-Z0-9_-]*")) {
            out = name.substring(1);
        } else if (name.matches("^\\$\\{[a-zA-Z_]+[a-zA-Z0-9_-]*}.*")) {
            Matcher matcher = Pattern.compile("^\\$\\{([a-zA-Z_]+[a-zA-Z0-9_-]*)}(.*)").matcher(name);
            if (matcher.find()) {
                out = matcher.group(1) + matcher.group(2);
            } else {
                throw new IllegalArgumentException();
            }
        }
        return out;
    }

    /* access modifiers changed from: private */
    public boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isCodeBlock(String line) {
        return line.contains("\n") && line.trim().endsWith("}");
    }

    private boolean isCommandLine(String line) {
        String command = parser().getCommand(line);
        boolean out = false;
        if (command != null && command.startsWith(EmitterKt.COMMENT_PREFIX)) {
            String command2 = command.substring(1);
            if (hasAlias(command2)) {
                command2 = getAlias(command2);
            }
            if (this.systemRegistry.hasCommand(command2)) {
                out = true;
            } else if (new ScriptFile(command2, "", new String[0]).isScript()) {
                out = true;
            }
        }
        return out;
    }

    /* access modifiers changed from: private */
    public String quote(String var) {
        if ((var.startsWith("\"") && var.endsWith("\"")) || (var.startsWith("'") && var.endsWith("'"))) {
            return var;
        }
        if (var.contains("\\\"")) {
            return "'" + var + "'";
        }
        return "\"" + var + "\"";
    }

    /* access modifiers changed from: private */
    public List<String> scriptExtensions() {
        List<String> extensions = new ArrayList<>(this.engine.getExtensions());
        extensions.add(this.scriptExtension);
        return extensions;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/ConsoleEngineImpl$ScriptFile.class */
    public class ScriptFile {
        private File script;
        private String extension = "";
        private String cmdLine;
        private String[] args;
        private boolean verbose;
        private Object result;

        public ScriptFile(String command, String cmdLine, String[] args) {
            if (ConsoleEngineImpl.this.parser().validCommandName(command)) {
                try {
                    this.script = new File(command);
                    this.cmdLine = cmdLine;
                    if (this.script.exists()) {
                        scriptExtension(command);
                    } else if (ConsoleEngineImpl.this.engine.hasVariable(ConsoleEngineImpl.VAR_PATH)) {
                        boolean found = false;
                        for (String p : (List) ConsoleEngineImpl.this.engine.get(ConsoleEngineImpl.VAR_PATH)) {
                            Iterator it = ConsoleEngineImpl.this.scriptExtensions().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Path path = Paths.get(p, command + Mapper.IGNORED_FIELDNAME + ((String) it.next()));
                                if (path.toFile().exists()) {
                                    this.script = path.toFile();
                                    scriptExtension(command);
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {
                                break;
                            }
                        }
                    }
                    doArgs(args);
                } catch (Exception e) {
                }
            }
        }

        public ScriptFile(File script, String cmdLine, String[] args) {
            if (!script.exists()) {
                throw new IllegalArgumentException("Script file not found!");
            }
            this.script = script;
            this.cmdLine = cmdLine;
            scriptExtension(script.getName());
            doArgs(args);
        }

        private void scriptExtension(String command) {
            String name = this.script.getName();
            this.extension = name.contains(Mapper.IGNORED_FIELDNAME) ? name.substring(name.lastIndexOf(Mapper.IGNORED_FIELDNAME) + 1) : "";
            if (!isEngineScript() && !isConsoleScript()) {
                throw new IllegalArgumentException("Command not found: " + command);
            }
        }

        private void doArgs(String[] args) {
            List<String> _args = new ArrayList<>();
            if (isConsoleScript()) {
                _args.add(this.script.getAbsolutePath());
            }
            for (String a : args) {
                if (!isConsoleScript()) {
                    _args.add(a);
                } else if (!a.equals(ConsoleEngineImpl.OPTION_VERBOSE)) {
                    _args.add(a);
                } else {
                    this.verbose = true;
                }
            }
            this.args = (String[]) _args.toArray(new String[0]);
        }

        private boolean isEngineScript() {
            return ConsoleEngineImpl.this.engine.getExtensions().contains(this.extension);
        }

        private boolean isConsoleScript() {
            return ConsoleEngineImpl.this.scriptExtension.equals(this.extension);
        }

        /* access modifiers changed from: private */
        public boolean isScript() {
            return ConsoleEngineImpl.this.engine.getExtensions().contains(this.extension) || ConsoleEngineImpl.this.scriptExtension.equals(this.extension);
        }

        public boolean execute() throws Exception {
            String line;
            if (!isScript()) {
                return false;
            }
            this.result = null;
            if (Arrays.asList(this.args).contains(ConsoleEngineImpl.OPTION_HELP[0]) || Arrays.asList(this.args).contains(ConsoleEngineImpl.OPTION_HELP[1])) {
                BufferedReader br = new BufferedReader(new FileReader(this.script));
                try {
                    int size = 0;
                    StringBuilder usage = new StringBuilder();
                    boolean helpEnd = false;
                    boolean headComment = false;
                    while (true) {
                        String l = br.readLine();
                        if (l == null) {
                            break;
                        }
                        size++;
                        String l2 = l.replaceAll("\\s+$", "");
                        line = l2;
                        if (size > 30 || line.endsWith(ConsoleEngineImpl.END_HELP)) {
                            break;
                        }
                        if (headComment || size < 3) {
                            String ltr = l2.trim();
                            if (ltr.startsWith("*") || ltr.startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
                                headComment = true;
                                line = ltr.length() > 1 ? ltr.substring(2) : "";
                            } else if (ltr.startsWith("/*") || ltr.startsWith("//")) {
                                headComment = true;
                                line = ltr.length() > 2 ? ltr.substring(3) : "";
                            }
                        }
                        usage.append(line).append('\n');
                    }
                    helpEnd = line.endsWith(ConsoleEngineImpl.END_HELP);
                    if (usage.length() > 0) {
                        usage.append("\n");
                        if (!helpEnd) {
                            usage.insert(0, "\n");
                        }
                        throw new Options.HelpException(usage.toString());
                    }
                    internalExecute();
                    br.close();
                    return true;
                } catch (Throwable th) {
                    try {
                        br.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                internalExecute();
                return true;
            }
        }

        private String expandParameterName(String parameter) {
            if (parameter.startsWith("$")) {
                return ConsoleEngineImpl.this.expandName(parameter);
            }
            if (ConsoleEngineImpl.this.isNumber(parameter)) {
                return parameter;
            }
            return ConsoleEngineImpl.this.quote(parameter);
        }

        private void internalExecute() throws Exception {
            if (isEngineScript()) {
                this.result = ConsoleEngineImpl.this.engine.execute(this.script, ConsoleEngineImpl.this.expandParameters(this.args));
            } else if (isConsoleScript()) {
                ConsoleEngineImpl.this.executing = true;
                boolean done = true;
                String line = "";
                BufferedReader br = new BufferedReader(new FileReader(this.script));
                while (true) {
                    try {
                        String l = br.readLine();
                        if (l == null) {
                            break;
                        } else if (l.trim().isEmpty() || l.trim().startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
                            done = true;
                        } else {
                            String line2 = line + l;
                            ConsoleEngineImpl.this.parser().parse(line2, line2.length() + 1, Parser.ParseContext.ACCEPT_LINE);
                            done = true;
                            for (int i = 1; i < this.args.length; i++) {
                                line2 = line2.replaceAll("\\s\\$" + i + "\\b", " " + expandParameterName(this.args[i]) + " ").replaceAll("\\$\\{" + i + "(|:-.*)}", expandParameterName(this.args[i]));
                            }
                            line = line2.replaceAll("\\$\\{@}", ConsoleEngineImpl.this.expandToList(this.args)).replaceAll("\\$@", ConsoleEngineImpl.this.expandToList(this.args)).replaceAll("\\s\\$\\d\\b", "").replaceAll("\\$\\{\\d+}", "");
                            Matcher matcher = Pattern.compile("\\$\\{\\d+:-(.*?)}").matcher(line);
                            if (matcher.find()) {
                                line = matcher.replaceAll(expandParameterName(matcher.group(1)));
                            }
                            try {
                                try {
                                    try {
                                        if (this.verbose) {
                                            AttributedStringBuilder asb = new AttributedStringBuilder();
                                            asb.styled(Styles.prntStyle().resolve(".vs"), line);
                                            asb.toAttributedString().println(ConsoleEngineImpl.this.terminal());
                                            ConsoleEngineImpl.this.terminal().flush();
                                        }
                                        ConsoleEngineImpl.this.println(ConsoleEngineImpl.this.systemRegistry.execute(line));
                                        line = "";
                                    } catch (EOFError e) {
                                        done = false;
                                        line = line + "\n";
                                    }
                                } catch (Exception e2) {
                                    ConsoleEngineImpl.this.executing = false;
                                    throw new IllegalArgumentException(line + "\n" + e2.getMessage());
                                }
                            } catch (EndOfFileException e3) {
                                done = true;
                                this.result = ConsoleEngineImpl.this.engine.get("_return");
                                ConsoleEngineImpl.this.postProcess(this.cmdLine, this.result);
                            } catch (SyntaxError e4) {
                                throw e4;
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
                if (!done) {
                    ConsoleEngineImpl.this.executing = false;
                    throw new IllegalArgumentException("Incompleted command: \n" + line);
                }
                ConsoleEngineImpl.this.executing = false;
                br.close();
            }
        }

        public Object getResult() {
            return this.result;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            try {
                sb.append("script:").append(this.script.getCanonicalPath());
            } catch (Exception e) {
                sb.append(e.getMessage());
            }
            sb.append(", ");
            sb.append("extension:").append(this.extension);
            sb.append(", ");
            sb.append("cmdLine:").append(this.cmdLine);
            sb.append(", ");
            sb.append("args:").append(Arrays.asList(this.args));
            sb.append(", ");
            sb.append("verbose:").append(this.verbose);
            sb.append(", ");
            sb.append("result:").append(this.result);
            sb.append("]");
            return sb.toString();
        }
    }

    @Override // org.jline.console.ConsoleEngine
    public Object execute(File script, String cmdLine, String[] args) throws Exception {
        ScriptFile file = new ScriptFile(script, cmdLine, args);
        file.execute();
        return file.getResult();
    }

    @Override // org.jline.console.ConsoleEngine
    public String expandCommandLine(String line) {
        String out;
        if (isCommandLine(line)) {
            StringBuilder sb = new StringBuilder();
            List<String> ws = parser().parse(line, 0, Parser.ParseContext.COMPLETE).words();
            int idx = ws.get(0).lastIndexOf(EmitterKt.COMMENT_PREFIX);
            if (idx > 0) {
                sb.append(ws.get(0).substring(0, idx));
            }
            String[] argv = new String[ws.size()];
            for (int i = 1; i < ws.size(); i++) {
                argv[i] = ws.get(i);
                if (argv[i].startsWith("${")) {
                    Matcher argvMatcher = Pattern.compile("\\$\\{(.*)}").matcher(argv[i]);
                    if (argvMatcher.find()) {
                        argv[i] = argv[i].replace(argv[i], argvMatcher.group(1));
                    }
                } else if (argv[i].startsWith("$")) {
                    argv[i] = argv[i].substring(1);
                } else {
                    argv[i] = quote(argv[i]);
                }
            }
            sb.append(SystemRegistry.class.getCanonicalName()).append(".get().invoke('").append(hasAlias(ws.get(0).substring(idx + 1)) ? getAlias(ws.get(0).substring(idx + 1)) : ws.get(0).substring(idx + 1)).append("'");
            for (int i2 = 1; i2 < argv.length; i2++) {
                sb.append(", ");
                sb.append(argv[i2]);
            }
            sb.append(")");
            out = sb.toString();
        } else {
            out = line;
        }
        return out;
    }

    @Override // org.jline.console.ConsoleEngine
    public Object execute(String cmd, String line, String[] args) throws Exception {
        if (line.trim().startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
            return null;
        }
        Object out = null;
        ScriptFile file = null;
        if (parser().validCommandName(cmd)) {
            file = new ScriptFile(cmd, line, args);
        } else {
            File f = new File(line.split("\\s+")[0]);
            if (f.exists()) {
                file = new ScriptFile(f, line, args);
            }
        }
        if (file == null || !file.execute()) {
            String line2 = line.trim();
            if (isCodeBlock(line2)) {
                StringBuilder sb = new StringBuilder();
                for (String s : line2.split("\\r?\\n")) {
                    sb.append(expandCommandLine(s));
                    sb.append("\n");
                }
                line2 = sb.toString();
            }
            if (this.engine.hasVariable(line2)) {
                out = this.engine.get(line2);
            } else if (parser().getVariable(line2) == null) {
                out = this.engine.execute(line2);
                this.engine.put(JavaConstant.Dynamic.DEFAULT_NAME, out);
            } else {
                this.engine.execute(line2);
            }
        } else {
            out = file.getResult();
        }
        return out;
    }

    @Override // org.jline.console.ConsoleEngine
    public void purge() {
        this.engine.del("_*");
    }

    @Override // org.jline.console.ConsoleEngine
    public void putVariable(String name, Object value) {
        this.engine.put(name, value);
    }

    @Override // org.jline.console.ConsoleEngine
    public Object getVariable(String name) {
        if (this.engine.hasVariable(name)) {
            return this.engine.get(name);
        }
        throw new IllegalArgumentException("Variable " + name + " does not exists!");
    }

    @Override // org.jline.console.ConsoleEngine
    public boolean hasVariable(String name) {
        return this.engine.hasVariable(name);
    }

    @Override // org.jline.console.ConsoleEngine
    public boolean executeWidget(Object function) {
        try {
            this.engine.put("_reader", this.reader);
            this.engine.put("_widgetFunction", function);
            try {
                if (this.engine.getEngineName().equals("GroovyEngine")) {
                    this.engine.execute("def _buffer() {_reader.getBuffer()}");
                    this.engine.execute("def _widget(w) {_reader.callWidget(w)}");
                }
                this.engine.execute("_widgetFunction()");
                purge();
                return true;
            } catch (Exception e) {
                trace(e);
                purge();
                return false;
            }
        } catch (Throwable th) {
            purge();
            throw th;
        }
    }

    private Map<String, Object> consoleOptions() {
        return this.engine.hasVariable(VAR_CONSOLE_OPTIONS) ? (Map) this.engine.get(VAR_CONSOLE_OPTIONS) : new HashMap();
    }

    @Override // org.jline.console.ConsoleEngine
    public <T> T consoleOption(String option, T defval) {
        T out = defval;
        try {
            out = (T) consoleOptions().getOrDefault(option, defval);
        } catch (Exception e) {
            trace(new Exception("Bad CONSOLE_OPTION value: " + e.getMessage()));
        }
        return out;
    }

    private boolean consoleOption(String option) {
        boolean out = false;
        try {
            out = consoleOptions().containsKey(option);
        } catch (Exception e) {
            trace(new Exception("Bad CONSOLE_OPTION value: " + e.getMessage()));
        }
        return out;
    }

    @Override // org.jline.console.ConsoleEngine
    public ConsoleEngine.ExecutionResult postProcess(String line, Object result, String output) {
        ConsoleEngine.ExecutionResult out;
        String[] split = (output == null || output.trim().isEmpty() || consoleOption("no-splittedOutput")) ? output : output.split("\\r?\\n");
        String consoleVar = parser().getVariable(line);
        if (!(consoleVar == null || result == null)) {
            this.engine.put("output", split);
        }
        if (this.systemRegistry.hasCommand(parser().getCommand(line))) {
            out = postProcess(line, (consoleVar == null || result != null) ? result : split);
        } else {
            String[] _result = result == null ? split : result;
            out = new ConsoleEngine.ExecutionResult(saveResult(consoleVar, _result), (consoleVar == null || consoleVar.startsWith(JavaConstant.Dynamic.DEFAULT_NAME)) ? _result : null);
        }
        return out;
    }

    /* access modifiers changed from: private */
    public ConsoleEngine.ExecutionResult postProcess(String line, Object result) {
        int status = 0;
        Object out = (!(result instanceof String) || !((String) result).trim().isEmpty()) ? result : null;
        String consoleVar = parser().getVariable(line);
        if (consoleVar != null) {
            status = saveResult(consoleVar, result);
            out = null;
        } else if (!parser().getCommand(line).equals("show")) {
            if (result != null) {
                status = saveResult(JavaConstant.Dynamic.DEFAULT_NAME, result);
            } else {
                status = 1;
            }
        }
        return new ConsoleEngine.ExecutionResult(status, out);
    }

    @Override // org.jline.console.ConsoleEngine
    public ConsoleEngine.ExecutionResult postProcess(Object result) {
        return new ConsoleEngine.ExecutionResult(saveResult(null, result), result);
    }

    private int saveResult(String var, Object result) {
        int out;
        try {
            this.engine.put("_executionResult", result);
            if (var != null) {
                if (var.contains(Mapper.IGNORED_FIELDNAME) || var.contains("[")) {
                    this.engine.execute(var + " = _executionResult");
                } else {
                    this.engine.put(var, result);
                }
            }
            out = ((Integer) this.engine.execute("_executionResult ? 0 : 1")).intValue();
        } catch (Exception e) {
            trace(e);
            out = 1;
        }
        return out;
    }

    @Override // org.jline.console.impl.AbstractCommandRegistry, org.jline.console.CommandRegistry
    public Object invoke(CommandRegistry.CommandSession session, String command, Object... args) throws Exception {
        this.exception = null;
        Object out = null;
        if (hasCommand(command)) {
            out = getCommandMethods(command).execute().apply(new CommandInput(command, args, session));
        } else {
            String[] _args = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                if (!(args[i] instanceof String)) {
                    throw new IllegalArgumentException();
                }
                _args[i] = args[i].toString();
            }
            ScriptFile sf = new ScriptFile(command, "", _args);
            if (sf.execute()) {
                out = sf.getResult();
            }
        }
        if (this.exception == null) {
            return out;
        }
        throw this.exception;
    }

    @Override // org.jline.console.ConsoleEngine
    public void trace(Object object) {
        Object toPrint = object;
        int level = ((Integer) consoleOption("trace", 0)).intValue();
        Map<String, Object> options = new HashMap<>();
        if (level < 2) {
            options.put("exception", SendMailJob.PROP_MESSAGE);
        }
        if (level == 0) {
            if (!(object instanceof Throwable)) {
                toPrint = null;
            }
        } else if (level == 1) {
            if (object instanceof SystemRegistryImpl.CommandData) {
                toPrint = ((SystemRegistryImpl.CommandData) object).rawLine();
            }
        } else if (level > 1 && (object instanceof SystemRegistryImpl.CommandData)) {
            toPrint = object.toString();
        }
        this.printer.println(options, toPrint);
    }

    private void error(String message) {
        AttributedStringBuilder asb = new AttributedStringBuilder();
        asb.styled(Styles.prntStyle().resolve(".em"), message);
        asb.println(terminal());
    }

    @Override // org.jline.console.ConsoleEngine
    public void println(Object object) {
        this.printer.println(object);
    }

    private Object show(CommandInput input) {
        try {
            parseOptions(new String[]{"show -  list console variables", "Usage: show [VARIABLE]", "  -? --help                       Displays command help"}, input.args());
            Map<String, Object> options = new HashMap<>();
            options.put(Printer.MAX_DEPTH, 0);
            this.printer.println(options, this.engine.find(input.args().length > 0 ? input.args()[0] : null));
            return null;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    private Object del(CommandInput input) {
        try {
            parseOptions(new String[]{"del -  delete console variables, methods, classes and imports", "Usage: del [var1] ...", "  -? --help                       Displays command help"}, input.args());
            this.engine.del(input.args());
            return null;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    private Object prnt(CommandInput input) {
        Exception result = this.printer.prntCommand(input);
        if (result == null) {
            return null;
        }
        this.exception = result;
        return null;
    }

    private Object slurpcmd(CommandInput input) {
        Object out = null;
        try {
            Options opt = parseOptions(new String[]{"slurp -  slurp file or string variable context to object", "Usage: slurp [OPTIONS] file|variable", "  -? --help                       Displays command help", "  -e --encoding=ENCODING          Encoding (default UTF-8)", "  -f --format=FORMAT              Serialization format"}, input.xargs());
            if (!opt.args().isEmpty()) {
                Object _arg = opt.argObjects().get(0);
                if (!(_arg instanceof String)) {
                    throw new IllegalArgumentException("Invalid parameter type: " + _arg.getClass().getSimpleName());
                }
                String arg = (String) _arg;
                Charset encoding = opt.isSet("encoding") ? Charset.forName(opt.get("encoding")) : StandardCharsets.UTF_8;
                String format = opt.isSet("format") ? opt.get("format") : this.engine.getSerializationFormats().get(0);
                Path path = Paths.get(arg, new String[0]);
                try {
                    if (path.toFile().exists()) {
                        if (!format.equals(SLURP_FORMAT_TEXT)) {
                            out = slurp(path, encoding, format);
                        } else {
                            out = Files.readAllLines(Paths.get(arg, new String[0]), encoding);
                        }
                    } else if (!format.equals(SLURP_FORMAT_TEXT)) {
                        out = this.engine.deserialize(arg, format);
                    } else {
                        out = arg.split("\n");
                    }
                } catch (Exception e) {
                    out = this.engine.deserialize(arg, format);
                }
            }
        } catch (Exception e2) {
            this.exception = e2;
        }
        return out;
    }

    @Override // org.jline.console.ConsoleEngine
    public void persist(Path file, Object object) {
        this.engine.persist(file, object);
    }

    @Override // org.jline.console.ConsoleEngine
    public Object slurp(Path file) throws IOException {
        return slurp(file, StandardCharsets.UTF_8, this.engine.getSerializationFormats().get(0));
    }

    private Object slurp(Path file, Charset encoding, String format) throws IOException {
        return this.engine.deserialize(new String(Files.readAllBytes(file), encoding), format);
    }

    private Object aliascmd(CommandInput input) {
        Object out = null;
        try {
            List<String> args = parseOptions(new String[]{"alias -  create command alias", "Usage: alias [ALIAS] [COMMANDLINE]", "  -? --help                       Displays command help"}, input.args()).args();
            if (args.isEmpty()) {
                out = this.aliases;
            } else if (args.size() == 1) {
                out = this.aliases.getOrDefault(args.get(0), null);
            } else {
                String alias = String.join(" ", args.subList(1, args.size()));
                for (int j = 0; j < 10; j++) {
                    alias = alias.replaceAll("%" + j, "\\$" + j).replaceAll("%\\{" + j + "}", "\\$\\{" + j + "\\}").replaceAll("%\\{" + j + CoreConstants.DEFAULT_VALUE_SEPARATOR, "\\$\\{" + j + CoreConstants.DEFAULT_VALUE_SEPARATOR);
                }
                this.aliases.put(args.get(0), alias.replaceAll("%@", "\\$@").replaceAll("%\\{@}", "\\$\\{@\\}"));
                persist(this.aliasFile, this.aliases);
            }
        } catch (Exception e) {
            this.exception = e;
        }
        return out;
    }

    private Object unalias(CommandInput input) {
        try {
            for (String a : parseOptions(new String[]{"unalias -  remove command alias", "Usage: unalias [ALIAS...]", "  -? --help                       Displays command help"}, input.args()).args()) {
                this.aliases.remove(a);
            }
            persist(this.aliasFile, this.aliases);
            return null;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    private Object pipe(CommandInput input) {
        try {
            Options opt = parseOptions(new String[]{"pipe -  create/delete pipe operator", "Usage: pipe [OPERATOR] [PREFIX] [POSTFIX]", "       pipe --list", "       pipe --delete [OPERATOR...]", "  -? --help                       Displays command help", "  -d --delete                     Delete pipe operators", "  -l --list                       List pipe operators"}, input.args());
            Map<String, Object> options = new HashMap<>();
            if (opt.isSet("delete")) {
                if (opt.args().size() != 1 || !opt.args().get(0).equals("*")) {
                    for (String p : opt.args()) {
                        this.pipes.remove(p.trim());
                    }
                } else {
                    this.pipes.clear();
                }
            } else if (opt.isSet("list") || opt.args().size() == 0) {
                options.put(Printer.MAX_DEPTH, 0);
                this.printer.println(options, this.pipes);
            } else if (opt.args().size() != 3) {
                this.exception = new IllegalArgumentException("Bad number of arguments!");
            } else if (this.systemRegistry.getPipeNames().contains(opt.args().get(0))) {
                this.exception = new IllegalArgumentException("Reserved pipe operator");
            } else {
                List<String> fixes = new ArrayList<>();
                fixes.add(opt.args().get(1));
                fixes.add(opt.args().get(2));
                this.pipes.put(opt.args().get(0), fixes);
            }
            return null;
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x004b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private java.lang.Object doc(org.jline.console.CommandInput r6) {
        /*
        // Method dump skipped, instructions count: 590
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.console.impl.ConsoleEngineImpl.doc(org.jline.console.CommandInput):java.lang.Object");
    }

    private boolean urlExists(String weburl) {
        try {
            HttpURLConnection huc = (HttpURLConnection) new URL(weburl).openConnection();
            huc.setRequestMethod("HEAD");
            return huc.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }

    private List<Completer> slurpCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        List<Completers.OptDesc> optDescs = commandOptions("slurp");
        Iterator<Completers.OptDesc> it = optDescs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Completers.OptDesc o = it.next();
            if (o.shortOption() != null && o.shortOption().equals("-f")) {
                List<String> formats = new ArrayList<>(this.engine.getDeserializationFormats());
                formats.add(SLURP_FORMAT_TEXT);
                o.setValueCompleter(new StringsCompleter((Iterable<String>) formats));
                break;
            }
        }
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(Arrays.asList(new AggregateCompleter(new Completers.FilesCompleter(this.workDir), new StringsCompleter(this::variableReferences)), NullCompleter.INSTANCE), optDescs, 1)));
        return completers;
    }

    private List<Completer> variableCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new StringsCompleter(() -> {
            return this.engine.find().keySet();
        }));
        return completers;
    }

    private List<String> variableReferences() {
        List<String> out = new ArrayList<>();
        Iterator<String> it = this.engine.find().keySet().iterator();
        while (it.hasNext()) {
            out.add("$" + it.next());
        }
        return out;
    }

    private List<Completer> prntCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(Arrays.asList(new StringsCompleter(this::variableReferences), NullCompleter.INSTANCE), this::commandOptions, 1)));
        return completers;
    }

    /* loaded from: grasscutter.jar:org/jline/console/impl/ConsoleEngineImpl$AliasValueCompleter.class */
    private static class AliasValueCompleter implements Completer {
        private final Map<String, String> aliases;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !ConsoleEngineImpl.class.desiredAssertionStatus();
        }

        public AliasValueCompleter(Map<String, String> aliases) {
            this.aliases = aliases;
        }

        @Override // org.jline.reader.Completer
        public void complete(LineReader reader, ParsedLine commandLine, List<Candidate> candidates) {
            String h;
            if (!$assertionsDisabled && commandLine == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || candidates != null) {
                List<String> words = commandLine.words();
                if (words.size() > 1 && (h = words.get(words.size() - 2)) != null && h.length() > 0 && this.aliases.containsKey(h)) {
                    String v = this.aliases.get(h);
                    candidates.add(new Candidate(AttributedString.stripAnsi(v), v, null, null, null, null, true));
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    private List<Completer> aliasCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        List<Completer> params = new ArrayList<>();
        Map<String, String> map = this.aliases;
        Objects.requireNonNull(map);
        params.add(new StringsCompleter(this::keySet));
        params.add(new AliasValueCompleter(this.aliases));
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(params, this::commandOptions, 1)));
        return completers;
    }

    private List<Completer> unaliasCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        Map<String, String> map = this.aliases;
        Objects.requireNonNull(map);
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(new StringsCompleter(this::keySet), this::commandOptions, 1)));
        return completers;
    }

    private List<String> docs() {
        List<String> out = new ArrayList<>();
        Map<String, String> docs = (Map) consoleOption("docs", null);
        if (docs == null) {
            return out;
        }
        Iterator<String> it = this.engine.find().keySet().iterator();
        while (it.hasNext()) {
            out.add("$" + it.next());
        }
        if (!docs.isEmpty()) {
            for (String d : docs.keySet()) {
                if (d.matches("\\w+")) {
                    out.add(d);
                }
            }
        }
        return out;
    }

    private List<Completer> docCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(Arrays.asList(new StringsCompleter(this::docs), NullCompleter.INSTANCE), this::commandOptions, 1)));
        return completers;
    }
}
