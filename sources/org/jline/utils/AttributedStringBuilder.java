package org.jline.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/AttributedStringBuilder.class */
public class AttributedStringBuilder extends AttributedCharSequence implements Appendable {
    private char[] buffer;
    private long[] style;
    private int length;
    private TabStops tabs;
    private int lastLineLength;
    private AttributedStyle current;

    public static AttributedString append(CharSequence... strings) {
        AttributedStringBuilder sb = new AttributedStringBuilder();
        for (CharSequence s : strings) {
            sb.append(s);
        }
        return sb.toAttributedString();
    }

    public AttributedStringBuilder() {
        this(64);
    }

    public AttributedStringBuilder(int capacity) {
        this.tabs = new TabStops(0);
        this.lastLineLength = 0;
        this.current = AttributedStyle.DEFAULT;
        this.buffer = new char[capacity];
        this.style = new long[capacity];
        this.length = 0;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // org.jline.utils.AttributedCharSequence, java.lang.CharSequence
    public char charAt(int index) {
        return this.buffer[index];
    }

    @Override // org.jline.utils.AttributedCharSequence
    public AttributedStyle styleAt(int index) {
        return new AttributedStyle(this.style[index], this.style[index]);
    }

    @Override // org.jline.utils.AttributedCharSequence
    long styleCodeAt(int index) {
        return this.style[index];
    }

    @Override // org.jline.utils.AttributedCharSequence
    protected char[] buffer() {
        return this.buffer;
    }

    @Override // org.jline.utils.AttributedCharSequence
    protected int offset() {
        return 0;
    }

    @Override // org.jline.utils.AttributedCharSequence, java.lang.CharSequence
    public AttributedString subSequence(int start, int end) {
        return new AttributedString(Arrays.copyOfRange(this.buffer, start, end), Arrays.copyOfRange(this.style, start, end), 0, end - start);
    }

    @Override // java.lang.Appendable
    public AttributedStringBuilder append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        return append(new AttributedString(csq, this.current));
    }

