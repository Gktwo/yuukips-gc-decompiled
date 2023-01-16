package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.query.OperationTarget;
import dev.morphia.query.UpdateException;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/UpdateOperator.class */
public class UpdateOperator {
    private final String operator;
    private final String field;
    private Object value;

    /* access modifiers changed from: protected */
    public UpdateOperator(String operator, String field, Object value) {
        this.operator = operator;
        this.field = field;
        this.value = value;
    }

    /* access modifiers changed from: protected */
    public UpdateOperator(String operator, String field, List<?> values) {
        if (values.isEmpty()) {
            throw new UpdateException(Sofia.valuesCannotBeNullOrEmpty(new Locale[0]));
        }
        this.operator = operator;
        this.field = field;
        this.value = values;
    }

    public String field() {
        return this.field;
    }

    public String operator() {
        return this.operator;
    }

    public OperationTarget toTarget(PathTarget pathTarget) {
        return new OperationTarget(pathTarget, value());
    }

    public Object value() {
        return this.value;
    }

    protected void value(Object value) {
        this.value = value;
    }
}
