package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ObjectArrays.class */
public final class ObjectArrays {
    private ObjectArrays() {
    }

    @GwtIncompatible
    public static <T> T[] newArray(Class<T> type, int length) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) type, length));
    }

    public static <T> T[] newArray(T[] reference, int length) {
        return (T[]) Platform.newArray(reference, length);
    }

    @GwtIncompatible
    public static <T> T[] concat(T[] first, T[] second, Class<T> type) {
        T[] result = (T[]) newArray(type, first.length + second.length);
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static <T> T[] concat(T element, T[] array) {
        T[] result = (T[]) newArray(array, array.length + 1);
        result[0] = element;
        System.arraycopy(array, 0, result, 1, array.length);
        return result;
    }

    public static <T> T[] concat(T[] array, T element) {
        T[] result = (T[]) Arrays.copyOf(array, array.length + 1);
        result[array.length] = element;
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object[]] */
    /* access modifiers changed from: package-private */
    public static <T> T[] toArrayImpl(Collection<?> c, T[] array) {
        int size = c.size();
        if (array.length < size) {
            array = newArray(array, size);
        }
        fillArray(c, array);
        if (array.length > size) {
            array[size] = null;
        }
        return array;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object[]] */
    /* access modifiers changed from: package-private */
    public static <T> T[] toArrayImpl(Object[] src, int offset, int len, T[] dst) {
        Preconditions.checkPositionIndexes(offset, offset + len, src.length);
        if (dst.length < len) {
            dst = newArray(dst, len);
        } else if (dst.length > len) {
            dst[len] = null;
        }
        System.arraycopy(src, offset, dst, 0, len);
        return dst;
    }

    /* access modifiers changed from: package-private */
    public static Object[] toArrayImpl(Collection<?> c) {
        return fillArray(c, new Object[c.size()]);
    }

    /* access modifiers changed from: package-private */
    public static Object[] copyAsObjectArray(Object[] elements, int offset, int length) {
        Preconditions.checkPositionIndexes(offset, offset + length, elements.length);
        if (length == 0) {
            return new Object[0];
        }
        Object[] result = new Object[length];
        System.arraycopy(elements, offset, result, 0, length);
        return result;
    }

    @CanIgnoreReturnValue
    private static Object[] fillArray(Iterable<?> elements, Object[] array) {
        int i = 0;
        Iterator<?> it = elements.iterator();
        while (it.hasNext()) {
            i++;
            array[i] = it.next();
        }
        return array;
    }

    static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object[] checkElementsNotNull(Object... array) {
        return checkElementsNotNull(array, array.length);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object[] checkElementsNotNull(Object[] array, int length) {
        for (int i = 0; i < length; i++) {
            checkElementNotNull(array[i], i);
        }
        return array;
    }

    @CanIgnoreReturnValue
    static Object checkElementNotNull(Object element, int index) {
        if (element != null) {
            return element;
        }
        throw new NullPointerException("at index " + index);
    }
}
