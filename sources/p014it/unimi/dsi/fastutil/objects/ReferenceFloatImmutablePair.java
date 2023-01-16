package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceFloatImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceFloatImmutablePair.class */
public class ReferenceFloatImmutablePair<K> implements ReferenceFloatPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final float right;

    public ReferenceFloatImmutablePair(K left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceFloatImmutablePair<K> m506of(K left, float right) {
        return new ReferenceFloatImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceFloatPair ? this.left == ((ReferenceFloatPair) other).left() && this.right == ((ReferenceFloatPair) other).rightFloat() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightFloat() + ">";
    }
}
