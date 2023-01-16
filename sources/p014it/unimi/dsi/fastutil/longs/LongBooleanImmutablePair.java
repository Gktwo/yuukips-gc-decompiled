package p014it.unimi.dsi.fastutil.longs;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongBooleanImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongBooleanImmutablePair.class */
public class LongBooleanImmutablePair implements LongBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final long left;
    protected final boolean right;

    public LongBooleanImmutablePair(long left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongBooleanImmutablePair m663of(long left, boolean right) {
        return new LongBooleanImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBooleanPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongBooleanPair ? this.left == ((LongBooleanPair) other).leftLong() && this.right == ((LongBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + rightBoolean() + ">";
    }
}
