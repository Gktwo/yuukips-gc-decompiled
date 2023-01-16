package org.jline.utils;

import org.jline.utils.AttributedCharSequence;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/AttributedStyle.class */
public class AttributedStyle {
    public static final int BLACK = 0;
    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int YELLOW = 3;
    public static final int BLUE = 4;
    public static final int MAGENTA = 5;
    public static final int CYAN = 6;
    public static final int WHITE = 7;
    public static final int BRIGHT = 8;
    static final long F_BOLD = 1;
    static final long F_FAINT = 2;
    static final long F_ITALIC = 4;
    static final long F_UNDERLINE = 8;
    static final long F_BLINK = 16;
    static final long F_INVERSE = 32;
    static final long F_CONCEAL = 64;
    static final long F_CROSSED_OUT = 128;
    static final long F_FOREGROUND_IND = 256;
    static final long F_FOREGROUND_RGB = 512;
    static final long F_FOREGROUND = 768;
    static final long F_BACKGROUND_IND = 1024;
    static final long F_BACKGROUND_RGB = 2048;
    static final long F_BACKGROUND = 3072;
    static final long F_HIDDEN = 4096;
    static final long MASK = 8191;
    static final int FG_COLOR_EXP = 15;
    static final int BG_COLOR_EXP = 39;
    static final long FG_COLOR = 549755781120L;
    static final long BG_COLOR = 9223371487098961920L;
    public static final AttributedStyle DEFAULT = new AttributedStyle();
    public static final AttributedStyle BOLD = DEFAULT.bold();
    public static final AttributedStyle BOLD_OFF = DEFAULT.boldOff();
    public static final AttributedStyle INVERSE = DEFAULT.inverse();
    public static final AttributedStyle INVERSE_OFF = DEFAULT.inverseOff();
    public static final AttributedStyle HIDDEN = DEFAULT.hidden();
    public static final AttributedStyle HIDDEN_OFF = DEFAULT.hiddenOff();
    final long style;
    final long mask;

    public AttributedStyle() {
        this(0, 0);
    }

    public AttributedStyle(AttributedStyle s) {
        this(s.style, s.mask);
    }

    public AttributedStyle(long style, long mask) {
        this.style = style;
        this.mask = (mask & 8191) | ((style & 768) != 0 ? 549755781120L : 0) | ((style & 3072) != 0 ? 9223371487098961920L : 0);
    }

    public AttributedStyle bold() {
        return new AttributedStyle(this.style | 1, this.mask | 1);
    }

    public AttributedStyle boldOff() {
        return new AttributedStyle(this.style & -2, this.mask | 1);
    }

    public AttributedStyle boldDefault() {
        return new AttributedStyle(this.style & -2, this.mask & -2);
    }

    public AttributedStyle faint() {
        return new AttributedStyle(this.style | 2, this.mask | 2);
    }

    public AttributedStyle faintOff() {
        return new AttributedStyle(this.style & -3, this.mask | 2);
    }

    public AttributedStyle faintDefault() {
        return new AttributedStyle(this.style & -3, this.mask & -3);
    }

    public AttributedStyle italic() {
        return new AttributedStyle(this.style | 4, this.mask | 4);
    }

    public AttributedStyle italicOff() {
        return new AttributedStyle(this.style & -5, this.mask | 4);
    }

    public AttributedStyle italicDefault() {
        return new AttributedStyle(this.style & -5, this.mask & -5);
    }

    public AttributedStyle underline() {
        return new AttributedStyle(this.style | 8, this.mask | 8);
    }

    public AttributedStyle underlineOff() {
        return new AttributedStyle(this.style & -9, this.mask | 8);
    }

    public AttributedStyle underlineDefault() {
        return new AttributedStyle(this.style & -9, this.mask & -9);
    }

    public AttributedStyle blink() {
        return new AttributedStyle(this.style | 16, this.mask | 16);
    }

    public AttributedStyle blinkOff() {
        return new AttributedStyle(this.style & -17, this.mask | 16);
    }

    public AttributedStyle blinkDefault() {
        return new AttributedStyle(this.style & -17, this.mask & -17);
    }

