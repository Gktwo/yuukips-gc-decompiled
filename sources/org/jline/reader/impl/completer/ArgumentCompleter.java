package org.jline.reader.impl.completer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;

/* loaded from: grasscutter.jar:org/jline/reader/impl/completer/ArgumentCompleter.class */
public class ArgumentCompleter implements Completer {
    private final List<Completer> completers;
    private boolean strict;
    private boolean strictCommand;

    public ArgumentCompleter(Collection<Completer> completers) {
        this.completers = new ArrayList();
        this.strict = true;
        this.strictCommand = true;
        Objects.requireNonNull(completers);
        this.completers.addAll(completers);
    }

    public ArgumentCompleter(Completer... completers) {
        this(Arrays.asList(completers));
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    public void setStrictCommand(boolean strictCommand) {
        this.strictCommand = strictCommand;
    }

    public boolean isStrict() {
        return this.strict;
    }

    public List<Completer> getCompleters() {
        return this.completers;
    }

    @Override // org.jline.reader.Completer
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        Completer completer;
        Objects.requireNonNull(line);
        Objects.requireNonNull(candidates);
        if (line.wordIndex() >= 0) {
            List<Completer> completers = getCompleters();
            if (line.wordIndex() >= completers.size()) {
                completer = completers.get(completers.size() - 1);
            } else {
                completer = completers.get(line.wordIndex());
            }
            int i = this.strictCommand ? 0 : 1;
            while (isStrict() && i < line.wordIndex()) {
                int idx = i >= completers.size() ? completers.size() - 1 : i;
                if (idx != 0 || this.strictCommand) {
                    Completer sub = completers.get(idx);
                    List<? extends CharSequence> args = line.words();
                    String arg = (args == null || i >= args.size()) ? "" : args.get(i).toString();
                    List<Candidate> subCandidates = new LinkedList<>();
                    sub.complete(reader, new ArgumentLine(arg, arg.length()), subCandidates);
                    boolean found = false;
                    Iterator<Candidate> it = subCandidates.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().value().equals(arg)) {
                                found = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!found) {
                        return;
                    }
                }
                i++;
            }
            completer.complete(reader, line, candidates);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/reader/impl/completer/ArgumentCompleter$ArgumentLine.class */
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
