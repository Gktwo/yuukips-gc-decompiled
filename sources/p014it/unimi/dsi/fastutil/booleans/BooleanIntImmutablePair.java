package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanIntImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanIntImmutablePair.class */
public class BooleanIntImmutablePair implements BooleanIntPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final boolean left;
    protected final int right;

    public BooleanIntImmutablePair(boolean left, int right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanIntImmutablePair m1145of(boolean left, int right) {
        return new BooleanIntImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIntPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIntPair
    public int rightInt() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanIntPair ? this.left == ((BooleanIntPair) other).leftBoolean() && this.right == ((BooleanIntPair) other).rightInt() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Integer.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + rightInt() + ">";
    }
}
