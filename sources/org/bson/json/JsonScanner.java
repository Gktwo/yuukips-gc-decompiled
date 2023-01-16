package org.bson.json;

import java.io.Reader;
import org.bson.BsonRegularExpression;
import p013io.javalin.http.sse.EmitterKt;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonScanner.class */
public class JsonScanner {
    private final JsonBuffer buffer;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/bson/json/JsonScanner$NumberState.class */
    public enum NumberState {
        SAW_LEADING_MINUS,
        SAW_LEADING_ZERO,
        SAW_INTEGER_DIGITS,
        SAW_DECIMAL_POINT,
        SAW_FRACTION_DIGITS,
        SAW_EXPONENT_LETTER,
        SAW_EXPONENT_SIGN,
        SAW_EXPONENT_DIGITS,
        SAW_MINUS_I,
        DONE,
        INVALID
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/bson/json/JsonScanner$RegularExpressionState.class */
    public enum RegularExpressionState {
        IN_PATTERN,
        IN_ESCAPE_SEQUENCE,
        IN_OPTIONS,
        DONE,
        INVALID
    }

    JsonScanner(JsonBuffer buffer) {
        this.buffer = buffer;
    }

    /* access modifiers changed from: package-private */
    public JsonScanner(String json) {
        this(new JsonStringBuffer(json));
    }

    /* access modifiers changed from: package-private */
    public JsonScanner(Reader reader) {
        this(new JsonStreamBuffer(reader));
    }

    public void reset(int markPos) {
        this.buffer.reset(markPos);
    }

    public int mark() {
        return this.buffer.mark();
    }

    public void discard(int markPos) {
        this.buffer.discard(markPos);
    }

    public JsonToken nextToken() {
        int c = this.buffer.read();
        while (c != -1 && Character.isWhitespace(c)) {
            c = this.buffer.read();
        }
        if (c == -1) {
            return new JsonToken(JsonTokenType.END_OF_FILE, "<eof>");
        }
        switch (c) {
            case 34:
            case 39:
                return scanString((char) c);
            case 40:
                return new JsonToken(JsonTokenType.LEFT_PAREN, "(");
            case 41:
                return new JsonToken(JsonTokenType.RIGHT_PAREN, ")");
            case 44:
                return new JsonToken(JsonTokenType.COMMA, ",");
            case 47:
                return scanRegularExpression();
            case 58:
                return new JsonToken(JsonTokenType.COLON, EmitterKt.COMMENT_PREFIX);
            case 91:
                return new JsonToken(JsonTokenType.BEGIN_ARRAY, "[");
            case 93:
                return new JsonToken(JsonTokenType.END_ARRAY, "]");
            case 123:
                return new JsonToken(JsonTokenType.BEGIN_OBJECT, "{");
            case 125:
                return new JsonToken(JsonTokenType.END_OBJECT, "}");
            default:
                if (c == 45 || Character.isDigit(c)) {
                    return scanNumber((char) c);
                }
                if (c == 36 || c == 95 || Character.isLetter(c)) {
                    return scanUnquotedString((char) c);
                }
                int position = this.buffer.getPosition();
                this.buffer.unread(c);
                throw new JsonParseException("Invalid JSON input. Position: %d. Character: '%c'.", Integer.valueOf(position), Integer.valueOf(c));
        }
    }

    private JsonToken scanRegularExpression() {
        StringBuilder patternBuilder = new StringBuilder();
        StringBuilder optionsBuilder = new StringBuilder();
        RegularExpressionState state = RegularExpressionState.IN_PATTERN;
        while (true) {
            int c = this.buffer.read();
            switch (state) {
                case IN_PATTERN:
                    switch (c) {
                        case -1:
                            state = RegularExpressionState.INVALID;
                            break;
                        case 47:
                            state = RegularExpressionState.IN_OPTIONS;
                            break;
                        case 92:
                            state = RegularExpressionState.IN_ESCAPE_SEQUENCE;
                            break;
                        default:
                            state = RegularExpressionState.IN_PATTERN;
                            break;
                    }
                case IN_ESCAPE_SEQUENCE:
                    state = RegularExpressionState.IN_PATTERN;
                    break;
                case IN_OPTIONS:
                    switch (c) {
                        case -1:
                        case 41:
                        case 44:
                        case 93:
                        case 125:
                            state = RegularExpressionState.DONE;
                            break;
                        case 105:
                        case 109:
                        case 115:
                        case 120:
                            state = RegularExpressionState.IN_OPTIONS;
                            break;
                        default:
                            if (!Character.isWhitespace(c)) {
                                state = RegularExpressionState.INVALID;
                                break;
                            } else {
                                state = RegularExpressionState.DONE;
                                break;
                            }
                    }
            }
            switch (state) {
                case DONE:
                    this.buffer.unread(c);
                    return new JsonToken(JsonTokenType.REGULAR_EXPRESSION, new BsonRegularExpression(patternBuilder.toString(), optionsBuilder.toString()));
                case INVALID:
                    throw new JsonParseException("Invalid JSON regular expression. Position: %d.", Integer.valueOf(this.buffer.getPosition()));
                default:
                    switch (state) {
                        case IN_OPTIONS:
                            if (c == 47) {
                                break;
                            } else {
                                optionsBuilder.append((char) c);
                                break;
                            }
                        default:
                            patternBuilder.append((char) c);
                            break;
                    }
            }
        }
    }

