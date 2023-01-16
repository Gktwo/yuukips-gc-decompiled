package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharFloatImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharFloatImmutablePair.class */
public class CharFloatImmutablePair implements CharFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final float right;

    public CharFloatImmutablePair(char left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharFloatImmutablePair m987of(char left, float right) {
        return new CharFloatImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharFloatPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharFloatPair
    public float rightFloat() {
        return this.right;
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
