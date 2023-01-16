package org.bson.json;

import org.bson.BsonDouble;
import org.bson.types.Decimal128;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonToken.class */
public class JsonToken {
    private final Object value;
    private final JsonTokenType type;

    /* access modifiers changed from: package-private */
    public JsonToken(JsonTokenType type, Object value) {
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return this.value;
    }

    public <T> T getValue(Class<T> clazz) {
        try {
            if (Long.class == clazz) {
                if (this.value instanceof Integer) {
                    return clazz.cast(Long.valueOf(((Integer) this.value).longValue()));
                }
                if (this.value instanceof String) {
                    return clazz.cast(Long.valueOf((String) this.value));
                }
            } else if (Integer.class == clazz) {
                if (this.value instanceof String) {
                    return clazz.cast(Integer.valueOf((String) this.value));
                }
            } else if (Double.class == clazz) {
                if (this.value instanceof String) {
                    return clazz.cast(Double.valueOf((String) this.value));
                }
            } else if (Decimal128.class == clazz) {
                if (this.value instanceof Integer) {
                    return clazz.cast(new Decimal128((long) ((Integer) this.value).intValue()));
                }
                if (this.value instanceof Long) {
                    return clazz.cast(new Decimal128(((Long) this.value).longValue()));
                }
                if (this.value instanceof Double) {
                    return clazz.cast(new BsonDouble(((Double) this.value).doubleValue()).decimal128Value());
                }
                if (this.value instanceof String) {
                    return clazz.cast(Decimal128.parse((String) this.value));
                }
            }
            return clazz.cast(this.value);
        } catch (Exception e) {
            throw new JsonParseException(String.format("Exception converting value '%s' to type %s", this.value, clazz.getName()), e);
        }
    }

    public JsonTokenType getType() {
        return this.type;
    }
}
