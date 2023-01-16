package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortDoubleMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortDoubleMutablePair.class */
public class ShortDoubleMutablePair implements ShortDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected short left;
    protected double right;

    public ShortDoubleMutablePair(short left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortDoubleMutablePair m428of(short left, double right) {
        return new ShortDoubleMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortDoublePair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortDoublePair
    public ShortDoubleMutablePair left(short l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortDoublePair
    public ShortDoubleMutablePair right(double r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortDoublePair ? this.left == ((ShortDoublePair) other).leftShort() && this.right == ((ShortDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + rightDouble() + ">";
    }
}
