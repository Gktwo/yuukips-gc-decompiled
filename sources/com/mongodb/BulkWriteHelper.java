package com.mongodb;

import com.mongodb.bulk.BulkWriteError;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.bulk.BulkWriteUpsert;
import com.mongodb.bulk.WriteConcernError;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonDocumentReader;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/BulkWriteHelper.class */
public final class BulkWriteHelper {
    /* access modifiers changed from: package-private */
    public static BulkWriteResult translateBulkWriteResult(BulkWriteResult bulkWriteResult, Decoder<DBObject> decoder) {
        if (bulkWriteResult.wasAcknowledged()) {
            return new AcknowledgedBulkWriteResult(bulkWriteResult.getInsertedCount(), bulkWriteResult.getMatchedCount(), bulkWriteResult.getDeletedCount(), Integer.valueOf(bulkWriteResult.getModifiedCount()), translateBulkWriteUpserts(bulkWriteResult.getUpserts(), decoder));
        }
        return new UnacknowledgedBulkWriteResult();
    }

    static List<BulkWriteUpsert> translateBulkWriteUpserts(List<BulkWriteUpsert> upserts, Decoder<DBObject> decoder) {
        List<BulkWriteUpsert> retVal = new ArrayList<>(upserts.size());
        for (BulkWriteUpsert cur : upserts) {
            retVal.add(new BulkWriteUpsert(cur.getIndex(), getUpsertedId(cur, decoder)));
        }
        return retVal;
    }

    private static Object getUpsertedId(BulkWriteUpsert cur, Decoder<DBObject> decoder) {
        return decoder.decode(new BsonDocumentReader(new BsonDocument(DBCollection.ID_FIELD_NAME, cur.getId())), DecoderContext.builder().build()).get(DBCollection.ID_FIELD_NAME);
    }

    /* access modifiers changed from: package-private */
    public static BulkWriteException translateBulkWriteException(MongoBulkWriteException e, Decoder<DBObject> decoder) {
        return new BulkWriteException(translateBulkWriteResult(e.getWriteResult(), decoder), translateWriteErrors(e.getWriteErrors()), translateWriteConcernError(e.getWriteConcernError()), e.getServerAddress());
    }

    @Nullable
    static WriteConcernError translateWriteConcernError(@Nullable WriteConcernError writeConcernError) {
        if (writeConcernError == null) {
            return null;
        }
        return new WriteConcernError(writeConcernError.getCode(), writeConcernError.getMessage(), DBObjects.toDBObject(writeConcernError.getDetails()));
    }

    static List<BulkWriteError> translateWriteErrors(List<BulkWriteError> errors) {
        List<BulkWriteError> retVal = new ArrayList<>(errors.size());
        for (BulkWriteError cur : errors) {
            retVal.add(new BulkWriteError(cur.getCode(), cur.getMessage(), DBObjects.toDBObject(cur.getDetails()), cur.getIndex()));
        }
        return retVal;
    }

    private BulkWriteHelper() {
    }
}
