package org.eclipse.jetty.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/QuotedStringTokenizer.class */
public class QuotedStringTokenizer extends StringTokenizer {
    private static final String __delim = "\t\n\r";
    private String _string;
    private String _delim;
    private boolean _returnQuotes;
    private boolean _returnDelimiters;
    private StringBuffer _token;
    private boolean _hasToken;

    /* renamed from: _i */
    private int f3124_i;
    private int _lastStart;
    private boolean _double;
    private boolean _single;
    private static final char[] escapes = new char[32];

    public QuotedStringTokenizer(String str, String delim, boolean returnDelimiters, boolean returnQuotes) {
        super("");
        this._delim = __delim;
        this._returnQuotes = false;
        this._returnDelimiters = false;
        this._hasToken = false;
        this.f3124_i = 0;
        this._lastStart = 0;
        this._double = true;
        this._single = true;
        this._string = str;
        if (delim != null) {
            this._delim = delim;
        }
        this._returnDelimiters = returnDelimiters;
        this._returnQuotes = returnQuotes;
        if (this._delim.indexOf(39) >= 0 || this._delim.indexOf(34) >= 0) {
            throw new Error("Can't use quotes as delimiters: " + this._delim);
        }
        this._token = new StringBuffer(this._string.length() > 1024 ? 512 : this._string.length() / 2);
    }

    public QuotedStringTokenizer(String str, String delim, boolean returnDelimiters) {
        this(str, delim, returnDelimiters, false);
    }

    public QuotedStringTokenizer(String str, String delim) {
        this(str, delim, false, false);
    }

    public QuotedStringTokenizer(String str) {
        this(str, null, false, false);
    }

    @Override // java.util.StringTokenizer
    public boolean hasMoreTokens() {
        if (this._hasToken) {
            return true;
        }
        this._lastStart = this.f3124_i;
        int state = 0;
        boolean escape = false;
        while (this.f3124_i < this._string.length()) {
            String str = this._string;
            int i = this.f3124_i;
            this.f3124_i = i + 1;
            char c = str.charAt(i);
            switch (state) {
                case 0:
                    if (this._delim.indexOf(c) < 0) {
                        if (c != '\'' || !this._single) {
                            if (c == '\"' && this._double) {
                                if (this._returnQuotes) {
                                    this._token.append(c);
                                }
                                state = 3;
                                break;
                            } else {
                                this._token.append(c);
                                this._hasToken = true;
                                state = 1;
                                break;
                            }
                        } else {
                            if (this._returnQuotes) {
                                this._token.append(c);
                            }
                            state = 2;
                            break;
                        }
                    } else if (!this._returnDelimiters) {
                        break;
                    } else {
                        this._token.append(c);
                        this._hasToken = true;
                        return true;
                    }
                case 1:
                    this._hasToken = true;
                    if (this._delim.indexOf(c) < 0) {
                        if (c != '\'' || !this._single) {
                            if (c == '\"' && this._double) {
                                if (this._returnQuotes) {
                                    this._token.append(c);
                                }
                                state = 3;
                                break;
                            } else {
                                this._token.append(c);
                                break;
                            }
                        } else {
                            if (this._returnQuotes) {
                                this._token.append(c);
                            }
                            state = 2;
                            break;
                        }
                    } else {
                        if (this._returnDelimiters) {
                            this.f3124_i--;
                        }
                        return this._hasToken;
                    }
                case 2:
                    this._hasToken = true;
                    if (!escape) {
                        if (c != '\'') {
                            if (c != '\\') {
                                this._token.append(c);
                                break;
                            } else {
                                if (this._returnQuotes) {
                                    this._token.append(c);
                                }
                                escape = true;
                                break;
                            }
                        } else {
                            if (this._returnQuotes) {
                                this._token.append(c);
                            }
                            state = 1;
                            break;
                        }
                    } else {
                        escape = false;
                        this._token.append(c);
                        break;
                    }
                case 3:
                    this._hasToken = true;
                    if (!escape) {
                        if (c != '\"') {
                            if (c != '\\') {
                                this._token.append(c);
                                break;
                            } else {
                                if (this._returnQuotes) {
                                    this._token.append(c);
                                }
                                escape = true;
                                break;
                            }
                        } else {
                            if (this._returnQuotes) {
                                this._token.append(c);
                            }
                            state = 1;
                            break;
                        }
                    } else {
                        escape = false;
                        this._token.append(c);
                        break;
                    }
            }
        }
        return this._hasToken;
    }

    @Override // java.util.StringTokenizer
    public String nextToken() throws NoSuchElementException {
        if (!hasMoreTokens() || this._token == null) {
            throw new NoSuchElementException();
        }
        String t = this._token.toString();
        this._token.setLength(0);
        this._hasToken = false;
        return t;
    }

    @Override // java.util.StringTokenizer
    public String nextToken(String delim) throws NoSuchElementException {
        this._delim = delim;
        this.f3124_i = this._lastStart;
        this._token.setLength(0);
        this._hasToken = false;
        return nextToken();
    }

    @Override // java.util.StringTokenizer, java.util.Enumeration
    public boolean hasMoreElements() {
        return hasMoreTokens();
    }

