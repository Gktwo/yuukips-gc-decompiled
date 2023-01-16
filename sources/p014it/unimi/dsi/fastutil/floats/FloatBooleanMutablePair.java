package p014it.unimi.dsi.fastutil.floats;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatBooleanMutablePair.class */
public class FloatBooleanMutablePair implements FloatBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected float left;
    protected boolean right;

    public FloatBooleanMutablePair(float left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static FloatBooleanMutablePair m831of(float left, boolean right) {
        return new FloatBooleanMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBooleanPair
    public float leftFloat() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBooleanPair
    public FloatBooleanMutablePair left(float l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.floats.FloatBooleanPair
    public FloatBooleanMutablePair right(boolean r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof FloatBooleanPair ? this.left == ((FloatBooleanPair) other).leftFloat() && this.right == ((FloatBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Float.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.float2int(this.left) * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftFloat() + "," + rightBoolean() + ">";
    }
}
