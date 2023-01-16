package p014it.unimi.dsi.fastutil.chars;

import java.io.Serializable;
import p014it.unimi.dsi.fastutil.SortedPair;

/* renamed from: it.unimi.dsi.fastutil.chars.CharCharSortedPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharCharSortedPair.class */
public interface CharCharSortedPair extends CharCharPair, SortedPair<Character>, Serializable {
    /* renamed from: of */
    static CharCharSortedPair m991of(char left, char right) {
        return CharCharImmutableSortedPair.m994of(left, right);
    }

    default boolean contains(char e) {
        return e == leftChar() || e == rightChar();
    }

    @Override // p014it.unimi.dsi.fastutil.SortedPair
    @Deprecated
    default boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        return contains(((Character) o).charValue());
    }
}
