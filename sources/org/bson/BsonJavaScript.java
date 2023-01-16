package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonJavaScript.class */
public class BsonJavaScript extends BsonValue {
    private final String code;

    public BsonJavaScript(String code) {
        this.code = code;
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.JAVASCRIPT;
    }

    public String getCode() {
        return this.code;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.code.equals(((BsonJavaScript) o).code)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public String toString() {
        return "BsonJavaScript{code='" + this.code + "'}";
    }
}
