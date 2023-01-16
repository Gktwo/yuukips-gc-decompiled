package org.jline.reader;

import java.util.List;
import java.util.Map;
import org.jline.reader.LineReader;

/* loaded from: grasscutter.jar:org/jline/reader/CompletionMatcher.class */
public interface CompletionMatcher {
    void compile(Map<LineReader.Option, Boolean> map, boolean z, CompletingParsedLine completingParsedLine, boolean z2, int i, String str);

    List<Candidate> matches(List<Candidate> list);

    Candidate exactMatch();

    String getCommonPrefix();
}
