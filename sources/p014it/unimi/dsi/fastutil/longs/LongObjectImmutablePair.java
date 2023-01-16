package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongObjectImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongObjectImmutablePair.class */
public class LongObjectImmutablePair<V> implements LongObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final long left;
    protected final V right;

    public LongObjectImmutablePair(long left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> LongObjectImmutablePair<V> m628of(long left, V right) {
        return new LongObjectImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongObjectPair
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
        return other instanceof LongObjectPair ? this.left == ((LongObjectPair) other).leftLong() && Objects.equals(this.right, ((LongObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + right() + ">";
    }
}
