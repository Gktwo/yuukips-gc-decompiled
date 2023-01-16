package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanByteMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanByteMutablePair.class */
public class BooleanByteMutablePair implements BooleanBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected byte right;

    public BooleanByteMutablePair(boolean left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanByteMutablePair m1158of(boolean left, byte right) {
        return new BooleanByteMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBytePair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBytePair
    public BooleanByteMutablePair left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBytePair
    public BooleanByteMutablePair right(byte r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanBytePair ? this.left == ((BooleanBytePair) other).leftBoolean() && this.right == ((BooleanBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + ((int) rightByte()) + ">";
    }
}
