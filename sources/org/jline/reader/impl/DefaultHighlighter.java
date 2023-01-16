package org.jline.reader.impl;

import java.util.regex.Pattern;
import org.jline.reader.Highlighter;
import org.jline.reader.LineReader;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.WCWidth;

/* loaded from: grasscutter.jar:org/jline/reader/impl/DefaultHighlighter.class */
public class DefaultHighlighter implements Highlighter {
    protected Pattern errorPattern;
    protected int errorIndex = -1;

    @Override // org.jline.reader.Highlighter
    public void setErrorPattern(Pattern errorPattern) {
        this.errorPattern = errorPattern;
    }

    @Override // org.jline.reader.Highlighter
    public void setErrorIndex(int errorIndex) {
        this.errorIndex = errorIndex;
    }

    @Override // org.jline.reader.Highlighter
    public AttributedString highlight(LineReader reader, String buffer) {
        int underlineStart = -1;
        int underlineEnd = -1;
        int negativeStart = -1;
        int negativeEnd = -1;
        String search = reader.getSearchTerm();
        if (search != null && search.length() > 0) {
            underlineStart = buffer.indexOf(search);
            if (underlineStart >= 0) {
                underlineEnd = (underlineStart + search.length()) - 1;
            }
        }
        if (reader.getRegionActive() != LineReader.RegionType.NONE) {
            negativeStart = reader.getRegionMark();
            negativeEnd = reader.getBuffer().cursor();
            if (negativeStart > negativeEnd) {
                negativeEnd = negativeStart;
                negativeStart = negativeEnd;
            }
            if (reader.getRegionActive() == LineReader.RegionType.LINE) {
                while (negativeStart > 0 && reader.getBuffer().atChar(negativeStart - 1) != 10) {
                    negativeStart--;
                }
                while (negativeEnd < reader.getBuffer().length() - 1 && reader.getBuffer().atChar(negativeEnd + 1) != 10) {
                    negativeEnd++;
                }
            }
        }
        AttributedStringBuilder sb = new AttributedStringBuilder();
        for (int i = 0; i < buffer.length(); i++) {
            if (i == underlineStart) {
                sb.style((v0) -> {
                    return v0.underline();
                });
            }
            if (i == negativeStart) {
                sb.style((v0) -> {
                    return v0.inverse();
                });
            }
            if (i == this.errorIndex) {
                sb.style((v0) -> {
                    return v0.inverse();
                });
            }
            char c = buffer.charAt(i);
            if (c == '\t' || c == '\n') {
                sb.append(c);
            } else if (c < ' ') {
                sb.style((v0) -> {
                    return v0.inverseNeg();
                }).append('^').append((char) (c + '@')).style((v0) -> {
                    return v0.inverseNeg();
                });
            } else if (WCWidth.wcwidth(c) > 0) {
                sb.append(c);
            }
            if (i == underlineEnd) {
                sb.style((v0) -> {
                    return v0.underlineOff();
                });
            }
            if (i == negativeEnd) {
                sb.style((v0) -> {
                    return v0.inverseOff();
                });
            }
            if (i == this.errorIndex) {
                sb.style((v0) -> {
                    return v0.inverseOff();
                });
            }
        }
        if (this.errorPattern != null) {
            sb.styleMatches(this.errorPattern, AttributedStyle.INVERSE);
        }
        return sb.toAttributedString();
    }
}
