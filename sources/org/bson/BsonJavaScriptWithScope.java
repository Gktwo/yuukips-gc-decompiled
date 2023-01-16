package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonJavaScriptWithScope.class */
public class BsonJavaScriptWithScope extends BsonValue {
    private final String code;
    private final BsonDocument scope;

    public BsonJavaScriptWithScope(String code, BsonDocument scope) {
        if (code == null) {
            throw new IllegalArgumentException("code can not be null");
        } else if (scope == null) {
            throw new IllegalArgumentException("scope can not be null");
        } else {
            this.code = code;
            this.scope = scope;
        }
    }

    @Override // org.bson.BsonValue
    public BsonType getBsonType() {
        return BsonType.JAVASCRIPT_WITH_SCOPE;
    }

    public String getCode() {
        return this.code;
    }

    public BsonDocument getScope() {
        return this.scope;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BsonJavaScriptWithScope that = (BsonJavaScriptWithScope) o;
        if (this.code.equals(that.code) && this.scope.equals(that.scope)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.code.hashCode()) + this.scope.hashCode();
    }

    public String toString() {
        return "BsonJavaScriptWithScope{code=" + getCode() + "scope=" + this.scope + '}';
    }

    /* access modifiers changed from: package-private */
    public static BsonJavaScriptWithScope clone(BsonJavaScriptWithScope from) {
        return new BsonJavaScriptWithScope(from.code, from.scope.clone());
    }
}
