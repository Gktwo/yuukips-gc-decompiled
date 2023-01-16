package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.FieldNameValidator;
import org.bson.codecs.Decoder;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/FindAndDeleteOperation.class */
public class FindAndDeleteOperation<T> extends BaseFindAndModifyOperation<T> {
    private BsonDocument filter;
    private BsonDocument projection;
    private BsonDocument sort;
    private long maxTimeMS;
    private Collation collation;
    private Bson hint;
    private String hintString;

    public FindAndDeleteOperation(MongoNamespace namespace, Decoder<T> decoder) {
        this(namespace, WriteConcern.ACKNOWLEDGED, false, decoder);
    }

    public FindAndDeleteOperation(MongoNamespace namespace, WriteConcern writeConcern, Decoder<T> decoder) {
        this(namespace, writeConcern, false, decoder);
    }

    public FindAndDeleteOperation(MongoNamespace namespace, WriteConcern writeConcern, boolean retryWrites, Decoder<T> decoder) {
        super(namespace, writeConcern, retryWrites, decoder);
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public FindAndDeleteOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public BsonDocument getProjection() {
        return this.projection;
    }

    public FindAndDeleteOperation<T> projection(BsonDocument projection) {
        this.projection = projection;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public FindAndDeleteOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public BsonDocument getSort() {
        return this.sort;
    }

    public FindAndDeleteOperation<T> sort(BsonDocument sort) {
        this.sort = sort;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public FindAndDeleteOperation<T> collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    public FindAndDeleteOperation<T> hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public FindAndDeleteOperation<T> hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected String getDatabaseName() {
        return getNamespace().getDatabaseName();
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.FindAndDeleteOperation.1
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                return FindAndDeleteOperation.this.createCommand(sessionContext, serverDescription, connectionDescription);
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument createCommand(SessionContext sessionContext, ServerDescription serverDescription, ConnectionDescription connectionDescription) {
        OperationHelper.validateCollation(connectionDescription, this.collation);
        BsonDocument commandDocument = new BsonDocument("findAndModify", new BsonString(getNamespace().getCollectionName()));
        DocumentHelper.putIfNotNull(commandDocument, "query", getFilter());
        DocumentHelper.putIfNotNull(commandDocument, "fields", getProjection());
        DocumentHelper.putIfNotNull(commandDocument, "sort", getSort());
        DocumentHelper.putIfNotZero(commandDocument, "maxTimeMS", getMaxTime(TimeUnit.MILLISECONDS));
        commandDocument.put("remove", (BsonValue) BsonBoolean.TRUE);
        addWriteConcernToCommand(connectionDescription, commandDocument, sessionContext);
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        if (!(this.hint == null && this.hintString == null)) {
            OperationHelper.validateHint(connectionDescription, getWriteConcern());
            if (this.hint != null) {
                commandDocument.put("hint", (BsonValue) this.hint.toBsonDocument(BsonDocument.class, null));
            } else {
                commandDocument.put("hint", (BsonValue) new BsonString(this.hintString));
            }
        }
        addTxnNumberToCommand(serverDescription, connectionDescription, commandDocument, sessionContext);
        return commandDocument;
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected FieldNameValidator getFieldNameValidator() {
        return new NoOpFieldNameValidator();
    }
}
