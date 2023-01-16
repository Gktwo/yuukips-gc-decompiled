package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortLongImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortLongImmutablePair.class */
public class ShortLongImmutablePair implements ShortLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final short left;
    protected final long right;

    public ShortLongImmutablePair(short left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortLongImmutablePair m408of(short left, long right) {
        return new ShortLongImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortLongPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortLongPair ? this.left == ((ShortLongPair) other).leftShort() && this.right == ((ShortLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + rightLong() + ">";
    }
}
