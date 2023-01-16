package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.query.OperationTarget;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/CurrentDateOperator.class */
public class CurrentDateOperator extends UpdateOperator {
    private TypeSpecification typeSpec = TypeSpecification.DATE;

    /* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/CurrentDateOperator$TypeSpecification.class */
    public enum TypeSpecification {
        DATE {
            @Override // dev.morphia.query.experimental.updates.CurrentDateOperator.TypeSpecification
            Object toTarget() {
                return true;
            }
        },
        TIMESTAMP {
            @Override // dev.morphia.query.experimental.updates.CurrentDateOperator.TypeSpecification
            Object toTarget() {
                return new Document("$type", "timestamp");
            }
        };

        abstract Object toTarget();
    }

    /* access modifiers changed from: protected */
    public CurrentDateOperator(String field) {
        super("$currentDate", field, field);
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(PathTarget pathTarget) {
        return new OperationTarget(pathTarget, this.typeSpec.toTarget());
    }

    public CurrentDateOperator type(TypeSpecification type) {
        this.typeSpec = type;
        return this;
    }
}
