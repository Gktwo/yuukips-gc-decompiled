package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.query.OperationTarget;
import java.util.Collection;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/AddToSetOperator.class */
public class AddToSetOperator extends UpdateOperator {
    private final boolean each;

    public AddToSetOperator(String field, Object values) {
        super("$addToSet", field, values);
        this.each = values instanceof Collection;
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(PathTarget pathTarget) {
        if (this.each) {
            return new OperationTarget(pathTarget, new Document("$each", value()));
        }
        return new OperationTarget(pathTarget, value());
    }
}
