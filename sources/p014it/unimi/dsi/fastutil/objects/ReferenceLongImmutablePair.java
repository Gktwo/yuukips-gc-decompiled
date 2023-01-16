package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceLongImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceLongImmutablePair.class */
public class ReferenceLongImmutablePair<K> implements ReferenceLongPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final long right;

    public ReferenceLongImmutablePair(K left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceLongImmutablePair<K> m488of(K left, long right) {
        return new ReferenceLongImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceLongPair ? this.left == ((ReferenceLongPair) other).left() && this.right == ((ReferenceLongPair) other).rightLong() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightLong() + ">";
    }
}
