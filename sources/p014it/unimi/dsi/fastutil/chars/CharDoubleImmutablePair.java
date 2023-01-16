package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharDoubleImmutablePair.class */
public class CharDoubleImmutablePair implements CharDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final double right;

    public CharDoubleImmutablePair(char left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharDoubleImmutablePair m990of(char left, double right) {
        return new CharDoubleImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharDoublePair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharDoublePair
    public double rightDouble() {
        return this.right;
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
