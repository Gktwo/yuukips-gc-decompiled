package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanObjectImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanObjectImmutablePair.class */
public class BooleanObjectImmutablePair<V> implements BooleanObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final boolean left;
    protected final V right;

    public BooleanObjectImmutablePair(boolean left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> BooleanObjectImmutablePair<V> m1134of(boolean left, V right) {
        return new BooleanObjectImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanObjectPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanObjectPair ? this.left == ((BooleanObjectPair) other).leftBoolean() && Objects.equals(this.right, ((BooleanObjectPair) other).right()) : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && Objects.equals(this.right, ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + (this.right == null ? 0 : this.right.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + right() + ">";
    }
}
