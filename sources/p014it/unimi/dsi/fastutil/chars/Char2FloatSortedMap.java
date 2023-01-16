package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2FloatMap;
import p014it.unimi.dsi.fastutil.floats.FloatCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatSortedMap.class */
public interface Char2FloatSortedMap extends Char2FloatMap, SortedMap<Character, Float> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2FloatSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2FloatSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2FloatMap.Entry>, Char2FloatMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap.FastEntrySet
        ObjectBidirectionalIterator<Char2FloatMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2FloatMap.Entry> fastIterator(Char2FloatMap.Entry entry);
    }

    Char2FloatSortedMap subMap(char c, char c2);

    Char2FloatSortedMap headMap(char c);

    Char2FloatSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2FloatMap.Entry> char2FloatEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
    FloatCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2FloatSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2FloatSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2FloatSortedMap tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2FloatMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Float>> entrySet() {
        return char2FloatEntrySet();
    }
}
