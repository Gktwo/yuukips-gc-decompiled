package p014it.unimi.dsi.fastutil.bytes;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.bytes.ByteLongImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/ByteLongImmutablePair.class */
public class ByteLongImmutablePair implements ByteLongPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final byte left;
    protected final long right;

    public ByteLongImmutablePair(byte left, long right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ByteLongImmutablePair m1054of(byte left, long right) {
        return new ByteLongImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteLongPair
    public byte leftByte() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.ByteLongPair
    public long rightLong() {
        return this.right;
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
