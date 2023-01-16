package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanBooleanMutablePair.class */
public class BooleanBooleanMutablePair implements BooleanBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected boolean right;

    public BooleanBooleanMutablePair(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanBooleanMutablePair m1161of(boolean left, boolean right) {
        return new BooleanBooleanMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBooleanPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBooleanPair
    public BooleanBooleanMutablePair left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBooleanPair
    public BooleanBooleanMutablePair right(boolean r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanBooleanPair ? this.left == ((BooleanBooleanPair) other).leftBoolean() && this.right == ((BooleanBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + rightBoolean() + ">";
    }
}
