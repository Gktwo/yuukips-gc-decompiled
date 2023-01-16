package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.query.OperationTarget;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/BitOperator.class */
class BitOperator extends UpdateOperator {
    private final String operation;

    /* access modifiers changed from: package-private */
    public BitOperator(String operation, String field, int value) {
        super("$bit", field, Integer.valueOf(value));
        this.operation = operation;
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(PathTarget pathTarget) {
        return new OperationTarget(pathTarget, new Document(this.operation, value()));
    }
}
