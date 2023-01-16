package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceCharMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceCharMutablePair.class */
public class ReferenceCharMutablePair<K> implements ReferenceCharPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected char right;

    public ReferenceCharMutablePair(K left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceCharMutablePair<K> m511of(K left, char right) {
        return new ReferenceCharMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ReferenceCharMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceCharPair
    public ReferenceCharMutablePair<K> right(char r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceCharPair ? this.left == ((ReferenceCharPair) other).left() && this.right == ((ReferenceCharPair) other).rightChar() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightChar() + ">";
    }
}
