package p014it.unimi.dsi.fastutil.ints;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntBooleanMutablePair.class */
public class IntBooleanMutablePair implements IntBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected int left;
    protected boolean right;

    public IntBooleanMutablePair(int left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntBooleanMutablePair m747of(int left, boolean right) {
        return new IntBooleanMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBooleanPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBooleanPair
    public IntBooleanMutablePair left(int l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntBooleanPair
    public IntBooleanMutablePair right(boolean r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntBooleanPair ? this.left == ((IntBooleanPair) other).leftInt() && this.right == ((IntBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + rightBoolean() + ">";
    }
}
