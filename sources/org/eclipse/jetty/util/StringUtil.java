package org.eclipse.jetty.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/StringUtil.class */
public class StringUtil {
    public static final String ALL_INTERFACES = "0.0.0.0";
    public static final String CRLF = "\r\n";
    public static final String __ISO_8859_1 = "iso-8859-1";
    public static final String __UTF8 = "utf-8";
    public static final String __UTF16 = "utf-16";
    private static final Trie<String> CHARSETS = new ArrayTrie(256);
    @Deprecated
    public static final String __LINE_SEPARATOR = System.lineSeparator();
    public static final char[] lowercases = {0, 1, 2, 3, 4, 5, 6, 7, '\b', '\t', '\n', 11, '\f', '\r', 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, ' ', '!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', 127};

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/StringUtil$CsvSplitState.class */
    public enum CsvSplitState {
        PRE_DATA,
        QUOTE,
        SLOSH,
        DATA,
        WHITE,
        POST_DATA
    }

    static {
        CHARSETS.put(__UTF8, __UTF8);
        CHARSETS.put("utf8", __UTF8);
        CHARSETS.put(__UTF16, __UTF16);
        CHARSETS.put("utf16", __UTF16);
        CHARSETS.put(__ISO_8859_1, __ISO_8859_1);
        CHARSETS.put("iso_8859_1", __ISO_8859_1);
    }

    public static String normalizeCharset(String s) {
        String n = CHARSETS.get(s);
        return n == null ? s : n;
    }

    public static String normalizeCharset(String s, int offset, int length) {
        String n = CHARSETS.get(s, offset, length);
        return n == null ? s.substring(offset, offset + length) : n;
    }

    public static String asciiToLowerCase(String s) {
        char c2;
        if (s == null) {
            return null;
        }
        char[] c = null;
        int i = s.length();
        while (true) {
            i--;
            if (i > 0) {
                char c1 = s.charAt(i);
                if (c1 <= 127 && c1 != (c2 = lowercases[c1])) {
                    c = s.toCharArray();
                    c[i] = c2;
                    break;
                }
            } else {
                break;
            }
        }
        while (true) {
            i--;
            if (i <= 0) {
                break;
            } else if (c[i] <= 127) {
                c[i] = lowercases[c[i]];
            }
        }
        return c == null ? s : new String(c);
    }

