package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongCharImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCharImmutablePair.class */
public class LongCharImmutablePair implements LongCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final long left;
    protected final char right;

    public LongCharImmutablePair(long left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongCharImmutablePair m657of(long left, char right) {
        return new LongCharImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongCharPair ? this.left == ((LongCharPair) other).leftLong() && this.right == ((LongCharPair) other).rightChar() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Character.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + rightChar() + ">";
    }
}