    @Override // java.util.StringTokenizer, java.util.Enumeration
    public Object nextElement() throws NoSuchElementException {
        return nextToken();
    }

    @Override // java.util.StringTokenizer
    public int countTokens() {
        return -1;
    }

    public static String quoteIfNeeded(String s, String delim) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "\"\"";
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' || c == '\"' || c == '\'' || Character.isWhitespace(c) || delim.indexOf(c) >= 0) {
                StringBuffer b = new StringBuffer(s.length() + 8);
                quote(b, s);
                return b.toString();
            }
        }
        return s;
    }

    public static String quote(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return "\"\"";
        }
        StringBuffer b = new StringBuffer(s.length() + 8);
        quote(b, s);
        return b.toString();
    }

    static {
        Arrays.fill(escapes, (char) 65535);
        escapes[8] = 'b';
        escapes[9] = 't';
        escapes[10] = 'n';
        escapes[12] = 'f';
        escapes[13] = 'r';
    }

    public static void quoteOnly(Appendable buffer, String input) {
        if (input != null) {
            try {
                buffer.append('\"');
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (c == '\"' || c == '\\') {
                        buffer.append('\\');
                    }
                    buffer.append(c);
                }
                buffer.append('\"');
            } catch (IOException x) {
                throw new RuntimeException(x);
            }
        }
    }

    public static void quote(Appendable buffer, String input) {
        if (input != null) {
            try {
                buffer.append('\"');
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (c >= ' ') {
                        if (c == '\"' || c == '\\') {
                            buffer.append('\\');
                        }
                        buffer.append(c);
                    } else {
                        char escape = escapes[c];
                        if (escape == 65535) {
                            buffer.append('\\').append('u').append('0').append('0');
                            if (c < 16) {
                                buffer.append('0');
                            }
                            buffer.append(Integer.toString(c, 16));
                        } else {
                            buffer.append('\\').append(escape);
                        }
                    }
                }
                buffer.append('\"');
            } catch (IOException x) {
                throw new RuntimeException(x);
            }
        }
    }

    public static String unquoteOnly(String s) {
        return unquoteOnly(s, false);
    }

    public static String unquoteOnly(String s, boolean lenient) {
        if (s == null) {
            return null;
        }
        if (s.length() < 2) {
            return s;
        }
        char first = s.charAt(0);
        if (!(first == s.charAt(s.length() - 1) && (first == '\"' || first == '\''))) {
            return s;
        }
        StringBuilder b = new StringBuilder(s.length() - 2);
        boolean escape = false;
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (escape) {
                escape = false;
                if (lenient && !isValidEscaping(c)) {
                    b.append('\\');
                }
                b.append(c);
            } else if (c == '\\') {
                escape = true;
            } else {
                b.append(c);
            }
        }
        return b.toString();
    }

    public static String unquote(String s) {
        return unquote(s, false);
    }

    public static String unquote(String s, boolean lenient) {
        if (s == null) {
            return null;
        }
        if (s.length() < 2) {
            return s;
        }
        char first = s.charAt(0);
        if (first != s.charAt(s.length() - 1) || (first != '\"' && first != '\'')) {
            return s;
        }
        StringBuilder b = new StringBuilder(s.length() - 2);
        boolean escape = false;
        int i = 1;
        while (i < s.length() - 1) {
            char c = s.charAt(i);
            if (escape) {
                escape = false;
                switch (c) {
                    case '\"':
                        b.append('\"');
                        continue;
                    case '/':
                        b.append('/');
                        continue;
                    case '\\':
                        b.append('\\');
                        continue;
                    case 'b':
                        b.append('\b');
                        continue;
                    case 'f':
                        b.append('\f');
                        continue;
                    case 'n':
                        b.append('\n');
                        continue;
                    case 'r':
                        b.append('\r');
                        continue;
                    case 't':
                        b.append('\t');
                        continue;
                    case 'u':
                        int i2 = i + 1;
                        int i3 = i2 + 1;
                        int i4 = i3 + 1;
                        i = i4 + 1;
                        b.append((char) ((TypeUtil.convertHexDigit((byte) s.charAt(i)) << 24) + (TypeUtil.convertHexDigit((byte) s.charAt(i2)) << 16) + (TypeUtil.convertHexDigit((byte) s.charAt(i3)) << 8) + TypeUtil.convertHexDigit((byte) s.charAt(i4))));
                        continue;
                    default:
                        if (lenient && !isValidEscaping(c)) {
                            b.append('\\');
                        }
                        b.append(c);
                        continue;
                }
            } else if (c == '\\') {
                escape = true;
            } else {
                b.append(c);
            }
            i++;
        }
        return b.toString();
    }

    private static boolean isValidEscaping(char c) {
        return c == 'n' || c == 'r' || c == 't' || c == 'f' || c == 'b' || c == '\\' || c == '/' || c == '\"' || c == 'u';
    }

    public static boolean isQuoted(String s) {
        return s != null && s.length() > 0 && s.charAt(0) == '\"' && s.charAt(s.length() - 1) == '\"';
    }

    public boolean getDouble() {
        return this._double;
    }

    public void setDouble(boolean d) {
        this._double = d;
    }

    public boolean getSingle() {
        return this._single;
    }

    public void setSingle(boolean single) {
        this._single = single;
    }
}
