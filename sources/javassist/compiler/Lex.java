package javassist.compiler;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import org.eclipse.jetty.client.ContinueProtocolHandler;

/* loaded from: grasscutter.jar:javassist/compiler/Lex.class */
public class Lex implements TokenId {
    private String input;
    private int maxlen;
    private static final int[] equalOps = {350, 0, 0, 0, TokenId.MOD_E, 352, 0, 0, 0, 353, 354, 0, TokenId.MINUS_E, 0, 356, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 357, TokenId.f3079EQ, TokenId.f3080GE, 0};
    private static final KeywordTable ktable = new KeywordTable();
    private int lastChar = -1;
    private StringBuffer textBuffer = new StringBuffer();
    private Token currentToken = new Token();
    private Token lookAheadTokens = null;
    private int position = 0;
    private int lineNumber = 0;

    public Lex(String s) {
        this.input = s;
        this.maxlen = s.length();
    }

    public int get() {
        if (this.lookAheadTokens == null) {
            return get(this.currentToken);
        }
        Token t = this.lookAheadTokens;
        this.currentToken = t;
        this.lookAheadTokens = this.lookAheadTokens.next;
        return t.tokenId;
    }

    public int lookAhead() {
        return lookAhead(0);
    }

    public int lookAhead(int i) {
        Token tk = this.lookAheadTokens;
        if (tk == null) {
            Token token = this.currentToken;
            tk = token;
            this.lookAheadTokens = token;
            tk.next = null;
            get(tk);
        }
        while (true) {
            i--;
            if (i > 0) {
                if (tk.next == null) {
                    Token tk2 = new Token();
                    tk.next = tk2;
                    get(tk2);
                }
                tk = tk.next;
            } else {
                this.currentToken = tk;
                return tk.tokenId;
            }
        }
    }

    public String getString() {
        return this.currentToken.textValue;
    }

    public long getLong() {
        return this.currentToken.longValue;
    }

    public double getDouble() {
        return this.currentToken.doubleValue;
    }

    private int get(Token token) {
        int t;
        do {
            t = readLine(token);
        } while (t == 10);
        token.tokenId = t;
        return t;
    }

    private int readLine(Token token) {
        int c = getNextNonWhiteChar();
        if (c < 0) {
            return c;
        }
        if (c == 10) {
            this.lineNumber++;
            return 10;
        } else if (c == 39) {
            return readCharConst(token);
        } else {
            if (c == 34) {
                return readStringL(token);
            }
            if (48 <= c && c <= 57) {
                return readNumber(c, token);
            }
            if (c == 46) {
                int c2 = getc();
                if (48 > c2 || c2 > 57) {
                    ungetc(c2);
                    return readSeparator(46);
                }
                StringBuffer tbuf = this.textBuffer;
                tbuf.setLength(0);
                tbuf.append('.');
                return readDouble(tbuf, c2, token);
            } else if (Character.isJavaIdentifierStart((char) c)) {
                return readIdentifier(c, token);
            } else {
                return readSeparator(c);
            }
        }
    }

    private int getNextNonWhiteChar() {
        int c;
        do {
            c = getc();
            if (c == 47) {
                int c2 = getc();
                if (c2 == 47) {
                    do {
                        c = getc();
                        if (c == 10 || c == 13) {
                            break;
                        }
                    } while (c != -1);
                } else if (c2 == 42) {
                    while (true) {
                        c = getc();
                        if (c == -1) {
                            break;
                        } else if (c == 42) {
                            int c3 = getc();
                            if (c3 == 47) {
                                c = 32;
                                break;
                            }
                            ungetc(c3);
                        }
                    }
                } else {
                    ungetc(c2);
                    c = 47;
                }
            }
        } while (isBlank(c));
        return c;
    }

    private int readCharConst(Token token) {
        int value = 0;
        while (true) {
            int c = getc();
            if (c == 39) {
                token.longValue = (long) value;
                return 401;
            } else if (c == 92) {
                value = readEscapeChar();
            } else if (c >= 32) {
                value = c;
            } else if (c != 10) {
                return 500;
            } else {
                this.lineNumber++;
                return 500;
            }
        }
    }

