package dev.morphia.query.experimental.updates;

import dev.morphia.query.experimental.filters.Filter;
import dev.morphia.sofia.Sofia;
import java.time.temporal.Temporal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/UpdateOperators.class */
public final class UpdateOperators {
    private UpdateOperators() {
    }

    public static AddToSetOperator addToSet(String field, Object value) {
        return new AddToSetOperator(field, value);
    }

    public static AddToSetOperator addToSet(String field, List<?> values) {
        return new AddToSetOperator(field, values);
    }

    public static UpdateOperator and(String field, int value) {
        return new BitOperator("and", field, value);
    }

    public static CurrentDateOperator currentDate(String field) {
        return new CurrentDateOperator(field);
    }

    public static UpdateOperator dec(String field) {
        return inc(field, -1);
    }

    public static UpdateOperator dec(String field, Number value) {
        if ((value instanceof Long) || (value instanceof Integer)) {
            return inc(field, Long.valueOf(value.longValue() * -1));
        }
        if ((value instanceof Double) || (value instanceof Float)) {
            return inc(field, Double.valueOf(value.doubleValue() * -1.0d));
        }
        throw new IllegalArgumentException(Sofia.onlyNumberTypesAllowed(new Locale[0]));
    }

    public static UpdateOperator inc(String field) {
        return inc(field, 1);
    }

    public static UpdateOperator inc(String field, Number value) {
        return new UpdateOperator("$inc", field, value);
    }

    public static UpdateOperator max(String field, Number value) {
        return new UpdateOperator("$max", field, value);
    }

    public static UpdateOperator max(String field, Temporal value) {
        return new UpdateOperator("$max", field, value);
    }

    public static UpdateOperator max(String field, Date value) {
        return new UpdateOperator("$max", field, value);
    }

    public static UpdateOperator min(String field, Number value) {
        return new UpdateOperator("$min", field, value);
    }

    public static UpdateOperator min(String field, Temporal value) {
        return new UpdateOperator("$min", field, value);
    }

    public static UpdateOperator min(String field, Date value) {
        return new UpdateOperator("$min", field, value);
    }

    public static UpdateOperator mul(String field, Number value) {
        return new UpdateOperator("$mul", field, value);
    }

    /* renamed from: or */
    public static UpdateOperator m1217or(String field, int value) {
        return new BitOperator("or", field, value);
    }

    public static PopOperator pop(String field) {
        return new PopOperator(field);
    }

    public static UpdateOperator pull(String field, Filter filter) {
        return new PullOperator(field, filter);
    }

    public static UpdateOperator pullAll(String field, List<?> values) {
        return new UpdateOperator("$pullAll", field, values);
    }

    public static PushOperator push(String field, Object value) {
        return new PushOperator(field, Collections.singletonList(value));
    }

    public static PushOperator push(String field, List<?> values) {
        return new PushOperator(field, values);
    }

    public static UpdateOperator rename(String field, String value) {
        return new UpdateOperator("$rename", field, value);
    }

    public static UpdateOperator set(String field, Object value) {
        return new UpdateOperator("$set", field, value);
    }

    public static UpdateOperator set(Object value) {
        return new SetEntityOperator(value);
    }

    public static UpdateOperator setOnInsert(Map<String, Object> values) {
        return new SetOnInsertOperator(values);
    }

    public static UpdateOperator unset(String field) {
        return new UnsetOperator(field);
    }

    public static UpdateOperator xor(String field, int value) {
        return new BitOperator("xor", field, value);
    }
}
