package p014it.unimi.dsi.fastutil.chars;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharBooleanImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBooleanImmutablePair.class */
public class CharBooleanImmutablePair implements CharBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected final char left;
    protected final boolean right;

    public CharBooleanImmutablePair(char left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharBooleanImmutablePair m1001of(char left, boolean right) {
        return new CharBooleanImmutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharBooleanPair ? this.left == ((CharBooleanPair) other).leftChar() && this.right == ((CharBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(Character.valueOf(this.left), ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.left * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + leftChar() + "," + rightBoolean() + ">";
    }
}
