package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.query.OperationTarget;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/UnsetOperator.class */
public class UnsetOperator extends UpdateOperator {
    public UnsetOperator(String field) {
        super("$unset", field, "unused");
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(final PathTarget pathTarget) {
        return new OperationTarget("", pathTarget) { // from class: dev.morphia.query.experimental.updates.UnsetOperator.1
            @Override // dev.morphia.query.OperationTarget
            public Object encode(Mapper mapper) {
                PropertyModel target = pathTarget.getTarget();
                return new Document(target != null ? target.getMappedName() : UnsetOperator.this.field(), "");
            }
        };
    }
}
