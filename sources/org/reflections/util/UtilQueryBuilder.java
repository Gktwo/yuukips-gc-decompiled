package org.reflections.util;

import java.lang.reflect.AnnotatedElement;
import java.util.LinkedHashSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.reflections.ReflectionUtils;
import org.reflections.Store;

/* loaded from: grasscutter.jar:org/reflections/util/UtilQueryBuilder.class */
public interface UtilQueryBuilder<F, E> {
    QueryFunction<Store, E> get(F f);

    /* renamed from: of */
    default QueryFunction<Store, E> mo2of(F element) {
        return m0of((QueryFunction) ReflectionUtils.extendType().get((AnnotatedElement) element));
    }

    /* renamed from: of */
    default QueryFunction<Store, E> m1of(F element, Predicate<? super E> predicate) {
        return mo2of((UtilQueryBuilder<F, E>) element).filter(predicate);
    }

    /* renamed from: of */
    default <T> QueryFunction<Store, E> m0of(QueryFunction<Store, T> function) {
        return store -> {
            return (LinkedHashSet) function.apply((QueryFunction) function).stream().flatMap(t -> {
                return get(function).apply((QueryFunction<Store, E>) store).stream();
            }).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    }
}
