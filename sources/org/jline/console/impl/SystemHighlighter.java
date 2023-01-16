package org.jline.console.impl;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jline.builtins.Nano;
import org.jline.builtins.Styles;
import org.jline.console.SystemRegistry;
import org.jline.reader.LineReader;
import org.jline.reader.Parser;
import org.jline.reader.impl.DefaultHighlighter;
import org.jline.utils.AttributedCharSequence;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.OSUtils;
import org.jline.utils.StyleResolver;

/* loaded from: grasscutter.jar:org/jline/console/impl/SystemHighlighter.class */
public class SystemHighlighter extends DefaultHighlighter {
    private static final StyleResolver resolver = Styles.lsStyle();
    protected final Nano.SyntaxHighlighter commandHighlighter;
    protected final Nano.SyntaxHighlighter argsHighlighter;
    protected final Nano.SyntaxHighlighter langHighlighter;
    protected final Map<String, FileHighlightCommand> fileHighlight = new HashMap();
    protected final SystemRegistry systemRegistry = SystemRegistry.get();

    public SystemHighlighter(Nano.SyntaxHighlighter commandHighlighter, Nano.SyntaxHighlighter argsHighlighter, Nano.SyntaxHighlighter langHighlighter) {
        this.commandHighlighter = commandHighlighter;
        this.argsHighlighter = argsHighlighter;
        this.langHighlighter = langHighlighter;
    }

    @Override // org.jline.reader.impl.DefaultHighlighter, org.jline.reader.Highlighter
    public AttributedString highlight(LineReader reader, String buffer) {
        return doDefaultHighlight(reader) ? highlight(reader, buffer) : systemHighlight(reader, buffer);
    }

    public void addFileHighlight(String... commands) {
        for (String c : commands) {
            this.fileHighlight.put(c, new FileHighlightCommand());
        }
    }

    public void addFileHighlight(String command, String subcommand, Collection<String> fileOptions) {
        this.fileHighlight.put(command, new FileHighlightCommand(subcommand, fileOptions));
    }

    private boolean doDefaultHighlight(LineReader reader) {
        String search = reader.getSearchTerm();
        return (search != null && search.length() > 0) || reader.getRegionActive() != LineReader.RegionType.NONE || this.errorIndex > -1 || this.errorPattern != null;
    }

    protected AttributedString systemHighlight(LineReader reader, String buffer) {
        AttributedString out;
        String command = reader.getParser().getCommand(buffer);
        if (buffer.trim().isEmpty()) {
            out = new AttributedStringBuilder().append((CharSequence) buffer).toAttributedString();
        } else if (this.fileHighlight.containsKey(command)) {
            FileHighlightCommand fhc = this.fileHighlight.get(command);
            if (!fhc.hasFileOptions()) {
                out = doFileArgsHighlight(reader, buffer, fhc);
            } else {
                out = doFileOptsHighlight(reader, buffer, fhc);
            }
        } else if (this.systemRegistry.isCommandOrScript(command) || this.systemRegistry.isCommandAlias(command)) {
            out = doCommandHighlight(buffer);
        } else if (this.langHighlighter != null) {
            out = this.langHighlighter.highlight(buffer);
        } else {
            out = new AttributedStringBuilder().append((CharSequence) buffer).toAttributedString();
        }
        return out;
    }

    protected AttributedString doFileOptsHighlight(LineReader reader, String buffer, FileHighlightCommand fhc) {
        int idx0 = commandIndex(buffer);
        AttributedStringBuilder asb = new AttributedStringBuilder();
        if (idx0 < 0) {
            highlightCommand(buffer, asb);
        } else {
            highlightCommand(buffer.substring(0, idx0), asb);
            List<String> words = reader.getParser().parse(buffer, buffer.length() + 1, Parser.ParseContext.COMPLETE).words();
            if (!fhc.isSubcommand() || (words.size() > 2 && fhc.getSubcommand().equals(words.get(1)))) {
                int firstArg = fhc.isSubcommand() ? 1 : 0;
                int idx = buffer.indexOf(words.get(firstArg)) + words.get(firstArg).length() + 1;
                highlightArgs(buffer.substring(idx0, idx), asb);
                boolean fileOption = false;
                for (int i = firstArg + 1; i < words.size(); i++) {
                    int nextIdx = buffer.substring(idx).indexOf(words.get(i)) + idx;
                    for (int j = idx; j < nextIdx; j++) {
                        asb.append(buffer.charAt(j));
                    }
                    String word = words.get(i);
                    if (word.contains("=") && fhc.getFileOptions().contains(word.substring(0, word.indexOf("=")))) {
                        highlightArgs(word.substring(0, word.indexOf("=") + 1), asb);
                        highlightFileArg(reader, word.substring(word.indexOf("=") + 1), asb);
                    } else if (fhc.getFileOptions().contains(word)) {
                        highlightArgs(word, asb);
                        fileOption = true;
                    } else if (fileOption) {
                        highlightFileArg(reader, word, asb);
                    } else {
                        highlightArgs(word, asb);
                        fileOption = false;
                    }
                    idx = nextIdx + word.length();
                }
            } else {
                highlightArgs(buffer.substring(idx0), asb);
            }
        }
        return asb.toAttributedString();
    }

