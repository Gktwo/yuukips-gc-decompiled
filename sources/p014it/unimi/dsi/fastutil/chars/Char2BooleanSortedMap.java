package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.booleans.BooleanCollection;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanSortedMap.class */
public interface Char2BooleanSortedMap extends Char2BooleanMap, SortedMap<Character, Boolean> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Char2BooleanMap.Entry>, Char2BooleanMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap.FastEntrySet
        ObjectBidirectionalIterator<Char2BooleanMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Char2BooleanMap.Entry> fastIterator(Char2BooleanMap.Entry entry);
    }

    Char2BooleanSortedMap subMap(char c, char c2);

    Char2BooleanSortedMap headMap(char c);

    Char2BooleanSortedMap tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2BooleanMap.Entry> char2BooleanEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
    BooleanCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2BooleanSortedMap subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2BooleanSortedMap headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2BooleanSortedMap tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, Boolean>> entrySet() {
        return char2BooleanEntrySet();
    }
}
