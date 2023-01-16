package com.mongodb.internal.operation;

import com.mongodb.assertions.Assertions;
import com.mongodb.internal.connection.ReadConcernHelper;
import com.mongodb.internal.session.SessionContext;
import org.bson.BsonDocument;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationReadConcernHelper.class */
public final class OperationReadConcernHelper {
    /* access modifiers changed from: package-private */
    public static void appendReadConcernToCommand(SessionContext sessionContext, BsonDocument commandDocument) {
        Assertions.notNull("commandDocument", commandDocument);
        Assertions.notNull("sessionContext", sessionContext);
        if (!sessionContext.hasActiveTransaction()) {
            BsonDocument readConcernDocument = ReadConcernHelper.getReadConcernDocument(sessionContext);
            if (!readConcernDocument.isEmpty()) {
                commandDocument.append("readConcern", readConcernDocument);
            }
        }
    }

    private OperationReadConcernHelper() {
    }
}
