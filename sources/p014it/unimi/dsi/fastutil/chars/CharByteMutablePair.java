package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharByteMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharByteMutablePair.class */
public class CharByteMutablePair implements CharBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected byte right;

    public CharByteMutablePair(char left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharByteMutablePair m997of(char left, byte right) {
        return new CharByteMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
    public CharByteMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
    public CharByteMutablePair right(byte r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharBytePair ? this.left == ((CharBytePair) other).leftChar() && this.right == ((CharBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + ((int) rightByte()) + ">";
    }
}
