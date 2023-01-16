package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2LongMap;
import p014it.unimi.dsi.fastutil.longs.LongCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2LongSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2LongSortedMap.class */
public interface Char2LongSortedMap extends Char2LongMap, SortedMap<Character, Long> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2LongSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2LongSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2LongMap.Entry>, Char2LongMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2LongMap.FastEntrySet
        ObjectBidirectionalIterator<Char2LongMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2LongMap.Entry> fastIterator(Char2LongMap.Entry entry);
    }

    Char2LongSortedMap subMap(char c, char c2);

    Char2LongSortedMap headMap(char c);

    Char2LongSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2LongMap.Entry> char2LongEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2LongMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2LongMap, java.util.Map
    LongCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2LongSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2LongSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2LongSortedMap tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2LongMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Long>> entrySet() {
        return char2LongEntrySet();
    }
}
