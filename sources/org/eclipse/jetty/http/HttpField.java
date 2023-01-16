package org.eclipse.jetty.http;

import java.util.Objects;
import org.eclipse.jetty.util.StringUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpField.class */
public class HttpField {
    private static final String ZEROQUALITY = "q=0";
    private final HttpHeader _header;
    private final String _name;
    private final String _value;
    private int hash;

    public HttpField(HttpHeader header, String name, String value) {
        this.hash = 0;
        this._header = header;
        if (this._header == null || name != null) {
            this._name = (String) Objects.requireNonNull(name, "name");
        } else {
            this._name = this._header.asString();
        }
        this._value = value;
    }

    public HttpField(HttpHeader header, String value) {
        this(header, header.asString(), value);
    }

    public HttpField(HttpHeader header, HttpHeaderValue value) {
        this(header, header.asString(), value.asString());
    }

    public HttpField(String name, String value) {
        this(HttpHeader.CACHE.get(name), name, value);
    }

    public HttpHeader getHeader() {
        return this._header;
    }

    public String getName() {
        return this._name;
    }

    public String getLowerCaseName() {
        return this._header != null ? this._header.lowerCaseName() : StringUtil.asciiToLowerCase(this._name);
    }

    public String getValue() {
        return this._value;
    }

    public int getIntValue() {
        return Integer.parseInt(this._value);
    }

    public long getLongValue() {
        return Long.parseLong(this._value);
    }

    public String[] getValues() {
        if (this._value == null) {
            return null;
        }
        QuotedCSV list = new QuotedCSV(false, this._value);
        return (String[]) list.getValues().toArray(new String[list.size()]);
    }

    public boolean contains(String search) {
        if (search == null) {
            return this._value == null;
        }
        if (search.isEmpty() || this._value == null) {
            return false;
        }
        if (search.equals(this._value)) {
            return true;
        }
        String search2 = StringUtil.asciiToLowerCase(search);
        int state = 0;
        int match = 0;
        int param = 0;
        for (int i = 0; i < this._value.length(); i++) {
            char c = this._value.charAt(i);
            switch (state) {
                case 0:
                    switch (c) {
                        case '\t':
                        case ' ':
                        case ',':
                            break;
                        case '\"':
                            match = 0;
                            state = 2;
                            continue;
                        case ';':
                            param = -1;
                            match = -1;
                            state = 5;
                            continue;
                        default:
                            match = Character.toLowerCase(c) == search2.charAt(0) ? 1 : -1;
                            state = 1;
                            continue;
                    }
                case 1:
                    switch (c) {
                        case ',':
                            if (match == search2.length()) {
                                return true;
                            }
                            state = 0;
                            continue;
                        case ';':
                            param = match >= 0 ? 0 : -1;
                            state = 5;
                            continue;
                        default:
                            if (match > 0) {
                                if (match >= search2.length()) {
                                    if (!(c == ' ' || c == '\t')) {
                                        match = -1;
                                        break;
                                    }
                                } else {
                                    match = Character.toLowerCase(c) == search2.charAt(match) ? match + 1 : -1;
                                    break;
                                }
                            } else {
                                continue;
                            }
                            break;
                    }
                case 2:
                    switch (c) {
                        case '\"':
                            state = 4;
                            continue;
                        case '\\':
                            state = 3;
                            continue;
                        default:
                            if (match >= 0) {
                                if (match < search2.length()) {
                                    match = Character.toLowerCase(c) == search2.charAt(match) ? match + 1 : -1;
                                    break;
                                } else {
                                    match = -1;
                                    break;
                                }
                            } else {
                                continue;
                            }
                    }
                case 3:
                    if (match >= 0) {
                        if (match < search2.length()) {
                            match = Character.toLowerCase(c) == search2.charAt(match) ? match + 1 : -1;
                        } else {
                            match = -1;
                        }
                    }
                    state = 2;
                    break;
                case 4:
                    switch (c) {
                        case '\t':
                        case ' ':
                            continue;
                        case ',':
                            if (match == search2.length()) {
                                return true;
                            }
                            state = 0;
                            continue;
                        case ';':
                            state = 5;
                            continue;
                        default:
                            match = -1;
                            continue;
                    }
                case 5:
                    switch (c) {
                        case '\t':
                        case ' ':
                            continue;
                        case ',':
                            if (param != ZEROQUALITY.length() && match == search2.length()) {
                                return true;
                            }
                            param = 0;
                            state = 0;
                            continue;
                        default:
                            if (param >= 0) {
                                if (param >= ZEROQUALITY.length()) {
                                    if (!(c == '0' || c == '.')) {
                                        param = -1;
                                        break;
                                    }
                                } else {
                                    param = Character.toLowerCase(c) == ZEROQUALITY.charAt(param) ? param + 1 : -1;
                                    break;
                                }
                            } else {
                                continue;
                            }
                            break;
                    }
                default:
                    throw new IllegalStateException();
            }
        }
        return param != ZEROQUALITY.length() && match == search2.length();
    }

