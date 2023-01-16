package com.mongodb.internal.operation;

import com.mongodb.Function;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonValue;
import org.bson.FieldNameValidator;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/TransactionOperation.class */
public abstract class TransactionOperation implements WriteOperation<Void>, AsyncWriteOperation<Void> {
    private final WriteConcern writeConcern;

    protected abstract String getCommandName();

    protected abstract Function<BsonDocument, BsonDocument> getRetryCommandModifier();

    /* access modifiers changed from: package-private */
    public TransactionOperation(WriteConcern writeConcern) {
        this.writeConcern = (WriteConcern) Assertions.notNull("writeConcern", writeConcern);
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(WriteBinding binding) {
        Assertions.isTrue("in transaction", binding.getSessionContext().hasActiveTransaction());
        return (Void) CommandOperationHelper.executeRetryableCommand(binding, "admin", (ReadPreference) null, (FieldNameValidator) new NoOpFieldNameValidator(), (Decoder) new BsonDocumentCodec(), getCommandCreator(), (CommandOperationHelper.CommandWriteTransformer<T, Object>) CommandOperationHelper.writeConcernErrorTransformer(), getRetryCommandModifier());
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(AsyncWriteBinding binding, SingleResultCallback<Void> callback) {
        Assertions.isTrue("in transaction", binding.getSessionContext().hasActiveTransaction());
        CommandOperationHelper.executeRetryableCommand(binding, "admin", null, new NoOpFieldNameValidator(), new BsonDocumentCodec(), getCommandCreator(), CommandOperationHelper.writeConcernErrorTransformerAsync(), getRetryCommandModifier(), ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER));
    }

    /* access modifiers changed from: package-private */
    public CommandOperationHelper.CommandCreator getCommandCreator() {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.TransactionOperation.1
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                BsonDocument command = new BsonDocument(TransactionOperation.this.getCommandName(), new BsonInt32(1));
                if (!TransactionOperation.this.writeConcern.isServerDefault()) {
                    command.put("writeConcern", (BsonValue) TransactionOperation.this.writeConcern.asDocument());
                }
                return command;
            }
        };
    }
}
