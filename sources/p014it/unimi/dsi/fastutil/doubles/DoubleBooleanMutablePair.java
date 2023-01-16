package p014it.unimi.dsi.fastutil.doubles;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleBooleanMutablePair.class */
public class DoubleBooleanMutablePair implements DoubleBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected double left;
    protected boolean right;

    public DoubleBooleanMutablePair(double left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static DoubleBooleanMutablePair m915of(double left, boolean right) {
        return new DoubleBooleanMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBooleanPair
    public double leftDouble() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBooleanPair
    public DoubleBooleanMutablePair left(double l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.DoubleBooleanPair
    public DoubleBooleanMutablePair right(boolean r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof DoubleBooleanPair ? this.left == ((DoubleBooleanPair) other).leftDouble() && this.right == ((DoubleBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Double.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.double2int(this.left) * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftDouble() + "," + rightBoolean() + ">";
    }
}
