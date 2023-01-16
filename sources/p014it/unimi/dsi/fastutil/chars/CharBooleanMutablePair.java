package p014it.unimi.dsi.fastutil.chars;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharBooleanMutablePair.class */
public class CharBooleanMutablePair implements CharBooleanPair, Serializable {
    private static final long serialVersionUID = 0;
    protected char left;
    protected boolean right;

    public CharBooleanMutablePair(char left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static CharBooleanMutablePair m1000of(char left, boolean right) {
        return new CharBooleanMutablePair(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
    public char leftChar() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
    public CharBooleanMutablePair left(char l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBooleanPair
    public CharBooleanMutablePair right(boolean r) {
        this.right = r;
        return this;
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
