package org.eclipse.jetty.websocket.api.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/util/QuoteUtil.class */
public class QuoteUtil {
    public static final String ABNF_REQUIRED_QUOTING = "\"'\\\n\r\t\f\b%+ ;=";
    private static final char UNICODE_TAG = 65535;
    private static final char[] escapes = new char[32];

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/util/QuoteUtil$DeQuotingStringIterator.class */
    public static class DeQuotingStringIterator implements Iterator<String> {
        private final String input;
        private final String delims;
        private StringBuilder token;
        private boolean hasToken = false;

        /* renamed from: i */
        private int f3178i = 0;

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/util/QuoteUtil$DeQuotingStringIterator$State.class */
        public enum State {
            START,
            TOKEN,
            QUOTE_SINGLE,
            QUOTE_DOUBLE
        }

        public DeQuotingStringIterator(String input, String delims) {
            this.input = input;
            this.delims = delims;
            int len = input.length();
            this.token = new StringBuilder(len > 1024 ? 512 : len / 2);
        }

        private void appendToken(char c) {
            if (this.hasToken) {
                this.token.append(c);
            } else if (!Character.isWhitespace(c)) {
                this.token.append(c);
                this.hasToken = true;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.hasToken) {
                return true;
            }
            State state = State.START;
            boolean escape = false;
            int inputLen = this.input.length();
            while (this.f3178i < inputLen) {
                String str = this.input;
                int i = this.f3178i;
                this.f3178i = i + 1;
                char c = str.charAt(i);
                switch (state) {
                    case START:
                        if (c != '\'') {
                            if (c != '\"') {
                                appendToken(c);
                                state = State.TOKEN;
                                break;
                            } else {
                                state = State.QUOTE_DOUBLE;
                                appendToken(c);
                                break;
                            }
                        } else {
                            state = State.QUOTE_SINGLE;
                            appendToken(c);
                            break;
                        }
                    case TOKEN:
                        if (this.delims.indexOf(c) < 0) {
                            if (c == '\'') {
                                state = State.QUOTE_SINGLE;
                            } else if (c == '\"') {
                                state = State.QUOTE_DOUBLE;
                            }
                            appendToken(c);
                            break;
                        } else {
                            return this.hasToken;
                        }
                    case QUOTE_SINGLE:
                        if (!escape) {
                            if (c != '\'') {
                                if (c != '\\') {
                                    appendToken(c);
                                    break;
                                } else {
                                    escape = true;
                                    break;
                                }
                            } else {
                                appendToken(c);
                                state = State.TOKEN;
                                break;
                            }
                        } else {
                            escape = false;
                            appendToken(c);
                            break;
                        }
                    case QUOTE_DOUBLE:
                        if (!escape) {
                            if (c != '\"') {
                                if (c != '\\') {
                                    appendToken(c);
                                    break;
                                } else {
                                    escape = true;
                                    break;
                                }
                            } else {
                                appendToken(c);
                                state = State.TOKEN;
                                break;
                            }
                        } else {
                            escape = false;
                            appendToken(c);
                            break;
                        }
                }
            }
            return this.hasToken;
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String ret = this.token.toString();
            this.token.setLength(0);
            this.hasToken = false;
            return QuoteUtil.dequote(ret.trim());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported with this iterator");
        }
    }

    static {
        Arrays.fill(escapes, (char) 65535);
        escapes[8] = 'b';
        escapes[9] = 't';
        escapes[10] = 'n';
        escapes[12] = 'f';
        escapes[13] = 'r';
    }

    private static int dehex(byte b) {
        if (b >= 48 && b <= 57) {
            return (byte) (b - 48);
        }
        if (b >= 97 && b <= 102) {
            return (byte) ((b - 97) + 10);
        }
        if (b >= 65 && b <= 70) {
            return (byte) ((b - 65) + 10);
        }
        throw new IllegalArgumentException("!hex:" + Integer.toHexString(255 & b));
    }

    public static String dequote(String str) {
        char start = str.charAt(0);
        if ((start == '\'' || start == '\"') && start == str.charAt(str.length() - 1)) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    public static void escape(StringBuilder buf, String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c >= ' ') {
                if (c == '\"' || c == '\\') {
                    buf.append('\\');
                }
                buf.append(c);
            } else {
                char escaped = escapes[c];
                if (escaped == 65535) {
                    buf.append("\\u00");
                    if (c < 16) {
                        buf.append('0');
                    }
                    buf.append(Integer.toString(c, 16));
                } else {
                    buf.append('\\').append(escaped);
                }
            }
        }
    }

    public static void quote(StringBuilder buf, String str) {
        buf.append('\"');
        escape(buf, str);
        buf.append('\"');
    }

    public static void quoteIfNeeded(StringBuilder buf, String str, String delim) {
        int len;
        if (!(str == null || (len = str.length()) == 0)) {
            for (int i = 0; i < len; i++) {
                if (delim.indexOf(str.codePointAt(i)) >= 0) {
                    quote(buf, str);
                    return;
                }
            }
            buf.append(str);
        }
    }

    public static Iterator<String> splitAt(String str, String delims) {
        return new DeQuotingStringIterator(str.trim(), delims);
    }

    public static String unescape(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len <= 1) {
            return str;
        }
        StringBuilder ret = new StringBuilder(len - 2);
        boolean escaped = false;
        int i = 0;
        while (i < len) {
            char c = str.charAt(i);
            if (escaped) {
                escaped = false;
                switch (c) {
                    case '\"':
                        ret.append('\"');
                        continue;
                    case '/':
                        ret.append('/');
                        continue;
                    case '\\':
                        ret.append('\\');
                        continue;
                    case 'b':
                        ret.append('\b');
                        continue;
                    case 'f':
                        ret.append('\f');
                        continue;
                    case 'n':
                        ret.append('\n');
                        continue;
                    case 'r':
                        ret.append('\r');
                        continue;
                    case 't':
                        ret.append('\t');
                        continue;
                    case 'u':
                        int i2 = i + 1;
                        int i3 = i2 + 1;
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        ret.append((char) ((dehex((byte) str.charAt(i)) << 24) + (dehex((byte) str.charAt(i2)) << 16) + (dehex((byte) str.charAt(i3)) << 8) + dehex((byte) str.charAt(i4))));
                        continue;
                    default:
                        ret.append(c);
                        continue;
                }
            } else if (c == '\\') {
                escaped = true;
            } else {
                ret.append(c);
            }
            i++;
        }
        return ret.toString();
    }

    public static String join(Object[] objs, String delim) {
        if (objs == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        int len = objs.length;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                ret.append(delim);
            }
            if (objs[i] instanceof String) {
                ret.append('\"').append(objs[i]).append('\"');
            } else {
                ret.append(objs[i]);
            }
        }
        return ret.toString();
    }

    public static String join(Collection<?> objs, String delim) {
        if (objs == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        boolean needDelim = false;
        for (Object obj : objs) {
            if (needDelim) {
                ret.append(delim);
            }
            if (obj instanceof String) {
                ret.append('\"').append(obj).append('\"');
            } else {
                ret.append(obj);
            }
            needDelim = true;
        }
        return ret.toString();
    }
}
