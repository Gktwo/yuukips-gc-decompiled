package com.mongodb.internal.operation;

import com.mongodb.Function;
import com.mongodb.WriteConcern;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.operation.CommandOperationHelper;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AbortTransactionOperation.class */
public class AbortTransactionOperation extends TransactionOperation {
    private BsonDocument recoveryToken;

    public AbortTransactionOperation(WriteConcern writeConcern) {
        super(writeConcern);
    }

    public AbortTransactionOperation recoveryToken(BsonDocument recoveryToken) {
        this.recoveryToken = recoveryToken;
        return this;
    }

    @Override // com.mongodb.internal.operation.TransactionOperation
    protected String getCommandName() {
        return "abortTransaction";
    }

    @Override // com.mongodb.internal.operation.TransactionOperation
    CommandOperationHelper.CommandCreator getCommandCreator() {
        final CommandOperationHelper.CommandCreator creator = getCommandCreator();
        if (this.recoveryToken != null) {
            return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.AbortTransactionOperation.1
                @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
                public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                    return creator.create(serverDescription, connectionDescription).append("recoveryToken", AbortTransactionOperation.this.recoveryToken);
                }
            };
        }
        return creator;
    }

    @Override // com.mongodb.internal.operation.TransactionOperation
    protected Function<BsonDocument, BsonDocument> getRetryCommandModifier() {
        return CommandOperationHelper.noOpRetryCommandModifier();
    }
}
