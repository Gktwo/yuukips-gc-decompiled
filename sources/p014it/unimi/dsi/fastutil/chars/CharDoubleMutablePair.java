package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharDoubleMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharDoubleMutablePair.class */
public class CharDoubleMutablePair implements CharDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected double right;

    public CharDoubleMutablePair(char left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharDoubleMutablePair m989of(char left, double right) {
        return new CharDoubleMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharDoublePair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharDoublePair
    public CharDoubleMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharDoublePair
    public CharDoubleMutablePair right(double r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharDoublePair ? this.left == ((CharDoublePair) other).leftChar() && this.right == ((CharDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + rightDouble() + ">";
    }
}
