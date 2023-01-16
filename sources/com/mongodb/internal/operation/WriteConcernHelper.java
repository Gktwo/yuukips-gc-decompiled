package com.mongodb.internal.operation;

import com.mongodb.MongoException;
import com.mongodb.MongoWriteConcernException;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.WriteConcernResult;
import com.mongodb.bulk.WriteConcernError;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.connection.ProtocolHelper;
import java.util.Set;
import java.util.stream.Collectors;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/WriteConcernHelper.class */
public final class WriteConcernHelper {
    public static void appendWriteConcernToCommand(WriteConcern writeConcern, BsonDocument commandDocument, ConnectionDescription description) {
        if (writeConcern != null && !writeConcern.isServerDefault() && ServerVersionHelper.serverIsAtLeastVersionThreeDotFour(description)) {
            commandDocument.put("writeConcern", (BsonValue) writeConcern.asDocument());
        }
    }

    public static void throwOnWriteConcernError(BsonDocument result, ServerAddress serverAddress, int maxWireVersion) {
        if (hasWriteConcernError(result)) {
            MongoException exception = ProtocolHelper.createSpecialException(result, serverAddress, "errmsg");
            if (exception == null) {
                exception = createWriteConcernException(result, serverAddress);
            }
            CommandOperationHelper.addRetryableWriteErrorLabel(exception, maxWireVersion);
            throw exception;
        }
    }

    public static boolean hasWriteConcernError(BsonDocument result) {
        return result.containsKey("writeConcernError");
    }

    public static MongoWriteConcernException createWriteConcernException(BsonDocument result, ServerAddress serverAddress) {
        return new MongoWriteConcernException(createWriteConcernError(result.getDocument("writeConcernError")), WriteConcernResult.acknowledged(0, false, null), serverAddress);
    }

    public static WriteConcernError createWriteConcernError(BsonDocument writeConcernErrorDocument) {
        return new WriteConcernError(writeConcernErrorDocument.getNumber("code").intValue(), writeConcernErrorDocument.getString("codeName", new BsonString("")).getValue(), writeConcernErrorDocument.getString("errmsg").getValue(), writeConcernErrorDocument.getDocument("errInfo", new BsonDocument()), (Set) writeConcernErrorDocument.getArray("errorLabels", new BsonArray()).stream().map(i -> {
            return i.asString().getValue();
        }).collect(Collectors.toSet()));
    }

    private WriteConcernHelper() {
    }
}
