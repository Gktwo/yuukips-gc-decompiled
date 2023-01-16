package org.jline.reader;

import java.util.List;

/* loaded from: grasscutter.jar:org/jline/reader/Completer.class */
public interface Completer {
    void complete(LineReader lineReader, ParsedLine parsedLine, List<Candidate> list);
}
