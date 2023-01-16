package org.jline.reader;

import java.util.List;

/* loaded from: grasscutter.jar:org/jline/reader/ParsedLine.class */
public interface ParsedLine {
    String word();

    int wordCursor();

    int wordIndex();

    List<String> words();

    String line();

    int cursor();
}
