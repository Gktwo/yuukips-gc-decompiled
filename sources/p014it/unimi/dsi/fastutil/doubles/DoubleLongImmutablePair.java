package p014it.unimi.dsi.fastutil.doubles;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleLongImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleLongImmutablePair.class */
public class DoubleLongImmutablePair implements DoubleLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final double left;
    protected final long right;

    public DoubleLongImmutablePair(double left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleLongImmutablePair m884of(double left, long right) {
        return new DoubleLongImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleLongPair
    public long rightLong() {
        return this.right;
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
