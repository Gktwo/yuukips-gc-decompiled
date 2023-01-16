package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongObjectMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongObjectMutablePair.class */
public class LongObjectMutablePair<V> implements LongObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected long left;
    protected V right;

    public LongObjectMutablePair(long left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> LongObjectMutablePair<V> m627of(long left, V right) {
        return new LongObjectMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongObjectPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongObjectPair
    public LongObjectMutablePair<V> left(long l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public LongObjectMutablePair<V> right(V r) {
        this.right = r;
        return this;
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
