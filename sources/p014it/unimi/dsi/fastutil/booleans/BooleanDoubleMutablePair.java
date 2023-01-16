package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanDoubleMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanDoubleMutablePair.class */
public class BooleanDoubleMutablePair implements BooleanDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected double right;

    public BooleanDoubleMutablePair(boolean left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanDoubleMutablePair m1152of(boolean left, double right) {
        return new BooleanDoubleMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanDoublePair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanDoublePair
    public BooleanDoubleMutablePair left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanDoublePair
    public double rightDouble() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanDoublePair
    public BooleanDoubleMutablePair right(double r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanDoublePair ? this.left == ((BooleanDoublePair) other).leftBoolean() && this.right == ((BooleanDoublePair) other).rightDouble() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Double.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + HashCommon.double2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + rightDouble() + ">";
    }
}
