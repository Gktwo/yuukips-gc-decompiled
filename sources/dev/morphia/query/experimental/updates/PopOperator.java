package dev.morphia.query.experimental.updates;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/PopOperator.class */
public class PopOperator extends UpdateOperator {
    public PopOperator(String field) {
        super("$pop", field, (Object) 1);
    }

    public PopOperator removeFirst() {
        value(-1);
        return this;
    }
}