    protected AttributedString doFileArgsHighlight(LineReader reader, String buffer, FileHighlightCommand fhc) {
        int idx0 = commandIndex(buffer);
        AttributedStringBuilder asb = new AttributedStringBuilder();
        if (idx0 < 0) {
            highlightCommand(buffer, asb);
        } else {
            highlightCommand(buffer.substring(0, idx0), asb);
            List<String> words = reader.getParser().parse(buffer, buffer.length() + 1, Parser.ParseContext.COMPLETE).words();
            if (!fhc.isSubcommand() || (words.size() > 2 && fhc.getSubcommand().equals(words.get(1)))) {
                int firstArg = fhc.isSubcommand() ? 1 : 0;
                int idx = buffer.indexOf(words.get(firstArg)) + words.get(firstArg).length();
                highlightArgs(buffer.substring(idx0, idx), asb);
                for (int i = firstArg + 1; i < words.size(); i++) {
                    int nextIdx = buffer.substring(idx).indexOf(words.get(i)) + idx;
                    for (int j = idx; j < nextIdx; j++) {
                        asb.append(buffer.charAt(j));
                    }
                    highlightFileArg(reader, words.get(i), asb);
                    idx = nextIdx + words.get(i).length();
                }
            } else {
                highlightArgs(buffer.substring(idx0), asb);
            }
        }
        return asb.toAttributedString();
    }

    protected AttributedString doCommandHighlight(String buffer) {
        AttributedString out;
        if (this.commandHighlighter == null && this.argsHighlighter == null) {
            out = new AttributedStringBuilder().append((CharSequence) buffer).toAttributedString();
        } else {
            int idx = commandIndex(buffer);
            AttributedStringBuilder asb = new AttributedStringBuilder();
            if (idx < 0) {
                highlightCommand(buffer, asb);
            } else {
                highlightCommand(buffer.substring(0, idx), asb);
                highlightArgs(buffer.substring(idx), asb);
            }
            out = asb.toAttributedString();
        }
        return out;
    }

    private int commandIndex(String buffer) {
        int idx = -1;
        boolean cmdFound = false;
        int i = 0;
        while (true) {
            if (i >= buffer.length()) {
                break;
            }
            if (buffer.charAt(i) != ' ') {
                cmdFound = true;
            } else if (cmdFound) {
                idx = i;
                break;
            }
            i++;
        }
        return idx;
    }

    private void highlightFileArg(LineReader reader, String arg, AttributedStringBuilder asb) {
        if (arg.startsWith("-")) {
            highlightArgs(arg, asb);
            return;
        }
        String separator = reader.isSet(LineReader.Option.USE_FORWARD_SLASH) ? "/" : Paths.get(System.getProperty("user.dir"), new String[0]).getFileSystem().getSeparator();
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Path> iterator = new File(arg).toPath().iterator();
            if (OSUtils.IS_WINDOWS && arg.matches("^[A-Za-z]:.*$")) {
                if (arg.length() == 2) {
                    sb.append(arg);
                    asb.append((CharSequence) arg);
                } else if (arg.charAt(2) == separator.charAt(0)) {
                    sb.append(arg.substring(0, 3));
                    asb.append((CharSequence) arg.substring(0, 3));
                }
            }
            if (arg.startsWith(separator)) {
                sb.append(separator);
                asb.append((CharSequence) separator);
            }
            while (iterator.hasNext()) {
                sb.append(iterator.next());
                highlightFile(new File(sb.toString()).toPath(), asb);
                if (iterator.hasNext()) {
                    sb.append(separator);
                    asb.append((CharSequence) separator);
                }
            }
            if (arg.length() > 2 && !arg.matches("^[A-Za-z]:" + separator) && arg.endsWith(separator)) {
                asb.append((CharSequence) separator);
            }
        } catch (Exception e) {
            asb.append((CharSequence) arg);
        }
    }

    private void highlightFile(Path path, AttributedStringBuilder asb) {
        AttributedStringBuilder sb = new AttributedStringBuilder();
        String name = path.getFileName().toString();
        int idx = name.lastIndexOf(Mapper.IGNORED_FIELDNAME);
        String type = idx != -1 ? ".*" + name.substring(idx) : null;
        if (Files.isSymbolicLink(path)) {
            sb.styled(resolver.resolve(".ln"), name);
        } else if (Files.isDirectory(path, new LinkOption[0])) {
            sb.styled(resolver.resolve(".di"), name);
        } else if (Files.isExecutable(path) && !OSUtils.IS_WINDOWS) {
            sb.styled(resolver.resolve(".ex"), name);
        } else if (type != null && resolver.resolve(type).getStyle() != 0) {
            sb.styled(resolver.resolve(type), name);
        } else if (Files.isRegularFile(path, new LinkOption[0])) {
            sb.styled(resolver.resolve(".fi"), name);
        } else {
            sb.append((CharSequence) name);
        }
        asb.append((AttributedCharSequence) sb);
    }

    private void highlightArgs(String args, AttributedStringBuilder asb) {
        if (this.argsHighlighter != null) {
            asb.append(this.argsHighlighter.highlight(args));
        } else {
            asb.append((CharSequence) args);
        }
    }

    private void highlightCommand(String command, AttributedStringBuilder asb) {
        if (this.commandHighlighter != null) {
            asb.append(this.commandHighlighter.highlight(command));
        } else {
            asb.append((CharSequence) command);
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/console/impl/SystemHighlighter$FileHighlightCommand.class */
    public static class FileHighlightCommand {
        private final String subcommand;
        private final List<String> fileOptions;

        public FileHighlightCommand() {
            this(null, new ArrayList());
        }

        public FileHighlightCommand(String subcommand, Collection<String> fileOptions) {
            this.fileOptions = new ArrayList();
            this.subcommand = subcommand;
            this.fileOptions.addAll(fileOptions);
        }

        public boolean isSubcommand() {
            return this.subcommand != null;
        }

        public boolean hasFileOptions() {
            return !this.fileOptions.isEmpty();
        }

        public String getSubcommand() {
            return this.subcommand;
        }

        public List<String> getFileOptions() {
            return this.fileOptions;
        }
    }
}