    public AttributedStyle inverse() {
        return new AttributedStyle(this.style | 32, this.mask | 32);
    }

    public AttributedStyle inverseNeg() {
        return new AttributedStyle((this.style & 32) != 0 ? this.style & -33 : this.style | 32, this.mask | 32);
    }

    public AttributedStyle inverseOff() {
        return new AttributedStyle(this.style & -33, this.mask | 32);
    }

    public AttributedStyle inverseDefault() {
        return new AttributedStyle(this.style & -33, this.mask & -33);
    }

    public AttributedStyle conceal() {
        return new AttributedStyle(this.style | 64, this.mask | 64);
    }

    public AttributedStyle concealOff() {
        return new AttributedStyle(this.style & -65, this.mask | 64);
    }

    public AttributedStyle concealDefault() {
        return new AttributedStyle(this.style & -65, this.mask & -65);
    }

    public AttributedStyle crossedOut() {
        return new AttributedStyle(this.style | 128, this.mask | 128);
    }

    public AttributedStyle crossedOutOff() {
        return new AttributedStyle(this.style & -129, this.mask | 128);
    }

    public AttributedStyle crossedOutDefault() {
        return new AttributedStyle(this.style & -129, this.mask & -129);
    }

    public AttributedStyle foreground(int color) {
        return new AttributedStyle((this.style & -549755781121L) | 256 | ((((long) color) << 15) & 549755781120L), this.mask | 256);
    }

    public AttributedStyle foreground(int r, int g, int b) {
        return foregroundRgb((r << 16) | (g << 8) | b);
    }

    public AttributedStyle foregroundRgb(int color) {
        return new AttributedStyle((this.style & -549755781121L) | 512 | (((((long) color) & 16777215) << 15) & 549755781120L), this.mask | 512);
    }

    public AttributedStyle foregroundOff() {
        return new AttributedStyle(this.style & -549755781121L & -769, this.mask | 768);
    }

    public AttributedStyle foregroundDefault() {
        return new AttributedStyle(this.style & -549755781121L & -769, this.mask & -549755781889L);
    }

    public AttributedStyle background(int color) {
        return new AttributedStyle((this.style & -9223371487098961921L) | 1024 | ((((long) color) << 39) & 9223371487098961920L), this.mask | 1024);
    }

    public AttributedStyle background(int r, int g, int b) {
        return backgroundRgb((r << 16) | (g << 8) | b);
    }

    public AttributedStyle backgroundRgb(int color) {
        return new AttributedStyle((this.style & -9223371487098961921L) | 2048 | (((((long) color) & 16777215) << 39) & 9223371487098961920L), this.mask | 2048);
    }

    public AttributedStyle backgroundOff() {
        return new AttributedStyle(this.style & -9223371487098961921L & -3073, this.mask | 3072);
    }

    public AttributedStyle backgroundDefault() {
        return new AttributedStyle(this.style & -9223371487098961921L & -3073, this.mask & -9223371487098964993L);
    }

    public AttributedStyle hidden() {
        return new AttributedStyle(this.style | 4096, this.mask | 4096);
    }

    public AttributedStyle hiddenOff() {
        return new AttributedStyle(this.style & -4097, this.mask | 4096);
    }

    public AttributedStyle hiddenDefault() {
        return new AttributedStyle(this.style & -4097, this.mask & -4097);
    }

    public long getStyle() {
        return this.style;
    }

    public long getMask() {
        return this.mask;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttributedStyle that = (AttributedStyle) o;
        return this.style == that.style && this.mask == that.mask;
    }

    public int hashCode() {
        return (31 * Long.hashCode(this.style)) + Long.hashCode(this.mask);
    }

    public String toAnsi() {
        AttributedStringBuilder sb = new AttributedStringBuilder();
        sb.styled(this, " ");
        String s = sb.toAnsi(16777216, AttributedCharSequence.ForceMode.None);
        return s.length() > 1 ? s.substring(2, s.indexOf(109)) : s;
    }

    public String toString() {
        return "AttributedStyle{style=" + this.style + ", mask=" + this.mask + ", ansi=" + toAnsi() + '}';
    }
}