    public String toString() {
        String v = getValue();
        return getName() + ": " + (v == null ? "" : v);
    }

    public boolean isSameName(HttpField field) {
        if (field == null) {
            return false;
        }
        if (field == this) {
            return true;
        }
        if (this._header == null || this._header != field.getHeader()) {
            return this._name.equalsIgnoreCase(field.getName());
        }
        return true;
    }

    /* renamed from: is */
    public boolean m43is(String name) {
        return this._name.equalsIgnoreCase(name);
    }

    private int nameHashCode() {
        int h = this.hash;
        int len = this._name.length();
        if (h == 0 && len > 0) {
            for (int i = 0; i < len; i++) {
                char c = this._name.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c = (char) (c - ' ');
                }
                h = (31 * h) + c;
            }
            this.hash = h;
        }
        return h;
    }

    public int hashCode() {
        int vhc = Objects.hashCode(this._value);
        if (this._header == null) {
            return vhc ^ nameHashCode();
        }
        return vhc ^ this._header.hashCode();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HttpField)) {
            return false;
        }
        HttpField field = (HttpField) o;
        if (this._header == field.getHeader() && this._name.equalsIgnoreCase(field.getName())) {
            return Objects.equals(this._value, field.getValue());
        }
        return false;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpField$IntValueHttpField.class */
    public static class IntValueHttpField extends HttpField {
        private final int _int;

        public IntValueHttpField(HttpHeader header, String name, String value, int intValue) {
            super(header, name, value);
            this._int = intValue;
        }

        public IntValueHttpField(HttpHeader header, String name, String value) {
            this(header, name, value, Integer.parseInt(value));
        }

        public IntValueHttpField(HttpHeader header, String name, int intValue) {
            this(header, name, Integer.toString(intValue), intValue);
        }

        public IntValueHttpField(HttpHeader header, int value) {
            this(header, header.asString(), value);
        }

        @Override // org.eclipse.jetty.http.HttpField
        public int getIntValue() {
            return this._int;
        }

        @Override // org.eclipse.jetty.http.HttpField
        public long getLongValue() {
            return (long) this._int;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpField$LongValueHttpField.class */
    public static class LongValueHttpField extends HttpField {
        private final long _long;

        public LongValueHttpField(HttpHeader header, String name, String value, long longValue) {
            super(header, name, value);
            this._long = longValue;
        }

        public LongValueHttpField(HttpHeader header, String name, String value) {
            this(header, name, value, Long.parseLong(value));
        }

        public LongValueHttpField(HttpHeader header, String name, long value) {
            this(header, name, Long.toString(value), value);
        }

        public LongValueHttpField(HttpHeader header, long value) {
            this(header, header.asString(), value);
        }

        @Override // org.eclipse.jetty.http.HttpField
        public int getIntValue() {
            return (int) this._long;
        }

        @Override // org.eclipse.jetty.http.HttpField
        public long getLongValue() {
            return this._long;
        }
    }
}
