package org.luaj.vm2.parser;

import dev.morphia.mapping.Mapper;

/* loaded from: grasscutter.jar:org/luaj/vm2/parser/ParseException.class */
public class ParseException extends Exception {
    private static final long serialVersionUID = 1;
    public Token currentToken;
    public int[][] expectedTokenSequences;
    public String[] tokenImage;
    protected String eol = System.getProperty("line.separator", "\n");

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        super(initialise(token, iArr, strArr));
        this.currentToken = token;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
    }

    public ParseException() {
    }

    public ParseException(String str) {
        super(str);
    }

    private static String initialise(Token token, int[][] iArr, String[] strArr) {
        String property = System.getProperty("line.separator", "\n");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i < iArr[i2].length) {
                i = iArr[i2].length;
            }
            for (int i3 = 0; i3 < iArr[i2].length; i3++) {
                stringBuffer.append(strArr[iArr[i2][i3]]).append(' ');
            }
            if (iArr[i2][iArr[i2].length - 1] != 0) {
                stringBuffer.append("...");
            }
            stringBuffer.append(property).append("    ");
        }
        String str = "Encountered \"";
        Token token2 = token.next;
        int i4 = 0;
        while (true) {
            if (i4 >= i) {
                break;
            }
            if (i4 != 0) {
                str = new StringBuffer().append(str).append(" ").toString();
            }
            if (token2.kind == 0) {
                str = new StringBuffer().append(str).append(strArr[0]).toString();
                break;
            }
            str = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append(" ").append(strArr[token2.kind]).toString()).append(" \"").toString()).append(add_escapes(token2.image)).toString()).append(" \"").toString();
            token2 = token2.next;
            i4++;
        }
        String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(str).append("\" at line ").append(token.next.beginLine).append(", column ").append(token.next.beginColumn).toString()).append(Mapper.IGNORED_FIELDNAME).append(property).toString();
        return new StringBuffer().append(iArr.length == 1 ? new StringBuffer().append(stringBuffer2).append("Was expecting:").append(property).append("    ").toString() : new StringBuffer().append(stringBuffer2).append("Was expecting one of:").append(property).append("    ").toString()).append(stringBuffer.toString()).toString();
    }

    static String add_escapes(String str) {
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
}
