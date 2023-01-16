package com.mongodb.internal.operation;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoCursorNotFoundException;
import com.mongodb.MongoQueryException;
import com.mongodb.ServerCursor;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/QueryHelper.class */
public final class QueryHelper {
    /* access modifiers changed from: package-private */
    public static MongoQueryException translateCommandException(MongoCommandException commandException, ServerCursor cursor) {
        if (commandException.getErrorCode() == 43) {
            return new MongoCursorNotFoundException(cursor.getId(), cursor.getAddress());
        }
        return new MongoQueryException(commandException);
    }

    private QueryHelper() {
    }
}
