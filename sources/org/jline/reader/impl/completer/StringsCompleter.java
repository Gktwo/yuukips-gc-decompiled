package org.jline.reader.impl.completer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.utils.AttributedString;

/* loaded from: grasscutter.jar:org/jline/reader/impl/completer/StringsCompleter.class */
public class StringsCompleter implements Completer {
    protected Collection<Candidate> candidates;
    protected Supplier<Collection<String>> stringsSupplier;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !StringsCompleter.class.desiredAssertionStatus();
    }

    public StringsCompleter() {
        this((Collection<Candidate>) Collections.emptyList());
    }

    public StringsCompleter(Supplier<Collection<String>> stringsSupplier) {
        if ($assertionsDisabled || stringsSupplier != null) {
            this.candidates = null;
            this.stringsSupplier = stringsSupplier;
            return;
        }
        throw new AssertionError();
    }

    public StringsCompleter(String... strings) {
        this((Iterable<String>) Arrays.asList(strings));
    }

    public StringsCompleter(Iterable<String> strings) {
        if ($assertionsDisabled || strings != null) {
            this.candidates = new ArrayList();
            for (String string : strings) {
                this.candidates.add(new Candidate(AttributedString.stripAnsi(string), string, null, null, null, null, true));
            }
            return;
        }
        throw new AssertionError();
    }

    public StringsCompleter(Candidate... candidates) {
        this((Collection<Candidate>) Arrays.asList(candidates));
    }

    public StringsCompleter(Collection<Candidate> candidates) {
        if ($assertionsDisabled || candidates != null) {
            this.candidates = new ArrayList(candidates);
            return;
        }
        throw new AssertionError();
    }

    @Override // org.jline.reader.Completer
    public void complete(LineReader reader, ParsedLine commandLine, List<Candidate> candidates) {
        if (!$assertionsDisabled && commandLine == null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && candidates == null) {
            throw new AssertionError();
        } else if (this.candidates != null) {
            candidates.addAll(this.candidates);
        } else {
            for (String string : this.stringsSupplier.get()) {
                candidates.add(new Candidate(AttributedString.stripAnsi(string), string, null, null, null, null, true));
            }
        }
    }

    public String toString() {
        return "StringsCompleter" + (this.candidates != null ? this.candidates.toString() : "{" + this.stringsSupplier.toString() + "}");
    }
}
