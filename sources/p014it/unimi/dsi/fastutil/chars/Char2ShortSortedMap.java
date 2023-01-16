package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2ShortMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.ShortCollection;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortSortedMap.class */
public interface Char2ShortSortedMap extends Char2ShortMap, SortedMap<Character, Short> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2ShortMap.Entry>, Char2ShortMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMap.FastEntrySet
        ObjectBidirectionalIterator<Char2ShortMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2ShortMap.Entry> fastIterator(Char2ShortMap.Entry entry);
    }

    Char2ShortSortedMap subMap(char c, char c2);

    Char2ShortSortedMap headMap(char c);

    Char2ShortSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2ShortMap.Entry> char2ShortEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
    ShortCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2ShortSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2ShortSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2ShortSortedMap tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Short>> entrySet() {
        return char2ShortEntrySet();
    }
}
