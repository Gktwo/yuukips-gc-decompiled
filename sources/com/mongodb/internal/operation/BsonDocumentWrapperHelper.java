package com.mongodb.internal.operation;

import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/BsonDocumentWrapperHelper.class */
public final class BsonDocumentWrapperHelper {
    /* access modifiers changed from: package-private */
    public static <T> List<T> toList(BsonDocument result, String fieldContainingWrappedArray) {
        return ((BsonArrayWrapper) result.getArray(fieldContainingWrappedArray)).getWrappedArray();
    }

    /* access modifiers changed from: package-private */
    public static <T> T toDocument(BsonDocument document) {
        if (document == null) {
            return null;
        }
        return (T) ((BsonDocumentWrapper) document).getWrappedDocument();
    }

    private BsonDocumentWrapperHelper() {
    }
}
