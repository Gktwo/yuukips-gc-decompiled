package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharByteImmutablePair.class */
public class CharByteImmutablePair implements CharBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final byte right;

    public CharByteImmutablePair(char left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharByteImmutablePair m998of(char left, byte right) {
        return new CharByteImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBytePair
    public byte rightByte() {
        return this.right;
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
