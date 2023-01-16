package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharCharImmutableSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharCharImmutableSortedPair.class */
public class CharCharImmutableSortedPair extends CharCharImmutablePair implements CharCharSortedPair, Serializable {
    private static final long serialVersionUID = 0;

    private CharCharImmutableSortedPair(char left, char right) {
        super(left, right);
    }

    /* renamed from: of */
    public static CharCharImmutableSortedPair m994of(char left, char right) {
        return left <= right ? new CharCharImmutableSortedPair(left, right) : new CharCharImmutableSortedPair(right, left);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCharImmutablePair, java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof CharCharSortedPair ? this.left == ((CharCharSortedPair) other).leftChar() && this.right == ((CharCharSortedPair) other).rightChar() : (other instanceof SortedPair) && Objects.equals(Character.valueOf(this.left), ((SortedPair) other).left()) && Objects.equals(Character.valueOf(this.right), ((SortedPair) other).right());
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCharImmutablePair, java.lang.Object
    public String toString() {
        return "{" + leftChar() + "," + rightChar() + "}";
    }
}
