package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectObjectImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectObjectImmutableSortedPair.class */
public class ObjectObjectImmutableSortedPair<K extends Comparable<K>> extends ObjectObjectImmutablePair<K, K> implements SortedPair<K>, Serializable {
    private static final long serialVersionUID = 0;

    private ObjectObjectImmutableSortedPair(K left, K right) {
        super(left, right);
    }

    /* renamed from: of */
    public static <K extends Comparable<K>> ObjectObjectImmutableSortedPair<K> m544of(K left, K right) {
        return left.compareTo(right) <= 0 ? new ObjectObjectImmutableSortedPair<>(left, right) : new ObjectObjectImmutableSortedPair<>(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        return other != null && (other instanceof SortedPair) && Objects.equals(this.left, ((SortedPair) other).left()) && Objects.equals(this.right, ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair, java.lang.Object
    public String toString() {
        return "{" + left() + "," + right() + "}";
    }
}
