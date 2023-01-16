package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntShortImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntShortImmutablePair.class */
public class IntShortImmutablePair implements IntShortPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final int left;
    protected final short right;

    public IntShortImmutablePair(int left, short right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntShortImmutablePair m694of(int left, short right) {
        return new IntShortImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntShortPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntShortPair
    public short rightShort() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntShortPair ? this.left == ((IntShortPair) other).leftInt() && this.right == ((IntShortPair) other).rightShort() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Short.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + ((int) rightShort()) + ">";
    }
}
