package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharCharMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharCharMutablePair.class */
public class CharCharMutablePair implements CharCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected char right;

    public CharCharMutablePair(char left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharCharMutablePair m993of(char left, char right) {
        return new CharCharMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCharPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCharPair
    public CharCharMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCharPair
    public CharCharMutablePair right(char r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharCharPair ? this.left == ((CharCharPair) other).leftChar() && this.right == ((CharCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + rightChar() + ">";
    }
}
