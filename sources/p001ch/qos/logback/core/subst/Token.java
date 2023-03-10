package p001ch.qos.logback.core.subst;

/* renamed from: ch.qos.logback.core.subst.Token */
/* loaded from: grasscutter.jar:ch/qos/logback/core/subst/Token.class */
public class Token {
    public static final Token START_TOKEN = new Token(Type.START, null);
    public static final Token CURLY_LEFT_TOKEN = new Token(Type.CURLY_LEFT, null);
    public static final Token CURLY_RIGHT_TOKEN = new Token(Type.CURLY_RIGHT, null);
    public static final Token DEFAULT_SEP_TOKEN = new Token(Type.DEFAULT, null);
    Type type;
    String payload;

    /* renamed from: ch.qos.logback.core.subst.Token$Type */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/subst/Token$Type.class */
    public enum Type {
        LITERAL,
        START,
        CURLY_LEFT,
        CURLY_RIGHT,
        DEFAULT
    }

    public Token(Type type, String payload) {
        this.type = type;
        this.payload = payload;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Token token = (Token) o;
        if (this.type != token.type) {
            return false;
        }
        if (this.payload != null) {
            if (!this.payload.equals(token.payload)) {
                return false;
            }
            return true;
        } else if (token.payload != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * (this.type != null ? this.type.hashCode() : 0)) + (this.payload != null ? this.payload.hashCode() : 0);
    }

    public String toString() {
        String result = "Token{type=" + this.type;
        if (this.payload != null) {
            result = result + ", payload='" + this.payload + '\'';
        }
        return result + '}';
    }
}
