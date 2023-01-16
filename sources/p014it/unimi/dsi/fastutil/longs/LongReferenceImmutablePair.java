package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongReferenceImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongReferenceImmutablePair.class */
public class LongReferenceImmutablePair<V> implements LongReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final long left;
    protected final V right;

    public LongReferenceImmutablePair(long left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> LongReferenceImmutablePair<V> m618of(long left, V right) {
        return new LongReferenceImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongReferencePair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongReferencePair ? this.left == ((LongReferencePair) other).leftLong() && this.right == ((LongReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + right() + ">";
    }
}
