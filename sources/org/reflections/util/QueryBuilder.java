package org.reflections.util;

import java.lang.reflect.AnnotatedElement;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.reflections.Store;

/* loaded from: grasscutter.jar:org/reflections/util/QueryBuilder.class */
public interface QueryBuilder extends NameHelper {
    default String index() {
        return getClass().getSimpleName();
    }

    default QueryFunction<Store, String> get(String key) {
        return store -> {
            return new LinkedHashSet(key.getOrDefault(index(), Collections.emptyMap()).getOrDefault(key, Collections.emptySet()));
        };
    }

    default QueryFunction<Store, String> get(AnnotatedElement element) {
        return get(toName(element));
    }

    default QueryFunction<Store, String> get(Collection<String> keys) {
        return (QueryFunction) keys.stream().map(this::get).reduce((v0, v1) -> {
            return v0.add(v1);
        }).get();
    }

    default QueryFunction<Store, String> getAll(Collection<String> keys) {
        return QueryFunction.set(keys).getAll(this::get);
    }

    default QueryFunction<Store, String> getAllIncluding(String key) {
        return QueryFunction.single(key).add(QueryFunction.single(key).getAll(this::get));
    }

    default QueryFunction<Store, String> getAllIncluding(Collection<String> keys) {
        return QueryFunction.set(keys).add(QueryFunction.set(keys).getAll(this::get));
    }

    /* renamed from: of */
    default QueryFunction<Store, String> m8of(Collection<String> keys) {
        return getAll(keys);
    }

    /* renamed from: of */
    default QueryFunction<Store, String> m9of(String key) {
        return getAll(Collections.singletonList(key));
    }

    /* renamed from: of */
    default QueryFunction<Store, String> m5of(AnnotatedElement... elements) {
        return getAll(toNames(elements));
    }

    /* renamed from: of */
    default QueryFunction<Store, String> m7of(Set<? extends AnnotatedElement> elements) {
        return getAll(toNames(elements));
    }

    default QueryFunction<Store, String> with(Collection<String> keys) {
        return m8of(keys);
    }

    default QueryFunction<Store, String> with(String key) {
        return m9of(key);
    }

    default QueryFunction<Store, String> with(AnnotatedElement... keys) {
        return m5of(keys);
    }

    default QueryFunction<Store, String> with(Set<? extends AnnotatedElement> keys) {
        return m7of(keys);
    }

    /* renamed from: of */
    default <T> QueryFunction<Store, T> m6of(QueryFunction queryFunction) {
        return queryFunction.add(queryFunction.getAll(this::get));
    }
}
