package nonapi.p019io.github.classgraph.types;

import nonapi.p019io.github.classgraph.json.JSONUtils;

/* renamed from: nonapi.io.github.classgraph.types.Parser */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/types/Parser.class */
public class Parser {
    private final String string;
    private int position;
    private final StringBuilder token = new StringBuilder();
    private Object state;
    private static final int SHOW_BEFORE = 80;
    private static final int SHOW_AFTER = 80;

    public Parser(String string) throws ParseException {
        if (string == null) {
            throw new ParseException(null, "Cannot parse null string");
        }
        this.string = string;
    }

    public String getPositionInfo() {
        return "before: \"" + JSONUtils.escapeJSONString(this.string.substring(Math.max(0, this.position - 80), this.position)) + "\"; after: \"" + JSONUtils.escapeJSONString(this.string.substring(this.position, Math.min(this.string.length(), this.position + 80))) + "\"; position: " + this.position + "; token: \"" + ((Object) this.token) + "\"";
    }

    public Object setState(Object state) {
        Object oldState = this.state;
        this.state = state;
        return oldState;
    }

    public Object getState() {
        return this.state;
    }

    public char getc() throws ParseException {
        if (this.position >= this.string.length()) {
            throw new ParseException(this, "Ran out of input while parsing");
        }
        String str = this.string;
        int i = this.position;
        this.position = i + 1;
        return str.charAt(i);
    }

    public void expect(char expectedChar) throws ParseException {
        int next = getc();
        if (next != expectedChar) {
            throw new ParseException(this, "Expected '" + expectedChar + "'; got '" + ((char) next) + "'");
        }
    }

    public char peek() {
        if (this.position == this.string.length()) {
            return 0;
        }
        return this.string.charAt(this.position);
    }

    public void peekExpect(char expectedChar) throws ParseException {
        if (this.position == this.string.length()) {
            throw new ParseException(this, "Expected '" + expectedChar + "'; reached end of string");
        }
        char next = this.string.charAt(this.position);
        if (next != expectedChar) {
            throw new ParseException(this, "Expected '" + expectedChar + "'; got '" + next + "'");
        }
    }

    public boolean peekMatches(String strMatch) {
        return this.string.regionMatches(this.position, strMatch, 0, strMatch.length());
    }

    public void next() {
        this.position++;
    }

    public void advance(int numChars) {
        if (this.position + numChars >= this.string.length()) {
            throw new IllegalArgumentException("Invalid skip distance");
        }
        this.position += numChars;
    }

    public boolean hasMore() {
        return this.position < this.string.length();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        if (position < 0 || position >= this.string.length()) {
            throw new IllegalArgumentException("Invalid position");
        }
        this.position = position;
    }

    public CharSequence getSubsequence(int startPosition, int endPosition) {
        return this.string.subSequence(startPosition, endPosition);
    }

    public String getSubstring(int startPosition, int endPosition) {
        return this.string.substring(startPosition, endPosition);
    }

    public void appendToToken(String str) {
        this.token.append(str);
    }

    public void appendToToken(char c) {
        this.token.append(c);
    }

    public void skipWhitespace() {
        while (this.position < this.string.length()) {
            char c = this.string.charAt(this.position);
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t') {
                this.position++;
            } else {
                return;
            }
        }
    }

    public String currToken() {
        String tok = this.token.toString();
        this.token.setLength(0);
        return tok;
    }

    public String toString() {
        return getPositionInfo();
    }
}
