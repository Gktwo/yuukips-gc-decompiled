package com.mongodb.internal.operation;

import org.bson.BsonDocument;
import org.bson.BsonInt32;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/CursorHelper.class */
public final class CursorHelper {
    /* access modifiers changed from: package-private */
    public static int getNumberToReturn(int limit, int batchSize, int numReturnedSoFar) {
        int numberToReturn;
        if (Math.abs(limit) != 0) {
            numberToReturn = Math.abs(limit) - numReturnedSoFar;
            if (batchSize != 0 && numberToReturn > Math.abs(batchSize)) {
                numberToReturn = batchSize;
            }
        } else {
            numberToReturn = batchSize;
        }
        return numberToReturn;
    }

    /* access modifiers changed from: package-private */
    public static BsonDocument getCursorDocumentFromBatchSize(Integer batchSize) {
        return batchSize == null ? new BsonDocument() : new BsonDocument("batchSize", new BsonInt32(batchSize.intValue()));
    }

    private CursorHelper() {
    }
}
