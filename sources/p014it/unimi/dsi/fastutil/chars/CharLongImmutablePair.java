package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharLongImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLongImmutablePair.class */
public class CharLongImmutablePair implements CharLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final long right;

    public CharLongImmutablePair(char left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharLongImmutablePair m969of(char left, long right) {
        return new CharLongImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharLongPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharLongPair ? this.left == ((CharLongPair) other).leftChar() && this.right == ((CharLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + rightLong() + ">";
    }
}
