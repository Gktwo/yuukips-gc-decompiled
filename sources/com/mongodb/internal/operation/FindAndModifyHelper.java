package com.mongodb.internal.operation;

import com.mongodb.MongoWriteConcernException;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcernResult;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.CommandOperationHelper;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/FindAndModifyHelper.class */
public final class FindAndModifyHelper {
    /* access modifiers changed from: package-private */
    public static <T> CommandOperationHelper.CommandWriteTransformer<BsonDocument, T> transformer() {
        return new CommandOperationHelper.CommandWriteTransformer<BsonDocument, T>() { // from class: com.mongodb.internal.operation.FindAndModifyHelper.1
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            public T apply(BsonDocument result, Connection connection) {
                return FindAndModifyHelper.transformDocument(result, connection.getDescription().getServerAddress());
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static <T> CommandOperationHelper.CommandWriteTransformerAsync<BsonDocument, T> asyncTransformer() {
        return new CommandOperationHelper.CommandWriteTransformerAsync<BsonDocument, T>() { // from class: com.mongodb.internal.operation.FindAndModifyHelper.2
            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            public T apply(BsonDocument result, AsyncConnection connection) {
                return FindAndModifyHelper.transformDocument(result, connection.getDescription().getServerAddress());
            }
        };
    }

    /* access modifiers changed from: private */
    public static <T> T transformDocument(BsonDocument result, ServerAddress serverAddress) {
        if (WriteConcernHelper.hasWriteConcernError(result)) {
            throw new MongoWriteConcernException(WriteConcernHelper.createWriteConcernError(result.getDocument("writeConcernError")), createWriteConcernResult(result.getDocument("lastErrorObject", new BsonDocument())), serverAddress);
        } else if (!result.isDocument("value")) {
            return null;
        } else {
            return (T) BsonDocumentWrapperHelper.toDocument(result.getDocument("value", null));
        }
    }

    private static WriteConcernResult createWriteConcernResult(BsonDocument result) {
        return WriteConcernResult.acknowledged(result.getNumber("n", new BsonInt32(0)).intValue(), result.getBoolean("updatedExisting", BsonBoolean.FALSE).getValue(), result.get("upserted"));
    }

    private FindAndModifyHelper() {
    }
}
