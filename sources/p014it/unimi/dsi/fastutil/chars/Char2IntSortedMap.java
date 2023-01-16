package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2IntMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2IntSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntSortedMap.class */
public interface Char2IntSortedMap extends Char2IntMap, SortedMap<Character, Integer> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2IntMap.Entry>, Char2IntMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap.FastEntrySet
        ObjectBidirectionalIterator<Char2IntMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2IntMap.Entry> fastIterator(Char2IntMap.Entry entry);
    }

    Char2IntSortedMap subMap(char c, char c2);

    Char2IntSortedMap headMap(char c);

    Char2IntSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2IntMap.Entry> char2IntEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap, java.util.Map
    IntCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2IntSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2IntSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2IntSortedMap tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Integer>> entrySet() {
        return char2IntEntrySet();
    }
}
