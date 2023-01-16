package org.jline.utils;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/AttributedString.class */
public class AttributedString extends AttributedCharSequence {
    final char[] buffer;
    final long[] style;
    final int start;
    final int end;
    public static final AttributedString EMPTY = new AttributedString("");
    public static final AttributedString NEWLINE = new AttributedString("\n");

    public AttributedString(CharSequence str) {
        this(str, 0, str.length(), (AttributedStyle) null);
    }

    public AttributedString(CharSequence str, int start, int end) {
        this(str, start, end, (AttributedStyle) null);
    }

    public AttributedString(CharSequence str, AttributedStyle s) {
        this(str, 0, str.length(), s);
    }

    public AttributedString(CharSequence str, int start, int end, AttributedStyle s) {
        if (end < start) {
            throw new InvalidParameterException();
        } else if (str instanceof AttributedString) {
            AttributedString as = (AttributedString) str;
            this.buffer = as.buffer;
            if (s != null) {
                this.style = (long[]) as.style.clone();
                for (int i = 0; i < this.style.length; i++) {
                    this.style[i] = (this.style[i] & (s.getMask() ^ -1)) | s.getStyle();
                }
            } else {
                this.style = as.style;
            }
            this.start = as.start + start;
            this.end = as.start + end;
        } else if (str instanceof AttributedStringBuilder) {
            AttributedString as2 = ((AttributedStringBuilder) str).subSequence(start, end);
            this.buffer = as2.buffer;
            this.style = as2.style;
            if (s != null) {
                for (int i2 = 0; i2 < this.style.length; i2++) {
                    this.style[i2] = (this.style[i2] & (s.getMask() ^ -1)) | s.getStyle();
                }
            }
            this.start = as2.start;
            this.end = as2.end;
        } else {
            int l = end - start;
            this.buffer = new char[l];
            for (int i3 = 0; i3 < l; i3++) {
                this.buffer[i3] = str.charAt(start + i3);
            }
            this.style = new long[l];
            if (s != null) {
                Arrays.fill(this.style, s.getStyle());
            }
            this.start = 0;
            this.end = l;
        }
    }

    /* access modifiers changed from: package-private */
    public AttributedString(char[] buffer, long[] style, int start, int end) {
        this.buffer = buffer;
        this.style = style;
        this.start = start;
        this.end = end;
    }

    public static AttributedString fromAnsi(String ansi) {
        return fromAnsi(ansi, 0);
    }

    public static AttributedString fromAnsi(String ansi, int tabs) {
        return fromAnsi(ansi, Arrays.asList(Integer.valueOf(tabs)));
    }

    public static AttributedString fromAnsi(String ansi, List<Integer> tabs) {
        if (ansi == null) {
            return null;
        }
        return new AttributedStringBuilder(ansi.length()).tabs(tabs).ansiAppend(ansi).toAttributedString();
    }

    public static String stripAnsi(String ansi) {
        if (ansi == null) {
            return null;
        }
        return new AttributedStringBuilder(ansi.length()).ansiAppend(ansi).toString();
    }

    @Override // org.jline.utils.AttributedCharSequence
    protected char[] buffer() {
        return this.buffer;
    }

    @Override // org.jline.utils.AttributedCharSequence
    protected int offset() {
        return this.start;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.end - this.start;
    }

    @Override // org.jline.utils.AttributedCharSequence
    public AttributedStyle styleAt(int index) {
        return new AttributedStyle(this.style[this.start + index], this.style[this.start + index]);
    }

    @Override // org.jline.utils.AttributedCharSequence
    long styleCodeAt(int index) {
        return this.style[this.start + index];
    }

    @Override // org.jline.utils.AttributedCharSequence, java.lang.CharSequence
    public AttributedString subSequence(int start, int end) {
        return new AttributedString(this, start, end);
    }

    public AttributedString styleMatches(Pattern pattern, AttributedStyle style) {
        Matcher matcher = pattern.matcher(this);
        if (!matcher.find()) {
            return this;
        }
        long[] newstyle = (long[]) this.style.clone();
        do {
            for (int i = matcher.start(); i < matcher.end(); i++) {
                newstyle[this.start + i] = (newstyle[this.start + i] & (style.getMask() ^ -1)) | style.getStyle();
            }
        } while (matcher.find());
        return new AttributedString(this.buffer, newstyle, this.start, this.end);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttributedString that = (AttributedString) o;
        return this.end - this.start == that.end - that.start && arrEq(this.buffer, that.buffer, this.start, that.start, this.end - this.start) && arrEq(this.style, that.style, this.start, that.start, this.end - this.start);
    }

    private boolean arrEq(char[] a1, char[] a2, int s1, int s2, int l) {
        for (int i = 0; i < l; i++) {
            if (a1[s1 + i] != a2[s2 + i]) {
                return false;
            }
        }
        return true;
    }

    private boolean arrEq(long[] a1, long[] a2, int s1, int s2, int l) {
        for (int i = 0; i < l; i++) {
            if (a1[s1 + i] != a2[s2 + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * ((31 * Arrays.hashCode(this.buffer)) + Arrays.hashCode(this.style))) + this.start)) + this.end;
    }

    public static AttributedString join(AttributedString delimiter, AttributedString... elements) {
        Objects.requireNonNull(delimiter);
        Objects.requireNonNull(elements);
        return join(delimiter, Arrays.asList(elements));
    }

    public static AttributedString join(AttributedString delimiter, Iterable<AttributedString> elements) {
        Objects.requireNonNull(elements);
        AttributedStringBuilder sb = new AttributedStringBuilder();
        int i = 0;
        for (AttributedString str : elements) {
            i++;
            if (i > 0 && delimiter != null) {
                sb.append(delimiter);
            }
            sb.append(str);
        }
        return sb.toAttributedString();
    }
}
