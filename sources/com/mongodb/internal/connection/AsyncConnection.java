package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcernResult;
import com.mongodb.annotations.ThreadSafe;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.ReferenceCounted;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.session.SessionContext;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.FieldNameValidator;
import org.bson.codecs.Decoder;

@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AsyncConnection.class */
public interface AsyncConnection extends ReferenceCounted {
    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    AsyncConnection retain();

    ConnectionDescription getDescription();

    void insertAsync(MongoNamespace mongoNamespace, boolean z, InsertRequest insertRequest, SingleResultCallback<WriteConcernResult> singleResultCallback);

    void updateAsync(MongoNamespace mongoNamespace, boolean z, UpdateRequest updateRequest, SingleResultCallback<WriteConcernResult> singleResultCallback);

    void deleteAsync(MongoNamespace mongoNamespace, boolean z, DeleteRequest deleteRequest, SingleResultCallback<WriteConcernResult> singleResultCallback);

    <T> void commandAsync(String str, BsonDocument bsonDocument, FieldNameValidator fieldNameValidator, ReadPreference readPreference, Decoder<T> decoder, SessionContext sessionContext, SingleResultCallback<T> singleResultCallback);

    <T> void commandAsync(String str, BsonDocument bsonDocument, FieldNameValidator fieldNameValidator, ReadPreference readPreference, Decoder<T> decoder, SessionContext sessionContext, boolean z, SplittablePayload splittablePayload, FieldNameValidator fieldNameValidator2, SingleResultCallback<T> singleResultCallback);

    <T> void queryAsync(MongoNamespace mongoNamespace, BsonDocument bsonDocument, BsonDocument bsonDocument2, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Decoder<T> decoder, SingleResultCallback<QueryResult<T>> singleResultCallback);

    <T> void getMoreAsync(MongoNamespace mongoNamespace, long j, int i, Decoder<T> decoder, SingleResultCallback<QueryResult<T>> singleResultCallback);

    void killCursorAsync(MongoNamespace mongoNamespace, List<Long> list, SingleResultCallback<Void> singleResultCallback);
}
