package p014it.unimi.dsi.fastutil.shorts;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortBooleanMutablePair.class */
public class ShortBooleanMutablePair implements ShortBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected short left;
    protected boolean right;

    public ShortBooleanMutablePair(short left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortBooleanMutablePair m437of(short left, boolean right) {
        return new ShortBooleanMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBooleanPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBooleanPair
    public ShortBooleanMutablePair left(short l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBooleanPair
    public ShortBooleanMutablePair right(boolean r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortBooleanPair ? this.left == ((ShortBooleanPair) other).leftShort() && this.right == ((ShortBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + rightBoolean() + ">";
    }
}
