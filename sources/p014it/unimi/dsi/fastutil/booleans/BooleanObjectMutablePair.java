package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanObjectMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanObjectMutablePair.class */
public class BooleanObjectMutablePair<V> implements BooleanObjectPair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected V right;

    public BooleanObjectMutablePair(boolean left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> BooleanObjectMutablePair<V> m1133of(boolean left, V right) {
        return new BooleanObjectMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanObjectPair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanObjectPair
    public BooleanObjectMutablePair<V> left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public BooleanObjectMutablePair<V> right(V r) {
        this.right = r;
        return this;
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
