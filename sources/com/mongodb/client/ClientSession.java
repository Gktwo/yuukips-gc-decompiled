package com.mongodb.client;

import com.mongodb.ServerAddress;
import com.mongodb.TransactionOptions;
import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/client/ClientSession.class */
public interface ClientSession extends com.mongodb.session.ClientSession {
    @Override // com.mongodb.session.ClientSession
    @Nullable
    ServerAddress getPinnedServerAddress();

    @Override // com.mongodb.session.ClientSession
    void setPinnedServerAddress(@Nullable ServerAddress serverAddress);

    boolean hasActiveTransaction();

    boolean notifyMessageSent();

    TransactionOptions getTransactionOptions();

    void startTransaction();

    void startTransaction(TransactionOptions transactionOptions);

    void commitTransaction();

    void abortTransaction();

    <T> T withTransaction(TransactionBody<T> transactionBody);

    <T> T withTransaction(TransactionBody<T> transactionBody, TransactionOptions transactionOptions);
}
