package org.jline.utils;

import java.util.ArrayList;
import java.util.List;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/AttributedCharSequence.class */
public abstract class AttributedCharSequence implements CharSequence {
    public static final int TRUE_COLORS = 16777216;
    private static final int HIGH_COLORS = 32767;
    static final boolean DISABLE_ALTERNATE_CHARSET = Boolean.getBoolean("org.jline.utils.disableAlternateCharset");

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/utils/AttributedCharSequence$ForceMode.class */
    public enum ForceMode {
        None,
        Force256Colors,
        ForceTrueColors
    }

    public abstract AttributedStyle styleAt(int i);

    @Override // java.lang.CharSequence
    public abstract AttributedString subSequence(int i, int i2);

    protected abstract char[] buffer();

    protected abstract int offset();

    public void print(Terminal terminal) {
        terminal.writer().print(toAnsi(terminal));
    }

    public void println(Terminal terminal) {
        terminal.writer().println(toAnsi(terminal));
    }

    public String toAnsi() {
        return toAnsi(null);
    }

    public String toAnsi(Terminal terminal) {
        if (terminal != null && "dumb".equals(terminal.getType())) {
            return toString();
        }
        int colors = 256;
        ForceMode forceMode = ForceMode.None;
        ColorPalette palette = null;
        String alternateIn = null;
        String alternateOut = null;
        if (terminal != null) {
            Integer max_colors = terminal.getNumericCapability(InfoCmp.Capability.max_colors);
            if (max_colors != null) {
                colors = max_colors.intValue();
            }
            if ("windows-256color".equals(terminal.getType()) || "windows-conemu".equals(terminal.getType())) {
                forceMode = ForceMode.Force256Colors;
            }
            palette = terminal.getPalette();
            if (!DISABLE_ALTERNATE_CHARSET) {
                alternateIn = Curses.tputs(terminal.getStringCapability(InfoCmp.Capability.enter_alt_charset_mode), new Object[0]);
                alternateOut = Curses.tputs(terminal.getStringCapability(InfoCmp.Capability.exit_alt_charset_mode), new Object[0]);
            }
        }
        return toAnsi(colors, forceMode, palette, alternateIn, alternateOut);
    }

    @Deprecated
    public String toAnsi(int colors, boolean force256colors) {
        return toAnsi(colors, force256colors, null, null);
    }

    @Deprecated
    public String toAnsi(int colors, boolean force256colors, String altIn, String altOut) {
        return toAnsi(colors, force256colors ? ForceMode.Force256Colors : ForceMode.None, null, altIn, altOut);
    }

    public String toAnsi(int colors, ForceMode force) {
        return toAnsi(colors, force, null, null, null);
    }

    public String toAnsi(int colors, ForceMode force, ColorPalette palette) {
        return toAnsi(colors, force, palette, null, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:187:0x063c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r0v175, types: [long] */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r0v179, types: [long] */
    /* JADX WARN: Type inference failed for: r25v4 */
    /* JADX WARN: Type inference failed for: r25v6 */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8 */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toAnsi(int r8, org.jline.utils.AttributedCharSequence.ForceMode r9, org.jline.utils.ColorPalette r10, java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 1644
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.AttributedCharSequence.toAnsi(int, org.jline.utils.AttributedCharSequence$ForceMode, org.jline.utils.ColorPalette, java.lang.String, java.lang.String):java.lang.String");
    }

    @Deprecated
    public static int rgbColor(int col) {
        return Colors.rgbColor(col);
    }

    @Deprecated
    public static int roundColor(int col, int max) {
        return Colors.roundColor(col, max);
    }

    @Deprecated
    public static int roundRgbColor(int r, int g, int b, int max) {
        return Colors.roundRgbColor(r, g, b, max);
    }

    private static boolean attr(StringBuilder sb, String s, boolean first) {
        if (!first) {
            sb.append(";");
        }
        sb.append(s);
        return false;
    }

    /* access modifiers changed from: package-private */
    public long styleCodeAt(int index) {
        return styleAt(index).getStyle();
    }

    public boolean isHidden(int index) {
        return (styleCodeAt(index) & 4096) != 0;
    }

    public int runStart(int index) {
        AttributedStyle style = styleAt(index);
        while (index > 0 && styleAt(index - 1).equals(style)) {
            index--;
        }
        return index;
    }

    public int runLimit(int index) {
        AttributedStyle style = styleAt(index);
        while (index < length() - 1 && styleAt(index + 1).equals(style)) {
            index++;
        }
        return index + 1;
    }

    public AttributedString substring(int start, int end) {
        return subSequence(start, end);
    }

    @Override // java.lang.CharSequence
    public char charAt(int index) {
        return buffer()[offset() + index];
    }

    public int codePointAt(int index) {
        return Character.codePointAt(buffer(), index + offset());
    }

    public boolean contains(char c) {
        for (int i = 0; i < length(); i++) {
            if (charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public int codePointBefore(int index) {
        return Character.codePointBefore(buffer(), index + offset());
    }

    public int codePointCount(int index, int length) {
        return Character.codePointCount(buffer(), index + offset(), length);
    }

    public int columnLength() {
        int cols = 0;
        int len = length();
        int cur = 0;
        while (cur < len) {
            int cp = codePointAt(cur);
            if (!isHidden(cur)) {
                cols += WCWidth.wcwidth(cp);
            }
            cur += Character.charCount(cp);
        }
        return cols;
    }

    public AttributedString columnSubSequence(int start, int stop) {
        int cp;
        int begin = 0;
        int col = 0;
        while (begin < length()) {
            int cp2 = codePointAt(begin);
            int w = isHidden(begin) ? 0 : WCWidth.wcwidth(cp2);
            if (col + w > start) {
                break;
            }
            begin += Character.charCount(cp2);
            col += w;
        }
        int end = begin;
        while (end < length() && (cp = codePointAt(end)) != 10) {
            int w2 = isHidden(end) ? 0 : WCWidth.wcwidth(cp);
            if (col + w2 > stop) {
                break;
            }
            end += Character.charCount(cp);
            col += w2;
        }
        return subSequence(begin, end);
    }

    public List<AttributedString> columnSplitLength(int columns) {
        return columnSplitLength(columns, false, true);
    }

    public List<AttributedString> columnSplitLength(int columns, boolean includeNewlines, boolean delayLineWrap) {
        List<AttributedString> strings = new ArrayList<>();
        int cur = 0;
        int beg = 0;
        int col = 0;
        while (cur < length()) {
            int cp = codePointAt(cur);
            int w = isHidden(cur) ? 0 : WCWidth.wcwidth(cp);
            if (cp == 10) {
                strings.add(subSequence(beg, includeNewlines ? cur + 1 : cur));
                beg = cur + 1;
                col = 0;
            } else {
                int i = col + w;
                col = i;
                if (i > columns) {
                    strings.add(subSequence(beg, cur));
                    beg = cur;
                    col = w;
                }
            }
            cur += Character.charCount(cp);
        }
        strings.add(subSequence(beg, cur));
        return strings;
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public String toString() {
        return new String(buffer(), offset(), length());
    }

    public AttributedString toAttributedString() {
        return substring(0, length());
    }
}
