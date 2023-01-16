package dev.morphia.query;

import java.util.List;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/UpdateOperations.class */
public interface UpdateOperations<T> {
    UpdateOperations<T> addToSet(String str, Object obj);

    UpdateOperations<T> addToSet(String str, List<?> list);

    UpdateOperations<T> addToSet(String str, Iterable<?> iterable);

    UpdateOperations<T> dec(String str);

    UpdateOperations<T> dec(String str, Number number);

    UpdateOperations<T> disableValidation();

    UpdateOperations<T> enableValidation();

    UpdateOperations<T> inc(String str);

    UpdateOperations<T> inc(String str, Number number);

    UpdateOperations<T> max(String str, Number number);

    UpdateOperations<T> min(String str, Number number);

    UpdateOperations<T> push(String str, Object obj);

    UpdateOperations<T> push(String str, Object obj, PushOptions pushOptions);

    UpdateOperations<T> push(String str, List<?> list);

    UpdateOperations<T> push(String str, List<?> list, PushOptions pushOptions);

    UpdateOperations<T> removeAll(String str, Object obj);

    UpdateOperations<T> removeAll(String str, List<?> list);

    UpdateOperations<T> removeFirst(String str);

    UpdateOperations<T> removeLast(String str);

    UpdateOperations<T> set(String str, Object obj);

    UpdateOperations<T> setOnInsert(String str, Object obj);

    UpdateOperations<T> unset(String str);
}