    public static String sanitizeFileSystemName(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c <= 31 || c >= 127 || c == '|' || c == '>' || c == '<' || c == '/' || c == '&' || c == '\\' || c == '.' || c == ':' || c == '=' || c == '\"' || c == ',' || c == '*' || c == '?' || c == '!' || c == ' ') {
                chars[i] = '_';
            }
        }
        return String.valueOf(chars);
    }

    public static boolean startsWithIgnoreCase(String s, String w) {
        if (w == null) {
            return true;
        }
        if (s == null || s.length() < w.length()) {
            return false;
        }
        for (int i = 0; i < w.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = w.charAt(i);
            if (c1 != c2) {
                if (c1 <= 127) {
                    c1 = lowercases[c1];
                }
                if (c2 <= 127) {
                    c2 = lowercases[c2];
                }
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean endsWithIgnoreCase(String s, String w) {
        if (w == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        int sl = s.length();
        int wl = w.length();
        if (sl < wl) {
            return false;
        }
        int i = wl;
        while (true) {
            i--;
            if (i <= 0) {
                return true;
            }
            sl--;
            char c1 = s.charAt(sl);
            char c2 = w.charAt(i);
            if (c1 != c2) {
                if (c1 <= 127) {
                    c1 = lowercases[c1];
                }
                if (c2 <= 127) {
                    c2 = lowercases[c2];
                }
                if (c1 != c2) {
                    return false;
                }
            }
        }
    }

    public static int indexFrom(String s, String chars) {
        for (int i = 0; i < s.length(); i++) {
            if (chars.indexOf(s.charAt(i)) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static String replace(String str, char find, char with) {
        if (str == null) {
            return null;
        }
        if (find == with) {
            return str;
        }
        int idx = str.indexOf(find, 0);
        if (idx == -1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = idx; i < len; i++) {
            if (chars[i] == find) {
                chars[i] = with;
            }
        }
        return String.valueOf(chars);
    }

    public static String replace(String s, String sub, String with) {
        int indexOf;
        if (s == null) {
            return null;
        }
        int c = 0;
        int i = s.indexOf(sub, 0);
        if (i == -1) {
            return s;
        }
        StringBuilder buf = new StringBuilder(s.length() + with.length());
        do {
            buf.append((CharSequence) s, c, i);
            buf.append(with);
            c = i + sub.length();
            indexOf = s.indexOf(sub, c);
            i = indexOf;
        } while (indexOf != -1);
        if (c < s.length()) {
            buf.append(s.substring(c));
        }
        return buf.toString();
    }

    public static String replaceFirst(String original, String target, String replacement) {
        int idx = original.indexOf(target);
        if (idx == -1) {
            return original;
        }
        int originalLen = original.length();
        StringBuilder buf = new StringBuilder(originalLen + replacement.length());
        buf.append((CharSequence) original, 0, idx);
        buf.append(replacement);
        buf.append((CharSequence) original, 0 + idx + target.length(), originalLen);
        return buf.toString();
    }

    @Deprecated
    public static String unquote(String s) {
        return QuotedStringTokenizer.unquote(s);
    }

    public static void append(StringBuilder buf, String s, int offset, int length) {
        synchronized (buf) {
            int end = offset + length;
            int i = offset;
            while (i < end && i < s.length()) {
                buf.append(s.charAt(i));
                i++;
            }
        }
    }

    public static void append(StringBuilder buf, byte b, int base) {
        int bi = 255 & b;
        int c = 48 + ((bi / base) % base);
        if (c > 57) {
            c = 97 + ((c - 48) - 10);
        }
        buf.append((char) c);
        int c2 = 48 + (bi % base);
        if (c2 > 57) {
            c2 = 97 + ((c2 - 48) - 10);
        }
        buf.append((char) c2);
    }

    public static void append2digits(StringBuffer buf, int i) {
        if (i < 100) {
            buf.append((char) ((i / 10) + 48));
            buf.append((char) ((i % 10) + 48));
        }
    }

    public static void append2digits(StringBuilder buf, int i) {
        if (i < 100) {
            buf.append((char) ((i / 10) + 48));
            buf.append((char) ((i % 10) + 48));
        }
    }

    public static String nonNull(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }

    public static boolean equals(String s, char[] buf, int offset, int length) {
        if (s.length() != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (buf[offset + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String toUTF8String(byte[] b, int offset, int length) {
        return new String(b, offset, length, StandardCharsets.UTF_8);
    }

    public static String toString(byte[] b, int offset, int length, String charset) {
        try {
            return new String(b, offset, length, charset);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int indexOfControlChars(String str) {
        if (str == null) {
            return -1;
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (Character.isISOControl(str.codePointAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isWhitespace(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotBlank(String str) {
        if (str == null) {
            return false;
        }
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isWhitespace(str.codePointAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUTF8(String charset) {
        return __UTF8.equalsIgnoreCase(charset) || __UTF8.equalsIgnoreCase(normalizeCharset(charset));
    }

    public static boolean isHex(String str, int offset, int length) {
        if (offset + length > str.length()) {
            return false;
        }
        for (int i = offset; i < offset + length; i++) {
            char c = str.charAt(i);
            if ((c < 'a' || c > 'f') && ((c < 'A' || c > 'F') && (c < '0' || c > '9'))) {
                return false;
            }
        }
        return true;
    }

    public static String printable(String name) {
        if (name == null) {
            return null;
        }
        StringBuilder buf = new StringBuilder(name.length());
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isISOControl(c)) {
                buf.append(c);
            }
        }
        return buf.toString();
    }

    public static String printable(byte[] b) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            char c = (char) b[i];
            if (Character.isWhitespace(c) || (c > ' ' && c < 127)) {
                buf.append(c);
            } else {
                buf.append("0x");
                TypeUtil.toHex(b[i], (Appendable) buf);
            }
        }
        return buf.toString();
    }

    public static byte[] getBytes(String s) {
        return s.getBytes(StandardCharsets.ISO_8859_1);
    }

    public static byte[] getUtf8Bytes(String s) {
        return s.getBytes(StandardCharsets.UTF_8);
    }

    public static byte[] getBytes(String s, String charset) {
        try {
            return s.getBytes(charset);
        } catch (Exception e) {
            return s.getBytes();
        }
    }

    @Deprecated
    public static String sidBytesToString(byte[] sidBytes) {
        StringBuilder sidString = new StringBuilder();
        sidString.append("S-");
        sidString.append((int) sidBytes[0]).append('-');
        StringBuilder tmpBuilder = new StringBuilder();
        for (int i = 2; i <= 7; i++) {
            tmpBuilder.append(Integer.toHexString(sidBytes[i] & 255));
        }
        sidString.append(Long.parseLong(tmpBuilder.toString(), 16));
        byte b = sidBytes[1];
        for (int i2 = 0; i2 < b; i2++) {
            int offset = i2 * 4;
            tmpBuilder.setLength(0);
            tmpBuilder.append(String.format("%02X%02X%02X%02X", Integer.valueOf(sidBytes[11 + offset] & 255), Integer.valueOf(sidBytes[10 + offset] & 255), Integer.valueOf(sidBytes[9 + offset] & 255), Integer.valueOf(sidBytes[8 + offset] & 255)));
            sidString.append('-').append(Long.parseLong(tmpBuilder.toString(), 16));
        }
        return sidString.toString();
    }

    @Deprecated
    public static byte[] sidStringToBytes(String sidString) {
        String[] sidTokens = sidString.split("-");
        int subAuthorityCount = sidTokens.length - 3;
        byte[] sidBytes = new byte[8 + (4 * subAuthorityCount)];
        int byteCount = 0 + 1;
        sidBytes[0] = (byte) Integer.parseInt(sidTokens[1]);
        int byteCount2 = byteCount + 1;
        sidBytes[byteCount] = (byte) subAuthorityCount;
        String hexStr = Long.toHexString(Long.parseLong(sidTokens[2]));
        while (hexStr.length() < 12) {
            hexStr = "0" + hexStr;
        }
        for (int i = 0; i < hexStr.length(); i += 2) {
            byteCount2++;
            sidBytes[byteCount2] = (byte) Integer.parseInt(hexStr.substring(i, i + 2), 16);
        }
        for (int i2 = 3; i2 < sidTokens.length; i2++) {
            String hexStr2 = Long.toHexString(Long.parseLong(sidTokens[i2]));
            while (hexStr2.length() < 8) {
                hexStr2 = "0" + hexStr2;
            }
            for (int j = hexStr2.length(); j > 0; j -= 2) {
                byteCount2++;
                sidBytes[byteCount2] = (byte) Integer.parseInt(hexStr2.substring(j - 2, j), 16);
            }
        }
        return sidBytes;
    }

    public static int toInt(String string, int from) {
        int val = 0;
        boolean started = false;
        boolean minus = false;
        for (int i = from; i < string.length(); i++) {
            char b = string.charAt(i);
            if (b > ' ') {
                if (b < '0' || b > '9') {
                    if (b != '-' || started) {
                        break;
                    }
                    minus = true;
                } else {
                    val = (val * 10) + (b - '0');
                    started = true;
                }
            } else if (started) {
                break;
            }
        }
        if (started) {
            return minus ? -val : val;
        }
        throw new NumberFormatException(string);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0057 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public static long toLong(String string) {
        long val = 0;
        boolean started = false;
        boolean minus = false;
        int i = 0;
        while (i < string.length()) {
            char b = string.charAt(i);
            if (b > ' ') {
                if (b < '0' || b > '9') {
                    if (b != '-' || started) {
                        break;
                    }
                    minus = true;
                } else {
                    val = ((val == true ? 1 : 0) * 10) + ((long) (b - '0'));
                    started = true;
                }
                i++;
                val = val;
                started = started;
                minus = minus;
            } else if (started) {
                break;
            } else {
                i++;
                val = val;
                started = started;
                minus = minus;
            }
        }
        if (started) {
            return minus ? -val : val;
        }
        throw new NumberFormatException(string);
    }

    public static String truncate(String str, int maxSize) {
        if (str == null) {
            return null;
        }
        if (str.length() <= maxSize) {
            return str;
        }
        return str.substring(0, maxSize);
    }

    public static String[] arrayFromString(String s) {
        if (s == null) {
            return new String[0];
        }
        if (!s.startsWith("[") || !s.endsWith("]")) {
            throw new IllegalArgumentException();
        } else if (s.length() == 2) {
            return new String[0];
        } else {
            return csvSplit(s, 1, s.length() - 2);
        }
    }

    public static String[] csvSplit(String s) {
        if (s == null) {
            return null;
        }
        return csvSplit(s, 0, s.length());
    }

    public static String[] csvSplit(String s, int off, int len) {
        if (s == null) {
            return null;
        }
        if (off < 0 || len < 0 || off > s.length()) {
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<>();
        csvSplit(list, s, off, len);
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static List<String> csvSplit(List<String> list, String s, int off, int len) {
        if (list == null) {
            list = new ArrayList();
        }
        CsvSplitState state = CsvSplitState.PRE_DATA;
        StringBuilder out = new StringBuilder();
        int last = -1;
        while (len > 0) {
            off++;
            char ch = s.charAt(off);
            len--;
            switch (state) {
                case PRE_DATA:
                    if (!Character.isWhitespace(ch)) {
                        if ('\"' != ch) {
                            if (',' != ch) {
                                state = CsvSplitState.DATA;
                                out.append(ch);
                                break;
                            } else {
                                list.add("");
                                break;
                            }
                        } else {
                            state = CsvSplitState.QUOTE;
                            break;
                        }
                    } else {
                        break;
                    }
                case DATA:
                    if (!Character.isWhitespace(ch)) {
                        if (',' != ch) {
                            out.append(ch);
                            break;
                        } else {
                            list.add(out.toString());
                            out.setLength(0);
                            state = CsvSplitState.PRE_DATA;
                            break;
                        }
                    } else {
                        last = out.length();
                        out.append(ch);
                        state = CsvSplitState.WHITE;
                        break;
                    }
                case WHITE:
                    if (!Character.isWhitespace(ch)) {
                        if (',' != ch) {
                            state = CsvSplitState.DATA;
                            out.append(ch);
                            last = -1;
                            break;
                        } else {
                            out.setLength(last);
                            list.add(out.toString());
                            out.setLength(0);
                            state = CsvSplitState.PRE_DATA;
                            break;
                        }
                    } else {
                        out.append(ch);
                        break;
                    }
                case QUOTE:
                    if ('\\' != ch) {
                        if ('\"' != ch) {
                            out.append(ch);
                            break;
                        } else {
                            list.add(out.toString());
                            out.setLength(0);
                            state = CsvSplitState.POST_DATA;
                            break;
                        }
                    } else {
                        state = CsvSplitState.SLOSH;
                        break;
                    }
                case SLOSH:
                    out.append(ch);
                    state = CsvSplitState.QUOTE;
                    break;
                case POST_DATA:
                    if (',' != ch) {
                        break;
                    } else {
                        state = CsvSplitState.PRE_DATA;
                        break;
                    }
            }
        }
        switch (state) {
            case DATA:
            case QUOTE:
            case SLOSH:
                list.add(out.toString());
                break;
            case WHITE:
                out.setLength(last);
                list.add(out.toString());
                break;
        }
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String sanitizeXmlString(java.lang.String r5) {
        /*
            r0 = r5
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            r0 = 0
            r6 = r0
        L_0x0008:
            r0 = r6
            r1 = r5
            int r1 = r1.length()
            if (r0 >= r1) goto L_0x0062
            r0 = r5
            r1 = r6
            char r0 = r0.charAt(r1)
            r7 = r0
            r0 = r7
            switch(r0) {
                case 34: goto L_0x0048;
                case 38: goto L_0x0048;
                case 39: goto L_0x0048;
                case 60: goto L_0x0048;
                case 62: goto L_0x0048;
                default: goto L_0x004b;
            }
        L_0x0048:
            goto L_0x0062
        L_0x004b:
            r0 = r7
            boolean r0 = java.lang.Character.isISOControl(r0)
            if (r0 == 0) goto L_0x005c
            r0 = r7
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x0062
        L_0x005c:
            int r6 = r6 + 1
            goto L_0x0008
        L_0x0062:
            r0 = r6
            r1 = r5
            int r1 = r1.length()
            if (r0 != r1) goto L_0x006c
            r0 = r5
            return r0
        L_0x006c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r2 = r5
            int r2 = r2.length()
            r3 = 4
            int r2 = r2 * r3
            r3 = 3
            int r2 = r2 / r3
            r1.<init>(r2)
            r7 = r0
            r0 = r7
            r1 = r5
            r2 = 0
            r3 = r6
            java.lang.StringBuilder r0 = r0.append(r1, r2, r3)
        L_0x0084:
            r0 = r6
            r1 = r5
            int r1 = r1.length()
            if (r0 >= r1) goto L_0x011a
            r0 = r5
            r1 = r6
            char r0 = r0.charAt(r1)
            r8 = r0
            r0 = r8
            switch(r0) {
                case 34: goto L_0x00ec;
                case 38: goto L_0x00c4;
                case 39: goto L_0x00e2;
                case 60: goto L_0x00ce;
                case 62: goto L_0x00d8;
                default: goto L_0x00f6;
            }
        L_0x00c4:
            r0 = r7
            java.lang.String r1 = "&amp;"
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L_0x0114
        L_0x00ce:
            r0 = r7
            java.lang.String r1 = "&lt;"
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L_0x0114
        L_0x00d8:
            r0 = r7
            java.lang.String r1 = "&gt;"
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L_0x0114
        L_0x00e2:
            r0 = r7
            java.lang.String r1 = "&apos;"
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L_0x0114
        L_0x00ec:
            r0 = r7
            java.lang.String r1 = "&quot;"
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L_0x0114
        L_0x00f6:
            r0 = r8
            boolean r0 = java.lang.Character.isISOControl(r0)
            if (r0 == 0) goto L_0x010e
            r0 = r8
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 != 0) goto L_0x010e
            r0 = r7
            r1 = 63
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L_0x0114
        L_0x010e:
            r0 = r7
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)
        L_0x0114:
            int r6 = r6 + 1
            goto L_0x0084
        L_0x011a:
            r0 = r7
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.StringUtil.sanitizeXmlString(java.lang.String):java.lang.String");
    }

    public static String strip(String str, String find) {
        return replace(str, find, "");
    }

    public static String valueOf(Object object) {
        if (object == null) {
            return null;
        }
        return String.valueOf(object);
    }
}
