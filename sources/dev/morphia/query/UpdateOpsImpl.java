package dev.morphia.query;

import dev.morphia.Datastore;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.experimental.filters.Filters;
import dev.morphia.query.experimental.updates.PopOperator;
import dev.morphia.query.experimental.updates.PushOperator;
import dev.morphia.query.experimental.updates.UpdateOperators;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/UpdateOpsImpl.class */
public class UpdateOpsImpl<T> extends UpdateBase<T> implements UpdateOperations<T> {
    private Document ops = new Document();
    private boolean validateNames = true;

    public UpdateOpsImpl(Datastore datastore, Class<T> type, Mapper mapper) {
        super(datastore, mapper, null, null, type);
    }

    static <T> List<T> iterToList(Iterable<T> it) {
        if (it instanceof List) {
            return (List) it;
        }
        List<T> ar = new ArrayList<>();
        for (T o : it) {
            ar.add(o);
        }
        return ar;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> addToSet(String field, Object value) {
        add(UpdateOperators.addToSet(field, value));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> addToSet(String field, List<?> values) {
        add(UpdateOperators.addToSet(field, values));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> addToSet(String field, Iterable<?> values) {
        return addToSet(field, iterToList(values));
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> dec(String field) {
        return inc(field, -1);
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> dec(String field, Number value) {
        if ((value instanceof Long) || (value instanceof Integer)) {
            return inc(field, Long.valueOf(value.longValue() * -1));
        }
        if ((value instanceof Double) || (value instanceof Float)) {
            return inc(field, Double.valueOf(value.doubleValue() * -1.0d));
        }
        throw new IllegalArgumentException("Currently only the following types are allowed: integer, long, double, float.");
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> disableValidation() {
        this.validateNames = false;
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> enableValidation() {
        this.validateNames = true;
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> inc(String field) {
        return inc(field, 1);
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> inc(String field, Number value) {
        add(UpdateOperators.inc(field, value));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> max(String field, Number value) {
        add(UpdateOperators.max(field, value));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> min(String field, Number value) {
        add(UpdateOperators.min(field, value));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> push(String field, Object value) {
        add(UpdateOperators.push(field, value));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> push(String field, Object value, PushOptions options) {
        PushOperator push = UpdateOperators.push(field, value);
        options.update(push);
        add(push);
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> push(String field, List<?> values) {
        add(UpdateOperators.push(field, values));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> push(String field, List<?> values, PushOptions options) {
        PushOperator push = UpdateOperators.push(field, values);
        options.update(push);
        add(push);
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> removeAll(String field, Object value) {
        add(UpdateOperators.pull(field, Filters.m1223eq(field, value)));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> removeAll(String field, List<?> values) {
        add(UpdateOperators.pullAll(field, values));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> removeFirst(String field) {
        return remove(field, true);
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> removeLast(String field) {
        return remove(field, false);
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> set(String field, Object value) {
        add(UpdateOperators.set(field, value));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> setOnInsert(String field, Object value) {
        add(UpdateOperators.setOnInsert(Map.of(field, value)));
        return this;
    }

    @Override // dev.morphia.query.UpdateOperations
    public UpdateOperations<T> unset(String field) {
        add(UpdateOperators.unset(field));
        return this;
    }

    public Document getOps() {
        return new Document(this.ops);
    }

    public void setOps(Document ops) {
        this.ops = ops;
    }

    protected UpdateOperations<T> remove(String fieldExpr, boolean firstNotLast) {
        PopOperator pop = UpdateOperators.pop(fieldExpr);
        if (firstNotLast) {
            pop.removeFirst();
        }
        add(pop);
        return this;
    }
}
