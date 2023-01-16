package org.luaj.vm2.parser;

/* loaded from: grasscutter.jar:org/luaj/vm2/parser/TokenMgrError.class */
public class TokenMgrError extends Error {
    private static final long serialVersionUID = 1;
    static final int LEXICAL_ERROR = 0;
    static final int STATIC_LEXER_ERROR = 1;
    static final int INVALID_LEXICAL_STATE = 2;
    static final int LOOP_DETECTED = 3;
    int errorCode;

    protected static final String addEscapes(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 0:
                    break;
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case '\"':
                    stringBuffer.append("\\\"");
                    break;
                case '\'':
                    stringBuffer.append("\\'");
                    break;
                case '\\':
                    stringBuffer.append("\\\\");
                    break;
                default:
                    char charAt = str.charAt(i);
                    if (charAt < ' ' || charAt > '~') {
                        String stringBuffer2 = new StringBuffer().append("0000").append(Integer.toString(charAt, 16)).toString();
                        stringBuffer.append(new StringBuffer().append("\\u").append(stringBuffer2.substring(stringBuffer2.length() - 4, stringBuffer2.length())).toString());
                        break;
                    } else {
                        stringBuffer.append(charAt);
                        break;
                    }
                    break;
            }
        }
        return stringBuffer.toString();
    }

    protected static String LexicalError(boolean z, int i, int i2, int i3, String str, char c) {
        return new StringBuffer().append("Lexical error at line ").append(i2).append(", column ").append(i3).append(".  Encountered: ").append(z ? "<EOF> " : new StringBuffer().append("\"").append(addEscapes(String.valueOf(c))).append("\"").append(" (").append((int) c).append("), ").toString()).append("after : \"").append(addEscapes(str)).append("\"").toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getMessage();
    }

    public TokenMgrError() {
    }

    public TokenMgrError(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public TokenMgrError(boolean z, int i, int i2, int i3, String str, char c, int i4) {
        this(LexicalError(z, i, i2, i3, str, c), i4);
    }
}
