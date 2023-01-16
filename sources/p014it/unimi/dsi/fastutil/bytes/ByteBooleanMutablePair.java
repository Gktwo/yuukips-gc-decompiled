package p014it.unimi.dsi.fastutil.bytes;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteBooleanMutablePair.class */
public class ByteBooleanMutablePair implements ByteBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected byte left;
    protected boolean right;

    public ByteBooleanMutablePair(byte left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteBooleanMutablePair m1085of(byte left, boolean right) {
        return new ByteBooleanMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBooleanPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBooleanPair
    public ByteBooleanMutablePair left(byte l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteBooleanPair
    public ByteBooleanMutablePair right(boolean r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteBooleanPair ? this.left == ((ByteBooleanPair) other).leftByte() && this.right == ((ByteBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + rightBoolean() + ">";
    }
}
