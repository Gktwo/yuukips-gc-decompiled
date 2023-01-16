package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.OperationTarget;
import java.util.Map;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/SetOnInsertOperator.class */
public class SetOnInsertOperator extends UpdateOperator {
    private final Map<String, Object> insertValues;

    public SetOnInsertOperator(Map<String, Object> values) {
        super("$setOnInsert", "unused", "unused");
        this.insertValues = values;
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(PathTarget pathTarget) {
        return new OperationTarget(null, null) { // from class: dev.morphia.query.experimental.updates.SetOnInsertOperator.1
            @Override // dev.morphia.query.OperationTarget
            public Object encode(Mapper mapper) {
                return SetOnInsertOperator.this.insertValues;
            }
        };
    }
}
