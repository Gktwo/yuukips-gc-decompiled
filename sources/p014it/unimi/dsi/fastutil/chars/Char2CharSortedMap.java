package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2CharMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharSortedMap.class */
public interface Char2CharSortedMap extends Char2CharMap, SortedMap<Character, Character> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2CharMap.Entry>, Char2CharMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Char2CharMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2CharMap.Entry> fastIterator(Char2CharMap.Entry entry);
    }

    Char2CharSortedMap subMap(char c, char c2);

    Char2CharSortedMap headMap(char c);

    Char2CharSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2CharMap.Entry> char2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
    CharCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2CharSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2CharSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2CharSortedMap tailMap(Character from) {
        return tailMap(from.charValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Character firstKey() {
        return Character.valueOf(firstCharKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Character lastKey() {
        return Character.valueOf(lastCharKey());
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Character>> entrySet() {
        return char2CharEntrySet();
    }
}
