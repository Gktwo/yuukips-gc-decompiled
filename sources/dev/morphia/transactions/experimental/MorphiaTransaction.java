package dev.morphia.transactions.experimental;

import dev.morphia.experimental.MorphiaSession;

/* loaded from: grasscutter.jar:dev/morphia/transactions/experimental/MorphiaTransaction.class */
public interface MorphiaTransaction<T> {
    T execute(MorphiaSession morphiaSession);
}
