package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/Platform.class */
public final class Platform {
    /* access modifiers changed from: package-private */
    public static <K, V> Map<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return Maps.newHashMapWithExpectedSize(expectedSize);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int expectedSize) {
        return Maps.newLinkedHashMapWithExpectedSize(expectedSize);
    }

    /* access modifiers changed from: package-private */
    public static <E> Set<E> newHashSetWithExpectedSize(int expectedSize) {
        return Sets.newHashSetWithExpectedSize(expectedSize);
    }

    /* access modifiers changed from: package-private */
    public static <E> Set<E> newLinkedHashSetWithExpectedSize(int expectedSize) {
        return Sets.newLinkedHashSetWithExpectedSize(expectedSize);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return Maps.newLinkedHashMap();
    }

    /* access modifiers changed from: package-private */
    public static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return Sets.newLinkedHashSet();
    }

    /* access modifiers changed from: package-private */
    public static <T> T[] newArray(T[] reference, int length) {
        return (T[]) ((Object[]) Array.newInstance(reference.getClass().getComponentType(), length));
    }

    /* access modifiers changed from: package-private */
    public static <T> T[] copy(Object[] source, int from, int to, T[] arrayOfType) {
        return (T[]) Arrays.copyOfRange(source, from, to, arrayOfType.getClass());
    }

    /* access modifiers changed from: package-private */
    public static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    static int reduceIterationsIfGwt(int iterations) {
        return iterations;
    }

    static int reduceExponentIfGwt(int exponent) {
        return exponent;
    }

    private Platform() {
    }
}
