package org.luaj.vm2.parser;

import java.io.Serializable;

/* loaded from: grasscutter.jar:org/luaj/vm2/parser/Token.class */
public class Token implements Serializable {
    private static final long serialVersionUID = 1;
    public int kind;
    public int beginLine;
    public int beginColumn;
    public int endLine;
    public int endColumn;
    public String image;
    public Token next;
    public Token specialToken;

    public Object getValue() {
        return null;
    }

    public Token() {
    }

    public Token(int i) {
        this(i, null);
    }

    public Token(int i, String str) {
        this.kind = i;
        this.image = str;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.image;
    }

    public static Token newToken(int i, String str) {
        switch (i) {
            default:
                return new Token(i, str);
        }
    }

    public static Token newToken(int i) {
        return newToken(i, null);
    }
}
