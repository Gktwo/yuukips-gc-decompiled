package org.eclipse.jetty.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ArrayUtil.class */
public class ArrayUtil implements Cloneable, Serializable {
    public static <T> T[] removeFromArray(T[] array, Object item) {
        if (item == null || array == null) {
            return array;
        }
        int i = array.length;
        do {
            i--;
            if (i <= 0) {
                return array;
            }
        } while (!item.equals(array[i]));
        T[] na = (T[]) ((Object[]) Array.newInstance(array == null ? item.getClass() : array.getClass().getComponentType(), Array.getLength(array) - 1));
        if (i > 0) {
            System.arraycopy(array, 0, na, 0, i);
        }
        if (i + 1 < array.length) {
            System.arraycopy(array, i + 1, na, i, array.length - (i + 1));
        }
        return na;
    }

    public static <T> T[] add(T[] array1, T[] array2) {
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }
        T[] na = (T[]) Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, na, array1.length, array2.length);
        return na;
    }

    public static <T> T[] addToArray(T[] array, T item, Class<?> type) {
        if (array == null) {
            if (type == null && item != null) {
                type = item.getClass();
            }
            T[] na = (T[]) ((Object[]) Array.newInstance(type, 1));
            na[0] = item;
            return na;
        }
        T[] na2 = (T[]) Arrays.copyOf(array, array.length + 1);
        na2[array.length] = item;
        return na2;
    }

    public static <T> T[] prependToArray(T item, T[] array, Class<?> type) {
        if (array == null) {
            if (type == null && item != null) {
                type = item.getClass();
            }
            T[] na = (T[]) ((Object[]) Array.newInstance(type, 1));
            na[0] = item;
            return na;
        }
        T[] na2 = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), Array.getLength(array) + 1));
        System.arraycopy(array, 0, na2, 1, array.length);
        na2[0] = item;
        return na2;
    }

    public static <E> List<E> asMutableList(E[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(Arrays.asList(array));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] removeNulls(T[] array) {
        for (T t : array) {
            if (t == null) {
                List<T> list = new ArrayList<>();
                for (T t2 : array) {
                    if (t2 != null) {
                        list.add(t2);
                    }
                }
                return (T[]) list.toArray(Arrays.copyOf(array, list.size()));
            }
        }
        return array;
    }
}
