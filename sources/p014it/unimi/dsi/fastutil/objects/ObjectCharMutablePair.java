package p014it.unimi.dsi.fastutil.objects;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectCharMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectCharMutablePair.class */
public class ObjectCharMutablePair<K> implements ObjectCharPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected char right;

    public ObjectCharMutablePair(K left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectCharMutablePair<K> m571of(K left, char right) {
        return new ObjectCharMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ObjectCharMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectCharPair
    public ObjectCharMutablePair<K> right(char r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectCharPair ? Objects.equals(this.left, ((ObjectCharPair) other).left()) && this.right == ((ObjectCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightChar() + ">";
    }
}