    @Override // java.lang.Appendable
    public AttributedStringBuilder append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        return append(csq.subSequence(start, end));
    }

    @Override // java.lang.Appendable
    public AttributedStringBuilder append(char c) {
        return append((CharSequence) Character.toString(c));
    }

    public AttributedStringBuilder append(CharSequence csq, AttributedStyle style) {
        return append(new AttributedString(csq, style));
    }

    public AttributedStringBuilder style(AttributedStyle style) {
        this.current = style;
        return this;
    }

    public AttributedStringBuilder style(Function<AttributedStyle, AttributedStyle> style) {
        this.current = style.apply(this.current);
        return this;
    }

    public AttributedStringBuilder styled(Function<AttributedStyle, AttributedStyle> style, CharSequence cs) {
        return styled(style, sb -> {
            sb.append(cs);
        });
    }

    public AttributedStringBuilder styled(AttributedStyle style, CharSequence cs) {
        return styled(s -> {
            return style;
        }, sb -> {
            sb.append(cs);
        });
    }

    public AttributedStringBuilder styled(Function<AttributedStyle, AttributedStyle> style, Consumer<AttributedStringBuilder> consumer) {
        AttributedStyle prev = this.current;
        this.current = style.apply(prev);
        consumer.accept(this);
        this.current = prev;
        return this;
    }

    public AttributedStyle style() {
        return this.current;
    }

    public AttributedStringBuilder append(AttributedString str) {
        return append((AttributedCharSequence) str, 0, str.length());
    }

    public AttributedStringBuilder append(AttributedString str, int start, int end) {
        return append((AttributedCharSequence) str, start, end);
    }

    public AttributedStringBuilder append(AttributedCharSequence str) {
        return append(str, 0, str.length());
    }

    public AttributedStringBuilder append(AttributedCharSequence str, int start, int end) {
        ensureCapacity((this.length + end) - start);
        for (int i = start; i < end; i++) {
            char c = str.charAt(i);
            long s = (str.styleCodeAt(i) & (this.current.getMask() ^ -1)) | this.current.getStyle();
            if (!this.tabs.defined() || c != '\t') {
                ensureCapacity(this.length + 1);
                this.buffer[this.length] = c;
                this.style[this.length] = s;
                if (c == '\n') {
                    this.lastLineLength = 0;
                } else {
                    this.lastLineLength++;
                }
                this.length++;
            } else {
                insertTab(new AttributedStyle(s, 0));
            }
        }
        return this;
    }

    protected void ensureCapacity(int nl) {
        if (nl > this.buffer.length) {
            int s = Math.max(this.buffer.length, 1);
            while (s <= nl) {
                s *= 2;
            }
            this.buffer = Arrays.copyOf(this.buffer, s);
            this.style = Arrays.copyOf(this.style, s);
        }
    }

    public void appendAnsi(String ansi) {
        ansiAppend(ansi);
    }

    public AttributedStringBuilder ansiAppend(String ansi) {
        int ansiStart = 0;
        int ansiState = 0;
        ensureCapacity(this.length + ansi.length());
        for (int i = 0; i < ansi.length(); i++) {
            char c = ansi.charAt(i);
            if (ansiState == 0 && c == 27) {
                ansiState++;
            } else if (ansiState == 1 && c == '[') {
                ansiState++;
                ansiStart = i + 1;
            } else if (ansiState == 2) {
                if (c == 'm') {
                    String[] params = ansi.substring(ansiStart, i).split(";");
                    int j = 0;
                    while (j < params.length) {
                        int ansiParam = params[j].isEmpty() ? 0 : Integer.parseInt(params[j]);
                        switch (ansiParam) {
                            case 0:
                                this.current = AttributedStyle.DEFAULT;
                                break;
                            case 1:
                                this.current = this.current.bold();
                                break;
                            case 2:
                                this.current = this.current.faint();
                                break;
                            case 3:
                                this.current = this.current.italic();
                                break;
                            case 4:
                                this.current = this.current.underline();
                                break;
                            case 5:
                                this.current = this.current.blink();
                                break;
                            case 7:
                                this.current = this.current.inverse();
                                break;
                            case 8:
                                this.current = this.current.conceal();
                                break;
                            case 9:
                                this.current = this.current.crossedOut();
                                break;
                            case 22:
                                this.current = this.current.boldOff().faintOff();
                                break;
                            case 23:
                                this.current = this.current.italicOff();
                                break;
                            case 24:
                                this.current = this.current.underlineOff();
                                break;
                            case 25:
                                this.current = this.current.blinkOff();
                                break;
                            case 27:
                                this.current = this.current.inverseOff();
                                break;
                            case 28:
                                this.current = this.current.concealOff();
                                break;
                            case 29:
                                this.current = this.current.crossedOutOff();
                                break;
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                                this.current = this.current.foreground(ansiParam - 30);
                                break;
                            case 38:
                            case 48:
                                if (j + 1 < params.length) {
                                    j++;
                                    int ansiParam2 = Integer.parseInt(params[j]);
                                    if (ansiParam2 == 2) {
                                        if (j + 3 < params.length) {
                                            int j2 = j + 1;
                                            int r = Integer.parseInt(params[j2]);
                                            int j3 = j2 + 1;
                                            int g = Integer.parseInt(params[j3]);
                                            j = j3 + 1;
                                            int b = Integer.parseInt(params[j]);
                                            if (ansiParam == 38) {
                                                this.current = this.current.foreground(r, g, b);
                                                break;
                                            } else {
                                                this.current = this.current.background(r, g, b);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else if (ansiParam2 == 5 && j + 1 < params.length) {
                                        j++;
                                        int col = Integer.parseInt(params[j]);
                                        if (ansiParam == 38) {
                                            this.current = this.current.foreground(col);
                                            break;
                                        } else {
                                            this.current = this.current.background(col);
                                            break;
                                        }
                                    }
                                } else {
                                    break;
                                }
                                break;
                            case 39:
                                this.current = this.current.foregroundOff();
                                break;
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                                this.current = this.current.background(ansiParam - 40);
                                break;
                            case 49:
                                this.current = this.current.backgroundOff();
                                break;
                            case 90:
                            case 91:
                            case 92:
                            case 93:
                            case 94:
                            case 95:
                            case 96:
                            case 97:
                                this.current = this.current.foreground((ansiParam - 90) + 8);
                                break;
                            case 100:
                            case 101:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                                this.current = this.current.background((ansiParam - 100) + 8);
                                break;
                        }
                        j++;
                    }
                    ansiState = 0;
                } else if ((c < '0' || c > '9') && c != ';') {
                    ansiState = 0;
                }
            } else if (c != '\t' || !this.tabs.defined()) {
                ensureCapacity(this.length + 1);
                this.buffer[this.length] = c;
                this.style[this.length] = this.current.getStyle();
                if (c == '\n') {
                    this.lastLineLength = 0;
                } else {
                    this.lastLineLength++;
                }
                this.length++;
            } else {
                insertTab(this.current);
            }
        }
        return this;
    }

    protected void insertTab(AttributedStyle s) {
        int nb = this.tabs.spaces(this.lastLineLength);
        ensureCapacity(this.length + nb);
        for (int i = 0; i < nb; i++) {
            this.buffer[this.length] = ' ';
            this.style[this.length] = s.getStyle();
            this.length++;
        }
        this.lastLineLength += nb;
    }

    public void setLength(int l) {
        this.length = l;
    }

    public AttributedStringBuilder tabs(int tabsize) {
        if (tabsize >= 0) {
            return tabs(Arrays.asList(Integer.valueOf(tabsize)));
        }
        throw new IllegalArgumentException("Tab size must be non negative");
    }

    public AttributedStringBuilder tabs(List<Integer> tabs) {
        if (this.length > 0) {
            throw new IllegalStateException("Cannot change tab size after appending text");
        }
        this.tabs = new TabStops(tabs);
        return this;
    }

    public AttributedStringBuilder styleMatches(Pattern pattern, AttributedStyle s) {
        Matcher matcher = pattern.matcher(this);
        while (matcher.find()) {
            for (int i = matcher.start(); i < matcher.end(); i++) {
                this.style[i] = (this.style[i] & (s.getMask() ^ -1)) | s.getStyle();
            }
        }
        return this;
    }

    public AttributedStringBuilder styleMatches(Pattern pattern, List<AttributedStyle> styles) {
        Matcher matcher = pattern.matcher(this);
        while (matcher.find()) {
            for (int group = 0; group < matcher.groupCount(); group++) {
                AttributedStyle s = styles.get(group);
                for (int i = matcher.start(group + 1); i < matcher.end(group + 1); i++) {
                    this.style[i] = (this.style[i] & (s.getMask() ^ -1)) | s.getStyle();
                }
            }
        }
        return this;
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/utils/AttributedStringBuilder$TabStops.class */
    public static class TabStops {
        private List<Integer> tabs;
        private int lastStop;
        private int lastSize;

        public TabStops(int tabs) {
            this.tabs = new ArrayList();
            this.lastStop = 0;
            this.lastSize = 0;
            this.lastSize = tabs;
        }

        public TabStops(List<Integer> tabs) {
            this.tabs = new ArrayList();
            this.lastStop = 0;
            this.lastSize = 0;
            this.tabs = tabs;
            int p = 0;
            for (Integer num : tabs) {
                int s = num.intValue();
                if (s > p) {
                    this.lastStop = s;
                    this.lastSize = s - p;
                    p = s;
                }
            }
        }

        boolean defined() {
            return this.lastSize > 0;
        }

        int spaces(int lastLineLength) {
            int out = 0;
            if (lastLineLength < this.lastStop) {
                Iterator<Integer> it = this.tabs.iterator();
                while (true) {
                    if (it.hasNext()) {
                        int s = it.next().intValue();
                        if (s > lastLineLength) {
                            out = s - lastLineLength;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                out = this.lastSize - ((lastLineLength - this.lastStop) % this.lastSize);
            }
            return out;
        }
    }
}
