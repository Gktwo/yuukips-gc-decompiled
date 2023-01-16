package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.bytes.ByteCollection;
import p014it.unimi.dsi.fastutil.chars.Char2ByteMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteSortedMap.class */
public interface Char2ByteSortedMap extends Char2ByteMap, SortedMap<Character, Byte> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2ByteMap.Entry>, Char2ByteMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap.FastEntrySet
        ObjectBidirectionalIterator<Char2ByteMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2ByteMap.Entry> fastIterator(Char2ByteMap.Entry entry);
    }

    Char2ByteSortedMap subMap(char c, char c2);

    Char2ByteSortedMap headMap(char c);

    Char2ByteSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2ByteMap.Entry> char2ByteEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    ByteCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2ByteSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2ByteSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2ByteSortedMap tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Byte>> entrySet() {
        return char2ByteEntrySet();
    }
}
