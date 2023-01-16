package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIntImmutablePair.class */
public class ShortIntImmutablePair implements ShortIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final short left;
    protected final int right;

    public ShortIntImmutablePair(short left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortIntImmutablePair m421of(short left, int right) {
        return new ShortIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortIntPair ? this.left == ((ShortIntPair) other).leftShort() && this.right == ((ShortIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + rightInt() + ">";
    }
}
