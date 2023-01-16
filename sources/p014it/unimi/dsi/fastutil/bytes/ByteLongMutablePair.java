package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteLongMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLongMutablePair.class */
public class ByteLongMutablePair implements ByteLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected byte left;
    protected long right;

    public ByteLongMutablePair(byte left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteLongMutablePair m1053of(byte left, long right) {
        return new ByteLongMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteLongPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteLongPair
    public ByteLongMutablePair left(byte l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteLongPair
    public long rightLong() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteLongPair
    public ByteLongMutablePair right(long r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ByteLongPair ? this.left == ((ByteLongPair) other).leftByte() && this.right == ((ByteLongPair) other).rightLong() : (other instanceof Pair) && Objects.equals(Byte.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Long.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + HashCommon.long2int(this.right);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftByte()) + "," + rightLong() + ">";
    }
}
