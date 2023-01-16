package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIntMutablePair.class */
public class CharIntMutablePair implements CharIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected int right;

    public CharIntMutablePair(char left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharIntMutablePair m981of(char left, int right) {
        return new CharIntMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIntPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIntPair
    public CharIntMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIntPair
    public CharIntMutablePair right(int r) {
        this.right = r;
        return this;
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
