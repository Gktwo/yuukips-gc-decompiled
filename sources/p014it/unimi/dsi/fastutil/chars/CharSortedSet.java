package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.SortedSet;
import p014it.unimi.dsi.fastutil.Size64;

/* renamed from: it.unimi.dsi.fastutil.chars.CharSortedSet */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharSortedSet.class */
public interface CharSortedSet extends CharSet, SortedSet<Character>, CharBidirectionalIterable {
    CharBidirectionalIterator iterator(char c);

    @Override // p014it.unimi.dsi.fastutil.chars.CharSet, p014it.unimi.dsi.fastutil.chars.CharCollection, java.util.Collection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
    CharBidirectionalIterator iterator();

    CharSortedSet subSet(char c, char c2);

    CharSortedSet headSet(char c);

    CharSortedSet tailSet(char c);

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedSet
    Comparator<? super Character> comparator();

    char firstChar();

    char lastChar();

    /* JADX WARN: Type inference failed for: r3v1, types: [it.unimi.dsi.fastutil.chars.CharComparator] */
    @Override // p014it.unimi.dsi.fastutil.chars.CharSet, p014it.unimi.dsi.fastutil.chars.CharCollection, java.lang.Iterable, p014it.unimi.dsi.fastutil.chars.CharIterable
    default CharSpliterator spliterator() {
        return CharSpliterators.asSpliteratorFromSorted(iterator(), Size64.sizeOf(this), 341, comparator());
    }

    @Deprecated
    default CharSortedSet subSet(Character from, Character to) {
        return subSet(from.charValue(), to.charValue());
    }

    @Deprecated
    default CharSortedSet headSet(Character to) {
        return headSet(to.charValue());
    }

    @Deprecated
    default CharSortedSet tailSet(Character from) {
        return tailSet(from.charValue());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Character first() {
        return Character.valueOf(firstChar());
    }

    @Override // java.util.SortedSet
    @Deprecated
    default Character last() {
        return Character.valueOf(lastChar());
    }
}
