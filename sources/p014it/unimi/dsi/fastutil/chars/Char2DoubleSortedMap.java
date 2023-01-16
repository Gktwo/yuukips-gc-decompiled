package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleMap;
import p014it.unimi.dsi.fastutil.doubles.DoubleCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleSortedMap.class */
public interface Char2DoubleSortedMap extends Char2DoubleMap, SortedMap<Character, Double> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2DoubleSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2DoubleSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2DoubleMap.Entry>, Char2DoubleMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMap.FastEntrySet
        ObjectBidirectionalIterator<Char2DoubleMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2DoubleMap.Entry> fastIterator(Char2DoubleMap.Entry entry);
    }

    Char2DoubleSortedMap subMap(char c, char c2);

    Char2DoubleSortedMap headMap(char c);

    Char2DoubleSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2DoubleMap.Entry> char2DoubleEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
    DoubleCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2DoubleSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2DoubleSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2DoubleSortedMap tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2DoubleMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Double>> entrySet() {
        return char2DoubleEntrySet();
    }
}