    private int readEscapeChar() {
        int c = getc();
        if (c == 110) {
            c = 10;
        } else if (c == 116) {
            c = 9;
        } else if (c == 114) {
            c = 13;
        } else if (c == 102) {
            c = 12;
        } else if (c == 10) {
            this.lineNumber++;
        }
        return c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r4.lineNumber++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        return 500;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readStringL(javassist.compiler.Token r5) {
        /*
            r4 = this;
            r0 = r4
            java.lang.StringBuffer r0 = r0.textBuffer
            r7 = r0
            r0 = r7
            r1 = 0
            r0.setLength(r1)
        L_0x000a:
            r0 = r4
            int r0 = r0.getc()
            r1 = r0
            r6 = r1
            r1 = 34
            if (r0 == r1) goto L_0x0045
            r0 = r6
            r1 = 92
            if (r0 != r1) goto L_0x0023
            r0 = r4
            int r0 = r0.readEscapeChar()
            r6 = r0
            goto L_0x003b
        L_0x0023:
            r0 = r6
            r1 = 10
            if (r0 == r1) goto L_0x002d
            r0 = r6
            if (r0 >= 0) goto L_0x003b
        L_0x002d:
            r0 = r4
            r1 = r0
            int r1 = r1.lineNumber
            r2 = 1
            int r1 = r1 + r2
            r0.lineNumber = r1
            r0 = 500(0x1f4, float:7.0E-43)
            return r0
        L_0x003b:
            r0 = r7
            r1 = r6
            char r1 = (char) r1
            java.lang.StringBuffer r0 = r0.append(r1)
            goto L_0x000a
        L_0x0045:
            r0 = r4
            int r0 = r0.getc()
            r6 = r0
            r0 = r6
            r1 = 10
            if (r0 != r1) goto L_0x005d
            r0 = r4
            r1 = r0
            int r1 = r1.lineNumber
            r2 = 1
            int r1 = r1 + r2
            r0.lineNumber = r1
            goto L_0x0045
        L_0x005d:
            r0 = r6
            boolean r0 = isBlank(r0)
            if (r0 != 0) goto L_0x0045
            goto L_0x0067
        L_0x0067:
            r0 = r6
            r1 = 34
            if (r0 == r1) goto L_0x000a
            r0 = r4
            r1 = r6
            r0.ungetc(r1)
            goto L_0x0075
        L_0x0075:
            r0 = r5
            r1 = r7
            java.lang.String r1 = r1.toString()
            r0.textValue = r1
            r0 = 406(0x196, float:5.69E-43)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.compiler.Lex.readStringL(javassist.compiler.Token):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x001c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x001c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v4, types: [long] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [long] */
    /* JADX WARN: Type inference failed for: r8v7, types: [long] */
    /* JADX WARN: Type inference failed for: r8v8, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readNumber(int r6, javassist.compiler.Token r7) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.compiler.Lex.readNumber(int, javassist.compiler.Token):int");
    }

    private int readDouble(StringBuffer sbuf, int c, Token token) {
        if (c != 69 && c != 101 && c != 68 && c != 100) {
            sbuf.append((char) c);
            while (true) {
                c = getc();
                if (48 > c || c > 57) {
                    break;
                }
                sbuf.append((char) c);
            }
        }
        if (c == 69 || c == 101) {
            sbuf.append((char) c);
            c = getc();
            if (c == 43 || c == 45) {
                sbuf.append((char) c);
                c = getc();
            }
            while (48 <= c && c <= 57) {
                sbuf.append((char) c);
                c = getc();
            }
        }
        try {
            token.doubleValue = Double.parseDouble(sbuf.toString());
            if (c == 70 || c == 102) {
                return 404;
            }
            if (c == 68 || c == 100) {
                return 405;
            }
            ungetc(c);
            return 405;
        } catch (NumberFormatException e) {
            return 500;
        }
    }

    static {
        ktable.append("abstract", 300);
        ktable.append("boolean", 301);
        ktable.append("break", 302);
        ktable.append("byte", 303);
        ktable.append("case", 304);
        ktable.append("catch", 305);
        ktable.append("char", TokenId.CHAR);
        ktable.append("class", 307);
        ktable.append("const", 308);
        ktable.append(ContinueProtocolHandler.NAME, 309);
        ktable.append("default", TokenId.DEFAULT);
        ktable.append("do", 311);
        ktable.append("double", TokenId.DOUBLE);
        ktable.append("else", TokenId.ELSE);
        ktable.append("extends", 314);
        ktable.append("false", 411);
        ktable.append("final", 315);
        ktable.append("finally", 316);
        ktable.append("float", 317);
        ktable.append("for", TokenId.FOR);
        ktable.append("goto", 319);
        ktable.append("if", 320);
        ktable.append("implements", 321);
        ktable.append("import", 322);
        ktable.append("instanceof", 323);
        ktable.append("int", 324);
        ktable.append("interface", 325);
        ktable.append("long", TokenId.LONG);
        ktable.append("native", 327);
        ktable.append("new", TokenId.NEW);
        ktable.append("null", 412);
        ktable.append("package", TokenId.PACKAGE);
        ktable.append("private", 330);
        ktable.append("protected", TokenId.PROTECTED);
        ktable.append("public", TokenId.PUBLIC);
        ktable.append("return", 333);
        ktable.append("short", 334);
        ktable.append("static", TokenId.STATIC);
        ktable.append("strictfp", 347);
        ktable.append("super", TokenId.SUPER);
        ktable.append("switch", TokenId.SWITCH);
        ktable.append("synchronized", TokenId.SYNCHRONIZED);
        ktable.append("this", 339);
        ktable.append("throw", TokenId.THROW);
        ktable.append("throws", 341);
        ktable.append("transient", TokenId.TRANSIENT);
        ktable.append(C3P0Substitutions.DEBUG, 410);
        ktable.append("try", 343);
        ktable.append("void", 344);
        ktable.append("volatile", TokenId.VOLATILE);
        ktable.append("while", 346);
    }

    private int readSeparator(int c) {
        int c2;
        if (33 <= c && c <= 63) {
            int t = equalOps[c - 33];
            if (t == 0) {
                return c;
            }
            c2 = getc();
            if (c == c2) {
                switch (c) {
                    case 38:
                        return TokenId.ANDAND;
                    case 43:
                        return TokenId.PLUSPLUS;
                    case 45:
                        return 363;
                    case 60:
                        int c3 = getc();
                        if (c3 == 61) {
                            return TokenId.LSHIFT_E;
                        }
                        ungetc(c3);
                        return 364;
                    case 61:
                        return TokenId.f3079EQ;
                    case 62:
                        int c32 = getc();
                        if (c32 == 61) {
                            return TokenId.RSHIFT_E;
                        }
                        if (c32 == 62) {
                            int c33 = getc();
                            if (c33 == 61) {
                                return TokenId.ARSHIFT_E;
                            }
                            ungetc(c33);
                            return 370;
                        }
                        ungetc(c32);
                        return 366;
                }
            } else if (c2 == 61) {
                return t;
            }
        } else if (c == 94) {
            c2 = getc();
            if (c2 == 61) {
                return 360;
            }
        } else if (c != 124) {
            return c;
        } else {
            c2 = getc();
            if (c2 == 61) {
                return 361;
            }
            if (c2 == 124) {
                return TokenId.OROR;
            }
        }
        ungetc(c2);
        return c;
    }

    private int readIdentifier(int c, Token token) {
        StringBuffer tbuf = this.textBuffer;
        tbuf.setLength(0);
        do {
            tbuf.append((char) c);
            c = getc();
        } while (Character.isJavaIdentifierPart((char) c));
        ungetc(c);
        String name = tbuf.toString();
        int t = ktable.lookup(name);
        if (t >= 0) {
            return t;
        }
        token.textValue = name;
        return 400;
    }

    private static boolean isBlank(int c) {
        return c == 32 || c == 9 || c == 12 || c == 13 || c == 10;
    }

    private static boolean isDigit(int c) {
        return 48 <= c && c <= 57;
    }

    private void ungetc(int c) {
        this.lastChar = c;
    }

    public String getTextAround() {
        int begin = this.position - 10;
        if (begin < 0) {
            begin = 0;
        }
        int end = this.position + 10;
        if (end > this.maxlen) {
            end = this.maxlen;
        }
        return this.input.substring(begin, end);
    }

    private int getc() {
        if (this.lastChar >= 0) {
            int c = this.lastChar;
            this.lastChar = -1;
            return c;
        } else if (this.position >= this.maxlen) {
            return -1;
        } else {
            String str = this.input;
            int i = this.position;
            this.position = i + 1;
            return str.charAt(i);
        }
    }
}
