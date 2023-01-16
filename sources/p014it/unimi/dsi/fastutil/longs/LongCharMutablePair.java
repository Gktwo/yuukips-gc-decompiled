package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongCharMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongCharMutablePair.class */
public class LongCharMutablePair implements LongCharPair, Serializable {
    private static final long serialVersionUID = 0;
    protected long left;
    protected char right;

    public LongCharMutablePair(long left, char right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongCharMutablePair m656of(long left, char right) {
        return new LongCharMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
    public LongCharMutablePair left(long l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
    public char rightChar() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongCharPair
    public LongCharMutablePair right(char r) {
        this.right = r;
        return this;
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
