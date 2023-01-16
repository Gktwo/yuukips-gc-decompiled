package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanReferenceMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanReferenceMutablePair.class */
public class BooleanReferenceMutablePair<V> implements BooleanReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected boolean left;
    protected V right;

    public BooleanReferenceMutablePair(boolean left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> BooleanReferenceMutablePair<V> m1124of(boolean left, V right) {
        return new BooleanReferenceMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanReferencePair
    public boolean leftBoolean() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanReferencePair
    public BooleanReferenceMutablePair<V> left(boolean l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public V right() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public BooleanReferenceMutablePair<V> right(V r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof BooleanReferencePair ? this.left == ((BooleanReferencePair) other).leftBoolean() && this.right == ((BooleanReferencePair) other).right() : (other instanceof Pair) && Objects.equals(Boolean.valueOf(this.left), ((Pair) other).left()) && this.right == ((Pair) other).right();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE) * 19) + (this.right == null ? 0 : System.identityHashCode(this.right));
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftBoolean() + "," + right() + ">";
    }
}
