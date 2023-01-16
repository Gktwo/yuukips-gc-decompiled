package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceByteMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceByteMutablePair.class */
public class ReferenceByteMutablePair<K> implements ReferenceBytePair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected byte right;

    public ReferenceByteMutablePair(K left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceByteMutablePair<K> m514of(K left, byte right) {
        return new ReferenceByteMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ReferenceByteMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBytePair
    public ReferenceByteMutablePair<K> right(byte r) {
        this.right = r;
        return this;
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
