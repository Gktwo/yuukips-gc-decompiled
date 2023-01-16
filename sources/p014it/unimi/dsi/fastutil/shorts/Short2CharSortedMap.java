package p014it.unimi.dsi.fastutil.shorts;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.CharCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import p014it.unimi.dsi.fastutil.shorts.Short2CharMap;

/* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharSortedMap.class */
public interface Short2CharSortedMap extends Short2CharMap, SortedMap<Short, Character> {

    /* renamed from: it.unimi.dsi.fastutil.shorts.Short2CharSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2CharSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet extends ObjectSortedSet<Short2CharMap.Entry>, Short2CharMap.FastEntrySet {
        @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap.FastEntrySet
        ObjectBidirectionalIterator<Short2CharMap.Entry> fastIterator();

        ObjectBidirectionalIterator<Short2CharMap.Entry> fastIterator(Short2CharMap.Entry entry);
    }

    Short2CharSortedMap subMap(short s, short s2);

    Short2CharSortedMap headMap(short s);

    Short2CharSortedMap tailMap(short s);

    short firstShortKey();

    short lastShortKey();

    ObjectSortedSet<Short2CharMap.Entry> short2CharEntrySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
    ShortSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
    CharCollection values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Short> comparator();

    @Deprecated
    default Short2CharSortedMap subMap(Short from, Short to) {
        return subMap(from.shortValue(), to.shortValue());
    }

    @Deprecated
    default Short2CharSortedMap headMap(Short to) {
        return headMap(to.shortValue());
    }

    @Deprecated
    default Short2CharSortedMap tailMap(Short from) {
        return tailMap(from.shortValue());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Short firstKey() {
        return Short.valueOf(firstShortKey());
    }

    @Override // java.util.SortedMap
    @Deprecated
    default Short lastKey() {
        return Short.valueOf(lastShortKey());
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2CharMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Short, Character>> entrySet() {
        return short2CharEntrySet();
    }
}
