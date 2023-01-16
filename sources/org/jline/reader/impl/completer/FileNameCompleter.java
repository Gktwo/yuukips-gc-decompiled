package org.jline.reader.impl.completer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

@Deprecated
/* loaded from: grasscutter.jar:org/jline/reader/impl/completer/FileNameCompleter.class */
public class FileNameCompleter implements Completer {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !FileNameCompleter.class.desiredAssertionStatus();
    }

    @Override // org.jline.reader.Completer
    public void complete(LineReader reader, ParsedLine commandLine, List<Candidate> candidates) {
        String curBuf;
        Path current;
        if (!$assertionsDisabled && commandLine == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || candidates != null) {
            String buffer = commandLine.word().substring(0, commandLine.wordCursor());
            String sep = getUserDir().getFileSystem().getSeparator();
            int lastSep = buffer.lastIndexOf(sep);
            if (lastSep >= 0) {
                curBuf = buffer.substring(0, lastSep + 1);
                if (!curBuf.startsWith("~")) {
                    current = getUserDir().resolve(curBuf);
                } else if (curBuf.startsWith("~" + sep)) {
                    current = getUserHome().resolve(curBuf.substring(2));
                } else {
                    current = getUserHome().getParent().resolve(curBuf.substring(1));
                }
            } else {
                curBuf = "";
                current = getUserDir();
            }
            try {
                Files.newDirectoryStream(current, this::accept).forEach(p -> {
                    String value = curBuf + sep.getFileName().toString();
                    if (Files.isDirectory(sep, new LinkOption[0])) {
                        curBuf.add(new Candidate(value + (candidates.isSet(LineReader.Option.AUTO_PARAM_SLASH) ? reader : ""), getDisplay(candidates.getTerminal(), sep), null, null, candidates.isSet(LineReader.Option.AUTO_REMOVE_SLASH) ? reader : null, null, false));
                    } else {
                        curBuf.add(new Candidate(value, getDisplay(candidates.getTerminal(), sep), null, null, null, null, true));
                    }
                });
            } catch (IOException e) {
            }
        } else {
            throw new AssertionError();
        }
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

    protected String getDisplay(Terminal terminal, Path p) {
        String name = p.getFileName().toString();
        if (Files.isDirectory(p, new LinkOption[0])) {
            AttributedStringBuilder sb = new AttributedStringBuilder();
            sb.styled(AttributedStyle.BOLD.foreground(1), name);
            sb.append((CharSequence) "/");
            name = sb.toAnsi(terminal);
        } else if (Files.isSymbolicLink(p)) {
            AttributedStringBuilder sb2 = new AttributedStringBuilder();
            sb2.styled(AttributedStyle.BOLD.foreground(1), name);
            sb2.append((CharSequence) "@");
            name = sb2.toAnsi(terminal);
        }
        return name;
    }
}
