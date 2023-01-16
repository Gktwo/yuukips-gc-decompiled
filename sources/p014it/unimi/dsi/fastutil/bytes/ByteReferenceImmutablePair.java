package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteReferenceImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteReferenceImmutablePair.class */
public class ByteReferenceImmutablePair<V> implements ByteReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final byte left;
    protected final V right;

    public ByteReferenceImmutablePair(byte left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> ByteReferenceImmutablePair<V> m1041of(byte left, V right) {
        return new ByteReferenceImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteReferencePair
    public byte leftByte() {
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
