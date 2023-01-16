package p014it.unimi.dsi.fastutil;

import java.lang.Comparable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.objects.ObjectObjectImmutableSortedPair;

/* renamed from: it.unimi.dsi.fastutil.SortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/SortedPair.class */
public interface SortedPair<K extends Comparable<K>> extends Pair<K, K> {
    /* renamed from: of */
    static <K extends Comparable<K>> SortedPair<K> m1170of(K l, K r) {
        return ObjectObjectImmutableSortedPair.m544of((Comparable) l, (Comparable) r);
    }

    default boolean contains(Object o) {
        return Objects.equals(o, left()) || Objects.equals(o, right());
    }
}