    private JsonToken scanUnquotedString(char firstChar) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);
        int c = this.buffer.read();
        while (true) {
            if (c == 36 || c == 95 || Character.isLetterOrDigit(c)) {
                sb.append((char) c);
                c = this.buffer.read();
            } else {
                this.buffer.unread(c);
                return new JsonToken(JsonTokenType.UNQUOTED_STRING, sb.toString());
            }
        }
    }

    private JsonToken scanNumber(char firstChar) {
        NumberState state;
        StringBuilder sb = new StringBuilder();
        sb.append(firstChar);
        switch (firstChar) {
            case '-':
                state = NumberState.SAW_LEADING_MINUS;
                break;
            case '0':
                state = NumberState.SAW_LEADING_ZERO;
                break;
            default:
                state = NumberState.SAW_INTEGER_DIGITS;
                break;
        }
        JsonTokenType type = JsonTokenType.INT64;
        while (true) {
            int c = this.buffer.read();
            switch (state) {
                case SAW_LEADING_MINUS:
                    switch (c) {
                        case 48:
                            state = NumberState.SAW_LEADING_ZERO;
                            break;
                        case 73:
                            state = NumberState.SAW_MINUS_I;
                            break;
                        default:
                            if (!Character.isDigit(c)) {
                                state = NumberState.INVALID;
                                break;
                            } else {
                                state = NumberState.SAW_INTEGER_DIGITS;
                                break;
                            }
                    }
                case SAW_LEADING_ZERO:
                    switch (c) {
                        case -1:
                        case 41:
                        case 44:
                        case 93:
                        case 125:
                            state = NumberState.DONE;
                            break;
                        case 46:
                            state = NumberState.SAW_DECIMAL_POINT;
                            break;
                        case 69:
                        case 101:
                            state = NumberState.SAW_EXPONENT_LETTER;
                            break;
                        default:
                            if (!Character.isDigit(c)) {
                                if (!Character.isWhitespace(c)) {
                                    state = NumberState.INVALID;
                                    break;
                                } else {
                                    state = NumberState.DONE;
                                    break;
                                }
                            } else {
                                state = NumberState.SAW_INTEGER_DIGITS;
                                break;
                            }
                    }
                case SAW_INTEGER_DIGITS:
                    switch (c) {
                        case -1:
                        case 41:
                        case 44:
                        case 93:
                        case 125:
                            state = NumberState.DONE;
                            break;
                        case 46:
                            state = NumberState.SAW_DECIMAL_POINT;
                            break;
                        case 69:
                        case 101:
                            state = NumberState.SAW_EXPONENT_LETTER;
                            break;
                        default:
                            if (!Character.isDigit(c)) {
                                if (!Character.isWhitespace(c)) {
                                    state = NumberState.INVALID;
                                    break;
                                } else {
                                    state = NumberState.DONE;
                                    break;
                                }
                            } else {
                                state = NumberState.SAW_INTEGER_DIGITS;
                                break;
                            }
                    }
                case SAW_DECIMAL_POINT:
                    type = JsonTokenType.DOUBLE;
                    if (!Character.isDigit(c)) {
                        state = NumberState.INVALID;
                        break;
                    } else {
                        state = NumberState.SAW_FRACTION_DIGITS;
                        break;
                    }
                case SAW_FRACTION_DIGITS:
                    switch (c) {
                        case -1:
                        case 41:
                        case 44:
                        case 93:
                        case 125:
                            state = NumberState.DONE;
                            break;
                        case 69:
                        case 101:
                            state = NumberState.SAW_EXPONENT_LETTER;
                            break;
                        default:
                            if (!Character.isDigit(c)) {
                                if (!Character.isWhitespace(c)) {
                                    state = NumberState.INVALID;
                                    break;
                                } else {
                                    state = NumberState.DONE;
                                    break;
                                }
                            } else {
                                state = NumberState.SAW_FRACTION_DIGITS;
                                break;
                            }
                    }
                case SAW_EXPONENT_LETTER:
                    type = JsonTokenType.DOUBLE;
                    switch (c) {
                        case 43:
                        case 45:
                            state = NumberState.SAW_EXPONENT_SIGN;
                            break;
                        default:
                            if (!Character.isDigit(c)) {
                                state = NumberState.INVALID;
                                break;
                            } else {
                                state = NumberState.SAW_EXPONENT_DIGITS;
                                break;
                            }
                    }
                case SAW_EXPONENT_SIGN:
                    if (!Character.isDigit(c)) {
                        state = NumberState.INVALID;
                        break;
                    } else {
                        state = NumberState.SAW_EXPONENT_DIGITS;
                        break;
                    }
                case SAW_EXPONENT_DIGITS:
                    switch (c) {
                        case 41:
                        case 44:
                        case 93:
                        case 125:
                            state = NumberState.DONE;
                            break;
                        default:
                            if (!Character.isDigit(c)) {
                                if (!Character.isWhitespace(c)) {
                                    state = NumberState.INVALID;
                                    break;
                                } else {
                                    state = NumberState.DONE;
                                    break;
                                }
                            } else {
                                state = NumberState.SAW_EXPONENT_DIGITS;
                                break;
                            }
                    }
                case SAW_MINUS_I:
                    boolean sawMinusInfinity = true;
                    char[] nfinity = {'n', 'f', 'i', 'n', 'i', 't', 'y'};
                    int i = 0;
                    while (true) {
                        if (i < nfinity.length) {
                            if (c != nfinity[i]) {
                                sawMinusInfinity = false;
                            } else {
                                sb.append((char) c);
                                c = this.buffer.read();
                                i++;
                            }
                        }
                    }
                    if (!sawMinusInfinity) {
                        state = NumberState.INVALID;
                        break;
                    } else {
                        type = JsonTokenType.DOUBLE;
                        switch (c) {
                            case -1:
                            case 41:
                            case 44:
                            case 93:
                            case 125:
                                state = NumberState.DONE;
                                break;
                            default:
                                if (!Character.isWhitespace(c)) {
                                    state = NumberState.INVALID;
                                    break;
                                } else {
                                    state = NumberState.DONE;
                                    break;
                                }
                        }
                    }
            }
            switch (state) {
                case INVALID:
                    throw new JsonParseException("Invalid JSON number");
                case DONE:
                    this.buffer.unread(c);
                    String lexeme = sb.toString();
                    if (type == JsonTokenType.DOUBLE) {
                        return new JsonToken(JsonTokenType.DOUBLE, Double.valueOf(Double.parseDouble(lexeme)));
                    }
                    long value = Long.parseLong(lexeme);
                    if (value < -2147483648L || value > 2147483647L) {
                        return new JsonToken(JsonTokenType.INT64, Long.valueOf(value));
                    }
                    return new JsonToken(JsonTokenType.INT32, Integer.valueOf((int) value));
                default:
                    sb.append((char) c);
            }
        }
    }

    private JsonToken scanString(char quoteCharacter) {
        int c;
        StringBuilder sb = new StringBuilder();
        do {
            c = this.buffer.read();
            switch (c) {
                case 92:
                    c = this.buffer.read();
                    switch (c) {
                        case 34:
                            sb.append('\"');
                            break;
                        case 39:
                            sb.append('\'');
                            break;
                        case 47:
                            sb.append('/');
                            break;
                        case 92:
                            sb.append('\\');
                            break;
                        case 98:
                            sb.append('\b');
                            break;
                        case 102:
                            sb.append('\f');
                            break;
                        case 110:
                            sb.append('\n');
                            break;
                        case 114:
                            sb.append('\r');
                            break;
                        case 116:
                            sb.append('\t');
                            break;
                        case 117:
                            int u1 = this.buffer.read();
                            int u2 = this.buffer.read();
                            int u3 = this.buffer.read();
                            int u4 = this.buffer.read();
                            if (u4 != -1) {
                                sb.append((char) Integer.parseInt(new String(new char[]{(char) u1, (char) u2, (char) u3, (char) u4}), 16));
                                break;
                            }
                            break;
                        default:
                            throw new JsonParseException("Invalid escape sequence in JSON string '\\%c'.", Integer.valueOf(c));
                    }
                default:
                    if (c != quoteCharacter) {
                        if (c != -1) {
                            sb.append((char) c);
                            break;
                        }
                    } else {
                        return new JsonToken(JsonTokenType.STRING, sb.toString());
                    }
                    break;
            }
        } while (c != -1);
        throw new JsonParseException("End of file in JSON string.");
    }
}
