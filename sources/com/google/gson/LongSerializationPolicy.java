package com.google.gson;

/* loaded from: grasscutter.jar:com/google/gson/LongSerializationPolicy.class */
public enum LongSerializationPolicy {
    DEFAULT {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long value) {
            if (value == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(value);
        }
    },
    STRING {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long value) {
            if (value == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(value.toString());
        }
    };

    public abstract JsonElement serialize(Long l);
}
