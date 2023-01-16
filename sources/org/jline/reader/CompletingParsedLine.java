package org.jline.reader;

/* loaded from: grasscutter.jar:org/jline/reader/CompletingParsedLine.class */
public interface CompletingParsedLine extends ParsedLine {
    CharSequence escape(CharSequence charSequence, boolean z);

    int rawWordCursor();

    int rawWordLength();
}
