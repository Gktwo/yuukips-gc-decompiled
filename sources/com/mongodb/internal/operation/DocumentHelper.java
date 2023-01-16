package com.mongodb.internal.operation;

import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonValue;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/DocumentHelper.class */
public final class DocumentHelper {
    private DocumentHelper() {
    }

    /* access modifiers changed from: package-private */
    public static void putIfTrue(BsonDocument command, String key, boolean condition) {
        if (condition) {
            command.put(key, (BsonValue) BsonBoolean.TRUE);
        }
    }

    /* access modifiers changed from: package-private */
    public static void putIfFalse(BsonDocument command, String key, boolean condition) {
        if (!condition) {
            command.put(key, (BsonValue) BsonBoolean.FALSE);
        }
    }

    /* access modifiers changed from: package-private */
    public static void putIfNotNullOrEmpty(BsonDocument command, String key, BsonDocument documentValue) {
        if (documentValue != null && !documentValue.isEmpty()) {
            command.put(key, (BsonValue) documentValue);
        }
    }

    /* access modifiers changed from: package-private */
    public static void putIfNotNull(BsonDocument command, String key, BsonValue value) {
        if (value != null) {
            command.put(key, value);
        }
    }

    /* access modifiers changed from: package-private */
    public static void putIfNotZero(BsonDocument command, String key, int value) {
        if (value != 0) {
            command.put(key, (BsonValue) new BsonInt32(value));
        }
    }

    /* access modifiers changed from: package-private */
    public static void putIfNotZero(BsonDocument command, String key, long value) {
        if (value != 0) {
            command.put(key, (BsonValue) new BsonInt64(value));
        }
    }
}
