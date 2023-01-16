package p014it.unimi.dsi.fastutil.shorts;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortByteImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortByteImmutablePair.class */
public class ShortByteImmutablePair implements ShortBytePair, Serializable {
    private static final long serialVersionUID = 0;
    protected final short left;
    protected final byte right;

    public ShortByteImmutablePair(short left, byte right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static ShortByteImmutablePair m435of(short left, byte right) {
        return new ShortByteImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBytePair
    public short leftShort() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.ShortBytePair
    public byte rightByte() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ShortBytePair ? this.left == ((ShortBytePair) other).leftShort() && this.right == ((ShortBytePair) other).rightByte() : (other instanceof Pair) && Objects.equals(Short.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Byte.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + this.right;
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + ((int) leftShort()) + "," + ((int) rightByte()) + ">";
    }
}
