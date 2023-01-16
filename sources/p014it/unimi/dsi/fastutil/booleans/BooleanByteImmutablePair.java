package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanByteImmutablePair.class */
public class BooleanByteImmutablePair implements BooleanBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final boolean left;
    protected final byte right;

    public BooleanByteImmutablePair(boolean left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanByteImmutablePair m1159of(boolean left, byte right) {
        return new BooleanByteImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBytePair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanBytePair
    public byte rightByte() {
        return this.right;
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
