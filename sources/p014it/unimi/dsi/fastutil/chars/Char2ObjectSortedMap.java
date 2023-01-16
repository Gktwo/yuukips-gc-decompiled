package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import p014it.unimi.dsi.fastutil.objects.ObjectBidirectionalIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectSortedSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectSortedMap.class */
public interface Char2ObjectSortedMap<V> extends Char2ObjectMap<V>, SortedMap<Character, V> {

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap$FastSortedEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectSortedMap$FastSortedEntrySet.class */
    public interface FastSortedEntrySet<V> extends ObjectSortedSet<Char2ObjectMap.Entry<V>>, Char2ObjectMap.FastEntrySet<V> {
        @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap.FastEntrySet
        ObjectBidirectionalIterator<Char2ObjectMap.Entry<V>> fastIterator();

        ObjectBidirectionalIterator<Char2ObjectMap.Entry<V>> fastIterator(Char2ObjectMap.Entry<V> entry);
    }

    Char2ObjectSortedMap<V> subMap(char c, char c2);

    Char2ObjectSortedMap<V> headMap(char c);

    Char2ObjectSortedMap<V> tailMap(char c);

    char firstCharKey();

    char lastCharKey();

    ObjectSortedSet<Char2ObjectMap.Entry<V>> char2ObjectEntrySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    CharSortedSet keySet();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    ObjectCollection<V> values();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // java.util.SortedMap
    Comparator<? super Character> comparator();

    @Deprecated
    default Char2ObjectSortedMap<V> subMap(Character from, Character to) {
        return subMap(from.charValue(), to.charValue());
    }

    @Deprecated
    default Char2ObjectSortedMap<V> headMap(Character to) {
        return headMap(to.charValue());
    }

    @Deprecated
    default Char2ObjectSortedMap<V> tailMap(Character from) {
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

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectMap, java.util.Map
    @Deprecated
    default ObjectSortedSet<Map.Entry<Character, V>> entrySet() {
        return char2ObjectEntrySet();
    }
}
