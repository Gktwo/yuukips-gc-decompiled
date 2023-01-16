package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortIntMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortIntMutablePair.class */
public class ShortIntMutablePair implements ShortIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected short left;
    protected int right;

    public ShortIntMutablePair(short left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortIntMutablePair m420of(short left, int right) {
        return new ShortIntMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
    public ShortIntMutablePair left(short l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortIntPair
    public ShortIntMutablePair right(int r) {
        this.right = r;
        return this;
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
