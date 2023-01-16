package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/Ascii.class */
public final class Ascii {
    public static final byte NUL = 0;
    public static final byte SOH = 1;
    public static final byte STX = 2;
    public static final byte ETX = 3;
    public static final byte EOT = 4;
    public static final byte ENQ = 5;
    public static final byte ACK = 6;
    public static final byte BEL = 7;

    /* renamed from: BS */
    public static final byte f243BS = 8;

    /* renamed from: HT */
    public static final byte f244HT = 9;

    /* renamed from: LF */
    public static final byte f245LF = 10;

    /* renamed from: NL */
    public static final byte f246NL = 10;

    /* renamed from: VT */
    public static final byte f247VT = 11;

    /* renamed from: FF */
    public static final byte f248FF = 12;

    /* renamed from: CR */
    public static final byte f249CR = 13;

    /* renamed from: SO */
    public static final byte f250SO = 14;

    /* renamed from: SI */
    public static final byte f251SI = 15;
    public static final byte DLE = 16;
    public static final byte DC1 = 17;
    public static final byte XON = 17;
    public static final byte DC2 = 18;
    public static final byte DC3 = 19;
    public static final byte XOFF = 19;
    public static final byte DC4 = 20;
    public static final byte NAK = 21;
    public static final byte SYN = 22;
    public static final byte ETB = 23;
    public static final byte CAN = 24;

    /* renamed from: EM */
    public static final byte f252EM = 25;
    public static final byte SUB = 26;
    public static final byte ESC = 27;

    /* renamed from: FS */
    public static final byte f253FS = 28;

    /* renamed from: GS */
    public static final byte f254GS = 29;

    /* renamed from: RS */
    public static final byte f255RS = 30;

    /* renamed from: US */
    public static final byte f256US = 31;

    /* renamed from: SP */
    public static final byte f257SP = 32;
    public static final byte SPACE = 32;
    public static final byte DEL = Byte.MAX_VALUE;
    public static final char MIN = 0;
    public static final char MAX = 127;
    private static final char CASE_MASK = ' ';

    private Ascii() {
    }

    public static String toLowerCase(String string) {
        int length = string.length();
        int i = 0;
        while (i < length) {
            if (isUpperCase(string.charAt(i))) {
                char[] chars = string.toCharArray();
                while (i < length) {
                    char c = chars[i];
                    if (isUpperCase(c)) {
                        chars[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(chars);
            }
            i++;
        }
        return string;
    }

    public static String toLowerCase(CharSequence chars) {
        if (chars instanceof String) {
            return toLowerCase((String) chars);
        }
        char[] newChars = new char[chars.length()];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = toLowerCase(chars.charAt(i));
        }
        return String.valueOf(newChars);
    }

    public static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c ^ ' ') : c;
    }

    public static String toUpperCase(String string) {
        int length = string.length();
        int i = 0;
        while (i < length) {
            if (isLowerCase(string.charAt(i))) {
                char[] chars = string.toCharArray();
                while (i < length) {
                    char c = chars[i];
                    if (isLowerCase(c)) {
                        chars[i] = (char) (c ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(chars);
            }
            i++;
        }
        return string;
    }

    public static String toUpperCase(CharSequence chars) {
        if (chars instanceof String) {
            return toUpperCase((String) chars);
        }
        char[] newChars = new char[chars.length()];
        for (int i = 0; i < newChars.length; i++) {
            newChars[i] = toUpperCase(chars.charAt(i));
        }
        return String.valueOf(newChars);
    }

    public static char toUpperCase(char c) {
        return isLowerCase(c) ? (char) (c ^ ' ') : c;
    }

    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static String truncate(CharSequence seq, int maxLength, String truncationIndicator) {
        Preconditions.checkNotNull(seq);
        int truncationLength = maxLength - truncationIndicator.length();
        Preconditions.checkArgument(truncationLength >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", maxLength, truncationIndicator.length());
        if (seq.length() <= maxLength) {
            String string = seq.toString();
            if (string.length() <= maxLength) {
                return string;
            }
            seq = string;
        }
        return new StringBuilder(maxLength).append(seq, 0, truncationLength).append(truncationIndicator).toString();
    }

    public static boolean equalsIgnoreCase(CharSequence s1, CharSequence s2) {
        int alphaIndex;
        int length = s1.length();
        if (s1 == s2) {
            return true;
        }
        if (length != s2.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2 && ((alphaIndex = getAlphaIndex(c1)) >= 26 || alphaIndex != getAlphaIndex(c2))) {
                return false;
            }
        }
        return true;
    }

    private static int getAlphaIndex(char c) {
        return (char) ((c | ' ') - 97);
    }
}
