package org.reflections.util;

import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.reflections.Store;

/* loaded from: grasscutter.jar:org/reflections/util/QueryFunction.class */
public interface QueryFunction<C, T> extends Function<C, Set<T>>, NameHelper {
    @Override // java.util.function.Function
    Set<T> apply(C c);

    static <C, T> QueryFunction<Store, T> empty() {
        return ctx -> {
            return Collections.emptySet();
        };
    }

    static <C, T> QueryFunction<Store, T> single(T element) {
        return ctx -> {
            return Collections.singleton(element);
        };
    }

    static <C, T> QueryFunction<Store, T> set(Collection<T> elements) {
        return ctx -> {
            return new LinkedHashSet(elements);
        };
    }

    default QueryFunction<C, T> filter(Predicate<? super T> predicate) {
        return ctx -> {
            return (LinkedHashSet) apply((QueryFunction<C, T>) predicate).stream().filter(predicate).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    }

    default <R> QueryFunction<C, R> map(Function<? super T, ? extends R> function) {
        return ctx -> {
            return (LinkedHashSet) apply((QueryFunction<C, T>) function).stream().map(function).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    }

    default <R> QueryFunction<C, R> flatMap(Function<T, ? extends Function<C, Set<R>>> function) {
        return ctx -> {
            return (LinkedHashSet) apply((QueryFunction<C, T>) function).stream().flatMap(t -> {
                return ((Set) ((Function) function.apply(t)).apply(function)).stream();
            }).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.function.Function<T, org.reflections.util.QueryFunction<C, T>> */
    /* JADX WARN: Multi-variable type inference failed */
    default QueryFunction<C, T> getAll(Function<T, QueryFunction<C, T>> builder) {
        return (QueryFunction<C, T>) getAll(builder, t -> {
            return t;
        });
    }

    default <R> QueryFunction<C, R> getAll(Function<T, QueryFunction<C, R>> builder, Function<R, T> traverse) {
        return ctx -> {
            ArrayList arrayList = new ArrayList(apply((QueryFunction<C, T>) traverse));
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i = 0; i < arrayList.size(); i++) {
                for (T t : ((QueryFunction) builder.apply(arrayList.get(i))).apply((QueryFunction) traverse)) {
                    if (linkedHashSet.add(t)) {
                        arrayList.add(builder.apply(t));
                    }
                }
            }
            return linkedHashSet;
        };
    }

    default <R> QueryFunction<C, T> add(QueryFunction<C, T> function) {
        return ctx -> {
            return (LinkedHashSet) Stream.of((Object[]) new Set[]{apply((QueryFunction<C, T>) function), function.apply((QueryFunction) function)}).flatMap((v0) -> {
                return v0.stream();
            }).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    }

    /* renamed from: as */
    default <R> QueryFunction<C, R> m3as(Class<? extends R> type, ClassLoader... loaders) {
        return ctx -> {
            Set<T> apply = apply((QueryFunction<C, T>) loaders);
            return (Set) apply.stream().findFirst().map(first -> {
                if (type.isAssignableFrom(type.getClass())) {
                    return type;
                }
                if (type instanceof String) {
                    return (Set) forNames(type, type, apply);
                }
                if (type instanceof AnnotatedElement) {
                    return (Set) forNames(toNames(type), type, apply);
                }
                return (Set) type.stream().map(t -> {
                    return t;
                }).collect(Collectors.toCollection(LinkedHashSet::new));
            }).orElse(apply);
        };
    }

    default <R> QueryFunction<C, Class<?>> asClass(ClassLoader... loaders) {
        return ctx -> {
            return (Set) forNames(apply((QueryFunction<C, T>) loaders), Class.class, loaders);
        };
    }

    default QueryFunction<C, String> asString() {
        return ctx -> {
            return new LinkedHashSet(toNames((AnnotatedElement) apply((QueryFunction<C, T>) ctx)));
        };
    }

    /* renamed from: as */
    default <R> QueryFunction<C, Class<? extends R>> m4as() {
        return ctx -> {
            return new LinkedHashSet(apply((QueryFunction<C, T>) ctx));
        };
    }
}
