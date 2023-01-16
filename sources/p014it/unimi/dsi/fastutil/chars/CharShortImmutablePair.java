package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharShortImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharShortImmutablePair.class */
public class CharShortImmutablePair implements CharShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final short right;

    public CharShortImmutablePair(char left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharShortImmutablePair m947of(char left, short right) {
        return new CharShortImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharShortPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharShortPair ? this.left == ((CharShortPair) other).leftChar() && this.right == ((CharShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + ((int) rightShort()) + ">";
    }
}
