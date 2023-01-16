package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanShortMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanShortMutablePair.class */
public class BooleanShortMutablePair implements BooleanShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected short right;

    public BooleanShortMutablePair(boolean left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanShortMutablePair m1116of(boolean left, short right) {
        return new BooleanShortMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanShortPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanShortPair
    public BooleanShortMutablePair left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanShortPair
    public BooleanShortMutablePair right(short r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanShortPair ? this.left == ((BooleanShortPair) other).leftBoolean() && this.right == ((BooleanShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + ((int) rightShort()) + ">";
    }
}
