package p014it.unimi.dsi.fastutil.chars;

import java.util.ListIterator;

/* renamed from: it.unimi.dsi.fastutil.chars.CharListIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharListIterator.class */
public interface CharListIterator extends CharBidirectionalIterator, ListIterator<Character> {
    default void set(char k) {
        throw new UnsupportedOperationException();
    }

    default void add(char k) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    default void remove() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default void set(Character k) {
        set(k.charValue());
    }

    @Deprecated
    default void add(Character k) {
        add(k.charValue());
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharIterator, java.util.Iterator
    @Deprecated
    default Character next() {
        return next();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharBidirectionalIterator, p014it.unimi.dsi.fastutil.BidirectionalIterator
    @Deprecated
    default Character previous() {
        return previous();
    }
}
