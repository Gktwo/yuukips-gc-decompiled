package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanCharImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanCharImmutablePair.class */
public class BooleanCharImmutablePair implements BooleanCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final boolean left;
    protected final char right;

    public BooleanCharImmutablePair(boolean left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static BooleanCharImmutablePair m1156of(boolean left, char right) {
        return new BooleanCharImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCharPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanCharPair ? this.left == ((BooleanCharPair) other).leftBoolean() && this.right == ((BooleanCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + rightChar() + ">";
    }
}
