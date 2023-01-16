package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.CollectibleDocumentFieldNameValidator;
import com.mongodb.internal.validator.MappedFieldNameValidator;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import com.mongodb.lang.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.FieldNameValidator;
import org.bson.codecs.Decoder;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/FindAndReplaceOperation.class */
public class FindAndReplaceOperation<T> extends BaseFindAndModifyOperation<T> {
    private final BsonDocument replacement;
    private BsonDocument filter;
    private BsonDocument projection;
    private BsonDocument sort;
    private long maxTimeMS;
    private boolean returnOriginal;
    private boolean upsert;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private Bson hint;
    private String hintString;

    public FindAndReplaceOperation(MongoNamespace namespace, Decoder<T> decoder, BsonDocument replacement) {
        this(namespace, WriteConcern.ACKNOWLEDGED, false, decoder, replacement);
    }

    public FindAndReplaceOperation(MongoNamespace namespace, WriteConcern writeConcern, Decoder<T> decoder, BsonDocument replacement) {
        this(namespace, writeConcern, false, decoder, replacement);
    }

    public FindAndReplaceOperation(MongoNamespace namespace, WriteConcern writeConcern, boolean retryWrites, Decoder<T> decoder, BsonDocument replacement) {
        super(namespace, writeConcern, retryWrites, decoder);
        this.returnOriginal = true;
        this.replacement = (BsonDocument) Assertions.notNull("replacement", replacement);
    }

    public BsonDocument getReplacement() {
        return this.replacement;
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public FindAndReplaceOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public BsonDocument getProjection() {
        return this.projection;
    }

    public FindAndReplaceOperation<T> projection(BsonDocument projection) {
        this.projection = projection;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public FindAndReplaceOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public BsonDocument getSort() {
        return this.sort;
    }

    public FindAndReplaceOperation<T> sort(BsonDocument sort) {
        this.sort = sort;
        return this;
    }

    public boolean isReturnOriginal() {
        return this.returnOriginal;
    }

    public FindAndReplaceOperation<T> returnOriginal(boolean returnOriginal) {
        this.returnOriginal = returnOriginal;
        return this;
    }

    public boolean isUpsert() {
        return this.upsert;
    }

    public FindAndReplaceOperation<T> upsert(boolean upsert) {
        this.upsert = upsert;
        return this;
    }

    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public FindAndReplaceOperation<T> bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    public FindAndReplaceOperation<T> hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public FindAndReplaceOperation<T> hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    public FindAndReplaceOperation<T> collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected String getDatabaseName() {
        return getNamespace().getDatabaseName();
    }

    @Override // com.mongodb.internal.operation.BaseFindAndModifyOperation
    protected CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.FindAndReplaceOperation.1
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                return FindAndReplaceOperation.this.createCommand(sessionContext, serverDescription, connectionDescription);
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
        commandDocument.put("new", (BsonValue) new BsonBoolean(!isReturnOriginal()));
        DocumentHelper.putIfTrue(commandDocument, "upsert", isUpsert());
        DocumentHelper.putIfNotZero(commandDocument, "maxTimeMS", getMaxTime(TimeUnit.MILLISECONDS));
        commandDocument.put("update", (BsonValue) getReplacement());
        if (this.bypassDocumentValidation != null && ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connectionDescription)) {
            commandDocument.put("bypassDocumentValidation", (BsonValue) BsonBoolean.valueOf(this.bypassDocumentValidation.booleanValue()));
        }
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
        Map<String, FieldNameValidator> map = new HashMap<>();
        map.put("update", new CollectibleDocumentFieldNameValidator());
        return new MappedFieldNameValidator(new NoOpFieldNameValidator(), map);
    }
}
