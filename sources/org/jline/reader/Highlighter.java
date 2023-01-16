package org.jline.reader;

import java.util.regex.Pattern;
import org.jline.utils.AttributedString;

/* loaded from: grasscutter.jar:org/jline/reader/Highlighter.class */
public interface Highlighter {
    AttributedString highlight(LineReader lineReader, String str);

    void setErrorPattern(Pattern pattern);

    void setErrorIndex(int i);
}
