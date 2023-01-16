package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLongMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLongMutablePair.class */
public class DoubleLongMutablePair implements DoubleLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected double left;
    protected long right;

    public DoubleLongMutablePair(double left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleLongMutablePair m883of(double left, long right) {
        return new DoubleLongMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
    public DoubleLongMutablePair left(double l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
    public DoubleLongMutablePair right(long r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleLongPair ? this.left == ((DoubleLongPair) other).leftDouble() && this.right == ((DoubleLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + rightLong() + ">";
    }
}
