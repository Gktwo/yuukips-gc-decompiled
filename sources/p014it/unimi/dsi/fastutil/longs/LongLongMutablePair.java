package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongLongMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongLongMutablePair.class */
public class LongLongMutablePair implements LongLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected long left;
    protected long right;

    public LongLongMutablePair(long left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongLongMutablePair m631of(long left, long right) {
        return new LongLongMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongLongPair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongLongPair
    public LongLongMutablePair left(long l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongLongPair
    public LongLongMutablePair right(long r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongLongPair ? this.left == ((LongLongPair) other).leftLong() && this.right == ((LongLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + rightLong() + ">";
    }
}
