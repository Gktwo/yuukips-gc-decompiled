package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharShortMutablePair.class */
public class CharShortMutablePair implements CharShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected short right;

    public CharShortMutablePair(char left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharShortMutablePair m946of(char left, short right) {
        return new CharShortMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharShortPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharShortPair
    public CharShortMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharShortPair
    public CharShortMutablePair right(short r) {
        this.right = r;
        return this;
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
