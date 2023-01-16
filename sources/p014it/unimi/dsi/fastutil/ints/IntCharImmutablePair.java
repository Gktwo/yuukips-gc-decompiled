package p014it.unimi.dsi.fastutil.ints;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.ints.IntCharImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntCharImmutablePair.class */
public class IntCharImmutablePair implements IntCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final int left;
    protected final char right;

    public IntCharImmutablePair(int left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static IntCharImmutablePair m742of(int left, char right) {
        return new IntCharImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCharPair
    public int leftInt() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.IntCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof IntCharPair ? this.left == ((IntCharPair) other).leftInt() && this.right == ((IntCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Integer.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftInt() + "," + rightChar() + ">";
    }
}
