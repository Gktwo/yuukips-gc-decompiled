package p014it.unimi.dsi.fastutil.longs;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.HashCommon;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.longs.LongByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongByteImmutablePair.class */
public class LongByteImmutablePair implements LongBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final long left;
    protected final byte right;

    public LongByteImmutablePair(long left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static LongByteImmutablePair m660of(long left, byte right) {
        return new LongByteImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBytePair
    public long leftLong() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.LongBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof LongBytePair ? this.left == ((LongBytePair) other).leftLong() && this.right == ((LongBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Long.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (HashCommon.long2int(this.left) * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftLong() + "," + ((int) rightByte()) + ">";
    }
}
