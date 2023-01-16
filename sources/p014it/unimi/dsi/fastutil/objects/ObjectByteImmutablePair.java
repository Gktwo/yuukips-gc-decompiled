package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectByteImmutablePair.class */
public class ObjectByteImmutablePair<K> implements ObjectBytePair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final byte right;

    public ObjectByteImmutablePair(K left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectByteImmutablePair<K> m575of(K left, byte right) {
        return new ObjectByteImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectBytePair ? Objects.equals(this.left, ((ObjectBytePair) other).left()) && this.right == ((ObjectBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + ((int) rightByte()) + ">";
    }
}
