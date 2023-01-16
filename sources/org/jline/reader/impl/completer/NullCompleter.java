package org.jline.reader.impl.completer;

import java.util.List;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;

/* loaded from: grasscutter.jar:org/jline/reader/impl/completer/NullCompleter.class */
public final class NullCompleter implements Completer {
    public static final NullCompleter INSTANCE = new NullCompleter();

    @Override // org.jline.reader.Completer
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
    }
}
