package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceByteImmutablePair.class */
public class ReferenceByteImmutablePair<K> implements ReferenceBytePair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final byte right;

    public ReferenceByteImmutablePair(K left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceByteImmutablePair<K> m515of(K left, byte right) {
        return new ReferenceByteImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceBytePair ? this.left == ((ReferenceBytePair) other).left() && this.right == ((ReferenceBytePair) other).rightByte() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + ((int) rightByte()) + ">";
    }
}
