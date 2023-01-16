package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortShortImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortShortImmutablePair.class */
public class ShortShortImmutablePair implements ShortShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final short left;
    protected final short right;

    public ShortShortImmutablePair(short left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortShortImmutablePair m386of(short left, short right) {
        return new ShortShortImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortShortPair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortShortPair ? this.left == ((ShortShortPair) other).leftShort() && this.right == ((ShortShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + ((int) rightShort()) + ">";
    }
}
