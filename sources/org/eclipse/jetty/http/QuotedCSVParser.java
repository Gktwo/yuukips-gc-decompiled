package org.eclipse.jetty.http;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/QuotedCSVParser.class */
public abstract class QuotedCSVParser {
    protected final boolean _keepQuotes;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/QuotedCSVParser$State.class */
    private enum State {
        VALUE,
        PARAM_NAME,
        PARAM_VALUE
    }

    public QuotedCSVParser(boolean keepQuotes) {
        this._keepQuotes = keepQuotes;
    }

    public static String unquote(String s) {
        int l = s.length();
        if (s == null || l == 0) {
            return s;
        }
        int i = 0;
        while (i < l && s.charAt(i) != '\"') {
            i++;
        }
        if (i == l) {
            return s;
        }
        boolean quoted = true;
        boolean sloshed = false;
        StringBuffer buffer = new StringBuffer();
        buffer.append((CharSequence) s, 0, i);
        while (true) {
            i++;
            if (i >= l) {
                return buffer.toString();
            }
            char c = s.charAt(i);
            if (quoted) {
                if (sloshed) {
                    buffer.append(c);
                    sloshed = false;
                } else if (c == '\"') {
                    quoted = false;
                } else if (c == '\\') {
                    sloshed = true;
                } else {
                    buffer.append(c);
                }
            } else if (c == '\"') {
                quoted = true;
            } else {
                buffer.append(c);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void addValue(String value) {
        if (value != null) {
            StringBuffer buffer = new StringBuffer();
            int l = value.length();
            State state = State.VALUE;
            boolean quoted = false;
            boolean sloshed = false;
            int nwsLength = 0;
            int lastLength = 0;
            int valueLength = -1;
            int paramName = -1;
            int paramValue = -1;
            int i = 0;
            while (i <= l) {
                char c = i == l ? 0 : value.charAt(i);
                if (!quoted || c == 0) {
                    switch (c) {
                        case 0:
                        case ',':
                            if (nwsLength > 0) {
                                buffer.setLength(nwsLength);
                                switch (state) {
                                    case VALUE:
                                        parsedValue(buffer);
                                        buffer.length();
                                        break;
                                    case PARAM_NAME:
                                    case PARAM_VALUE:
                                        parsedParam(buffer, valueLength, paramName, paramValue);
                                        break;
                                }
                                parsedValueAndParams(buffer);
                            }
                            buffer.setLength(0);
                            lastLength = 0;
                            nwsLength = 0;
                            paramValue = -1;
                            paramName = -1;
                            valueLength = -1;
                            state = State.VALUE;
                            continue;
                        case '\t':
                        case ' ':
                            if (buffer.length() > lastLength) {
                                buffer.append(c);
                                break;
                            } else {
                                continue;
                            }
                        case '\"':
                            quoted = true;
                            if (this._keepQuotes) {
                                if (state == State.PARAM_VALUE && paramValue < 0) {
                                    paramValue = nwsLength;
                                }
                                buffer.append(c);
                            } else if (state == State.PARAM_VALUE && paramValue < 0) {
                                paramValue = nwsLength;
                            }
                            nwsLength = buffer.length();
                            continue;
                        case ';':
                            buffer.setLength(nwsLength);
                            if (state == State.VALUE) {
                                parsedValue(buffer);
                                valueLength = buffer.length();
                            } else {
                                parsedParam(buffer, valueLength, paramName, paramValue);
                            }
                            int nwsLength2 = buffer.length();
                            paramValue = -1;
                            paramName = -1;
                            buffer.append(c);
                            nwsLength = nwsLength2 + 1;
                            lastLength = nwsLength;
                            state = State.PARAM_NAME;
                            continue;
                        case '=':
                            switch (state) {
                                case VALUE:
                                    paramName = 0;
                                    buffer.setLength(nwsLength);
                                    String param = buffer.toString();
                                    buffer.setLength(0);
                                    parsedValue(buffer);
                                    valueLength = buffer.length();
                                    buffer.append(param);
                                    buffer.append(c);
                                    nwsLength++;
                                    lastLength = nwsLength;
                                    state = State.PARAM_VALUE;
                                    continue;
                                    continue;
                                case PARAM_NAME:
                                    buffer.setLength(nwsLength);
                                    buffer.append(c);
                                    nwsLength++;
                                    lastLength = nwsLength;
                                    state = State.PARAM_VALUE;
                                    continue;
                                case PARAM_VALUE:
                                    if (paramValue < 0) {
                                        paramValue = nwsLength;
                                    }
                                    buffer.append(c);
                                    nwsLength = buffer.length();
                                    continue;
                            }
                        default:
                            switch (state) {
                                case VALUE:
                                    buffer.append(c);
                                    nwsLength = buffer.length();
                                    continue;
                                case PARAM_NAME:
                                    if (paramName < 0) {
                                        paramName = nwsLength;
                                    }
                                    buffer.append(c);
                                    nwsLength = buffer.length();
                                    continue;
                                case PARAM_VALUE:
                                    if (paramValue < 0) {
                                        paramValue = nwsLength;
                                    }
                                    buffer.append(c);
                                    nwsLength = buffer.length();
                                    continue;
                                default:
                                    continue;
                            }
                    }
                } else {
                    if (!sloshed) {
                        switch (c) {
                            case '\"':
                                quoted = false;
                                if (!this._keepQuotes) {
                                    break;
                                }
                                break;
                            case '\\':
                                sloshed = true;
                                if (!this._keepQuotes) {
                                    break;
                                }
                                break;
                        }
                    } else {
                        sloshed = false;
                    }
                    buffer.append(c);
                    nwsLength = buffer.length();
                }
                i++;
            }
        }
    }

    protected void parsedValueAndParams(StringBuffer buffer) {
    }

    protected void parsedValue(StringBuffer buffer) {
    }

    protected void parsedParam(StringBuffer buffer, int valueLength, int paramName, int paramValue) {
    }
}
