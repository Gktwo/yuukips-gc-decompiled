package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanDoubleImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanDoubleImmutablePair.class */
public class BooleanDoubleImmutablePair implements BooleanDoublePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final boolean left;
    protected final double right;

    public BooleanDoubleImmutablePair(boolean left, double right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanDoubleImmutablePair m1153of(boolean left, double right) {
        return new BooleanDoubleImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanDoublePair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanDoublePair
    public double rightDouble() {
        return this.right;
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
