package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIntImmutablePair.class */
public class CharIntImmutablePair implements CharIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final int right;

    public CharIntImmutablePair(char left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharIntImmutablePair m982of(char left, int right) {
        return new CharIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIntPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharIntPair ? this.left == ((CharIntPair) other).leftChar() && this.right == ((CharIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + rightInt() + ">";
    }
}
