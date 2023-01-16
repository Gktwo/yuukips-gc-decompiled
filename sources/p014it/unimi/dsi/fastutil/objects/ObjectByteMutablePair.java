package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectByteMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectByteMutablePair.class */
public class ObjectByteMutablePair<K> implements ObjectBytePair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected byte right;

    public ObjectByteMutablePair(K left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectByteMutablePair<K> m574of(K left, byte right) {
        return new ObjectByteMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ObjectByteMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBytePair
    public ObjectByteMutablePair<K> right(byte r) {
        this.right = r;
        return this;
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
