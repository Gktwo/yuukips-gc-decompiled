package org.jline.reader.impl.completer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;

/* loaded from: grasscutter.jar:org/jline/reader/impl/completer/AggregateCompleter.class */
public class AggregateCompleter implements Completer {
    private final Collection<Completer> completers;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !AggregateCompleter.class.desiredAssertionStatus();
    }

    public AggregateCompleter(Completer... completers) {
        this(Arrays.asList(completers));
    }

    public AggregateCompleter(Collection<Completer> completers) {
        if ($assertionsDisabled || completers != null) {
            this.completers = completers;
            return;
        }
        throw new AssertionError();
    }

    public Collection<Completer> getCompleters() {
        return this.completers;
    }

    @Override // org.jline.reader.Completer
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        Objects.requireNonNull(line);
        Objects.requireNonNull(candidates);
        this.completers.forEach(c -> {
            c.complete(reader, line, candidates);
        });
    }

    public String toString() {
        return getClass().getSimpleName() + "{completers=" + this.completers + '}';
    }
}
