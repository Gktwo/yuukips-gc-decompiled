package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortCharImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortCharImmutablePair.class */
public class ShortCharImmutablePair implements ShortCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final short left;
    protected final char right;

    public ShortCharImmutablePair(short left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortCharImmutablePair m432of(short left, char right) {
        return new ShortCharImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortCharPair
    public char rightChar() {
        return this.right;
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
