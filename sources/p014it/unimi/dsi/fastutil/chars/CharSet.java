package p014it.unimi.dsi.fastutil.chars;

import java.util.Set;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.chars.CharSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSet.class */
public interface CharSet extends CharCollection, Set<Character> {
    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
    CharIterator iterator();

    boolean remove(char c);

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
    default CharSpliterator spliterator() {
        return CharSpliterators.asSpliterator(iterator(), Size64.sizeOf(this), 321);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
    @Deprecated
    default boolean remove(Object o) {
        return remove(o);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    default boolean add(Character o) {
        return add(o);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection
    @Deprecated
    default boolean contains(Object o) {
        return contains(o);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.CharCollection
    @Deprecated
    default boolean rem(char k) {
        return remove(k);
    }

    /* renamed from: of */
    static CharSet m953of() {
        return CharSets.UNMODIFIABLE_EMPTY_SET;
    }

    /* renamed from: of */
    static CharSet m952of(char e) {
        return CharSets.singleton(e);
    }

    /* renamed from: of */
    static CharSet m951of(char e0, char e1) {
        CharArraySet innerSet = new CharArraySet(2);
        innerSet.add(e0);
        if (innerSet.add(e1)) {
            return CharSets.unmodifiable(innerSet);
        }
        throw new IllegalArgumentException("Duplicate element: " + e1);
    }

    /* renamed from: of */
    static CharSet m950of(char e0, char e1, char e2) {
        CharArraySet innerSet = new CharArraySet(3);
        innerSet.add(e0);
        if (!innerSet.add(e1)) {
            throw new IllegalArgumentException("Duplicate element: " + e1);
        } else if (innerSet.add(e2)) {
            return CharSets.unmodifiable(innerSet);
        } else {
            throw new IllegalArgumentException("Duplicate element: " + e2);
        }
    }

    /* renamed from: of */
    static CharSet m949of(char... a) {
        switch (a.length) {
            case 0:
                return m953of();
            case 1:
                return m952of(a[0]);
            case 2:
                return m951of(a[0], a[1]);
            case 3:
                return m950of(a[0], a[1], a[2]);
            default:
                CharSet innerSet = a.length <= 4 ? new CharArraySet(a.length) : new CharOpenHashSet(a.length);
                for (char element : a) {
                    if (!innerSet.add(element)) {
                        throw new IllegalArgumentException("Duplicate element: " + element);
                    }
                }
                return CharSets.unmodifiable(innerSet);
        }
    }
}
