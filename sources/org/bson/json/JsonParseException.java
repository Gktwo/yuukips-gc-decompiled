package org.bson.json;

/* loaded from: grasscutter.jar:org/bson/json/JsonParseException.class */
public class JsonParseException extends RuntimeException {
    private static final long serialVersionUID = -6722022620020198727L;

    public JsonParseException() {
    }

    public JsonParseException(String s) {
        super(s);
    }

    public JsonParseException(String pattern, Object... args) {
        super(String.format(pattern, args));
    }

    public JsonParseException(String s, Throwable t) {
        super(s, t);
    }

    public JsonParseException(Throwable t) {
        super(t);
    }
}
