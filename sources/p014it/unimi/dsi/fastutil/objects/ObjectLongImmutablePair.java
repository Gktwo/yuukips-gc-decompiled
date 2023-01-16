package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectLongImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectLongImmutablePair.class */
public class ObjectLongImmutablePair<K> implements ObjectLongPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final long right;

    public ObjectLongImmutablePair(K left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectLongImmutablePair<K> m548of(K left, long right) {
        return new ObjectLongImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectLongPair ? Objects.equals(this.left, ((ObjectLongPair) other).left()) && this.right == ((ObjectLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightLong() + ">";
    }
}
