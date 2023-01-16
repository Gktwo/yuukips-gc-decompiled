package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharReferenceMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharReferenceMutablePair.class */
public class CharReferenceMutablePair<V> implements CharReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected V right;

    public CharReferenceMutablePair(char left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> CharReferenceMutablePair<V> m955of(char left, V right) {
        return new CharReferenceMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharReferencePair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharReferencePair
    public CharReferenceMutablePair<V> left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public CharReferenceMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharReferencePair ? this.left == ((CharReferencePair) other).leftChar() && this.right == ((CharReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + right() + ">";
    }
}
