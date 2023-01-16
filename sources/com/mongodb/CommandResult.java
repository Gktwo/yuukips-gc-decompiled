package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/CommandResult.class */
public class CommandResult extends BasicDBObject {
    private static final long serialVersionUID = 5907909423864204060L;
    private final BsonDocument response;
    private final ServerAddress address;

    /* access modifiers changed from: package-private */
    public CommandResult(BsonDocument response) {
        this(response, null);
    }

    /* access modifiers changed from: package-private */
    public CommandResult(BsonDocument response, @Nullable ServerAddress address) {
        this.address = address;
        this.response = (BsonDocument) Assertions.notNull("response", response);
        putAll(DBObjects.toDBObject(response));
    }

    /* renamed from: ok */
    public boolean m1282ok() {
        Object okValue = get("ok");
        if (okValue instanceof Boolean) {
            return ((Boolean) okValue).booleanValue();
        }
        return (okValue instanceof Number) && ((Number) okValue).intValue() == 1;
    }

    @Nullable
    public String getErrorMessage() {
        Object foo = get("errmsg");
        if (foo == null) {
            return null;
        }
        return foo.toString();
    }

    @Nullable
    public MongoException getException() {
        if (!m1282ok()) {
            return createException();
        }
        return null;
    }

    public void throwOnError() {
        if (!m1282ok()) {
            throw createException();
        }
    }

    private MongoException createException() {
        return new MongoCommandException(this.response, this.address);
    }
}
