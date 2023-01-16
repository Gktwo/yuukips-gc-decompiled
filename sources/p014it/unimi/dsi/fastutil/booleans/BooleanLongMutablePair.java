package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanLongMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanLongMutablePair.class */
public class BooleanLongMutablePair implements BooleanLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected long right;

    public BooleanLongMutablePair(boolean left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanLongMutablePair m1136of(boolean left, long right) {
        return new BooleanLongMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanLongPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanLongPair
    public BooleanLongMutablePair left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanLongPair
    public BooleanLongMutablePair right(long r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanLongPair ? this.left == ((BooleanLongPair) other).leftBoolean() && this.right == ((BooleanLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + rightLong() + ">";
    }
}
