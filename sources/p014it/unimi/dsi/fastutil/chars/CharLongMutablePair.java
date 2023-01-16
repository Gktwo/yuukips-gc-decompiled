package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharLongMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharLongMutablePair.class */
public class CharLongMutablePair implements CharLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected long right;

    public CharLongMutablePair(char left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharLongMutablePair m968of(char left, long right) {
        return new CharLongMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharLongPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharLongPair
    public CharLongMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharLongPair
    public CharLongMutablePair right(long r) {
        this.right = r;
        return this;
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
