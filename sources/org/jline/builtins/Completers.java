package org.jline.builtins;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import net.bytebuddy.utility.JavaConstant;
import org.jline.reader.Candidate;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.OSUtils;
import org.jline.utils.StyleResolver;

/* loaded from: grasscutter.jar:org/jline/builtins/Completers.class */
public class Completers {

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$CompletionEnvironment.class */
    public interface CompletionEnvironment {
        Map<String, List<CompletionData>> getCompletions();

        Set<String> getCommands();

        String resolveCommand(String str);

        String commandName(String str);

        Object evaluate(LineReader lineReader, ParsedLine parsedLine, String str) throws Exception;
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$CompletionData.class */
    public static class CompletionData {
        public final List<String> options;
        public final String description;
        public final String argument;
        public final String condition;

        public CompletionData(List<String> options, String description, String argument, String condition) {
            this.options = options;
            this.description = description;
            this.argument = argument;
            this.condition = condition;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$Completer.class */
    public static class Completer implements org.jline.reader.Completer {
        private final CompletionEnvironment environment;

        public Completer(CompletionEnvironment environment) {
            this.environment = environment;
        }

        @Override // org.jline.reader.Completer
        public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
            if (line.wordIndex() == 0) {
                completeCommand(candidates);
            } else {
                tryCompleteArguments(reader, line, candidates);
            }
        }

        protected void tryCompleteArguments(LineReader reader, ParsedLine line, List<Candidate> candidates) {
            List<CompletionData> cmd;
            String resolved = this.environment.resolveCommand(line.words().get(0));
            Map<String, List<CompletionData>> comp = this.environment.getCompletions();
            if (comp != null && (cmd = comp.get(resolved)) != null) {
                completeCommandArguments(reader, line, candidates, cmd);
            }
        }

        protected void completeCommandArguments(LineReader reader, ParsedLine line, List<Candidate> candidates, List<CompletionData> completions) {
            for (CompletionData completion : completions) {
                boolean isOption = line.word().startsWith("-");
                String prevOption = (line.wordIndex() < 2 || !line.words().get(line.wordIndex() - 1).startsWith("-")) ? null : line.words().get(line.wordIndex() - 1);
                String key = UUID.randomUUID().toString();
                boolean conditionValue = true;
                if (completion.condition != null) {
                    Object res = Boolean.FALSE;
                    try {
                        res = this.environment.evaluate(reader, line, completion.condition);
                    } catch (Throwable th) {
                    }
                    conditionValue = isTrue(res);
                }
                if (conditionValue && isOption && completion.options != null) {
                    for (String opt : completion.options) {
                        candidates.add(new Candidate(opt, opt, "options", completion.description, null, key, true));
                    }
                } else if (!isOption && prevOption != null && completion.argument != null && completion.options != null && completion.options.contains(prevOption)) {
                    Object res2 = null;
                    try {
                        res2 = this.environment.evaluate(reader, line, completion.argument);
                    } catch (Throwable th2) {
                    }
                    if (res2 instanceof Candidate) {
                        candidates.add((Candidate) res2);
                    } else if (res2 instanceof String) {
                        candidates.add(new Candidate((String) res2, (String) res2, null, null, null, null, true));
                    } else if (res2 instanceof Collection) {
                        for (Object s : (Collection) res2) {
                            if (s instanceof Candidate) {
                                candidates.add((Candidate) s);
                            } else if (s instanceof String) {
                                candidates.add(new Candidate((String) s, (String) s, null, null, null, null, true));
                            }
                        }
                    } else if (res2 != null && res2.getClass().isArray()) {
                        int l = Array.getLength(res2);
                        for (int i = 0; i < l; i++) {
                            Object s2 = Array.get(res2, i);
                            if (s2 instanceof Candidate) {
                                candidates.add((Candidate) s2);
                            } else if (s2 instanceof String) {
                                candidates.add(new Candidate((String) s2, (String) s2, null, null, null, null, true));
                            }
                        }
                    }
                } else if (!isOption && completion.argument != null) {
                    Object res3 = null;
                    try {
                        res3 = this.environment.evaluate(reader, line, completion.argument);
                    } catch (Throwable th3) {
                    }
                    if (res3 instanceof Candidate) {
                        candidates.add((Candidate) res3);
                    } else if (res3 instanceof String) {
                        candidates.add(new Candidate((String) res3, (String) res3, null, completion.description, null, null, true));
                    } else if (res3 instanceof Collection) {
                        for (Object s3 : (Collection) res3) {
                            if (s3 instanceof Candidate) {
                                candidates.add((Candidate) s3);
                            } else if (s3 instanceof String) {
                                candidates.add(new Candidate((String) s3, (String) s3, null, completion.description, null, null, true));
                            }
                        }
                    }
                }
            }
        }

        protected void completeCommand(List<Candidate> candidates) {
            List<CompletionData> completions;
            for (String command : this.environment.getCommands()) {
                String name = this.environment.commandName(command);
                boolean resolved = command.equals(this.environment.resolveCommand(name));
                if (!name.startsWith(JavaConstant.Dynamic.DEFAULT_NAME)) {
                    String desc = null;
                    Map<String, List<CompletionData>> comp = this.environment.getCompletions();
                    if (!(comp == null || (completions = comp.get(command)) == null)) {
                        for (CompletionData completion : completions) {
                            if (completion.description != null && completion.options == null && completion.argument == null && completion.condition == null) {
                                desc = completion.description;
                            }
                        }
                    }
                    String key = UUID.randomUUID().toString();
                    if (desc != null) {
                        candidates.add(new Candidate(command, command, null, desc, null, key, true));
                        if (resolved) {
                            candidates.add(new Candidate(name, name, null, desc, null, key, true));
                        }
                    } else {
                        candidates.add(new Candidate(command, command, null, null, null, key, true));
                        if (resolved) {
                            candidates.add(new Candidate(name, name, null, null, null, key, true));
                        }
                    }
                }
            }
        }

        private boolean isTrue(Object result) {
            if (result == null) {
                return false;
            }
            if (result instanceof Boolean) {
                return ((Boolean) result).booleanValue();
            }
            return (!(result instanceof Number) || 0 != ((Number) result).intValue()) && !"".equals(result) && !"0".equals(result);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$DirectoriesCompleter.class */
    public static class DirectoriesCompleter extends FileNameCompleter {
        private final Supplier<Path> currentDir;

        public DirectoriesCompleter(File currentDir) {
            this(currentDir.toPath());
        }

        public DirectoriesCompleter(Path currentDir) {
            this.currentDir = () -> {
                return currentDir;
            };
        }

        public DirectoriesCompleter(Supplier<Path> currentDir) {
            this.currentDir = currentDir;
        }

        @Override // org.jline.builtins.Completers.FileNameCompleter
        protected Path getUserDir() {
            return this.currentDir.get();
        }

        @Override // org.jline.builtins.Completers.FileNameCompleter
        protected boolean accept(Path path) {
            return Files.isDirectory(path, new LinkOption[0]) && accept(path);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$FilesCompleter.class */
    public static class FilesCompleter extends FileNameCompleter {
        private final Supplier<Path> currentDir;
        private final String namePattern;

        public FilesCompleter(File currentDir) {
            this(currentDir.toPath(), (String) null);
        }

        public FilesCompleter(File currentDir, String namePattern) {
            this(currentDir.toPath(), namePattern);
        }

        public FilesCompleter(Path currentDir) {
            this(currentDir, (String) null);
        }

        public FilesCompleter(Path currentDir, String namePattern) {
            this.currentDir = () -> {
                return currentDir;
            };
            this.namePattern = compilePattern(namePattern);
        }

        public FilesCompleter(Supplier<Path> currentDir) {
            this(currentDir, (String) null);
        }

        public FilesCompleter(Supplier<Path> currentDir, String namePattern) {
            this.currentDir = currentDir;
            this.namePattern = compilePattern(namePattern);
        }

        private String compilePattern(String pattern) {
            if (pattern == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < pattern.length()) {
                char ch = pattern.charAt(i);
                if (ch == '\\') {
                    i++;
                    sb.append(pattern.charAt(i));
                } else if (ch == '.') {
                    sb.append('\\').append('.');
                } else if (ch == '*') {
                    sb.append('.').append('*');
                } else {
                    sb.append(ch);
                }
                i++;
            }
            return sb.toString();
        }

        @Override // org.jline.builtins.Completers.FileNameCompleter
        protected Path getUserDir() {
            return this.currentDir.get();
        }

        @Override // org.jline.builtins.Completers.FileNameCompleter
        protected boolean accept(Path path) {
            if (this.namePattern == null || Files.isDirectory(path, new LinkOption[0])) {
                return accept(path);
            }
            return path.getFileName().toString().matches(this.namePattern) && accept(path);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$FileNameCompleter.class */
    public static class FileNameCompleter implements org.jline.reader.Completer {
        protected static StyleResolver resolver;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !Completers.class.desiredAssertionStatus();
            resolver = Styles.lsStyle();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x00fb
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // org.jline.reader.Completer
        public void complete(org.jline.reader.LineReader r8, org.jline.reader.ParsedLine r9, java.util.List<org.jline.reader.Candidate> r10) {
            /*
            // Method dump skipped, instructions count: 291
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.Completers.FileNameCompleter.complete(org.jline.reader.LineReader, org.jline.reader.ParsedLine, java.util.List):void");
        }

        protected boolean accept(Path path) {
            try {
                return !Files.isHidden(path);
            } catch (IOException e) {
                return false;
            }
        }

        protected Path getUserDir() {
            return Paths.get(System.getProperty("user.dir"), new String[0]);
        }

        protected Path getUserHome() {
            return Paths.get(System.getProperty("user.home"), new String[0]);
        }

        protected String getSeparator(boolean useForwardSlash) {
            return useForwardSlash ? "/" : getUserDir().getFileSystem().getSeparator();
        }

        protected String getDisplay(Terminal terminal, Path p, StyleResolver resolver2, String separator) {
            AttributedStringBuilder sb = new AttributedStringBuilder();
            String name = p.getFileName().toString();
            int idx = name.lastIndexOf(Mapper.IGNORED_FIELDNAME);
            String type = idx != -1 ? ".*" + name.substring(idx) : null;
            if (Files.isSymbolicLink(p)) {
                sb.styled(resolver2.resolve(".ln"), name).append((CharSequence) "@");
            } else if (Files.isDirectory(p, new LinkOption[0])) {
                sb.styled(resolver2.resolve(".di"), name).append((CharSequence) separator);
            } else if (Files.isExecutable(p) && !OSUtils.IS_WINDOWS) {
                sb.styled(resolver2.resolve(".ex"), name).append((CharSequence) "*");
            } else if (type != null && resolver2.resolve(type).getStyle() != 0) {
                sb.styled(resolver2.resolve(type), name);
            } else if (Files.isRegularFile(p, new LinkOption[0])) {
                sb.styled(resolver2.resolve(".fi"), name);
            } else {
                sb.append((CharSequence) name);
            }
            return sb.toAnsi(terminal);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$TreeCompleter.class */
    public static class TreeCompleter implements org.jline.reader.Completer {
        final Map<String, org.jline.reader.Completer> completers;
        final RegexCompleter completer;

        public TreeCompleter(Node... nodes) {
            this(Arrays.asList(nodes));
        }

        public TreeCompleter(List<Node> nodes) {
            this.completers = new HashMap();
            StringBuilder sb = new StringBuilder();
            addRoots(sb, nodes);
            String sb2 = sb.toString();
            Map<String, org.jline.reader.Completer> map = this.completers;
            Objects.requireNonNull(map);
            this.completer = new RegexCompleter(sb2, (v1) -> {
                return r4.get(v1);
            });
        }

        public static Node node(Object... objs) {
            org.jline.reader.Completer comp = null;
            List<Candidate> cands = new ArrayList<>();
            List<Node> nodes = new ArrayList<>();
            for (Object obj : objs) {
                if (obj instanceof String) {
                    cands.add(new Candidate((String) obj));
                } else if (obj instanceof Candidate) {
                    cands.add((Candidate) obj);
                } else if (obj instanceof Node) {
                    nodes.add((Node) obj);
                } else if (obj instanceof org.jline.reader.Completer) {
                    comp = (org.jline.reader.Completer) obj;
                } else {
                    throw new IllegalArgumentException();
                }
            }
            if (comp != null) {
                if (cands.isEmpty()) {
                    return new Node(comp, nodes);
                }
                throw new IllegalArgumentException();
            } else if (!cands.isEmpty()) {
                return new Node(r, l, c -> {
                    c.addAll(cands);
                }, nodes);
            } else {
                throw new IllegalArgumentException();
            }
        }

        void addRoots(StringBuilder sb, List<Node> nodes) {
            if (!nodes.isEmpty()) {
                sb.append(" ( ");
                boolean first = true;
                for (Node n : nodes) {
                    if (first) {
                        first = false;
                    } else {
                        sb.append(" | ");
                    }
                    String name = "c" + this.completers.size();
                    this.completers.put(name, n.completer);
                    sb.append(name);
                    addRoots(sb, n.nodes);
                }
                sb.append(" ) ");
            }
        }

        @Override // org.jline.reader.Completer
        public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
            this.completer.complete(reader, line, candidates);
        }

        /* loaded from: grasscutter.jar:org/jline/builtins/Completers$TreeCompleter$Node.class */
        public static class Node {
            final org.jline.reader.Completer completer;
            final List<Node> nodes;

            public Node(org.jline.reader.Completer completer, List<Node> nodes) {
                this.completer = completer;
                this.nodes = nodes;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$RegexCompleter.class */
    public static class RegexCompleter implements org.jline.reader.Completer {
        private final NfaMatcher<String> matcher;
        private final Function<String, org.jline.reader.Completer> completers;
        private final ThreadLocal<LineReader> reader = new ThreadLocal<>();

        public RegexCompleter(String syntax, Function<String, org.jline.reader.Completer> completers) {
            this.matcher = new NfaMatcher<>(syntax, this::doMatch);
            this.completers = completers;
        }

        @Override // org.jline.reader.Completer
        public synchronized void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
            List<String> words = line.words().subList(0, line.wordIndex());
            this.reader.set(reader);
            for (String n : this.matcher.matchPartial(words)) {
                this.completers.apply(n).complete(reader, new ArgumentLine(line.word(), line.wordCursor()), candidates);
            }
            this.reader.set(null);
        }

        private boolean doMatch(String arg, String name) {
            List<Candidate> candidates = new ArrayList<>();
            LineReader r = this.reader.get();
            boolean caseInsensitive = r != null && r.isSet(LineReader.Option.CASE_INSENSITIVE);
            this.completers.apply(name).complete(r, new ArgumentLine(arg, arg.length()), candidates);
            return candidates.stream().anyMatch(c -> {
                return caseInsensitive ? c.value().equalsIgnoreCase(arg) : c.value().equals(arg);
            });
        }

        /* loaded from: grasscutter.jar:org/jline/builtins/Completers$RegexCompleter$ArgumentLine.class */
        public static class ArgumentLine implements ParsedLine {
            private final String word;
            private final int cursor;

            public ArgumentLine(String word, int cursor) {
                this.word = word;
                this.cursor = cursor;
            }

            @Override // org.jline.reader.ParsedLine
            public String word() {
                return this.word;
            }

            @Override // org.jline.reader.ParsedLine
            public int wordCursor() {
                return this.cursor;
            }

            @Override // org.jline.reader.ParsedLine
            public int wordIndex() {
                return 0;
            }

            @Override // org.jline.reader.ParsedLine
            public List<String> words() {
                return Collections.singletonList(this.word);
            }

            @Override // org.jline.reader.ParsedLine
            public String line() {
                return this.word;
            }

            @Override // org.jline.reader.ParsedLine
            public int cursor() {
                return this.cursor;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$OptDesc.class */
    public static class OptDesc {
        private String shortOption;
        private String longOption;
        private String description;
        private org.jline.reader.Completer valueCompleter;

        protected static List<OptDesc> compile(Map<String, List<String>> optionValues, Collection<String> options) {
            List<OptDesc> out = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : optionValues.entrySet()) {
                if (entry.getKey().startsWith("--")) {
                    out.add(new OptDesc((String) null, entry.getKey(), new StringsCompleter((Iterable<String>) entry.getValue())));
                } else if (entry.getKey().matches("-[a-zA-Z]")) {
                    out.add(new OptDesc(entry.getKey(), (String) null, new StringsCompleter((Iterable<String>) entry.getValue())));
                }
            }
            for (String o : options) {
                if (o.startsWith("--")) {
                    out.add(new OptDesc(null, o));
                } else if (o.matches("-[a-zA-Z]")) {
                    out.add(new OptDesc(o, null));
                }
            }
            return out;
        }

        public OptDesc(String shortOption, String longOption, String description, org.jline.reader.Completer valueCompleter) {
            this.shortOption = shortOption;
            this.longOption = longOption;
            this.description = description;
            this.valueCompleter = valueCompleter;
        }

        public OptDesc(String shortOption, String longOption, org.jline.reader.Completer valueCompleter) {
            this(shortOption, longOption, null, valueCompleter);
        }

        public OptDesc(String shortOption, String longOption, String description) {
            this(shortOption, longOption, description, null);
        }

        public OptDesc(String shortOption, String longOption) {
            this(shortOption, longOption, null, null);
        }

        protected OptDesc() {
        }

        public void setValueCompleter(org.jline.reader.Completer valueCompleter) {
            this.valueCompleter = valueCompleter;
        }

        public String longOption() {
            return this.longOption;
        }

        public String shortOption() {
            return this.shortOption;
        }

        public String description() {
            return this.description;
        }

        protected boolean hasValue() {
            return (this.valueCompleter == null || this.valueCompleter == NullCompleter.INSTANCE) ? false : true;
        }

        protected org.jline.reader.Completer valueCompleter() {
            return this.valueCompleter;
        }

        protected void completeOption(LineReader reader, ParsedLine commandLine, List<Candidate> candidates, boolean longOpt) {
            if (!longOpt) {
                if (this.shortOption != null) {
                    candidates.add(new Candidate(this.shortOption, this.shortOption, null, this.description, null, null, false));
                }
            } else if (this.longOption == null) {
            } else {
                if (hasValue()) {
                    candidates.add(new Candidate(this.longOption + "=", this.longOption, null, this.description, null, null, false));
                } else {
                    candidates.add(new Candidate(this.longOption, this.longOption, null, this.description, null, null, true));
                }
            }
        }

        protected boolean completeValue(LineReader reader, ParsedLine commandLine, List<Candidate> candidates, String curBuf, String partialValue) {
            boolean out = false;
            List<Candidate> temp = new ArrayList<>();
            this.valueCompleter.complete(reader, reader.getParser().parse(partialValue, partialValue.length()), temp);
            for (Candidate c : temp) {
                String v = c.value();
                if (v.startsWith(partialValue)) {
                    out = true;
                    String val = c.value();
                    if (this.valueCompleter instanceof FileNameCompleter) {
                        FileNameCompleter cc = (FileNameCompleter) this.valueCompleter;
                        val = cc.getDisplay(reader.getTerminal(), Paths.get(c.value(), new String[0]), FileNameCompleter.resolver, cc.getSeparator(reader.isSet(LineReader.Option.USE_FORWARD_SLASH)));
                    }
                    candidates.add(new Candidate(curBuf + v, val, null, null, null, null, c.complete()));
                }
            }
            return out;
        }

        protected boolean match(String option) {
            return (this.shortOption != null && this.shortOption.equals(option)) || (this.longOption != null && this.longOption.equals(option));
        }

        protected boolean startsWith(String option) {
            return (this.shortOption != null && this.shortOption.startsWith(option)) || (this.longOption != null && this.longOption.startsWith(option));
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$OptionCompleter.class */
    public static class OptionCompleter implements org.jline.reader.Completer {
        private Function<String, Collection<OptDesc>> commandOptions;
        private Collection<OptDesc> options;
        private List<org.jline.reader.Completer> argsCompleters;
        private int startPos;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !Completers.class.desiredAssertionStatus();
        }

        public OptionCompleter(org.jline.reader.Completer completer, Function<String, Collection<OptDesc>> commandOptions, int startPos) {
            this.argsCompleters = new ArrayList();
            this.startPos = startPos;
            this.commandOptions = commandOptions;
            this.argsCompleters.add(completer);
        }

        public OptionCompleter(List<org.jline.reader.Completer> completers, Function<String, Collection<OptDesc>> commandOptions, int startPos) {
            this.argsCompleters = new ArrayList();
            this.startPos = startPos;
            this.commandOptions = commandOptions;
            this.argsCompleters = new ArrayList(completers);
        }

        public OptionCompleter(List<org.jline.reader.Completer> completers, Map<String, List<String>> optionValues, Collection<String> options, int startPos) {
            this(optionValues, options, startPos);
            this.argsCompleters = new ArrayList(completers);
        }

        public OptionCompleter(org.jline.reader.Completer completer, Map<String, List<String>> optionValues, Collection<String> options, int startPos) {
            this(optionValues, options, startPos);
            this.argsCompleters.add(completer);
        }

        public OptionCompleter(Map<String, List<String>> optionValues, Collection<String> options, int startPos) {
            this(OptDesc.compile(optionValues, options), startPos);
        }

        public OptionCompleter(org.jline.reader.Completer completer, Collection<OptDesc> options, int startPos) {
            this(options, startPos);
            this.argsCompleters.add(completer);
        }

        public OptionCompleter(List<org.jline.reader.Completer> completers, Collection<OptDesc> options, int startPos) {
            this(options, startPos);
            this.argsCompleters = new ArrayList(completers);
        }

        public OptionCompleter(Collection<OptDesc> options, int startPos) {
            this.argsCompleters = new ArrayList();
            this.options = options;
            this.startPos = startPos;
        }

        public void setStartPos(int startPos) {
            this.startPos = startPos;
        }

        @Override // org.jline.reader.Completer
        public void complete(LineReader reader, ParsedLine commandLine, List<Candidate> candidates) {
            if (!$assertionsDisabled && commandLine == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || candidates != null) {
                List<String> words = commandLine.words();
                String buffer = commandLine.word().substring(0, commandLine.wordCursor());
                if (this.startPos >= words.size()) {
                    candidates.add(new Candidate(buffer, buffer, null, null, null, null, true));
                    return;
                }
                String command = reader.getParser().getCommand(words.get(this.startPos - 1));
                if (buffer.startsWith("-")) {
                    boolean addbuff = true;
                    boolean valueCandidates = false;
                    boolean longOption = buffer.startsWith("--");
                    int eq = buffer.matches("-[a-zA-Z][a-zA-Z0-9]+") ? 2 : buffer.indexOf(61);
                    if (eq < 0) {
                        List<String> usedOptions = new ArrayList<>();
                        for (int i = this.startPos; i < words.size(); i++) {
                            if (words.get(i).startsWith("-")) {
                                String w = words.get(i);
                                int ind = w.indexOf(61);
                                if (ind < 0) {
                                    usedOptions.add(w);
                                } else {
                                    usedOptions.add(w.substring(0, ind));
                                }
                            }
                        }
                        for (OptDesc o : this.commandOptions == null ? this.options : this.commandOptions.apply(command)) {
                            if (!usedOptions.contains(o.shortOption()) && !usedOptions.contains(o.longOption())) {
                                if (o.startsWith(buffer)) {
                                    addbuff = false;
                                }
                                o.completeOption(reader, commandLine, candidates, longOption);
                            }
                        }
                    } else {
                        addbuff = false;
                        int nb = buffer.contains("=") ? 1 : 0;
                        String value = buffer.substring(eq + nb);
                        String curBuf = buffer.substring(0, eq + nb);
                        OptDesc option = findOptDesc(command, buffer.substring(0, eq));
                        if (option.hasValue()) {
                            valueCandidates = option.completeValue(reader, commandLine, candidates, curBuf, value);
                        }
                    }
                    if (!(!buffer.contains("=") || buffer.endsWith("=") || valueCandidates) || addbuff) {
                        candidates.add(new Candidate(buffer, buffer, null, null, null, null, true));
                    }
                } else if (words.size() > 1 && shortOptionValueCompleter(command, words.get(words.size() - 2)) != null) {
                    shortOptionValueCompleter(command, words.get(words.size() - 2)).complete(reader, commandLine, candidates);
                } else if (words.size() > 1 && longOptionValueCompleter(command, words.get(words.size() - 2)) != null) {
                    longOptionValueCompleter(command, words.get(words.size() - 2)).complete(reader, commandLine, candidates);
                } else if (!this.argsCompleters.isEmpty()) {
                    int args = -1;
                    for (int i2 = this.startPos; i2 < words.size(); i2++) {
                        if (!words.get(i2).startsWith("-") && i2 > 0 && shortOptionValueCompleter(command, words.get(i2 - 1)) == null && longOptionValueCompleter(command, words.get(i2 - 1)) == null) {
                            args++;
                        }
                    }
                    if (args == -1) {
                        candidates.add(new Candidate(buffer, buffer, null, null, null, null, true));
                    } else if (args < this.argsCompleters.size()) {
                        this.argsCompleters.get(args).complete(reader, commandLine, candidates);
                    } else {
                        this.argsCompleters.get(this.argsCompleters.size() - 1).complete(reader, commandLine, candidates);
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        private org.jline.reader.Completer longOptionValueCompleter(String command, String opt) {
            if (!opt.matches("--[a-zA-Z]+")) {
                return null;
            }
            OptDesc option = findOptDesc(this.commandOptions == null ? this.options : this.commandOptions.apply(command), opt);
            if (option.hasValue()) {
                return option.valueCompleter();
            }
            return null;
        }

        private org.jline.reader.Completer shortOptionValueCompleter(String command, String opt) {
            if (!opt.matches("-[a-zA-Z]+")) {
                return null;
            }
            org.jline.reader.Completer out = null;
            Collection<OptDesc> optDescs = this.commandOptions == null ? this.options : this.commandOptions.apply(command);
            if (opt.length() == 2) {
                out = findOptDesc(optDescs, opt).valueCompleter();
            } else if (opt.length() > 2) {
                for (int i = 1; i < opt.length(); i++) {
                    OptDesc o = findOptDesc(optDescs, "-" + opt.charAt(i));
                    if (o.shortOption() == null) {
                        return null;
                    }
                    if (out == null) {
                        out = o.valueCompleter();
                    }
                }
            }
            return out;
        }

        private OptDesc findOptDesc(String command, String opt) {
            return findOptDesc(this.commandOptions == null ? this.options : this.commandOptions.apply(command), opt);
        }

        private OptDesc findOptDesc(Collection<OptDesc> optDescs, String opt) {
            for (OptDesc o : optDescs) {
                if (o.match(opt)) {
                    return o;
                }
            }
            return new OptDesc();
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Completers$AnyCompleter.class */
    public static class AnyCompleter implements org.jline.reader.Completer {
        public static final AnyCompleter INSTANCE;
        static final /* synthetic */ boolean $assertionsDisabled;

        static {
            $assertionsDisabled = !Completers.class.desiredAssertionStatus();
            INSTANCE = new AnyCompleter();
        }

        @Override // org.jline.reader.Completer
        public void complete(LineReader reader, ParsedLine commandLine, List<Candidate> candidates) {
            if (!$assertionsDisabled && commandLine == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || candidates != null) {
                String buffer = commandLine.word().substring(0, commandLine.wordCursor());
                candidates.add(new Candidate(AttributedString.stripAnsi(buffer), buffer, null, null, null, null, true));
            } else {
                throw new AssertionError();
            }
        }
    }
}
