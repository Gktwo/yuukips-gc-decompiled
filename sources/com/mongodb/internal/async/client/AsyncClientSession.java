package com.mongodb.internal.async.client;

import com.mongodb.TransactionOptions;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.session.ClientSession;

/* loaded from: grasscutter.jar:com/mongodb/internal/async/client/AsyncClientSession.class */
public interface AsyncClientSession extends ClientSession {
    boolean hasActiveTransaction();

    boolean notifyMessageSent();

    TransactionOptions getTransactionOptions();

    void startTransaction();

    void startTransaction(TransactionOptions transactionOptions);

    void commitTransaction(SingleResultCallback<Void> singleResultCallback);

    void abortTransaction(SingleResultCallback<Void> singleResultCallback);
}
