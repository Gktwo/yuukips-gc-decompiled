package org.eclipse.jetty.http;

import org.eclipse.jetty.util.TypeUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpTokens.class */
public class HttpTokens {
    static final byte COLON = 58;
    static final byte TAB = 9;
    static final byte LINE_FEED = 10;
    static final byte CARRIAGE_RETURN = 13;
    static final byte SPACE = 32;
    static final byte[] CRLF = {13, 10};
    public static final Token[] TOKENS = new Token[256];

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpTokens$EndOfContent.class */
    public enum EndOfContent {
        UNKNOWN_CONTENT,
        NO_CONTENT,
        EOF_CONTENT,
        CONTENT_LENGTH,
        CHUNKED_CONTENT
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpTokens$Type.class */
    public enum Type {
        CNTL,
        HTAB,
        LF,
        CR,
        SPACE,
        COLON,
        DIGIT,
        ALPHA,
        TCHAR,
        VCHAR,
        OTEXT
    }

    static {
        for (int b = 0; b < 256; b++) {
            switch (b) {
                case 9:
                    TOKENS[b] = new Token((byte) b, Type.HTAB);
                    break;
                case 10:
                    TOKENS[b] = new Token((byte) b, Type.LF);
                    break;
                case 13:
                    TOKENS[b] = new Token((byte) b, Type.CR);
                    break;
                case 32:
                    TOKENS[b] = new Token((byte) b, Type.SPACE);
                    break;
                case 33:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 42:
                case 43:
                case 45:
                case 46:
                case 94:
                case 95:
                case 96:
                case 124:
                case 126:
                    TOKENS[b] = new Token((byte) b, Type.TCHAR);
                    break;
                case 58:
                    TOKENS[b] = new Token((byte) b, Type.COLON);
                    break;
                default:
                    if (b < 48 || b > 57) {
                        if (b < 65 || b > 90) {
                            if (b < 97 || b > 122) {
                                if (b < 33 || b > 126) {
                                    if (b >= 128) {
                                        TOKENS[b] = new Token((byte) b, Type.OTEXT);
                                        break;
                                    } else {
                                        TOKENS[b] = new Token((byte) b, Type.CNTL);
                                        break;
                                    }
                                } else {
                                    TOKENS[b] = new Token((byte) b, Type.VCHAR);
                                    break;
                                }
                            } else {
                                TOKENS[b] = new Token((byte) b, Type.ALPHA);
                                break;
                            }
                        } else {
                            TOKENS[b] = new Token((byte) b, Type.ALPHA);
                            break;
                        }
                    } else {
                        TOKENS[b] = new Token((byte) b, Type.DIGIT);
                        break;
                    }
                    break;
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpTokens$Token.class */
    public static class Token {
        private final Type _type;

        /* renamed from: _b */
        private final byte f3139_b;

        /* renamed from: _c */
        private final char f3140_c;

        /* renamed from: _x */
        private final int f3141_x;

        private Token(byte b, Type type) {
            this._type = type;
            this.f3139_b = b;
            this.f3140_c = (char) (255 & b);
            char lc = (this.f3140_c >= 'A') & (this.f3140_c <= 'Z') ? (char) ((this.f3140_c - 'A') + 97) : this.f3140_c;
            this.f3141_x = (this._type == Type.DIGIT || (this._type == Type.ALPHA && lc >= 'a' && lc <= 'f')) ? TypeUtil.convertHexDigit(b) : -1;
        }

        public Type getType() {
            return this._type;
        }

        public byte getByte() {
            return this.f3139_b;
        }

        public char getChar() {
            return this.f3140_c;
        }

        public boolean isHexDigit() {
            return this.f3141_x >= 0;
        }

        public int getHexDigit() {
            return this.f3141_x;
        }

        public String toString() {
            switch (this._type) {
                case SPACE:
                case COLON:
                case ALPHA:
                case DIGIT:
                case TCHAR:
                case VCHAR:
                    return this._type + "='" + this.f3140_c + "'";
                case CR:
                    return "CR=\\r";
                case LF:
                    return "LF=\\n";
                default:
                    return String.format("%s=0x%x", this._type, Byte.valueOf(this.f3139_b));
            }
        }
    }
}
