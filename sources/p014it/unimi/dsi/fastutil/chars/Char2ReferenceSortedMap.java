package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.objects.ReferenceCollection;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceSortedMap.class */
public interface Char2ReferenceSortedMap<V> extends Char2ReferenceMap<V>, SortedMap<Character, V> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Char2ReferenceMap.Entry<V>>, Char2ReferenceMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap.FastEntrySet
        ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Char2ReferenceMap.Entry<V>> fastIterator(Char2ReferenceMap.Entry<V> entry);
    }

    Char2ReferenceSortedMap<V> subMap(char c, char c2);

    Char2ReferenceSortedMap<V> headMap(char c);

    Char2ReferenceSortedMap<V> tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2ReferenceMap.Entry<V>> char2ReferenceEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    ReferenceCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2ReferenceSortedMap<V> subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2ReferenceSortedMap<V> headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2ReferenceSortedMap<V> tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
        return char2ReferenceEntrySet();
    }
}
