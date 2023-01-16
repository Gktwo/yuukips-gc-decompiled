package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharFloatMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharFloatMutablePair.class */
public class CharFloatMutablePair implements CharFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected float right;

    public CharFloatMutablePair(char left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharFloatMutablePair m986of(char left, float right) {
        return new CharFloatMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharFloatPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharFloatPair
    public CharFloatMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharFloatPair
    public CharFloatMutablePair right(float r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharFloatPair ? this.left == ((CharFloatPair) other).leftChar() && this.right == ((CharFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + rightFloat() + ">";
    }
}
