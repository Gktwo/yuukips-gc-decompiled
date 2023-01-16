package p014it.unimi.dsi.fastutil.booleans;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanReferenceImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanReferenceImmutablePair.class */
public class BooleanReferenceImmutablePair<V> implements BooleanReferencePair<V>, Serializable {
    private static final long serialVersionUID = 0;
    protected final boolean left;
    protected final V right;

    public BooleanReferenceImmutablePair(boolean left, V right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <V> BooleanReferenceImmutablePair<V> m1125of(boolean left, V right) {
        return new BooleanReferenceImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.booleans.BooleanReferencePair
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
