package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcernResult;
import com.mongodb.annotations.ThreadSafe;
import com.mongodb.connection.ConnectionDescription;
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
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/Connection.class */
public interface Connection extends ReferenceCounted {
    @Override // com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    Connection retain();

    ConnectionDescription getDescription();

    WriteConcernResult insert(MongoNamespace mongoNamespace, boolean z, InsertRequest insertRequest);

    WriteConcernResult update(MongoNamespace mongoNamespace, boolean z, UpdateRequest updateRequest);

    WriteConcernResult delete(MongoNamespace mongoNamespace, boolean z, DeleteRequest deleteRequest);

    <T> T command(String str, BsonDocument bsonDocument, FieldNameValidator fieldNameValidator, ReadPreference readPreference, Decoder<T> decoder, SessionContext sessionContext);

    <T> T command(String str, BsonDocument bsonDocument, FieldNameValidator fieldNameValidator, ReadPreference readPreference, Decoder<T> decoder, SessionContext sessionContext, boolean z, SplittablePayload splittablePayload, FieldNameValidator fieldNameValidator2);

    <T> QueryResult<T> query(MongoNamespace mongoNamespace, BsonDocument bsonDocument, BsonDocument bsonDocument2, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Decoder<T> decoder);

    <T> QueryResult<T> getMore(MongoNamespace mongoNamespace, long j, int i, Decoder<T> decoder);

    void killCursor(MongoNamespace mongoNamespace, List<Long> list);
}
