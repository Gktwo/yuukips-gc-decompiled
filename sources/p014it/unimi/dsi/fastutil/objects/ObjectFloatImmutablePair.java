package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectFloatImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectFloatImmutablePair.class */
public class ObjectFloatImmutablePair<K> implements ObjectFloatPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final float right;

    public ObjectFloatImmutablePair(K left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectFloatImmutablePair<K> m566of(K left, float right) {
        return new ObjectFloatImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectFloatPair ? Objects.equals(this.left, ((ObjectFloatPair) other).left()) && this.right == ((ObjectFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightFloat() + ">";
    }
}
