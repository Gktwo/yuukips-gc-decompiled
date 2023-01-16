package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanFloatMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanFloatMutablePair.class */
public class BooleanFloatMutablePair implements BooleanFloatPair, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected float right;

    public BooleanFloatMutablePair(boolean left, float right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanFloatMutablePair m1149of(boolean left, float right) {
        return new BooleanFloatMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanFloatPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanFloatPair
    public BooleanFloatMutablePair left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanFloatPair
    public float rightFloat() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanFloatPair
    public BooleanFloatMutablePair right(float r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanFloatPair ? this.left == ((BooleanFloatPair) other).leftBoolean() && this.right == ((BooleanFloatPair) other).rightFloat() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Float.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + HashCommon.float2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + rightFloat() + ">";
    }
}
