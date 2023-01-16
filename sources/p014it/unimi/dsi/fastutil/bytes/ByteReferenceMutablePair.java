package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteReferenceMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteReferenceMutablePair.class */
public class ByteReferenceMutablePair<V> implements ByteReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected byte left;
    protected V right;

    public ByteReferenceMutablePair(byte left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> ByteReferenceMutablePair<V> m1040of(byte left, V right) {
        return new ByteReferenceMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteReferencePair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteReferencePair
    public ByteReferenceMutablePair<V> left(byte l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ByteReferenceMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteReferencePair ? this.left == ((ByteReferencePair) other).leftByte() && this.right == ((ByteReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + right() + ">";
    }
}
