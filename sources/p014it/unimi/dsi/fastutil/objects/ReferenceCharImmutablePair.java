package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceCharImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceCharImmutablePair.class */
public class ReferenceCharImmutablePair<K> implements ReferenceCharPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final char right;

    public ReferenceCharImmutablePair(K left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceCharImmutablePair<K> m512of(K left, char right) {
        return new ReferenceCharImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceCharPair ? this.left == ((ReferenceCharPair) other).left() && this.right == ((ReferenceCharPair) other).rightChar() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightChar() + ">";
    }
}
