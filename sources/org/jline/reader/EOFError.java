package org.jline.reader;

/* loaded from: grasscutter.jar:org/jline/reader/EOFError.class */
public class EOFError extends SyntaxError {
    private static final long serialVersionUID = 1;
    private final String missing;
    private final int openBrackets;
    private final String nextClosingBracket;

    public EOFError(int line, int column, String message) {
        this(line, column, message, null);
    }

    public EOFError(int line, int column, String message, String missing) {
        this(line, column, message, missing, 0, null);
    }

    public EOFError(int line, int column, String message, String missing, int openBrackets, String nextClosingBracket) {
        super(line, column, message);
        this.missing = missing;
        this.openBrackets = openBrackets;
        this.nextClosingBracket = nextClosingBracket;
    }

    public String getMissing() {
        return this.missing;
    }

    public int getOpenBrackets() {
        return this.openBrackets;
    }

    public String getNextClosingBracket() {
        return this.nextClosingBracket;
    }
}
