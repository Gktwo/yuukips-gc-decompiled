package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteObjectMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteObjectMutablePair.class */
public class ByteObjectMutablePair<V> implements ByteObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected byte left;
    protected V right;

    public ByteObjectMutablePair(byte left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> ByteObjectMutablePair<V> m1050of(byte left, V right) {
        return new ByteObjectMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteObjectPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteObjectPair
    public ByteObjectMutablePair<V> left(byte l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ByteObjectMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteObjectPair ? this.left == ((ByteObjectPair) other).leftByte() && Objects.equals(this.right, ((ByteObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + right() + ">";
    }
}
