package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharObjectImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharObjectImmutablePair.class */
public class CharObjectImmutablePair<V> implements CharObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final V right;

    public CharObjectImmutablePair(char left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> CharObjectImmutablePair<V> m966of(char left, V right) {
        return new CharObjectImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharObjectPair
    public char leftChar() {
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
        return other instanceof CharObjectPair ? this.left == ((CharObjectPair) other).leftChar() && Objects.equals(this.right, ((CharObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + right() + ">";
    }
}
