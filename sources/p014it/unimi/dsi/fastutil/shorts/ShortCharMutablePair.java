package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortCharMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCharMutablePair.class */
public class ShortCharMutablePair implements ShortCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected short left;
    protected char right;

    public ShortCharMutablePair(short left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortCharMutablePair m431of(short left, char right) {
        return new ShortCharMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
    public ShortCharMutablePair left(short l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
    public ShortCharMutablePair right(char r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortCharPair ? this.left == ((ShortCharPair) other).leftShort() && this.right == ((ShortCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + rightChar() + ">";
    }
}
